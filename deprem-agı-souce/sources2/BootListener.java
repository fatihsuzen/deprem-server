package com.finazzi.distquake;

import Z0.C0693a;
import Z0.C0696d;
import Z0.C0700h;
import Z0.C0714w;
import Z0.F;
import Z0.O;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;

public class BootListener extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            C0696d a8 = new C0696d.a().b(C0714w.CONNECTED).a();
            TimeUnit timeUnit = TimeUnit.MINUTES;
            C0693a aVar = C0693a.EXPONENTIAL;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            O h8 = O.h(context);
            C0700h hVar = C0700h.KEEP;
            h8.e("worker_location", hVar, (F) ((F.a) ((F.a) ((F.a) new F.a(WorkerLocation.class, 30, timeUnit).j(a8)).m(10, timeUnit)).i(aVar, 60000, timeUnit2)).b());
            TimeUnit timeUnit3 = TimeUnit.HOURS;
            O.h(context).e("worker_FCM", hVar, (F) ((F.a) ((F.a) ((F.a) new F.a(WorkerFCMRegistration.class, 8, timeUnit3).j(a8)).m(8, timeUnit3)).i(aVar, 60000, timeUnit2)).b());
            O.h(context).e("worker_topic", hVar, (F) ((F.a) ((F.a) ((F.a) new F.a(WorkerTopic.class, 180, timeUnit).j(a8)).m(60, timeUnit)).i(aVar, 60000, timeUnit2)).b());
            O.h(context).e("worker_permission", hVar, (F) ((F.a) ((F.a) new F.a(WorkerPermission.class, 3, timeUnit3).m(20, timeUnit)).i(aVar, 600000, timeUnit2)).b());
            O.h(context).e("worker_sensors", hVar, (F) ((F.a) ((F.a) new F.a(WorkerSensors.class, 15, timeUnit).m(15, timeUnit)).i(aVar, 60000, timeUnit2)).b());
        }
    }
}
