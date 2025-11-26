package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.x;

public class SoundImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8509a = true;

    public SoundImageView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    public boolean getStatus() {
        return this.f8509a;
    }

    public void setSoundStatus(boolean z4) {
        this.f8509a = z4;
        if (z4) {
            setImageResource(x.a(getContext(), "mbridge_reward_sound_open", "drawable"));
        } else {
            setImageResource(x.a(getContext(), "mbridge_reward_sound_close", "drawable"));
        }
    }

    public SoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SoundImageView(Context context) {
        super(context);
    }
}
