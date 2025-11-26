package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float alphaEndSwipeDistance = 0.5f;
    float alphaStartSwipeDistance = 0.0f;
    private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId = -1;
        private int originalCapturedViewLeft;

        private boolean shouldDismiss(@NonNull View view, float f5) {
            boolean z4;
            int i5 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
            if (i5 != 0) {
                if (view.getLayoutDirection() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i6 = SwipeDismissBehavior.this.swipeDirection;
                if (i6 == 2) {
                    return true;
                }
                if (i6 != 0) {
                    if (i6 == 1) {
                        if (z4) {
                            if (i5 > 0) {
                                return true;
                            }
                            return false;
                        } else if (f5 < 0.0f) {
                            return true;
                        }
                    }
                    return false;
                } else if (z4) {
                    if (f5 < 0.0f) {
                        return true;
                    }
                    return false;
                } else if (i5 > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (Math.abs(view.getLeft() - this.originalCapturedViewLeft) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.dragDismissThreshold)) {
                    return true;
                }
                return false;
            }
        }

        public int clampViewPositionHorizontal(@NonNull View view, int i5, int i6) {
            boolean z4;
            int i7;
            int i8;
            int width;
            if (view.getLayoutDirection() == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            int i9 = SwipeDismissBehavior.this.swipeDirection;
            if (i9 != 0) {
                if (i9 != 1) {
                    i7 = this.originalCapturedViewLeft - view.getWidth();
                    i8 = view.getWidth() + this.originalCapturedViewLeft;
                } else if (z4) {
                    i7 = this.originalCapturedViewLeft;
                    width = view.getWidth();
                } else {
                    i7 = this.originalCapturedViewLeft - view.getWidth();
                    i8 = this.originalCapturedViewLeft;
                }
                return SwipeDismissBehavior.clamp(i7, i5, i8);
            } else if (z4) {
                i7 = this.originalCapturedViewLeft - view.getWidth();
                i8 = this.originalCapturedViewLeft;
                return SwipeDismissBehavior.clamp(i7, i5, i8);
            } else {
                i7 = this.originalCapturedViewLeft;
                width = view.getWidth();
            }
            i8 = width + i7;
            return SwipeDismissBehavior.clamp(i7, i5, i8);
        }

        public int clampViewPositionVertical(@NonNull View view, int i5, int i6) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        public void onViewCaptured(@NonNull View view, int i5) {
            this.activePointerId = i5;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                boolean unused = SwipeDismissBehavior.this.requestingDisallowInterceptTouchEvent = true;
                parent.requestDisallowInterceptTouchEvent(true);
                boolean unused2 = SwipeDismissBehavior.this.requestingDisallowInterceptTouchEvent = false;
            }
        }

        public void onViewDragStateChanged(int i5) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i5);
            }
        }

        public void onViewPositionChanged(@NonNull View view, int i5, int i6, int i7, int i8) {
            float width = ((float) view.getWidth()) * SwipeDismissBehavior.this.alphaStartSwipeDistance;
            float width2 = ((float) view.getWidth()) * SwipeDismissBehavior.this.alphaEndSwipeDistance;
            float abs = (float) Math.abs(i5 - this.originalCapturedViewLeft);
            if (abs <= width) {
                view.setAlpha(1.0f);
            } else if (abs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp(0.0f, 1.0f - SwipeDismissBehavior.fraction(width, width2, abs), 1.0f));
            }
        }

        public void onViewReleased(@NonNull View view, float f5, float f6) {
            boolean z4;
            int i5;
            OnDismissListener onDismissListener;
            int i6;
            this.activePointerId = -1;
            int width = view.getWidth();
            if (shouldDismiss(view, f5)) {
                if (f5 < 0.0f || view.getLeft() < (i6 = this.originalCapturedViewLeft)) {
                    i5 = this.originalCapturedViewLeft - width;
                } else {
                    i5 = i6 + width;
                }
                z4 = true;
            } else {
                i5 = this.originalCapturedViewLeft;
                z4 = false;
            }
            if (SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(i5, view.getTop())) {
                view.postOnAnimation(new SettleRunnable(view, z4));
            } else if (z4 && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(view);
            }
        }

        public boolean tryCaptureView(View view, int i5) {
            int i6 = this.activePointerId;
            if ((i6 == -1 || i6 == i5) && SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                return true;
            }
            return false;
        }
    };
    float dragDismissThreshold = 0.5f;
    private boolean interceptingEvents;
    OnDismissListener listener;
    /* access modifiers changed from: private */
    public boolean requestingDisallowInterceptTouchEvent;
    private float sensitivity = 0.0f;
    private boolean sensitivitySet;
    int swipeDirection = 2;
    ViewDragHelper viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i5);
    }

    private class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        SettleRunnable(View view2, boolean z4) {
            this.view = view2;
            this.dismiss = z4;
        }

        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                this.view.postOnAnimation(this);
            } else if (this.dismiss && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(this.view);
            }
        }
    }

    static float clamp(float f5, float f6, float f7) {
        return Math.min(Math.max(f5, f6), f7);
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        ViewDragHelper viewDragHelper2;
        if (this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                viewDragHelper2 = ViewDragHelper.create(viewGroup, this.sensitivity, this.dragCallback);
            } else {
                viewDragHelper2 = ViewDragHelper.create(viewGroup, this.dragCallback);
            }
            this.viewDragHelper = viewDragHelper2;
        }
    }

    static float fraction(float f5, float f6, float f7) {
        return (f7 - f5) / (f6 - f5);
    }

    private void updateAccessibilityActions(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (canSwipeDismissView(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, (CharSequence) null, new AccessibilityViewCommand() {
                public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                    int i5;
                    boolean z4 = false;
                    if (!SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                        return false;
                    }
                    if (view.getLayoutDirection() == 1) {
                        z4 = true;
                    }
                    int i6 = SwipeDismissBehavior.this.swipeDirection;
                    if ((i6 != 0 || !z4) && (i6 != 1 || z4)) {
                        i5 = view.getWidth();
                    } else {
                        i5 = -view.getWidth();
                    }
                    ViewCompat.offsetLeftAndRight(view, i5);
                    view.setAlpha(0.0f);
                    OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(view);
                    }
                    return true;
                }
            });
        }
    }

    public boolean canSwipeDismissView(@NonNull View view) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 != null) {
            return viewDragHelper2.getViewDragState();
        }
        return 0;
    }

    @VisibleForTesting
    @Nullable
    public OnDismissListener getListener() {
        return this.listener;
    }

    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull MotionEvent motionEvent) {
        boolean z4 = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z4 = coordinatorLayout.isPointInChildBounds(v5, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z4;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (z4) {
            ensureViewDragHelper(coordinatorLayout);
            if (this.requestingDisallowInterceptTouchEvent || !this.viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i5) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v5, i5);
        if (v5.getImportantForAccessibility() == 0) {
            v5.setImportantForAccessibility(1);
            updateAccessibilityActions(v5);
        }
        return onLayoutChild;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        if (this.viewDragHelper == null) {
            return false;
        }
        if (this.requestingDisallowInterceptTouchEvent && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    public void setDragDismissDistance(float f5) {
        this.dragDismissThreshold = clamp(0.0f, f5, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f5) {
        this.alphaEndSwipeDistance = clamp(0.0f, f5, 1.0f);
    }

    public void setListener(@Nullable OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public void setSensitivity(float f5) {
        this.sensitivity = f5;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float f5) {
        this.alphaStartSwipeDistance = clamp(0.0f, f5, 1.0f);
    }

    public void setSwipeDirection(int i5) {
        this.swipeDirection = i5;
    }

    static int clamp(int i5, int i6, int i7) {
        return Math.min(Math.max(i5, i6), i7);
    }
}
