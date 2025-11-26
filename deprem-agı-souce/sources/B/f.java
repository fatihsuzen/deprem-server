package b;

import b3.C2308e;
import com.inmobi.cmp.ChoiceCmp;
import kotlin.coroutines.jvm.internal.d;

public final class f extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f808a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f809b;

    /* renamed from: c  reason: collision with root package name */
    public int f810c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(ChoiceCmp choiceCmp, C2308e eVar) {
        super(eVar);
        this.f809b = choiceCmp;
    }

    public final Object invokeSuspend(Object obj) {
        this.f808a = obj;
        this.f810c |= Integer.MIN_VALUE;
        return this.f809b.e(this);
    }
}
