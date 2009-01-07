package org.wisdomfish.finance;

import org.wisdomfish.common.CommonConstants;

/**
 * 提供固定資產折舊計算函數相關的函數類別.
 * 折舊計算函數主要包括 AMORDEGRC、AMORLINC、DB、DDB、SLN、SYD、VDB。
 * 
 * @author  ChaoYi ,Kuo (Taiwan: 郭朝益)
 * @version 0.1-dev, 01-2009
 *
 */
public final class Depreciation implements CommonConstants {

    private Depreciation() {
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
        return (cost - salvage) / life;
    }

    /**
     * 傳回某項固定資產在某期間按年數合計法 (sum-of-years) 計算的每期折舊金額。
     * 
     * @param cost      係指固定資產的原始成本。
     * @param salvage   係指折舊最後的數值 (有時稱為固定資產之估計殘值)。
     * @param life      係指固定資產折舊的期間 (有時稱為固定資產的生命週期)。
     * @param period    是您所要計算的期間，<= life。
     * @return          回傳每期折舊金額。
     */
    public static double syd(double cost, double salvage, int life, int period) {
        if (period > life) {
            return ERROR_ARGS;
        } else {
            return ((cost - salvage) * (life - period + 1) * 2) / (life * (life + 1));
        }

    }
}
