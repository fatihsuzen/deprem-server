package com.mbridge.msdk.widget;

import android.view.View;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Calendar;

public abstract class a implements View.OnClickListener {
    public static final int MIN_CLICK_DELAY_TIME = 2000;
    private long lastClickTime = 0;

    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.lastClickTime > AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            this.lastClickTime = timeInMillis;
            onNoDoubleClick(view);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onNoDoubleClick(View view);
}
