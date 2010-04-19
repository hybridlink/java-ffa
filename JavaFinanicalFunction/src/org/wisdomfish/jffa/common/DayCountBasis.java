package org.wisdomfish.jffa.common;

import java.util.GregorianCalendar;

/**
 * 與日期計算有關的函數類別必須實作本介面.
 *
 * @version 0.2-dev, 2010-04
 * @author  ChaoYi, Kuo (Taiwan: 郭朝益)
 */
public interface DayCountBasis {

    /**
     * 給付時間點為每期的'開始".
     */
    public static final int AT_BEGINNING_OF_PERIOD = 1;
    /**
     * 給付時間點為每期的"期末".
     */
    public static final int AT_END_OF_PERIOD = 0;

    /**
     * 回傳二個日期點間的天數差值.
     *
     * @param initialDate   初始日
     * @param finalDate     結束日
     * @return  回傳二個日期點間的天數差值.
     */
    int getDaysBetween(GregorianCalendar initialDate, GregorianCalendar finalDate);
}
