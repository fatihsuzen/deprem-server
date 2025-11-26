package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    float mConstantValue = 0.0f;
    boolean mIsSimpleDefinition = false;
    boolean mUsed = false;
    SolverVariable mVariable = null;
    ArrayList<SolverVariable> mVariablesToUpdate = new ArrayList<>();
    public ArrayRowVariables variables;

    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f5, boolean z4);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f5);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i5);

        float getVariableValue(int i5);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f5);

        float remove(SolverVariable solverVariable, boolean z4);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z4);
    }

    public ArrayRow() {
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        if (solverVariable.usageInRowCount <= 1) {
            return true;
        }
        return false;
    }

    private SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f5 = 0.0f;
        for (int i5 = 0; i5 < currentSize; i5++) {
            float variableValue = this.variables.getVariableValue(i5);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(i5);
                if ((zArr == null || !zArr[variable.id]) && variable != solverVariable && (((type = variable.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f5)) {
                    f5 = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i5) {
        this.variables.put(linearSystem.createErrorVariable(i5, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i5, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow addSingleError(SolverVariable solverVariable, int i5) {
        this.variables.put(solverVariable, (float) i5);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean chooseSubject(LinearSystem linearSystem) {
        boolean z4;
        SolverVariable chooseSubjectInVariables = chooseSubjectInVariables(linearSystem);
        if (chooseSubjectInVariables == null) {
            z4 = true;
        } else {
            pivot(chooseSubjectInVariables);
            z4 = false;
        }
        if (this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable chooseSubjectInVariables(LinearSystem linearSystem) {
        boolean isNew;
        boolean isNew2;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable = null;
        float f5 = 0.0f;
        float f6 = 0.0f;
        boolean z4 = false;
        boolean z5 = false;
        SolverVariable solverVariable2 = null;
        for (int i5 = 0; i5 < currentSize; i5++) {
            float variableValue = this.variables.getVariableValue(i5);
            SolverVariable variable = this.variables.getVariable(i5);
            if (variable.mType == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    isNew2 = isNew(variable, linearSystem);
                } else if (f5 > variableValue) {
                    isNew2 = isNew(variable, linearSystem);
                } else if (!z4 && isNew(variable, linearSystem)) {
                    f5 = variableValue;
                    solverVariable = variable;
                    z4 = true;
                }
                z4 = isNew2;
                f5 = variableValue;
                solverVariable = variable;
            } else if (solverVariable == null && variableValue < 0.0f) {
                if (solverVariable2 == null) {
                    isNew = isNew(variable, linearSystem);
                } else if (f6 > variableValue) {
                    isNew = isNew(variable, linearSystem);
                } else if (!z5 && isNew(variable, linearSystem)) {
                    f6 = variableValue;
                    solverVariable2 = variable;
                    z5 = true;
                }
                z5 = isNew;
                f6 = variableValue;
                solverVariable2 = variable;
            }
        }
        if (solverVariable != null) {
            return solverVariable;
        }
        return solverVariable2;
    }

    public void clear() {
        this.variables.clear();
        this.mVariable = null;
        this.mConstantValue = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i5, float f5, SolverVariable solverVariable3, SolverVariable solverVariable4, int i6) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f5 == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i5 > 0 || i6 > 0) {
                this.mConstantValue = (float) ((-i5) + i6);
                return this;
            }
        } else if (f5 <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.mConstantValue = (float) i5;
            return this;
        } else if (f5 >= 1.0f) {
            this.variables.put(solverVariable4, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            this.mConstantValue = (float) (-i6);
            return this;
        } else {
            float f6 = 1.0f - f5;
            this.variables.put(solverVariable, f6 * 1.0f);
            this.variables.put(solverVariable2, f6 * -1.0f);
            this.variables.put(solverVariable3, -1.0f * f5);
            this.variables.put(solverVariable4, 1.0f * f5);
            if (i5 > 0 || i6 > 0) {
                this.mConstantValue = (((float) (-i5)) * f6) + (((float) i6) * f5);
                return this;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i5) {
        this.mVariable = solverVariable;
        float f5 = (float) i5;
        solverVariable.computedValue = f5;
        this.mConstantValue = f5;
        this.mIsSimpleDefinition = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f5) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f5);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f5) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f5);
        this.variables.put(solverVariable4, -f5);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f5, float f6, float f7, SolverVariable solverVariable, int i5, SolverVariable solverVariable2, int i6, SolverVariable solverVariable3, int i7, SolverVariable solverVariable4, int i8) {
        if (f6 == 0.0f || f5 == f7) {
            this.mConstantValue = (float) (((-i5) - i6) + i7 + i8);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        float f8 = (f5 / f6) / (f7 / f6);
        this.mConstantValue = ((float) ((-i5) - i6)) + (((float) i7) * f8) + (((float) i8) * f8);
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable4, f8);
        this.variables.put(solverVariable3, -f8);
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f5, float f6, float f7, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.mConstantValue = 0.0f;
        if (f6 == 0.0f || f5 == f7) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        } else if (f5 == 0.0f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            return this;
        } else if (f7 == 0.0f) {
            this.variables.put(solverVariable3, 1.0f);
            this.variables.put(solverVariable4, -1.0f);
            return this;
        } else {
            float f8 = (f5 / f6) / (f7 / f6);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f8);
            this.variables.put(solverVariable3, -f8);
            return this;
        }
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i5) {
        if (i5 < 0) {
            this.mConstantValue = (float) (i5 * -1);
            this.variables.put(solverVariable, 1.0f);
            return this;
        }
        this.mConstantValue = (float) i5;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i5) {
        boolean z4 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z4 = true;
            }
            this.mConstantValue = (float) i5;
        }
        if (!z4) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
            return this;
        }
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable3, -1.0f);
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i5) {
        boolean z4 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z4 = true;
            }
            this.mConstantValue = (float) i5;
        }
        if (!z4) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable3, 1.0f);
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f5) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.mConstantValue = -f5;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void ensurePositiveConstant() {
        float f5 = this.mConstantValue;
        if (f5 < 0.0f) {
            this.mConstantValue = f5 * -1.0f;
            this.variables.invert();
        }
    }

    public SolverVariable getKey() {
        return this.mVariable;
    }

    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return pickPivotInVariables(zArr, (SolverVariable) null);
    }

    /* access modifiers changed from: package-private */
    public boolean hasKeyVariable() {
        SolverVariable solverVariable = this.mVariable;
        if (solverVariable == null) {
            return false;
        }
        if (solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.mConstantValue >= 0.0f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.mVariable = null;
            this.variables.clear();
            for (int i5 = 0; i5 < arrayRow.variables.getCurrentSize(); i5++) {
                this.variables.add(arrayRow.variables.getVariable(i5), arrayRow.variables.getVariableValue(i5), true);
            }
        }
    }

    public boolean isEmpty() {
        if (this.mVariable == null && this.mConstantValue == 0.0f && this.variables.getCurrentSize() == 0) {
            return true;
        }
        return false;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return pickPivotInVariables((boolean[]) null, solverVariable);
    }

    /* access modifiers changed from: package-private */
    public void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.mVariable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.mVariable.mDefinitionId = -1;
            this.mVariable = null;
        }
        float remove = this.variables.remove(solverVariable, true) * -1.0f;
        this.mVariable = solverVariable;
        if (remove != 1.0f) {
            this.mConstantValue /= remove;
            this.variables.divideByAmount(remove);
        }
    }

    public void reset() {
        this.mVariable = null;
        this.variables.clear();
        this.mConstantValue = 0.0f;
        this.mIsSimpleDefinition = false;
    }

    /* access modifiers changed from: package-private */
    public int sizeInBytes() {
        int i5;
        if (this.mVariable != null) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        return i5 + 8 + this.variables.sizeInBytes();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0069, code lost:
        r7 = r10.variables.getVariableValue(r3);
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toReadableString() {
        /*
            r10 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r10.mVariable
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            androidx.constraintlayout.core.SolverVariable r1 = r10.mVariable
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.mConstantValue
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.mConstantValue
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r4
            goto L_0x0057
        L_0x0056:
            r1 = r3
        L_0x0057:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r5 = r10.variables
            int r5 = r5.getCurrentSize()
        L_0x005d:
            if (r3 >= r5) goto L_0x00ec
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r6 = r10.variables
            androidx.constraintlayout.core.SolverVariable r6 = r6.getVariable(r3)
            if (r6 != 0) goto L_0x0069
            goto L_0x00e8
        L_0x0069:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r7 = r10.variables
            float r7 = r7.getVariableValue(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0075
            goto L_0x00e8
        L_0x0075:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0094
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ba
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x0092:
            float r7 = r7 * r9
            goto L_0x00ba
        L_0x0094:
            if (r8 <= 0) goto L_0x00a8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00ba
        L_0x00a8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x0092
        L_0x00ba:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00d0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e7
        L_0x00d0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e7:
            r1 = r4
        L_0x00e8:
            int r3 = r3 + 1
            goto L_0x005d
        L_0x00ec:
            if (r1 != 0) goto L_0x00ff
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00ff:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.toReadableString():java.lang.String");
    }

    public String toString() {
        return toReadableString();
    }

    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z4) {
        if (solverVariable != null && solverVariable.isFinalValue) {
            this.mConstantValue += solverVariable.computedValue * this.variables.get(solverVariable);
            this.variables.remove(solverVariable, z4);
            if (z4) {
                solverVariable.removeFromRow(this);
            }
            if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
                this.mIsSimpleDefinition = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z4) {
        this.mConstantValue += arrayRow.mConstantValue * this.variables.use(arrayRow, z4);
        if (z4) {
            arrayRow.mVariable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.mVariable != null && this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z4) {
        if (solverVariable != null && solverVariable.mIsSynonym) {
            float f5 = this.variables.get(solverVariable);
            this.mConstantValue += solverVariable.mSynonymDelta * f5;
            this.variables.remove(solverVariable, z4);
            if (z4) {
                solverVariable.removeFromRow(this);
            }
            this.variables.add(linearSystem.mCache.mIndexedVariables[solverVariable.mSynonym], f5, z4);
            if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
                this.mIsSimpleDefinition = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    public void updateFromSystem(LinearSystem linearSystem) {
        if (linearSystem.mRows.length != 0) {
            boolean z4 = false;
            while (!z4) {
                int currentSize = this.variables.getCurrentSize();
                for (int i5 = 0; i5 < currentSize; i5++) {
                    SolverVariable variable = this.variables.getVariable(i5);
                    if (variable.mDefinitionId != -1 || variable.isFinalValue || variable.mIsSynonym) {
                        this.mVariablesToUpdate.add(variable);
                    }
                }
                int size = this.mVariablesToUpdate.size();
                if (size > 0) {
                    for (int i6 = 0; i6 < size; i6++) {
                        SolverVariable solverVariable = this.mVariablesToUpdate.get(i6);
                        if (solverVariable.isFinalValue) {
                            updateFromFinalVariable(linearSystem, solverVariable, true);
                        } else if (solverVariable.mIsSynonym) {
                            updateFromSynonymVariable(linearSystem, solverVariable, true);
                        } else {
                            updateFromRow(linearSystem, linearSystem.mRows[solverVariable.mDefinitionId], true);
                        }
                    }
                    this.mVariablesToUpdate.clear();
                } else {
                    z4 = true;
                }
            }
            if (LinearSystem.SIMPLIFY_SYNONYMS && this.mVariable != null && this.variables.getCurrentSize() == 0) {
                this.mIsSimpleDefinition = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    public void addError(SolverVariable solverVariable) {
        int i5 = solverVariable.strength;
        float f5 = 1.0f;
        if (i5 != 1) {
            if (i5 == 2) {
                f5 = 1000.0f;
            } else if (i5 == 3) {
                f5 = 1000000.0f;
            } else if (i5 == 4) {
                f5 = 1.0E9f;
            } else if (i5 == 5) {
                f5 = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f5);
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i5) {
        boolean z4 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z4 = true;
            }
            this.mConstantValue = (float) i5;
        }
        if (!z4) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            return this;
        }
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        return this;
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i5, SolverVariable solverVariable2) {
        this.mConstantValue = (float) i5;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }
}
