package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon;
import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion", f = "AdSelectionManagerImplCommon.kt", l = {231}, m = "selectAds")
final class AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdSelectionManagerImplCommon.Ext10Impl.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1(AdSelectionManagerImplCommon.Ext10Impl.Companion companion, C2308e eVar) {
        super(eVar);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectAds((AdSelectionManager) null, (AdSelectionFromOutcomesConfig) null, this);
    }
}
