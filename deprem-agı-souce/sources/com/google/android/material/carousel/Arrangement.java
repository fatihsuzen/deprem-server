package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    public Arrangement(int i5, float f5, float f6, float f7, int i6, float f8, int i7, float f9, int i8, float f10) {
        this.priority = i5;
        this.smallSize = MathUtils.clamp(f5, f6, f7);
        this.smallCount = i6;
        this.mediumSize = f8;
        this.mediumCount = i7;
        this.largeSize = f9;
        this.largeCount = i8;
        fit(f10, f6, f7, f9);
        this.cost = cost(f9);
    }

    private float calculateLargeSize(float f5, int i5, float f6, int i6, int i7) {
        if (i5 <= 0) {
            f6 = 0.0f;
        }
        float f7 = ((float) i6) / 2.0f;
        return (f5 - ((((float) i5) + f7) * f6)) / (((float) i7) + f7);
    }

    private float cost(float f5) {
        if (!isValid()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f5 - this.largeSize) * ((float) this.priority);
    }

    @Nullable
    public static Arrangement findLowestCostArrangement(float f5, float f6, float f7, float f8, @NonNull int[] iArr, float f9, @NonNull int[] iArr2, float f10, @NonNull int[] iArr3) {
        int[] iArr4 = iArr;
        int[] iArr5 = iArr2;
        Arrangement arrangement = null;
        int i5 = 1;
        for (int i6 : iArr3) {
            int length = iArr5.length;
            int i7 = 0;
            while (i7 < length) {
                int i8 = iArr5[i7];
                int length2 = iArr4.length;
                int i9 = 0;
                while (i9 < length2) {
                    int i10 = i7;
                    int i11 = i5;
                    int i12 = i10;
                    int i13 = length2;
                    int i14 = i9;
                    int i15 = length;
                    Arrangement arrangement2 = new Arrangement(i11, f6, f7, f8, iArr4[i9], f9, i8, f10, i6, f5);
                    if (arrangement == null || arrangement2.cost < arrangement.cost) {
                        if (arrangement2.cost == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    int i16 = i11 + 1;
                    i9 = i14 + 1;
                    i7 = i12;
                    i5 = i16;
                    length = i15;
                    length2 = i13;
                }
                int i17 = i7;
                int i18 = i5;
                int i19 = i17;
                int i20 = length;
                int i21 = i18;
                i7 = i19 + 1;
                i5 = i21;
                length = i20;
            }
        }
        return arrangement;
    }

    private void fit(float f5, float f6, float f7, float f8) {
        float f9;
        float space = f5 - getSpace();
        int i5 = this.smallCount;
        if (i5 > 0 && space > 0.0f) {
            float f10 = this.smallSize;
            this.smallSize = f10 + Math.min(space / ((float) i5), f7 - f10);
        } else if (i5 > 0 && space < 0.0f) {
            float f11 = this.smallSize;
            this.smallSize = f11 + Math.max(space / ((float) i5), f6 - f11);
        }
        int i6 = this.smallCount;
        if (i6 > 0) {
            f9 = this.smallSize;
        } else {
            f9 = 0.0f;
        }
        this.smallSize = f9;
        float calculateLargeSize = calculateLargeSize(f5, i6, f9, this.mediumCount, this.largeCount);
        this.largeSize = calculateLargeSize;
        float f12 = (this.smallSize + calculateLargeSize) / 2.0f;
        this.mediumSize = f12;
        int i7 = this.mediumCount;
        if (i7 > 0 && calculateLargeSize != f8) {
            float f13 = (f8 - calculateLargeSize) * ((float) this.largeCount);
            float min = Math.min(Math.abs(f13), f12 * 0.1f * ((float) i7));
            if (f13 > 0.0f) {
                this.mediumSize -= min / ((float) this.mediumCount);
                this.largeSize += min / ((float) this.largeCount);
                return;
            }
            this.mediumSize += min / ((float) this.mediumCount);
            this.largeSize -= min / ((float) this.largeCount);
        }
    }

    private float getSpace() {
        return (this.largeSize * ((float) this.largeCount)) + (this.mediumSize * ((float) this.mediumCount)) + (this.smallSize * ((float) this.smallCount));
    }

    private boolean isValid() {
        int i5 = this.largeCount;
        if (i5 > 0 && this.smallCount > 0 && this.mediumCount > 0) {
            float f5 = this.largeSize;
            float f6 = this.mediumSize;
            if (f5 <= f6 || f6 <= this.smallSize) {
                return false;
            }
            return true;
        } else if (i5 <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public int getItemCount() {
        return this.smallCount + this.mediumCount + this.largeCount;
    }

    @NonNull
    public String toString() {
        return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
    }
}
