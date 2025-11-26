package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;

public final class A1 implements R1, C0531j2 {

    /* renamed from: a  reason: collision with root package name */
    public double f1432a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ double f1433b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DoubleBinaryOperator f1434c;

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

    public A1(double d5, DoubleBinaryOperator doubleBinaryOperator) {
        this.f1433b = d5;
        this.f1434c = doubleBinaryOperator;
    }

    public final void j(R1 r12) {
        accept(((A1) r12).f1432a);
    }

    public final void c(long j5) {
        this.f1432a = this.f1433b;
    }

    public final void accept(double d5) {
        this.f1432a = this.f1434c.applyAsDouble(this.f1432a, d5);
    }

    public final Object get() {
        return Double.valueOf(this.f1432a);
    }
}
