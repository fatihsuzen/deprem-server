package X2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2677a;

/* renamed from: X2.c  reason: case insensitive filesystem */
public abstract class C2236c extends C2235b implements List, C2677a {
    public static final a Companion = new a((C2633k) null);
    private static final int maxArraySize = 2147483639;

    /* renamed from: X2.c$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(int i5, int i6, int i7) {
            if (i5 < 0 || i6 > i7) {
                throw new IndexOutOfBoundsException("startIndex: " + i5 + ", endIndex: " + i6 + ", size: " + i7);
            } else if (i5 > i6) {
                throw new IllegalArgumentException("startIndex: " + i5 + " > endIndex: " + i6);
            }
        }

        public final void b(int i5, int i6) {
            if (i5 < 0 || i5 >= i6) {
                throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
            }
        }

        public final void c(int i5, int i6) {
            if (i5 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
            }
        }

        public final void d(int i5, int i6, int i7) {
            if (i5 < 0 || i6 > i7) {
                throw new IndexOutOfBoundsException("fromIndex: " + i5 + ", toIndex: " + i6 + ", size: " + i7);
            } else if (i5 > i6) {
                throw new IllegalArgumentException("fromIndex: " + i5 + " > toIndex: " + i6);
            }
        }

        public final int e(int i5, int i6) {
            int i7 = i5 + (i5 >> 1);
            if (i7 - i6 < 0) {
                i7 = i6;
            }
            if (i7 - C2236c.maxArraySize <= 0) {
                return i7;
            }
            if (i6 > C2236c.maxArraySize) {
                return Integer.MAX_VALUE;
            }
            return C2236c.maxArraySize;
        }

        public final boolean f(Collection collection, Collection collection2) {
            t.e(collection, "c");
            t.e(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            for (Object a5 : collection) {
                if (!t.a(a5, it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection collection) {
            int i5;
            t.e(collection, "c");
            int i6 = 1;
            for (Object next : collection) {
                int i7 = i6 * 31;
                if (next != null) {
                    i5 = next.hashCode();
                } else {
                    i5 = 0;
                }
                i6 = i7 + i5;
            }
            return i6;
        }

        private a() {
        }
    }

    /* renamed from: X2.c$b */
    private class b implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private int f20056a;

        public b() {
        }

        /* access modifiers changed from: protected */
        public final int a() {
            return this.f20056a;
        }

        /* access modifiers changed from: protected */
        public final void b(int i5) {
            this.f20056a = i5;
        }

        public boolean hasNext() {
            if (this.f20056a < C2236c.this.size()) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (hasNext()) {
                C2236c cVar = C2236c.this;
                int i5 = this.f20056a;
                this.f20056a = i5 + 1;
                return cVar.get(i5);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: X2.c$c  reason: collision with other inner class name */
    private class C0193c extends b implements ListIterator, C2677a {
        public C0193c(int i5) {
            super();
            C2236c.Companion.c(i5, C2236c.this.size());
            b(i5);
        }

        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            if (a() > 0) {
                return true;
            }
            return false;
        }

        public int nextIndex() {
            return a();
        }

        public Object previous() {
            if (hasPrevious()) {
                C2236c cVar = C2236c.this;
                b(a() - 1);
                return cVar.get(a());
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return a() - 1;
        }

        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: X2.c$d */
    private static final class d extends C2236c implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        private final C2236c f20059a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20060b;

        /* renamed from: c  reason: collision with root package name */
        private int f20061c;

        public d(C2236c cVar, int i5, int i6) {
            t.e(cVar, "list");
            this.f20059a = cVar;
            this.f20060b = i5;
            C2236c.Companion.d(i5, i6, cVar.size());
            this.f20061c = i6 - i5;
        }

        public Object get(int i5) {
            C2236c.Companion.b(i5, this.f20061c);
            return this.f20059a.get(this.f20060b + i5);
        }

        public int getSize() {
            return this.f20061c;
        }
    }

    protected C2236c() {
    }

    public void add(int i5, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i5, Collection<Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return Companion.f(this, (Collection) obj);
    }

    public abstract Object get(int i5);

    public int hashCode() {
        return Companion.g(this);
    }

    public int indexOf(Object obj) {
        int i5 = 0;
        for (Object a5 : this) {
            if (t.a(a5, obj)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public Iterator<Object> iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (t.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<Object> listIterator() {
        return new C0193c(0);
    }

    public Object remove(int i5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object set(int i5, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<Object> subList(int i5, int i6) {
        return new d(this, i5, i6);
    }

    public ListIterator<Object> listIterator(int i5) {
        return new C0193c(i5);
    }
}
