package l2;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* renamed from: l2.H  reason: case insensitive filesystem */
public final class C2648H implements Parcelable {
    public static Parcelable.Creator<C2648H> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final b f24768e = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f24769a;

    /* renamed from: b  reason: collision with root package name */
    private int f24770b;

    /* renamed from: c  reason: collision with root package name */
    private int f24771c;

    /* renamed from: d  reason: collision with root package name */
    private String f24772d;

    /* renamed from: l2.H$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2648H createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new C2648H(parcel);
        }

        /* renamed from: b */
        public C2648H[] newArray(int i5) {
            return new C2648H[i5];
        }
    }

    /* renamed from: l2.H$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final C2648H a(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObject");
            C2648H h5 = new C2648H();
            if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                h5.h(jSONObject.optString(MimeTypes.BASE_TYPE_TEXT));
            }
            if (!jSONObject.isNull("floatingCategoryID")) {
                h5.g(jSONObject.optInt("floatingCategoryID"));
            }
            if (!jSONObject.isNull("categoryID")) {
                h5.e(jSONObject.optInt("categoryID"));
            }
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                h5.f(jSONObject.optString(RewardPlus.NAME));
            }
            return h5;
        }

        private b() {
        }
    }

    public C2648H() {
        this.f24770b = -1;
        this.f24771c = -1;
    }

    public final int a() {
        return this.f24771c;
    }

    public final String b() {
        return this.f24772d;
    }

    public final int c() {
        return this.f24770b;
    }

    public final String d() {
        return this.f24769a;
    }

    public int describeContents() {
        return hashCode();
    }

    public final void e(int i5) {
        this.f24771c = i5;
    }

    public final void f(String str) {
        this.f24772d = str;
    }

    public final void g(int i5) {
        this.f24770b = i5;
    }

    public final void h(String str) {
        this.f24769a = str;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeString(this.f24769a);
        parcel.writeInt(this.f24770b);
        parcel.writeInt(this.f24771c);
        parcel.writeString(this.f24772d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C2648H(Parcel parcel) {
        this();
        t.e(parcel, "parcel");
        this.f24769a = parcel.readString();
        this.f24770b = parcel.readInt();
        this.f24771c = parcel.readInt();
        this.f24772d = parcel.readString();
    }
}
