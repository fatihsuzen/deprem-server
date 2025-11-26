package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean onNestedFling(ViewParent viewParent, View view, float f5, float f6, boolean z4) {
            return viewParent.onNestedFling(view, f5, f6, z4);
        }

        @DoNotInline
        static boolean onNestedPreFling(ViewParent viewParent, View view, float f5, float f6) {
            return viewParent.onNestedPreFling(view, f5, f6);
        }

        @DoNotInline
        static void onNestedPreScroll(ViewParent viewParent, View view, int i5, int i6, int[] iArr) {
            viewParent.onNestedPreScroll(view, i5, i6, iArr);
        }

        @DoNotInline
        static void onNestedScroll(ViewParent viewParent, View view, int i5, int i6, int i7, int i8) {
            viewParent.onNestedScroll(view, i5, i6, i7, i8);
        }

        @DoNotInline
        static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i5) {
            viewParent.onNestedScrollAccepted(view, view2, i5);
        }

        @DoNotInline
        static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i5) {
            return viewParent.onStartNestedScroll(view, view2, i5);
        }

        @DoNotInline
        static void onStopNestedScroll(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i5) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i5);
    }

    public static boolean onNestedFling(@NonNull ViewParent viewParent, @NonNull View view, float f5, float f6, boolean z4) {
        try {
            return Api21Impl.onNestedFling(viewParent, view, f5, f6, z4);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e5);
            return false;
        }
    }

    public static boolean onNestedPreFling(@NonNull ViewParent viewParent, @NonNull View view, float f5, float f6) {
        try {
            return Api21Impl.onNestedPreFling(viewParent, view, f5, f6);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e5);
            return false;
        }
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i5, int i6, @NonNull int[] iArr) {
        onNestedPreScroll(viewParent, view, i5, i6, iArr, 0);
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i5, int i6, int i7, int i8) {
        onNestedScroll(viewParent, view, i5, i6, i7, i8, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i5) {
        onNestedScrollAccepted(viewParent, view, view2, i5, 0);
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i5) {
        return onStartNestedScroll(viewParent, view, view2, i5, 0);
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i5, int i6, @NonNull int[] iArr, int i7) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i5, i6, iArr, i7);
        } else if (i7 == 0) {
            try {
                Api21Impl.onNestedPreScroll(viewParent, view, i5, i6, iArr);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e5);
            }
        }
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i5, int i6) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i5, i6);
        } else if (i6 == 0) {
            try {
                Api21Impl.onNestedScrollAccepted(viewParent, view, view2, i5);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e5);
            }
        }
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i5, int i6) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i5, i6);
        }
        if (i6 != 0) {
            return false;
        }
        try {
            return Api21Impl.onStartNestedScroll(viewParent, view, view2, i5);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e5);
            return false;
        }
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i5);
        } else if (i5 == 0) {
            try {
                Api21Impl.onStopNestedScroll(viewParent, view);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e5);
            }
        }
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i5, int i6, int i7, int i8, int i9) {
        onNestedScroll(viewParent, view, i5, i6, i7, i8, i9, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i5, int i6, int i7, int i8, int i9, @NonNull int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view, i5, i6, i7, i8, i9, iArr);
            return;
        }
        int i10 = i5;
        View view2 = view;
        int[] iArr2 = iArr;
        int i11 = i9;
        int i12 = i8;
        int i13 = i7;
        int i14 = i6;
        int i15 = i10;
        iArr2[0] = iArr2[0] + i13;
        iArr2[1] = iArr2[1] + i12;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view2, i15, i14, i13, i12, i11);
        } else if (i11 == 0) {
            ViewParent viewParent2 = viewParent;
            try {
                Api21Impl.onNestedScroll(viewParent2, view2, i15, i14, i13, i12);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent2 + " does not implement interface method onNestedScroll", e5);
            }
        }
    }
}
