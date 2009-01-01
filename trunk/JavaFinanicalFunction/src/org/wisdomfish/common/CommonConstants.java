package org.wisdomfish.common;

/**
 * 定義 JFFA 共用常數欄位.
 *
 * @version 0.1-dev
 * @author  ChaoYi, Kuo (Taiwan: 郭朝益)
 */
public interface CommonConstants {

    /**
     * 給付時間點為每期的開始支付
     */
    public static final int AT_BEGINNING_OF_PERIOD = 0;
    /**
     * 給付時間點為每期的期末支付
     */
    public static final int AT_END_OF_PERIOD = 1;
    /**
     * 引數值非該函數要求的合法範圍值內, 代碼：-999.0
     */
    public static final double ERROR_ARGS = -999.0;
    /**
     * JFFA中有關引數名稱帶"rate"者, 全假性該數值為未加上"%"字元符之百分比數,
     * 故在進行方法調用時, JFFA 自動進行 *0.01 的動作後運算.
     */
    public static final double UN_RATE = 0.01;
}
