package j$.util.stream;

import j$.time.format.a;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.t;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.n  reason: case insensitive filesystem */
public final class C0548n extends C0496c2 {
    public static L0 U0(C0594w1 w1Var, Spliterator spliterator) {
        a aVar = new a(21);
        a aVar2 = new a(22);
        a aVar3 = new a(23);
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(aVar2);
        Objects.requireNonNull(aVar3);
        return new L0((Collection) new B1(C0487a3.REFERENCE, aVar3, aVar2, aVar, 3).i(w1Var, spliterator));
    }

    public final H0 N0(C0594w1 w1Var, Spliterator spliterator, IntFunction intFunction) {
        C0483a aVar = (C0483a) w1Var;
        if (Z2.DISTINCT.h(aVar.f1653m)) {
            return w1Var.j0(spliterator, false, intFunction);
        }
        if (Z2.ORDERED.h(aVar.f1653m)) {
            return U0(w1Var, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        t tVar = new t(4, (Object) atomicBoolean, (Object) concurrentHashMap);
        Objects.requireNonNull(tVar);
        new P(tVar, false).a(w1Var, spliterator);
        Set keySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(keySet);
            hashSet.add((Object) null);
            keySet = hashSet;
        }
        return new L0(keySet);
    }

    public final Spliterator O0(C0483a aVar, Spliterator spliterator) {
        if (Z2.DISTINCT.h(aVar.f1653m)) {
            return aVar.H0(spliterator);
        }
        if (Z2.ORDERED.h(aVar.f1653m)) {
            return U0(aVar, spliterator).spliterator();
        }
        return new C0527i3(aVar.H0(spliterator), new ConcurrentHashMap());
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        Objects.requireNonNull(m2Var);
        if (Z2.DISTINCT.h(i5)) {
            return m2Var;
        }
        if (Z2.SORTED.h(i5)) {
            return new C0538l(m2Var);
        }
        return new C0543m(m2Var);
    }
}
