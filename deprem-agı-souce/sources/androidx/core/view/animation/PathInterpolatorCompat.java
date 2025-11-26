package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class PathInterpolatorCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Interpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        @DoNotInline
        static Interpolator createPathInterpolator(float f5, float f6) {
            return new PathInterpolator(f5, f6);
        }

        @DoNotInline
        static Interpolator createPathInterpolator(float f5, float f6, float f7, float f8) {
            return new PathInterpolator(f5, f6, f7, f8);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    @NonNull
    public static Interpolator create(float f5, float f6) {
        return Api21Impl.createPathInterpolator(f5, f6);
    }

    @NonNull
    public static Interpolator create(float f5, float f6, float f7, float f8) {
        return Api21Impl.createPathInterpolator(f5, f6, f7, f8);
    }
}
