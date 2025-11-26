package j$.util.stream;

import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.i2  reason: case insensitive filesystem */
public abstract class C0526i2 implements C0546m2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0546m2 f1716a;

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

    public C0526i2(C0546m2 m2Var) {
        this.f1716a = (C0546m2) Objects.requireNonNull(m2Var);
    }

    public void c(long j5) {
        this.f1716a.c(j5);
    }

    public void end() {
        this.f1716a.end();
    }

    public boolean e() {
        return this.f1716a.e();
    }
}
