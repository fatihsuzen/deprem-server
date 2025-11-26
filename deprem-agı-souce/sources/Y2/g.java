package Y2;

import X2.C2237d;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import l3.C2678b;

public final class g extends C2237d implements Collection, C2678b {

    /* renamed from: a  reason: collision with root package name */
    private final d f20193a;

    public g(d dVar) {
        t.e(dVar, "backing");
        this.f20193a = dVar;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        t.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int c() {
        return this.f20193a.size();
    }

    public void clear() {
        this.f20193a.clear();
    }

    public boolean contains(Object obj) {
        return this.f20193a.containsValue(obj);
    }

    public boolean isEmpty() {
        return this.f20193a.isEmpty();
    }

    public Iterator iterator() {
        return this.f20193a.P();
    }

    public boolean remove(Object obj) {
        return this.f20193a.N(obj);
    }

    public boolean removeAll(Collection collection) {
        t.e(collection, "elements");
        this.f20193a.m();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        t.e(collection, "elements");
        this.f20193a.m();
        return super.retainAll(collection);
    }
}
