package j$.util.stream;

import j$.util.Spliterator;
import j$.util.f0;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public final class Q0 extends R0 implements F0 {
    public final /* synthetic */ void forEach(Consumer consumer) {
        C0594w1.R(this, consumer);
    }

    public final /* synthetic */ H0 i(long j5, long j6, IntFunction intFunction) {
        return C0594w1.U(this, j5, j6);
    }

    public final /* synthetic */ void k(Object[] objArr, int i5) {
        C0594w1.O(this, (Long[]) objArr, i5);
    }

    public final Object newArray(int i5) {
        return new long[i5];
    }

    public final Spliterator spliterator() {
        return new C0535k1(this);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.k1, j$.util.f0] */
    /* renamed from: spliterator  reason: collision with other method in class */
    public final f0 m215spliterator() {
        return new C0535k1(this);
    }
}
