package j$.util.stream;

import j$.util.C0469e;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.f0;
import java.util.Comparator;

/* renamed from: j$.util.stream.y3  reason: case insensitive filesystem */
public abstract class C0606y3 extends B3 implements f0 {
    public abstract void g(Object obj);

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public abstract C0512f3 i(int i5);

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        while (f() != A3.NO_MORE && ((f0) this.f1444a).tryAdvance(this)) {
            if (a(1) == 1) {
                g(obj);
                return true;
            }
        }
        return false;
    }

    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        C0512f3 f3Var = null;
        while (true) {
            A3 f5 = f();
            if (f5 != A3.NO_MORE) {
                A3 a32 = A3.MAYBE_MORE;
                Spliterator spliterator = this.f1444a;
                if (f5 == a32) {
                    int i5 = this.f1446c;
                    if (f3Var == null) {
                        f3Var = i(i5);
                    } else {
                        f3Var.f1707b = 0;
                    }
                    long j5 = 0;
                    while (((f0) spliterator).tryAdvance(f3Var)) {
                        j5++;
                        if (j5 >= ((long) i5)) {
                            break;
                        }
                    }
                    if (j5 != 0) {
                        f3Var.a(obj, a(j5));
                    } else {
                        return;
                    }
                } else {
                    ((f0) spliterator).forEachRemaining(obj);
                    return;
                }
            } else {
                return;
            }
        }
    }
}
