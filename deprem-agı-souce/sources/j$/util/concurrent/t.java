package j$.util.concurrent;

import j$.com.android.tools.r8.a;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import j$.util.stream.C0483a;
import j$.util.stream.C0487a3;
import j$.util.stream.C0527i3;
import j$.util.stream.C0559p0;
import j$.util.stream.C0578t0;
import j$.util.stream.C0583u0;
import j$.util.stream.C0588v0;
import j$.util.stream.C0594w1;
import j$.util.stream.F3;
import j$.util.stream.Z2;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final /* synthetic */ class t implements BiConsumer, BiFunction, Consumer, Supplier, F3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1349a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f1350b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f1351c;

    public /* synthetic */ t(int i5, Object obj, Object obj2) {
        this.f1349a = i5;
        this.f1350b = obj;
        this.f1351c = obj2;
    }

    public /* synthetic */ t(BiFunction biFunction, Function function) {
        this.f1349a = 2;
        this.f1351c = biFunction;
        this.f1350b = function;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f1349a) {
            case 0:
                return a.b(this, biConsumer);
            default:
                return a.b(this, biConsumer);
        }
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        return a.c(this, function);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f1349a) {
            case 3:
                return Consumer$CC.$default$andThen(this, consumer);
            case 4:
                return Consumer$CC.$default$andThen(this, consumer);
            case 7:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public Object apply(Object obj, Object obj2) {
        return ((Function) this.f1350b).apply(((BiFunction) this.f1351c).apply(obj, obj2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x001c A[LOOP:0: B:5:0x001c->B:8:0x002a, LOOP_START, PHI: r5 
      PHI: (r5v1 java.lang.Object) = (r5v0 java.lang.Object), (r5v3 java.lang.Object) binds: [B:4:0x0014, B:8:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void accept(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r3.f1349a
            switch(r0) {
                case 0: goto L_0x0014;
                default: goto L_0x0005;
            }
        L_0x0005:
            java.lang.Object r0 = r3.f1350b
            java.util.function.BiConsumer r0 = (java.util.function.BiConsumer) r0
            java.lang.Object r1 = r3.f1351c
            java.util.function.BiConsumer r1 = (java.util.function.BiConsumer) r1
            r0.accept(r4, r5)
            r1.accept(r4, r5)
            return
        L_0x0014:
            java.lang.Object r0 = r3.f1350b
            java.util.concurrent.ConcurrentMap r0 = (java.util.concurrent.ConcurrentMap) r0
            java.lang.Object r1 = r3.f1351c
            java.util.function.BiFunction r1 = (java.util.function.BiFunction) r1
        L_0x001c:
            java.lang.Object r2 = r1.apply(r4, r5)
            boolean r5 = r0.replace(r4, r5, r2)
            if (r5 != 0) goto L_0x002c
            java.lang.Object r5 = r0.get(r4)
            if (r5 != 0) goto L_0x001c
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.t.accept(java.lang.Object, java.lang.Object):void");
    }

    public Object get() {
        return new C0559p0((C0583u0) this.f1350b, (Predicate) this.f1351c);
    }

    public t(C0487a3 a3Var, C0583u0 u0Var, Supplier supplier) {
        this.f1349a = 6;
        this.f1350b = u0Var;
        this.f1351c = supplier;
    }

    public int v() {
        return Z2.f1639u | Z2.f1636r;
    }

    public Object f(C0483a aVar, Spliterator spliterator) {
        C0578t0 t0Var = (C0578t0) ((Supplier) this.f1351c).get();
        aVar.F0(spliterator, t0Var);
        return Boolean.valueOf(t0Var.f1787b);
    }

    public Object i(C0594w1 w1Var, Spliterator spliterator) {
        return (Boolean) new C0588v0(this, (C0483a) w1Var, spliterator).invoke();
    }

    public void accept(Object obj) {
        switch (this.f1349a) {
            case 3:
                ((Consumer) this.f1350b).accept(obj);
                ((Consumer) this.f1351c).accept(obj);
                return;
            case 4:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f1350b;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f1351c;
                if (obj == null) {
                    atomicBoolean.set(true);
                    return;
                } else {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                    return;
                }
            case 7:
                ((BiConsumer) this.f1350b).accept(this.f1351c, obj);
                return;
            default:
                Consumer consumer = (Consumer) this.f1351c;
                if (((C0527i3) this.f1350b).f1719b.putIfAbsent(obj != null ? obj : C0527i3.f1717d, Boolean.TRUE) == null) {
                    consumer.accept(obj);
                    return;
                }
                return;
        }
    }
}
