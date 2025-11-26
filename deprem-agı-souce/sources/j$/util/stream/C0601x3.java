package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C0469e;
import j$.util.Spliterator;
import j$.util.c0;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.x3  reason: case insensitive filesystem */
public final class C0601x3 extends C0606y3 implements c0, LongConsumer {

    /* renamed from: f  reason: collision with root package name */
    public long f1831f;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.c(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.h(this, consumer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.B3, j$.util.Spliterator] */
    public final Spliterator b(Spliterator spliterator) {
        return new B3((c0) spliterator, this);
    }

    public final void g(Object obj) {
        ((LongConsumer) obj).accept(this.f1831f);
    }

    public final void accept(long j5) {
        this.f1831f = j5;
    }

    public final C0512f3 i(int i5) {
        return new C0507e3(i5);
    }
}
