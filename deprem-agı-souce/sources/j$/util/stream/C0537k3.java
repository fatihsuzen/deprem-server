package j$.util.stream;

import j$.util.C0469e;
import j$.util.C0481q;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.W;
import j$.util.f0;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.k3  reason: case insensitive filesystem */
public final class C0537k3 extends C0492b3 implements W {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.a(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.f(this, consumer);
    }

    public final C0492b3 e(Spliterator spliterator) {
        return new C0492b3(this.f1665b, spliterator, this.f1664a);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, j$.util.stream.c, java.util.function.DoubleConsumer, j$.util.stream.V2] */
    public final void d() {
        ? v22 = new V2();
        this.f1671h = v22;
        Objects.requireNonNull(v22);
        this.f1668e = this.f1665b.G0(new C0532j3(v22, 1));
        this.f1669f = new C0481q(10, this);
    }

    public final Spliterator trySplit() {
        return (W) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final W m222trySplit() {
        return (W) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final f0 m223trySplit() {
        return (W) super.trySplit();
    }

    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        double d5;
        Objects.requireNonNull(doubleConsumer);
        boolean a5 = a();
        if (a5) {
            P2 p22 = (P2) this.f1671h;
            long j5 = this.f1670g;
            int r5 = p22.r(j5);
            if (p22.f1678c == 0 && r5 == 0) {
                d5 = ((double[]) p22.f1595e)[(int) j5];
            } else {
                d5 = ((double[][]) p22.f1596f)[r5][(int) (j5 - p22.f1679d[r5])];
            }
            doubleConsumer.accept(d5);
        }
        return a5;
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        if (this.f1671h != null || this.f1672i) {
            do {
            } while (tryAdvance(doubleConsumer));
            return;
        }
        Objects.requireNonNull(doubleConsumer);
        c();
        Objects.requireNonNull(doubleConsumer);
        C0532j3 j3Var = new C0532j3(doubleConsumer, 0);
        this.f1665b.F0(this.f1667d, j3Var);
        this.f1672i = true;
    }
}
