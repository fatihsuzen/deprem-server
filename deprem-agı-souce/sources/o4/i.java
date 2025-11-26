package o4;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;

public final class i extends d {

    /* renamed from: a  reason: collision with root package name */
    public k f25586a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f25587b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f25588c;

    /* renamed from: d  reason: collision with root package name */
    public int f25589d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(k kVar, C2308e eVar) {
        super(eVar);
        this.f25588c = kVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f25587b = obj;
        this.f25589d |= Integer.MIN_VALUE;
        return this.f25588c.c(this);
    }
}
