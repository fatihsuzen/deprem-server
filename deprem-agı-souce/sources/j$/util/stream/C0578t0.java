package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.t0  reason: case insensitive filesystem */
public abstract class C0578t0 implements C0546m2 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1786a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1787b;

    public /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void c(long j5) {
    }

    public final /* synthetic */ void end() {
    }

    public C0578t0(C0583u0 u0Var) {
        this.f1787b = !u0Var.f1794b;
    }

    public final boolean e() {
        return this.f1786a;
    }
}
