package k4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class j extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f24594a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f24595b;

    /* renamed from: c  reason: collision with root package name */
    public int f24596c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(l lVar, C2308e eVar) {
        super(eVar);
        this.f24595b = lVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f24594a = obj;
        this.f24596c |= Integer.MIN_VALUE;
        return this.f24595b.c((g) null, (s) null, (h) null, this);
    }
}
