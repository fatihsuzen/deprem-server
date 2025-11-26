package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.core.internal.view.SupportMenu;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Grid extends VirtualLayout {
    private static final boolean DEBUG_BOXES = false;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "Grid";
    public static final int VERTICAL = 1;
    private int[] mBoxViewIds;
    private View[] mBoxViews;
    private int mColumns;
    private int mColumnsSet;
    ConstraintLayout mContainer;
    private float mHorizontalGaps;
    private final int mMaxColumns = 50;
    private final int mMaxRows = 50;
    private int mNextAvailableIndex = 0;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    Set<Integer> mSpanIds = new HashSet();
    private String mStrColumnWeights;
    private String mStrRowWeights;
    private String mStrSkips;
    private String mStrSpans;
    private boolean mUseRtl;
    private boolean mValidateInputs;
    private float mVerticalGaps;

    public Grid(Context context) {
        super(context);
    }

    private boolean arrangeWidgets() {
        View[] views = getViews(this.mContainer);
        for (int i5 = 0; i5 < this.mCount; i5++) {
            if (!this.mSpanIds.contains(Integer.valueOf(this.mIds[i5]))) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return false;
                }
                connectView(views[i5], rowByIndex, colByIndex, 1, 1);
            }
        }
        return true;
    }

    private void buildBoxes() {
        int max = Math.max(this.mRows, this.mColumns);
        View[] viewArr = this.mBoxViews;
        int i5 = 0;
        if (viewArr == null) {
            this.mBoxViews = new View[max];
            int i6 = 0;
            while (true) {
                View[] viewArr2 = this.mBoxViews;
                if (i6 >= viewArr2.length) {
                    break;
                }
                viewArr2[i6] = makeNewView();
                i6++;
            }
        } else if (max != viewArr.length) {
            View[] viewArr3 = new View[max];
            for (int i7 = 0; i7 < max; i7++) {
                View[] viewArr4 = this.mBoxViews;
                if (i7 < viewArr4.length) {
                    viewArr3[i7] = viewArr4[i7];
                } else {
                    viewArr3[i7] = makeNewView();
                }
            }
            int i8 = max;
            while (true) {
                View[] viewArr5 = this.mBoxViews;
                if (i8 >= viewArr5.length) {
                    break;
                }
                this.mContainer.removeView(viewArr5[i8]);
                i8++;
            }
            this.mBoxViews = viewArr3;
        }
        this.mBoxViewIds = new int[max];
        while (true) {
            View[] viewArr6 = this.mBoxViews;
            if (i5 < viewArr6.length) {
                this.mBoxViewIds[i5] = viewArr6[i5].getId();
                i5++;
            } else {
                setBoxViewVerticalChains();
                setBoxViewHorizontalChains();
                return;
            }
        }
    }

    private void clearHParams(View view) {
        ConstraintLayout.LayoutParams params = params(view);
        params.horizontalWeight = -1.0f;
        params.leftToRight = -1;
        params.leftToLeft = -1;
        params.rightToLeft = -1;
        params.rightToRight = -1;
        params.leftMargin = -1;
        view.setLayoutParams(params);
    }

    private void clearVParams(View view) {
        ConstraintLayout.LayoutParams params = params(view);
        params.verticalWeight = -1.0f;
        params.topToBottom = -1;
        params.topToTop = -1;
        params.bottomToTop = -1;
        params.bottomToBottom = -1;
        params.topMargin = -1;
        view.setLayoutParams(params);
    }

    private void connectView(View view, int i5, int i6, int i7, int i8) {
        ConstraintLayout.LayoutParams params = params(view);
        int[] iArr = this.mBoxViewIds;
        params.leftToLeft = iArr[i6];
        params.topToTop = iArr[i5];
        params.rightToRight = iArr[(i6 + i8) - 1];
        params.bottomToBottom = iArr[(i5 + i7) - 1];
        view.setLayoutParams(params);
    }

    private boolean generateGrid(boolean z4) {
        boolean z5;
        int[][] parseSpans;
        int[][] parseSpans2;
        if (this.mContainer == null || this.mRows < 1 || this.mColumns < 1) {
            return false;
        }
        if (z4) {
            for (int i5 = 0; i5 < this.mPositionMatrix.length; i5++) {
                int i6 = 0;
                while (true) {
                    boolean[][] zArr = this.mPositionMatrix;
                    if (i6 >= zArr[0].length) {
                        break;
                    }
                    zArr[i5][i6] = true;
                    i6++;
                }
            }
            this.mSpanIds.clear();
        }
        this.mNextAvailableIndex = 0;
        buildBoxes();
        String str = this.mStrSkips;
        if (str == null || str.trim().isEmpty() || (parseSpans2 = parseSpans(this.mStrSkips)) == null) {
            z5 = true;
        } else {
            z5 = handleSkips(parseSpans2);
        }
        String str2 = this.mStrSpans;
        if (!(str2 == null || str2.trim().isEmpty() || (parseSpans = parseSpans(this.mStrSpans)) == null)) {
            z5 &= handleSpans(this.mIds, parseSpans);
        }
        if ((z5 && arrangeWidgets()) || !this.mValidateInputs) {
            return true;
        }
        return false;
    }

    private int getColByIndex(int i5) {
        if (this.mOrientation == 1) {
            return i5 / this.mRows;
        }
        return i5 % this.mColumns;
    }

    private int getNextPosition() {
        boolean z4 = false;
        int i5 = 0;
        while (!z4) {
            i5 = this.mNextAvailableIndex;
            if (i5 >= this.mRows * this.mColumns) {
                return -1;
            }
            int rowByIndex = getRowByIndex(i5);
            int colByIndex = getColByIndex(this.mNextAvailableIndex);
            boolean[] zArr = this.mPositionMatrix[rowByIndex];
            if (zArr[colByIndex]) {
                zArr[colByIndex] = false;
                z4 = true;
            }
            this.mNextAvailableIndex++;
        }
        return i5;
    }

    private int getRowByIndex(int i5) {
        if (this.mOrientation == 1) {
            return i5 % this.mRows;
        }
        return i5 / this.mColumns;
    }

    private boolean handleSkips(int[][] iArr) {
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int rowByIndex = getRowByIndex(iArr[i5][0]);
            int colByIndex = getColByIndex(iArr[i5][0]);
            int[] iArr2 = iArr[i5];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return false;
            }
        }
        return true;
    }

    private boolean handleSpans(int[] iArr, int[][] iArr2) {
        View[] views = getViews(this.mContainer);
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            int rowByIndex = getRowByIndex(iArr2[i5][0]);
            int colByIndex = getColByIndex(iArr2[i5][0]);
            int[] iArr3 = iArr2[i5];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr3[1], iArr3[2])) {
                return false;
            }
            View view = views[i5];
            int[] iArr4 = iArr2[i5];
            int i6 = iArr4[1];
            int i7 = iArr4[2];
            connectView(view, rowByIndex, colByIndex, i6, i7);
            this.mSpanIds.add(Integer.valueOf(iArr[i5]));
        }
        return true;
    }

    private void initVariables() {
        int i5 = this.mRows;
        int[] iArr = new int[2];
        iArr[1] = this.mColumns;
        iArr[0] = i5;
        boolean[][] zArr = (boolean[][]) Array.newInstance(Boolean.TYPE, iArr);
        this.mPositionMatrix = zArr;
        for (boolean[] fill : zArr) {
            Arrays.fill(fill, true);
        }
    }

    private boolean invalidatePositions(int i5, int i6, int i7, int i8) {
        for (int i9 = i5; i9 < i5 + i7; i9++) {
            int i10 = i6;
            while (i10 < i6 + i8) {
                boolean[][] zArr = this.mPositionMatrix;
                if (i9 < zArr.length && i10 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i9];
                    if (zArr2[i10]) {
                        zArr2[i10] = false;
                        i10++;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isSpansValid(CharSequence charSequence) {
        return true;
    }

    private boolean isWeightsValid(String str) {
        return true;
    }

    private View makeNewView() {
        View view = new View(getContext());
        view.setId(View.generateViewId());
        view.setVisibility(4);
        this.mContainer.addView(view, new ConstraintLayout.LayoutParams(0, 0));
        return view;
    }

    private ConstraintLayout.LayoutParams params(View view) {
        return (ConstraintLayout.LayoutParams) view.getLayoutParams();
    }

    private int[][] parseSpans(String str) {
        if (!isSpansValid(str)) {
            return null;
        }
        String[] split = str.split(",");
        int length = split.length;
        int[] iArr = new int[2];
        iArr[1] = 3;
        iArr[0] = length;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i5 = 0; i5 < split.length; i5++) {
            String[] split2 = split[i5].trim().split(":");
            String[] split3 = split2[1].split("x");
            iArr2[i5][0] = Integer.parseInt(split2[0]);
            iArr2[i5][1] = Integer.parseInt(split3[0]);
            iArr2[i5][2] = Integer.parseInt(split3[1]);
        }
        return iArr2;
    }

    private float[] parseWeights(int i5, String str) {
        float[] fArr = null;
        if (str != null && !str.trim().isEmpty()) {
            String[] split = str.split(",");
            if (split.length != i5) {
                return null;
            }
            fArr = new float[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                fArr[i6] = Float.parseFloat(split[i6].trim());
            }
        }
        return fArr;
    }

    private void setBoxViewHorizontalChains() {
        int i5;
        int id = getId();
        int max = Math.max(this.mRows, this.mColumns);
        float[] parseWeights = parseWeights(this.mColumns, this.mStrColumnWeights);
        int i6 = 0;
        ConstraintLayout.LayoutParams params = params(this.mBoxViews[0]);
        if (this.mColumns == 1) {
            clearHParams(this.mBoxViews[0]);
            params.leftToLeft = id;
            params.rightToRight = id;
            this.mBoxViews[0].setLayoutParams(params);
            return;
        }
        while (true) {
            i5 = this.mColumns;
            if (i6 >= i5) {
                break;
            }
            ConstraintLayout.LayoutParams params2 = params(this.mBoxViews[i6]);
            clearHParams(this.mBoxViews[i6]);
            if (parseWeights != null) {
                params2.horizontalWeight = parseWeights[i6];
            }
            if (i6 > 0) {
                params2.leftToRight = this.mBoxViewIds[i6 - 1];
            } else {
                params2.leftToLeft = id;
            }
            if (i6 < this.mColumns - 1) {
                params2.rightToLeft = this.mBoxViewIds[i6 + 1];
            } else {
                params2.rightToRight = id;
            }
            if (i6 > 0) {
                params2.leftMargin = (int) this.mHorizontalGaps;
            }
            this.mBoxViews[i6].setLayoutParams(params2);
            i6++;
        }
        while (i5 < max) {
            ConstraintLayout.LayoutParams params3 = params(this.mBoxViews[i5]);
            clearHParams(this.mBoxViews[i5]);
            params3.leftToLeft = id;
            params3.rightToRight = id;
            this.mBoxViews[i5].setLayoutParams(params3);
            i5++;
        }
    }

    private void setBoxViewVerticalChains() {
        int i5;
        int id = getId();
        int max = Math.max(this.mRows, this.mColumns);
        float[] parseWeights = parseWeights(this.mRows, this.mStrRowWeights);
        int i6 = 0;
        if (this.mRows == 1) {
            ConstraintLayout.LayoutParams params = params(this.mBoxViews[0]);
            clearVParams(this.mBoxViews[0]);
            params.topToTop = id;
            params.bottomToBottom = id;
            this.mBoxViews[0].setLayoutParams(params);
            return;
        }
        while (true) {
            i5 = this.mRows;
            if (i6 >= i5) {
                break;
            }
            ConstraintLayout.LayoutParams params2 = params(this.mBoxViews[i6]);
            clearVParams(this.mBoxViews[i6]);
            if (parseWeights != null) {
                params2.verticalWeight = parseWeights[i6];
            }
            if (i6 > 0) {
                params2.topToBottom = this.mBoxViewIds[i6 - 1];
            } else {
                params2.topToTop = id;
            }
            if (i6 < this.mRows - 1) {
                params2.bottomToTop = this.mBoxViewIds[i6 + 1];
            } else {
                params2.bottomToBottom = id;
            }
            if (i6 > 0) {
                params2.topMargin = (int) this.mHorizontalGaps;
            }
            this.mBoxViews[i6].setLayoutParams(params2);
            i6++;
        }
        while (i5 < max) {
            ConstraintLayout.LayoutParams params3 = params(this.mBoxViews[i5]);
            clearVParams(this.mBoxViews[i5]);
            params3.topToTop = id;
            params3.bottomToBottom = id;
            this.mBoxViews[i5].setLayoutParams(params3);
            i5++;
        }
    }

    private void updateActualRowsAndColumns() {
        int i5;
        int i6 = this.mRowsSet;
        if (i6 == 0 || (i5 = this.mColumnsSet) == 0) {
            int i7 = this.mColumnsSet;
            if (i7 > 0) {
                this.mColumns = i7;
                this.mRows = ((this.mCount + i7) - 1) / i7;
            } else if (i6 > 0) {
                this.mRows = i6;
                this.mColumns = ((this.mCount + i6) - 1) / i6;
            } else {
                int sqrt = (int) (Math.sqrt((double) this.mCount) + 1.5d);
                this.mRows = sqrt;
                this.mColumns = ((this.mCount + sqrt) - 1) / sqrt;
            }
        } else {
            this.mRows = i6;
            this.mColumns = i5;
        }
    }

    public String getColumnWeights() {
        return this.mStrColumnWeights;
    }

    public int getColumns() {
        return this.mColumnsSet;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public String getRowWeights() {
        return this.mStrRowWeights;
    }

    public int getRows() {
        return this.mRowsSet;
    }

    public String getSkips() {
        return this.mStrSkips;
    }

    public String getSpans() {
        return this.mStrSpans;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Grid);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.Grid_grid_rows) {
                    this.mRowsSet = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_columns) {
                    this.mColumnsSet = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_spans) {
                    this.mStrSpans = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_skips) {
                    this.mStrSkips = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_rowWeights) {
                    this.mStrRowWeights = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_columnWeights) {
                    this.mStrColumnWeights = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_orientation) {
                    this.mOrientation = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.Grid_grid_horizontalGaps) {
                    this.mHorizontalGaps = obtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R.styleable.Grid_grid_verticalGaps) {
                    this.mVerticalGaps = obtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R.styleable.Grid_grid_validateInputs) {
                    this.mValidateInputs = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == R.styleable.Grid_grid_useRtl) {
                    this.mUseRtl = obtainStyledAttributes.getBoolean(index, false);
                }
            }
            updateActualRowsAndColumns();
            initVariables();
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        generateGrid(false);
    }

    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode()) {
            return;
        }
        Paint paint = new Paint();
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStyle(Paint.Style.STROKE);
        int top = getTop();
        int left = getLeft();
        int bottom = getBottom();
        int right = getRight();
        for (View view : this.mBoxViews) {
            int top2 = view.getTop() - top;
            int bottom2 = view.getBottom() - top;
            canvas.drawRect((float) (view.getLeft() - left), 0.0f, (float) (view.getRight() - left), (float) (bottom - top), paint);
            canvas.drawRect(0.0f, (float) top2, (float) (right - left), (float) bottom2, paint);
        }
    }

    public void setColumnWeights(String str) {
        if (isWeightsValid(str)) {
            String str2 = this.mStrColumnWeights;
            if (str2 == null || !str2.equals(str)) {
                this.mStrColumnWeights = str;
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setColumns(int i5) {
        if (i5 <= 50 && this.mColumnsSet != i5) {
            this.mColumnsSet = i5;
            updateActualRowsAndColumns();
            initVariables();
            generateGrid(false);
            invalidate();
        }
    }

    public void setHorizontalGaps(float f5) {
        if (f5 >= 0.0f && this.mHorizontalGaps != f5) {
            this.mHorizontalGaps = f5;
            generateGrid(true);
            invalidate();
        }
    }

    public void setOrientation(int i5) {
        if ((i5 == 0 || i5 == 1) && this.mOrientation != i5) {
            this.mOrientation = i5;
            generateGrid(true);
            invalidate();
        }
    }

    public void setRowWeights(String str) {
        if (isWeightsValid(str)) {
            String str2 = this.mStrRowWeights;
            if (str2 == null || !str2.equals(str)) {
                this.mStrRowWeights = str;
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setRows(int i5) {
        if (i5 <= 50 && this.mRowsSet != i5) {
            this.mRowsSet = i5;
            updateActualRowsAndColumns();
            initVariables();
            generateGrid(false);
            invalidate();
        }
    }

    public void setSkips(String str) {
        if (isSpansValid(str)) {
            String str2 = this.mStrSkips;
            if (str2 == null || !str2.equals(str)) {
                this.mStrSkips = str;
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setSpans(CharSequence charSequence) {
        if (isSpansValid(charSequence)) {
            String str = this.mStrSpans;
            if (str == null || !str.contentEquals(charSequence)) {
                this.mStrSpans = charSequence.toString();
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setVerticalGaps(float f5) {
        if (f5 >= 0.0f && this.mVerticalGaps != f5) {
            this.mVerticalGaps = f5;
            generateGrid(true);
            invalidate();
        }
    }

    public Grid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Grid(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
