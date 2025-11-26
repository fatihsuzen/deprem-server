package j$.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* renamed from: j$.util.stream.j  reason: case insensitive filesystem */
public final /* synthetic */ class C0528j implements Collector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collector f1721a;

    public /* synthetic */ C0528j(Collector collector) {
        this.f1721a = collector;
    }

    public final /* synthetic */ BiConsumer accumulator() {
        return this.f1721a.accumulator();
    }

    public final /* synthetic */ Set characteristics() {
        return C0594w1.q0(this.f1721a.characteristics());
    }

    public final /* synthetic */ BinaryOperator combiner() {
        return this.f1721a.combiner();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Collector collector = this.f1721a;
        if (obj instanceof C0528j) {
            obj = ((C0528j) obj).f1721a;
        }
        return collector.equals(obj);
    }

    public final /* synthetic */ Function finisher() {
        return this.f1721a.finisher();
    }

    public final /* synthetic */ int hashCode() {
        return this.f1721a.hashCode();
    }

    public final /* synthetic */ Supplier supplier() {
        return this.f1721a.supplier();
    }
}
