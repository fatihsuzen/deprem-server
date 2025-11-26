package l2;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* renamed from: l2.x  reason: case insensitive filesystem */
public final class C2674x implements Parcelable {
    public static final a CREATOR = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f25231a;

    /* renamed from: b  reason: collision with root package name */
    private String f25232b;

    /* renamed from: l2.x$a */
    public static final class a implements Parcelable.Creator {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* renamed from: a */
        public C2674x createFromParcel(Parcel parcel) {
            t.e(parcel, "parcel");
            return new C2674x(parcel);
        }

        /* renamed from: b */
        public C2674x[] newArray(int i5) {
            return new C2674x[i5];
        }

        private a() {
        }
    }

    public C2674x() {
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.isNull("antivirusName")) {
                this.f25231a = jSONObject.optString("antivirusName");
            }
            if (!jSONObject.isNull("virusName")) {
                this.f25232b = jSONObject.optString("virusName");
            }
        }
    }

    public final String b() {
        return this.f25231a;
    }

    public final String c() {
        return this.f25232b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeString(this.f25231a);
        parcel.writeString(this.f25232b);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C2674x(Parcel parcel) {
        this();
        t.e(parcel, "parcel");
        this.f25231a = parcel.readString();
        this.f25232b = parcel.readString();
    }
}
