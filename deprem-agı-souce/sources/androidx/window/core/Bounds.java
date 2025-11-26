package androidx.window.core;

import android.graphics.Rect;
import kotlin.jvm.internal.t;

public final class Bounds {
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public Bounds(int i5, int i6, int i7, int i8) {
        this.left = i5;
        this.top = i6;
        this.right = i7;
        this.bottom = i8;
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            cls = null;
        } else {
            cls = obj.getClass();
        }
        if (!t.a(Bounds.class, cls)) {
            return false;
        }
        if (obj != null) {
            Bounds bounds = (Bounds) obj;
            if (this.left == bounds.left && this.top == bounds.top && this.right == bounds.right && this.bottom == bounds.bottom) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public final boolean isEmpty() {
        if (getHeight() == 0 || getWidth() == 0) {
            return true;
        }
        return false;
    }

    public final boolean isZero() {
        if (getHeight() == 0 && getWidth() == 0) {
            return true;
        }
        return false;
    }

    public final Rect toRect() {
        return new Rect(this.left, this.top, this.right, this.bottom);
    }

    public String toString() {
        return Bounds.class.getSimpleName() + " { [" + this.left + ',' + this.top + ',' + this.right + ',' + this.bottom + "] }";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Bounds(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        t.e(rect, "rect");
    }
}
