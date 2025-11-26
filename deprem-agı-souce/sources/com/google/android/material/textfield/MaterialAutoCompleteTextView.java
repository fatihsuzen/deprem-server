package com.google.android.material.textfield;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final String SWITCH_ACCESS_ACTIVITY_NAME = "SwitchAccess";
    @Nullable
    private final AccessibilityManager accessibilityManager;
    @Nullable
    private ColorStateList dropDownBackgroundTint;
    /* access modifiers changed from: private */
    @NonNull
    public final ListPopupWindow modalListPopup;
    private final float popupElevation;
    @LayoutRes
    private final int simpleItemLayout;
    /* access modifiers changed from: private */
    public int simpleItemSelectedColor;
    /* access modifiers changed from: private */
    @Nullable
    public ColorStateList simpleItemSelectedRippleColor;
    @NonNull
    private final Rect tempRect;

    private class MaterialArrayAdapter<T> extends ArrayAdapter<String> {
        @Nullable
        private ColorStateList pressedRippleColor;
        @Nullable
        private ColorStateList selectedItemRippleOverlaidColor;

        MaterialArrayAdapter(@NonNull Context context, int i5, @NonNull String[] strArr) {
            super(context, i5, strArr);
            updateSelectedItemColorStateList();
        }

        @Nullable
        private ColorStateList createItemSelectedColorStateList() {
            if (!hasSelectedColor() || !hasSelectedRippleColor()) {
                return null;
            }
            int[] iArr = {16843623, -16842919};
            int[] iArr2 = {16842913, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{MaterialColors.layer(MaterialAutoCompleteTextView.this.simpleItemSelectedColor, MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor.getColorForState(iArr2, 0)), MaterialColors.layer(MaterialAutoCompleteTextView.this.simpleItemSelectedColor, MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor.getColorForState(iArr, 0)), MaterialAutoCompleteTextView.this.simpleItemSelectedColor});
        }

        @Nullable
        private Drawable getSelectedItemDrawable() {
            if (!hasSelectedColor()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(MaterialAutoCompleteTextView.this.simpleItemSelectedColor);
            if (this.pressedRippleColor == null) {
                return colorDrawable;
            }
            colorDrawable.setTintList(this.selectedItemRippleOverlaidColor);
            return new RippleDrawable(this.pressedRippleColor, colorDrawable, (Drawable) null);
        }

        private boolean hasSelectedColor() {
            if (MaterialAutoCompleteTextView.this.simpleItemSelectedColor != 0) {
                return true;
            }
            return false;
        }

        private boolean hasSelectedRippleColor() {
            if (MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor != null) {
                return true;
            }
            return false;
        }

        private ColorStateList sanitizeDropdownItemSelectedRippleColor() {
            if (!hasSelectedRippleColor()) {
                return null;
            }
            int[] iArr = {16842919};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor.getColorForState(iArr, 0), 0});
        }

        public View getView(int i5, @Nullable View view, ViewGroup viewGroup) {
            Drawable drawable;
            View view2 = super.getView(i5, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                if (MaterialAutoCompleteTextView.this.getText().toString().contentEquals(textView.getText())) {
                    drawable = getSelectedItemDrawable();
                } else {
                    drawable = null;
                }
                textView.setBackground(drawable);
            }
            return view2;
        }

        /* access modifiers changed from: package-private */
        public void updateSelectedItemColorStateList() {
            this.pressedRippleColor = sanitizeDropdownItemSelectedRippleColor();
            this.selectedItemRippleOverlaidColor = createItemSelectedColorStateList();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @Nullable
    private TextInputLayout findTextInputLayoutAncestor() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean isPopupRequired() {
        if (isTouchExplorationEnabled() || isSwitchAccessEnabled()) {
            return true;
        }
        return false;
    }

    private boolean isSwitchAccessEnabled() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (!(accessibilityManager2 == null || !accessibilityManager2.isEnabled() || (enabledAccessibilityServiceList = this.accessibilityManager.getEnabledAccessibilityServiceList(16)) == null)) {
            for (AccessibilityServiceInfo next : enabledAccessibilityServiceList) {
                if (next.getSettingsActivityName() != null && next.getSettingsActivityName().contains(SWITCH_ACCESS_ACTIVITY_NAME)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTouchExplorationEnabled() {
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 == null || !accessibilityManager2.isTouchExplorationEnabled()) {
            return false;
        }
        return true;
    }

    private int measureContentWidth() {
        ListAdapter adapter = getAdapter();
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        int i5 = 0;
        if (adapter == null || findTextInputLayoutAncestor == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.modalListPopup.getSelectedItemPosition()) + 15);
        View view = null;
        int i6 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = adapter.getView(max, view, findTextInputLayoutAncestor);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i6 = Math.max(i6, view.getMeasuredWidth());
        }
        Drawable background = this.modalListPopup.getBackground();
        if (background != null) {
            background.getPadding(this.tempRect);
            Rect rect = this.tempRect;
            i6 += rect.left + rect.right;
        }
        return i6 + findTextInputLayoutAncestor.getEndIconView().getMeasuredWidth();
    }

    private void onInputTypeChanged() {
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor != null) {
            findTextInputLayoutAncestor.updateEditTextBoxBackgroundIfNeeded();
        }
    }

    public void dismissDropDown() {
        if (isPopupRequired()) {
            this.modalListPopup.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    @Nullable
    public ColorStateList getDropDownBackgroundTintList() {
        return this.dropDownBackgroundTint;
    }

    @Nullable
    public CharSequence getHint() {
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor == null || !findTextInputLayoutAncestor.isProvidingHint()) {
            return super.getHint();
        }
        return findTextInputLayoutAncestor.getHint();
    }

    public float getPopupElevation() {
        return this.popupElevation;
    }

    public int getSimpleItemSelectedColor() {
        return this.simpleItemSelectedColor;
    }

    @Nullable
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.simpleItemSelectedRippleColor;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor != null && findTextInputLayoutAncestor.isProvidingHint() && super.getHint() == null && ManufacturerUtils.isMeizuDevice()) {
            setHint("");
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.modalListPopup.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(i5)), getMeasuredHeight());
        }
    }

    public void onWindowFocusChanged(boolean z4) {
        if (!isPopupRequired()) {
            super.onWindowFocusChanged(z4);
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t5) {
        super.setAdapter(t5);
        this.modalListPopup.setAdapter(getAdapter());
    }

    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        ListPopupWindow listPopupWindow = this.modalListPopup;
        if (listPopupWindow != null) {
            listPopupWindow.setBackgroundDrawable(drawable);
        }
    }

    public void setDropDownBackgroundTint(@ColorInt int i5) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i5));
    }

    public void setDropDownBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.dropDownBackgroundTint = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) dropDownBackground).setFillColor(this.dropDownBackgroundTint);
        }
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.modalListPopup.setOnItemSelectedListener(getOnItemSelectedListener());
    }

    public void setRawInputType(int i5) {
        super.setRawInputType(i5);
        onInputTypeChanged();
    }

    public void setSimpleItemSelectedColor(int i5) {
        this.simpleItemSelectedColor = i5;
        if (getAdapter() instanceof MaterialArrayAdapter) {
            ((MaterialArrayAdapter) getAdapter()).updateSelectedItemColorStateList();
        }
    }

    public void setSimpleItemSelectedRippleColor(@Nullable ColorStateList colorStateList) {
        this.simpleItemSelectedRippleColor = colorStateList;
        if (getAdapter() instanceof MaterialArrayAdapter) {
            ((MaterialArrayAdapter) getAdapter()).updateSelectedItemColorStateList();
        }
    }

    public void setSimpleItems(@ArrayRes int i5) {
        setSimpleItems(getResources().getStringArray(i5));
    }

    public void showDropDown() {
        if (isPopupRequired()) {
            this.modalListPopup.show();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new MaterialArrayAdapter(getContext(), this.simpleItemLayout, strArr));
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i5, 0), attributeSet, i5);
        this.tempRect = new Rect();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.MaterialAutoCompleteTextView, i5, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i6 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType;
        if (obtainStyledAttributes.hasValue(i6) && obtainStyledAttributes.getInt(i6, 0) == 0) {
            setKeyListener((KeyListener) null);
        }
        this.simpleItemLayout = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemLayout, com.google.android.material.R.layout.mtrl_auto_complete_simple_item);
        this.popupElevation = (float) obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_popupElevation, com.google.android.material.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int i7 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.dropDownBackgroundTint = ColorStateList.valueOf(obtainStyledAttributes.getColor(i7, 0));
        }
        this.simpleItemSelectedColor = obtainStyledAttributes.getColor(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.simpleItemSelectedRippleColor = MaterialResources.getColorStateList(context2, obtainStyledAttributes, com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.modalListPopup = listPopupWindow;
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(this);
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                Object obj;
                MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
                if (i5 < 0) {
                    obj = materialAutoCompleteTextView.modalListPopup.getSelectedItem();
                } else {
                    obj = materialAutoCompleteTextView.getAdapter().getItem(i5);
                }
                MaterialAutoCompleteTextView materialAutoCompleteTextView2 = MaterialAutoCompleteTextView.this;
                materialAutoCompleteTextView2.setText(materialAutoCompleteTextView2.convertSelectionToString(obj), false);
                AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i5 < 0) {
                        view = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedView();
                        i5 = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItemPosition();
                        j5 = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.modalListPopup.getListView(), view, i5, j5);
                }
                MaterialAutoCompleteTextView.this.modalListPopup.dismiss();
            }
        });
        int i8 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItems;
        if (obtainStyledAttributes.hasValue(i8)) {
            setSimpleItems(obtainStyledAttributes.getResourceId(i8, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
