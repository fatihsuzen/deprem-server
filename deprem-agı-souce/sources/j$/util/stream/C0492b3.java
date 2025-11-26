package j$.util.stream;

import j$.util.C0469e;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.b3  reason: case insensitive filesystem */
public abstract class C0492b3 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1664a;

    /* renamed from: b  reason: collision with root package name */
    public final C0483a f1665b;

    /* renamed from: c  reason: collision with root package name */
    public Supplier f1666c;

    /* renamed from: d  reason: collision with root package name */
    public Spliterator f1667d;

    /* renamed from: e  reason: collision with root package name */
    public C0546m2 f1668e;

    /* renamed from: f  reason: collision with root package name */
    public BooleanSupplier f1669f;

    /* renamed from: g  reason: collision with root package name */
    public long f1670g;

    /* renamed from: h  reason: collision with root package name */
    public C0493c f1671h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1672i;

    public abstract void d();

    public abstract C0492b3 e(Spliterator spliterator);

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public C0492b3(C0483a aVar, Supplier supplier, boolean z4) {
        this.f1665b = aVar;
        this.f1666c = supplier;
        this.f1667d = null;
        this.f1664a = z4;
    }

    public C0492b3(C0483a aVar, Spliterator spliterator, boolean z4) {
        this.f1665b = aVar;
        this.f1666c = null;
        this.f1667d = spliterator;
        this.f1664a = z4;
    }

    public final void c() {
        if (this.f1667d == null) {
            this.f1667d = (Spliterator) this.f1666c.get();
            this.f1666c = null;
        }
    }

    public final boolean a() {
        C0493c cVar = this.f1671h;
        boolean z4 = false;
        if (cVar != null) {
            long j5 = this.f1670g + 1;
            this.f1670g = j5;
            if (j5 < cVar.count()) {
                z4 = true;
            }
            if (z4) {
                return z4;
            }
            this.f1670g = 0;
            this.f1671h.clear();
            return b();
        } else if (this.f1672i) {
            return false;
        } else {
            c();
            d();
            this.f1670g = 0;
            this.f1668e.c(this.f1667d.getExactSizeIfKnown());
            return b();
        }
    }

    public Spliterator trySplit() {
        if (!this.f1664a || this.f1671h != null || this.f1672i) {
            return null;
        }
        c();
        Spliterator trySplit = this.f1667d.trySplit();
        if (trySplit == null) {
            return null;
        }
        return e(trySplit);
    }

    public final boolean b() {
        while (this.f1671h.count() == 0) {
            if (this.f1668e.e() || !this.f1669f.getAsBoolean()) {
                if (this.f1672i) {
                    return false;
                }
                this.f1668e.end();
                this.f1672i = true;
            }
        }
        return true;
    }

    public final long estimateSize() {
        c();
        return this.f1667d.estimateSize();
    }

    public final long getExactSizeIfKnown() {
        c();
        if (Z2.SIZED.h(this.f1665b.f1653m)) {
            return this.f1667d.getExactSizeIfKnown();
        }
        return -1;
    }

    public final int characteristics() {
        c();
        int i5 = this.f1665b.f1653m;
        int i6 = i5 & ((~i5) >> 1) & Z2.f1628j & Z2.f1624f;
        return (i6 & 64) != 0 ? (i6 & -16449) | (this.f1667d.characteristics() & 16448) : i6;
    }

    public final Comparator getComparator() {
        if (C0469e.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    public final String toString() {
        return String.format("%s[%s]", new Object[]{getClass().getName(), this.f1667d});
    }
}
