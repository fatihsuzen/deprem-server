package com.mbridge.msdk.newreward.player.iview;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;

public interface IPlayTempleView extends IBaseView {
    @ReportAnnotation.MethodInfo(className = "IPlayTempleView", key = "", methodName = "alertDismiss", reportType = "2")
    void alertDismiss();

    @ReportAnnotation.MethodInfo(className = "IPlayTempleView", key = "", methodName = "alertShow", reportType = "2")
    void alertShow();

    View getBaitClickView();

    View getCountDownView();

    boolean getMuteState();

    ImageView getPrivacyButton();

    MBridgeSegmentsProgressBar getSegmentsProgressBar();

    @ReportAnnotation.MethodInfo(className = "IPlayTempleView", methodName = "pause", reportType = "2")
    void pause();

    @ReportAnnotation.MethodInfo(className = "IPlayTempleView", methodName = "play", reportType = "2")
    void play(String str, int i5);

    void release();

    @ReportAnnotation.MethodInfo(className = "IPlayTempleView", methodName = "resume", reportType = "2")
    void resume();

    void setAdCloseVisibility(boolean z4);

    void setAlertViewType(String str, int i5, int i6);

    void setBackGroundImage(Bitmap bitmap);

    void setCountDown(String str, int i5, int i6, ViewGroup.LayoutParams layoutParams);

    void setMuteState(boolean z4);

    void setPlayerSize(int i5, int i6, int i7);

    void setSegmentsProgressBar(int i5);

    void setTemplateWidthAndHeight(int i5);

    @ReportAnnotation.MethodInfo(className = "IPlayTempleView", methodName = "viewReport", reportType = "3")
    void viewReport(Object obj);
}
