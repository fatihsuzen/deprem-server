package j$.util.stream;

import j$.util.C0469e;
import j$.util.Spliterator;
import j$.util.c0;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.r3  reason: case insensitive filesystem */
public final class C0571r3 extends C0576s3 implements c0 {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.c(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.h(this, consumer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.u3, j$.util.Spliterator] */
    public final Spliterator a(Spliterator spliterator, long j5, long j6, long j7, long j8) {
        return new C0586u3((c0) spliterator, j5, j6, j7, j8);
    }

    public final Object b() {
        return new E0(1);
    }
}
