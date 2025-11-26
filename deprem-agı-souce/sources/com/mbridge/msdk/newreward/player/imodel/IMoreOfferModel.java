package com.mbridge.msdk.newreward.player.imodel;

import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;

public interface IMoreOfferModel extends IModel {
    @ReportAnnotation.MethodInfo(isParameter = true, key = "m_mof_initiate", reportType = "1")
    void onMoreOfferReq(String str);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "m_mof_req_result", reportType = "1")
    void onMoreOfferRes(String str, String str2);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "m_mof_req_result", reportType = "1")
    void onMoreOfferRes(String str, String str2, String str3);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "m_mof_scenes", reportType = "1")
    void onMoreOfferShow(String str);
}
