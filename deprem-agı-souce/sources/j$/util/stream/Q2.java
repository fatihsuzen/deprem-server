package j$.util.stream;

import j$.util.C0469e;
import j$.util.Objects;
import j$.util.Z;
import j$.util.f0;
import j$.util.r0;
import j$.util.u0;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class Q2 extends U2 implements Z {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ R2 f1567g;

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.b(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.g(this, consumer);
    }

    public final void a(int i5, Object obj, Object obj2) {
        ((IntConsumer) obj2).accept(((int[]) obj)[i5]);
    }

    public final f0 b(Object obj, int i5, int i6) {
        int[] iArr = (int[]) obj;
        int i7 = i6 + i5;
        u0.a(((int[]) Objects.requireNonNull(iArr)).length, i5, i7);
        return new r0(iArr, i5, i7, 1040);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Q2(R2 r22, int i5, int i6, int i7, int i8) {
        super(r22, i5, i6, i7, i8);
        this.f1567g = r22;
    }

    public final f0 c(int i5, int i6, int i7, int i8) {
        return new Q2(this.f1567g, i5, i6, i7, i8);
    }
}
