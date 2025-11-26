package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.jvm.internal.C2633k;

public final class BackEventCompat {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final int EDGE_LEFT = 0;
    public static final int EDGE_RIGHT = 1;
    private final float progress;
    private final int swipeEdge;
    private final float touchX;
    private final float touchY;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    @Target({ElementType.TYPE_USE})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SwipeEdge {
    }

    @VisibleForTesting
    public BackEventCompat(float f5, float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, int i5) {
        this.touchX = f5;
        this.touchY = f6;
        this.progress = f7;
        this.swipeEdge = i5;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final int getSwipeEdge() {
        return this.swipeEdge;
    }

    public final float getTouchX() {
        return this.touchX;
    }

    public final float getTouchY() {
        return this.touchY;
    }

    @RequiresApi(34)
    public final BackEvent toBackEvent() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.INSTANCE.createOnBackEvent(this.touchX, this.touchY, this.progress, this.swipeEdge);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 34+");
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + '}';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RequiresApi(34)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BackEventCompat(android.window.BackEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "backEvent"
            kotlin.jvm.internal.t.e(r5, r0)
            androidx.activity.Api34Impl r0 = androidx.activity.Api34Impl.INSTANCE
            float r1 = r0.touchX(r5)
            float r2 = r0.touchY(r5)
            float r3 = r0.progress(r5)
            int r5 = r0.swipeEdge(r5)
            r4.<init>(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.BackEventCompat.<init>(android.window.BackEvent):void");
    }
}
