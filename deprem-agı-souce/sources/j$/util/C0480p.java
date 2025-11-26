package j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* renamed from: j$.util.p  reason: case insensitive filesystem */
public class C0480p extends C0478n implements List, List {
    private static final long serialVersionUID = -283967356065247728L;

    /* renamed from: b  reason: collision with root package name */
    public final List f1417b;

    public C0480p(List list) {
        super(list);
        this.f1417b = list;
    }

    public final boolean equals(Object obj) {
        return obj == this || this.f1417b.equals(obj);
    }

    public final int hashCode() {
        return this.f1417b.hashCode();
    }

    public final Object get(int i5) {
        return this.f1417b.get(i5);
    }

    public final Object set(int i5, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void add(int i5, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Object remove(int i5) {
        throw new UnsupportedOperationException();
    }

    public final int indexOf(Object obj) {
        return this.f1417b.indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        return this.f1417b.lastIndexOf(obj);
    }

    public final boolean addAll(int i5, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException();
    }

    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator listIterator() {
        return new C0479o(this, 0);
    }

    public final ListIterator listIterator(int i5) {
        return new C0479o(this, i5);
    }

    public List subList(int i5, int i6) {
        return new C0480p(this.f1417b.subList(i5, i6));
    }

    private Object readResolve() {
        List list = this.f1417b;
        return list instanceof RandomAccess ? new C0480p(list) : this;
    }
}
