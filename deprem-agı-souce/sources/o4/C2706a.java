package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

/* renamed from: o4.a  reason: case insensitive filesystem */
public final class C2706a extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f25562a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2708c f25563b;

    /* renamed from: c  reason: collision with root package name */
    public int f25564c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2706a(C2708c cVar, C2308e eVar) {
        super(eVar);
        this.f25563b = cVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25562a = obj;
        this.f25564c |= Integer.MIN_VALUE;
        return this.f25563b.b(this);
    }
}
