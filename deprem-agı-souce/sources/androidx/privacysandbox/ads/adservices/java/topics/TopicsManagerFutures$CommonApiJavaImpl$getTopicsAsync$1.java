package androidx.privacysandbox.ads.adservices.java.topics;

import W2.J;
import W2.u;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1", f = "TopicsManagerFutures.kt", l = {55}, m = "invokeSuspend")
final class TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1 extends l implements p {
    final /* synthetic */ GetTopicsRequest $request;
    int label;
    final /* synthetic */ TopicsManagerFutures.CommonApiJavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(TopicsManagerFutures.CommonApiJavaImpl commonApiJavaImpl, GetTopicsRequest getTopicsRequest, C2308e eVar) {
        super(2, eVar);
        this.this$0 = commonApiJavaImpl;
        this.$request = getTopicsRequest;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this.this$0, this.$request, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            TopicsManager access$getMTopicsManager$p = this.this$0.mTopicsManager;
            GetTopicsRequest getTopicsRequest = this.$request;
            this.label = 1;
            Object topics = access$getMTopicsManager$p.getTopics(getTopicsRequest, this);
            if (topics == f5) {
                return f5;
            }
            return topics;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
