package androidx.privacysandbox.ads.adservices.java.appsetid;

import W2.J;
import W2.u;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1", f = "AppSetIdManagerFutures.kt", l = {49}, m = "invokeSuspend")
final class AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1 extends l implements p {
    int label;
    final /* synthetic */ AppSetIdManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(AppSetIdManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, C2308e eVar) {
        super(2, eVar);
        this.this$0 = api33Ext4JavaImpl;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            AppSetIdManager access$getMAppSetIdManager$p = this.this$0.mAppSetIdManager;
            this.label = 1;
            Object appSetId = access$getMAppSetIdManager$p.getAppSetId(this);
            if (appSetId == f5) {
                return f5;
            }
            return appSetId;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
