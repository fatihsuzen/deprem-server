package j$.util.stream;

import j$.util.C0469e;
import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.t3  reason: case insensitive filesystem */
public final class C0581t3 extends C0586u3 implements Spliterator {
    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0581t3(j$.util.Spliterator r13, long r14, long r16) {
        /*
            r12 = this;
            long r0 = r13.estimateSize()
            r6 = r16
            long r10 = java.lang.Math.min(r0, r6)
            r8 = 0
            r2 = r12
            r3 = r13
            r4 = r14
            r2.<init>(r3, r4, r6, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0581t3.<init>(j$.util.Spliterator, long, long):void");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.u3, j$.util.Spliterator] */
    public final Spliterator a(Spliterator spliterator, long j5, long j6, long j7, long j8) {
        return new C0586u3(spliterator, j5, j6, j7, j8);
    }

    public final boolean tryAdvance(Consumer consumer) {
        long j5;
        Objects.requireNonNull(consumer);
        long j6 = this.f1801e;
        long j7 = this.f1797a;
        if (j7 >= j6) {
            return false;
        }
        while (true) {
            j5 = this.f1800d;
            if (j7 <= j5) {
                break;
            }
            this.f1799c.tryAdvance(new C0494c0(21));
            this.f1800d++;
        }
        if (j5 >= this.f1801e) {
            return false;
        }
        this.f1800d = j5 + 1;
        return this.f1799c.tryAdvance(consumer);
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        long j5 = this.f1801e;
        long j6 = this.f1797a;
        if (j6 < j5) {
            long j7 = this.f1800d;
            if (j7 < j5) {
                if (j7 < j6 || this.f1799c.estimateSize() + j7 > this.f1798b) {
                    while (j6 > this.f1800d) {
                        this.f1799c.tryAdvance(new C0494c0(22));
                        this.f1800d++;
                    }
                    while (this.f1800d < this.f1801e) {
                        this.f1799c.tryAdvance(consumer);
                        this.f1800d++;
                    }
                    return;
                }
                this.f1799c.forEachRemaining(consumer);
                this.f1800d = this.f1801e;
            }
        }
    }
}
