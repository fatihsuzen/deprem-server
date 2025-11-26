package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.D;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

public final class N1 implements R1, C0536k2 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1544a;

    /* renamed from: b  reason: collision with root package name */
    public int f1545b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IntBinaryOperator f1546c;

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

    public N1(IntBinaryOperator intBinaryOperator) {
        this.f1546c = intBinaryOperator;
    }

    public final void j(R1 r12) {
        N1 n12 = (N1) r12;
        if (!n12.f1544a) {
            accept(n12.f1545b);
        }
    }

    public final void c(long j5) {
        this.f1544a = true;
        this.f1545b = 0;
    }

    public final void accept(int i5) {
        if (this.f1544a) {
            this.f1544a = false;
            this.f1545b = i5;
            return;
        }
        this.f1545b = this.f1546c.applyAsInt(this.f1545b, i5);
    }

    public final Object get() {
        return this.f1544a ? D.f1258c : new D(this.f1545b);
    }
}
