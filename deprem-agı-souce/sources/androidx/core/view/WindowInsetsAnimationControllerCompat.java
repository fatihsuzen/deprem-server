package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.WindowInsetsAnimationController;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

public final class WindowInsetsAnimationControllerCompat {
    private final Impl mImpl;

    private static class Impl {
        Impl() {
        }

        /* access modifiers changed from: package-private */
        public void finish(boolean z4) {
        }

        public float getCurrentAlpha() {
            return 0.0f;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getCurrentFraction() {
            return 0.0f;
        }

        @NonNull
        public Insets getCurrentInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getHiddenStateInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getShownStateInsets() {
            return Insets.NONE;
        }

        public int getTypes() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isCancelled() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isFinished() {
            return false;
        }

        public void setInsetsAndAlpha(@Nullable Insets insets, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl {
        private final WindowInsetsAnimationController mController;

        Impl30(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
            this.mController = windowInsetsAnimationController;
        }

        /* access modifiers changed from: package-private */
        public void finish(boolean z4) {
            this.mController.finish(z4);
        }

        public float getCurrentAlpha() {
            return this.mController.getCurrentAlpha();
        }

        public float getCurrentFraction() {
            return this.mController.getCurrentFraction();
        }

        @NonNull
        public Insets getCurrentInsets() {
            return Insets.toCompatInsets(this.mController.getCurrentInsets());
        }

        @NonNull
        public Insets getHiddenStateInsets() {
            return Insets.toCompatInsets(this.mController.getHiddenStateInsets());
        }

        @NonNull
        public Insets getShownStateInsets() {
            return Insets.toCompatInsets(this.mController.getShownStateInsets());
        }

        @SuppressLint({"WrongConstant"})
        public int getTypes() {
            return this.mController.getTypes();
        }

        /* access modifiers changed from: package-private */
        public boolean isCancelled() {
            return this.mController.isCancelled();
        }

        /* access modifiers changed from: package-private */
        public boolean isFinished() {
            return this.mController.isFinished();
        }

        public void setInsetsAndAlpha(@Nullable Insets insets, float f5, float f6) {
            android.graphics.Insets insets2;
            WindowInsetsAnimationController windowInsetsAnimationController = this.mController;
            if (insets == null) {
                insets2 = null;
            } else {
                insets2 = insets.toPlatformInsets();
            }
            windowInsetsAnimationController.setInsetsAndAlpha(insets2, f5, f6);
        }
    }

    @RequiresApi(30)
    WindowInsetsAnimationControllerCompat(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new Impl30(windowInsetsAnimationController);
    }

    public void finish(boolean z4) {
        this.mImpl.finish(z4);
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    @NonNull
    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    @NonNull
    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    @NonNull
    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        if (isFinished() || isCancelled()) {
            return false;
        }
        return true;
    }

    public void setInsetsAndAlpha(@Nullable Insets insets, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        this.mImpl.setInsetsAndAlpha(insets, f5, f6);
    }
}
