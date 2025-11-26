package l2;

import W2.u;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
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

/* renamed from: l2.K  reason: case insensitive filesystem */
public final class C2651K implements Parcelable {
    public static Parcelable.Creator<C2651K> CREATOR = new a();

    /* renamed from: m  reason: collision with root package name */
    public static final b f24779m = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f24780a;

    /* renamed from: b  reason: collision with root package name */
    private String f24781b;

    /* renamed from: c  reason: collision with root package name */
    private String f24782c;

    /* renamed from: d  reason: collision with root package name */
    private String f24783d;

    /* renamed from: e  reason: collision with root package name */
    private long f24784e;

    /* renamed from: f  reason: collision with root package name */
    private String f24785f;

    /* renamed from: g  reason: collision with root package name */
    private String f24786g;

    /* renamed from: h  reason: collision with root package name */
    private int f24787h;

    /* renamed from: i  reason: collision with root package name */
    private int f24788i;

    /* renamed from: j  reason: collision with root package name */
    private int f24789j;

    /* renamed from: k  reason: collision with root package name */
    private String f24790k;

    /* renamed from: l  reason: collision with root package name */
    private int f24791l;

    /* renamed from: l2.K$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2651K createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new C2651K(parcel);
        }

        /* renamed from: b */
        public C2651K[] newArray(int i5) {
            return new C2651K[i5];
        }
    }

    /* renamed from: l2.K$b */
    public static final class b {

        /* renamed from: l2.K$b$a */
        static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            Object f24792a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f24793b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f24794c;

            /* renamed from: d  reason: collision with root package name */
            int f24795d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, C2308e eVar) {
                super(eVar);
                this.f24794c = bVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f24793b = obj;
                this.f24795d |= Integer.MIN_VALUE;
                return this.f24794c.d((C2651K) null, (Context) null, this);
            }
        }

        /* renamed from: l2.K$b$b  reason: collision with other inner class name */
        static final class C0247b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f24796a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f24797b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2651K f24798c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ J f24799d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0247b(Context context, C2651K k5, J j5, C2308e eVar) {
                super(2, eVar);
                this.f24797b = context;
                this.f24798c = k5;
                this.f24799d = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0247b(this.f24797b, this.f24798c, this.f24799d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f24796a == 0) {
                    u.b(obj);
                    M K02 = new Z(this.f24797b).K0(this.f24798c.d());
                    if (!K02.b() && K02.e() != null) {
                        JSONObject e5 = K02.e();
                        t.b(e5);
                        if (!e5.isNull("success")) {
                            this.f24799d.f24688a = e5.optInt("success");
                        }
                        if (this.f24799d.f24688a == 1) {
                            this.f24798c.p(this.f24798c.e() + 1);
                        }
                    }
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0247b) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final void a(long j5) {
            P.f26510a.g().add(Long.valueOf(j5));
        }

        public final C2651K b(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObject");
            C2651K k5 = new C2651K();
            if (!jSONObject.isNull("id")) {
                k5.o(jSONObject.optLong("id"));
            }
            if (!jSONObject.isNull("userName")) {
                k5.u(jSONObject.optString("userName"));
                if (!jSONObject.isNull("userAvatar")) {
                    k5.m(jSONObject.optString("userAvatar"));
                }
                if (!jSONObject.isNull("userID")) {
                    k5.t(jSONObject.optString("userID"));
                }
            }
            if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                k5.q(jSONObject.optString(MimeTypes.BASE_TYPE_TEXT));
            }
            if (!jSONObject.isNull("timeAgo")) {
                k5.r(jSONObject.optString("timeAgo"));
            }
            if (!jSONObject.isNull("likes")) {
                k5.p(jSONObject.optInt("likes"));
            }
            if (!jSONObject.isNull("isAuthorVerified")) {
                k5.l(jSONObject.optInt("isAuthorVerified"));
            }
            if (!jSONObject.isNull("isTurbo")) {
                k5.s(jSONObject.optInt("isTurbo"));
            }
            if (!jSONObject.isNull("usernameFormat")) {
                k5.v(jSONObject.optString("usernameFormat"));
            }
            if (!jSONObject.isNull("following")) {
                k5.n(jSONObject.optInt("following"));
            }
            return k5;
        }

        public final boolean c(long j5) {
            return P.f26510a.g().contains(Long.valueOf(j5));
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object d(l2.C2651K r7, android.content.Context r8, b3.C2308e r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof l2.C2651K.b.a
                if (r0 == 0) goto L_0x0013
                r0 = r9
                l2.K$b$a r0 = (l2.C2651K.b.a) r0
                int r1 = r0.f24795d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f24795d = r1
                goto L_0x0018
            L_0x0013:
                l2.K$b$a r0 = new l2.K$b$a
                r0.<init>(r6, r9)
            L_0x0018:
                java.lang.Object r9 = r0.f24793b
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f24795d
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r7 = r0.f24792a
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
                long r4 = r7.d()
                r6.a(r4)
                kotlin.jvm.internal.J r9 = new kotlin.jvm.internal.J
                r9.<init>()
                w3.I r2 = w3.C2865c0.b()
                l2.K$b$b r4 = new l2.K$b$b
                r5 = 0
                r4.<init>(r8, r7, r9, r5)
                r0.f24792a = r9
                r0.f24795d = r3
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
            throw new UnsupportedOperationException("Method not decompiled: l2.C2651K.b.d(l2.K, android.content.Context, b3.e):java.lang.Object");
        }

        public final ArrayList e(JSONArray jSONArray) {
            t.e(jSONArray, "jsonArray");
            ArrayList arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                    t.d(optJSONObject, "optJSONObject(...)");
                    arrayList.add(b(optJSONObject));
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

    public C2651K() {
    }

    public final int a() {
        return this.f24788i;
    }

    public final String b() {
        return this.f24783d;
    }

    public final int c() {
        return this.f24791l;
    }

    public final long d() {
        return this.f24780a;
    }

    public int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f24787h;
    }

    public final Spanned f() {
        String str = this.f24785f;
        if (str == null) {
            return null;
        }
        P p5 = P.f26510a;
        t.b(str);
        return p5.c(s.L(str, "\n", "<br />", false, 4, (Object) null));
    }

    public final String g() {
        return this.f24786g;
    }

    public final String h() {
        return this.f24782c;
    }

    public final String i() {
        return this.f24781b;
    }

    public final String j() {
        return this.f24790k;
    }

    public final boolean k() {
        if (this.f24789j == 1) {
            return true;
        }
        return false;
    }

    public final void l(int i5) {
        this.f24788i = i5;
    }

    public final void m(String str) {
        this.f24783d = str;
    }

    public final void n(int i5) {
        this.f24791l = i5;
    }

    public final void o(long j5) {
        this.f24780a = j5;
    }

    public final void p(int i5) {
        this.f24787h = i5;
    }

    public final void q(String str) {
        this.f24785f = str;
    }

    public final void r(String str) {
        this.f24786g = str;
    }

    public final void s(int i5) {
        this.f24789j = i5;
    }

    public final void t(String str) {
        this.f24782c = str;
    }

    public final void u(String str) {
        this.f24781b = str;
    }

    public final void v(String str) {
        this.f24790k = str;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeLong(this.f24780a);
        parcel.writeLong(this.f24784e);
        parcel.writeString(this.f24781b);
        parcel.writeString(this.f24782c);
        parcel.writeString(this.f24783d);
        parcel.writeString(this.f24785f);
        parcel.writeString(this.f24786g);
        parcel.writeInt(this.f24787h);
        parcel.writeInt(this.f24788i);
        parcel.writeInt(this.f24789j);
        parcel.writeString(this.f24790k);
        parcel.writeInt(this.f24791l);
    }

    public C2651K(Parcel parcel) {
        t.e(parcel, "source");
        this.f24780a = parcel.readLong();
        this.f24784e = parcel.readLong();
        this.f24781b = parcel.readString();
        this.f24782c = parcel.readString();
        this.f24783d = parcel.readString();
        this.f24785f = parcel.readString();
        this.f24786g = parcel.readString();
        this.f24787h = parcel.readInt();
        this.f24788i = parcel.readInt();
        this.f24789j = parcel.readInt();
        this.f24790k = parcel.readString();
        this.f24791l = parcel.readInt();
    }
}
