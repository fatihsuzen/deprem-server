package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.d.c;
import com.mbridge.msdk.videocommon.listener.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f13139a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13140b = false;

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<String, j> f13141c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> f13142d;

    /* renamed from: e  reason: collision with root package name */
    private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> f13143e;

    /* renamed from: f  reason: collision with root package name */
    private ConcurrentHashMap<String, CopyOnWriteArrayList<a>> f13144f;

    private b() {
    }

    public static b getInstance() {
        if (f13139a == null) {
            synchronized (b.class) {
                try {
                    if (f13139a == null) {
                        f13139a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13139a;
    }

    public final a a(String str, String str2) {
        j c5 = c(str);
        if (c5 != null) {
            return c5.a(str2);
        }
        return null;
    }

    public final CopyOnWriteArrayList<a> b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.f13144f;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f13144f.get(str);
    }

    public final j c(String str) {
        ConcurrentHashMap<String, j> concurrentHashMap = this.f13141c;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f13141c.get(str);
    }

    public j createUnitCache(Context context, String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, int i5, a aVar) {
        if (TextUtils.isEmpty(str) || copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return null;
        }
        if (this.f13141c.containsKey(str)) {
            j jVar = this.f13141c.get(str);
            if (jVar == null) {
                jVar = new j(context, (List<CampaignEx>) copyOnWriteArrayList, str, i5);
                this.f13141c.put(str, jVar);
            }
            if (i5 == 94 || i5 == 287) {
                jVar.a(copyOnWriteArrayList.get(0).getRequestId(), aVar);
            } else {
                jVar.a(aVar);
            }
            jVar.a((List<CampaignEx>) copyOnWriteArrayList);
            return jVar;
        }
        j jVar2 = new j(context, (List<CampaignEx>) copyOnWriteArrayList, str, i5);
        if (aVar != null) {
            jVar2.a(aVar);
        }
        this.f13141c.put(str, jVar2);
        return jVar2;
    }

    public void load(String str) {
        j c5 = c(str);
        if (c5 != null) {
            c5.a();
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.f13143e;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f13143e.get(str);
    }

    public final void b(String str, CopyOnWriteArrayList<a> copyOnWriteArrayList) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.f13144f;
        if (concurrentHashMap == null) {
            this.f13144f = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap.clear();
        }
        this.f13144f.put(str, copyOnWriteArrayList);
    }

    public final void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.f13143e;
        if (concurrentHashMap == null) {
            this.f13143e = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap.clear();
        }
        this.f13143e.put(str, copyOnWriteArrayList);
    }

    public final int b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, a>> c5;
        a aVar;
        CampaignEx l5;
        ConcurrentHashMap<String, j> concurrentHashMap = this.f13141c;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, j> value : concurrentHashMap.entrySet()) {
                j jVar = (j) value.getValue();
                if (!(jVar == null || (c5 = jVar.c()) == null)) {
                    int size = c5.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        Map map = c5.get(i5);
                        if (map != null) {
                            Iterator it = map.entrySet().iterator();
                            if (!(!it.hasNext() || (aVar = (a) ((Map.Entry) it.next()).getValue()) == null || (l5 = aVar.l()) == null)) {
                                String videoUrlEncode = l5.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return aVar.k();
                                }
                            }
                        }
                    }
                    continue;
                }
            }
        }
        return 0;
    }

    public final boolean a(int i5, String str, boolean z4) {
        try {
            j c5 = c(str);
            if (c5 == null || c5.a(i5, z4) == null) {
                return false;
            }
            return true;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public j createUnitCache(Context context, String str, CampaignEx campaignEx, int i5, a aVar) {
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.f13141c.containsKey(str)) {
            j jVar = this.f13141c.get(str);
            if (jVar == null) {
                jVar = new j(context, campaignEx, str, i5);
                this.f13141c.put(str, jVar);
            }
            if (i5 == 94 || i5 == 287) {
                jVar.a(campaignEx.getRequestId(), aVar);
            } else {
                jVar.a(aVar);
            }
            jVar.a(campaignEx);
            return jVar;
        }
        j jVar2 = new j(context, campaignEx, str, i5);
        if (aVar != null) {
            jVar2.a(aVar);
        }
        this.f13141c.put(str, jVar2);
        return jVar2;
    }

    public final boolean a(int i5, String str, boolean z4, int i6, boolean z5, int i7, List<CampaignEx> list) {
        return a(i5, str, z4, i6, z5, i7, list, false, (e) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012b, code lost:
        if (r3.size() >= r16) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0189, code lost:
        if (r2.size() > 0) goto L_0x018b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0242  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r13, java.lang.String r14, boolean r15, int r16, boolean r17, int r18, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20, com.mbridge.msdk.foundation.same.report.d.e r21) {
        /*
            r12 = this;
            r7 = 0
            if (r19 == 0) goto L_0x0245
            int r0 = r19.size()     // Catch:{ Exception -> 0x0060 }
            if (r0 != 0) goto L_0x000b
            goto L_0x0245
        L_0x000b:
            com.mbridge.msdk.videocommon.download.j r0 = r12.c(r14)     // Catch:{ Exception -> 0x0060 }
            if (r0 == 0) goto L_0x023d
            r2 = r13
            r1 = r14
            r3 = r15
            r4 = r19
            r5 = r20
            r6 = r21
            java.util.List r13 = r0.a(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0060 }
            if (r13 == 0) goto L_0x018c
            int r0 = r13.size()     // Catch:{ Exception -> 0x0060 }
            if (r0 != 0) goto L_0x0028
            goto L_0x018c
        L_0x0028:
            r0 = 1
            if (r17 == 0) goto L_0x012e
            int r2 = r4.size()     // Catch:{ Exception -> 0x0060 }
            if (r2 <= 0) goto L_0x0064
            java.lang.Object r2 = r4.get(r7)     // Catch:{ Exception -> 0x0060 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x0060 }
            if (r2 == 0) goto L_0x0064
            java.util.ArrayList r3 = r2.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0060 }
            if (r3 == 0) goto L_0x0064
            java.util.ArrayList r3 = r2.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0060 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x0060 }
            if (r3 <= 0) goto L_0x0064
            java.util.ArrayList r2 = r2.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0060 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0060 }
            boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x0060 }
            if (r2 == 0) goto L_0x0064
            java.lang.String r2 = "DownLoadManager"
            java.lang.String r3 = "Is not check video download status with TPL"
            com.mbridge.msdk.foundation.tools.af.c(r2, r3)     // Catch:{ Exception -> 0x0060 }
            r2 = r0
            goto L_0x0065
        L_0x0060:
            r0 = move-exception
            r13 = r0
            goto L_0x023e
        L_0x0064:
            r2 = r7
        L_0x0065:
            if (r18 != 0) goto L_0x00ce
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00be }
            r3.<init>()     // Catch:{ Exception -> 0x00be }
            java.util.Iterator r5 = r13.iterator()     // Catch:{ Exception -> 0x00be }
        L_0x0070:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x00be }
            if (r6 == 0) goto L_0x00c3
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x00be }
            com.mbridge.msdk.videocommon.download.a r6 = (com.mbridge.msdk.videocommon.download.a) r6     // Catch:{ Exception -> 0x00be }
            java.util.Iterator r7 = r4.iterator()     // Catch:{ Exception -> 0x00be }
        L_0x0080:
            boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x00be }
            if (r8 == 0) goto L_0x0070
            java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x00be }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ Exception -> 0x00be }
            if (r6 == 0) goto L_0x0080
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r6.l()     // Catch:{ Exception -> 0x00be }
            if (r9 == 0) goto L_0x0080
            if (r8 == 0) goto L_0x0080
            java.lang.String r9 = r8.getId()     // Catch:{ Exception -> 0x00be }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r6.l()     // Catch:{ Exception -> 0x00be }
            java.lang.String r10 = r10.getId()     // Catch:{ Exception -> 0x00be }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x00be }
            if (r9 == 0) goto L_0x0080
            java.lang.String r8 = r8.getRequestId()     // Catch:{ Exception -> 0x00be }
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r6.l()     // Catch:{ Exception -> 0x00be }
            java.lang.String r9 = r9.getRequestId()     // Catch:{ Exception -> 0x00be }
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x00be }
            if (r8 == 0) goto L_0x0080
            r3.add(r6)     // Catch:{ Exception -> 0x00be }
            goto L_0x0080
        L_0x00be:
            r0 = move-exception
            r13 = r0
            r7 = r2
            goto L_0x023e
        L_0x00c3:
            int r3 = r3.size()     // Catch:{ Exception -> 0x00be }
            if (r3 <= 0) goto L_0x00cb
            goto L_0x018b
        L_0x00cb:
            r7 = r2
            goto L_0x018c
        L_0x00ce:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00be }
            r3.<init>()     // Catch:{ Exception -> 0x00be }
            java.util.Iterator r5 = r13.iterator()     // Catch:{ Exception -> 0x00be }
        L_0x00d7:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x00be }
            if (r6 == 0) goto L_0x0125
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x00be }
            com.mbridge.msdk.videocommon.download.a r6 = (com.mbridge.msdk.videocommon.download.a) r6     // Catch:{ Exception -> 0x00be }
            java.util.Iterator r8 = r4.iterator()     // Catch:{ Exception -> 0x00be }
        L_0x00e7:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x00be }
            if (r9 == 0) goto L_0x00d7
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x00be }
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9     // Catch:{ Exception -> 0x00be }
            if (r6 == 0) goto L_0x00e7
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r6.l()     // Catch:{ Exception -> 0x00be }
            if (r10 == 0) goto L_0x00e7
            if (r9 == 0) goto L_0x00e7
            java.lang.String r10 = r9.getId()     // Catch:{ Exception -> 0x00be }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r6.l()     // Catch:{ Exception -> 0x00be }
            java.lang.String r11 = r11.getId()     // Catch:{ Exception -> 0x00be }
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x00be }
            if (r10 == 0) goto L_0x00e7
            java.lang.String r9 = r9.getRequestId()     // Catch:{ Exception -> 0x00be }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r6.l()     // Catch:{ Exception -> 0x00be }
            java.lang.String r10 = r10.getRequestId()     // Catch:{ Exception -> 0x00be }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x00be }
            if (r9 == 0) goto L_0x00e7
            r3.add(r6)     // Catch:{ Exception -> 0x00be }
            goto L_0x00e7
        L_0x0125:
            int r2 = r3.size()     // Catch:{ Exception -> 0x00be }
            r3 = r16
            if (r2 < r3) goto L_0x018c
            goto L_0x018b
        L_0x012e:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0060 }
            r2.<init>()     // Catch:{ Exception -> 0x0060 }
            java.util.Iterator r3 = r13.iterator()     // Catch:{ Exception -> 0x0060 }
        L_0x0137:
            boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x0060 }
            if (r5 == 0) goto L_0x0185
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x0060 }
            com.mbridge.msdk.videocommon.download.a r5 = (com.mbridge.msdk.videocommon.download.a) r5     // Catch:{ Exception -> 0x0060 }
            java.util.Iterator r6 = r4.iterator()     // Catch:{ Exception -> 0x0060 }
        L_0x0147:
            boolean r8 = r6.hasNext()     // Catch:{ Exception -> 0x0060 }
            if (r8 == 0) goto L_0x0137
            java.lang.Object r8 = r6.next()     // Catch:{ Exception -> 0x0060 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ Exception -> 0x0060 }
            if (r5 == 0) goto L_0x0147
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r5.l()     // Catch:{ Exception -> 0x0060 }
            if (r9 == 0) goto L_0x0147
            if (r8 == 0) goto L_0x0147
            java.lang.String r9 = r8.getId()     // Catch:{ Exception -> 0x0060 }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r5.l()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r10 = r10.getId()     // Catch:{ Exception -> 0x0060 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x0060 }
            if (r9 == 0) goto L_0x0147
            java.lang.String r8 = r8.getRequestId()     // Catch:{ Exception -> 0x0060 }
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r5.l()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r9 = r9.getRequestId()     // Catch:{ Exception -> 0x0060 }
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x0060 }
            if (r8 == 0) goto L_0x0147
            r2.add(r5)     // Catch:{ Exception -> 0x0060 }
            goto L_0x0147
        L_0x0185:
            int r2 = r2.size()     // Catch:{ Exception -> 0x0060 }
            if (r2 <= 0) goto L_0x018c
        L_0x018b:
            r7 = r0
        L_0x018c:
            if (r7 == 0) goto L_0x023d
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>> r0 = r12.f13142d     // Catch:{ Exception -> 0x0060 }
            if (r0 != 0) goto L_0x019a
            j$.util.concurrent.ConcurrentHashMap r0 = new j$.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x0060 }
            r0.<init>()     // Catch:{ Exception -> 0x0060 }
            r12.f13142d = r0     // Catch:{ Exception -> 0x0060 }
            goto L_0x01a5
        L_0x019a:
            boolean r0 = r0.containsKey(r14)     // Catch:{ Exception -> 0x0060 }
            if (r0 == 0) goto L_0x01a5
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>> r0 = r12.f13142d     // Catch:{ Exception -> 0x0060 }
            r0.remove(r14)     // Catch:{ Exception -> 0x0060 }
        L_0x01a5:
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.a>> r0 = r12.f13144f     // Catch:{ Exception -> 0x0060 }
            if (r0 != 0) goto L_0x01b1
            j$.util.concurrent.ConcurrentHashMap r0 = new j$.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x0060 }
            r0.<init>()     // Catch:{ Exception -> 0x0060 }
            r12.f13144f = r0     // Catch:{ Exception -> 0x0060 }
            goto L_0x01bc
        L_0x01b1:
            boolean r0 = r0.containsKey(r14)     // Catch:{ Exception -> 0x0060 }
            if (r0 == 0) goto L_0x01bc
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.a>> r0 = r12.f13144f     // Catch:{ Exception -> 0x0060 }
            r0.remove(r14)     // Catch:{ Exception -> 0x0060 }
        L_0x01bc:
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>> r0 = r12.f13143e     // Catch:{ Exception -> 0x0060 }
            if (r0 != 0) goto L_0x01c8
            j$.util.concurrent.ConcurrentHashMap r0 = new j$.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x0060 }
            r0.<init>()     // Catch:{ Exception -> 0x0060 }
            r12.f13143e = r0     // Catch:{ Exception -> 0x0060 }
            goto L_0x01d3
        L_0x01c8:
            boolean r0 = r0.containsKey(r14)     // Catch:{ Exception -> 0x0060 }
            if (r0 == 0) goto L_0x01d3
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>> r0 = r12.f13143e     // Catch:{ Exception -> 0x0060 }
            r0.remove(r14)     // Catch:{ Exception -> 0x0060 }
        L_0x01d3:
            if (r13 == 0) goto L_0x023d
            int r0 = r13.size()     // Catch:{ Exception -> 0x0060 }
            if (r0 <= 0) goto L_0x023d
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x0060 }
            r0.<init>()     // Catch:{ Exception -> 0x0060 }
            java.util.concurrent.CopyOnWriteArrayList r2 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x0060 }
            r2.<init>()     // Catch:{ Exception -> 0x0060 }
            java.util.concurrent.CopyOnWriteArrayList r3 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x0060 }
            r3.<init>()     // Catch:{ Exception -> 0x0060 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x0060 }
        L_0x01ee:
            boolean r4 = r13.hasNext()     // Catch:{ Exception -> 0x0060 }
            if (r4 == 0) goto L_0x022e
            java.lang.Object r4 = r13.next()     // Catch:{ Exception -> 0x0060 }
            com.mbridge.msdk.videocommon.download.a r4 = (com.mbridge.msdk.videocommon.download.a) r4     // Catch:{ Exception -> 0x0060 }
            j$.util.concurrent.ConcurrentHashMap r5 = new j$.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x0060 }
            r5.<init>()     // Catch:{ Exception -> 0x0060 }
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r4.l()     // Catch:{ Exception -> 0x0060 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0060 }
            r8.<init>()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r9 = r6.getId()     // Catch:{ Exception -> 0x0060 }
            r8.append(r9)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r9 = r6.getVideoUrlEncode()     // Catch:{ Exception -> 0x0060 }
            r8.append(r9)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r9 = r6.getBidToken()     // Catch:{ Exception -> 0x0060 }
            r8.append(r9)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0060 }
            r5.put(r8, r4)     // Catch:{ Exception -> 0x0060 }
            r0.add(r5)     // Catch:{ Exception -> 0x0060 }
            r2.add(r6)     // Catch:{ Exception -> 0x0060 }
            r3.add(r4)     // Catch:{ Exception -> 0x0060 }
            goto L_0x01ee
        L_0x022e:
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>> r13 = r12.f13142d     // Catch:{ Exception -> 0x0060 }
            r13.put(r14, r0)     // Catch:{ Exception -> 0x0060 }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>> r13 = r12.f13143e     // Catch:{ Exception -> 0x0060 }
            r13.put(r14, r2)     // Catch:{ Exception -> 0x0060 }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.a>> r13 = r12.f13144f     // Catch:{ Exception -> 0x0060 }
            r13.put(r14, r3)     // Catch:{ Exception -> 0x0060 }
        L_0x023d:
            return r7
        L_0x023e:
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r14 == 0) goto L_0x0245
            r13.printStackTrace()
        L_0x0245:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.b.a(int, java.lang.String, boolean, int, boolean, int, java.util.List, boolean, com.mbridge.msdk.foundation.same.report.d.e):boolean");
    }

    public final void b(boolean z4) {
        if (!z4) {
            this.f13140b = false;
        } else if (this.f13140b) {
            return;
        }
        ConcurrentHashMap<String, j> concurrentHashMap = this.f13141c;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, j> value : concurrentHashMap.entrySet()) {
                ((j) value.getValue()).a();
            }
        }
    }

    public final void a(boolean z4) {
        this.f13140b = z4;
        ConcurrentHashMap<String, j> concurrentHashMap = this.f13141c;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, j> value : concurrentHashMap.entrySet()) {
                j jVar = (j) value.getValue();
                if (jVar != null) {
                    jVar.b();
                }
            }
        }
    }

    public final void a() {
        ConcurrentHashMap<String, j> concurrentHashMap = this.f13141c;
        if (concurrentHashMap != null) {
            for (Map.Entry next : concurrentHashMap.entrySet()) {
                j jVar = (j) next.getValue();
                String str = (String) next.getKey();
                try {
                    c a5 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), str);
                    if (a5 != null) {
                        if (a5.w() == 2) {
                            jVar.b();
                        } else {
                            jVar.a();
                        }
                    }
                } catch (Exception e5) {
                    af.b("DownLoadManager", e5.getMessage());
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            k d5 = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), str);
                            if (d5 == null) {
                                d5 = k.e(str);
                            }
                            if (d5.k() == 2) {
                                jVar.b();
                            } else {
                                jVar.a();
                            }
                        }
                    } catch (Exception e6) {
                        af.b("DownLoadManager", e6.getMessage());
                    }
                }
            }
        }
    }
}
