package androidx.window.layout;

import android.graphics.Rect;
import androidx.annotation.RestrictTo;
import androidx.window.core.Bounds;
import kotlin.jvm.internal.t;

public final class WindowMetrics {
    private final Bounds _bounds;

    public WindowMetrics(Bounds bounds) {
        t.e(bounds, "_bounds");
        this._bounds = bounds;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.a(WindowMetrics.class, obj.getClass())) {
            return false;
        }
        return t.a(this._bounds, ((WindowMetrics) obj)._bounds);
    }

    public final Rect getBounds() {
        return this._bounds.toRect();
    }

    public int hashCode() {
        return this._bounds.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + getBounds() + " }";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.TESTS})
    public WindowMetrics(Rect rect) {
        this(new Bounds(rect));
        t.e(rect, "bounds");
    }
}
