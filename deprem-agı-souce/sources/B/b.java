package b;

import b3.C2308e;
import com.inmobi.cmp.ChoiceCmp;
import kotlin.coroutines.jvm.internal.d;

public final class b extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f796a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f797b;

    /* renamed from: c  reason: collision with root package name */
    public int f798c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ChoiceCmp choiceCmp, C2308e eVar) {
        super(eVar);
        this.f797b = choiceCmp;
    }

    public final Object invokeSuspend(Object obj) {
        this.f796a = obj;
        this.f798c |= Integer.MIN_VALUE;
        return ChoiceCmp.access$loadCmpInfo(this.f797b, this);
    }
}
