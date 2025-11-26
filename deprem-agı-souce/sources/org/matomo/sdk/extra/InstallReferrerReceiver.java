package org.matomo.sdk.extra;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import g4.b;
import i4.e;
import java.util.Collections;
import java.util.List;
import p4.a;

public class InstallReferrerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f25659a = b.i(InstallReferrerReceiver.class);

    /* renamed from: b  reason: collision with root package name */
    static final List f25660b = Collections.singletonList("com.android.vending.INSTALL_REFERRER");

    public static /* synthetic */ void a(Context context, String str, BroadcastReceiver.PendingResult pendingResult) {
        b.f(context.getApplicationContext()).g().edit().putString("referrer.extras", str).apply();
        a.b(f25659a).a("Stored Google Play referrer extras: %s", str);
        pendingResult.finish();
    }

    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        String str = f25659a;
        a.b(str).a(intent.toString(), new Object[0]);
        if (intent.getAction() == null || !f25660b.contains(intent.getAction())) {
            a.b(str).h("Got called outside our responsibilities: %s", intent.getAction());
        } else if (intent.getBooleanExtra("forwarded", false)) {
            a.b(str).a("Dropping forwarded intent", new Object[0]);
        } else {
            if (intent.getAction().equals("com.android.vending.INSTALL_REFERRER") && (stringExtra = intent.getStringExtra("referrer")) != null) {
                new Thread(new e(context, stringExtra, goAsync())).start();
            }
            intent.setComponent((ComponentName) null);
            intent.setPackage(context.getPackageName());
            intent.putExtra("forwarded", true);
            context.sendBroadcast(intent);
        }
    }
}
