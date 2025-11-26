package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR;
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS;
    @Nullable
    private final AccessibilityManager accessibilityManager;
    @Nullable
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        public void onDismissed(Snackbar snackbar, int i5) {
        }

        public void onShown(Snackbar snackbar) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i5, int i6) {
            super.onMeasure(i5, i6);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    static {
        int i5 = R.attr.snackbarButtonStyle;
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{i5};
        SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{i5, R.attr.snackbarTextViewStyle};
    }

    private Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        super(context, viewGroup, view, contentViewCallback);
        this.accessibilityManager = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static /* synthetic */ void a(Snackbar snackbar, View.OnClickListener onClickListener, View view) {
        snackbar.getClass();
        onClickListener.onClick(view);
        snackbar.dispatchDismiss(1);
    }

    @Nullable
    private static ViewGroup findSuitableParent(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private Button getActionView() {
        return getContentLayout().getActionView();
    }

    private SnackbarContentLayout getContentLayout() {
        return (SnackbarContentLayout) this.view.getChildAt(0);
    }

    private TextView getMessageView() {
        return getContentLayout().getMessageView();
    }

    @Deprecated
    protected static boolean hasSnackbarButtonStyleAttr(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            return true;
        }
        return false;
    }

    private static boolean hasSnackbarContentStyleAttrs(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        if (resourceId == -1 || resourceId2 == -1) {
            return false;
        }
        return true;
    }

    @NonNull
    public static Snackbar make(@NonNull View view, @NonNull CharSequence charSequence, int i5) {
        return makeInternal((Context) null, view, charSequence, i5);
    }

    @NonNull
    private static Snackbar makeInternal(@Nullable Context context, @NonNull View view, @NonNull CharSequence charSequence, int i5) {
        int i6;
        ViewGroup findSuitableParent = findSuitableParent(view);
        if (findSuitableParent != null) {
            if (context == null) {
                context = findSuitableParent.getContext();
            }
            LayoutInflater from = LayoutInflater.from(context);
            if (hasSnackbarContentStyleAttrs(context)) {
                i6 = R.layout.mtrl_layout_snackbar_include;
            } else {
                i6 = R.layout.design_layout_snackbar_include;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(i6, findSuitableParent, false);
            Snackbar snackbar = new Snackbar(context, findSuitableParent, snackbarContentLayout, snackbarContentLayout);
            snackbar.setText(charSequence);
            snackbar.setDuration(i5);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    public void dismiss() {
        super.dismiss();
    }

    public int getDuration() {
        int i5;
        int duration = super.getDuration();
        if (duration == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.hasAction) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            return this.accessibilityManager.getRecommendedTimeoutMillis(duration, i5 | 3);
        } else if (!this.hasAction || !this.accessibilityManager.isTouchExplorationEnabled()) {
            return duration;
        } else {
            return -2;
        }
    }

    public boolean isShown() {
        return super.isShown();
    }

    @NonNull
    public Snackbar setAction(@StringRes int i5, View.OnClickListener onClickListener) {
        return setAction(getContext().getText(i5), onClickListener);
    }

    @NonNull
    public Snackbar setActionTextColor(ColorStateList colorStateList) {
        getActionView().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    public Snackbar setBackgroundTint(@ColorInt int i5) {
        return setBackgroundTintList(ColorStateList.valueOf(i5));
    }

    @NonNull
    public Snackbar setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.view.setBackgroundTintList(colorStateList);
        return this;
    }

    @NonNull
    public Snackbar setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        this.view.setBackgroundTintMode(mode);
        return this;
    }

    @NonNull
    @Deprecated
    public Snackbar setCallback(@Nullable Callback callback2) {
        BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback = this.callback;
        if (baseCallback != null) {
            removeCallback(baseCallback);
        }
        if (callback2 != null) {
            addCallback(callback2);
        }
        this.callback = callback2;
        return this;
    }

    @NonNull
    public Snackbar setMaxInlineActionWidth(@Dimension int i5) {
        getContentLayout().setMaxInlineActionWidth(i5);
        return this;
    }

    @NonNull
    public Snackbar setText(@NonNull CharSequence charSequence) {
        getMessageView().setText(charSequence);
        return this;
    }

    @NonNull
    public Snackbar setTextColor(ColorStateList colorStateList) {
        getMessageView().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    public Snackbar setTextMaxLines(int i5) {
        getMessageView().setMaxLines(i5);
        return this;
    }

    public void show() {
        super.show();
    }

    @NonNull
    public static Snackbar make(@NonNull View view, @StringRes int i5, int i6) {
        return make(view, view.getResources().getText(i5), i6);
    }

    @NonNull
    public Snackbar setAction(@Nullable CharSequence charSequence, @Nullable View.OnClickListener onClickListener) {
        Button actionView = getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener((View.OnClickListener) null);
            this.hasAction = false;
            return this;
        }
        this.hasAction = true;
        actionView.setVisibility(0);
        actionView.setText(charSequence);
        actionView.setOnClickListener(new a(this, onClickListener));
        return this;
    }

    @NonNull
    public Snackbar setActionTextColor(@ColorInt int i5) {
        getActionView().setTextColor(i5);
        return this;
    }

    @NonNull
    public Snackbar setText(@StringRes int i5) {
        return setText(getContext().getText(i5));
    }

    @NonNull
    public Snackbar setTextColor(@ColorInt int i5) {
        getMessageView().setTextColor(i5);
        return this;
    }

    @NonNull
    public static Snackbar make(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i5) {
        return makeInternal(context, view, charSequence, i5);
    }
}
