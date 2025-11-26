package j$.util.stream;

import j$.util.C0469e;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.Comparator;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.z3  reason: case insensitive filesystem */
public final class C0611z3 extends B3 implements Spliterator, Consumer {

    /* renamed from: f  reason: collision with root package name */
    public Object f1839f;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final void accept(Object obj) {
        this.f1839f = obj;
    }

    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        while (f() != A3.NO_MORE && this.f1444a.tryAdvance(this)) {
            if (a(1) == 1) {
                consumer.accept(this.f1839f);
                this.f1839f = null;
                return true;
            }
        }
        return false;
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        C0517g3 g3Var = null;
        while (true) {
            A3 f5 = f();
            if (f5 != A3.NO_MORE) {
                A3 a32 = A3.MAYBE_MORE;
                Spliterator spliterator = this.f1444a;
                if (f5 == a32) {
                    int i5 = this.f1446c;
                    if (g3Var == null) {
                        g3Var = new C0517g3(i5);
                    } else {
                        g3Var.f1714a = 0;
                    }
                    long j5 = 0;
                    while (spliterator.tryAdvance(g3Var)) {
                        j5++;
                        if (j5 >= ((long) i5)) {
                            break;
                        }
                    }
                    if (j5 != 0) {
                        long a5 = a(j5);
                        for (int i6 = 0; ((long) i6) < a5; i6++) {
                            consumer.accept(g3Var.f1711b[i6]);
                        }
                    } else {
                        return;
                    }
                } else {
                    spliterator.forEachRemaining(consumer);
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.B3, j$.util.Spliterator] */
    public final Spliterator b(Spliterator spliterator) {
        return new B3(spliterator, this);
    }
}
