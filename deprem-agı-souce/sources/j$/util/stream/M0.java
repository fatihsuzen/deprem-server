package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

public final class M0 extends N0 {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f1535k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ M0(C0594w1 w1Var, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator, int i5) {
        super(w1Var, spliterator, longFunction, binaryOperator);
        this.f1535k = i5;
    }

    public final C0498d c(Spliterator spliterator) {
        switch (this.f1535k) {
            case 0:
                return new N0(this, spliterator);
            case 1:
                return new N0(this, spliterator);
            case 2:
                return new N0(this, spliterator);
            default:
                return new N0(this, spliterator);
        }
    }

    public final /* bridge */ /* synthetic */ Object a() {
        switch (this.f1535k) {
            case 0:
                return a();
            case 1:
                return a();
            case 2:
                return a();
            default:
                return a();
        }
    }
}
