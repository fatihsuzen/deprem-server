package Y2;

import X2.C2239f;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.t;
import l3.C2678b;

public final class f extends C2239f implements Set, C2678b {

    /* renamed from: a  reason: collision with root package name */
    private final d f20192a;

    public f(d dVar) {
        t.e(dVar, "backing");
        this.f20192a = dVar;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        t.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int c() {
        return this.f20192a.size();
    }

    public void clear() {
        this.f20192a.clear();
    }

    public boolean contains(Object obj) {
        return this.f20192a.containsKey(obj);
    }

    public boolean isEmpty() {
        return this.f20192a.isEmpty();
    }

    public Iterator iterator() {
        return this.f20192a.D();
    }

    public boolean remove(Object obj) {
        return this.f20192a.M(obj);
    }

    public boolean removeAll(Collection collection) {
        t.e(collection, "elements");
        this.f20192a.m();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        t.e(collection, "elements");
        this.f20192a.m();
        return super.retainAll(collection);
    }
}
