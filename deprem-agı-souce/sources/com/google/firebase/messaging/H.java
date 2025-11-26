package com.google.firebase.messaging;

import X0.a;
import X0.b;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.installations.c;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.concurrent.ExecutionException;
import k0.C1701o;
import o0.f;
import p.C1745c;
import p.C1746d;
import p.g;
import p.j;
import p0.C1748a;

public abstract class H {
    static void A(String str, Bundle bundle) {
        try {
            f.l();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String d5 = d(bundle);
            if (d5 != null) {
                bundle2.putString("_nmid", d5);
            }
            String e5 = e(bundle);
            if (e5 != null) {
                bundle2.putString("_nmn", e5);
            }
            String i5 = i(bundle);
            if (!TextUtils.isEmpty(i5)) {
                bundle2.putString("label", i5);
            }
            String g5 = g(bundle);
            if (!TextUtils.isEmpty(g5)) {
                bundle2.putString("message_channel", g5);
            }
            String r5 = r(bundle);
            if (r5 != null) {
                bundle2.putString("_nt", r5);
            }
            String l5 = l(bundle);
            if (l5 != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(l5));
                } catch (NumberFormatException e6) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e6);
                }
            }
            String t5 = t(bundle);
            if (t5 != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(t5));
                } catch (NumberFormatException e7) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e7);
                }
            }
            String n5 = n(bundle);
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", n5);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Logging to scion event=" + str + " scionPayload=" + bundle2);
            }
            C1748a aVar = (C1748a) f.l().j(C1748a.class);
            if (aVar != null) {
                aVar.b("fcm", str, bundle2);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    private static void B(Bundle bundle) {
        if (bundle != null) {
            if ("1".equals(bundle.getString("google.c.a.tc"))) {
                C1748a aVar = (C1748a) f.l().j(C1748a.class);
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (aVar != null) {
                    String string = bundle.getString("google.c.a.c_id");
                    aVar.c("fcm", "_ln", string);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("source", "Firebase");
                    bundle2.putString("medium", "notification");
                    bundle2.putString("campaign", string);
                    aVar.b("fcm", "_cmp", bundle2);
                    return;
                }
                Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
            }
        }
    }

    public static boolean C(Intent intent) {
        if (intent == null || u(intent)) {
            return false;
        }
        return a();
    }

    public static boolean D(Intent intent) {
        if (intent == null || u(intent)) {
            return false;
        }
        return E(intent.getExtras());
    }

    public static boolean E(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    static boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            f.l();
            Context k5 = f.l().k();
            SharedPreferences sharedPreferences = k5.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = k5.getPackageManager();
                if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(k5.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("delivery_metrics_exported_to_big_query_enabled"))) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    static a b(a.b bVar, Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        a.C0063a j5 = a.p().n(s(extras)).e(bVar).f(f(extras)).i(o()).l(a.d.ANDROID).h(m(extras)).j(k(extras));
        String h5 = h(extras);
        if (h5 != null) {
            j5.g(h5);
        }
        String r5 = r(extras);
        if (r5 != null) {
            j5.m(r5);
        }
        String c5 = c(extras);
        if (c5 != null) {
            j5.c(c5);
        }
        String i5 = i(extras);
        if (i5 != null) {
            j5.b(i5);
        }
        String e5 = e(extras);
        if (e5 != null) {
            j5.d(e5);
        }
        long q5 = q(extras);
        if (q5 > 0) {
            j5.k(q5);
        }
        return j5.a();
    }

    static String c(Bundle bundle) {
        return bundle.getString("collapse_key");
    }

    static String d(Bundle bundle) {
        return bundle.getString("google.c.a.c_id");
    }

    static String e(Bundle bundle) {
        return bundle.getString("google.c.a.c_l");
    }

    static String f(Bundle bundle) {
        String string = bundle.getString("google.to");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return (String) C1701o.a(c.q(f.l()).getId());
        } catch (InterruptedException | ExecutionException e5) {
            throw new RuntimeException(e5);
        }
    }

    static String g(Bundle bundle) {
        return bundle.getString("google.c.a.m_c");
    }

    static String h(Bundle bundle) {
        String string = bundle.getString("google.message_id");
        if (string == null) {
            return bundle.getString("message_id");
        }
        return string;
    }

    static String i(Bundle bundle) {
        return bundle.getString("google.c.a.m_l");
    }

    private static int j(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        if ("normal".equals(str)) {
            return 2;
        }
        return 0;
    }

    static int k(Bundle bundle) {
        int p5 = p(bundle);
        if (p5 == 2) {
            return 5;
        }
        if (p5 == 1) {
            return 10;
        }
        return 0;
    }

    static String l(Bundle bundle) {
        return bundle.getString("google.c.a.ts");
    }

    static a.c m(Bundle bundle) {
        if (bundle == null || !J.t(bundle)) {
            return a.c.DATA_MESSAGE;
        }
        return a.c.DISPLAY_NOTIFICATION;
    }

    static String n(Bundle bundle) {
        if (bundle == null || !J.t(bundle)) {
            return DataSchemeDataSource.SCHEME_DATA;
        }
        return "display";
    }

    static String o() {
        return f.l().k().getPackageName();
    }

    static int p(Bundle bundle) {
        String string = bundle.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(bundle.getString("google.priority_reduced"))) {
                return 2;
            }
            string = bundle.getString("google.priority");
        }
        return j(string);
    }

    static long q(Bundle bundle) {
        if (bundle.containsKey("google.c.sender.id")) {
            try {
                return Long.parseLong(bundle.getString("google.c.sender.id"));
            } catch (NumberFormatException e5) {
                Log.w("FirebaseMessaging", "error parsing project number", e5);
            }
        }
        f l5 = f.l();
        String d5 = l5.n().d();
        if (d5 != null) {
            try {
                return Long.parseLong(d5);
            } catch (NumberFormatException e6) {
                Log.w("FirebaseMessaging", "error parsing sender ID", e6);
            }
        }
        String c5 = l5.n().c();
        if (!c5.startsWith("1:")) {
            try {
                return Long.parseLong(c5);
            } catch (NumberFormatException e7) {
                Log.w("FirebaseMessaging", "error parsing app ID", e7);
                return 0;
            }
        } else {
            String[] split = c5.split(":");
            if (split.length < 2) {
                return 0;
            }
            String str = split[1];
            if (str.isEmpty()) {
                return 0;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e8) {
                Log.w("FirebaseMessaging", "error parsing app ID", e8);
                return 0;
            }
        }
    }

    static String r(Bundle bundle) {
        String string = bundle.getString(TypedValues.TransitionType.S_FROM);
        if (string == null || !string.startsWith("/topics/")) {
            return null;
        }
        return string;
    }

    static int s(Bundle bundle) {
        Object obj = bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    static String t(Bundle bundle) {
        if (bundle.containsKey("google.c.a.udt")) {
            return bundle.getString("google.c.a.udt");
        }
        return null;
    }

    private static boolean u(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }

    public static void v(Intent intent) {
        A("_nd", intent.getExtras());
    }

    public static void w(Intent intent) {
        A("_nf", intent.getExtras());
    }

    public static void x(Bundle bundle) {
        B(bundle);
        A("_no", bundle);
    }

    public static void y(Intent intent) {
        if (D(intent)) {
            A("_nr", intent.getExtras());
        }
        if (C(intent)) {
            z(a.b.MESSAGE_DELIVERED, intent, FirebaseMessaging.s());
        }
    }

    private static void z(a.b bVar, Intent intent, j jVar) {
        if (jVar == null) {
            Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
            return;
        }
        a b5 = b(bVar, intent);
        if (b5 != null) {
            try {
                jVar.a("FCM_CLIENT_EVENT_LOGGING", b.class, C1745c.b("proto"), new G()).b(C1746d.g(b.b().b(b5).a(), g.b(Integer.valueOf(intent.getIntExtra("google.product_id", 111881503)))));
            } catch (RuntimeException e5) {
                Log.w("FirebaseMessaging", "Failed to send big query analytics payload.", e5);
            }
        }
    }
}
