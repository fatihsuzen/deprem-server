package j$.util.stream;

import j$.util.C0469e;
import j$.util.Objects;
import j$.util.f0;
import java.util.Comparator;

/* renamed from: j$.util.stream.s3  reason: case insensitive filesystem */
public abstract class C0576s3 extends C0586u3 implements f0 {
    public abstract Object b();

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
    public C0576s3(j$.util.f0 r13, long r14, long r16) {
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
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0576s3.<init>(j$.util.f0, long, long):void");
    }

    public final boolean tryAdvance(Object obj) {
        long j5;
        Objects.requireNonNull(obj);
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
            ((f0) this.f1799c).tryAdvance(b());
            this.f1800d++;
        }
        if (j5 >= this.f1801e) {
            return false;
        }
        this.f1800d = j5 + 1;
        return ((f0) this.f1799c).tryAdvance(obj);
    }

    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        long j5 = this.f1801e;
        long j6 = this.f1797a;
        if (j6 < j5) {
            long j7 = this.f1800d;
            if (j7 < j5) {
                if (j7 < j6 || ((f0) this.f1799c).estimateSize() + j7 > this.f1798b) {
                    while (j6 > this.f1800d) {
                        ((f0) this.f1799c).tryAdvance(b());
                        this.f1800d++;
                    }
                    while (this.f1800d < this.f1801e) {
                        ((f0) this.f1799c).tryAdvance(obj);
                        this.f1800d++;
                    }
                    return;
                }
                ((f0) this.f1799c).forEachRemaining(obj);
                this.f1800d = this.f1801e;
            }
        }
    }
}
