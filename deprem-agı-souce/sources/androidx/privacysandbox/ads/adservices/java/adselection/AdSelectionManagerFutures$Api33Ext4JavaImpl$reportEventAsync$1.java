package androidx.privacysandbox.ads.adservices.java.adselection;

import W2.J;
import W2.u;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.ReportEventRequest;
import androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1", f = "AdSelectionManagerFutures.kt", l = {350}, m = "invokeSuspend")
final class AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1 extends l implements p {
    final /* synthetic */ ReportEventRequest $reportEventRequest;
    int label;
    final /* synthetic */ AdSelectionManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1(AdSelectionManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, ReportEventRequest reportEventRequest, C2308e eVar) {
        super(2, eVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$reportEventRequest = reportEventRequest;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1(this.this$0, this.$reportEventRequest, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            AdSelectionManager access$getMAdSelectionManager$p = this.this$0.mAdSelectionManager;
            t.b(access$getMAdSelectionManager$p);
            ReportEventRequest reportEventRequest = this.$reportEventRequest;
            this.label = 1;
            if (access$getMAdSelectionManager$p.reportEvent(reportEventRequest, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
