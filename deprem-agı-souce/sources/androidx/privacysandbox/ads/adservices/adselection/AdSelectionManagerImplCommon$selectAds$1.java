package androidx.privacysandbox.ads.adservices.adselection;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon", f = "AdSelectionManagerImplCommon.kt", l = {44}, m = "selectAds$suspendImpl")
final class AdSelectionManagerImplCommon$selectAds$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdSelectionManagerImplCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdSelectionManagerImplCommon$selectAds$1(AdSelectionManagerImplCommon adSelectionManagerImplCommon, C2308e eVar) {
        super(eVar);
        this.this$0 = adSelectionManagerImplCommon;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AdSelectionManagerImplCommon.selectAds$suspendImpl(this.this$0, (AdSelectionConfig) null, (C2308e) this);
    }
}
