package m3;

/* renamed from: m3.c  reason: case insensitive filesystem */
abstract class C2692c extends C2691b {
    public static int a(float f5) {
        if (!Float.isNaN(f5)) {
            return Math.round(f5);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static long b(double d5) {
        if (!Double.isNaN(d5)) {
            return Math.round(d5);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}
