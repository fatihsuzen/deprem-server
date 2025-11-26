package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr = new char[24];
    private static final Object sFormatSync = new Object();

    private TimeUtils() {
    }

    private static int accumField(int i5, int i6, boolean z4, int i7) {
        if (i5 > 99 || (z4 && i7 >= 3)) {
            return i6 + 3;
        }
        if (i5 > 9 || (z4 && i7 >= 2)) {
            return i6 + 2;
        }
        if (z4 || i5 > 0) {
            return i6 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j5, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j5, 0));
        }
    }

    private static int formatDurationLocked(long j5, int i5) {
        char c5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z4;
        boolean z5;
        int i10;
        boolean z6;
        int i11;
        boolean z7;
        int i12;
        int i13;
        boolean z8;
        boolean z9;
        boolean z10;
        int i14;
        long j6 = j5;
        int i15 = i5;
        if (sFormatStr.length < i15) {
            sFormatStr = new char[i15];
        }
        char[] cArr = sFormatStr;
        int i16 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
        if (i16 == 0) {
            int i17 = i15 - 1;
            while (i17 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i16 > 0) {
            c5 = '+';
        } else {
            j6 = -j6;
            c5 = '-';
        }
        int i18 = (int) (j6 % 1000);
        int floor = (int) Math.floor((double) (j6 / 1000));
        if (floor > SECONDS_PER_DAY) {
            i6 = floor / SECONDS_PER_DAY;
            floor -= SECONDS_PER_DAY * i6;
        } else {
            i6 = 0;
        }
        if (floor > SECONDS_PER_HOUR) {
            i7 = floor / SECONDS_PER_HOUR;
            floor -= i7 * SECONDS_PER_HOUR;
        } else {
            i7 = 0;
        }
        if (floor > 60) {
            int i19 = floor / 60;
            floor -= i19 * 60;
            i8 = i19;
        } else {
            i8 = 0;
        }
        if (i15 != 0) {
            int accumField = accumField(i6, 1, false, 0);
            if (accumField > 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            int accumField2 = accumField + accumField(i7, 1, z8, 2);
            if (accumField2 > 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            int accumField3 = accumField2 + accumField(i8, 1, z9, 2);
            if (accumField3 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            int accumField4 = accumField3 + accumField(floor, 1, z10, 2);
            if (accumField4 > 0) {
                i14 = 3;
            } else {
                i14 = 0;
            }
            i9 = 0;
            for (int accumField5 = accumField4 + accumField(i18, 2, true, i14) + 1; accumField5 < i15; accumField5++) {
                cArr[i9] = ' ';
                i9++;
            }
        } else {
            i9 = 0;
        }
        cArr[i9] = c5;
        int i20 = i9 + 1;
        if (i15 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int printField = printField(cArr, i6, 'd', i20, false, 0);
        int i21 = i20;
        if (printField != i21) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z4) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        int i22 = i21;
        int i23 = i7;
        int i24 = i22;
        int printField2 = printField(cArr, i23, 'h', printField, z5, i10);
        if (printField2 != i24) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z4) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        int printField3 = printField(cArr, i8, 'm', printField2, z6, i11);
        if (printField3 != i24) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z4) {
            i12 = 2;
        } else {
            i12 = 0;
        }
        int printField4 = printField(cArr, floor, 's', printField3, z7, i12);
        if (!z4 || printField4 == i24) {
            i13 = 0;
        } else {
            i13 = 3;
        }
        int printField5 = printField(cArr, i18, 'm', printField4, true, i13);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i5, char c5, int i6, boolean z4, int i7) {
        int i8;
        if (!z4 && i5 <= 0) {
            return i6;
        }
        if ((!z4 || i7 < 3) && i5 <= 99) {
            i8 = i6;
        } else {
            int i9 = i5 / 100;
            cArr[i6] = (char) (i9 + 48);
            i8 = i6 + 1;
            i5 -= i9 * 100;
        }
        if ((z4 && i7 >= 2) || i5 > 9 || i6 != i8) {
            int i10 = i5 / 10;
            cArr[i8] = (char) (i10 + 48);
            i8++;
            i5 -= i10 * 10;
        }
        cArr[i8] = (char) (i5 + 48);
        cArr[i8 + 1] = c5;
        return i8 + 2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j5, PrintWriter printWriter, int i5) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j5, i5)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j5, PrintWriter printWriter) {
        formatDuration(j5, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j5, long j6, PrintWriter printWriter) {
        if (j5 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j5 - j6, printWriter, 0);
        }
    }
}
