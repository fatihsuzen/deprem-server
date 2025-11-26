package m0;

import j$.util.Map;
import j$.util.Objects;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import m0.h;

public abstract class j implements Map, Serializable, j$.util.Map {

    /* renamed from: d  reason: collision with root package name */
    static final Map.Entry[] f15562d = new Map.Entry[0];

    /* renamed from: a  reason: collision with root package name */
    private transient k f15563a;

    /* renamed from: b  reason: collision with root package name */
    private transient k f15564b;

    /* renamed from: c  reason: collision with root package name */
    private transient h f15565c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Comparator f15566a;

        /* renamed from: b  reason: collision with root package name */
        Object[] f15567b;

        /* renamed from: c  reason: collision with root package name */
        int f15568c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15569d;

        /* renamed from: e  reason: collision with root package name */
        C0154a f15570e;

        /* renamed from: m0.j$a$a  reason: collision with other inner class name */
        static final class C0154a {

            /* renamed from: a  reason: collision with root package name */
            private final Object f15571a;

            /* renamed from: b  reason: collision with root package name */
            private final Object f15572b;

            /* renamed from: c  reason: collision with root package name */
            private final Object f15573c;

            C0154a(Object obj, Object obj2, Object obj3) {
                this.f15571a = obj;
                this.f15572b = obj2;
                this.f15573c = obj3;
            }

            /* access modifiers changed from: package-private */
            public IllegalArgumentException a() {
                String valueOf = String.valueOf(this.f15571a);
                String valueOf2 = String.valueOf(this.f15572b);
                String valueOf3 = String.valueOf(this.f15571a);
                String valueOf4 = String.valueOf(this.f15573c);
                StringBuilder sb = new StringBuilder(valueOf.length() + 39 + valueOf2.length() + valueOf3.length() + valueOf4.length());
                sb.append("Multiple entries with same key: ");
                sb.append(valueOf);
                sb.append("=");
                sb.append(valueOf2);
                sb.append(" and ");
                sb.append(valueOf3);
                sb.append("=");
                sb.append(valueOf4);
                return new IllegalArgumentException(sb.toString());
            }
        }

        public a() {
            this(4);
        }

        private j b(boolean z4) {
            Object[] objArr;
            C0154a aVar;
            C0154a aVar2;
            if (!z4 || (aVar2 = this.f15570e) == null) {
                int i5 = this.f15568c;
                if (this.f15566a == null) {
                    objArr = this.f15567b;
                } else {
                    if (this.f15569d) {
                        this.f15567b = Arrays.copyOf(this.f15567b, i5 * 2);
                    }
                    objArr = this.f15567b;
                    if (!z4) {
                        objArr = e(objArr, this.f15568c);
                        if (objArr.length < this.f15567b.length) {
                            i5 = objArr.length >>> 1;
                        }
                    }
                    j(objArr, i5, this.f15566a);
                }
                this.f15569d = true;
                u o5 = u.o(i5, objArr, this);
                if (!z4 || (aVar = this.f15570e) == null) {
                    return o5;
                }
                throw aVar.a();
            }
            throw aVar2.a();
        }

        private void d(int i5) {
            int i6 = i5 * 2;
            Object[] objArr = this.f15567b;
            if (i6 > objArr.length) {
                this.f15567b = Arrays.copyOf(objArr, h.b.a(objArr.length, i6));
                this.f15569d = false;
            }
        }

        private Object[] e(Object[] objArr, int i5) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i6 = i5 - 1; i6 >= 0; i6--) {
                Object obj = objArr[i6 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i6);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[((i5 - bitSet.cardinality()) * 2)];
            int i7 = 0;
            int i8 = 0;
            while (i7 < i5 * 2) {
                if (bitSet.get(i7 >>> 1)) {
                    i7 += 2;
                } else {
                    int i9 = i8 + 1;
                    int i10 = i7 + 1;
                    Object obj2 = objArr[i7];
                    Objects.requireNonNull(obj2);
                    objArr2[i8] = obj2;
                    i8 += 2;
                    i7 += 2;
                    Object obj3 = objArr[i10];
                    Objects.requireNonNull(obj3);
                    objArr2[i9] = obj3;
                }
            }
            return objArr2;
        }

        static void j(Object[] objArr, int i5, Comparator comparator) {
            Map.Entry[] entryArr = new Map.Entry[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 2;
                Object obj = objArr[i7];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i7 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i6] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i5, r.a(comparator).b(o.c()));
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = i8 * 2;
                objArr[i9] = entryArr[i8].getKey();
                objArr[i9 + 1] = entryArr[i8].getValue();
            }
        }

        public j a() {
            return c();
        }

        public j c() {
            return b(true);
        }

        public a f(Object obj, Object obj2) {
            d(this.f15568c + 1);
            C1715d.a(obj, obj2);
            Object[] objArr = this.f15567b;
            int i5 = this.f15568c;
            objArr[i5 * 2] = obj;
            objArr[(i5 * 2) + 1] = obj2;
            this.f15568c = i5 + 1;
            return this;
        }

        public a g(Map.Entry entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a h(Iterable iterable) {
            if (iterable instanceof Collection) {
                d(this.f15568c + ((Collection) iterable).size());
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                g((Map.Entry) it.next());
            }
            return this;
        }

        public a i(Map map) {
            return h(map.entrySet());
        }

        a(int i5) {
            this.f15567b = new Object[(i5 * 2)];
            this.f15568c = 0;
            this.f15569d = false;
        }
    }

    j() {
    }

    public static a a() {
        return new a();
    }

    public static j b(Iterable iterable) {
        int i5;
        if (iterable instanceof Collection) {
            i5 = ((Collection) iterable).size();
        } else {
            i5 = 4;
        }
        a aVar = new a(i5);
        aVar.h(iterable);
        return aVar.a();
    }

    public static j i() {
        return u.f15583h;
    }

    public static j j(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        C1715d.a(obj, obj2);
        C1715d.a(obj3, obj4);
        C1715d.a(obj5, obj6);
        C1715d.a(obj7, obj8);
        return u.n(4, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8});
    }

    public static j k(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        C1715d.a(obj, obj2);
        C1715d.a(obj3, obj4);
        C1715d.a(obj5, obj6);
        C1715d.a(obj7, obj8);
        C1715d.a(obj9, obj10);
        return u.n(5, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10});
    }

    public static j l(Map.Entry... entryArr) {
        return b(Arrays.asList(entryArr));
    }

    /* access modifiers changed from: package-private */
    public abstract k c();

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    /* access modifiers changed from: package-private */
    public abstract k e();

    public boolean equals(Object obj) {
        return o.a(this, obj);
    }

    /* access modifiers changed from: package-private */
    public abstract h f();

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    /* renamed from: g */
    public k entrySet() {
        k kVar = this.f15563a;
        if (kVar != null) {
            return kVar;
        }
        k c5 = c();
        this.f15563a = c5;
        return c5;
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    /* renamed from: h */
    public k keySet() {
        k kVar = this.f15564b;
        if (kVar != null) {
            return kVar;
        }
        k e5 = e();
        this.f15564b = e5;
        return e5;
    }

    public int hashCode() {
        return w.b(entrySet());
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public h values() {
        h hVar = this.f15565c;
        if (hVar != null) {
            return hVar;
        }
        h f5 = f();
        this.f15565c = f5;
        return f5;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.$default$replace(this, obj, obj2);
    }

    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public String toString() {
        return o.b(this);
    }

    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }
}
