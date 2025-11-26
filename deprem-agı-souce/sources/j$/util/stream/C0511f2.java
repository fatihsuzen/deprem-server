package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.f2  reason: case insensitive filesystem */
public abstract class C0511f2 implements C0531j2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0546m2 f1706a;

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

    public final /* synthetic */ void n(Double d5) {
        C0594w1.D(this, d5);
    }

    public C0511f2(C0546m2 m2Var) {
        this.f1706a = (C0546m2) Objects.requireNonNull(m2Var);
    }

    public void c(long j5) {
        this.f1706a.c(j5);
    }

    public void end() {
        this.f1706a.end();
    }

    public boolean e() {
        return this.f1706a.e();
    }
}
