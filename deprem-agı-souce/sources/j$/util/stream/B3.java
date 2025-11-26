package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;

public abstract class B3 {

    /* renamed from: a  reason: collision with root package name */
    public final Spliterator f1444a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1445b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1446c;

    /* renamed from: d  reason: collision with root package name */
    public final long f1447d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicLong f1448e;

    public abstract Spliterator b(Spliterator spliterator);

    public B3(Spliterator spliterator, long j5, long j6) {
        this.f1444a = spliterator;
        long j7 = 0;
        int i5 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
        this.f1445b = i5 < 0;
        this.f1447d = i5 >= 0 ? j6 : j7;
        this.f1446c = 128;
        this.f1448e = new AtomicLong(i5 >= 0 ? j5 + j6 : j5);
    }

    public B3(Spliterator spliterator, B3 b32) {
        this.f1444a = spliterator;
        this.f1445b = b32.f1445b;
        this.f1448e = b32.f1448e;
        this.f1447d = b32.f1447d;
        this.f1446c = b32.f1446c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(long r11) {
        /*
            r10 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicLong r0 = r10.f1448e
            long r0 = r0.get()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            boolean r5 = r10.f1445b
            if (r4 != 0) goto L_0x0012
            if (r5 == 0) goto L_0x0011
            return r11
        L_0x0011:
            return r2
        L_0x0012:
            long r6 = java.lang.Math.min(r0, r11)
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0024
            java.util.concurrent.atomic.AtomicLong r4 = r10.f1448e
            long r8 = r0 - r6
            boolean r4 = r4.compareAndSet(r0, r8)
            if (r4 == 0) goto L_0x0000
        L_0x0024:
            if (r5 == 0) goto L_0x002c
            long r11 = r11 - r6
            long r11 = java.lang.Math.max(r11, r2)
            return r11
        L_0x002c:
            long r11 = r10.f1447d
            int r4 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r4 <= 0) goto L_0x0039
            long r0 = r0 - r11
            long r6 = r6 - r0
            long r11 = java.lang.Math.max(r6, r2)
            return r11
        L_0x0039:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.B3.a(long):long");
    }

    public final A3 f() {
        if (this.f1448e.get() > 0) {
            return A3.MAYBE_MORE;
        }
        return this.f1445b ? A3.UNLIMITED : A3.NO_MORE;
    }

    public final Spliterator trySplit() {
        Spliterator trySplit;
        if (this.f1448e.get() == 0 || (trySplit = this.f1444a.trySplit()) == null) {
            return null;
        }
        return b(trySplit);
    }

    public final long estimateSize() {
        return this.f1444a.estimateSize();
    }

    public final int characteristics() {
        return this.f1444a.characteristics() & -16465;
    }
}
