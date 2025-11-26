package j$.util;

import j$.com.android.tools.r8.a;
import j$.util.Map;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.e  reason: case insensitive filesystem */
public abstract /* synthetic */ class C0469e {
    public static /* synthetic */ void q(Map map, BiConsumer biConsumer) {
        if (map instanceof Map) {
            ((Map) map).forEach(biConsumer);
        } else if (map instanceof ConcurrentMap) {
            a.j((ConcurrentMap) map, biConsumer);
        } else {
            Map.CC.$default$forEach(map, biConsumer);
        }
    }

    public static /* synthetic */ Object t(java.util.Map map, Object obj, Object obj2) {
        return map instanceof Map ? ((Map) map).putIfAbsent(obj, obj2) : Map.CC.$default$putIfAbsent(map, obj, obj2);
    }

    public static B i(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? new B(optional.get()) : B.f1253b;
    }

    public static C j(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? new C(optionalDouble.getAsDouble()) : C.f1255c;
    }

    public static E l(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? new E(optionalLong.getAsLong()) : E.f1261c;
    }

    public static D k(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? new D(optionalInt.getAsInt()) : D.f1258c;
    }

    public static Object s(java.util.Map map, Object obj, Object obj2) {
        if (map instanceof Map) {
            return ((Map) map).getOrDefault(obj, obj2);
        }
        if (!(map instanceof ConcurrentMap)) {
            return Map.CC.$default$getOrDefault(map, obj, obj2);
        }
        Object obj3 = ((ConcurrentMap) map).get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public static void r(Iterator it, Consumer consumer) {
        if (it instanceof C0618z) {
            ((C0618z) it).forEachRemaining(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static OptionalDouble n(C c5) {
        if (c5 == null) {
            return null;
        }
        boolean z4 = c5.f1256a;
        if (!z4) {
            return OptionalDouble.empty();
        }
        if (z4) {
            return OptionalDouble.of(c5.f1257b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static OptionalInt o(D d5) {
        if (d5 == null) {
            return null;
        }
        boolean z4 = d5.f1259a;
        if (!z4) {
            return OptionalInt.empty();
        }
        if (z4) {
            return OptionalInt.of(d5.f1260b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static OptionalLong p(E e5) {
        if (e5 == null) {
            return null;
        }
        boolean z4 = e5.f1262a;
        if (!z4) {
            return OptionalLong.empty();
        }
        if (z4) {
            return OptionalLong.of(e5.f1263b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static Optional m(B b5) {
        if (b5 == null) {
            return null;
        }
        Object obj = b5.f1254a;
        if (obj == null) {
            return Optional.empty();
        }
        if (obj != null) {
            return Optional.of(obj);
        }
        throw new NoSuchElementException("No value present");
    }

    public static l0 v(Object[] objArr, int i5, int i6) {
        u0.a(((Object[]) Objects.requireNonNull(objArr)).length, i5, i6);
        return new l0(objArr, i5, i6, 1040);
    }

    public static C0468d w(C0470f fVar, Comparator comparator) {
        Objects.requireNonNull(comparator);
        return new C0468d(fVar, comparator);
    }

    public static long d(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1;
        }
        return spliterator.estimateSize();
    }

    public static boolean e(Spliterator spliterator, int i5) {
        return (spliterator.characteristics() & i5) == i5;
    }

    public static void u(List list, Comparator comparator) {
        if (list instanceof List) {
            ((List) list).sort(comparator);
            return;
        }
        Object[] array = list.toArray();
        Arrays.sort(array, comparator);
        ListIterator listIterator = list.listIterator();
        for (Object obj : array) {
            listIterator.next();
            listIterator.set(obj);
        }
    }

    public static boolean g(Z z4, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            return z4.tryAdvance((IntConsumer) consumer);
        }
        if (!x0.f1861a) {
            Objects.requireNonNull(consumer);
            return z4.tryAdvance(new J(consumer, 0));
        }
        x0.a(z4.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
        throw null;
    }

    public static void b(Z z4, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            z4.forEachRemaining((IntConsumer) consumer);
        } else if (!x0.f1861a) {
            Objects.requireNonNull(consumer);
            z4.forEachRemaining(new J(consumer, 0));
        } else {
            x0.a(z4.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
            throw null;
        }
    }

    public static boolean h(c0 c0Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            return c0Var.tryAdvance((LongConsumer) consumer);
        }
        if (!x0.f1861a) {
            Objects.requireNonNull(consumer);
            return c0Var.tryAdvance(new N(consumer, 0));
        }
        x0.a(c0Var.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
        throw null;
    }

    public static void c(c0 c0Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            c0Var.forEachRemaining((LongConsumer) consumer);
        } else if (!x0.f1861a) {
            Objects.requireNonNull(consumer);
            c0Var.forEachRemaining(new N(consumer, 0));
        } else {
            x0.a(c0Var.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
            throw null;
        }
    }

    public static boolean f(W w4, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            return w4.tryAdvance((DoubleConsumer) consumer);
        }
        if (!x0.f1861a) {
            Objects.requireNonNull(consumer);
            return w4.tryAdvance(new F(consumer, 0));
        }
        x0.a(w4.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
        throw null;
    }

    public static void a(W w4, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            w4.forEachRemaining((DoubleConsumer) consumer);
        } else if (!x0.f1861a) {
            Objects.requireNonNull(consumer);
            w4.forEachRemaining(new F(consumer, 0));
        } else {
            x0.a(w4.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
            throw null;
        }
    }

    public Spliterator trySplit() {
        return null;
    }

    public boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        return false;
    }

    public void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
    }

    public long estimateSize() {
        return 0;
    }

    public int characteristics() {
        return 16448;
    }
}
