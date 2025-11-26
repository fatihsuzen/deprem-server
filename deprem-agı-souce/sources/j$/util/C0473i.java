package j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* renamed from: j$.util.i  reason: case insensitive filesystem */
public class C0473i extends C0472h implements List, List {
    private static final long serialVersionUID = -7754090372962971524L;

    /* renamed from: c  reason: collision with root package name */
    public final List f1390c;

    public C0473i(List list) {
        super(list);
        this.f1390c = list;
    }

    public C0473i(List list, Object obj) {
        super(list, obj);
        this.f1390c = list;
    }

    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f1386b) {
            equals = this.f1390c.equals(obj);
        }
        return equals;
    }

    public final int hashCode() {
        int hashCode;
        synchronized (this.f1386b) {
            hashCode = this.f1390c.hashCode();
        }
        return hashCode;
    }

    public final Object get(int i5) {
        Object obj;
        synchronized (this.f1386b) {
            obj = this.f1390c.get(i5);
        }
        return obj;
    }

    public final Object set(int i5, Object obj) {
        Object obj2;
        synchronized (this.f1386b) {
            obj2 = this.f1390c.set(i5, obj);
        }
        return obj2;
    }

    public final void add(int i5, Object obj) {
        synchronized (this.f1386b) {
            this.f1390c.add(i5, obj);
        }
    }

    public final Object remove(int i5) {
        Object remove;
        synchronized (this.f1386b) {
            remove = this.f1390c.remove(i5);
        }
        return remove;
    }

    public final int indexOf(Object obj) {
        int indexOf;
        synchronized (this.f1386b) {
            indexOf = this.f1390c.indexOf(obj);
        }
        return indexOf;
    }

    public final int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this.f1386b) {
            lastIndexOf = this.f1390c.lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    public final boolean addAll(int i5, Collection collection) {
        boolean addAll;
        synchronized (this.f1386b) {
            addAll = this.f1390c.addAll(i5, collection);
        }
        return addAll;
    }

    public final ListIterator listIterator() {
        return this.f1390c.listIterator();
    }

    public final ListIterator listIterator(int i5) {
        return this.f1390c.listIterator(i5);
    }

    public List subList(int i5, int i6) {
        C0473i iVar;
        synchronized (this.f1386b) {
            iVar = new C0473i(this.f1390c.subList(i5, i6), this.f1386b);
        }
        return iVar;
    }

    public final void replaceAll(UnaryOperator unaryOperator) {
        synchronized (this.f1386b) {
            List list = this.f1390c;
            if (list instanceof List) {
                ((List) list).replaceAll(unaryOperator);
            } else {
                Objects.requireNonNull(unaryOperator);
                ListIterator listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    listIterator.set(unaryOperator.apply(listIterator.next()));
                }
            }
        }
    }

    public final void sort(Comparator comparator) {
        synchronized (this.f1386b) {
            C0469e.u(this.f1390c, comparator);
        }
    }

    private Object readResolve() {
        List list = this.f1390c;
        return list instanceof RandomAccess ? new C0473i(list) : this;
    }
}
