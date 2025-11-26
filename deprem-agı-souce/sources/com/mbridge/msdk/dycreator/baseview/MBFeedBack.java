package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.widget.FeedBackButton;

public class MBFeedBack extends MBTextView {
    public static String FEEDBACK_BTN_BACKGROUND_COLOR_STR = "#60000000";

    public MBFeedBack(Context context) {
        super(context);
        a();
    }

    private void a() {
        setText(x.a(getContext(), "mbridge_cm_feedback_btn_text", TypedValues.Custom.S_STRING));
        Context context = getContext();
        int a5 = ak.a(context, 13.0f);
        setPadding(a5, 0, a5, 0);
        setTextIsSelectable(false);
        setGravity(17);
        setBackgroundColor(Color.parseColor(FEEDBACK_BTN_BACKGROUND_COLOR_STR));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) ak.a(context, 20.0f));
        gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
        setBackground(gradientDrawable);
        setTextColor(-1);
    }

    public MBFeedBack(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MBFeedBack(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        a();
    }
}
