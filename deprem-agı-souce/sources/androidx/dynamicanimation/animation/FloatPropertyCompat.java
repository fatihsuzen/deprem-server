package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> floatProperty) {
        return new FloatPropertyCompat<T>(floatProperty.getName()) {
            public float getValue(T t5) {
                return ((Float) floatProperty.get(t5)).floatValue();
            }

            public void setValue(T t5, float f5) {
                floatProperty.setValue(t5, f5);
            }
        };
    }

    public abstract float getValue(T t5);

    public abstract void setValue(T t5, float f5);
}
