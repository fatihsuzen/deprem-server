package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;

public final class U1 extends X1 implements C0536k2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void d(Integer num) {
        C0594w1.F(this, num);
    }

    public final Object get() {
        return Long.valueOf(this.f1608b);
    }

    public final void j(R1 r12) {
        this.f1608b += ((X1) r12).f1608b;
    }

    public final void accept(int i5) {
        this.f1608b++;
    }
}
