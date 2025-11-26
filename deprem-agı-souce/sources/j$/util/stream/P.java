package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;

public final class P extends Q {

    /* renamed from: b  reason: collision with root package name */
    public final Consumer f1559b;

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

    public P(Consumer consumer, boolean z4) {
        super(z4);
        this.f1559b = consumer;
    }

    public final void accept(Object obj) {
        this.f1559b.accept(obj);
    }
}
