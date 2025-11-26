package com.mbridge.msdk.foundation.same.net.e;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.tracker.network.h;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f9332a;

    /* renamed from: b  reason: collision with root package name */
    private int f9333b;

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<String, a> f9334c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Integer> f9335d;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9336a;

        /* renamed from: b  reason: collision with root package name */
        public String f9337b;

        /* renamed from: c  reason: collision with root package name */
        public long f9338c;

        public a(long j5, int i5, String str) {
            this.f9338c = j5;
            this.f9336a = i5;
            this.f9337b = str;
        }
    }

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f9339a = new c();
    }

    public static c a() {
        return b.f9339a;
    }

    private d b(String str, String str2, String str3, String str4, String str5) {
        int parseInt;
        String str6 = str + "_" + str3 + "_" + str2 + "_" + str5;
        a a5 = a(str6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h("data_res_type", "1"));
        if (a5 != null && !TextUtils.isEmpty(a5.f9337b)) {
            try {
                if (a5.f9336a != -1) {
                    return d.a(new JSONObject(a5.f9337b), new com.mbridge.msdk.foundation.same.net.d.a(200, a5.f9337b.getBytes(), arrayList));
                }
                if (!TextUtils.isEmpty(str4)) {
                    return null;
                }
                if (!(str5 == null || TextUtils.isEmpty(str5) || (parseInt = Integer.parseInt(str5)) == 287 || parseInt == 94)) {
                    if (System.currentTimeMillis() < ((long) (com.mbridge.msdk.c.h.a().a(str, str2).n() * 1000)) + a5.f9338c) {
                        return d.a(new JSONObject(a5.f9337b), new com.mbridge.msdk.foundation.same.net.d.a(200, a5.f9337b.getBytes(), arrayList));
                    }
                    this.f9334c.remove(str6);
                    return null;
                }
            } catch (Exception e5) {
                af.b("IDErrorUtil", e5.getMessage());
            }
        }
        af.b("IDErrorUtil", "getErrorInfo RETURN NULL");
        return null;
    }

    private c() {
        this.f9332a = "IDErrorUtil";
        this.f9334c = new ConcurrentHashMap<>();
        this.f9335d = new ArrayList<>();
        g b5 = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (b5 == null) {
            com.mbridge.msdk.c.h.a();
            b5 = i.a();
        }
        this.f9333b = b5.A() * 1000;
        if (b5.E() == null || b5.E().size() <= 0) {
            af.b("IDErrorUtil", "Setting ercd is EMPTY and use default code list.");
            this.f9335d.addAll(Arrays.asList(new Integer[]{-1, -10, -1201, -1202, -1203, -1205, -1206, -1208, -1301, -1302, -1305, -1306, -1307, -1915, 10602, 10603, 10604, 10609, 10610, 10616}));
            return;
        }
        af.b("IDErrorUtil", "Setting ercd not EMPTY will use setting.");
        this.f9335d.addAll(b5.E());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r4, int r5, java.lang.String r6, long r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.e.c$a> r0 = r3.f9334c     // Catch:{ all -> 0x0048 }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r3)
            return
        L_0x000b:
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0013
            monitor-exit(r3)
            return
        L_0x0013:
            java.util.ArrayList<java.lang.Integer> r0 = r3.f9335d     // Catch:{ all -> 0x0048 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0048 }
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x004a
            java.lang.String r0 = "IDErrorUtil"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r1.<init>()     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "addErrorInfo : "
            r1.append(r2)     // Catch:{ all -> 0x0048 }
            r1.append(r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = " "
            r1.append(r2)     // Catch:{ all -> 0x0048 }
            r1.append(r6)     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0048 }
            com.mbridge.msdk.foundation.tools.af.b(r0, r1)     // Catch:{ all -> 0x0048 }
            com.mbridge.msdk.foundation.same.net.e.c$a r0 = new com.mbridge.msdk.foundation.same.net.e.c$a     // Catch:{ all -> 0x0048 }
            r0.<init>(r7, r5, r6)     // Catch:{ all -> 0x0048 }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.e.c$a> r5 = r3.f9334c     // Catch:{ all -> 0x0048 }
            r5.put(r4, r0)     // Catch:{ all -> 0x0048 }
            goto L_0x004a
        L_0x0048:
            r4 = move-exception
            goto L_0x004c
        L_0x004a:
            monitor-exit(r3)
            return
        L_0x004c:
            monitor-exit(r3)     // Catch:{ all -> 0x0048 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.e.c.a(java.lang.String, int, java.lang.String, long):void");
    }

    public final d a(String str, String str2, String str3, String str4, String str5) {
        return b(str, str2, str3, str4, str5);
    }

    public final d a(e eVar) {
        String str = eVar.a().get(MBridgeConstans.APP_ID);
        String str2 = eVar.a().get("placement_id");
        String str3 = TextUtils.isEmpty(str2) ? "" : str2;
        String str4 = eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (TextUtils.isEmpty(str4)) {
            str4 = eVar.a().get("unit_ids");
            if (!TextUtils.isEmpty(str4)) {
                str4 = str4.replace("[", "").replace("]", "");
            }
        }
        String str5 = str4;
        String str6 = eVar.a().get("ad_type");
        if (TextUtils.isEmpty(str6)) {
            str6 = "0";
        }
        return b(str, str5, str3, eVar.a().get("token"), str6);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a6, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.mbridge.msdk.foundation.same.net.e.c.a a(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "IDErrorUtil"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r1.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "getErrorInfo : "
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            r1.append(r8)     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0087 }
            com.mbridge.msdk.foundation.tools.af.b(r0, r1)     // Catch:{ all -> 0x0087 }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.e.c$a> r0 = r7.f9334c     // Catch:{ all -> 0x0087 }
            boolean r0 = r0.containsKey(r8)     // Catch:{ all -> 0x0087 }
            r1 = 0
            if (r0 == 0) goto L_0x00a5
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.e.c$a> r0 = r7.f9334c     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0087 }
            com.mbridge.msdk.foundation.same.net.e.c$a r0 = (com.mbridge.msdk.foundation.same.net.e.c.a) r0     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x00a5
            int r2 = r0.f9336a     // Catch:{ all -> 0x0087 }
            r3 = -1
            if (r2 != r3) goto L_0x0031
            monitor-exit(r7)
            return r0
        L_0x0031:
            long r2 = r0.f9338c     // Catch:{ all -> 0x0087 }
            int r4 = r7.f9333b     // Catch:{ all -> 0x0087 }
            long r4 = (long) r4     // Catch:{ all -> 0x0087 }
            long r2 = r2 + r4
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0087 }
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x008b
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.e.c$a> r0 = r7.f9334c     // Catch:{ all -> 0x0087 }
            r0.remove(r8)     // Catch:{ all -> 0x0087 }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.e.c$a> r8 = r7.f9334c     // Catch:{ all -> 0x0087 }
            int r8 = r8.size()     // Catch:{ all -> 0x0087 }
            if (r8 <= 0) goto L_0x0089
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.e.c$a> r8 = r7.f9334c     // Catch:{ all -> 0x0087 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x0087 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0087 }
        L_0x0056:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0089
            java.lang.String r0 = "IDErrorUtil"
            java.lang.String r2 = "getErrorInfo : delete timeout entry"
            com.mbridge.msdk.foundation.tools.af.b(r0, r2)     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x0087 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0087 }
            java.lang.Object r2 = r0.getValue()     // Catch:{ all -> 0x0087 }
            com.mbridge.msdk.foundation.same.net.e.c$a r2 = (com.mbridge.msdk.foundation.same.net.e.c.a) r2     // Catch:{ all -> 0x0087 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0087 }
            long r5 = r2.f9338c     // Catch:{ all -> 0x0087 }
            long r3 = r3 - r5
            int r2 = r7.f9333b     // Catch:{ all -> 0x0087 }
            long r5 = (long) r2     // Catch:{ all -> 0x0087 }
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0056
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.e.c$a> r2 = r7.f9334c     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r0.getKey()     // Catch:{ all -> 0x0087 }
            r2.remove(r0)     // Catch:{ all -> 0x0087 }
            goto L_0x0056
        L_0x0087:
            r8 = move-exception
            goto L_0x00a7
        L_0x0089:
            monitor-exit(r7)
            return r1
        L_0x008b:
            java.lang.String r8 = "IDErrorUtil"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r1.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "getErrorInfo : "
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = r0.f9337b     // Catch:{ all -> 0x0087 }
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0087 }
            com.mbridge.msdk.foundation.tools.af.b(r8, r1)     // Catch:{ all -> 0x0087 }
            monitor-exit(r7)
            return r0
        L_0x00a5:
            monitor-exit(r7)
            return r1
        L_0x00a7:
            monitor-exit(r7)     // Catch:{ all -> 0x0087 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.e.c.a(java.lang.String):com.mbridge.msdk.foundation.same.net.e.c$a");
    }
}
