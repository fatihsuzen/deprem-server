package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Spliterator;
import java.util.function.LongConsumer;

public final class O extends Q implements C0541l2 {

    /* renamed from: b  reason: collision with root package name */
    public final LongConsumer f1553b;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    public final /* synthetic */ void l(Long l5) {
        C0594w1.H(this, l5);
    }

    public final Object f(C0483a aVar, Spliterator spliterator) {
        aVar.F0(spliterator, this);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object i(C0594w1 w1Var, Spliterator spliterator) {
        a(w1Var, spliterator);
        return null;
    }

    public O(LongConsumer longConsumer, boolean z4) {
        super(z4);
        this.f1553b = longConsumer;
    }

    public final void accept(long j5) {
        this.f1553b.accept(j5);
    }
}
