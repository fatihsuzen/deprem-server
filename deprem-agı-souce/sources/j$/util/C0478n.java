package j$.util;

import j$.util.Collection;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* renamed from: j$.util.n  reason: case insensitive filesystem */
public class C0478n implements Collection, Serializable, Collection {
    private static final long serialVersionUID = 1820017752578914078L;

    /* renamed from: a  reason: collision with root package name */
    public final Collection f1415a;

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public C0478n(java.util.Collection collection) {
        collection.getClass();
        this.f1415a = collection;
    }

    public final int size() {
        return this.f1415a.size();
    }

    public final boolean isEmpty() {
        return this.f1415a.isEmpty();
    }

    public boolean contains(Object obj) {
        return this.f1415a.contains(obj);
    }

    public Object[] toArray() {
        return this.f1415a.toArray();
    }

    public Object[] toArray(Object[] objArr) {
        return this.f1415a.toArray(objArr);
    }

    public final String toString() {
        return this.f1415a.toString();
    }

    public Iterator iterator() {
        return new C0477m(this);
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(java.util.Collection collection) {
        return this.f1415a.containsAll(collection);
    }

    public final boolean addAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public void forEach(Consumer consumer) {
        Collection.EL.a(this.f1415a, consumer);
    }

    public final boolean removeIf(Predicate predicate) {
        throw new UnsupportedOperationException();
    }

    public Spliterator spliterator() {
        return Collection.EL.c(this.f1415a);
    }

    public Stream stream() {
        return Collection.EL.stream(this.f1415a);
    }

    public Stream parallelStream() {
        return Collection.EL.b(this.f1415a);
    }
}
