package j$.util.stream;

import j$.time.format.a;
import j$.util.C0481q;
import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.a  reason: case insensitive filesystem */
public abstract class C0483a extends C0594w1 implements C0513g {

    /* renamed from: h  reason: collision with root package name */
    public final C0483a f1648h;

    /* renamed from: i  reason: collision with root package name */
    public final C0483a f1649i;

    /* renamed from: j  reason: collision with root package name */
    public final int f1650j;

    /* renamed from: k  reason: collision with root package name */
    public final C0483a f1651k;

    /* renamed from: l  reason: collision with root package name */
    public int f1652l;

    /* renamed from: m  reason: collision with root package name */
    public int f1653m;

    /* renamed from: n  reason: collision with root package name */
    public Spliterator f1654n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1655o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f1656p;

    /* renamed from: q  reason: collision with root package name */
    public Runnable f1657q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1658r;

    public abstract H0 K0(C0483a aVar, Spliterator spliterator, boolean z4, IntFunction intFunction);

    public abstract boolean L0(Spliterator spliterator, C0546m2 m2Var);

    public abstract C0487a3 M0();

    public abstract boolean P0();

    public abstract C0546m2 Q0(int i5, C0546m2 m2Var);

    public abstract Spliterator T0(C0483a aVar, Supplier supplier, boolean z4);

    public C0483a(Spliterator spliterator, int i5, boolean z4) {
        this.f1649i = null;
        this.f1654n = spliterator;
        this.f1648h = this;
        int i6 = Z2.f1625g & i5;
        this.f1650j = i6;
        this.f1653m = (~(i6 << 1)) & Z2.f1630l;
        this.f1652l = 0;
        this.f1658r = z4;
    }

    public C0483a(C0483a aVar, int i5) {
        if (!aVar.f1655o) {
            aVar.f1655o = true;
            aVar.f1651k = this;
            this.f1649i = aVar;
            this.f1650j = Z2.f1626h & i5;
            this.f1653m = Z2.e(i5, aVar.f1653m);
            C0483a aVar2 = aVar.f1648h;
            this.f1648h = aVar2;
            if (P0()) {
                aVar2.f1656p = true;
            }
            this.f1652l = aVar.f1652l + 1;
            return;
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    static {
        Class<C0483a> cls = C0483a.class;
    }

    public final Object I0(F3 f32) {
        if (!this.f1655o) {
            this.f1655o = true;
            if (this.f1648h.f1658r) {
                return f32.i(this, R0(f32.v()));
            }
            return f32.f(this, R0(f32.v()));
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    public final H0 J0(IntFunction intFunction) {
        if (!this.f1655o) {
            this.f1655o = true;
            if (!this.f1648h.f1658r || this.f1649i == null || !P0()) {
                return j0(R0(0), true, intFunction);
            }
            this.f1652l = 0;
            C0483a aVar = this.f1649i;
            return N0(aVar, aVar.R0(0), intFunction);
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    public final Spliterator S0() {
        C0483a aVar = this.f1648h;
        if (this != aVar) {
            throw new IllegalStateException();
        } else if (!this.f1655o) {
            this.f1655o = true;
            Spliterator spliterator = aVar.f1654n;
            if (spliterator != null) {
                aVar.f1654n = null;
                return spliterator;
            }
            throw new IllegalStateException("source already consumed or closed");
        } else {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
    }

    public final C0513g sequential() {
        this.f1648h.f1658r = false;
        return this;
    }

    public final C0513g parallel() {
        this.f1648h.f1658r = true;
        return this;
    }

    public final void close() {
        this.f1655o = true;
        this.f1654n = null;
        C0483a aVar = this.f1648h;
        Runnable runnable = aVar.f1657q;
        if (runnable != null) {
            aVar.f1657q = null;
            runnable.run();
        }
    }

    public final C0513g onClose(Runnable runnable) {
        if (!this.f1655o) {
            Objects.requireNonNull(runnable);
            C0483a aVar = this.f1648h;
            Runnable runnable2 = aVar.f1657q;
            if (runnable2 != null) {
                runnable = new E3(runnable2, runnable);
            }
            aVar.f1657q = runnable;
            return this;
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    public Spliterator spliterator() {
        if (!this.f1655o) {
            this.f1655o = true;
            C0483a aVar = this.f1648h;
            if (this != aVar) {
                return T0(this, new C0481q(2, this), aVar.f1658r);
            }
            Spliterator spliterator = aVar.f1654n;
            if (spliterator != null) {
                aVar.f1654n = null;
                return spliterator;
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    public final boolean isParallel() {
        return this.f1648h.f1658r;
    }

    public final H0 j0(Spliterator spliterator, boolean z4, IntFunction intFunction) {
        if (this.f1648h.f1658r) {
            return K0(this, spliterator, z4, intFunction);
        }
        C0608z0 A02 = A0(k0(spliterator), intFunction);
        F0(spliterator, A02);
        return A02.build();
    }

    public final Spliterator R0(int i5) {
        int i6;
        int i7;
        C0483a aVar = this.f1648h;
        Spliterator spliterator = aVar.f1654n;
        if (spliterator != null) {
            aVar.f1654n = null;
            if (aVar.f1658r && aVar.f1656p) {
                C0483a aVar2 = aVar.f1651k;
                int i8 = 1;
                while (aVar != this) {
                    int i9 = aVar2.f1650j;
                    if (aVar2.P0()) {
                        if (Z2.SHORT_CIRCUIT.h(i9)) {
                            i9 &= ~Z2.f1639u;
                        }
                        spliterator = aVar2.O0(aVar, spliterator);
                        if (spliterator.hasCharacteristics(64)) {
                            i6 = (~Z2.f1638t) & i9;
                            i7 = Z2.f1637s;
                        } else {
                            i6 = (~Z2.f1637s) & i9;
                            i7 = Z2.f1638t;
                        }
                        i9 = i6 | i7;
                        i8 = 0;
                    }
                    int i10 = i8 + 1;
                    aVar2.f1652l = i8;
                    aVar2.f1653m = Z2.e(i9, aVar.f1653m);
                    C0483a aVar3 = aVar2;
                    aVar2 = aVar2.f1651k;
                    aVar = aVar3;
                    i8 = i10;
                }
            }
            if (i5 != 0) {
                this.f1653m = Z2.e(i5, this.f1653m);
            }
            return spliterator;
        }
        throw new IllegalStateException("source already consumed or closed");
    }

    public final long k0(Spliterator spliterator) {
        if (Z2.SIZED.h(this.f1653m)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1;
    }

    public final C0546m2 F0(Spliterator spliterator, C0546m2 m2Var) {
        f0(spliterator, G0((C0546m2) Objects.requireNonNull(m2Var)));
        return m2Var;
    }

    public final void f0(Spliterator spliterator, C0546m2 m2Var) {
        Objects.requireNonNull(m2Var);
        if (!Z2.SHORT_CIRCUIT.h(this.f1653m)) {
            m2Var.c(spliterator.getExactSizeIfKnown());
            spliterator.forEachRemaining(m2Var);
            m2Var.end();
            return;
        }
        g0(spliterator, m2Var);
    }

    public final boolean g0(Spliterator spliterator, C0546m2 m2Var) {
        C0483a aVar = this;
        while (aVar.f1652l > 0) {
            aVar = aVar.f1649i;
        }
        m2Var.c(spliterator.getExactSizeIfKnown());
        boolean L02 = aVar.L0(spliterator, m2Var);
        m2Var.end();
        return L02;
    }

    public final C0546m2 G0(C0546m2 m2Var) {
        Objects.requireNonNull(m2Var);
        for (C0483a aVar = this; aVar.f1652l > 0; aVar = aVar.f1649i) {
            m2Var = aVar.Q0(aVar.f1649i.f1653m, m2Var);
        }
        return m2Var;
    }

    public final Spliterator H0(Spliterator spliterator) {
        if (this.f1652l == 0) {
            return spliterator;
        }
        return T0(this, new C0481q(3, spliterator), this.f1648h.f1658r);
    }

    public H0 N0(C0594w1 w1Var, Spliterator spliterator, IntFunction intFunction) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    public Spliterator O0(C0483a aVar, Spliterator spliterator) {
        return N0(aVar, spliterator, new a(8)).spliterator();
    }
}
