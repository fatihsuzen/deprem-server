package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.r0  reason: case insensitive filesystem */
public final class C0568r0 extends C0578t0 implements C0541l2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void l(Long l5) {
        C0594w1.H(this, l5);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Throwable, java.util.function.LongPredicate] */
    public final void accept(long j5) {
        if (!this.f1786a) {
            ? r02 = 0;
            r02.test(j5);
            throw r02;
        }
    }
}
