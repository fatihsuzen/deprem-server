package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.E;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;

public final class Q1 implements R1, C0541l2 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1564a;

    /* renamed from: b  reason: collision with root package name */
    public long f1565b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LongBinaryOperator f1566c;

    public final /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public final /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final /* synthetic */ void end() {
    }

    public final /* synthetic */ void l(Long l5) {
        C0594w1.H(this, l5);
    }

    public Q1(LongBinaryOperator longBinaryOperator) {
        this.f1566c = longBinaryOperator;
    }

    public final void j(R1 r12) {
        Q1 q12 = (Q1) r12;
        if (!q12.f1564a) {
            accept(q12.f1565b);
        }
    }

    public final void c(long j5) {
        this.f1564a = true;
        this.f1565b = 0;
    }

    public final void accept(long j5) {
        if (this.f1564a) {
            this.f1564a = false;
            this.f1565b = j5;
            return;
        }
        this.f1565b = this.f1566c.applyAsLong(this.f1565b, j5);
    }

    public final Object get() {
        return this.f1564a ? E.f1261c : new E(this.f1565b);
    }
}
