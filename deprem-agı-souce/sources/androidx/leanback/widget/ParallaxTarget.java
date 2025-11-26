package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.animation.LinearInterpolator;

public abstract class ParallaxTarget {

    public static final class DirectPropertyTarget<T, V extends Number> extends ParallaxTarget {
        Object mObject;
        Property<T, V> mProperty;

        public DirectPropertyTarget(Object obj, Property<T, V> property) {
            this.mObject = obj;
            this.mProperty = property;
        }

        public void directUpdate(Number number) {
            this.mProperty.set(this.mObject, number);
        }

        public boolean isDirectMapping() {
            return true;
        }
    }

    public static final class PropertyValuesHolderTarget extends ParallaxTarget {
        private static final long PSEUDO_DURATION = 1000000;
        private final ObjectAnimator mAnimator;

        public PropertyValuesHolderTarget(Object obj, PropertyValuesHolder propertyValuesHolder) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[]{propertyValuesHolder});
            this.mAnimator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            ofPropertyValuesHolder.setDuration(1000000);
        }

        public void update(float f5) {
            this.mAnimator.setCurrentPlayTime((long) (f5 * 1000000.0f));
        }
    }

    public void directUpdate(Number number) {
    }

    public boolean isDirectMapping() {
        return false;
    }

    public void update(float f5) {
    }
}
