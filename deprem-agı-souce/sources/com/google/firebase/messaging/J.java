package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

public class J {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f7305a;

    public J(Bundle bundle) {
        if (bundle != null) {
            this.f7305a = new Bundle(bundle);
            return;
        }
        throw new NullPointerException(DataSchemeDataSource.SCHEME_DATA);
    }

    private static int d(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != -16777216) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean s(String str) {
        if (str.startsWith("google.c.a.") || str.equals(TypedValues.TransitionType.S_FROM)) {
            return true;
        }
        return false;
    }

    public static boolean t(Bundle bundle) {
        if ("1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(v("gcm.n.e")))) {
            return true;
        }
        return false;
    }

    private static boolean u(String str) {
        if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
            return true;
        }
        return false;
    }

    private static String v(String str) {
        if (!str.startsWith("gcm.n.")) {
            return str;
        }
        return str.replace("gcm.n.", "gcm.notification.");
    }

    private String w(String str) {
        if (!this.f7305a.containsKey(str) && str.startsWith("gcm.n.")) {
            String v5 = v(str);
            if (this.f7305a.containsKey(v5)) {
                return v5;
            }
        }
        return str;
    }

    private static String z(String str) {
        if (str.startsWith("gcm.n.")) {
            return str.substring(6);
        }
        return str;
    }

    public boolean a(String str) {
        String p5 = p(str);
        if ("1".equals(p5) || Boolean.parseBoolean(p5)) {
            return true;
        }
        return false;
    }

    public Integer b(String str) {
        String p5 = p(str);
        if (TextUtils.isEmpty(p5)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(p5));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + z(str) + "(" + p5 + ") into an int");
            return null;
        }
    }

    public JSONArray c(String str) {
        String p5 = p(str);
        if (TextUtils.isEmpty(p5)) {
            return null;
        }
        try {
            return new JSONArray(p5);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + z(str) + ": " + p5 + ", falling back to default");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int[] e() {
        JSONArray c5 = c("gcm.n.light_settings");
        if (c5 == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (c5.length() == 3) {
                iArr[0] = d(c5.optString(0));
                iArr[1] = c5.optInt(1);
                iArr[2] = c5.optInt(2);
                return iArr;
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (JSONException unused) {
            Log.w("NotificationParams", "LightSettings is invalid: " + c5 + ". Skipping setting LightSettings");
            return null;
        } catch (IllegalArgumentException e5) {
            Log.w("NotificationParams", "LightSettings is invalid: " + c5 + ". " + e5.getMessage() + ". Skipping setting LightSettings");
            return null;
        }
    }

    public Uri f() {
        String p5 = p("gcm.n.link_android");
        if (TextUtils.isEmpty(p5)) {
            p5 = p("gcm.n.link");
        }
        if (!TextUtils.isEmpty(p5)) {
            return Uri.parse(p5);
        }
        return null;
    }

    public Object[] g(String str) {
        JSONArray c5 = c(str + "_loc_args");
        if (c5 == null) {
            return null;
        }
        int length = c5.length();
        String[] strArr = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            strArr[i5] = c5.optString(i5);
        }
        return strArr;
    }

    public String h(String str) {
        return p(str + "_loc_key");
    }

    public String i(Resources resources, String str, String str2) {
        String h5 = h(str2);
        if (TextUtils.isEmpty(h5)) {
            return null;
        }
        int identifier = resources.getIdentifier(h5, TypedValues.Custom.S_STRING, str);
        if (identifier == 0) {
            Log.w("NotificationParams", z(str2 + "_loc_key") + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] g5 = g(str2);
        if (g5 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, g5);
        } catch (MissingFormatArgumentException e5) {
            Log.w("NotificationParams", "Missing format argument for " + z(str2) + ": " + Arrays.toString(g5) + " Default value will be used.", e5);
            return null;
        }
    }

    public Long j(String str) {
        String p5 = p(str);
        if (TextUtils.isEmpty(p5)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(p5));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + z(str) + "(" + p5 + ") into a long");
            return null;
        }
    }

    public String k() {
        return p("gcm.n.android_channel_id");
    }

    /* access modifiers changed from: package-private */
    public Integer l() {
        Integer b5 = b("gcm.n.notification_count");
        if (b5 == null) {
            return null;
        }
        if (b5.intValue() >= 0) {
            return b5;
        }
        Log.w("FirebaseMessaging", "notificationCount is invalid: " + b5 + ". Skipping setting notificationCount.");
        return null;
    }

    /* access modifiers changed from: package-private */
    public Integer m() {
        Integer b5 = b("gcm.n.notification_priority");
        if (b5 == null) {
            return null;
        }
        if (b5.intValue() >= -2 && b5.intValue() <= 2) {
            return b5;
        }
        Log.w("FirebaseMessaging", "notificationPriority is invalid " + b5 + ". Skipping setting notificationPriority.");
        return null;
    }

    public String n(Resources resources, String str, String str2) {
        String p5 = p(str2);
        if (!TextUtils.isEmpty(p5)) {
            return p5;
        }
        return i(resources, str, str2);
    }

    public String o() {
        String p5 = p("gcm.n.sound2");
        if (TextUtils.isEmpty(p5)) {
            return p("gcm.n.sound");
        }
        return p5;
    }

    public String p(String str) {
        return this.f7305a.getString(w(str));
    }

    public long[] q() {
        JSONArray c5 = c("gcm.n.vibrate_timings");
        if (c5 == null) {
            return null;
        }
        try {
            if (c5.length() > 1) {
                int length = c5.length();
                long[] jArr = new long[length];
                for (int i5 = 0; i5 < length; i5++) {
                    jArr[i5] = c5.optLong(i5);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + c5 + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Integer r() {
        Integer b5 = b("gcm.n.visibility");
        if (b5 == null) {
            return null;
        }
        if (b5.intValue() >= -1 && b5.intValue() <= 1) {
            return b5;
        }
        Log.w("NotificationParams", "visibility is invalid: " + b5 + ". Skipping setting visibility.");
        return null;
    }

    public Bundle x() {
        Bundle bundle = new Bundle(this.f7305a);
        for (String next : this.f7305a.keySet()) {
            if (!s(next)) {
                bundle.remove(next);
            }
        }
        return bundle;
    }

    public Bundle y() {
        Bundle bundle = new Bundle(this.f7305a);
        for (String next : this.f7305a.keySet()) {
            if (u(next)) {
                bundle.remove(next);
            }
        }
        return bundle;
    }
}
