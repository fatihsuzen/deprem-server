package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-4f;
    static final int NOT_FOUND = -1;
    GoalVariableAccessor mAccessor = new GoalVariableAccessor(this);
    private SolverVariable[] mArrayGoals = new SolverVariable[128];
    Cache mCache;
    private int mNumGoals = 0;
    private SolverVariable[] mSortArray = new SolverVariable[128];
    private int mTableSize = 128;

    class GoalVariableAccessor {
        PriorityGoalRow mRow;
        SolverVariable mVariable;

        GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.mRow = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i5 = 0; i5 < 9; i5++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f5 = fArr[i5] + solverVariable.mGoalStrengthVector[i5];
                fArr[i5] = f5;
                if (Math.abs(f5) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i5] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f5) {
            boolean z4 = true;
            if (this.mVariable.inGoal) {
                for (int i5 = 0; i5 < 9; i5++) {
                    float[] fArr = this.mVariable.mGoalStrengthVector;
                    float f6 = fArr[i5] + (solverVariable.mGoalStrengthVector[i5] * f5);
                    fArr[i5] = f6;
                    if (Math.abs(f6) < 1.0E-4f) {
                        this.mVariable.mGoalStrengthVector[i5] = 0.0f;
                    } else {
                        z4 = false;
                    }
                }
                if (z4) {
                    PriorityGoalRow.this.removeGoal(this.mVariable);
                }
                return false;
            }
            for (int i6 = 0; i6 < 9; i6++) {
                float f7 = solverVariable.mGoalStrengthVector[i6];
                if (f7 != 0.0f) {
                    float f8 = f7 * f5;
                    if (Math.abs(f8) < 1.0E-4f) {
                        f8 = 0.0f;
                    }
                    this.mVariable.mGoalStrengthVector[i6] = f8;
                } else {
                    this.mVariable.mGoalStrengthVector[i6] = 0.0f;
                }
            }
            return true;
        }

        public void init(SolverVariable solverVariable) {
            this.mVariable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i5 = 8; i5 >= 0; i5--) {
                float f5 = this.mVariable.mGoalStrengthVector[i5];
                if (f5 > 0.0f) {
                    return false;
                }
                if (f5 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i5 = 0; i5 < 9; i5++) {
                if (this.mVariable.mGoalStrengthVector[i5] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i5 = 8;
            while (true) {
                if (i5 < 0) {
                    break;
                }
                float f5 = solverVariable.mGoalStrengthVector[i5];
                float f6 = this.mVariable.mGoalStrengthVector[i5];
                if (f6 == f5) {
                    i5--;
                } else if (f6 < f5) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.mVariable.mGoalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.mVariable != null) {
                for (int i5 = 0; i5 < 9; i5++) {
                    str = str + this.mVariable.mGoalStrengthVector[i5] + " ";
                }
            }
            return str + "] " + this.mVariable;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.mCache = cache;
    }

    private void addToGoal(SolverVariable solverVariable) {
        int i5;
        int i6 = this.mNumGoals + 1;
        SolverVariable[] solverVariableArr = this.mArrayGoals;
        if (i6 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.mArrayGoals = solverVariableArr2;
            this.mSortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.mArrayGoals;
        int i7 = this.mNumGoals;
        solverVariableArr3[i7] = solverVariable;
        int i8 = i7 + 1;
        this.mNumGoals = i8;
        if (i8 > 1 && solverVariableArr3[i7].id > solverVariable.id) {
            int i9 = 0;
            while (true) {
                i5 = this.mNumGoals;
                if (i9 >= i5) {
                    break;
                }
                this.mSortArray[i9] = this.mArrayGoals[i9];
                i9++;
            }
            Arrays.sort(this.mSortArray, 0, i5, new Comparator<SolverVariable>() {
                public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
                    return solverVariable.id - solverVariable2.id;
                }
            });
            for (int i10 = 0; i10 < this.mNumGoals; i10++) {
                this.mArrayGoals[i10] = this.mSortArray[i10];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* access modifiers changed from: private */
    public void removeGoal(SolverVariable solverVariable) {
        int i5 = 0;
        while (i5 < this.mNumGoals) {
            if (this.mArrayGoals[i5] == solverVariable) {
                while (true) {
                    int i6 = this.mNumGoals;
                    if (i5 < i6 - 1) {
                        SolverVariable[] solverVariableArr = this.mArrayGoals;
                        int i7 = i5 + 1;
                        solverVariableArr[i5] = solverVariableArr[i7];
                        i5 = i7;
                    } else {
                        this.mNumGoals = i6 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i5++;
            }
        }
    }

    public void addError(SolverVariable solverVariable) {
        this.mAccessor.init(solverVariable);
        this.mAccessor.reset();
        solverVariable.mGoalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    public void clear() {
        this.mNumGoals = 0;
        this.mConstantValue = 0.0f;
    }

    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i5 = -1;
        for (int i6 = 0; i6 < this.mNumGoals; i6++) {
            SolverVariable solverVariable = this.mArrayGoals[i6];
            if (!zArr[solverVariable.id]) {
                this.mAccessor.init(solverVariable);
                if (i5 == -1) {
                    if (!this.mAccessor.isNegative()) {
                    }
                } else if (!this.mAccessor.isSmallerThan(this.mArrayGoals[i5])) {
                }
                i5 = i6;
            }
        }
        if (i5 == -1) {
            return null;
        }
        return this.mArrayGoals[i5];
    }

    public boolean isEmpty() {
        if (this.mNumGoals == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str = "" + " goal -> (" + this.mConstantValue + ") : ";
        for (int i5 = 0; i5 < this.mNumGoals; i5++) {
            this.mAccessor.init(this.mArrayGoals[i5]);
            str = str + this.mAccessor + " ";
        }
        return str;
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z4) {
        SolverVariable solverVariable = arrayRow.mVariable;
        if (solverVariable != null) {
            ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
            int currentSize = arrayRowVariables.getCurrentSize();
            for (int i5 = 0; i5 < currentSize; i5++) {
                SolverVariable variable = arrayRowVariables.getVariable(i5);
                float variableValue = arrayRowVariables.getVariableValue(i5);
                this.mAccessor.init(variable);
                if (this.mAccessor.addToGoal(solverVariable, variableValue)) {
                    addToGoal(variable);
                }
                this.mConstantValue += arrayRow.mConstantValue * variableValue;
            }
            removeGoal(solverVariable);
        }
    }
}
