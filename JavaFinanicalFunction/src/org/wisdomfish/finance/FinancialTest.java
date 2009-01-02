/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.wisdomfish.finance;

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
        System.out.println("Invest.EFFECT() = " + Invest.EFFECT(5.25, 4));
        System.out.println("Invest.EFFECT() = " + Invest.EFFECT(2, -2));
        System.out.println("Invest.NOMINAL() = " + Invest.NOMINAL(5.3343, 4));
        System.out.println("Invest.NOMINAL() = " + Invest.NOMINAL(0, 4));
        System.out.println("Invest.FVS() = " + Invest.FVS(1000, 4, 10));
        System.out.println("Invest.PVS() = " + Invest.PVS(1, 5, 10)); // 精確度不夠
        System.out.println("Invest.FV(2301.40) = " + Invest.FV(6/12, 12, -100, -1000, 1)); // 精確度不夠

    }

}
