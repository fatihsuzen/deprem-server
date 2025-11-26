package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;

public class VerticalGridView extends BaseGridView {
    public VerticalGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"CustomViewStyleable"})
    public void initAttributes(Context context, AttributeSet attributeSet) {
        initBaseGridViewAttributes(context, attributeSet);
        int[] iArr = R.styleable.lbVerticalGridView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        setColumnWidth(obtainStyledAttributes);
        setNumColumns(obtainStyledAttributes.getInt(R.styleable.lbVerticalGridView_numberOfColumns, 1));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void setColumnWidth(TypedArray typedArray) {
        int i5 = R.styleable.lbVerticalGridView_columnWidth;
        if (typedArray.peekValue(i5) != null) {
            setColumnWidth(typedArray.getLayoutDimension(i5, 0));
        }
    }

    public void setNumColumns(int i5) {
        this.mLayoutManager.setNumRows(i5);
        requestLayout();
    }

    public VerticalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalGridView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mLayoutManager.setOrientation(1);
        initAttributes(context, attributeSet);
    }

    public void setColumnWidth(int i5) {
        this.mLayoutManager.setRowHeight(i5);
        requestLayout();
    }
}
