package b;

import b3.C2308e;
import com.inmobi.cmp.ChoiceCmp;

public final class d extends kotlin.coroutines.jvm.internal.d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f802a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f803b;

    /* renamed from: c  reason: collision with root package name */
    public int f804c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ChoiceCmp choiceCmp, C2308e eVar) {
        super(eVar);
        this.f803b = choiceCmp;
    }

    public final Object invokeSuspend(Object obj) {
        this.f802a = obj;
        this.f804c |= Integer.MIN_VALUE;
        return this.f803b.c(this);
    }
}
