package com.mbridge.msdk.newreward.player.iview;

import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;

public interface IBaseView {
    void addViewToCurrentViewGroup(View view);

    boolean initViews(boolean z4);

    void onActivityLifeCycleCallback(String str);

    void removeTempleFromSuperView(ViewGroup viewGroup);

    @ReportAnnotation.MethodInfo(className = "IBaseView.show", reportType = "2")
    void show(ViewGroup viewGroup);
}
