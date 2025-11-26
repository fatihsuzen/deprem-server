package b;

import b3.C2308e;
import com.inmobi.cmp.ChoiceCmp;
import kotlin.coroutines.jvm.internal.d;

public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f799a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f800b;

    /* renamed from: c  reason: collision with root package name */
    public int f801c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ChoiceCmp choiceCmp, C2308e eVar) {
        super(eVar);
        this.f800b = choiceCmp;
    }

    public final Object invokeSuspend(Object obj) {
        this.f799a = obj;
        this.f801c |= Integer.MIN_VALUE;
        return this.f800b.b(this);
    }
}
