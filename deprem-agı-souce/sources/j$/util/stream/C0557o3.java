package j$.util.stream;

import j$.util.C0469e;
import j$.util.C0481q;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.c0;
import j$.util.f0;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.o3  reason: case insensitive filesystem */
public final class C0557o3 extends C0492b3 implements c0 {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.c(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.h(this, consumer);
    }

    public final C0492b3 e(Spliterator spliterator) {
        return new C0492b3(this.f1665b, spliterator, this.f1664a);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, j$.util.stream.c, j$.util.stream.V2, java.util.function.LongConsumer] */
    public final void d() {
        ? v22 = new V2();
        this.f1671h = v22;
        Objects.requireNonNull(v22);
        this.f1668e = this.f1665b.G0(new C0552n3(v22, 1));
        this.f1669f = new C0481q(12, this);
    }

    public final Spliterator trySplit() {
        return (c0) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final c0 m229trySplit() {
        return (c0) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final f0 m230trySplit() {
        return (c0) super.trySplit();
    }

    public final boolean tryAdvance(LongConsumer longConsumer) {
        long j5;
        Objects.requireNonNull(longConsumer);
        boolean a5 = a();
        if (a5) {
            T2 t22 = (T2) this.f1671h;
            long j6 = this.f1670g;
            int r5 = t22.r(j6);
            if (t22.f1678c == 0 && r5 == 0) {
                j5 = ((long[]) t22.f1595e)[(int) j6];
            } else {
                j5 = ((long[][]) t22.f1596f)[r5][(int) (j6 - t22.f1679d[r5])];
            }
            longConsumer.accept(j5);
        }
        return a5;
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        if (this.f1671h != null || this.f1672i) {
            do {
            } while (tryAdvance(longConsumer));
            return;
        }
        Objects.requireNonNull(longConsumer);
        c();
        Objects.requireNonNull(longConsumer);
        C0552n3 n3Var = new C0552n3(longConsumer, 0);
        this.f1665b.F0(this.f1667d, n3Var);
        this.f1672i = true;
    }
}
