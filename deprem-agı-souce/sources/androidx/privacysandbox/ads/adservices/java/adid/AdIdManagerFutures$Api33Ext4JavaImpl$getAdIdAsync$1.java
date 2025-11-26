package androidx.privacysandbox.ads.adservices.java.adid;

import W2.J;
import W2.u;
import androidx.privacysandbox.ads.adservices.adid.AdIdManager;
import androidx.privacysandbox.ads.adservices.java.adid.AdIdManagerFutures;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.java.adid.AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1", f = "AdIdManagerFutures.kt", l = {54}, m = "invokeSuspend")
final class AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1 extends l implements p {
    int label;
    final /* synthetic */ AdIdManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1(AdIdManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, C2308e eVar) {
        super(2, eVar);
        this.this$0 = api33Ext4JavaImpl;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            AdIdManager access$getMAdIdManager$p = this.this$0.mAdIdManager;
            this.label = 1;
            Object adId = access$getMAdIdManager$p.getAdId(this);
            if (adId == f5) {
                return f5;
            }
            return adId;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
