package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ScaleFrameLayout extends FrameLayout {
    private static final int DEFAULT_CHILD_GRAVITY = 8388659;
    private float mChildScale;
    private float mLayoutScaleX;
    private float mLayoutScaleY;

    public ScaleFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private static int getScaledMeasureSpec(int i5, float f5) {
        if (f5 == 1.0f) {
            return i5;
        }
        return View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i5)) / f5) + 0.5f), View.MeasureSpec.getMode(i5));
    }

    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i5, layoutParams);
        view.setScaleX(this.mChildScale);
        view.setScaleY(this.mChildScale);
    }

    /* access modifiers changed from: protected */
    public boolean addViewInLayout(View view, int i5, ViewGroup.LayoutParams layoutParams, boolean z4) {
        boolean addViewInLayout = super.addViewInLayout(view, i5, layoutParams, z4);
        if (addViewInLayout) {
            view.setScaleX(this.mChildScale);
            view.setScaleY(this.mChildScale);
        }
        return addViewInLayout;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
            r16 = this;
            r0 = r16
            int r1 = r0.getChildCount()
            int r2 = r0.getLayoutDirection()
            r3 = 1
            if (r2 != r3) goto L_0x0018
            int r4 = r0.getWidth()
            float r4 = (float) r4
            float r5 = r0.getPivotX()
            float r4 = r4 - r5
            goto L_0x001c
        L_0x0018:
            float r4 = r0.getPivotX()
        L_0x001c:
            float r5 = r0.mLayoutScaleX
            r6 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            r7 = 1056964608(0x3f000000, float:0.5)
            if (r5 == 0) goto L_0x0041
            int r5 = r0.getPaddingLeft()
            float r8 = r0.mLayoutScaleX
            float r9 = r4 / r8
            float r9 = r4 - r9
            float r9 = r9 + r7
            int r9 = (int) r9
            int r5 = r5 + r9
            int r9 = r20 - r18
            float r9 = (float) r9
            float r9 = r9 - r4
            float r9 = r9 / r8
            float r9 = r9 + r4
            float r9 = r9 + r7
            int r8 = (int) r9
            int r9 = r0.getPaddingRight()
        L_0x003f:
            int r8 = r8 - r9
            goto L_0x004c
        L_0x0041:
            int r5 = r0.getPaddingLeft()
            int r8 = r20 - r18
            int r9 = r0.getPaddingRight()
            goto L_0x003f
        L_0x004c:
            float r9 = r0.getPivotY()
            float r10 = r0.mLayoutScaleY
            int r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0071
            int r6 = r0.getPaddingTop()
            float r10 = r0.mLayoutScaleY
            float r11 = r9 / r10
            float r11 = r9 - r11
            float r11 = r11 + r7
            int r11 = (int) r11
            int r6 = r6 + r11
            int r11 = r21 - r19
            float r11 = (float) r11
            float r11 = r11 - r9
            float r11 = r11 / r10
            float r11 = r11 + r9
            float r11 = r11 + r7
            int r7 = (int) r11
            int r10 = r0.getPaddingBottom()
        L_0x006f:
            int r7 = r7 - r10
            goto L_0x007c
        L_0x0071:
            int r6 = r0.getPaddingTop()
            int r7 = r21 - r19
            int r10 = r0.getPaddingBottom()
            goto L_0x006f
        L_0x007c:
            r10 = 0
        L_0x007d:
            if (r10 >= r1) goto L_0x0102
            android.view.View r11 = r0.getChildAt(r10)
            int r12 = r11.getVisibility()
            r13 = 8
            if (r12 == r13) goto L_0x00fb
            android.view.ViewGroup$LayoutParams r12 = r11.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r12 = (android.widget.FrameLayout.LayoutParams) r12
            int r13 = r11.getMeasuredWidth()
            int r14 = r11.getMeasuredHeight()
            int r15 = r12.gravity
            r3 = -1
            if (r15 != r3) goto L_0x00a1
            r15 = 8388659(0x800033, float:1.1755015E-38)
        L_0x00a1:
            int r3 = android.view.Gravity.getAbsoluteGravity(r15, r2)
            r15 = r15 & 112(0x70, float:1.57E-43)
            r3 = r3 & 7
            r0 = 1
            if (r3 == r0) goto L_0x00b9
            r0 = 5
            if (r3 == r0) goto L_0x00b3
            int r0 = r12.leftMargin
            int r0 = r0 + r5
            goto L_0x00c5
        L_0x00b3:
            int r0 = r8 - r13
            int r3 = r12.rightMargin
        L_0x00b7:
            int r0 = r0 - r3
            goto L_0x00c5
        L_0x00b9:
            int r0 = r8 - r5
            int r0 = r0 - r13
            int r0 = r0 / 2
            int r0 = r0 + r5
            int r3 = r12.leftMargin
            int r0 = r0 + r3
            int r3 = r12.rightMargin
            goto L_0x00b7
        L_0x00c5:
            r3 = 16
            if (r15 == r3) goto L_0x00de
            r3 = 48
            if (r15 == r3) goto L_0x00db
            r3 = 80
            if (r15 == r3) goto L_0x00d5
            int r3 = r12.topMargin
        L_0x00d3:
            int r3 = r3 + r6
            goto L_0x00ea
        L_0x00d5:
            int r3 = r7 - r14
            int r12 = r12.bottomMargin
        L_0x00d9:
            int r3 = r3 - r12
            goto L_0x00ea
        L_0x00db:
            int r3 = r12.topMargin
            goto L_0x00d3
        L_0x00de:
            int r3 = r7 - r6
            int r3 = r3 - r14
            int r3 = r3 / 2
            int r3 = r3 + r6
            int r15 = r12.topMargin
            int r3 = r3 + r15
            int r12 = r12.bottomMargin
            goto L_0x00d9
        L_0x00ea:
            int r13 = r13 + r0
            int r14 = r14 + r3
            r11.layout(r0, r3, r13, r14)
            float r0 = (float) r0
            float r0 = r4 - r0
            r11.setPivotX(r0)
            float r0 = (float) r3
            float r0 = r9 - r0
            r11.setPivotY(r0)
        L_0x00fb:
            int r10 = r10 + 1
            r0 = r16
            r3 = 1
            goto L_0x007d
        L_0x0102:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.ScaleFrameLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        float f5 = this.mLayoutScaleX;
        if (f5 == 1.0f && this.mLayoutScaleY == 1.0f) {
            super.onMeasure(i5, i6);
            return;
        }
        super.onMeasure(getScaledMeasureSpec(i5, f5), getScaledMeasureSpec(i6, this.mLayoutScaleY));
        setMeasuredDimension((int) ((((float) getMeasuredWidth()) * this.mLayoutScaleX) + 0.5f), (int) ((((float) getMeasuredHeight()) * this.mLayoutScaleY) + 0.5f));
    }

    public void setChildScale(float f5) {
        if (this.mChildScale != f5) {
            this.mChildScale = f5;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                getChildAt(i5).setScaleX(f5);
                getChildAt(i5).setScaleY(f5);
            }
        }
    }

    public void setForeground(Drawable drawable) {
        throw new UnsupportedOperationException();
    }

    public void setLayoutScaleX(float f5) {
        if (f5 != this.mLayoutScaleX) {
            this.mLayoutScaleX = f5;
            requestLayout();
        }
    }

    public void setLayoutScaleY(float f5) {
        if (f5 != this.mLayoutScaleY) {
            this.mLayoutScaleY = f5;
            requestLayout();
        }
    }

    public ScaleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleFrameLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mLayoutScaleX = 1.0f;
        this.mLayoutScaleY = 1.0f;
        this.mChildScale = 1.0f;
    }
}
