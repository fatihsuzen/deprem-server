package androidx.collection;

public final class PackingUtilsKt {
    public static final long packFloats(float f5, float f6) {
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f5);
        return (((long) Float.floatToRawIntBits(f6)) & 4294967295L) | (floatToRawIntBits << 32);
    }

    public static final long packInts(int i5, int i6) {
        return (((long) i6) & 4294967295L) | (((long) i5) << 32);
    }
}
