package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public final class G1 extends S1 implements R1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1479b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BiFunction f1480c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f1481d;

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
        this.f1576a = this.f1481d.apply(this.f1576a, ((G1) r12).f1576a);
    }

    public final void c(long j5) {
        this.f1576a = this.f1479b;
    }

    public final void accept(Object obj) {
        this.f1576a = this.f1480c.apply(this.f1576a, obj);
    }

    public G1(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        this.f1479b = obj;
        this.f1480c = biFunction;
        this.f1481d = binaryOperator;
    }
}
