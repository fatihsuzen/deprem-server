package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import java.util.ArrayList;

public class PinPicker extends Picker {
    private static final int DEFAULT_COLUMN_COUNT = 4;

    public PinPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pinPickerStyle);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 1 || keyCode < 7 || keyCode > 16) {
            return super.dispatchKeyEvent(keyEvent);
        }
        setColumnValue(getSelectedColumn(), keyCode - 7, false);
        performClick();
        return true;
    }

    public String getPin() {
        StringBuilder sb = new StringBuilder();
        int columnsCount = getColumnsCount();
        for (int i5 = 0; i5 < columnsCount; i5++) {
            sb.append(Integer.toString(getColumnAt(i5).getCurrentValue()));
        }
        return sb.toString();
    }

    public boolean performClick() {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn == getColumnsCount() - 1) {
            return super.performClick();
        }
        setSelectedColumn(selectedColumn + 1);
        return false;
    }

    public void resetPin() {
        int columnsCount = getColumnsCount();
        for (int i5 = 0; i5 < columnsCount; i5++) {
            setColumnValue(i5, 0, false);
        }
        setSelectedColumn(0);
    }

    public void setNumberOfColumns(int i5) {
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            PickerColumn pickerColumn = new PickerColumn();
            pickerColumn.setMinValue(0);
            pickerColumn.setMaxValue(9);
            pickerColumn.setLabelFormat(TimeModel.NUMBER_FORMAT);
            arrayList.add(pickerColumn);
        }
        setColumns(arrayList);
    }

    @SuppressLint({"CustomViewStyleable"})
    public PinPicker(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        int[] iArr = R.styleable.lbPinPicker;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i5, 0);
        try {
            setSeparator(" ");
            setNumberOfColumns(obtainStyledAttributes.getInt(R.styleable.lbPinPicker_columnCount, 4));
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            Throwable th2 = th;
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
