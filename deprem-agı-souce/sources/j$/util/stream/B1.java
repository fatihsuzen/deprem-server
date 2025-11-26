package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

public final class B1 extends C0594w1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1439h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1440i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f1441j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f1442k;

    public /* synthetic */ B1(C0487a3 a3Var, Object obj, Object obj2, Object obj3, int i5) {
        this.f1439h = i5;
        this.f1441j = obj;
        this.f1442k = obj2;
        this.f1440i = obj3;
    }

    public final R1 D0() {
        switch (this.f1439h) {
            case 0:
                return new C0604y1((Supplier) this.f1440i, (ObjLongConsumer) this.f1442k, (C0558p) this.f1441j);
            case 1:
                return new E1((Supplier) this.f1440i, (ObjDoubleConsumer) this.f1442k, (C0558p) this.f1441j);
            case 2:
                return new G1(this.f1440i, (BiFunction) this.f1442k, (BinaryOperator) this.f1441j);
            case 3:
                return new K1((Supplier) this.f1440i, (BiConsumer) this.f1442k, (BiConsumer) this.f1441j);
            default:
                return new O1((Supplier) this.f1440i, (ObjIntConsumer) this.f1442k, (C0558p) this.f1441j);
        }
    }
}
