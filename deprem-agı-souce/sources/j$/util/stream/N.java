package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Spliterator;
import java.util.function.IntConsumer;

public final class N extends Q implements C0536k2 {

    /* renamed from: b  reason: collision with root package name */
    public final IntConsumer f1540b;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void d(Integer num) {
        C0594w1.F(this, num);
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    public final Object f(C0483a aVar, Spliterator spliterator) {
        aVar.F0(spliterator, this);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object i(C0594w1 w1Var, Spliterator spliterator) {
        a(w1Var, spliterator);
        return null;
    }

    public N(IntConsumer intConsumer, boolean z4) {
        super(z4);
        this.f1540b = intConsumer;
    }

    public final void accept(int i5) {
        this.f1540b.accept(i5);
    }
}
