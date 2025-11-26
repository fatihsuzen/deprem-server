package com.mbridge.msdk.newreward.player.imodel;

import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public interface IECModel extends IModel {
    @ReportAnnotation.MethodInfo(className = "IECModel", key = "", methodName = "eventAddReward", reportType = "2")
    boolean eventAddReward(RedirectModel redirectModel);

    void eventImpression(RedirectModel redirectModel);

    void eventOnlyImpression(RedirectModel redirectModel);

    void eventPvUrls(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(key = "2000142", reportType = "1")
    boolean eventTrackingForClick(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000144", reportType = "1")
    void eventTrackingForEndCardShow(RedirectModel redirectModel, int i5);

    @ReportAnnotation.MethodInfo(key = "2000141", reportType = "1")
    boolean eventTrackingForImpression(RedirectModel redirectModel);

    int getRenderStatus();

    void onAdClick(MBridgeIds mBridgeIds);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000152", reportType = "1")
    boolean onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo, int i5);

    void onAdCloseWithIVReward(MBridgeIds mBridgeIds, boolean z4, int i5);

    @ReportAnnotation.MethodInfo(key = "2000130", reportType = "1")
    boolean onAdShow(MBridgeIds mBridgeIds);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000134", reportType = "1")
    void onCloseViewClick(int i5);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000147", reportType = "1")
    void onEndCardShow(MBridgeIds mBridgeIds, int i5);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000131", reportType = "1")
    boolean onShowFail(MBridgeIds mBridgeIds, String str, int i5);

    void setRenderStatus(int i5);
}
