package androidx.graphics.shapes;

import kotlin.jvm.internal.t;

public final class ProgressableFeature {
    private final Feature feature;
    private final float progress;

    public ProgressableFeature(float f5, Feature feature2) {
        t.e(feature2, "feature");
        this.progress = f5;
        this.feature = feature2;
    }

    public static /* synthetic */ ProgressableFeature copy$default(ProgressableFeature progressableFeature, float f5, Feature feature2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = progressableFeature.progress;
        }
        if ((i5 & 2) != 0) {
            feature2 = progressableFeature.feature;
        }
        return progressableFeature.copy(f5, feature2);
    }

    public final float component1() {
        return this.progress;
    }

    public final Feature component2() {
        return this.feature;
    }

    public final ProgressableFeature copy(float f5, Feature feature2) {
        t.e(feature2, "feature");
        return new ProgressableFeature(f5, feature2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressableFeature)) {
            return false;
        }
        ProgressableFeature progressableFeature = (ProgressableFeature) obj;
        return Float.compare(this.progress, progressableFeature.progress) == 0 && t.a(this.feature, progressableFeature.feature);
    }

    public final Feature getFeature() {
        return this.feature;
    }

    public final float getProgress() {
        return this.progress;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.progress) * 31) + this.feature.hashCode();
    }

    public String toString() {
        return "ProgressableFeature(progress=" + this.progress + ", feature=" + this.feature + ')';
    }
}
