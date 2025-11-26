package l2;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.UptodownApp;
import d3.C2345b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.P;
import l2.b0;
import l2.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t3.s;
import z2.F;

/* renamed from: l2.f  reason: case insensitive filesystem */
public final class C2657f implements Parcelable {
    public static Parcelable.Creator<C2657f> CREATOR = new a();

    /* renamed from: J0  reason: collision with root package name */
    public static final b f25002J0 = new b((C2633k) null);

    /* renamed from: A  reason: collision with root package name */
    private String f25003A;

    /* renamed from: A0  reason: collision with root package name */
    private int f25004A0;

    /* renamed from: B  reason: collision with root package name */
    private long f25005B = -1;

    /* renamed from: B0  reason: collision with root package name */
    private int f25006B0;

    /* renamed from: C  reason: collision with root package name */
    private long f25007C = -1;

    /* renamed from: C0  reason: collision with root package name */
    private boolean f25008C0;

    /* renamed from: D  reason: collision with root package name */
    private int f25009D;

    /* renamed from: D0  reason: collision with root package name */
    private int f25010D0;

    /* renamed from: E  reason: collision with root package name */
    private String f25011E;

    /* renamed from: E0  reason: collision with root package name */
    private int f25012E0;

    /* renamed from: F  reason: collision with root package name */
    private String f25013F;

    /* renamed from: F0  reason: collision with root package name */
    private ArrayList f25014F0;

    /* renamed from: G  reason: collision with root package name */
    private String f25015G;

    /* renamed from: G0  reason: collision with root package name */
    private transient ArrayList f25016G0;

    /* renamed from: H  reason: collision with root package name */
    private String f25017H;

    /* renamed from: H0  reason: collision with root package name */
    private ArrayList f25018H0 = new ArrayList();

    /* renamed from: I  reason: collision with root package name */
    private String f25019I;

    /* renamed from: I0  reason: collision with root package name */
    private C2648H f25020I0;

    /* renamed from: J  reason: collision with root package name */
    private String f25021J;

    /* renamed from: K  reason: collision with root package name */
    private ArrayList f25022K;

    /* renamed from: L  reason: collision with root package name */
    private ArrayList f25023L;

    /* renamed from: M  reason: collision with root package name */
    private ArrayList f25024M;

    /* renamed from: N  reason: collision with root package name */
    private String f25025N;

    /* renamed from: O  reason: collision with root package name */
    private String f25026O;

    /* renamed from: P  reason: collision with root package name */
    private ArrayList f25027P;

    /* renamed from: Q  reason: collision with root package name */
    private ArrayList f25028Q;

    /* renamed from: R  reason: collision with root package name */
    private L f25029R;

    /* renamed from: S  reason: collision with root package name */
    private String f25030S;

    /* renamed from: T  reason: collision with root package name */
    private String f25031T;

    /* renamed from: U  reason: collision with root package name */
    private String f25032U;

    /* renamed from: V  reason: collision with root package name */
    private int f25033V;

    /* renamed from: W  reason: collision with root package name */
    private String f25034W;

    /* renamed from: X  reason: collision with root package name */
    private String f25035X;

    /* renamed from: Y  reason: collision with root package name */
    private String f25036Y;

    /* renamed from: Z  reason: collision with root package name */
    private String f25037Z;

    /* renamed from: a  reason: collision with root package name */
    private long f25038a;

    /* renamed from: b  reason: collision with root package name */
    private String f25039b;

    /* renamed from: c  reason: collision with root package name */
    private String f25040c;

    /* renamed from: d  reason: collision with root package name */
    private long f25041d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f25042e;

    /* renamed from: f  reason: collision with root package name */
    private String f25043f;

    /* renamed from: g  reason: collision with root package name */
    private String f25044g;

    /* renamed from: h  reason: collision with root package name */
    private String f25045h;

    /* renamed from: i  reason: collision with root package name */
    private int f25046i;

    /* renamed from: j  reason: collision with root package name */
    private int f25047j;

    /* renamed from: k  reason: collision with root package name */
    private String f25048k;

    /* renamed from: l  reason: collision with root package name */
    private String f25049l;

    /* renamed from: m  reason: collision with root package name */
    private String f25050m;

    /* renamed from: m0  reason: collision with root package name */
    private String f25051m0;

    /* renamed from: n  reason: collision with root package name */
    private String f25052n;

    /* renamed from: n0  reason: collision with root package name */
    private String f25053n0;

    /* renamed from: o  reason: collision with root package name */
    private String f25054o;

    /* renamed from: o0  reason: collision with root package name */
    private long f25055o0;

    /* renamed from: p  reason: collision with root package name */
    private int f25056p;

    /* renamed from: p0  reason: collision with root package name */
    private String f25057p0;

    /* renamed from: q  reason: collision with root package name */
    private int f25058q;

    /* renamed from: q0  reason: collision with root package name */
    private String f25059q0;

    /* renamed from: r  reason: collision with root package name */
    private int f25060r;

    /* renamed from: r0  reason: collision with root package name */
    private String f25061r0;

    /* renamed from: s  reason: collision with root package name */
    private int f25062s;

    /* renamed from: s0  reason: collision with root package name */
    private int f25063s0;

    /* renamed from: t  reason: collision with root package name */
    private int f25064t;

    /* renamed from: t0  reason: collision with root package name */
    private String f25065t0;

    /* renamed from: u  reason: collision with root package name */
    private int f25066u;

    /* renamed from: u0  reason: collision with root package name */
    private int f25067u0;

    /* renamed from: v  reason: collision with root package name */
    private int f25068v;

    /* renamed from: v0  reason: collision with root package name */
    private String f25069v0;

    /* renamed from: w  reason: collision with root package name */
    private String f25070w;

    /* renamed from: w0  reason: collision with root package name */
    private c f25071w0 = c.NONE;

    /* renamed from: x  reason: collision with root package name */
    private C2660i f25072x;

    /* renamed from: x0  reason: collision with root package name */
    private HashMap f25073x0 = new HashMap();

    /* renamed from: y  reason: collision with root package name */
    private int f25074y;

    /* renamed from: y0  reason: collision with root package name */
    private int f25075y0;

    /* renamed from: z  reason: collision with root package name */
    private String f25076z;

    /* renamed from: z0  reason: collision with root package name */
    private String f25077z0;

    /* renamed from: l2.f$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2657f createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new C2657f(parcel);
        }

        /* renamed from: b */
        public C2657f[] newArray(int i5) {
            return new C2657f[i5];
        }
    }

    /* renamed from: l2.f$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public static /* synthetic */ C2657f b(b bVar, JSONObject jSONObject, Context context, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                context = null;
            }
            return bVar.a(jSONObject, context);
        }

        public final C2657f a(JSONObject jSONObject, Context context) {
            t.e(jSONObject, "jsonObjectData");
            C2657f fVar = new C2657f();
            fVar.a(jSONObject, context);
            return fVar;
        }

        public final boolean c(String str) {
            return t.a(str, "Discontinued");
        }

        public final boolean d(String str) {
            if (str == null || g(str) || c(str) || e(str) || h(str) || f(str)) {
                return false;
            }
            return true;
        }

        public final boolean e(String str) {
            return t.a(str, "ExternalDownload");
        }

        public final boolean f(String str) {
            return t.a(str, "AppNotAvailableInThisCountry");
        }

        public final boolean g(String str) {
            return t.a(str, "PreRegister");
        }

        public final boolean h(String str) {
            return t.a(str, "ReadingMode");
        }

        private b() {
        }
    }

    /* renamed from: l2.f$c */
    public enum c {
        UPDATE,
        PROMOTED,
        LATEST,
        EDITOR_CHOICE,
        TRENDING,
        NONE;

        static {
            c[] a5;
            f25085h = C2345b.a(a5);
        }
    }

    public C2657f() {
    }

    private final boolean H0() {
        if (this.f25063s0 > 1) {
            return true;
        }
        return false;
    }

    private final void P0(JSONObject jSONObject, Context context) {
        JSONObject optJSONObject;
        if (!jSONObject.isNull("appID")) {
            this.f25038a = jSONObject.optLong("appID");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f25039b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("license")) {
            this.f25045h = jSONObject.optString("license");
        }
        if (!jSONObject.isNull("lastVersionCode")) {
            this.f25041d = jSONObject.optLong("lastVersionCode");
        }
        if (!jSONObject.isNull("shortDescription")) {
            this.f25043f = jSONObject.optString("shortDescription");
        }
        if (!jSONObject.isNull("iconURL")) {
            this.f25049l = jSONObject.optString("iconURL");
        } else if (!jSONObject.isNull(RewardPlus.ICON)) {
            this.f25049l = jSONObject.optString(RewardPlus.ICON);
        }
        if (!jSONObject.isNull("feature")) {
            this.f25050m = jSONObject.optString("feature");
        } else if (!jSONObject.isNull("imageURL")) {
            this.f25050m = jSONObject.optString("imageURL");
        }
        if (!jSONObject.isNull("author")) {
            this.f25052n = jSONObject.optString("author");
        }
        if (!jSONObject.isNull("size")) {
            this.f25044g = jSONObject.optString("size");
        }
        if (!jSONObject.isNull("downloads")) {
            this.f25046i = jSONObject.optInt("downloads");
        }
        if (!jSONObject.isNull("weeklyDownloads")) {
            this.f25047j = jSONObject.optInt("weeklyDownloads");
        }
        if (!jSONObject.isNull("lastUpdate")) {
            this.f25048k = jSONObject.optString("lastUpdate");
        }
        if (!jSONObject.isNull("urlShare")) {
            this.f25042e = jSONObject.optString("urlShare");
        } else if (!jSONObject.isNull("url")) {
            this.f25042e = jSONObject.optString("url");
        }
        if (!jSONObject.isNull("description")) {
            String optString = jSONObject.optString("description");
            t.d(optString, "optString(...)");
            this.f25054o = s.L(optString, "\n", "<br />", false, 4, (Object) null);
        }
        if (!jSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
            this.f25056p = jSONObject.optInt(CampaignEx.JSON_KEY_STAR);
        }
        if (!jSONObject.isNull("ratingCount")) {
            this.f25058q = jSONObject.optInt("ratingCount");
        }
        if (!jSONObject.isNull("ratingCount1")) {
            this.f25060r = jSONObject.optInt("ratingCount1");
        }
        if (!jSONObject.isNull("ratingCount2")) {
            this.f25062s = jSONObject.optInt("ratingCount2");
        }
        if (!jSONObject.isNull("ratingCount3")) {
            this.f25064t = jSONObject.optInt("ratingCount3");
        }
        if (!jSONObject.isNull("ratingCount4")) {
            this.f25066u = jSONObject.optInt("ratingCount4");
        }
        if (!jSONObject.isNull("ratingCount5")) {
            this.f25068v = jSONObject.optInt("ratingCount5");
        }
        if (!jSONObject.isNull("packagename")) {
            this.f25070w = jSONObject.optString("packagename");
        } else if (!jSONObject.isNull("packageName")) {
            this.f25070w = jSONObject.optString("packageName");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("categoryData");
        if (optJSONObject2 != null) {
            C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
            this.f25072x = iVar;
            t.b(iVar);
            iVar.n(optJSONObject2);
        }
        if (!jSONObject.isNull("permissionCount")) {
            this.f25074y = jSONObject.optInt("permissionCount");
        }
        if (!jSONObject.isNull("md5Signature")) {
            this.f25011E = jSONObject.optString("md5Signature");
        }
        if (!jSONObject.isNull("activeADEX")) {
            this.f25009D = jSONObject.optInt("activeADEX");
        }
        if (!jSONObject.isNull("pegi")) {
            this.f25015G = jSONObject.optString("pegi");
        }
        if (!jSONObject.isNull("technicalData")) {
            this.f25019I = jSONObject.optString("technicalData");
        }
        if (!jSONObject.isNull("versionRequired")) {
            this.f25021J = jSONObject.optString("versionRequired");
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("compatibleFile");
        if (optJSONObject3 != null) {
            JSONArray optJSONArray = optJSONObject3.optJSONArray("densities");
            if (optJSONArray != null) {
                this.f25022K = new ArrayList();
                int length = optJSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    ArrayList arrayList = this.f25022K;
                    if (arrayList != null) {
                        arrayList.add(optJSONArray.optString(i5));
                    }
                }
            }
            JSONArray optJSONArray2 = optJSONObject3.optJSONArray("abis");
            if (optJSONArray2 != null) {
                this.f25023L = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i6 = 0; i6 < length2; i6++) {
                    ArrayList arrayList2 = this.f25023L;
                    if (arrayList2 != null) {
                        arrayList2.add(optJSONArray2.optString(i6));
                    }
                }
            }
            if (!optJSONObject3.isNull("fileID")) {
                this.f25005B = optJSONObject3.optLong("fileID");
            }
            if (!optJSONObject3.isNull("minSDK")) {
                this.f25076z = optJSONObject3.optString("minSDK");
            }
            if (!optJSONObject3.isNull("fileType")) {
                this.f25003A = optJSONObject3.optString("fileType");
            }
            if (!optJSONObject3.isNull("version")) {
                this.f25040c = optJSONObject3.optString("version");
            }
            if (!optJSONObject3.isNull("versionCode")) {
                this.f25007C = optJSONObject3.optLong("versionCode");
            }
            if (!optJSONObject3.isNull("sha256")) {
                this.f25017H = optJSONObject3.optString("sha256");
            }
            if (!optJSONObject3.isNull("url_apk")) {
                this.f25013F = optJSONObject3.optString("url_apk");
            }
            JSONArray optJSONArray3 = optJSONObject3.optJSONArray("requiredFeatures");
            if (optJSONArray3 != null) {
                this.f25024M = new ArrayList();
                int length3 = optJSONArray3.length();
                for (int i7 = 0; i7 < length3; i7++) {
                    ArrayList arrayList3 = this.f25024M;
                    if (arrayList3 != null) {
                        arrayList3.add(optJSONArray3.optString(i7));
                    }
                }
                ArrayList arrayList4 = this.f25024M;
                t.b(arrayList4);
                if (!arrayList4.isEmpty() && context != null) {
                    C2667p pVar = new C2667p();
                    ArrayList arrayList5 = this.f25024M;
                    t.b(arrayList5);
                    ArrayList e5 = pVar.e(arrayList5, context);
                    if (!e5.isEmpty()) {
                        Iterator it = e5.iterator();
                        t.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            Bundle bundle = new Bundle();
                            bundle.putInt("update", 0);
                            bundle.putString("feature", (String) next);
                            new F(context).d("required_features_not_supported", bundle);
                        }
                    }
                }
            }
            JSONArray optJSONArray4 = optJSONObject3.optJSONArray("containedFiles");
            if (optJSONArray4 != null) {
                this.f25018H0 = new ArrayList();
                int length4 = optJSONArray4.length();
                for (int i8 = 0; i8 < length4; i8++) {
                    JSONObject jSONObject2 = optJSONArray4.getJSONObject(i8);
                    r.b bVar = r.f25178k;
                    t.b(jSONObject2);
                    this.f25018H0.add(bVar.a(jSONObject2));
                }
            }
        }
        if (!jSONObject.isNull("website")) {
            this.f25025N = jSONObject.optString("website");
        }
        if (!jSONObject.isNull("downloadStatus")) {
            String optString2 = jSONObject.optString("downloadStatus");
            this.f25026O = optString2;
            if (s.F(optString2, "PreRegister", false, 2, (Object) null) && (optJSONObject = jSONObject.optJSONObject("preRegister")) != null) {
                if (!optJSONObject.isNull("date")) {
                    this.f25030S = optJSONObject.optString("date");
                }
                if (!optJSONObject.isNull("countPreRegistered")) {
                    this.f25031T = optJSONObject.optString("countPreRegistered");
                }
            }
        }
        if (!jSONObject.isNull("newFeatures")) {
            this.f25032U = jSONObject.optString("newFeatures");
        }
        if (!jSONObject.isNull("onBoard")) {
            this.f25033V = jSONObject.optInt("onBoard");
        }
        if (!jSONObject.isNull("responsibilities")) {
            this.f25034W = jSONObject.optString("responsibilities");
        }
        if (!jSONObject.isNull(TypedValues.CycleType.S_WAVE_PHASE)) {
            this.f25035X = jSONObject.optString(TypedValues.CycleType.S_WAVE_PHASE);
        }
        if (!jSONObject.isNull("deviceType")) {
            this.f25036Y = jSONObject.optString("deviceType");
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("translations");
        if (optJSONObject4 != null) {
            this.f25073x0 = new HashMap();
            if (!optJSONObject4.isNull("try")) {
                HashMap hashMap = this.f25073x0;
                t.b(hashMap);
                hashMap.put("try", optJSONObject4.optString("try"));
            }
            if (!optJSONObject4.isNull("supportedDevice")) {
                HashMap hashMap2 = this.f25073x0;
                t.b(hashMap2);
                hashMap2.put("supportedDevice", optJSONObject4.optString("supportedDevice"));
            }
        }
        if (!jSONObject.isNull("readingModeText")) {
            this.f25037Z = jSONObject.optString("readingModeText");
        }
        if (!jSONObject.isNull("externalDownloadURL")) {
            this.f25051m0 = jSONObject.optString("externalDownloadURL");
        }
        if (!jSONObject.isNull("externalDownloadText")) {
            this.f25053n0 = jSONObject.optString("externalDownloadText");
        }
        if (!jSONObject.isNull("organizationID")) {
            this.f25055o0 = jSONObject.optLong("organizationID");
        }
        if (!jSONObject.isNull("editorNameNew")) {
            this.f25057p0 = jSONObject.optString("editorNameNew");
        }
        if (!jSONObject.isNull("editorAvatar")) {
            this.f25059q0 = jSONObject.optString("editorAvatar");
        }
        if (!jSONObject.isNull("showReviewedBy")) {
            this.f25067u0 = jSONObject.optInt("showReviewedBy");
        }
        if (!jSONObject.isNull("editorJobTitle")) {
            this.f25061r0 = jSONObject.optString("editorJobTitle");
        }
        if (!jSONObject.isNull("totalVersions")) {
            this.f25063s0 = jSONObject.optInt("totalVersions");
        }
        if (!jSONObject.isNull("disclaimerText")) {
            this.f25065t0 = jSONObject.optString("disclaimerText");
        }
        if (!jSONObject.isNull("tagID")) {
            int optInt = jSONObject.optInt("tagID");
            if (optInt == 0) {
                this.f25071w0 = c.NONE;
            } else if (optInt == 1) {
                this.f25071w0 = c.TRENDING;
            } else if (optInt == 2) {
                this.f25071w0 = c.LATEST;
            } else if (optInt == 3) {
                this.f25071w0 = c.UPDATE;
            } else if (optInt == 4) {
                this.f25071w0 = c.PROMOTED;
            } else if (optInt == 5) {
                this.f25071w0 = c.EDITOR_CHOICE;
            }
            if (!jSONObject.isNull("tag")) {
                this.f25069v0 = jSONObject.optString("tag");
            }
        }
        if (!jSONObject.isNull("promoted")) {
            this.f25075y0 = jSONObject.optInt("promoted");
        }
        if (!jSONObject.isNull("containsAds")) {
            this.f25004A0 = jSONObject.optInt("containsAds");
        }
        if (!jSONObject.isNull("hasAlternatives")) {
            if (jSONObject.optBoolean("hasAlternatives")) {
                this.f25006B0 = 1;
            } else {
                this.f25006B0 = 0;
            }
        }
        if (!jSONObject.isNull("wishlist")) {
            this.f25010D0 = jSONObject.optInt("wishlist");
        }
        JSONArray optJSONArray5 = jSONObject.optJSONArray("userSays");
        if (optJSONArray5 != null) {
            this.f25014F0 = new ArrayList();
            int length5 = optJSONArray5.length();
            for (int i9 = 0; i9 < length5; i9++) {
                ArrayList arrayList6 = this.f25014F0;
                t.b(arrayList6);
                arrayList6.add(optJSONArray5.getString(i9));
            }
        }
        if (!jSONObject.isNull("recommended-apps")) {
            this.f25012E0 = jSONObject.optInt("recommended-apps");
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("ranking");
        if (optJSONObject5 != null) {
            this.f25020I0 = C2648H.f24768e.a(optJSONObject5);
        }
    }

    public static /* synthetic */ void b(C2657f fVar, JSONObject jSONObject, Context context, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            context = null;
        }
        fVar.a(jSONObject, context);
    }

    public final long A() {
        return this.f25005B;
    }

    public final long A0() {
        return this.f25007C;
    }

    public final String B() {
        return this.f25003A;
    }

    public final String B0() {
        return this.f25040c;
    }

    public final int C() {
        return this.f25006B0;
    }

    public final String C0() {
        return this.f25021J;
    }

    public final String D() {
        if (this.f25050m == null) {
            return null;
        }
        return this.f25050m + UptodownApp.f13477F.p() + ":webp";
    }

    public final ArrayList D0() {
        return this.f25028Q;
    }

    public final String E() {
        return this.f25049l;
    }

    public final String E0() {
        return this.f25025N;
    }

    public final String F(int i5) {
        if (this.f25049l == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(':');
        sb.append(i5);
        String sb2 = sb.toString();
        return this.f25049l + sb2 + ":webp";
    }

    public final int F0() {
        return this.f25010D0;
    }

    public final String G() {
        if (this.f25049l == null) {
            return null;
        }
        return this.f25049l + UptodownApp.f13477F.q() + ":webp";
    }

    public final boolean G0() {
        if (this.f25005B >= 0) {
            return true;
        }
        return false;
    }

    public final String H() {
        if (this.f25049l == null) {
            return null;
        }
        return this.f25049l + UptodownApp.f13477F.r() + ":webp";
    }

    public final String I() {
        return this.f25048k;
    }

    public final boolean I0() {
        return f25002J0.c(this.f25026O);
    }

    public final long J() {
        return this.f25041d;
    }

    public final boolean J0() {
        return f25002J0.d(this.f25026O);
    }

    public final String K() {
        return this.f25045h;
    }

    public final boolean K0() {
        return f25002J0.e(this.f25026O);
    }

    public final String L() {
        return this.f25011E;
    }

    public final boolean L0() {
        return f25002J0.f(this.f25026O);
    }

    public final String M() {
        return this.f25076z;
    }

    public final boolean M0() {
        return f25002J0.g(this.f25026O);
    }

    public final String N() {
        return this.f25039b;
    }

    public final boolean N0() {
        if (this.f25075y0 == 1) {
            return true;
        }
        return false;
    }

    public final String O() {
        return this.f25032U;
    }

    public final boolean O0() {
        return f25002J0.h(this.f25026O);
    }

    public final boolean P() {
        return this.f25008C0;
    }

    public final ArrayList Q() {
        return this.f25016G0;
    }

    public final void Q0(long j5) {
        this.f25038a = j5;
    }

    public final long R() {
        return this.f25055o0;
    }

    public final void R0(String str) {
        this.f25050m = str;
    }

    public final String S() {
        return this.f25070w;
    }

    public final void S0(long j5) {
        this.f25005B = j5;
    }

    public final String T() {
        return this.f25015G;
    }

    public final void T0(boolean z4) {
        this.f25008C0 = z4;
    }

    public final int U() {
        return this.f25074y;
    }

    public final void U0(ArrayList arrayList) {
        this.f25016G0 = arrayList;
    }

    public final String V() {
        return this.f25035X;
    }

    public final void V0(int i5) {
        this.f25075y0 = i5;
    }

    public final String W() {
        return this.f25031T;
    }

    public final void W0(String str) {
        this.f25077z0 = str;
    }

    public final int X() {
        return this.f25075y0;
    }

    public final void X0(int i5) {
        this.f25012E0 = i5;
    }

    public final String Y() {
        return this.f25077z0;
    }

    public final void Y0(L l5) {
        this.f25029R = l5;
    }

    public final C2648H Z() {
        return this.f25020I0;
    }

    public final void Z0(ArrayList arrayList) {
        this.f25027P = arrayList;
    }

    public final void a(JSONObject jSONObject, Context context) {
        t.e(jSONObject, "jsonObjectData");
        if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (optJSONObject != null) {
                P0(optJSONObject, context);
            }
        } else {
            P0(jSONObject, context);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("videos");
        if (optJSONArray != null) {
            this.f25028Q = new ArrayList();
            int length = optJSONArray.length();
            for (int i5 = 0; i5 < length; i5++) {
                if (optJSONArray.get(i5) instanceof JSONObject) {
                    b0.b bVar = b0.f24958c;
                    Object obj = optJSONArray.get(i5);
                    t.c(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    b0 a5 = bVar.a((JSONObject) obj);
                    ArrayList arrayList = this.f25028Q;
                    t.b(arrayList);
                    arrayList.add(a5);
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("screenshots");
        if (optJSONArray2 != null) {
            this.f25027P = new ArrayList();
            int length2 = optJSONArray2.length();
            for (int i6 = 0; i6 < length2; i6++) {
                if (optJSONArray2.get(i6) instanceof JSONObject) {
                    P.b bVar2 = P.f24840e;
                    Object obj2 = optJSONArray2.get(i6);
                    t.c(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                    P b5 = bVar2.b((JSONObject) obj2);
                    ArrayList arrayList2 = this.f25027P;
                    if (arrayList2 != null) {
                        arrayList2.add(b5);
                    }
                }
            }
        }
    }

    public final int a0() {
        return this.f25056p;
    }

    public final void a1(String str) {
        this.f25017H = str;
    }

    public final int b0() {
        return this.f25058q;
    }

    public final void b1(ArrayList arrayList) {
        this.f25028Q = arrayList;
    }

    public final boolean c() {
        if (O0() || K0() || !H0() || L0() || M0()) {
            return false;
        }
        return true;
    }

    public final int c0() {
        return this.f25060r;
    }

    public final void c1(int i5) {
        this.f25010D0 = i5;
    }

    public final int d() {
        return this.f25009D;
    }

    public final int d0() {
        return this.f25062s;
    }

    public int describeContents() {
        return hashCode();
    }

    public final long e() {
        return this.f25038a;
    }

    public final int e0() {
        return this.f25064t;
    }

    public final long f(M m5) {
        int i5;
        t.e(m5, "responseJson");
        try {
            if (m5.b() || m5.e() == null) {
                return 0;
            }
            JSONObject e5 = m5.e();
            t.b(e5);
            if (!e5.isNull("success")) {
                i5 = e5.optInt("success");
            } else {
                i5 = 0;
            }
            JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (i5 != 1 || optJSONObject == null || optJSONObject.isNull("appID")) {
                return 0;
            }
            return optJSONObject.optLong("appID");
        } catch (JSONException e6) {
            e6.printStackTrace();
            return -1;
        }
    }

    public final int f0() {
        return this.f25066u;
    }

    public final String g() {
        return this.f25052n;
    }

    public final int g0() {
        return this.f25068v;
    }

    public final C2660i h() {
        return this.f25072x;
    }

    public final String h0() {
        return this.f25037Z;
    }

    public final int i() {
        return this.f25004A0;
    }

    public final int i0() {
        return this.f25012E0;
    }

    public final ArrayList j() {
        return this.f25018H0;
    }

    public final L j0() {
        return this.f25029R;
    }

    public final String k() {
        return this.f25054o;
    }

    public final ArrayList k0() {
        return this.f25024M;
    }

    public final int l() {
        return this.f25033V;
    }

    public final String l0() {
        return this.f25034W;
    }

    public final String m() {
        return this.f25036Y;
    }

    public final ArrayList m0() {
        return this.f25027P;
    }

    public final String n() {
        return this.f25065t0;
    }

    public final String n0() {
        return this.f25017H;
    }

    public final String o() {
        return this.f25026O;
    }

    public final String o0() {
        return this.f25043f;
    }

    public final String p() {
        return this.f25013F;
    }

    public final int p0() {
        return this.f25067u0;
    }

    public final int q() {
        return this.f25046i;
    }

    public final String q0() {
        return this.f25044g;
    }

    public final String r() {
        return this.f25059q0;
    }

    public final ArrayList r0() {
        return this.f25023L;
    }

    public final String s() {
        return this.f25061r0;
    }

    public final ArrayList s0() {
        return this.f25022K;
    }

    public final String t() {
        return this.f25057p0;
    }

    public final String t0() {
        return this.f25069v0;
    }

    public String toString() {
        return "AppInfo(appID=" + this.f25038a + ", name=" + this.f25039b + ", versionName=" + this.f25040c + ", lastVersionCode=" + this.f25041d + ", urlShare=" + this.f25042e + ", shortDescription=" + this.f25043f + ", size=" + this.f25044g + ", license=" + this.f25045h + ", downloads=" + this.f25046i + ", weeklyDownloads=" + this.f25047j + ", lastUpdate=" + this.f25048k + ", icon=" + this.f25049l + ", feature=" + this.f25050m + ", author=" + this.f25052n + ", description=" + this.f25054o + ", rating=" + this.f25056p + ", ratingCount=" + this.f25058q + ", ratingCount1=" + this.f25060r + ", ratingCount2=" + this.f25062s + ", ratingCount3=" + this.f25064t + ", ratingCount4=" + this.f25066u + ", ratingCount5=" + this.f25068v + ", packagename=" + this.f25070w + ", screenShots=" + this.f25027P + ", category=" + this.f25072x + ", permissionCount=" + this.f25074y + ", minsdk=" + this.f25076z + ", fileType=" + this.f25003A + ", md5signature=" + this.f25011E + ", downloadUrl=" + this.f25013F + ", fileID=" + this.f25005B + ", oldVersions=" + this.f25016G0 + ", activeADEX=" + this.f25009D + ", sha256=" + this.f25017H + ", technicalData=" + this.f25019I + ", versionRequired=" + this.f25021J + ", webAuthor=" + this.f25025N + ", downloadStatus=" + this.f25026O + ", devOnBoard=" + this.f25033V + ", responsibilities=" + this.f25034W + ", phase=" + this.f25035X + ", readingModeText=" + this.f25037Z + ", externalDownloadUrl=" + this.f25051m0 + ", newFeatures=" + this.f25032U + ", preRegisterDate=" + this.f25030S + ", preRegistersCount=" + this.f25031T + ", editorAvatar=" + this.f25059q0 + ", editorJobTitle=" + this.f25061r0 + ", showReviewedBy=" + this.f25067u0 + ", containAds=" + this.f25004A0 + ", hasAlternatives=" + this.f25006B0 + ", wishlist=" + this.f25010D0 + ", deviceType=" + this.f25036Y + ", translations=" + this.f25073x0 + ", supportedDensities=" + this.f25022K + ", supportedAbis=" + this.f25023L + ", requiredFeatures=" + this.f25024M + ", pegi=" + this.f25015G + ", externalDownloadText=" + this.f25053n0 + ", organizationID=" + this.f25055o0 + ", editorName=" + this.f25057p0 + ", totalVersions=" + this.f25063s0 + ", disclaimerText=" + this.f25065t0 + ", promoted=" + this.f25075y0 + ", promotedFrom=" + this.f25077z0 + ')';
    }

    public final String u() {
        return this.f25053n0;
    }

    public final c u0() {
        return this.f25071w0;
    }

    public final String v() {
        return this.f25051m0;
    }

    public final String v0() {
        return this.f25019I;
    }

    public final String w() {
        return this.f25050m;
    }

    public final int w0() {
        return this.f25063s0;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeLong(this.f25038a);
        parcel.writeString(this.f25039b);
        parcel.writeString(this.f25040c);
        parcel.writeLong(this.f25041d);
        parcel.writeString(this.f25042e);
        parcel.writeString(this.f25043f);
        parcel.writeString(this.f25044g);
        parcel.writeString(this.f25045h);
        parcel.writeInt(this.f25046i);
        parcel.writeInt(this.f25047j);
        parcel.writeString(this.f25048k);
        parcel.writeString(this.f25049l);
        parcel.writeString(this.f25050m);
        parcel.writeString(this.f25052n);
        parcel.writeString(this.f25054o);
        parcel.writeInt(this.f25056p);
        parcel.writeInt(this.f25058q);
        parcel.writeInt(this.f25060r);
        parcel.writeInt(this.f25062s);
        parcel.writeInt(this.f25064t);
        parcel.writeInt(this.f25066u);
        parcel.writeInt(this.f25068v);
        parcel.writeString(this.f25070w);
        parcel.writeParcelable(this.f25072x, i5);
        parcel.writeInt(this.f25074y);
        parcel.writeString(this.f25076z);
        parcel.writeString(this.f25011E);
        parcel.writeString(this.f25013F);
        parcel.writeLong(this.f25005B);
        parcel.writeInt(this.f25009D);
        parcel.writeString(this.f25017H);
        parcel.writeString(this.f25019I);
        parcel.writeString(this.f25021J);
        parcel.writeStringList(this.f25022K);
        parcel.writeStringList(this.f25023L);
        parcel.writeStringList(this.f25024M);
        parcel.writeString(this.f25025N);
        parcel.writeString(this.f25026O);
        parcel.writeString(this.f25015G);
        parcel.writeInt(this.f25033V);
        parcel.writeString(this.f25036Y);
        parcel.writeMap(this.f25073x0);
        parcel.writeString(this.f25037Z);
        parcel.writeString(this.f25051m0);
        parcel.writeString(this.f25053n0);
        parcel.writeLong(this.f25055o0);
        parcel.writeString(this.f25057p0);
        parcel.writeInt(this.f25063s0);
        parcel.writeString(this.f25034W);
        parcel.writeString(this.f25032U);
        parcel.writeString(this.f25030S);
        parcel.writeString(this.f25031T);
        parcel.writeString(this.f25059q0);
        parcel.writeString(this.f25061r0);
        parcel.writeString(this.f25065t0);
        parcel.writeInt(this.f25067u0);
        parcel.writeInt(this.f25004A0);
        parcel.writeInt(this.f25006B0);
        parcel.writeInt(this.f25010D0);
        parcel.writeStringList(this.f25014F0);
        parcel.writeInt(this.f25012E0);
        parcel.writeInt(this.f25075y0);
        parcel.writeString(this.f25077z0);
        parcel.writeTypedList(this.f25018H0);
        parcel.writeParcelable(this.f25020I0, i5);
        parcel.writeString(this.f25003A);
    }

    public final String x() {
        if (this.f25050m == null) {
            return null;
        }
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.x() <= 0) {
            return z();
        }
        return this.f25050m + ':' + aVar.x() + ":webp";
    }

    public final String x0(String str) {
        t.e(str, "key");
        HashMap hashMap = this.f25073x0;
        if (hashMap != null) {
            return (String) hashMap.get(str);
        }
        return null;
    }

    public final String y() {
        if (this.f25050m == null) {
            return null;
        }
        return this.f25050m + UptodownApp.f13477F.n() + ":webp";
    }

    public final String y0() {
        return this.f25042e;
    }

    public final String z() {
        if (this.f25050m == null) {
            return null;
        }
        return this.f25050m + UptodownApp.f13477F.o() + ":webp";
    }

    public final ArrayList z0() {
        return this.f25014F0;
    }

    public C2657f(Parcel parcel) {
        t.e(parcel, "source");
        this.f25038a = parcel.readLong();
        this.f25039b = parcel.readString();
        this.f25040c = parcel.readString();
        this.f25041d = parcel.readLong();
        this.f25042e = parcel.readString();
        this.f25043f = parcel.readString();
        this.f25044g = parcel.readString();
        this.f25045h = parcel.readString();
        this.f25046i = parcel.readInt();
        this.f25047j = parcel.readInt();
        this.f25048k = parcel.readString();
        this.f25049l = parcel.readString();
        this.f25050m = parcel.readString();
        this.f25052n = parcel.readString();
        this.f25054o = parcel.readString();
        this.f25056p = parcel.readInt();
        this.f25058q = parcel.readInt();
        this.f25060r = parcel.readInt();
        this.f25062s = parcel.readInt();
        this.f25064t = parcel.readInt();
        this.f25066u = parcel.readInt();
        this.f25068v = parcel.readInt();
        this.f25070w = parcel.readString();
        int i5 = Build.VERSION.SDK_INT;
        Class<C2660i> cls = C2660i.class;
        if (i5 >= 33) {
            this.f25072x = (C2660i) parcel.readParcelable(cls.getClassLoader(), cls);
        } else {
            this.f25072x = (C2660i) parcel.readParcelable(cls.getClassLoader());
        }
        this.f25074y = parcel.readInt();
        this.f25076z = parcel.readString();
        this.f25011E = parcel.readString();
        this.f25013F = parcel.readString();
        this.f25005B = parcel.readLong();
        this.f25009D = parcel.readInt();
        this.f25017H = parcel.readString();
        this.f25019I = parcel.readString();
        this.f25021J = parcel.readString();
        this.f25022K = parcel.createStringArrayList();
        this.f25023L = parcel.createStringArrayList();
        this.f25024M = parcel.createStringArrayList();
        this.f25025N = parcel.readString();
        this.f25026O = parcel.readString();
        this.f25015G = parcel.readString();
        this.f25033V = parcel.readInt();
        this.f25036Y = parcel.readString();
        HashMap readHashMap = parcel.readHashMap(ClassLoader.getSystemClassLoader());
        t.c(readHashMap, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
        this.f25073x0 = readHashMap;
        this.f25037Z = parcel.readString();
        this.f25051m0 = parcel.readString();
        this.f25053n0 = parcel.readString();
        this.f25055o0 = parcel.readLong();
        this.f25057p0 = parcel.readString();
        this.f25063s0 = parcel.readInt();
        this.f25034W = parcel.readString();
        this.f25032U = parcel.readString();
        this.f25030S = parcel.readString();
        this.f25031T = parcel.readString();
        this.f25059q0 = parcel.readString();
        this.f25061r0 = parcel.readString();
        this.f25065t0 = parcel.readString();
        this.f25067u0 = parcel.readInt();
        this.f25004A0 = parcel.readInt();
        this.f25006B0 = parcel.readInt();
        this.f25010D0 = parcel.readInt();
        this.f25014F0 = parcel.createStringArrayList();
        this.f25012E0 = parcel.readInt();
        this.f25075y0 = parcel.readInt();
        this.f25077z0 = parcel.readString();
        parcel.readTypedList(this.f25018H0, r.CREATOR);
        Class<C2648H> cls2 = C2648H.class;
        if (i5 >= 33) {
            this.f25020I0 = (C2648H) parcel.readParcelable(cls2.getClassLoader(), cls2);
        } else {
            this.f25020I0 = (C2648H) parcel.readParcelable(cls2.getClassLoader());
        }
        this.f25003A = parcel.readString();
    }
}
