package l2;

import X2.C2250q;
import a3.C2265a;
import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

public final class X implements Parcelable {
    public static Parcelable.Creator<X> CREATOR = new a();

    /* renamed from: l  reason: collision with root package name */
    public static final b f24900l = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f24901a;

    /* renamed from: b  reason: collision with root package name */
    private String f24902b;

    /* renamed from: c  reason: collision with root package name */
    private String f24903c;

    /* renamed from: d  reason: collision with root package name */
    private String f24904d;

    /* renamed from: e  reason: collision with root package name */
    private String f24905e;

    /* renamed from: f  reason: collision with root package name */
    private int f24906f;

    /* renamed from: g  reason: collision with root package name */
    private String f24907g;

    /* renamed from: h  reason: collision with root package name */
    private long f24908h;

    /* renamed from: i  reason: collision with root package name */
    private int f24909i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList f24910j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList f24911k = new ArrayList();

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public X createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new X(parcel);
        }

        /* renamed from: b */
        public X[] newArray(int i5) {
            return new X[i5];
        }
    }

    public static final class b {

        public static final class a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return C2265a.a(Long.valueOf(((c) obj2).b()), Long.valueOf(((c) obj).b()));
            }
        }

        /* renamed from: l2.X$b$b  reason: collision with other inner class name */
        public static final class C0249b implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return C2265a.a(Long.valueOf(((c) obj2).b()), Long.valueOf(((c) obj).b()));
            }
        }

        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private final c d(JSONObject jSONObject) {
            String str;
            String str2;
            long j5;
            String str3 = null;
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                str = jSONObject.optString(RewardPlus.NAME);
            } else {
                str = null;
            }
            if (!jSONObject.isNull("packagename")) {
                str2 = jSONObject.optString("packagename");
            } else {
                str2 = null;
            }
            if (!jSONObject.isNull("lastUpdate")) {
                j5 = jSONObject.optLong("lastUpdate");
            } else {
                j5 = -1;
            }
            long j6 = j5;
            if (!jSONObject.isNull(RewardPlus.ICON)) {
                str3 = jSONObject.optString(RewardPlus.ICON);
            }
            return new c(str, str2, j6, str3);
        }

        public final X a(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObject");
            X x4 = new X();
            if (!jSONObject.isNull("id")) {
                x4.m(jSONObject.optLong("id"));
            }
            if (!jSONObject.isNull("identifier")) {
                x4.n(jSONObject.optString("identifier"));
            }
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                x4.q(jSONObject.optString(RewardPlus.NAME));
            }
            if (!jSONObject.isNull("platformID")) {
                x4.s(jSONObject.optInt("platformID"));
                int j5 = x4.j();
                if (j5 == 1) {
                    x4.r("Windows");
                } else if (j5 == 3) {
                    x4.r("Mac");
                } else if (j5 == 13) {
                    x4.r("Android");
                } else if (j5 == 14) {
                    x4.r("iOS");
                }
            }
            if (!jSONObject.isNull("lastUpdate")) {
                x4.o(jSONObject.optLong("lastUpdate"));
            }
            return x4;
        }

        public final X b(X x4, JSONObject jSONObject) {
            t.e(x4, "<this>");
            t.e(jSONObject, "jsonObject");
            if (!jSONObject.isNull("brand")) {
                x4.l(jSONObject.optString("brand"));
            }
            if (!jSONObject.isNull("model")) {
                x4.p(jSONObject.optString("model"));
            }
            if (!jSONObject.isNull("securityPositivesCount")) {
                x4.t(jSONObject.optInt("securityPositivesCount"));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("installedApps");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                    t.d(optJSONObject, "optJSONObject(...)");
                    x4.d().add(d(optJSONObject));
                }
                ArrayList d5 = x4.d();
                if (d5.size() > 1) {
                    C2250q.t(d5, new a());
                }
            }
            JSONArray jSONArray = jSONObject.getJSONArray("nonInstalledApps");
            if (!jSONObject.isNull("nonInstalledApps")) {
                int length2 = jSONArray.length();
                for (int i6 = 0; i6 < length2; i6++) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i6);
                    t.d(optJSONObject2, "optJSONObject(...)");
                    x4.h().add(d(optJSONObject2));
                }
                ArrayList h5 = x4.h();
                if (h5.size() > 1) {
                    C2250q.t(h5, new C0249b());
                }
            }
            return x4;
        }

        public final ArrayList c(JSONArray jSONArray) {
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

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f24912a;

        /* renamed from: b  reason: collision with root package name */
        private final String f24913b;

        /* renamed from: c  reason: collision with root package name */
        private final long f24914c;

        /* renamed from: d  reason: collision with root package name */
        private final String f24915d;

        public c(String str, String str2, long j5, String str3) {
            this.f24912a = str;
            this.f24913b = str2;
            this.f24914c = j5;
            this.f24915d = str3;
        }

        public final String a() {
            return this.f24915d;
        }

        public final long b() {
            return this.f24914c;
        }

        public final String c() {
            return this.f24912a;
        }

        public final String d() {
            return this.f24913b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (t.a(this.f24912a, cVar.f24912a) && t.a(this.f24913b, cVar.f24913b) && this.f24914c == cVar.f24914c && t.a(this.f24915d, cVar.f24915d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i5;
            int i6;
            String str = this.f24912a;
            int i7 = 0;
            if (str == null) {
                i5 = 0;
            } else {
                i5 = str.hashCode();
            }
            int i8 = i5 * 31;
            String str2 = this.f24913b;
            if (str2 == null) {
                i6 = 0;
            } else {
                i6 = str2.hashCode();
            }
            int a5 = (((i8 + i6) * 31) + androidx.collection.a.a(this.f24914c)) * 31;
            String str3 = this.f24915d;
            if (str3 != null) {
                i7 = str3.hashCode();
            }
            return a5 + i7;
        }

        public String toString() {
            return "UserDeviceApp(name=" + this.f24912a + ", packagename=" + this.f24913b + ", lastUpdate=" + this.f24914c + ", icon=" + this.f24915d + ')';
        }
    }

    public X() {
    }

    public final String a() {
        return this.f24904d;
    }

    public final long b() {
        return this.f24901a;
    }

    public final String c() {
        return this.f24902b;
    }

    public final ArrayList d() {
        return this.f24910j;
    }

    public int describeContents() {
        return hashCode();
    }

    public final long e() {
        return this.f24908h;
    }

    public final String f() {
        return this.f24905e;
    }

    public final String g() {
        return this.f24903c;
    }

    public final ArrayList h() {
        return this.f24911k;
    }

    public final String i() {
        return this.f24907g;
    }

    public final int j() {
        return this.f24906f;
    }

    public final int k() {
        return this.f24909i;
    }

    public final void l(String str) {
        this.f24904d = str;
    }

    public final void m(long j5) {
        this.f24901a = j5;
    }

    public final void n(String str) {
        this.f24902b = str;
    }

    public final void o(long j5) {
        this.f24908h = j5;
    }

    public final void p(String str) {
        this.f24905e = str;
    }

    public final void q(String str) {
        this.f24903c = str;
    }

    public final void r(String str) {
        this.f24907g = str;
    }

    public final void s(int i5) {
        this.f24906f = i5;
    }

    public final void t(int i5) {
        this.f24909i = i5;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeLong(this.f24901a);
        parcel.writeString(this.f24902b);
        parcel.writeString(this.f24903c);
        parcel.writeString(this.f24904d);
        parcel.writeString(this.f24905e);
        parcel.writeInt(this.f24906f);
        parcel.writeString(this.f24907g);
        parcel.writeLong(this.f24908h);
        parcel.writeInt(this.f24909i);
    }

    public X(Parcel parcel) {
        t.e(parcel, "source");
        this.f24901a = parcel.readLong();
        this.f24902b = parcel.readString();
        this.f24903c = parcel.readString();
        this.f24904d = parcel.readString();
        this.f24905e = parcel.readString();
        this.f24906f = parcel.readInt();
        this.f24907g = parcel.readString();
        this.f24908h = parcel.readLong();
        this.f24909i = parcel.readInt();
    }
}
