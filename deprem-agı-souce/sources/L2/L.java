package l2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

public final class L implements Parcelable {
    public static final a CREATOR = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f24800a;

    /* renamed from: b  reason: collision with root package name */
    private int f24801b;

    /* renamed from: c  reason: collision with root package name */
    private int f24802c;

    /* renamed from: d  reason: collision with root package name */
    private String f24803d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f24804e;

    public static final class a implements Parcelable.Creator {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* renamed from: a */
        public L createFromParcel(Parcel parcel) {
            t.e(parcel, "parcel");
            return new L(parcel);
        }

        /* renamed from: b */
        public L[] newArray(int i5) {
            return new L[i5];
        }

        private a() {
        }
    }

    public L() {
    }

    public final void a(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObject");
        if (!jSONObject.isNull("sha256")) {
            this.f24800a = jSONObject.optString("sha256");
        }
        if (!jSONObject.isNull("scans")) {
            this.f24801b = jSONObject.optInt("scans");
        }
        if (!jSONObject.isNull("positives")) {
            this.f24802c = jSONObject.optInt("positives");
        }
        if (!jSONObject.isNull("lastAnalysis")) {
            this.f24803d = jSONObject.optString("lastAnalysis");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("infections");
        if (optJSONArray != null) {
            this.f24804e = new ArrayList();
            int length = optJSONArray.length();
            for (int i5 = 0; i5 < length; i5++) {
                C2674x xVar = new C2674x();
                xVar.a(optJSONArray.optJSONObject(i5));
                ArrayList arrayList = this.f24804e;
                t.b(arrayList);
                arrayList.add(xVar);
            }
        }
    }

    public final ArrayList b() {
        return this.f24804e;
    }

    public final String c() {
        return this.f24803d;
    }

    public final int d() {
        return this.f24802c;
    }

    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f24801b;
    }

    public final String f() {
        return this.f24800a;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeString(this.f24800a);
        parcel.writeInt(this.f24801b);
        parcel.writeInt(this.f24802c);
        parcel.writeString(this.f24803d);
        parcel.writeList(this.f24804e);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public L(Parcel parcel) {
        this();
        t.e(parcel, "parcel");
        this.f24800a = parcel.readString();
        this.f24801b = parcel.readInt();
        this.f24802c = parcel.readInt();
        this.f24803d = parcel.readString();
        ArrayList arrayList = this.f24804e;
        if (arrayList == null || arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            this.f24804e = arrayList2;
            t.b(arrayList2);
            parcel.readList(arrayList2, C2674x.class.getClassLoader());
        }
    }
}
