package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SoftwareKeyboardControllerCompat {
    private final Impl mImpl;

    private static class Impl {
        Impl() {
        }

        /* access modifiers changed from: package-private */
        public void hide() {
        }

        /* access modifiers changed from: package-private */
        public void show() {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {
        @Nullable
        private final View mView;

        Impl20(@Nullable View view) {
            this.mView = view;
        }

        /* access modifiers changed from: package-private */
        public void hide() {
            View view = this.mView;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void show() {
            View view = this.mView;
            if (view != null) {
                if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                    view.requestFocus();
                } else {
                    view = view.getRootView().findFocus();
                }
                if (view == null) {
                    view = this.mView.getRootView().findViewById(16908290);
                }
                if (view != null && view.hasWindowFocus()) {
                    view.post(new C0374y(view));
                }
            }
        }
    }

    public SoftwareKeyboardControllerCompat(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(view);
        } else {
            this.mImpl = new Impl20(view);
        }
    }

    public void hide() {
        this.mImpl.hide();
    }

    public void show() {
        this.mImpl.show();
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl20 {
        @Nullable
        private View mView;
        @Nullable
        private WindowInsetsController mWindowInsetsController;

        Impl30(@NonNull View view) {
            super(view);
            this.mView = view;
        }

        public static /* synthetic */ void b(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i5) {
            boolean z4;
            if ((i5 & 8) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            atomicBoolean.set(z4);
        }

        /* access modifiers changed from: package-private */
        public void hide() {
            View view;
            WindowInsetsController windowInsetsController = this.mWindowInsetsController;
            if (windowInsetsController == null) {
                View view2 = this.mView;
                if (view2 != null) {
                    windowInsetsController = view2.getWindowInsetsController();
                } else {
                    windowInsetsController = null;
                }
            }
            if (windowInsetsController != null) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                F f5 = new F(atomicBoolean);
                windowInsetsController.addOnControllableInsetsChangedListener(f5);
                if (!atomicBoolean.get() && (view = this.mView) != null) {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(f5);
                windowInsetsController.hide(WindowInsets.Type.ime());
                return;
            }
            super.hide();
        }

        /* access modifiers changed from: package-private */
        public void show() {
            View view = this.mView;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.mWindowInsetsController;
            if (windowInsetsController == null) {
                View view2 = this.mView;
                if (view2 != null) {
                    windowInsetsController = view2.getWindowInsetsController();
                } else {
                    windowInsetsController = null;
                }
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            super.show();
        }

        Impl30(@Nullable WindowInsetsController windowInsetsController) {
            super((View) null);
            this.mWindowInsetsController = windowInsetsController;
        }
    }

    @RequiresApi(30)
    @Deprecated
    SoftwareKeyboardControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.mImpl = new Impl30(windowInsetsController);
    }
}
