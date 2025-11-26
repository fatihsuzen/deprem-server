package b;

import b3.C2308e;
import com.inmobi.cmp.ChoiceCmp;
import kotlin.coroutines.jvm.internal.d;

public final class e extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f805a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f806b;

    /* renamed from: c  reason: collision with root package name */
    public int f807c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ChoiceCmp choiceCmp, C2308e eVar) {
        super(eVar);
        this.f806b = choiceCmp;
    }

    public final Object invokeSuspend(Object obj) {
        this.f805a = obj;
        this.f807c |= Integer.MIN_VALUE;
        return this.f806b.d(this);
    }
}
