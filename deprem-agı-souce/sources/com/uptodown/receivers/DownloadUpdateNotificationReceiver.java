package com.uptodown.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import l2.C2668q;
import l2.T;
import z2.M;

public final class DownloadUpdateNotificationReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        int intExtra;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1881097171) {
                if (hashCode != 75902422) {
                    if (hashCode == 1980572282 && str.equals("CANCEL") && (intExtra = intent.getIntExtra("notificationID", -1)) == 262 && context != null) {
                        UptodownApp.a aVar = UptodownApp.f13477F;
                        aVar.g();
                        Iterator it = aVar.D().iterator();
                        t.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            T t5 = (T) next;
                            UptodownApp.f13477F.d0(t5.h());
                            C2668q b5 = t5.b(context);
                            if (b5 != null) {
                                b5.g();
                            }
                        }
                        M.f26506a.d(context, intExtra);
                    }
                } else if (str.equals("PAUSE")) {
                    DownloadWorker.f21359d.n();
                }
            } else if (str.equals("RESUME")) {
                DownloadWorker.f21359d.o();
            }
        }
    }
}
