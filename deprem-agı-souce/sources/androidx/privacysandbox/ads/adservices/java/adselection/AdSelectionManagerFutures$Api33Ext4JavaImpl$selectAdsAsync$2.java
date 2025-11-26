package androidx.privacysandbox.ads.adservices.java.adselection;

import W2.J;
import W2.u;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2", f = "AdSelectionManagerFutures.kt", l = {317}, m = "invokeSuspend")
final class AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2 extends l implements p {
    final /* synthetic */ AdSelectionFromOutcomesConfig $adSelectionFromOutcomesConfig;
    int label;
    final /* synthetic */ AdSelectionManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2(AdSelectionManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, C2308e eVar) {
        super(2, eVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$adSelectionFromOutcomesConfig = adSelectionFromOutcomesConfig;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2(this.this$0, this.$adSelectionFromOutcomesConfig, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            AdSelectionManager access$getMAdSelectionManager$p = this.this$0.mAdSelectionManager;
            t.b(access$getMAdSelectionManager$p);
            AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig = this.$adSelectionFromOutcomesConfig;
            this.label = 1;
            Object selectAds = access$getMAdSelectionManager$p.selectAds(adSelectionFromOutcomesConfig, (C2308e) this);
            if (selectAds == f5) {
                return f5;
            }
            return selectAds;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
