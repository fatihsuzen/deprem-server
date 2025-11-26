package androidx.window.embedding;

import android.graphics.Rect;
import android.os.Build;
import android.view.WindowMetrics;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.window.core.ExperimentalWindowApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@ExperimentalWindowApi
public class SplitRule extends EmbeddingRule {
    private final int layoutDirection;
    private final int minSmallestWidth;
    private final int minWidth;
    private final float splitRatio;

    @RequiresApi(30)
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        @DoNotInline
        public final Rect getBounds(WindowMetrics windowMetrics) {
            t.e(windowMetrics, "windowMetrics");
            Rect bounds = windowMetrics.getBounds();
            t.d(bounds, "windowMetrics.bounds");
            return bounds;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutDir {
    }

    public SplitRule() {
        this(0, 0, 0.0f, 0, 15, (C2633k) null);
    }

    public final boolean checkParentMetrics(WindowMetrics windowMetrics) {
        boolean z4;
        boolean z5;
        t.e(windowMetrics, "parentMetrics");
        if (Build.VERSION.SDK_INT <= 30) {
            return false;
        }
        Rect bounds = Api30Impl.INSTANCE.getBounds(windowMetrics);
        if (this.minWidth == 0 || bounds.width() >= this.minWidth) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.minSmallestWidth == 0 || Math.min(bounds.width(), bounds.height()) >= this.minSmallestWidth) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z4 || !z5) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitRule)) {
            return false;
        }
        SplitRule splitRule = (SplitRule) obj;
        if (this.minWidth == splitRule.minWidth && this.minSmallestWidth == splitRule.minSmallestWidth && this.splitRatio == splitRule.splitRatio && this.layoutDirection == splitRule.layoutDirection) {
            return true;
        }
        return false;
    }

    public final int getLayoutDirection() {
        return this.layoutDirection;
    }

    public final int getMinSmallestWidth() {
        return this.minSmallestWidth;
    }

    public final int getMinWidth() {
        return this.minWidth;
    }

    public final float getSplitRatio() {
        return this.splitRatio;
    }

    public int hashCode() {
        return (((((this.minWidth * 31) + this.minSmallestWidth) * 31) + Float.floatToIntBits(this.splitRatio)) * 31) + this.layoutDirection;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SplitRule(int i5, int i6, float f5, int i7, int i8, C2633k kVar) {
        this((i8 & 1) != 0 ? 0 : i5, (i8 & 2) != 0 ? 0 : i6, (i8 & 4) != 0 ? 0.5f : f5, (i8 & 8) != 0 ? 3 : i7);
    }

    public SplitRule(int i5, int i6, float f5, int i7) {
        this.minWidth = i5;
        this.minSmallestWidth = i6;
        this.splitRatio = f5;
        this.layoutDirection = i7;
    }
}
