package org.wisdomfish.jffa.common;

import java.math.BigDecimal;

/**
 * 定義 JFFA 共用常數欄位.
 *
 * @version 0.1-dev, 2009-01
 * @author  ChaoYi, Kuo (Taiwan: 郭朝益)
 */
public interface CommonConstants {

    /**
     * 當給予參數值非該函數API要求的合法範圍值時, 回傳錯誤代碼: <b>-999.999</b>
     */
    public static final BigDecimal ERROR_ARGS = new BigDecimal(-999.999);
    /**
     * JFFA中有關參數數名稱帶"rate"者, 全假定該數值為未加上"%"字元符之百分比值數,
     * 故在進行JFFA方法調用時, JFFA將於內部運算時封裝乘除本常數的轉換計算動作.
     */
    public static final BigDecimal UN_RATE = new BigDecimal(0.01);

    /**
     * String type number of JFFA Version.
     */
    public static final String VERSION = "0.2-Dev";
}
