package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.DoubleConsumer;

public final class T1 extends X1 implements C0531j2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void n(Double d5) {
        C0594w1.D(this, d5);
    }

    public final Object get() {
        return Long.valueOf(this.f1608b);
    }

    public final void j(R1 r12) {
        this.f1608b += ((X1) r12).f1608b;
    }

    public final void accept(double d5) {
        this.f1608b++;
    }
}
