package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.List;

public class MBridgeSegmentsProgressBar extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f8495a = "MBridgeSegmentsProgressBar";

    /* renamed from: b  reason: collision with root package name */
    private int f8496b;

    /* renamed from: c  reason: collision with root package name */
    private int f8497c = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f8498d = 20;

    /* renamed from: e  reason: collision with root package name */
    private int f8499e = 10;

    /* renamed from: f  reason: collision with root package name */
    private int f8500f = 1;

    /* renamed from: g  reason: collision with root package name */
    private int f8501g = -1711276033;

    /* renamed from: h  reason: collision with root package name */
    private int f8502h = -1;

    /* renamed from: i  reason: collision with root package name */
    private List<ProgressBar> f8503i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private TextView f8504j;

    /* renamed from: k  reason: collision with root package name */
    private String f8505k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8506l = false;

    public MBridgeSegmentsProgressBar(Context context) {
        super(context);
    }

    private void a() {
        Drawable drawable;
        try {
            this.f8506l = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable th) {
            af.b("MBridgeSegmentsProgressBar", th.getMessage());
        }
        try {
            if (this.f8497c == 1) {
                setOrientation(1);
                if (TextUtils.isEmpty(this.f8505k)) {
                    this.f8505k = this.f8506l ? "正在播放第%s个，共%s个视频" : "The %s is playing, %s videos.";
                }
            }
            if (this.f8497c == 2) {
                setOrientation(0);
                if (TextUtils.isEmpty(this.f8505k)) {
                    this.f8505k = this.f8506l ? "广告 %s/%s" : "ADS %s/%s";
                }
            }
            this.f8503i.clear();
            removeAllViews();
            setBackground(c());
            TextView textView = new TextView(getContext());
            this.f8504j = textView;
            textView.setTextColor(-1);
            this.f8504j.setTextSize(12.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f8504j.setLayoutParams(layoutParams);
            if (this.f8497c == 1) {
                layoutParams.gravity = 5;
                TextView textView2 = this.f8504j;
                int i5 = this.f8498d;
                textView2.setPadding(i5 / 2, 15, i5 / 2, 5);
            }
            if (this.f8497c == 2) {
                this.f8504j.setGravity(16);
                TextView textView3 = this.f8504j;
                int i6 = this.f8498d;
                textView3.setPadding(i6 / 2, 0, i6 / 2, 0);
            }
            int a5 = x.a(getContext(), "mbridge_reward_video_icon", "drawable");
            if (!(a5 == 0 || (drawable = getContext().getResources().getDrawable(a5)) == null)) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f8504j.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                this.f8504j.setCompoundDrawablePadding(5);
            }
        } catch (Throwable th2) {
            af.b("MBridgeSegmentsProgressBar", th2.getMessage());
            return;
        }
        this.f8504j.setText(a(this.f8500f));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 25);
        linearLayout.setLayoutParams(layoutParams2);
        for (int i7 = 0; i7 < this.f8496b; i7++) {
            ProgressBar progressBar = new ProgressBar(getContext(), (AttributeSet) null, 16842872);
            progressBar.setMax(100);
            progressBar.setProgress(0);
            progressBar.setProgressDrawable(b());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 20, 1.0f);
            int i8 = this.f8498d;
            layoutParams3.leftMargin = i8 / 2;
            layoutParams3.rightMargin = i8 / 2;
            progressBar.setLayoutParams(layoutParams3);
            linearLayout.addView(progressBar);
            this.f8503i.add(progressBar);
        }
        int i9 = this.f8497c;
        if (i9 == 1) {
            setPadding(15, 10, 15, 25);
            addView(this.f8504j);
            addView(linearLayout);
        } else if (i9 == 2) {
            setPadding(15, 0, 15, 25);
            layoutParams2.gravity = 16;
            layoutParams2.weight = 1.0f;
            addView(linearLayout);
            addView(this.f8504j);
        } else {
            addView(linearLayout);
        }
    }

    private LayerDrawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) this.f8499e);
        gradientDrawable.setColor(this.f8501g);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius((float) this.f8499e);
        gradientDrawable2.setColor(this.f8502h);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ScaleDrawable(gradientDrawable2, 3, 1.0f, -1.0f)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908301);
        return layerDrawable;
    }

    private GradientDrawable c() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setDither(true);
        gradientDrawable.setColors(new int[]{0, 1291845632});
        return gradientDrawable;
    }

    public void dismiss() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                MBridgeSegmentsProgressBar.this.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(alphaAnimation);
    }

    public void init(int i5, int i6) {
        this.f8496b = i5;
        this.f8497c = i6;
        a();
    }

    public void setIndicatorText(String str) {
        this.f8505k = str;
    }

    public void setProgress(int i5, int i6) {
        try {
            if (this.f8503i.size() != 0) {
                if (i6 < this.f8503i.size()) {
                    this.f8503i.get(i6).setProgress(i5);
                }
                int i7 = i6 + 1;
                if (i7 > this.f8500f) {
                    this.f8500f = i7;
                    TextView textView = this.f8504j;
                    if (textView != null) {
                        textView.setText(a(i7));
                    }
                }
            }
        } catch (Throwable th) {
            af.b("MBridgeSegmentsProgressBar", th.getMessage());
        }
    }

    public void init(int i5, int i6, int i7, int i8) {
        this.f8496b = i5;
        this.f8497c = i6;
        this.f8502h = i7;
        this.f8501g = i8;
        a();
    }

    public void init(int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f8496b = i5;
        this.f8497c = i6;
        this.f8502h = i7;
        this.f8501g = i8;
        this.f8498d = i9;
        this.f8499e = i10;
        a();
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    @RequiresApi(api = 21)
    public MBridgeSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }

    private StringBuilder a(int i5) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format(this.f8505k, new Object[]{Integer.valueOf(i5), Integer.valueOf(this.f8496b)}));
            return sb;
        } catch (Throwable th) {
            sb.append(this.f8496b);
            sb.append("videos, the");
            sb.append(i5);
            sb.append(" is playing.");
            af.b("MBridgeSegmentsProgressBar", th.getMessage());
            return sb;
        }
    }
}
