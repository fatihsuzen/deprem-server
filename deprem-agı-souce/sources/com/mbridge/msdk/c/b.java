package com.mbridge.msdk.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f7880a = 1500;

    /* renamed from: A  reason: collision with root package name */
    private String f7881A = "";

    /* renamed from: B  reason: collision with root package name */
    private String f7882B = "";

    /* renamed from: C  reason: collision with root package name */
    private String f7883C = "";

    /* renamed from: D  reason: collision with root package name */
    private int f7884D = 120;

    /* renamed from: E  reason: collision with root package name */
    private String f7885E = d.f().f9373h;

    /* renamed from: F  reason: collision with root package name */
    private String f7886F = d.f().f9377l;

    /* renamed from: G  reason: collision with root package name */
    private long f7887G;

    /* renamed from: H  reason: collision with root package name */
    private int f7888H = f7880a;

    /* renamed from: I  reason: collision with root package name */
    private ArrayList<Integer> f7889I;

    /* renamed from: J  reason: collision with root package name */
    private d f7890J;

    /* renamed from: K  reason: collision with root package name */
    private C0079b f7891K;

    /* renamed from: L  reason: collision with root package name */
    private int f7892L = 0;

    /* renamed from: M  reason: collision with root package name */
    private long f7893M = 86400;

    /* renamed from: N  reason: collision with root package name */
    private int f7894N = 0;

    /* renamed from: O  reason: collision with root package name */
    private int f7895O = 3;

    /* renamed from: P  reason: collision with root package name */
    private HashMap<String, String> f7896P;

    /* renamed from: Q  reason: collision with root package name */
    private String f7897Q;

    /* renamed from: R  reason: collision with root package name */
    private boolean f7898R = true;

    /* renamed from: S  reason: collision with root package name */
    private int f7899S = 0;

    /* renamed from: T  reason: collision with root package name */
    private boolean f7900T = false;

    /* renamed from: U  reason: collision with root package name */
    private boolean f7901U = false;

    /* renamed from: V  reason: collision with root package name */
    private int f7902V;

    /* renamed from: W  reason: collision with root package name */
    private int f7903W = 0;

    /* renamed from: X  reason: collision with root package name */
    private int f7904X = 0;

    /* renamed from: Y  reason: collision with root package name */
    private String f7905Y;

    /* renamed from: Z  reason: collision with root package name */
    private Map<String, String> f7906Z;
    private int aA = 3;
    private int aB = 0;
    private int aC = 10;
    private int aD = 600;
    private boolean aE;
    private int aF = 0;
    private JSONArray aG;
    private JSONObject aH;
    private String aI = "";
    private long aJ;
    private int aK = 8000;
    private int aL = 1;
    private long aM = 10;
    private int aN = 3;
    private long aO;
    private boolean aP;
    private int aQ = 1;
    private int aR = 1;
    private int aS = 1;
    private int aT = 1;
    private String aU = "";
    private String aV;
    private int aW = 1300;
    private int aX = 0;
    private int aY = 0;
    private long aZ = 3600;
    private String aa = BuildConfig.VERSION_NAME;
    private int ab = 30;
    private int ac = 9377;
    private int ad = 0;
    private int ae = 5;
    private int af = 1;
    private int ag = 8000;
    private String ah = "";
    private int ai;
    private int aj = 10;
    private int ak = 120;
    private String al;
    private String am;
    private String an = "";
    private String ao = "";
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private String at = "";
    private String au = "";
    private long av;
    private long aw;
    private List<Integer> ax = new ArrayList();
    private int ay = 3;
    private int az = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7907b = false;
    private String ba = "";
    private int bb;
    private String bc;

    /* renamed from: c  reason: collision with root package name */
    private JSONArray f7908c = new JSONArray();

    /* renamed from: d  reason: collision with root package name */
    private JSONArray f7909d = new JSONArray();

    /* renamed from: e  reason: collision with root package name */
    private String f7910e = "";

    /* renamed from: f  reason: collision with root package name */
    private int f7911f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f7912g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f7913h = 2;

    /* renamed from: i  reason: collision with root package name */
    private int f7914i = 0;

    /* renamed from: j  reason: collision with root package name */
    private String f7915j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f7916k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f7917l = "";

    /* renamed from: m  reason: collision with root package name */
    private int f7918m;

    /* renamed from: n  reason: collision with root package name */
    private int f7919n = 0;

    /* renamed from: o  reason: collision with root package name */
    private List<com.mbridge.msdk.foundation.entity.a> f7920o;

    /* renamed from: p  reason: collision with root package name */
    private int f7921p = 0;

    /* renamed from: q  reason: collision with root package name */
    private long f7922q;

    /* renamed from: r  reason: collision with root package name */
    private a f7923r;

    /* renamed from: s  reason: collision with root package name */
    private String f7924s;

    /* renamed from: t  reason: collision with root package name */
    private Map<String, a> f7925t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f7926u;

    /* renamed from: v  reason: collision with root package name */
    private int f7927v;

    /* renamed from: w  reason: collision with root package name */
    private int f7928w = 1;

    /* renamed from: x  reason: collision with root package name */
    private boolean f7929x = false;

    /* renamed from: y  reason: collision with root package name */
    private String f7930y = "";

    /* renamed from: z  reason: collision with root package name */
    private String f7931z = "";

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private List<String> f7932a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f7933b;

        /* renamed from: c  reason: collision with root package name */
        private List<String> f7934c;

        /* renamed from: d  reason: collision with root package name */
        private List<String> f7935d;

        public final List<String> a() {
            return this.f7932a;
        }

        public final List<String> b() {
            return this.f7933b;
        }

        public final List<String> c() {
            return this.f7934c;
        }

        public final List<String> d() {
            return this.f7935d;
        }

        public final void a(JSONObject jSONObject) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("x");
                if (optJSONArray != null) {
                    this.f7934c = s.a(optJSONArray);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("y");
                if (optJSONArray2 != null) {
                    this.f7935d = s.a(optJSONArray2);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("width");
                if (optJSONArray3 != null) {
                    this.f7933b = s.a(optJSONArray3);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("height");
                if (optJSONArray4 != null) {
                    this.f7932a = s.a(optJSONArray4);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private static Map<String, a> e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    aVar.a(optJSONObject);
                }
                hashMap.put(next, aVar);
            }
            return hashMap;
        } catch (JSONException e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return null;
        } catch (Exception e6) {
            if (MBridgeConstans.DEBUG) {
                e6.printStackTrace();
            }
            return null;
        }
    }

    public final int A() {
        return this.f7884D;
    }

    public final String B() {
        return this.f7885E;
    }

    public final String C() {
        return this.f7886F;
    }

    public final long D() {
        return this.f7887G;
    }

    public final ArrayList<Integer> E() {
        return this.f7889I;
    }

    public final d F() {
        return this.f7890J;
    }

    public final C0079b G() {
        return this.f7891K;
    }

    public final long H() {
        return this.f7893M;
    }

    public final int I() {
        return this.f7895O;
    }

    public final HashMap<String, String> J() {
        return this.f7896P;
    }

    public final int K() {
        return this.f7899S;
    }

    public final int L() {
        return this.f7902V;
    }

    public final int M() {
        return this.f7903W;
    }

    public final JSONArray N() {
        return this.f7908c;
    }

    public final JSONArray O() {
        return this.f7909d;
    }

    public final String P() {
        return this.aa;
    }

    public final int Q() {
        return this.af;
    }

    public final int R() {
        return this.ag;
    }

    public final int S() {
        return this.ai;
    }

    public final int T() {
        return this.ak;
    }

    public final String U() {
        return this.al;
    }

    public final String V() {
        return this.am;
    }

    public final String W() {
        return this.an;
    }

    public final String X() {
        return this.ao;
    }

    public final int Y() {
        return this.ap;
    }

    public final int Z() {
        return this.aq;
    }

    public final int a() {
        return this.bb;
    }

    public final int aA() {
        return this.aW;
    }

    public final int aB() {
        return this.aX;
    }

    public final int aC() {
        return this.aY;
    }

    public final boolean aD() {
        return this.f7898R;
    }

    public final boolean aE() {
        return this.f7926u;
    }

    public final boolean aF() {
        return this.f7929x;
    }

    public final boolean aG() {
        return this.f7900T;
    }

    public final boolean aH() {
        return this.f7907b;
    }

    public final boolean aI() {
        return this.f7901U;
    }

    public final boolean aJ() {
        return this.aE;
    }

    public final boolean aK() {
        return this.aP;
    }

    public final void aL() {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(this.f7883C) || TextUtils.isEmpty(this.f7881A) || TextUtils.isEmpty(this.f7882B) || TextUtils.isEmpty(this.f7931z)) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.f7883C = "Confirm to close? ";
                this.f7881A = "You will not be rewarded after closing the window";
                this.f7882B = "Close it";
                this.f7931z = "Continue";
            } else {
                this.f7883C = "确认关闭？";
                this.f7881A = "关闭后您将不会获得任何奖励噢~ ";
                this.f7882B = "确认关闭";
                this.f7931z = "继续观看";
            }
        }
        if (!TextUtils.isEmpty(this.f7883C) && !TextUtils.isEmpty(this.f7881A) && !TextUtils.isEmpty(this.f7882B) && !TextUtils.isEmpty(this.f7930y)) {
            return;
        }
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.f7883C = "Confirm to close? ";
            this.f7881A = "You will not be rewarded after closing the window";
            this.f7882B = "Close it";
            this.f7930y = "Continue";
            return;
        }
        this.f7883C = "确认关闭？";
        this.f7881A = "关闭后您将不会获得任何奖励噢~ ";
        this.f7882B = "确认关闭";
        this.f7930y = "继续试玩";
    }

    public final int aa() {
        return this.ar;
    }

    public final int ab() {
        return this.as;
    }

    public final long ac() {
        return this.av;
    }

    public final long ad() {
        if (this.aw <= 0) {
            this.aw = 7200;
        }
        return this.aw;
    }

    public final int ae() {
        return this.ay;
    }

    public final int af() {
        return this.az;
    }

    public final int ag() {
        return this.aA;
    }

    public final int ah() {
        return this.aB;
    }

    public final int ai() {
        return this.aC;
    }

    public final int aj() {
        return this.aD;
    }

    public final int ak() {
        return this.aF;
    }

    public final JSONArray al() {
        return this.aG;
    }

    public final JSONObject am() {
        return this.aH;
    }

    public final String an() {
        return this.aI;
    }

    public final long ao() {
        return this.aJ;
    }

    public final int ap() {
        return this.aK;
    }

    public final int aq() {
        return this.aL;
    }

    public final long ar() {
        return this.aM * 1000;
    }

    public final int as() {
        return this.aN;
    }

    public final long at() {
        return this.aO;
    }

    public final int au() {
        return this.aQ;
    }

    public final int av() {
        return this.aR;
    }

    public final int aw() {
        return this.aS;
    }

    public final int ax() {
        return this.aT;
    }

    public final String ay() {
        return this.aU;
    }

    public final String az() {
        return this.aV;
    }

    public final String b() {
        return this.ba;
    }

    public final long c() {
        return this.aZ;
    }

    public final String d() {
        return this.f7910e;
    }

    public final int f() {
        return this.f7912g;
    }

    public final int g() {
        return this.f7913h;
    }

    public final int h() {
        return this.f7914i;
    }

    public final String i() {
        return this.f7915j;
    }

    public final String j() {
        return this.f7916k;
    }

    public final String k() {
        return this.f7917l;
    }

    public final int l() {
        return this.f7918m;
    }

    public final int m() {
        return this.f7919n;
    }

    public final List<com.mbridge.msdk.foundation.entity.a> n() {
        return this.f7920o;
    }

    public final int o() {
        return this.f7921p;
    }

    public final long p() {
        return this.f7922q;
    }

    public final a q() {
        return this.f7923r;
    }

    public final String r() {
        return this.f7924s;
    }

    public final Map<String, a> s() {
        return this.f7925t;
    }

    public final int t() {
        return this.f7927v;
    }

    public String toString() {
        return " cfc=" + this.f7927v + " getpf=" + this.f7893M + " rurl=" + this.aE;
    }

    public final int u() {
        return this.f7928w;
    }

    public final String v() {
        return this.f7930y;
    }

    public final String w() {
        return this.f7931z;
    }

    public final String x() {
        return this.f7881A;
    }

    public final String y() {
        return this.f7882B;
    }

    public final String z() {
        return this.f7883C;
    }

    public final void a(int i5) {
        this.bb = i5;
    }

    public final void b(int i5) {
        this.f7911f = i5;
    }

    public final void c(int i5) {
        this.f7912g = i5;
    }

    public final void d(int i5) {
        this.f7913h = i5;
    }

    public final void f(int i5) {
        this.f7918m = i5;
    }

    public final void g(int i5) {
        this.f7919n = i5;
    }

    public final void h(int i5) {
        this.f7921p = i5;
    }

    public final void i(int i5) {
        this.f7927v = i5;
    }

    public final void j(int i5) {
        this.f7928w = i5;
    }

    public final void k(int i5) {
        this.f7884D = i5;
    }

    public final void l(int i5) {
        this.f7895O = i5;
    }

    public final void m(int i5) {
        this.f7899S = i5;
    }

    public final void n(int i5) {
        this.f7902V = i5;
    }

    public final void o(int i5) {
        this.f7903W = i5;
    }

    public final void p(int i5) {
        if (i5 > 0) {
            this.aj = i5;
        }
    }

    public final void q(int i5) {
        this.ai = i5;
    }

    public final void r(int i5) {
        this.ak = i5;
    }

    public final void s(int i5) {
        this.aF = i5;
    }

    public final void t(int i5) {
        this.aL = i5;
    }

    public final void u(int i5) {
        this.aN = i5;
    }

    public final void v(int i5) {
        this.aQ = i5;
    }

    public final void w(int i5) {
        this.aR = i5;
    }

    public final void x(int i5) {
        this.aS = i5;
    }

    public final void y(int i5) {
        this.aT = i5;
    }

    public final boolean z(int i5) {
        return this.ax.contains(Integer.valueOf(i5));
    }

    public final void a(long j5) {
        this.aZ = j5;
    }

    public final void b(long j5) {
        this.f7922q = j5;
    }

    public final void c(String str) {
        this.an = str;
    }

    public final void d(String str) {
        this.ao = str;
    }

    public final void f(long j5) {
        this.aM = j5;
    }

    public static String a(Context context, String str) {
        try {
            g b5 = h.a().b(c.m().k());
            if (b5 == null) {
                return "";
            }
            if (b5.f7906Z == null) {
                return "";
            }
            String host = Uri.parse(str).getHost();
            for (Map.Entry<String, String> key : b5.f7906Z.entrySet()) {
                String str2 = (String) key.getKey();
                if (!TextUtils.isEmpty(host) && host.contains(str2)) {
                    String str3 = b5.f7906Z.get(str2);
                    if (TextUtils.isEmpty(str3)) {
                        return "";
                    }
                    return str3.replace("{gaid}", f.c());
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void b(String str) {
        this.am = str;
    }

    public final void c(long j5) {
        this.av = j5;
    }

    public final void d(long j5) {
        this.aw = j5;
    }

    public final void f(boolean z4) {
        this.aP = z4;
    }

    public final void b(boolean z4) {
        this.f7929x = z4;
    }

    public final void c(boolean z4) {
        this.f7900T = z4;
    }

    public final void d(boolean z4) {
        this.f7907b = z4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v9, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v18, resolved type: char} */
    /* JADX WARNING: type inference failed for: r15v17 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:212|(3:216|217|218)|220|221|(3:225|226|227)) */
    /* JADX WARNING: Code restructure failed: missing block: B:180:?, code lost:
        r9.f7929x = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
        r9.f7900T = true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:179:0x055e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:190:0x0598 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:199:0x05a8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:220:0x05ff */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x037c A[Catch:{ Exception -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03d8 A[Catch:{ Exception -> 0x045a }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03ec A[Catch:{ Exception -> 0x045a }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0480 A[Catch:{ Exception -> 0x0495 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0482 A[Catch:{ Exception -> 0x0495 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x048b A[Catch:{ Exception -> 0x0495 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x048d A[Catch:{ Exception -> 0x0495 }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x04d5 A[Catch:{ Exception -> 0x0538 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04db A[Catch:{ Exception -> 0x0538 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x04e1 A[Catch:{ Exception -> 0x0538 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x04e7 A[Catch:{ Exception -> 0x0538 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x04f3 A[Catch:{ Exception -> 0x0538 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0558 A[Catch:{ Exception -> 0x055e }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x055a A[Catch:{ Exception -> 0x055e }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x056e A[Catch:{ Exception -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x05a2 A[Catch:{ Exception -> 0x05a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x05a4 A[Catch:{ Exception -> 0x05a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x05cc A[SYNTHETIC, Splitter:B:209:0x05cc] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x062f A[SYNTHETIC, Splitter:B:231:0x062f] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x06be A[Catch:{ Exception -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x06d4 A[Catch:{ Exception -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x023d A[Catch:{ Exception -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0263 A[Catch:{ Exception -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0268 A[Catch:{ Exception -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02e4 A[Catch:{ Exception -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02fa A[Catch:{ Exception -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x030f A[SYNTHETIC, Splitter:B:78:0x030f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.c.g a(org.json.JSONObject r19) {
        /*
            r1 = r19
            java.lang.String r2 = "omsdkjs_h5_url"
            java.lang.String r3 = "omsdkjs_url"
            java.lang.String r0 = "plctb"
            java.lang.String r4 = "pcrn"
            java.lang.String r5 = "plct"
            java.lang.String r6 = "H+tU+FeXHM=="
            java.lang.String r7 = ""
            if (r1 == 0) goto L_0x06e6
            com.mbridge.msdk.c.g r9 = new com.mbridge.msdk.c.g     // Catch:{ Exception -> 0x06e0 }
            r9.<init>()     // Catch:{ Exception -> 0x06e0 }
            r9.aH = r1     // Catch:{ Exception -> 0x0249 }
            java.lang.String r10 = "cc"
            java.lang.String r10 = r1.optString(r10)     // Catch:{ Exception -> 0x0249 }
            r9.f7924s = r10     // Catch:{ Exception -> 0x0249 }
            java.lang.String r10 = "mv_wildcard"
            java.lang.String r11 = "<mvpackage>mbridge</mvpackage>"
            java.lang.String r10 = r1.optString(r10, r11)     // Catch:{ Exception -> 0x0249 }
            r9.am = r10     // Catch:{ Exception -> 0x0249 }
            java.lang.String r10 = "cfc"
            int r10 = r1.optInt(r10)     // Catch:{ Exception -> 0x0249 }
            r9.f7927v = r10     // Catch:{ Exception -> 0x0249 }
            java.lang.String r10 = "getpf"
            long r10 = r1.optLong(r10)     // Catch:{ Exception -> 0x0249 }
            r9.f7893M = r10     // Catch:{ Exception -> 0x0249 }
            java.lang.String r10 = "current_time"
            long r10 = r1.optLong(r10)     // Catch:{ Exception -> 0x0249 }
            r9.f7887G = r10     // Catch:{ Exception -> 0x0249 }
            java.lang.String r10 = "cfb"
            boolean r10 = r1.optBoolean(r10)     // Catch:{ Exception -> 0x0249 }
            r9.f7926u = r10     // Catch:{ Exception -> 0x0249 }
            java.lang.String r10 = "awct"
            long r10 = r1.optLong(r10)     // Catch:{ Exception -> 0x0249 }
            r9.f7922q = r10     // Catch:{ Exception -> 0x0249 }
            long r10 = r1.optLong(r5)     // Catch:{ Exception -> 0x0249 }
            r12 = 0
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 != 0) goto L_0x0060
            r10 = 3600(0xe10, double:1.7786E-320)
            goto L_0x0064
        L_0x0060:
            long r10 = r1.optLong(r5)     // Catch:{ Exception -> 0x0249 }
        L_0x0064:
            r9.av = r10     // Catch:{ Exception -> 0x0249 }
            java.lang.String r5 = "rurl"
            boolean r5 = r1.optBoolean(r5)     // Catch:{ Exception -> 0x0249 }
            r9.aE = r5     // Catch:{ Exception -> 0x0249 }
            java.lang.String r5 = "uct"
            long r10 = r1.optLong(r5)     // Catch:{ Exception -> 0x0249 }
            r9.aO = r10     // Catch:{ Exception -> 0x0249 }
            java.lang.String r5 = "ujds"
            boolean r5 = r1.optBoolean(r5)     // Catch:{ Exception -> 0x0249 }
            r9.aP = r5     // Catch:{ Exception -> 0x0249 }
            java.lang.String r5 = "n2"
            int r5 = r1.optInt(r5)     // Catch:{ Exception -> 0x0249 }
            r9.ar = r5     // Catch:{ Exception -> 0x0249 }
            java.lang.String r5 = "n3"
            int r5 = r1.optInt(r5)     // Catch:{ Exception -> 0x0249 }
            r9.as = r5     // Catch:{ Exception -> 0x0249 }
            java.lang.String r5 = "is_startup_crashsystem"
            r10 = 1
            int r5 = r1.optInt(r5, r10)     // Catch:{ Exception -> 0x0249 }
            r9.f7902V = r5     // Catch:{ Exception -> 0x0249 }
            int r5 = r1.optInt(r4)     // Catch:{ Exception -> 0x0249 }
            r9.aq = r5     // Catch:{ Exception -> 0x0249 }
            long r15 = r1.optLong(r0)     // Catch:{ Exception -> 0x0249 }
            int r5 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x00ab
            r15 = 7200(0x1c20, double:3.5573E-320)
        L_0x00a7:
            r17 = r12
            r12 = r15
            goto L_0x00b0
        L_0x00ab:
            long r15 = r1.optLong(r0)     // Catch:{ Exception -> 0x0249 }
            goto L_0x00a7
        L_0x00b0:
            r9.aw = r12     // Catch:{ Exception -> 0x0249 }
            r0 = 100
            int r0 = r1.optInt(r4, r0)     // Catch:{ Exception -> 0x0249 }
            r9.aq = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "opent"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x0249 }
            r9.ap = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "sfct"
            r4 = 1800(0x708, double:8.893E-321)
            long r4 = r1.optLong(r0, r4)     // Catch:{ Exception -> 0x0249 }
            r9.aJ = r4     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "upgd"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x0249 }
            r9.aS = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "upsrl"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x0249 }
            r9.aT = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "updevid"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x0249 }
            r9.aR = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "sc"
            r4 = 0
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x0249 }
            r9.aF = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "up_tips"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x0249 }
            r9.aQ = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "iseu"
            r5 = -1
            int r0 = r1.optInt(r0, r5)     // Catch:{ Exception -> 0x0249 }
            r9.f7903W = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "jm_unit"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x0249 }
            r9.f7905Y = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "atf"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x014c }
            if (r0 == 0) goto L_0x0151
            int r11 = r0.length()     // Catch:{ Exception -> 0x014c }
            if (r11 <= 0) goto L_0x0151
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x014c }
            r11.<init>()     // Catch:{ Exception -> 0x014c }
            r12 = r4
        L_0x011a:
            int r13 = r0.length()     // Catch:{ Exception -> 0x014c }
            if (r12 >= r13) goto L_0x014f
            java.lang.String r13 = r0.optString(r12)     // Catch:{ Exception -> 0x014c }
            boolean r15 = com.mbridge.msdk.foundation.tools.ap.b(r13)     // Catch:{ Exception -> 0x014c }
            if (r15 == 0) goto L_0x0147
            r15 = r5
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0145 }
            r5.<init>(r13)     // Catch:{ Exception -> 0x0145 }
            com.mbridge.msdk.foundation.entity.a r13 = new com.mbridge.msdk.foundation.entity.a     // Catch:{ Exception -> 0x0145 }
            java.lang.String r8 = "adtype"
            int r8 = r5.optInt(r8)     // Catch:{ Exception -> 0x0145 }
            java.lang.String r14 = "unitid"
            java.lang.String r5 = r5.optString(r14)     // Catch:{ Exception -> 0x0145 }
            r13.<init>(r8, r5)     // Catch:{ Exception -> 0x0145 }
            r11.add(r13)     // Catch:{ Exception -> 0x0145 }
            goto L_0x0148
        L_0x0145:
            r0 = move-exception
            goto L_0x0158
        L_0x0147:
            r15 = r5
        L_0x0148:
            int r12 = r12 + 1
            r5 = r15
            goto L_0x011a
        L_0x014c:
            r0 = move-exception
            r15 = r5
            goto L_0x0158
        L_0x014f:
            r15 = r5
            goto L_0x0153
        L_0x0151:
            r15 = r5
            r11 = 0
        L_0x0153:
            if (r11 == 0) goto L_0x015b
            r9.f7920o = r11     // Catch:{ Exception -> 0x0145 }
            goto L_0x015b
        L_0x0158:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0249 }
        L_0x015b:
            java.lang.String r0 = "adct"
            r5 = 259200(0x3f480, float:3.63217E-40)
            int r0 = r1.optInt(r0, r5)     // Catch:{ Exception -> 0x0249 }
            r9.f7918m = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "confirm_title"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7883C = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "confirm_description"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7881A = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "confirm_t"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7882B = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "confirm_c_rv"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7931z = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "confirm_c_play"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7930y = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "adchoice_icon"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7915j = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "adchoice_link"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7916k = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "adchoice_size"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7917l = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "platform_logo"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.at = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "platform_name"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.au = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "cdnate_cfg"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            java.util.Map r0 = e((java.lang.String) r0)     // Catch:{ Exception -> 0x0249 }
            r9.f7925t = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "atrqt"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x0249 }
            r9.f7921p = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "iupdid"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x0249 }
            r9.f7904X = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "mcs"
            r5 = 120(0x78, float:1.68E-43)
            int r0 = r1.optInt(r0, r5)     // Catch:{ Exception -> 0x0249 }
            r9.ak = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "ab_id"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7910e = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "rid"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.aI = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "log_rate"
            java.lang.String r8 = "-1"
            java.lang.String r0 = r1.optString(r0, r8)     // Catch:{ Exception -> 0x0249 }
            r9.aa = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = r1.optString(r3, r7)     // Catch:{ Exception -> 0x0249 }
            r9.ao = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = r1.optString(r2, r7)     // Catch:{ Exception -> 0x0249 }
            r9.an = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "rty_tk_clk"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x0249 }
            r9.az = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "rty_tk_imp"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x0249 }
            r9.aB = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "rty_cnt"
            r8 = 3
            int r0 = r1.optInt(r0, r8)     // Catch:{ Exception -> 0x0249 }
            r9.aA = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "rty_to"
            r11 = 600(0x258, float:8.41E-43)
            int r0 = r1.optInt(r0, r11)     // Catch:{ Exception -> 0x0249 }
            r9.aD = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "rty_inr"
            r11 = 10
            int r0 = r1.optInt(r0, r11)     // Catch:{ Exception -> 0x0249 }
            r9.aC = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "dns"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x0249 }
            r9.bc = r0     // Catch:{ Exception -> 0x0249 }
            boolean r12 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0249 }
            if (r12 != 0) goto L_0x024d
            com.mbridge.msdk.c.e r12 = com.mbridge.msdk.c.e.a.f8008a     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0249 }
            r12.b(r0)     // Catch:{ Exception -> 0x0249 }
            goto L_0x024d
        L_0x0249:
            r0 = move-exception
            r8 = r9
            goto L_0x06e2
        L_0x024d:
            java.lang.String r0 = r1.optString(r3, r7)     // Catch:{ Exception -> 0x0249 }
            r9.ao = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = r1.optString(r2, r7)     // Catch:{ Exception -> 0x0249 }
            r9.an = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "tcto"
            long r2 = r1.optLong(r0)     // Catch:{ Exception -> 0x0249 }
            int r0 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x0268
            r2 = 10
            r9.aM = r2     // Catch:{ Exception -> 0x0249 }
            goto L_0x029c
        L_0x0268:
            r9.aM = r2     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "jt"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x0249 }
            if (r0 == 0) goto L_0x029c
            int r2 = r0.length()     // Catch:{ Exception -> 0x0249 }
            if (r2 <= 0) goto L_0x029c
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0249 }
            r2.<init>()     // Catch:{ Exception -> 0x0249 }
            r3 = r4
        L_0x027e:
            int r12 = r0.length()     // Catch:{ Exception -> 0x0249 }
            if (r3 >= r12) goto L_0x029a
            org.json.JSONObject r12 = r0.optJSONObject(r3)     // Catch:{ Exception -> 0x0249 }
            java.lang.String r13 = "domain"
            java.lang.String r13 = r12.optString(r13)     // Catch:{ Exception -> 0x0249 }
            java.lang.String r14 = "format"
            java.lang.String r12 = r12.optString(r14)     // Catch:{ Exception -> 0x0249 }
            r2.put(r13, r12)     // Catch:{ Exception -> 0x0249 }
            int r3 = r3 + 1
            goto L_0x027e
        L_0x029a:
            r9.f7906Z = r2     // Catch:{ Exception -> 0x0249 }
        L_0x029c:
            java.lang.String r0 = "mraid_js"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x0249 }
            r9.al = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "web_env_url"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x0249 }
            r9.aV = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "alrbs"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x0249 }
            r2 = 2
            if (r0 > r2) goto L_0x02b7
            if (r0 >= 0) goto L_0x02b8
        L_0x02b7:
            r0 = r4
        L_0x02b8:
            r9.f7919n = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "GDPR_area"
            boolean r0 = r1.optBoolean(r0, r4)     // Catch:{ Exception -> 0x0249 }
            r9.f7907b = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "ct"
            int r0 = r1.optInt(r0, r5)     // Catch:{ Exception -> 0x0249 }
            r9.f7884D = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "ercd"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x0249 }
            if (r0 == 0) goto L_0x0303
            int r2 = r0.length()     // Catch:{ Exception -> 0x0249 }
            if (r2 <= 0) goto L_0x0303
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0249 }
            r2.<init>()     // Catch:{ Exception -> 0x0249 }
            r3 = r4
        L_0x02de:
            int r5 = r0.length()     // Catch:{ Exception -> 0x0249 }
            if (r3 >= r5) goto L_0x02f4
            int r5 = r0.optInt(r3)     // Catch:{ Exception -> 0x0249 }
            if (r5 == 0) goto L_0x02f1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0249 }
            r2.add(r5)     // Catch:{ Exception -> 0x0249 }
        L_0x02f1:
            int r3 = r3 + 1
            goto L_0x02de
        L_0x02f4:
            int r0 = r2.size()     // Catch:{ Exception -> 0x0249 }
            if (r0 <= 0) goto L_0x0303
            java.lang.Integer r0 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x0249 }
            r2.add(r0)     // Catch:{ Exception -> 0x0249 }
            r9.f7889I = r2     // Catch:{ Exception -> 0x0249 }
        L_0x0303:
            java.lang.String r0 = "hst"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x0249 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0249 }
            if (r2 != 0) goto L_0x0367
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0353 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0353 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0353 }
            java.util.Iterator r0 = r2.keys()     // Catch:{ Exception -> 0x0353 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0353 }
            r3.<init>()     // Catch:{ Exception -> 0x0353 }
        L_0x0321:
            boolean r5 = r0.hasNext()     // Catch:{ Exception -> 0x0353 }
            if (r5 == 0) goto L_0x0355
            java.lang.Object r5 = r0.next()     // Catch:{ Exception -> 0x0353 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0353 }
            boolean r12 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0353 }
            if (r12 != 0) goto L_0x0321
            java.lang.String r12 = r2.optString(r5)     // Catch:{ Exception -> 0x0353 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0353 }
            if (r12 != 0) goto L_0x0321
            java.lang.String r12 = r2.optString(r5)     // Catch:{ Exception -> 0x0353 }
            java.lang.String r12 = com.mbridge.msdk.foundation.tools.z.a(r12)     // Catch:{ Exception -> 0x0353 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0353 }
            if (r12 != 0) goto L_0x0321
            java.lang.String r12 = r2.optString(r5)     // Catch:{ Exception -> 0x0353 }
            r3.put(r5, r12)     // Catch:{ Exception -> 0x0353 }
            goto L_0x0321
        L_0x0353:
            r0 = move-exception
            goto L_0x035e
        L_0x0355:
            int r0 = r3.size()     // Catch:{ Exception -> 0x0353 }
            if (r0 <= 0) goto L_0x0367
            r9.f7896P = r3     // Catch:{ Exception -> 0x0353 }
            goto L_0x0367
        L_0x035e:
            java.lang.String r2 = "SETTING"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0249 }
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)     // Catch:{ Exception -> 0x0249 }
        L_0x0367:
            java.lang.String r0 = "refactor_switch"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x0249 }
            if (r0 == 0) goto L_0x03ad
            int r2 = r0.length()     // Catch:{ Exception -> 0x0249 }
            if (r2 <= 0) goto L_0x03ad
            r2 = r4
        L_0x0376:
            int r3 = r0.length()     // Catch:{ Exception -> 0x0249 }
            if (r2 >= r3) goto L_0x03ad
            org.json.JSONObject r3 = r0.getJSONObject(r2)     // Catch:{ Exception -> 0x0249 }
            java.util.Iterator r5 = r3.keys()     // Catch:{ Exception -> 0x0249 }
        L_0x0384:
            boolean r12 = r5.hasNext()     // Catch:{ Exception -> 0x0249 }
            if (r12 == 0) goto L_0x03aa
            java.lang.Object r12 = r5.next()     // Catch:{ Exception -> 0x0249 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0249 }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0249 }
            if (r13 != 0) goto L_0x0384
            boolean r13 = r3.getBoolean(r12)     // Catch:{ Exception -> 0x0249 }
            if (r13 == 0) goto L_0x0384
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ Exception -> 0x0249 }
            java.util.List<java.lang.Integer> r13 = r9.ax     // Catch:{ Exception -> 0x0249 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0249 }
            r13.add(r12)     // Catch:{ Exception -> 0x0249 }
            goto L_0x0384
        L_0x03aa:
            int r2 = r2 + 1
            goto L_0x0376
        L_0x03ad:
            java.lang.String r0 = "lqcnt"
            r2 = 30
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x045a }
            java.lang.String r2 = "lqto"
            r3 = 5
            int r2 = r1.optInt(r2, r3)     // Catch:{ Exception -> 0x045a }
            java.lang.String r3 = "lqswt"
            int r3 = r1.optInt(r3, r4)     // Catch:{ Exception -> 0x045a }
            java.lang.String r5 = "lqtype"
            int r5 = r1.optInt(r5, r10)     // Catch:{ Exception -> 0x045a }
            r9.ae = r2     // Catch:{ Exception -> 0x045a }
            r9.ab = r0     // Catch:{ Exception -> 0x045a }
            r9.ad = r3     // Catch:{ Exception -> 0x045a }
            r9.af = r5     // Catch:{ Exception -> 0x045a }
            java.lang.String r0 = "lg_bl"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x045a }
            if (r0 != 0) goto L_0x03e2
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x045a }
            r0.<init>()     // Catch:{ Exception -> 0x045a }
            java.lang.String r2 = "2000088"
            r0.put(r2)     // Catch:{ Exception -> 0x045a }
        L_0x03e2:
            r9.f7908c = r0     // Catch:{ Exception -> 0x045a }
            java.lang.String r0 = "lg_wl"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x045a }
            if (r0 != 0) goto L_0x0405
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x045a }
            r0.<init>()     // Catch:{ Exception -> 0x045a }
            java.lang.String r2 = "2000041"
            r0.put(r2)     // Catch:{ Exception -> 0x045a }
            java.lang.String r2 = "2000042"
            r0.put(r2)     // Catch:{ Exception -> 0x045a }
            java.lang.String r2 = "2000032"
            r0.put(r2)     // Catch:{ Exception -> 0x045a }
            java.lang.String r2 = "2000079"
            r0.put(r2)     // Catch:{ Exception -> 0x045a }
        L_0x0405:
            r9.f7909d = r0     // Catch:{ Exception -> 0x045a }
            java.lang.String r0 = "lg_wl_rt"
            int r0 = r1.optInt(r0)     // Catch:{ Exception -> 0x045a }
            r9.aX = r0     // Catch:{ Exception -> 0x045a }
            java.lang.String r0 = "srml"
            r2 = 8000(0x1f40, float:1.121E-41)
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x045a }
            r9.aK = r0     // Catch:{ Exception -> 0x045a }
            java.lang.String r0 = "lrml"
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x045a }
            r9.ag = r0     // Catch:{ Exception -> 0x045a }
            java.lang.String r0 = "wgl_d_ms"
            r2 = 1300(0x514, float:1.822E-42)
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x045a }
            r9.aW = r0     // Catch:{ Exception -> 0x045a }
            java.lang.String r0 = "dp_ct"
            int r2 = f7880a     // Catch:{ Exception -> 0x045a }
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x045a }
            r9.f7888H = r0     // Catch:{ Exception -> 0x045a }
            com.mbridge.msdk.click.b.a.f8100c = r0     // Catch:{ Exception -> 0x045a }
            java.lang.String r0 = "lqpt"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x045a }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x045a }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x045a }
            if (r0 <= 0) goto L_0x045a
            r2 = 65535(0xffff, float:9.1834E-41)
            if (r0 >= r2) goto L_0x045a
            r9.ac = r0     // Catch:{ Exception -> 0x045a }
            com.mbridge.msdk.foundation.same.net.e.d r2 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x045a }
            r2.f9378m = r0     // Catch:{ Exception -> 0x045a }
            com.mbridge.msdk.foundation.same.net.e.d r2 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x045a }
            r2.f9381p = r0     // Catch:{ Exception -> 0x045a }
        L_0x045a:
            java.lang.String r0 = "wvddt"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x0249 }
            r9.aY = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "hst_st"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7885E = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "hst_st_t"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.f7886F = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "l"
            int r0 = r1.optInt(r0, r8)     // Catch:{ Exception -> 0x0495 }
            java.lang.String r2 = "k"
            int r2 = r1.optInt(r2, r4)     // Catch:{ Exception -> 0x0495 }
            if (r2 != r10) goto L_0x0482
            r2 = r10
            goto L_0x0483
        L_0x0482:
            r2 = r4
        L_0x0483:
            java.lang.String r3 = "m"
            int r3 = r1.optInt(r3, r10)     // Catch:{ Exception -> 0x0495 }
            if (r3 != r10) goto L_0x048d
            r3 = r10
            goto L_0x048e
        L_0x048d:
            r3 = r4
        L_0x048e:
            r9.ay = r0     // Catch:{ Exception -> 0x0495 }
            r9.f7901U = r2     // Catch:{ Exception -> 0x0495 }
            r9.f7898R = r3     // Catch:{ Exception -> 0x0495 }
            goto L_0x049f
        L_0x0495:
            r0 = move-exception
            java.lang.String r2 = "Setting"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0249 }
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)     // Catch:{ Exception -> 0x0249 }
        L_0x049f:
            java.lang.String r0 = "fbk_swt"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x0249 }
            r9.f7892L = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "fbk"
            org.json.JSONObject r0 = r1.optJSONObject(r0)     // Catch:{ Exception -> 0x0249 }
            com.mbridge.msdk.c.b$b r0 = com.mbridge.msdk.c.b.C0079b.a(r0)     // Catch:{ Exception -> 0x0249 }
            r9.f7891K = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "ad_connection_timeout"
            int r2 = com.mbridge.msdk.foundation.same.a.f9196o     // Catch:{ Exception -> 0x0538 }
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x0538 }
            java.lang.String r2 = "ad_read_timeout"
            int r3 = com.mbridge.msdk.foundation.same.a.f9198q     // Catch:{ Exception -> 0x0538 }
            int r2 = r1.optInt(r2, r3)     // Catch:{ Exception -> 0x0538 }
            java.lang.String r3 = "ad_write_timeout"
            int r5 = com.mbridge.msdk.foundation.same.a.f9200s     // Catch:{ Exception -> 0x0538 }
            int r3 = r1.optInt(r3, r5)     // Catch:{ Exception -> 0x0538 }
            java.lang.String r5 = "ad_retry_count"
            int r12 = com.mbridge.msdk.foundation.same.a.f9199r     // Catch:{ Exception -> 0x0538 }
            int r5 = r1.optInt(r5, r12)     // Catch:{ Exception -> 0x0538 }
            if (r0 > 0) goto L_0x04d7
            int r0 = com.mbridge.msdk.foundation.same.a.f9196o     // Catch:{ Exception -> 0x0538 }
        L_0x04d7:
            r9.f7911f = r0     // Catch:{ Exception -> 0x0538 }
            if (r2 > 0) goto L_0x04dd
            int r2 = com.mbridge.msdk.foundation.same.a.f9198q     // Catch:{ Exception -> 0x0538 }
        L_0x04dd:
            r9.f7912g = r2     // Catch:{ Exception -> 0x0538 }
            if (r3 > 0) goto L_0x04e3
            int r3 = com.mbridge.msdk.foundation.same.a.f9200s     // Catch:{ Exception -> 0x0538 }
        L_0x04e3:
            r9.f7914i = r3     // Catch:{ Exception -> 0x0538 }
            if (r5 >= 0) goto L_0x04e9
            int r5 = com.mbridge.msdk.foundation.same.a.f9199r     // Catch:{ Exception -> 0x0538 }
        L_0x04e9:
            r9.f7913h = r5     // Catch:{ Exception -> 0x0538 }
            java.lang.String r0 = "max_download_task_size"
            int r0 = r1.optInt(r0, r11)     // Catch:{ Exception -> 0x0538 }
            if (r0 > 0) goto L_0x04f4
            r0 = r11
        L_0x04f4:
            r9.ai = r0     // Catch:{ Exception -> 0x0538 }
            java.lang.String r0 = "max_bitmap_cache_size"
            int r0 = r1.optInt(r0, r11)     // Catch:{ Exception -> 0x0538 }
            r9.p(r0)     // Catch:{ Exception -> 0x0538 }
            java.lang.String r0 = "t_t"
            int r0 = r1.optInt(r0, r8)     // Catch:{ Exception -> 0x0538 }
            r9.aN = r0     // Catch:{ Exception -> 0x0538 }
            java.lang.String r0 = "h_t"
            int r0 = r1.optInt(r0, r8)     // Catch:{ Exception -> 0x0538 }
            r9.f7895O = r0     // Catch:{ Exception -> 0x0538 }
            java.lang.String r0 = "gtp"
            int r0 = r1.optInt(r0)     // Catch:{ Exception -> 0x0538 }
            r9.f7894N = r0     // Catch:{ Exception -> 0x0538 }
            com.mbridge.msdk.foundation.same.net.e.d r2 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x0538 }
            r2.a((int) r0)     // Catch:{ Exception -> 0x0538 }
            java.lang.String r0 = "i_i_t"
            r2 = 3600(0xe10, double:1.7786E-320)
            long r2 = r1.optLong(r0, r2)     // Catch:{ Exception -> 0x0538 }
            r9.aZ = r2     // Catch:{ Exception -> 0x0538 }
            java.lang.String r0 = "c_i"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0538 }
            r9.ba = r0     // Catch:{ Exception -> 0x0538 }
            java.lang.String r0 = "n_c_u_p"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x0538 }
            r9.bb = r0     // Catch:{ Exception -> 0x0538 }
        L_0x0538:
            java.lang.String r0 = "http_track_url"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0540 }
            r9.f7897Q = r0     // Catch:{ Exception -> 0x0540 }
        L_0x0540:
            java.lang.String r0 = "st_net"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x0249 }
            r9.aL = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "vtag"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0249 }
            r9.aU = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "check_webview"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x055e }
            if (r0 != 0) goto L_0x055a
            r0 = r4
            goto L_0x055b
        L_0x055a:
            r0 = r10
        L_0x055b:
            r9.f7929x = r0     // Catch:{ Exception -> 0x055e }
            goto L_0x0560
        L_0x055e:
            r9.f7929x = r4     // Catch:{ Exception -> 0x0249 }
        L_0x0560:
            java.lang.String r0 = "swxid"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x0249 }
            java.lang.String r2 = r9.ah     // Catch:{ Exception -> 0x0249 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0249 }
            if (r2 != 0) goto L_0x0587
            r9.ah = r0     // Catch:{ Exception -> 0x0249 }
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = r0.h()     // Catch:{ Exception -> 0x0249 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0249 }
            if (r0 == 0) goto L_0x0587
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0249 }
            java.lang.String r2 = r9.ah     // Catch:{ Exception -> 0x0249 }
            r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0249 }
        L_0x0587:
            java.lang.String r0 = "sdk_filters"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x0249 }
            r9.aG = r0     // Catch:{ Exception -> 0x0249 }
            java.lang.String r0 = "ch_nv_im_cb"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x0598 }
            r9.f7928w = r0     // Catch:{ Exception -> 0x0598 }
            goto L_0x059a
        L_0x0598:
            r9.f7928w = r10     // Catch:{ Exception -> 0x0249 }
        L_0x059a:
            java.lang.String r0 = "do_us_fi_re"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x05a8 }
            if (r0 == 0) goto L_0x05a4
            r0 = r10
            goto L_0x05a5
        L_0x05a4:
            r0 = r4
        L_0x05a5:
            r9.f7900T = r0     // Catch:{ Exception -> 0x05a8 }
            goto L_0x05aa
        L_0x05a8:
            r9.f7900T = r10     // Catch:{ Exception -> 0x0249 }
        L_0x05aa:
            com.mbridge.msdk.foundation.controller.d.a()     // Catch:{ Exception -> 0x062c }
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x05c1 }
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x05c1 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r2)     // Catch:{ Exception -> 0x05c1 }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.z.a(r6)     // Catch:{ Exception -> 0x05c1 }
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x05c1 }
            com.mbridge.msdk.foundation.tools.FastKV r8 = r0.build()     // Catch:{ Exception -> 0x05c1 }
            goto L_0x05c2
        L_0x05c1:
            r8 = 0
        L_0x05c2:
            java.lang.String r0 = "H+tU+Fz8"
            java.lang.String r2 = "H+tU+bfPhM=="
            java.lang.String r3 = "c"
            java.lang.String r5 = "b"
            if (r8 == 0) goto L_0x062f
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x05fd }
            android.content.Context r4 = r4.c()     // Catch:{ Exception -> 0x05fd }
            if (r4 == 0) goto L_0x06b2
            java.lang.String r4 = r1.optString(r5)     // Catch:{ Exception -> 0x05fd }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x05fd }
            if (r6 != 0) goto L_0x05ff
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x05fd }
            boolean r6 = android.text.TextUtils.equals(r6, r4)     // Catch:{ Exception -> 0x05fd }
            if (r6 != 0) goto L_0x05ff
            com.mbridge.msdk.foundation.same.a.f9179V = r4     // Catch:{ Exception -> 0x05fd }
            com.mbridge.msdk.foundation.a.a.a r4 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x05fd }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x05fd }
            r4.a((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x05fd }
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.z.a(r2)     // Catch:{ Exception -> 0x05ff }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x05ff }
            r8.putString(r2, r4)     // Catch:{ Exception -> 0x05ff }
            goto L_0x05ff
        L_0x05fd:
            r0 = move-exception
            goto L_0x0627
        L_0x05ff:
            java.lang.String r2 = r1.optString(r3)     // Catch:{ Exception -> 0x05fd }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x05fd }
            if (r4 != 0) goto L_0x06b2
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x05fd }
            boolean r4 = android.text.TextUtils.equals(r4, r2)     // Catch:{ Exception -> 0x05fd }
            if (r4 != 0) goto L_0x06b2
            com.mbridge.msdk.foundation.same.a.f9188g = r2     // Catch:{ Exception -> 0x05fd }
            com.mbridge.msdk.foundation.a.a.a r2 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x05fd }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x05fd }
            r2.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x05fd }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x06b2 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x06b2 }
            r8.putString(r0, r2)     // Catch:{ Exception -> 0x06b2 }
            goto L_0x06b2
        L_0x0627:
            r0.printStackTrace()     // Catch:{ Exception -> 0x062c }
            goto L_0x06b2
        L_0x062c:
            r0 = move-exception
            goto L_0x06af
        L_0x062f:
            com.mbridge.msdk.foundation.controller.c r7 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0671 }
            android.content.Context r7 = r7.c()     // Catch:{ Exception -> 0x0671 }
            if (r7 == 0) goto L_0x06b2
            java.lang.String r8 = r1.optString(r5)     // Catch:{ Exception -> 0x0671 }
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0671 }
            if (r10 != 0) goto L_0x0673
            java.lang.String r10 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x0671 }
            boolean r10 = android.text.TextUtils.equals(r10, r8)     // Catch:{ Exception -> 0x0671 }
            if (r10 != 0) goto L_0x0673
            com.mbridge.msdk.foundation.same.a.f9179V = r8     // Catch:{ Exception -> 0x0671 }
            com.mbridge.msdk.foundation.a.a.a r8 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0671 }
            java.lang.String r10 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x0671 }
            r8.a((java.lang.String) r5, (java.lang.String) r10)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.z.a(r6)     // Catch:{ Exception -> 0x0671 }
            android.content.SharedPreferences r5 = r7.getSharedPreferences(r5, r4)     // Catch:{ Exception -> 0x0671 }
            if (r5 == 0) goto L_0x0673
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ Exception -> 0x0671 }
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.z.a(r2)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r8 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x0671 }
            r5.putString(r2, r8)     // Catch:{ Exception -> 0x0671 }
            r5.apply()     // Catch:{ Exception -> 0x0671 }
            goto L_0x0673
        L_0x0671:
            r0 = move-exception
            goto L_0x06ab
        L_0x0673:
            java.lang.String r2 = r1.optString(r3)     // Catch:{ Exception -> 0x0671 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0671 }
            if (r5 != 0) goto L_0x06b2
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x0671 }
            boolean r5 = android.text.TextUtils.equals(r5, r2)     // Catch:{ Exception -> 0x0671 }
            if (r5 != 0) goto L_0x06b2
            com.mbridge.msdk.foundation.same.a.f9188g = r2     // Catch:{ Exception -> 0x0671 }
            com.mbridge.msdk.foundation.a.a.a r2 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x0671 }
            r2.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.z.a(r6)     // Catch:{ Exception -> 0x0671 }
            android.content.SharedPreferences r2 = r7.getSharedPreferences(r2, r4)     // Catch:{ Exception -> 0x0671 }
            if (r2 == 0) goto L_0x06b2
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x0671 }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x0671 }
            r2.putString(r0, r3)     // Catch:{ Exception -> 0x0671 }
            r2.apply()     // Catch:{ Exception -> 0x0671 }
            goto L_0x06b2
        L_0x06ab:
            r0.printStackTrace()     // Catch:{ Exception -> 0x062c }
            goto L_0x06b2
        L_0x06af:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0249 }
        L_0x06b2:
            java.lang.String r0 = "bcp"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x0249 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0249 }
            if (r2 != 0) goto L_0x06c8
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0249 }
            com.mbridge.msdk.c.a r0 = com.mbridge.msdk.c.a.a(r0)     // Catch:{ Exception -> 0x0249 }
            r9.f7923r = r0     // Catch:{ Exception -> 0x0249 }
        L_0x06c8:
            java.lang.String r0 = "monitor"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x0249 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0249 }
            if (r1 != 0) goto L_0x06de
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0249 }
            com.mbridge.msdk.c.d r0 = com.mbridge.msdk.c.d.a(r0)     // Catch:{ Exception -> 0x0249 }
            r9.f7890J = r0     // Catch:{ Exception -> 0x0249 }
        L_0x06de:
            r8 = r9
            goto L_0x06e7
        L_0x06e0:
            r0 = move-exception
            r8 = 0
        L_0x06e2:
            r0.printStackTrace()
            goto L_0x06e7
        L_0x06e6:
            r8 = 0
        L_0x06e7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.c.b.a(org.json.JSONObject):com.mbridge.msdk.c.g");
    }

    public final int e() {
        return this.f7911f;
    }

    /* renamed from: com.mbridge.msdk.c.b$b  reason: collision with other inner class name */
    public static class C0079b {

        /* renamed from: a  reason: collision with root package name */
        private String f7943a;

        /* renamed from: b  reason: collision with root package name */
        private JSONArray f7944b;

        /* renamed from: c  reason: collision with root package name */
        private String f7945c;

        /* renamed from: d  reason: collision with root package name */
        private String f7946d;

        /* renamed from: e  reason: collision with root package name */
        private String f7947e;

        /* renamed from: f  reason: collision with root package name */
        private String f7948f;

        public static C0079b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            C0079b bVar = new C0079b();
            Context c5 = c.m().c();
            bVar.f7948f = jSONObject.optString(CampaignEx.JSON_KEY_TITLE, c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_title", TypedValues.Custom.S_STRING)));
            bVar.f7943a = jSONObject.optString("cancel", c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_close_close", TypedValues.Custom.S_STRING)));
            bVar.f7946d = jSONObject.optString("submit", c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_close_submit", TypedValues.Custom.S_STRING)));
            bVar.f7947e = jSONObject.optString("submit_notice", c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_submit_notice", TypedValues.Custom.S_STRING)));
            bVar.f7945c = jSONObject.optString("privacy", c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_privacy_des", TypedValues.Custom.S_STRING)));
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            bVar.f7944b = optJSONArray;
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                bVar.f7944b = jSONArray;
                jSONArray.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_not_play", TypedValues.Custom.S_STRING)));
                bVar.f7944b.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_sound_problems", TypedValues.Custom.S_STRING)));
                bVar.f7944b.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_misleading", TypedValues.Custom.S_STRING)));
                bVar.f7944b.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_fraud", TypedValues.Custom.S_STRING)));
                bVar.f7944b.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_por_violence", TypedValues.Custom.S_STRING)));
                bVar.f7944b.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_other", TypedValues.Custom.S_STRING)));
            }
            return bVar;
        }

        public final JSONArray b() {
            return this.f7944b;
        }

        public final String c() {
            return this.f7945c;
        }

        public final String d() {
            return this.f7946d;
        }

        public final String e() {
            return this.f7947e;
        }

        public final String f() {
            return this.f7948f;
        }

        public final String a() {
            return this.f7943a;
        }
    }

    public final void e(int i5) {
        this.f7914i = i5;
    }

    public final void e(long j5) {
        this.aJ = j5;
    }

    public final void e(boolean z4) {
        this.aE = z4;
    }

    public final void a(String str) {
        this.f7897Q = str;
    }

    public final void a(boolean z4) {
        this.f7926u = z4;
    }
}
