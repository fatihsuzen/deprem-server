package j$.util.stream;

import j$.util.C0469e;
import j$.util.Objects;
import j$.util.W;
import j$.util.f0;
import j$.util.m0;
import j$.util.u0;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class O2 extends U2 implements W {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ P2 f1557g;

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.a(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.f(this, consumer);
    }

    public final void a(int i5, Object obj, Object obj2) {
        ((DoubleConsumer) obj2).accept(((double[]) obj)[i5]);
    }

    public final f0 b(Object obj, int i5, int i6) {
        double[] dArr = (double[]) obj;
        int i7 = i6 + i5;
        u0.a(((double[]) Objects.requireNonNull(dArr)).length, i5, i7);
        return new m0(dArr, i5, i7, 1040);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public O2(P2 p22, int i5, int i6, int i7, int i8) {
        super(p22, i5, i6, i7, i8);
        this.f1557g = p22;
    }

    public final f0 c(int i5, int i6, int i7, int i8) {
        return new O2(this.f1557g, i5, i6, i7, i8);
    }
}
