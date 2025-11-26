package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class z extends d {

    /* renamed from: a  reason: collision with root package name */
    public B f25647a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f25648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ B f25649c;

    /* renamed from: d  reason: collision with root package name */
    public int f25650d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(B b5, C2308e eVar) {
        super(eVar);
        this.f25649c = b5;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25648b = obj;
        this.f25650d |= Integer.MIN_VALUE;
        return this.f25649c.c(0, this);
    }
}
