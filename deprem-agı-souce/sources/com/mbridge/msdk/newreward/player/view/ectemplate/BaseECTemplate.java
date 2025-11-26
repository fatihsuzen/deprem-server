package com.mbridge.msdk.newreward.player.view.ectemplate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.player.iview.IECTempleView;
import com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.widget.FeedBackButton;

public abstract class BaseECTemplate extends RelativeLayout implements View.OnClickListener, IECTempleView {
    private final String TAG = "BaseECTemple";
    protected ImageView appIconIv;
    protected ImageView bannerIv;
    /* access modifiers changed from: private */
    public ImageView bannerIvBg;
    protected View closeView;
    protected View ctaView;
    protected TextView descTv;
    ECTemplePresenter ecPresenter;
    protected FeedBackButton feedBackButton;
    protected ImageView flagIV;
    protected TextView flagTV;
    protected LinearLayout levelSlv;
    protected ImageView logoView;
    protected MBridgeBaitClickView mBaitClickView;
    protected boolean mDyXmlSuccess = false;
    protected LinearLayout mLevelHeatCount;
    protected RelativeLayout nativeECLayout;
    protected ImageView noticeIV;
    protected TextView numberTv;
    protected TextView titleTv;
    private RelativeLayout topControllerLayout;

    public BaseECTemplate(@NonNull Context context) {
        super(context);
    }

    private void setViewInitState() {
        View view = this.closeView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void addClickEvent() {
        View view = this.closeView;
        if (view != null) {
            view.setOnClickListener(this);
        }
        RelativeLayout relativeLayout = this.nativeECLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this);
        }
        View view2 = this.ctaView;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        ImageView imageView = this.appIconIv;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.bannerIv;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
    }

    public void addViewToCurrentViewGroup(View view) {
        addView(view);
    }

    public View getBaitClickView() {
        return this.mBaitClickView;
    }

    public View getCloseView() {
        return this.closeView;
    }

    public ImageView getNoticeIV() {
        return this.noticeIV;
    }

    public IECTempleView getParentObject() {
        return this;
    }

    public boolean initViews(boolean z4) {
        boolean z5;
        boolean z6 = z4;
        try {
            this.mDyXmlSuccess = z6;
            this.nativeECLayout = (RelativeLayout) findViewById(this.ecPresenter.filterFindViewId(z6, "mbridge_native_ec_layout"));
            this.bannerIv = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_adbanner"));
            this.appIconIv = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_icon"));
            this.flagIV = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_flag"));
            this.flagTV = (TextView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_flag"));
            this.logoView = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_logo"));
            this.noticeIV = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_link"));
            this.titleTv = (TextView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_apptitle"));
            this.levelSlv = (LinearLayout) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_sv_starlevel"));
            this.mLevelHeatCount = (LinearLayout) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_sv_heat_count_level"));
            this.closeView = findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_close"));
            this.ctaView = findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_cta"));
            this.feedBackButton = (FeedBackButton) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_native_endcard_feed_btn"));
            this.topControllerLayout = (RelativeLayout) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_native_ec_controller"));
            this.bannerIvBg = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_adbanner_bg"));
            this.mBaitClickView = (MBridgeBaitClickView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_animation_click_view"));
            this.descTv = (TextView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_appdesc"));
            addClickEvent();
            if (z6) {
                ImageView imageView = this.bannerIv;
                if (imageView != null && (imageView instanceof RoundImageView)) {
                    ((RoundImageView) imageView).setBorderRadius(10);
                }
                ImageView imageView2 = this.appIconIv;
                if (imageView2 != null && (imageView2 instanceof RoundImageView)) {
                    ((RoundImageView) imageView2).setBorderRadius(10);
                }
                return this.ecPresenter.isNotNULL(this.bannerIv, this.appIconIv, this.titleTv, this.levelSlv, this.closeView, this.ctaView);
            }
            TextView textView = (TextView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_number"));
            this.numberTv = textView;
            z5 = false;
            try {
                return this.ecPresenter.isNotNULL(this.bannerIv, this.appIconIv, this.titleTv, this.descTv, textView, this.levelSlv, this.closeView, this.ctaView);
            } catch (Throwable th) {
                th = th;
                af.b("BaseECTemple", th.getMessage());
                return z5;
            }
        } catch (Throwable th2) {
            th = th2;
            z5 = false;
            af.b("BaseECTemple", th.getMessage());
            return z5;
        }
    }

    public void onActivityLifeCycleCallback(String str) {
        ECTemplePresenter eCTemplePresenter;
        str.getClass();
        if (str.equals("onDestroy")) {
            ECTemplePresenter eCTemplePresenter2 = this.ecPresenter;
            if (eCTemplePresenter2 != null) {
                eCTemplePresenter2.onDestroy();
            }
        } else if (str.equals("onBackPressed") && (eCTemplePresenter = this.ecPresenter) != null) {
            eCTemplePresenter.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ECTemplePresenter eCTemplePresenter = this.ecPresenter;
        if (eCTemplePresenter != null) {
            eCTemplePresenter.setAutoRedirect();
            this.ecPresenter.addShakeView();
            this.ecPresenter.addBaitClickView();
            this.ecPresenter.setCloseViewShow();
            setNotch();
            this.ecPresenter.showStoreMiniCard();
        }
    }

    public void onClick(View view) {
        this.ecPresenter.click(view);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ECTemplePresenter eCTemplePresenter = this.ecPresenter;
        if (!(eCTemplePresenter == null || motionEvent == null)) {
            eCTemplePresenter.handleInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void removeTempleFromSuperView(ViewGroup viewGroup) {
        viewGroup.removeView(this);
    }

    public void setBlurBackGround(final Bitmap bitmap) {
        ImageView imageView = this.bannerIvBg;
        if (imageView != null) {
            imageView.post(new Runnable() {
                public void run() {
                    BaseECTemplate.this.bannerIvBg.setImageBitmap(bitmap);
                }
            });
        }
    }

    public void setCTAText(String str) {
        View view = this.ctaView;
        if (view instanceof TextView) {
            ((TextView) view).setText(str);
        }
    }

    public void setCloseViewBtnDelayShow(int i5) {
        View view = this.closeView;
        if (view != null) {
            view.postDelayed(new Runnable() {
                public void run() {
                    View view = BaseECTemplate.this.closeView;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                }
            }, (long) i5);
        }
    }

    public void setHeatCount(int i5) {
        LinearLayout linearLayout = this.mLevelHeatCount;
        if (linearLayout instanceof MBHeatLevelLayoutView) {
            ((MBHeatLevelLayoutView) linearLayout).setHeatCount(i5);
        }
    }

    public void setImageBitMap(int i5, Bitmap bitmap) {
        ((ImageView) findViewById(i5)).setImageBitmap(bitmap);
    }

    public void setNLogo(int i5, String str, Drawable drawable) {
        if (i5 == 0) {
            ImageView imageView = this.flagIV;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            ImageView imageView2 = this.logoView;
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            TextView textView = this.flagTV;
            if (textView != null) {
                textView.setVisibility(0);
                this.flagTV.setText(str);
                return;
            }
            return;
        }
        ImageView imageView3 = this.flagIV;
        if (imageView3 != null) {
            imageView3.setImageDrawable(drawable);
        }
    }

    public void setNotch() {
        DisplayCutout a5;
        int i5;
        int i6;
        try {
            if (!this.ecPresenter.isHalfScreenOffer()) {
                int i7 = Build.VERSION.SDK_INT;
                WindowInsets rootWindowInsets = getRootWindowInsets();
                if (i7 >= 28 && (a5 = rootWindowInsets.getDisplayCutout()) != null) {
                    int a6 = a5.getSafeInsetLeft();
                    int a7 = a5.getSafeInsetTop();
                    int a8 = a5.getSafeInsetRight();
                    int unused = a5.getSafeInsetBottom();
                    if (this.topControllerLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.topControllerLayout.getLayoutParams();
                        int a9 = ak.a(getContext(), 9.0f);
                        if (a6 == 0) {
                            i5 = a9;
                        } else {
                            i5 = a6;
                        }
                        layoutParams.leftMargin = i5;
                        if (a7 == 0) {
                            i6 = a9;
                        } else {
                            i6 = a7;
                        }
                        layoutParams.topMargin = i6;
                        if (a8 != 0) {
                            a9 = a8;
                        }
                        layoutParams.rightMargin = a9;
                        this.topControllerLayout.setLayoutParams(layoutParams);
                    }
                    if (this.topControllerLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.topControllerLayout.getLayoutParams();
                        int a10 = ak.a(getContext(), 9.0f);
                        if (a6 == 0) {
                            a6 = a10;
                        }
                        layoutParams2.leftMargin = a6;
                        if (a7 == 0) {
                            a7 = a10;
                        }
                        layoutParams2.topMargin = a7;
                        if (a8 == 0) {
                            a8 = a10;
                        }
                        layoutParams2.rightMargin = a8;
                        this.topControllerLayout.setLayoutParams(layoutParams2);
                    }
                }
            }
        } catch (Throwable th) {
            af.b("BaseECTemple", th.getMessage());
        }
    }

    public void setRatingAndUser(double d5, int i5) {
        try {
            LinearLayout linearLayout = this.levelSlv;
            if (linearLayout instanceof MBridgeLevelLayoutView) {
                linearLayout.removeAllViews();
                this.levelSlv.setVisibility(0);
                ((MBridgeLevelLayoutView) this.levelSlv).setRatingAndUser(d5, i5);
            }
            LinearLayout linearLayout2 = this.levelSlv;
            if (linearLayout2 instanceof MBStarLevelLayoutView) {
                linearLayout2.removeAllViews();
                this.levelSlv.setVisibility(0);
                ((MBStarLevelLayoutView) this.levelSlv).setRating((int) d5);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public void setTextByID(int i5, String str) {
        TextView textView = (TextView) findViewById(i5);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void show(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.addView(this);
            setViewInitState();
            ECTemplePresenter eCTemplePresenter = this.ecPresenter;
            if (eCTemplePresenter != null) {
                eCTemplePresenter.onEndCardShow();
            }
        }
    }

    public BaseECTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
