package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.newreward.player.presenter.AbsPresenter;
import com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter;
import com.mbridge.msdk.newreward.player.view.floatview.AlertTempleView;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.widget.FeedBackButton;

public abstract class BaseTemplate extends RelativeLayout implements View.OnClickListener, IPlayTempleView {
    private static final String TAG = "BaseTemplate";
    protected AlertTempleView alertTempleView;
    protected ImageView bgImageView;
    protected CollapsibleWebView collapsibleWebVew;
    protected RelativeLayout collapsibleWebVewHeader;
    protected RelativeLayout collapsibleWebVewLayout;
    protected FeedBackButton feedBackButton;
    private final Runnable getCutoutRunnable = new Runnable() {
        public void run() {
            DisplayCutout a5;
            try {
                PlayTemplePresenter playTemplePresenter = BaseTemplate.this.presenter;
                if (playTemplePresenter == null || !playTemplePresenter.isHalfScreenOffer()) {
                    int i5 = Build.VERSION.SDK_INT;
                    WindowInsets rootWindowInsets = BaseTemplate.this.getRootWindowInsets();
                    if (i5 >= 28 && rootWindowInsets != null && (a5 = rootWindowInsets.getDisplayCutout()) != null && BaseTemplate.this.mTopControllerView != null) {
                        int a6 = a5.getSafeInsetLeft();
                        int a7 = a5.getSafeInsetTop();
                        int a8 = a5.getSafeInsetRight();
                        int unused = a5.getSafeInsetBottom();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BaseTemplate.this.mTopControllerView.getLayoutParams();
                        int a9 = ak.a(BaseTemplate.this.getContext(), 9.0f);
                        if (a6 == 0) {
                            a6 = a9;
                        }
                        layoutParams.leftMargin = a6;
                        if (a7 == 0) {
                            a7 = a9;
                        }
                        layoutParams.topMargin = a7;
                        if (a8 == 0) {
                            a8 = a9;
                        }
                        layoutParams.rightMargin = a8;
                        BaseTemplate.this.mTopControllerView.setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable th) {
                af.b(BaseTemplate.TAG, th.getMessage());
            }
        }
    };
    protected MBridgeBaitClickView mBaitClickView;
    protected FrameLayout mCtaLayout;
    protected boolean mDyXmlSuccess = false;
    protected PlayerView mPlayerView;
    protected MBridgeSegmentsProgressBar mSegmentsProgressBar;
    protected SoundImageView mSoundImageView;
    protected RelativeLayout mTopControllerView;
    protected TextView mTvCountDown;
    protected View mViewPlayingClose;
    protected PlayTemplePresenter presenter;
    protected ImageView privacyButton;
    protected ProgressBar videoProgressBar;

    public BaseTemplate(@NonNull Context context) {
        super(context);
    }

    public void addClickEvent() {
        View view = this.mViewPlayingClose;
        if (view != null) {
            view.setOnClickListener(this);
        }
        SoundImageView soundImageView = this.mSoundImageView;
        if (soundImageView != null) {
            soundImageView.setOnClickListener(this);
        }
    }

    public void addViewToCurrentViewGroup(View view) {
        addView(view);
    }

    public void alertDismiss() {
        if (this.alertTempleView != null) {
            PlayTemplePresenter playTemplePresenter = this.presenter;
            if (playTemplePresenter != null) {
                playTemplePresenter.onResume();
            }
            removeView(this.alertTempleView);
        }
    }

    public void alertShow() {
        if (this.alertTempleView != null) {
            PlayTemplePresenter playTemplePresenter = this.presenter;
            if (playTemplePresenter != null) {
                playTemplePresenter.onPause();
            }
            addView(this.alertTempleView);
        }
    }

    public View getBaitClickView() {
        MBridgeBaitClickView mBridgeBaitClickView = this.mBaitClickView;
        if (mBridgeBaitClickView == null) {
            return null;
        }
        return mBridgeBaitClickView;
    }

    public View getCountDownView() {
        return this.mTvCountDown;
    }

    public boolean getMuteState() {
        PlayerView playerView = this.mPlayerView;
        if (playerView == null) {
            return true;
        }
        return playerView.isSilent();
    }

    public ImageView getPrivacyButton() {
        return this.privacyButton;
    }

    public MBridgeSegmentsProgressBar getSegmentsProgressBar() {
        return this.mSegmentsProgressBar;
    }

    public PlayerView getmPlayerView() {
        return this.mPlayerView;
    }

    public SoundImageView getmSoundImageView() {
        return this.mSoundImageView;
    }

    public TextView getmTvCountDown() {
        return this.mTvCountDown;
    }

    public View getmViewPlayingClose() {
        return this.mViewPlayingClose;
    }

    public boolean initViews(boolean z4) {
        this.mDyXmlSuccess = z4;
        try {
            this.alertTempleView = new AlertTempleView(getContext(), (AbsPresenter) this.presenter);
            this.mPlayerView = (PlayerView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_vfpv"));
            this.mSoundImageView = (SoundImageView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_sound_switch"));
            this.mTvCountDown = (TextView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_count"));
            View findViewById = findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_rl_playing_close"));
            this.mViewPlayingClose = findViewById;
            if (findViewById != null) {
                findViewById.setVisibility(4);
            }
            this.mTopControllerView = (RelativeLayout) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_top_control"));
            this.bgImageView = (ImageView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_videoview_bg"));
            this.videoProgressBar = (ProgressBar) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_video_progress_bar"));
            this.feedBackButton = (FeedBackButton) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_native_endcard_feed_btn"));
            this.privacyButton = (ImageView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_link"));
            this.collapsibleWebVewLayout = (RelativeLayout) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_reward_scale_webview_layout"));
            this.collapsibleWebVewHeader = (RelativeLayout) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_reward_header_layout"));
            if (this.collapsibleWebVewLayout != null) {
                CollapsibleWebView collapsibleWebView = new CollapsibleWebView(getContext());
                this.collapsibleWebVew = collapsibleWebView;
                this.collapsibleWebVewLayout.addView(collapsibleWebView, new RelativeLayout.LayoutParams(-1, -1));
            }
            this.mSegmentsProgressBar = (MBridgeSegmentsProgressBar) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_reward_segment_progressbar"));
            this.mCtaLayout = (FrameLayout) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_reward_cta_layout"));
            this.mBaitClickView = (MBridgeBaitClickView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_animation_click_view"));
            addClickEvent();
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
        return this.presenter.isNotNULL(this.mPlayerView, this.mSoundImageView, this.mTvCountDown, this.mViewPlayingClose, this.mTopControllerView);
    }

    public void onActivityLifeCycleCallback(String str) {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1401315045:
                if (str.equals("onDestroy")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1340212393:
                if (str.equals("onPause")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1111243300:
                if (str.equals("onBackPressed")) {
                    c5 = 2;
                    break;
                }
                break;
            case 1463983852:
                if (str.equals("onResume")) {
                    c5 = 3;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                PlayTemplePresenter playTemplePresenter = this.presenter;
                if (playTemplePresenter != null) {
                    playTemplePresenter.onDestroy();
                    return;
                }
                return;
            case 1:
                PlayTemplePresenter playTemplePresenter2 = this.presenter;
                if (playTemplePresenter2 != null) {
                    playTemplePresenter2.onPause();
                    return;
                }
                return;
            case 2:
                PlayTemplePresenter playTemplePresenter3 = this.presenter;
                if (playTemplePresenter3 != null) {
                    playTemplePresenter3.onBackPressed();
                    return;
                }
                return;
            case 3:
                PlayTemplePresenter playTemplePresenter4 = this.presenter;
                if (playTemplePresenter4 != null) {
                    playTemplePresenter4.onResume();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.presenter.addBaitClickView();
    }

    public void onClick(View view) {
        PlayTemplePresenter playTemplePresenter = this.presenter;
        if (playTemplePresenter != null) {
            playTemplePresenter.click(view);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        PlayTemplePresenter playTemplePresenter = this.presenter;
        if (!(playTemplePresenter == null || motionEvent == null)) {
            playTemplePresenter.handleInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        PlayTemplePresenter playTemplePresenter = this.presenter;
        if (playTemplePresenter != null) {
            playTemplePresenter.windowFocusChanged();
        }
    }

    public void pause() {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.pause();
        }
    }

    public void play(String str, int i5) {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.initBufferIngParam(i5);
            this.mPlayerView.initVFPData(str, str, this.presenter);
            this.mPlayerView.playVideo();
        }
    }

    public void release() {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.release();
            this.mPlayerView = null;
        }
    }

    public void removeTempleFromSuperView(ViewGroup viewGroup) {
        removeCallbacks(this.getCutoutRunnable);
        viewGroup.removeView(this);
        PlayTemplePresenter playTemplePresenter = this.presenter;
        if (playTemplePresenter != null) {
            playTemplePresenter.removeCurrPlayTemplateMoreOfferView(viewGroup);
        }
    }

    public void resume() {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.onResume();
        }
    }

    public void setAdCloseVisibility(boolean z4) {
        View view = this.mViewPlayingClose;
        if (view != null) {
            if (z4) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void setAlertViewType(String str, int i5, int i6) {
        AlertTempleView alertTempleView2 = this.alertTempleView;
        if (alertTempleView2 != null) {
            alertTempleView2.setAlertType(i5, str, i6);
        }
    }

    public void setBackGroundImage(Bitmap bitmap) {
    }

    public void setCountDown(String str, int i5, int i6, ViewGroup.LayoutParams layoutParams) {
        TextView textView = this.mTvCountDown;
        if (textView != null) {
            textView.setText(str);
            if (this.mTvCountDown.getVisibility() != 0) {
                this.mTvCountDown.setVisibility(0);
            }
            if (i5 != 0) {
                this.mTvCountDown.setPadding(i5, 0, i5, 0);
            }
            if (layoutParams != null) {
                this.mTvCountDown.setLayoutParams(layoutParams);
            }
            if (i6 != 0) {
                this.mTvCountDown.setBackgroundResource(i6);
            }
        }
    }

    public void setMuteState(boolean z4) {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            if (z4) {
                playerView.closeSound();
            } else {
                playerView.openSound();
            }
        }
        SoundImageView soundImageView = this.mSoundImageView;
        if (soundImageView != null) {
            soundImageView.setSoundStatus(!z4);
        }
    }

    public void setPlayerSize(int i5, int i6, int i7) {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) playerView.getLayoutParams();
            layoutParams.width = i6;
            layoutParams.height = i7;
            if (i5 != 0) {
                layoutParams.gravity = i5;
            }
            this.mPlayerView.setLayoutParams(layoutParams);
        }
    }

    public void setSegmentsProgressBar(int i5) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar = this.mSegmentsProgressBar;
        if (mBridgeSegmentsProgressBar != null) {
            mBridgeSegmentsProgressBar.init(1, 3);
            this.mSegmentsProgressBar.setVisibility(i5);
        }
    }

    public void setTemplateWidthAndHeight(final int i5) {
        post(new Runnable() {
            public void run() {
                try {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) BaseTemplate.this.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.setMargins(0, 0, 0, i5);
                        BaseTemplate.this.setLayoutParams(layoutParams);
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        });
    }

    public void setmPlayerView(PlayerView playerView) {
        this.mPlayerView = playerView;
    }

    public void show(ViewGroup viewGroup) {
        PlayTemplePresenter playTemplePresenter = this.presenter;
        if (playTemplePresenter != null && playTemplePresenter.playTemplateRanderSuccess) {
            viewGroup.addView(this);
            postDelayed(this.getCutoutRunnable, 1000);
            this.presenter.addMoreOfferView(this);
        }
    }

    public void viewReport(Object obj) {
    }

    public BaseTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
