package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.iview.ICusTemplateView;
import com.mbridge.msdk.newreward.player.presenter.PlayPresenter202;
import com.mbridge.msdk.playercommon.PlayerView;

public class Template202 extends BaseTemplate implements ICusTemplateView {
    public Template202(@NonNull Context context) {
        super(context);
        PlayPresenter202 playPresenter202 = new PlayPresenter202(this);
        this.presenter = playPresenter202;
        playPresenter202.getView();
    }

    public void addCTAViewToLayout(View view, int i5) {
        FrameLayout frameLayout = this.mCtaLayout;
        if (frameLayout != null) {
            if (i5 == 8) {
                frameLayout.setVisibility(i5);
                return;
            }
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mCtaLayout.addView(view);
                this.mCtaLayout.setVisibility(i5);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public void addClickEvent() {
        super.addClickEvent();
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.setOnClickListener(this);
        }
    }

    public int getCTAViewState() {
        FrameLayout frameLayout = this.mCtaLayout;
        if (frameLayout != null) {
            return frameLayout.getVisibility();
        }
        return -1;
    }

    public void setBackGroundImage(final Bitmap bitmap) {
        post(new Runnable() {
            public void run() {
                ImageView imageView = Template202.this.bgImageView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    Template202.this.bgImageView.setImageBitmap(bitmap);
                }
            }
        });
    }

    public void show(ViewGroup viewGroup) {
        super.show(viewGroup);
        this.presenter.setBackGrandImage();
    }

    public Template202(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
