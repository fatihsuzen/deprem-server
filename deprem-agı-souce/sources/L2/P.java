package l2;

import android.os.Parcel;
import android.os.Parcelable;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

public final class P implements Parcelable {
    public static Parcelable.Creator<P> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final b f24840e = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f24841a;

    /* renamed from: b  reason: collision with root package name */
    private int f24842b;

    /* renamed from: c  reason: collision with root package name */
    private int f24843c;

    /* renamed from: d  reason: collision with root package name */
    private int f24844d;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public P createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new P(parcel);
        }

        /* renamed from: b */
        public P[] newArray(int i5) {
            return new P[i5];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final P a(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObjectScreenshot");
            P p5 = new P();
            if (!jSONObject.isNull("screenshotURL")) {
                p5.g(jSONObject.optString("screenshotURL"));
            }
            if (!jSONObject.isNull("isVertical")) {
                p5.h(jSONObject.optInt("isVertical"));
            }
            if (!jSONObject.isNull("featured")) {
                p5.f(jSONObject.optInt("featured"));
            }
            return p5;
        }

        public final P b(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObjectScreenshot");
            P p5 = new P();
            if (!jSONObject.isNull("screenshotURL")) {
                p5.g(jSONObject.optString("screenshotURL"));
            }
            if (!jSONObject.isNull("isVertical")) {
                p5.h(jSONObject.optInt("isVertical"));
            }
            return p5;
        }

        private b() {
        }
    }

    public P() {
    }

    public final int a() {
        return this.f24843c;
    }

    public final int b() {
        return this.f24842b;
    }

    public final String c() {
        return this.f24841a;
    }

    public final String d() {
        if (this.f24841a == null) {
            return null;
        }
        return this.f24841a + UptodownApp.f13477F.A() + ":webp";
    }

    public int describeContents() {
        return hashCode();
    }

    public final String e() {
        if (this.f24841a == null) {
            return null;
        }
        return this.f24841a + UptodownApp.f13477F.z() + ":webp";
    }

    public final void f(int i5) {
        this.f24843c = i5;
    }

    public final void g(String str) {
        this.f24841a = str;
    }

    public final void h(int i5) {
        this.f24844d = i5;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "dest");
        parcel.writeString(this.f24841a);
        parcel.writeInt(this.f24842b);
        parcel.writeInt(this.f24843c);
        parcel.writeInt(this.f24844d);
    }

    public P(Parcel parcel) {
        t.e(parcel, "source");
        this.f24841a = parcel.readString();
        this.f24842b = parcel.readInt();
        this.f24843c = parcel.readInt();
        this.f24844d = parcel.readInt();
    }
}
