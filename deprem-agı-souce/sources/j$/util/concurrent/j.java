package j$.util.concurrent;

import j$.util.C0469e;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

public final class j extends p implements Spliterator {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f1318i;

    /* renamed from: j  reason: collision with root package name */
    public long f1319j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(l[] lVarArr, int i5, int i6, int i7, long j5, int i8) {
        super(lVarArr, i5, i6, i7);
        this.f1318i = i8;
        this.f1319j = j5;
    }

    public final int characteristics() {
        switch (this.f1318i) {
            case 0:
                return 4353;
            default:
                return 4352;
        }
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        switch (this.f1318i) {
            case 0:
                return C0469e.d(this);
            default:
                return C0469e.d(this);
        }
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        switch (this.f1318i) {
            case 0:
                return C0469e.e(this, i5);
            default:
                return C0469e.e(this, i5);
        }
    }

    public final Comparator getComparator() {
        switch (this.f1318i) {
            case 0:
                throw new IllegalStateException();
            default:
                throw new IllegalStateException();
        }
    }

    public final Spliterator trySplit() {
        switch (this.f1318i) {
            case 0:
                int i5 = this.f1336f;
                int i6 = this.f1337g;
                int i7 = (i5 + i6) >>> 1;
                if (i7 <= i5) {
                    return null;
                }
                l[] lVarArr = this.f1331a;
                this.f1337g = i7;
                long j5 = this.f1319j >>> 1;
                this.f1319j = j5;
                return new j(lVarArr, this.f1338h, i7, i6, j5, 0);
            default:
                int i8 = this.f1336f;
                int i9 = this.f1337g;
                int i10 = (i8 + i9) >>> 1;
                if (i10 <= i8) {
                    return null;
                }
                l[] lVarArr2 = this.f1331a;
                this.f1337g = i10;
                long j6 = this.f1319j >>> 1;
                this.f1319j = j6;
                return new j(lVarArr2, this.f1338h, i10, i9, j6, 1);
        }
    }

    public final void forEachRemaining(Consumer consumer) {
        switch (this.f1318i) {
            case 0:
                consumer.getClass();
                while (true) {
                    l a5 = a();
                    if (a5 != null) {
                        consumer.accept(a5.f1324b);
                    } else {
                        return;
                    }
                }
            default:
                consumer.getClass();
                while (true) {
                    l a6 = a();
                    if (a6 != null) {
                        consumer.accept(a6.f1325c);
                    } else {
                        return;
                    }
                }
        }
    }

    public final boolean tryAdvance(Consumer consumer) {
        switch (this.f1318i) {
            case 0:
                consumer.getClass();
                l a5 = a();
                if (a5 == null) {
                    return false;
                }
                consumer.accept(a5.f1324b);
                return true;
            default:
                consumer.getClass();
                l a6 = a();
                if (a6 == null) {
                    return false;
                }
                consumer.accept(a6.f1325c);
                return true;
        }
    }

    public final long estimateSize() {
        switch (this.f1318i) {
            case 0:
                return this.f1319j;
            default:
                return this.f1319j;
        }
    }
}
