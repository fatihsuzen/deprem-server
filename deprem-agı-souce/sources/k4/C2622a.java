package k4;

import androidx.collection.a;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* renamed from: k4.a  reason: case insensitive filesystem */
public final class C2622a extends m {

    /* renamed from: h  reason: collision with root package name */
    public long f24553h;

    /* renamed from: i  reason: collision with root package name */
    public final String f24554i;

    public C2622a(long j5, String str) {
        t.e(str, NotificationCompat.CATEGORY_EVENT);
        this.f24553h = j5;
        this.f24554i = str;
    }

    public final long a() {
        return this.f24553h;
    }

    public final void b(long j5) {
        this.f24553h = j5;
    }

    public final String d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f24554i);
        jSONObject.putOpt("clientTimestamp", Long.valueOf(this.f24553h));
        String jSONObject2 = jSONObject.toString();
        t.d(jSONObject2, "JSONObject().apply {\n   …mestamp)\n    }.toString()");
        return jSONObject2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2622a)) {
            return false;
        }
        C2622a aVar = (C2622a) obj;
        if (this.f24553h == aVar.f24553h && t.a(this.f24554i, aVar.f24554i)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f24554i.hashCode() + (a.a(this.f24553h) * 31);
    }

    public final String toString() {
        return "UserEvent(clientTimestamp=" + this.f24553h + ", event=" + this.f24554i + ')';
    }
}
