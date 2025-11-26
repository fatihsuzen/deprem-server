package j$.util.function;

import j$.com.android.tools.r8.a;
import j$.util.C0469e;
import j$.util.Objects;
import j$.util.stream.Collectors;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;

public final /* synthetic */ class c implements Function, BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1374a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function f1375b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function f1376c;

    public /* synthetic */ c(Function function, Function function2, int i5) {
        this.f1374a = i5;
        this.f1375b = function;
        this.f1376c = function2;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return a.b(this, biConsumer);
    }

    public /* synthetic */ Function andThen(Function function) {
        switch (this.f1374a) {
            case 0:
                return Function$CC.$default$andThen(this, function);
            default:
                return Function$CC.$default$andThen(this, function);
        }
    }

    public /* synthetic */ Function compose(Function function) {
        switch (this.f1374a) {
            case 0:
                return Function$CC.$default$compose(this, function);
            default:
                return Function$CC.$default$compose(this, function);
        }
    }

    public Object apply(Object obj) {
        switch (this.f1374a) {
            case 0:
                return this.f1376c.apply(this.f1375b.apply(obj));
            default:
                return this.f1375b.apply(this.f1376c.apply(obj));
        }
    }

    public void accept(Object obj, Object obj2) {
        Set set = Collectors.f1457a;
        Object apply = this.f1375b.apply(obj2);
        Object requireNonNull = Objects.requireNonNull(this.f1376c.apply(obj2));
        Object t5 = C0469e.t((Map) obj, apply, requireNonNull);
        if (t5 != null) {
            throw new IllegalStateException(String.format("Duplicate key %s (attempted merging values %s and %s)", new Object[]{apply, t5, requireNonNull}));
        }
    }
}
