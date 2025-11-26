package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Spliterator;
import java.util.function.DoubleConsumer;

public final class M extends Q implements C0531j2 {

    /* renamed from: b  reason: collision with root package name */
    public final DoubleConsumer f1534b;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    public final /* synthetic */ void n(Double d5) {
        C0594w1.D(this, d5);
    }

    public final Object f(C0483a aVar, Spliterator spliterator) {
        aVar.F0(spliterator, this);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object i(C0594w1 w1Var, Spliterator spliterator) {
        a(w1Var, spliterator);
        return null;
    }

    public M(DoubleConsumer doubleConsumer, boolean z4) {
        super(z4);
        this.f1534b = doubleConsumer;
    }

    public final void accept(double d5) {
        this.f1534b.accept(d5);
    }
}
