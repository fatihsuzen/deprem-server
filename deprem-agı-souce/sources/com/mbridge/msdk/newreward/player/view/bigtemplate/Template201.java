package com.mbridge.msdk.newreward.player.view.bigtemplate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.presenter.BigTemplatePresenter;

public class Template201 extends RelativeLayout implements View.OnClickListener, IBaseView {
    protected BigTemplatePresenter bigTemplatePresenter;

    public Template201(@NonNull Context context) {
        super(context);
        BigTemplatePresenter bigTemplatePresenter2 = new BigTemplatePresenter(this);
        this.bigTemplatePresenter = bigTemplatePresenter2;
        bigTemplatePresenter2.getView();
    }

    public void addViewToCurrentViewGroup(View view) {
        addView(view);
    }

    public boolean initViews(boolean z4) {
        return false;
    }

    public void onActivityLifeCycleCallback(String str) {
    }

    public void onClick(View view) {
    }

    public void removeTempleFromSuperView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public void show(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.addView(this);
        }
    }

    public Template201(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
