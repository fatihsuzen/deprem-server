package n4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class b extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f25519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f25520b;

    /* renamed from: c  reason: collision with root package name */
    public int f25521c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(h hVar, C2308e eVar) {
        super(eVar);
        this.f25520b = hVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25519a = obj;
        this.f25521c |= Integer.MIN_VALUE;
        return this.f25520b.a((String) null, this);
    }
}
