package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Picker extends FrameLayout {
    private int mAlphaAnimDuration;
    private final OnChildViewHolderSelectedListener mColumnChangeListener;
    final List<VerticalGridView> mColumnViews;
    ArrayList<PickerColumn> mColumns;
    private Interpolator mDecelerateInterpolator;
    private float mFocusedAlpha;
    private float mInvisibleColumnAlpha;
    private ArrayList<PickerValueListener> mListeners;
    private int mPickerItemLayoutId;
    private int mPickerItemTextViewId;
    private ViewGroup mPickerView;
    private int mSelectedColumn;
    private List<CharSequence> mSeparators;
    private float mUnfocusedAlpha;
    private float mVisibleColumnAlpha;
    private float mVisibleItems;
    private float mVisibleItemsActivated;

    class PickerScrollArrayAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final int mColIndex;
        private PickerColumn mData;
        private final int mResource;
        private final int mTextViewResourceId;

        PickerScrollArrayAdapter(int i5, int i6, int i7) {
            this.mResource = i5;
            this.mColIndex = i7;
            this.mTextViewResourceId = i6;
            this.mData = Picker.this.mColumns.get(i7);
        }

        public int getItemCount() {
            PickerColumn pickerColumn = this.mData;
            if (pickerColumn == null) {
                return 0;
            }
            return pickerColumn.getCount();
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i5) {
            PickerColumn pickerColumn;
            TextView textView = viewHolder.textView;
            if (!(textView == null || (pickerColumn = this.mData) == null)) {
                textView.setText(pickerColumn.getLabelFor(pickerColumn.getMinValue() + i5));
            }
            Picker picker = Picker.this;
            picker.setOrAnimateAlpha(viewHolder.itemView, picker.mColumnViews.get(this.mColIndex).getSelectedPosition() == i5, this.mColIndex, false);
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
            TextView textView;
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.mResource, viewGroup, false);
            int i6 = this.mTextViewResourceId;
            if (i6 != 0) {
                textView = (TextView) inflate.findViewById(i6);
            } else {
                textView = (TextView) inflate;
            }
            return new ViewHolder(inflate, textView);
        }

        public void onViewAttachedToWindow(ViewHolder viewHolder) {
            viewHolder.itemView.setFocusable(Picker.this.isActivated());
        }
    }

    public interface PickerValueListener {
        void onValueChanged(Picker picker, int i5);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ViewHolder(View view, TextView textView2) {
            super(view);
            this.textView = textView2;
        }
    }

    public Picker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pickerStyle);
    }

    private void notifyValueChanged(int i5) {
        ArrayList<PickerValueListener> arrayList = this.mListeners;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onValueChanged(this, i5);
            }
        }
    }

    private void updateColumnSize() {
        for (int i5 = 0; i5 < getColumnsCount(); i5++) {
            updateColumnSize(this.mColumnViews.get(i5));
        }
    }

    private void updateItemFocusable() {
        boolean isActivated = isActivated();
        for (int i5 = 0; i5 < getColumnsCount(); i5++) {
            VerticalGridView verticalGridView = this.mColumnViews.get(i5);
            for (int i6 = 0; i6 < verticalGridView.getChildCount(); i6++) {
                verticalGridView.getChildAt(i6).setFocusable(isActivated);
            }
        }
    }

    public void addOnValueChangedListener(PickerValueListener pickerValueListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(pickerValueListener);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isActivated()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 23 && keyCode != 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 1) {
            performClick();
        }
        return true;
    }

    public float getActivatedVisibleItemCount() {
        return this.mVisibleItemsActivated;
    }

    public PickerColumn getColumnAt(int i5) {
        ArrayList<PickerColumn> arrayList = this.mColumns;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i5);
    }

    public int getColumnsCount() {
        ArrayList<PickerColumn> arrayList = this.mColumns;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* access modifiers changed from: protected */
    public int getPickerItemHeightPixels() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.picker_item_height);
    }

    @LayoutRes
    public final int getPickerItemLayoutId() {
        return this.mPickerItemLayoutId;
    }

    @IdRes
    public final int getPickerItemTextViewId() {
        return this.mPickerItemTextViewId;
    }

    public int getSelectedColumn() {
        return this.mSelectedColumn;
    }

    @Deprecated
    public final CharSequence getSeparator() {
        return this.mSeparators.get(0);
    }

    public final List<CharSequence> getSeparators() {
        return this.mSeparators;
    }

    public float getVisibleItemCount() {
        return 1.0f;
    }

    public void onColumnValueChanged(int i5, int i6) {
        PickerColumn pickerColumn = this.mColumns.get(i5);
        if (pickerColumn.getCurrentValue() != i6) {
            pickerColumn.setCurrentValue(i6);
            notifyValueChanged(i5);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i5, Rect rect) {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn < 0 || selectedColumn >= this.mColumnViews.size()) {
            return false;
        }
        return this.mColumnViews.get(selectedColumn).requestFocus(i5, rect);
    }

    public void removeOnValueChangedListener(PickerValueListener pickerValueListener) {
        ArrayList<PickerValueListener> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.remove(pickerValueListener);
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        for (int i5 = 0; i5 < this.mColumnViews.size(); i5++) {
            if (this.mColumnViews.get(i5).hasFocus()) {
                setSelectedColumn(i5);
            }
        }
    }

    public void setActivated(boolean z4) {
        if (z4 == isActivated()) {
            super.setActivated(z4);
            return;
        }
        super.setActivated(z4);
        boolean hasFocus = hasFocus();
        int selectedColumn = getSelectedColumn();
        setDescendantFocusability(131072);
        if (!z4 && hasFocus && isFocusable()) {
            requestFocus();
        }
        for (int i5 = 0; i5 < getColumnsCount(); i5++) {
            this.mColumnViews.get(i5).setFocusable(z4);
        }
        updateColumnSize();
        updateItemFocusable();
        if (z4 && hasFocus && selectedColumn >= 0) {
            this.mColumnViews.get(selectedColumn).requestFocus();
        }
        setDescendantFocusability(262144);
    }

    public void setActivatedVisibleItemCount(float f5) {
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException();
        } else if (this.mVisibleItemsActivated != f5) {
            this.mVisibleItemsActivated = f5;
            if (isActivated()) {
                updateColumnSize();
            }
        }
    }

    public void setColumnAt(int i5, PickerColumn pickerColumn) {
        this.mColumns.set(i5, pickerColumn);
        VerticalGridView verticalGridView = this.mColumnViews.get(i5);
        PickerScrollArrayAdapter pickerScrollArrayAdapter = (PickerScrollArrayAdapter) verticalGridView.getAdapter();
        if (pickerScrollArrayAdapter != null) {
            pickerScrollArrayAdapter.notifyDataSetChanged();
        }
        verticalGridView.setSelectedPosition(pickerColumn.getCurrentValue() - pickerColumn.getMinValue());
    }

    public void setColumnValue(int i5, int i6, boolean z4) {
        PickerColumn pickerColumn = this.mColumns.get(i5);
        if (pickerColumn.getCurrentValue() != i6) {
            pickerColumn.setCurrentValue(i6);
            notifyValueChanged(i5);
            VerticalGridView verticalGridView = this.mColumnViews.get(i5);
            if (verticalGridView != null) {
                int minValue = i6 - this.mColumns.get(i5).getMinValue();
                if (z4) {
                    verticalGridView.setSelectedPositionSmooth(minValue);
                } else {
                    verticalGridView.setSelectedPosition(minValue);
                }
            }
        }
    }

    public void setColumns(List<PickerColumn> list) {
        if (this.mSeparators.size() != 0) {
            if (this.mSeparators.size() == 1) {
                CharSequence charSequence = this.mSeparators.get(0);
                this.mSeparators.clear();
                this.mSeparators.add("");
                for (int i5 = 0; i5 < list.size() - 1; i5++) {
                    this.mSeparators.add(charSequence);
                }
                this.mSeparators.add("");
            } else if (this.mSeparators.size() != list.size() + 1) {
                throw new IllegalStateException("Separators size: " + this.mSeparators.size() + " mustequal the size of columns: " + list.size() + " + 1");
            }
            this.mColumnViews.clear();
            this.mPickerView.removeAllViews();
            ArrayList<PickerColumn> arrayList = new ArrayList<>(list);
            this.mColumns = arrayList;
            if (this.mSelectedColumn > arrayList.size() - 1) {
                this.mSelectedColumn = this.mColumns.size() - 1;
            }
            LayoutInflater from = LayoutInflater.from(getContext());
            int columnsCount = getColumnsCount();
            if (!TextUtils.isEmpty(this.mSeparators.get(0))) {
                TextView textView = (TextView) from.inflate(R.layout.lb_picker_separator, this.mPickerView, false);
                textView.setText(this.mSeparators.get(0));
                this.mPickerView.addView(textView);
            }
            int i6 = 0;
            while (i6 < columnsCount) {
                VerticalGridView verticalGridView = (VerticalGridView) from.inflate(R.layout.lb_picker_column, this.mPickerView, false);
                updateColumnSize(verticalGridView);
                verticalGridView.setWindowAlignment(0);
                verticalGridView.setHasFixedSize(false);
                verticalGridView.setFocusable(isActivated());
                verticalGridView.setItemViewCacheSize(0);
                this.mColumnViews.add(verticalGridView);
                this.mPickerView.addView(verticalGridView);
                int i7 = i6 + 1;
                if (!TextUtils.isEmpty(this.mSeparators.get(i7))) {
                    TextView textView2 = (TextView) from.inflate(R.layout.lb_picker_separator, this.mPickerView, false);
                    textView2.setText(this.mSeparators.get(i7));
                    this.mPickerView.addView(textView2);
                }
                verticalGridView.setAdapter(new PickerScrollArrayAdapter(getPickerItemLayoutId(), getPickerItemTextViewId(), i6));
                verticalGridView.setOnChildViewHolderSelectedListener(this.mColumnChangeListener);
                i6 = i7;
            }
            return;
        }
        throw new IllegalStateException("Separators size is: " + this.mSeparators.size() + ". At least one separator must be provided");
    }

    /* access modifiers changed from: package-private */
    public void setOrAnimateAlpha(View view, boolean z4, int i5, boolean z5) {
        boolean z6 = i5 == this.mSelectedColumn || !hasFocus();
        if (z4) {
            if (z6) {
                setOrAnimateAlpha(view, z5, this.mFocusedAlpha, -1.0f, this.mDecelerateInterpolator);
            } else {
                setOrAnimateAlpha(view, z5, this.mUnfocusedAlpha, -1.0f, this.mDecelerateInterpolator);
            }
        } else if (z6) {
            setOrAnimateAlpha(view, z5, this.mVisibleColumnAlpha, -1.0f, this.mDecelerateInterpolator);
        } else {
            setOrAnimateAlpha(view, z5, this.mInvisibleColumnAlpha, -1.0f, this.mDecelerateInterpolator);
        }
    }

    public final void setPickerItemLayoutId(@LayoutRes int i5) {
        this.mPickerItemLayoutId = i5;
    }

    public final void setPickerItemTextViewId(@IdRes int i5) {
        this.mPickerItemTextViewId = i5;
    }

    public void setSelectedColumn(int i5) {
        if (this.mSelectedColumn != i5) {
            this.mSelectedColumn = i5;
            for (int i6 = 0; i6 < this.mColumnViews.size(); i6++) {
                updateColumnAlpha(i6, true);
            }
        }
        VerticalGridView verticalGridView = this.mColumnViews.get(i5);
        if (hasFocus() && !verticalGridView.hasFocus()) {
            verticalGridView.requestFocus();
        }
    }

    public final void setSeparator(CharSequence charSequence) {
        setSeparators(Arrays.asList(new CharSequence[]{charSequence}));
    }

    public final void setSeparators(List<CharSequence> list) {
        this.mSeparators.clear();
        this.mSeparators.addAll(list);
    }

    public void setVisibleItemCount(float f5) {
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException();
        } else if (this.mVisibleItems != f5) {
            this.mVisibleItems = f5;
            if (!isActivated()) {
                updateColumnSize();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateColumnAlpha(int i5, boolean z4) {
        boolean z5;
        VerticalGridView verticalGridView = this.mColumnViews.get(i5);
        int selectedPosition = verticalGridView.getSelectedPosition();
        for (int i6 = 0; i6 < verticalGridView.getAdapter().getItemCount(); i6++) {
            View findViewByPosition = verticalGridView.getLayoutManager().findViewByPosition(i6);
            if (findViewByPosition != null) {
                if (selectedPosition == i6) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                setOrAnimateAlpha(findViewByPosition, z5, i5, z4);
            }
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    public Picker(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mColumnViews = new ArrayList();
        this.mVisibleItemsActivated = 3.0f;
        this.mVisibleItems = 1.0f;
        this.mSelectedColumn = 0;
        this.mSeparators = new ArrayList();
        this.mColumnChangeListener = new OnChildViewHolderSelectedListener() {
            public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i5, int i6) {
                int indexOf = Picker.this.mColumnViews.indexOf((VerticalGridView) recyclerView);
                Picker.this.updateColumnAlpha(indexOf, true);
                if (viewHolder != null) {
                    Picker.this.onColumnValueChanged(indexOf, Picker.this.mColumns.get(indexOf).getMinValue() + i5);
                }
            }
        };
        int[] iArr = R.styleable.lbPicker;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i5, 0);
        this.mPickerItemLayoutId = obtainStyledAttributes.getResourceId(R.styleable.lbPicker_pickerItemLayout, R.layout.lb_picker_item);
        this.mPickerItemTextViewId = obtainStyledAttributes.getResourceId(R.styleable.lbPicker_pickerItemTextViewId, 0);
        obtainStyledAttributes.recycle();
        setEnabled(true);
        setDescendantFocusability(262144);
        this.mFocusedAlpha = 1.0f;
        this.mUnfocusedAlpha = 1.0f;
        this.mVisibleColumnAlpha = 0.5f;
        this.mInvisibleColumnAlpha = 0.0f;
        this.mAlphaAnimDuration = 200;
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.5f);
        this.mPickerView = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.lb_picker, this, true)).findViewById(R.id.picker);
    }

    private void updateColumnSize(VerticalGridView verticalGridView) {
        ViewGroup.LayoutParams layoutParams = verticalGridView.getLayoutParams();
        float activatedVisibleItemCount = isActivated() ? getActivatedVisibleItemCount() : getVisibleItemCount();
        layoutParams.height = (int) ((((float) getPickerItemHeightPixels()) * activatedVisibleItemCount) + (((float) verticalGridView.getVerticalSpacing()) * (activatedVisibleItemCount - 1.0f)));
        verticalGridView.setLayoutParams(layoutParams);
    }

    private void setOrAnimateAlpha(View view, boolean z4, float f5, float f6, Interpolator interpolator) {
        view.animate().cancel();
        if (!z4) {
            view.setAlpha(f5);
            return;
        }
        if (f6 >= 0.0f) {
            view.setAlpha(f6);
        }
        view.animate().alpha(f5).setDuration((long) this.mAlphaAnimDuration).setInterpolator(interpolator).start();
    }
}
