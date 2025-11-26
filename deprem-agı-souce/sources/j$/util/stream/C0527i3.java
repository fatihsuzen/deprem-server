package j$.util.stream;

import j$.util.C0469e;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.t;
import j$.util.function.Consumer$CC;
import java.util.Comparator;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.i3  reason: case insensitive filesystem */
public final class C0527i3 implements Spliterator, Consumer {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f1717d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Spliterator f1718a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap f1719b;

    /* renamed from: c  reason: collision with root package name */
    public Object f1720c;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public C0527i3(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.f1718a = spliterator;
        this.f1719b = concurrentHashMap;
    }

    public final void accept(Object obj) {
        this.f1720c = obj;
    }

    public final boolean tryAdvance(Consumer consumer) {
        while (this.f1718a.tryAdvance(this)) {
            Object obj = this.f1720c;
            if (obj == null) {
                obj = f1717d;
            }
            if (this.f1719b.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.f1720c);
                this.f1720c = null;
                return true;
            }
        }
        return false;
    }

    public final void forEachRemaining(Consumer consumer) {
        this.f1718a.forEachRemaining(new t(8, (Object) this, (Object) consumer));
    }

    public final Spliterator trySplit() {
        Spliterator trySplit = this.f1718a.trySplit();
        if (trySplit != null) {
            return new C0527i3(trySplit, this.f1719b);
        }
        return null;
    }

    public final long estimateSize() {
        return this.f1718a.estimateSize();
    }

    public final int characteristics() {
        return (this.f1718a.characteristics() & -16469) | 1;
    }

    public final Comparator getComparator() {
        return this.f1718a.getComparator();
    }
}
