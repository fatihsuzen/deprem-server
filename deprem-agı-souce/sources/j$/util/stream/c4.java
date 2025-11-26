package j$.util.stream;

import j$.util.C0469e;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public abstract class c4 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public final Spliterator f1684a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f1685b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1686c = true;

    /* renamed from: d  reason: collision with root package name */
    public int f1687d;

    public abstract Spliterator b(Spliterator spliterator);

    public final long getExactSizeIfKnown() {
        return -1;
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public void forEachRemaining(Consumer consumer) {
        do {
        } while (tryAdvance(consumer));
    }

    public c4(Spliterator spliterator) {
        this.f1684a = spliterator;
        this.f1685b = new AtomicBoolean();
    }

    public c4(Spliterator spliterator, c4 c4Var) {
        this.f1684a = spliterator;
        c4Var.getClass();
        this.f1685b = c4Var.f1685b;
    }

    public final long estimateSize() {
        return this.f1684a.estimateSize();
    }

    public final int characteristics() {
        return this.f1684a.characteristics() & -16449;
    }

    public final Comparator getComparator() {
        return this.f1684a.getComparator();
    }

    public Spliterator trySplit() {
        Spliterator trySplit = this.f1684a.trySplit();
        if (trySplit != null) {
            return b(trySplit);
        }
        return null;
    }

    public final boolean a() {
        return this.f1687d != 0 || !this.f1685b.get();
    }
}
