package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.GravityInt;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.sidesheet.SheetCallback;

abstract class SheetDialog<C extends SheetCallback> extends AppCompatDialog {
    private static final int COORDINATOR_LAYOUT_ID = R.id.coordinator;
    private static final int TOUCH_OUTSIDE_ID = R.id.touch_outside;
    @Nullable
    private MaterialBackOrchestrator backOrchestrator;
    @Nullable
    private Sheet<C> behavior;
    boolean cancelable = true;
    private boolean canceledOnTouchOutside = true;
    private boolean canceledOnTouchOutsideSet;
    @Nullable
    private FrameLayout container;
    boolean dismissWithAnimation;
    @Nullable
    private FrameLayout sheet;

    SheetDialog(@NonNull Context context, @StyleRes int i5, @AttrRes int i6, @StyleRes int i7) {
        super(context, getThemeResId(context, i5, i6, i7));
        supportRequestWindowFeature(1);
    }

    public static /* synthetic */ void b(SheetDialog sheetDialog, View view) {
        if (sheetDialog.cancelable && sheetDialog.isShowing() && sheetDialog.shouldWindowCloseOnTouchOutside()) {
            sheetDialog.cancel();
        }
    }

    private void ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), getLayoutResId(), (ViewGroup) null);
            this.container = frameLayout;
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(getDialogId());
            this.sheet = frameLayout2;
            Sheet<C> behaviorFromSheet = getBehaviorFromSheet(frameLayout2);
            this.behavior = behaviorFromSheet;
            addSheetCancelOnHideCallback(behaviorFromSheet);
            this.backOrchestrator = new MaterialBackOrchestrator(this.behavior, this.sheet);
        }
    }

    @NonNull
    private FrameLayout getContainer() {
        if (this.container == null) {
            ensureContainerAndBehavior();
        }
        return this.container;
    }

    @NonNull
    private FrameLayout getSheet() {
        if (this.sheet == null) {
            ensureContainerAndBehavior();
        }
        return this.sheet;
    }

    private static int getThemeResId(@NonNull Context context, @StyleRes int i5, @AttrRes int i6, @StyleRes int i7) {
        if (i5 != 0) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i6, typedValue, true)) {
            return typedValue.resourceId;
        }
        return i7;
    }

    private void maybeUpdateWindowAnimationsBasedOnLayoutDirection() {
        FrameLayout frameLayout;
        int i5;
        Window window = getWindow();
        if (window != null && (frameLayout = this.sheet) != null && (frameLayout.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            if (Gravity.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) this.sheet.getLayoutParams()).gravity, this.sheet.getLayoutDirection()) == 3) {
                i5 = R.style.Animation_Material3_SideSheetDialog_Left;
            } else {
                i5 = R.style.Animation_Material3_SideSheetDialog_Right;
            }
            window.setWindowAnimations(i5);
        }
    }

    private boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
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

    private View wrapInSheet(int i5, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getContainer().findViewById(COORDINATOR_LAYOUT_ID);
        if (i5 != 0 && view == null) {
            view = getLayoutInflater().inflate(i5, coordinatorLayout, false);
        }
        FrameLayout sheet2 = getSheet();
        sheet2.removeAllViews();
        if (layoutParams == null) {
            sheet2.addView(view);
        } else {
            sheet2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(TOUCH_OUTSIDE_ID).setOnClickListener(new a(this));
        ViewCompat.setAccessibilityDelegate(getSheet(), new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (SheetDialog.this.cancelable) {
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                    return;
                }
                accessibilityNodeInfoCompat.setDismissable(false);
            }

            public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
                if (i5 == 1048576) {
                    SheetDialog sheetDialog = SheetDialog.this;
                    if (sheetDialog.cancelable) {
                        sheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view, i5, bundle);
            }
        });
        return this.container;
    }

    /* access modifiers changed from: package-private */
    public abstract void addSheetCancelOnHideCallback(Sheet<C> sheet2);

    public void cancel() {
        Sheet behavior2 = getBehavior();
        if (!this.dismissWithAnimation || behavior2.getState() == 5) {
            super.cancel();
        } else {
            behavior2.setState(5);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Sheet<C> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract Sheet<C> getBehaviorFromSheet(@NonNull FrameLayout frameLayout);

    /* access modifiers changed from: package-private */
    @IdRes
    public abstract int getDialogId();

    /* access modifiers changed from: package-private */
    @LayoutRes
    public abstract int getLayoutResId();

    /* access modifiers changed from: package-private */
    public abstract int getStateOnStart();

    public boolean isDismissWithSheetAnimationEnabled() {
        return this.dismissWithAnimation;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeUpdateWindowAnimationsBasedOnLayoutDirection();
        updateListeningForBackCallbacks();
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaterialBackOrchestrator materialBackOrchestrator = this.backOrchestrator;
        if (materialBackOrchestrator != null) {
            materialBackOrchestrator.stopListeningForBackCallbacks();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Sheet<C> sheet2 = this.behavior;
        if (sheet2 != null && sheet2.getState() == 5) {
            this.behavior.setState(getStateOnStart());
        }
    }

    public void setCancelable(boolean z4) {
        super.setCancelable(z4);
        if (this.cancelable != z4) {
            this.cancelable = z4;
        }
        if (getWindow() != null) {
            updateListeningForBackCallbacks();
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
        super.setContentView(wrapInSheet(i5, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void setDismissWithSheetAnimationEnabled(boolean z4) {
        this.dismissWithAnimation = z4;
    }

    public void setSheetEdge(@GravityInt int i5) {
        FrameLayout frameLayout = this.sheet;
        if (frameLayout == null) {
            throw new IllegalStateException("Sheet view reference is null; sheet edge cannot be changed if the sheet view is null.");
        } else if (!frameLayout.isLaidOut()) {
            ViewGroup.LayoutParams layoutParams = this.sheet.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                ((CoordinatorLayout.LayoutParams) layoutParams).gravity = i5;
                maybeUpdateWindowAnimationsBasedOnLayoutDirection();
            }
        } else {
            throw new IllegalStateException("Sheet view has been laid out; sheet edge cannot be changed once the sheet has been laid out.");
        }
    }

    public void setContentView(@Nullable View view) {
        super.setContentView(wrapInSheet(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(@Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInSheet(0, view, layoutParams));
    }
}
