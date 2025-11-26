package j$.util;

import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.stream.Stream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* renamed from: j$.util.h  reason: case insensitive filesystem */
public class C0472h implements Collection, Serializable, Collection {
    private static final long serialVersionUID = 3053995032091335093L;

    /* renamed from: a  reason: collision with root package name */
    public final Collection f1385a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f1386b;

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public C0472h(java.util.Collection collection) {
        this.f1385a = (java.util.Collection) Objects.requireNonNull(collection);
        this.f1386b = this;
    }

    public C0472h(java.util.Collection collection, Object obj) {
        this.f1385a = (java.util.Collection) Objects.requireNonNull(collection);
        this.f1386b = Objects.requireNonNull(obj);
    }

    public final int size() {
        int size;
        synchronized (this.f1386b) {
            size = this.f1385a.size();
        }
        return size;
    }

    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f1386b) {
            isEmpty = this.f1385a.isEmpty();
        }
        return isEmpty;
    }

    public final boolean contains(Object obj) {
        boolean contains;
        synchronized (this.f1386b) {
            contains = this.f1385a.contains(obj);
        }
        return contains;
    }

    public final Object[] toArray() {
        Object[] array;
        synchronized (this.f1386b) {
            array = this.f1385a.toArray();
        }
        return array;
    }

    public final Object[] toArray(Object[] objArr) {
        Object[] array;
        synchronized (this.f1386b) {
            array = this.f1385a.toArray(objArr);
        }
        return array;
    }

    public final Iterator iterator() {
        return this.f1385a.iterator();
    }

    public final boolean add(Object obj) {
        boolean add;
        synchronized (this.f1386b) {
            add = this.f1385a.add(obj);
        }
        return add;
    }

    public final boolean remove(Object obj) {
        boolean remove;
        synchronized (this.f1386b) {
            remove = this.f1385a.remove(obj);
        }
        return remove;
    }

    public final boolean containsAll(java.util.Collection collection) {
        boolean containsAll;
        synchronized (this.f1386b) {
            containsAll = this.f1385a.containsAll(collection);
        }
        return containsAll;
    }

    public final boolean addAll(java.util.Collection collection) {
        boolean addAll;
        synchronized (this.f1386b) {
            addAll = this.f1385a.addAll(collection);
        }
        return addAll;
    }

    public final boolean removeAll(java.util.Collection collection) {
        boolean removeAll;
        synchronized (this.f1386b) {
            removeAll = this.f1385a.removeAll(collection);
        }
        return removeAll;
    }

    public final boolean retainAll(java.util.Collection collection) {
        boolean retainAll;
        synchronized (this.f1386b) {
            retainAll = this.f1385a.retainAll(collection);
        }
        return retainAll;
    }

    public final void clear() {
        synchronized (this.f1386b) {
            this.f1385a.clear();
        }
    }

    public final String toString() {
        String obj;
        synchronized (this.f1386b) {
            obj = this.f1385a.toString();
        }
        return obj;
    }

    public final void forEach(Consumer consumer) {
        synchronized (this.f1386b) {
            Collection.EL.a(this.f1385a, consumer);
        }
    }

    public final boolean removeIf(Predicate predicate) {
        boolean removeIf;
        synchronized (this.f1386b) {
            java.util.Collection collection = this.f1385a;
            removeIf = collection instanceof Collection ? ((Collection) collection).removeIf(predicate) : Collection.CC.$default$removeIf(collection, predicate);
        }
        return removeIf;
    }

    public final Spliterator spliterator() {
        return Collection.EL.c(this.f1385a);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m211spliterator() {
        return Spliterator.Wrapper.convert(Collection.EL.c(this.f1385a));
    }

    public final Stream stream() {
        return Collection.EL.stream(this.f1385a);
    }

    /* renamed from: stream  reason: collision with other method in class */
    public final java.util.stream.Stream m212stream() {
        return Stream.Wrapper.convert(Collection.EL.stream(this.f1385a));
    }

    public final Stream parallelStream() {
        return Collection.EL.b(this.f1385a);
    }

    /* renamed from: parallelStream  reason: collision with other method in class */
    public final java.util.stream.Stream m210parallelStream() {
        return Stream.Wrapper.convert(Collection.EL.b(this.f1385a));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.f1386b) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
