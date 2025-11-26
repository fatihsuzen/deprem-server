package b;

import b3.C2308e;
import com.inmobi.cmp.ChoiceCmp;
import kotlin.coroutines.jvm.internal.d;

public final class h extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f814a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f815b;

    /* renamed from: c  reason: collision with root package name */
    public int f816c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(ChoiceCmp choiceCmp, C2308e eVar) {
        super(eVar);
        this.f815b = choiceCmp;
    }

    public final Object invokeSuspend(Object obj) {
        this.f814a = obj;
        this.f816c |= Integer.MIN_VALUE;
        return this.f815b.g(this);
    }
}
