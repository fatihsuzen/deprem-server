package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.google.android.gms.measurement.internal.q2  reason: case insensitive filesystem */
public final class C1402q2 extends B3 {

    /* renamed from: c  reason: collision with root package name */
    private char f6627c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f6628d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f6629e;

    /* renamed from: f  reason: collision with root package name */
    private final C1388o2 f6630f = new C1388o2(this, 6, false, false);

    /* renamed from: g  reason: collision with root package name */
    private final C1388o2 f6631g = new C1388o2(this, 6, true, false);

    /* renamed from: h  reason: collision with root package name */
    private final C1388o2 f6632h = new C1388o2(this, 6, false, true);

    /* renamed from: i  reason: collision with root package name */
    private final C1388o2 f6633i = new C1388o2(this, 5, false, false);

    /* renamed from: j  reason: collision with root package name */
    private final C1388o2 f6634j = new C1388o2(this, 5, true, false);

    /* renamed from: k  reason: collision with root package name */
    private final C1388o2 f6635k = new C1388o2(this, 5, false, true);

    /* renamed from: l  reason: collision with root package name */
    private final C1388o2 f6636l = new C1388o2(this, 4, false, false);

    /* renamed from: m  reason: collision with root package name */
    private final C1388o2 f6637m = new C1388o2(this, 3, false, false);

    /* renamed from: n  reason: collision with root package name */
    private final C1388o2 f6638n = new C1388o2(this, 2, false, false);

    C1402q2(X2 x22) {
        super(x22);
    }

    static String A(boolean z4, String str, Object obj, Object obj2, Object obj3) {
        String B4 = B(z4, obj);
        String B5 = B(z4, obj2);
        String B6 = B(z4, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(B4)) {
            sb.append(str2);
            sb.append(B4);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(B5)) {
            sb.append(str2);
            sb.append(B5);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(B6)) {
            sb.append(str3);
            sb.append(B6);
        }
        return sb.toString();
    }

    static String B(boolean z4, Object obj) {
        String str;
        String className;
        String str2 = "";
        if (obj == null) {
            return str2;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i5 = 0;
        if (obj instanceof Long) {
            if (!z4) {
                return obj.toString();
            }
            Long l5 = (Long) obj;
            if (Math.abs(l5.longValue()) < 100) {
                return obj.toString();
            }
            char charAt = obj.toString().charAt(0);
            String valueOf = String.valueOf(Math.abs(l5.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 4.0d);
            int length = String.valueOf(round).length();
            if (charAt == '-') {
                str2 = "-";
            }
            int length2 = str2.length() + length;
            StringBuilder sb = new StringBuilder(length2 + 3 + str2.length() + String.valueOf(round2).length());
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return obj.toString();
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                if (z4) {
                    str = th.getClass().getName();
                } else {
                    str = th.toString();
                }
                StringBuilder sb2 = new StringBuilder(str);
                String C4 = C(X2.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length3 = stackTrace.length;
                while (true) {
                    if (i5 >= length3) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i5];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && C(className).equals(C4)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i5++;
                }
                return sb2.toString();
            } else if (obj instanceof C1395p2) {
                return ((C1395p2) obj).a();
            } else {
                if (z4) {
                    return "-";
                }
                return obj.toString();
            }
        }
    }

    static String C(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) != -1) {
            return str.substring(0, lastIndexOf);
        }
        return "";
    }

    protected static Object x(String str) {
        if (str == null) {
            return null;
        }
        return new C1395p2(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ char D() {
        return this.f6627c;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void E(char c5) {
        this.f6627c = c5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ long F() {
        return this.f6628d;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void G(long j5) {
        this.f6628d = 133005;
    }

    /* access modifiers changed from: protected */
    public final boolean i() {
        return false;
    }

    public final C1388o2 o() {
        return this.f6630f;
    }

    public final C1388o2 p() {
        return this.f6631g;
    }

    public final C1388o2 q() {
        return this.f6632h;
    }

    public final C1388o2 r() {
        return this.f6633i;
    }

    public final C1388o2 s() {
        return this.f6634j;
    }

    public final C1388o2 t() {
        return this.f6635k;
    }

    public final C1388o2 u() {
        return this.f6636l;
    }

    public final C1388o2 v() {
        return this.f6637m;
    }

    public final C1388o2 w() {
        return this.f6638n;
    }

    /* access modifiers changed from: protected */
    public final void y(int i5, boolean z4, boolean z5, String str, Object obj, Object obj2, Object obj3) {
        if (!z4 && Log.isLoggable(z(), i5)) {
            Log.println(i5, z(), A(false, str, obj, obj2, obj3));
        }
        if (!z5 && i5 >= 5) {
            C0722p.k(str);
            T2 A4 = this.f5730a.A();
            if (A4 == null) {
                Log.println(6, z(), "Scheduler not set. Not logging error/warn");
            } else if (!A4.k()) {
                Log.println(6, z(), "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i5 >= 9) {
                    i5 = 8;
                }
                A4.t(new C1381n2(this, i5, str, obj, obj2, obj3));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String z() {
        String str;
        synchronized (this) {
            try {
                if (this.f6629e == null) {
                    this.f6629e = this.f5730a.w().u();
                }
                C0722p.k(this.f6629e);
                str = this.f6629e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
