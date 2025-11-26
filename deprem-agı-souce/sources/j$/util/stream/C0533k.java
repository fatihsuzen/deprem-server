package j$.util.stream;

import j$.time.format.a;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.k  reason: case insensitive filesystem */
public final class C0533k implements Collector {

    /* renamed from: a  reason: collision with root package name */
    public final Supplier f1724a;

    /* renamed from: b  reason: collision with root package name */
    public final BiConsumer f1725b;

    /* renamed from: c  reason: collision with root package name */
    public final BinaryOperator f1726c;

    /* renamed from: d  reason: collision with root package name */
    public final Function f1727d;

    /* renamed from: e  reason: collision with root package name */
    public final Set f1728e;

    public C0533k(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Function function, Set set) {
        this.f1724a = supplier;
        this.f1725b = biConsumer;
        this.f1726c = binaryOperator;
        this.f1727d = function;
        this.f1728e = set;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C0533k(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Set set) {
        this(supplier, biConsumer, binaryOperator, new a(16), set);
        Set set2 = Collectors.f1457a;
    }

    public final BiConsumer accumulator() {
        return this.f1725b;
    }

    public final Supplier supplier() {
        return this.f1724a;
    }

    public final BinaryOperator combiner() {
        return this.f1726c;
    }

    public final Function finisher() {
        return this.f1727d;
    }

    public final Set characteristics() {
        return this.f1728e;
    }
}
