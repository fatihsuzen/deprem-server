package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import C.C0634a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import r.p;
import r.u;
import y.C1930a;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static /* synthetic */ void a() {
    }

    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i5 = intent.getExtras().getInt("attemptNumber");
        u.f(context);
        p.a d5 = p.a().b(queryParameter).d(C0634a.b(intValue));
        if (queryParameter2 != null) {
            d5.c(Base64.decode(queryParameter2, 0));
        }
        u.c().e().m(d5.a(), i5, new C1930a());
    }
}
