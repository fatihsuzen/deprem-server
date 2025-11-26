package k4;

import W2.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q extends m {

    /* renamed from: h  reason: collision with root package name */
    public final List f24638h;

    /* renamed from: i  reason: collision with root package name */
    public final String f24639i;

    /* renamed from: j  reason: collision with root package name */
    public final List f24640j;

    public q(ArrayList arrayList, String str, ArrayList arrayList2) {
        t.e(arrayList, "userEvents");
        this.f24638h = arrayList;
        this.f24639i = str;
        this.f24640j = arrayList2;
    }

    public final String d() {
        ArrayList arrayList;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList2 = new ArrayList();
        for (C2622a d5 : this.f24638h) {
            arrayList2.add(new JSONObject(d5.d()));
        }
        jSONObject.put("userEvents", new JSONArray(arrayList2));
        jSONObject.putOpt("acceptanceState", this.f24639i);
        if (this.f24640j == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (s sVar : this.f24640j) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(String.valueOf(((Number) sVar.c()).intValue()), sVar.d());
                arrayList.add(jSONObject2);
            }
        }
        jSONObject.putOpt("gbcData", new JSONArray(arrayList));
        c(jSONObject);
        String jSONObject3 = jSONObject.toString();
        t.d(jSONObject3, "jsonObject.toString()");
        return jSONObject3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (t.a(this.f24638h, qVar.f24638h) && t.a(this.f24639i, qVar.f24639i) && t.a(this.f24640j, qVar.f24640j)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int hashCode = this.f24638h.hashCode() * 31;
        String str = this.f24639i;
        int i6 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i7 = (hashCode + i5) * 31;
        List list = this.f24640j;
        if (list != null) {
            i6 = list.hashCode();
        }
        return i7 + i6;
    }

    public final String toString() {
        return "TrackingUserGBCDoneLog(userEvents=" + this.f24638h + ", acceptanceState=" + this.f24639i + ", gbcData=" + this.f24640j + ')';
    }
}
