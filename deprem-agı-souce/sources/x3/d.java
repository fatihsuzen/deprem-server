package X3;

import U3.B;
import java.util.LinkedHashSet;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set f20090a = new LinkedHashSet();

    public synchronized void a(B b5) {
        this.f20090a.remove(b5);
    }

    public synchronized void b(B b5) {
        this.f20090a.add(b5);
    }

    public synchronized boolean c(B b5) {
        return this.f20090a.contains(b5);
    }
}
