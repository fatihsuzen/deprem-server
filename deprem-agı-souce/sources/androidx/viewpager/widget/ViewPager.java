package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() {
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = {16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new Interpolator() {
        public float getInterpolation(float f5) {
            float f6 = f5 - 1.0f;
            return (f6 * f6 * f6 * f6 * f6) + 1.0f;
        }
    };
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
    private int mActivePointerId = -1;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    };
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems = new ArrayList<>();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit = 1;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem = new ItemInfo();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        private boolean canScroll() {
            PagerAdapter pagerAdapter = ViewPager.this.mAdapter;
            if (pagerAdapter == null || pagerAdapter.getCount() <= 1) {
                return false;
            }
            return true;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() == 4096 && (pagerAdapter = ViewPager.this.mAdapter) != null) {
                accessibilityEvent.setItemCount(pagerAdapter.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
                accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
            if (super.performAccessibilityAction(view, i5, bundle)) {
                return true;
            }
            if (i5 != 4096) {
                if (i5 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.mCurItem + 1);
                return true;
            }
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i5);

        void onPageScrolled(int i5, float f5, @Px int i6);

        void onPageSelected(int i5);
    }

    public interface PageTransformer {
        void transformPage(@NonNull View view, float f5);
    }

    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    public static class SavedState extends AbsSavedState {
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
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i5);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageScrollStateChanged(int i5) {
        }

        public void onPageScrolled(int i5, float f5, int i6) {
        }

        public void onPageSelected(int i5) {
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z4 = layoutParams.isDecor;
            if (z4 != layoutParams2.isDecor) {
                return z4 ? 1 : -1;
            }
            return layoutParams.position - layoutParams2.position;
        }
    }

    public ViewPager(@NonNull Context context) {
        super(context);
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i5, ItemInfo itemInfo2) {
        float f5;
        float f6;
        float f7;
        int i6;
        int i7;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f5 = ((float) this.mPageMargin) / ((float) clientWidth);
        } else {
            f5 = 0.0f;
        }
        if (itemInfo2 != null) {
            int i8 = itemInfo2.position;
            int i9 = itemInfo.position;
            if (i8 < i9) {
                float f8 = itemInfo2.offset + itemInfo2.widthFactor + f5;
                int i10 = i8 + 1;
                int i11 = 0;
                while (i10 <= itemInfo.position && i11 < this.mItems.size()) {
                    Object obj = this.mItems.get(i11);
                    while (true) {
                        itemInfo4 = (ItemInfo) obj;
                        if (i10 > itemInfo4.position && i11 < this.mItems.size() - 1) {
                            i11++;
                            obj = this.mItems.get(i11);
                        }
                    }
                    while (i10 < itemInfo4.position) {
                        f8 += this.mAdapter.getPageWidth(i10) + f5;
                        i10++;
                    }
                    itemInfo4.offset = f8;
                    f8 += itemInfo4.widthFactor + f5;
                    i10++;
                }
            } else if (i8 > i9) {
                int size = this.mItems.size() - 1;
                float f9 = itemInfo2.offset;
                while (true) {
                    i8--;
                    if (i8 < itemInfo.position || size < 0) {
                        break;
                    }
                    Object obj2 = this.mItems.get(size);
                    while (true) {
                        itemInfo3 = (ItemInfo) obj2;
                        if (i8 < itemInfo3.position && size > 0) {
                            size--;
                            obj2 = this.mItems.get(size);
                        }
                    }
                    while (i8 > itemInfo3.position) {
                        f9 -= this.mAdapter.getPageWidth(i8) + f5;
                        i8--;
                    }
                    f9 -= itemInfo3.widthFactor + f5;
                    itemInfo3.offset = f9;
                }
            }
        }
        int size2 = this.mItems.size();
        float f10 = itemInfo.offset;
        int i12 = itemInfo.position;
        int i13 = i12 - 1;
        if (i12 == 0) {
            f6 = f10;
        } else {
            f6 = -3.4028235E38f;
        }
        this.mFirstOffset = f6;
        int i14 = count - 1;
        if (i12 == i14) {
            f7 = (itemInfo.widthFactor + f10) - 1.0f;
        } else {
            f7 = Float.MAX_VALUE;
        }
        this.mLastOffset = f7;
        int i15 = i5 - 1;
        while (i15 >= 0) {
            ItemInfo itemInfo5 = this.mItems.get(i15);
            while (true) {
                i7 = itemInfo5.position;
                if (i13 <= i7) {
                    break;
                }
                f10 -= this.mAdapter.getPageWidth(i13) + f5;
                i13--;
            }
            f10 -= itemInfo5.widthFactor + f5;
            itemInfo5.offset = f10;
            if (i7 == 0) {
                this.mFirstOffset = f10;
            }
            i15--;
            i13--;
        }
        float f11 = itemInfo.offset + itemInfo.widthFactor + f5;
        int i16 = itemInfo.position + 1;
        int i17 = i5 + 1;
        while (i17 < size2) {
            ItemInfo itemInfo6 = this.mItems.get(i17);
            while (true) {
                i6 = itemInfo6.position;
                if (i16 >= i6) {
                    break;
                }
                f11 += this.mAdapter.getPageWidth(i16) + f5;
                i16++;
            }
            if (i6 == i14) {
                this.mLastOffset = (itemInfo6.widthFactor + f11) - 1.0f;
            }
            itemInfo6.offset = f11;
            f11 += itemInfo6.widthFactor + f5;
            i17++;
            i16++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z4) {
        boolean z5;
        if (this.mScrollState == 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i5 = 0; i5 < this.mItems.size(); i5++) {
            ItemInfo itemInfo = this.mItems.get(i5);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                z5 = true;
            }
        }
        if (!z5) {
            return;
        }
        if (z4) {
            ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int i5, float f5, int i6, int i7) {
        float f6;
        if (Math.abs(i7) <= this.mFlingDistance || Math.abs(i6) <= this.mMinimumVelocity) {
            if (i5 >= this.mCurItem) {
                f6 = 0.4f;
            } else {
                f6 = 0.6f;
            }
            i5 += (int) (f5 + f6);
        } else if (i6 <= 0) {
            i5++;
        }
        if (this.mItems.size() <= 0) {
            return i5;
        }
        ArrayList<ItemInfo> arrayList = this.mItems;
        return Math.max(this.mItems.get(0).position, Math.min(i5, arrayList.get(arrayList.size() - 1).position));
    }

    private void dispatchOnPageScrolled(int i5, float f5, int i6) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i5, f5, i6);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i7);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrolled(i5, f5, i6);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrolled(i5, f5, i6);
        }
    }

    private void dispatchOnPageSelected(int i5) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i5);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i6);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i5);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageSelected(i5);
        }
    }

    private void dispatchOnScrollStateChanged(int i5) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i5);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i6);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrollStateChanged(i5);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrollStateChanged(i5);
        }
    }

    private void enableLayers(boolean z4) {
        int i5;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (z4) {
                i5 = this.mPageTransformerLayerType;
            } else {
                i5 = 0;
            }
            getChildAt(i6).setLayerType(i5, (Paint) null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        float f5;
        float f6;
        int i5;
        int clientWidth = getClientWidth();
        float f7 = 0.0f;
        if (clientWidth > 0) {
            f5 = ((float) getScrollX()) / ((float) clientWidth);
        } else {
            f5 = 0.0f;
        }
        if (clientWidth > 0) {
            f6 = ((float) this.mPageMargin) / ((float) clientWidth);
        } else {
            f6 = 0.0f;
        }
        int i6 = 0;
        boolean z4 = true;
        ItemInfo itemInfo = null;
        int i7 = -1;
        float f8 = 0.0f;
        while (i6 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i6);
            if (!z4 && itemInfo2.position != (i5 = i7 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.offset = f7 + f8 + f6;
                itemInfo2.position = i5;
                itemInfo2.widthFactor = this.mAdapter.getPageWidth(i5);
                i6--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f7 = itemInfo3.offset;
            float f9 = itemInfo3.widthFactor + f7 + f6;
            if (!z4 && f5 < f7) {
                break;
            } else if (f5 < f9 || i6 == this.mItems.size() - 1) {
                return itemInfo3;
            } else {
                int i8 = itemInfo3.position;
                float f10 = itemInfo3.widthFactor;
                i6++;
                ItemInfo itemInfo4 = itemInfo3;
                i7 = i8;
                f8 = f10;
                itemInfo = itemInfo4;
                z4 = false;
            }
        }
        return itemInfo;
    }

    private static boolean isDecorView(@NonNull View view) {
        if (view.getClass().getAnnotation(DecorView.class) != null) {
            return true;
        }
        return false;
    }

    private boolean isGutterDrag(float f5, float f6) {
        if (f5 < ((float) this.mGutterSize) && f6 > 0.0f) {
            return true;
        }
        if (f5 <= ((float) (getWidth() - this.mGutterSize)) || f6 >= 0.0f) {
            return false;
        }
        return true;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i5;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            this.mLastMotionX = motionEvent.getX(i5);
            this.mActivePointerId = motionEvent.getPointerId(i5);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i5) {
        if (this.mItems.size() != 0) {
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i6 = this.mPageMargin;
            int i7 = clientWidth + i6;
            float f5 = (float) clientWidth;
            int i8 = infoForCurrentScrollPosition.position;
            float f6 = ((((float) i5) / f5) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (((float) i6) / f5));
            this.mCalledSuper = false;
            onPageScrolled(i8, f6, (int) (((float) i7) * f6));
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private boolean performDrag(float f5) {
        boolean z4;
        boolean z5;
        float f6 = this.mLastMotionX - f5;
        this.mLastMotionX = f5;
        float scrollX = ((float) getScrollX()) + f6;
        float clientWidth = (float) getClientWidth();
        float f7 = this.mFirstOffset * clientWidth;
        float f8 = this.mLastOffset * clientWidth;
        boolean z6 = false;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.position != 0) {
            f7 = itemInfo.offset * clientWidth;
            z4 = false;
        } else {
            z4 = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f8 = itemInfo2.offset * clientWidth;
            z5 = false;
        } else {
            z5 = true;
        }
        if (scrollX < f7) {
            if (z4) {
                this.mLeftEdge.onPull(Math.abs(f7 - scrollX) / clientWidth);
                z6 = true;
            }
            scrollX = f7;
        } else if (scrollX > f8) {
            if (z5) {
                this.mRightEdge.onPull(Math.abs(scrollX - f8) / clientWidth);
                z6 = true;
            }
            scrollX = f8;
        }
        int i5 = (int) scrollX;
        this.mLastMotionX += scrollX - ((float) i5);
        scrollTo(i5, getScrollY());
        pageScrolled(i5);
        return z6;
    }

    private void recomputeScrollPosition(int i5, int i6, int i7, int i8) {
        float f5;
        if (i6 <= 0 || this.mItems.isEmpty()) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            if (infoForPosition != null) {
                f5 = Math.min(infoForPosition.offset, this.mLastOffset);
            } else {
                f5 = 0.0f;
            }
            int paddingLeft = (int) (f5 * ((float) ((i5 - getPaddingLeft()) - getPaddingRight())));
            if (paddingLeft != getScrollX()) {
                completeScroll(false);
                scrollTo(paddingLeft, getScrollY());
            }
        } else if (!this.mScroller.isFinished()) {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i6 - getPaddingLeft()) - getPaddingRight()) + i8))) * ((float) (((i5 - getPaddingLeft()) - getPaddingRight()) + i7))), getScrollY());
        }
    }

    private void removeNonDecorViews() {
        int i5 = 0;
        while (i5 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i5).getLayoutParams()).isDecor) {
                removeViewAt(i5);
                i5--;
            }
            i5++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z4) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z4);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (this.mLeftEdge.isFinished() || this.mRightEdge.isFinished()) {
            return true;
        }
        return false;
    }

    private void scrollToItem(int i5, boolean z4, int i6, boolean z5) {
        int i7;
        ItemInfo infoForPosition = infoForPosition(i5);
        if (infoForPosition != null) {
            i7 = (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)));
        } else {
            i7 = 0;
        }
        if (z4) {
            smoothScrollTo(i7, 0, i6);
            if (z5) {
                dispatchOnPageSelected(i5);
                return;
            }
            return;
        }
        if (z5) {
            dispatchOnPageSelected(i5);
        }
        completeScroll(false);
        scrollTo(i7, 0);
        pageScrolled(i7);
    }

    private void setScrollingCacheEnabled(boolean z4) {
        if (this.mScrollingCacheEnabled != z4) {
            this.mScrollingCacheEnabled = z4;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                this.mDrawingOrderedChildren.add(getChildAt(i5));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i5, int i6) {
        ItemInfo infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i5, i6);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i6 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    /* access modifiers changed from: package-private */
    public ItemInfo addNewItem(int i5, int i6) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i5;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i5);
        itemInfo.widthFactor = this.mAdapter.getPageWidth(i5);
        if (i6 < 0 || i6 >= this.mItems.size()) {
            this.mItems.add(itemInfo);
            return itemInfo;
        }
        this.mItems.add(i6, itemInfo);
        return itemInfo;
    }

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean isDecorView = layoutParams2.isDecor | isDecorView(view);
        layoutParams2.isDecor = isDecorView;
        if (!this.mInLayout) {
            super.addView(view, i5, layoutParams);
        } else if (!isDecorView) {
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i5, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L_0x0009
        L_0x0007:
            r0 = r1
            goto L_0x0063
        L_0x0009:
            if (r0 == 0) goto L_0x0063
            android.view.ViewParent r2 = r0.getParent()
        L_0x000f:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x001b
            if (r2 != r4) goto L_0x0016
            goto L_0x0063
        L_0x0016:
            android.view.ViewParent r2 = r2.getParent()
            goto L_0x000f
        L_0x001b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L_0x002f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x0048
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x002f
        L_0x0048:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L_0x0007
        L_0x0063:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto L_0x00b3
            if (r1 == r0) goto L_0x00b3
            if (r5 != r3) goto L_0x0093
            android.graphics.Rect r2 = r4.mTempRect
            android.graphics.Rect r2 = r4.getChildRectInPagerCoordinates(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.mTempRect
            android.graphics.Rect r3 = r4.getChildRectInPagerCoordinates(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L_0x008e
            if (r2 < r3) goto L_0x008e
            boolean r0 = r4.pageLeft()
            goto L_0x00ca
        L_0x008e:
            boolean r0 = r1.requestFocus()
            goto L_0x00ca
        L_0x0093:
            if (r5 != r2) goto L_0x00bf
            android.graphics.Rect r2 = r4.mTempRect
            android.graphics.Rect r2 = r4.getChildRectInPagerCoordinates(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.mTempRect
            android.graphics.Rect r3 = r4.getChildRectInPagerCoordinates(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L_0x00ae
            if (r2 > r3) goto L_0x00ae
            boolean r0 = r4.pageRight()
            goto L_0x00ca
        L_0x00ae:
            boolean r0 = r1.requestFocus()
            goto L_0x00ca
        L_0x00b3:
            if (r5 == r3) goto L_0x00c6
            r0 = 1
            if (r5 != r0) goto L_0x00b9
            goto L_0x00c6
        L_0x00b9:
            if (r5 == r2) goto L_0x00c1
            r0 = 2
            if (r5 != r0) goto L_0x00bf
            goto L_0x00c1
        L_0x00bf:
            r0 = 0
            goto L_0x00ca
        L_0x00c1:
            boolean r0 = r4.pageRight()
            goto L_0x00ca
        L_0x00c6:
            boolean r0 = r4.pageLeft()
        L_0x00ca:
            if (r0 == 0) goto L_0x00d3
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        L_0x00d3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.arrowScroll(int):boolean");
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z4, int i5, int i6, int i7) {
        int i8;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i9 = i6 + scrollX;
                if (i9 >= childAt.getLeft() && i9 < childAt.getRight() && (i8 = i7 + scrollY) >= childAt.getTop() && i8 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i5, i9 - childAt.getLeft(), i8 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z4 || !view.canScrollHorizontally(-i5)) {
            return false;
        }
        return true;
    }

    public boolean canScrollHorizontally(int i5) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i5 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                return true;
            }
            return false;
        } else if (i5 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: package-private */
    public void dataSetChanged() {
        boolean z4;
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        if (this.mItems.size() >= (this.mOffscreenPageLimit * 2) + 1 || this.mItems.size() >= count) {
            z4 = false;
        } else {
            z4 = true;
        }
        int i5 = this.mCurItem;
        int i6 = 0;
        boolean z5 = false;
        while (i6 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i6);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i6);
                    i6--;
                    if (!z5) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z5 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    int i7 = this.mCurItem;
                    if (i7 == itemInfo.position) {
                        i5 = Math.max(0, Math.min(i7, count - 1));
                    }
                } else {
                    int i8 = itemInfo.position;
                    if (i8 != itemPosition) {
                        if (i8 == this.mCurItem) {
                            i5 = itemPosition;
                        }
                        itemInfo.position = itemPosition;
                    }
                }
                z4 = true;
            }
            i6++;
        }
        if (z5) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z4) {
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i9).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i5, false, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public float distanceInfluenceForSnapDuration(float f5) {
        return (float) Math.sin((double) ((f5 - 0.5f) * 0.47123894f));
    }

    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z4 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.mAdapter) != null && pagerAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(height, width);
                z4 = this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) width2));
                this.mRightEdge.setSize(height2, width2);
                z4 |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (z4) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 21) {
            if (keyCode != 22) {
                if (keyCode != 61) {
                    return false;
                }
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
                return false;
            } else if (keyEvent.hasModifiers(2)) {
                return pageRight();
            } else {
                return arrowScroll(66);
            }
        } else if (keyEvent.hasModifiers(2)) {
            return pageLeft();
        } else {
            return arrowScroll(17);
        }
    }

    public void fakeDragBy(float f5) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f5;
            float scrollX = ((float) getScrollX()) - f5;
            float clientWidth = (float) getClientWidth();
            float f6 = this.mFirstOffset * clientWidth;
            float f7 = this.mLastOffset * clientWidth;
            ItemInfo itemInfo = this.mItems.get(0);
            ArrayList<ItemInfo> arrayList = this.mItems;
            ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
            if (itemInfo.position != 0) {
                f6 = itemInfo.offset * clientWidth;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f7 = itemInfo2.offset * clientWidth;
            }
            if (scrollX < f6) {
                scrollX = f6;
            } else if (scrollX > f7) {
                scrollX = f7;
            }
            int i5 = (int) scrollX;
            this.mLastMotionX += scrollX - ((float) i5);
            scrollTo(i5, getScrollY());
            pageScrolled(i5);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i5, int i6) {
        if (this.mDrawingOrder == 2) {
            i6 = (i5 - 1) - i6;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i6).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    /* access modifiers changed from: package-private */
    public ItemInfo infoForAnyChild(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    public ItemInfo infoForChild(View view) {
        for (int i5 = 0; i5 < this.mItems.size(); i5++) {
            ItemInfo itemInfo = this.mItems.get(i5);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ItemInfo infoForPosition(int i5) {
        for (int i6 = 0; i6 < this.mItems.size(); i6++) {
            ItemInfo itemInfo = this.mItems.get(i6);
            if (itemInfo.position == i5) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f5);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f5);
        this.mCloseEnough = (int) (2.0f * f5);
        this.mDefaultGutterSize = (int) (f5 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            private final Rect mTempRect = new Rect();

            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                if (onApplyWindowInsets.isConsumed()) {
                    return onApplyWindowInsets;
                }
                Rect rect = this.mTempRect;
                rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
                rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
                rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
                rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
                int childCount = ViewPager.this.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i5), onApplyWindowInsets);
                    rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                    rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                    rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                    rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
                }
                return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
            r17 = this;
            r0 = r17
            super.onDraw(r18)
            int r1 = r0.mPageMargin
            if (r1 <= 0) goto L_0x00a8
            android.graphics.drawable.Drawable r1 = r0.mMarginDrawable
            if (r1 == 0) goto L_0x00a8
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r1 = r0.mItems
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00a8
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            if (r1 == 0) goto L_0x00a8
            int r1 = r0.getScrollX()
            int r2 = r0.getWidth()
            int r3 = r0.mPageMargin
            float r3 = (float) r3
            float r4 = (float) r2
            float r3 = r3 / r4
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            float r7 = r5.offset
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r8 = r0.mItems
            int r8 = r8.size()
            int r9 = r5.position
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r10 = r0.mItems
            int r11 = r8 + -1
            java.lang.Object r10 = r10.get(r11)
            androidx.viewpager.widget.ViewPager$ItemInfo r10 = (androidx.viewpager.widget.ViewPager.ItemInfo) r10
            int r10 = r10.position
        L_0x0045:
            if (r9 >= r10) goto L_0x00a8
        L_0x0047:
            int r11 = r5.position
            if (r9 <= r11) goto L_0x0058
            if (r6 >= r8) goto L_0x0058
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            int r6 = r6 + 1
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x0047
        L_0x0058:
            if (r9 != r11) goto L_0x0064
            float r7 = r5.offset
            float r11 = r5.widthFactor
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r7 = r7 + r11
            float r7 = r7 + r3
            goto L_0x006f
        L_0x0064:
            androidx.viewpager.widget.PagerAdapter r11 = r0.mAdapter
            float r11 = r11.getPageWidth(r9)
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r11 = r11 + r3
            float r7 = r7 + r11
        L_0x006f:
            int r11 = r0.mPageMargin
            float r11 = (float) r11
            float r11 = r11 + r12
            float r13 = (float) r1
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x0097
            android.graphics.drawable.Drawable r11 = r0.mMarginDrawable
            int r13 = java.lang.Math.round(r12)
            int r14 = r0.mTopPageBounds
            int r15 = r0.mPageMargin
            float r15 = (float) r15
            float r15 = r15 + r12
            int r15 = java.lang.Math.round(r15)
            r16 = r1
            int r1 = r0.mBottomPageBounds
            r11.setBounds(r13, r14, r15, r1)
            android.graphics.drawable.Drawable r1 = r0.mMarginDrawable
            r11 = r18
            r1.draw(r11)
            goto L_0x009b
        L_0x0097:
            r11 = r18
            r16 = r1
        L_0x009b:
            int r1 = r16 + r2
            float r1 = (float) r1
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00a3
            goto L_0x00a8
        L_0x00a3:
            int r9 = r9 + 1
            r1 = r16
            goto L_0x0045
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onDraw(android.graphics.Canvas):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f5;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x4 = motionEvent.getX();
            this.mInitialMotionX = x4;
            this.mLastMotionX = x4;
            float y4 = motionEvent.getY();
            this.mInitialMotionY = y4;
            this.mLastMotionY = y4;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i5 = this.mActivePointerId;
            if (i5 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i5);
                float x5 = motionEvent.getX(findPointerIndex);
                float f6 = x5 - this.mLastMotionX;
                float abs = Math.abs(f6);
                float y5 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y5 - this.mInitialMotionY);
                int i6 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
                if (i6 != 0 && !isGutterDrag(this.mLastMotionX, f6)) {
                    if (canScroll(this, false, (int) f6, (int) x5, (int) y5)) {
                        this.mLastMotionX = x5;
                        this.mLastMotionY = y5;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                }
                int i7 = this.mTouchSlop;
                if (abs > ((float) i7) && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    float f7 = this.mInitialMotionX;
                    float f8 = (float) this.mTouchSlop;
                    if (i6 > 0) {
                        f5 = f7 + f8;
                    } else {
                        f5 = f7 - f8;
                    }
                    this.mLastMotionX = f5;
                    this.mLastMotionY = y5;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) i7)) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x5)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.getChildCount()
            int r2 = r22 - r20
            int r3 = r23 - r21
            int r4 = r0.getPaddingLeft()
            int r5 = r0.getPaddingTop()
            int r6 = r0.getPaddingRight()
            int r7 = r0.getPaddingBottom()
            int r8 = r0.getScrollX()
            r10 = 0
            r11 = 0
        L_0x0020:
            r12 = 8
            if (r10 >= r1) goto L_0x00b8
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            if (r14 == r12) goto L_0x00b4
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r12 = (androidx.viewpager.widget.ViewPager.LayoutParams) r12
            boolean r14 = r12.isDecor
            if (r14 == 0) goto L_0x00b4
            int r12 = r12.gravity
            r14 = r12 & 7
            r12 = r12 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r14 == r15) goto L_0x0061
            r15 = 3
            if (r14 == r15) goto L_0x005b
            r15 = 5
            if (r14 == r15) goto L_0x0049
            r14 = r4
            goto L_0x006e
        L_0x0049:
            int r14 = r2 - r6
            int r15 = r13.getMeasuredWidth()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredWidth()
            int r6 = r6 + r15
        L_0x0055:
            r17 = r14
            r14 = r4
            r4 = r17
            goto L_0x006e
        L_0x005b:
            int r14 = r13.getMeasuredWidth()
            int r14 = r14 + r4
            goto L_0x006e
        L_0x0061:
            int r14 = r13.getMeasuredWidth()
            int r14 = r2 - r14
            int r14 = r14 / 2
            int r14 = java.lang.Math.max(r14, r4)
            goto L_0x0055
        L_0x006e:
            r15 = 16
            if (r12 == r15) goto L_0x0094
            r15 = 48
            if (r12 == r15) goto L_0x008e
            r15 = 80
            if (r12 == r15) goto L_0x007c
            r12 = r5
            goto L_0x00a1
        L_0x007c:
            int r12 = r3 - r7
            int r15 = r13.getMeasuredHeight()
            int r12 = r12 - r15
            int r15 = r13.getMeasuredHeight()
            int r7 = r7 + r15
        L_0x0088:
            r17 = r12
            r12 = r5
            r5 = r17
            goto L_0x00a1
        L_0x008e:
            int r12 = r13.getMeasuredHeight()
            int r12 = r12 + r5
            goto L_0x00a1
        L_0x0094:
            int r12 = r13.getMeasuredHeight()
            int r12 = r3 - r12
            int r12 = r12 / 2
            int r12 = java.lang.Math.max(r12, r5)
            goto L_0x0088
        L_0x00a1:
            int r4 = r4 + r8
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r4
            int r16 = r13.getMeasuredHeight()
            int r9 = r5 + r16
            r13.layout(r4, r5, r15, r9)
            int r11 = r11 + 1
            r5 = r12
            r4 = r14
        L_0x00b4:
            int r10 = r10 + 1
            goto L_0x0020
        L_0x00b8:
            int r2 = r2 - r4
            int r2 = r2 - r6
            r6 = 0
        L_0x00bb:
            if (r6 >= r1) goto L_0x0108
            android.view.View r8 = r0.getChildAt(r6)
            int r9 = r8.getVisibility()
            if (r9 == r12) goto L_0x0105
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.isDecor
            if (r10 != 0) goto L_0x0105
            androidx.viewpager.widget.ViewPager$ItemInfo r10 = r0.infoForChild(r8)
            if (r10 == 0) goto L_0x0105
            float r13 = (float) r2
            float r10 = r10.offset
            float r10 = r10 * r13
            int r10 = (int) r10
            int r10 = r10 + r4
            boolean r14 = r9.needsMeasure
            if (r14 == 0) goto L_0x00f8
            r14 = 0
            r9.needsMeasure = r14
            float r9 = r9.widthFactor
            float r13 = r13 * r9
            int r9 = (int) r13
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
            int r14 = r3 - r5
            int r14 = r14 - r7
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r8.measure(r9, r13)
        L_0x00f8:
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r10
            int r13 = r8.getMeasuredHeight()
            int r13 = r13 + r5
            r8.layout(r10, r5, r9, r13)
        L_0x0105:
            int r6 = r6 + 1
            goto L_0x00bb
        L_0x0108:
            r0.mTopPageBounds = r5
            int r3 = r3 - r7
            r0.mBottomPageBounds = r3
            r0.mDecorChildCount = r11
            boolean r1 = r0.mFirstLayout
            if (r1 == 0) goto L_0x011a
            int r1 = r0.mCurItem
            r14 = 0
            r0.scrollToItem(r1, r14, r14, r14)
            goto L_0x011b
        L_0x011a:
            r14 = 0
        L_0x011b:
            r0.mFirstLayout = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z4;
        int i7;
        setMeasuredDimension(View.getDefaultSize(0, i5), View.getDefaultSize(0, i6));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i8 = 0;
        while (true) {
            boolean z5 = true;
            int i9 = 1073741824;
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (!(childAt.getVisibility() == 8 || (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) == null || !layoutParams2.isDecor)) {
                int i10 = layoutParams2.gravity;
                int i11 = i10 & 7;
                int i12 = i10 & 112;
                if (i12 == 48 || i12 == 80) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!(i11 == 3 || i11 == 5)) {
                    z5 = false;
                }
                int i13 = Integer.MIN_VALUE;
                if (z4) {
                    i7 = Integer.MIN_VALUE;
                    i13 = 1073741824;
                } else if (z5) {
                    i7 = 1073741824;
                } else {
                    i7 = Integer.MIN_VALUE;
                }
                int i14 = layoutParams2.width;
                if (i14 != -2) {
                    if (i14 == -1) {
                        i14 = paddingLeft;
                    }
                    i13 = 1073741824;
                } else {
                    i14 = paddingLeft;
                }
                int i15 = layoutParams2.height;
                if (i15 == -2) {
                    i15 = measuredHeight;
                    i9 = i7;
                } else if (i15 == -1) {
                    i15 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i14, i13), View.MeasureSpec.makeMeasureSpec(i15, i9));
                if (z4) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z5) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i8++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.isDecor)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * layoutParams.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageScrolled(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.mDecorChildCount
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006c
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L_0x001b:
            if (r7 >= r6) goto L_0x006c
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.isDecor
            if (r10 != 0) goto L_0x002c
            goto L_0x0069
        L_0x002c:
            int r9 = r9.gravity
            r9 = r9 & 7
            if (r9 == r2) goto L_0x0050
            r10 = 3
            if (r9 == r10) goto L_0x004a
            r10 = 5
            if (r9 == r10) goto L_0x003a
            r9 = r3
            goto L_0x005d
        L_0x003a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
        L_0x0046:
            r11 = r9
            r9 = r3
            r3 = r11
            goto L_0x005d
        L_0x004a:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L_0x005d
        L_0x0050:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
            goto L_0x0046
        L_0x005d:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L_0x0068
            r8.offsetLeftAndRight(r3)
        L_0x0068:
            r3 = r9
        L_0x0069:
            int r7 = r7 + 1
            goto L_0x001b
        L_0x006c:
            r12.dispatchOnPageScrolled(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$PageTransformer r13 = r12.mPageTransformer
            if (r13 == 0) goto L_0x00a0
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007b:
            if (r1 >= r14) goto L_0x00a0
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.isDecor
            if (r0 == 0) goto L_0x008c
            goto L_0x009d
        L_0x008c:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$PageTransformer r3 = r12.mPageTransformer
            r3.transformPage(r15, r0)
        L_0x009d:
            int r1 = r1 + 1
            goto L_0x007b
        L_0x00a0:
            r12.mCalledSuper = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onPageScrolled(int, float, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i5, Rect rect) {
        int i6;
        int i7;
        int i8;
        ItemInfo infoForChild;
        int childCount = getChildCount();
        if ((i5 & 2) != 0) {
            i7 = childCount;
            i8 = 0;
            i6 = 1;
        } else {
            i8 = childCount - 1;
            i7 = -1;
            i6 = -1;
        }
        while (i8 != i7) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i5, rect)) {
                return true;
            }
            i8 += i6;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, false, true);
            return;
        }
        this.mRestoredCurItem = savedState.position;
        this.mRestoredAdapterState = savedState.adapterState;
        this.mRestoredClassLoader = savedState.loader;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            savedState.adapterState = pagerAdapter.saveState();
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        if (i5 != i7) {
            int i9 = this.mPageMargin;
            recomputeScrollPosition(i5, i7, i9, i9);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        float f5;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z4 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x4 = motionEvent.getX();
            this.mInitialMotionX = x4;
            this.mLastMotionX = x4;
            float y4 = motionEvent.getY();
            this.mInitialMotionY = y4;
            this.mLastMotionY = y4;
            this.mActivePointerId = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mIsBeingDragged) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        z4 = resetTouch();
                    } else {
                        float x5 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x5 - this.mLastMotionX);
                        float y5 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y5 - this.mLastMotionY);
                        if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            float f6 = this.mInitialMotionX;
                            if (x5 - f6 > 0.0f) {
                                f5 = f6 + ((float) this.mTouchSlop);
                            } else {
                                f5 = f6 - ((float) this.mTouchSlop);
                            }
                            this.mLastMotionX = f5;
                            this.mLastMotionY = y5;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z4 = performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                }
            } else if (this.mIsBeingDragged) {
                scrollToItem(this.mCurItem, true, 0, false);
                z4 = resetTouch();
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            float f7 = (float) clientWidth;
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / f7) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (((float) this.mPageMargin) / f7)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
            z4 = resetTouch();
        }
        if (z4) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean pageLeft() {
        int i5 = this.mCurItem;
        if (i5 <= 0) {
            return false;
        }
        setCurrentItem(i5 - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void populate() {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.mAdapter;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver((DataSetObserver) null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i5 = 0; i5 < this.mItems.size(); i5++) {
                ItemInfo itemInfo = this.mItems.get(i5);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z4 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z4) {
                populate();
            } else {
                requestLayout();
            }
        }
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list != null && !list.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.mAdapterChangeListeners.get(i6).onAdapterChanged(this, pagerAdapter3, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int i5) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i5, !this.mFirstLayout, false);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i5, boolean z4, boolean z5) {
        setCurrentItemInternal(i5, z4, z5, 0);
    }

    /* access modifiers changed from: package-private */
    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setOffscreenPageLimit(int i5) {
        if (i5 < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i5 + " too small; defaulting to " + 1);
            i5 = 1;
        }
        if (i5 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i5;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int i5) {
        int i6 = this.mPageMargin;
        this.mPageMargin = i5;
        int width = getWidth();
        recomputeScrollPosition(width, width, i5, i6);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z4, @Nullable PageTransformer pageTransformer) {
        setPageTransformer(z4, pageTransformer, 2);
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i5) {
        boolean z4;
        if (this.mScrollState != i5) {
            this.mScrollState = i5;
            if (this.mPageTransformer != null) {
                if (i5 != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                enableLayers(z4);
            }
            dispatchOnScrollStateChanged(i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i5, int i6) {
        smoothScrollTo(i5, i6, 0);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.mMarginDrawable) {
            return true;
        }
        return false;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        if (r9 == r10) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populate(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.mCurItem
            if (r2 == r1) goto L_0x000f
            androidx.viewpager.widget.ViewPager$ItemInfo r2 = r0.infoForPosition(r2)
            r0.mCurItem = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            if (r1 != 0) goto L_0x0018
            r0.sortChildDrawingOrder()
            return
        L_0x0018:
            boolean r1 = r0.mPopulatePending
            if (r1 == 0) goto L_0x0020
            r0.sortChildDrawingOrder()
            return
        L_0x0020:
            android.os.IBinder r1 = r0.getWindowToken()
            if (r1 != 0) goto L_0x0028
            goto L_0x020f
        L_0x0028:
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            r1.startUpdate((android.view.ViewGroup) r0)
            int r1 = r0.mOffscreenPageLimit
            int r4 = r0.mCurItem
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.viewpager.widget.PagerAdapter r6 = r0.mAdapter
            int r6 = r6.getCount()
            int r7 = r6 + -1
            int r8 = r0.mCurItem
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.mExpectedAdapterCount
            if (r6 != r7) goto L_0x0210
            r7 = r5
        L_0x004b:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r8 = r0.mItems
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x0067
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r8 = r0.mItems
            java.lang.Object r8 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$ItemInfo r8 = (androidx.viewpager.widget.ViewPager.ItemInfo) r8
            int r9 = r8.position
            int r10 = r0.mCurItem
            if (r9 < r10) goto L_0x0064
            if (r9 != r10) goto L_0x0067
            goto L_0x0068
        L_0x0064:
            int r7 = r7 + 1
            goto L_0x004b
        L_0x0067:
            r8 = 0
        L_0x0068:
            if (r8 != 0) goto L_0x0072
            if (r6 <= 0) goto L_0x0072
            int r8 = r0.mCurItem
            androidx.viewpager.widget.ViewPager$ItemInfo r8 = r0.addNewItem(r8, r7)
        L_0x0072:
            r9 = 0
            if (r8 == 0) goto L_0x019d
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0082
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r11 = r0.mItems
            java.lang.Object r11 = r11.get(r10)
            androidx.viewpager.widget.ViewPager$ItemInfo r11 = (androidx.viewpager.widget.ViewPager.ItemInfo) r11
            goto L_0x0083
        L_0x0082:
            r11 = 0
        L_0x0083:
            int r12 = r0.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x008d
            r14 = r9
            goto L_0x0099
        L_0x008d:
            float r14 = r8.widthFactor
            float r14 = r13 - r14
            int r15 = r0.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r14 = r14 + r15
        L_0x0099:
            int r3 = r0.mCurItem
            int r3 = r3 + -1
            r15 = r9
        L_0x009e:
            if (r3 < 0) goto L_0x00ff
            int r16 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00cf
            if (r3 >= r4) goto L_0x00cf
            if (r11 != 0) goto L_0x00a9
            goto L_0x00ff
        L_0x00a9:
            int r5 = r11.position
            if (r3 != r5) goto L_0x00fb
            boolean r5 = r11.scrolling
            if (r5 != 0) goto L_0x00fb
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            r5.remove(r10)
            androidx.viewpager.widget.PagerAdapter r5 = r0.mAdapter
            java.lang.Object r11 = r11.object
            r5.destroyItem((android.view.ViewGroup) r0, (int) r3, (java.lang.Object) r11)
            int r10 = r10 + -1
            int r7 = r7 + -1
            if (r10 < 0) goto L_0x00cc
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x00cd
        L_0x00cc:
            r5 = 0
        L_0x00cd:
            r11 = r5
            goto L_0x00fb
        L_0x00cf:
            if (r11 == 0) goto L_0x00e5
            int r5 = r11.position
            if (r3 != r5) goto L_0x00e5
            float r5 = r11.widthFactor
            float r15 = r15 + r5
            int r10 = r10 + -1
            if (r10 < 0) goto L_0x00cc
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x00cd
        L_0x00e5:
            int r5 = r10 + 1
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = r0.addNewItem(r3, r5)
            float r5 = r5.widthFactor
            float r15 = r15 + r5
            int r7 = r7 + 1
            if (r10 < 0) goto L_0x00cc
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x00cd
        L_0x00fb:
            int r3 = r3 + -1
            r5 = 0
            goto L_0x009e
        L_0x00ff:
            float r3 = r8.widthFactor
            int r4 = r7 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0191
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0118
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x0119
        L_0x0118:
            r5 = 0
        L_0x0119:
            if (r12 > 0) goto L_0x011d
            r10 = r9
            goto L_0x0125
        L_0x011d:
            int r10 = r0.getPaddingRight()
            float r10 = (float) r10
            float r11 = (float) r12
            float r10 = r10 / r11
            float r10 = r10 + r13
        L_0x0125:
            int r11 = r0.mCurItem
        L_0x0127:
            int r11 = r11 + 1
            if (r11 >= r6) goto L_0x0191
            int r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x015b
            if (r11 <= r1) goto L_0x015b
            if (r5 != 0) goto L_0x0134
            goto L_0x0191
        L_0x0134:
            int r12 = r5.position
            if (r11 != r12) goto L_0x0190
            boolean r12 = r5.scrolling
            if (r12 != 0) goto L_0x0190
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r12 = r0.mItems
            r12.remove(r4)
            androidx.viewpager.widget.PagerAdapter r12 = r0.mAdapter
            java.lang.Object r5 = r5.object
            r12.destroyItem((android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r5)
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0159
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x0190
        L_0x0159:
            r5 = 0
            goto L_0x0190
        L_0x015b:
            if (r5 == 0) goto L_0x0177
            int r12 = r5.position
            if (r11 != r12) goto L_0x0177
            float r5 = r5.widthFactor
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0159
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x0190
        L_0x0177:
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = r0.addNewItem(r11, r4)
            int r4 = r4 + 1
            float r5 = r5.widthFactor
            float r3 = r3 + r5
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0159
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
        L_0x0190:
            goto L_0x0127
        L_0x0191:
            r0.calculatePageOffsets(r8, r7, r2)
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            int r2 = r0.mCurItem
            java.lang.Object r3 = r8.object
            r1.setPrimaryItem((android.view.ViewGroup) r0, (int) r2, (java.lang.Object) r3)
        L_0x019d:
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            r1.finishUpdate((android.view.ViewGroup) r0)
            int r1 = r0.getChildCount()
            r2 = 0
        L_0x01a7:
            if (r2 >= r1) goto L_0x01d0
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r4 = (androidx.viewpager.widget.ViewPager.LayoutParams) r4
            r4.childIndex = r2
            boolean r5 = r4.isDecor
            if (r5 != 0) goto L_0x01cd
            float r5 = r4.widthFactor
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01cd
            androidx.viewpager.widget.ViewPager$ItemInfo r3 = r0.infoForChild(r3)
            if (r3 == 0) goto L_0x01cd
            float r5 = r3.widthFactor
            r4.widthFactor = r5
            int r3 = r3.position
            r4.position = r3
        L_0x01cd:
            int r2 = r2 + 1
            goto L_0x01a7
        L_0x01d0:
            r0.sortChildDrawingOrder()
            boolean r1 = r0.hasFocus()
            if (r1 == 0) goto L_0x020f
            android.view.View r1 = r0.findFocus()
            if (r1 == 0) goto L_0x01e4
            androidx.viewpager.widget.ViewPager$ItemInfo r3 = r0.infoForAnyChild(r1)
            goto L_0x01e5
        L_0x01e4:
            r3 = 0
        L_0x01e5:
            if (r3 == 0) goto L_0x01ed
            int r1 = r3.position
            int r2 = r0.mCurItem
            if (r1 == r2) goto L_0x020f
        L_0x01ed:
            r5 = 0
        L_0x01ee:
            int r1 = r0.getChildCount()
            if (r5 >= r1) goto L_0x020f
            android.view.View r1 = r0.getChildAt(r5)
            androidx.viewpager.widget.ViewPager$ItemInfo r2 = r0.infoForChild(r1)
            if (r2 == 0) goto L_0x020c
            int r2 = r2.position
            int r3 = r0.mCurItem
            if (r2 != r3) goto L_0x020c
            r2 = 2
            boolean r1 = r1.requestFocus(r2)
            if (r1 == 0) goto L_0x020c
            goto L_0x020f
        L_0x020c:
            int r5 = r5 + 1
            goto L_0x01ee
        L_0x020f:
            return
        L_0x0210:
            android.content.res.Resources r1 = r0.getResources()     // Catch:{ NotFoundException -> 0x021d }
            int r2 = r0.getId()     // Catch:{ NotFoundException -> 0x021d }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x021d }
            goto L_0x0225
        L_0x021d:
            int r1 = r0.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0225:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.mExpectedAdapterCount
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r0.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.populate(int):void");
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i5, boolean z4, boolean z5, int i6) {
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean z6 = false;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z5 || this.mCurItem != i5 || this.mItems.size() == 0) {
            if (i5 < 0) {
                i5 = 0;
            } else if (i5 >= this.mAdapter.getCount()) {
                i5 = this.mAdapter.getCount() - 1;
            }
            int i7 = this.mOffscreenPageLimit;
            int i8 = this.mCurItem;
            if (i5 > i8 + i7 || i5 < i8 - i7) {
                for (int i9 = 0; i9 < this.mItems.size(); i9++) {
                    this.mItems.get(i9).scrolling = true;
                }
            }
            if (this.mCurItem != i5) {
                z6 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i5;
                if (z6) {
                    dispatchOnPageSelected(i5);
                }
                requestLayout();
                return;
            }
            populate(i5);
            scrollToItem(i5, z4, i6, z6);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setPageTransformer(boolean z4, @Nullable PageTransformer pageTransformer, int i5) {
        int i6 = 1;
        boolean z5 = pageTransformer != null;
        boolean z6 = z5 != (this.mPageTransformer != null);
        this.mPageTransformer = pageTransformer;
        setChildrenDrawingOrderEnabled(z5);
        if (z5) {
            if (z4) {
                i6 = 2;
            }
            this.mDrawingOrder = i6;
            this.mPageTransformerLayerType = i5;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z6) {
            populate();
        }
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i5, int i6, int i7) {
        int scrollX;
        int i8;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i9 = scrollX;
        int scrollY = getScrollY();
        int i10 = i5 - i9;
        int i11 = i6 - scrollY;
        if (i10 == 0 && i11 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i12 = clientWidth / 2;
        float f5 = (float) clientWidth;
        float f6 = (float) i12;
        float distanceInfluenceForSnapDuration = f6 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i10)) * 1.0f) / f5)) * f6);
        int abs = Math.abs(i7);
        if (abs > 0) {
            i8 = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4;
        } else {
            i8 = (int) (((((float) Math.abs(i10)) / ((f5 * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i8, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i9, scrollY, i10, i11, min);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setCurrentItem(int i5, boolean z4) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i5, z4, false);
    }

    public void setPageMarginDrawable(@DrawableRes int i5) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i5));
    }

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }
}
