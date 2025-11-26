package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;

public final class C1 implements R1, C0531j2 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1451a;

    /* renamed from: b  reason: collision with root package name */
    public double f1452b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DoubleBinaryOperator f1453c;

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

    public C1(DoubleBinaryOperator doubleBinaryOperator) {
        this.f1453c = doubleBinaryOperator;
    }

    public final void j(R1 r12) {
        C1 c12 = (C1) r12;
        if (!c12.f1451a) {
            accept(c12.f1452b);
        }
    }

    public final void c(long j5) {
        this.f1451a = true;
        this.f1452b = 0.0d;
    }

    public final void accept(double d5) {
        if (this.f1451a) {
            this.f1451a = false;
            this.f1452b = d5;
            return;
        }
        this.f1452b = this.f1453c.applyAsDouble(this.f1452b, d5);
    }

    public final Object get() {
        return this.f1451a ? C.f1255c : new C(this.f1452b);
    }
}
