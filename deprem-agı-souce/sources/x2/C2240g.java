package X2;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.t;
import l3.C2677a;

/* renamed from: X2.g  reason: case insensitive filesystem */
final class C2240g implements Collection, C2677a {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f20062a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20063b;

    public C2240g(Object[] objArr, boolean z4) {
        t.e(objArr, "values");
        this.f20062a = objArr;
        this.f20063b = z4;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int c() {
        return this.f20062a.length;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return C2247n.L(this.f20062a, obj);
    }

    public boolean containsAll(Collection collection) {
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

    public boolean isEmpty() {
        if (this.f20062a.length == 0) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return C2625c.a(this.f20062a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return c();
    }

    public Object[] toArray(Object[] objArr) {
        t.e(objArr, "array");
        return C2632j.b(this, objArr);
    }

    public final Object[] toArray() {
        return r.b(this.f20062a, this.f20063b);
    }
}
