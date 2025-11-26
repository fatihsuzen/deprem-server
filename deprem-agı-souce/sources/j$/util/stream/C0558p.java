package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* renamed from: j$.util.stream.p  reason: case insensitive filesystem */
public final /* synthetic */ class C0558p implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1756a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f1757b;

    public /* synthetic */ C0558p(BiConsumer biConsumer, int i5) {
        this.f1756a = i5;
        this.f1757b = biConsumer;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f1756a) {
            case 0:
                return a.c(this, function);
            case 1:
                return a.c(this, function);
            default:
                return a.c(this, function);
        }
    }

    public final Object apply(Object obj, Object obj2) {
        switch (this.f1756a) {
            case 0:
                this.f1757b.accept(obj, obj2);
                return obj;
            case 1:
                this.f1757b.accept(obj, obj2);
                return obj;
            default:
                this.f1757b.accept(obj, obj2);
                return obj;
        }
    }
}
