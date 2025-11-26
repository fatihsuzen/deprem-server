package androidx.privacysandbox.ads.adservices.appsetid;

import android.content.Context;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class AppSetIdManager$Companion$obtain$1 extends u implements l {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppSetIdManager$Companion$obtain$1(Context context) {
        super(1);
        this.$context = context;
    }

    public final AppSetIdManagerApi31Ext9Impl invoke(Context context) {
        t.e(context, "it");
        return new AppSetIdManagerApi31Ext9Impl(this.$context);
    }
}
