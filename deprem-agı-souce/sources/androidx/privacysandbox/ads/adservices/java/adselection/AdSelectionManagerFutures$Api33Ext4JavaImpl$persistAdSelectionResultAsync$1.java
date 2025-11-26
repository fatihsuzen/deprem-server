package androidx.privacysandbox.ads.adservices.java.adselection;

import W2.J;
import W2.u;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1", f = "AdSelectionManagerFutures.kt", l = {373}, m = "invokeSuspend")
final class AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1 extends l implements p {
    final /* synthetic */ PersistAdSelectionResultRequest $persistAdSelectionResultRequest;
    int label;
    final /* synthetic */ AdSelectionManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(AdSelectionManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, PersistAdSelectionResultRequest persistAdSelectionResultRequest, C2308e eVar) {
        super(2, eVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$persistAdSelectionResultRequest = persistAdSelectionResultRequest;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(this.this$0, this.$persistAdSelectionResultRequest, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            AdSelectionManager access$getMAdSelectionManager$p = this.this$0.mAdSelectionManager;
            t.b(access$getMAdSelectionManager$p);
            PersistAdSelectionResultRequest persistAdSelectionResultRequest = this.$persistAdSelectionResultRequest;
            this.label = 1;
            Object persistAdSelectionResult = access$getMAdSelectionManager$p.persistAdSelectionResult(persistAdSelectionResultRequest, this);
            if (persistAdSelectionResult == f5) {
                return f5;
            }
            return persistAdSelectionResult;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
