/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.wisdomfish.common;

import java.util.Date;

/**
 * 定義需要使用到日期計算值的函數必需要實作的介面.
 *
 * @version 0.1
 * @author ChaoYi, Kuo (Taiwan:郭朝益)
 */
public interface BasisPart {

    /**
     * 回傳二個日期點的天數差數值.
     * @param initialDate   初始日
     * @param finalDate     結束日
     * @return  回傳二個日期點的天數差數值.
     */
    int daysBetween(Date initialDate, Date finalDate);

}
