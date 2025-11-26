package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class s extends d {

    /* renamed from: a  reason: collision with root package name */
    public t f25623a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f25624b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f25625c;

    /* renamed from: d  reason: collision with root package name */
    public int f25626d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(t tVar, C2308e eVar) {
        super(eVar);
        this.f25625c = tVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25624b = obj;
        this.f25626d |= Integer.MIN_VALUE;
        return this.f25625c.a(this);
    }
}
