package j$.util.stream;

import j$.time.format.r;
import j$.util.C0469e;
import j$.util.Spliterator;
import java.util.EnumMap;
import java.util.Map;

public enum Z2 {
    DISTINCT(0, r2),
    SORTED(1, r7),
    ORDERED(2, r12),
    SIZED(3, r14),
    SHORT_CIRCUIT(12, r14);
    

    /* renamed from: f  reason: collision with root package name */
    public static final int f1624f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f1625g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f1626h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f1627i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f1628j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static final int f1629k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static final int f1630l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final int f1631m = 0;

    /* renamed from: n  reason: collision with root package name */
    public static final int f1632n = 0;

    /* renamed from: o  reason: collision with root package name */
    public static final int f1633o = 0;

    /* renamed from: p  reason: collision with root package name */
    public static final int f1634p = 0;

    /* renamed from: q  reason: collision with root package name */
    public static final int f1635q = 0;

    /* renamed from: r  reason: collision with root package name */
    public static final int f1636r = 0;

    /* renamed from: s  reason: collision with root package name */
    public static final int f1637s = 0;

    /* renamed from: t  reason: collision with root package name */
    public static final int f1638t = 0;

    /* renamed from: u  reason: collision with root package name */
    public static final int f1639u = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Map f1641a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1642b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1643c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1644d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1645e;

    static {
        Y2 y22;
        Y2 y23;
        Y2 y24;
        Y2 y25;
        Y2 y26;
        int i5;
        f1624f = f(y22);
        f1625g = f(y23);
        f1626h = f(y24);
        f(y25);
        f(y26);
        for (Z2 z22 : values()) {
            i5 |= z22.f1645e;
        }
        f1627i = i5;
        int i6 = f1625g;
        f1628j = i6;
        int i7 = i6 << 1;
        f1629k = i7;
        f1630l = i6 | i7;
        Z2 z23 = DISTINCT;
        f1631m = z23.f1643c;
        f1632n = z23.f1644d;
        Z2 z24 = SORTED;
        f1633o = z24.f1643c;
        f1634p = z24.f1644d;
        Z2 z25 = ORDERED;
        f1635q = z25.f1643c;
        f1636r = z25.f1644d;
        Z2 z26 = SIZED;
        f1637s = z26.f1643c;
        f1638t = z26.f1644d;
        f1639u = SHORT_CIRCUIT.f1643c;
    }

    public static r k(Y2 y22) {
        r rVar = new r(1, new EnumMap(Y2.class));
        rVar.b(y22);
        return rVar;
    }

    /* access modifiers changed from: public */
    Z2(int i5, r rVar) {
        for (Y2 t5 : Y2.values()) {
            C0469e.t(rVar.f1137a, t5, 0);
        }
        this.f1641a = rVar.f1137a;
        int i6 = i5 * 2;
        this.f1642b = i6;
        this.f1643c = 1 << i6;
        this.f1644d = 2 << i6;
        this.f1645e = 3 << i6;
    }

    public final boolean h(int i5) {
        return (i5 & this.f1645e) == this.f1643c;
    }

    public static int f(Y2 y22) {
        int i5 = 0;
        for (Z2 z22 : values()) {
            i5 |= ((Integer) z22.f1641a.get(y22)).intValue() << z22.f1642b;
        }
        return i5;
    }

    public static int e(int i5, int i6) {
        int i7;
        if (i5 == 0) {
            i7 = f1627i;
        } else {
            i7 = ~(((f1628j & i5) << 1) | i5 | ((f1629k & i5) >> 1));
        }
        return i5 | (i6 & i7);
    }

    public static int g(Spliterator spliterator) {
        int characteristics = spliterator.characteristics();
        int i5 = characteristics & 4;
        int i6 = f1624f;
        return (i5 == 0 || spliterator.getComparator() == null) ? characteristics & i6 : characteristics & i6 & -5;
    }
}
