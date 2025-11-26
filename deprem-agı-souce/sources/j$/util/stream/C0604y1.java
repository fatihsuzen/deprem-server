package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.y1  reason: case insensitive filesystem */
public final class C0604y1 extends S1 implements R1, C0541l2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f1832b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ObjLongConsumer f1833c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C0558p f1834d;

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

    public final void j(R1 r12) {
        this.f1576a = this.f1834d.apply(this.f1576a, ((C0604y1) r12).f1576a);
    }

    public final void c(long j5) {
        this.f1576a = this.f1832b.get();
    }

    public final void accept(long j5) {
        this.f1833c.accept(this.f1576a, j5);
    }

    public C0604y1(Supplier supplier, ObjLongConsumer objLongConsumer, C0558p pVar) {
        this.f1832b = supplier;
        this.f1833c = objLongConsumer;
        this.f1834d = pVar;
    }
}
