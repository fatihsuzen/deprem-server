package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import j$.util.DesugarCollections;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.WeakHashMap;

public final class VelocityTrackerCompat {
    private static Map<VelocityTracker, VelocityTrackerFallback> sFallbackTrackers = DesugarCollections.synchronizedMap(new WeakHashMap());

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static float getAxisVelocity(VelocityTracker velocityTracker, int i5, int i6) {
            return velocityTracker.getAxisVelocity(i5, i6);
        }

        @DoNotInline
        static boolean isAxisSupported(VelocityTracker velocityTracker, int i5) {
            return velocityTracker.isAxisSupported(i5);
        }

        @DoNotInline
        static float getAxisVelocity(VelocityTracker velocityTracker, int i5) {
            return velocityTracker.getAxisVelocity(i5);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface VelocityTrackableMotionEventAxis {
    }

    private VelocityTrackerCompat() {
    }

    public static void addMovement(@NonNull VelocityTracker velocityTracker, @NonNull MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!sFallbackTrackers.containsKey(velocityTracker)) {
                sFallbackTrackers.put(velocityTracker, new VelocityTrackerFallback());
            }
            sFallbackTrackers.get(velocityTracker).addMovement(motionEvent);
        }
    }

    public static void clear(@NonNull VelocityTracker velocityTracker) {
        velocityTracker.clear();
        removeFallbackForTracker(velocityTracker);
    }

    public static void computeCurrentVelocity(@NonNull VelocityTracker velocityTracker, int i5, float f5) {
        velocityTracker.computeCurrentVelocity(i5, f5);
        VelocityTrackerFallback fallbackTrackerOrNull = getFallbackTrackerOrNull(velocityTracker);
        if (fallbackTrackerOrNull != null) {
            fallbackTrackerOrNull.computeCurrentVelocity(i5, f5);
        }
    }

    public static float getAxisVelocity(@NonNull VelocityTracker velocityTracker, int i5) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getAxisVelocity(velocityTracker, i5);
        }
        if (i5 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i5 == 1) {
            return velocityTracker.getYVelocity();
        }
        VelocityTrackerFallback fallbackTrackerOrNull = getFallbackTrackerOrNull(velocityTracker);
        if (fallbackTrackerOrNull != null) {
            return fallbackTrackerOrNull.getAxisVelocity(i5);
        }
        return 0.0f;
    }

    @Nullable
    private static VelocityTrackerFallback getFallbackTrackerOrNull(VelocityTracker velocityTracker) {
        return sFallbackTrackers.get(velocityTracker);
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker velocityTracker, int i5) {
        return velocityTracker.getXVelocity(i5);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker velocityTracker, int i5) {
        return velocityTracker.getYVelocity(i5);
    }

    public static boolean isAxisSupported(@NonNull VelocityTracker velocityTracker, int i5) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.isAxisSupported(velocityTracker, i5);
        }
        if (i5 == 26 || i5 == 0 || i5 == 1) {
            return true;
        }
        return false;
    }

    public static void recycle(@NonNull VelocityTracker velocityTracker) {
        velocityTracker.recycle();
        removeFallbackForTracker(velocityTracker);
    }

    private static void removeFallbackForTracker(VelocityTracker velocityTracker) {
        sFallbackTrackers.remove(velocityTracker);
    }

    public static void computeCurrentVelocity(@NonNull VelocityTracker velocityTracker, int i5) {
        computeCurrentVelocity(velocityTracker, i5, Float.MAX_VALUE);
    }

    public static float getAxisVelocity(@NonNull VelocityTracker velocityTracker, int i5, int i6) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getAxisVelocity(velocityTracker, i5, i6);
        }
        if (i5 == 0) {
            return velocityTracker.getXVelocity(i6);
        }
        if (i5 == 1) {
            return velocityTracker.getYVelocity(i6);
        }
        return 0.0f;
    }
}
