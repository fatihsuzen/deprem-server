package b;

import b3.C2308e;
import com.inmobi.cmp.ChoiceCmp;
import kotlin.coroutines.jvm.internal.d;

public final class g extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f811a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f812b;

    /* renamed from: c  reason: collision with root package name */
    public int f813c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(ChoiceCmp choiceCmp, C2308e eVar) {
        super(eVar);
        this.f812b = choiceCmp;
    }

    public final Object invokeSuspend(Object obj) {
        this.f811a = obj;
        this.f813c |= Integer.MIN_VALUE;
        return this.f812b.f(this);
    }
}
