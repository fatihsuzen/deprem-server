package b;

import b3.C2308e;
import com.inmobi.cmp.ChoiceCmp;
import kotlin.coroutines.jvm.internal.d;

public final class i extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f817a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f818b;

    /* renamed from: c  reason: collision with root package name */
    public int f819c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(ChoiceCmp choiceCmp, C2308e eVar) {
        super(eVar);
        this.f818b = choiceCmp;
    }

    public final Object invokeSuspend(Object obj) {
        this.f817a = obj;
        this.f819c |= Integer.MIN_VALUE;
        return this.f818b.h(this);
    }
}
