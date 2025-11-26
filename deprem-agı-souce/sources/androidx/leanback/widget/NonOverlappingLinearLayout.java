package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class NonOverlappingLinearLayout extends LinearLayout {
    boolean mDeferFocusableViewAvailableInLayout;
    boolean mFocusableViewAvailableFixEnabled;
    final ArrayList<ArrayList<View>> mSortedAvailableViews;

    public NonOverlappingLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void focusableViewAvailable(View view) {
        int i5;
        if (this.mDeferFocusableViewAvailableInLayout) {
            View view2 = view;
            while (true) {
                if (view2 == this || view2 == null) {
                    i5 = -1;
                } else if (view2.getParent() == this) {
                    i5 = indexOfChild(view2);
                    break;
                } else {
                    view2 = (View) view2.getParent();
                }
            }
            if (i5 != -1) {
                this.mSortedAvailableViews.get(i5).add(view);
                return;
            }
            return;
        }
        super.focusableViewAvailable(view);
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x001e A[LOOP:0: B:17:0x001e->B:20:0x002a, LOOP_START, SYNTHETIC, Splitter:B:17:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            r1 = 0
            boolean r0 = r8.mFocusableViewAvailableFixEnabled     // Catch:{ all -> 0x00a8 }
            r2 = 1
            if (r0 == 0) goto L_0x0019
            int r0 = r8.getOrientation()     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0019
            int r0 = r8.getLayoutDirection()     // Catch:{ all -> 0x0014 }
            if (r0 != r2) goto L_0x0019
            r0 = r2
            goto L_0x001a
        L_0x0014:
            r0 = move-exception
            r9 = r0
            r2 = r8
            goto L_0x00ab
        L_0x0019:
            r0 = r1
        L_0x001a:
            r8.mDeferFocusableViewAvailableInLayout = r0     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x004c
        L_0x001e:
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r0 = r8.mSortedAvailableViews     // Catch:{ all -> 0x0014 }
            int r0 = r0.size()     // Catch:{ all -> 0x0014 }
            int r3 = r8.getChildCount()     // Catch:{ all -> 0x0014 }
            if (r0 <= r3) goto L_0x0035
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r0 = r8.mSortedAvailableViews     // Catch:{ all -> 0x0014 }
            int r3 = r0.size()     // Catch:{ all -> 0x0014 }
            int r3 = r3 - r2
            r0.remove(r3)     // Catch:{ all -> 0x0014 }
            goto L_0x001e
        L_0x0035:
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r0 = r8.mSortedAvailableViews     // Catch:{ all -> 0x0014 }
            int r0 = r0.size()     // Catch:{ all -> 0x0014 }
            int r2 = r8.getChildCount()     // Catch:{ all -> 0x0014 }
            if (r0 >= r2) goto L_0x004c
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r0 = r8.mSortedAvailableViews     // Catch:{ all -> 0x0014 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0014 }
            r2.<init>()     // Catch:{ all -> 0x0014 }
            r0.add(r2)     // Catch:{ all -> 0x0014 }
            goto L_0x0035
        L_0x004c:
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            super.onLayout(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0085 }
            boolean r9 = r2.mDeferFocusableViewAvailableInLayout     // Catch:{ all -> 0x0085 }
            if (r9 == 0) goto L_0x008b
            r9 = r1
        L_0x005a:
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r10 = r2.mSortedAvailableViews     // Catch:{ all -> 0x0085 }
            int r10 = r10.size()     // Catch:{ all -> 0x0085 }
            if (r9 >= r10) goto L_0x008b
            r10 = r1
        L_0x0063:
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r11 = r2.mSortedAvailableViews     // Catch:{ all -> 0x0085 }
            java.lang.Object r11 = r11.get(r9)     // Catch:{ all -> 0x0085 }
            java.util.ArrayList r11 = (java.util.ArrayList) r11     // Catch:{ all -> 0x0085 }
            int r11 = r11.size()     // Catch:{ all -> 0x0085 }
            if (r10 >= r11) goto L_0x0088
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r11 = r2.mSortedAvailableViews     // Catch:{ all -> 0x0085 }
            java.lang.Object r11 = r11.get(r9)     // Catch:{ all -> 0x0085 }
            java.util.ArrayList r11 = (java.util.ArrayList) r11     // Catch:{ all -> 0x0085 }
            java.lang.Object r11 = r11.get(r10)     // Catch:{ all -> 0x0085 }
            android.view.View r11 = (android.view.View) r11     // Catch:{ all -> 0x0085 }
            super.focusableViewAvailable(r11)     // Catch:{ all -> 0x0085 }
            int r10 = r10 + 1
            goto L_0x0063
        L_0x0085:
            r0 = move-exception
        L_0x0086:
            r9 = r0
            goto L_0x00ab
        L_0x0088:
            int r9 = r9 + 1
            goto L_0x005a
        L_0x008b:
            boolean r9 = r2.mDeferFocusableViewAvailableInLayout
            if (r9 == 0) goto L_0x00a7
            r2.mDeferFocusableViewAvailableInLayout = r1
        L_0x0091:
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r9 = r2.mSortedAvailableViews
            int r9 = r9.size()
            if (r1 >= r9) goto L_0x00a7
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r9 = r2.mSortedAvailableViews
            java.lang.Object r9 = r9.get(r1)
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            r9.clear()
            int r1 = r1 + 1
            goto L_0x0091
        L_0x00a7:
            return
        L_0x00a8:
            r0 = move-exception
            r2 = r8
            goto L_0x0086
        L_0x00ab:
            boolean r10 = r2.mDeferFocusableViewAvailableInLayout
            if (r10 == 0) goto L_0x00c7
            r2.mDeferFocusableViewAvailableInLayout = r1
        L_0x00b1:
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r10 = r2.mSortedAvailableViews
            int r10 = r10.size()
            if (r1 >= r10) goto L_0x00c7
            java.util.ArrayList<java.util.ArrayList<android.view.View>> r10 = r2.mSortedAvailableViews
            java.lang.Object r10 = r10.get(r1)
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            r10.clear()
            int r1 = r1 + 1
            goto L_0x00b1
        L_0x00c7:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.NonOverlappingLinearLayout.onLayout(boolean, int, int, int, int):void");
    }

    public void setFocusableViewAvailableFixEnabled(boolean z4) {
        this.mFocusableViewAvailableFixEnabled = z4;
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mFocusableViewAvailableFixEnabled = false;
        this.mSortedAvailableViews = new ArrayList<>();
    }
}
