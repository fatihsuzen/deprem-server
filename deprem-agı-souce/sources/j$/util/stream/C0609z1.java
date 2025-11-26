package j$.util.stream;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/* renamed from: j$.util.stream.z1  reason: case insensitive filesystem */
public final class C0609z1 extends C0594w1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1836h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1837i;

    public /* synthetic */ C0609z1(C0487a3 a3Var, Object obj, int i5) {
        this.f1836h = i5;
        this.f1837i = obj;
    }

    public final R1 D0() {
        switch (this.f1836h) {
            case 0:
                return new Q1((LongBinaryOperator) this.f1837i);
            case 1:
                return new C1((DoubleBinaryOperator) this.f1837i);
            case 2:
                return new H1((BinaryOperator) this.f1837i);
            default:
                return new N1((IntBinaryOperator) this.f1837i);
        }
    }
}
