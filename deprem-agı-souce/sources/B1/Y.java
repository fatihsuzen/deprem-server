package b1;

import T2.a;
import androidx.datastore.core.DataStore;
import b3.C2312i;
import d1.C1625b;
import e1.j;

public final class Y implements C1625b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4629a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4630b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4631c;

    /* renamed from: d  reason: collision with root package name */
    private final a f4632d;

    /* renamed from: e  reason: collision with root package name */
    private final a f4633e;

    /* renamed from: f  reason: collision with root package name */
    private final a f4634f;

    /* renamed from: g  reason: collision with root package name */
    private final a f4635g;

    public Y(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7) {
        this.f4629a = aVar;
        this.f4630b = aVar2;
        this.f4631c = aVar3;
        this.f4632d = aVar4;
        this.f4633e = aVar5;
        this.f4634f = aVar6;
        this.f4635g = aVar7;
    }

    public static Y a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7) {
        return new Y(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static X c(j jVar, Q q5, N n5, a0 a0Var, DataStore dataStore, C1040z zVar, C2312i iVar) {
        return new X(jVar, q5, n5, a0Var, dataStore, zVar, iVar);
    }

    /* renamed from: b */
    public X get() {
        return c((j) this.f4629a.get(), (Q) this.f4630b.get(), (N) this.f4631c.get(), (a0) this.f4632d.get(), (DataStore) this.f4633e.get(), (C1040z) this.f4634f.get(), (C2312i) this.f4635g.get());
    }
}
