package androidx.window.layout;

import android.graphics.Rect;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class HardwareFoldingFeature implements FoldingFeature {
    public static final Companion Companion = new Companion((C2633k) null);
    private final Bounds featureBounds;
    private final FoldingFeature.State state;
    private final Type type;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final void validateFeatureBounds$window_release(Bounds bounds) {
            t.e(bounds, "bounds");
            if (bounds.getWidth() == 0 && bounds.getHeight() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero");
            } else if (bounds.getLeft() != 0 && bounds.getTop() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
            }
        }

        private Companion() {
        }
    }

    public static final class Type {
        public static final Companion Companion = new Companion((C2633k) null);
        /* access modifiers changed from: private */
        public static final Type FOLD = new Type("FOLD");
        /* access modifiers changed from: private */
        public static final Type HINGE = new Type("HINGE");
        private final String description;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final Type getFOLD() {
                return Type.FOLD;
            }

            public final Type getHINGE() {
                return Type.HINGE;
            }

            private Companion() {
            }
        }

        private Type(String str) {
            this.description = str;
        }

        public String toString() {
            return this.description;
        }
    }

    public HardwareFoldingFeature(Bounds bounds, Type type2, FoldingFeature.State state2) {
        t.e(bounds, "featureBounds");
        t.e(type2, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        t.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
        this.featureBounds = bounds;
        this.type = type2;
        this.state = state2;
        Companion.validateFeatureBounds$window_release(bounds);
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
        if (!t.a(HardwareFoldingFeature.class, cls)) {
            return false;
        }
        if (obj != null) {
            HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) obj;
            if (t.a(this.featureBounds, hardwareFoldingFeature.featureBounds) && t.a(this.type, hardwareFoldingFeature.type) && t.a(getState(), hardwareFoldingFeature.getState())) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
    }

    public Rect getBounds() {
        return this.featureBounds.toRect();
    }

    public FoldingFeature.OcclusionType getOcclusionType() {
        if (this.featureBounds.getWidth() == 0 || this.featureBounds.getHeight() == 0) {
            return FoldingFeature.OcclusionType.NONE;
        }
        return FoldingFeature.OcclusionType.FULL;
    }

    public FoldingFeature.Orientation getOrientation() {
        if (this.featureBounds.getWidth() > this.featureBounds.getHeight()) {
            return FoldingFeature.Orientation.HORIZONTAL;
        }
        return FoldingFeature.Orientation.VERTICAL;
    }

    public FoldingFeature.State getState() {
        return this.state;
    }

    public final Type getType$window_release() {
        return this.type;
    }

    public int hashCode() {
        return (((this.featureBounds.hashCode() * 31) + this.type.hashCode()) * 31) + getState().hashCode();
    }

    public boolean isSeparating() {
        Type type2 = this.type;
        Type.Companion companion = Type.Companion;
        if (t.a(type2, companion.getHINGE())) {
            return true;
        }
        if (!t.a(this.type, companion.getFOLD()) || !t.a(getState(), FoldingFeature.State.HALF_OPENED)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return HardwareFoldingFeature.class.getSimpleName() + " { " + this.featureBounds + ", type=" + this.type + ", state=" + getState() + " }";
    }
}
