package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbbanner.common.a.b;
import com.mbridge.msdk.mbbanner.common.b.d;
import com.mbridge.msdk.out.MBridgeIds;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f9930a = "a";

    /* renamed from: h  reason: collision with root package name */
    private static volatile a f9931h;

    /* renamed from: b  reason: collision with root package name */
    private Context f9932b = c.m().c();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.mbridge.msdk.mbbanner.common.util.a f9933c = new com.mbridge.msdk.mbbanner.common.util.a();

    /* renamed from: d  reason: collision with root package name */
    private Map<String, b> f9934d = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Boolean> f9935e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Handler> f9936f = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Integer> f9937g = new ConcurrentHashMap();

    private a() {
    }

    public static a a() {
        if (f9931h == null) {
            synchronized (a.class) {
                try {
                    if (f9931h == null) {
                        f9931h = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9931h;
    }

    public final void b(String str, String str2, com.mbridge.msdk.mbbanner.common.a.a aVar, com.mbridge.msdk.mbbanner.common.b.b bVar) {
        Handler handler;
        final MBridgeIds mBridgeIds = new MBridgeIds(str, str2);
        if (aVar == null || aVar.b() <= 0) {
            String str3 = str2;
            String str4 = f9930a;
            af.b(str4, "doUnitRotation: Illegal banner request parameters! && unitId=" + str3);
            return;
        }
        if (this.f9936f.containsKey(str2)) {
            handler = this.f9936f.get(str2);
        } else {
            handler = new Handler();
            this.f9936f.put(str2, handler);
        }
        Handler handler2 = handler;
        final String str5 = str;
        final String str6 = str2;
        final com.mbridge.msdk.mbbanner.common.a.a aVar2 = aVar;
        final com.mbridge.msdk.mbbanner.common.b.b bVar2 = bVar;
        AnonymousClass2 r02 = new Runnable() {
            public final void run() {
                int i5;
                Boolean bool;
                if (a.this.f9935e == null || !a.this.f9935e.containsKey(str6) || (bool = (Boolean) a.this.f9935e.get(str6)) == null || !bool.booleanValue()) {
                    if (a.this.f9937g.containsKey(str6)) {
                        Integer num = (Integer) a.this.f9937g.get(str6);
                        if (num != null) {
                            i5 = num.intValue();
                        } else {
                            i5 = 0;
                        }
                        if (i5 == 2 || i5 == 4) {
                            String c5 = a.f9930a;
                            af.b(c5, "doUnitRotation: autoRotationStatus=" + i5 + " && unitId=" + str6);
                            if (a.this.f9933c != null) {
                                com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880026);
                                bVar.a(mBridgeIds);
                                a.this.f9933c.a(bVar2, bVar);
                                return;
                            }
                            return;
                        }
                    }
                    a.this.a(str5, str6, aVar2, bVar2);
                }
            }
        };
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            handler2.postDelayed(r02, (long) aVar2.b());
        }
    }

    public final void a(String str, String str2, final com.mbridge.msdk.mbbanner.common.a.a aVar, com.mbridge.msdk.mbbanner.common.b.b bVar) {
        b bVar2;
        Boolean bool;
        MBridgeIds mBridgeIds = new MBridgeIds(str, str2);
        String e5 = aVar.e();
        com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(str2, e5);
        String str3 = "1";
        a5.i(!TextUtils.isEmpty(aVar.c()) ? str3 : "0");
        a5.e(aVar.c());
        if (!aVar.f()) {
            str3 = "2";
        }
        a5.b(str3);
        a5.d(aVar.f() ? 1 : 2);
        a5.e(aVar.b());
        com.mbridge.msdk.mbbanner.common.d.a.a("2000123", a5, (e) null);
        if (this.f9932b == null) {
            com.mbridge.msdk.foundation.c.b bVar3 = new com.mbridge.msdk.foundation.c.b(880025);
            bVar3.a(mBridgeIds);
            bVar3.b(e5);
            this.f9933c.a(bVar, bVar3);
        } else if (bVar == null) {
            com.mbridge.msdk.foundation.c.b bVar4 = new com.mbridge.msdk.foundation.c.b(880001);
            bVar4.a(mBridgeIds);
            bVar4.b(e5);
            this.f9933c.a(bVar, bVar4);
        } else {
            Map<String, Boolean> map = this.f9935e;
            if (map == null || !map.containsKey(str2) || (bool = this.f9935e.get(str2)) == null || !bool.booleanValue()) {
                this.f9935e.put(str2, Boolean.TRUE);
                if (this.f9934d.containsKey(str2)) {
                    bVar2 = this.f9934d.get(str2);
                } else {
                    k d5 = h.a().d(c.m().k(), str2);
                    if (d5 == null) {
                        d5 = k.d(str2);
                    }
                    b bVar5 = new b(str2, "", 0, d5.w());
                    this.f9934d.put(str2, bVar5);
                    bVar2 = bVar5;
                }
                bVar2.b(e5);
                new b(this.f9932b, bVar2, bVar, this.f9933c).a(str, str2, aVar, (d) new d() {
                    public final void a(String str) {
                        synchronized (a.a()) {
                            aVar.a("");
                            a.this.f9935e.put(str, Boolean.FALSE);
                        }
                    }
                });
                com.mbridge.msdk.mbbanner.common.d.a.a("2000125", a5, (e) null);
                return;
            }
            com.mbridge.msdk.foundation.c.b bVar6 = new com.mbridge.msdk.foundation.c.b(880016, "Current unit is loading!");
            bVar6.a(mBridgeIds);
            bVar6.b(e5);
            this.f9933c.a(bVar, bVar6);
        }
    }

    public final void b() {
        Map<String, b> map = this.f9934d;
        if (map != null) {
            map.clear();
        }
        Map<String, Boolean> map2 = this.f9935e;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Handler> map3 = this.f9936f;
        if (map3 != null) {
            for (Map.Entry next : map3.entrySet()) {
                if (next.getValue() != null) {
                    ((Handler) next.getValue()).removeCallbacksAndMessages((Object) null);
                }
            }
            this.f9936f.clear();
        }
        Map<String, Integer> map4 = this.f9937g;
        if (map4 != null) {
            map4.clear();
        }
    }

    public final void a(String str) {
        if (this.f9936f.containsKey(str)) {
            Handler handler = this.f9936f.get(str);
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.f9936f.remove(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r7.f9937g.get(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, java.lang.String r9, java.lang.String r10, com.mbridge.msdk.mbbanner.common.a.a r11, com.mbridge.msdk.mbbanner.common.b.b r12) {
        /*
            r7 = this;
            java.util.Map<java.lang.String, java.lang.Integer> r0 = r7.f9937g
            boolean r0 = r0.containsKey(r10)
            r1 = 0
            if (r0 == 0) goto L_0x0018
            java.util.Map<java.lang.String, java.lang.Integer> r0 = r7.f9937g
            java.lang.Object r0 = r0.get(r10)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L_0x0018
            int r0 = r0.intValue()
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            r2 = 0
            r3 = 1
            if (r8 == r3) goto L_0x0084
            r4 = 2
            if (r8 == r4) goto L_0x0063
            r5 = 3
            r6 = 4
            if (r8 == r5) goto L_0x0052
            if (r8 == r6) goto L_0x0027
            goto L_0x0083
        L_0x0027:
            if (r0 != 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Integer> r8 = r7.f9937g
            java.lang.Integer r9 = java.lang.Integer.valueOf(r1)
            r8.put(r10, r9)
            return
        L_0x0033:
            java.util.Map<java.lang.String, android.os.Handler> r9 = r7.f9936f
            boolean r9 = r9.containsKey(r10)
            if (r9 == 0) goto L_0x0048
            java.util.Map<java.lang.String, android.os.Handler> r9 = r7.f9936f
            java.lang.Object r9 = r9.get(r10)
            android.os.Handler r9 = (android.os.Handler) r9
            if (r9 == 0) goto L_0x0048
            r9.removeCallbacksAndMessages(r2)
        L_0x0048:
            java.util.Map<java.lang.String, java.lang.Integer> r9 = r7.f9937g
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.put(r10, r8)
            return
        L_0x0052:
            if (r0 == r4) goto L_0x0056
            if (r0 != r6) goto L_0x0083
        L_0x0056:
            java.util.Map<java.lang.String, java.lang.Integer> r8 = r7.f9937g
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r8.put(r10, r0)
            r7.b(r9, r10, r11, r12)
            return
        L_0x0063:
            if (r0 != r3) goto L_0x0083
            java.util.Map<java.lang.String, android.os.Handler> r9 = r7.f9936f
            boolean r9 = r9.containsKey(r10)
            if (r9 == 0) goto L_0x007a
            java.util.Map<java.lang.String, android.os.Handler> r9 = r7.f9936f
            java.lang.Object r9 = r9.get(r10)
            android.os.Handler r9 = (android.os.Handler) r9
            if (r9 == 0) goto L_0x007a
            r9.removeCallbacksAndMessages(r2)
        L_0x007a:
            java.util.Map<java.lang.String, java.lang.Integer> r9 = r7.f9937g
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.put(r10, r8)
        L_0x0083:
            return
        L_0x0084:
            java.util.Map<java.lang.String, android.os.Handler> r9 = r7.f9936f
            boolean r9 = r9.containsKey(r10)
            if (r9 == 0) goto L_0x0099
            java.util.Map<java.lang.String, android.os.Handler> r9 = r7.f9936f
            java.lang.Object r9 = r9.get(r10)
            android.os.Handler r9 = (android.os.Handler) r9
            if (r9 == 0) goto L_0x0099
            r9.removeCallbacksAndMessages(r2)
        L_0x0099:
            java.util.Map<java.lang.String, java.lang.Integer> r9 = r7.f9937g
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.put(r10, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.a.a(int, java.lang.String, java.lang.String, com.mbridge.msdk.mbbanner.common.a.a, com.mbridge.msdk.mbbanner.common.b.b):void");
    }
}
