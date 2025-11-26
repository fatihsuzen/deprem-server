package androidx.dynamicanimation.animation;

import android.annotation.SuppressLint;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final ViewProperty ALPHA = new ViewProperty("alpha") {
        public float getValue(View view) {
            return view.getAlpha();
        }

        public void setValue(View view, float f5) {
            view.setAlpha(f5);
        }
    };
    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    public static final ViewProperty ROTATION = new ViewProperty(Key.ROTATION) {
        public float getValue(View view) {
            return view.getRotation();
        }

        public void setValue(View view, float f5) {
            view.setRotation(f5);
        }
    };
    public static final ViewProperty ROTATION_X = new ViewProperty("rotationX") {
        public float getValue(View view) {
            return view.getRotationX();
        }

        public void setValue(View view, float f5) {
            view.setRotationX(f5);
        }
    };
    public static final ViewProperty ROTATION_Y = new ViewProperty("rotationY") {
        public float getValue(View view) {
            return view.getRotationY();
        }

        public void setValue(View view, float f5) {
            view.setRotationY(f5);
        }
    };
    public static final ViewProperty SCALE_X = new ViewProperty("scaleX") {
        public float getValue(View view) {
            return view.getScaleX();
        }

        public void setValue(View view, float f5) {
            view.setScaleX(f5);
        }
    };
    public static final ViewProperty SCALE_Y = new ViewProperty("scaleY") {
        public float getValue(View view) {
            return view.getScaleY();
        }

        public void setValue(View view, float f5) {
            view.setScaleY(f5);
        }
    };
    public static final ViewProperty SCROLL_X = new ViewProperty("scrollX") {
        public float getValue(View view) {
            return (float) view.getScrollX();
        }

        public void setValue(View view, float f5) {
            view.setScrollX((int) f5);
        }
    };
    public static final ViewProperty SCROLL_Y = new ViewProperty("scrollY") {
        public float getValue(View view) {
            return (float) view.getScrollY();
        }

        public void setValue(View view, float f5) {
            view.setScrollY((int) f5);
        }
    };
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    public static final ViewProperty TRANSLATION_X = new ViewProperty("translationX") {
        public float getValue(View view) {
            return view.getTranslationX();
        }

        public void setValue(View view, float f5) {
            view.setTranslationX(f5);
        }
    };
    public static final ViewProperty TRANSLATION_Y = new ViewProperty("translationY") {
        public float getValue(View view) {
            return view.getTranslationY();
        }

        public void setValue(View view, float f5) {
            view.setTranslationY(f5);
        }
    };
    public static final ViewProperty TRANSLATION_Z = new ViewProperty("translationZ") {
        public float getValue(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        public void setValue(View view, float f5) {
            ViewCompat.setTranslationZ(view, f5);
        }
    };
    private static final float UNSET = Float.MAX_VALUE;

    /* renamed from: X  reason: collision with root package name */
    public static final ViewProperty f340X = new ViewProperty("x") {
        public float getValue(View view) {
            return view.getX();
        }

        public void setValue(View view, float f5) {
            view.setX(f5);
        }
    };

    /* renamed from: Y  reason: collision with root package name */
    public static final ViewProperty f341Y = new ViewProperty("y") {
        public float getValue(View view) {
            return view.getY();
        }

        public void setValue(View view, float f5) {
            view.setY(f5);
        }
    };

    /* renamed from: Z  reason: collision with root package name */
    public static final ViewProperty f342Z = new ViewProperty("z") {
        public float getValue(View view) {
            return ViewCompat.getZ(view);
        }

        public void setValue(View view, float f5) {
            ViewCompat.setZ(view, f5);
        }
    };
    private AnimationHandler mAnimationHandler;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final FloatPropertyCompat mProperty;
    boolean mRunning;
    boolean mStartValueIsSet;
    final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    float mValue;
    float mVelocity;

    static class MassState {
        float mValue;
        float mVelocity;

        MassState() {
        }
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z4, float f5, float f6);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f5, float f6);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String str) {
            super(str);
        }
    }

    DynamicAnimation(final FloatValueHolder floatValueHolder) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = null;
        this.mProperty = new FloatPropertyCompat("FloatValueHolder") {
            public float getValue(Object obj) {
                return floatValueHolder.getValue();
            }

            public void setValue(Object obj, float f5) {
                floatValueHolder.setValue(f5);
            }
        };
        this.mMinVisibleChange = 1.0f;
    }

    private void endAnimationInternal(boolean z4) {
        this.mRunning = false;
        getAnimationHandler().removeCallback(this);
        this.mLastFrameTime = 0;
        this.mStartValueIsSet = false;
        for (int i5 = 0; i5 < this.mEndListeners.size(); i5++) {
            if (this.mEndListeners.get(i5) != null) {
                this.mEndListeners.get(i5).onAnimationEnd(this, z4, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t5) {
        int indexOf = arrayList.indexOf(t5);
        if (indexOf >= 0) {
            arrayList.set(indexOf, (Object) null);
        }
    }

    private static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.mStartValueIsSet) {
                this.mValue = getPropertyValue();
            }
            float f5 = this.mValue;
            if (f5 > this.mMaxValue || f5 < this.mMinValue) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            getAnimationHandler().addAnimationFrameCallback(this, 0);
        }
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!isRunning()) {
            if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
                this.mUpdateListeners.add(onAnimationUpdateListener);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    @MainThread
    public void cancel() {
        if (!getAnimationHandler().isCurrentThread()) {
            throw new AndroidRuntimeException("Animations may only be canceled from the same thread as the animation handler");
        } else if (this.mRunning) {
            endAnimationInternal(true);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean doAnimationFrame(long j5) {
        long j6;
        long j7 = this.mLastFrameTime;
        if (j7 == 0) {
            this.mLastFrameTime = j5;
            setPropertyValue(this.mValue);
            return false;
        }
        long j8 = j5 - j7;
        this.mLastFrameTime = j5;
        float durationScale = getAnimationHandler().getDurationScale();
        if (durationScale == 0.0f) {
            j6 = 2147483647L;
        } else {
            j6 = (long) (((float) j8) / durationScale);
        }
        boolean updateValueAndVelocity = updateValueAndVelocity(j6);
        float min = Math.min(this.mValue, this.mMaxValue);
        this.mValue = min;
        float max = Math.max(min, this.mMinValue);
        this.mValue = max;
        setPropertyValue(max);
        if (updateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return updateValueAndVelocity;
    }

    /* access modifiers changed from: package-private */
    public abstract float getAcceleration(float f5, float f6);

    @VisibleForTesting
    public AnimationHandler getAnimationHandler() {
        AnimationHandler animationHandler = this.mAnimationHandler;
        if (animationHandler != null) {
            return animationHandler;
        }
        return AnimationHandler.getInstance();
    }

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public FrameCallbackScheduler getScheduler() {
        AnimationHandler animationHandler = this.mAnimationHandler;
        if (animationHandler != null) {
            return animationHandler.getScheduler();
        }
        return AnimationHandler.getInstance().getScheduler();
    }

    /* access modifiers changed from: package-private */
    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isAtEquilibrium(float f5, float f6);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setMaxValue(float f5) {
        this.mMaxValue = f5;
        return this;
    }

    public T setMinValue(float f5) {
        this.mMinValue = f5;
        return this;
    }

    public T setMinimumVisibleChange(@FloatRange(from = 0.0d, fromInclusive = false) float f5) {
        if (f5 > 0.0f) {
            this.mMinVisibleChange = f5;
            setValueThreshold(f5 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    /* access modifiers changed from: package-private */
    public void setPropertyValue(float f5) {
        this.mProperty.setValue(this.mTarget, f5);
        for (int i5 = 0; i5 < this.mUpdateListeners.size(); i5++) {
            if (this.mUpdateListeners.get(i5) != null) {
                this.mUpdateListeners.get(i5).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public void setScheduler(FrameCallbackScheduler frameCallbackScheduler) {
        AnimationHandler animationHandler = this.mAnimationHandler;
        if (animationHandler != null && animationHandler.getScheduler() == frameCallbackScheduler) {
            return;
        }
        if (!this.mRunning) {
            this.mAnimationHandler = new AnimationHandler(frameCallbackScheduler);
            return;
        }
        throw new AndroidRuntimeException("Animations are still running and the animationhandler should not be set at this timming");
    }

    public T setStartValue(float f5) {
        this.mValue = f5;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f5) {
        this.mVelocity = f5;
        return this;
    }

    /* access modifiers changed from: package-private */
    public abstract void setValueThreshold(float f5);

    @MainThread
    public void start() {
        if (!getAnimationHandler().isCurrentThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        } else if (!this.mRunning) {
            startAnimationInternal();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean updateValueAndVelocity(long j5);

    <K> DynamicAnimation(K k5, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = k5;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat == ROTATION || floatPropertyCompat == ROTATION_X || floatPropertyCompat == ROTATION_Y) {
            this.mMinVisibleChange = 0.1f;
        } else if (floatPropertyCompat == ALPHA) {
            this.mMinVisibleChange = 0.00390625f;
        } else if (floatPropertyCompat == SCALE_X || floatPropertyCompat == SCALE_Y) {
            this.mMinVisibleChange = 0.002f;
        } else {
            this.mMinVisibleChange = 1.0f;
        }
    }
}
