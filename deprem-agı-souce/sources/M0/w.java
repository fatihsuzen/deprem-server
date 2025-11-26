package m0;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import l0.h;

public abstract class w {

    class a extends b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Set f15604a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Set f15605b;

        /* renamed from: m0.w$a$a  reason: collision with other inner class name */
        class C0157a extends C1713b {

            /* renamed from: c  reason: collision with root package name */
            final Iterator f15606c;

            /* renamed from: d  reason: collision with root package name */
            final Iterator f15607d;

            C0157a() {
                this.f15606c = a.this.f15604a.iterator();
                this.f15607d = a.this.f15605b.iterator();
            }

            /* access modifiers changed from: protected */
            public Object a() {
                if (this.f15606c.hasNext()) {
                    return this.f15606c.next();
                }
                while (this.f15607d.hasNext()) {
                    Object next = this.f15607d.next();
                    if (!a.this.f15604a.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super((a) null);
            this.f15604a = set;
            this.f15605b = set2;
        }

        /* renamed from: c */
        public z iterator() {
            return new C0157a();
        }

        public boolean contains(Object obj) {
            if (this.f15604a.contains(obj) || this.f15605b.contains(obj)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            if (!this.f15604a.isEmpty() || !this.f15605b.isEmpty()) {
                return false;
            }
            return true;
        }

        public int size() {
            int size = this.f15604a.size();
            for (Object contains : this.f15605b) {
                if (!this.f15604a.contains(contains)) {
                    size++;
                }
            }
            return size;
        }
    }

    public static abstract class b extends AbstractSet {
        /* synthetic */ b(a aVar) {
            this();
        }

        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public abstract z c();

        public final void clear() {
            throw new UnsupportedOperationException();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        private b() {
        }
    }

    static boolean a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static int b(Set set) {
        int i5;
        int i6 = 0;
        for (Object next : set) {
            if (next != null) {
                i5 = next.hashCode();
            } else {
                i5 = 0;
            }
            i6 = ~(~(i6 + i5));
        }
        return i6;
    }

    public static b c(Set set, Set set2) {
        h.i(set, "set1");
        h.i(set2, "set2");
        return new a(set, set2);
    }
}
