package androidx.leanback.widget;

import android.util.Property;
import androidx.annotation.CallSuper;
import androidx.leanback.widget.ParallaxEffect;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

public abstract class Parallax<PropertyT extends Property> {
    private final List<ParallaxEffect> mEffects = new ArrayList(4);
    private float[] mFloatValues = new float[4];
    final List<PropertyT> mProperties;
    final List<PropertyT> mPropertiesReadOnly;
    private int[] mValues = new int[4];

    public static class FloatProperty extends Property<Parallax, Float> {
        public static final float UNKNOWN_AFTER = Float.MAX_VALUE;
        public static final float UNKNOWN_BEFORE = -3.4028235E38f;
        private final int mIndex;

        public FloatProperty(String str, int i5) {
            super(Float.class, str);
            this.mIndex = i5;
        }

        public final PropertyMarkerValue at(float f5, float f6) {
            return new FloatPropertyMarkerValue(this, f5, f6);
        }

        public final PropertyMarkerValue atAbsolute(float f5) {
            return new FloatPropertyMarkerValue(this, f5, 0.0f);
        }

        public final PropertyMarkerValue atFraction(float f5) {
            return new FloatPropertyMarkerValue(this, 0.0f, f5);
        }

        public final PropertyMarkerValue atMax() {
            return new FloatPropertyMarkerValue(this, 0.0f, 1.0f);
        }

        public final PropertyMarkerValue atMin() {
            return new FloatPropertyMarkerValue(this, 0.0f);
        }

        public final int getIndex() {
            return this.mIndex;
        }

        public final float getValue(Parallax parallax) {
            return parallax.getFloatPropertyValue(this.mIndex);
        }

        public final void setValue(Parallax parallax, float f5) {
            parallax.setFloatPropertyValue(this.mIndex, f5);
        }

        public final Float get(Parallax parallax) {
            return Float.valueOf(parallax.getFloatPropertyValue(this.mIndex));
        }

        public final void set(Parallax parallax, Float f5) {
            parallax.setFloatPropertyValue(this.mIndex, f5.floatValue());
        }
    }

    static class FloatPropertyMarkerValue extends PropertyMarkerValue<FloatProperty> {
        private final float mFactionOfMax;
        private final float mValue;

        FloatPropertyMarkerValue(FloatProperty floatProperty, float f5) {
            this(floatProperty, f5, 0.0f);
        }

        /* access modifiers changed from: package-private */
        public final float getMarkerValue(Parallax parallax) {
            if (this.mFactionOfMax == 0.0f) {
                return this.mValue;
            }
            return this.mValue + (parallax.getMaxValue() * this.mFactionOfMax);
        }

        FloatPropertyMarkerValue(FloatProperty floatProperty, float f5, float f6) {
            super(floatProperty);
            this.mValue = f5;
            this.mFactionOfMax = f6;
        }
    }

    public static class IntProperty extends Property<Parallax, Integer> {
        public static final int UNKNOWN_AFTER = Integer.MAX_VALUE;
        public static final int UNKNOWN_BEFORE = Integer.MIN_VALUE;
        private final int mIndex;

        public IntProperty(String str, int i5) {
            super(Integer.class, str);
            this.mIndex = i5;
        }

        public final PropertyMarkerValue at(int i5, float f5) {
            return new IntPropertyMarkerValue(this, i5, f5);
        }

        public final PropertyMarkerValue atAbsolute(int i5) {
            return new IntPropertyMarkerValue(this, i5, 0.0f);
        }

        public final PropertyMarkerValue atFraction(float f5) {
            return new IntPropertyMarkerValue(this, 0, f5);
        }

        public final PropertyMarkerValue atMax() {
            return new IntPropertyMarkerValue(this, 0, 1.0f);
        }

        public final PropertyMarkerValue atMin() {
            return new IntPropertyMarkerValue(this, 0);
        }

        public final int getIndex() {
            return this.mIndex;
        }

        public final int getValue(Parallax parallax) {
            return parallax.getIntPropertyValue(this.mIndex);
        }

        public final void setValue(Parallax parallax, int i5) {
            parallax.setIntPropertyValue(this.mIndex, i5);
        }

        public final Integer get(Parallax parallax) {
            return Integer.valueOf(parallax.getIntPropertyValue(this.mIndex));
        }

        public final void set(Parallax parallax, Integer num) {
            parallax.setIntPropertyValue(this.mIndex, num.intValue());
        }
    }

    static class IntPropertyMarkerValue extends PropertyMarkerValue<IntProperty> {
        private final float mFactionOfMax;
        private final int mValue;

        IntPropertyMarkerValue(IntProperty intProperty, int i5) {
            this(intProperty, i5, 0.0f);
        }

        /* access modifiers changed from: package-private */
        public final int getMarkerValue(Parallax parallax) {
            if (this.mFactionOfMax == 0.0f) {
                return this.mValue;
            }
            return this.mValue + Math.round(parallax.getMaxValue() * this.mFactionOfMax);
        }

        IntPropertyMarkerValue(IntProperty intProperty, int i5, float f5) {
            super(intProperty);
            this.mValue = i5;
            this.mFactionOfMax = f5;
        }
    }

    public static class PropertyMarkerValue<PropertyT> {
        private final PropertyT mProperty;

        public PropertyMarkerValue(PropertyT propertyt) {
            this.mProperty = propertyt;
        }

        public PropertyT getProperty() {
            return this.mProperty;
        }
    }

    public Parallax() {
        ArrayList arrayList = new ArrayList();
        this.mProperties = arrayList;
        this.mPropertiesReadOnly = DesugarCollections.unmodifiableList(arrayList);
    }

    public ParallaxEffect addEffect(PropertyMarkerValue... propertyMarkerValueArr) {
        ParallaxEffect parallaxEffect;
        if (propertyMarkerValueArr[0].getProperty() instanceof IntProperty) {
            parallaxEffect = new ParallaxEffect.IntEffect();
        } else {
            parallaxEffect = new ParallaxEffect.FloatEffect();
        }
        parallaxEffect.setPropertyRanges(propertyMarkerValueArr);
        this.mEffects.add(parallaxEffect);
        return parallaxEffect;
    }

    public final PropertyT addProperty(String str) {
        int size = this.mProperties.size();
        PropertyT createProperty = createProperty(str, size);
        int i5 = 0;
        if (createProperty instanceof IntProperty) {
            int length = this.mValues.length;
            if (length == size) {
                int[] iArr = new int[(length * 2)];
                while (i5 < length) {
                    iArr[i5] = this.mValues[i5];
                    i5++;
                }
                this.mValues = iArr;
            }
            this.mValues[size] = Integer.MAX_VALUE;
        } else if (createProperty instanceof FloatProperty) {
            int length2 = this.mFloatValues.length;
            if (length2 == size) {
                float[] fArr = new float[(length2 * 2)];
                while (i5 < length2) {
                    fArr[i5] = this.mFloatValues[i5];
                    i5++;
                }
                this.mFloatValues = fArr;
            }
            this.mFloatValues[size] = Float.MAX_VALUE;
        } else {
            throw new IllegalArgumentException("Invalid Property type");
        }
        this.mProperties.add(createProperty);
        return createProperty;
    }

    public abstract PropertyT createProperty(String str, int i5);

    public List<ParallaxEffect> getEffects() {
        return this.mEffects;
    }

    /* access modifiers changed from: package-private */
    public final float getFloatPropertyValue(int i5) {
        return this.mFloatValues[i5];
    }

    /* access modifiers changed from: package-private */
    public final int getIntPropertyValue(int i5) {
        return this.mValues[i5];
    }

    public abstract float getMaxValue();

    public final List<PropertyT> getProperties() {
        return this.mPropertiesReadOnly;
    }

    public void removeAllEffects() {
        this.mEffects.clear();
    }

    public void removeEffect(ParallaxEffect parallaxEffect) {
        this.mEffects.remove(parallaxEffect);
    }

    /* access modifiers changed from: package-private */
    public final void setFloatPropertyValue(int i5, float f5) {
        if (i5 < this.mProperties.size()) {
            this.mFloatValues[i5] = f5;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /* access modifiers changed from: package-private */
    public final void setIntPropertyValue(int i5, int i6) {
        if (i5 < this.mProperties.size()) {
            this.mValues[i5] = i6;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @CallSuper
    public void updateValues() {
        for (int i5 = 0; i5 < this.mEffects.size(); i5++) {
            this.mEffects.get(i5).performMapping(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void verifyFloatProperties() throws IllegalStateException {
        if (this.mProperties.size() >= 2) {
            float floatPropertyValue = getFloatPropertyValue(0);
            int i5 = 1;
            while (i5 < this.mProperties.size()) {
                float floatPropertyValue2 = getFloatPropertyValue(i5);
                if (floatPropertyValue2 < floatPropertyValue) {
                    Integer valueOf = Integer.valueOf(i5);
                    String name = ((Property) this.mProperties.get(i5)).getName();
                    int i6 = i5 - 1;
                    throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is smaller than Property[%d]\"%s\"", new Object[]{valueOf, name, Integer.valueOf(i6), ((Property) this.mProperties.get(i6)).getName()}));
                } else if (floatPropertyValue == -3.4028235E38f && floatPropertyValue2 == Float.MAX_VALUE) {
                    int i7 = i5 - 1;
                    throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is UNKNOWN_BEFORE and Property[%d]\"%s\" is UNKNOWN_AFTER", new Object[]{Integer.valueOf(i7), ((Property) this.mProperties.get(i7)).getName(), Integer.valueOf(i5), ((Property) this.mProperties.get(i5)).getName()}));
                } else {
                    i5++;
                    floatPropertyValue = floatPropertyValue2;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void verifyIntProperties() throws IllegalStateException {
        if (this.mProperties.size() >= 2) {
            int intPropertyValue = getIntPropertyValue(0);
            int i5 = 1;
            while (i5 < this.mProperties.size()) {
                int intPropertyValue2 = getIntPropertyValue(i5);
                if (intPropertyValue2 < intPropertyValue) {
                    Integer valueOf = Integer.valueOf(i5);
                    String name = ((Property) this.mProperties.get(i5)).getName();
                    int i6 = i5 - 1;
                    throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is smaller than Property[%d]\"%s\"", new Object[]{valueOf, name, Integer.valueOf(i6), ((Property) this.mProperties.get(i6)).getName()}));
                } else if (intPropertyValue == Integer.MIN_VALUE && intPropertyValue2 == Integer.MAX_VALUE) {
                    int i7 = i5 - 1;
                    throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is UNKNOWN_BEFORE and Property[%d]\"%s\" is UNKNOWN_AFTER", new Object[]{Integer.valueOf(i7), ((Property) this.mProperties.get(i7)).getName(), Integer.valueOf(i5), ((Property) this.mProperties.get(i5)).getName()}));
                } else {
                    i5++;
                    intPropertyValue = intPropertyValue2;
                }
            }
        }
    }
}
