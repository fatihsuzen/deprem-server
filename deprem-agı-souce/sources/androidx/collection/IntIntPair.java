package androidx.collection;

public final class IntIntPair {
    public final long packedValue;

    private /* synthetic */ IntIntPair(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IntIntPair m12boximpl(long j5) {
        return new IntIntPair(j5);
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m13component1impl(long j5) {
        return (int) (j5 >> 32);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final int m14component2impl(long j5) {
        return (int) (j5 & 4294967295L);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m16constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m17equalsimpl(long j5, Object obj) {
        return (obj instanceof IntIntPair) && j5 == ((IntIntPair) obj).m23unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m18equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getFirst-impl  reason: not valid java name */
    public static final int m19getFirstimpl(long j5) {
        return (int) (j5 >> 32);
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getSecond-impl  reason: not valid java name */
    public static final int m20getSecondimpl(long j5) {
        return (int) (j5 & 4294967295L);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m21hashCodeimpl(long j5) {
        return a.a(j5);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m22toStringimpl(long j5) {
        return '(' + m19getFirstimpl(j5) + ", " + m20getSecondimpl(j5) + ')';
    }

    public boolean equals(Object obj) {
        return m17equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m21hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m22toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m23unboximpl() {
        return this.packedValue;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m15constructorimpl(int i5, int i6) {
        return m16constructorimpl((((long) i6) & 4294967295L) | (((long) i5) << 32));
    }
}
