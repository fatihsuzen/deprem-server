package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class J1 extends S1 implements R1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f1507b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f1508c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f1509d;

    public final /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public final /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public final /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final /* synthetic */ void end() {
    }

    public final void j(R1 r12) {
        this.f1576a = this.f1509d.apply(this.f1576a, ((J1) r12).f1576a);
    }

    public final void c(long j5) {
        this.f1576a = this.f1507b.get();
    }

    public final void accept(Object obj) {
        this.f1508c.accept(this.f1576a, obj);
    }

    public J1(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator) {
        this.f1507b = supplier;
        this.f1508c = biConsumer;
        this.f1509d = binaryOperator;
    }
}
