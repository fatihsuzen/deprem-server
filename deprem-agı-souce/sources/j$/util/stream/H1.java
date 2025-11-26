package j$.util.stream;

import j$.util.B;
import j$.util.function.Consumer$CC;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public final class H1 implements R1 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1485a;

    /* renamed from: b  reason: collision with root package name */
    public Object f1486b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f1487c;

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

    public H1(BinaryOperator binaryOperator) {
        this.f1487c = binaryOperator;
    }

    public final void j(R1 r12) {
        H1 h12 = (H1) r12;
        if (!h12.f1485a) {
            accept(h12.f1486b);
        }
    }

    public final void c(long j5) {
        this.f1485a = true;
        this.f1486b = null;
    }

    public final void accept(Object obj) {
        if (this.f1485a) {
            this.f1485a = false;
            this.f1486b = obj;
            return;
        }
        this.f1486b = this.f1487c.apply(this.f1486b, obj);
    }

    public final Object get() {
        return this.f1485a ? B.f1253b : new B(this.f1486b);
    }
}
