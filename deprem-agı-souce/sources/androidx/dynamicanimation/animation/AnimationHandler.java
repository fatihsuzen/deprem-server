package androidx.dynamicanimation.animation;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

public class AnimationHandler {
    private static final ThreadLocal<AnimationHandler> sAnimatorHandler = new ThreadLocal<>();
    final ArrayList<AnimationFrameCallback> mAnimationCallbacks = new ArrayList<>();
    private final AnimationCallbackDispatcher mCallbackDispatcher = new AnimationCallbackDispatcher();
    long mCurrentFrameTime = 0;
    private final SimpleArrayMap<AnimationFrameCallback, Long> mDelayedCallbackStartTime = new SimpleArrayMap<>();
    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float mDurationScale = 1.0f;
    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DurationScaleChangeListener mDurationScaleChangeListener;
    private boolean mListDirty = false;
    /* access modifiers changed from: private */
    public final Runnable mRunnable = new b(this);
    /* access modifiers changed from: private */
    public FrameCallbackScheduler mScheduler;

    private class AnimationCallbackDispatcher {
        private AnimationCallbackDispatcher() {
        }

        /* access modifiers changed from: package-private */
        public void dispatchAnimationFrame() {
            AnimationHandler.this.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.doAnimationFrame(animationHandler.mCurrentFrameTime);
            if (AnimationHandler.this.mAnimationCallbacks.size() > 0) {
                AnimationHandler.this.mScheduler.postFrameCallback(AnimationHandler.this.mRunnable);
            }
        }
    }

    interface AnimationFrameCallback {
        boolean doAnimationFrame(long j5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public interface DurationScaleChangeListener {
        boolean register();

        boolean unregister();
    }

    @RequiresApi(api = 33)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public class DurationScaleChangeListener33 implements DurationScaleChangeListener {
        ValueAnimator.DurationScaleChangeListener mListener;

        public DurationScaleChangeListener33() {
        }

        public boolean register() {
            if (this.mListener != null) {
                return true;
            }
            e eVar = new e(this);
            this.mListener = eVar;
            return ValueAnimator.registerDurationScaleChangeListener(eVar);
        }

        public boolean unregister() {
            boolean a5 = ValueAnimator.unregisterDurationScaleChangeListener(this.mListener);
            this.mListener = null;
            return a5;
        }
    }

    static final class FrameCallbackScheduler16 implements FrameCallbackScheduler {
        private final Choreographer mChoreographer = Choreographer.getInstance();
        private final Looper mLooper = Looper.myLooper();

        FrameCallbackScheduler16() {
        }

        public boolean isCurrentThread() {
            if (Thread.currentThread() == this.mLooper.getThread()) {
                return true;
            }
            return false;
        }

        public void postFrameCallback(Runnable runnable) {
            this.mChoreographer.postFrameCallback(new f(runnable));
        }
    }

    public AnimationHandler(FrameCallbackScheduler frameCallbackScheduler) {
        this.mScheduler = frameCallbackScheduler;
    }

    private void cleanUpList() {
        if (this.mListDirty) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            if (this.mAnimationCallbacks.size() == 0 && Build.VERSION.SDK_INT >= 33) {
                this.mDurationScaleChangeListener.unregister();
            }
            this.mListDirty = false;
        }
    }

    static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> threadLocal = sAnimatorHandler;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler(new FrameCallbackScheduler16()));
        }
        return threadLocal.get();
    }

    private boolean isCallbackDue(AnimationFrameCallback animationFrameCallback, long j5) {
        Long l5 = this.mDelayedCallbackStartTime.get(animationFrameCallback);
        if (l5 == null) {
            return true;
        }
        if (l5.longValue() >= j5) {
            return false;
        }
        this.mDelayedCallbackStartTime.remove(animationFrameCallback);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void addAnimationFrameCallback(AnimationFrameCallback animationFrameCallback, long j5) {
        if (this.mAnimationCallbacks.size() == 0) {
            this.mScheduler.postFrameCallback(this.mRunnable);
            if (Build.VERSION.SDK_INT >= 33) {
                this.mDurationScale = ValueAnimator.getDurationScale();
                if (this.mDurationScaleChangeListener == null) {
                    this.mDurationScaleChangeListener = new DurationScaleChangeListener33();
                }
                this.mDurationScaleChangeListener.register();
            }
        }
        if (!this.mAnimationCallbacks.contains(animationFrameCallback)) {
            this.mAnimationCallbacks.add(animationFrameCallback);
        }
        if (j5 > 0) {
            this.mDelayedCallbackStartTime.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j5));
        }
    }

    /* access modifiers changed from: package-private */
    public void doAnimationFrame(long j5) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i5 = 0; i5 < this.mAnimationCallbacks.size(); i5++) {
            AnimationFrameCallback animationFrameCallback = this.mAnimationCallbacks.get(i5);
            if (animationFrameCallback != null && isCallbackDue(animationFrameCallback, uptimeMillis)) {
                animationFrameCallback.doAnimationFrame(j5);
            }
        }
        cleanUpList();
    }

    @VisibleForTesting
    public float getDurationScale() {
        return this.mDurationScale;
    }

    /* access modifiers changed from: package-private */
    public FrameCallbackScheduler getScheduler() {
        return this.mScheduler;
    }

    /* access modifiers changed from: package-private */
    public boolean isCurrentThread() {
        return this.mScheduler.isCurrentThread();
    }

    /* access modifiers changed from: package-private */
    public void removeCallback(AnimationFrameCallback animationFrameCallback) {
        this.mDelayedCallbackStartTime.remove(animationFrameCallback);
        int indexOf = this.mAnimationCallbacks.indexOf(animationFrameCallback);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, (Object) null);
            this.mListDirty = true;
        }
    }
}
