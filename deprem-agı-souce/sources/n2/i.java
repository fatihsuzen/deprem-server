package n2;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import o2.C2702a;
import org.json.JSONException;
import w3.M;

public final class i extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2702a f25516a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONException f25517b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(C2702a aVar, JSONException jSONException, C2308e eVar) {
        super(2, eVar);
        this.f25516a = aVar;
        this.f25517b = jSONException;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new i(this.f25516a, this.f25517b, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new i(this.f25516a, this.f25517b, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        u.b(obj);
        this.f25516a.a(this.f25517b.getMessage());
        return J.f19942a;
    }
}
