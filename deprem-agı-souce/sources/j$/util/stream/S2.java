package j$.util.stream;

import j$.util.C0469e;
import j$.util.Objects;
import j$.util.c0;
import j$.util.f0;
import j$.util.t0;
import j$.util.u0;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class S2 extends U2 implements c0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T2 f1577g;

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.c(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.h(this, consumer);
    }

    public final void a(int i5, Object obj, Object obj2) {
        ((LongConsumer) obj2).accept(((long[]) obj)[i5]);
    }

    public final f0 b(Object obj, int i5, int i6) {
        long[] jArr = (long[]) obj;
        int i7 = i6 + i5;
        u0.a(((long[]) Objects.requireNonNull(jArr)).length, i5, i7);
        return new t0(jArr, i5, i7, 1040);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public S2(T2 t22, int i5, int i6, int i7, int i8) {
        super(t22, i5, i6, i7, i8);
        this.f1577g = t22;
    }

    public final f0 c(int i5, int i6, int i7, int i8) {
        return new S2(this.f1577g, i5, i6, i7, i8);
    }
}
