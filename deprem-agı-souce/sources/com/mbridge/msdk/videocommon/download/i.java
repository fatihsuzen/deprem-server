package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.d.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f13163a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f13164b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f13165c = c.m().c();

    /* renamed from: d  reason: collision with root package name */
    private final String f13166d;

    /* renamed from: e  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f13167e;

    /* renamed from: f  reason: collision with root package name */
    private final int f13168f;

    /* renamed from: g  reason: collision with root package name */
    private final CopyOnWriteArrayList<CampaignEx> f13169g;

    /* renamed from: h  reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f13170h = new ConcurrentHashMap<>();

    public i(List<CampaignEx> list, String str, int i5) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f13169g = copyOnWriteArrayList;
        this.f13166d = str;
        this.f13168f = i5;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    private String b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return "";
        }
        try {
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                return rewardTemplateMode.e();
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", this.f13166d + " getVideoTemplateUrl error", e5);
            }
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.videocommon.download.a c(com.mbridge.msdk.foundation.entity.CampaignEx r6) {
        /*
            r5 = this;
            r0 = 0
            com.mbridge.msdk.videocommon.download.a r1 = new com.mbridge.msdk.videocommon.download.a     // Catch:{ Exception -> 0x0040 }
            android.content.Context r2 = r5.f13165c     // Catch:{ Exception -> 0x0040 }
            java.lang.String r3 = r5.f13166d     // Catch:{ Exception -> 0x0040 }
            int r4 = r5.f()     // Catch:{ Exception -> 0x0040 }
            r1.<init>(r2, r6, r3, r4)     // Catch:{ Exception -> 0x0040 }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r6)     // Catch:{ Exception -> 0x003d }
            int r2 = r5.f13168f     // Catch:{ Exception -> 0x003d }
            r1.d((int) r2)     // Catch:{ Exception -> 0x003d }
            int r2 = r5.f(r6)     // Catch:{ Exception -> 0x003d }
            r1.c((int) r2)     // Catch:{ Exception -> 0x003d }
            int r2 = r5.e()     // Catch:{ Exception -> 0x003d }
            r1.b((int) r2)     // Catch:{ Exception -> 0x003d }
            int r6 = r5.d(r6)     // Catch:{ Exception -> 0x003d }
            r1.e((int) r6)     // Catch:{ Exception -> 0x003d }
            r1.a((com.mbridge.msdk.videocommon.download.c) r0)     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.videocommon.download.i$a r6 = new com.mbridge.msdk.videocommon.download.i$a     // Catch:{ Exception -> 0x003d }
            java.lang.String r0 = r5.f13166d     // Catch:{ Exception -> 0x003d }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.listener.a> r2 = r5.f13164b     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.videocommon.listener.a r3 = r5.f13163a     // Catch:{ Exception -> 0x003d }
            r6.<init>(r0, r2, r3)     // Catch:{ Exception -> 0x003d }
            r1.a((com.mbridge.msdk.videocommon.listener.a) r6)     // Catch:{ Exception -> 0x003d }
            return r1
        L_0x003d:
            r6 = move-exception
            r0 = r1
            goto L_0x0041
        L_0x0040:
            r6 = move-exception
        L_0x0041:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0064
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r5.f13166d
            r1.append(r2)
            java.lang.String r2 = " createAndStartCampaignDownloadTask error "
            r1.append(r2)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            java.lang.String r1 = "RewardVideoRefactorManager"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r6)
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.i.c(com.mbridge.msdk.foundation.entity.CampaignEx):com.mbridge.msdk.videocommon.download.a");
    }

    private int d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 1;
        }
        try {
            return campaignEx.getVideoCtnType();
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return 1;
            }
            af.a("RewardVideoRefactorManager", this.f13166d + " getVideoCtnType error " + e5.getMessage());
            return 1;
        }
    }

    private boolean e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            af.a("RewardVideoRefactorManager", this.f13166d + " isPlayerAbleAds error:" + th.getMessage());
            return false;
        }
    }

    private int f(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return g();
    }

    private int g() {
        try {
            return c(this.f13166d).r();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            af.a("RewardVideoRefactorManager", this.f13166d + " getRewardReadyRate error:" + th.getMessage());
            return 100;
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f13163a = aVar;
    }

    public final void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (this.f13164b == null) {
            this.f13164b = new ConcurrentHashMap<>();
        }
        if (aVar != null && !TextUtils.isEmpty(str)) {
            this.f13164b.put(str, aVar);
        }
    }

    private int f() {
        if (TextUtils.isEmpty(this.f13166d)) {
            return 1;
        }
        try {
            com.mbridge.msdk.videocommon.d.c c5 = c(this.f13166d);
            if (c5 != null) {
                return c5.w();
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.a("RewardVideoRefactorManager", this.f13166d + " getDlnet error " + e5.getMessage());
            }
        }
        return 1;
    }

    private int e() {
        com.mbridge.msdk.videocommon.d.c c5 = c(this.f13166d);
        if (c5 == null) {
            return 0;
        }
        try {
            return c5.s();
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return 0;
            }
            af.a("RewardVideoRefactorManager", this.f13166d + " getCDRate error " + e5.getMessage());
            return 0;
        }
    }

    public final void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                this.f13169g.addAll(list);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoRefactorManager", this.f13166d + " update error", e5);
                }
            }
        }
    }

    public final CopyOnWriteArrayList<Map<String, a>> d() {
        try {
            CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(this.f13170h);
            return copyOnWriteArrayList;
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            af.b("RewardVideoRefactorManager", this.f13166d + " getCampaignDownLoadTaskList error:" + e5.getMessage());
            return null;
        }
    }

    public i(CampaignEx campaignEx, String str, int i5) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f13169g = copyOnWriteArrayList;
        this.f13166d = str;
        this.f13168f = i5;
        if (campaignEx != null) {
            copyOnWriteArrayList.add(campaignEx);
        }
    }

    public final a b() {
        List<a> list;
        if (this.f13169g.size() == 0) {
            af.a("RewardVideoRefactorManager", this.f13166d + " isReady campaignExes is null");
            return null;
        }
        try {
            list = a((List<CampaignEx>) this.f13169g, false);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", this.f13166d + " isReady error", e5);
            }
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    private static final class a implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a  reason: collision with root package name */
        private final String f13171a;

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f13172b;

        /* renamed from: c  reason: collision with root package name */
        private final com.mbridge.msdk.videocommon.listener.a f13173c;

        public a(String str, ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap, com.mbridge.msdk.videocommon.listener.a aVar) {
            this.f13171a = str;
            this.f13172b = concurrentHashMap;
            this.f13173c = aVar;
        }

        public final void a(String str) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f13173c;
            if (aVar != null) {
                try {
                    aVar.a(str);
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoRefactorManager", this.f13171a + " videoDownloadListener onDownLoadDone error: " + e5.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f13172b;
            if (concurrentHashMap != null) {
                for (com.mbridge.msdk.videocommon.listener.a a5 : concurrentHashMap.values()) {
                    try {
                        a5.a(str);
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoRefactorManager", this.f13171a + " videoDownloadListener onDownLoadDone error: " + e6.getMessage());
                        }
                    }
                }
            }
        }

        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f13173c;
            if (aVar != null) {
                try {
                    aVar.a(str, str2);
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoRefactorManager", this.f13171a + " videoDownloadListener onDownLoadFailed error: " + e5.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f13172b;
            if (concurrentHashMap != null) {
                for (com.mbridge.msdk.videocommon.listener.a a5 : concurrentHashMap.values()) {
                    try {
                        a5.a(str, str2);
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoRefactorManager", this.f13171a + " videoDownloadListener onDownLoadFailed error: " + e6.getMessage());
                        }
                    }
                }
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                this.f13169g.add(campaignEx);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoRefactorManager", this.f13166d + " update error", e5);
                }
            }
        }
    }

    public final void a() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f13169g;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            af.a("RewardVideoRefactorManager", this.f13166d + " load campaignExes is null");
            return;
        }
        Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CampaignEx next = it.next();
            if (next != null) {
                try {
                    String str = next.getRequestId() + next.getId() + next.getVideoUrlEncode();
                    if (!this.f13170h.containsKey(str)) {
                        a(next, str, (a) null);
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoRefactorManager", this.f13166d + " handlerCampaignLoadEvent error", e5);
                    }
                }
            }
        }
    }

    private com.mbridge.msdk.videocommon.d.c c(String str) {
        try {
            if (this.f13167e == null) {
                this.f13167e = b.a().a(c.m().k(), str, this.f13168f == 287);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.a("RewardVideoRefactorManager", this.f13166d + " getRewardUnitSetting error " + e5.getMessage());
            }
        }
        return this.f13167e;
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.f13170h.containsKey(str)) {
                    a remove = this.f13170h.remove(str);
                    if (remove != null) {
                        CampaignEx l5 = remove.l();
                        if (l5 != null) {
                            this.f13169g.remove(l5);
                            if (MBridgeConstans.DEBUG) {
                                af.a("RewardVideoRefactorManager", this.f13166d + " removeCampaignDownloadTask campaign name: " + l5.getAppName());
                            }
                        }
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoRefactorManager", this.f13166d + " removeCampaignDownloadTask error:" + e5.getMessage());
                }
            }
        }
    }

    public final a c() {
        try {
            return b();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            af.b("RewardVideoRefactorManager", this.f13166d + " getCampaignDownLoadTask error:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b6, code lost:
        if (r11.getRsIgnoreCheckRule().contains(0) != false) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ca, code lost:
        if (r11.getVideoCheckType() == r5) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0139, code lost:
        if (com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r12.j(), r12.m()) >= r13) goto L_0x0140;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016f A[Catch:{ Exception -> 0x0165 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01cf A[Catch:{ Exception -> 0x01e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01f2 A[Catch:{ Exception -> 0x01e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0201 A[Catch:{ Exception -> 0x01e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0208 A[Catch:{ Exception -> 0x01e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0115 A[Catch:{ Exception -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0116 A[Catch:{ Exception -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x015b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.videocommon.download.a> a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r21, boolean r22) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r2 = "\n\t\t\tisIgnore = "
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r5 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.lang.String r8 = "RewardVideoRefactorManager"
            if (r21 == 0) goto L_0x001d
            int r0 = r21.size()
            if (r0 != 0) goto L_0x0021
        L_0x001d:
            r16 = r7
            goto L_0x03a6
        L_0x0021:
            int r9 = r21.size()
            java.util.Iterator r10 = r21.iterator()
        L_0x0029:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x03a3
            java.lang.Object r0 = r10.next()
            r11 = r0
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = (com.mbridge.msdk.foundation.entity.CampaignEx) r11
            if (r11 != 0) goto L_0x0039
            goto L_0x0029
        L_0x0039:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x037d }
            r0.<init>()     // Catch:{ Exception -> 0x037d }
            java.lang.String r12 = r11.getRequestId()     // Catch:{ Exception -> 0x037d }
            r0.append(r12)     // Catch:{ Exception -> 0x037d }
            java.lang.String r12 = r11.getId()     // Catch:{ Exception -> 0x037d }
            r0.append(r12)     // Catch:{ Exception -> 0x037d }
            java.lang.String r12 = r11.getVideoUrlEncode()     // Catch:{ Exception -> 0x037d }
            r0.append(r12)     // Catch:{ Exception -> 0x037d }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x037d }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.download.a> r12 = r1.f13170h     // Catch:{ Exception -> 0x037d }
            java.lang.Object r12 = r12.get(r0)     // Catch:{ Exception -> 0x037d }
            com.mbridge.msdk.videocommon.download.a r12 = (com.mbridge.msdk.videocommon.download.a) r12     // Catch:{ Exception -> 0x037d }
            com.mbridge.msdk.videocommon.download.a r12 = r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r11, (java.lang.String) r0, (com.mbridge.msdk.videocommon.download.a) r12)     // Catch:{ Exception -> 0x037d }
            if (r12 != 0) goto L_0x006b
            r14 = r6
            r16 = r7
            r7 = r5
            goto L_0x039c
        L_0x006b:
            int r0 = r11.getLoadTimeoutState()     // Catch:{ Exception -> 0x01c7 }
            boolean r13 = r12.d()     // Catch:{ Exception -> 0x01c7 }
            if (r13 != 0) goto L_0x013e
            int r13 = r1.f(r11)     // Catch:{ Exception -> 0x0107 }
            int r14 = r1.f()     // Catch:{ Exception -> 0x0107 }
            boolean r15 = r12.d()     // Catch:{ Exception -> 0x0107 }
            if (r15 == 0) goto L_0x0085
            goto L_0x013e
        L_0x0085:
            boolean r15 = r1.e(r11)     // Catch:{ Exception -> 0x0107 }
            if (r15 == 0) goto L_0x008d
            goto L_0x013e
        L_0x008d:
            java.lang.String r15 = r12.e()     // Catch:{ Exception -> 0x0107 }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x0107 }
            if (r15 == 0) goto L_0x0099
            goto L_0x013e
        L_0x0099:
            r15 = 3
            if (r14 != r15) goto L_0x009e
            goto L_0x013e
        L_0x009e:
            java.util.ArrayList r14 = r11.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0107 }
            if (r14 == 0) goto L_0x00c0
            java.util.ArrayList r14 = r11.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x00ba }
            int r14 = r14.size()     // Catch:{ Exception -> 0x00ba }
            if (r14 <= 0) goto L_0x00c0
            java.util.ArrayList r14 = r11.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x00ba }
            boolean r14 = r14.contains(r4)     // Catch:{ Exception -> 0x00ba }
            if (r14 == 0) goto L_0x00c0
            goto L_0x013e
        L_0x00ba:
            r0 = move-exception
            r5 = r3
            r14 = r6
            r6 = r5
            goto L_0x01cb
        L_0x00c0:
            int r14 = r11.getIsTimeoutCheckVideoStatus()     // Catch:{ Exception -> 0x0107 }
            if (r14 != r5) goto L_0x00ce
            int r14 = r11.getVideoCheckType()     // Catch:{ Exception -> 0x00ba }
            if (r14 != r5) goto L_0x00ce
            goto L_0x013e
        L_0x00ce:
            long r14 = r12.m()     // Catch:{ Exception -> 0x0107 }
            long r16 = r12.j()     // Catch:{ Exception -> 0x0107 }
            if (r22 == 0) goto L_0x00ec
            int r3 = r11.getVideoCheckType()     // Catch:{ Exception -> 0x0107 }
            if (r3 != r5) goto L_0x00ec
            if (r13 != 0) goto L_0x00e1
            goto L_0x013e
        L_0x00e1:
            r18 = 0
            int r3 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r3 != 0) goto L_0x00ef
            int r3 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r3 == 0) goto L_0x00ec
            goto L_0x00ef
        L_0x00ec:
            r19 = r6
            goto L_0x010b
        L_0x00ef:
            int r3 = r13 / 100
            r19 = r6
            long r5 = (long) r3
            long r5 = r5 * r16
            int r3 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x010b
            r3 = 1
            r11.setIsTimeoutCheckVideoStatus(r3)     // Catch:{ Exception -> 0x00ff }
            goto L_0x0140
        L_0x00ff:
            r0 = move-exception
        L_0x0100:
            r14 = r19
        L_0x0102:
            r3 = 0
        L_0x0103:
            r5 = 0
        L_0x0104:
            r6 = 0
            goto L_0x01cb
        L_0x0107:
            r0 = move-exception
            r19 = r6
            goto L_0x0100
        L_0x010b:
            java.lang.String r3 = r12.e()     // Catch:{ Exception -> 0x00ff }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00ff }
            if (r3 == 0) goto L_0x0116
            goto L_0x0140
        L_0x0116:
            if (r13 != 0) goto L_0x012d
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r12.l()     // Catch:{ Exception -> 0x00ff }
            if (r3 == 0) goto L_0x013c
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r12.l()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r3 = r3.getVideoUrlEncode()     // Catch:{ Exception -> 0x00ff }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00ff }
            if (r3 != 0) goto L_0x013c
            goto L_0x0140
        L_0x012d:
            long r5 = r12.j()     // Catch:{ Exception -> 0x00ff }
            long r14 = r12.m()     // Catch:{ Exception -> 0x00ff }
            int r3 = com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r5, r14)     // Catch:{ Exception -> 0x00ff }
            if (r3 < r13) goto L_0x013c
            goto L_0x0140
        L_0x013c:
            r3 = 0
            goto L_0x0141
        L_0x013e:
            r19 = r6
        L_0x0140:
            r3 = 1
        L_0x0141:
            r12.d((boolean) r3)     // Catch:{ Exception -> 0x0157 }
            boolean r5 = r12.b()     // Catch:{ Exception -> 0x0157 }
            if (r5 != 0) goto L_0x015b
            java.lang.String r5 = r11.getendcard_url()     // Catch:{ Exception -> 0x0157 }
            boolean r5 = r1.a((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r11, (com.mbridge.msdk.videocommon.download.a) r12)     // Catch:{ Exception -> 0x0157 }
            if (r5 == 0) goto L_0x0155
            goto L_0x015b
        L_0x0155:
            r5 = 0
            goto L_0x015c
        L_0x0157:
            r0 = move-exception
            r14 = r19
            goto L_0x0103
        L_0x015b:
            r5 = 1
        L_0x015c:
            if (r0 != 0) goto L_0x0169
            if (r5 == 0) goto L_0x0169
            r6 = 1
            r12.b((boolean) r6)     // Catch:{ Exception -> 0x0165 }
            goto L_0x0169
        L_0x0165:
            r0 = move-exception
            r14 = r19
            goto L_0x0104
        L_0x0169:
            boolean r6 = r12.c()     // Catch:{ Exception -> 0x0165 }
            if (r6 != 0) goto L_0x01b9
            java.lang.String r6 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r11)     // Catch:{ Exception -> 0x0165 }
            boolean r13 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0165 }
            if (r13 == 0) goto L_0x017a
            goto L_0x01b9
        L_0x017a:
            boolean r13 = r12.c()     // Catch:{ Exception -> 0x0165 }
            if (r13 == 0) goto L_0x0181
            goto L_0x01b9
        L_0x0181:
            boolean r13 = r11.isDynamicView()     // Catch:{ Exception -> 0x0165 }
            if (r13 == 0) goto L_0x0188
            goto L_0x01b9
        L_0x0188:
            java.util.ArrayList r13 = r11.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0165 }
            if (r13 == 0) goto L_0x01a8
            java.util.ArrayList r13 = r11.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0165 }
            int r13 = r13.size()     // Catch:{ Exception -> 0x0165 }
            if (r13 <= 0) goto L_0x01a8
            java.util.ArrayList r13 = r11.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0165 }
            r14 = r19
            boolean r13 = r13.contains(r14)     // Catch:{ Exception -> 0x01a5 }
            if (r13 == 0) goto L_0x01aa
            goto L_0x01bb
        L_0x01a5:
            r0 = move-exception
            goto L_0x0104
        L_0x01a8:
            r14 = r19
        L_0x01aa:
            int r13 = r11.getLoadTimeoutState()     // Catch:{ Exception -> 0x01a5 }
            if (r13 != 0) goto L_0x01bb
            java.lang.String r6 = com.mbridge.msdk.videocommon.download.f.a(r6)     // Catch:{ Exception -> 0x01a5 }
            if (r6 == 0) goto L_0x01b7
            goto L_0x01bb
        L_0x01b7:
            r6 = 0
            goto L_0x01bc
        L_0x01b9:
            r14 = r19
        L_0x01bb:
            r6 = 1
        L_0x01bc:
            if (r0 != 0) goto L_0x01ec
            if (r6 == 0) goto L_0x01ec
            r13 = 1
            r12.c((boolean) r13)     // Catch:{ Exception -> 0x01c5 }
            goto L_0x01ec
        L_0x01c5:
            r0 = move-exception
            goto L_0x01cb
        L_0x01c7:
            r0 = move-exception
            r14 = r6
            goto L_0x0102
        L_0x01cb:
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x01e6 }
            if (r13 == 0) goto L_0x01ec
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e6 }
            r13.<init>()     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r15 = r1.f13166d     // Catch:{ Exception -> 0x01e6 }
            r13.append(r15)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r15 = " checkResourceReadyState error"
            r13.append(r15)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x01e6 }
            com.mbridge.msdk.foundation.tools.af.b(r8, r13, r0)     // Catch:{ Exception -> 0x01e6 }
            goto L_0x01ec
        L_0x01e6:
            r0 = move-exception
            r16 = r7
        L_0x01e9:
            r7 = 1
            goto L_0x0382
        L_0x01ec:
            boolean r0 = r12.a()     // Catch:{ Exception -> 0x01e6 }
            if (r0 != 0) goto L_0x01fb
            if (r3 == 0) goto L_0x01f9
            if (r5 == 0) goto L_0x01f9
            if (r6 == 0) goto L_0x01f9
            goto L_0x01fb
        L_0x01f9:
            r0 = 0
            goto L_0x01fc
        L_0x01fb:
            r0 = 1
        L_0x01fc:
            r12.a((boolean) r0)     // Catch:{ Exception -> 0x01e6 }
            if (r0 == 0) goto L_0x0204
            r7.add(r12)     // Catch:{ Exception -> 0x01e6 }
        L_0x0204:
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x01e6 }
            if (r13 == 0) goto L_0x0379
            java.util.ArrayList r13 = r11.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x01e6 }
            if (r13 != 0) goto L_0x0213
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x01e6 }
            r13.<init>()     // Catch:{ Exception -> 0x01e6 }
        L_0x0213:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e6 }
            r15.<init>()     // Catch:{ Exception -> 0x01e6 }
            r16 = r7
            java.lang.String r7 = r1.f13166d     // Catch:{ Exception -> 0x0376 }
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "  campaign name = "
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = r11.getAppName()     // Catch:{ Exception -> 0x0376 }
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "\n\t\tcampaign id = "
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = r11.getId()     // Catch:{ Exception -> 0x0376 }
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "\n\t\trequest id = "
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = r11.getRequestId()     // Catch:{ Exception -> 0x0376 }
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "\n\t\tadType = "
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            int r7 = r1.f13168f     // Catch:{ Exception -> 0x0376 }
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "\n\t\tunitID = "
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = r1.f13166d     // Catch:{ Exception -> 0x0376 }
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "\n\t\tisReady = "
            r15.append(r7)     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\tisDynamicView = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            boolean r0 = r11.isDynamicView()     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\tisTPL = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = r11.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0376 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0376 }
            r18 = 1
            r0 = r0 ^ 1
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\tcurrentSuccessSize = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            int r0 = r16.size()     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\tisReadyCheckSize = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            r15.append(r9)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\ttotalCampaignSize = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f13169g     // Catch:{ Exception -> 0x0376 }
            int r0 = r0.size()     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\tlinkType = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            int r0 = r11.getLinkType()     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\tloadTimeoutState = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            int r0 = r11.getLoadTimeoutState()     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\tisVideoReady = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            r15.append(r3)     // Catch:{ Exception -> 0x0376 }
            r15.append(r2)     // Catch:{ Exception -> 0x0376 }
            boolean r0 = r13.contains(r4)     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\t\treadyRate == "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            int r0 = r1.f(r11)     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\t\tCDRate = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            int r0 = r1.e()     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\t\tdlnet = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            int r0 = r1.f()     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\t\tctn = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            int r0 = r1.d(r11)     // Catch:{ Exception -> 0x0376 }
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = "\n\t\t\tdownloadState = "
            r15.append(r0)     // Catch:{ Exception -> 0x0376 }
            int r0 = r12.k()     // Catch:{ Exception -> 0x0376 }
            r3 = 2
            if (r0 == 0) goto L_0x0324
            r7 = 1
            if (r0 == r7) goto L_0x0321
            if (r0 == r3) goto L_0x031e
            r12 = 4
            if (r0 == r12) goto L_0x031b
            r12 = 5
            if (r0 == r12) goto L_0x0318
            java.lang.String r0 = "Unknown"
            goto L_0x0327
        L_0x0315:
            r0 = move-exception
            goto L_0x0382
        L_0x0318:
            java.lang.String r0 = "DOWNLOAD_DONE"
            goto L_0x0327
        L_0x031b:
            java.lang.String r0 = "DOWNLOAD_STOP"
            goto L_0x0327
        L_0x031e:
            java.lang.String r0 = "DOWNLOAD_PAUSE"
            goto L_0x0327
        L_0x0321:
            java.lang.String r0 = "DOWNLOAD_RUN"
            goto L_0x0327
        L_0x0324:
            r7 = 1
            java.lang.String r0 = "DOWNLOAD_READY"
        L_0x0327:
            r15.append(r0)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r0 = "\n\t\tisTemplateReady = "
            r15.append(r0)     // Catch:{ Exception -> 0x0315 }
            r15.append(r6)     // Catch:{ Exception -> 0x0315 }
            r15.append(r2)     // Catch:{ Exception -> 0x0315 }
            boolean r0 = r13.contains(r14)     // Catch:{ Exception -> 0x0315 }
            r15.append(r0)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r0 = "\n\t\tisEndCardReady = "
            r15.append(r0)     // Catch:{ Exception -> 0x0315 }
            r15.append(r5)     // Catch:{ Exception -> 0x0315 }
            r15.append(r2)     // Catch:{ Exception -> 0x0315 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0315 }
            boolean r0 = r13.contains(r0)     // Catch:{ Exception -> 0x0315 }
            r15.append(r0)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r0 = "\n\t\t\tisOnlyPlayable = "
            r15.append(r0)     // Catch:{ Exception -> 0x0315 }
            boolean r0 = r1.e(r11)     // Catch:{ Exception -> 0x0315 }
            r15.append(r0)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r0 = "\n\t\t\tisPlayableEndCard(dynamicView) = "
            r15.append(r0)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r0 = r11.getendcard_url()     // Catch:{ Exception -> 0x0315 }
            boolean r0 = com.mbridge.msdk.foundation.tools.ak.l((java.lang.String) r0)     // Catch:{ Exception -> 0x0315 }
            r15.append(r0)     // Catch:{ Exception -> 0x0315 }
            java.lang.String r0 = r15.toString()     // Catch:{ Exception -> 0x0315 }
            com.mbridge.msdk.foundation.tools.af.b(r8, r0)     // Catch:{ Exception -> 0x0315 }
            goto L_0x039c
        L_0x0376:
            r0 = move-exception
            goto L_0x01e9
        L_0x0379:
            r16 = r7
            r7 = 1
            goto L_0x039c
        L_0x037d:
            r0 = move-exception
            r14 = r6
            r16 = r7
            r7 = r5
        L_0x0382:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L_0x039c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r1.f13166d
            r3.append(r5)
            java.lang.String r5 = " isReady error"
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            com.mbridge.msdk.foundation.tools.af.b(r8, r3, r0)
        L_0x039c:
            r5 = r7
            r6 = r14
            r7 = r16
            r3 = 0
            goto L_0x0029
        L_0x03a3:
            r16 = r7
            return r16
        L_0x03a6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r1.f13166d
            r0.append(r2)
            java.lang.String r2 = " isReady campaignExes is null"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r8, (java.lang.String) r0)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.i.a(java.util.List, boolean):java.util.List");
    }

    private a a(CampaignEx campaignEx, String str, a aVar) {
        if (aVar != null) {
            return aVar;
        }
        a c5 = c(campaignEx);
        c5.n();
        this.f13170h.put(str, c5);
        return c5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a9 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r5, com.mbridge.msdk.foundation.entity.CampaignEx r6, com.mbridge.msdk.videocommon.download.a r7) {
        /*
            r4 = this;
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "RewardVideoRefactorManager"
            r2 = 0
            if (r6 == 0) goto L_0x00cb
            if (r7 != 0) goto L_0x000e
            goto L_0x00cb
        L_0x000e:
            boolean r7 = r7.b()     // Catch:{ all -> 0x002c }
            r3 = 1
            if (r7 == 0) goto L_0x002f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r5.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r6 = r4.f13166d     // Catch:{ all -> 0x002c }
            r5.append(r6)     // Catch:{ all -> 0x002c }
            java.lang.String r6 = " checkEndCardZipOrSourceDownLoad endCard download success"
            r5.append(r6)     // Catch:{ all -> 0x002c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x002c }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ all -> 0x002c }
            return r3
        L_0x002c:
            r5 = move-exception
            goto L_0x00aa
        L_0x002f:
            java.util.ArrayList r7 = r6.getRsIgnoreCheckRule()     // Catch:{ all -> 0x002c }
            if (r7 == 0) goto L_0x004a
            java.util.ArrayList r7 = r6.getRsIgnoreCheckRule()     // Catch:{ all -> 0x002c }
            int r7 = r7.size()     // Catch:{ all -> 0x002c }
            if (r7 <= 0) goto L_0x004a
            java.util.ArrayList r7 = r6.getRsIgnoreCheckRule()     // Catch:{ all -> 0x002c }
            boolean r7 = r7.contains(r0)     // Catch:{ all -> 0x002c }
            if (r7 == 0) goto L_0x004a
            return r3
        L_0x004a:
            boolean r7 = r6.isDynamicView()     // Catch:{ all -> 0x002c }
            if (r7 == 0) goto L_0x0057
            boolean r7 = com.mbridge.msdk.foundation.tools.ak.l((java.lang.String) r5)     // Catch:{ all -> 0x002c }
            if (r7 != 0) goto L_0x0057
            return r3
        L_0x0057:
            boolean r7 = com.mbridge.msdk.foundation.tools.ap.a(r5)     // Catch:{ all -> 0x002c }
            if (r7 == 0) goto L_0x005e
            return r3
        L_0x005e:
            boolean r7 = r6.isMraid()     // Catch:{ all -> 0x002c }
            if (r7 != 0) goto L_0x0077
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x002c }
            if (r7 == 0) goto L_0x006b
            goto L_0x0077
        L_0x006b:
            int r7 = r6.getLoadTimeoutState()     // Catch:{ all -> 0x002c }
            if (r7 != r3) goto L_0x0079
            boolean r7 = r4.e(r6)     // Catch:{ all -> 0x002c }
            if (r7 != 0) goto L_0x0079
        L_0x0077:
            r5 = r3
            goto L_0x00a7
        L_0x0079:
            java.util.ArrayList r7 = r6.getRsIgnoreCheckRule()     // Catch:{ all -> 0x002c }
            if (r7 == 0) goto L_0x0094
            java.util.ArrayList r7 = r6.getRsIgnoreCheckRule()     // Catch:{ all -> 0x002c }
            int r7 = r7.size()     // Catch:{ all -> 0x002c }
            if (r7 <= 0) goto L_0x0094
            java.util.ArrayList r6 = r6.getRsIgnoreCheckRule()     // Catch:{ all -> 0x002c }
            boolean r6 = r6.contains(r0)     // Catch:{ all -> 0x002c }
            if (r6 == 0) goto L_0x0094
            goto L_0x0077
        L_0x0094:
            java.lang.String r6 = com.mbridge.msdk.videocommon.download.f.a(r5)     // Catch:{ all -> 0x002c }
            boolean r6 = com.mbridge.msdk.foundation.tools.ap.b(r6)     // Catch:{ all -> 0x002c }
            if (r6 == 0) goto L_0x009f
            goto L_0x0077
        L_0x009f:
            java.lang.String r5 = com.mbridge.msdk.videocommon.download.f.b(r5)     // Catch:{ all -> 0x002c }
            boolean r5 = com.mbridge.msdk.foundation.tools.ap.b(r5)     // Catch:{ all -> 0x002c }
        L_0x00a7:
            if (r5 == 0) goto L_0x00cb
            return r3
        L_0x00aa:
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r6 == 0) goto L_0x00cb
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r4.f13166d
            r6.append(r7)
            java.lang.String r7 = " checkEndCardDownload error "
            r6.append(r7)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r5)
        L_0x00cb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.i.a(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.videocommon.download.a):boolean");
    }

    public final a a(String str) {
        if (!TextUtils.isEmpty(str) && this.f13170h.containsKey(str)) {
            return this.f13170h.get(str);
        }
        return null;
    }
}
