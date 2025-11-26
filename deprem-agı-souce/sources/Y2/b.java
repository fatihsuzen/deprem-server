package Y2;

import X2.C2236c;
import X2.C2238e;
import X2.C2242i;
import X2.C2250q;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2677a;
import l3.C2678b;

public final class b extends C2238e implements List, RandomAccess, Serializable, C2678b {

    /* renamed from: d  reason: collision with root package name */
    private static final C0196b f20151d = new C0196b((C2633k) null);

    /* renamed from: e  reason: collision with root package name */
    private static final b f20152e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Object[] f20153a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f20154b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f20155c;

    public static final class a extends C2238e implements List, RandomAccess, Serializable, C2678b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Object[] f20156a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f20157b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f20158c;

        /* renamed from: d  reason: collision with root package name */
        private final a f20159d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final b f20160e;

        /* renamed from: Y2.b$a$a  reason: collision with other inner class name */
        private static final class C0195a implements ListIterator, C2677a {

            /* renamed from: a  reason: collision with root package name */
            private final a f20161a;

            /* renamed from: b  reason: collision with root package name */
            private int f20162b;

            /* renamed from: c  reason: collision with root package name */
            private int f20163c = -1;

            /* renamed from: d  reason: collision with root package name */
            private int f20164d;

            public C0195a(a aVar, int i5) {
                t.e(aVar, "list");
                this.f20161a = aVar;
                this.f20162b = i5;
                this.f20164d = aVar.modCount;
            }

            private final void a() {
                if (this.f20161a.f20160e.modCount != this.f20164d) {
                    throw new ConcurrentModificationException();
                }
            }

            public void add(Object obj) {
                a();
                a aVar = this.f20161a;
                int i5 = this.f20162b;
                this.f20162b = i5 + 1;
                aVar.add(i5, obj);
                this.f20163c = -1;
                this.f20164d = this.f20161a.modCount;
            }

            public boolean hasNext() {
                if (this.f20162b < this.f20161a.f20158c) {
                    return true;
                }
                return false;
            }

            public boolean hasPrevious() {
                if (this.f20162b > 0) {
                    return true;
                }
                return false;
            }

            public Object next() {
                a();
                if (this.f20162b < this.f20161a.f20158c) {
                    int i5 = this.f20162b;
                    this.f20162b = i5 + 1;
                    this.f20163c = i5;
                    return this.f20161a.f20156a[this.f20161a.f20157b + this.f20163c];
                }
                throw new NoSuchElementException();
            }

            public int nextIndex() {
                return this.f20162b;
            }

            public Object previous() {
                a();
                int i5 = this.f20162b;
                if (i5 > 0) {
                    int i6 = i5 - 1;
                    this.f20162b = i6;
                    this.f20163c = i6;
                    return this.f20161a.f20156a[this.f20161a.f20157b + this.f20163c];
                }
                throw new NoSuchElementException();
            }

            public int previousIndex() {
                return this.f20162b - 1;
            }

            public void remove() {
                a();
                int i5 = this.f20163c;
                if (i5 != -1) {
                    this.f20161a.remove(i5);
                    this.f20162b = this.f20163c;
                    this.f20163c = -1;
                    this.f20164d = this.f20161a.modCount;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }

            public void set(Object obj) {
                a();
                int i5 = this.f20163c;
                if (i5 != -1) {
                    this.f20161a.set(i5, obj);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
        }

        public a(Object[] objArr, int i5, int i6, a aVar, b bVar) {
            t.e(objArr, "backing");
            t.e(bVar, "root");
            this.f20156a = objArr;
            this.f20157b = i5;
            this.f20158c = i6;
            this.f20159d = aVar;
            this.f20160e = bVar;
            this.modCount = bVar.modCount;
        }

        private final void n(int i5, Collection collection, int i6) {
            t();
            a aVar = this.f20159d;
            if (aVar != null) {
                aVar.n(i5, collection, i6);
            } else {
                this.f20160e.r(i5, collection, i6);
            }
            this.f20156a = this.f20160e.f20153a;
            this.f20158c += i6;
        }

        private final void o(int i5, Object obj) {
            t();
            a aVar = this.f20159d;
            if (aVar != null) {
                aVar.o(i5, obj);
            } else {
                this.f20160e.s(i5, obj);
            }
            this.f20156a = this.f20160e.f20153a;
            this.f20158c++;
        }

        private final void p() {
            if (this.f20160e.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void q() {
            if (s()) {
                throw new UnsupportedOperationException();
            }
        }

        private final boolean r(List list) {
            return c.h(this.f20156a, this.f20157b, this.f20158c, list);
        }

        private final boolean s() {
            return this.f20160e.f20155c;
        }

        private final void t() {
            this.modCount++;
        }

        private final Object u(int i5) {
            Object obj;
            t();
            a aVar = this.f20159d;
            if (aVar != null) {
                obj = aVar.u(i5);
            } else {
                obj = this.f20160e.C(i5);
            }
            this.f20158c--;
            return obj;
        }

        private final void v(int i5, int i6) {
            if (i6 > 0) {
                t();
            }
            a aVar = this.f20159d;
            if (aVar != null) {
                aVar.v(i5, i6);
            } else {
                this.f20160e.D(i5, i6);
            }
            this.f20158c -= i6;
        }

        private final int w(int i5, int i6, Collection collection, boolean z4) {
            int i7;
            a aVar = this.f20159d;
            if (aVar != null) {
                i7 = aVar.w(i5, i6, collection, z4);
            } else {
                i7 = this.f20160e.E(i5, i6, collection, z4);
            }
            if (i7 > 0) {
                t();
            }
            this.f20158c -= i7;
            return i7;
        }

        public boolean add(Object obj) {
            q();
            p();
            o(this.f20157b + this.f20158c, obj);
            return true;
        }

        public boolean addAll(Collection collection) {
            t.e(collection, "elements");
            q();
            p();
            int size = collection.size();
            n(this.f20157b + this.f20158c, collection, size);
            return size > 0;
        }

        public int c() {
            p();
            return this.f20158c;
        }

        public void clear() {
            q();
            p();
            v(this.f20157b, this.f20158c);
        }

        public boolean equals(Object obj) {
            p();
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof List) || !r((List) obj)) {
                return false;
            }
            return true;
        }

        public Object f(int i5) {
            q();
            p();
            C2236c.Companion.b(i5, this.f20158c);
            return u(this.f20157b + i5);
        }

        public Object get(int i5) {
            p();
            C2236c.Companion.b(i5, this.f20158c);
            return this.f20156a[this.f20157b + i5];
        }

        public int hashCode() {
            p();
            return c.i(this.f20156a, this.f20157b, this.f20158c);
        }

        public int indexOf(Object obj) {
            p();
            for (int i5 = 0; i5 < this.f20158c; i5++) {
                if (t.a(this.f20156a[this.f20157b + i5], obj)) {
                    return i5;
                }
            }
            return -1;
        }

        public boolean isEmpty() {
            p();
            if (this.f20158c == 0) {
                return true;
            }
            return false;
        }

        public Iterator iterator() {
            return listIterator(0);
        }

        public int lastIndexOf(Object obj) {
            p();
            for (int i5 = this.f20158c - 1; i5 >= 0; i5--) {
                if (t.a(this.f20156a[this.f20157b + i5], obj)) {
                    return i5;
                }
            }
            return -1;
        }

        public ListIterator listIterator() {
            return listIterator(0);
        }

        public boolean remove(Object obj) {
            q();
            p();
            int indexOf = indexOf(obj);
            if (indexOf >= 0) {
                remove(indexOf);
            }
            if (indexOf >= 0) {
                return true;
            }
            return false;
        }

        public boolean removeAll(Collection collection) {
            t.e(collection, "elements");
            q();
            p();
            if (w(this.f20157b, this.f20158c, collection, false) > 0) {
                return true;
            }
            return false;
        }

        public boolean retainAll(Collection collection) {
            t.e(collection, "elements");
            q();
            p();
            if (w(this.f20157b, this.f20158c, collection, true) > 0) {
                return true;
            }
            return false;
        }

        public Object set(int i5, Object obj) {
            q();
            p();
            C2236c.Companion.b(i5, this.f20158c);
            Object[] objArr = this.f20156a;
            int i6 = this.f20157b;
            Object obj2 = objArr[i6 + i5];
            objArr[i6 + i5] = obj;
            return obj2;
        }

        public List subList(int i5, int i6) {
            C2236c.Companion.d(i5, i6, this.f20158c);
            return new a(this.f20156a, this.f20157b + i5, i6 - i5, this, this.f20160e);
        }

        public Object[] toArray(Object[] objArr) {
            t.e(objArr, "array");
            p();
            int length = objArr.length;
            int i5 = this.f20158c;
            if (length < i5) {
                Object[] objArr2 = this.f20156a;
                int i6 = this.f20157b;
                Object[] copyOfRange = Arrays.copyOfRange(objArr2, i6, i5 + i6, objArr.getClass());
                t.d(copyOfRange, "copyOfRange(...)");
                return copyOfRange;
            }
            Object[] objArr3 = this.f20156a;
            int i7 = this.f20157b;
            C2242i.l(objArr3, objArr, 0, i7, i5 + i7);
            return C2250q.e(this.f20158c, objArr);
        }

        public String toString() {
            p();
            return c.j(this.f20156a, this.f20157b, this.f20158c, this);
        }

        public ListIterator listIterator(int i5) {
            p();
            C2236c.Companion.c(i5, this.f20158c);
            return new C0195a(this, i5);
        }

        public void add(int i5, Object obj) {
            q();
            p();
            C2236c.Companion.c(i5, this.f20158c);
            o(this.f20157b + i5, obj);
        }

        public boolean addAll(int i5, Collection collection) {
            t.e(collection, "elements");
            q();
            p();
            C2236c.Companion.c(i5, this.f20158c);
            int size = collection.size();
            n(this.f20157b + i5, collection, size);
            return size > 0;
        }

        public Object[] toArray() {
            p();
            Object[] objArr = this.f20156a;
            int i5 = this.f20157b;
            return C2242i.s(objArr, i5, this.f20158c + i5);
        }
    }

    /* renamed from: Y2.b$b  reason: collision with other inner class name */
    private static final class C0196b {
        public /* synthetic */ C0196b(C2633k kVar) {
            this();
        }

        private C0196b() {
        }
    }

    private static final class c implements ListIterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private final b f20165a;

        /* renamed from: b  reason: collision with root package name */
        private int f20166b;

        /* renamed from: c  reason: collision with root package name */
        private int f20167c = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f20168d;

        public c(b bVar, int i5) {
            t.e(bVar, "list");
            this.f20165a = bVar;
            this.f20166b = i5;
            this.f20168d = bVar.modCount;
        }

        private final void a() {
            if (this.f20165a.modCount != this.f20168d) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(Object obj) {
            a();
            b bVar = this.f20165a;
            int i5 = this.f20166b;
            this.f20166b = i5 + 1;
            bVar.add(i5, obj);
            this.f20167c = -1;
            this.f20168d = this.f20165a.modCount;
        }

        public boolean hasNext() {
            if (this.f20166b < this.f20165a.f20154b) {
                return true;
            }
            return false;
        }

        public boolean hasPrevious() {
            if (this.f20166b > 0) {
                return true;
            }
            return false;
        }

        public Object next() {
            a();
            if (this.f20166b < this.f20165a.f20154b) {
                int i5 = this.f20166b;
                this.f20166b = i5 + 1;
                this.f20167c = i5;
                return this.f20165a.f20153a[this.f20167c];
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.f20166b;
        }

        public Object previous() {
            a();
            int i5 = this.f20166b;
            if (i5 > 0) {
                int i6 = i5 - 1;
                this.f20166b = i6;
                this.f20167c = i6;
                return this.f20165a.f20153a[this.f20167c];
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.f20166b - 1;
        }

        public void remove() {
            a();
            int i5 = this.f20167c;
            if (i5 != -1) {
                this.f20165a.remove(i5);
                this.f20166b = this.f20167c;
                this.f20167c = -1;
                this.f20168d = this.f20165a.modCount;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }

        public void set(Object obj) {
            a();
            int i5 = this.f20167c;
            if (i5 != -1) {
                this.f20165a.set(i5, obj);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    static {
        b bVar = new b(0);
        bVar.f20155c = true;
        f20152e = bVar;
    }

    public b(int i5) {
        this.f20153a = c.d(i5);
    }

    /* access modifiers changed from: private */
    public final Object C(int i5) {
        z();
        Object[] objArr = this.f20153a;
        Object obj = objArr[i5];
        C2242i.l(objArr, objArr, i5, i5 + 1, this.f20154b);
        c.f(this.f20153a, this.f20154b - 1);
        this.f20154b--;
        return obj;
    }

    /* access modifiers changed from: private */
    public final void D(int i5, int i6) {
        if (i6 > 0) {
            z();
        }
        Object[] objArr = this.f20153a;
        C2242i.l(objArr, objArr, i5, i5 + i6, this.f20154b);
        Object[] objArr2 = this.f20153a;
        int i7 = this.f20154b;
        c.g(objArr2, i7 - i6, i7);
        this.f20154b -= i6;
    }

    /* access modifiers changed from: private */
    public final int E(int i5, int i6, Collection collection, boolean z4) {
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = i5 + i7;
            if (collection.contains(this.f20153a[i9]) == z4) {
                Object[] objArr = this.f20153a;
                i7++;
                objArr[i8 + i5] = objArr[i9];
                i8++;
            } else {
                i7++;
            }
        }
        int i10 = i6 - i8;
        Object[] objArr2 = this.f20153a;
        C2242i.l(objArr2, objArr2, i5 + i8, i6 + i5, this.f20154b);
        Object[] objArr3 = this.f20153a;
        int i11 = this.f20154b;
        c.g(objArr3, i11 - i10, i11);
        if (i10 > 0) {
            z();
        }
        this.f20154b -= i10;
        return i10;
    }

    /* access modifiers changed from: private */
    public final void r(int i5, Collection collection, int i6) {
        z();
        y(i5, i6);
        Iterator it = collection.iterator();
        for (int i7 = 0; i7 < i6; i7++) {
            this.f20153a[i5 + i7] = it.next();
        }
    }

    /* access modifiers changed from: private */
    public final void s(int i5, Object obj) {
        z();
        y(i5, 1);
        this.f20153a[i5] = obj;
    }

    private final void u() {
        if (this.f20155c) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean v(List list) {
        return c.h(this.f20153a, 0, this.f20154b, list);
    }

    private final void w(int i5) {
        if (i5 >= 0) {
            Object[] objArr = this.f20153a;
            if (i5 > objArr.length) {
                this.f20153a = c.e(this.f20153a, C2236c.Companion.e(objArr.length, i5));
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void x(int i5) {
        w(this.f20154b + i5);
    }

    private final void y(int i5, int i6) {
        x(i6);
        Object[] objArr = this.f20153a;
        C2242i.l(objArr, objArr, i5 + i6, i5, this.f20154b);
        this.f20154b += i6;
    }

    private final void z() {
        this.modCount++;
    }

    public boolean add(Object obj) {
        u();
        s(this.f20154b, obj);
        return true;
    }

    public boolean addAll(Collection collection) {
        t.e(collection, "elements");
        u();
        int size = collection.size();
        r(this.f20154b, collection, size);
        return size > 0;
    }

    public int c() {
        return this.f20154b;
    }

    public void clear() {
        u();
        D(0, this.f20154b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List) || !v((List) obj)) {
            return false;
        }
        return true;
    }

    public Object f(int i5) {
        u();
        C2236c.Companion.b(i5, this.f20154b);
        return C(i5);
    }

    public Object get(int i5) {
        C2236c.Companion.b(i5, this.f20154b);
        return this.f20153a[i5];
    }

    public int hashCode() {
        return c.i(this.f20153a, 0, this.f20154b);
    }

    public int indexOf(Object obj) {
        for (int i5 = 0; i5 < this.f20154b; i5++) {
            if (t.a(this.f20153a[i5], obj)) {
                return i5;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.f20154b == 0) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(Object obj) {
        for (int i5 = this.f20154b - 1; i5 >= 0; i5--) {
            if (t.a(this.f20153a[i5], obj)) {
                return i5;
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    public boolean remove(Object obj) {
        u();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        t.e(collection, "elements");
        u();
        if (E(0, this.f20154b, collection, false) > 0) {
            return true;
        }
        return false;
    }

    public boolean retainAll(Collection collection) {
        t.e(collection, "elements");
        u();
        if (E(0, this.f20154b, collection, true) > 0) {
            return true;
        }
        return false;
    }

    public Object set(int i5, Object obj) {
        u();
        C2236c.Companion.b(i5, this.f20154b);
        Object[] objArr = this.f20153a;
        Object obj2 = objArr[i5];
        objArr[i5] = obj;
        return obj2;
    }

    public List subList(int i5, int i6) {
        C2236c.Companion.d(i5, i6, this.f20154b);
        return new a(this.f20153a, i5, i6 - i5, (a) null, this);
    }

    public final List t() {
        u();
        this.f20155c = true;
        if (this.f20154b > 0) {
            return this;
        }
        return f20152e;
    }

    public Object[] toArray(Object[] objArr) {
        t.e(objArr, "array");
        int length = objArr.length;
        int i5 = this.f20154b;
        if (length < i5) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f20153a, 0, i5, objArr.getClass());
            t.d(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        C2242i.l(this.f20153a, objArr, 0, 0, i5);
        return C2250q.e(this.f20154b, objArr);
    }

    public String toString() {
        return c.j(this.f20153a, 0, this.f20154b, this);
    }

    public ListIterator listIterator(int i5) {
        C2236c.Companion.c(i5, this.f20154b);
        return new c(this, i5);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 10 : i5);
    }

    public void add(int i5, Object obj) {
        u();
        C2236c.Companion.c(i5, this.f20154b);
        s(i5, obj);
    }

    public boolean addAll(int i5, Collection collection) {
        t.e(collection, "elements");
        u();
        C2236c.Companion.c(i5, this.f20154b);
        int size = collection.size();
        r(i5, collection, size);
        return size > 0;
    }

    public Object[] toArray() {
        return C2242i.s(this.f20153a, 0, this.f20154b);
    }
}
