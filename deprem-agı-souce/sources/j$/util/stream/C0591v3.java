package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C0469e;
import j$.util.Spliterator;
import j$.util.W;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.v3  reason: case insensitive filesystem */
public final class C0591v3 extends C0606y3 implements W, DoubleConsumer {

    /* renamed from: f  reason: collision with root package name */
    public double f1811f;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.a(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.f(this, consumer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.B3, j$.util.Spliterator] */
    public final Spliterator b(Spliterator spliterator) {
        return new B3((W) spliterator, this);
    }

    public final void g(Object obj) {
        ((DoubleConsumer) obj).accept(this.f1811f);
    }

    public final void accept(double d5) {
        this.f1811f = d5;
    }

    public final C0512f3 i(int i5) {
        return new C0497c3(i5);
    }
}
