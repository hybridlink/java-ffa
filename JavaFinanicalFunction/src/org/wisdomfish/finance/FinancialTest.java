package org.wisdomfish.finance;

import org.wisdomfish.accounting.AnalysisOfSTRA;

/**
 * @author  ChaoYi ,Kuo (Taiwan: 郭朝益)
 * @version 0.1-dev, 01-2009
 */
class FinancialTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("AnalysisOfSTRA.currentRatio() = " + AnalysisOfSTRA.currentRatio(20000, 500000));

        System.out.println("Invest.EFFECT() = " + Invest.effect(5.25, 4));
        System.out.println("Invest.EFFECT() = " + Invest.effect(2, -2));
        System.out.println("Invest.NOMINAL() = " + Invest.nominal(5.3343, 4));
        System.out.println("Invest.NOMINAL() = " + Invest.nominal(0, 4));
        System.out.println("Invest.FVS(1.480) = " + Invest.fvs(1, 4, 10));
        System.out.println("Invest.FVS(1480) = " + Invest.fvs(1000, 4, 10));
        System.out.println("Invest.PVS(0.614) = " + Invest.pvs(1, 5, 10));
        System.out.println("Invest.PVS(6209) = " + Invest.pvs(10000, 10, 5));
        
        // Checking
        System.out.println("Invest.FV(2301.40) = " + Invest.fv(6 / 12, 12, -100, -1000, 1)); // 精確度不夠

        System.out.println("Depreciation.SLN(2250.0) = " + Depreciation.sln(30000, 7500, 10));
        System.out.println("Depreciation.SYD(409.9) = " + Depreciation.syd(30000, 7500, 10, 10));

        System.out.println("pduration = " + Invest.pduration(10, 10, 100));
    }
}
