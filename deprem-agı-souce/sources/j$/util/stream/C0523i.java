package j$.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* renamed from: j$.util.stream.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0523i implements Collector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collector f1715a;

    public /* synthetic */ C0523i(Collector collector) {
        this.f1715a = collector;
    }

    public final /* synthetic */ BiConsumer accumulator() {
        return this.f1715a.accumulator();
    }

    public final /* synthetic */ Set characteristics() {
        return C0594w1.q0(this.f1715a.characteristics());
    }

    public final /* synthetic */ BinaryOperator combiner() {
        return this.f1715a.combiner();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Collector collector = this.f1715a;
        if (obj instanceof C0523i) {
            obj = ((C0523i) obj).f1715a;
        }
        return collector.equals(obj);
    }

    public final /* synthetic */ Function finisher() {
        return this.f1715a.finisher();
    }

    public final /* synthetic */ int hashCode() {
        return this.f1715a.hashCode();
    }

    public final /* synthetic */ Supplier supplier() {
        return this.f1715a.supplier();
    }
}
