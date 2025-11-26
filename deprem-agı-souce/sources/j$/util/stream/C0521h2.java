package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.h2  reason: case insensitive filesystem */
public abstract class C0521h2 implements C0541l2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0546m2 f1713a;

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

    public final /* synthetic */ void l(Long l5) {
        C0594w1.H(this, l5);
    }

    public C0521h2(C0546m2 m2Var) {
        this.f1713a = (C0546m2) Objects.requireNonNull(m2Var);
    }

    public void c(long j5) {
        this.f1713a.c(j5);
    }

    public void end() {
        this.f1713a.end();
    }

    public boolean e() {
        return this.f1713a.e();
    }
}
