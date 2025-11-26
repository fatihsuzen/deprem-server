package j$.util.function;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public final /* synthetic */ class a implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1370a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f1371b;

    public /* synthetic */ a(Comparator comparator, int i5) {
        this.f1370a = i5;
        this.f1371b = comparator;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f1370a) {
            case 0:
                return j$.com.android.tools.r8.a.c(this, function);
            default:
                return j$.com.android.tools.r8.a.c(this, function);
        }
    }

    public final Object apply(Object obj, Object obj2) {
        switch (this.f1370a) {
            case 0:
                return this.f1371b.compare(obj, obj2) >= 0 ? obj : obj2;
            default:
                return this.f1371b.compare(obj, obj2) <= 0 ? obj : obj2;
        }
    }
}
