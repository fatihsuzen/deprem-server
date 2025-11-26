package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public final class I1 extends C0594w1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f1494h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f1495i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Supplier f1496j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Collector f1497k;

    public final R1 D0() {
        return new J1(this.f1496j, this.f1495i, this.f1494h);
    }

    public final int v() {
        if (this.f1497k.characteristics().contains(C0518h.UNORDERED)) {
            return Z2.f1636r;
        }
        return 0;
    }

    public I1(C0487a3 a3Var, BinaryOperator binaryOperator, BiConsumer biConsumer, Supplier supplier, Collector collector) {
        this.f1494h = binaryOperator;
        this.f1495i = biConsumer;
        this.f1496j = supplier;
        this.f1497k = collector;
    }
}
