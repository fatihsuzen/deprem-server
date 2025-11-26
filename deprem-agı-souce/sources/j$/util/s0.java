package j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;

public class s0 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public final Collection f1426a;

    /* renamed from: b  reason: collision with root package name */
    public Iterator f1427b = null;

    /* renamed from: c  reason: collision with root package name */
    public final int f1428c;

    /* renamed from: d  reason: collision with root package name */
    public long f1429d;

    /* renamed from: e  reason: collision with root package name */
    public int f1430e;

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public s0(int i5, Collection collection) {
        this.f1426a = collection;
        this.f1428c = i5 | 16448;
    }

    public final Spliterator trySplit() {
        long j5;
        Iterator it = this.f1427b;
        if (it == null) {
            it = this.f1426a.iterator();
            this.f1427b = it;
            j5 = (long) this.f1426a.size();
            this.f1429d = j5;
        } else {
            j5 = this.f1429d;
        }
        if (j5 <= 1 || !it.hasNext()) {
            return null;
        }
        int i5 = this.f1430e + 1024;
        if (((long) i5) > j5) {
            i5 = (int) j5;
        }
        if (i5 > 33554432) {
            i5 = 33554432;
        }
        Object[] objArr = new Object[i5];
        int i6 = 0;
        do {
            objArr[i6] = it.next();
            i6++;
            if (i6 >= i5 || !it.hasNext()) {
                this.f1430e = i6;
                long j6 = this.f1429d;
            }
            objArr[i6] = it.next();
            i6++;
            break;
        } while (!it.hasNext());
        this.f1430e = i6;
        long j62 = this.f1429d;
        if (j62 != Long.MAX_VALUE) {
            this.f1429d = j62 - ((long) i6);
        }
        return new l0(objArr, 0, i6, this.f1428c);
    }

    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        Iterator it = this.f1427b;
        if (it == null) {
            it = this.f1426a.iterator();
            this.f1427b = it;
            this.f1429d = (long) this.f1426a.size();
        }
        C0469e.r(it, consumer);
    }

    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        if (this.f1427b == null) {
            this.f1427b = this.f1426a.iterator();
            this.f1429d = (long) this.f1426a.size();
        }
        if (!this.f1427b.hasNext()) {
            return false;
        }
        consumer.accept(this.f1427b.next());
        return true;
    }

    public final long estimateSize() {
        if (this.f1427b != null) {
            return this.f1429d;
        }
        this.f1427b = this.f1426a.iterator();
        long size = (long) this.f1426a.size();
        this.f1429d = size;
        return size;
    }

    public final int characteristics() {
        return this.f1428c;
    }

    public Comparator getComparator() {
        if (C0469e.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
