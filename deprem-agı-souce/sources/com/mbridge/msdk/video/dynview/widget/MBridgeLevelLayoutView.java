package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.x;

public class MBridgeLevelLayoutView extends LinearLayout {

    /* renamed from: d  reason: collision with root package name */
    private static int f12262d = 18;

    /* renamed from: a  reason: collision with root package name */
    private double f12263a;

    /* renamed from: b  reason: collision with root package name */
    private int f12264b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12265c;

    public MBridgeLevelLayoutView(Context context) {
        super(context);
    }

    private void a() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        if (this.f12265c) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, dip2px(getContext(), (float) f12262d));
            linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(layoutParams);
        } else {
            linearLayout2 = null;
            linearLayout = null;
        }
        removeAllViews();
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, dip2px(getContext(), (float) f12262d));
            TextView textView = new TextView(getContext());
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setText("(");
            textView.setTextColor(Color.parseColor("#5f5f5f"));
            TextView textView2 = new TextView(getContext());
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            textView2.setGravity(17);
            textView2.setTextColor(Color.parseColor("#5f5f5f"));
            Drawable drawable = getResources().getDrawable(x.a(getContext(), "mbridge_reward_user", "drawable"));
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            textView2.setText(this.f12264b + " )");
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setLines(1);
            linearLayout.addView(textView, layoutParams2);
            linearLayout.addView(textView2, layoutParams2);
        }
        double d5 = this.f12263a;
        if (d5 == 0.0d) {
            d5 = 5.0d;
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dip2px(getContext(), 15.0f), dip2px(getContext(), (float) f12262d));
            if (((double) i5) < d5) {
                imageView.setImageResource(x.a(getContext(), "mbridge_download_message_dialog_star_sel", "drawable"));
            } else {
                imageView.setImageResource(x.a(getContext(), "mbridge_download_message_dilaog_star_nor", "drawable"));
            }
            layoutParams3.weight = 1.0f;
            layoutParams3.setMargins(dip2px(getContext(), 2.0f), 0, 0, 0);
            if (linearLayout2 != null) {
                linearLayout2.addView(imageView, layoutParams3);
            } else {
                addView(imageView, layoutParams3);
            }
        }
        if (linearLayout2 != null) {
            addView(linearLayout2);
            addView(linearLayout);
        }
    }

    public static int dip2px(Context context, float f5) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f5 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public void setRating(int i5) {
        this.f12263a = (double) i5;
        a();
    }

    public void setRatingAndUser(double d5, int i5) {
        this.f12263a = d5;
        if (i5 == 0) {
            i5 = (int) (((Math.random() * 9.0d) + 1.0d) * 10000.0d);
        }
        this.f12264b = i5;
        this.f12265c = true;
        a();
    }

    public MBridgeLevelLayoutView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeLevelLayoutView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
