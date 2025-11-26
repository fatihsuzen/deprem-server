package l2;

import W2.u;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import androidx.work.multiprocess.RemoteWorkManager;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.activities.preferences.a;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;
import t3.s;
import w3.M;
import z2.P;
import z2.Z;

public final class O implements Parcelable {
    public static Parcelable.Creator<O> CREATOR = new a();

    /* renamed from: p  reason: collision with root package name */
    public static final b f24814p = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f24815a;

    /* renamed from: b  reason: collision with root package name */
    private String f24816b;

    /* renamed from: c  reason: collision with root package name */
    private String f24817c;

    /* renamed from: d  reason: collision with root package name */
    private String f24818d;

    /* renamed from: e  reason: collision with root package name */
    private long f24819e;

    /* renamed from: f  reason: collision with root package name */
    private String f24820f;

    /* renamed from: g  reason: collision with root package name */
    private int f24821g;

    /* renamed from: h  reason: collision with root package name */
    private int f24822h;

    /* renamed from: i  reason: collision with root package name */
    private String f24823i;

    /* renamed from: j  reason: collision with root package name */
    private int f24824j;

    /* renamed from: k  reason: collision with root package name */
    private int f24825k;

    /* renamed from: l  reason: collision with root package name */
    private String f24826l;

    /* renamed from: m  reason: collision with root package name */
    private int f24827m;

    /* renamed from: n  reason: collision with root package name */
    private String f24828n;

    /* renamed from: o  reason: collision with root package name */
    private int f24829o;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public O createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new O(parcel);
        }

        /* renamed from: b */
        public O[] newArray(int i5) {
            return new O[i5];
        }
    }

    public static final class b {

        static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            Object f24830a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f24831b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f24832c;

            /* renamed from: d  reason: collision with root package name */
            int f24833d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, C2308e eVar) {
                super(eVar);
                this.f24832c = bVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f24831b = obj;
                this.f24833d |= Integer.MIN_VALUE;
                return this.f24832c.f((O) null, (Context) null, this);
            }
        }

        /* renamed from: l2.O$b$b  reason: collision with other inner class name */
        static final class C0248b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f24834a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f24835b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ O f24836c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ J f24837d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0248b(Context context, O o5, J j5, C2308e eVar) {
                super(2, eVar);
                this.f24835b = context;
                this.f24836c = o5;
                this.f24837d = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0248b(this.f24835b, this.f24836c, this.f24837d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f24834a == 0) {
                    u.b(obj);
                    M L02 = new Z(this.f24835b).L0(this.f24836c.g());
                    if (!L02.b() && L02.e() != null) {
                        JSONObject e5 = L02.e();
                        t.b(e5);
                        if (!e5.isNull("success")) {
                            this.f24837d.f24688a = e5.optInt("success");
                        }
                        if (this.f24837d.f24688a == 1) {
                            int h5 = this.f24836c.h();
                            this.f24836c.x(h5 + 1);
                            kotlin.coroutines.jvm.internal.b.b(h5);
                        } else {
                            O.f24814p.i(this.f24836c.g());
                        }
                    }
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0248b) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final void a(long j5) {
            P.f26510a.h().add(Long.valueOf(j5));
        }

        public final O b(C2672v vVar) {
            t.e(vVar, "feedItem");
            O o5 = new O();
            o5.w(vVar.h());
            o5.C(String.valueOf(vVar.j()));
            o5.D(vVar.p());
            o5.E(vVar.q());
            o5.z(vVar.i());
            o5.B(vVar.m());
            o5.y(vVar.g());
            o5.u(vVar.l());
            o5.A(vVar.n());
            o5.s(vVar.c());
            o5.x(vVar.f());
            o5.v(1);
            return o5;
        }

        public final O c(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObject");
            O o5 = new O();
            if (!jSONObject.isNull("id")) {
                o5.w(jSONObject.optLong("id"));
            }
            if (!jSONObject.isNull("userID")) {
                o5.C(jSONObject.optString("userID"));
                if (!jSONObject.isNull("userName")) {
                    o5.D(jSONObject.optString("userName"));
                }
                if (!jSONObject.isNull("userAvatar")) {
                    o5.u(jSONObject.optString("userAvatar"));
                }
            }
            if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                o5.z(jSONObject.optString(MimeTypes.BASE_TYPE_TEXT));
            }
            if (!jSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
                o5.y(jSONObject.optInt(CampaignEx.JSON_KEY_STAR));
            }
            if (!jSONObject.isNull("totalAnswers")) {
                o5.q(jSONObject.optInt("totalAnswers"));
            }
            if (!jSONObject.isNull("timeAgo")) {
                o5.A(jSONObject.optString("timeAgo"));
            }
            if (!jSONObject.isNull("likes")) {
                o5.x(jSONObject.optInt("likes"));
            }
            if (!jSONObject.isNull("isAuthorVerified")) {
                o5.t(jSONObject.optInt("isAuthorVerified"));
            }
            if (!jSONObject.isNull("isTurbo")) {
                o5.B(jSONObject.optInt("isTurbo"));
            }
            if (!jSONObject.isNull("usernameFormat")) {
                o5.E(jSONObject.optString("usernameFormat"));
            }
            if (!jSONObject.isNull("following")) {
                o5.v(jSONObject.optInt("following"));
            }
            return o5;
        }

        public final boolean d(long j5) {
            return P.f26510a.h().contains(Long.valueOf(j5));
        }

        public final boolean e(Context context, String str) {
            if (context != null) {
                a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
                String r5 = aVar.r(context);
                String s5 = aVar.s(context);
                if (s5 == null) {
                    s5 = "0";
                }
                if (str == null || !s.E(str, r5, true) || System.currentTimeMillis() - Long.parseLong(s5) >= RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS) {
                    return false;
                }
                return true;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object f(l2.O r7, android.content.Context r8, b3.C2308e r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof l2.O.b.a
                if (r0 == 0) goto L_0x0013
                r0 = r9
                l2.O$b$a r0 = (l2.O.b.a) r0
                int r1 = r0.f24833d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f24833d = r1
                goto L_0x0018
            L_0x0013:
                l2.O$b$a r0 = new l2.O$b$a
                r0.<init>(r6, r9)
            L_0x0018:
                java.lang.Object r9 = r0.f24831b
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f24833d
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r7 = r0.f24830a
                kotlin.jvm.internal.J r7 = (kotlin.jvm.internal.J) r7
                W2.u.b(r9)
                goto L_0x005a
            L_0x002d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0035:
                W2.u.b(r9)
                long r4 = r7.g()
                r6.a(r4)
                kotlin.jvm.internal.J r9 = new kotlin.jvm.internal.J
                r9.<init>()
                w3.I r2 = w3.C2865c0.b()
                l2.O$b$b r4 = new l2.O$b$b
                r5 = 0
                r4.<init>(r8, r7, r9, r5)
                r0.f24830a = r9
                r0.f24833d = r3
                java.lang.Object r7 = w3.C2872g.g(r2, r4, r0)
                if (r7 != r1) goto L_0x0059
                return r1
            L_0x0059:
                r7 = r9
            L_0x005a:
                int r7 = r7.f24688a
                java.lang.Integer r7 = kotlin.coroutines.jvm.internal.b.b(r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: l2.O.b.f(l2.O, android.content.Context, b3.e):java.lang.Object");
        }

        public final void g(O o5, JSONObject jSONObject) {
            t.e(o5, "<this>");
            t.e(jSONObject, "jsonObject");
            if (!jSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
                o5.y(jSONObject.optInt(CampaignEx.JSON_KEY_STAR));
            }
            if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                o5.z(jSONObject.optString(MimeTypes.BASE_TYPE_TEXT));
            }
        }

        public final ArrayList h(JSONArray jSONArray) {
            t.e(jSONArray, "jsonArray");
            ArrayList arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                    t.d(optJSONObject, "optJSONObject(...)");
                    arrayList.add(c(optJSONObject));
                }
                return arrayList;
            } catch (Exception e5) {
                e5.printStackTrace();
                return arrayList;
            }
        }

        public final void i(long j5) {
            P.f26510a.h().remove(Long.valueOf(j5));
        }

        public final void j(Context context, String str, String str2) {
            if (context != null) {
                if (!(str == null || str.length() == 0)) {
                    com.uptodown.activities.preferences.a.f15150a.R0(context, str);
                }
                if (str2 != null && str2.length() != 0) {
                    com.uptodown.activities.preferences.a.f15150a.S0(context, str2);
                }
            }
        }

        public final O k(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObject");
            O o5 = new O();
            if (!jSONObject.isNull("id")) {
                o5.w(jSONObject.optLong("id"));
            }
            if (!jSONObject.isNull("appName")) {
                o5.s(jSONObject.optString("appName"));
            }
            if (!jSONObject.isNull("appID")) {
                o5.r(jSONObject.optLong("appID"));
            }
            if (!jSONObject.isNull("appIcon")) {
                o5.u(jSONObject.optString("appIcon"));
            }
            if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                o5.z(jSONObject.optString(MimeTypes.BASE_TYPE_TEXT));
            }
            if (!jSONObject.isNull("rate")) {
                o5.y(jSONObject.optInt("rate"));
            }
            if (!jSONObject.isNull("publishedDate")) {
                o5.A(jSONObject.optString("publishedDate"));
            }
            if (!jSONObject.isNull("likes")) {
                o5.x(jSONObject.optInt("likes"));
            }
            if (!jSONObject.isNull("isTurbo")) {
                o5.B(jSONObject.optInt("isTurbo"));
            }
            if (!jSONObject.isNull("usernameFormat")) {
                o5.E(jSONObject.optString("usernameFormat"));
            }
            if (!jSONObject.isNull("totalAnswers")) {
                o5.q(jSONObject.optInt("totalAnswers"));
            }
            return o5;
        }

        private b() {
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final O f24838a;

        /* renamed from: b  reason: collision with root package name */
        private final int f24839b;

        public c(O o5, int i5) {
            t.e(o5, "review");
            this.f24838a = o5;
            this.f24839b = i5;
        }

        public final O a() {
            return this.f24838a;
        }

        public final int b() {
            return this.f24839b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (t.a(this.f24838a, cVar.f24838a) && this.f24839b == cVar.f24839b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f24838a.hashCode() * 31) + this.f24839b;
        }

        public String toString() {
            return "ReviewLikeData(review=" + this.f24838a + ", reviewLikedSuccessfully=" + this.f24839b + ')';
        }
    }

    public O() {
    }

    public final void A(String str) {
        this.f24823i = str;
    }

    public final void B(int i5) {
        this.f24827m = i5;
    }

    public final void C(String str) {
        this.f24816b = str;
    }

    public final void D(String str) {
        this.f24817c = str;
    }

    public final void E(String str) {
        this.f24828n = str;
    }

    public final int a() {
        return this.f24822h;
    }

    public final long b() {
        return this.f24819e;
    }

    public final String c() {
        return this.f24826l;
    }

    public final int d() {
        return this.f24825k;
    }

    public int describeContents() {
        return hashCode();
    }

    public final String e() {
        return this.f24818d;
    }

    public final int f() {
        return this.f24829o;
    }

    public final long g() {
        return this.f24815a;
    }

    public final int h() {
        return this.f24824j;
    }

    public final int i() {
        return this.f24821g;
    }

    public final String j() {
        return this.f24820f;
    }

    public final Spanned k() {
        String str = this.f24820f;
        if (str == null) {
            return null;
        }
        P p5 = P.f26510a;
        t.b(str);
        return p5.c(s.L(str, "\n", "<br />", false, 4, (Object) null));
    }

    public final String l() {
        return this.f24823i;
    }

    public final String m() {
        return this.f24816b;
    }

    public final String n() {
        return this.f24817c;
    }

    public final String o() {
        return this.f24828n;
    }

    public final boolean p() {
        if (this.f24827m == 1) {
            return true;
        }
        return false;
    }

    public final void q(int i5) {
        this.f24822h = i5;
    }

    public final void r(long j5) {
        this.f24819e = j5;
    }

    public final void s(String str) {
        this.f24826l = str;
    }

    public final void t(int i5) {
        this.f24825k = i5;
    }

    public final void u(String str) {
        this.f24818d = str;
    }

    public final void v(int i5) {
        this.f24829o = i5;
    }

    public final void w(long j5) {
        this.f24815a = j5;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeLong(this.f24815a);
        parcel.writeLong(this.f24819e);
        parcel.writeString(this.f24817c);
        parcel.writeString(this.f24816b);
        parcel.writeString(this.f24818d);
        parcel.writeString(this.f24820f);
        parcel.writeInt(this.f24821g);
        parcel.writeInt(this.f24822h);
        parcel.writeString(this.f24823i);
        parcel.writeInt(this.f24824j);
        parcel.writeInt(this.f24825k);
        parcel.writeString(this.f24826l);
        parcel.writeInt(this.f24827m);
        parcel.writeString(this.f24828n);
        parcel.writeInt(this.f24829o);
    }

    public final void x(int i5) {
        this.f24824j = i5;
    }

    public final void y(int i5) {
        this.f24821g = i5;
    }

    public final void z(String str) {
        this.f24820f = str;
    }

    public O(Parcel parcel) {
        t.e(parcel, "source");
        this.f24815a = parcel.readLong();
        this.f24819e = parcel.readLong();
        this.f24817c = parcel.readString();
        this.f24816b = parcel.readString();
        this.f24818d = parcel.readString();
        this.f24820f = parcel.readString();
        this.f24821g = parcel.readInt();
        this.f24822h = parcel.readInt();
        this.f24823i = parcel.readString();
        this.f24824j = parcel.readInt();
        this.f24825k = parcel.readInt();
        this.f24826l = parcel.readString();
        this.f24827m = parcel.readInt();
        this.f24828n = parcel.readString();
        this.f24829o = parcel.readInt();
    }
}
