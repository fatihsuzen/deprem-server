package j$.util.stream;

import j$.util.C0469e;
import j$.util.Spliterator;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

/* renamed from: j$.util.stream.k1  reason: case insensitive filesystem */
public abstract class C0535k1 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public H0 f1729a;

    /* renamed from: b  reason: collision with root package name */
    public int f1730b;

    /* renamed from: c  reason: collision with root package name */
    public Spliterator f1731c;

    /* renamed from: d  reason: collision with root package name */
    public Spliterator f1732d;

    /* renamed from: e  reason: collision with root package name */
    public Deque f1733e;

    public final int characteristics() {
        return 64;
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public C0535k1(H0 h02) {
        this.f1729a = h02;
    }

    public final Deque b() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int o5 = this.f1729a.o();
        while (true) {
            o5--;
            if (o5 < this.f1730b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.f1729a.a(o5));
        }
    }

    public static H0 a(Deque deque) {
        while (true) {
            ArrayDeque arrayDeque = (ArrayDeque) deque;
            H0 h02 = (H0) arrayDeque.pollFirst();
            if (h02 == null) {
                return null;
            }
            if (h02.o() != 0) {
                for (int o5 = h02.o() - 1; o5 >= 0; o5--) {
                    arrayDeque.addFirst(h02.a(o5));
                }
            } else if (h02.count() > 0) {
                return h02;
            }
        }
    }

    public final boolean c() {
        if (this.f1729a == null) {
            return false;
        }
        if (this.f1732d != null) {
            return true;
        }
        Spliterator spliterator = this.f1731c;
        if (spliterator == null) {
            Deque b5 = b();
            this.f1733e = b5;
            H0 a5 = a(b5);
            if (a5 != null) {
                this.f1732d = a5.spliterator();
                return true;
            }
            this.f1729a = null;
            return false;
        }
        this.f1732d = spliterator;
        return true;
    }

    public final Spliterator trySplit() {
        H0 h02 = this.f1729a;
        if (h02 == null || this.f1732d != null) {
            return null;
        }
        Spliterator spliterator = this.f1731c;
        if (spliterator != null) {
            return spliterator.trySplit();
        }
        if (this.f1730b < h02.o() - 1) {
            H0 h03 = this.f1729a;
            int i5 = this.f1730b;
            this.f1730b = i5 + 1;
            return h03.a(i5).spliterator();
        }
        H0 a5 = this.f1729a.a(this.f1730b);
        this.f1729a = a5;
        if (a5.o() == 0) {
            Spliterator spliterator2 = this.f1729a.spliterator();
            this.f1731c = spliterator2;
            return spliterator2.trySplit();
        }
        H0 h04 = this.f1729a;
        this.f1730b = 1;
        return h04.a(0).spliterator();
    }

    public final long estimateSize() {
        long j5 = 0;
        if (this.f1729a == null) {
            return 0;
        }
        Spliterator spliterator = this.f1731c;
        if (spliterator != null) {
            return spliterator.estimateSize();
        }
        for (int i5 = this.f1730b; i5 < this.f1729a.o(); i5++) {
            j5 += this.f1729a.a(i5).count();
        }
        return j5;
    }
}
