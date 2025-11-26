package com.mbridge.msdk.videocommon.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.tools.x;

public class StarLevelView extends LinearLayout {
    public StarLevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }

    public void initScore(double d5) {
        for (int i5 = 0; i5 < ((int) d5); i5++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(x.a(getContext(), "mbridge_video_common_full_star", "drawable"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i5 != 0) {
                layoutParams.setMargins(5, 0, 5, 0);
            }
            addView(imageView, layoutParams);
        }
        int i6 = (int) (50.0d - (d5 * 10.0d));
        if (i6 > 0) {
            if (i6 > 1 && i6 < 10) {
                if (i6 <= 0 || i6 >= 5) {
                    ImageView imageView2 = new ImageView(getContext());
                    imageView2.setImageResource(x.a(getContext(), "mbridge_video_common_full_star", "drawable"));
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(5, 0, 5, 0);
                    addView(imageView2, layoutParams2);
                } else {
                    ImageView imageView3 = new ImageView(getContext());
                    imageView3.setImageResource(x.a(getContext(), "mbridge_video_common_full_star", "drawable"));
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.setMargins(5, 0, 5, 0);
                    addView(imageView3, layoutParams3);
                }
            }
            int i7 = i6 / 10;
            if (i7 >= 1) {
                int i8 = i6 % (i7 * 10);
                if (i8 > 0 && i8 < 5) {
                    ImageView imageView4 = new ImageView(getContext());
                    imageView4.setImageResource(x.a(getContext(), "mbridge_video_common_full_while_star", "drawable"));
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams4.setMargins(5, 0, 5, 0);
                    addView(imageView4, layoutParams4);
                } else if (i8 >= 5 && i8 <= 9) {
                    ImageView imageView5 = new ImageView(getContext());
                    imageView5.setImageResource(x.a(getContext(), "mbridge_video_common_half_star", "drawable"));
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams5.setMargins(5, 0, 5, 0);
                    addView(imageView5, layoutParams5);
                }
                for (int i9 = 0; i9 < i7; i9++) {
                    ImageView imageView6 = new ImageView(getContext());
                    imageView6.setImageResource(x.a(getContext(), "mbridge_video_common_full_while_star", "drawable"));
                    LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams6.setMargins(5, 0, 5, 0);
                    addView(imageView6, layoutParams6);
                }
            }
        }
    }

    public StarLevelView(Context context) {
        super(context);
        setOrientation(0);
    }

    @SuppressLint({"NewApi"})
    public StarLevelView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        setOrientation(0);
    }
}
