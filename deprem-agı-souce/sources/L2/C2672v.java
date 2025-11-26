package l2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: l2.v  reason: case insensitive filesystem */
public final class C2672v implements Parcelable {
    public static Parcelable.Creator<C2672v> CREATOR = new a();

    /* renamed from: y  reason: collision with root package name */
    public static final b f25202y = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f25203a;

    /* renamed from: b  reason: collision with root package name */
    private String f25204b;

    /* renamed from: c  reason: collision with root package name */
    private long f25205c;

    /* renamed from: d  reason: collision with root package name */
    private String f25206d;

    /* renamed from: e  reason: collision with root package name */
    private int f25207e;

    /* renamed from: f  reason: collision with root package name */
    private String f25208f;

    /* renamed from: g  reason: collision with root package name */
    private int f25209g;

    /* renamed from: h  reason: collision with root package name */
    private String f25210h;

    /* renamed from: i  reason: collision with root package name */
    private String f25211i;

    /* renamed from: j  reason: collision with root package name */
    private String f25212j;

    /* renamed from: k  reason: collision with root package name */
    private long f25213k;

    /* renamed from: l  reason: collision with root package name */
    private String f25214l;

    /* renamed from: m  reason: collision with root package name */
    private int f25215m;

    /* renamed from: n  reason: collision with root package name */
    private String f25216n;

    /* renamed from: o  reason: collision with root package name */
    private long f25217o;

    /* renamed from: p  reason: collision with root package name */
    private String f25218p;

    /* renamed from: q  reason: collision with root package name */
    private String f25219q;

    /* renamed from: r  reason: collision with root package name */
    private long f25220r;

    /* renamed from: s  reason: collision with root package name */
    private long f25221s;

    /* renamed from: t  reason: collision with root package name */
    private String f25222t;

    /* renamed from: u  reason: collision with root package name */
    private String f25223u;

    /* renamed from: v  reason: collision with root package name */
    private String f25224v;

    /* renamed from: w  reason: collision with root package name */
    private String f25225w;

    /* renamed from: x  reason: collision with root package name */
    private int f25226x;

    /* renamed from: l2.v$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2672v createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new C2672v(parcel);
        }

        /* renamed from: b */
        public C2672v[] newArray(int i5) {
            return new C2672v[i5];
        }
    }

    /* renamed from: l2.v$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final C2672v a(JSONObject jSONObject) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            JSONObject optJSONObject3;
            t.e(jSONObject, "jsonObject");
            C2672v vVar = new C2672v();
            if (!jSONObject.isNull("eventID")) {
                vVar.P(jSONObject.optLong("eventID"));
            }
            if (!jSONObject.isNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                vVar.Q(jSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY));
            }
            if (!jSONObject.isNull("header") && (optJSONObject3 = jSONObject.optJSONObject("header")) != null) {
                if (!optJSONObject3.isNull("userID")) {
                    vVar.M(optJSONObject3.optLong("userID"));
                }
                if (!optJSONObject3.isNull("username")) {
                    vVar.N(optJSONObject3.optString("username"));
                }
                if (!optJSONObject3.isNull("languageID")) {
                    vVar.K(optJSONObject3.optInt("languageID"));
                }
                if (!optJSONObject3.isNull("action")) {
                    vVar.H(optJSONObject3.optString("action"));
                }
                if (!optJSONObject3.isNull("isTurbo")) {
                    vVar.J(optJSONObject3.optInt("isTurbo"));
                }
                if (!optJSONObject3.isNull("avatarURL")) {
                    vVar.I(optJSONObject3.optString("avatarURL"));
                }
                if (!optJSONObject3.isNull("timeAgo")) {
                    vVar.L(optJSONObject3.optString("timeAgo"));
                }
                if (!optJSONObject3.isNull("usernameFormat")) {
                    vVar.O(optJSONObject3.optString("usernameFormat"));
                }
            }
            if (!jSONObject.isNull("content") && (optJSONObject = jSONObject.optJSONObject("content")) != null) {
                if (!optJSONObject.isNull("userID")) {
                    vVar.F(optJSONObject.optLong("userID"));
                }
                if (!optJSONObject.isNull("shortDescription")) {
                    vVar.A(optJSONObject.optString("shortDescription"));
                }
                if (!optJSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                    vVar.E(optJSONObject.optString(MimeTypes.BASE_TYPE_TEXT));
                }
                if (!optJSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
                    vVar.z(optJSONObject.optInt(CampaignEx.JSON_KEY_STAR));
                }
                if (!optJSONObject.isNull("userListID")) {
                    vVar.G(optJSONObject.optLong("userListID"));
                }
                if (!optJSONObject.isNull("targetName")) {
                    vVar.C(optJSONObject.optString("targetName"));
                }
                if (!optJSONObject.isNull("targetURL")) {
                    vVar.D(optJSONObject.optString("targetURL"));
                }
                if (!optJSONObject.isNull("targetID")) {
                    vVar.B(optJSONObject.optLong("targetID"));
                }
                if (!optJSONObject.isNull("likes")) {
                    vVar.y(optJSONObject.optInt("likes"));
                }
                if (!optJSONObject.isNull(MBridgeConstans.DYNAMIC_VIEW_WX_APP) && (optJSONObject2 = optJSONObject.optJSONObject(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) != null) {
                    if (!optJSONObject2.isNull("appID")) {
                        vVar.t(optJSONObject2.optLong("appID"));
                    }
                    if (!optJSONObject2.isNull(RewardPlus.NAME)) {
                        vVar.v(optJSONObject2.optString(RewardPlus.NAME));
                    }
                    if (!optJSONObject2.isNull("appURL")) {
                        vVar.x(optJSONObject2.optString("appURL"));
                    }
                    if (!optJSONObject2.isNull("shortDescription")) {
                        vVar.w(optJSONObject2.optString("shortDescription"));
                    }
                    if (!optJSONObject2.isNull("iconURL")) {
                        vVar.u(optJSONObject2.optString("iconURL"));
                    }
                }
            }
            return vVar;
        }

        public final ArrayList b(JSONArray jSONArray) {
            t.e(jSONArray, "jsonArray");
            ArrayList arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                    t.d(optJSONObject, "optJSONObject(...)");
                    arrayList.add(a(optJSONObject));
                }
                return arrayList;
            } catch (Exception e5) {
                e5.printStackTrace();
                return arrayList;
            }
        }

        private b() {
        }
    }

    public C2672v() {
    }

    public final void A(String str) {
        this.f25216n = str;
    }

    public final void B(long j5) {
        this.f25220r = j5;
    }

    public final void C(String str) {
        this.f25218p = str;
    }

    public final void D(String str) {
        this.f25219q = str;
    }

    public final void E(String str) {
        this.f25214l = str;
    }

    public final void F(long j5) {
        this.f25213k = j5;
    }

    public final void G(long j5) {
        this.f25217o = j5;
    }

    public final void H(String str) {
        this.f25208f = str;
    }

    public final void I(String str) {
        this.f25210h = str;
    }

    public final void J(int i5) {
        this.f25209g = i5;
    }

    public final void K(int i5) {
        this.f25207e = i5;
    }

    public final void L(String str) {
        this.f25211i = str;
    }

    public final void M(long j5) {
        this.f25205c = j5;
    }

    public final void N(String str) {
        this.f25206d = str;
    }

    public final void O(String str) {
        this.f25212j = str;
    }

    public final void P(long j5) {
        this.f25203a = j5;
    }

    public final void Q(String str) {
        this.f25204b = str;
    }

    public final long a() {
        return this.f25221s;
    }

    public final String b() {
        return this.f25225w;
    }

    public final String c() {
        return this.f25222t;
    }

    public final String d() {
        return this.f25224v;
    }

    public int describeContents() {
        return hashCode();
    }

    public final String e() {
        return this.f25223u;
    }

    public final int f() {
        return this.f25226x;
    }

    public final int g() {
        return this.f25215m;
    }

    public final long h() {
        return this.f25220r;
    }

    public final String i() {
        return this.f25214l;
    }

    public final long j() {
        return this.f25213k;
    }

    public final String k() {
        return this.f25208f;
    }

    public final String l() {
        return this.f25210h;
    }

    public final int m() {
        return this.f25209g;
    }

    public final String n() {
        return this.f25211i;
    }

    public final long o() {
        return this.f25205c;
    }

    public final String p() {
        return this.f25206d;
    }

    public final String q() {
        return this.f25212j;
    }

    public final String r() {
        return this.f25204b;
    }

    public final boolean s() {
        if (this.f25209g == 1) {
            return true;
        }
        return false;
    }

    public final void t(long j5) {
        this.f25221s = j5;
    }

    public final void u(String str) {
        this.f25225w = str;
    }

    public final void v(String str) {
        this.f25222t = str;
    }

    public final void w(String str) {
        this.f25224v = str;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeLong(this.f25203a);
        parcel.writeString(this.f25204b);
        parcel.writeLong(this.f25205c);
        parcel.writeString(this.f25206d);
        parcel.writeInt(this.f25207e);
        parcel.writeString(this.f25208f);
        parcel.writeInt(this.f25209g);
        parcel.writeString(this.f25210h);
        parcel.writeString(this.f25211i);
        parcel.writeString(this.f25212j);
        parcel.writeLong(this.f25213k);
        parcel.writeString(this.f25214l);
        parcel.writeInt(this.f25215m);
        parcel.writeString(this.f25216n);
        parcel.writeLong(this.f25217o);
        parcel.writeString(this.f25218p);
        parcel.writeString(this.f25219q);
        parcel.writeLong(this.f25220r);
        parcel.writeLong(this.f25221s);
        parcel.writeString(this.f25222t);
        parcel.writeString(this.f25223u);
        parcel.writeString(this.f25224v);
        parcel.writeString(this.f25225w);
        parcel.writeInt(this.f25226x);
    }

    public final void x(String str) {
        this.f25223u = str;
    }

    public final void y(int i5) {
        this.f25226x = i5;
    }

    public final void z(int i5) {
        this.f25215m = i5;
    }

    public C2672v(Parcel parcel) {
        t.e(parcel, "source");
        this.f25203a = parcel.readLong();
        this.f25204b = parcel.readString();
        this.f25205c = parcel.readLong();
        this.f25206d = parcel.readString();
        this.f25207e = parcel.readInt();
        this.f25208f = parcel.readString();
        this.f25209g = parcel.readInt();
        this.f25210h = parcel.readString();
        this.f25211i = parcel.readString();
        this.f25212j = parcel.readString();
        this.f25213k = parcel.readLong();
        this.f25214l = parcel.readString();
        this.f25215m = parcel.readInt();
        this.f25216n = parcel.readString();
        this.f25217o = parcel.readLong();
        this.f25218p = parcel.readString();
        this.f25219q = parcel.readString();
        this.f25220r = parcel.readLong();
        this.f25221s = parcel.readLong();
        this.f25222t = parcel.readString();
        this.f25223u = parcel.readString();
        this.f25224v = parcel.readString();
        this.f25225w = parcel.readString();
        this.f25226x = parcel.readInt();
    }
}
