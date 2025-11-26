package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    private void updateImportantForAccessibility(@NonNull View view, boolean z4) {
        boolean z5;
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z4) {
                this.importantForAccessibilityMap = new HashMap(childCount);
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = coordinatorLayout.getChildAt(i5);
                if (!(childAt.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) || !(((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior)) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (childAt != view && !z5) {
                    if (!z4) {
                        Map<View, Integer> map = this.importantForAccessibilityMap;
                        if (map != null && map.containsKey(childAt)) {
                            childAt.setImportantForAccessibility(this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    } else {
                        this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        childAt.setImportantForAccessibility(4);
                    }
                }
            }
            if (!z4) {
                this.importantForAccessibilityMap = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context context, boolean z4) {
        int i5;
        if (z4) {
            i5 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i5 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
        fabTransformationSpec.timings = MotionSpec.createFromResource(context, i5);
        fabTransformationSpec.positioning = new Positioning(17, 0.0f, 0.0f);
        return fabTransformationSpec;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public boolean onExpandedStateChange(@NonNull View view, @NonNull View view2, boolean z4, boolean z5) {
        updateImportantForAccessibility(view2, z4);
        return super.onExpandedStateChange(view, view2, z4, z5);
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
