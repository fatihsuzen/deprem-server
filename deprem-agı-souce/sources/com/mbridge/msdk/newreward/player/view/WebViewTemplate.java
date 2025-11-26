package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.at;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.iview.IWebTemplateView;
import com.mbridge.msdk.newreward.player.model.WebTemplateModel;
import com.mbridge.msdk.newreward.player.presenter.AbsPresenter;
import com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter;
import com.mbridge.msdk.newreward.player.view.floatview.AlertTempleView;
import com.mbridge.msdk.newreward.player.view.floatview.FloatWebTemplateView;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONObject;

public class WebViewTemplate extends FrameLayout implements View.OnClickListener, IWebTemplateView {
    final int CLOSE_BUILD_TYPE = 2;
    private final String TAG = "WebViewTemplate";
    private final Runnable getNotchDataRunnable = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0060 A[Catch:{ all -> 0x0085 }] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0062 A[Catch:{ all -> 0x0085 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0067 A[Catch:{ all -> 0x0085 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0069 A[Catch:{ all -> 0x0085 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006e A[Catch:{ all -> 0x0085 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x006f A[Catch:{ all -> 0x0085 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0085 }
                com.mbridge.msdk.newreward.player.view.WebViewTemplate r1 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch:{ all -> 0x0085 }
                android.view.WindowInsets r1 = r1.getRootWindowInsets()     // Catch:{ all -> 0x0085 }
                r2 = 28
                if (r0 < r2) goto L_0x0087
                android.view.DisplayCutout r0 = r1.getDisplayCutout()     // Catch:{ all -> 0x0085 }
                if (r0 == 0) goto L_0x0087
                com.mbridge.msdk.newreward.player.view.WebViewTemplate r1 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch:{ all -> 0x0085 }
                android.widget.RelativeLayout r1 = r1.mTopControllerView     // Catch:{ all -> 0x0085 }
                if (r1 == 0) goto L_0x0087
                int r1 = r0.getSafeInsetLeft()     // Catch:{ all -> 0x0085 }
                int r2 = r0.getSafeInsetTop()     // Catch:{ all -> 0x0085 }
                int r3 = r0.getSafeInsetRight()     // Catch:{ all -> 0x0085 }
                int r0 = r0.getSafeInsetBottom()     // Catch:{ all -> 0x0085 }
                com.mbridge.msdk.newreward.player.view.WebViewTemplate r4 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch:{ all -> 0x0085 }
                android.view.Display r4 = r4.getDisplay()     // Catch:{ all -> 0x0085 }
                int r4 = r4.getRotation()     // Catch:{ all -> 0x0085 }
                if (r4 != 0) goto L_0x0035
                goto L_0x0047
            L_0x0035:
                r5 = 1
                if (r4 != r5) goto L_0x003b
                r4 = 90
                goto L_0x0048
            L_0x003b:
                r5 = 2
                if (r4 != r5) goto L_0x0041
                r4 = 180(0xb4, float:2.52E-43)
                goto L_0x0048
            L_0x0041:
                r5 = 3
                if (r4 != r5) goto L_0x0047
                r4 = 270(0x10e, float:3.78E-43)
                goto L_0x0048
            L_0x0047:
                r4 = 0
            L_0x0048:
                com.mbridge.msdk.newreward.player.view.WebViewTemplate r5 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch:{ all -> 0x0085 }
                android.widget.RelativeLayout r5 = r5.mTopControllerView     // Catch:{ all -> 0x0085 }
                android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch:{ all -> 0x0085 }
                android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5     // Catch:{ all -> 0x0085 }
                com.mbridge.msdk.newreward.player.view.WebViewTemplate r6 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch:{ all -> 0x0085 }
                android.content.Context r6 = r6.getContext()     // Catch:{ all -> 0x0085 }
                r7 = 1092616192(0x41200000, float:10.0)
                int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r6, (float) r7)     // Catch:{ all -> 0x0085 }
                if (r1 != 0) goto L_0x0062
                r7 = r6
                goto L_0x0063
            L_0x0062:
                r7 = r1
            L_0x0063:
                r5.leftMargin = r7     // Catch:{ all -> 0x0085 }
                if (r2 != 0) goto L_0x0069
                r7 = r6
                goto L_0x006a
            L_0x0069:
                r7 = r2
            L_0x006a:
                r5.topMargin = r7     // Catch:{ all -> 0x0085 }
                if (r3 != 0) goto L_0x006f
                goto L_0x0070
            L_0x006f:
                r6 = r3
            L_0x0070:
                r5.rightMargin = r6     // Catch:{ all -> 0x0085 }
                com.mbridge.msdk.newreward.player.view.WebViewTemplate r6 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch:{ all -> 0x0085 }
                android.widget.RelativeLayout r6 = r6.mTopControllerView     // Catch:{ all -> 0x0085 }
                r6.setLayoutParams(r5)     // Catch:{ all -> 0x0085 }
                com.mbridge.msdk.newreward.player.view.WebViewTemplate r5 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch:{ all -> 0x0085 }
                com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter r5 = r5.mWebTemplatePresenter     // Catch:{ all -> 0x0085 }
                java.lang.String r0 = com.mbridge.msdk.foundation.tools.s.a(r4, r1, r3, r2, r0)     // Catch:{ all -> 0x0085 }
                r5.setNotchData(r0)     // Catch:{ all -> 0x0085 }
                return
            L_0x0085:
                r0 = move-exception
                goto L_0x0088
            L_0x0087:
                return
            L_0x0088:
                java.lang.String r1 = "WebViewTemplate"
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.WebViewTemplate.AnonymousClass6.run():void");
        }
    };
    private boolean hasWebViewShow = false;
    private final Runnable hideCTAViewRunnable = new Runnable() {
        public void run() {
            WebViewTemplate webViewTemplate = WebViewTemplate.this;
            webViewTemplate.removeView(webViewTemplate.mCTAView);
            WebViewTemplate.this.mSoundImageView.setVisibility(0);
        }
    };
    boolean isWebViewAttached;
    boolean isWebViewShowed;
    AlertTempleView mAlertTempleView;
    MBridgeClickCTAView mCTAView;
    ImageView mCloseImageView;
    TextView mCountDownTextView;
    ImageView mLinkImageView;
    FrameLayout mPlayerLayout;
    PlayerView mPlayerView;
    MBridgeSegmentsProgressBar mSegmentsProgressBar;
    SoundImageView mSoundImageView;
    RelativeLayout mTopControllerView;
    PlayWebPresenter mWebTemplatePresenter;
    MBWebView mWebView;
    FloatWebTemplateView miniCardView;
    private final Runnable webViewShowRunnable = new Runnable() {
        public void run() {
            WebViewTemplate.this.webViewShow();
        }
    };

    public WebViewTemplate(@NonNull Context context) {
        super(context);
        initPresenter();
    }

    private RelativeLayout getTopControllerView() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        int a5 = ak.a(getContext(), 10.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = a5;
        layoutParams.rightMargin = a5;
        layoutParams.topMargin = a5;
        relativeLayout.setLayoutParams(layoutParams);
        this.mLinkImageView = new ImageView(getContext());
        int a6 = ak.a(getContext(), 35.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a6, a6);
        layoutParams2.addRule(9);
        this.mLinkImageView.setLayoutParams(layoutParams2);
        this.mLinkImageView.setImageResource(x.a(getContext(), "mbridge_reward_notice", "drawable"));
        this.mLinkImageView.setId(at.a());
        this.mLinkImageView.setOnClickListener(this);
        this.mCountDownTextView = new TextView(getContext());
        int a7 = ak.a(getContext(), 30.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a7, a7);
        layoutParams3.addRule(1, this.mLinkImageView.getId());
        layoutParams3.addRule(15);
        this.mCountDownTextView.setLayoutParams(layoutParams3);
        this.mCountDownTextView.setId(at.a());
        this.mCountDownTextView.setGravity(17);
        this.mCountDownTextView.setTextColor(-1);
        this.mCountDownTextView.setTextSize(11.0f);
        this.mCountDownTextView.setBackgroundResource(x.a(getContext(), "mbridge_reward_video_time_count_num_bg", "drawable"));
        this.mCloseImageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a6, a6);
        layoutParams4.addRule(11);
        this.mCloseImageView.setLayoutParams(layoutParams4);
        this.mCloseImageView.setImageResource(x.a(getContext(), "mbridge_reward_close", "drawable"));
        this.mCloseImageView.setVisibility(4);
        this.mCloseImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WebViewTemplate.this.onCloseViewClick(2);
            }
        });
        relativeLayout.addView(this.mLinkImageView);
        relativeLayout.addView(this.mCountDownTextView);
        relativeLayout.addView(this.mCloseImageView);
        return relativeLayout;
    }

    public void addViewToCurrentViewGroup(View view) {
        if (view != null) {
            addView(view);
        }
    }

    public void addWebView(MBWebView mBWebView, int i5) {
        if (mBWebView != null) {
            this.mWebView = mBWebView;
            mBWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.mWebView.getHybridCommunicator() instanceof WebTemplateModel) {
                this.mWebTemplatePresenter.setTemplateModel((WebTemplateModel) this.mWebView.getHybridCommunicator());
            }
            this.mWebView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    WebViewTemplate webViewTemplate = WebViewTemplate.this;
                    webViewTemplate.isWebViewAttached = true;
                    webViewTemplate.mWebTemplatePresenter.onWebViewShow();
                }

                public void onViewDetachedFromWindow(View view) {
                    WebViewTemplate.this.isWebViewAttached = false;
                }
            });
            addView(this.mWebView, i5);
        }
    }

    public void alertDismiss() {
        if (this.mAlertTempleView != null) {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null) {
                playerView.resumeStart();
            }
            removeView(this.mAlertTempleView);
        }
    }

    public void alertShow() {
        if (this.mAlertTempleView != null) {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null) {
                playerView.pause();
            }
            addView(this.mAlertTempleView);
        }
    }

    public void changeVideoViewPosition(JSONObject jSONObject) {
        if (this.mPlayerView != null && jSONObject != null) {
            int optInt = jSONObject.optInt("margin_top", 0);
            int optInt2 = jSONObject.optInt("margin_left", 0);
            int optInt3 = jSONObject.optInt("view_width", 0);
            int optInt4 = jSONObject.optInt("view_height", 0);
            int optInt5 = jSONObject.optInt("radius", 0);
            if (optInt3 >= 0 && optInt4 >= 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerLayout.getLayoutParams();
                layoutParams.width = optInt3;
                layoutParams.height = optInt4;
                layoutParams.topMargin = optInt;
                layoutParams.leftMargin = optInt2;
                if (optInt5 > 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius((float) ak.a(getContext(), (float) optInt5));
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(1, 0);
                    setBackground(gradientDrawable);
                    this.mPlayerView.setBackground(gradientDrawable);
                    setClipToOutline(true);
                    this.mPlayerView.setClipToOutline(true);
                }
                this.mPlayerLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public View getBaitClickView() {
        return null;
    }

    public View getCountDownView() {
        return this.mCountDownTextView;
    }

    public boolean getMuteState() {
        SoundImageView soundImageView = this.mSoundImageView;
        if (soundImageView != null) {
            return soundImageView.getStatus();
        }
        return false;
    }

    public ImageView getPrivacyButton() {
        return this.mLinkImageView;
    }

    public MBridgeSegmentsProgressBar getSegmentsProgressBar() {
        return this.mSegmentsProgressBar;
    }

    public MBWebView getWebView() {
        return this.mWebView;
    }

    public void hideCTAView() {
        post(this.hideCTAViewRunnable);
    }

    public void initPresenter() {
        PlayWebPresenter playWebPresenter = new PlayWebPresenter(this);
        this.mWebTemplatePresenter = playWebPresenter;
        playWebPresenter.getView();
    }

    public boolean initViews(boolean z4) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mPlayerLayout = new FrameLayout(getContext());
        PlayerView playerView = new PlayerView(getContext());
        this.mPlayerView = playerView;
        playerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mAlertTempleView = new AlertTempleView(getContext(), (AbsPresenter) this.mWebTemplatePresenter);
        this.mSoundImageView = new SoundImageView(getContext());
        int a5 = ak.a(getContext(), 35.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a5, a5);
        int a6 = ak.a(getContext(), 10.0f);
        layoutParams.leftMargin = a6;
        layoutParams.bottomMargin = a6;
        layoutParams.gravity = 8388691;
        this.mSoundImageView.setLayoutParams(layoutParams);
        this.mSoundImageView.setOnClickListener(this);
        this.mSegmentsProgressBar = new MBridgeSegmentsProgressBar(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.mSegmentsProgressBar.setLayoutParams(layoutParams2);
        this.mPlayerLayout.addView(this.mPlayerView);
        this.mPlayerLayout.addView(this.mSoundImageView);
        this.mPlayerLayout.addView(this.mSegmentsProgressBar);
        this.mTopControllerView = getTopControllerView();
        addView(this.mPlayerLayout);
        addView(this.mTopControllerView);
        this.mPlayerView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WebViewTemplate.this.mWebTemplatePresenter.onClick(1);
            }
        });
        return false;
    }

    public void onActivityLifeCycleCallback(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
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
                case -1012956543:
                    if (str.equals("onStop")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 1463983852:
                    if (str.equals("onResume")) {
                        c5 = 4;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    PlayWebPresenter playWebPresenter = this.mWebTemplatePresenter;
                    if (playWebPresenter != null) {
                        playWebPresenter.onDestroy();
                    }
                    str2 = "onSystemDestory";
                    break;
                case 1:
                    PlayerView playerView = this.mPlayerView;
                    if (playerView != null) {
                        playerView.pause();
                    }
                    PlayWebPresenter playWebPresenter2 = this.mWebTemplatePresenter;
                    if (playWebPresenter2 != null) {
                        playWebPresenter2.onPause();
                    }
                    str2 = "onSystemPause";
                    break;
                case 2:
                    PlayWebPresenter playWebPresenter3 = this.mWebTemplatePresenter;
                    if (playWebPresenter3 != null) {
                        playWebPresenter3.onBackPressed();
                    }
                    str2 = "onSystemBackPressed";
                    break;
                case 3:
                    PlayerView playerView2 = this.mPlayerView;
                    if (playerView2 != null) {
                        playerView2.stop();
                        break;
                    }
                    break;
                case 4:
                    PlayerView playerView3 = this.mPlayerView;
                    if (playerView3 != null) {
                        playerView3.onResume();
                    }
                    PlayWebPresenter playWebPresenter4 = this.mWebTemplatePresenter;
                    if (playWebPresenter4 != null) {
                        playWebPresenter4.onResume();
                    }
                    str2 = "onSystemResume";
                    break;
            }
            str2 = "";
            if (!TextUtils.isEmpty(str2)) {
                MBCommunicatorUtil.fireEvent(this.mWebView, str2, "");
            }
        }
    }

    public void onClick(View view) {
        if (view == this.mLinkImageView) {
            this.mWebTemplatePresenter.onClick(9);
        } else if (view == this.mSoundImageView) {
            this.mWebTemplatePresenter.onClick(5);
        }
    }

    public void onCloseViewClick(@BridgeParameter(key = "type") int i5) {
        PlayWebPresenter playWebPresenter = this.mWebTemplatePresenter;
        if (playWebPresenter != null) {
            playWebPresenter.onClick(2);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            MBCommunicatorUtil.fireEvent(this.mWebView, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            af.b("WebViewTemplate", e5.getMessage());
        }
    }

    public void onDestroyWebContent(@BridgeParameter(key = "type") int i5) {
        MBWebView mBWebView = this.mWebView;
        if (mBWebView != null) {
            mBWebView.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.getNotchDataRunnable);
        removeCallbacks(this.hideCTAViewRunnable);
        removeCallbacks(this.webViewShowRunnable);
        this.mWebTemplatePresenter.onDetachedFromWindow();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        PlayWebPresenter playWebPresenter = this.mWebTemplatePresenter;
        if (!(playWebPresenter == null || motionEvent == null)) {
            playWebPresenter.handleInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onWebViewShow(@BridgeParameter(key = "type") int i5) {
        if (this.mWebView.isAttachedToWindow()) {
            this.mWebView.post(this.webViewShowRunnable);
        }
        if (this.hasWebViewShow) {
            return true;
        }
        this.hasWebViewShow = true;
        return false;
    }

    public void pause() {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.pause();
        }
    }

    public void play(String str, int i5) {
        this.mPlayerView.initBufferIngParam(i5);
        this.mPlayerView.initVFPData(str, str, this.mWebTemplatePresenter);
        this.mPlayerView.playVideo();
    }

    public void playOrPauseVideo(int i5) {
        PlayerView playerView;
        if (i5 != -999) {
            if (i5 == 1) {
                resume();
            } else if (i5 == 2) {
                pause();
            } else if (i5 == 3) {
                this.mPlayerView.stop();
            } else if (i5 == 6 && (playerView = this.mPlayerView) != null) {
                playerView.release();
            }
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
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public void resume() {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.onResume();
        }
    }

    public void seekToPlay(int i5) {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null && i5 != -1) {
            playerView.seekTo(i5);
        }
    }

    public void setAdCloseVisibility(boolean z4) {
    }

    public void setAlertViewType(String str, int i5, int i6) {
        AlertTempleView alertTempleView = this.mAlertTempleView;
        if (alertTempleView != null) {
            alertTempleView.setAlertType(i5, str, i6);
        }
    }

    public void setBackGroundImage(Bitmap bitmap) {
    }

    public void setCountDown(String str, int i5, int i6, ViewGroup.LayoutParams layoutParams) {
        TextView textView = this.mCountDownTextView;
        if (textView != null && textView.getVisibility() != 4) {
            this.mCountDownTextView.setText(str);
            if (i5 != 0) {
                this.mCountDownTextView.setPadding(i5, 0, i5, 0);
            }
            if (layoutParams != null) {
                this.mCountDownTextView.setLayoutParams(layoutParams);
            }
            if (i6 != 0) {
                this.mCountDownTextView.setBackgroundResource(i6);
            }
        }
    }

    public void setMuteState(boolean z4) {
        SoundImageView soundImageView = this.mSoundImageView;
        if (soundImageView != null) {
            soundImageView.setSoundStatus(z4);
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView == null) {
            return;
        }
        if (z4) {
            playerView.openSound();
        } else {
            playerView.closeSound();
        }
    }

    public void setNativeCloseButtonVisibility(int i5) {
        PlayWebPresenter playWebPresenter;
        ImageView imageView = this.mCloseImageView;
        if (imageView != null) {
            imageView.setVisibility(i5);
            if (i5 == 0 && (playWebPresenter = this.mWebTemplatePresenter) != null) {
                playWebPresenter.setCanResponseBack(true);
            }
        }
    }

    public void setPlayerSize(int i5, int i6, int i7) {
    }

    public void setSegmentsProgressBar(int i5) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar = this.mSegmentsProgressBar;
        if (mBridgeSegmentsProgressBar != null) {
            mBridgeSegmentsProgressBar.init(1, 3);
            this.mSegmentsProgressBar.setVisibility(i5);
        }
    }

    public void setTemplateWidthAndHeight(int i5) {
    }

    public void show(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.addView(this);
        }
        postDelayed(this.getNotchDataRunnable, 500);
    }

    public void showCTAView(String str, CampaignEx campaignEx) {
        if (this.mCTAView == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(getContext());
            this.mCTAView = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(campaignEx);
            this.mCTAView.setUnitId(str);
            this.mCTAView.preLoadData((b) null);
            this.mCTAView.setCtaClickCallBack(new MBridgeClickCTAView.a() {
                public void ctaClick() {
                    WebViewTemplate.this.mWebTemplatePresenter.onClick(3);
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        addView(this.mCTAView, layoutParams);
    }

    public void showMRAIDExpandView(String str, int i5) {
    }

    public void showMiniCard() {
        if (this.miniCardView == null) {
            FloatWebTemplateView floatWebTemplateView = new FloatWebTemplateView(getContext());
            this.miniCardView = floatWebTemplateView;
            floatWebTemplateView.setFloatViewType(FloatWebTemplateView.FLOAT_MINI_CARD);
        }
        this.miniCardView.addShowReqListener(new com.mbridge.msdk.newreward.a.b.b() {
            public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            }

            public void reqSuccessful(Object obj) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.equals("show")) {
                        WebViewTemplate.this.pause();
                    } else if (str.equals("remove")) {
                        WebViewTemplate.this.resume();
                    }
                }
            }
        });
        this.miniCardView.show(this);
    }

    public void viewReport(Object obj) {
    }

    public void webViewShow() {
        if (!this.isWebViewShowed) {
            int i5 = getResources().getConfiguration().orientation;
            String str = "undefined";
            if (i5 != 0) {
                if (i5 == 1) {
                    str = "portrait";
                } else if (i5 == 2) {
                    str = "landscape";
                }
            }
            MBCommunicatorUtil.notifyShowDataInfo(this.mWebView, i5, this.mWebTemplatePresenter.getCampaignOrientation());
            MBCommunicatorUtil.notifyWebViewShowed(this.mWebView, str, this.mWebTemplatePresenter.getWebViewShowExtraData());
            this.isWebViewShowed = true;
        }
    }

    public void setMuteState(int i5, int i6) {
        SoundImageView soundImageView = this.mSoundImageView;
        if (soundImageView != null) {
            soundImageView.setVisibility(i6 == 1 ? 4 : 0);
            if (i5 == 1) {
                this.mSoundImageView.setSoundStatus(true);
            }
            if (i5 == 2) {
                this.mSoundImageView.setSoundStatus(false);
            }
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            if (i5 == 1) {
                playerView.closeSound();
            }
            if (i5 == 2) {
                this.mPlayerView.openSound();
            }
        }
    }

    public WebViewTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initPresenter();
    }

    public WebViewTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        initPresenter();
    }

    @RequiresApi(api = 21)
    public WebViewTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        initPresenter();
    }
}
