package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class q extends d {

    /* renamed from: a  reason: collision with root package name */
    public r f25614a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f25615b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f25616c;

    /* renamed from: d  reason: collision with root package name */
    public int f25617d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(r rVar, C2308e eVar) {
        super(eVar);
        this.f25616c = rVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25615b = obj;
        this.f25617d |= Integer.MIN_VALUE;
        return this.f25616c.a(this);
    }
}
