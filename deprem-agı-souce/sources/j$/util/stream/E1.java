package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

public final class E1 extends S1 implements R1, C0531j2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f1466b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ObjDoubleConsumer f1467c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C0558p f1468d;

    public final /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public final /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final /* synthetic */ void end() {
    }

    public final /* synthetic */ void n(Double d5) {
        C0594w1.D(this, d5);
    }

    public final void j(R1 r12) {
        this.f1576a = this.f1468d.apply(this.f1576a, ((E1) r12).f1576a);
    }

    public final void c(long j5) {
        this.f1576a = this.f1466b.get();
    }

    public final void accept(double d5) {
        this.f1467c.accept(this.f1576a, d5);
    }

    public E1(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, C0558p pVar) {
        this.f1466b = supplier;
        this.f1467c = objDoubleConsumer;
        this.f1468d = pVar;
    }
}
