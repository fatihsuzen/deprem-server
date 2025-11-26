package androidx.privacysandbox.ads.adservices.adid;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon", f = "AdIdManagerImplCommon.kt", l = {40}, m = "getAdId$suspendImpl")
final class AdIdManagerImplCommon$getAdId$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdIdManagerImplCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdIdManagerImplCommon$getAdId$1(AdIdManagerImplCommon adIdManagerImplCommon, C2308e eVar) {
        super(eVar);
        this.this$0 = adIdManagerImplCommon;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AdIdManagerImplCommon.getAdId$suspendImpl(this.this$0, this);
    }
}
