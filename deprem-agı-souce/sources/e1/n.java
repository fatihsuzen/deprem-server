package e1;

import T2.a;
import androidx.datastore.core.DataStore;
import b1.a0;
import b3.C2312i;
import d1.C1625b;

public final class n implements C1625b {

    /* renamed from: a  reason: collision with root package name */
    private final a f15297a;

    /* renamed from: b  reason: collision with root package name */
    private final a f15298b;

    /* renamed from: c  reason: collision with root package name */
    private final a f15299c;

    public n(a aVar, a aVar2, a aVar3) {
        this.f15297a = aVar;
        this.f15298b = aVar2;
        this.f15299c = aVar3;
    }

    public static n a(a aVar, a aVar2, a aVar3) {
        return new n(aVar, aVar2, aVar3);
    }

    public static m c(C2312i iVar, a0 a0Var, DataStore dataStore) {
        return new m(iVar, a0Var, dataStore);
    }

    /* renamed from: b */
    public m get() {
        return c((C2312i) this.f15297a.get(), (a0) this.f15298b.get(), (DataStore) this.f15299c.get());
    }
}
