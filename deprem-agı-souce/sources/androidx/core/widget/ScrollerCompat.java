package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class ScrollerCompat {
    OverScroller mScroller;

    ScrollerCompat(Context context, Interpolator interpolator) {
        OverScroller overScroller;
        if (interpolator != null) {
            overScroller = new OverScroller(context, interpolator);
        } else {
            overScroller = new OverScroller(context);
        }
        this.mScroller = overScroller;
    }

    @Deprecated
    public static ScrollerCompat create(Context context) {
        return create(context, (Interpolator) null);
    }

    @Deprecated
    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    @Deprecated
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    @Deprecated
    public void fling(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.mScroller.fling(i5, i6, i7, i8, i9, i10, i11, i12);
    }

    @Deprecated
    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    @Deprecated
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Deprecated
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    @Deprecated
    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    @Deprecated
    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    @Deprecated
    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    @Deprecated
    public void notifyHorizontalEdgeReached(int i5, int i6, int i7) {
        this.mScroller.notifyHorizontalEdgeReached(i5, i6, i7);
    }

    @Deprecated
    public void notifyVerticalEdgeReached(int i5, int i6, int i7) {
        this.mScroller.notifyVerticalEdgeReached(i5, i6, i7);
    }

    @Deprecated
    public boolean springBack(int i5, int i6, int i7, int i8, int i9, int i10) {
        return this.mScroller.springBack(i5, i6, i7, i8, i9, i10);
    }

    @Deprecated
    public void startScroll(int i5, int i6, int i7, int i8) {
        this.mScroller.startScroll(i5, i6, i7, i8);
    }

    @Deprecated
    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    @Deprecated
    public void fling(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        this.mScroller.fling(i5, i6, i7, i8, i9, i10, i11, i12, i13, i14);
    }

    @Deprecated
    public void startScroll(int i5, int i6, int i7, int i8, int i9) {
        this.mScroller.startScroll(i5, i6, i7, i8, i9);
    }
}
