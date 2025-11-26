package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.x;

public class MBHeatLevelLayoutView extends MBLinearLayout {
    public MBHeatLevelLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setHeatCount(int i5) {
        try {
            removeAllViews();
            double a5 = c.a((double) i5, 10000.0d, 2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, c.a(getContext(), 30.0f));
            layoutParams.setMargins(15, 0, 0, 0);
            TextView textView = new TextView(getContext());
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setGravity(17);
            textView.setTextColor(Color.parseColor("#FF000000"));
            textView.setTextSize(10.0f);
            Drawable drawable = getResources().getDrawable(x.a(getContext(), "mbridge_reward_user", "drawable"));
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            textView.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            int identifier = getResources().getIdentifier("mbridge_reward_heat_count_unit", TypedValues.Custom.S_STRING, com.mbridge.msdk.foundation.controller.c.m().g());
            textView.setText(a5 + getResources().getString(identifier));
            addView(textView, layoutParams);
        } catch (Exception e5) {
            af.b("MBHeatLevelLayoutView", e5.getMessage());
        }
    }
}
