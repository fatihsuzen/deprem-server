package l2;

import android.os.Parcel;
import android.os.Parcelable;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

public final class W implements Parcelable {
    public static Parcelable.Creator<W> CREATOR = new a();

    /* renamed from: m  reason: collision with root package name */
    public static final b f24887m = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f24888a;

    /* renamed from: b  reason: collision with root package name */
    private int f24889b;

    /* renamed from: c  reason: collision with root package name */
    private int f24890c;

    /* renamed from: d  reason: collision with root package name */
    private int f24891d;

    /* renamed from: e  reason: collision with root package name */
    private int f24892e;

    /* renamed from: f  reason: collision with root package name */
    private int f24893f;

    /* renamed from: g  reason: collision with root package name */
    private int f24894g;

    /* renamed from: h  reason: collision with root package name */
    private int f24895h;

    /* renamed from: i  reason: collision with root package name */
    private int f24896i;

    /* renamed from: j  reason: collision with root package name */
    private int f24897j;

    /* renamed from: k  reason: collision with root package name */
    private int f24898k;

    /* renamed from: l  reason: collision with root package name */
    private long f24899l;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public W createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new W(parcel);
        }

        /* renamed from: b */
        public W[] newArray(int i5) {
            return new W[i5];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final W a(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObject");
            W w4 = new W();
            if (!jSONObject.isNull("publicAvatarURL")) {
                w4.n(jSONObject.optString("publicAvatarURL"));
            }
            if (!jSONObject.isNull("turboUser")) {
                w4.w(jSONObject.optInt("turboUser"));
            }
            if (!jSONObject.isNull("reviews")) {
                w4.v(jSONObject.optInt("reviews"));
            }
            if (!jSONObject.isNull("likes")) {
                w4.q(jSONObject.optInt("likes"));
            }
            if (!jSONObject.isNull("replies")) {
                w4.t(jSONObject.optInt("replies"));
            }
            if (!jSONObject.isNull("likesToOtherReviews")) {
                w4.r(jSONObject.optInt("likesToOtherReviews"));
            }
            if (!jSONObject.isNull("repliesToOtherReviews")) {
                w4.u(jSONObject.optInt("repliesToOtherReviews"));
            }
            if (!jSONObject.isNull("preregistrations")) {
                w4.s(jSONObject.optInt("preregistrations"));
            }
            if (!jSONObject.isNull("downloads")) {
                w4.o(jSONObject.optInt("downloads"));
            }
            if (!jSONObject.isNull("installations")) {
                w4.p(jSONObject.optInt("installations"));
            }
            if (!jSONObject.isNull("updates")) {
                w4.x(jSONObject.optInt("updates"));
            }
            if (!jSONObject.isNull("usageTime")) {
                w4.y(jSONObject.optLong("usageTime"));
            }
            return w4;
        }

        private b() {
        }
    }

    public W() {
    }

    public final String a() {
        if (this.f24888a == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = this.f24888a;
        t.b(str);
        sb.append(str);
        sb.append(UptodownApp.f13477F.i());
        sb.append(":webp");
        return sb.toString();
    }

    public final String b() {
        return this.f24888a;
    }

    public final int c() {
        return this.f24896i;
    }

    public final int d() {
        return this.f24897j;
    }

    public int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f24891d;
    }

    public final int f() {
        return this.f24893f;
    }

    public final int g() {
        return this.f24895h;
    }

    public final int h() {
        return this.f24892e;
    }

    public final int i() {
        return this.f24894g;
    }

    public final int j() {
        return this.f24890c;
    }

    public final int k() {
        return this.f24898k;
    }

    public final long l() {
        return this.f24899l;
    }

    public final boolean m() {
        if (this.f24889b == 1) {
            return true;
        }
        return false;
    }

    public final void n(String str) {
        this.f24888a = str;
    }

    public final void o(int i5) {
        this.f24896i = i5;
    }

    public final void p(int i5) {
        this.f24897j = i5;
    }

    public final void q(int i5) {
        this.f24891d = i5;
    }

    public final void r(int i5) {
        this.f24893f = i5;
    }

    public final void s(int i5) {
        this.f24895h = i5;
    }

    public final void t(int i5) {
        this.f24892e = i5;
    }

    public final void u(int i5) {
        this.f24894g = i5;
    }

    public final void v(int i5) {
        this.f24890c = i5;
    }

    public final void w(int i5) {
        this.f24889b = i5;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeString(this.f24888a);
        parcel.writeInt(this.f24889b);
        parcel.writeInt(this.f24890c);
        parcel.writeInt(this.f24891d);
        parcel.writeInt(this.f24892e);
        parcel.writeInt(this.f24893f);
        parcel.writeInt(this.f24894g);
        parcel.writeInt(this.f24895h);
    }

    public final void x(int i5) {
        this.f24898k = i5;
    }

    public final void y(long j5) {
        this.f24899l = j5;
    }

    public W(Parcel parcel) {
        t.e(parcel, "source");
        this.f24888a = parcel.readString();
        this.f24889b = parcel.readInt();
        this.f24890c = parcel.readInt();
        this.f24891d = parcel.readInt();
        this.f24892e = parcel.readInt();
        this.f24893f = parcel.readInt();
        this.f24894g = parcel.readInt();
        this.f24895h = parcel.readInt();
    }
}
