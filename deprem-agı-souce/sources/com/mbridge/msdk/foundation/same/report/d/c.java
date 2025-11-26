package com.mbridge.msdk.foundation.same.report.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.aq;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c implements Serializable, Cloneable {

    /* renamed from: A  reason: collision with root package name */
    private int f9471A;

    /* renamed from: B  reason: collision with root package name */
    private CampaignEx f9472B;

    /* renamed from: C  reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f9473C = new CopyOnWriteArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private boolean f9474a = false;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Map<String, String>> f9475b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Map<String, String>> f9476c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Long> f9477d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private b f9478e;

    /* renamed from: f  reason: collision with root package name */
    private String f9479f = "";

    /* renamed from: g  reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f9480g = new CopyOnWriteArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private String f9481h;

    /* renamed from: i  reason: collision with root package name */
    private int f9482i;

    /* renamed from: j  reason: collision with root package name */
    private String f9483j;

    /* renamed from: k  reason: collision with root package name */
    private String f9484k;

    /* renamed from: l  reason: collision with root package name */
    private String f9485l;

    /* renamed from: m  reason: collision with root package name */
    private String f9486m;

    /* renamed from: n  reason: collision with root package name */
    private String f9487n;

    /* renamed from: o  reason: collision with root package name */
    private String f9488o;

    /* renamed from: p  reason: collision with root package name */
    private String f9489p;

    /* renamed from: q  reason: collision with root package name */
    private String f9490q;

    /* renamed from: r  reason: collision with root package name */
    private int f9491r = -1;

    /* renamed from: s  reason: collision with root package name */
    private int f9492s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f9493t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f9494u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f9495v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f9496w;

    /* renamed from: x  reason: collision with root package name */
    private int f9497x;

    /* renamed from: y  reason: collision with root package name */
    private int f9498y;

    /* renamed from: z  reason: collision with root package name */
    private int f9499z;

    public c() {
    }

    public final boolean a() {
        return this.f9474a;
    }

    public final int b() {
        return this.f9491r;
    }

    public final String c() {
        return this.f9490q;
    }

    @NonNull
    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final String d() {
        return this.f9489p;
    }

    public final List<CampaignEx> e() {
        return this.f9480g;
    }

    public final String f() {
        return this.f9479f;
    }

    public final CampaignEx g() {
        return this.f9472B;
    }

    public final List<CampaignEx> h() {
        return this.f9473C;
    }

    public final String i() {
        Map map;
        if (!TextUtils.isEmpty(this.f9481h)) {
            return this.f9481h;
        }
        try {
            if (TextUtils.isEmpty(this.f9481h)) {
                String str = this.f9479f + this.f9490q;
                Map<String, Map<String, String>> map2 = this.f9475b;
                if (map2 != null && map2.containsKey(str) && (map = this.f9475b.get(str)) != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                    this.f9481h = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return this.f9481h;
    }

    public final int j() {
        return this.f9482i;
    }

    public final String k() {
        return this.f9484k;
    }

    public final String l() {
        return this.f9485l;
    }

    public final String m() {
        return this.f9487n;
    }

    public final int n() {
        return this.f9492s;
    }

    public final b o() {
        return this.f9478e;
    }

    public final Map<String, Map<String, String>> p() {
        return this.f9475b;
    }

    public final Map<String, Map<String, String>> q() {
        return this.f9476c;
    }

    public final boolean r() {
        return this.f9494u;
    }

    public final boolean s() {
        return this.f9495v;
    }

    public final String t() {
        return this.f9486m;
    }

    public final void a(boolean z4) {
        this.f9493t = z4;
    }

    public final void b(String str) {
        this.f9489p = str;
    }

    public final void c(String str) {
        this.f9479f = str;
    }

    public final void d(String str) {
        this.f9481h = str;
    }

    public final void e(String str) {
        this.f9483j = str;
    }

    public final void f(String str) {
        this.f9484k = str;
    }

    public final void g(String str) {
        this.f9485l = str;
    }

    public final void h(String str) {
        this.f9487n = str;
    }

    public final Map<String, String> j(String str) {
        int i5;
        String str2;
        b bVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = new e();
        try {
            this.f9490q = str;
            eVar.a(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(i())) {
                eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, i());
            }
            int i6 = this.f9482i;
            if (i6 != 0) {
                eVar.a("adtp", Integer.valueOf(i6));
            }
            if (!TextUtils.isEmpty(this.f9488o)) {
                eVar.a(CampaignEx.JSON_KEY_HB, this.f9488o);
            }
            if (!TextUtils.isEmpty(this.f9483j)) {
                eVar.a("bid_tk", this.f9483j);
            }
            if (!TextUtils.isEmpty(str)) {
                eVar.a("key", str);
            }
            if (Arrays.asList(b.f9459a).contains(str)) {
                eVar.a("from_cache", this.f9493t ? "1" : "2");
            }
            if ("2000047".contains(str)) {
                b bVar2 = this.f9478e;
                if (bVar2 != null) {
                    eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(bVar2.e()));
                    eVar.a("reason", bVar2.b());
                    if (!TextUtils.isEmpty(bVar2.h())) {
                        eVar.a("reason_d", bVar2.h());
                        eVar.a("type_d", Integer.valueOf(bVar2.g()));
                    }
                }
            }
            if ("2000048".contains(str) && (bVar = this.f9478e) != null && !TextUtils.isEmpty(bVar.h())) {
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(bVar.g()));
                eVar.a("reason", bVar.h());
            }
            if (this.f9482i == 296) {
                eVar.a("auto_load", this.f9489p);
                eVar.a("auto_refresh", Integer.valueOf(this.f9497x));
                eVar.a("auto_refresh_interval", Integer.valueOf(this.f9498y));
                eVar.a("content_type", Integer.valueOf(this.f9499z));
                eVar.a("temp_display_type", Integer.valueOf(this.f9471A));
            }
            if ("2000126".equals(this.f9490q)) {
                String str3 = this.f9483j;
                g a5 = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                if (TextUtils.isEmpty(str3)) {
                    i5 = a5.as();
                } else {
                    i5 = a5.I();
                }
                String a6 = d.f().a(str3, i5);
                if (TextUtils.isEmpty(a6)) {
                    str2 = "";
                } else {
                    str2 = aq.a(a6);
                }
                eVar.a("dns_ty", Integer.valueOf(e.a().a(str2)));
                eVar.a("dns_hs", str2);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return eVar.a();
    }

    public final void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = this.f9479f + str;
                Map<String, Map<String, String>> map = this.f9475b;
                if (map != null && map.containsKey(str2)) {
                    this.f9475b.remove(str2);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final long l(String str) {
        Map<String, Long> map;
        try {
            if (!TextUtils.isEmpty(str) && (map = this.f9477d) != null && map.containsKey(str)) {
                Long l5 = this.f9477d.get(str);
                return System.currentTimeMillis() - (l5 != null ? l5.longValue() : 0);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return 0;
    }

    public final void m(String str) {
        if (this.f9477d != null && !TextUtils.isEmpty(str)) {
            this.f9477d.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void n(String str) {
        this.f9486m = str;
    }

    public final void a(int i5) {
        this.f9491r = i5;
    }

    public final void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    if (!this.f9473C.isEmpty()) {
                        this.f9473C.clear();
                    }
                    this.f9473C.addAll(list);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void c(int i5) {
        this.f9492s = i5;
    }

    public final void d(boolean z4) {
        this.f9496w = z4;
    }

    public final void e(int i5) {
        this.f9498y = i5;
    }

    public final void f(int i5) {
        this.f9499z = i5;
    }

    public final void g(int i5) {
        this.f9471A = i5;
    }

    public final void a(String str) {
        this.f9490q = str;
    }

    public final void c(boolean z4) {
        this.f9495v = z4;
    }

    public final void d(int i5) {
        this.f9497x = i5;
    }

    public final void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    if (!this.f9480g.isEmpty()) {
                        this.f9480g.clear();
                    }
                    this.f9480g.addAll(list);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void b(int i5) {
        this.f9482i = i5;
    }

    public final void b(boolean z4) {
        this.f9494u = z4;
    }

    public final void a(CampaignEx campaignEx) {
        this.f9472B = campaignEx;
        if (campaignEx != null) {
            try {
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f9473C;
                int i5 = 0;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    int i6 = 0;
                    while (true) {
                        if (i6 < this.f9473C.size()) {
                            if (this.f9473C.get(i6) != null && this.f9473C.get(i6).getId().equals(campaignEx.getId())) {
                                this.f9473C.set(i6, campaignEx);
                                break;
                            }
                            i6++;
                        } else {
                            break;
                        }
                    }
                }
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.f9480g;
                if (copyOnWriteArrayList2 != null && !copyOnWriteArrayList2.isEmpty()) {
                    while (i5 < this.f9480g.size()) {
                        if (this.f9480g.get(i5) == null || !this.f9480g.get(i5).getId().equals(campaignEx.getId())) {
                            i5++;
                        } else {
                            this.f9480g.set(i5, campaignEx);
                            return;
                        }
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public c(boolean z4) {
        this.f9474a = z4;
    }

    public final void i(String str) {
        this.f9488o = str;
    }

    public final void a(String str, e eVar) {
        Map map;
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                String str2 = this.f9479f + str;
                Map<String, Map<String, String>> map2 = this.f9475b;
                if (map2 == null) {
                    return;
                }
                if (!map2.containsKey(str2) || (map = this.f9475b.get(str2)) == null) {
                    this.f9475b.put(str2, eVar.a());
                } else {
                    map.putAll(eVar.a());
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void a(String str, e eVar, int i5) {
        Map map;
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                String str2 = this.f9479f + "_" + i5 + "_" + str;
                Map<String, Map<String, String>> map2 = this.f9476c;
                if (map2 == null) {
                    return;
                }
                if (!map2.containsKey(str2) || (map = this.f9476c.get(str2)) == null) {
                    this.f9476c.put(str2, eVar.a());
                } else {
                    map.putAll(eVar.a());
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void a(b bVar) {
        this.f9478e = bVar;
    }
}
