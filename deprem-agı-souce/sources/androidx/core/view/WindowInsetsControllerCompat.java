package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.accessibility.AccessibilityEventCompat;

public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;
    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    private static class Impl {
        Impl() {
        }

        /* access modifiers changed from: package-private */
        public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* access modifiers changed from: package-private */
        public void controlWindowInsetsAnimation(int i5, long j5, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        /* access modifiers changed from: package-private */
        public int getSystemBarsBehavior() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void hide(int i5) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void setAppearanceLightNavigationBars(boolean z4) {
        }

        public void setAppearanceLightStatusBars(boolean z4) {
        }

        /* access modifiers changed from: package-private */
        public void setSystemBarsBehavior(int i5) {
        }

        /* access modifiers changed from: package-private */
        public void show(int i5) {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {
        @NonNull
        private final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        @NonNull
        protected final Window mWindow;

        Impl20(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.mWindow = window;
            this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
        }

        private void hideForType(int i5) {
            if (i5 == 1) {
                setSystemUiFlag(4);
            } else if (i5 == 2) {
                setSystemUiFlag(2);
            } else if (i5 == 8) {
                this.mSoftwareKeyboardControllerCompat.hide();
            }
        }

        private void showForType(int i5) {
            if (i5 == 1) {
                unsetSystemUiFlag(4);
                unsetWindowFlag(1024);
            } else if (i5 == 2) {
                unsetSystemUiFlag(2);
            } else if (i5 == 8) {
                this.mSoftwareKeyboardControllerCompat.show();
            }
        }

        /* access modifiers changed from: package-private */
        public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* access modifiers changed from: package-private */
        public void controlWindowInsetsAnimation(int i5, long j5, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        /* access modifiers changed from: package-private */
        public int getSystemBarsBehavior() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void hide(int i5) {
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i5 & i6) != 0) {
                    hideForType(i6);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* access modifiers changed from: package-private */
        public void setSystemBarsBehavior(int i5) {
            if (i5 == 0) {
                unsetSystemUiFlag(6144);
            } else if (i5 == 1) {
                unsetSystemUiFlag(4096);
                setSystemUiFlag(2048);
            } else if (i5 == 2) {
                unsetSystemUiFlag(2048);
                setSystemUiFlag(4096);
            }
        }

        /* access modifiers changed from: protected */
        public void setSystemUiFlag(int i5) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i5 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void setWindowFlag(int i5) {
            this.mWindow.addFlags(i5);
        }

        /* access modifiers changed from: package-private */
        public void show(int i5) {
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i5 & i6) != 0) {
                    showForType(i6);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void unsetSystemUiFlag(int i5) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void unsetWindowFlag(int i5) {
            this.mWindow.clearFlags(i5);
        }
    }

    @RequiresApi(23)
    private static class Impl23 extends Impl20 {
        Impl23(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        public boolean isAppearanceLightStatusBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 8192) != 0) {
                return true;
            }
            return false;
        }

        public void setAppearanceLightStatusBars(boolean z4) {
            if (z4) {
                unsetWindowFlag(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
                setWindowFlag(Integer.MIN_VALUE);
                setSystemUiFlag(8192);
                return;
            }
            unsetSystemUiFlag(8192);
        }
    }

    @RequiresApi(26)
    private static class Impl26 extends Impl23 {
        Impl26(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        public boolean isAppearanceLightNavigationBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0) {
                return true;
            }
            return false;
        }

        public void setAppearanceLightNavigationBars(boolean z4) {
            if (z4) {
                unsetWindowFlag(134217728);
                setWindowFlag(Integer.MIN_VALUE);
                setSystemUiFlag(16);
                return;
            }
            unsetSystemUiFlag(16);
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, int i5);
    }

    @RequiresApi(30)
    @Deprecated
    private WindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.mImpl = new Impl30(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
    }

    @RequiresApi(30)
    @NonNull
    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i5, long j5, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.controlWindowInsetsAnimation(i5, j5, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    @SuppressLint({"WrongConstant"})
    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int i5) {
        this.mImpl.hide(i5);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z4) {
        this.mImpl.setAppearanceLightNavigationBars(z4);
    }

    public void setAppearanceLightStatusBars(boolean z4) {
        this.mImpl.setAppearanceLightStatusBars(z4);
    }

    public void setSystemBarsBehavior(int i5) {
        this.mImpl.setSystemBarsBehavior(i5);
    }

    public void show(int i5) {
        this.mImpl.show(i5);
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;
        final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected Window mWindow;

        Impl30(@NonNull Window window, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat, softwareKeyboardControllerCompat);
            this.mWindow = window;
        }

        public static /* synthetic */ void a(Impl30 impl30, OnControllableInsetsChangedListener onControllableInsetsChangedListener, WindowInsetsController windowInsetsController, int i5) {
            if (impl30.mInsetsController == windowInsetsController) {
                onControllableInsetsChangedListener.onControllableInsetsChanged(impl30.mCompatController, i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (!this.mListeners.containsKey(onControllableInsetsChangedListener)) {
                V0 v02 = new V0(this, onControllableInsetsChangedListener);
                this.mListeners.put(onControllableInsetsChangedListener, v02);
                this.mInsetsController.addOnControllableInsetsChangedListener(v02);
            }
        }

        /* access modifiers changed from: package-private */
        public void controlWindowInsetsAnimation(int i5, long j5, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull final WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.mInsetsController.controlWindowInsetsAnimation(i5, j5, interpolator, cancellationSignal, new WindowInsetsAnimationControlListener() {
                private WindowInsetsAnimationControllerCompat mCompatAnimController = null;

                public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
                    WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat;
                    WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat = windowInsetsAnimationControlListenerCompat;
                    if (windowInsetsAnimationController == null) {
                        windowInsetsAnimationControllerCompat = null;
                    } else {
                        windowInsetsAnimationControllerCompat = this.mCompatAnimController;
                    }
                    windowInsetsAnimationControlListenerCompat.onCancelled(windowInsetsAnimationControllerCompat);
                }

                public void onFinished(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onFinished(this.mCompatAnimController);
                }

                public void onReady(@NonNull WindowInsetsAnimationController windowInsetsAnimationController, int i5) {
                    WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                    this.mCompatAnimController = windowInsetsAnimationControllerCompat;
                    windowInsetsAnimationControlListenerCompat.onReady(windowInsetsAnimationControllerCompat, i5);
                }
            });
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        /* access modifiers changed from: package-private */
        public void hide(int i5) {
            if ((i5 & 8) != 0) {
                this.mSoftwareKeyboardControllerCompat.hide();
            }
            this.mInsetsController.hide(i5 & -9);
        }

        public boolean isAppearanceLightNavigationBars() {
            this.mInsetsController.setSystemBarsAppearance(0, 0);
            if ((this.mInsetsController.getSystemBarsAppearance() & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            this.mInsetsController.setSystemBarsAppearance(0, 0);
            if ((this.mInsetsController.getSystemBarsAppearance() & 8) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener a5 = T0.a(this.mListeners.remove(onControllableInsetsChangedListener));
            if (a5 != null) {
                this.mInsetsController.removeOnControllableInsetsChangedListener(a5);
            }
        }

        public void setAppearanceLightNavigationBars(boolean z4) {
            if (z4) {
                if (this.mWindow != null) {
                    setSystemUiFlag(16);
                }
                this.mInsetsController.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.mWindow != null) {
                unsetSystemUiFlag(16);
            }
            this.mInsetsController.setSystemBarsAppearance(0, 16);
        }

        public void setAppearanceLightStatusBars(boolean z4) {
            if (z4) {
                if (this.mWindow != null) {
                    setSystemUiFlag(8192);
                }
                this.mInsetsController.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.mWindow != null) {
                unsetSystemUiFlag(8192);
            }
            this.mInsetsController.setSystemBarsAppearance(0, 8);
        }

        /* access modifiers changed from: package-private */
        public void setSystemBarsBehavior(int i5) {
            this.mInsetsController.setSystemBarsBehavior(i5);
        }

        /* access modifiers changed from: protected */
        public void setSystemUiFlag(int i5) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i5 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: package-private */
        public void show(int i5) {
            if ((i5 & 8) != 0) {
                this.mSoftwareKeyboardControllerCompat.show();
            }
            this.mInsetsController.show(i5 & -9);
        }

        /* access modifiers changed from: protected */
        public void unsetSystemUiFlag(int i5) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
        }

        Impl30(@NonNull WindowInsetsController windowInsetsController, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.mListeners = new SimpleArrayMap<>();
            this.mInsetsController = windowInsetsController;
            this.mCompatController = windowInsetsControllerCompat;
            this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
        }
    }

    public WindowInsetsControllerCompat(@NonNull Window window, @NonNull View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            this.mImpl = new Impl30(window, this, softwareKeyboardControllerCompat);
        } else if (i5 >= 26) {
            this.mImpl = new Impl26(window, softwareKeyboardControllerCompat);
        } else {
            this.mImpl = new Impl23(window, softwareKeyboardControllerCompat);
        }
    }
}
