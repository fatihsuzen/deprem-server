package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import kotlin.jvm.internal.C2633k;

public final class CornerRounding {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final CornerRounding Unrounded = new CornerRounding(0.0f, 0.0f, 3, (C2633k) null);
    private final float radius;
    private final float smoothing;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public CornerRounding() {
        this(0.0f, 0.0f, 3, (C2633k) null);
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    public CornerRounding(@FloatRange(from = 0.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        this.radius = f5;
        this.smoothing = f6;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CornerRounding(float f5, float f6, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? 0.0f : f5, (i5 & 2) != 0 ? 0.0f : f6);
    }
}
