package q3;

import kotlin.jvm.internal.t;
import q3.C2726b;

abstract class g extends f {
    public static float b(float f5, float f6) {
        if (f5 < f6) {
            return f6;
        }
        return f5;
    }

    public static int c(int i5, int i6) {
        if (i5 < i6) {
            return i6;
        }
        return i5;
    }

    public static long d(long j5, long j6) {
        if (j5 < j6) {
            return j6;
        }
        return j5;
    }

    public static int e(int i5, int i6) {
        if (i5 > i6) {
            return i6;
        }
        return i5;
    }

    public static long f(long j5, long j6) {
        if (j5 > j6) {
            return j6;
        }
        return j5;
    }

    public static float g(float f5, float f6, float f7) {
        if (f6 > f7) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f7 + " is less than minimum " + f6 + '.');
        } else if (f5 < f6) {
            return f6;
        } else {
            if (f5 > f7) {
                return f7;
            }
            return f5;
        }
    }

    public static int h(int i5, int i6, int i7) {
        if (i6 > i7) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i7 + " is less than minimum " + i6 + '.');
        } else if (i5 < i6) {
            return i6;
        } else {
            if (i5 > i7) {
                return i7;
            }
            return i5;
        }
    }

    public static long i(long j5, long j6, long j7) {
        if (j6 > j7) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j7 + " is less than minimum " + j6 + '.');
        } else if (j5 < j6) {
            return j6;
        } else {
            if (j5 > j7) {
                return j7;
            }
            return j5;
        }
    }

    public static C2726b j(int i5, int i6) {
        return C2726b.f25690d.a(i5, i6, -1);
    }

    public static C2726b k(C2726b bVar, int i5) {
        boolean z4;
        t.e(bVar, "<this>");
        if (i5 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        f.a(z4, Integer.valueOf(i5));
        C2726b.a aVar = C2726b.f25690d;
        int c5 = bVar.c();
        int f5 = bVar.f();
        if (bVar.g() <= 0) {
            i5 = -i5;
        }
        return aVar.a(c5, f5, i5);
    }

    public static C2728d l(int i5, int i6) {
        if (i6 <= Integer.MIN_VALUE) {
            return C2728d.f25698e.a();
        }
        return new C2728d(i5, i6 - 1);
    }
}
