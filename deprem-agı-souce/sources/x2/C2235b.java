package X2;

import java.util.Collection;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.t;
import l3.C2677a;

/* renamed from: X2.b  reason: case insensitive filesystem */
public abstract class C2235b implements Collection, C2677a {
    protected C2235b() {
    }

    /* access modifiers changed from: private */
    public static final CharSequence f(C2235b bVar, Object obj) {
        if (obj == bVar) {
            return "(this Collection)";
        }
        return String.valueOf(obj);
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        for (Object a5 : this) {
            if (t.a(a5, obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        t.e(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public abstract int getSize();

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public Object[] toArray() {
        return C2632j.a(this);
    }

    public String toString() {
        return B.V(this, ", ", "[", "]", 0, (CharSequence) null, new C2234a(this), 24, (Object) null);
    }

    public <T> T[] toArray(T[] tArr) {
        t.e(tArr, "array");
        return C2632j.b(this, tArr);
    }
}
