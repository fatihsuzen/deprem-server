package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.g2  reason: case insensitive filesystem */
public abstract class C0516g2 implements C0536k2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0546m2 f1710a;

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

    public C0516g2(C0546m2 m2Var) {
        this.f1710a = (C0546m2) Objects.requireNonNull(m2Var);
    }

    public void c(long j5) {
        this.f1710a.c(j5);
    }

    public void end() {
        this.f1710a.end();
    }

    public boolean e() {
        return this.f1710a.e();
    }
}
