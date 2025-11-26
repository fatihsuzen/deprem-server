package G0;

import java.util.HashMap;

public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private final int f2474a;

    public c(int i5) {
        this.f2474a = i5;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, int i5, int i6) {
        int i7 = i6 - i5;
        if (i6 + i7 > stackTraceElementArr.length) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!stackTraceElementArr[i5 + i8].equals(stackTraceElementArr[i6 + i8])) {
                return false;
            }
        }
        return true;
    }

    private static StackTraceElement[] c(StackTraceElement[] stackTraceElementArr, int i5) {
        int i6;
        HashMap hashMap = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i7 = 0;
        int i8 = 0;
        int i9 = 1;
        while (i7 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i7];
            Integer num = (Integer) hashMap.get(stackTraceElement);
            if (num == null || !b(stackTraceElementArr, num.intValue(), i7)) {
                stackTraceElementArr2[i8] = stackTraceElementArr[i7];
                i8++;
                i9 = 1;
                i6 = i7;
            } else {
                int intValue = i7 - num.intValue();
                if (i9 < i5) {
                    System.arraycopy(stackTraceElementArr, i7, stackTraceElementArr2, i8, intValue);
                    i8 += intValue;
                    i9++;
                }
                i6 = (intValue - 1) + i7;
            }
            hashMap.put(stackTraceElement, Integer.valueOf(i7));
            i7 = i6 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i8];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, i8);
        return stackTraceElementArr3;
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] c5 = c(stackTraceElementArr, this.f2474a);
        if (c5.length < stackTraceElementArr.length) {
            return c5;
        }
        return stackTraceElementArr;
    }
}
