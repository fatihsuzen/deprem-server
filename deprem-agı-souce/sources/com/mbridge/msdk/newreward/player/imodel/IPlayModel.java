package com.mbridge.msdk.newreward.player.imodel;

import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public interface IPlayModel extends IModel {
    void checkOMSdkProgress(int i5, int i6);

    void eventAdUrlList(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(className = "IPlayModel", key = "", methodName = "eventAddReward", reportType = "2")
    boolean eventAddReward(RedirectModel redirectModel);

    void eventAdvImpList(RedirectModel redirectModel);

    void eventImpression(RedirectModel redirectModel);

    void eventNoticeUrl(RedirectModel redirectModel, int i5);

    void eventOnlyImpression(RedirectModel redirectModel);

    void eventPvUrls(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(key = "2000142", reportType = "1")
    boolean eventTrackingForClick(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(key = "2000143", reportType = "1")
    boolean eventTrackingForClose(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(key = "2000141", reportType = "1")
    boolean eventTrackingForImpression(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(key = "m_mute_click", methodParameter = "true", reportType = "1")
    void eventTrackingForMute(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(className = "IPlayModel", key = "", methodName = "eventTrackingForPause", reportType = "2")
    void eventTrackingForPause(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(key = "2000021", reportType = "1")
    void eventTrackingForPlayError(RedirectModel redirectModel, String str);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000140", reportType = "1")
    void eventTrackingForPlayPercentage(RedirectModel redirectModel, int i5);

    @ReportAnnotation.MethodInfo(className = "IPlayModel", key = "", methodName = "eventTrackingForResume", reportType = "2")
    void eventTrackingForResume(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(key = "m_mute_click", methodParameter = "false", reportType = "1")
    void eventTrackingForUnMute(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(key = "2000054", reportType = "1")
    void historyShowState();

    @ReportAnnotation.MethodInfo(className = "IPlayModel", methodName = "report", reportType = "3")
    void modelReport(String str);

    @ReportAnnotation.MethodInfo(className = "IPlayModel", isParameter = true, methodName = "report", reportType = "3")
    void modelReport(String str, e eVar);

    void onAdClick(MBridgeIds mBridgeIds);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000152", reportType = "1")
    boolean onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo, int i5);

    @ReportAnnotation.MethodInfo(className = "IPlayModel", key = "", methodName = "onAdCloseWithIVReward", reportType = "2")
    void onAdCloseWithIVReward(MBridgeIds mBridgeIds, boolean z4, int i5);

    @ReportAnnotation.MethodInfo(key = "2000130", reportType = "1")
    boolean onAdShow(MBridgeIds mBridgeIds);

    void onBufferingEnd();

    void onBufferingStart(String str);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000131", reportType = "1")
    boolean onShowFail(MBridgeIds mBridgeIds, String str, int i5);

    @ReportAnnotation.MethodInfo(className = "IPlayModel", key = "", methodName = "onVideoComplete", reportType = "2")
    void onVideoComplete(MBridgeIds mBridgeIds);

    void skipped();
}
