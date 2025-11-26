package com.uptodown.activities.preferences;

import U1.C2201a;
import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2641A;
import l2.U;
import t3.s;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0147a f15150a = new C0147a((C2633k) null);

    /* renamed from: com.uptodown.activities.preferences.a$a  reason: collision with other inner class name */
    public static final class C0147a {
        public /* synthetic */ C0147a(C2633k kVar) {
            this();
        }

        public static /* synthetic */ long A(C0147a aVar, Context context, String str, long j5, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                j5 = -1;
            }
            return aVar.z(context, str, j5);
        }

        public static /* synthetic */ boolean e(C0147a aVar, Context context, String str, boolean z4, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                z4 = true;
            }
            return aVar.d(context, str, z4);
        }

        private final boolean f0(Context context, String str) {
            try {
                return context.getSharedPreferences("SettingsPreferences", 0).contains(str);
            } catch (Exception unused) {
                return false;
            }
        }

        public static /* synthetic */ int m(C0147a aVar, Context context, String str, int i5, int i6, Object obj) {
            if ((i6 & 4) != 0) {
                i5 = -1;
            }
            return aVar.l(context, str, i5);
        }

        public final void A0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "is_device_tracking_registered", z4);
        }

        public final String B(Context context) {
            t.e(context, "context");
            String H4 = H(context, "notifications_frecuency", "1");
            if (!s.E(H4, "0", false)) {
                return H4;
            }
            n1(context, "notifications_frecuency", "1");
            return "1";
        }

        public final void B0(Context context, int i5) {
            t.e(context, "context");
            M0(context, "downloadID_to_rollback", i5);
        }

        public final C2641A C(Context context) {
            t.e(context, "context");
            C2641A a5 = new C2641A();
            Context context2 = context;
            Context context3 = context2;
            a5.j(A(this, context2, "fcm_app_id", 0, 4, (Object) null));
            a5.m(G(context3, "fcm_packagename"));
            a5.k(m(this, context3, "fcm_download_id", 0, 4, (Object) null));
            a5.o(A(this, context3, "fcm_received_timestamp", 0, 4, (Object) null));
            a5.q(A(this, context3, "fcm_shown_timestamp", 0, 4, (Object) null));
            if (a5.b() <= -1 || a5.d() == null) {
                return null;
            }
            return a5;
        }

        public final void C0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "download_notification", z4);
        }

        public final int D(Context context) {
            t.e(context, "context");
            return m(this, context, "notification_permission_request_api33", 0, 4, (Object) null);
        }

        public final void D0(Context context, String str) {
            t.e(context, "context");
            t.e(str, "optionIndex");
            n1(context, "download_updates_options", str);
        }

        public final long E(Context context) {
            t.e(context, "context");
            return z(context, "last_notification_permission_request_timestamp", 0);
        }

        public final void E0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "app_detail_inflate_view_failed", z4);
        }

        public final long F(Context context) {
            t.e(context, "context");
            return z(context, "last_sign_in_request_timestamp", 0);
        }

        public final void F0(Context context, String str) {
            t.e(context, "context");
            n1(context, "fcmToken", str);
        }

        public final String G(Context context, String str) {
            t.e(context, "context");
            t.e(str, "key");
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains(str)) {
                    return sharedPreferences.getString(str, (String) null);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return null;
        }

        public final void G0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "fcmTokenSent", z4);
        }

        public final String H(Context context, String str, String str2) {
            t.e(context, "context");
            t.e(str, "key");
            t.e(str2, "defaultValue");
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains(str)) {
                    String string = sharedPreferences.getString(str, str2);
                    t.b(string);
                    return string;
                }
            } catch (Exception unused) {
            }
            return str2;
        }

        public final void H0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "gdpr_requested", z4);
        }

        public final U I(Context context) {
            t.e(context, "context");
            return new U(z(context, "bytes_uploaded", 0), z(context, "timestamp_uploaded", 0));
        }

        public final void I0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "is_in_eea", z4);
        }

        public final long J(Context context) {
            t.e(context, "context");
            return z(context, "uptodown_turbo_register_popup_shown", 0);
        }

        public final void J0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "is_in_eea_checked", z4);
        }

        public final String K(Context context) {
            t.e(context, "context");
            return G(context, "url_526");
        }

        public final void K0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "install_apk_rooted", z4);
        }

        public final String L(Context context) {
            t.e(context, "context");
            return G(context, "UTOKEN");
        }

        public final void L0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "installation_notification", z4);
        }

        public final int M(Context context) {
            t.e(context, "context");
            return m(this, context, "versioncode_526", 0, 4, (Object) null);
        }

        public final void M0(Context context, String str, int i5) {
            t.e(context, "context");
            t.e(str, "key");
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                edit.putInt(str, i5);
                edit.apply();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final boolean N(Context context) {
            t.e(context, "context");
            return d(context, "app_detail_inflate_view_failed", false);
        }

        public final void N0(Context context, String str) {
            t.e(context, "context");
            t.e(str, "language");
            n1(context, "Language", str);
            new C2201a(context).E(str);
        }

        public final boolean O(Context context) {
            t.e(context, "context");
            return d(context, "gdpr_analytics_allowed", false);
        }

        public final void O0(Context context, int i5) {
            t.e(context, "context");
            M0(context, "last_changelog_version_shown", i5);
        }

        public final boolean P(Context context) {
            t.e(context, "context");
            if (UptodownApp.f13477F.P()) {
                return false;
            }
            return e(this, context, "animations", false, 4, (Object) null);
        }

        public final void P0(Context context, long j5) {
            t.e(context, "context");
            Z0(context, "last_analysis_timestamp", j5);
        }

        public final boolean Q(Context context) {
            t.e(context, "context");
            return d(context, "gdpr_crashlytics_allowed", false);
        }

        public final void Q0(Context context, String str) {
            t.e(context, "context");
            t.e(str, CampaignEx.JSON_KEY_TIMESTAMP);
            n1(context, "last_notification_timestamp", str);
        }

        public final boolean R(Context context) {
            t.e(context, "context");
            return d(context, "is_device_tracking_registered", false);
        }

        public final void R0(Context context, String str) {
            t.e(context, "context");
            t.e(str, MimeTypes.BASE_TYPE_TEXT);
            n1(context, "last_review_text", str);
        }

        public final boolean S(Context context) {
            t.e(context, "context");
            return d(context, "download_notification", true);
        }

        public final void S0(Context context, String str) {
            t.e(context, "context");
            t.e(str, CampaignEx.JSON_KEY_TIMESTAMP);
            n1(context, "last_review_timestamp", str);
        }

        public final boolean T(Context context) {
            t.e(context, "context");
            return d(context, "fcmTokenSent", false);
        }

        public final void T0(Context context, long j5) {
            t.e(context, "context");
            Z0(context, "last_events_timestamp", j5);
        }

        public final boolean U(Context context) {
            t.e(context, "context");
            if (UptodownApp.f13477F.P()) {
                return false;
            }
            return d(context, "floating_download_queue_active", true);
        }

        public final void U0(Context context, long j5) {
            t.e(context, "context");
            Z0(context, "getLastTimeGetTrackedAppsInfoCalled", j5);
        }

        public final boolean V(Context context) {
            t.e(context, "context");
            return d(context, "gdpr_requested", false);
        }

        public final void V0(Context context, long j5) {
            t.e(context, "context");
            Z0(context, "mintegral_interstitial_last_shown", j5);
        }

        public final boolean W(Context context) {
            t.e(context, "context");
            return d(context, "is_in_eea", true);
        }

        public final void W0(Context context, long j5) {
            t.e(context, "context");
            Z0(context, "getLastTimePendingDialogShown", j5);
        }

        public final boolean X(Context context) {
            t.e(context, "context");
            return d(context, "is_in_eea_checked", false);
        }

        public final void X0(Context context, long j5) {
            t.e(context, "context");
            Z0(context, "lastTimeUsageGetted", j5);
        }

        public final boolean Y(Context context) {
            t.e(context, "context");
            return d(context, "install_apk_rooted", false);
        }

        public final void Y0(Context context, long j5) {
            t.e(context, "context");
            Z0(context, "last_tracking_timestamp", j5);
        }

        public final boolean Z(Context context) {
            t.e(context, "context");
            return d(context, "installation_notification", true);
        }

        public final void Z0(Context context, String str, long j5) {
            t.e(context, "context");
            t.e(str, "key");
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                edit.putLong(str, j5);
                edit.apply();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final void a(Context context) {
            t.e(context, "context");
            SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            edit.remove("fcm_app_id");
            edit.remove("fcm_packagename");
            edit.remove("fcm_download_id");
            edit.remove("fcm_received_timestamp");
            edit.remove("fcm_shown_timestamp");
            edit.apply();
        }

        public final boolean a0(Context context) {
            t.e(context, "context");
            return e(this, context, "recibir_notificaciones", false, 4, (Object) null);
        }

        public final void a1(Context context, String str) {
            t.e(context, "context");
            t.e(str, "option");
            n1(context, "notifications_frecuency", str);
        }

        public final String b(Context context) {
            t.e(context, "context");
            return G(context, "app_id_after_kill");
        }

        public final boolean b0(Context context) {
            t.e(context, "context");
            return e(this, context, "only_wifi", false, 4, (Object) null);
        }

        public final void b1(Context context, int i5) {
            t.e(context, "context");
            M0(context, "notification_permission_request_api33", i5);
        }

        public final int c(Context context) {
            t.e(context, "context");
            return Integer.parseInt(H(context, "autoplay_video", "0"));
        }

        public final boolean c0(Context context) {
            t.e(context, "context");
            return d(context, "install_apk_as_root_system", false);
        }

        public final void c1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "recibir_notificaciones", z4);
        }

        public final boolean d(Context context, String str, boolean z4) {
            t.e(context, "context");
            t.e(str, "key");
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains(str)) {
                    return sharedPreferences.getBoolean(str, z4);
                }
            } catch (Exception unused) {
            }
            return z4;
        }

        public final boolean d0(Context context) {
            t.e(context, "context");
            return d(context, "storage_sdcard", false);
        }

        public final void d1(Context context, long j5) {
            t.e(context, "context");
            Z0(context, "last_notification_permission_request_timestamp", j5);
        }

        public final boolean e0(Context context) {
            t.e(context, "context");
            return f0(context, "storage_sdcard");
        }

        public final void e1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "only_wifi", z4);
        }

        public final String f(Context context) {
            t.e(context, "context");
            return H(context, "dark_mode", "system");
        }

        public final void f1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "install_apk_as_root_system", z4);
        }

        public final int g(Context context) {
            t.e(context, "context");
            return Integer.parseInt(H(context, "data_saver_options", "1"));
        }

        public final boolean g0(Context context) {
            t.e(context, "context");
            return d(context, "settings_utd_sended", false);
        }

        public final void g1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "storage_sdcard", z4);
        }

        public final String h(Context context) {
            t.e(context, "context");
            return G(context, "device_status");
        }

        public final boolean h0(Context context) {
            t.e(context, "context");
            return d(context, "show_system_apps", false);
        }

        public final void h1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "settings_utd_sended", z4);
        }

        public final int i(Context context) {
            t.e(context, "context");
            return m(this, context, "downloadID_to_rollback", 0, 4, (Object) null);
        }

        public final boolean i0(Context context) {
            t.e(context, "context");
            return d(context, "show_system_services", false);
        }

        public final void i1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "show_system_apps", z4);
        }

        public final String j(Context context) {
            t.e(context, "context");
            return H(context, "download_updates_options", "2");
        }

        public final boolean j0(Context context) {
            t.e(context, "context");
            return d(context, "is_status_code_526", false);
        }

        public final void j1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "show_system_services", z4);
        }

        public final String k(Context context) {
            t.e(context, "context");
            return G(context, "fcmToken");
        }

        public final boolean k0(Context context) {
            t.e(context, "context");
            return d(context, "gdpr_tracking_allowed", false);
        }

        public final void k1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "show_warning_download_incompatible", z4);
        }

        public final int l(Context context, String str, int i5) {
            t.e(context, "context");
            t.e(str, "key");
            return context.getSharedPreferences("SettingsPreferences", 0).getInt(str, i5);
        }

        public final boolean l0(Context context) {
            t.e(context, "context");
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SharedPreferencesTracking", 0);
                if (sharedPreferences.contains("maintenance_time")) {
                    if (System.currentTimeMillis() < sharedPreferences.getLong("maintenance_time", 0)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }

        public final void l1(Context context, long j5) {
            t.e(context, "context");
            Z0(context, "last_sign_in_request_timestamp", j5);
        }

        public final boolean m0(Context context) {
            t.e(context, "context");
            return d(context, "welcome_popup_shown", false);
        }

        public final void m1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "is_status_code_526", z4);
        }

        public final String n(Context context) {
            t.e(context, "context");
            return G(context, "Language");
        }

        public final boolean n0(Context context) {
            t.e(context, "context");
            return d(context, "wizard_completed", false);
        }

        public final void n1(Context context, String str, String str2) {
            t.e(context, "context");
            t.e(str, "key");
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                edit.putString(str, str2);
                edit.apply();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final int o(Context context) {
            t.e(context, "context");
            return l(context, "last_changelog_version_shown", 0);
        }

        public final boolean o0(int i5, Context context) {
            t.e(context, "context");
            return d(context, "wizard_step_" + i5 + "_shown", false);
        }

        public final void o1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "gdpr_tracking_allowed", z4);
        }

        public final long p(Context context) {
            t.e(context, "context");
            return z(context, "last_analysis_timestamp", 0);
        }

        public final void p0(Context context, C2641A a5) {
            t.e(context, "context");
            t.e(a5, "notificationFCM");
            Z0(context, "fcm_app_id", a5.b());
            n1(context, "fcm_packagename", a5.d());
            M0(context, "fcm_download_id", a5.c());
            Z0(context, "fcm_received_timestamp", a5.e());
            Z0(context, "fcm_shown_timestamp", a5.f());
        }

        public final void p1(Context context, long j5) {
            t.e(context, "context");
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("SharedPreferencesTracking", 0).edit();
                edit.putLong("maintenance_time", System.currentTimeMillis() + (j5 * ((long) 1000)));
                edit.apply();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final String q(Context context) {
            t.e(context, "context");
            return G(context, "last_notification_timestamp");
        }

        public final void q0(Context context, U u5) {
            t.e(context, "context");
            t.e(u5, "uploadInfo");
            Z0(context, "bytes_uploaded", u5.b());
            Z0(context, "timestamp_uploaded", u5.c());
        }

        public final void q1(Context context, long j5) {
            t.e(context, "context");
            Z0(context, "uptodown_turbo_register_popup_shown", j5);
        }

        public final String r(Context context) {
            t.e(context, "context");
            return G(context, "last_review_text");
        }

        public final void r0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "gdpr_analytics_allowed", z4);
        }

        public final void r1(Context context, String str) {
            t.e(context, "context");
            n1(context, "url_526", str);
        }

        public final String s(Context context) {
            t.e(context, "context");
            return G(context, "last_review_timestamp");
        }

        public final void s0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "animations", z4);
        }

        public final void s1(Context context, String str) {
            t.e(context, "context");
            n1(context, "UTOKEN", str);
        }

        public final long t(Context context) {
            t.e(context, "context");
            return z(context, "last_events_timestamp", 0);
        }

        public final void t0(Context context, String str) {
            t.e(context, "context");
            n1(context, "app_id_after_kill", str);
        }

        public final void t1(Context context, int i5) {
            t.e(context, "context");
            M0(context, "versioncode_526", i5);
        }

        public final long u(Context context) {
            t.e(context, "context");
            return z(context, "getLastTimeGetTrackedAppsInfoCalled", 0);
        }

        public final void u0(Context context, String str) {
            t.e(context, "context");
            t.e(str, "option");
            n1(context, "autoplay_video", str);
        }

        public final void u1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "welcome_popup_shown", z4);
        }

        public final long v(Context context) {
            t.e(context, "context");
            return z(context, "mintegral_interstitial_last_shown", 0);
        }

        public final void v0(Context context, String str, boolean z4) {
            t.e(context, "context");
            t.e(str, "key");
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                edit.putBoolean(str, z4);
                edit.apply();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final void v1(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "wizard_completed", z4);
        }

        public final long w(Context context) {
            t.e(context, "context");
            return z(context, "getLastTimePendingDialogShown", 0);
        }

        public final void w0(Context context, boolean z4) {
            t.e(context, "context");
            v0(context, "gdpr_crashlytics_allowed", z4);
        }

        public final void w1(Context context, int i5) {
            t.e(context, "context");
            v0(context, "wizard_step_" + i5 + "_shown", true);
        }

        public final long x(Context context, long j5) {
            t.e(context, "context");
            return z(context, "lastTimeUsageGetted", j5);
        }

        public final void x0(Context context, String str) {
            t.e(context, "context");
            n1(context, "dark_mode", str);
        }

        public final boolean x1(Context context) {
            t.e(context, "context");
            return d(context, "show_warning_download_incompatible", true);
        }

        public final long y(Context context) {
            t.e(context, "context");
            return z(context, "last_tracking_timestamp", 0);
        }

        public final void y0(Context context, String str) {
            t.e(context, "context");
            t.e(str, "option");
            n1(context, "data_saver_options", str);
        }

        public final long z(Context context, String str, long j5) {
            t.e(context, "context");
            t.e(str, "key");
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            try {
                return sharedPreferences.getLong(str, j5);
            } catch (ClassCastException unused) {
                try {
                    long j6 = (long) sharedPreferences.getInt(str, -1);
                    Z0(context, str, j6);
                    return j6;
                } catch (ClassCastException unused2) {
                    return j5;
                }
            }
        }

        public final void z0(Context context, String str) {
            t.e(context, "context");
            n1(context, "device_status", str);
        }

        private C0147a() {
        }
    }
}
