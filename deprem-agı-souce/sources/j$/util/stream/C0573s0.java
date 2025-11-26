package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.s0  reason: case insensitive filesystem */
public final class C0573s0 extends C0578t0 implements C0531j2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void n(Double d5) {
        C0594w1.D(this, d5);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Throwable, java.util.function.DoublePredicate] */
    public final void accept(double d5) {
        if (!this.f1786a) {
            ? r02 = 0;
            r02.test(d5);
            throw r02;
        }
    }
}
