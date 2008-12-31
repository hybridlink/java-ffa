package org.wisdomfish.financial;

/**
 * 財務函數可以進行一般的財務計算，如確定貸款的支付額、投資的未來值或淨現值，以及債券或息票的價值。
 * 這些財務函數大體上可分為四類：投資計算函數、折舊計算函數、償還率計算函數、債券及其他金融函數。
 * 它們為財務分析提供了極大的便利。使用這些函數不必理解高級財務知識，只要填寫變數值就可以了。
 */


import java.util.Date;

/**
 * 債券及其他金融函數又可分為計算本金、利息的函數，與利息支付時間有關的函數、
 * 與利率收益率有關的函數、與修正期限有關的函數、
 * 與有價證券有關的函數以及與證券價格表示有關的函數。
 * 
 * @author ChaoYi ,Kuo
 * @version 0.1
 * @since http://office.microsoft.com/zh-tw/excel/HP052089791028.aspx
 * 
 */
public final class Bond {

    private Bond() {
    }

    /**
     * 傳回定期給付利息債券所累積的利息。
     * @param issue 為債券發行的日期。
     * @param first_interest 為債券首次給付利息的日期。
     * @param settlement 係指債券的結算日。債券結算日是債券交易給買方後的次日。
     * @param rate 係指債券的年利率。
     * @param par 為債券的面額。如果省略了 par，ACCRINT 將使用 1000 元做為面額。
     * @param frequency 係指為每年給付利息的次數。<br />
     * 若為每年給付一次，frequency = 1；若為每半年給付一次，frequency = 2；若為每季給付一次，frequency = 4。
     * @param basis 係指所採用的日計利基的類型。
     * @return 傳回定期給付利息債券所累積的利息。
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