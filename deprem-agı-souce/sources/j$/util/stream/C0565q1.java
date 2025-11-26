package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Spliterator;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.q1  reason: case insensitive filesystem */
public final class C0565q1 extends C0574s1 implements C0541l2 {

    /* renamed from: h  reason: collision with root package name */
    public final long[] f1766h;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void l(Long l5) {
        C0594w1.H(this, l5);
    }

    public C0565q1(Spliterator spliterator, C0594w1 w1Var, long[] jArr) {
        super(spliterator, w1Var, jArr.length);
        this.f1766h = jArr;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0565q1(j$.util.stream.C0565q1 r10, j$.util.Spliterator r11, long r12, long r14) {
        /*
            r9 = this;
            long[] r0 = r10.f1766h
            int r8 = r0.length
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r14
            r1.<init>(r2, r3, r4, r6, r8)
            long[] r10 = r2.f1766h
            r1.f1766h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0565q1.<init>(j$.util.stream.q1, j$.util.Spliterator, long, long):void");
    }

    public final C0574s1 a(Spliterator spliterator, long j5, long j6) {
        return new C0565q1(this, spliterator, j5, j6);
    }

    public final void accept(long j5) {
        int i5 = this.f1781f;
        if (i5 < this.f1782g) {
            long[] jArr = this.f1766h;
            this.f1781f = i5 + 1;
            jArr[i5] = j5;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f1781f));
    }
}
