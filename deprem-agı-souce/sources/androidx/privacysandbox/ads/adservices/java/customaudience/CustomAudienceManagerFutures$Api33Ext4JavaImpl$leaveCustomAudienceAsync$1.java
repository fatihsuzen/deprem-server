package androidx.privacysandbox.ads.adservices.java.customaudience;

import W2.J;
import W2.u;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1", f = "CustomAudienceManagerFutures.kt", l = {166}, m = "invokeSuspend")
final class CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1 extends l implements p {
    final /* synthetic */ LeaveCustomAudienceRequest $request;
    int label;
    final /* synthetic */ CustomAudienceManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(CustomAudienceManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, LeaveCustomAudienceRequest leaveCustomAudienceRequest, C2308e eVar) {
        super(2, eVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$request = leaveCustomAudienceRequest;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(this.this$0, this.$request, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            CustomAudienceManager access$getMCustomAudienceManager$p = this.this$0.mCustomAudienceManager;
            t.b(access$getMCustomAudienceManager$p);
            LeaveCustomAudienceRequest leaveCustomAudienceRequest = this.$request;
            this.label = 1;
            if (access$getMCustomAudienceManager$p.leaveCustomAudience(leaveCustomAudienceRequest, this) == f5) {
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
        return ((CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
