package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.q0  reason: case insensitive filesystem */
public final class C0564q0 extends C0578t0 implements C0536k2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void d(Integer num) {
        C0594w1.F(this, num);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Throwable, java.util.function.IntPredicate] */
    public final void accept(int i5) {
        if (!this.f1786a) {
            ? r02 = 0;
            r02.test(i5);
            throw r02;
        }
    }
}
