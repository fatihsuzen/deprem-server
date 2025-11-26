package l2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: l2.i  reason: case insensitive filesystem */
public final class C2660i implements Parcelable {
    public static Parcelable.Creator<C2660i> CREATOR = new a();

    /* renamed from: i  reason: collision with root package name */
    public static final b f25094i = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private int f25095a;

    /* renamed from: b  reason: collision with root package name */
    private String f25096b;

    /* renamed from: c  reason: collision with root package name */
    private String f25097c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f25098d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25099e;

    /* renamed from: f  reason: collision with root package name */
    private int f25100f;

    /* renamed from: g  reason: collision with root package name */
    private int f25101g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f25102h;

    /* renamed from: l2.i$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2660i createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new C2660i(parcel);
        }

        /* renamed from: b */
        public C2660i[] newArray(int i5) {
            return new C2660i[i5];
        }
    }

    /* renamed from: l2.i$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final ArrayList a(String str, int i5) {
            t.e(str, "json");
            return c(new JSONObject(str), i5);
        }

        public final ArrayList b(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            t.e(jSONObject2, "jsonObject");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject2.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                    int optInt = optJSONObject.optInt("id");
                    C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
                    t.b(optJSONObject);
                    iVar.o(optJSONObject, optInt);
                    if (optInt == 831) {
                        iVar.t(new ArrayList());
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("children");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i6 = 0; i6 < length2; i6++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i6);
                                C2660i iVar2 = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
                                t.b(optJSONObject2);
                                iVar2.o(optJSONObject2, optInt);
                                ArrayList a5 = iVar.a();
                                t.b(a5);
                                a5.add(iVar2);
                            }
                        }
                    }
                    arrayList.add(iVar);
                }
            }
            return arrayList;
        }

        public final ArrayList c(JSONObject jSONObject, int i5) {
            t.e(jSONObject, "jsonObject");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i6 = 0; i6 < length; i6++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                    C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
                    t.b(optJSONObject);
                    iVar.o(optJSONObject, i5);
                    arrayList.add(iVar);
                }
            }
            return arrayList;
        }

        public final ArrayList d(String str) {
            t.e(str, "json");
            return e(new JSONObject(str));
        }

        public final ArrayList e(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObject");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                    C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
                    t.b(optJSONObject);
                    iVar.r(optJSONObject);
                    arrayList.add(iVar);
                }
            }
            return arrayList;
        }

        private b() {
        }
    }

    public C2660i(int i5, String str, String str2) {
        this.f25095a = i5;
        this.f25096b = str;
        this.f25097c = str2;
    }

    public final ArrayList a() {
        return this.f25102h;
    }

    public final String b() {
        return this.f25097c;
    }

    public final int c() {
        return this.f25095a;
    }

    public final int d() {
        int i5 = this.f25095a;
        if (i5 == 648 || i5 == 567 || i5 == 563) {
            return 12;
        }
        return 20;
    }

    public int describeContents() {
        return hashCode();
    }

    public final String e() {
        return this.f25096b;
    }

    public final int f() {
        return this.f25100f;
    }

    public final int g() {
        int i5;
        if (!(this.f25100f != 523 || (i5 = this.f25095a) == 568 || i5 == 593 || i5 == 645)) {
            switch (i5) {
                case 558:
                case 559:
                case 560:
                case 562:
                    return 5;
                case 561:
                    break;
                default:
                    switch (i5) {
                        case 564:
                        case 565:
                        case 566:
                            return 5;
                        default:
                            return 6;
                    }
            }
        }
        return 1;
    }

    public final boolean h() {
        if (this.f25100f != 0) {
            return true;
        }
        return false;
    }

    public final boolean i() {
        return this.f25098d;
    }

    public final int j() {
        return this.f25101g;
    }

    public final boolean k() {
        int i5 = this.f25100f;
        if (i5 == 0 || i5 == 831) {
            return false;
        }
        return true;
    }

    public final boolean l() {
        return this.f25099e;
    }

    public final boolean m() {
        int i5 = this.f25095a;
        if (i5 == -3 || i5 == -2) {
            return false;
        }
        return true;
    }

    public final void n(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObjectData");
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f25096b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("id")) {
            this.f25095a = jSONObject.optInt("id");
        }
        if (!jSONObject.isNull("isGame")) {
            this.f25101g = jSONObject.optInt("isGame");
        }
    }

    public final void o(JSONObject jSONObject, int i5) {
        t.e(jSONObject, "jsonObjectData");
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f25096b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("id")) {
            this.f25095a = jSONObject.optInt("id");
        }
        this.f25100f = i5;
    }

    public final void p(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObjectData");
        if (!jSONObject.isNull("id")) {
            this.f25095a = jSONObject.optInt("id");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f25096b = jSONObject.optString(RewardPlus.NAME);
        } else if (!jSONObject.isNull("value")) {
            this.f25096b = jSONObject.optString("value");
        }
        if (!jSONObject.isNull("description")) {
            this.f25097c = jSONObject.optString("description");
        }
        this.f25098d = true;
    }

    public final void q(Bundle bundle) {
        t.e(bundle, "arg");
        this.f25095a = bundle.getInt("id");
        this.f25096b = bundle.getString(RewardPlus.NAME);
        this.f25097c = bundle.getString("description");
        this.f25098d = bundle.getBoolean("isFloating");
        this.f25100f = bundle.getInt("parentCategoryId");
        this.f25101g = bundle.getInt("isGame");
        this.f25099e = bundle.getBoolean("isLeaf");
    }

    public final void r(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObjectData");
        if (!jSONObject.isNull("id")) {
            this.f25095a = jSONObject.optInt("id");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f25096b = jSONObject.optString(RewardPlus.NAME);
        }
        if (jSONObject.isNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
            return;
        }
        if (t.a(jSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY), "floatingCategory")) {
            this.f25098d = true;
        } else {
            this.f25099e = true;
        }
    }

    public final Bundle s() {
        Bundle bundle = new Bundle();
        bundle.putInt("id", this.f25095a);
        bundle.putString(RewardPlus.NAME, this.f25096b);
        bundle.putString("description", this.f25097c);
        bundle.putBoolean("isFloating", this.f25098d);
        bundle.putInt("parentCategoryId", this.f25100f);
        bundle.putInt("isGame", this.f25101g);
        bundle.putBoolean("isLeaf", this.f25099e);
        return bundle;
    }

    public final void t(ArrayList arrayList) {
        this.f25102h = arrayList;
    }

    public final void u(String str) {
        this.f25097c = str;
    }

    public final void v(boolean z4) {
        this.f25098d = z4;
    }

    public final void w(int i5) {
        this.f25095a = i5;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeInt(this.f25095a);
        parcel.writeString(this.f25096b);
        parcel.writeString(this.f25097c);
        parcel.writeBooleanArray(new boolean[]{this.f25098d, this.f25099e});
        parcel.writeInt(this.f25100f);
        parcel.writeInt(this.f25101g);
        parcel.writeTypedList(this.f25102h);
    }

    public final void x(String str) {
        this.f25096b = str;
    }

    public final void y(int i5) {
        this.f25100f = i5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2660i(int i5, String str, String str2, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 0 : i5, (i6 & 2) != 0 ? null : str, (i6 & 4) != 0 ? null : str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C2660i(Parcel parcel) {
        this(0, (String) null, (String) null, 7, (C2633k) null);
        t.e(parcel, "source");
        this.f25095a = parcel.readInt();
        this.f25096b = parcel.readString();
        this.f25097c = parcel.readString();
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f25098d = zArr[0];
        this.f25099e = zArr[1];
        this.f25100f = parcel.readInt();
        this.f25101g = parcel.readInt();
        this.f25102h = parcel.createTypedArrayList(CREATOR);
    }
}
