package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.LongConsumer;

public final class V1 extends X1 implements C0541l2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void l(Long l5) {
        C0594w1.H(this, l5);
    }

    public final Object get() {
        return Long.valueOf(this.f1608b);
    }

    public final void j(R1 r12) {
        this.f1608b += ((X1) r12).f1608b;
    }

    public final void accept(long j5) {
        this.f1608b++;
    }
}
