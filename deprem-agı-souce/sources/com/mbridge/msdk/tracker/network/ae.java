package com.mbridge.msdk.tracker.network;

import android.util.Log;
import java.util.List;
import java.util.Locale;

public class ae {

    /* renamed from: a  reason: collision with root package name */
    public static String f11566a = "TrackManager_Volley";

    /* renamed from: b  reason: collision with root package name */
    private static final String f11567b = "com.mbridge.msdk.tracker.network.ae";

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<C0108a> f11568a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11569b;

        /* renamed from: com.mbridge.msdk.tracker.network.ae$a$a  reason: collision with other inner class name */
        private static class C0108a {

            /* renamed from: a  reason: collision with root package name */
            public final String f11570a;

            /* renamed from: b  reason: collision with root package name */
            public final long f11571b;

            /* renamed from: c  reason: collision with root package name */
            public final long f11572c;
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            long j5;
            if (!this.f11569b) {
                this.f11569b = true;
                if (this.f11568a.size() == 0) {
                    j5 = 0;
                } else {
                    long j6 = this.f11568a.get(0).f11572c;
                    List<C0108a> list = this.f11568a;
                    j5 = list.get(list.size() - 1).f11572c - j6;
                }
                if (j5 > 0) {
                    long j7 = this.f11568a.get(0).f11572c;
                    ae.b("(%-4d ms) %s", Long.valueOf(j5), "Request on the loose");
                    for (C0108a next : this.f11568a) {
                        long j8 = next.f11572c;
                        ae.b("(+%-4d) [%2d] %s", Long.valueOf(j8 - j7), Long.valueOf(next.f11571b), next.f11570a);
                        j7 = j8;
                    }
                }
                ae.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static void a(String str, Object... objArr) {
    }

    public static void b(String str, Object... objArr) {
        Log.d(f11566a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f11566a, d(str, objArr));
    }

    private static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i5 = 2;
        while (true) {
            if (i5 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i5].getClassName().equals(f11567b)) {
                String className = stackTrace[i5].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i5].getMethodName();
                break;
            } else {
                i5++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f11566a, d(str, objArr), th);
    }
}
