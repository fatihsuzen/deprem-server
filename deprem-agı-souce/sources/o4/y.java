package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class y extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f25644a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ B f25645b;

    /* renamed from: c  reason: collision with root package name */
    public int f25646c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(B b5, C2308e eVar) {
        super(eVar);
        this.f25645b = b5;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25644a = obj;
        this.f25646c |= Integer.MIN_VALUE;
        return this.f25645b.b(0, this);
    }
}
