package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.shape.MaterialShapeDrawable;

public class BottomSheetDialog extends AppCompatDialog {
    @Nullable
    private MaterialBackOrchestrator backOrchestrator;
    /* access modifiers changed from: private */
    public BottomSheetBehavior<FrameLayout> behavior;
    /* access modifiers changed from: private */
    public FrameLayout bottomSheet;
    @NonNull
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    /* access modifiers changed from: private */
    public EdgeToEdgeCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    private static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {
        @NonNull
        private final WindowInsetsCompat insetsCompat;
        @Nullable
        private final Boolean lightBottomSheet;
        private boolean lightStatusBar;
        @Nullable
        private Window window;

        private void setPaddingForPosition(View view) {
            boolean z4;
            if (view.getTop() < this.insetsCompat.getSystemWindowInsetTop()) {
                Window window2 = this.window;
                if (window2 != null) {
                    Boolean bool = this.lightBottomSheet;
                    if (bool == null) {
                        z4 = this.lightStatusBar;
                    } else {
                        z4 = bool.booleanValue();
                    }
                    EdgeToEdgeUtils.setLightStatusBar(window2, z4);
                }
                view.setPadding(view.getPaddingLeft(), this.insetsCompat.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                Window window3 = this.window;
                if (window3 != null) {
                    EdgeToEdgeUtils.setLightStatusBar(window3, this.lightStatusBar);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        /* access modifiers changed from: package-private */
        public void onLayout(@NonNull View view) {
            setPaddingForPosition(view);
        }

        public void onSlide(@NonNull View view, float f5) {
            setPaddingForPosition(view);
        }

        public void onStateChanged(@NonNull View view, int i5) {
            setPaddingForPosition(view);
        }

        /* access modifiers changed from: package-private */
        public void setWindow(@Nullable Window window2) {
            if (this.window != window2) {
                this.window = window2;
                if (window2 != null) {
                    this.lightStatusBar = WindowCompat.getInsetsController(window2, window2.getDecorView()).isAppearanceLightStatusBars();
                }
            }
        }

        private EdgeToEdgeCallback(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ColorStateList colorStateList;
            this.insetsCompat = windowInsetsCompat;
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.from(view).getMaterialShapeDrawable();
            if (materialShapeDrawable != null) {
                colorStateList = materialShapeDrawable.getFillColor();
            } else {
                colorStateList = view.getBackgroundTintList();
            }
            if (colorStateList != null) {
                this.lightBottomSheet = Boolean.valueOf(MaterialColors.isColorLight(colorStateList.getDefaultColor()));
                return;
            }
            Integer backgroundColor = ViewUtils.getBackgroundColor(view);
            if (backgroundColor != null) {
                this.lightBottomSheet = Boolean.valueOf(MaterialColors.isColorLight(backgroundColor.intValue()));
            } else {
                this.lightBottomSheet = null;
            }
        }
    }

    public BottomSheetDialog(@NonNull Context context) {
        this(context, 0);
        initialize();
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, (ViewGroup) null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
            this.behavior = from;
            from.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
            this.backOrchestrator = new MaterialBackOrchestrator(this.behavior, this.bottomSheet);
        }
        return this.container;
    }

    private static int getThemeResId(@NonNull Context context, int i5) {
        if (i5 != 0) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return R.style.Theme_Design_Light_BottomSheetDialog;
    }

    private void initialize() {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge});
        this.edgeToEdgeEnabled = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }

    @Deprecated
    public static void setLightStatusBar(@NonNull View view, boolean z4) {
        int i5;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z4) {
            i5 = systemUiVisibility | 8192;
        } else {
            i5 = systemUiVisibility & -8193;
        }
        view.setSystemUiVisibility(i5);
    }

    private void updateListeningForBackCallbacks() {
        MaterialBackOrchestrator materialBackOrchestrator = this.backOrchestrator;
        if (materialBackOrchestrator != null) {
            if (this.cancelable) {
                materialBackOrchestrator.startListeningForBackCallbacks();
            } else {
                materialBackOrchestrator.stopListeningForBackCallbacks();
            }
        }
    }

    private View wrapInBottomSheet(int i5, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (i5 != 0 && view == null) {
            view = getLayoutInflater().inflate(i5, coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            ViewCompat.setOnApplyWindowInsetsListener(this.container, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    if (BottomSheetDialog.this.edgeToEdgeCallback != null) {
                        BottomSheetDialog.this.behavior.removeBottomSheetCallback(BottomSheetDialog.this.edgeToEdgeCallback);
                    }
                    if (windowInsetsCompat != null) {
                        BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                        EdgeToEdgeCallback unused = bottomSheetDialog.edgeToEdgeCallback = new EdgeToEdgeCallback(bottomSheetDialog.bottomSheet, windowInsetsCompat);
                        BottomSheetDialog.this.edgeToEdgeCallback.setWindow(BottomSheetDialog.this.getWindow());
                        BottomSheetDialog.this.behavior.addBottomSheetCallback(BottomSheetDialog.this.edgeToEdgeCallback);
                    }
                    return windowInsetsCompat;
                }
            });
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.cancelable && bottomSheetDialog.isShowing() && BottomSheetDialog.this.shouldWindowCloseOnTouchOutside()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (BottomSheetDialog.this.cancelable) {
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                    return;
                }
                accessibilityNodeInfoCompat.setDismissable(false);
            }

            public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
                if (i5 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.cancelable) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view, i5, bundle);
            }
        });
        this.bottomSheet.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.container;
    }

    public void cancel() {
        BottomSheetBehavior<FrameLayout> behavior2 = getBehavior();
        if (!this.dismissWithAnimation || behavior2.getState() == 5) {
            super.cancel();
        } else {
            behavior2.setState(5);
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    public void onAttachedToWindow() {
        boolean z4;
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            if (!this.edgeToEdgeEnabled || Color.alpha(window.getNavigationBarColor()) >= 255) {
                z4 = false;
            } else {
                z4 = true;
            }
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z4);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z4);
            }
            WindowCompat.setDecorFitsSystemWindows(window, !z4);
            EdgeToEdgeCallback edgeToEdgeCallback2 = this.edgeToEdgeCallback;
            if (edgeToEdgeCallback2 != null) {
                edgeToEdgeCallback2.setWindow(window);
            }
        }
        updateListeningForBackCallbacks();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    public void onDetachedFromWindow() {
        EdgeToEdgeCallback edgeToEdgeCallback2 = this.edgeToEdgeCallback;
        if (edgeToEdgeCallback2 != null) {
            edgeToEdgeCallback2.setWindow((Window) null);
        }
        MaterialBackOrchestrator materialBackOrchestrator = this.backOrchestrator;
        if (materialBackOrchestrator != null) {
            materialBackOrchestrator.stopListeningForBackCallbacks();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 5) {
            this.behavior.setState(4);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    public void setCancelable(boolean z4) {
        super.setCancelable(z4);
        if (this.cancelable != z4) {
            this.cancelable = z4;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z4);
            }
            if (getWindow() != null) {
                updateListeningForBackCallbacks();
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z4) {
        super.setCanceledOnTouchOutside(z4);
        if (z4 && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z4;
        this.canceledOnTouchOutsideSet = true;
    }

    public void setContentView(@LayoutRes int i5) {
        super.setContentView(wrapInBottomSheet(i5, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void setDismissWithAnimation(boolean z4) {
        this.dismissWithAnimation = z4;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, (ViewGroup.LayoutParams) null));
    }

    public BottomSheetDialog(@NonNull Context context, @StyleRes int i5) {
        super(context, getThemeResId(context, i5));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(@NonNull View view, float f5) {
            }

            public void onStateChanged(@NonNull View view, int i5) {
                if (i5 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
        initialize();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    protected BottomSheetDialog(@NonNull Context context, boolean z4, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z4, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(@NonNull View view, float f5) {
            }

            public void onStateChanged(@NonNull View view, int i5) {
                if (i5 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
        this.cancelable = z4;
        initialize();
    }
}
