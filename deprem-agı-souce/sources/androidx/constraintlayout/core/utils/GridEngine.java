package androidx.constraintlayout.core.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GridEngine {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int VERTICAL = 1;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    private int mNextAvailableIndex = 0;
    private int mNumWidgets;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    private String mStrSkips;
    private String mStrSpans;

    public GridEngine() {
    }

    private void addAllConstraintPositions() {
        for (int i5 = 0; i5 < this.mNumWidgets; i5++) {
            if (leftOfWidget(i5) == -1) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition != -1) {
                    addConstraintPosition(i5, rowByIndex, colByIndex, 1, 1);
                } else {
                    return;
                }
            }
        }
    }

    private void addConstraintPosition(int i5, int i6, int i7, int i8, int i9) {
        int[] iArr = this.mConstraintMatrix[i5];
        iArr[0] = i7;
        iArr[1] = i6;
        iArr[2] = (i7 + i9) - 1;
        iArr[3] = (i6 + i8) - 1;
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
        String str = this.mStrSkips;
        if (!(str == null || str.trim().isEmpty() || (parseSpans2 = parseSpans(this.mStrSkips)) == null)) {
            handleSkips(parseSpans2);
        }
        String str2 = this.mStrSpans;
        if (!(str2 == null || str2.trim().isEmpty() || (parseSpans = parseSpans(this.mStrSpans)) == null)) {
            handleSpans(parseSpans);
        }
        addAllConstraintPositions();
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
        int i5 = 0;
        while (i5 < iArr.length) {
            int rowByIndex = getRowByIndex(iArr[i5][0]);
            int colByIndex = getColByIndex(iArr[i5][0]);
            int[] iArr2 = iArr[i5];
            if (invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                i5++;
            } else {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        int i5 = 0;
        while (i5 < iArr.length) {
            int rowByIndex = getRowByIndex(iArr[i5][0]);
            int colByIndex = getColByIndex(iArr[i5][0]);
            int[] iArr2 = iArr[i5];
            if (invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                int[] iArr3 = iArr[i5];
                addConstraintPosition(i5, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
                i5++;
            } else {
                return;
            }
        }
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
        int i6 = this.mNumWidgets;
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

    private boolean isSpansValid(CharSequence charSequence) {
        return charSequence != null;
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

    private void updateActualRowsAndColumns() {
        int i5;
        int i6 = this.mRowsSet;
        if (i6 == 0 || (i5 = this.mColumnsSet) == 0) {
            int i7 = this.mColumnsSet;
            if (i7 > 0) {
                this.mColumns = i7;
                this.mRows = ((this.mNumWidgets + i7) - 1) / i7;
            } else if (i6 > 0) {
                this.mRows = i6;
                this.mColumns = ((this.mNumWidgets + i6) - 1) / i6;
            } else {
                int sqrt = (int) (Math.sqrt((double) this.mNumWidgets) + 1.5d);
                this.mRows = sqrt;
                this.mColumns = ((this.mNumWidgets + sqrt) - 1) / sqrt;
            }
        } else {
            this.mRows = i6;
            this.mColumns = i5;
        }
    }

    public int bottomOfWidget(int i5) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i5 >= iArr.length) {
            return 0;
        }
        return iArr[i5][3];
    }

    public int leftOfWidget(int i5) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i5 >= iArr.length) {
            return 0;
        }
        return iArr[i5][0];
    }

    public int rightOfWidget(int i5) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i5 >= iArr.length) {
            return 0;
        }
        return iArr[i5][2];
    }

    public void setColumns(int i5) {
        if (i5 <= 50 && this.mColumnsSet != i5) {
            this.mColumnsSet = i5;
            updateActualRowsAndColumns();
        }
    }

    public void setNumWidgets(int i5) {
        if (i5 <= this.mRows * this.mColumns) {
            this.mNumWidgets = i5;
        }
    }

    public void setOrientation(int i5) {
        if ((i5 == 0 || i5 == 1) && this.mOrientation != i5) {
            this.mOrientation = i5;
        }
    }

    public void setRows(int i5) {
        if (i5 <= 50 && this.mRowsSet != i5) {
            this.mRowsSet = i5;
            updateActualRowsAndColumns();
        }
    }

    public void setSkips(String str) {
        String str2 = this.mStrSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mStrSkips = str;
        }
    }

    public void setSpans(CharSequence charSequence) {
        String str = this.mStrSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mStrSpans = charSequence.toString();
        }
    }

    public void setup() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z4 = false;
        if (iArr != null && iArr.length == this.mNumWidgets && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z4 = true;
        }
        if (!z4) {
            initVariables();
        }
        fillConstraintMatrix(z4);
    }

    public int topOfWidget(int i5) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i5 >= iArr.length) {
            return 0;
        }
        return iArr[i5][1];
    }

    public GridEngine(int i5, int i6) {
        this.mRowsSet = i5;
        this.mColumnsSet = i6;
        if (i5 > 50) {
            this.mRowsSet = 3;
        }
        if (i6 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initVariables();
    }

    public GridEngine(int i5, int i6, int i7) {
        this.mRowsSet = i5;
        this.mColumnsSet = i6;
        this.mNumWidgets = i7;
        if (i5 > 50) {
            this.mRowsSet = 3;
        }
        if (i6 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        int i8 = this.mRows;
        int i9 = this.mColumns;
        if (i7 > i8 * i9 || i7 < 1) {
            this.mNumWidgets = i8 * i9;
        }
        initVariables();
        fillConstraintMatrix(false);
    }
}
