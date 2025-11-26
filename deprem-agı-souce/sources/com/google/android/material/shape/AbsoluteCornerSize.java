package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

public final class AbsoluteCornerSize implements CornerSize {
    private final float size;

    public AbsoluteCornerSize(float f5) {
        this.size = f5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AbsoluteCornerSize) && this.size == ((AbsoluteCornerSize) obj).size) {
            return true;
        }
        return false;
    }

    public float getCornerSize(@NonNull RectF rectF) {
        return this.size;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.size)});
    }

    public String toString() {
        return getCornerSize() + "px";
    }

    public float getCornerSize() {
        return this.size;
    }
}
