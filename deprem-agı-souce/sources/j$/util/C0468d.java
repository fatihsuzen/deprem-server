package j$.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;

/* renamed from: j$.util.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0468d implements Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1364a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f1365b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f1366c;

    public /* synthetic */ C0468d(C0470f fVar, Comparator comparator) {
        this.f1366c = fVar;
        this.f1365b = comparator;
    }

    public /* synthetic */ C0468d(Function function, Comparator comparator) {
        this.f1365b = comparator;
        this.f1366c = function;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.f1364a) {
            case 0:
                Comparator comparator = this.f1365b;
                int compare = ((C0470f) this.f1366c).compare(obj, obj2);
                return compare != 0 ? compare : comparator.compare(obj, obj2);
            default:
                Comparator comparator2 = this.f1365b;
                Function function = (Function) this.f1366c;
                return comparator2.compare(function.apply(obj), function.apply(obj2));
        }
    }
}
