package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.StateListCornerSize;
import com.google.android.material.shape.StateListShapeAppearanceModel;
import com.google.android.material.shape.StateListSizeChange;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class MaterialButtonGroup extends LinearLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_MaterialButtonGroup;
    private static final String LOG_TAG = "MButtonGroup";
    @Nullable
    private StateListSizeChange buttonSizeChange;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;
    private boolean childShapesDirty;
    @Nullable
    private StateListShapeAppearanceModel groupStateListShapeAppearance;
    @Nullable
    StateListCornerSize innerCornerSize;
    private final List<ShapeAppearanceModel> originalChildShapeAppearanceModels;
    private final List<StateListShapeAppearanceModel> originalChildStateListShapeAppearanceModels;
    private final PressedStateTracker pressedStateTracker;
    @Px
    private int spacing;

    private class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        public void onPressedChanged(@NonNull MaterialButton materialButton, boolean z4) {
            MaterialButtonGroup.this.invalidate();
        }
    }

    public MaterialButtonGroup(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ int a(MaterialButtonGroup materialButtonGroup, MaterialButton materialButton, MaterialButton materialButton2) {
        materialButtonGroup.getClass();
        int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        return Integer.compare(materialButtonGroup.indexOfChild(materialButton), materialButtonGroup.indexOfChild(materialButton2));
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int i5;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i6 = firstVisibleChildIndex + 1; i6 < getChildCount(); i6++) {
                MaterialButton childButton = getChildButton(i6);
                MaterialButton childButton2 = getChildButton(i6 - 1);
                if (this.spacing <= 0) {
                    i5 = Math.min(childButton.getStrokeWidth(), childButton2.getStrokeWidth());
                    childButton.setShouldDrawSurfaceColorStroke(true);
                    childButton2.setShouldDrawSurfaceColorStroke(true);
                } else {
                    childButton.setShouldDrawSurfaceColorStroke(false);
                    childButton2.setShouldDrawSurfaceColorStroke(false);
                    i5 = 0;
                }
                LinearLayout.LayoutParams buildLayoutParams = buildLayoutParams(childButton);
                if (getOrientation() == 0) {
                    buildLayoutParams.setMarginEnd(0);
                    buildLayoutParams.setMarginStart(this.spacing - i5);
                    buildLayoutParams.topMargin = 0;
                } else {
                    buildLayoutParams.bottomMargin = 0;
                    buildLayoutParams.topMargin = this.spacing - i5;
                    buildLayoutParams.setMarginStart(0);
                }
                childButton.setLayoutParams(buildLayoutParams);
            }
            resetChildMargins(firstVisibleChildIndex);
        }
    }

    private void adjustChildSizeChange() {
        int i5;
        if (this.buttonSizeChange != null && getChildCount() != 0) {
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i6 = Integer.MAX_VALUE;
            for (int i7 = firstVisibleChildIndex; i7 <= lastVisibleChildIndex; i7++) {
                if (isChildVisible(i7)) {
                    int buttonAllowedWidthIncrease = getButtonAllowedWidthIncrease(i7);
                    if (!(i7 == firstVisibleChildIndex || i7 == lastVisibleChildIndex)) {
                        buttonAllowedWidthIncrease /= 2;
                    }
                    i6 = Math.min(i6, buttonAllowedWidthIncrease);
                }
            }
            for (int i8 = firstVisibleChildIndex; i8 <= lastVisibleChildIndex; i8++) {
                if (isChildVisible(i8)) {
                    getChildButton(i8).setSizeChange(this.buttonSizeChange);
                    MaterialButton childButton = getChildButton(i8);
                    if (i8 == firstVisibleChildIndex || i8 == lastVisibleChildIndex) {
                        i5 = i6;
                    } else {
                        i5 = i6 * 2;
                    }
                    childButton.setWidthChangeMax(i5);
                }
            }
        }
    }

    private int getButtonAllowedWidthIncrease(int i5) {
        int i6;
        int i7 = 0;
        if (!isChildVisible(i5) || this.buttonSizeChange == null) {
            return 0;
        }
        int max = Math.max(0, this.buttonSizeChange.getMaxWidthChange(getChildButton(i5).getWidth()));
        MaterialButton prevVisibleChildButton = getPrevVisibleChildButton(i5);
        if (prevVisibleChildButton == null) {
            i6 = 0;
        } else {
            i6 = prevVisibleChildButton.getAllowedWidthDecrease();
        }
        MaterialButton nextVisibleChildButton = getNextVisibleChildButton(i5);
        if (nextVisibleChildButton != null) {
            i7 = nextVisibleChildButton.getAllowedWidthDecrease();
        }
        return Math.min(max, i6 + i7);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (isChildVisible(i5)) {
                return i5;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    @Nullable
    private MaterialButton getNextVisibleChildButton(int i5) {
        int childCount = getChildCount();
        do {
            i5++;
            if (i5 >= childCount) {
                return null;
            }
        } while (!isChildVisible(i5));
        return getChildButton(i5);
    }

    @NonNull
    private StateListShapeAppearanceModel.Builder getOriginalStateListShapeBuilder(boolean z4, boolean z5, int i5) {
        StateListShapeAppearanceModel stateListShapeAppearanceModel = this.groupStateListShapeAppearance;
        if (stateListShapeAppearanceModel == null || (!z4 && !z5)) {
            stateListShapeAppearanceModel = this.originalChildStateListShapeAppearanceModels.get(i5);
        }
        if (stateListShapeAppearanceModel == null) {
            return new StateListShapeAppearanceModel.Builder(this.originalChildShapeAppearanceModels.get(i5));
        }
        return stateListShapeAppearanceModel.toBuilder();
    }

    @Nullable
    private MaterialButton getPrevVisibleChildButton(int i5) {
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            if (isChildVisible(i6)) {
                return getChildButton(i6);
            }
        }
        return null;
    }

    private boolean isChildVisible(int i5) {
        if (getChildAt(i5).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private void recoverAllChildrenLayoutParams() {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildButton(i5).recoverOriginalLayoutParams();
        }
    }

    private void resetChildMargins(int i5) {
        if (getChildCount() != 0 && i5 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildButton(i5).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            layoutParams.setMarginEnd(0);
            layoutParams.setMarginStart(0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    private void updateChildOrder() {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            treeMap.put(getChildButton(i5), Integer.valueOf(i5));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    public void addView(@NonNull View view, int i5, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(LOG_TAG, "Child views must be of type MaterialButton.");
            return;
        }
        recoverAllChildrenLayoutParams();
        this.childShapesDirty = true;
        super.addView(view, i5, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        this.originalChildShapeAppearanceModels.add(materialButton.getShapeAppearanceModel());
        this.originalChildStateListShapeAppearanceModels.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LinearLayout.LayoutParams buildLayoutParams(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(@NonNull Canvas canvas) {
        updateChildOrder();
        super.dispatchDraw(canvas);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StateListSizeChange getButtonSizeChange() {
        return this.buttonSizeChange;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public MaterialButton getChildButton(int i5) {
        return (MaterialButton) getChildAt(i5);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i5, int i6) {
        Integer[] numArr = this.childOrder;
        if (numArr != null && i6 < numArr.length) {
            return numArr[i6].intValue();
        }
        Log.w(LOG_TAG, "Child order wasn't updated");
        return i6;
    }

    @NonNull
    public CornerSize getInnerCornerSize() {
        return this.innerCornerSize.getDefaultCornerSize();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StateListCornerSize getInnerCornerSizeStateList() {
        return this.innerCornerSize;
    }

    @Nullable
    public ShapeAppearanceModel getShapeAppearance() {
        StateListShapeAppearanceModel stateListShapeAppearanceModel = this.groupStateListShapeAppearance;
        if (stateListShapeAppearanceModel == null) {
            return null;
        }
        return stateListShapeAppearanceModel.getDefaultShape(true);
    }

    @Px
    public int getSpacing() {
        return this.spacing;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StateListShapeAppearanceModel getStateListShapeAppearance() {
        return this.groupStateListShapeAppearance;
    }

    /* access modifiers changed from: package-private */
    public void onButtonWidthChanged(@NonNull MaterialButton materialButton, int i5) {
        int indexOfChild = indexOfChild(materialButton);
        if (indexOfChild >= 0) {
            MaterialButton prevVisibleChildButton = getPrevVisibleChildButton(indexOfChild);
            MaterialButton nextVisibleChildButton = getNextVisibleChildButton(indexOfChild);
            if (prevVisibleChildButton != null || nextVisibleChildButton != null) {
                if (prevVisibleChildButton == null) {
                    nextVisibleChildButton.setDisplayedWidthDecrease(i5);
                }
                if (nextVisibleChildButton == null) {
                    prevVisibleChildButton.setDisplayedWidthDecrease(i5);
                }
                if (prevVisibleChildButton != null && nextVisibleChildButton != null) {
                    prevVisibleChildButton.setDisplayedWidthDecrease(i5 / 2);
                    nextVisibleChildButton.setDisplayedWidthDecrease((i5 + 1) / 2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        if (z4) {
            recoverAllChildrenLayoutParams();
            adjustChildSizeChange();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i5, i6);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal((MaterialButton.OnPressedChangeListener) null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.originalChildShapeAppearanceModels.remove(indexOfChild);
            this.originalChildStateListShapeAppearanceModels.remove(indexOfChild);
        }
        this.childShapesDirty = true;
        updateChildShapes();
        recoverAllChildrenLayoutParams();
        adjustChildMarginsAndUpdateLayout();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setButtonSizeChange(@NonNull StateListSizeChange stateListSizeChange) {
        if (this.buttonSizeChange != stateListSizeChange) {
            this.buttonSizeChange = stateListSizeChange;
            adjustChildSizeChange();
            requestLayout();
            invalidate();
        }
    }

    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildButton(i5).setEnabled(z4);
        }
    }

    public void setInnerCornerSize(@NonNull CornerSize cornerSize) {
        this.innerCornerSize = StateListCornerSize.create(cornerSize);
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInnerCornerSizeStateList(@NonNull StateListCornerSize stateListCornerSize) {
        this.innerCornerSize = stateListCornerSize;
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    public void setOrientation(int i5) {
        if (getOrientation() != i5) {
            this.childShapesDirty = true;
        }
        super.setOrientation(i5);
    }

    public void setShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.groupStateListShapeAppearance = new StateListShapeAppearanceModel.Builder(shapeAppearanceModel).build();
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    public void setSpacing(@Px int i5) {
        this.spacing = i5;
        invalidate();
        requestLayout();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStateListShapeAppearance(@Nullable StateListShapeAppearanceModel stateListShapeAppearanceModel) {
        this.groupStateListShapeAppearance = stateListShapeAppearanceModel;
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void updateChildShapes() {
        boolean z4;
        boolean z5;
        boolean z6;
        int i5;
        int i6;
        if (!(this.innerCornerSize == null && this.groupStateListShapeAppearance == null) && this.childShapesDirty) {
            this.childShapesDirty = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            for (int i7 = 0; i7 < childCount; i7++) {
                MaterialButton childButton = getChildButton(i7);
                if (childButton.getVisibility() != 8) {
                    if (i7 == firstVisibleChildIndex) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (i7 == lastVisibleChildIndex) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    StateListShapeAppearanceModel.Builder originalStateListShapeBuilder = getOriginalStateListShapeBuilder(z4, z5, i7);
                    if (getOrientation() == 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                    if (z6) {
                        if (z4) {
                            i5 = 5;
                        } else {
                            i5 = 0;
                        }
                        if (z5) {
                            i5 |= 10;
                        }
                        if (isLayoutRtl) {
                            i5 = StateListShapeAppearanceModel.swapCornerPositionRtl(i5);
                        }
                    } else {
                        if (z4) {
                            i6 = 3;
                        } else {
                            i6 = 0;
                        }
                        if (z5) {
                            i5 |= 12;
                        }
                    }
                    StateListShapeAppearanceModel build = originalStateListShapeBuilder.setCornerSizeOverride(this.innerCornerSize, ~i5).build();
                    if (build.isStateful()) {
                        childButton.setStateListShapeAppearanceModel(build);
                    } else {
                        childButton.setShapeAppearanceModel(build.getDefaultShape(true));
                    }
                }
            }
        }
    }

    public MaterialButtonGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonGroupStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButtonGroup(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r7.originalChildShapeAppearanceModels = r8
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r7.originalChildStateListShapeAppearanceModels = r8
            com.google.android.material.button.MaterialButtonGroup$PressedStateTracker r8 = new com.google.android.material.button.MaterialButtonGroup$PressedStateTracker
            r0 = 0
            r8.<init>()
            r7.pressedStateTracker = r8
            com.google.android.material.button.c r8 = new com.google.android.material.button.c
            r8.<init>(r7)
            r7.childOrderComparator = r8
            r8 = 1
            r7.childShapesDirty = r8
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButtonGroup
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_buttonSizeChange
            boolean r1 = r9.hasValue(r10)
            if (r1 == 0) goto L_0x0046
            com.google.android.material.shape.StateListSizeChange r10 = com.google.android.material.shape.StateListSizeChange.create(r0, r9, r10)
            r7.buttonSizeChange = r10
        L_0x0046:
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_shapeAppearance
            boolean r1 = r9.hasValue(r10)
            if (r1 == 0) goto L_0x0073
            com.google.android.material.shape.StateListShapeAppearanceModel r1 = com.google.android.material.shape.StateListShapeAppearanceModel.create(r0, r9, r10)
            r7.groupStateListShapeAppearance = r1
            if (r1 != 0) goto L_0x0073
            com.google.android.material.shape.StateListShapeAppearanceModel$Builder r1 = new com.google.android.material.shape.StateListShapeAppearanceModel$Builder
            int r10 = r9.getResourceId(r10, r6)
            int r2 = com.google.android.material.R.styleable.MaterialButtonGroup_shapeAppearanceOverlay
            int r2 = r9.getResourceId(r2, r6)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r10 = com.google.android.material.shape.ShapeAppearanceModel.builder(r0, r10, r2)
            com.google.android.material.shape.ShapeAppearanceModel r10 = r10.build()
            r1.<init>((com.google.android.material.shape.ShapeAppearanceModel) r10)
            com.google.android.material.shape.StateListShapeAppearanceModel r10 = r1.build()
            r7.groupStateListShapeAppearance = r10
        L_0x0073:
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_innerCornerSize
            boolean r1 = r9.hasValue(r10)
            if (r1 == 0) goto L_0x0087
            com.google.android.material.shape.AbsoluteCornerSize r1 = new com.google.android.material.shape.AbsoluteCornerSize
            r2 = 0
            r1.<init>(r2)
            com.google.android.material.shape.StateListCornerSize r10 = com.google.android.material.shape.StateListCornerSize.create(r0, r9, r10, r1)
            r7.innerCornerSize = r10
        L_0x0087:
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_android_spacing
            int r10 = r9.getDimensionPixelSize(r10, r6)
            r7.spacing = r10
            r7.setChildrenDrawingOrderEnabled(r8)
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_android_enabled
            boolean r8 = r9.getBoolean(r10, r8)
            r7.setEnabled(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
