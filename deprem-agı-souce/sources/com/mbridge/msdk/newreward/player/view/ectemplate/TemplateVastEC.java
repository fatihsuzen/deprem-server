package com.mbridge.msdk.newreward.player.view.ectemplate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.presenter.ECVastPresenter;

public class TemplateVastEC extends FrameLayout implements IBaseView {
    private final String TAG = "TemplateVastEC";
    private final View.OnClickListener buttonClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            ECVastPresenter eCVastPresenter = TemplateVastEC.this.mVastPresenter;
            if (eCVastPresenter != null) {
                eCVastPresenter.click(view);
            }
        }
    };
    ImageView closeImageView;
    ImageView confirmImageView;
    ECVastPresenter mVastPresenter;

    public TemplateVastEC(@NonNull Context context) {
        super(context);
        initPresenter();
    }

    public void addViewToCurrentViewGroup(View view) {
    }

    public void initPresenter() {
        ECVastPresenter eCVastPresenter = new ECVastPresenter(this);
        this.mVastPresenter = eCVastPresenter;
        eCVastPresenter.getView();
    }

    public boolean initViews(boolean z4) {
        setBackgroundColor(-1442840576);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        View inflate = LayoutInflater.from(getContext()).inflate(x.a(getContext(), "mbridge_reward_endcard_vast", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        if (inflate != null) {
            this.closeImageView = (ImageView) inflate.findViewById(x.a(getContext(), "mbridge_iv_vastclose", "id"));
            this.confirmImageView = (ImageView) inflate.findViewById(x.a(getContext(), "mbridge_iv_vastok", "id"));
            ImageView imageView = this.closeImageView;
            if (imageView != null) {
                imageView.setOnClickListener(this.buttonClickListener);
            }
            ImageView imageView2 = this.confirmImageView;
            if (imageView2 != null) {
                imageView2.setOnClickListener(this.buttonClickListener);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        addView(inflate, layoutParams);
        return false;
    }

    public void onActivityLifeCycleCallback(String str) {
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

    public TemplateVastEC(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initPresenter();
    }

    public TemplateVastEC(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        initPresenter();
    }

    @RequiresApi(api = 21)
    public TemplateVastEC(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        initPresenter();
    }
}
