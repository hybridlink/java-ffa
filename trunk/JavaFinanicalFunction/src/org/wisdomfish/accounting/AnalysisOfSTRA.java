package org.wisdomfish.accounting;

/**
 * <p>短期償債能力分析(Analysis of Short-Term Repayment Ability)，
 * 是針對被分析公司的現金與短期內可以變現的各種資產，以及短期內到期而必須償還的各種負債，進行評估。
 * 企業可能獲利能力不錯，但卻可能因不能償還到期的負債而導致週轉不靈，以致無法繼續經營。
 * 因此，短期償債能力分析，實是企業體質健全與否的重要指標。</p>
 *
 * <p>短期償債能力是企業償還流動負債的能力，短期償債能力的強弱取決於流動資產的流動性，
 * 即資產轉換成現金的速度。企業流動資產的流動性強，相應的短期償債能力也強。
 * 因此，通常使用營運資本、流動比率、速動比率和現金比率衡量短期償債能力。</p>
 *
 * @author  ChaoYi, Kuo (Taiwan:郭朝益)
 * @version 0.1
 */
public class AnalysisOfSTRA {

    private AnalysisOfSTRA() {
    }

    /**
     * 流動比率(Current Ratio)流動比率越高，表示短期償債能力越高；流動比率越低，則短期償債能力越低。
     * 流動資產中的某些項目在變現時可能有貶值之虞，因此推論出流動比率應超過200%方屬理想，
     * 但也不可一概而論。一般來說只有100%左右；而如低於100%以下，則表示短期償債能力過低，對債權人的權益，已缺乏保障。
     * 
     * @param   currentAssets       流動資產
     * @param   currentLiability    流動負債
     * @return  回傳未包含"%"字元符的百分比數值
     */
    public static double currentRatio(double currentAssets, double currentLiability) {
        double currentR = currentAssets / currentLiability * 100;
        return currentR;
    }
}
