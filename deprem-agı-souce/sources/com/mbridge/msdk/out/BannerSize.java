package com.mbridge.msdk.out;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ab;

public class BannerSize {
    public static final int DEV_SET_TYPE = 5;
    public static final int LARGE_TYPE = 1;
    public static final int MEDIUM_TYPE = 2;
    public static final int SMART_TYPE = 3;
    public static final int STANDARD_TYPE = 4;
    private int height;
    private int width;

    public BannerSize(int i5, int i6, int i7) {
        if (i5 == 1) {
            this.height = 90;
            this.width = 320;
        } else if (i5 == 2) {
            this.height = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
            this.width = MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION;
        } else if (i5 == 3) {
            setSmartMode();
        } else if (i5 == 4) {
            this.height = 50;
            this.width = 320;
        } else if (i5 == 5) {
            this.height = i7;
            this.width = i6;
        }
    }

    private void setSmartMode() {
        if (ab.h(c.m().c()) < 720) {
            this.height = 50;
            this.width = 320;
            return;
        }
        this.height = 90;
        this.width = 728;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
