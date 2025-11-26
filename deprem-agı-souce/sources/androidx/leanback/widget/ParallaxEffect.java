package androidx.leanback.widget;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.ParallaxTarget;
import java.util.ArrayList;
import java.util.List;

public abstract class ParallaxEffect {
    final List<Parallax.PropertyMarkerValue> mMarkerValues = new ArrayList(2);
    final List<ParallaxTarget> mTargets = new ArrayList(4);
    final List<Float> mTotalWeights = new ArrayList(2);
    final List<Float> mWeights = new ArrayList(2);

    static final class FloatEffect extends ParallaxEffect {
        FloatEffect() {
        }

        /* access modifiers changed from: package-private */
        public Number calculateDirectValue(Parallax parallax) {
            if (this.mMarkerValues.size() != 2) {
                throw new RuntimeException("Must use two marker values for direct mapping");
            } else if (this.mMarkerValues.get(0).getProperty() == this.mMarkerValues.get(1).getProperty()) {
                float markerValue = ((Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(0)).getMarkerValue(parallax);
                float markerValue2 = ((Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(1)).getMarkerValue(parallax);
                if (markerValue > markerValue2) {
                    float f5 = markerValue2;
                    markerValue2 = markerValue;
                    markerValue = f5;
                }
                Float f6 = ((Parallax.FloatProperty) this.mMarkerValues.get(0).getProperty()).get(parallax);
                if (f6.floatValue() < markerValue) {
                    return Float.valueOf(markerValue);
                }
                if (f6.floatValue() > markerValue2) {
                    return Float.valueOf(markerValue2);
                }
                return f6;
            } else {
                throw new RuntimeException("Marker value must use same Property for direct mapping");
            }
        }

        /* access modifiers changed from: package-private */
        public float calculateFraction(Parallax parallax) {
            float f5;
            int i5 = 0;
            int i6 = 0;
            float f6 = 0.0f;
            float f7 = 0.0f;
            while (i5 < this.mMarkerValues.size()) {
                Parallax.FloatPropertyMarkerValue floatPropertyMarkerValue = (Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(i5);
                int index = ((Parallax.FloatProperty) floatPropertyMarkerValue.getProperty()).getIndex();
                float markerValue = floatPropertyMarkerValue.getMarkerValue(parallax);
                float floatPropertyValue = parallax.getFloatPropertyValue(index);
                if (i5 == 0) {
                    if (floatPropertyValue >= markerValue) {
                        return 0.0f;
                    }
                } else if (i6 == index && f6 < markerValue) {
                    throw new IllegalStateException("marker value of same variable must be descendant order");
                } else if (floatPropertyValue == Float.MAX_VALUE) {
                    return getFractionWithWeightAdjusted((f6 - f7) / parallax.getMaxValue(), i5);
                } else {
                    if (floatPropertyValue >= markerValue) {
                        if (i6 != index) {
                            if (f7 != -3.4028235E38f) {
                                f6 += floatPropertyValue - f7;
                            } else {
                                f5 = 1.0f - ((floatPropertyValue - markerValue) / parallax.getMaxValue());
                                return getFractionWithWeightAdjusted(f5, i5);
                            }
                        }
                        f5 = (f6 - floatPropertyValue) / (f6 - markerValue);
                        return getFractionWithWeightAdjusted(f5, i5);
                    }
                }
                i5++;
                f6 = markerValue;
                i6 = index;
                f7 = floatPropertyValue;
            }
            return 1.0f;
        }
    }

    static final class IntEffect extends ParallaxEffect {
        IntEffect() {
        }

        /* access modifiers changed from: package-private */
        public Number calculateDirectValue(Parallax parallax) {
            if (this.mMarkerValues.size() != 2) {
                throw new RuntimeException("Must use two marker values for direct mapping");
            } else if (this.mMarkerValues.get(0).getProperty() == this.mMarkerValues.get(1).getProperty()) {
                int markerValue = ((Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(0)).getMarkerValue(parallax);
                int markerValue2 = ((Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(1)).getMarkerValue(parallax);
                if (markerValue > markerValue2) {
                    int i5 = markerValue2;
                    markerValue2 = markerValue;
                    markerValue = i5;
                }
                Integer num = ((Parallax.IntProperty) this.mMarkerValues.get(0).getProperty()).get(parallax);
                if (num.intValue() < markerValue) {
                    return Integer.valueOf(markerValue);
                }
                if (num.intValue() > markerValue2) {
                    return Integer.valueOf(markerValue2);
                }
                return num;
            } else {
                throw new RuntimeException("Marker value must use same Property for direct mapping");
            }
        }

        /* access modifiers changed from: package-private */
        public float calculateFraction(Parallax parallax) {
            float f5;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i5 < this.mMarkerValues.size()) {
                Parallax.IntPropertyMarkerValue intPropertyMarkerValue = (Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(i5);
                int index = ((Parallax.IntProperty) intPropertyMarkerValue.getProperty()).getIndex();
                int markerValue = intPropertyMarkerValue.getMarkerValue(parallax);
                int intPropertyValue = parallax.getIntPropertyValue(index);
                if (i5 == 0) {
                    if (intPropertyValue >= markerValue) {
                        return 0.0f;
                    }
                } else if (i6 == index && i7 < markerValue) {
                    throw new IllegalStateException("marker value of same variable must be descendant order");
                } else if (intPropertyValue == Integer.MAX_VALUE) {
                    return getFractionWithWeightAdjusted(((float) (i7 - i8)) / parallax.getMaxValue(), i5);
                } else {
                    if (intPropertyValue >= markerValue) {
                        if (i6 != index) {
                            if (i8 != Integer.MIN_VALUE) {
                                i7 += intPropertyValue - i8;
                            } else {
                                f5 = 1.0f - (((float) (intPropertyValue - markerValue)) / parallax.getMaxValue());
                                return getFractionWithWeightAdjusted(f5, i5);
                            }
                        }
                        f5 = ((float) (i7 - intPropertyValue)) / ((float) (i7 - markerValue));
                        return getFractionWithWeightAdjusted(f5, i5);
                    }
                }
                i5++;
                i7 = markerValue;
                i6 = index;
                i8 = intPropertyValue;
            }
            return 1.0f;
        }
    }

    ParallaxEffect() {
    }

    public final void addTarget(ParallaxTarget parallaxTarget) {
        this.mTargets.add(parallaxTarget);
    }

    /* access modifiers changed from: package-private */
    public abstract Number calculateDirectValue(Parallax parallax);

    /* access modifiers changed from: package-private */
    public abstract float calculateFraction(Parallax parallax);

    /* access modifiers changed from: package-private */
    public final float getFractionWithWeightAdjusted(float f5, int i5) {
        float size;
        float f6;
        if (this.mMarkerValues.size() >= 3) {
            if (this.mWeights.size() == this.mMarkerValues.size() - 1) {
                List<Float> list = this.mTotalWeights;
                size = list.get(list.size() - 1).floatValue();
                f5 = (f5 * this.mWeights.get(i5 - 1).floatValue()) / size;
                if (i5 < 2) {
                    return f5;
                }
                f6 = this.mTotalWeights.get(i5 - 2).floatValue();
            } else {
                size = (float) (this.mMarkerValues.size() - 1);
                f5 /= size;
                if (i5 >= 2) {
                    f6 = (float) (i5 - 1);
                }
            }
            return f5 + (f6 / size);
        }
        return f5;
    }

    public final List<Parallax.PropertyMarkerValue> getPropertyRanges() {
        return this.mMarkerValues;
    }

    public final List<ParallaxTarget> getTargets() {
        return this.mTargets;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final List<Float> getWeights() {
        return this.mWeights;
    }

    public final void performMapping(Parallax parallax) {
        if (this.mMarkerValues.size() >= 2) {
            if (this instanceof IntEffect) {
                parallax.verifyIntProperties();
            } else {
                parallax.verifyFloatProperties();
            }
            Number number = null;
            float f5 = 0.0f;
            boolean z4 = false;
            for (int i5 = 0; i5 < this.mTargets.size(); i5++) {
                ParallaxTarget parallaxTarget = this.mTargets.get(i5);
                if (parallaxTarget.isDirectMapping()) {
                    if (number == null) {
                        number = calculateDirectValue(parallax);
                    }
                    parallaxTarget.directUpdate(number);
                } else {
                    if (!z4) {
                        f5 = calculateFraction(parallax);
                        z4 = true;
                    }
                    parallaxTarget.update(f5);
                }
            }
        }
    }

    public final void removeTarget(ParallaxTarget parallaxTarget) {
        this.mTargets.remove(parallaxTarget);
    }

    public final void setPropertyRanges(Parallax.PropertyMarkerValue... propertyMarkerValueArr) {
        this.mMarkerValues.clear();
        for (Parallax.PropertyMarkerValue add : propertyMarkerValueArr) {
            this.mMarkerValues.add(add);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setWeights(float... fArr) {
        int length = fArr.length;
        int i5 = 0;
        while (true) {
            float f5 = 0.0f;
            if (i5 >= length) {
                this.mWeights.clear();
                this.mTotalWeights.clear();
                for (float f6 : fArr) {
                    this.mWeights.add(Float.valueOf(f6));
                    f5 += f6;
                    this.mTotalWeights.add(Float.valueOf(f5));
                }
                return;
            } else if (fArr[i5] > 0.0f) {
                i5++;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public final ParallaxEffect target(ParallaxTarget parallaxTarget) {
        this.mTargets.add(parallaxTarget);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final ParallaxEffect weights(float... fArr) {
        setWeights(fArr);
        return this;
    }

    public final ParallaxEffect target(Object obj, PropertyValuesHolder propertyValuesHolder) {
        this.mTargets.add(new ParallaxTarget.PropertyValuesHolderTarget(obj, propertyValuesHolder));
        return this;
    }

    public final <T, V extends Number> ParallaxEffect target(T t5, Property<T, V> property) {
        this.mTargets.add(new ParallaxTarget.DirectPropertyTarget(t5, property));
        return this;
    }
}
