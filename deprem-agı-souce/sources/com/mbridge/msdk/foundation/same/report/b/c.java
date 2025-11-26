package com.mbridge.msdk.foundation.same.report.b;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.tracker.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static long f9430a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static long f9431b;

    private static final class a implements a {
        public final void a() {
        }

        public final void a(final String str, final StackTraceElement[] stackTraceElementArr) {
            if (MBridgeConstans.DEBUG) {
                af.a("AnrMonitorManager", "onAnrHappened: " + str);
            }
            if (!c.b(str)) {
                af.a("AnrMonitorManager", "onAnrHappened: can track false");
                return;
            }
            long unused = c.f9431b = System.currentTimeMillis();
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    try {
                        c.a(str, stackTraceElementArr);
                    } catch (Exception e5) {
                        af.b("AnrMonitorManager", "handler anr failed", e5);
                    }
                }
            });
        }
    }

    public static String b(StackTraceElement[] stackTraceElementArr) {
        return c(stackTraceElementArr) ? "1" : "0";
    }

    private static boolean c(StackTraceElement[] stackTraceElementArr) {
        if (!(stackTraceElementArr == null || stackTraceElementArr.length == 0)) {
            try {
                ArrayList arrayList = new ArrayList();
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (stackTraceElement != null) {
                        if (!TextUtils.isEmpty(stackTraceElement.toString())) {
                            String stackTraceElement2 = stackTraceElement.toString();
                            if (!TextUtils.isEmpty(stackTraceElement2)) {
                                if (!stackTraceElement2.contains(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && !stackTraceElement2.contains("com.google") && !stackTraceElement2.contains("java.lang") && !stackTraceElement2.contains(MBridgeConstans.APPLICATION_STACK_ANDROID_OS)) {
                                    if (stackTraceElement2.contains(MBridgeConstans.APPLICATION_STACK_ANDROID_APP)) {
                                    }
                                }
                            }
                            arrayList.add(stackTraceElement2);
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    return false;
                }
                return b((String) arrayList.get(0));
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("AnrMonitorManager", "isMBridgeFirst exception", e5);
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (String next : d.a(d.a())) {
                if (!TextUtils.isEmpty(next)) {
                    if (str.contains(next)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        if (!(stackTraceElementArr == null || stackTraceElementArr.length == 0)) {
            try {
                StringBuilder sb = new StringBuilder();
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (stackTraceElement != null) {
                        sb.append(stackTraceElement.toString());
                        sb.append("\r\n");
                    }
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static void a() {
        if (!b()) {
            af.a("AnrMonitorManager", "anr monitor is not available");
            return;
        }
        try {
            b.a().a(c(), new a()).start();
        } catch (Exception e5) {
            af.b("AnrMonitorManager", "start anr monitor failed", e5);
        }
    }

    private static boolean b() {
        try {
            return ah.a().a("anr_monitor_available", false);
        } catch (Exception e5) {
            af.b("AnrMonitorManager", "get anr monitor available failed", e5);
            return false;
        }
    }

    static /* synthetic */ void a(String str, StackTraceElement[] stackTraceElementArr) throws JSONException {
        try {
            JSONObject b5 = d.a(com.mbridge.msdk.foundation.controller.c.m().c()).b(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
            b5.put("crashinfo", str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", b5.toString());
            jSONObject.put("crash_first_index_from_mtg", b(stackTraceElementArr));
            e eVar = new e("m_anr_report");
            eVar.a(jSONObject);
            eVar.a(com.mbridge.msdk.foundation.same.report.c.c());
            eVar.a(0);
            eVar.b(1);
            f.a().d().a(eVar);
        } catch (JSONException e5) {
            af.b("AnrMonitorManager", "reportANRByEventLibrary anr failed", e5);
        }
    }

    private static int c() {
        try {
            int a5 = ah.a().a("anr_check_timeout", (int) DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
            return a5 <= 0 ? DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS : a5;
        } catch (Exception e5) {
            af.b("AnrMonitorManager", "get anr check timeout failed", e5);
            return DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
        }
    }
}
