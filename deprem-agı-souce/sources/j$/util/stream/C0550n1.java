package j$.util.stream;

import j$.util.Spliterator;
import j$.util.f0;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.n1  reason: case insensitive filesystem */
public final class C0550n1 extends T2 implements F0, C0603y0 {
    public final /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public final /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final F0 build() {
        return this;
    }

    /* renamed from: build  reason: collision with other method in class */
    public final H0 m227build() {
        return this;
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final void end() {
    }

    public final /* synthetic */ H0 i(long j5, long j6, IntFunction intFunction) {
        return C0594w1.U(this, j5, j6);
    }

    public final /* synthetic */ void l(Long l5) {
        C0594w1.H(this, l5);
    }

    public final /* synthetic */ Object[] m(IntFunction intFunction) {
        return C0594w1.L(this, intFunction);
    }

    public final /* synthetic */ int o() {
        return 0;
    }

    public final G0 a(int i5) {
        throw new IndexOutOfBoundsException();
    }

    public final /* synthetic */ void k(Object[] objArr, int i5) {
        C0594w1.O(this, (Long[]) objArr, i5);
    }

    public final void f(int i5, Object obj) {
        super.f(i5, (long[]) obj);
    }

    public final void g(Object obj) {
        super.g((LongConsumer) obj);
    }

    public final Spliterator spliterator() {
        return super.spliterator();
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final f0 m228spliterator() {
        return super.spliterator();
    }

    public final void c(long j5) {
        clear();
        s(j5);
    }

    public final Object b() {
        return (long[]) super.b();
    }
}
