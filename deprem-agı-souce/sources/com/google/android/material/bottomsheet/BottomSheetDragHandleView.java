package com.google.android.material.bottomsheet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_BottomSheet_DragHandle;
    @Nullable
    private final AccessibilityManager accessibilityManager;
    /* access modifiers changed from: private */
    @Nullable
    public BottomSheetBehavior<?> bottomSheetBehavior;
    private final BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    private final String clickToCollapseActionLabel;
    private boolean clickToExpand;
    private final String clickToExpandActionLabel;
    private final GestureDetector gestureDetector;
    private final GestureDetector.OnGestureListener gestureListener;
    private boolean hasClickListener;
    private boolean hasTouchListener;

    public BottomSheetDragHandleView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r1 != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean expandOrCollapseBottomSheetIfPossible() {
        /*
            r6 = this;
            boolean r0 = r6.hasAttachedBehavior()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            com.google.android.material.bottomsheet.BottomSheetBehavior<?> r0 = r6.bottomSheetBehavior
            boolean r0 = r0.isFitToContents()
            r2 = 1
            if (r0 != 0) goto L_0x001a
            com.google.android.material.bottomsheet.BottomSheetBehavior<?> r0 = r6.bottomSheetBehavior
            boolean r0 = r0.shouldSkipHalfExpandedStateWhenDragging()
            if (r0 != 0) goto L_0x001a
            r1 = r2
        L_0x001a:
            com.google.android.material.bottomsheet.BottomSheetBehavior<?> r0 = r6.bottomSheetBehavior
            int r0 = r0.getState()
            r3 = 6
            r4 = 3
            r5 = 4
            if (r0 != r5) goto L_0x0028
            if (r1 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0028:
            if (r0 != r4) goto L_0x002f
            if (r1 == 0) goto L_0x002d
            goto L_0x0036
        L_0x002d:
            r3 = r5
            goto L_0x0036
        L_0x002f:
            boolean r0 = r6.clickToExpand
            if (r0 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r4 = r5
        L_0x0035:
            r3 = r4
        L_0x0036:
            com.google.android.material.bottomsheet.BottomSheetBehavior<?> r0 = r6.bottomSheetBehavior
            r0.setState(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetDragHandleView.expandOrCollapseBottomSheetIfPossible():boolean");
    }

    @Nullable
    private BottomSheetBehavior<?> findParentBottomSheetBehavior() {
        View view = this;
        while (true) {
            view = getParentView(view);
            if (view == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
                if (behavior instanceof BottomSheetBehavior) {
                    return (BottomSheetBehavior) behavior;
                }
            }
        }
    }

    @Nullable
    private static View getParentView(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    private boolean hasAttachedBehavior() {
        if (this.bottomSheetBehavior != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void onBottomSheetStateChanged(int i5) {
        String str;
        if (i5 == 4) {
            this.clickToExpand = true;
        } else if (i5 == 3) {
            this.clickToExpand = false;
        }
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK;
        if (this.clickToExpand) {
            str = this.clickToExpandActionLabel;
        } else {
            str = this.clickToCollapseActionLabel;
        }
        ViewCompat.replaceAccessibilityAction(this, accessibilityActionCompat, str, new c(this));
    }

    private void setBottomSheetBehavior(@Nullable BottomSheetBehavior<?> bottomSheetBehavior2) {
        BottomSheetBehavior<?> bottomSheetBehavior3 = this.bottomSheetBehavior;
        if (bottomSheetBehavior3 != null) {
            bottomSheetBehavior3.removeBottomSheetCallback(this.bottomSheetCallback);
            this.bottomSheetBehavior.setAccessibilityDelegateView((View) null);
            this.bottomSheetBehavior.setDragHandleView((BottomSheetDragHandleView) null);
        }
        this.bottomSheetBehavior = bottomSheetBehavior2;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.setAccessibilityDelegateView(this);
            this.bottomSheetBehavior.setDragHandleView(this);
            onBottomSheetStateChanged(this.bottomSheetBehavior.getState());
            this.bottomSheetBehavior.addBottomSheetCallback(this.bottomSheetCallback);
        }
        setClickable(hasAttachedBehavior());
    }

    public void onAccessibilityStateChanged(boolean z4) {
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(findParentBottomSheetBehavior());
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null) {
            accessibilityManager2.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.accessibilityManager.isEnabled());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null) {
            accessibilityManager2.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior((BottomSheetBehavior<?>) null);
        super.onDetachedFromWindow();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hasClickListener || this.hasTouchListener) {
            return super.onTouchEvent(motionEvent);
        }
        return this.gestureDetector.onTouchEvent(motionEvent);
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        boolean z4;
        if (onClickListener != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.hasClickListener = z4;
        super.setOnClickListener(onClickListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        boolean z4;
        if (onTouchListener != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.hasTouchListener = z4;
        super.setOnTouchListener(onTouchListener);
    }

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomSheetDragHandleStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i5, DEF_STYLE_RES), attributeSet, i5);
        this.hasTouchListener = false;
        this.hasClickListener = false;
        this.clickToExpandActionLabel = getResources().getString(R.string.bottomsheet_action_expand);
        this.clickToCollapseActionLabel = getResources().getString(R.string.bottomsheet_action_collapse);
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(@NonNull View view, float f5) {
            }

            public void onStateChanged(@NonNull View view, int i5) {
                BottomSheetDragHandleView.this.onBottomSheetStateChanged(i5);
            }
        };
        AnonymousClass2 r32 = new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(@NonNull MotionEvent motionEvent) {
                if (BottomSheetDragHandleView.this.bottomSheetBehavior == null || !BottomSheetDragHandleView.this.bottomSheetBehavior.isHideable()) {
                    return super.onDoubleTap(motionEvent);
                }
                BottomSheetDragHandleView.this.bottomSheetBehavior.setState(5);
                return true;
            }

            public boolean onDown(@NonNull MotionEvent motionEvent) {
                return BottomSheetDragHandleView.this.isClickable();
            }

            public boolean onSingleTapConfirmed(@NonNull MotionEvent motionEvent) {
                return BottomSheetDragHandleView.this.expandOrCollapseBottomSheetIfPossible();
            }
        };
        this.gestureListener = r32;
        Context context2 = getContext();
        this.gestureDetector = new GestureDetector(context2, r32, new Handler(Looper.getMainLooper()));
        this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() {
            public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                if (accessibilityEvent.getEventType() == 1) {
                    boolean unused = BottomSheetDragHandleView.this.expandOrCollapseBottomSheetIfPossible();
                }
            }
        });
    }
}
