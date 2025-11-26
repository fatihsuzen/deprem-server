package j$.util.stream;

import j$.util.Spliterator;
import j$.util.f0;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.e1  reason: case insensitive filesystem */
public final class C0505e1 extends R2 implements D0, C0598x0 {
    public final /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public final /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final D0 build() {
        return this;
    }

    /* renamed from: build  reason: collision with other method in class */
    public final H0 m220build() {
        return this;
    }

    public final /* synthetic */ void d(Integer num) {
        C0594w1.F(this, num);
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final void end() {
    }

    public final /* synthetic */ H0 i(long j5, long j6, IntFunction intFunction) {
        return C0594w1.T(this, j5, j6);
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
        C0594w1.N(this, (Integer[]) objArr, i5);
    }

    public final void f(int i5, Object obj) {
        super.f(i5, (int[]) obj);
    }

    public final void g(Object obj) {
        super.g((IntConsumer) obj);
    }

    public final Spliterator spliterator() {
        return super.spliterator();
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final f0 m221spliterator() {
        return super.spliterator();
    }

    public final void c(long j5) {
        clear();
        s(j5);
    }

    public final Object b() {
        return (int[]) super.b();
    }
}
