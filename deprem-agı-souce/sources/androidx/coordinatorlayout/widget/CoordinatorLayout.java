package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import j$.util.DesugarCollections;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    static final Class<?>[] CONSTRUCTOR_PARAMS = {Context.class, AttributeSet.class};
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = new ThreadLocal<>();
    private static final Pools.Pool<Rect> sRectPool = new Pools.SynchronizedPool(12);
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        @Nullable
        public static Object getTag(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mBehaviorTag;
        }

        public static void setTag(@NonNull View view, @Nullable Object obj) {
            ((LayoutParams) view.getLayoutParams()).mBehaviorTag = obj;
        }

        public boolean blocksInteractionBelow(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5) {
            if (getScrimOpacity(coordinatorLayout, v5) > 0.0f) {
                return true;
            }
            return false;
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull Rect rect) {
            return false;
        }

        @ColorInt
        public int getScrimColor(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getScrimOpacity(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5) {
            return 0.0f;
        }

        public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams layoutParams) {
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view) {
            return false;
        }

        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i5) {
            return false;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i5, int i6, int i7, int i8) {
            return false;
        }

        public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, float f5, float f6, boolean z4) {
            return false;
        }

        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, float f5, float f6) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i5, int i6, @NonNull int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i5, int i6, int i7, int i8) {
        }

        @Deprecated
        public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, @NonNull View view2, int i5) {
        }

        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull Rect rect, boolean z4) {
            return false;
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull Parcelable parcelable) {
        }

        @Nullable
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, @NonNull View view2, int i5) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view) {
        }

        public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i5, int i6, @NonNull int[] iArr, int i7) {
            if (i7 == 0) {
                onNestedPreScroll(coordinatorLayout, v5, view, i5, i6, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i5, int i6, int i7, int i8, int i9) {
            if (i9 == 0) {
                onNestedScroll(coordinatorLayout, v5, view, i5, i6, i7, i8);
            }
        }

        public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, @NonNull View view2, int i5, int i6) {
            if (i6 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v5, view, view2, i5);
            }
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, @NonNull View view2, int i5, int i6) {
            if (i6 == 0) {
                return onStartNestedScroll(coordinatorLayout, v5, view, view2, i5);
            }
            return false;
        }

        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i5) {
            if (i5 == 0) {
                onStopNestedScroll(coordinatorLayout, v5, view);
            }
        }

        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i5, int i6, int i7, int i8, int i9, @NonNull int[] iArr) {
            iArr[0] = iArr[0] + i7;
            iArr[1] = iArr[1] + i8;
            onNestedScroll(coordinatorLayout, v5, view, i5, i6, i7, i8, i9);
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DispatchChangeEvent {
    }

    private class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        HierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        OnPreDrawListener() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        public int compare(View view, View view2) {
            float z4 = ViewCompat.getZ(view);
            float z5 = ViewCompat.getZ(view2);
            if (z4 > z5) {
                return -1;
            }
            return z4 < z5 ? 1 : 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.getName()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            WIDGET_PACKAGE_NAME = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$ViewElevationComparator r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$ViewElevationComparator
            r0.<init>()
            TOP_SORTED_CHILDREN_COMPARATOR = r0
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            r2 = 0
            r0[r2] = r1
            java.lang.Class<android.util.AttributeSet> r1 = android.util.AttributeSet.class
            r2 = 1
            r0[r2] = r1
            CONSTRUCTOR_PARAMS = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            sConstructors = r0
            androidx.core.util.Pools$SynchronizedPool r0 = new androidx.core.util.Pools$SynchronizedPool
            r1 = 12
            r0.<init>(r1)
            sRectPool = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    private static Rect acquireTempRect() {
        Rect acquire = sRectPool.acquire();
        if (acquire == null) {
            return new Rect();
        }
        return acquire;
    }

    private static int clamp(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : i5 > i7 ? i7 : i5;
    }

    private void constrainChildRect(LayoutParams layoutParams, Rect rect, int i5, int i6) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i5) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i6) - layoutParams.bottomMargin));
        rect.set(max, max2, i5 + max, i6 + max2);
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        Behavior behavior;
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (ViewCompat.getFitsSystemWindows(childAt) && (behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior()) != null) {
                windowInsetsCompat = behavior.onApplyWindowInsets(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.isConsumed()) {
                    return windowInsetsCompat;
                }
            }
        }
        return windowInsetsCompat;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i5, Rect rect, Rect rect2, LayoutParams layoutParams, int i6, int i7) {
        int i8;
        int i9;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(layoutParams.gravity), i5);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(resolveGravity(layoutParams.anchorGravity), i5);
        int i10 = absoluteGravity & 7;
        int i11 = absoluteGravity & 112;
        int i12 = absoluteGravity2 & 7;
        int i13 = absoluteGravity2 & 112;
        if (i12 == 1) {
            i8 = rect.left + (rect.width() / 2);
        } else if (i12 != 5) {
            i8 = rect.left;
        } else {
            i8 = rect.right;
        }
        if (i13 == 16) {
            i9 = rect.top + (rect.height() / 2);
        } else if (i13 != 80) {
            i9 = rect.top;
        } else {
            i9 = rect.bottom;
        }
        if (i10 == 1) {
            i8 -= i6 / 2;
        } else if (i10 != 5) {
            i8 -= i6;
        }
        if (i11 == 16) {
            i9 -= i7 / 2;
        } else if (i11 != 80) {
            i9 -= i7;
        }
        rect2.set(i8, i9, i6 + i8, i7 + i9);
    }

    private int getKeyline(int i5) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + i5);
            return 0;
        } else if (i5 >= 0 && i5 < iArr.length) {
            return iArr[i5];
        } else {
            Log.e(TAG, "Keyline index " + i5 + " out of range for " + this);
            return 0;
        }
    }

    private void getTopSortedChildren(List<View> list) {
        int i5;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            if (isChildrenDrawingOrderEnabled) {
                i5 = getChildDrawingOrder(childCount, i6);
            } else {
                i5 = i6;
            }
            list.add(getChildAt(i5));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.hasOutgoingEdges(view);
    }

    private void layoutChild(View view, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
            acquireTempRect.left += this.mLastInsets.getSystemWindowInsetLeft();
            acquireTempRect.top += this.mLastInsets.getSystemWindowInsetTop();
            acquireTempRect.right -= this.mLastInsets.getSystemWindowInsetRight();
            acquireTempRect.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        }
        Rect acquireTempRect2 = acquireTempRect();
        GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i5);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    private void layoutChildWithAnchor(View view, View view2, int i5) {
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i5, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i5, int i6) {
        int i7;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), i6);
        int i8 = absoluteGravity & 7;
        int i9 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i6 == 1) {
            i5 = width - i5;
        }
        int keyline = getKeyline(i5) - measuredWidth;
        if (i8 == 1) {
            keyline += measuredWidth / 2;
        } else if (i8 == 5) {
            keyline += measuredWidth;
        }
        if (i9 == 16) {
            i7 = measuredHeight / 2;
        } else if (i9 != 80) {
            i7 = 0;
        } else {
            i7 = measuredHeight;
        }
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(i7, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void offsetChildByInset(View view, Rect rect, int i5) {
        boolean z4;
        boolean z5;
        int width;
        int i6;
        int i7;
        int i8;
        int height;
        int i9;
        int i10;
        int i11;
        if (ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behavior == null || !behavior.getInsetDodgeRect(this, view, acquireTempRect)) {
                acquireTempRect.set(acquireTempRect2);
            } else if (!acquireTempRect2.contains(acquireTempRect)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect.toShortString() + " | Bounds:" + acquireTempRect2.toShortString());
            }
            releaseTempRect(acquireTempRect2);
            if (acquireTempRect.isEmpty()) {
                releaseTempRect(acquireTempRect);
                return;
            }
            int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.dodgeInsetEdges, i5);
            boolean z6 = true;
            if ((absoluteGravity & 48) != 48 || (i10 = (acquireTempRect.top - layoutParams.topMargin) - layoutParams.mInsetOffsetY) >= (i11 = rect.top)) {
                z4 = false;
            } else {
                setInsetOffsetY(view, i11 - i10);
                z4 = true;
            }
            if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - acquireTempRect.bottom) - layoutParams.bottomMargin) + layoutParams.mInsetOffsetY) < (i9 = rect.bottom)) {
                setInsetOffsetY(view, height - i9);
                z4 = true;
            }
            if (!z4) {
                setInsetOffsetY(view, 0);
            }
            if ((absoluteGravity & 3) != 3 || (i7 = (acquireTempRect.left - layoutParams.leftMargin) - layoutParams.mInsetOffsetX) >= (i8 = rect.left)) {
                z5 = false;
            } else {
                setInsetOffsetX(view, i8 - i7);
                z5 = true;
            }
            if ((absoluteGravity & 5) != 5 || (width = ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin) + layoutParams.mInsetOffsetX) >= (i6 = rect.right)) {
                z6 = z5;
            } else {
                setInsetOffsetX(view, width - i6);
            }
            if (!z6) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(acquireTempRect);
        }
    }

    static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = WIDGET_PACKAGE_NAME;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = sConstructors;
            Map map = threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e5) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e5);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i5) {
        MotionEvent motionEvent2 = motionEvent;
        int i6 = i5;
        int actionMasked = motionEvent2.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z4 = false;
        boolean z5 = false;
        for (int i7 = 0; i7 < size; i7++) {
            View view = list.get(i7);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            if ((!z4 && !z5) || actionMasked == 0) {
                if (!z4 && behavior != null) {
                    if (i6 == 0) {
                        z4 = behavior.onInterceptTouchEvent(this, view, motionEvent2);
                    } else if (i6 == 1) {
                        z4 = behavior.onTouchEvent(this, view, motionEvent2);
                    }
                    if (z4) {
                        this.mBehaviorTouchView = view;
                    }
                }
                boolean didBlockInteraction = layoutParams.didBlockInteraction();
                boolean isBlockingInteractionBelow = layoutParams.isBlockingInteractionBelow(this, view);
                if (!isBlockingInteractionBelow || didBlockInteraction) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (isBlockingInteractionBelow && !z5) {
                    break;
                }
            } else if (behavior != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i6 == 0) {
                    behavior.onInterceptTouchEvent(this, view, motionEvent3);
                } else if (i6 == 1) {
                    behavior.onTouchEvent(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z4;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.findAnchorView(this, childAt);
            this.mChildDag.addNode(childAt);
            for (int i6 = 0; i6 < childCount; i6++) {
                if (i6 != i5) {
                    View childAt2 = getChildAt(i6);
                    if (resolvedLayoutParams.dependsOn(this, childAt, childAt2)) {
                        if (!this.mChildDag.contains(childAt2)) {
                            this.mChildDag.addNode(childAt2);
                        }
                        this.mChildDag.addEdge(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(@NonNull Rect rect) {
        rect.setEmpty();
        sRectPool.release(rect);
    }

    private void resetTouchBehaviors(boolean z4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z4) {
                    behavior.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    behavior.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            ((LayoutParams) getChildAt(i6).getLayoutParams()).resetTouchBehaviorTracking();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int i5) {
        if (i5 == 0) {
            return 17;
        }
        return i5;
    }

    private static int resolveGravity(int i5) {
        if ((i5 & 7) == 0) {
            i5 |= GravityCompat.START;
        }
        return (i5 & 112) == 0 ? i5 | 48 : i5;
    }

    private static int resolveKeylineGravity(int i5) {
        if (i5 == 0) {
            return 8388661;
        }
        return i5;
    }

    private void setInsetOffsetX(View view, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i6 = layoutParams.mInsetOffsetX;
        if (i6 != i5) {
            ViewCompat.offsetLeftAndRight(view, i5 - i6);
            layoutParams.mInsetOffsetX = i5;
        }
    }

    private void setInsetOffsetY(View view, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i6 = layoutParams.mInsetOffsetY;
        if (i6 != i5) {
            ViewCompat.offsetTopAndBottom(view, i5 - i6);
            layoutParams.mInsetOffsetY = i5;
        }
    }

    private void setupForInsets() {
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        return CoordinatorLayout.this.setWindowInsets(windowInsetsCompat);
                    }
                };
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, (OnApplyWindowInsetsListener) null);
    }

    /* access modifiers changed from: package-private */
    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public void dispatchDependentViewsChanged(@NonNull View view) {
        List incomingEdges = this.mChildDag.getIncomingEdges(view);
        if (incomingEdges != null && !incomingEdges.isEmpty()) {
            for (int i5 = 0; i5 < incomingEdges.size(); i5++) {
                View view2 = (View) incomingEdges.get(i5);
                Behavior behavior = ((LayoutParams) view2.getLayoutParams()).getBehavior();
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public boolean doViewsOverlap(@NonNull View view, @NonNull View view2) {
        boolean z4;
        boolean z5;
        boolean z6 = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect acquireTempRect = acquireTempRect();
        if (view.getParent() != this) {
            z4 = true;
        } else {
            z4 = false;
        }
        getChildRect(view, z4, acquireTempRect);
        Rect acquireTempRect2 = acquireTempRect();
        if (view2.getParent() != this) {
            z5 = true;
        } else {
            z5 = false;
        }
        getChildRect(view2, z5, acquireTempRect2);
        try {
            if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left && acquireTempRect.bottom >= acquireTempRect2.top) {
                z6 = true;
            }
            return z6;
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j5) {
        View view2 = view;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        Behavior behavior = layoutParams.mBehavior;
        if (behavior != null) {
            float scrimOpacity = behavior.getScrimOpacity(this, view2);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(layoutParams.mBehavior.getScrimColor(this, view2));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view2.isOpaque()) {
                    canvas.clipRect((float) view2.getLeft(), (float) view2.getTop(), (float) view2.getRight(), (float) view2.getBottom(), Region.Op.DIFFERENCE);
                }
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.mScrimPaint);
                canvas2.restoreToCount(save);
                return super.drawChild(canvas, view, j5);
            }
        }
        Canvas canvas3 = canvas;
        return super.drawChild(canvas, view, j5);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z4;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        if (drawable == null || !drawable.isStateful()) {
            z4 = false;
        } else {
            z4 = drawable.setState(drawableState);
        }
        if (z4) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            } else if (hasDependencies(getChildAt(i5))) {
                z4 = true;
                break;
            } else {
                i5++;
            }
        }
        if (z4 == this.mNeedsPreDrawListener) {
            return;
        }
        if (z4) {
            addPreDrawListener();
        } else {
            removePreDrawListener();
        }
    }

    /* access modifiers changed from: package-private */
    public void getChildRect(View view, boolean z4, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z4) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @NonNull
    public List<View> getDependencies(@NonNull View view) {
        List<View> outgoingEdges = this.mChildDag.getOutgoingEdges(view);
        this.mTempDependenciesList.clear();
        if (outgoingEdges != null) {
            this.mTempDependenciesList.addAll(outgoingEdges);
        }
        return this.mTempDependenciesList;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return DesugarCollections.unmodifiableList(this.mDependencySortedChildren);
    }

    @NonNull
    public List<View> getDependents(@NonNull View view) {
        List incomingEdges = this.mChildDag.getIncomingEdges(view);
        this.mTempDependenciesList.clear();
        if (incomingEdges != null) {
            this.mTempDependenciesList.addAll(incomingEdges);
        }
        return this.mTempDependenciesList;
    }

    /* access modifiers changed from: package-private */
    public void getDescendantRect(View view, Rect rect) {
        ViewGroupUtils.getDescendantRect(this, view, rect);
    }

    /* access modifiers changed from: package-private */
    public void getDesiredAnchoredChildRect(View view, int i5, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect rect3 = rect2;
        getDesiredAnchoredChildRectWithoutConstraints(view, i5, rect, rect3, layoutParams, measuredWidth, measuredHeight);
        constrainChildRect(layoutParams, rect3, measuredWidth, measuredHeight);
    }

    /* access modifiers changed from: package-private */
    public void getLastChildRect(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).getLastChildRect());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    /* access modifiers changed from: package-private */
    public LayoutParams getResolvedLayoutParams(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mBehaviorResolved) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e(TAG, "Attached behavior class is null");
                }
                layoutParams.setBehavior(behavior);
                layoutParams.mBehaviorResolved = true;
                return layoutParams;
            }
            DefaultBehavior defaultBehavior = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                if (defaultBehavior != null) {
                    break;
                }
            }
            if (defaultBehavior != null) {
                try {
                    layoutParams.setBehavior((Behavior) defaultBehavior.value().getDeclaredConstructor((Class[]) null).newInstance((Object[]) null));
                } catch (Exception e5) {
                    Log.e(TAG, "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e5);
                }
            }
            layoutParams.mBehaviorResolved = true;
        }
        return layoutParams;
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public boolean isPointInChildBounds(@NonNull View view, int i5, int i6) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(i5, i6);
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    /* access modifiers changed from: package-private */
    public void offsetChildToAnchor(View view, int i5) {
        Behavior behavior;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mAnchorView != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(layoutParams.mAnchorView, acquireTempRect);
            boolean z4 = false;
            getChildRect(view, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            View view2 = view;
            getDesiredAnchoredChildRectWithoutConstraints(view2, i5, acquireTempRect, acquireTempRect3, layoutParams, measuredWidth, measuredHeight);
            if (!(acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top)) {
                z4 = true;
            }
            constrainChildRect(layoutParams, acquireTempRect3, measuredWidth, measuredHeight);
            int i6 = acquireTempRect3.left - acquireTempRect2.left;
            int i7 = acquireTempRect3.top - acquireTempRect2.top;
            if (i6 != 0) {
                ViewCompat.offsetLeftAndRight(view2, i6);
            }
            if (i7 != 0) {
                ViewCompat.offsetTopAndBottom(view2, i7);
            }
            if (z4 && (behavior = layoutParams.getBehavior()) != null) {
                behavior.onDependentViewChanged(this, view2, layoutParams.mAnchorView);
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
            return;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.mIsAttachedToWindow = true;
    }

    /* access modifiers changed from: package-private */
    public final void onChildViewsChanged(int i5) {
        boolean z4;
        int i6 = i5;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i7 = 0; i7 < size; i7++) {
            View view = this.mDependencySortedChildren.get(i7);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i6 != 0 || view.getVisibility() != 8) {
                for (int i8 = 0; i8 < i7; i8++) {
                    if (layoutParams.mAnchorDirectChild == this.mDependencySortedChildren.get(i8)) {
                        offsetChildToAnchor(view, layoutDirection);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (layoutParams.insetEdge != 0 && !acquireTempRect2.isEmpty()) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.insetEdge, layoutDirection);
                    int i9 = absoluteGravity & 112;
                    if (i9 == 48) {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    } else if (i9 == 80) {
                        acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                    }
                    int i10 = absoluteGravity & 7;
                    if (i10 == 3) {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    } else if (i10 == 5) {
                        acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                    }
                }
                if (layoutParams.dodgeInsetEdges != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, layoutDirection);
                }
                if (i6 != 2) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (int i11 = i7 + 1; i11 < size; i11++) {
                    View view2 = this.mDependencySortedChildren.get(i11);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior behavior = layoutParams2.getBehavior();
                    if (behavior != null && behavior.layoutDependsOn(this, view2, view)) {
                        if (i6 != 0 || !layoutParams2.getChangedAfterNestedScroll()) {
                            if (i6 != 2) {
                                z4 = behavior.onDependentViewChanged(this, view2, view);
                            } else {
                                behavior.onDependentViewRemoved(this, view2, view);
                                z4 = true;
                            }
                            if (i6 == 1) {
                                layoutParams2.setChangedAfterNestedScroll(z4);
                            }
                        } else {
                            layoutParams2.resetChangedAfterNestedScroll();
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    public void onDraw(Canvas canvas) {
        int i5;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            if (windowInsetsCompat != null) {
                i5 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i5 = 0;
            }
            if (i5 > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), i5);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return performIntercept;
        }
        resetTouchBehaviors(true);
        return performIntercept;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        Behavior behavior;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        for (int i9 = 0; i9 < size; i9++) {
            View view = this.mDependencySortedChildren.get(i9);
            if (view.getVisibility() != 8 && ((behavior = ((LayoutParams) view.getLayoutParams()).getBehavior()) == null || !behavior.onLayoutChild(this, view, layoutDirection))) {
                onLayoutChild(view, layoutDirection);
            }
        }
    }

    public void onLayoutChild(@NonNull View view, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.checkAnchorChanged()) {
            View view2 = layoutParams.mAnchorView;
            if (view2 != null) {
                layoutChildWithAnchor(view, view2, i5);
                return;
            }
            int i6 = layoutParams.keyline;
            if (i6 >= 0) {
                layoutChildWithKeyline(view, i6, i5);
            } else {
                layoutChild(view, i5);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r27, int r28) {
        /*
            r26 = this;
            r0 = r26
            r0.prepareChildren()
            r0.ensurePreDrawListener()
            int r7 = r0.getPaddingLeft()
            int r1 = r0.getPaddingTop()
            int r8 = r0.getPaddingRight()
            int r2 = r0.getPaddingBottom()
            int r9 = androidx.core.view.ViewCompat.getLayoutDirection(r0)
            r3 = 1
            if (r9 != r3) goto L_0x0021
            r11 = r3
            goto L_0x0022
        L_0x0021:
            r11 = 0
        L_0x0022:
            int r12 = android.view.View.MeasureSpec.getMode(r27)
            int r13 = android.view.View.MeasureSpec.getSize(r27)
            int r14 = android.view.View.MeasureSpec.getMode(r28)
            int r15 = android.view.View.MeasureSpec.getSize(r28)
            int r16 = r7 + r8
            int r17 = r1 + r2
            int r1 = r0.getSuggestedMinimumWidth()
            int r2 = r0.getSuggestedMinimumHeight()
            androidx.core.view.WindowInsetsCompat r4 = r0.mLastInsets
            if (r4 == 0) goto L_0x004b
            boolean r4 = androidx.core.view.ViewCompat.getFitsSystemWindows(r0)
            if (r4 == 0) goto L_0x004b
            r18 = r3
            goto L_0x004d
        L_0x004b:
            r18 = 0
        L_0x004d:
            java.util.List<android.view.View> r3 = r0.mDependencySortedChildren
            int r3 = r3.size()
            r4 = 0
            r5 = 0
        L_0x0055:
            if (r4 >= r3) goto L_0x0183
            java.util.List<android.view.View> r6 = r0.mDependencySortedChildren
            java.lang.Object r6 = r6.get(r4)
            android.view.View r6 = (android.view.View) r6
            int r10 = r6.getVisibility()
            r20 = r1
            r1 = 8
            if (r10 != r1) goto L_0x0079
            r23 = r3
            r21 = r4
            r19 = r7
            r22 = r9
            r1 = r20
            r24 = 0
            r20 = r8
            goto L_0x0177
        L_0x0079:
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
            r10 = r1
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r10 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r10
            int r1 = r10.keyline
            if (r1 < 0) goto L_0x00c6
            if (r12 == 0) goto L_0x00c6
            int r1 = r0.getKeyline(r1)
            r21 = r1
            int r1 = r10.gravity
            int r1 = resolveKeylineGravity(r1)
            int r1 = androidx.core.view.GravityCompat.getAbsoluteGravity(r1, r9)
            r1 = r1 & 7
            r22 = r2
            r2 = 3
            if (r1 != r2) goto L_0x009f
            if (r11 == 0) goto L_0x00a4
        L_0x009f:
            r2 = 5
            if (r1 != r2) goto L_0x00b3
            if (r11 == 0) goto L_0x00b3
        L_0x00a4:
            int r1 = r13 - r8
            int r1 = r1 - r21
            r2 = 0
            int r1 = java.lang.Math.max(r2, r1)
        L_0x00ad:
            r25 = r4
            r4 = r1
            r1 = r25
            goto L_0x00cb
        L_0x00b3:
            if (r1 != r2) goto L_0x00b7
            if (r11 == 0) goto L_0x00bc
        L_0x00b7:
            r2 = 3
            if (r1 != r2) goto L_0x00c4
            if (r11 == 0) goto L_0x00c4
        L_0x00bc:
            int r1 = r21 - r7
            r2 = 0
            int r1 = java.lang.Math.max(r2, r1)
            goto L_0x00ad
        L_0x00c4:
            r2 = 0
            goto L_0x00c9
        L_0x00c6:
            r22 = r2
            goto L_0x00c4
        L_0x00c9:
            r1 = r4
            r4 = r2
        L_0x00cb:
            if (r18 == 0) goto L_0x00ff
            boolean r19 = androidx.core.view.ViewCompat.getFitsSystemWindows(r6)
            if (r19 != 0) goto L_0x00ff
            androidx.core.view.WindowInsetsCompat r2 = r0.mLastInsets
            int r2 = r2.getSystemWindowInsetLeft()
            r21 = r1
            androidx.core.view.WindowInsetsCompat r1 = r0.mLastInsets
            int r1 = r1.getSystemWindowInsetRight()
            int r2 = r2 + r1
            androidx.core.view.WindowInsetsCompat r1 = r0.mLastInsets
            int r1 = r1.getSystemWindowInsetTop()
            r23 = r1
            androidx.core.view.WindowInsetsCompat r1 = r0.mLastInsets
            int r1 = r1.getSystemWindowInsetBottom()
            int r1 = r23 + r1
            int r2 = r13 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r12)
            int r1 = r15 - r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r14)
            goto L_0x0105
        L_0x00ff:
            r21 = r1
            r2 = r27
            r1 = r28
        L_0x0105:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r10.getBehavior()
            if (r0 == 0) goto L_0x012f
            r23 = r3
            r3 = r2
            r2 = r6
            r6 = 0
            r19 = r22
            r22 = r9
            r9 = r19
            r24 = 0
            r19 = r7
            r7 = r20
            r20 = r8
            r8 = r5
            r5 = r1
            r1 = r26
            boolean r0 = r0.onMeasureChild(r1, r2, r3, r4, r5, r6)
            r1 = r3
            r3 = r4
            r4 = r5
            if (r0 != 0) goto L_0x012c
            goto L_0x0144
        L_0x012c:
            r0 = r26
            goto L_0x014e
        L_0x012f:
            r19 = r22
            r22 = r9
            r9 = r19
            r23 = r3
            r3 = r4
            r19 = r7
            r7 = r20
            r24 = 0
            r4 = r1
            r1 = r2
            r2 = r6
            r20 = r8
            r8 = r5
        L_0x0144:
            r5 = 0
            r0 = r2
            r2 = r1
            r1 = r0
            r0 = r26
            r0.onMeasureChild(r1, r2, r3, r4, r5)
            r2 = r1
        L_0x014e:
            int r1 = r2.getMeasuredWidth()
            int r1 = r16 + r1
            int r3 = r10.leftMargin
            int r1 = r1 + r3
            int r3 = r10.rightMargin
            int r1 = r1 + r3
            int r1 = java.lang.Math.max(r7, r1)
            int r3 = r2.getMeasuredHeight()
            int r3 = r17 + r3
            int r4 = r10.topMargin
            int r3 = r3 + r4
            int r4 = r10.bottomMargin
            int r3 = r3 + r4
            int r3 = java.lang.Math.max(r9, r3)
            int r2 = r2.getMeasuredState()
            int r5 = android.view.View.combineMeasuredStates(r8, r2)
            r2 = r3
        L_0x0177:
            int r4 = r21 + 1
            r7 = r19
            r8 = r20
            r9 = r22
            r3 = r23
            goto L_0x0055
        L_0x0183:
            r7 = r1
            r9 = r2
            r8 = r5
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r1 & r8
            r2 = r27
            int r1 = android.view.View.resolveSizeAndState(r7, r2, r1)
            int r2 = r8 << 16
            r3 = r28
            int r2 = android.view.View.resolveSizeAndState(r9, r3, r2)
            r0.setMeasuredDimension(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public void onMeasureChild(View view, int i5, int i6, int i7, int i8) {
        measureChildWithMargins(view, i5, i6, i7, i8);
    }

    public boolean onNestedFling(View view, float f5, float f6, boolean z4) {
        boolean z5;
        float f7;
        float f8;
        View view2;
        Behavior behavior;
        int childCount = getChildCount();
        int i5 = 0;
        boolean z6 = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.getBehavior()) != null) {
                    view2 = view;
                    f8 = f5;
                    f7 = f6;
                    z5 = z4;
                    z6 |= behavior.onNestedFling(this, childAt, view2, f8, f7, z5);
                    i5++;
                    view = view2;
                    f5 = f8;
                    f6 = f7;
                    z4 = z5;
                }
            }
            view2 = view;
            f8 = f5;
            f7 = f6;
            z5 = z4;
            i5++;
            view = view2;
            f5 = f8;
            f6 = f7;
            z4 = z5;
        }
        if (z6) {
            onChildViewsChanged(1);
        }
        return z6;
    }

    public boolean onNestedPreFling(View view, float f5, float f6) {
        float f7;
        float f8;
        View view2;
        Behavior behavior;
        int childCount = getChildCount();
        int i5 = 0;
        boolean z4 = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.getBehavior()) != null) {
                    view2 = view;
                    f8 = f5;
                    f7 = f6;
                    z4 |= behavior.onNestedPreFling(this, childAt, view2, f8, f7);
                    i5++;
                    view = view2;
                    f5 = f8;
                    f6 = f7;
                }
            }
            view2 = view;
            f8 = f5;
            f7 = f6;
            i5++;
            view = view2;
            f5 = f8;
            f6 = f7;
        }
        return z4;
    }

    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        onNestedPreScroll(view, i5, i6, iArr, 0);
    }

    public void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        onNestedScroll(view, i5, i6, i7, i8, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i5) {
        onNestedScrollAccepted(view, view2, i5, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            Behavior behavior = getResolvedLayoutParams(childAt).getBehavior();
            if (!(id == -1 || behavior == null || (parcelable2 = sparseArray.get(id)) == null)) {
                behavior.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (!(id == -1 || behavior == null || (onSaveInstanceState = behavior.onSaveInstanceState(this, childAt)) == null)) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i5) {
        return onStartNestedScroll(view, view2, i5, 0);
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0018;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.mBehaviorTouchView
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0017
            boolean r3 = r0.performIntercept(r1, r4)
            if (r3 == 0) goto L_0x0015
            goto L_0x0018
        L_0x0015:
            r6 = r5
            goto L_0x002c
        L_0x0017:
            r3 = r5
        L_0x0018:
            android.view.View r6 = r0.mBehaviorTouchView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.getBehavior()
            if (r6 == 0) goto L_0x0015
            android.view.View r7 = r0.mBehaviorTouchView
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
        L_0x002c:
            android.view.View r7 = r0.mBehaviorTouchView
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0056
            r1 = 3
            if (r2 != r1) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            return r6
        L_0x0056:
            r0.resetTouchBehaviors(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void recordLastChildRect(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).setLastChildRect(rect);
    }

    /* access modifiers changed from: package-private */
    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z4)) {
            return super.requestChildRectangleOnScreen(view, rect, z4);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z4) {
        super.requestDisallowInterceptTouchEvent(z4);
        if (z4 && !this.mDisallowInterceptReset) {
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    public void setFitsSystemWindows(boolean z4) {
        super.setFitsSystemWindows(z4);
        setupForInsets();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        boolean z4;
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.mStatusBarBackground;
                if (getVisibility() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                drawable4.setVisible(z4, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarBackgroundColor(@ColorInt int i5) {
        setStatusBarBackground(new ColorDrawable(i5));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i5) {
        Drawable drawable;
        if (i5 != 0) {
            drawable = ContextCompat.getDrawable(getContext(), i5);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    public void setVisibility(int i5) {
        boolean z4;
        super.setVisibility(i5);
        if (i5 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isVisible() != z4) {
            this.mStatusBarBackground.setVisible(z4, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        boolean z4;
        if (ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.mLastInsets = windowInsetsCompat;
        boolean z5 = false;
        if (windowInsetsCompat == null || windowInsetsCompat.getSystemWindowInsetTop() <= 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.mDrawStatusBarBackground = z4;
        if (!z4 && getBackground() == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
        requestLayout();
        return dispatchApplyWindowInsetsToBehaviors;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground) {
            return true;
        }
        return false;
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr, int i7) {
        Behavior behavior;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z4 = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i11 = i7;
                if (layoutParams.isNestedScrollAccepted(i11) && (behavior = layoutParams.getBehavior()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedPreScroll(this, childAt, view, i5, i6, iArr2, i11);
                    int[] iArr3 = this.mBehaviorConsumed;
                    if (i5 > 0) {
                        min = Math.max(i8, iArr3[0]);
                    } else {
                        min = Math.min(i8, iArr3[0]);
                    }
                    i8 = min;
                    int[] iArr4 = this.mBehaviorConsumed;
                    if (i6 > 0) {
                        min2 = Math.max(i9, iArr4[1]);
                    } else {
                        min2 = Math.min(i9, iArr4[1]);
                    }
                    i9 = min2;
                    z4 = true;
                }
            }
        }
        iArr[0] = i8;
        iArr[1] = i9;
        if (z4) {
            onChildViewsChanged(1);
        }
    }

    public void onNestedScroll(View view, int i5, int i6, int i7, int i8, int i9) {
        onNestedScroll(view, i5, i6, i7, i8, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    public void onNestedScrollAccepted(View view, View view2, int i5, int i6) {
        int i7;
        int i8;
        View view3;
        View view4;
        Behavior behavior;
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i5, i6);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i6) && (behavior = layoutParams.getBehavior()) != null) {
                view4 = view;
                view3 = view2;
                i8 = i5;
                i7 = i6;
                behavior.onNestedScrollAccepted(this, childAt, view4, view3, i8, i7);
            } else {
                view4 = view;
                view3 = view2;
                i8 = i5;
                i7 = i6;
            }
            i9++;
            view = view4;
            view2 = view3;
            i5 = i8;
            i6 = i7;
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i5, int i6) {
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                int i8 = i6;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    int i9 = i6;
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i5, i9);
                    z4 |= onStartNestedScroll;
                    layoutParams.setNestedScrollAccepted(i9, onStartNestedScroll);
                } else {
                    layoutParams.setNestedScrollAccepted(i6, false);
                }
            }
        }
        return z4;
    }

    public void onStopNestedScroll(View view, int i5) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view, i5);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i5)) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, i5);
                }
                layoutParams.resetNestedScroll(i5);
                layoutParams.resetChangedAfterNestedScroll();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        super(context, attributeSet, i5);
        TypedArray obtainStyledAttributes;
        Context context2;
        CoordinatorLayout coordinatorLayout;
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        if (i5 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i5, 0);
        }
        TypedArray typedArray = obtainStyledAttributes;
        if (Build.VERSION.SDK_INT < 29) {
            coordinatorLayout = this;
            context2 = context;
        } else if (i5 == 0) {
            coordinatorLayout = this;
            context2 = context;
            coordinatorLayout.saveAttributeDataForStyleable(context2, R.styleable.CoordinatorLayout, attributeSet, typedArray, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            context2 = context;
            coordinatorLayout = this;
            coordinatorLayout.saveAttributeDataForStyleable(context2, R.styleable.CoordinatorLayout, attributeSet, typedArray, i5, 0);
        }
        int resourceId = typedArray.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            coordinatorLayout.mKeylines = resources.getIntArray(resourceId);
            float f5 = resources.getDisplayMetrics().density;
            int length = coordinatorLayout.mKeylines.length;
            for (int i6 = 0; i6 < length; i6++) {
                int[] iArr = coordinatorLayout.mKeylines;
                iArr[i6] = (int) (((float) iArr[i6]) * f5);
            }
        }
        coordinatorLayout.mStatusBarBackground = typedArray.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void onNestedScroll(@NonNull View view, int i5, int i6, int i7, int i8, int i9, @NonNull int[] iArr) {
        Behavior behavior;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z4 = false;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i13 = i9;
                if (layoutParams.isNestedScrollAccepted(i13) && (behavior = layoutParams.getBehavior()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedScroll(this, childAt, view, i5, i6, i7, i8, i13, iArr2);
                    int[] iArr3 = this.mBehaviorConsumed;
                    if (i7 > 0) {
                        min = Math.max(i10, iArr3[0]);
                    } else {
                        min = Math.min(i10, iArr3[0]);
                    }
                    i10 = min;
                    int[] iArr4 = this.mBehaviorConsumed;
                    if (i8 > 0) {
                        min2 = Math.max(i11, iArr4[1]);
                    } else {
                        min2 = Math.min(i11, iArr4[1]);
                    }
                    i11 = min2;
                    z4 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i10;
        iArr[1] = iArr[1] + i11;
        if (z4) {
            onChildViewsChanged(1);
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        SparseArray<Parcelable> behaviorStates;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int i5 = 0; i5 < readInt; i5++) {
                this.behaviorStates.append(iArr[i5], readParcelableArray[i5]);
            }
        }

        public void writeToParcel(Parcel parcel, int i5) {
            int i6;
            super.writeToParcel(parcel, i5);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            if (sparseArray != null) {
                i6 = sparseArray.size();
            } else {
                i6 = 0;
            }
            parcel.writeInt(i6);
            int[] iArr = new int[i6];
            Parcelable[] parcelableArr = new Parcelable[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                iArr[i7] = this.behaviorStates.keyAt(i7);
                parcelableArr[i7] = this.behaviorStates.valueAt(i7);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i5);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int anchorGravity = 0;
        public int dodgeInsetEdges = 0;
        public int gravity = 0;
        public int insetEdge = 0;
        public int keyline = -1;
        View mAnchorDirectChild;
        int mAnchorId = -1;
        View mAnchorView;
        Behavior mBehavior;
        boolean mBehaviorResolved = false;
        Object mBehaviorTag;
        private boolean mDidAcceptNestedScrollNonTouch;
        private boolean mDidAcceptNestedScrollTouch;
        private boolean mDidBlockInteraction;
        private boolean mDidChangeAfterNestedScroll;
        int mInsetOffsetX;
        int mInsetOffsetY;
        final Rect mLastChildRect = new Rect();

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
        }

        private void resolveAnchorView(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.mAnchorId);
            this.mAnchorView = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    ViewParent parent = findViewById.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.mAnchorDirectChild = null;
                            this.mAnchorView = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.mAnchorDirectChild = findViewById;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.mAnchorId) + " to anchor view " + view);
            }
        }

        private boolean shouldDodge(View view, int i5) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).insetEdge, i5);
            if (absoluteGravity == 0 || (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, i5) & absoluteGravity) != absoluteGravity) {
                return false;
            }
            return true;
        }

        private boolean verifyAnchorView(View view, CoordinatorLayout coordinatorLayout) {
            if (this.mAnchorView.getId() != this.mAnchorId) {
                return false;
            }
            View view2 = this.mAnchorView;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.mAnchorDirectChild = view2;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean checkAnchorChanged() {
            if (this.mAnchorView != null || this.mAnchorId == -1) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean dependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 == this.mAnchorDirectChild || shouldDodge(view2, ViewCompat.getLayoutDirection(coordinatorLayout))) {
                return true;
            }
            Behavior behavior = this.mBehavior;
            if (behavior == null || !behavior.layoutDependsOn(coordinatorLayout, view, view2)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean didBlockInteraction() {
            if (this.mBehavior == null) {
                this.mDidBlockInteraction = false;
            }
            return this.mDidBlockInteraction;
        }

        /* access modifiers changed from: package-private */
        public View findAnchorView(CoordinatorLayout coordinatorLayout, View view) {
            if (this.mAnchorId == -1) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return null;
            }
            if (this.mAnchorView == null || !verifyAnchorView(view, coordinatorLayout)) {
                resolveAnchorView(view, coordinatorLayout);
            }
            return this.mAnchorView;
        }

        @IdRes
        public int getAnchorId() {
            return this.mAnchorId;
        }

        @Nullable
        public Behavior getBehavior() {
            return this.mBehavior;
        }

        /* access modifiers changed from: package-private */
        public boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        /* access modifiers changed from: package-private */
        public Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        /* access modifiers changed from: package-private */
        public void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        /* access modifiers changed from: package-private */
        public boolean isBlockingInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
            boolean z4;
            boolean z5 = this.mDidBlockInteraction;
            if (z5) {
                return true;
            }
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                z4 = behavior.blocksInteractionBelow(coordinatorLayout, view);
            } else {
                z4 = false;
            }
            boolean z6 = z4 | z5;
            this.mDidBlockInteraction = z6;
            return z6;
        }

        /* access modifiers changed from: package-private */
        public boolean isNestedScrollAccepted(int i5) {
            if (i5 == 0) {
                return this.mDidAcceptNestedScrollTouch;
            }
            if (i5 != 1) {
                return false;
            }
            return this.mDidAcceptNestedScrollNonTouch;
        }

        /* access modifiers changed from: package-private */
        public void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        /* access modifiers changed from: package-private */
        public void resetNestedScroll(int i5) {
            setNestedScrollAccepted(i5, false);
        }

        /* access modifiers changed from: package-private */
        public void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        public void setAnchorId(@IdRes int i5) {
            invalidateAnchor();
            this.mAnchorId = i5;
        }

        public void setBehavior(@Nullable Behavior behavior) {
            Behavior behavior2 = this.mBehavior;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.mBehavior = behavior;
                this.mBehaviorTag = null;
                this.mBehaviorResolved = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setChangedAfterNestedScroll(boolean z4) {
            this.mDidChangeAfterNestedScroll = z4;
        }

        /* access modifiers changed from: package-private */
        public void setLastChildRect(Rect rect) {
            this.mLastChildRect.set(rect);
        }

        /* access modifiers changed from: package-private */
        public void setNestedScrollAccepted(int i5, boolean z4) {
            if (i5 == 0) {
                this.mDidAcceptNestedScrollTouch = z4;
            } else if (i5 == 1) {
                this.mDidAcceptNestedScrollNonTouch = z4;
            }
        }

        LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.mAnchorId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.keyline = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i5 = R.styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean hasValue = obtainStyledAttributes.hasValue(i5);
            this.mBehaviorResolved = hasValue;
            if (hasValue) {
                this.mBehavior = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(i5));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
