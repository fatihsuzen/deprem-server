package com.google.firebase.messaging;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.trusted.g;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.firebase.messaging.d  reason: case insensitive filesystem */
public abstract class C1555d {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f7396a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* renamed from: com.google.firebase.messaging.d$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final NotificationCompat.Builder f7397a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7398b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7399c;

        a(NotificationCompat.Builder builder, String str, int i5) {
            this.f7397a = builder;
            this.f7398b = str;
            this.f7399c = i5;
        }
    }

    private static PendingIntent a(Context context, J j5, String str, PackageManager packageManager) {
        Intent f5 = f(str, j5, packageManager);
        if (f5 == null) {
            return null;
        }
        f5.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        f5.putExtras(j5.y());
        if (q(j5)) {
            f5.putExtra("gcm.n.analytics_data", j5.x());
        }
        return PendingIntent.getActivity(context, g(), f5, l(1073741824));
    }

    private static PendingIntent b(Context context, Context context2, J j5) {
        if (!q(j5)) {
            return null;
        }
        return c(context, context2, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(j5.x()));
    }

    private static PendingIntent c(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.android.c2dm.intent.RECEIVE").setPackage(context2.getPackageName()).putExtra("wrapped_intent", intent), l(1073741824));
    }

    public static a d(Context context, Context context2, J j5, String str, Bundle bundle) {
        String packageName = context2.getPackageName();
        Resources resources = context2.getResources();
        PackageManager packageManager = context2.getPackageManager();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, str);
        String n5 = j5.n(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(n5)) {
            builder.setContentTitle(n5);
        }
        String n6 = j5.n(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(n6)) {
            builder.setContentText(n6);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(n6));
        }
        builder.setSmallIcon(m(packageManager, resources, packageName, j5.p("gcm.n.icon"), bundle));
        Uri n7 = n(packageName, j5, resources);
        if (n7 != null) {
            builder.setSound(n7);
        }
        builder.setContentIntent(a(context, j5, packageName, packageManager));
        PendingIntent b5 = b(context, context2, j5);
        if (b5 != null) {
            builder.setDeleteIntent(b5);
        }
        Integer h5 = h(context2, j5.p("gcm.n.color"), bundle);
        if (h5 != null) {
            builder.setColor(h5.intValue());
        }
        builder.setAutoCancel(!j5.a("gcm.n.sticky"));
        builder.setLocalOnly(j5.a("gcm.n.local_only"));
        String p5 = j5.p("gcm.n.ticker");
        if (p5 != null) {
            builder.setTicker(p5);
        }
        Integer m5 = j5.m();
        if (m5 != null) {
            builder.setPriority(m5.intValue());
        }
        Integer r5 = j5.r();
        if (r5 != null) {
            builder.setVisibility(r5.intValue());
        }
        Integer l5 = j5.l();
        if (l5 != null) {
            builder.setNumber(l5.intValue());
        }
        Long j6 = j5.j("gcm.n.event_time");
        if (j6 != null) {
            builder.setShowWhen(true);
            builder.setWhen(j6.longValue());
        }
        long[] q5 = j5.q();
        if (q5 != null) {
            builder.setVibrate(q5);
        }
        int[] e5 = j5.e();
        if (e5 != null) {
            builder.setLights(e5[0], e5[1], e5[2]);
        }
        builder.setDefaults(i(j5));
        return new a(builder, o(j5), 0);
    }

    static a e(Context context, J j5) {
        Bundle j6 = j(context.getPackageManager(), context.getPackageName());
        return d(context, context, j5, k(context, j5.k(), j6), j6);
    }

    private static Intent f(String str, J j5, PackageManager packageManager) {
        String p5 = j5.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(p5)) {
            Intent intent = new Intent(p5);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri f5 = j5.f();
        if (f5 != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(f5);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return f7396a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w("FirebaseMessaging", "Color is invalid: " + str + ". Notification will use default color.");
            }
        }
        int i5 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i5 == 0) {
            return null;
        }
        try {
            return Integer.valueOf(ContextCompat.getColor(context, i5));
        } catch (Resources.NotFoundException unused2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    private static int i(J j5) {
        boolean a5 = j5.a("gcm.n.default_sound");
        if (j5.a("gcm.n.default_vibrate_timings")) {
            a5 |= true;
        }
        return j5.a("gcm.n.default_light_settings") ? a5 | true ? 1 : 0 : a5 ? 1 : 0;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                return bundle;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            Log.w("FirebaseMessaging", "Couldn't get own application info: " + e5);
        }
        return Bundle.EMPTY;
    }

    public static String k(Context context, String str, Bundle bundle) {
        String str2;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", "Notification Channel requested (" + str + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else if (notificationManager.getNotificationChannel(string) != null) {
                return string;
            } else {
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", TypedValues.Custom.S_STRING, context.getPackageName());
                if (identifier == 0) {
                    Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    str2 = "Misc";
                } else {
                    str2 = context.getString(identifier);
                }
                notificationManager.createNotificationChannel(g.a("fcm_fallback_notification_channel", str2, 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static int l(int i5) {
        return i5 | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            Log.w("FirebaseMessaging", "Icon resource " + str2 + " not found. Notification will use default icon.");
        }
        int i5 = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i5 == 0 || !p(resources, i5)) {
            try {
                i5 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e5) {
                Log.w("FirebaseMessaging", "Couldn't get own application info: " + e5);
            }
        }
        if (i5 == 0 || !p(resources, i5)) {
            return 17301651;
        }
        return i5;
    }

    private static Uri n(String str, J j5, Resources resources) {
        String o5 = j5.o();
        if (TextUtils.isEmpty(o5)) {
            return null;
        }
        if (MRAIDCommunicatorUtil.STATES_DEFAULT.equals(o5) || resources.getIdentifier(o5, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        return Uri.parse("android.resource://" + str + "/raw/" + o5);
    }

    private static String o(J j5) {
        String p5 = j5.p("gcm.n.tag");
        if (!TextUtils.isEmpty(p5)) {
            return p5;
        }
        return "FCM-Notification:" + SystemClock.uptimeMillis();
    }

    private static boolean p(Resources resources, int i5) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!C1554c.a(resources.getDrawable(i5, (Resources.Theme) null))) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i5);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + i5 + ", treating it as an invalid icon");
            return false;
        }
    }

    static boolean q(J j5) {
        return j5.a("google.c.a.e");
    }
}
