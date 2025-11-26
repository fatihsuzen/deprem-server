package l2;

import android.database.Cursor;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* renamed from: l2.J  reason: case insensitive filesystem */
public final class C2650J {

    /* renamed from: a  reason: collision with root package name */
    private int f24775a = -1;

    /* renamed from: b  reason: collision with root package name */
    private long f24776b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f24777c;

    /* renamed from: d  reason: collision with root package name */
    private int f24778d = -1;

    public final long a() {
        return this.f24776b;
    }

    public final int b() {
        return this.f24778d;
    }

    public final String c() {
        return this.f24777c;
    }

    public final void d(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObject");
        this.f24776b = jSONObject.optLong("appID");
        this.f24777c = jSONObject.optString("sourceDevice");
    }

    public final void e(Cursor cursor) {
        t.e(cursor, "c");
        this.f24775a = cursor.getInt(0);
        this.f24776b = cursor.getLong(1);
        this.f24777c = cursor.getString(2);
        this.f24778d = cursor.getInt(3);
    }

    public final void f(long j5) {
        this.f24776b = j5;
    }

    public final void g(int i5) {
        this.f24778d = i5;
    }

    public final void h(String str) {
        this.f24777c = str;
    }

    public String toString() {
        return "{id=" + this.f24775a + ", appId=" + this.f24776b + ", deviceName=" + this.f24777c + ", downloadId=" + this.f24778d + '}';
    }
}
