package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MBSplashShakeView extends MBLinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f8399a = "浏览第三方应用";

    /* renamed from: b  reason: collision with root package name */
    private final String f8400b = "View";

    /* renamed from: c  reason: collision with root package name */
    private final String f8401c = "打开第三方应用";

    /* renamed from: d  reason: collision with root package name */
    private final String f8402d = "Open";

    /* renamed from: e  reason: collision with root package name */
    private final String f8403e = "下载第三方应用";

    /* renamed from: f  reason: collision with root package name */
    private final String f8404f = "Install";

    /* renamed from: g  reason: collision with root package name */
    private ImageView f8405g;

    /* renamed from: h  reason: collision with root package name */
    private Animation f8406h;

    public MBSplashShakeView(Context context) {
        super(context);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0111, code lost:
        if (r10.equals("Open") == false) goto L_0x00e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 1
            r9.setOrientation(r0)
            r9.setGravity(r0)
            android.widget.ImageView r1 = new android.widget.ImageView
            android.content.Context r2 = r9.getContext()
            r1.<init>(r2)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            android.content.Context r3 = r9.getContext()
            r4 = 1117782016(0x42a00000, float:80.0)
            int r3 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r3, (float) r4)
            android.content.Context r5 = r9.getContext()
            int r4 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r5, (float) r4)
            r2.<init>(r3, r4)
            r1.setLayoutParams(r2)
            java.lang.String r2 = "#60000000"
            int r2 = android.graphics.Color.parseColor(r2)
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r3.setColor(r2)
            r2 = 200(0xc8, float:2.8E-43)
            float r2 = (float) r2
            r3.setCornerRadius(r2)
            r1.setBackground(r3)
            android.widget.ImageView r2 = new android.widget.ImageView
            android.content.Context r3 = r9.getContext()
            r2.<init>(r3)
            r9.f8405g = r2
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            android.content.Context r3 = r9.getContext()
            r4 = 1109393408(0x42200000, float:40.0)
            int r3 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r3, (float) r4)
            android.content.Context r5 = r9.getContext()
            int r4 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r5, (float) r4)
            r2.<init>(r3, r4)
            r3 = 17
            r2.gravity = r3
            android.widget.ImageView r4 = r9.f8405g
            r4.setLayoutParams(r2)
            android.content.res.Resources r2 = r9.getResources()
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r4 = r4.g()
            java.lang.String r5 = "mbridge_cm_btn_shake"
            java.lang.String r6 = "drawable"
            int r2 = r2.getIdentifier(r5, r6, r4)
            android.widget.ImageView r4 = r9.f8405g
            r4.setImageResource(r2)
            android.widget.FrameLayout r2 = new android.widget.FrameLayout
            android.content.Context r4 = r9.getContext()
            r2.<init>(r4)
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r5 = -2
            r4.<init>(r5, r5)
            r2.setLayoutParams(r4)
            r2.addView(r1)
            android.widget.ImageView r1 = r9.f8405g
            r2.addView(r1)
            android.widget.TextView r1 = new android.widget.TextView
            android.content.Context r4 = r9.getContext()
            r1.<init>(r4)
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r4.<init>(r5, r5)
            android.content.Context r6 = r9.getContext()
            r7 = 1092616192(0x41200000, float:10.0)
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r6, (float) r7)
            r4.topMargin = r6
            r1.setLayoutParams(r4)
            r1.setGravity(r3)
            java.lang.String r4 = "Shake your phone"
            r1.setText(r4)
            r4 = 1098907648(0x41800000, float:16.0)
            r1.setTextSize(r4)
            r4 = -1
            r1.setTextColor(r4)
            boolean r6 = android.text.TextUtils.isEmpty(r10)
            java.lang.String r7 = "浏览第三方应用"
            java.lang.String r8 = "View"
            if (r6 != 0) goto L_0x0121
            r10.getClass()
            int r6 = r10.hashCode()
            switch(r6) {
                case -672744069: goto L_0x0114;
                case 2464362: goto L_0x010b;
                case 2666181: goto L_0x0102;
                case 855294846: goto L_0x00f7;
                case 1383132195: goto L_0x00ec;
                case 1681333335: goto L_0x00e3;
                default: goto L_0x00e1;
            }
        L_0x00e1:
            r0 = r4
            goto L_0x011e
        L_0x00e3:
            boolean r0 = r10.equals(r7)
            if (r0 != 0) goto L_0x00ea
            goto L_0x00e1
        L_0x00ea:
            r0 = 5
            goto L_0x011e
        L_0x00ec:
            java.lang.String r0 = "打开第三方应用"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x00f5
            goto L_0x00e1
        L_0x00f5:
            r0 = 4
            goto L_0x011e
        L_0x00f7:
            java.lang.String r0 = "下载第三方应用"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x0100
            goto L_0x00e1
        L_0x0100:
            r0 = 3
            goto L_0x011e
        L_0x0102:
            boolean r0 = r10.equals(r8)
            if (r0 != 0) goto L_0x0109
            goto L_0x00e1
        L_0x0109:
            r0 = 2
            goto L_0x011e
        L_0x010b:
            java.lang.String r6 = "Open"
            boolean r6 = r10.equals(r6)
            if (r6 != 0) goto L_0x011e
            goto L_0x00e1
        L_0x0114:
            java.lang.String r0 = "Install"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x011d
            goto L_0x00e1
        L_0x011d:
            r0 = 0
        L_0x011e:
            switch(r0) {
                case 0: goto L_0x013e;
                case 1: goto L_0x013e;
                case 2: goto L_0x013e;
                case 3: goto L_0x013e;
                case 4: goto L_0x013e;
                case 5: goto L_0x013e;
                default: goto L_0x0121;
            }
        L_0x0121:
            android.content.Context r10 = r9.getContext()
            android.content.res.Resources r10 = r10.getResources()
            android.content.res.Configuration r10 = r10.getConfiguration()
            java.util.Locale r10 = r10.locale
            java.lang.String r10 = r10.getLanguage()
            java.lang.String r0 = "zh"
            boolean r10 = r10.contains(r0)
            if (r10 == 0) goto L_0x013d
            r10 = r7
            goto L_0x013e
        L_0x013d:
            r10 = r8
        L_0x013e:
            android.widget.TextView r0 = new android.widget.TextView
            android.content.Context r6 = r9.getContext()
            r0.<init>(r6)
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r6.<init>(r5, r5)
            android.content.Context r5 = r9.getContext()
            r7 = 1084227584(0x40a00000, float:5.0)
            int r5 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r5, (float) r7)
            r6.topMargin = r5
            r0.setLayoutParams(r6)
            r0.setGravity(r3)
            r0.setText(r10)
            r10 = 1094713344(0x41400000, float:12.0)
            r0.setTextSize(r10)
            r0.setTextColor(r4)
            r9.addView(r2)
            r9.addView(r1)
            r9.addView(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBSplashShakeView.initView(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8405g != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
            this.f8406h = rotateAnimation;
            rotateAnimation.setDuration(100);
            this.f8406h.setRepeatMode(2);
            this.f8406h.setRepeatCount(-1);
            this.f8405g.startAnimation(this.f8406h);
        }
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
