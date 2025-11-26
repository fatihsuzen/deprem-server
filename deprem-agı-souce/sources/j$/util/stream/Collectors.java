package j$.util.stream;

import j$.time.format.a;
import j$.util.C0481q;
import j$.util.function.c;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public final class Collectors {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f1457a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set f1458b = Collections.EMPTY_SET;

    static {
        C0518h hVar = C0518h.CONCURRENT;
        C0518h hVar2 = C0518h.UNORDERED;
        C0518h hVar3 = C0518h.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(hVar, hVar2, hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar, hVar2));
        f1457a = Collections.unmodifiableSet(EnumSet.of(hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar2, hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar2));
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new C0533k(new a(11), new a(12), new a(15), f1457a);
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence charSequence) {
        return new C0533k(new C0481q(4, charSequence), new a(17), new a(18), new a(19), f1458b);
    }

    public static void a(double[] dArr, double d5) {
        double d6 = d5 - dArr[1];
        double d7 = dArr[0];
        double d8 = d7 + d6;
        dArr[1] = (d8 - d7) - d6;
        dArr[0] = d8;
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends U> function2) {
        return new C0533k(new a(20), new c(function, function2, 2), new a(9), f1457a);
    }
}
