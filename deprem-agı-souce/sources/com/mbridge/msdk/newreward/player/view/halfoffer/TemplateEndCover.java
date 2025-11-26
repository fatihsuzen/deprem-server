package com.mbridge.msdk.newreward.player.view.halfoffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.player.iview.IECoverTemplateView;
import com.mbridge.msdk.newreward.player.presenter.PlayPresenterEndCover;
import com.mbridge.msdk.newreward.player.view.BaseTemplate;

public class TemplateEndCover extends BaseTemplate implements IECoverTemplateView {
    private ImageView closeImageView;
    private TextView ctaButton;
    private TextView descTextView;
    private ImageView iconImageView;
    private View rootView;
    private TextView titleTextView;

    public TemplateEndCover(@NonNull Context context) {
        super(context);
        PlayPresenterEndCover playPresenterEndCover = new PlayPresenterEndCover(this);
        this.presenter = playPresenterEndCover;
        playPresenterEndCover.getView();
    }

    public void addClickEvent() {
        ImageView imageView = this.closeImageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        TextView textView = this.ctaButton;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    public boolean initViews(boolean z4) {
        try {
            int a5 = x.a(getContext(), "mbridge_reward_videoend_cover", TtmlNode.TAG_LAYOUT);
            if (a5 >= 0) {
                View inflate = LayoutInflater.from(getContext()).inflate(a5, (ViewGroup) null);
                this.rootView = inflate;
                if (inflate != null) {
                    this.iconImageView = (ImageView) inflate.findViewById(this.presenter.filterFindViewId(false, "mbridge_vec_iv_icon"));
                    this.closeImageView = (ImageView) this.rootView.findViewById(this.presenter.filterFindViewId(false, "mbridge_vec_iv_close"));
                    this.titleTextView = (TextView) this.rootView.findViewById(this.presenter.filterFindViewId(false, "mbridge_vec_tv_title"));
                    this.descTextView = (TextView) this.rootView.findViewById(this.presenter.filterFindViewId(false, "mbridge_vec_tv_desc"));
                    this.ctaButton = (TextView) this.rootView.findViewById(this.presenter.filterFindViewId(false, "mbridge_vec_btn"));
                    addView(this.rootView, -1, -1);
                }
            }
            addClickEvent();
            return true;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return false;
        }
    }

    public void setCtaBtn(String str) {
        TextView textView = this.ctaButton;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setDesc(String str) {
        TextView textView = this.descTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setIconImageView(Bitmap bitmap) {
        ImageView imageView = this.iconImageView;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.titleTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
