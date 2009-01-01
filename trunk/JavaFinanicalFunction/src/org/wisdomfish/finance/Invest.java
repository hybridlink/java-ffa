package org.wisdomfish.finance;

/**
 * 投資計算函數可分為與未來值FV有關，與付款PMT有關，與現值PV有關，
 * 與複利計算有關及與期間數有關幾類函數：
 * <ul>
 *  <li>與未來值fv有關的函數 - FV、FVSCHEDULE</li>
 *  <li>與付款pmt有關的函數 - IPMT、ISPMT、PMT、PPMT</li>
 *  <li>與現值pv有關的函數 - NPV、PV、XNPV</li>
 *  <li>與複利計算有關的函數 - EFFECT、NOMINAL</li>
 *  <li>與期間數有關的函數 - NPER</li>
 * </ul>
 *
 * @version 0.1
 * @author  ChaoYi, Kuo (Taiwan:郭朝益)
 *
 */
public final class Invest {

    /**
     * 給付時間點為每期的開始支付
     */
    public static final int AT_BEGINNING_OF_PERIOD = 0;
    /**
     * 給付時間點為每期的期末支付
     */
    public static final int AT_END_OF_PERIOD = 1;

    public static final double UN_RATE= 0.01;

    private Invest() {
    }

    public static double EFFECT(double nominalRate, int nPerYear) {
        nominalRate = nominalRate * UN_RATE;
        return Math.pow((1 + (nominalRate / nPerYear)), nPerYear) - 1;
    }

    /**
     * <p>Future Value - 根據週期、固定支出以及固定利率，傳回投資的未來值。</p>
     * <p>有關 FV 引數以及年金函數的更詳細資訊，請參閱 PV。</p>
     * <ul>
     *  <li>rate    為各期的利率。</li>
     *  <li>NPER    為年金的總付款期數。</li>
     *  <li>PMT     係指分期付款。不得在年金期限內變更。通常 pmt 包含本金和利息，但不包含其他的費用或稅款。如果忽略 pmt，則您必須包含 pv 引數。</li>
     *  <li>PV      係指現值或一系列未來付款的目前總額。如果您省略 pv，則假設為 0 (零)，並且您必須包含 pmt 引數。</li>
     *  <li>type    為 0 或 1 的數值，用以界定各期金額的給付時點。如果省略 type，則假設其值為 0。</li>
     * </ul>
     *
     * @param rate  為各期的利率。
     * @param NPER  為年金的總付款期數。
     * @param PMT   係指分期付款。
     * @param PV    係指現值或一系列未來付款的目前總額。
     * @param type  為 0 或 1 的數值，用以界定各期金額的給付時點。
     * @return      回傳投資的未來價值。
     */
    public static double FV(double rate, int NPER, double PMT, double PV, int type) {
        return -1;
    }

    public static double FV(double rate, int NPER, double PMT, int type) {
        double PV = 0;
        return -1;
    }

    public static double FV(double rate, int NPER, double PMT, double PV) {
        int type = AT_BEGINNING_OF_PERIOD;
        return -1;
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
    public static double PMT(double rate, int NPER, double PV, double FV, int type) {
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
    public static double PV(double rate, int NPER, double PMT, double FV, int type) {
        return -1;
    }
}
