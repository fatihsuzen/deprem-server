package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class A extends d {

    /* renamed from: a  reason: collision with root package name */
    public B f25535a;

    /* renamed from: b  reason: collision with root package name */
    public String f25536b;

    /* renamed from: c  reason: collision with root package name */
    public int f25537c;

    /* renamed from: d  reason: collision with root package name */
    public /* synthetic */ Object f25538d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ B f25539e;

    /* renamed from: f  reason: collision with root package name */
    public int f25540f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public A(B b5, C2308e eVar) {
        super(eVar);
        this.f25539e = b5;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25538d = obj;
        this.f25540f |= Integer.MIN_VALUE;
        return this.f25539e.d(0, this);
    }
}
