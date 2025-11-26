package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {
        private int mBaselineAlignedChildIndexId;
        private int mBaselineAlignedId;
        private int mDividerId;
        private int mDividerPaddingId;
        private int mGravityId;
        private int mMeasureWithLargestChildId;
        private int mOrientationId;
        private boolean mPropertiesMapped = false;
        private int mShowDividersId;
        private int mWeightSumId;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.mBaselineAlignedId = propertyMapper.mapBoolean("baselineAligned", 16843046);
            this.mBaselineAlignedChildIndexId = propertyMapper.mapInt("baselineAlignedChildIndex", 16843047);
            this.mGravityId = propertyMapper.mapGravity("gravity", 16842927);
            this.mOrientationId = propertyMapper.mapIntEnum("orientation", 16842948, new IntFunction<String>() {
                public String apply(int i5) {
                    if (i5 == 0) {
                        return "horizontal";
                    }
                    if (i5 != 1) {
                        return String.valueOf(i5);
                    }
                    return "vertical";
                }
            });
            this.mWeightSumId = propertyMapper.mapFloat("weightSum", 16843048);
            this.mDividerId = propertyMapper.mapObject("divider", R.attr.divider);
            this.mDividerPaddingId = propertyMapper.mapInt("dividerPadding", R.attr.dividerPadding);
            this.mMeasureWithLargestChildId = propertyMapper.mapBoolean("measureWithLargestChild", R.attr.measureWithLargestChild);
            this.mShowDividersId = propertyMapper.mapIntFlag("showDividers", R.attr.showDividers, new IntFunction<Set<String>>() {
                public Set<String> apply(int i5) {
                    HashSet hashSet = new HashSet();
                    if (i5 == 0) {
                        hashSet.add("none");
                    }
                    if (i5 == 1) {
                        hashSet.add("beginning");
                    }
                    if (i5 == 2) {
                        hashSet.add("middle");
                    }
                    if (i5 == 4) {
                        hashSet.add(TtmlNode.END);
                    }
                    return hashSet;
                }
            });
            this.mPropertiesMapped = true;
        }

        public void readProperties(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull PropertyReader propertyReader) {
            if (this.mPropertiesMapped) {
                propertyReader.readBoolean(this.mBaselineAlignedId, linearLayoutCompat.isBaselineAligned());
                propertyReader.readInt(this.mBaselineAlignedChildIndexId, linearLayoutCompat.getBaselineAlignedChildIndex());
                propertyReader.readGravity(this.mGravityId, linearLayoutCompat.getGravity());
                propertyReader.readIntEnum(this.mOrientationId, linearLayoutCompat.getOrientation());
                propertyReader.readFloat(this.mWeightSumId, linearLayoutCompat.getWeightSum());
                propertyReader.readObject(this.mDividerId, linearLayoutCompat.getDividerDrawable());
                propertyReader.readInt(this.mDividerPaddingId, linearLayoutCompat.getDividerPadding());
                propertyReader.readBoolean(this.mMeasureWithLargestChildId, linearLayoutCompat.isMeasureWithLargestChildEnabled());
                propertyReader.readIntFlag(this.mShowDividersId, linearLayoutCompat.getShowDividers());
                return;
            }
            throw c.a();
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
        }

        public LayoutParams(int i5, int i6, float f5) {
            super(i5, i6, f5);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void forceUniformHeight(int i5, int i6) {
        int i7;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int i8 = 0;
        while (i8 < i5) {
            View virtualChildAt = getVirtualChildAt(i8);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i9 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    i7 = i6;
                    measureChildWithMargins(virtualChildAt, i7, 0, makeMeasureSpec, 0);
                    layoutParams.width = i9;
                    i8++;
                    i6 = i7;
                }
            }
            i7 = i6;
            i8++;
            i6 = i7;
        }
    }

    private void forceUniformWidth(int i5, int i6) {
        int i7;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i8 = 0;
        while (i8 < i5) {
            View virtualChildAt = getVirtualChildAt(i8);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i9 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    i7 = i6;
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i7, 0);
                    layoutParams.height = i9;
                    i8++;
                    i6 = i7;
                }
            }
            i7 = i6;
            i8++;
            i6 = i7;
        }
    }

    private void setChildFrame(View view, int i5, int i6, int i7, int i8) {
        view.layout(i5, i6, i7 + i5, i8 + i6);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void drawDividersHorizontal(Canvas canvas) {
        int i5;
        int left;
        int i6;
        int i7;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i8 = 0; i8 < virtualChildCount; i8++) {
            View virtualChildAt = getVirtualChildAt(i8);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i8))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    i7 = virtualChildAt.getRight() + layoutParams.rightMargin;
                } else {
                    i7 = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, i7);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    left = virtualChildAt2.getLeft() - layoutParams2.leftMargin;
                    i6 = this.mDividerWidth;
                } else {
                    i5 = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                    drawVerticalDivider(canvas, i5);
                }
            } else if (isLayoutRtl) {
                i5 = getPaddingLeft();
                drawVerticalDivider(canvas, i5);
            } else {
                left = getWidth() - getPaddingRight();
                i6 = this.mDividerWidth;
            }
            i5 = left - i6;
            drawVerticalDivider(canvas, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersVertical(Canvas canvas) {
        int i5;
        int virtualChildCount = getVirtualChildCount();
        for (int i6 = 0; i6 < virtualChildCount; i6++) {
            View virtualChildAt = getVirtualChildAt(i6);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i6))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                i5 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                i5 = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawHorizontalDivider(Canvas canvas, int i5) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i5, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i5);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawVerticalDivider(Canvas canvas, int i5) {
        this.mDivider.setBounds(i5, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i5, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public int getBaseline() {
        int i5;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i6 = this.mBaselineAlignedChildIndex;
        if (childCount > i6) {
            View childAt = getChildAt(i6);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i7 = this.mBaselineChildTop;
                if (this.mOrientation == 1 && (i5 = this.mGravity & 112) != 48) {
                    if (i5 == 16) {
                        i7 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    } else if (i5 == 80) {
                        i7 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                }
                return i7 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    /* access modifiers changed from: package-private */
    public int getChildrenSkipCount(View view, int i5) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @GravityInt
    public int getGravity() {
        return this.mGravity;
    }

    /* access modifiers changed from: package-private */
    public int getLocationOffset(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    /* access modifiers changed from: package-private */
    public View getVirtualChildAt(int i5) {
        return getChildAt(i5);
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i5) {
        if (i5 == 0) {
            if ((this.mShowDividers & 1) != 0) {
                return true;
            }
            return false;
        } else if (i5 != getChildCount()) {
            if ((this.mShowDividers & 2) != 0) {
                for (int i6 = i5 - 1; i6 >= 0; i6--) {
                    if (getChildAt(i6).getVisibility() != 8) {
                        return true;
                    }
                }
            }
            return false;
        } else if ((this.mShowDividers & 4) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARNING: type inference failed for: r25v2 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layoutHorizontal(int r22, int r23, int r24, int r25) {
        /*
            r21 = this;
            r0 = r21
            boolean r1 = androidx.appcompat.widget.ViewUtils.isLayoutRtl(r0)
            int r6 = r0.getPaddingTop()
            int r2 = r25 - r23
            int r3 = r0.getPaddingBottom()
            int r7 = r2 - r3
            int r2 = r2 - r6
            int r3 = r0.getPaddingBottom()
            int r8 = r2 - r3
            int r9 = r0.getVirtualChildCount()
            int r2 = r0.mGravity
            r3 = 8388615(0x800007, float:1.1754953E-38)
            r3 = r3 & r2
            r10 = r2 & 112(0x70, float:1.57E-43)
            boolean r11 = r0.mBaselineAligned
            int[] r12 = r0.mMaxAscent
            int[] r13 = r0.mMaxDescent
            int r2 = r0.getLayoutDirection()
            int r2 = androidx.core.view.GravityCompat.getAbsoluteGravity(r3, r2)
            r14 = 2
            r15 = 1
            if (r2 == r15) goto L_0x004b
            r3 = 5
            if (r2 == r3) goto L_0x003f
            int r2 = r0.getPaddingLeft()
            goto L_0x0056
        L_0x003f:
            int r2 = r0.getPaddingLeft()
            int r2 = r2 + r24
            int r2 = r2 - r22
            int r3 = r0.mTotalLength
            int r2 = r2 - r3
            goto L_0x0056
        L_0x004b:
            int r2 = r0.getPaddingLeft()
            int r3 = r24 - r22
            int r4 = r0.mTotalLength
            int r3 = r3 - r4
            int r3 = r3 / r14
            int r2 = r2 + r3
        L_0x0056:
            r3 = 0
            if (r1 == 0) goto L_0x0060
            int r1 = r9 + -1
            r16 = r1
            r17 = -1
            goto L_0x0064
        L_0x0060:
            r16 = r3
            r17 = r15
        L_0x0064:
            r1 = r3
        L_0x0065:
            if (r1 >= r9) goto L_0x0140
            int r3 = r17 * r1
            int r3 = r16 + r3
            r5 = r1
            android.view.View r1 = r0.getVirtualChildAt(r3)
            if (r1 != 0) goto L_0x0082
            int r1 = r0.measureNullChild(r3)
            int r2 = r2 + r1
            r1 = r5
            r19 = r6
            r23 = r14
            r25 = r15
            r18 = -1
            goto L_0x0136
        L_0x0082:
            r23 = r14
            int r14 = r1.getVisibility()
            r25 = r15
            r15 = 8
            if (r14 == r15) goto L_0x012e
            int r14 = r1.getMeasuredWidth()
            r15 = r5
            int r5 = r1.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r18 = r1.getLayoutParams()
            r4 = r18
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            r24 = r2
            if (r11 == 0) goto L_0x00af
            int r2 = r4.height
            r18 = r5
            r5 = -1
            if (r2 == r5) goto L_0x00b1
            int r5 = r1.getBaseline()
            goto L_0x00b2
        L_0x00af:
            r18 = r5
        L_0x00b1:
            r5 = -1
        L_0x00b2:
            int r2 = r4.gravity
            if (r2 >= 0) goto L_0x00b7
            r2 = r10
        L_0x00b7:
            r2 = r2 & 112(0x70, float:1.57E-43)
            r19 = r6
            r6 = 16
            if (r2 == r6) goto L_0x00ed
            r6 = 48
            if (r2 == r6) goto L_0x00df
            r6 = 80
            if (r2 == r6) goto L_0x00cb
            r2 = r19
            r6 = -1
            goto L_0x00fa
        L_0x00cb:
            int r2 = r7 - r18
            int r6 = r4.bottomMargin
            int r2 = r2 - r6
            r6 = -1
            if (r5 == r6) goto L_0x00fa
            int r20 = r1.getMeasuredHeight()
            int r20 = r20 - r5
            r5 = r13[r23]
            int r5 = r5 - r20
        L_0x00dd:
            int r2 = r2 - r5
            goto L_0x00fa
        L_0x00df:
            r6 = -1
            int r2 = r4.topMargin
            int r2 = r19 + r2
            if (r5 == r6) goto L_0x00fa
            r20 = r12[r25]
            int r20 = r20 - r5
            int r2 = r2 + r20
            goto L_0x00fa
        L_0x00ed:
            r6 = -1
            int r2 = r8 - r18
            int r2 = r2 / 2
            int r2 = r19 + r2
            int r5 = r4.topMargin
            int r2 = r2 + r5
            int r5 = r4.bottomMargin
            goto L_0x00dd
        L_0x00fa:
            boolean r5 = r0.hasDividerBeforeChildAt(r3)
            if (r5 == 0) goto L_0x0105
            int r5 = r0.mDividerWidth
            int r5 = r24 + r5
            goto L_0x0107
        L_0x0105:
            r5 = r24
        L_0x0107:
            int r6 = r4.leftMargin
            int r6 = r6 + r5
            int r5 = r0.getLocationOffset(r1)
            int r5 = r5 + r6
            r22 = r6
            r6 = r4
            r4 = r14
            r14 = r3
            r3 = r2
            r2 = r5
            r5 = r18
            r18 = -1
            r0.setChildFrame(r1, r2, r3, r4, r5)
            int r2 = r6.rightMargin
            int r2 = r2 + r4
            int r3 = r0.getNextLocationOffset(r1)
            int r2 = r2 + r3
            int r6 = r22 + r2
            int r1 = r0.getChildrenSkipCount(r1, r14)
            int r1 = r1 + r15
            r2 = r6
            goto L_0x0136
        L_0x012e:
            r24 = r2
            r15 = r5
            r19 = r6
            r18 = -1
            r1 = r15
        L_0x0136:
            int r1 = r1 + 1
            r14 = r23
            r15 = r25
            r6 = r19
            goto L_0x0065
        L_0x0140:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.layoutHorizontal(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void layoutVertical(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int paddingLeft = getPaddingLeft();
        int i13 = i7 - i5;
        int paddingRight = i13 - getPaddingRight();
        int paddingRight2 = (i13 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i14 = this.mGravity;
        int i15 = i14 & 112;
        int i16 = i14 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i15 == 16) {
            i9 = getPaddingTop() + (((i8 - i6) - this.mTotalLength) / 2);
        } else if (i15 != 80) {
            i9 = getPaddingTop();
        } else {
            i9 = ((getPaddingTop() + i8) - i6) - this.mTotalLength;
        }
        int i17 = 0;
        while (i17 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i17);
            if (virtualChildAt == null) {
                i9 += measureNullChild(i17);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i18 = layoutParams.gravity;
                if (i18 < 0) {
                    i18 = i16;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i18, getLayoutDirection()) & 7;
                if (absoluteGravity == 1) {
                    i10 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i11 = layoutParams.rightMargin;
                    i12 = i10 - i11;
                } else if (absoluteGravity != 5) {
                    i12 = layoutParams.leftMargin + paddingLeft;
                } else {
                    i10 = paddingRight - measuredWidth;
                    i11 = layoutParams.rightMargin;
                    i12 = i10 - i11;
                }
                int i19 = i12;
                if (hasDividerBeforeChildAt(i17)) {
                    i9 += this.mDividerHeight;
                }
                int i20 = i9 + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i19, i20 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i9 = i20 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                i17 += getChildrenSkipCount(virtualChildAt, i17);
                i17++;
            }
            i17++;
        }
    }

    /* access modifiers changed from: package-private */
    public void measureChildBeforeLayout(View view, int i5, int i6, int i7, int i8, int i9) {
        measureChildWithMargins(view, i6, i7, i8, i9);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0461  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void measureHorizontal(int r39, int r40) {
        /*
            r38 = this;
            r0 = r38
            r7 = 0
            r0.mTotalLength = r7
            int r8 = r0.getVirtualChildCount()
            int r9 = android.view.View.MeasureSpec.getMode(r39)
            int r10 = android.view.View.MeasureSpec.getMode(r40)
            int[] r1 = r0.mMaxAscent
            r11 = 4
            if (r1 == 0) goto L_0x001a
            int[] r1 = r0.mMaxDescent
            if (r1 != 0) goto L_0x0022
        L_0x001a:
            int[] r1 = new int[r11]
            r0.mMaxAscent = r1
            int[] r1 = new int[r11]
            r0.mMaxDescent = r1
        L_0x0022:
            int[] r12 = r0.mMaxAscent
            int[] r13 = r0.mMaxDescent
            r14 = 3
            r15 = -1
            r12[r14] = r15
            r16 = 2
            r12[r16] = r15
            r17 = 1
            r12[r17] = r15
            r12[r7] = r15
            r13[r14] = r15
            r13[r16] = r15
            r13[r17] = r15
            r13[r7] = r15
            boolean r1 = r0.mBaselineAligned
            boolean r2 = r0.mUseLargestChild
            r3 = 1073741824(0x40000000, float:2.0)
            if (r9 != r3) goto L_0x0047
            r18 = r17
            goto L_0x0049
        L_0x0047:
            r18 = r7
        L_0x0049:
            r19 = 0
            r4 = r2
            r2 = r7
            r6 = r2
            r15 = r6
            r22 = r15
            r24 = r22
            r26 = r24
            r20 = r11
            r21 = r14
            r25 = r17
            r5 = r19
            r11 = r26
            r14 = r11
        L_0x0060:
            r27 = r6
            r6 = 8
            if (r2 >= r8) goto L_0x0205
            r30 = r1
            android.view.View r1 = r0.getVirtualChildAt(r2)
            if (r1 != 0) goto L_0x0089
            int r1 = r0.mTotalLength
            int r6 = r0.measureNullChild(r2)
            int r1 = r1 + r6
            r0.mTotalLength = r1
        L_0x0077:
            r3 = r39
            r1 = r40
            r35 = r8
            r33 = r9
            r34 = r12
            r28 = r13
            r6 = r27
            r27 = r4
            goto L_0x01f2
        L_0x0089:
            int r7 = r1.getVisibility()
            if (r7 != r6) goto L_0x0095
            int r1 = r0.getChildrenSkipCount(r1, r2)
            int r2 = r2 + r1
            goto L_0x0077
        L_0x0095:
            boolean r6 = r0.hasDividerBeforeChildAt(r2)
            if (r6 == 0) goto L_0x00a2
            int r6 = r0.mTotalLength
            int r7 = r0.mDividerWidth
            int r6 = r6 + r7
            r0.mTotalLength = r6
        L_0x00a2:
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            r7 = r6
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r7 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r7
            float r6 = r7.weight
            float r32 = r5 + r6
            if (r9 != r3) goto L_0x0100
            int r5 = r7.width
            if (r5 != 0) goto L_0x0100
            int r5 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r5 <= 0) goto L_0x0100
            if (r18 == 0) goto L_0x00c4
            int r5 = r0.mTotalLength
            int r6 = r7.leftMargin
            int r3 = r7.rightMargin
            int r6 = r6 + r3
            int r5 = r5 + r6
            r0.mTotalLength = r5
            goto L_0x00d2
        L_0x00c4:
            int r3 = r0.mTotalLength
            int r5 = r7.leftMargin
            int r5 = r5 + r3
            int r6 = r7.rightMargin
            int r5 = r5 + r6
            int r3 = java.lang.Math.max(r3, r5)
            r0.mTotalLength = r3
        L_0x00d2:
            if (r30 == 0) goto L_0x00e7
            r3 = 0
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r3)
            r1.measure(r5, r5)
            r3 = r39
            r35 = r8
            r33 = r9
            r34 = r12
            r28 = r13
            goto L_0x00f3
        L_0x00e7:
            r3 = r39
            r35 = r8
            r33 = r9
            r34 = r12
            r28 = r13
            r22 = r17
        L_0x00f3:
            r12 = r27
            r8 = 1073741824(0x40000000, float:2.0)
            r29 = -2
            r27 = r4
            r4 = r1
            r1 = r40
            goto L_0x0174
        L_0x0100:
            int r3 = r7.width
            if (r3 != 0) goto L_0x010d
            int r3 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x010d
            r3 = -2
            r7.width = r3
            r5 = 0
            goto L_0x0110
        L_0x010d:
            r3 = -2
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0110:
            int r6 = (r32 > r19 ? 1 : (r32 == r19 ? 0 : -1))
            if (r6 != 0) goto L_0x011c
            int r6 = r0.mTotalLength
            r37 = r6
            r6 = r4
            r4 = r37
            goto L_0x011e
        L_0x011c:
            r6 = r4
            r4 = 0
        L_0x011e:
            r28 = 0
            r29 = r3
            r35 = r8
            r33 = r9
            r34 = r12
            r12 = r27
            r8 = 1073741824(0x40000000, float:2.0)
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r39
            r27 = r6
            r6 = r28
            r28 = r13
            r13 = r5
            r5 = r40
            r0.measureChildBeforeLayout(r1, r2, r3, r4, r5, r6)
            r4 = r1
            r1 = r5
            if (r13 == r9) goto L_0x0142
            r7.width = r13
        L_0x0142:
            int r5 = r4.getMeasuredWidth()
            if (r18 == 0) goto L_0x0159
            int r6 = r0.mTotalLength
            int r9 = r7.leftMargin
            int r9 = r9 + r5
            int r13 = r7.rightMargin
            int r9 = r9 + r13
            int r13 = r0.getNextLocationOffset(r4)
            int r9 = r9 + r13
            int r6 = r6 + r9
            r0.mTotalLength = r6
            goto L_0x016e
        L_0x0159:
            int r6 = r0.mTotalLength
            int r9 = r6 + r5
            int r13 = r7.leftMargin
            int r9 = r9 + r13
            int r13 = r7.rightMargin
            int r9 = r9 + r13
            int r13 = r0.getNextLocationOffset(r4)
            int r9 = r9 + r13
            int r6 = java.lang.Math.max(r6, r9)
            r0.mTotalLength = r6
        L_0x016e:
            if (r27 == 0) goto L_0x0174
            int r15 = java.lang.Math.max(r5, r15)
        L_0x0174:
            if (r10 == r8) goto L_0x0180
            int r5 = r7.height
            r6 = -1
            if (r5 != r6) goto L_0x0180
            r5 = r17
            r26 = r5
            goto L_0x0181
        L_0x0180:
            r5 = 0
        L_0x0181:
            int r6 = r7.topMargin
            int r9 = r7.bottomMargin
            int r6 = r6 + r9
            int r9 = r4.getMeasuredHeight()
            int r9 = r9 + r6
            int r13 = r4.getMeasuredState()
            r8 = r24
            int r24 = android.view.View.combineMeasuredStates(r8, r13)
            if (r30 == 0) goto L_0x01c1
            int r8 = r4.getBaseline()
            r13 = -1
            if (r8 == r13) goto L_0x01c1
            int r13 = r7.gravity
            if (r13 >= 0) goto L_0x01a4
            int r13 = r0.mGravity
        L_0x01a4:
            r13 = r13 & 112(0x70, float:1.57E-43)
            int r13 = r13 >> 4
            r13 = r13 & -2
            int r13 = r13 >> 1
            r36 = r5
            r5 = r34[r13]
            int r5 = java.lang.Math.max(r5, r8)
            r34[r13] = r5
            r5 = r28[r13]
            int r8 = r9 - r8
            int r5 = java.lang.Math.max(r5, r8)
            r28[r13] = r5
            goto L_0x01c3
        L_0x01c1:
            r36 = r5
        L_0x01c3:
            int r5 = java.lang.Math.max(r12, r9)
            if (r25 == 0) goto L_0x01d1
            int r8 = r7.height
            r13 = -1
            if (r8 != r13) goto L_0x01d1
            r25 = r17
            goto L_0x01d3
        L_0x01d1:
            r25 = 0
        L_0x01d3:
            float r7 = r7.weight
            int r7 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r7 <= 0) goto L_0x01e2
            if (r36 == 0) goto L_0x01dc
            goto L_0x01dd
        L_0x01dc:
            r6 = r9
        L_0x01dd:
            int r14 = java.lang.Math.max(r14, r6)
            goto L_0x01ea
        L_0x01e2:
            if (r36 == 0) goto L_0x01e5
            goto L_0x01e6
        L_0x01e5:
            r6 = r9
        L_0x01e6:
            int r11 = java.lang.Math.max(r11, r6)
        L_0x01ea:
            int r4 = r0.getChildrenSkipCount(r4, r2)
            int r2 = r2 + r4
            r6 = r5
            r5 = r32
        L_0x01f2:
            int r2 = r2 + 1
            r4 = r27
            r13 = r28
            r1 = r30
            r9 = r33
            r12 = r34
            r8 = r35
            r3 = 1073741824(0x40000000, float:2.0)
            r7 = 0
            goto L_0x0060
        L_0x0205:
            r3 = r39
            r30 = r1
            r35 = r8
            r33 = r9
            r34 = r12
            r28 = r13
            r8 = r24
            r12 = r27
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r29 = -2
            r1 = r40
            r27 = r4
            int r2 = r0.mTotalLength
            if (r2 <= 0) goto L_0x0231
            r2 = r35
            boolean r4 = r0.hasDividerBeforeChildAt(r2)
            if (r4 == 0) goto L_0x0233
            int r4 = r0.mTotalLength
            int r7 = r0.mDividerWidth
            int r4 = r4 + r7
            r0.mTotalLength = r4
            goto L_0x0233
        L_0x0231:
            r2 = r35
        L_0x0233:
            r4 = r34[r17]
            r13 = -1
            if (r4 != r13) goto L_0x0249
            r31 = 0
            r7 = r34[r31]
            if (r7 != r13) goto L_0x0249
            r7 = r34[r16]
            if (r7 != r13) goto L_0x0249
            r7 = r34[r21]
            if (r7 == r13) goto L_0x0247
            goto L_0x0249
        L_0x0247:
            r6 = r12
            goto L_0x0276
        L_0x0249:
            r7 = r34[r21]
            r31 = 0
            r13 = r34[r31]
            r6 = r34[r16]
            int r4 = java.lang.Math.max(r4, r6)
            int r4 = java.lang.Math.max(r13, r4)
            int r4 = java.lang.Math.max(r7, r4)
            r6 = r28[r21]
            r7 = r28[r31]
            r13 = r28[r17]
            r9 = r28[r16]
            int r9 = java.lang.Math.max(r13, r9)
            int r7 = java.lang.Math.max(r7, r9)
            int r6 = java.lang.Math.max(r6, r7)
            int r4 = r4 + r6
            int r6 = java.lang.Math.max(r12, r4)
        L_0x0276:
            if (r27 == 0) goto L_0x02ea
            r4 = r33
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 == r9) goto L_0x0280
            if (r4 != 0) goto L_0x0282
        L_0x0280:
            r7 = 0
            goto L_0x0288
        L_0x0282:
            r32 = r5
        L_0x0284:
            r33 = r6
            goto L_0x02ef
        L_0x0288:
            r0.mTotalLength = r7
            r7 = 0
        L_0x028b:
            if (r7 >= r2) goto L_0x0282
            android.view.View r9 = r0.getVirtualChildAt(r7)
            if (r9 != 0) goto L_0x029d
            int r9 = r0.mTotalLength
            int r12 = r0.measureNullChild(r7)
            int r9 = r9 + r12
            r0.mTotalLength = r9
            goto L_0x02aa
        L_0x029d:
            int r12 = r9.getVisibility()
            r13 = 8
            if (r12 != r13) goto L_0x02af
            int r9 = r0.getChildrenSkipCount(r9, r7)
            int r7 = r7 + r9
        L_0x02aa:
            r32 = r5
        L_0x02ac:
            r33 = r6
            goto L_0x02e3
        L_0x02af:
            android.view.ViewGroup$LayoutParams r12 = r9.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r12 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r12
            if (r18 == 0) goto L_0x02ca
            int r13 = r0.mTotalLength
            r32 = r5
            int r5 = r12.leftMargin
            int r5 = r5 + r15
            int r12 = r12.rightMargin
            int r5 = r5 + r12
            int r9 = r0.getNextLocationOffset(r9)
            int r5 = r5 + r9
            int r13 = r13 + r5
            r0.mTotalLength = r13
            goto L_0x02ac
        L_0x02ca:
            r32 = r5
            int r5 = r0.mTotalLength
            int r13 = r5 + r15
            r33 = r6
            int r6 = r12.leftMargin
            int r13 = r13 + r6
            int r6 = r12.rightMargin
            int r13 = r13 + r6
            int r6 = r0.getNextLocationOffset(r9)
            int r13 = r13 + r6
            int r5 = java.lang.Math.max(r5, r13)
            r0.mTotalLength = r5
        L_0x02e3:
            int r7 = r7 + 1
            r5 = r32
            r6 = r33
            goto L_0x028b
        L_0x02ea:
            r32 = r5
            r4 = r33
            goto L_0x0284
        L_0x02ef:
            int r5 = r0.mTotalLength
            int r6 = r0.getPaddingLeft()
            int r7 = r0.getPaddingRight()
            int r6 = r6 + r7
            int r5 = r5 + r6
            r0.mTotalLength = r5
            int r6 = r0.getSuggestedMinimumWidth()
            int r5 = java.lang.Math.max(r5, r6)
            r7 = 0
            int r5 = android.view.View.resolveSizeAndState(r5, r3, r7)
            r6 = 16777215(0xffffff, float:2.3509886E-38)
            r6 = r6 & r5
            int r7 = r0.mTotalLength
            int r6 = r6 - r7
            if (r22 != 0) goto L_0x035e
            if (r6 == 0) goto L_0x031a
            int r9 = (r32 > r19 ? 1 : (r32 == r19 ? 0 : -1))
            if (r9 <= 0) goto L_0x031a
            goto L_0x035e
        L_0x031a:
            int r6 = java.lang.Math.max(r11, r14)
            if (r27 == 0) goto L_0x0356
            r9 = 1073741824(0x40000000, float:2.0)
            if (r4 == r9) goto L_0x0356
            r4 = 0
        L_0x0325:
            if (r4 >= r2) goto L_0x0356
            android.view.View r9 = r0.getVirtualChildAt(r4)
            if (r9 == 0) goto L_0x0353
            int r11 = r9.getVisibility()
            r13 = 8
            if (r11 != r13) goto L_0x0336
            goto L_0x0353
        L_0x0336:
            android.view.ViewGroup$LayoutParams r11 = r9.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            float r11 = r11.weight
            int r11 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r11 <= 0) goto L_0x0353
            r11 = 1073741824(0x40000000, float:2.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r11)
            int r13 = r9.getMeasuredHeight()
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r11)
            r9.measure(r12, r13)
        L_0x0353:
            int r4 = r4 + 1
            goto L_0x0325
        L_0x0356:
            r27 = r5
            r24 = r8
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x04e0
        L_0x035e:
            float r9 = r0.mWeightSum
            int r12 = (r9 > r19 ? 1 : (r9 == r19 ? 0 : -1))
            if (r12 <= 0) goto L_0x0366
            r32 = r9
        L_0x0366:
            r23 = -1
            r34[r21] = r23
            r34[r16] = r23
            r34[r17] = r23
            r9 = 0
            r34[r9] = r23
            r28[r21] = r23
            r28[r16] = r23
            r28[r17] = r23
            r28[r9] = r23
            r0.mTotalLength = r9
            r9 = r8
            r8 = -1
            r12 = 0
        L_0x037e:
            if (r12 >= r2) goto L_0x0485
            android.view.View r13 = r0.getVirtualChildAt(r12)
            if (r13 == 0) goto L_0x038e
            int r14 = r13.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x0394
        L_0x038e:
            r27 = r5
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x047f
        L_0x0394:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r14 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r14
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            float r7 = r14.weight
            int r24 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r24 <= 0) goto L_0x03f4
            float r15 = (float) r6
            float r15 = r15 * r7
            float r15 = r15 / r32
            int r15 = (int) r15
            float r32 = r32 - r7
            int r6 = r6 - r15
            int r7 = r0.getPaddingTop()
            int r27 = r0.getPaddingBottom()
            int r7 = r7 + r27
            r27 = r5
            int r5 = r14.topMargin
            int r7 = r7 + r5
            int r5 = r14.bottomMargin
            int r7 = r7 + r5
            int r5 = r14.height
            int r5 = android.view.ViewGroup.getChildMeasureSpec(r1, r7, r5)
            int r7 = r14.width
            if (r7 != 0) goto L_0x03d7
            r7 = 1073741824(0x40000000, float:2.0)
            if (r4 == r7) goto L_0x03cb
            goto L_0x03d9
        L_0x03cb:
            if (r15 <= 0) goto L_0x03ce
            goto L_0x03cf
        L_0x03ce:
            r15 = 0
        L_0x03cf:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r7)
            r13.measure(r15, r5)
            goto L_0x03e9
        L_0x03d7:
            r7 = 1073741824(0x40000000, float:2.0)
        L_0x03d9:
            int r33 = r13.getMeasuredWidth()
            int r15 = r33 + r15
            if (r15 >= 0) goto L_0x03e2
            r15 = 0
        L_0x03e2:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r7)
            r13.measure(r15, r5)
        L_0x03e9:
            int r5 = r13.getMeasuredState()
            r5 = r5 & r22
            int r9 = android.view.View.combineMeasuredStates(r9, r5)
            goto L_0x03f6
        L_0x03f4:
            r27 = r5
        L_0x03f6:
            if (r18 == 0) goto L_0x040f
            int r5 = r0.mTotalLength
            int r7 = r13.getMeasuredWidth()
            int r15 = r14.leftMargin
            int r7 = r7 + r15
            int r15 = r14.rightMargin
            int r7 = r7 + r15
            int r15 = r0.getNextLocationOffset(r13)
            int r7 = r7 + r15
            int r5 = r5 + r7
            r0.mTotalLength = r5
        L_0x040c:
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x0428
        L_0x040f:
            int r5 = r0.mTotalLength
            int r7 = r13.getMeasuredWidth()
            int r7 = r7 + r5
            int r15 = r14.leftMargin
            int r7 = r7 + r15
            int r15 = r14.rightMargin
            int r7 = r7 + r15
            int r15 = r0.getNextLocationOffset(r13)
            int r7 = r7 + r15
            int r5 = java.lang.Math.max(r5, r7)
            r0.mTotalLength = r5
            goto L_0x040c
        L_0x0428:
            if (r10 == r7) goto L_0x0432
            int r5 = r14.height
            r7 = -1
            if (r5 != r7) goto L_0x0432
            r5 = r17
            goto L_0x0433
        L_0x0432:
            r5 = 0
        L_0x0433:
            int r7 = r14.topMargin
            int r15 = r14.bottomMargin
            int r7 = r7 + r15
            int r15 = r13.getMeasuredHeight()
            int r15 = r15 + r7
            int r8 = java.lang.Math.max(r8, r15)
            if (r5 == 0) goto L_0x0444
            goto L_0x0445
        L_0x0444:
            r7 = r15
        L_0x0445:
            int r5 = java.lang.Math.max(r11, r7)
            if (r25 == 0) goto L_0x0453
            int r7 = r14.height
            r11 = -1
            if (r7 != r11) goto L_0x0454
            r7 = r17
            goto L_0x0455
        L_0x0453:
            r11 = -1
        L_0x0454:
            r7 = 0
        L_0x0455:
            if (r30 == 0) goto L_0x047c
            int r13 = r13.getBaseline()
            if (r13 == r11) goto L_0x047c
            int r11 = r14.gravity
            if (r11 >= 0) goto L_0x0463
            int r11 = r0.mGravity
        L_0x0463:
            r11 = r11 & 112(0x70, float:1.57E-43)
            int r11 = r11 >> 4
            r11 = r11 & -2
            int r11 = r11 >> 1
            r14 = r34[r11]
            int r14 = java.lang.Math.max(r14, r13)
            r34[r11] = r14
            r14 = r28[r11]
            int r15 = r15 - r13
            int r13 = java.lang.Math.max(r14, r15)
            r28[r11] = r13
        L_0x047c:
            r11 = r5
            r25 = r7
        L_0x047f:
            int r12 = r12 + 1
            r5 = r27
            goto L_0x037e
        L_0x0485:
            r27 = r5
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            int r4 = r0.mTotalLength
            int r5 = r0.getPaddingLeft()
            int r6 = r0.getPaddingRight()
            int r5 = r5 + r6
            int r4 = r4 + r5
            r0.mTotalLength = r4
            r4 = r34[r17]
            r13 = -1
            if (r4 != r13) goto L_0x04ad
            r31 = 0
            r5 = r34[r31]
            if (r5 != r13) goto L_0x04ad
            r5 = r34[r16]
            if (r5 != r13) goto L_0x04ad
            r5 = r34[r21]
            if (r5 == r13) goto L_0x04ab
            goto L_0x04ad
        L_0x04ab:
            r6 = r8
            goto L_0x04db
        L_0x04ad:
            r5 = r34[r21]
            r31 = 0
            r6 = r34[r31]
            r7 = r34[r16]
            int r4 = java.lang.Math.max(r4, r7)
            int r4 = java.lang.Math.max(r6, r4)
            int r4 = java.lang.Math.max(r5, r4)
            r5 = r28[r21]
            r6 = r28[r31]
            r7 = r28[r17]
            r12 = r28[r16]
            int r7 = java.lang.Math.max(r7, r12)
            int r6 = java.lang.Math.max(r6, r7)
            int r5 = java.lang.Math.max(r5, r6)
            int r4 = r4 + r5
            int r4 = java.lang.Math.max(r8, r4)
            r6 = r4
        L_0x04db:
            r33 = r6
            r24 = r9
            r6 = r11
        L_0x04e0:
            if (r25 != 0) goto L_0x04e7
            r7 = 1073741824(0x40000000, float:2.0)
            if (r10 == r7) goto L_0x04e7
            goto L_0x04e9
        L_0x04e7:
            r6 = r33
        L_0x04e9:
            int r4 = r0.getPaddingTop()
            int r5 = r0.getPaddingBottom()
            int r4 = r4 + r5
            int r6 = r6 + r4
            int r4 = r0.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r6, r4)
            r5 = r24 & r22
            r5 = r27 | r5
            int r6 = r24 << 16
            int r1 = android.view.View.resolveSizeAndState(r4, r1, r6)
            r0.setMeasuredDimension(r5, r1)
            if (r26 == 0) goto L_0x050d
            r0.forceUniformHeight(r2, r3)
        L_0x050d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.measureHorizontal(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int measureNullChild(int i5) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0160  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void measureVertical(int r28, int r29) {
        /*
            r27 = this;
            r0 = r27
            r7 = 0
            r0.mTotalLength = r7
            int r8 = r0.getVirtualChildCount()
            int r9 = android.view.View.MeasureSpec.getMode(r28)
            int r10 = android.view.View.MeasureSpec.getMode(r29)
            int r11 = r0.mBaselineAlignedChildIndex
            boolean r12 = r0.mUseLargestChild
            r2 = r7
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r15 = r6
            r16 = r15
            r18 = r16
            r1 = 0
            r17 = 1
            r19 = 1
        L_0x0024:
            r20 = 0
            r7 = 8
            r14 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r8) goto L_0x0180
            r21 = r1
            android.view.View r1 = r0.getVirtualChildAt(r2)
            if (r1 != 0) goto L_0x004d
            int r1 = r0.mTotalLength
            int r7 = r0.measureNullChild(r2)
            int r1 = r1 + r7
            r0.mTotalLength = r1
        L_0x003d:
            r14 = r3
            r26 = r8
            r25 = r10
            r24 = r12
            r1 = r21
            r3 = r28
            r10 = r5
            r5 = r29
            goto L_0x0173
        L_0x004d:
            int r13 = r1.getVisibility()
            if (r13 != r7) goto L_0x0059
            int r1 = r0.getChildrenSkipCount(r1, r2)
            int r2 = r2 + r1
            goto L_0x003d
        L_0x0059:
            boolean r7 = r0.hasDividerBeforeChildAt(r2)
            if (r7 == 0) goto L_0x0066
            int r7 = r0.mTotalLength
            int r13 = r0.mDividerHeight
            int r7 = r7 + r13
            r0.mTotalLength = r7
        L_0x0066:
            android.view.ViewGroup$LayoutParams r7 = r1.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r7 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r7
            float r13 = r7.weight
            float r21 = r21 + r13
            if (r10 != r14) goto L_0x009d
            int r14 = r7.height
            if (r14 != 0) goto L_0x009d
            int r14 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            if (r14 <= 0) goto L_0x009d
            int r13 = r0.mTotalLength
            int r14 = r7.topMargin
            int r14 = r14 + r13
            r24 = r1
            int r1 = r7.bottomMargin
            int r14 = r14 + r1
            int r1 = java.lang.Math.max(r13, r14)
            r0.mTotalLength = r1
            r14 = r3
            r26 = r8
            r25 = r10
            r16 = r19
            r1 = r24
            r3 = r28
            r10 = r5
            r8 = r6
            r24 = r12
            r5 = r29
            goto L_0x00fe
        L_0x009d:
            r24 = r1
            int r1 = r7.height
            if (r1 != 0) goto L_0x00ac
            int r1 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ac
            r1 = -2
            r7.height = r1
            r13 = 0
            goto L_0x00ae
        L_0x00ac:
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00ae:
            int r1 = (r21 > r20 ? 1 : (r21 == r20 ? 0 : -1))
            if (r1 != 0) goto L_0x00b9
            int r1 = r0.mTotalLength
            r14 = r6
            r6 = r1
            r1 = r14
        L_0x00b7:
            r14 = r4
            goto L_0x00bc
        L_0x00b9:
            r1 = r6
            r6 = 0
            goto L_0x00b7
        L_0x00bc:
            r4 = 0
            r26 = r8
            r25 = r10
            r8 = r1
            r10 = r5
            r1 = r24
            r5 = r29
            r24 = r12
            r12 = r14
            r14 = r3
            r3 = r28
            r0.measureChildBeforeLayout(r1, r2, r3, r4, r5, r6)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r13 == r4) goto L_0x00d6
            r7.height = r13
        L_0x00d6:
            int r4 = r1.getMeasuredHeight()
            int r6 = r0.mTotalLength
            int r13 = r6 + r4
            r22 = r13
            int r13 = r7.topMargin
            int r13 = r22 + r13
            r22 = r13
            int r13 = r7.bottomMargin
            int r13 = r22 + r13
            int r22 = r0.getNextLocationOffset(r1)
            int r13 = r13 + r22
            int r6 = java.lang.Math.max(r6, r13)
            r0.mTotalLength = r6
            if (r24 == 0) goto L_0x00fd
            int r4 = java.lang.Math.max(r4, r12)
            goto L_0x00fe
        L_0x00fd:
            r4 = r12
        L_0x00fe:
            if (r11 < 0) goto L_0x0108
            int r6 = r2 + 1
            if (r11 != r6) goto L_0x0108
            int r6 = r0.mTotalLength
            r0.mBaselineChildTop = r6
        L_0x0108:
            if (r2 >= r11) goto L_0x0110
            float r6 = r7.weight
            int r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r6 > 0) goto L_0x0113
        L_0x0110:
            r6 = 1073741824(0x40000000, float:2.0)
            goto L_0x011b
        L_0x0113:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r1.<init>(r2)
            throw r1
        L_0x011b:
            if (r9 == r6) goto L_0x0127
            int r6 = r7.width
            r12 = -1
            if (r6 != r12) goto L_0x0127
            r6 = r19
            r18 = r6
            goto L_0x0128
        L_0x0127:
            r6 = 0
        L_0x0128:
            int r12 = r7.leftMargin
            int r13 = r7.rightMargin
            int r12 = r12 + r13
            int r13 = r1.getMeasuredWidth()
            int r13 = r13 + r12
            int r10 = java.lang.Math.max(r10, r13)
            r22 = r4
            int r4 = r1.getMeasuredState()
            int r4 = android.view.View.combineMeasuredStates(r8, r4)
            if (r17 == 0) goto L_0x014c
            int r8 = r7.width
            r23 = r4
            r4 = -1
            if (r8 != r4) goto L_0x014e
            r17 = r19
            goto L_0x0150
        L_0x014c:
            r23 = r4
        L_0x014e:
            r17 = 0
        L_0x0150:
            float r4 = r7.weight
            int r4 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r4 <= 0) goto L_0x0160
            if (r6 == 0) goto L_0x0159
            goto L_0x015a
        L_0x0159:
            r12 = r13
        L_0x015a:
            int r4 = java.lang.Math.max(r14, r12)
            r14 = r4
            goto L_0x0168
        L_0x0160:
            if (r6 == 0) goto L_0x0163
            goto L_0x0164
        L_0x0163:
            r12 = r13
        L_0x0164:
            int r15 = java.lang.Math.max(r15, r12)
        L_0x0168:
            int r1 = r0.getChildrenSkipCount(r1, r2)
            int r2 = r2 + r1
            r1 = r21
            r4 = r22
            r6 = r23
        L_0x0173:
            int r2 = r2 + 1
            r5 = r10
            r3 = r14
            r12 = r24
            r10 = r25
            r8 = r26
            r7 = 0
            goto L_0x0024
        L_0x0180:
            r21 = r1
            r14 = r3
            r26 = r8
            r25 = r10
            r24 = r12
            r3 = r28
            r12 = r4
            r10 = r5
            r8 = r6
            r5 = r29
            int r1 = r0.mTotalLength
            if (r1 <= 0) goto L_0x01a4
            r1 = r26
            boolean r2 = r0.hasDividerBeforeChildAt(r1)
            if (r2 == 0) goto L_0x01a6
            int r2 = r0.mTotalLength
            int r4 = r0.mDividerHeight
            int r2 = r2 + r4
            r0.mTotalLength = r2
            goto L_0x01a6
        L_0x01a4:
            r1 = r26
        L_0x01a6:
            r2 = r25
            if (r24 == 0) goto L_0x01f5
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == r4) goto L_0x01b0
            if (r2 != 0) goto L_0x01f5
        L_0x01b0:
            r4 = 0
            r0.mTotalLength = r4
            r4 = 0
        L_0x01b4:
            if (r4 >= r1) goto L_0x01f5
            android.view.View r6 = r0.getVirtualChildAt(r4)
            if (r6 != 0) goto L_0x01c6
            int r6 = r0.mTotalLength
            int r11 = r0.measureNullChild(r4)
            int r6 = r6 + r11
            r0.mTotalLength = r6
            goto L_0x01f0
        L_0x01c6:
            int r11 = r6.getVisibility()
            if (r11 != r7) goto L_0x01d2
            int r6 = r0.getChildrenSkipCount(r6, r4)
            int r4 = r4 + r6
            goto L_0x01f0
        L_0x01d2:
            android.view.ViewGroup$LayoutParams r11 = r6.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            int r13 = r0.mTotalLength
            int r22 = r13 + r12
            int r7 = r11.topMargin
            int r22 = r22 + r7
            int r7 = r11.bottomMargin
            int r22 = r22 + r7
            int r6 = r0.getNextLocationOffset(r6)
            int r6 = r22 + r6
            int r6 = java.lang.Math.max(r13, r6)
            r0.mTotalLength = r6
        L_0x01f0:
            int r4 = r4 + 1
            r7 = 8
            goto L_0x01b4
        L_0x01f5:
            int r4 = r0.mTotalLength
            int r6 = r0.getPaddingTop()
            int r7 = r0.getPaddingBottom()
            int r6 = r6 + r7
            int r4 = r4 + r6
            r0.mTotalLength = r4
            int r6 = r0.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r4, r6)
            r6 = 0
            int r4 = android.view.View.resolveSizeAndState(r4, r5, r6)
            r6 = 16777215(0xffffff, float:2.3509886E-38)
            r6 = r6 & r4
            int r7 = r0.mTotalLength
            int r6 = r6 - r7
            if (r16 != 0) goto L_0x025c
            if (r6 == 0) goto L_0x0220
            int r7 = (r21 > r20 ? 1 : (r21 == r20 ? 0 : -1))
            if (r7 <= 0) goto L_0x0220
            goto L_0x025c
        L_0x0220:
            int r6 = java.lang.Math.max(r15, r14)
            if (r24 == 0) goto L_0x0349
            r7 = 1073741824(0x40000000, float:2.0)
            if (r2 == r7) goto L_0x0349
            r7 = 0
        L_0x022b:
            if (r7 >= r1) goto L_0x0349
            android.view.View r2 = r0.getVirtualChildAt(r7)
            if (r2 == 0) goto L_0x0259
            int r11 = r2.getVisibility()
            r13 = 8
            if (r11 != r13) goto L_0x023c
            goto L_0x0259
        L_0x023c:
            android.view.ViewGroup$LayoutParams r11 = r2.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            float r11 = r11.weight
            int r11 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r11 <= 0) goto L_0x0259
            int r11 = r2.getMeasuredWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r13)
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r13)
            r2.measure(r11, r14)
        L_0x0259:
            int r7 = r7 + 1
            goto L_0x022b
        L_0x025c:
            float r7 = r0.mWeightSum
            int r11 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r11 <= 0) goto L_0x0264
        L_0x0262:
            r11 = 0
            goto L_0x0267
        L_0x0264:
            r7 = r21
            goto L_0x0262
        L_0x0267:
            r0.mTotalLength = r11
            r12 = r7
            r7 = r6
            r6 = r11
        L_0x026c:
            if (r6 >= r1) goto L_0x033a
            android.view.View r13 = r0.getVirtualChildAt(r6)
            int r14 = r13.getVisibility()
            r11 = 8
            if (r14 != r11) goto L_0x0280
            r22 = r2
            r16 = r6
            goto L_0x0333
        L_0x0280:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r14 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r14
            float r11 = r14.weight
            int r16 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r16 <= 0) goto L_0x02e5
            r16 = r6
            float r6 = (float) r7
            float r6 = r6 * r11
            float r6 = r6 / r12
            int r6 = (int) r6
            float r12 = r12 - r11
            int r7 = r7 - r6
            int r11 = r0.getPaddingLeft()
            int r21 = r0.getPaddingRight()
            int r11 = r11 + r21
            r21 = r6
            int r6 = r14.leftMargin
            int r11 = r11 + r6
            int r6 = r14.rightMargin
            int r11 = r11 + r6
            int r6 = r14.width
            int r6 = android.view.ViewGroup.getChildMeasureSpec(r3, r11, r6)
            int r11 = r14.height
            if (r11 != 0) goto L_0x02c7
            r11 = 1073741824(0x40000000, float:2.0)
            if (r2 == r11) goto L_0x02b7
        L_0x02b4:
            r22 = r2
            goto L_0x02ca
        L_0x02b7:
            r22 = r2
            if (r21 <= 0) goto L_0x02be
            r2 = r21
            goto L_0x02bf
        L_0x02be:
            r2 = 0
        L_0x02bf:
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r11)
            r13.measure(r6, r2)
            goto L_0x02da
        L_0x02c7:
            r11 = 1073741824(0x40000000, float:2.0)
            goto L_0x02b4
        L_0x02ca:
            int r2 = r13.getMeasuredHeight()
            int r2 = r2 + r21
            if (r2 >= 0) goto L_0x02d3
            r2 = 0
        L_0x02d3:
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r11)
            r13.measure(r6, r2)
        L_0x02da:
            int r2 = r13.getMeasuredState()
            r2 = r2 & -256(0xffffffffffffff00, float:NaN)
            int r8 = android.view.View.combineMeasuredStates(r8, r2)
            goto L_0x02e9
        L_0x02e5:
            r22 = r2
            r16 = r6
        L_0x02e9:
            int r2 = r14.leftMargin
            int r6 = r14.rightMargin
            int r2 = r2 + r6
            int r6 = r13.getMeasuredWidth()
            int r6 = r6 + r2
            int r10 = java.lang.Math.max(r10, r6)
            r11 = 1073741824(0x40000000, float:2.0)
            if (r9 == r11) goto L_0x0305
            int r11 = r14.width
            r21 = r2
            r2 = -1
            if (r11 != r2) goto L_0x0306
            r6 = r21
            goto L_0x0306
        L_0x0305:
            r2 = -1
        L_0x0306:
            int r6 = java.lang.Math.max(r15, r6)
            if (r17 == 0) goto L_0x0313
            int r11 = r14.width
            if (r11 != r2) goto L_0x0313
            r11 = r19
            goto L_0x0314
        L_0x0313:
            r11 = 0
        L_0x0314:
            int r15 = r0.mTotalLength
            int r17 = r13.getMeasuredHeight()
            int r17 = r15 + r17
            int r2 = r14.topMargin
            int r17 = r17 + r2
            int r2 = r14.bottomMargin
            int r17 = r17 + r2
            int r2 = r0.getNextLocationOffset(r13)
            int r2 = r17 + r2
            int r2 = java.lang.Math.max(r15, r2)
            r0.mTotalLength = r2
            r15 = r6
            r17 = r11
        L_0x0333:
            int r6 = r16 + 1
            r2 = r22
            r11 = 0
            goto L_0x026c
        L_0x033a:
            int r2 = r0.mTotalLength
            int r6 = r0.getPaddingTop()
            int r7 = r0.getPaddingBottom()
            int r6 = r6 + r7
            int r2 = r2 + r6
            r0.mTotalLength = r2
            r6 = r15
        L_0x0349:
            if (r17 != 0) goto L_0x0350
            r11 = 1073741824(0x40000000, float:2.0)
            if (r9 == r11) goto L_0x0350
            r10 = r6
        L_0x0350:
            int r2 = r0.getPaddingLeft()
            int r6 = r0.getPaddingRight()
            int r2 = r2 + r6
            int r10 = r10 + r2
            int r2 = r0.getSuggestedMinimumWidth()
            int r2 = java.lang.Math.max(r10, r2)
            int r2 = android.view.View.resolveSizeAndState(r2, r3, r8)
            r0.setMeasuredDimension(r2, r4)
            if (r18 == 0) goto L_0x036e
            r0.forceUniformWidth(r1, r5)
        L_0x036e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.measureVertical(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        if (this.mOrientation == 1) {
            layoutVertical(i5, i6, i7, i8);
        } else {
            layoutHorizontal(i5, i6, i7, i8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        if (this.mOrientation == 1) {
            measureVertical(i5, i6);
        } else {
            measureHorizontal(i5, i6);
        }
    }

    public void setBaselineAligned(boolean z4) {
        this.mBaselineAligned = z4;
    }

    public void setBaselineAlignedChildIndex(int i5) {
        if (i5 < 0 || i5 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i5;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z4 = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z4 = true;
            }
            setWillNotDraw(z4);
            requestLayout();
        }
    }

    public void setDividerPadding(int i5) {
        this.mDividerPadding = i5;
    }

    public void setGravity(@GravityInt int i5) {
        if (this.mGravity != i5) {
            if ((8388615 & i5) == 0) {
                i5 |= GravityCompat.START;
            }
            if ((i5 & 112) == 0) {
                i5 |= 48;
            }
            this.mGravity = i5;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i5) {
        int i6 = i5 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i7 = this.mGravity;
        if ((8388615 & i7) != i6) {
            this.mGravity = i6 | (-8388616 & i7);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z4) {
        this.mUseLargestChild = z4;
    }

    public void setOrientation(int i5) {
        if (this.mOrientation != i5) {
            this.mOrientation = i5;
            requestLayout();
        }
    }

    public void setShowDividers(int i5) {
        if (i5 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i5;
    }

    public void setVerticalGravity(int i5) {
        int i6 = i5 & 112;
        int i7 = this.mGravity;
        if ((i7 & 112) != i6) {
            this.mGravity = i6 | (i7 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f5) {
        this.mWeightSum = Math.max(0.0f, f5);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        int i5 = this.mOrientation;
        if (i5 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i5 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        int[] iArr = R.styleable.LinearLayoutCompat;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i5, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i5, 0);
        int i6 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i6 >= 0) {
            setOrientation(i6);
        }
        int i7 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i7 >= 0) {
            setGravity(i7);
        }
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z4) {
            setBaselineAligned(z4);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) (LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
