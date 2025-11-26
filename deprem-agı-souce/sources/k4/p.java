package k4;

import W2.J;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p extends m {

    /* renamed from: h  reason: collision with root package name */
    public final List f24637h;

    public p(ArrayList arrayList) {
        t.e(arrayList, "userEvents");
        this.f24637h = arrayList;
    }

    public final String d() {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        for (C2622a d5 : this.f24637h) {
            arrayList.add(new JSONObject(d5.d()));
        }
        jSONObject.put("userEvents", new JSONArray(arrayList));
        c(jSONObject);
        J.f19942a.toString();
        String jSONObject2 = jSONObject.toString();
        t.d(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof p) && t.a(this.f24637h, ((p) obj).f24637h)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f24637h.hashCode();
    }

    public final String toString() {
        return "TrackingUserEventsLog(userEvents=" + this.f24637h + ')';
    }
}
