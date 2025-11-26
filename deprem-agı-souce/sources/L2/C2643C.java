package l2;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.r;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: l2.C  reason: case insensitive filesystem */
public final class C2643C implements Parcelable {
    public static Parcelable.Creator<C2643C> CREATOR = new a();

    /* renamed from: j  reason: collision with root package name */
    public static final b f24734j = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f24735a;

    /* renamed from: b  reason: collision with root package name */
    private long f24736b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f24737c;

    /* renamed from: d  reason: collision with root package name */
    private long f24738d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f24739e;

    /* renamed from: f  reason: collision with root package name */
    private String f24740f;

    /* renamed from: g  reason: collision with root package name */
    private String f24741g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f24742h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList f24743i = new ArrayList();

    /* renamed from: l2.C$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2643C createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new C2643C(parcel);
        }

        /* renamed from: b */
        public C2643C[] newArray(int i5) {
            return new C2643C[i5];
        }
    }

    /* renamed from: l2.C$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final ArrayList a(JSONObject jSONObject) {
            int i5;
            t.e(jSONObject, "jsonObject");
            if (!jSONObject.isNull("success")) {
                i5 = jSONObject.optInt("success", 0);
            } else {
                i5 = 1;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
            if (i5 != 1 || optJSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                C2643C c5 = new C2643C();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (!optJSONObject.isNull("fileID")) {
                    c5.k(optJSONObject.optString("fileID"));
                }
                if (!optJSONObject.isNull("version")) {
                    c5.r(optJSONObject.optString("version"));
                }
                if (!optJSONObject.isNull("versionCode")) {
                    c5.q(optJSONObject.optLong("versionCode"));
                }
                if (!optJSONObject.isNull("sizeInBytes")) {
                    c5.p(optJSONObject.optLong("sizeInBytes"));
                }
                if (!optJSONObject.isNull("minSDKVersion")) {
                    c5.n(optJSONObject.optString("minSDKVersion"));
                }
                if (!optJSONObject.isNull("lastUpdate")) {
                    c5.m(optJSONObject.optString("lastUpdate"));
                }
                if (!optJSONObject.isNull("fileType")) {
                    c5.l(optJSONObject.optString("fileType"));
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("requiredFeatures");
                if (optJSONArray2 != null) {
                    c5.o(new ArrayList());
                    int length2 = optJSONArray2.length();
                    for (int i7 = 0; i7 < length2; i7++) {
                        ArrayList f5 = c5.f();
                        if (f5 != null) {
                            f5.add(optJSONArray2.optString(i7));
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("containedFiles");
                if (optJSONArray3 != null) {
                    c5.j(new ArrayList());
                    int length3 = optJSONArray3.length();
                    for (int i8 = 0; i8 < length3; i8++) {
                        JSONObject jSONObject2 = optJSONArray3.getJSONObject(i8);
                        r.b bVar = r.f25178k;
                        t.b(jSONObject2);
                        c5.a().add(bVar.a(jSONObject2));
                    }
                }
                arrayList.add(c5);
            }
            return arrayList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
            r1 = com.uptodown.activities.preferences.a.f15150a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(android.content.Context r5, l2.C2655d r6, android.os.Bundle r7) {
            /*
                r4 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.t.e(r5, r0)
                java.lang.String r0 = "bundleParamsInstalled"
                kotlin.jvm.internal.t.e(r7, r0)
                r0 = 0
                if (r6 == 0) goto L_0x0049
                com.uptodown.activities.preferences.a$a r1 = com.uptodown.activities.preferences.a.f15150a
                int r2 = r1.i(r5)
                if (r2 < 0) goto L_0x0049
                z2.B$a r3 = z2.C2940B.f26458v
                z2.B r3 = r3.a(r5)
                r3.a()
                l2.q r2 = r3.i0(r2)
                if (r2 == 0) goto L_0x0046
                r0 = 1
                r6.N(r0)
                l2.d$c r2 = l2.C2655d.c.UPDATED
                r6.c0(r2)
                r3.v1(r6)
                java.lang.String r6 = r6.o()
                kotlin.jvm.internal.t.b(r6)
                r3.R(r6)
                z2.E r6 = new z2.E
                r6.<init>()
                r6.c(r5)
                r6 = -1
                r1.B0(r5, r6)
            L_0x0046:
                r3.m()
            L_0x0049:
                java.lang.String r5 = "rollback"
                r7.putInt(r5, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: l2.C2643C.b.b(android.content.Context, l2.d, android.os.Bundle):void");
        }

        private b() {
        }
    }

    public C2643C() {
    }

    public final ArrayList a() {
        return this.f24743i;
    }

    public final String b() {
        return this.f24741g;
    }

    public final String c() {
        return this.f24740f;
    }

    public final String d() {
        return this.f24737c;
    }

    public int describeContents() {
        return hashCode();
    }

    public final String e() {
        return this.f24739e;
    }

    public final ArrayList f() {
        return this.f24742h;
    }

    public final long g() {
        return this.f24736b;
    }

    public final long h() {
        return this.f24738d;
    }

    public final String i() {
        return this.f24735a;
    }

    public final void j(ArrayList arrayList) {
        t.e(arrayList, "<set-?>");
        this.f24743i = arrayList;
    }

    public final void k(String str) {
        this.f24741g = str;
    }

    public final void l(String str) {
        this.f24740f = str;
    }

    public final void m(String str) {
        this.f24737c = str;
    }

    public final void n(String str) {
        this.f24739e = str;
    }

    public final void o(ArrayList arrayList) {
        this.f24742h = arrayList;
    }

    public final void p(long j5) {
        this.f24736b = j5;
    }

    public final void q(long j5) {
        this.f24738d = j5;
    }

    public final void r(String str) {
        this.f24735a = str;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeString(this.f24735a);
        parcel.writeString(this.f24737c);
        parcel.writeLong(this.f24738d);
        parcel.writeString(this.f24739e);
        parcel.writeString(this.f24740f);
        parcel.writeString(this.f24741g);
        parcel.writeLong(this.f24736b);
    }

    public C2643C(Parcel parcel) {
        t.e(parcel, "source");
        this.f24735a = parcel.readString();
        this.f24737c = parcel.readString();
        this.f24738d = parcel.readLong();
        this.f24739e = parcel.readString();
        this.f24740f = parcel.readString();
        this.f24741g = parcel.readString();
        this.f24736b = parcel.readLong();
    }
}
