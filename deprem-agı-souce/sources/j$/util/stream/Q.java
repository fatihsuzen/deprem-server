package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

public abstract class Q implements F3, G3 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1563a;

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

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final /* synthetic */ void end() {
    }

    public Q(boolean z4) {
        this.f1563a = z4;
    }

    public final int v() {
        if (this.f1563a) {
            return 0;
        }
        return Z2.f1636r;
    }

    public final void a(C0594w1 w1Var, Spliterator spliterator) {
        if (this.f1563a) {
            new S(w1Var, spliterator, this).invoke();
        } else {
            new T(w1Var, spliterator, w1Var.G0(this)).invoke();
        }
    }
}
