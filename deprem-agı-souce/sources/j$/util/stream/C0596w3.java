package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C0469e;
import j$.util.Spliterator;
import j$.util.Z;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.w3  reason: case insensitive filesystem */
public final class C0596w3 extends C0606y3 implements Z, IntConsumer {

    /* renamed from: f  reason: collision with root package name */
    public int f1827f;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.b(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.g(this, consumer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.B3, j$.util.Spliterator] */
    public final Spliterator b(Spliterator spliterator) {
        return new B3((Z) spliterator, this);
    }

    public final void g(Object obj) {
        ((IntConsumer) obj).accept(this.f1827f);
    }

    public final void accept(int i5) {
        this.f1827f = i5;
    }

    public final C0512f3 i(int i5) {
        return new C0502d3(i5);
    }
}
