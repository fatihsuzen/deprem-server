package androidx.privacysandbox.ads.adservices.java.topics;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2865c0;
import w3.N;
import w3.O;

public abstract class TopicsManagerFutures {
    public static final Companion Companion = new Companion((C2633k) null);

    private static final class CommonApiJavaImpl extends TopicsManagerFutures {
        /* access modifiers changed from: private */
        public final TopicsManager mTopicsManager;

        public CommonApiJavaImpl(TopicsManager topicsManager) {
            t.e(topicsManager, "mTopicsManager");
            this.mTopicsManager = topicsManager;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
        @DoNotInline
        public C1722d getTopicsAsync(GetTopicsRequest getTopicsRequest) {
            t.e(getTopicsRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.c()), (C2312i) null, (O) null, new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this, getTopicsRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final TopicsManagerFutures from(Context context) {
            t.e(context, "context");
            TopicsManager obtain = TopicsManager.Companion.obtain(context);
            if (obtain != null) {
                return new CommonApiJavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final TopicsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public abstract C1722d getTopicsAsync(GetTopicsRequest getTopicsRequest);
}
