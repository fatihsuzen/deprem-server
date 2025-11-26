package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    static final int NONE = -1;
    private static float sEpsilon = 0.001f;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    protected final Cache mCache;
    private SolverVariable mCandidate = null;
    int mCurrentSize = 0;
    private boolean mDidFillOnce = false;
    private int mHead = -1;
    private int mLast = -1;
    private final ArrayRow mRow;
    private int mRowSize = 8;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    public void add(SolverVariable solverVariable, float f5, boolean z4) {
        float f6 = sEpsilon;
        if (f5 <= (-f6) || f5 >= f6) {
            int i5 = this.mHead;
            if (i5 == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f5;
                this.mArrayIndices[0] = solverVariable.id;
                this.mArrayNextIndices[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.mCurrentSize++;
                if (!this.mDidFillOnce) {
                    int i6 = this.mLast + 1;
                    this.mLast = i6;
                    int[] iArr = this.mArrayIndices;
                    if (i6 >= iArr.length) {
                        this.mDidFillOnce = true;
                        this.mLast = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i7 = 0;
            int i8 = -1;
            while (i5 != -1 && i7 < this.mCurrentSize) {
                int i9 = this.mArrayIndices[i5];
                int i10 = solverVariable.id;
                if (i9 == i10) {
                    float[] fArr = this.mArrayValues;
                    float f7 = fArr[i5] + f5;
                    float f8 = sEpsilon;
                    if (f7 > (-f8) && f7 < f8) {
                        f7 = 0.0f;
                    }
                    fArr[i5] = f7;
                    if (f7 == 0.0f) {
                        if (i5 == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i5];
                        } else {
                            int[] iArr2 = this.mArrayNextIndices;
                            iArr2[i8] = iArr2[i5];
                        }
                        if (z4) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i5;
                        }
                        solverVariable.usageInRowCount--;
                        this.mCurrentSize--;
                        return;
                    }
                    return;
                }
                if (i9 < i10) {
                    i8 = i5;
                }
                i5 = this.mArrayNextIndices[i5];
                i7++;
            }
            int i11 = this.mLast;
            int i12 = i11 + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[i11] != -1) {
                    i11 = iArr3.length;
                }
            } else {
                i11 = i12;
            }
            int[] iArr4 = this.mArrayIndices;
            if (i11 >= iArr4.length && this.mCurrentSize < iArr4.length) {
                int i13 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i13 >= iArr5.length) {
                        break;
                    } else if (iArr5[i13] == -1) {
                        i11 = i13;
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (i11 >= iArr6.length) {
                i11 = iArr6.length;
                int i14 = this.mRowSize * 2;
                this.mRowSize = i14;
                this.mDidFillOnce = false;
                this.mLast = i11 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i14);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
            }
            this.mArrayIndices[i11] = solverVariable.id;
            this.mArrayValues[i11] = f5;
            if (i8 != -1) {
                int[] iArr7 = this.mArrayNextIndices;
                iArr7[i11] = iArr7[i8];
                iArr7[i8] = i11;
            } else {
                this.mArrayNextIndices[i11] = this.mHead;
                this.mHead = i11;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i15 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i15 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    public final void clear() {
        int i5 = this.mHead;
        int i6 = 0;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i5]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mCurrentSize = 0;
    }

    public boolean contains(SolverVariable solverVariable) {
        int i5 = this.mHead;
        if (i5 == -1) {
            return false;
        }
        int i6 = 0;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            if (this.mArrayIndices[i5] == solverVariable.id) {
                return true;
            }
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
        return false;
    }

    public void display() {
        int i5 = this.mCurrentSize;
        System.out.print("{ ");
        for (int i6 = 0; i6 < i5; i6++) {
            SolverVariable variable = getVariable(i6);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i6) + " ");
            }
        }
        System.out.println(" }");
    }

    public void divideByAmount(float f5) {
        int i5 = this.mHead;
        int i6 = 0;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i5] = fArr[i5] / f5;
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
    }

    public final float get(SolverVariable solverVariable) {
        int i5 = this.mHead;
        int i6 = 0;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            if (this.mArrayIndices[i5] == solverVariable.id) {
                return this.mArrayValues[i5];
            }
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.mCurrentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i5) {
        return this.mArrayIndices[i5];
    }

    public final int getNextIndice(int i5) {
        return this.mArrayNextIndices[i5];
    }

    /* access modifiers changed from: package-private */
    public SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.mCandidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i5 = this.mHead;
        int i6 = 0;
        SolverVariable solverVariable2 = null;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            if (this.mArrayValues[i5] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i5]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
        return solverVariable2;
    }

    public final float getValue(int i5) {
        return this.mArrayValues[i5];
    }

    public SolverVariable getVariable(int i5) {
        int i6 = this.mHead;
        int i7 = 0;
        while (i6 != -1 && i7 < this.mCurrentSize) {
            if (i7 == i5) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i6]];
            }
            i6 = this.mArrayNextIndices[i6];
            i7++;
        }
        return null;
    }

    public float getVariableValue(int i5) {
        int i6 = this.mHead;
        int i7 = 0;
        while (i6 != -1 && i7 < this.mCurrentSize) {
            if (i7 == i5) {
                return this.mArrayValues[i6];
            }
            i6 = this.mArrayNextIndices[i6];
            i7++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAtLeastOnePositiveVariable() {
        int i5 = this.mHead;
        int i6 = 0;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            if (this.mArrayValues[i5] > 0.0f) {
                return true;
            }
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
        return false;
    }

    public int indexOf(SolverVariable solverVariable) {
        int i5 = this.mHead;
        if (i5 == -1) {
            return -1;
        }
        int i6 = 0;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            if (this.mArrayIndices[i5] == solverVariable.id) {
                return i5;
            }
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
        return -1;
    }

    public void invert() {
        int i5 = this.mHead;
        int i6 = 0;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i5] = fArr[i5] * -1.0f;
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
    }

    public final void put(SolverVariable solverVariable, float f5) {
        if (f5 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i5 = this.mHead;
        if (i5 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f5;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (!this.mDidFillOnce) {
                int i6 = this.mLast + 1;
                this.mLast = i6;
                int[] iArr = this.mArrayIndices;
                if (i6 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i7 = 0;
        int i8 = -1;
        while (i5 != -1 && i7 < this.mCurrentSize) {
            int i9 = this.mArrayIndices[i5];
            int i10 = solverVariable.id;
            if (i9 == i10) {
                this.mArrayValues[i5] = f5;
                return;
            }
            if (i9 < i10) {
                i8 = i5;
            }
            i5 = this.mArrayNextIndices[i5];
            i7++;
        }
        int i11 = this.mLast;
        int i12 = i11 + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[i11] != -1) {
                i11 = iArr2.length;
            }
        } else {
            i11 = i12;
        }
        int[] iArr3 = this.mArrayIndices;
        if (i11 >= iArr3.length && this.mCurrentSize < iArr3.length) {
            int i13 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i13 >= iArr4.length) {
                    break;
                } else if (iArr4[i13] == -1) {
                    i11 = i13;
                    break;
                } else {
                    i13++;
                }
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (i11 >= iArr5.length) {
            i11 = iArr5.length;
            int i14 = this.mRowSize * 2;
            this.mRowSize = i14;
            this.mDidFillOnce = false;
            this.mLast = i11 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i14);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
        }
        this.mArrayIndices[i11] = solverVariable.id;
        this.mArrayValues[i11] = f5;
        if (i8 != -1) {
            int[] iArr6 = this.mArrayNextIndices;
            iArr6[i11] = iArr6[i8];
            iArr6[i8] = i11;
        } else {
            this.mArrayNextIndices[i11] = this.mHead;
            this.mHead = i11;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i15 = this.mCurrentSize + 1;
        this.mCurrentSize = i15;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i15 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    public final float remove(SolverVariable solverVariable, boolean z4) {
        if (this.mCandidate == solverVariable) {
            this.mCandidate = null;
        }
        int i5 = this.mHead;
        if (i5 == -1) {
            return 0.0f;
        }
        int i6 = 0;
        int i7 = -1;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            if (this.mArrayIndices[i5] == solverVariable.id) {
                if (i5 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i5];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i7] = iArr[i5];
                }
                if (z4) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.mCurrentSize--;
                this.mArrayIndices[i5] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i5;
                }
                return this.mArrayValues[i5];
            }
            i6++;
            i7 = i5;
            i5 = this.mArrayNextIndices[i5];
        }
        return 0.0f;
    }

    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int i5 = this.mHead;
        String str = "";
        int i6 = 0;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            str = ((str + " -> ") + this.mArrayValues[i5] + " : ") + this.mCache.mIndexedVariables[this.mArrayIndices[i5]];
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
        return str;
    }

    public float use(ArrayRow arrayRow, boolean z4) {
        float f5 = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z4);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i5 = 0; i5 < currentSize; i5++) {
            SolverVariable variable = arrayRowVariables.getVariable(i5);
            add(variable, arrayRowVariables.get(variable) * f5, z4);
        }
        return f5;
    }
}
