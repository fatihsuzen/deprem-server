package k4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class k extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f24597a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f24598b;

    /* renamed from: c  reason: collision with root package name */
    public int f24599c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(l lVar, C2308e eVar) {
        super(eVar);
        this.f24598b = lVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f24597a = obj;
        this.f24599c |= Integer.MIN_VALUE;
        return this.f24598b.d((h) null, (e) null, (String) null, false, this);
    }
}
