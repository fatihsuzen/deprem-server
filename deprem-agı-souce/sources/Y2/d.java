package Y2;

import X2.C2236c;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2677a;
import l3.C2680d;
import q3.C2729e;

public final class d implements Map, Serializable, C2677a {

    /* renamed from: n  reason: collision with root package name */
    public static final a f20169n = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final d f20170o;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Object[] f20171a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Object[] f20172b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int[] f20173c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f20174d;

    /* renamed from: e  reason: collision with root package name */
    private int f20175e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f20176f;

    /* renamed from: g  reason: collision with root package name */
    private int f20177g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f20178h;

    /* renamed from: i  reason: collision with root package name */
    private int f20179i;

    /* renamed from: j  reason: collision with root package name */
    private f f20180j;

    /* renamed from: k  reason: collision with root package name */
    private g f20181k;

    /* renamed from: l  reason: collision with root package name */
    private e f20182l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f20183m;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final int c(int i5) {
            return Integer.highestOneBit(C2729e.c(i5, 1) * 3);
        }

        /* access modifiers changed from: private */
        public final int d(int i5) {
            return Integer.numberOfLeadingZeros(i5) + 1;
        }

        public final d e() {
            return d.f20170o;
        }

        private a() {
        }
    }

    public static final class b extends C0197d implements Iterator, C2677a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(dVar);
            t.e(dVar, "map");
        }

        /* renamed from: i */
        public c next() {
            a();
            if (b() < e().f20176f) {
                int b5 = b();
                g(b5 + 1);
                h(b5);
                c cVar = new c(e(), c());
                f();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void j(StringBuilder sb) {
            t.e(sb, "sb");
            if (b() < e().f20176f) {
                int b5 = b();
                g(b5 + 1);
                h(b5);
                Object obj = e().f20171a[c()];
                if (obj == e()) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] h5 = e().f20172b;
                t.b(h5);
                Object obj2 = h5[c()];
                if (obj2 == e()) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                f();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int k() {
            int i5;
            if (b() < e().f20176f) {
                int b5 = b();
                g(b5 + 1);
                h(b5);
                Object obj = e().f20171a[c()];
                int i6 = 0;
                if (obj != null) {
                    i5 = obj.hashCode();
                } else {
                    i5 = 0;
                }
                Object[] h5 = e().f20172b;
                t.b(h5);
                Object obj2 = h5[c()];
                if (obj2 != null) {
                    i6 = obj2.hashCode();
                }
                int i7 = i5 ^ i6;
                f();
                return i7;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class c implements Map.Entry, C2680d {

        /* renamed from: a  reason: collision with root package name */
        private final d f20184a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20185b;

        /* renamed from: c  reason: collision with root package name */
        private final int f20186c;

        public c(d dVar, int i5) {
            t.e(dVar, "map");
            this.f20184a = dVar;
            this.f20185b = i5;
            this.f20186c = dVar.f20178h;
        }

        private final void a() {
            if (this.f20184a.f20178h != this.f20186c) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!t.a(entry.getKey(), getKey()) || !t.a(entry.getValue(), getValue())) {
                return false;
            }
            return true;
        }

        public Object getKey() {
            a();
            return this.f20184a.f20171a[this.f20185b];
        }

        public Object getValue() {
            a();
            Object[] h5 = this.f20184a.f20172b;
            t.b(h5);
            return h5[this.f20185b];
        }

        public int hashCode() {
            int i5;
            Object key = getKey();
            int i6 = 0;
            if (key != null) {
                i5 = key.hashCode();
            } else {
                i5 = 0;
            }
            Object value = getValue();
            if (value != null) {
                i6 = value.hashCode();
            }
            return i5 ^ i6;
        }

        public Object setValue(Object obj) {
            a();
            this.f20184a.m();
            Object[] a5 = this.f20184a.k();
            int i5 = this.f20185b;
            Object obj2 = a5[i5];
            a5[i5] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* renamed from: Y2.d$d  reason: collision with other inner class name */
    public static class C0197d {

        /* renamed from: a  reason: collision with root package name */
        private final d f20187a;

        /* renamed from: b  reason: collision with root package name */
        private int f20188b;

        /* renamed from: c  reason: collision with root package name */
        private int f20189c = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f20190d;

        public C0197d(d dVar) {
            t.e(dVar, "map");
            this.f20187a = dVar;
            this.f20190d = dVar.f20178h;
            f();
        }

        public final void a() {
            if (this.f20187a.f20178h != this.f20190d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int b() {
            return this.f20188b;
        }

        public final int c() {
            return this.f20189c;
        }

        public final d e() {
            return this.f20187a;
        }

        public final void f() {
            while (this.f20188b < this.f20187a.f20176f) {
                int[] g5 = this.f20187a.f20173c;
                int i5 = this.f20188b;
                if (g5[i5] < 0) {
                    this.f20188b = i5 + 1;
                } else {
                    return;
                }
            }
        }

        public final void g(int i5) {
            this.f20188b = i5;
        }

        public final void h(int i5) {
            this.f20189c = i5;
        }

        public final boolean hasNext() {
            if (this.f20188b < this.f20187a.f20176f) {
                return true;
            }
            return false;
        }

        public final void remove() {
            a();
            if (this.f20189c != -1) {
                this.f20187a.m();
                this.f20187a.K(this.f20189c);
                this.f20189c = -1;
                this.f20190d = this.f20187a.f20178h;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
    }

    public static final class e extends C0197d implements Iterator, C2677a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d dVar) {
            super(dVar);
            t.e(dVar, "map");
        }

        public Object next() {
            a();
            if (b() < e().f20176f) {
                int b5 = b();
                g(b5 + 1);
                h(b5);
                Object obj = e().f20171a[c()];
                f();
                return obj;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class f extends C0197d implements Iterator, C2677a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d dVar) {
            super(dVar);
            t.e(dVar, "map");
        }

        public Object next() {
            a();
            if (b() < e().f20176f) {
                int b5 = b();
                g(b5 + 1);
                h(b5);
                Object[] h5 = e().f20172b;
                t.b(h5);
                Object obj = h5[c()];
                f();
                return obj;
            }
            throw new NoSuchElementException();
        }
    }

    static {
        d dVar = new d(0);
        dVar.f20183m = true;
        f20170o = dVar;
    }

    private d(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i5, int i6) {
        this.f20171a = objArr;
        this.f20172b = objArr2;
        this.f20173c = iArr;
        this.f20174d = iArr2;
        this.f20175e = i5;
        this.f20176f = i6;
        this.f20177g = f20169n.d(y());
    }

    private final int C(Object obj) {
        int i5;
        if (obj != null) {
            i5 = obj.hashCode();
        } else {
            i5 = 0;
        }
        return (i5 * -1640531527) >>> this.f20177g;
    }

    private final boolean E(Collection collection) {
        boolean z4 = false;
        if (collection.isEmpty()) {
            return false;
        }
        s(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (F((Map.Entry) it.next())) {
                z4 = true;
            }
        }
        return z4;
    }

    private final boolean F(Map.Entry entry) {
        int j5 = j(entry.getKey());
        Object[] k5 = k();
        if (j5 >= 0) {
            k5[j5] = entry.getValue();
            return true;
        }
        int i5 = (-j5) - 1;
        if (t.a(entry.getValue(), k5[i5])) {
            return false;
        }
        k5[i5] = entry.getValue();
        return true;
    }

    private final boolean G(int i5) {
        int C4 = C(this.f20171a[i5]);
        int i6 = this.f20175e;
        while (true) {
            int[] iArr = this.f20174d;
            if (iArr[C4] == 0) {
                iArr[C4] = i5 + 1;
                this.f20173c[i5] = C4;
                return true;
            }
            i6--;
            if (i6 < 0) {
                return false;
            }
            int i7 = C4 - 1;
            if (C4 == 0) {
                C4 = y() - 1;
            } else {
                C4 = i7;
            }
        }
    }

    private final void H() {
        this.f20178h++;
    }

    private final void I(int i5) {
        H();
        int i6 = 0;
        if (this.f20176f > size()) {
            n(false);
        }
        this.f20174d = new int[i5];
        this.f20177g = f20169n.d(i5);
        while (i6 < this.f20176f) {
            int i7 = i6 + 1;
            if (G(i6)) {
                i6 = i7;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void K(int i5) {
        c.f(this.f20171a, i5);
        Object[] objArr = this.f20172b;
        if (objArr != null) {
            c.f(objArr, i5);
        }
        L(this.f20173c[i5]);
        this.f20173c[i5] = -1;
        this.f20179i = size() - 1;
        H();
    }

    private final void L(int i5) {
        int e5 = C2729e.e(this.f20175e * 2, y() / 2);
        int i6 = 0;
        int i7 = i5;
        do {
            int i8 = i5 - 1;
            if (i5 == 0) {
                i5 = y() - 1;
            } else {
                i5 = i8;
            }
            i6++;
            if (i6 > this.f20175e) {
                this.f20174d[i7] = 0;
                return;
            }
            int[] iArr = this.f20174d;
            int i9 = iArr[i5];
            if (i9 == 0) {
                iArr[i7] = 0;
                return;
            }
            if (i9 < 0) {
                iArr[i7] = -1;
            } else {
                int i10 = i9 - 1;
                if (((C(this.f20171a[i10]) - i5) & (y() - 1)) >= i6) {
                    this.f20174d[i7] = i9;
                    this.f20173c[i10] = i7;
                }
                e5--;
            }
            i7 = i5;
            i6 = 0;
            e5--;
        } while (e5 >= 0);
        this.f20174d[i7] = -1;
    }

    private final boolean O(int i5) {
        int w4 = w();
        int i6 = this.f20176f;
        int i7 = w4 - i6;
        int size = i6 - size();
        if (i7 >= i5 || i7 + size < i5 || size < w() / 4) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final Object[] k() {
        Object[] objArr = this.f20172b;
        if (objArr != null) {
            return objArr;
        }
        Object[] d5 = c.d(w());
        this.f20172b = d5;
        return d5;
    }

    private final void n(boolean z4) {
        int i5;
        Object[] objArr = this.f20172b;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i5 = this.f20176f;
            if (i6 >= i5) {
                break;
            }
            int[] iArr = this.f20173c;
            int i8 = iArr[i6];
            if (i8 >= 0) {
                Object[] objArr2 = this.f20171a;
                objArr2[i7] = objArr2[i6];
                if (objArr != null) {
                    objArr[i7] = objArr[i6];
                }
                if (z4) {
                    iArr[i7] = i8;
                    this.f20174d[i8] = i7 + 1;
                }
                i7++;
            }
            i6++;
        }
        c.g(this.f20171a, i7, i5);
        if (objArr != null) {
            c.g(objArr, i7, this.f20176f);
        }
        this.f20176f = i7;
    }

    private final boolean q(Map map) {
        if (size() != map.size() || !o(map.entrySet())) {
            return false;
        }
        return true;
    }

    private final void r(int i5) {
        Object[] objArr;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        } else if (i5 > w()) {
            int e5 = C2236c.Companion.e(w(), i5);
            this.f20171a = c.e(this.f20171a, e5);
            Object[] objArr2 = this.f20172b;
            if (objArr2 != null) {
                objArr = c.e(objArr2, e5);
            } else {
                objArr = null;
            }
            this.f20172b = objArr;
            int[] copyOf = Arrays.copyOf(this.f20173c, e5);
            t.d(copyOf, "copyOf(...)");
            this.f20173c = copyOf;
            int a5 = f20169n.c(e5);
            if (a5 > y()) {
                I(a5);
            }
        }
    }

    private final void s(int i5) {
        if (O(i5)) {
            n(true);
        } else {
            r(this.f20176f + i5);
        }
    }

    private final int u(Object obj) {
        int C4 = C(obj);
        int i5 = this.f20175e;
        while (true) {
            int i6 = this.f20174d[C4];
            if (i6 == 0) {
                return -1;
            }
            if (i6 > 0) {
                int i7 = i6 - 1;
                if (t.a(this.f20171a[i7], obj)) {
                    return i7;
                }
            }
            i5--;
            if (i5 < 0) {
                return -1;
            }
            int i8 = C4 - 1;
            if (C4 == 0) {
                C4 = y() - 1;
            } else {
                C4 = i8;
            }
        }
    }

    private final int v(Object obj) {
        int i5 = this.f20176f;
        while (true) {
            i5--;
            if (i5 < 0) {
                return -1;
            }
            if (this.f20173c[i5] >= 0) {
                Object[] objArr = this.f20172b;
                t.b(objArr);
                if (t.a(objArr[i5], obj)) {
                    return i5;
                }
            }
        }
    }

    private final int y() {
        return this.f20174d.length;
    }

    public int A() {
        return this.f20179i;
    }

    public Collection B() {
        g gVar = this.f20181k;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        this.f20181k = gVar2;
        return gVar2;
    }

    public final e D() {
        return new e(this);
    }

    public final boolean J(Map.Entry entry) {
        t.e(entry, "entry");
        m();
        int u5 = u(entry.getKey());
        if (u5 < 0) {
            return false;
        }
        Object[] objArr = this.f20172b;
        t.b(objArr);
        if (!t.a(objArr[u5], entry.getValue())) {
            return false;
        }
        K(u5);
        return true;
    }

    public final boolean M(Object obj) {
        m();
        int u5 = u(obj);
        if (u5 < 0) {
            return false;
        }
        K(u5);
        return true;
    }

    public final boolean N(Object obj) {
        m();
        int v5 = v(obj);
        if (v5 < 0) {
            return false;
        }
        K(v5);
        return true;
    }

    public final f P() {
        return new f(this);
    }

    public void clear() {
        m();
        int i5 = this.f20176f - 1;
        if (i5 >= 0) {
            int i6 = 0;
            while (true) {
                int[] iArr = this.f20173c;
                int i7 = iArr[i6];
                if (i7 >= 0) {
                    this.f20174d[i7] = 0;
                    iArr[i6] = -1;
                }
                if (i6 == i5) {
                    break;
                }
                i6++;
            }
        }
        c.g(this.f20171a, 0, this.f20176f);
        Object[] objArr = this.f20172b;
        if (objArr != null) {
            c.g(objArr, 0, this.f20176f);
        }
        this.f20179i = 0;
        this.f20176f = 0;
        H();
    }

    public boolean containsKey(Object obj) {
        if (u(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (v(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final /* bridge */ Set entrySet() {
        return x();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map) || !q((Map) obj)) {
            return false;
        }
        return true;
    }

    public Object get(Object obj) {
        int u5 = u(obj);
        if (u5 < 0) {
            return null;
        }
        Object[] objArr = this.f20172b;
        t.b(objArr);
        return objArr[u5];
    }

    public int hashCode() {
        b t5 = t();
        int i5 = 0;
        while (t5.hasNext()) {
            i5 += t5.k();
        }
        return i5;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final int j(Object obj) {
        m();
        while (true) {
            int C4 = C(obj);
            int e5 = C2729e.e(this.f20175e * 2, y() / 2);
            int i5 = 0;
            while (true) {
                int i6 = this.f20174d[C4];
                if (i6 <= 0) {
                    if (this.f20176f >= w()) {
                        s(1);
                    } else {
                        int i7 = this.f20176f;
                        int i8 = i7 + 1;
                        this.f20176f = i8;
                        this.f20171a[i7] = obj;
                        this.f20173c[i7] = C4;
                        this.f20174d[C4] = i8;
                        this.f20179i = size() + 1;
                        H();
                        if (i5 > this.f20175e) {
                            this.f20175e = i5;
                        }
                        return i7;
                    }
                } else if (t.a(this.f20171a[i6 - 1], obj)) {
                    return -i6;
                } else {
                    i5++;
                    if (i5 > e5) {
                        I(y() * 2);
                        break;
                    }
                    int i9 = C4 - 1;
                    if (C4 == 0) {
                        C4 = y() - 1;
                    } else {
                        C4 = i9;
                    }
                }
            }
        }
    }

    public final /* bridge */ Set keySet() {
        return z();
    }

    public final Map l() {
        m();
        this.f20183m = true;
        if (size() > 0) {
            return this;
        }
        d dVar = f20170o;
        t.c(dVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return dVar;
    }

    public final void m() {
        if (this.f20183m) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean o(Collection collection) {
        t.e(collection, "m");
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!p((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean p(Map.Entry entry) {
        t.e(entry, "entry");
        int u5 = u(entry.getKey());
        if (u5 < 0) {
            return false;
        }
        Object[] objArr = this.f20172b;
        t.b(objArr);
        return t.a(objArr[u5], entry.getValue());
    }

    public Object put(Object obj, Object obj2) {
        m();
        int j5 = j(obj);
        Object[] k5 = k();
        if (j5 < 0) {
            int i5 = (-j5) - 1;
            Object obj3 = k5[i5];
            k5[i5] = obj2;
            return obj3;
        }
        k5[j5] = obj2;
        return null;
    }

    public void putAll(Map map) {
        t.e(map, TypedValues.TransitionType.S_FROM);
        m();
        E(map.entrySet());
    }

    public Object remove(Object obj) {
        m();
        int u5 = u(obj);
        if (u5 < 0) {
            return null;
        }
        Object[] objArr = this.f20172b;
        t.b(objArr);
        Object obj2 = objArr[u5];
        K(u5);
        return obj2;
    }

    public final /* bridge */ int size() {
        return A();
    }

    public final b t() {
        return new b(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b t5 = t();
        int i5 = 0;
        while (t5.hasNext()) {
            if (i5 > 0) {
                sb.append(", ");
            }
            t5.j(sb);
            i5++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return sb2;
    }

    public final /* bridge */ Collection values() {
        return B();
    }

    public final int w() {
        return this.f20171a.length;
    }

    public Set x() {
        e eVar = this.f20182l;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.f20182l = eVar2;
        return eVar2;
    }

    public Set z() {
        f fVar = this.f20180j;
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(this);
        this.f20180j = fVar2;
        return fVar2;
    }

    public d() {
        this(8);
    }

    public d(int i5) {
        this(c.d(i5), (Object[]) null, new int[i5], new int[f20169n.c(i5)], 2, 0);
    }
}
