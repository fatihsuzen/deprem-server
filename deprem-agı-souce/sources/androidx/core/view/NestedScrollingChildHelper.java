package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.mView = view;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SimplifyVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0009: MOVE  (r9v0 int) = (r19v0 int)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
        */
    private boolean dispatchNestedScrollInternal(int r14, int r15, int r16, int r17, @androidx.annotation.Nullable int[] r18, int r19, @androidx.annotation.Nullable int[] r20) {
        /*
            r13 = this;
            r0 = r18
            boolean r1 = r13.isNestedScrollingEnabled()
            r2 = 0
            if (r1 == 0) goto L_0x005e
            r9 = r19
            android.view.ViewParent r3 = r13.getNestedScrollingParentForType(r9)
            if (r3 != 0) goto L_0x0012
            return r2
        L_0x0012:
            r1 = 1
            if (r14 != 0) goto L_0x0023
            if (r15 != 0) goto L_0x0023
            if (r16 != 0) goto L_0x0023
            if (r17 == 0) goto L_0x001c
            goto L_0x0023
        L_0x001c:
            if (r0 == 0) goto L_0x005e
            r0[r2] = r2
            r0[r1] = r2
            goto L_0x005e
        L_0x0023:
            if (r0 == 0) goto L_0x0031
            android.view.View r4 = r13.mView
            r4.getLocationInWindow(r0)
            r4 = r0[r2]
            r5 = r0[r1]
            r11 = r4
            r12 = r5
            goto L_0x0033
        L_0x0031:
            r11 = r2
            r12 = r11
        L_0x0033:
            if (r20 != 0) goto L_0x003f
            int[] r4 = r13.getTempNestedScrollConsumed()
            r4[r2] = r2
            r4[r1] = r2
            r10 = r4
            goto L_0x0041
        L_0x003f:
            r10 = r20
        L_0x0041:
            android.view.View r4 = r13.mView
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            androidx.core.view.ViewParentCompat.onNestedScroll(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 == 0) goto L_0x005d
            android.view.View r14 = r13.mView
            r14.getLocationInWindow(r0)
            r14 = r0[r2]
            int r14 = r14 - r11
            r0[r2] = r14
            r14 = r0[r1]
            int r14 = r14 - r12
            r0[r1] = r14
        L_0x005d:
            return r1
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.NestedScrollingChildHelper.dispatchNestedScrollInternal(int, int, int, int, int[], int, int[]):boolean");
    }

    private ViewParent getNestedScrollingParentForType(int i5) {
        if (i5 == 0) {
            return this.mNestedScrollingParentTouch;
        }
        if (i5 != 1) {
            return null;
        }
        return this.mNestedScrollingParentNonTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed == null) {
            this.mTempNestedScrollConsumed = new int[2];
        }
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int i5, ViewParent viewParent) {
        if (i5 == 0) {
            this.mNestedScrollingParentTouch = viewParent;
        } else if (i5 == 1) {
            this.mNestedScrollingParentNonTouch = viewParent;
        }
    }

    public boolean dispatchNestedFling(float f5, float f6, boolean z4) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f5, f6, z4);
    }

    public boolean dispatchNestedPreFling(float f5, float f6) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f5, f6);
    }

    public boolean dispatchNestedPreScroll(int i5, int i6, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i5, i6, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, @Nullable int[] iArr) {
        return dispatchNestedScrollInternal(i5, i6, i7, i8, iArr, 0, (int[]) null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z4) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z4;
    }

    public boolean startNestedScroll(int i5) {
        return startNestedScroll(i5, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedPreScroll(int i5, int i6, @Nullable int[] iArr, @Nullable int[] iArr2, int i7) {
        ViewParent nestedScrollingParentForType;
        int i8;
        int i9;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i7)) == null) {
            return false;
        }
        if (i5 == 0 && i6 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            i9 = iArr2[0];
            i8 = iArr2[1];
        } else {
            i9 = 0;
            i8 = 0;
        }
        if (iArr == null) {
            iArr = getTempNestedScrollConsumed();
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i5, i6, iArr3, i7);
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i9;
            iArr2[1] = iArr2[1] - i8;
        }
        if (iArr3[0] == 0 && iArr3[1] == 0) {
            return false;
        }
        return true;
    }

    public boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, @Nullable int[] iArr, int i9) {
        return dispatchNestedScrollInternal(i5, i6, i7, i8, iArr, i9, (int[]) null);
    }

    public boolean hasNestedScrollingParent(int i5) {
        return getNestedScrollingParentForType(i5) != null;
    }

    public boolean startNestedScroll(int i5, int i6) {
        if (hasNestedScrollingParent(i6)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.mView;
        for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i5, i6)) {
                setNestedScrollingParentForType(i6, parent);
                ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i5, i6);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll(int i5) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i5);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i5);
            setNestedScrollingParentForType(i5, (ViewParent) null);
        }
    }

    public void dispatchNestedScroll(int i5, int i6, int i7, int i8, @Nullable int[] iArr, int i9, @Nullable int[] iArr2) {
        dispatchNestedScrollInternal(i5, i6, i7, i8, iArr, i9, iArr2);
    }
}
