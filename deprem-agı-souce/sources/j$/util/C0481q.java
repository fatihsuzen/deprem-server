package j$.util;

import j$.util.function.Consumer$CC;
import j$.util.function.Function$CC;
import j$.util.function.Predicate$CC;
import j$.util.stream.B;
import j$.util.stream.C;
import j$.util.stream.C0483a;
import j$.util.stream.C0537k3;
import j$.util.stream.C0539l0;
import j$.util.stream.C0544m0;
import j$.util.stream.C0546m2;
import j$.util.stream.C0547m3;
import j$.util.stream.C0549n0;
import j$.util.stream.C0557o3;
import j$.util.stream.Collectors;
import j$.util.stream.D;
import j$.util.stream.D3;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import j$.util.stream.X2;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/* renamed from: j$.util.q  reason: case insensitive filesystem */
public final /* synthetic */ class C0481q implements Consumer, Predicate, Supplier, DoubleFunction, Function, LongFunction, BooleanSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1418a;

    /* renamed from: b  reason: collision with root package name */
    public Object f1419b;

    public /* synthetic */ C0481q(int i5) {
        this.f1418a = i5;
    }

    public /* synthetic */ C0481q(int i5, Object obj) {
        this.f1418a = i5;
        this.f1419b = obj;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f1418a) {
            case 0:
                return Consumer$CC.$default$andThen(this, consumer);
            case 8:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate$CC.$default$or(this, predicate);
    }

    public boolean test(Object obj) {
        return !((Predicate) this.f1419b).test(obj);
    }

    public Object apply(Object obj) {
        Object apply = ((Function) this.f1419b).apply(obj);
        if (apply == null) {
            return null;
        }
        if (apply instanceof Stream) {
            return Stream.Wrapper.convert((Stream) apply);
        }
        if (apply instanceof java.util.stream.Stream) {
            return X2.f((java.util.stream.Stream) apply);
        }
        if (apply instanceof IntStream) {
            return IntStream.Wrapper.convert((IntStream) apply);
        }
        if (apply instanceof java.util.stream.IntStream) {
            return IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) apply);
        }
        if (apply instanceof D) {
            return C.f((D) apply);
        }
        if (apply instanceof DoubleStream) {
            return B.f((DoubleStream) apply);
        }
        if (apply instanceof C0549n0) {
            return C0544m0.f((C0549n0) apply);
        }
        if (apply instanceof LongStream) {
            return C0539l0.f((LongStream) apply);
        }
        C0471g.a(apply.getClass(), "java.util.stream.*Stream");
        throw null;
    }

    public Object apply(double d5) {
        Object apply = ((DoubleFunction) this.f1419b).apply(d5);
        if (apply == null) {
            return null;
        }
        if (apply instanceof D) {
            return C.f((D) apply);
        }
        if (apply instanceof DoubleStream) {
            return B.f((DoubleStream) apply);
        }
        C0471g.a(apply.getClass(), "java.util.stream.DoubleStream");
        throw null;
    }

    public Object apply(long j5) {
        Object apply = ((LongFunction) this.f1419b).apply(j5);
        if (apply == null) {
            return null;
        }
        if (apply instanceof C0549n0) {
            return C0544m0.f((C0549n0) apply);
        }
        if (apply instanceof LongStream) {
            return C0539l0.f((LongStream) apply);
        }
        C0471g.a(apply.getClass(), "java.util.stream.LongStream");
        throw null;
    }

    public boolean getAsBoolean() {
        switch (this.f1418a) {
            case 10:
                C0537k3 k3Var = (C0537k3) this.f1419b;
                return k3Var.f1667d.tryAdvance(k3Var.f1668e);
            case 11:
                C0547m3 m3Var = (C0547m3) this.f1419b;
                return m3Var.f1667d.tryAdvance(m3Var.f1668e);
            case 12:
                C0557o3 o3Var = (C0557o3) this.f1419b;
                return o3Var.f1667d.tryAdvance(o3Var.f1668e);
            default:
                D3 d32 = (D3) this.f1419b;
                return d32.f1667d.tryAdvance(d32.f1668e);
        }
    }

    public Object get() {
        switch (this.f1418a) {
            case 2:
                return ((C0483a) this.f1419b).R0(0);
            case 3:
                return (Spliterator) this.f1419b;
            default:
                Set set = Collectors.f1457a;
                return new v0((CharSequence) this.f1419b);
        }
    }

    public void accept(Object obj) {
        switch (this.f1418a) {
            case 0:
                ((Consumer) this.f1419b).accept(new r((Map.Entry) obj));
                return;
            case 8:
                ((C0546m2) this.f1419b).accept(obj);
                return;
            default:
                ((List) this.f1419b).add(obj);
                return;
        }
    }
}
