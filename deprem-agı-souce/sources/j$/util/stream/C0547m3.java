package j$.util.stream;

import j$.util.C0469e;
import j$.util.C0481q;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Z;
import j$.util.f0;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.m3  reason: case insensitive filesystem */
public final class C0547m3 extends C0492b3 implements Z {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.b(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.g(this, consumer);
    }

    public final C0492b3 e(Spliterator spliterator) {
        return new C0492b3(this.f1665b, spliterator, this.f1664a);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.function.IntConsumer, java.lang.Object, j$.util.stream.c, j$.util.stream.V2] */
    public final void d() {
        ? v22 = new V2();
        this.f1671h = v22;
        Objects.requireNonNull(v22);
        this.f1668e = this.f1665b.G0(new C0542l3(v22, 1));
        this.f1669f = new C0481q(11, this);
    }

    public final Spliterator trySplit() {
        return (Z) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final Z m225trySplit() {
        return (Z) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final f0 m226trySplit() {
        return (Z) super.trySplit();
    }

    public final boolean tryAdvance(IntConsumer intConsumer) {
        int i5;
        Objects.requireNonNull(intConsumer);
        boolean a5 = a();
        if (a5) {
            R2 r22 = (R2) this.f1671h;
            long j5 = this.f1670g;
            int r5 = r22.r(j5);
            if (r22.f1678c == 0 && r5 == 0) {
                i5 = ((int[]) r22.f1595e)[(int) j5];
            } else {
                i5 = ((int[][]) r22.f1596f)[r5][(int) (j5 - r22.f1679d[r5])];
            }
            intConsumer.accept(i5);
        }
        return a5;
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        if (this.f1671h != null || this.f1672i) {
            do {
            } while (tryAdvance(intConsumer));
            return;
        }
        Objects.requireNonNull(intConsumer);
        c();
        Objects.requireNonNull(intConsumer);
        C0542l3 l3Var = new C0542l3(intConsumer, 0);
        this.f1665b.F0(this.f1667d, l3Var);
        this.f1672i = true;
    }
}
