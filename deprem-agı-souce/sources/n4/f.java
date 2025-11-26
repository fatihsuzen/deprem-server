package n4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class f extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f25527a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f25528b;

    /* renamed from: c  reason: collision with root package name */
    public int f25529c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(h hVar, C2308e eVar) {
        super(eVar);
        this.f25528b = hVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25527a = obj;
        this.f25529c |= Integer.MIN_VALUE;
        return this.f25528b.b((String) null, (String) null, this);
    }
}
