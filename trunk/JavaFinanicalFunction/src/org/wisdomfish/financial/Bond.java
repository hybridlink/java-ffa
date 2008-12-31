package org.wisdomfish.financial;

import java.util.Date;

/**
 * <ul>債券及其他金融函數可分為:
 *  <li>計算本金、利息的函數</li>
 *  <li>利息支付時間有關的函數</li>
 *  <li>利率收益率有關的函數</li>
 *  <li>修正期限有關的函數</li>
 *  <li>有價證券有關的函數</li>
 *  <li>證券價格表示有關的函數</li>
 * </ul>
 * 
 * @author  ChaoYi ,Kuo
 * @version 0.1
 * @since http://sites.google.com/site/wisdomfishaccounting/java-accounting-api
 * 
 */
public final class Bond {

    private Bond() {
    }

    /**
     * 傳回定期給付利息債券所累積的利息。
     * @param   issue 為債券發行的日期。
     * @param   first_interest 為債券首次給付利息的日期。
     * @param   settlement 係指債券的結算日。債券結算日是債券交易給買方後的次日。
     * @param   rate 係指債券的年利率。
     * @param   par 為債券的面額。如果省略了 par，ACCRINT 將使用 1000 元做為面額。
     * @param   frequency 係指為每年給付利息的次數。<br />
     *          若為每年給付一次，frequency = 1；若為每半年給付一次，frequency = 2；若為每季給付一次，frequency = 4。
     * @param   basis 係指所採用的日計利基的類型。
     * @return  傳回定期給付利息債券所累積的利息。
     */
    public static double ACCRINT(
            Date issue, Date first_interest, Date settlement,
            double rate, double par, int frequency, int basis) {

        double interest = 0;

        if (rate <= interest) {
            return -1;
        }
        if (par <= interest) {
            return -1;
        }
        if (frequency != 1 || frequency != 2 || frequency != 4) {
            return -1;
        }
        if (basis < 0 || basis > 4) {
            return -1;
        }
        if (issue.compareTo(settlement) >= 0) {
            return -1;
        }

        // not final.
        rate = rate / 100;
        interest = par * (rate / frequency);

        return interest;
    }

//    public static void main(String[] args) {
//        double a = Bond.ACCRINT(new Date("2008-1-1"), null, null, 9.8, par, frequency, basis);
}