package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;

public class MBridgeBaitClickView extends RelativeLayout {
    public static final int ANIMATION_TYPE_DOUBLE_CLICK = 4;
    public static final int ANIMATION_TYPE_FAST_SCALE = 1;
    public static final int ANIMATION_TYPE_ROTATE = 5;
    public static final int ANIMATION_TYPE_SLOW_SCALE = 2;
    public static final int ANIMATION_TYPE_SLOW_SCALE_WITH_PAUSE = 3;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public MBridgeDyImageView f8453a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public MBridgeDyImageView f8454b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f8455c;

    /* renamed from: d  reason: collision with root package name */
    private String f8456d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f8457e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f8458f = "Click now for details";

    /* renamed from: g  reason: collision with root package name */
    private int f8459g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f8460h = 1342177280;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Animation f8461i;

    /* renamed from: j  reason: collision with root package name */
    private Animation f8462j;

    /* renamed from: k  reason: collision with root package name */
    private Animation f8463k;

    /* renamed from: l  reason: collision with root package name */
    private Animation f8464l;

    public MBridgeBaitClickView(@NonNull Context context) {
        super(context);
    }

    public void init(int i5) {
        this.f8459g = i5;
        init();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
        Animation animation = this.f8461i;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f8462j;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f8463k;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.f8464l;
        if (animation4 != null) {
            animation4.cancel();
        }
    }

    public void startAnimation() {
        int i5 = this.f8459g;
        if (i5 == 2) {
            this.f8454b.setVisibility(4);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f8461i = scaleAnimation;
            scaleAnimation.setDuration(500);
            this.f8461i.setRepeatCount(-1);
            this.f8461i.setRepeatMode(2);
            MBridgeDyImageView mBridgeDyImageView = this.f8453a;
            if (mBridgeDyImageView != null) {
                mBridgeDyImageView.startAnimation(this.f8461i);
            }
        } else if (i5 == 3) {
            MBridgeDyImageView mBridgeDyImageView2 = this.f8454b;
            if (mBridgeDyImageView2 != null) {
                mBridgeDyImageView2.setVisibility(4);
            }
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f8461i = scaleAnimation2;
            scaleAnimation2.setDuration(500);
            this.f8461i.setRepeatCount(1);
            this.f8461i.setRepeatMode(2);
            ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.f8462j = scaleAnimation3;
            scaleAnimation3.setDuration(1000);
            this.f8462j.setRepeatCount(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.f8463k = alphaAnimation;
            alphaAnimation.setDuration(1000);
            this.f8463k.setRepeatCount(0);
            final AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(this.f8462j);
            animationSet.addAnimation(this.f8463k);
            this.f8462j.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    if (MBridgeBaitClickView.this.f8454b != null) {
                        MBridgeBaitClickView.this.f8454b.setVisibility(4);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    if (MBridgeBaitClickView.this.f8454b != null) {
                        MBridgeBaitClickView.this.f8454b.setVisibility(0);
                    }
                }
            });
            this.f8461i.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    MBridgeBaitClickView.this.postDelayed(new Runnable() {
                        public void run() {
                            if (MBridgeBaitClickView.this.f8453a != null) {
                                MBridgeBaitClickView.this.f8453a.startAnimation(MBridgeBaitClickView.this.f8461i);
                            }
                        }
                    }, 1000);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    MBridgeBaitClickView.this.postDelayed(new Runnable() {
                        public void run() {
                            if (MBridgeBaitClickView.this.f8454b != null) {
                                MBridgeBaitClickView.this.f8454b.startAnimation(animationSet);
                            }
                        }
                    }, 550);
                }
            });
            MBridgeDyImageView mBridgeDyImageView3 = this.f8453a;
            if (mBridgeDyImageView3 != null) {
                mBridgeDyImageView3.startAnimation(this.f8461i);
            }
        } else if (i5 == 4) {
            this.f8454b.setVisibility(4);
            ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.f8461i = scaleAnimation4;
            scaleAnimation4.setDuration(200);
            this.f8461i.setRepeatCount(1);
            this.f8461i.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    MBridgeBaitClickView.this.postDelayed(new Runnable() {
                        public void run() {
                            if (MBridgeBaitClickView.this.f8453a != null) {
                                MBridgeBaitClickView.this.f8453a.startAnimation(MBridgeBaitClickView.this.f8461i);
                            }
                        }
                    }, 1000);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            MBridgeDyImageView mBridgeDyImageView4 = this.f8453a;
            if (mBridgeDyImageView4 != null) {
                mBridgeDyImageView4.startAnimation(this.f8461i);
            }
        } else if (i5 != 5) {
            ScaleAnimation scaleAnimation5 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f8461i = scaleAnimation5;
            scaleAnimation5.setDuration(200);
            this.f8461i.setRepeatCount(-1);
            this.f8461i.setRepeatMode(2);
            MBridgeDyImageView mBridgeDyImageView5 = this.f8453a;
            if (mBridgeDyImageView5 != null) {
                mBridgeDyImageView5.startAnimation(this.f8461i);
            }
            ScaleAnimation scaleAnimation6 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            this.f8462j = scaleAnimation6;
            scaleAnimation6.setDuration(400);
            this.f8462j.setRepeatCount(-1);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.3f);
            this.f8463k = alphaAnimation2;
            alphaAnimation2.setDuration(400);
            this.f8463k.setRepeatCount(-1);
            AnimationSet animationSet2 = new AnimationSet(true);
            animationSet2.addAnimation(this.f8462j);
            animationSet2.addAnimation(this.f8463k);
            MBridgeDyImageView mBridgeDyImageView6 = this.f8454b;
            if (mBridgeDyImageView6 != null) {
                mBridgeDyImageView6.startAnimation(animationSet2);
            }
        } else {
            RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
            this.f8464l = rotateAnimation;
            rotateAnimation.setDuration(300);
            this.f8464l.setRepeatMode(2);
            this.f8464l.setRepeatCount(-1);
            ScaleAnimation scaleAnimation7 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            this.f8462j = scaleAnimation7;
            scaleAnimation7.setDuration(600);
            this.f8462j.setRepeatCount(-1);
            AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
            this.f8463k = alphaAnimation3;
            alphaAnimation3.setDuration(600);
            this.f8463k.setRepeatCount(-1);
            AnimationSet animationSet3 = new AnimationSet(true);
            animationSet3.addAnimation(this.f8462j);
            animationSet3.addAnimation(this.f8463k);
            MBridgeDyImageView mBridgeDyImageView7 = this.f8453a;
            if (mBridgeDyImageView7 != null) {
                mBridgeDyImageView7.startAnimation(this.f8464l);
            }
            MBridgeDyImageView mBridgeDyImageView8 = this.f8454b;
            if (mBridgeDyImageView8 != null) {
                mBridgeDyImageView8.startAnimation(animationSet3);
            }
        }
    }

    public void init(int i5, int i6) {
        this.f8460h = i5;
        this.f8459g = i6;
        init();
    }

    public void init(int i5, int i6, String str, String str2, String str3) {
        this.f8460h = i5;
        this.f8459g = i6;
        this.f8456d = str;
        this.f8457e = str2;
        this.f8458f = str3;
        init();
    }

    public MBridgeBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init() {
        try {
            setBackgroundColor(this.f8460h);
            this.f8458f = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh") ? "点击查看详情" : "Click now for details";
        } catch (Throwable th) {
            af.b("MBridgeAnimationClickView", th.getMessage());
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        int a5 = ak.a(getContext(), 55.0f);
        int a6 = ak.a(getContext(), 33.0f);
        this.f8454b = new MBridgeDyImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a5, a5);
        layoutParams.setMargins(a6, a6, 0, 0);
        this.f8454b.setLayoutParams(layoutParams);
        final int a7 = x.a(getContext(), "mbridge_icon_click_circle", "drawable");
        if (TextUtils.isEmpty(this.f8457e)) {
            this.f8454b.setImageResource(a7);
        } else {
            b.a(c.m().c()).a(this.f8456d, new com.mbridge.msdk.foundation.same.c.c() {
                public void onFailedLoad(String str, String str2) {
                    MBridgeBaitClickView.this.f8454b.setImageResource(a7);
                }

                public void onSuccessLoad(Bitmap bitmap, String str) {
                    if (!bitmap.isRecycled()) {
                        MBridgeBaitClickView.this.f8454b.setImageBitmap(bitmap);
                    }
                }
            });
        }
        int a8 = ak.a(getContext(), 108.0f);
        int a9 = ak.a(getContext(), 35.0f);
        int a10 = ak.a(getContext(), 43.0f);
        this.f8453a = new MBridgeDyImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a8, a8);
        layoutParams2.setMargins(a9, a10, 0, 0);
        this.f8453a.setLayoutParams(layoutParams2);
        final int a11 = x.a(getContext(), "mbridge_icon_click_hand", "drawable");
        if (TextUtils.isEmpty(this.f8456d)) {
            this.f8453a.setImageResource(a11);
        } else {
            b.a(c.m().c()).a(this.f8456d, new com.mbridge.msdk.foundation.same.c.c() {
                public void onFailedLoad(String str, String str2) {
                    MBridgeBaitClickView.this.f8453a.setImageResource(a11);
                }

                public void onSuccessLoad(Bitmap bitmap, String str) {
                    if (!bitmap.isRecycled()) {
                        MBridgeBaitClickView.this.f8453a.setImageBitmap(bitmap);
                    }
                }
            });
        }
        relativeLayout.addView(this.f8454b);
        relativeLayout.addView(this.f8453a);
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        linearLayout.setLayoutParams(layoutParams3);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.addView(relativeLayout);
        this.f8455c = new TextView(getContext());
        this.f8455c.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f8455c.setText(this.f8458f);
        this.f8455c.setTextColor(-1);
        this.f8455c.setGravity(14);
        linearLayout.addView(this.f8455c);
        addView(linearLayout);
    }

    public MBridgeBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    @RequiresApi(api = 21)
    public MBridgeBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }
}
