package x1;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collection;
import u1.n;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f16972c = new c();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f16973a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f16974b = new ArrayList();

    private c() {
    }

    public static c e() {
        return f16972c;
    }

    public Collection a() {
        return DesugarCollections.unmodifiableCollection(this.f16974b);
    }

    public void b(n nVar) {
        this.f16973a.add(nVar);
    }

    public Collection c() {
        return DesugarCollections.unmodifiableCollection(this.f16973a);
    }

    public void d(n nVar) {
        boolean g5 = g();
        this.f16973a.remove(nVar);
        this.f16974b.remove(nVar);
        if (g5 && !g()) {
            i.d().f();
        }
    }

    public void f(n nVar) {
        boolean g5 = g();
        this.f16974b.add(nVar);
        if (!g5) {
            i.d().e();
        }
    }

    public boolean g() {
        if (this.f16974b.size() > 0) {
            return true;
        }
        return false;
    }
}
