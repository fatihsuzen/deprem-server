package com.mbridge.msdk.videocommon.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.d.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13004a = "com.mbridge.msdk.videocommon.a.a";

    /* renamed from: b  reason: collision with root package name */
    private static a f13005b;

    /* renamed from: c  reason: collision with root package name */
    private e f13006c;

    private a() {
        try {
            Context c5 = c.m().c();
            if (c5 != null) {
                this.f13006c = e.a((f) g.a(c5));
            } else {
                af.b(f13004a, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public static a a() {
        if (f13005b == null) {
            synchronized (a.class) {
                try {
                    if (f13005b == null) {
                        f13005b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13005b;
    }

    public final int b(String str, int i5, boolean z4, String str2) {
        List<CampaignEx> list;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            if (z4) {
                list = this.f13006c.a(str, 0, 0, i5, str2);
            } else {
                list = this.f13006c.a(str, 0, 0, i5, false);
            }
            if (list == null) {
                return 0;
            }
            for (CampaignEx next : list) {
                if (next != null && next.getReadyState() == 0) {
                    arrayList.add(next);
                }
            }
            return arrayList.size();
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public final List<CampaignEx> c(String str, int i5, boolean z4, String str2) {
        long ad;
        List<CampaignEx> list;
        ArrayList arrayList = null;
        try {
            com.mbridge.msdk.c.g b5 = h.a().b(c.m().k());
            if (b5 != null) {
                ad = b5.ad();
            } else {
                h.a();
                ad = i.a().ad();
            }
            long j5 = ad * 1000;
            if (!TextUtils.isEmpty(str)) {
                if (z4) {
                    list = this.f13006c.a(str, 0, 0, i5, str2);
                } else {
                    list = this.f13006c.a(str, 0, 0, i5, false);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        for (CampaignEx next : list) {
                            if (next != null && next.getReadyState() == 0) {
                                long plctb = next.getPlctb() * 1000;
                                long timestamp = currentTimeMillis - next.getTimestamp();
                                int i6 = (plctb > 0 ? 1 : (plctb == 0 ? 0 : -1));
                                if ((i6 <= 0 && j5 >= timestamp) || (i6 > 0 && plctb >= timestamp)) {
                                    arrayList2.add(next);
                                }
                            }
                        }
                        return arrayList2;
                    } catch (Exception e5) {
                        e = e5;
                        arrayList = arrayList2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
            }
            return null;
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            return arrayList;
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str, int i5) {
        List<CampaignEx> a5;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (a5 = this.f13006c.a(str, 0, 0, i5)) == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx next : a5) {
                    if (next != null) {
                        copyOnWriteArrayList2.add(next);
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e5) {
                e = e5;
                copyOnWriteArrayList = copyOnWriteArrayList2;
                e.printStackTrace();
                return copyOnWriteArrayList;
            }
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            return copyOnWriteArrayList;
        }
    }

    public final List<CampaignEx> b(String str, int i5, boolean z4) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return this.f13006c.a(str, 0, 0, i5, z4);
            }
            return null;
        } catch (Exception e5) {
            af.b(f13004a, e5.getLocalizedMessage());
            return null;
        }
    }

    public final void a(String str, List<CampaignEx> list, String str2, int i5) {
        e eVar;
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && !TextUtils.isEmpty(str2) && (eVar = this.f13006c) != null) {
            eVar.a(str, list, str2, i5);
        }
    }

    public final void b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> f5 = this.f13006c.f(str);
                if (f5 != null && f5.size() > 0) {
                    com.mbridge.msdk.c.g b5 = h.a().b(c.m().k());
                    if (b5 == null) {
                        h.a();
                        b5 = i.a();
                    }
                    long ad = b5 != null ? b5.ad() : 0;
                    long currentTimeMillis = System.currentTimeMillis();
                    for (com.mbridge.msdk.foundation.entity.c next : f5.values()) {
                        if (next != null) {
                            long e5 = next.e();
                            if (e5 <= 0) {
                                e5 = ad;
                            }
                            if (next.f() + (e5 * 1000) < currentTimeMillis) {
                                if (!TextUtils.isEmpty(next.a())) {
                                    af.b("HBOPTIMIZE", "不在有效期范围内 删除" + next.a());
                                    c(str, next.a());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public final void a(String str, List<CampaignEx> list) {
        e eVar;
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && (eVar = this.f13006c) != null) {
            eVar.b(str, list);
        }
    }

    public final void a(String str, List<CampaignEx> list, String str2) {
        e eVar;
        try {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && (eVar = this.f13006c) != null) {
                eVar.a(str, list, str2);
            }
        } catch (Exception e5) {
            af.b(f13004a, e5.getMessage());
        }
    }

    public final synchronized void c(String str, String str2) {
        try {
            this.f13006c.c(str2, str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(String str, String str2) {
        if (this.f13006c != null && !TextUtils.isEmpty(str)) {
            this.f13006c.f(str, str2);
        }
    }

    public final synchronized void c(String str, int i5) {
        try {
            com.mbridge.msdk.c.g b5 = h.a().b(c.m().k());
            if (b5 == null) {
                h.a();
                b5 = i.a();
            }
            int m5 = b5.m();
            if (m5 != 0) {
                boolean z4 = false;
                List<CampaignEx> b6 = this.f13006c.b(str, i5, m5 == 2);
                if (b6 != null && b6.size() > 0) {
                    for (CampaignEx next : b6) {
                        String requestIdNotice = next.getRequestIdNotice();
                        String id = next.getId();
                        com.mbridge.msdk.videocommon.a.b(next.getCampaignUnitId() + "_" + id + "_" + requestIdNotice + "_" + next.getCMPTEntryUrl());
                    }
                }
                e eVar = this.f13006c;
                if (m5 == 2) {
                    z4 = true;
                }
                eVar.a(str, i5, z4);
            }
        } catch (Exception e5) {
            af.b(f13004a, e5.getMessage());
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final List<CampaignEx> a(String str, int i5, boolean z4) {
        return a(str, i5, z4, "");
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str, int i5, boolean z4, String str2) {
        Exception exc;
        List<CampaignEx> list;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            com.mbridge.msdk.videocommon.d.a b5 = b.a().b();
            long f5 = b5 != null ? b5.f() : 0;
            if (!TextUtils.isEmpty(str)) {
                if (z4) {
                    list = this.f13006c.a(str, 0, 0, i5, str2);
                } else {
                    list = this.f13006c.a(str, 0, 0, i5, false);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (list != null) {
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                    try {
                        for (CampaignEx next : list) {
                            if (next != null) {
                                if (next.getReadyState() != 0) {
                                    if (next.getLoadTimeoutState() == 1) {
                                    }
                                }
                                long plct = next.getPlct() * 1000;
                                long timestamp = currentTimeMillis - next.getTimestamp();
                                int i6 = (plct > 0 ? 1 : (plct == 0 ? 0 : -1));
                                if ((i6 > 0 && plct >= timestamp) || (i6 <= 0 && f5 >= timestamp)) {
                                    copyOnWriteArrayList2.add(next);
                                }
                            }
                        }
                        return copyOnWriteArrayList2;
                    } catch (Exception e5) {
                        exc = e5;
                        copyOnWriteArrayList = copyOnWriteArrayList2;
                        exc.printStackTrace();
                        return copyOnWriteArrayList;
                    }
                }
            }
            return null;
        } catch (Exception e6) {
            exc = e6;
            exc.printStackTrace();
            return copyOnWriteArrayList;
        }
    }

    public final void b(String str, String str2) {
        e eVar = this.f13006c;
        if (eVar != null) {
            eVar.e(str, str2);
        }
    }

    public final void b(String str, int i5) {
        int size;
        try {
            List<com.mbridge.msdk.foundation.entity.c> d5 = this.f13006c.d(str);
            if (d5 != null && d5.size() > 0 && (size = d5.size() - i5) > 0) {
                for (int i6 = 0; i6 < size; i6++) {
                    c(str, d5.get(i6).a());
                    com.mbridge.msdk.foundation.same.a.b.c(str, d5.get(i6).a());
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list != null) {
            try {
                com.mbridge.msdk.videocommon.d.a b5 = b.a().b();
                long f5 = b5 != null ? b5.f() : 0;
                long currentTimeMillis = System.currentTimeMillis();
                if (list.size() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        for (CampaignEx next : list) {
                            if (next != null) {
                                long plct = next.getPlct() * 1000;
                                long timestamp = currentTimeMillis - next.getTimestamp();
                                int i5 = (plct > 0 ? 1 : (plct == 0 ? 0 : -1));
                                if ((i5 > 0 && plct >= timestamp) || (i5 <= 0 && f5 >= timestamp)) {
                                    arrayList2.add(next);
                                }
                            }
                        }
                        return arrayList2;
                    } catch (Exception e5) {
                        e = e5;
                        arrayList = arrayList2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    public final List<com.mbridge.msdk.foundation.entity.c> a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return this.f13006c.d(str);
            }
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (campaignEx.isBidCampaign()) {
                        com.mbridge.msdk.foundation.same.a.b.c(str, campaignEx.getRequestId());
                    }
                    this.f13006c.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getId())) {
                    this.f13006c.b(campaignEx.getId(), campaignEx.getRequestId());
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, List<CampaignEx> list) {
        try {
            if (!TextUtils.isEmpty(str2) && list != null && list.size() > 0) {
                this.f13006c.a(list, str, str2, 0);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final synchronized void a(long j5, String str) {
        try {
            this.f13006c.a(j5, str);
        } catch (Exception e5) {
            e5.printStackTrace();
            af.b(f13004a, e5.getMessage());
        }
    }
}
