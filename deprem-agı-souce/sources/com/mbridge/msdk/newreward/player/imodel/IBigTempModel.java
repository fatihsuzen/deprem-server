package com.mbridge.msdk.newreward.player.imodel;

import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.out.MBridgeIds;

public interface IBigTempModel extends IModel {
    void eventOnlyImpression(RedirectModel redirectModel);

    @ReportAnnotation.MethodInfo(key = "2000130", reportType = "1")
    boolean onAdShow(MBridgeIds mBridgeIds);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "2000131", reportType = "1")
    boolean onShowFail(MBridgeIds mBridgeIds, String str, int i5);
}
