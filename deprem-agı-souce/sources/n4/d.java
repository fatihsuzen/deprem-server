package n4;

import b3.C2308e;

public final class d extends kotlin.coroutines.jvm.internal.d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f25523a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f25524b;

    /* renamed from: c  reason: collision with root package name */
    public int f25525c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(h hVar, C2308e eVar) {
        super(eVar);
        this.f25524b = hVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25523a = obj;
        this.f25525c |= Integer.MIN_VALUE;
        return this.f25524b.c((String) null, this);
    }
}
