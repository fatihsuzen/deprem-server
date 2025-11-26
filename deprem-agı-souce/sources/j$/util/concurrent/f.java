package j$.util.concurrent;

import j$.util.C0469e;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

public final class f extends p implements Spliterator {

    /* renamed from: i  reason: collision with root package name */
    public final ConcurrentHashMap f1314i;

    /* renamed from: j  reason: collision with root package name */
    public long f1315j;

    public final int characteristics() {
        return 4353;
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

    public f(l[] lVarArr, int i5, int i6, int i7, long j5, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i5, i6, i7);
        this.f1314i = concurrentHashMap;
        this.f1315j = j5;
    }

    public final Spliterator trySplit() {
        int i5 = this.f1336f;
        int i6 = this.f1337g;
        int i7 = (i5 + i6) >>> 1;
        if (i7 <= i5) {
            return null;
        }
        l[] lVarArr = this.f1331a;
        this.f1337g = i7;
        long j5 = this.f1315j >>> 1;
        this.f1315j = j5;
        return new f(lVarArr, this.f1338h, i7, i6, j5, this.f1314i);
    }

    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        while (true) {
            l a5 = a();
            if (a5 != null) {
                consumer.accept(new k(a5.f1324b, a5.f1325c, this.f1314i));
            } else {
                return;
            }
        }
    }

    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        l a5 = a();
        if (a5 == null) {
            return false;
        }
        consumer.accept(new k(a5.f1324b, a5.f1325c, this.f1314i));
        return true;
    }

    public final long estimateSize() {
        return this.f1315j;
    }
}
