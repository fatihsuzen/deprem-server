package n2;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import o2.C2702a;
import q2.C2717d;

/* renamed from: n2.c  reason: case insensitive filesystem */
public final class C2695c extends d {

    /* renamed from: a  reason: collision with root package name */
    public C2702a f25506a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f25507b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2693a f25508c;

    /* renamed from: d  reason: collision with root package name */
    public int f25509d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2695c(C2693a aVar, C2308e eVar) {
        super(eVar);
        this.f25508c = aVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25507b = obj;
        this.f25509d |= Integer.MIN_VALUE;
        return C2693a.b(this.f25508c, (C2717d) null, (C2702a) null, this);
    }
}
