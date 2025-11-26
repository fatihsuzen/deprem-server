package j$.util;

import java.util.Comparator;
import java.util.function.Function;

/* renamed from: j$.util.Comparator$-CC  reason: invalid class name */
public final /* synthetic */ class Comparator$CC {
    public static <T, U> Comparator<T> comparing(Function<? super T, ? extends U> function, Comparator<? super U> comparator) {
        Objects.requireNonNull(function);
        Objects.requireNonNull(comparator);
        return new C0468d((Function) function, (Comparator) comparator);
    }
}
