package j$.util;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.function.Consumer;

/* renamed from: j$.util.a  reason: case insensitive filesystem */
public final class C0465a implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public final List f1282a;

    /* renamed from: b  reason: collision with root package name */
    public int f1283b;

    /* renamed from: c  reason: collision with root package name */
    public int f1284c;

    public final int characteristics() {
        return 16464;
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

    static {
        Class<C0466b> cls = C0466b.class;
    }

    public C0465a(List list) {
        this.f1282a = list;
        this.f1283b = 0;
        this.f1284c = -1;
    }

    public C0465a(C0465a aVar, int i5, int i6) {
        this.f1282a = aVar.f1282a;
        this.f1283b = i5;
        this.f1284c = i6;
    }

    public final int a() {
        List list = this.f1282a;
        int i5 = this.f1284c;
        if (i5 >= 0) {
            return i5;
        }
        int size = list.size();
        this.f1284c = size;
        return size;
    }

    public final Spliterator trySplit() {
        int a5 = a();
        int i5 = this.f1283b;
        int i6 = (a5 + i5) >>> 1;
        if (i5 >= i6) {
            return null;
        }
        this.f1283b = i6;
        return new C0465a(this, i5, i6);
    }

    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int a5 = a();
        int i5 = this.f1283b;
        if (i5 >= a5) {
            return false;
        }
        this.f1283b = i5 + 1;
        try {
            consumer.accept(this.f1282a.get(i5));
            return true;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        List list = this.f1282a;
        int a5 = a();
        int i5 = this.f1283b;
        this.f1283b = a5;
        while (i5 < a5) {
            try {
                consumer.accept(list.get(i5));
                i5++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public final long estimateSize() {
        return (long) (a() - this.f1283b);
    }
}
