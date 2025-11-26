package Y2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.t;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private final d f20191a;

    public e(d dVar) {
        t.e(dVar, "backing");
        this.f20191a = dVar;
    }

    public boolean addAll(Collection collection) {
        t.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int c() {
        return this.f20191a.size();
    }

    public void clear() {
        this.f20191a.clear();
    }

    public boolean containsAll(Collection collection) {
        t.e(collection, "elements");
        return this.f20191a.o(collection);
    }

    public boolean g(Map.Entry entry) {
        t.e(entry, "element");
        return this.f20191a.p(entry);
    }

    public boolean i(Map.Entry entry) {
        t.e(entry, "element");
        return this.f20191a.J(entry);
    }

    public boolean isEmpty() {
        return this.f20191a.isEmpty();
    }

    public Iterator iterator() {
        return this.f20191a.t();
    }

    /* renamed from: j */
    public boolean add(Map.Entry entry) {
        t.e(entry, "element");
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        t.e(collection, "elements");
        this.f20191a.m();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        t.e(collection, "elements");
        this.f20191a.m();
        return super.retainAll(collection);
    }
}
