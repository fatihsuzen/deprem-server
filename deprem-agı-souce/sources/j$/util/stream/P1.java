package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;

public final class P1 implements R1, C0541l2 {

    /* renamed from: a  reason: collision with root package name */
    public long f1560a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f1561b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LongBinaryOperator f1562c;

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

    public P1(long j5, LongBinaryOperator longBinaryOperator) {
        this.f1561b = j5;
        this.f1562c = longBinaryOperator;
    }

    public final void j(R1 r12) {
        accept(((P1) r12).f1560a);
    }

    public final void c(long j5) {
        this.f1560a = this.f1561b;
    }

    public final void accept(long j5) {
        this.f1560a = this.f1562c.applyAsLong(this.f1560a, j5);
    }

    public final Object get() {
        return Long.valueOf(this.f1560a);
    }
}
