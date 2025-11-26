package j$.util;

import j$.util.List;
import j$.util.stream.C0594w1;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public interface Collection<E> {
    void forEach(Consumer<? super E> consumer);

    Stream<E> parallelStream();

    boolean removeIf(Predicate<? super E> predicate);

    Spliterator<E> spliterator();

    Stream<E> stream();

    <T> T[] toArray(IntFunction<T[]> intFunction);

    /* renamed from: j$.util.Collection$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object[] $default$toArray(java.util.Collection collection, IntFunction intFunction) {
            return collection.toArray((Object[]) intFunction.apply(0));
        }

        public static Spliterator $default$spliterator(java.util.Collection collection) {
            return new s0(0, (java.util.Collection) Objects.requireNonNull(collection));
        }

        public static boolean $default$removeIf(java.util.Collection collection, Predicate predicate) {
            Objects.requireNonNull(predicate);
            Iterator it = collection.iterator();
            boolean z4 = false;
            while (it.hasNext()) {
                if (predicate.test(it.next())) {
                    it.remove();
                    z4 = true;
                }
            }
            return z4;
        }

        public static Stream $default$stream(java.util.Collection collection) {
            return C0594w1.E0(EL.c(collection), false);
        }

        public static Stream $default$parallelStream(java.util.Collection collection) {
            return C0594w1.E0(EL.c(collection), true);
        }
    }

    /* renamed from: j$.util.Collection$-EL  reason: invalid class name */
    public final /* synthetic */ class EL {
        public static /* synthetic */ Stream b(java.util.Collection collection) {
            return collection instanceof Collection ? ((Collection) collection).parallelStream() : CC.$default$parallelStream(collection);
        }

        public static /* synthetic */ Stream stream(java.util.Collection collection) {
            return collection instanceof Collection ? ((Collection) collection).stream() : CC.$default$stream(collection);
        }

        public static Spliterator c(java.util.Collection collection) {
            if (collection instanceof Collection) {
                return ((Collection) collection).spliterator();
            }
            if (collection instanceof LinkedHashSet) {
                return new s0(17, (java.util.Collection) Objects.requireNonNull((LinkedHashSet) collection));
            }
            if (!(collection instanceof SortedSet)) {
                return collection instanceof Set ? new s0(1, (java.util.Collection) Objects.requireNonNull((Set) collection)) : collection instanceof List ? List.CC.$default$spliterator((java.util.List) collection) : CC.$default$spliterator(collection);
            }
            SortedSet sortedSet = (SortedSet) collection;
            return new T(sortedSet, sortedSet);
        }

        public static void a(java.util.Collection collection, Consumer consumer) {
            if (collection instanceof Collection) {
                ((Collection) collection).forEach(consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            for (Object accept : collection) {
                consumer.accept(accept);
            }
        }
    }
}
