package j$.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* renamed from: j$.util.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0467c implements Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1287a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1288b;

    public /* synthetic */ C0467c(int i5, Object obj) {
        this.f1287a = i5;
        this.f1288b = obj;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.f1287a) {
            case 0:
                ToIntFunction toIntFunction = (ToIntFunction) this.f1288b;
                return Integer.compare(toIntFunction.applyAsInt(obj), toIntFunction.applyAsInt(obj2));
            case 1:
                ToDoubleFunction toDoubleFunction = (ToDoubleFunction) this.f1288b;
                return Double.compare(toDoubleFunction.applyAsDouble(obj), toDoubleFunction.applyAsDouble(obj2));
            case 2:
                Function function = (Function) this.f1288b;
                return ((Comparable) function.apply(obj)).compareTo(function.apply(obj2));
            default:
                ToLongFunction toLongFunction = (ToLongFunction) this.f1288b;
                return Long.compare(toLongFunction.applyAsLong(obj), toLongFunction.applyAsLong(obj2));
        }
    }
}
