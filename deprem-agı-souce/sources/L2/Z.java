package l2;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Z implements Parcelable {
    public static Parcelable.Creator<Z> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final b f24927g = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f24928a;

    /* renamed from: b  reason: collision with root package name */
    private String f24929b;

    /* renamed from: c  reason: collision with root package name */
    private int f24930c;

    /* renamed from: d  reason: collision with root package name */
    private int f24931d;

    /* renamed from: e  reason: collision with root package name */
    private int f24932e;

    /* renamed from: f  reason: collision with root package name */
    private int f24933f;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public Z createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new Z(parcel);
        }

        /* renamed from: b */
        public Z[] newArray(int i5) {
            return new Z[i5];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final Z a(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObject");
            Z z4 = new Z();
            if (!jSONObject.isNull("id")) {
                z4.i(jSONObject.optLong("id"));
            }
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                z4.l(jSONObject.optString(RewardPlus.NAME));
            }
            if (!jSONObject.isNull("isInstalled")) {
                z4.j(jSONObject.optInt("isInstalled"));
            }
            if (!jSONObject.isNull("isCompatible")) {
                z4.g(jSONObject.optInt("isCompatible"));
            }
            if (!jSONObject.isNull("isCurrentDevice")) {
                z4.h(jSONObject.optInt("isCurrentDevice"));
            }
            if (!jSONObject.isNull("isLinked")) {
                z4.k(jSONObject.optInt("isLinked"));
            }
            return z4;
        }

        public final ArrayList b(JSONArray jSONArray) {
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

    public Z() {
    }

    public final long a() {
        return this.f24928a;
    }

    public final String b() {
        return this.f24929b;
    }

    public final int c() {
        return this.f24932e;
    }

    public final int d() {
        return this.f24930c;
    }

    public int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f24931d;
    }

    public final int f() {
        return this.f24933f;
    }

    public final void g(int i5) {
        this.f24932e = i5;
    }

    public final void h(int i5) {
        this.f24930c = i5;
    }

    public final void i(long j5) {
        this.f24928a = j5;
    }

    public final void j(int i5) {
        this.f24931d = i5;
    }

    public final void k(int i5) {
        this.f24933f = i5;
    }

    public final void l(String str) {
        this.f24929b = str;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeLong(this.f24928a);
        parcel.writeString(this.f24929b);
        parcel.writeInt(this.f24931d);
        parcel.writeInt(this.f24932e);
        parcel.writeInt(this.f24930c);
        parcel.writeInt(this.f24933f);
    }

    public Z(Parcel parcel) {
        t.e(parcel, "source");
        this.f24928a = parcel.readLong();
        this.f24929b = parcel.readString();
        this.f24931d = parcel.readInt();
        this.f24932e = parcel.readInt();
        this.f24930c = parcel.readInt();
        this.f24933f = parcel.readInt();
    }
}
