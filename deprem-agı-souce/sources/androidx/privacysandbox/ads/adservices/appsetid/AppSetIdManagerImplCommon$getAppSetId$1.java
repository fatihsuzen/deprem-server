package androidx.privacysandbox.ads.adservices.appsetid;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon", f = "AppSetIdManagerImplCommon.kt", l = {38}, m = "getAppSetId$suspendImpl")
final class AppSetIdManagerImplCommon$getAppSetId$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppSetIdManagerImplCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppSetIdManagerImplCommon$getAppSetId$1(AppSetIdManagerImplCommon appSetIdManagerImplCommon, C2308e eVar) {
        super(eVar);
        this.this$0 = appSetIdManagerImplCommon;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AppSetIdManagerImplCommon.getAppSetId$suspendImpl(this.this$0, this);
    }
}
