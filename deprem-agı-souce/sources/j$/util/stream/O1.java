package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

public final class O1 extends S1 implements R1, C0536k2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f1554b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ObjIntConsumer f1555c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C0558p f1556d;

    public final /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public final /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void d(Integer num) {
        C0594w1.F(this, num);
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final /* synthetic */ void end() {
    }

    public final void j(R1 r12) {
        this.f1576a = this.f1556d.apply(this.f1576a, ((O1) r12).f1576a);
    }

    public final void c(long j5) {
        this.f1576a = this.f1554b.get();
    }

    public final void accept(int i5) {
        this.f1555c.accept(this.f1576a, i5);
    }

    public O1(Supplier supplier, ObjIntConsumer objIntConsumer, C0558p pVar) {
        this.f1554b = supplier;
        this.f1555c = objIntConsumer;
        this.f1556d = pVar;
    }
}
