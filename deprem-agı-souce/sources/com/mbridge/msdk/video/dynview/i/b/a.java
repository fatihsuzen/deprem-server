package com.mbridge.msdk.video.dynview.i.b;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.mbridge.msdk.foundation.tools.ak;

public final class a {
    public static void a(View view, float f5, float f6, String str, String[] strArr, GradientDrawable.Orientation orientation) {
        if (view != null && strArr != null) {
            int[] iArr = new int[strArr.length];
            for (int i5 = 0; i5 < strArr.length; i5++) {
                iArr[i5] = Color.parseColor(strArr[i5]);
            }
            GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
            gradientDrawable.setCornerRadius((float) ak.a(view.getContext(), f6));
            gradientDrawable.setStroke(ak.a(view.getContext(), f5), Color.parseColor(str));
            view.setBackground(gradientDrawable);
        }
    }
}
