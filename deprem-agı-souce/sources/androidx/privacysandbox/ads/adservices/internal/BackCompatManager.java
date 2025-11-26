package androidx.privacysandbox.ads.adservices.internal;

import android.content.Context;
import android.util.Log;
import k3.l;
import kotlin.jvm.internal.t;

public final class BackCompatManager {
    public static final BackCompatManager INSTANCE = new BackCompatManager();

    private BackCompatManager() {
    }

    public final <T> T getManager(Context context, String str, l lVar) {
        t.e(context, "context");
        t.e(str, "tag");
        t.e(lVar, "manager");
        try {
            return lVar.invoke(context);
        } catch (NoClassDefFoundError unused) {
            Log.d(str, "Unable to find adservices code, check manifest for uses-library tag, versionS=" + AdServicesInfo.INSTANCE.extServicesVersionS());
            return null;
        }
    }
}
