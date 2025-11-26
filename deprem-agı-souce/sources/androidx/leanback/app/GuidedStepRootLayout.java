package androidx.leanback.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

class GuidedStepRootLayout extends LinearLayout {
    private boolean mFocusOutEnd = false;
    private boolean mFocusOutStart = false;

    public GuidedStepRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View focusSearch(android.view.View r5, int r6) {
        /*
            r4 = this;
            android.view.View r0 = super.focusSearch(r5, r6)
            r1 = 66
            r2 = 17
            if (r6 == r2) goto L_0x000c
            if (r6 != r1) goto L_0x0028
        L_0x000c:
            boolean r3 = androidx.leanback.widget.Util.isDescendant(r4, r0)
            if (r3 == 0) goto L_0x0013
            goto L_0x0028
        L_0x0013:
            int r3 = r4.getLayoutDirection()
            if (r3 != 0) goto L_0x001c
            if (r6 != r2) goto L_0x0023
            goto L_0x001e
        L_0x001c:
            if (r6 != r1) goto L_0x0023
        L_0x001e:
            boolean r6 = r4.mFocusOutStart
            if (r6 != 0) goto L_0x0028
            goto L_0x0027
        L_0x0023:
            boolean r6 = r4.mFocusOutEnd
            if (r6 != 0) goto L_0x0028
        L_0x0027:
            return r5
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.app.GuidedStepRootLayout.focusSearch(android.view.View, int):android.view.View");
    }

    public void setFocusOutEnd(boolean z4) {
        this.mFocusOutEnd = z4;
    }

    public void setFocusOutStart(boolean z4) {
        this.mFocusOutStart = z4;
    }

    public GuidedStepRootLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
