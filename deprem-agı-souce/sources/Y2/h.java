package Y2;

import X2.C2239f;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2678b;

public final class h extends C2239f implements Set, Serializable, C2678b {

    /* renamed from: b  reason: collision with root package name */
    private static final a f20194b = new a((C2633k) null);

    /* renamed from: c  reason: collision with root package name */
    private static final h f20195c = new h(d.f20169n.e());

    /* renamed from: a  reason: collision with root package name */
    private final d f20196a;

    private static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public h(d dVar) {
        t.e(dVar, "backing");
        this.f20196a = dVar;
    }

    public boolean add(Object obj) {
        if (this.f20196a.j(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean addAll(Collection collection) {
        t.e(collection, "elements");
        this.f20196a.m();
        return super.addAll(collection);
    }

    public int c() {
        return this.f20196a.size();
    }

    public void clear() {
        this.f20196a.clear();
    }

    public boolean contains(Object obj) {
        return this.f20196a.containsKey(obj);
    }

    public final Set f() {
        this.f20196a.l();
        if (size() > 0) {
            return this;
        }
        return f20195c;
    }

    public boolean isEmpty() {
        return this.f20196a.isEmpty();
    }

    public Iterator iterator() {
        return this.f20196a.D();
    }

    public boolean remove(Object obj) {
        return this.f20196a.M(obj);
    }

    public boolean removeAll(Collection collection) {
        t.e(collection, "elements");
        this.f20196a.m();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        t.e(collection, "elements");
        this.f20196a.m();
        return super.retainAll(collection);
    }

    public h() {
        this(new d());
    }
}
