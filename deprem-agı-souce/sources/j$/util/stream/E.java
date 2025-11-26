package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class E implements F3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1461a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f1462b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate f1463c;

    /* renamed from: d  reason: collision with root package name */
    public final Supplier f1464d;

    public E(boolean z4, C0487a3 a3Var, Object obj, Predicate predicate, Supplier supplier) {
        this.f1461a = (z4 ? 0 : Z2.f1636r) | Z2.f1639u;
        this.f1462b = obj;
        this.f1463c = predicate;
        this.f1464d = supplier;
    }

    public final int v() {
        return this.f1461a;
    }

    public final Object f(C0483a aVar, Spliterator spliterator) {
        G3 g32 = (G3) this.f1464d.get();
        aVar.F0(spliterator, g32);
        Object obj = g32.get();
        if (obj != null) {
            return obj;
        }
        return this.f1462b;
    }

    public final Object i(C0594w1 w1Var, Spliterator spliterator) {
        C0483a aVar = (C0483a) w1Var;
        return new K(this, Z2.ORDERED.h(aVar.f1653m), aVar, spliterator).invoke();
    }
}
