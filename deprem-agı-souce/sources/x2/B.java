package X2;

import W2.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import k3.l;
import kotlin.jvm.internal.t;
import s3.C2751e;
import t3.s;

abstract class B extends z {

    public static final class a implements C2751e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterable f20045a;

        public a(Iterable iterable) {
            this.f20045a = iterable;
        }

        public Iterator iterator() {
            return this.f20045a.iterator();
        }
    }

    public static C2751e D(Iterable iterable) {
        t.e(iterable, "<this>");
        return new a(iterable);
    }

    public static boolean E(Iterable iterable, Object obj) {
        t.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (Q(iterable, obj) >= 0) {
            return true;
        }
        return false;
    }

    public static List F(Iterable iterable, int i5) {
        ArrayList arrayList;
        t.e(iterable, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        } else if (i5 == 0) {
            return n0(iterable);
        } else {
            if (iterable instanceof Collection) {
                int size = ((Collection) iterable).size() - i5;
                if (size <= 0) {
                    return C2251s.g();
                }
                if (size == 1) {
                    return r.d(W(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        List list = (List) iterable;
                        int size2 = list.size();
                        while (i5 < size2) {
                            arrayList.add(list.get(i5));
                            i5++;
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i5);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            int i6 = 0;
            for (Object next : iterable) {
                if (i6 >= i5) {
                    arrayList.add(next);
                } else {
                    i6++;
                }
            }
            return C2251s.m(arrayList);
        }
    }

    public static Object G(Iterable iterable, int i5) {
        t.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).get(i5);
        }
        return I(iterable, i5, new A(i5));
    }

    /* access modifiers changed from: private */
    public static final Object H(int i5, int i6) {
        throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i5 + '.');
    }

    public static final Object I(Iterable iterable, int i5, l lVar) {
        t.e(iterable, "<this>");
        t.e(lVar, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (i5 < 0 || i5 >= list.size()) {
                return lVar.invoke(Integer.valueOf(i5));
            }
            return list.get(i5);
        } else if (i5 < 0) {
            return lVar.invoke(Integer.valueOf(i5));
        } else {
            int i6 = 0;
            for (Object next : iterable) {
                int i7 = i6 + 1;
                if (i5 == i6) {
                    return next;
                }
                i6 = i7;
            }
            return lVar.invoke(Integer.valueOf(i5));
        }
    }

    public static List J(Iterable iterable) {
        t.e(iterable, "<this>");
        return (List) K(iterable, new ArrayList());
    }

    public static final Collection K(Iterable iterable, Collection collection) {
        t.e(iterable, "<this>");
        t.e(collection, "destination");
        for (Object next : iterable) {
            if (next != null) {
                collection.add(next);
            }
        }
        return collection;
    }

    public static final Object L(Iterable iterable) {
        t.e(iterable, "<this>");
        if (iterable instanceof List) {
            return M((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object M(List list) {
        t.e(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object N(Iterable iterable) {
        t.e(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static Object O(List list) {
        t.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object P(List list, int i5) {
        t.e(list, "<this>");
        if (i5 < 0 || i5 >= list.size()) {
            return null;
        }
        return list.get(i5);
    }

    public static final int Q(Iterable iterable, Object obj) {
        t.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i5 = 0;
        for (Object next : iterable) {
            if (i5 < 0) {
                C2251s.o();
            }
            if (t.a(obj, next)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static int R(List list, Object obj) {
        t.e(list, "<this>");
        return list.indexOf(obj);
    }

    public static final Appendable S(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        t.e(iterable, "<this>");
        t.e(appendable, "buffer");
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i6 = 0;
        for (Object next : iterable) {
            i6++;
            if (i6 > 1) {
                appendable.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            s.a(appendable, next, lVar);
        }
        if (i5 >= 0 && i6 > i5) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static /* synthetic */ Appendable T(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i7;
        CharSequence charSequence7;
        l lVar2;
        if ((i6 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i6 & 4) != 0) {
            charSequence6 = charSequence8;
        } else {
            charSequence6 = charSequence2;
        }
        if ((i6 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i6 & 16) != 0) {
            i7 = -1;
        } else {
            i7 = i5;
        }
        if ((i6 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i6 & 64) != 0) {
            lVar2 = null;
        } else {
            lVar2 = lVar;
        }
        return S(iterable, appendable, charSequence5, charSequence6, charSequence8, i7, charSequence7, lVar2);
    }

    public static final String U(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        t.e(iterable, "<this>");
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        return ((StringBuilder) S(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
    }

    public static /* synthetic */ String V(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        l lVar2 = lVar;
        int i7 = i5;
        CharSequence charSequence6 = charSequence2;
        return U(iterable, charSequence, charSequence6, charSequence3, i7, charSequence5, lVar2);
    }

    public static final Object W(Iterable iterable) {
        t.e(iterable, "<this>");
        if (iterable instanceof List) {
            return X((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object X(List list) {
        t.e(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(C2251s.i(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object Y(List list) {
        t.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable Z(Iterable iterable) {
        t.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static Comparable a0(Iterable iterable) {
        t.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static List b0(Collection collection, Iterable iterable) {
        t.e(collection, "<this>");
        t.e(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        C2256x.u(arrayList2, iterable);
        return arrayList2;
    }

    public static List c0(Collection collection, Object obj) {
        t.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object d0(Iterable iterable) {
        t.e(iterable, "<this>");
        if (iterable instanceof List) {
            return e0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final Object e0(List list) {
        t.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static Object f0(List list) {
        t.e(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List g0(Iterable iterable) {
        t.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return n0(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            C2245l.E((Comparable[]) array);
            return C2245l.g(array);
        }
        List o02 = o0(iterable);
        C2255w.s(o02);
        return o02;
    }

    public static List h0(Iterable iterable, Comparator comparator) {
        t.e(iterable, "<this>");
        t.e(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return n0(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            C2245l.F(array, comparator);
            return C2245l.g(array);
        }
        List o02 = o0(iterable);
        C2255w.t(o02, comparator);
        return o02;
    }

    public static List i0(Iterable iterable, int i5) {
        t.e(iterable, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        } else if (i5 == 0) {
            return C2251s.g();
        } else {
            if (iterable instanceof Collection) {
                if (i5 >= ((Collection) iterable).size()) {
                    return n0(iterable);
                }
                if (i5 == 1) {
                    return r.d(L(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i5);
            int i6 = 0;
            for (Object add : iterable) {
                arrayList.add(add);
                i6++;
                if (i6 == i5) {
                    break;
                }
            }
            return C2251s.m(arrayList);
        }
    }

    public static boolean[] j0(Collection collection) {
        t.e(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            zArr[i5] = ((Boolean) it.next()).booleanValue();
            i5++;
        }
        return zArr;
    }

    public static final Collection k0(Iterable iterable, Collection collection) {
        t.e(iterable, "<this>");
        t.e(collection, "destination");
        for (Object add : iterable) {
            collection.add(add);
        }
        return collection;
    }

    public static HashSet l0(Iterable iterable) {
        t.e(iterable, "<this>");
        return (HashSet) k0(iterable, new HashSet(O.e(C2252t.p(iterable, 12))));
    }

    public static int[] m0(Collection collection) {
        t.e(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            iArr[i5] = ((Number) it.next()).intValue();
            i5++;
        }
        return iArr;
    }

    public static List n0(Iterable iterable) {
        Object obj;
        t.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return C2251s.m(o0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return C2251s.g();
        }
        if (size != 1) {
            return p0(collection);
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = collection.iterator().next();
        }
        return r.d(obj);
    }

    public static final List o0(Iterable iterable) {
        t.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return p0((Collection) iterable);
        }
        return (List) k0(iterable, new ArrayList());
    }

    public static List p0(Collection collection) {
        t.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set q0(Iterable iterable) {
        t.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) k0(iterable, new LinkedHashSet());
    }

    public static Set r0(Iterable iterable) {
        Object obj;
        t.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return V.f((Set) k0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return V.d();
        }
        if (size != 1) {
            return (Set) k0(iterable, new LinkedHashSet(O.e(collection.size())));
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = collection.iterator().next();
        }
        return U.c(obj);
    }

    public static List s0(Iterable iterable, Iterable iterable2) {
        t.e(iterable, "<this>");
        t.e(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(C2252t.p(iterable, 10), C2252t.p(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(y.a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
