package j$.util.stream;

import j$.util.C0469e;
import j$.util.Spliterator;
import j$.util.W;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.p3  reason: case insensitive filesystem */
public final class C0562p3 extends C0576s3 implements W {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.a(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.f(this, consumer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.u3, j$.util.Spliterator] */
    public final Spliterator a(Spliterator spliterator, long j5, long j6, long j7, long j8) {
        return new C0586u3((W) spliterator, j5, j6, j7, j8);
    }

    public final Object b() {
        return new A0(1);
    }
}
