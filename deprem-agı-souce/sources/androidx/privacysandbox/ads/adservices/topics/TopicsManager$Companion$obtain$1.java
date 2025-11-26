package androidx.privacysandbox.ads.adservices.topics;

import android.content.Context;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class TopicsManager$Companion$obtain$1 extends u implements l {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopicsManager$Companion$obtain$1(Context context) {
        super(1);
        this.$context = context;
    }

    public final TopicsManagerApi31Ext11Impl invoke(Context context) {
        t.e(context, "it");
        return new TopicsManagerApi31Ext11Impl(this.$context);
    }
}
