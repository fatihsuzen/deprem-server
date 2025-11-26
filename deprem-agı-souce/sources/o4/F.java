package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class F extends d {

    /* renamed from: a  reason: collision with root package name */
    public C2708c f25558a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f25559b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2708c f25560c;

    /* renamed from: d  reason: collision with root package name */
    public int f25561d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public F(C2708c cVar, C2308e eVar) {
        super(eVar);
        this.f25560c = cVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25559b = obj;
        this.f25561d |= Integer.MIN_VALUE;
        return this.f25560c.a(this);
    }
}
