package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float sEpsilon = 0.001f;
    protected final Cache mCache;
    int mCount = 0;
    private int mHashSize = 16;
    int mHead = -1;
    int[] mKeys = new int[16];
    int[] mNext = new int[16];
    int[] mNextKeys = new int[16];
    private final int mNone = -1;
    int[] mPrevious = new int[16];
    private final ArrayRow mRow;
    private int mSize = 16;
    float[] mValues = new float[16];
    int[] mVariables = new int[16];

    SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i5) {
        int[] iArr;
        int i6 = solverVariable.id % this.mHashSize;
        int[] iArr2 = this.mKeys;
        int i7 = iArr2[i6];
        if (i7 == -1) {
            iArr2[i6] = i5;
        } else {
            while (true) {
                iArr = this.mNextKeys;
                int i8 = iArr[i7];
                if (i8 == -1) {
                    break;
                }
                i7 = i8;
            }
            iArr[i7] = i5;
        }
        this.mNextKeys[i5] = -1;
    }

    private void addVariable(int i5, SolverVariable solverVariable, float f5) {
        this.mVariables[i5] = solverVariable.id;
        this.mValues[i5] = f5;
        this.mPrevious[i5] = -1;
        this.mNext[i5] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i5 = 0; i5 < this.mHashSize; i5++) {
            if (this.mKeys[i5] != -1) {
                String str = hashCode() + " hash [" + i5 + "] => ";
                int i6 = this.mKeys[i5];
                boolean z4 = false;
                while (!z4) {
                    str = str + " " + this.mVariables[i6];
                    int i7 = this.mNextKeys[i6];
                    if (i7 != -1) {
                        i6 = i7;
                    } else {
                        z4 = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i5 = 0; i5 < this.mSize; i5++) {
            if (this.mVariables[i5] == -1) {
                return i5;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i5 = this.mSize * 2;
        this.mVariables = Arrays.copyOf(this.mVariables, i5);
        this.mValues = Arrays.copyOf(this.mValues, i5);
        this.mPrevious = Arrays.copyOf(this.mPrevious, i5);
        this.mNext = Arrays.copyOf(this.mNext, i5);
        this.mNextKeys = Arrays.copyOf(this.mNextKeys, i5);
        for (int i6 = this.mSize; i6 < i5; i6++) {
            this.mVariables[i6] = -1;
            this.mNextKeys[i6] = -1;
        }
        this.mSize = i5;
    }

    private void insertVariable(int i5, SolverVariable solverVariable, float f5) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f5);
        if (i5 != -1) {
            this.mPrevious[findEmptySlot] = i5;
            int[] iArr = this.mNext;
            iArr[findEmptySlot] = iArr[i5];
            iArr[i5] = findEmptySlot;
        } else {
            this.mPrevious[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.mNext[findEmptySlot] = this.mHead;
                this.mHead = findEmptySlot;
            } else {
                this.mNext[findEmptySlot] = -1;
            }
        }
        int i6 = this.mNext[findEmptySlot];
        if (i6 != -1) {
            this.mPrevious[i6] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeFromHashMap(androidx.constraintlayout.core.SolverVariable r6) {
        /*
            r5 = this;
            int r6 = r6.id
            int r0 = r5.mHashSize
            int r0 = r6 % r0
            int[] r1 = r5.mKeys
            r2 = r1[r0]
            r3 = -1
            if (r2 != r3) goto L_0x000e
            goto L_0x0039
        L_0x000e:
            int[] r4 = r5.mVariables
            r4 = r4[r2]
            if (r4 != r6) goto L_0x001d
            int[] r6 = r5.mNextKeys
            r4 = r6[r2]
            r1[r0] = r4
            r6[r2] = r3
            return
        L_0x001d:
            int[] r0 = r5.mNextKeys
            r1 = r0[r2]
            if (r1 == r3) goto L_0x002b
            int[] r4 = r5.mVariables
            r4 = r4[r1]
            if (r4 == r6) goto L_0x002b
            r2 = r1
            goto L_0x001d
        L_0x002b:
            if (r1 == r3) goto L_0x0039
            int[] r4 = r5.mVariables
            r4 = r4[r1]
            if (r4 != r6) goto L_0x0039
            r6 = r0[r1]
            r0[r2] = r6
            r0[r1] = r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.removeFromHashMap(androidx.constraintlayout.core.SolverVariable):void");
    }

    public void add(SolverVariable solverVariable, float f5, boolean z4) {
        float f6 = sEpsilon;
        if (f5 <= (-f6) || f5 >= f6) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f5);
                return;
            }
            float[] fArr = this.mValues;
            float f7 = fArr[indexOf] + f5;
            fArr[indexOf] = f7;
            float f8 = sEpsilon;
            if (f7 > (-f8) && f7 < f8) {
                fArr[indexOf] = 0.0f;
                remove(solverVariable, z4);
            }
        }
    }

    public void clear() {
        int i5 = this.mCount;
        for (int i6 = 0; i6 < i5; i6++) {
            SolverVariable variable = getVariable(i6);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i7 = 0; i7 < this.mSize; i7++) {
            this.mVariables[i7] = -1;
            this.mNextKeys[i7] = -1;
        }
        for (int i8 = 0; i8 < this.mHashSize; i8++) {
            this.mKeys[i8] = -1;
        }
        this.mCount = 0;
        this.mHead = -1;
    }

    public boolean contains(SolverVariable solverVariable) {
        if (indexOf(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    public void display() {
        int i5 = this.mCount;
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
        int i5 = this.mCount;
        int i6 = this.mHead;
        int i7 = 0;
        while (i7 < i5) {
            float[] fArr = this.mValues;
            fArr[i6] = fArr[i6] / f5;
            i6 = this.mNext[i6];
            if (i6 != -1) {
                i7++;
            } else {
                return;
            }
        }
    }

    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.mValues[indexOf];
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.mCount;
    }

    public SolverVariable getVariable(int i5) {
        int i6 = this.mCount;
        if (i6 == 0) {
            return null;
        }
        int i7 = this.mHead;
        for (int i8 = 0; i8 < i6; i8++) {
            if (i8 == i5 && i7 != -1) {
                return this.mCache.mIndexedVariables[this.mVariables[i7]];
            }
            i7 = this.mNext[i7];
            if (i7 == -1) {
                break;
            }
        }
        return null;
    }

    public float getVariableValue(int i5) {
        int i6 = this.mCount;
        int i7 = this.mHead;
        for (int i8 = 0; i8 < i6; i8++) {
            if (i8 == i5) {
                return this.mValues[i7];
            }
            i7 = this.mNext[i7];
            if (i7 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(androidx.constraintlayout.core.SolverVariable r4) {
        /*
            r3 = this;
            int r0 = r3.mCount
            r1 = -1
            if (r0 == 0) goto L_0x0033
            if (r4 != 0) goto L_0x0008
            goto L_0x0033
        L_0x0008:
            int r4 = r4.id
            int r0 = r3.mHashSize
            int r0 = r4 % r0
            int[] r2 = r3.mKeys
            r0 = r2[r0]
            if (r0 != r1) goto L_0x0015
            return r1
        L_0x0015:
            int[] r2 = r3.mVariables
            r2 = r2[r0]
            if (r2 != r4) goto L_0x001c
            return r0
        L_0x001c:
            int[] r2 = r3.mNextKeys
            r0 = r2[r0]
            if (r0 == r1) goto L_0x0029
            int[] r2 = r3.mVariables
            r2 = r2[r0]
            if (r2 == r4) goto L_0x0029
            goto L_0x001c
        L_0x0029:
            if (r0 != r1) goto L_0x002c
            return r1
        L_0x002c:
            int[] r2 = r3.mVariables
            r2 = r2[r0]
            if (r2 != r4) goto L_0x0033
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.indexOf(androidx.constraintlayout.core.SolverVariable):int");
    }

    public void invert() {
        int i5 = this.mCount;
        int i6 = this.mHead;
        int i7 = 0;
        while (i7 < i5) {
            float[] fArr = this.mValues;
            fArr[i6] = fArr[i6] * -1.0f;
            i6 = this.mNext[i6];
            if (i6 != -1) {
                i7++;
            } else {
                return;
            }
        }
    }

    public void put(SolverVariable solverVariable, float f5) {
        float f6 = sEpsilon;
        if (f5 <= (-f6) || f5 >= f6) {
            if (this.mCount == 0) {
                addVariable(0, solverVariable, f5);
                addToHashMap(solverVariable, 0);
                this.mHead = 0;
                return;
            }
            int indexOf = indexOf(solverVariable);
            if (indexOf != -1) {
                this.mValues[indexOf] = f5;
                return;
            }
            if (this.mCount + 1 >= this.mSize) {
                increaseSize();
            }
            int i5 = this.mCount;
            int i6 = this.mHead;
            int i7 = -1;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = this.mVariables[i6];
                int i10 = solverVariable.id;
                if (i9 == i10) {
                    this.mValues[i6] = f5;
                    return;
                }
                if (i9 < i10) {
                    i7 = i6;
                }
                i6 = this.mNext[i6];
                if (i6 == -1) {
                    break;
                }
            }
            insertVariable(i7, solverVariable, f5);
            return;
        }
        remove(solverVariable, true);
    }

    public float remove(SolverVariable solverVariable, boolean z4) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f5 = this.mValues[indexOf];
        if (this.mHead == indexOf) {
            this.mHead = this.mNext[indexOf];
        }
        this.mVariables[indexOf] = -1;
        int[] iArr = this.mPrevious;
        int i5 = iArr[indexOf];
        if (i5 != -1) {
            int[] iArr2 = this.mNext;
            iArr2[i5] = iArr2[indexOf];
        }
        int i6 = this.mNext[indexOf];
        if (i6 != -1) {
            iArr[i6] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z4) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f5;
    }

    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i5 = this.mCount;
        for (int i6 = 0; i6 < i5; i6++) {
            SolverVariable variable = getVariable(i6);
            if (variable != null) {
                String str4 = str3 + variable + " = " + getVariableValue(i6) + " ";
                int indexOf = indexOf(variable);
                String str5 = str4 + "[p: ";
                if (this.mPrevious[indexOf] != -1) {
                    str = str5 + this.mCache.mIndexedVariables[this.mVariables[this.mPrevious[indexOf]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.mNext[indexOf] != -1) {
                    str2 = str6 + this.mCache.mIndexedVariables[this.mVariables[this.mNext[indexOf]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }

    public float use(ArrayRow arrayRow, boolean z4) {
        float f5 = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z4);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i5 = 0;
        int i6 = 0;
        while (i5 < currentSize) {
            int i7 = solverVariableValues.mVariables[i6];
            if (i7 != -1) {
                add(this.mCache.mIndexedVariables[i7], solverVariableValues.mValues[i6] * f5, z4);
                i5++;
            }
            i6++;
        }
        return f5;
    }
}
