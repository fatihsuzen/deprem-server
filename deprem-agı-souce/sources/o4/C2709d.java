package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

/* renamed from: o4.d  reason: case insensitive filesystem */
public final class C2709d extends d {

    /* renamed from: a  reason: collision with root package name */
    public C2711f f25573a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f25574b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2711f f25575c;

    /* renamed from: d  reason: collision with root package name */
    public int f25576d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2709d(C2711f fVar, C2308e eVar) {
        super(eVar);
        this.f25575c = fVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25574b = obj;
        this.f25576d |= Integer.MIN_VALUE;
        return this.f25575c.a(this);
    }
}
