package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.GridLayoutManager;
import androidx.leanback.widget.ItemAlignmentFacet;

class ItemAlignmentFacetHelper {
    private static final Rect sRect = new Rect();

    private ItemAlignmentFacetHelper() {
    }

    static int getAlignmentPosition(View view, ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef, int i5) {
        View view2;
        int i6;
        int i7;
        int i8;
        int i9;
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        int i10 = itemAlignmentDef.mViewId;
        if (i10 == 0 || (view2 = view.findViewById(i10)) == null) {
            view2 = view;
        }
        int i11 = itemAlignmentDef.mOffset;
        if (i5 != 0) {
            if (itemAlignmentDef.mOffsetWithPadding) {
                float f5 = itemAlignmentDef.mOffsetPercent;
                if (f5 == 0.0f) {
                    i11 += view2.getPaddingTop();
                } else if (f5 == 100.0f) {
                    i11 -= view2.getPaddingBottom();
                }
            }
            if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                if (view2 == view) {
                    i6 = layoutParams.getOpticalHeight(view2);
                } else {
                    i6 = view2.getHeight();
                }
                i11 += (int) ((((float) i6) * itemAlignmentDef.mOffsetPercent) / 100.0f);
            }
            if (view != view2) {
                Rect rect = sRect;
                rect.top = i11;
                ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect);
                i11 = rect.top - layoutParams.getOpticalTopInset();
            }
            if (itemAlignmentDef.isAlignedToTextViewBaseLine()) {
                return i11 + view2.getBaseline();
            }
            return i11;
        } else if (view.getLayoutDirection() == 1) {
            if (view2 == view) {
                i8 = layoutParams.getOpticalWidth(view2);
            } else {
                i8 = view2.getWidth();
            }
            int i12 = i8 - i11;
            if (itemAlignmentDef.mOffsetWithPadding) {
                float f6 = itemAlignmentDef.mOffsetPercent;
                if (f6 == 0.0f) {
                    i12 -= view2.getPaddingRight();
                } else if (f6 == 100.0f) {
                    i12 += view2.getPaddingLeft();
                }
            }
            if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                if (view2 == view) {
                    i9 = layoutParams.getOpticalWidth(view2);
                } else {
                    i9 = view2.getWidth();
                }
                i12 -= (int) ((((float) i9) * itemAlignmentDef.mOffsetPercent) / 100.0f);
            }
            if (view == view2) {
                return i12;
            }
            Rect rect2 = sRect;
            rect2.right = i12;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect2);
            return rect2.right + layoutParams.getOpticalRightInset();
        } else {
            if (itemAlignmentDef.mOffsetWithPadding) {
                float f7 = itemAlignmentDef.mOffsetPercent;
                if (f7 == 0.0f) {
                    i11 += view2.getPaddingLeft();
                } else if (f7 == 100.0f) {
                    i11 -= view2.getPaddingRight();
                }
            }
            if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                if (view2 == view) {
                    i7 = layoutParams.getOpticalWidth(view2);
                } else {
                    i7 = view2.getWidth();
                }
                i11 += (int) ((((float) i7) * itemAlignmentDef.mOffsetPercent) / 100.0f);
            }
            if (view == view2) {
                return i11;
            }
            Rect rect3 = sRect;
            rect3.left = i11;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect3);
            return rect3.left - layoutParams.getOpticalLeftInset();
        }
    }
}
