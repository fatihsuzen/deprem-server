package androidx.collection;

public final class FloatFloatPair {
    public final long packedValue;

    private /* synthetic */ FloatFloatPair(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FloatFloatPair m0boximpl(long j5) {
        return new FloatFloatPair(j5);
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m1component1impl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m2component2impl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m4constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5equalsimpl(long j5, Object obj) {
        return (obj instanceof FloatFloatPair) && j5 == ((FloatFloatPair) obj).m11unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getFirst-impl  reason: not valid java name */
    public static final float m7getFirstimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getSecond-impl  reason: not valid java name */
    public static final float m8getSecondimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m9hashCodeimpl(long j5) {
        return a.a(j5);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m10toStringimpl(long j5) {
        return '(' + Float.intBitsToFloat((int) (j5 >> 32)) + ", " + Float.intBitsToFloat((int) (j5 & 4294967295L)) + ')';
    }

    public boolean equals(Object obj) {
        return m5equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m9hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m10toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m11unboximpl() {
        return this.packedValue;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m3constructorimpl(float f5, float f6) {
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f5);
        return m4constructorimpl((((long) Float.floatToRawIntBits(f6)) & 4294967295L) | (floatToRawIntBits << 32));
    }
}
