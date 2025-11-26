package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class g extends d {

    /* renamed from: a  reason: collision with root package name */
    public k f25582a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f25583b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f25584c;

    /* renamed from: d  reason: collision with root package name */
    public int f25585d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(k kVar, C2308e eVar) {
        super(eVar);
        this.f25584c = kVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25583b = obj;
        this.f25585d |= Integer.MIN_VALUE;
        return this.f25584c.a(this);
    }
}
