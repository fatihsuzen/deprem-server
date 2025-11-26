package k4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class i extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f24591a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f24592b;

    /* renamed from: c  reason: collision with root package name */
    public int f24593c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(l lVar, C2308e eVar) {
        super(eVar);
        this.f24592b = lVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f24591a = obj;
        this.f24593c |= Integer.MIN_VALUE;
        return this.f24592b.b((g) null, (m) null, (h) null, this);
    }
}
