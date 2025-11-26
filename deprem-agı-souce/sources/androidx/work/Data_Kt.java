package androidx.work;

import kotlin.jvm.internal.t;

public final class Data_Kt {
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("Data");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    /* access modifiers changed from: private */
    public static final Boolean[] convertPrimitiveArray(boolean[] zArr) {
        int length = zArr.length;
        Boolean[] boolArr = new Boolean[length];
        for (int i5 = 0; i5 < length; i5++) {
            boolArr[i5] = Boolean.valueOf(zArr[i5]);
        }
        return boolArr;
    }

    /* access modifiers changed from: private */
    public static final Byte[] convertPrimitiveArray(byte[] bArr) {
        int length = bArr.length;
        Byte[] bArr2 = new Byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr2[i5] = Byte.valueOf(bArr[i5]);
        }
        return bArr2;
    }

    /* access modifiers changed from: private */
    public static final Integer[] convertPrimitiveArray(int[] iArr) {
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i5 = 0; i5 < length; i5++) {
            numArr[i5] = Integer.valueOf(iArr[i5]);
        }
        return numArr;
    }

    /* access modifiers changed from: private */
    public static final Long[] convertPrimitiveArray(long[] jArr) {
        int length = jArr.length;
        Long[] lArr = new Long[length];
        for (int i5 = 0; i5 < length; i5++) {
            lArr[i5] = Long.valueOf(jArr[i5]);
        }
        return lArr;
    }

    /* access modifiers changed from: private */
    public static final Float[] convertPrimitiveArray(float[] fArr) {
        int length = fArr.length;
        Float[] fArr2 = new Float[length];
        for (int i5 = 0; i5 < length; i5++) {
            fArr2[i5] = Float.valueOf(fArr[i5]);
        }
        return fArr2;
    }

    /* access modifiers changed from: private */
    public static final Double[] convertPrimitiveArray(double[] dArr) {
        int length = dArr.length;
        Double[] dArr2 = new Double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr2[i5] = Double.valueOf(dArr[i5]);
        }
        return dArr2;
    }
}
