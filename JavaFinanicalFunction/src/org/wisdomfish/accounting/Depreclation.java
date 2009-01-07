/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wisdomfish.accounting;

import org.wisdomfish.finance.Depreciation;

/**
 * 折舊計算用函數, 包含來自 org.wisdomfish.finance.Depreciation　的方法Soft-Links.
 * @version 0.1-dev, 01-2009
 * @author ChaoYi, Kuo (Taiwan: 郭朝益)
 */
public final class Depreclation {

    private Depreclation() {
    }

    /**
     * 傳回固定資產使用「直線折舊法(Straight-line depreciation, SLD)」計算出來的每期折舊金額。
     *
     * @param   cost    係指固定資產的原始成本。
     * @param   salvage 係指折舊最後的數值 (有時稱為固定資產之估計殘值)。
     * @param   life    係指固定資產折舊的期間 (有時稱為固定資產的生命週期)
     * @return  回傳每期折舊金額。
     */
    public static double sln(double cost, double salvage, int life) {
        return Depreciation.sln(cost, salvage, life);
    }
}
