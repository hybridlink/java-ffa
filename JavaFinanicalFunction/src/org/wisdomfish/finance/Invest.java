package org.wisdomfish.finance;

import java.util.GregorianCalendar;
import org.wisdomfish.common.CommonConstants;
import org.wisdomfish.common.DayCountBasis;

/**
 * 投資計算函數可分為與未來值FV有關，與付款PMT有關，與現值PV有關，
 * 與複利計算有關及與期間數有關幾類函數. 包括：
 * <ul>
 *  <li>與未來值fv有關的函數 - FV、FVS、FVSCHEDULE</li>
 *  <li>與付款pmt有關的函數 - IPMT、ISPMT、PMT、PPMT</li>
 *  <li>與現值pv有關的函數 - NPV、PV、PVS、XNPV</li>
 *  <li>與複利計算有關的函數 - EFFECT、NOMINAL</li>
 *  <li>與期間數有關的函數 - NPER</li>
 * </ul>
 *
 * @version 0.1-dev, 2009-01
 * @author  ChaoYi, Kuo (Taiwan: 郭朝益)
 *
 */
public final class Invest
        implements CommonConstants, DayCountBasis {

    private Invest() {
    }

    /**
     * Effective annual interest rate -
     * 依據給定的 nominal 年利率以及每年以複利計算利息的期間之次數，傳回實際的年利率。.
     * <ul>
     *  <li>如果 nominalRate = 0 或 nPerYear < 1，EFFECT 將傳回錯誤碼值: ERROR_ARGS。</li>
     *  <li>NOMINAL 與 EFFECT 有關</li>
     * </ul>
     * 
     * @param nominalRate   為名義(nominal)利率。
     * @param nPerYear      為每年以複利計算之期數。
     * @return              傳回"實際"的年利率值(未帶"%"符)。
     * @see Invest#NOMINAL(double, int)
     * @see CommonConstants#ERROR_ARGS
     */
    public static double EFFECT(double nominalRate, int nPerYear) {
        if (nominalRate == 0.0 || nPerYear < 1) {
            return ERROR_ARGS;
        } else {
            nominalRate = nominalRate * UN_RATE;
            return (StrictMath.pow((1.0 + (nominalRate / nPerYear)), nPerYear) - 1.0) / UN_RATE;
        }

    }

    /**
     * 年金(Future Value) - 根據週期、固定支出以及固定利率，傳回投資的未來值。.
     * <p>有關 FV 參數以及年金函數的更詳細資訊，請參閱 PV。</p>
     * <ul>
     *  <li>rate    為各期的利率。</li>
     *  <li>NPER    為年金的總付款期數。</li>
     *  <li>PMT     係指分期付款。不得在年金期限內變更。通常 pmt 包含本金和利息，
     *              但不包含其他的費用或稅款。如果忽略 pmt，則您必須包含 pv 引數。</li>
     *  <li>PV      係指現值或一系列未來付款的目前總額。如果您省略 pv，則假設為 0 (零)，
     *              並且您必須包含 pmt 引數。</li>
     *  <li>whenType    為普通年金(0)或即付年金(1)的數值，用以界定各期金額的給付時點。
     *                  如果省略 WhenType，則假設其值為 0。</li>
     * </ul>
     *
     * @param rate      為各期的利率(預設為年利率)。
     * @param NPER      為年金的總付款期數。
     * @param PMT       係指分期付款。
     * @param PV        係指現值或一系列未來付款的目前總額。
     * @param whenType  為期未(0)或期初(1)的數值，用以界定各期金額的給付時點。
     * @return          回傳投資的未來價值。
     */
    public static double FV(double rate, int NPER, double PMT, double PV, int whenType) {
        if (whenType >= 3 || whenType < 0) {
            return ERROR_ARGS;
        }
        rate = rate * UN_RATE;
        double fv = 0.0;
        if (rate == 0.0) {
            //  FV = -1(PV+PMT*NPER)
            fv = -1 * (PV + PMT * NPER);
            return fv;
        } else {
            switch (whenType) {
                // 普通年金終值：F=A{[（1+i）^n-1]/i}
                case AT_END_OF_PERIOD:
                    fv = PMT * ((StrictMath.pow((1.0 + rate), NPER) - 1.0) / rate);
                    break;
                // 即付年金的終值：F=A{[（1+i）^（n+1）-1]/i}
                case AT_BEGINNING_OF_PERIOD:
                    fv = PMT * ((StrictMath.pow((1.0 + rate), (NPER + 1)) - 1.0) / rate);
                    break;
            }
            // Yt=PV*(1-Pmt)^t*(1+r)^t
            // FV = (PMT*(1+rate*type)*(1-(1+ rate)^NPER)/rate)-PV*(1+rate)^NPER
//            fv = PMT * (1.0 + rate * whenType);
//            fv = fv * ((1.0 - (StrictMath.pow((1.0 + rate), NPER))) / rate);
//            fv = fv - (PV * StrictMath.pow((1.0 + rate), NPER));
            return fv;
        }
    }

    private static double FV(double rate, int NPER, double PMT, int whenType) {
        return -1;
    }

    private static double FV(double rate, int NPER, double PMT, double PV) {
        int whenType = AT_END_OF_PERIOD;
        rate = rate * UN_RATE;
        double fv = 0.0;
        if (rate == 0.0) {
            //  FV = -1(PV+PMT*NPER)
            fv = -1 * (PV + PMT * NPER);
            return fv;
        } else {
            // FV = (PMT*(1+rate*type)*(1-(1+ rate)^NPER)/rate)-PV*(1+rate)^NPER
            fv = PMT * (1.0 + rate * whenType);
            fv = fv * ((1.0 - (StrictMath.pow((1.0 + rate), NPER))) / rate);
            fv = fv - (PV * StrictMath.pow((1.0 + rate), NPER));
            return fv;
        }
    }

    /**
     * 複利(Compound interest)終值單筆(Single)
     * 
     * @param presentValue  單一筆數本金現值
     * @param interestRate  年利率/報酬率
     * @param nPeriods      期數
     * @return              回傳單筆本金的未來價值
     */
    public static double FVS(double presentValue, double interestRate, int nPeriods) {
        interestRate = interestRate * UN_RATE;
        return (presentValue * (StrictMath.pow((1.0 + interestRate), nPeriods)));
    }

    /**
     * Nominal interest rate -　在給定有效(實質)利率以及每年以複利計算的期間的情況下，
     * 傳回名義(nominal)年利率。.
     * <ul>
     *  <li>如果 effectRate = 0 或 nPerYear < 1，EFFECT 將傳回錯誤碼值: ERROR_ARGS 。</li>
     *  <li>NOMINAL 與 EFFECT 有關</li>
     * </ul>
     * 
     * @param effectRate    為有效(實質)利率。
     * @param nPerYear      為每年以複利計算之期數。
     * @return              傳回 nominal 年利率。
     * @see Invest#EFFECT(double, int)
     * @see CommonConstants#ERROR_ARGS
     */
    public static double NOMINAL(double effectRate, int nPerYear) {
        if (effectRate == 0.0 || nPerYear < 1) {
            return ERROR_ARGS;
        } else {
            effectRate = effectRate * UN_RATE;
            return ((StrictMath.pow((1.0 + effectRate), (1.0 / nPerYear)) - 1.0) * nPerYear) / UN_RATE;
        }
    }

    /**
     * Periodic payment - 週期性的付款
     * @param rate
     * @param NPER
     * @param PV
     * @param FV
     * @param type
     * @return
     */
    static double PMT(double rate, int NPER, double PV, double FV, int type) {
        return -1;
    }

    /**
     * Present value - 當前現值
     * @param rate
     * @param NPER
     * @param PMT
     * @param FV
     * @param type
     * @return
     */
    static double PV(double rate, int NPER, double PMT, double FV, int type) {
        return -1;
    }

    /**
     * 複利(Compound interest)現值單筆(Single)
     *
     * @param futureValue   單一筆數本金未來值
     * @param interestRate  年利率(報酬率)
     * @param nPeriods      期數
     * @return              回傳單筆本金的現在價值
     */
    public static double PVS(double futureValue, double interestRate, int nPeriods) {
        interestRate = interestRate * UN_RATE;
        return (futureValue / (StrictMath.pow((1.0 + interestRate), nPeriods)));
    }

    public int getDaysBetween(GregorianCalendar initialDate, GregorianCalendar finalDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
