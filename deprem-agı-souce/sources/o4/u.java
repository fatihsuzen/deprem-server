package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class u extends d {

    /* renamed from: a  reason: collision with root package name */
    public v f25630a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f25631b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v f25632c;

    /* renamed from: d  reason: collision with root package name */
    public int f25633d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(v vVar, C2308e eVar) {
        super(eVar);
        this.f25632c = vVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25631b = obj;
        this.f25633d |= Integer.MIN_VALUE;
        return this.f25632c.a(this);
    }
}
