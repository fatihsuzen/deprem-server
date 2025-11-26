package X2;

import java.util.Iterator;
import k3.C2616a;
import kotlin.jvm.internal.t;
import l3.C2677a;

public final class H implements Iterable, C2677a {

    /* renamed from: a  reason: collision with root package name */
    private final C2616a f20052a;

    public H(C2616a aVar) {
        t.e(aVar, "iteratorFactory");
        this.f20052a = aVar;
    }

    public Iterator iterator() {
        return new I((Iterator) this.f20052a.invoke());
    }
}
