package j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

public interface List<E> extends Collection<E> {
    void replaceAll(UnaryOperator<E> unaryOperator);

    void sort(Comparator<? super E> comparator);

    Spliterator<E> spliterator();

    /* renamed from: j$.util.List$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Spliterator $default$spliterator(java.util.List list) {
            return list instanceof RandomAccess ? new C0465a(list) : new s0(16, (Collection) Objects.requireNonNull(list));
        }
    }
}
