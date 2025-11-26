package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class m0 implements W {

    /* renamed from: a  reason: collision with root package name */
    public final double[] f1411a;

    /* renamed from: b  reason: collision with root package name */
    public int f1412b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1413c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1414d;

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.a(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.f(this, consumer);
    }

    public m0(double[] dArr, int i5, int i6, int i7) {
        this.f1411a = dArr;
        this.f1412b = i5;
        this.f1413c = i6;
        this.f1414d = i7 | 16448;
    }

    public final W trySplit() {
        int i5 = this.f1412b;
        int i6 = (this.f1413c + i5) >>> 1;
        if (i5 >= i6) {
            return null;
        }
        this.f1412b = i6;
        return new m0(this.f1411a, i5, i6, this.f1414d);
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        int i5;
        doubleConsumer.getClass();
        double[] dArr = this.f1411a;
        int length = dArr.length;
        int i6 = this.f1413c;
        if (length >= i6 && (i5 = this.f1412b) >= 0) {
            this.f1412b = i6;
            if (i5 < i6) {
                do {
                    doubleConsumer.accept(dArr[i5]);
                    i5++;
                } while (i5 < i6);
            }
        }
    }

    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        int i5 = this.f1412b;
        if (i5 < 0 || i5 >= this.f1413c) {
            return false;
        }
        this.f1412b = i5 + 1;
        doubleConsumer.accept(this.f1411a[i5]);
        return true;
    }

    public final long estimateSize() {
        return (long) (this.f1413c - this.f1412b);
    }

    public final int characteristics() {
        return this.f1414d;
    }

    public final Comparator getComparator() {
        if (C0469e.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
