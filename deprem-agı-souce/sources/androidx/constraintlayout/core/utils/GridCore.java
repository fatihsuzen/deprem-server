package androidx.constraintlayout.core.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GridCore extends VirtualLayout {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int SPANS_RESPECT_WIDGET_ORDER = 2;
    public static final int SUB_GRID_BY_COL_ROW = 1;
    public static final int VERTICAL = 1;
    private ConstraintWidget[] mBoxWidgets;
    private String mColumnWeights;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    ConstraintWidgetContainer mContainer;
    private boolean mExtraSpaceHandled = false;
    private int mFlags;
    private float mHorizontalGaps;
    private int mNextAvailableIndex = 0;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private String mRowWeights;
    private int mRows;
    private int mRowsSet;
    private String mSkips;
    Set<String> mSpanIds = new HashSet();
    private int mSpanIndex = 0;
    private int[][] mSpanMatrix;
    private String mSpans;
    private float mVerticalGaps;

    public GridCore() {
        updateActualRowsAndColumns();
        initMatrices();
    }

    public static /* synthetic */ int a(String str, String str2) {
        return Integer.parseInt(str.split(":")[0]) - Integer.parseInt(str2.split(":")[0]);
    }

    private void addConstraints() {
        setBoxWidgetVerticalChains();
        setBoxWidgetHorizontalChains();
        arrangeWidgets();
    }

    private void arrangeWidgets() {
        int[][] iArr;
        int i5;
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            if (!this.mSpanIds.contains(this.mWidgets[i6].stringId)) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition != -1) {
                    if (isSpansRespectWidgetOrder() && (iArr = this.mSpanMatrix) != null && (i5 = this.mSpanIndex) < iArr.length) {
                        int[] iArr2 = iArr[i5];
                        if (iArr2[0] == nextPosition) {
                            this.mPositionMatrix[rowByIndex][colByIndex] = true;
                            if (invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                                ConstraintWidget constraintWidget = this.mWidgets[i6];
                                int[] iArr3 = this.mSpanMatrix[this.mSpanIndex];
                                int i7 = iArr3[1];
                                int i8 = iArr3[2];
                                connectWidget(constraintWidget, rowByIndex, colByIndex, i7, i8);
                                this.mSpanIndex++;
                            }
                        }
                    }
                    connectWidget(this.mWidgets[i6], rowByIndex, colByIndex, 1, 1);
                } else {
                    return;
                }
            }
        }
    }

    private void clearHorizontalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setHorizontalWeight(-1.0f);
        constraintWidget.mLeft.reset();
        constraintWidget.mRight.reset();
    }

    private void clearVerticalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setVerticalWeight(-1.0f);
        constraintWidget.mTop.reset();
        constraintWidget.mBottom.reset();
        constraintWidget.mBaseline.reset();
    }

    private void connectWidget(ConstraintWidget constraintWidget, int i5, int i6, int i7, int i8) {
        constraintWidget.mLeft.connect(this.mBoxWidgets[i6].mLeft, 0);
        constraintWidget.mTop.connect(this.mBoxWidgets[i5].mTop, 0);
        constraintWidget.mRight.connect(this.mBoxWidgets[(i6 + i8) - 1].mRight, 0);
        constraintWidget.mBottom.connect(this.mBoxWidgets[(i5 + i7) - 1].mBottom, 0);
    }

    private void createBoxes() {
        int max = Math.max(this.mRows, this.mColumns);
        ConstraintWidget[] constraintWidgetArr = this.mBoxWidgets;
        int i5 = 0;
        if (constraintWidgetArr == null) {
            this.mBoxWidgets = new ConstraintWidget[max];
            while (true) {
                ConstraintWidget[] constraintWidgetArr2 = this.mBoxWidgets;
                if (i5 < constraintWidgetArr2.length) {
                    constraintWidgetArr2[i5] = makeNewWidget();
                    i5++;
                } else {
                    return;
                }
            }
        } else if (max != constraintWidgetArr.length) {
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[max];
            while (i5 < max) {
                ConstraintWidget[] constraintWidgetArr4 = this.mBoxWidgets;
                if (i5 < constraintWidgetArr4.length) {
                    constraintWidgetArr3[i5] = constraintWidgetArr4[i5];
                } else {
                    constraintWidgetArr3[i5] = makeNewWidget();
                }
                i5++;
            }
            while (true) {
                ConstraintWidget[] constraintWidgetArr5 = this.mBoxWidgets;
                if (max < constraintWidgetArr5.length) {
                    this.mContainer.remove(constraintWidgetArr5[max]);
                    max++;
                } else {
                    this.mBoxWidgets = constraintWidgetArr3;
                    return;
                }
            }
        }
    }

    private void fillConstraintMatrix(boolean z4) {
        int[][] parseSpans;
        int[][] parseSpans2;
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
            for (int i7 = 0; i7 < this.mConstraintMatrix.length; i7++) {
                int i8 = 0;
                while (true) {
                    int[][] iArr = this.mConstraintMatrix;
                    if (i8 >= iArr[0].length) {
                        break;
                    }
                    iArr[i7][i8] = -1;
                    i8++;
                }
            }
        }
        this.mNextAvailableIndex = 0;
        String str = this.mSkips;
        if (!(str == null || str.trim().isEmpty() || (parseSpans2 = parseSpans(this.mSkips, false)) == null)) {
            handleSkips(parseSpans2);
        }
        String str2 = this.mSpans;
        if (str2 != null && !str2.trim().isEmpty() && (parseSpans = parseSpans(this.mSpans, true)) != null) {
            handleSpans(parseSpans);
        }
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

    private void handleSkips(int[][] iArr) {
        int length = iArr.length;
        int i5 = 0;
        while (i5 < length) {
            int[] iArr2 = iArr[i5];
            if (invalidatePositions(getRowByIndex(iArr2[0]), getColByIndex(iArr2[0]), iArr2[1], iArr2[2])) {
                i5++;
            } else {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        if (!isSpansRespectWidgetOrder()) {
            for (int i5 = 0; i5 < iArr.length; i5++) {
                int rowByIndex = getRowByIndex(iArr[i5][0]);
                int colByIndex = getColByIndex(iArr[i5][0]);
                int[] iArr2 = iArr[i5];
                if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i5];
                int[] iArr3 = iArr[i5];
                connectWidget(constraintWidget, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
                this.mSpanIds.add(this.mWidgets[i5].stringId);
            }
        }
    }

    private void initMatrices() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z4 = false;
        if (iArr != null && iArr.length == this.mWidgetsCount && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z4 = true;
        }
        if (!z4) {
            initVariables();
        }
        fillConstraintMatrix(z4);
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
        int i6 = this.mWidgetsCount;
        if (i6 > 0) {
            int[] iArr2 = new int[2];
            iArr2[1] = 4;
            iArr2[0] = i6;
            int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, iArr2);
            this.mConstraintMatrix = iArr3;
            for (int[] fill2 : iArr3) {
                Arrays.fill(fill2, -1);
            }
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

    private boolean isSpansRespectWidgetOrder() {
        if ((this.mFlags & 2) > 0) {
            return true;
        }
        return false;
    }

    private boolean isSubGridByColRow() {
        if ((this.mFlags & 1) > 0) {
            return true;
        }
        return false;
    }

    private ConstraintWidget makeNewWidget() {
        ConstraintWidget constraintWidget = new ConstraintWidget();
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        constraintWidget.stringId = String.valueOf(constraintWidget.hashCode());
        return constraintWidget;
    }

    private int[][] parseSpans(String str, boolean z4) {
        try {
            String[] split = str.split(",");
            Arrays.sort(split, new a());
            int length = split.length;
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = length;
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            if (this.mRows != 1) {
                if (this.mColumns != 1) {
                    for (int i5 = 0; i5 < split.length; i5++) {
                        String[] split2 = split[i5].trim().split(":");
                        String[] split3 = split2[1].split("x");
                        iArr2[i5][0] = Integer.parseInt(split2[0]);
                        if (isSubGridByColRow()) {
                            iArr2[i5][1] = Integer.parseInt(split3[1]);
                            iArr2[i5][2] = Integer.parseInt(split3[0]);
                        } else {
                            iArr2[i5][1] = Integer.parseInt(split3[0]);
                            iArr2[i5][2] = Integer.parseInt(split3[1]);
                        }
                    }
                    return iArr2;
                }
            }
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < split.length; i8++) {
                String[] split4 = split[i8].trim().split(":");
                iArr2[i8][0] = Integer.parseInt(split4[0]);
                int[] iArr3 = iArr2[i8];
                iArr3[1] = 1;
                iArr3[2] = 1;
                if (this.mColumns == 1) {
                    iArr3[1] = Integer.parseInt(split4[1]);
                    i6 += iArr2[i8][1];
                    if (z4) {
                        i6--;
                    }
                }
                if (this.mRows == 1) {
                    iArr2[i8][2] = Integer.parseInt(split4[1]);
                    i7 += iArr2[i8][2];
                    if (z4) {
                        i7--;
                    }
                }
            }
            if (i6 != 0 && !this.mExtraSpaceHandled) {
                setRows(this.mRows + i6);
            }
            if (i7 != 0 && !this.mExtraSpaceHandled) {
                setColumns(this.mColumns + i7);
            }
            this.mExtraSpaceHandled = true;
            return iArr2;
        } catch (Exception unused) {
            return null;
        }
    }

    private float[] parseWeights(int i5, String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] split = str.split(",");
        float[] fArr = new float[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 < split.length) {
                try {
                    fArr[i6] = Float.parseFloat(split[i6]);
                } catch (Exception e5) {
                    PrintStream printStream = System.err;
                    printStream.println("Error parsing `" + split[i6] + "`: " + e5.getMessage());
                    fArr[i6] = 1.0f;
                }
            } else {
                fArr[i6] = 1.0f;
            }
        }
        return fArr;
    }

    private void setBoxWidgetHorizontalChains() {
        int i5;
        int max = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] parseWeights = parseWeights(this.mColumns, this.mColumnWeights);
        if (this.mColumns == 1) {
            clearHorizontalAttributes(constraintWidget);
            constraintWidget.mLeft.connect(this.mLeft, 0);
            constraintWidget.mRight.connect(this.mRight, 0);
            return;
        }
        int i6 = 0;
        while (true) {
            i5 = this.mColumns;
            if (i6 >= i5) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i6];
            clearHorizontalAttributes(constraintWidget2);
            if (parseWeights != null) {
                constraintWidget2.setHorizontalWeight(parseWeights[i6]);
            }
            if (i6 > 0) {
                constraintWidget2.mLeft.connect(this.mBoxWidgets[i6 - 1].mRight, 0);
            } else {
                constraintWidget2.mLeft.connect(this.mLeft, 0);
            }
            if (i6 < this.mColumns - 1) {
                constraintWidget2.mRight.connect(this.mBoxWidgets[i6 + 1].mLeft, 0);
            } else {
                constraintWidget2.mRight.connect(this.mRight, 0);
            }
            if (i6 > 0) {
                constraintWidget2.mLeft.mMargin = (int) this.mHorizontalGaps;
            }
            i6++;
        }
        while (i5 < max) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i5];
            clearHorizontalAttributes(constraintWidget3);
            constraintWidget3.mLeft.connect(this.mLeft, 0);
            constraintWidget3.mRight.connect(this.mRight, 0);
            i5++;
        }
    }

    private void setBoxWidgetVerticalChains() {
        int i5;
        int max = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] parseWeights = parseWeights(this.mRows, this.mRowWeights);
        if (this.mRows == 1) {
            clearVerticalAttributes(constraintWidget);
            constraintWidget.mTop.connect(this.mTop, 0);
            constraintWidget.mBottom.connect(this.mBottom, 0);
            return;
        }
        int i6 = 0;
        while (true) {
            i5 = this.mRows;
            if (i6 >= i5) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i6];
            clearVerticalAttributes(constraintWidget2);
            if (parseWeights != null) {
                constraintWidget2.setVerticalWeight(parseWeights[i6]);
            }
            if (i6 > 0) {
                constraintWidget2.mTop.connect(this.mBoxWidgets[i6 - 1].mBottom, 0);
            } else {
                constraintWidget2.mTop.connect(this.mTop, 0);
            }
            if (i6 < this.mRows - 1) {
                constraintWidget2.mBottom.connect(this.mBoxWidgets[i6 + 1].mTop, 0);
            } else {
                constraintWidget2.mBottom.connect(this.mBottom, 0);
            }
            if (i6 > 0) {
                constraintWidget2.mTop.mMargin = (int) this.mVerticalGaps;
            }
            i6++;
        }
        while (i5 < max) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i5];
            clearVerticalAttributes(constraintWidget3);
            constraintWidget3.mTop.connect(this.mTop, 0);
            constraintWidget3.mBottom.connect(this.mBottom, 0);
            i5++;
        }
    }

    private void setupGrid(boolean z4) {
        int[][] parseSpans;
        if (this.mRows >= 1 && this.mColumns >= 1) {
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
            String str = this.mSkips;
            if (!(str == null || str.trim().isEmpty() || (parseSpans = parseSpans(this.mSkips, false)) == null)) {
                handleSkips(parseSpans);
            }
            String str2 = this.mSpans;
            if (str2 != null && !str2.trim().isEmpty()) {
                this.mSpanMatrix = parseSpans(this.mSpans, true);
            }
            createBoxes();
            int[][] iArr = this.mSpanMatrix;
            if (iArr != null) {
                handleSpans(iArr);
            }
        }
    }

    private void updateActualRowsAndColumns() {
        int i5;
        int i6 = this.mRowsSet;
        if (i6 == 0 || (i5 = this.mColumnsSet) == 0) {
            int i7 = this.mColumnsSet;
            if (i7 > 0) {
                this.mColumns = i7;
                this.mRows = ((this.mWidgetsCount + i7) - 1) / i7;
            } else if (i6 > 0) {
                this.mRows = i6;
                this.mColumns = ((this.mWidgetsCount + i6) - 1) / i6;
            } else {
                int sqrt = (int) (Math.sqrt((double) this.mWidgetsCount) + 1.5d);
                this.mRows = sqrt;
                this.mColumns = ((this.mWidgetsCount + sqrt) - 1) / sqrt;
            }
        } else {
            this.mRows = i6;
            this.mColumns = i5;
        }
    }

    public void addToSolver(@Nullable LinearSystem linearSystem, boolean z4) {
        super.addToSolver(linearSystem, z4);
        addConstraints();
    }

    @Nullable
    public String getColumnWeights() {
        return this.mColumnWeights;
    }

    @Nullable
    public ConstraintWidgetContainer getContainer() {
        return this.mContainer;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Nullable
    public String getRowWeights() {
        return this.mRowWeights;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    public void measure(int i5, int i6, int i7, int i8) {
        super.measure(i5, i6, i7, i8);
        this.mContainer = (ConstraintWidgetContainer) getParent();
        setupGrid(false);
        this.mContainer.add(this.mBoxWidgets);
    }

    public void setColumnWeights(@NonNull String str) {
        String str2 = this.mColumnWeights;
        if (str2 == null || !str2.equals(str)) {
            this.mColumnWeights = str;
        }
    }

    public void setColumns(int i5) {
        if (i5 <= 50 && this.mColumnsSet != i5) {
            this.mColumnsSet = i5;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setContainer(@NonNull ConstraintWidgetContainer constraintWidgetContainer) {
        this.mContainer = constraintWidgetContainer;
    }

    public void setFlags(int i5) {
        this.mFlags = i5;
    }

    public void setHorizontalGaps(float f5) {
        if (f5 >= 0.0f && this.mHorizontalGaps != f5) {
            this.mHorizontalGaps = f5;
        }
    }

    public void setOrientation(int i5) {
        if ((i5 == 0 || i5 == 1) && this.mOrientation != i5) {
            this.mOrientation = i5;
        }
    }

    public void setRowWeights(@NonNull String str) {
        String str2 = this.mRowWeights;
        if (str2 == null || !str2.equals(str)) {
            this.mRowWeights = str;
        }
    }

    public void setRows(int i5) {
        if (i5 <= 50 && this.mRowsSet != i5) {
            this.mRowsSet = i5;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setSkips(@NonNull String str) {
        String str2 = this.mSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mExtraSpaceHandled = false;
            this.mSkips = str;
        }
    }

    public void setSpans(@NonNull CharSequence charSequence) {
        String str = this.mSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mExtraSpaceHandled = false;
            this.mSpans = charSequence.toString();
        }
    }

    public void setVerticalGaps(float f5) {
        if (f5 >= 0.0f && this.mVerticalGaps != f5) {
            this.mVerticalGaps = f5;
        }
    }

    public GridCore(int i5, int i6) {
        this.mRowsSet = i5;
        this.mColumnsSet = i6;
        if (i5 > 50) {
            this.mRowsSet = 3;
        }
        if (i6 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initMatrices();
    }
}
