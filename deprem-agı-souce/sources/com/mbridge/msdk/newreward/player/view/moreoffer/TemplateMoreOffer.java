package com.mbridge.msdk.newreward.player.view.moreoffer;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.player.iview.IMoreOfferTemplateView;
import com.mbridge.msdk.newreward.player.presenter.MoreOfferPresenter;
import com.mbridge.msdk.video.dynview.widget.ObservableScrollView;

public class TemplateMoreOffer extends BaseMoreOfferTemplate implements View.OnClickListener, IMoreOfferTemplateView {
    LinearLayout linearLayout;
    Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler();
    int moreOfferType;
    /* access modifiers changed from: private */
    public Runnable runnable = new Runnable() {
        public void run() {
            TemplateMoreOffer templateMoreOffer = TemplateMoreOffer.this;
            MoreOfferPresenter moreOfferPresenter = templateMoreOffer.moreOfferPresenter;
            if (moreOfferPresenter != null) {
                moreOfferPresenter.onTouch(templateMoreOffer.mObservableScrollView);
            }
        }
    };

    public TemplateMoreOffer(Context context, b bVar, int i5) {
        super(context);
        this.mContext = context;
        setVisibility(8);
        this.moreOfferType = i5;
        MoreOfferPresenter moreOfferPresenter = new MoreOfferPresenter(this);
        this.moreOfferPresenter = moreOfferPresenter;
        moreOfferPresenter.setIReqCallBack(bVar);
        this.moreOfferPresenter.getView();
        this.moreOfferPresenter.syncLoad(i5);
    }

    public void addClickEvent() {
        TextView textView = this.likeTv;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    public void addMoreOfferLikeText(final String str, final int i5) {
        if (this.likeTv != null) {
            post(new Runnable() {
                public void run() {
                    TextView textView = TemplateMoreOffer.this.likeTv;
                    if (textView != null) {
                        textView.setVisibility(0);
                        TemplateMoreOffer.this.likeTv.setTextColor(Color.parseColor("#FF000000"));
                        TemplateMoreOffer.this.likeTv.setTextSize(10.0f);
                        TemplateMoreOffer.this.likeTv.setEms(1);
                        if (i5 != 0) {
                            TemplateMoreOffer.this.likeTv.getLayoutParams().width = i5;
                        }
                        TemplateMoreOffer.this.likeTv.setText(str);
                    }
                }
            });
        }
    }

    public void addViewToCurrentViewGroup(View view) {
        if (view != null) {
            try {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                }
                layoutParams.addRule(12, -1);
                view.setLayoutParams(layoutParams);
                view.setVisibility(0);
                addView(view);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                    return;
                }
                return;
            }
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, ak.a(c.m().c(), 100.0f));
        layoutParams2.gravity = 80;
        setLayoutParams(layoutParams2);
    }

    public void addViewToObservableScrollView(final View view) {
        if (view instanceof LinearLayout) {
            this.linearLayout = (LinearLayout) view;
        }
        if (this.mObservableScrollView != null) {
            post(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
                    r0 = r2.this$0;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r2 = this;
                        android.view.View r0 = r2
                        if (r0 == 0) goto L_0x000f
                        com.mbridge.msdk.newreward.player.view.moreoffer.TemplateMoreOffer r0 = com.mbridge.msdk.newreward.player.view.moreoffer.TemplateMoreOffer.this
                        com.mbridge.msdk.video.dynview.widget.ObservableScrollView r1 = r0.mObservableScrollView
                        if (r1 == 0) goto L_0x000f
                        android.widget.LinearLayout r0 = r0.linearLayout
                        r1.addView(r0)
                    L_0x000f:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.moreoffer.TemplateMoreOffer.AnonymousClass2.run():void");
                }
            });
            this.mObservableScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                public void onScrollChanged() {
                    if (TemplateMoreOffer.this.mHandler != null) {
                        TemplateMoreOffer.this.mHandler.removeCallbacks(TemplateMoreOffer.this.runnable);
                        TemplateMoreOffer.this.mHandler.postDelayed(TemplateMoreOffer.this.runnable, 100);
                    }
                }
            });
        }
    }

    public void onActivityLifeCycleCallback(String str) {
    }

    public void onClick(View view) {
        MoreOfferPresenter moreOfferPresenter = this.moreOfferPresenter;
        if (moreOfferPresenter != null) {
            moreOfferPresenter.click(view);
        }
    }

    public void removeTempleFromSuperView(ViewGroup viewGroup) {
    }

    public void setObservableScrollViewVisible() {
        ObservableScrollView observableScrollView = this.mObservableScrollView;
        if (observableScrollView != null) {
            if (observableScrollView.getVisibility() == 0) {
                this.mObservableScrollView.setVisibility(8);
            } else {
                this.mObservableScrollView.setVisibility(0);
            }
        }
    }

    public void show(ViewGroup viewGroup) {
        if (viewGroup.getParent() != null) {
            ((ViewGroup) viewGroup.getParent()).addView(this);
        }
    }
}
