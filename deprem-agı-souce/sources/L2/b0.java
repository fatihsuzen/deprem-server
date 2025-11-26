package l2;

import android.os.Parcel;
import android.os.Parcelable;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

public final class b0 implements Parcelable {
    public static Parcelable.Creator<b0> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final b f24958c = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f24959a;

    /* renamed from: b  reason: collision with root package name */
    private String f24960b;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public b0 createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new b0(parcel);
        }

        /* renamed from: b */
        public b0[] newArray(int i5) {
            return new b0[i5];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final b0 a(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObjectVideo");
            b0 b0Var = new b0();
            if (!jSONObject.isNull("youtubeID")) {
                b0Var.c(jSONObject.optString("youtubeID"));
            }
            if (!jSONObject.isNull("image")) {
                b0Var.d(jSONObject.optString("image"));
            }
            return b0Var;
        }

        private b() {
        }
    }

    public b0() {
    }

    public final String a() {
        return this.f24959a;
    }

    public final String b() {
        if (this.f24960b == null) {
            return null;
        }
        return this.f24960b + UptodownApp.f13477F.o() + ":webp";
    }

    public final void c(String str) {
        this.f24959a = str;
    }

    public final void d(String str) {
        this.f24960b = str;
    }

    public int describeContents() {
        return hashCode();
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeString(this.f24959a);
        parcel.writeString(this.f24960b);
    }

    public b0(Parcel parcel) {
        t.e(parcel, "source");
        this.f24959a = parcel.readString();
        this.f24960b = parcel.readString();
    }
}
