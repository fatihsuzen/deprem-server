package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class TypedBundle {
    private static final int INITIAL_BOOLEAN = 4;
    private static final int INITIAL_FLOAT = 10;
    private static final int INITIAL_INT = 10;
    private static final int INITIAL_STRING = 5;
    int mCountBoolean = 0;
    int mCountFloat = 0;
    int mCountInt = 0;
    int mCountString = 0;
    int[] mTypeBoolean = new int[4];
    int[] mTypeFloat = new int[10];
    int[] mTypeInt = new int[10];
    int[] mTypeString = new int[5];
    boolean[] mValueBoolean = new boolean[4];
    float[] mValueFloat = new float[10];
    int[] mValueInt = new int[10];
    String[] mValueString = new String[5];

    public void add(int i5, int i6) {
        int i7 = this.mCountInt;
        int[] iArr = this.mTypeInt;
        if (i7 >= iArr.length) {
            this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.mValueInt;
            this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.mTypeInt;
        int i8 = this.mCountInt;
        iArr3[i8] = i5;
        int[] iArr4 = this.mValueInt;
        this.mCountInt = i8 + 1;
        iArr4[i8] = i6;
    }

    public void addIfNotNull(int i5, String str) {
        if (str != null) {
            add(i5, str);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        for (int i5 = 0; i5 < this.mCountInt; i5++) {
            typedValues.setValue(this.mTypeInt[i5], this.mValueInt[i5]);
        }
        for (int i6 = 0; i6 < this.mCountFloat; i6++) {
            typedValues.setValue(this.mTypeFloat[i6], this.mValueFloat[i6]);
        }
        for (int i7 = 0; i7 < this.mCountString; i7++) {
            typedValues.setValue(this.mTypeString[i7], this.mValueString[i7]);
        }
        for (int i8 = 0; i8 < this.mCountBoolean; i8++) {
            typedValues.setValue(this.mTypeBoolean[i8], this.mValueBoolean[i8]);
        }
    }

    public void clear() {
        this.mCountBoolean = 0;
        this.mCountString = 0;
        this.mCountFloat = 0;
        this.mCountInt = 0;
    }

    public int getInteger(int i5) {
        for (int i6 = 0; i6 < this.mCountInt; i6++) {
            if (this.mTypeInt[i6] == i5) {
                return this.mValueInt[i6];
            }
        }
        return -1;
    }

    public String toString() {
        return "TypedBundle{mCountInt=" + this.mCountInt + ", mCountFloat=" + this.mCountFloat + ", mCountString=" + this.mCountString + ", mCountBoolean=" + this.mCountBoolean + '}';
    }

    public void add(int i5, float f5) {
        int i6 = this.mCountFloat;
        int[] iArr = this.mTypeFloat;
        if (i6 >= iArr.length) {
            this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValueFloat;
            this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTypeFloat;
        int i7 = this.mCountFloat;
        iArr2[i7] = i5;
        float[] fArr2 = this.mValueFloat;
        this.mCountFloat = i7 + 1;
        fArr2[i7] = f5;
    }

    public void applyDelta(TypedBundle typedBundle) {
        for (int i5 = 0; i5 < this.mCountInt; i5++) {
            typedBundle.add(this.mTypeInt[i5], this.mValueInt[i5]);
        }
        for (int i6 = 0; i6 < this.mCountFloat; i6++) {
            typedBundle.add(this.mTypeFloat[i6], this.mValueFloat[i6]);
        }
        for (int i7 = 0; i7 < this.mCountString; i7++) {
            typedBundle.add(this.mTypeString[i7], this.mValueString[i7]);
        }
        for (int i8 = 0; i8 < this.mCountBoolean; i8++) {
            typedBundle.add(this.mTypeBoolean[i8], this.mValueBoolean[i8]);
        }
    }

    public void add(int i5, String str) {
        int i6 = this.mCountString;
        int[] iArr = this.mTypeString;
        if (i6 >= iArr.length) {
            this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.mValueString;
            this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.mTypeString;
        int i7 = this.mCountString;
        iArr2[i7] = i5;
        String[] strArr2 = this.mValueString;
        this.mCountString = i7 + 1;
        strArr2[i7] = str;
    }

    public void add(int i5, boolean z4) {
        int i6 = this.mCountBoolean;
        int[] iArr = this.mTypeBoolean;
        if (i6 >= iArr.length) {
            this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.mValueBoolean;
            this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.mTypeBoolean;
        int i7 = this.mCountBoolean;
        iArr2[i7] = i5;
        boolean[] zArr2 = this.mValueBoolean;
        this.mCountBoolean = i7 + 1;
        zArr2[i7] = z4;
    }
}
