package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

public class MBSplashClickView extends MBRelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK = 3;
    public final int TYPE_SPLASH_BTN_GO = 2;
    public final int TYPE_SPLASH_BTN_OPEN = 1;

    /* renamed from: a  reason: collision with root package name */
    private final String f8369a = "浏览第三方应用";

    /* renamed from: b  reason: collision with root package name */
    private final String f8370b = "View";

    /* renamed from: c  reason: collision with root package name */
    private final String f8371c = "打开第三方应用";

    /* renamed from: d  reason: collision with root package name */
    private final String f8372d = "Open";

    /* renamed from: e  reason: collision with root package name */
    private final String f8373e = "下载第三方应用";

    /* renamed from: f  reason: collision with root package name */
    private final String f8374f = "Install";

    /* renamed from: g  reason: collision with root package name */
    private final String f8375g = "mbridge_splash_btn_arrow_right";

    /* renamed from: h  reason: collision with root package name */
    private final String f8376h = "mbridge_splash_btn_circle";

    /* renamed from: i  reason: collision with root package name */
    private final String f8377i = "mbridge_splash_btn_finger";

    /* renamed from: j  reason: collision with root package name */
    private final String f8378j = "mbridge_splash_btn_go";

    /* renamed from: k  reason: collision with root package name */
    private final String f8379k = "mbridge_splash_btn_light";

    /* renamed from: l  reason: collision with root package name */
    private final String f8380l = "mbridge_expand_data";

    /* renamed from: m  reason: collision with root package name */
    private String f8381m;

    /* renamed from: n  reason: collision with root package name */
    private int f8382n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public ImageView f8383o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public ImageView f8384p;

    /* renamed from: q  reason: collision with root package name */
    private final RectF f8385q = new RectF();

    /* renamed from: r  reason: collision with root package name */
    private final Paint f8386r = new Paint();

    /* renamed from: s  reason: collision with root package name */
    private final Paint f8387s = new Paint();

    public MBSplashClickView(Context context) {
        super(context);
        a();
    }

    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f8385q, this.f8387s, 31);
        canvas.drawRoundRect(this.f8385q, 200.0f, 200.0f, this.f8387s);
        canvas.saveLayer(this.f8385q, this.f8386r, 31);
        super.draw(canvas);
        canvas.restore();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(java.lang.String r12) {
        /*
            r11 = this;
            r11.f8381m = r12
            r12.getClass()
            int r0 = r12.hashCode()
            java.lang.String r1 = "浏览第三方应用"
            java.lang.String r2 = "View"
            r3 = 0
            r4 = 3
            r5 = 1
            r6 = -1
            r7 = 2
            switch(r0) {
                case -672744069: goto L_0x004a;
                case 2464362: goto L_0x003f;
                case 2666181: goto L_0x0036;
                case 855294846: goto L_0x002b;
                case 1383132195: goto L_0x0020;
                case 1681333335: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            r12 = r6
            goto L_0x0054
        L_0x0017:
            boolean r12 = r12.equals(r1)
            if (r12 != 0) goto L_0x001e
            goto L_0x0015
        L_0x001e:
            r12 = 5
            goto L_0x0054
        L_0x0020:
            java.lang.String r0 = "打开第三方应用"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x0029
            goto L_0x0015
        L_0x0029:
            r12 = 4
            goto L_0x0054
        L_0x002b:
            java.lang.String r0 = "下载第三方应用"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x0034
            goto L_0x0015
        L_0x0034:
            r12 = r4
            goto L_0x0054
        L_0x0036:
            boolean r12 = r12.equals(r2)
            if (r12 != 0) goto L_0x003d
            goto L_0x0015
        L_0x003d:
            r12 = r7
            goto L_0x0054
        L_0x003f:
            java.lang.String r0 = "Open"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x0048
            goto L_0x0015
        L_0x0048:
            r12 = r5
            goto L_0x0054
        L_0x004a:
            java.lang.String r0 = "Install"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x0053
            goto L_0x0015
        L_0x0053:
            r12 = r3
        L_0x0054:
            switch(r12) {
                case 0: goto L_0x0086;
                case 1: goto L_0x0083;
                case 2: goto L_0x0080;
                case 3: goto L_0x0086;
                case 4: goto L_0x0083;
                case 5: goto L_0x0080;
                default: goto L_0x0057;
            }
        L_0x0057:
            android.content.Context r12 = r11.getContext()
            android.content.res.Resources r12 = r12.getResources()
            android.content.res.Configuration r12 = r12.getConfiguration()
            java.util.Locale r12 = r12.locale
            java.lang.String r12 = r12.getLanguage()
            java.lang.String r0 = "zh"
            boolean r12 = r12.contains(r0)
            java.lang.String r0 = r11.f8381m
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x007d
            if (r12 == 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r1 = r2
        L_0x007b:
            r11.f8381m = r1
        L_0x007d:
            r11.f8382n = r7
            goto L_0x0088
        L_0x0080:
            r11.f8382n = r7
            goto L_0x0088
        L_0x0083:
            r11.f8382n = r5
            goto L_0x0088
        L_0x0086:
            r11.f8382n = r4
        L_0x0088:
            android.view.ViewParent r12 = r11.getParent()
            android.view.ViewGroup r12 = (android.view.ViewGroup) r12
            if (r12 == 0) goto L_0x00a7
            java.lang.String r0 = "mbridge_expand_data"
            android.view.View r12 = r11.a(r12, r0)
            if (r12 == 0) goto L_0x00a7
            boolean r0 = r12 instanceof android.widget.TextView
            if (r0 == 0) goto L_0x00a7
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.CharSequence r12 = r12.getText()
            java.lang.String r12 = r12.toString()
            goto L_0x00a9
        L_0x00a7:
            java.lang.String r12 = ""
        L_0x00a9:
            int r0 = r11.f8382n
            java.lang.String r1 = "#666666"
            int r1 = android.graphics.Color.parseColor(r1)
            java.lang.String r2 = "#8FC31F"
            int r2 = android.graphics.Color.parseColor(r2)
            java.lang.String r8 = "#000000"
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.drawable.GradientDrawable r9 = new android.graphics.drawable.GradientDrawable
            r9.<init>()
            if (r0 != r7) goto L_0x00c8
            r9.setColor(r2)
            goto L_0x00ce
        L_0x00c8:
            r9.setColor(r8)
            r9.setStroke(r7, r1)
        L_0x00ce:
            r0 = 200(0xc8, float:2.8E-43)
            float r0 = (float) r0
            r9.setCornerRadius(r0)
            r11.setBackground(r9)
            android.widget.TextView r0 = new android.widget.TextView
            android.content.Context r1 = r11.getContext()
            r0.<init>(r1)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r6, r6)
            r2 = 15
            r1.addRule(r2)
            r0.setLayoutParams(r1)
            r1 = 17
            r0.setGravity(r1)
            r1 = 1101004800(0x41a00000, float:20.0)
            r0.setTextSize(r1)
            r0.setTextColor(r6)
            java.lang.String r1 = r11.f8381m
            r0.setText(r1)
            android.widget.ImageView r1 = new android.widget.ImageView
            android.content.Context r8 = r11.getContext()
            r1.<init>(r8)
            r11.f8383o = r1
            int r1 = r11.f8382n
            r8 = 11
            java.lang.String r9 = "drawable"
            if (r1 != r7) goto L_0x014f
            android.content.res.Resources r1 = r11.getResources()
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r3 = r3.g()
            java.lang.String r4 = "mbridge_splash_btn_go"
            int r3 = r1.getIdentifier(r4, r9, r3)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            android.content.Context r4 = r11.getContext()
            r5 = 1108082688(0x420c0000, float:35.0)
            int r4 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r4, (float) r5)
            android.content.Context r6 = r11.getContext()
            int r5 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r6, (float) r5)
            r1.<init>(r4, r5)
            r1.addRule(r8)
            r1.addRule(r2)
            android.content.Context r2 = r11.getContext()
            r4 = 1092616192(0x41200000, float:10.0)
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r2, (float) r4)
            r1.rightMargin = r2
            goto L_0x0253
        L_0x014f:
            r7 = 1112014848(0x42480000, float:50.0)
            if (r1 != r5) goto L_0x01b1
            android.content.res.Resources r1 = r11.getResources()
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r3 = r3.g()
            java.lang.String r4 = "mbridge_splash_btn_light"
            int r3 = r1.getIdentifier(r4, r9, r3)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r4 = -2
            r1.<init>(r4, r6)
            r5 = 20
            r1.leftMargin = r5
            r1.rightMargin = r5
            android.widget.ImageView r5 = new android.widget.ImageView
            android.content.Context r10 = r11.getContext()
            r5.<init>(r10)
            android.widget.RelativeLayout$LayoutParams r10 = new android.widget.RelativeLayout$LayoutParams
            r10.<init>(r4, r6)
            r10.addRule(r8)
            r10.addRule(r2)
            android.content.Context r2 = r11.getContext()
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r2, (float) r7)
            r10.rightMargin = r2
            android.content.res.Resources r2 = r11.getResources()
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r4 = r4.g()
            java.lang.String r6 = "mbridge_splash_btn_arrow_right"
            int r2 = r2.getIdentifier(r6, r9, r4)
            r5.setImageResource(r2)
            android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.CENTER
            r5.setScaleType(r2)
            r5.setLayoutParams(r10)
            r11.addView(r5)
            goto L_0x0253
        L_0x01b1:
            if (r1 != r4) goto L_0x0252
            android.content.res.Resources r1 = r11.getResources()
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r2 = r2.g()
            java.lang.String r3 = "mbridge_splash_btn_finger"
            int r3 = r1.getIdentifier(r3, r9, r2)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            android.content.Context r2 = r11.getContext()
            r4 = 1103626240(0x41c80000, float:25.0)
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r2, (float) r4)
            android.content.Context r5 = r11.getContext()
            int r4 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r5, (float) r4)
            r1.<init>(r2, r4)
            r1.addRule(r8)
            android.content.Context r2 = r11.getContext()
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r2, (float) r7)
            r1.rightMargin = r2
            android.content.Context r2 = r11.getContext()
            r4 = 1099956224(0x41900000, float:18.0)
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r2, (float) r4)
            r1.topMargin = r2
            android.widget.ImageView r2 = new android.widget.ImageView
            android.content.Context r4 = r11.getContext()
            r2.<init>(r4)
            r11.f8384p = r2
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            android.content.Context r4 = r11.getContext()
            r5 = 1106247680(0x41f00000, float:30.0)
            int r4 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r4, (float) r5)
            android.content.Context r6 = r11.getContext()
            int r5 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r6, (float) r5)
            r2.<init>(r4, r5)
            r2.addRule(r8)
            android.content.Context r4 = r11.getContext()
            int r4 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r4, (float) r7)
            r2.rightMargin = r4
            android.content.Context r4 = r11.getContext()
            r5 = 1084227584(0x40a00000, float:5.0)
            int r4 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r4, (float) r5)
            r2.topMargin = r4
            android.widget.ImageView r4 = r11.f8384p
            r4.setLayoutParams(r2)
            android.content.res.Resources r2 = r11.getResources()
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r4 = r4.g()
            java.lang.String r5 = "mbridge_splash_btn_circle"
            int r2 = r2.getIdentifier(r5, r9, r4)
            android.widget.ImageView r4 = r11.f8384p
            r4.setImageResource(r2)
            android.widget.ImageView r2 = r11.f8384p
            r11.addView(r2)
            goto L_0x0253
        L_0x0252:
            r1 = 0
        L_0x0253:
            android.widget.ImageView r2 = r11.f8383o
            r2.setLayoutParams(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            if (r1 == 0) goto L_0x0264
            android.widget.ImageView r12 = r11.f8383o
            r12.setImageResource(r3)
            goto L_0x0296
        L_0x0264:
            android.widget.ImageView r1 = r11.f8383o
            if (r1 != 0) goto L_0x0269
            goto L_0x0296
        L_0x0269:
            boolean r2 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0273 }
            if (r2 == 0) goto L_0x0275
            r1.setBackgroundResource(r3)     // Catch:{ Exception -> 0x0273 }
            goto L_0x0275
        L_0x0273:
            r12 = move-exception
            goto L_0x028a
        L_0x0275:
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0273 }
            android.content.Context r2 = r2.c()     // Catch:{ Exception -> 0x0273 }
            com.mbridge.msdk.foundation.same.c.b r2 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r2)     // Catch:{ Exception -> 0x0273 }
            com.mbridge.msdk.dycreator.baseview.MBSplashClickView$4 r4 = new com.mbridge.msdk.dycreator.baseview.MBSplashClickView$4     // Catch:{ Exception -> 0x0273 }
            r4.<init>(r1, r3)     // Catch:{ Exception -> 0x0273 }
            r2.a(r12, r4)     // Catch:{ Exception -> 0x0273 }
            goto L_0x0296
        L_0x028a:
            java.lang.String r2 = "MBSplashClickView"
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r12)
            r1.setBackgroundResource(r3)
        L_0x0296:
            r11.addView(r0)
            android.widget.ImageView r12 = r11.f8383o
            r11.addView(r12)
            r11.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.initView(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i5 = this.f8382n;
        if (i5 == 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.f8383o.startAnimation(scaleAnimation);
        } else if (i5 == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(final Animation animation) {
                    MBSplashClickView.this.f8383o.setVisibility(4);
                    MBSplashClickView.this.f8383o.postDelayed(new Runnable() {
                        public void run() {
                            MBSplashClickView.this.f8383o.startAnimation(animation);
                        }
                    }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f8383o.setVisibility(0);
                }
            });
            this.f8383o.startAnimation(translateAnimation);
        } else if (i5 == 3) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(1000);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            final ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(400);
            scaleAnimation3.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    MBSplashClickView.this.f8384p.setVisibility(4);
                    MBSplashClickView.this.f8384p.postDelayed(new Runnable() {
                        public void run() {
                            MBSplashClickView.this.f8384p.startAnimation(scaleAnimation3);
                        }
                    }, 1600);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f8384p.setVisibility(0);
                }
            });
            this.f8384p.setVisibility(4);
            this.f8383o.startAnimation(scaleAnimation2);
            this.f8384p.postDelayed(new Runnable() {
                public void run() {
                    MBSplashClickView.this.f8384p.startAnimation(scaleAnimation3);
                }
            }, 800);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        this.f8385q.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    private void a() {
        this.f8386r.setAntiAlias(true);
        this.f8386r.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f8387s.setAntiAlias(true);
        this.f8387s.setColor(-1);
    }

    private View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (viewGroup.getId() == str.hashCode()) {
                        return viewGroup;
                    }
                    int childCount = viewGroup.getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = viewGroup.getChildAt(i5);
                        if (childAt.getId() == str.hashCode()) {
                            return childAt;
                        }
                        if (childAt instanceof ViewGroup) {
                            a((ViewGroup) childAt, str);
                        }
                    }
                    return null;
                }
            } catch (Exception e5) {
                af.b("MBSplashClickView", e5.getMessage());
            }
        }
        return null;
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        a();
    }
}
