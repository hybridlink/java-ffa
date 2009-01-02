package org.wisdomfish.common;

/**
 * 定義 JFFA 共用常數欄位.
 *
 * @version 0.1-dev, 2009-01
 * @author  ChaoYi, Kuo (Taiwan: 郭朝益)
 */
public interface CommonConstants {

    /**
     * 給付時間點為每期的'開始".
     */
    public static final int AT_BEGINNING_OF_PERIOD = 0;
    /**
     * 給付時間點為每期的"期末".
     */
    public static final int AT_END_OF_PERIOD = 1;
    /**
     * 當給予參數值非該函數API要求的合法範圍值時, 回傳錯誤代碼: <b>-999.0</b>
     */
    public static final double ERROR_ARGS = -999.0;
    /**
     * JFFA中有關引數名稱帶"rate"者, 全假定該數值為未加上"%"字元符之百分比值數,
     * 故在進行JFFA方法調用時, JFFA將於內部運算時封裝乘除本常數的轉換計算動作.
     */
    public static final double UN_RATE = 0.01;
}
