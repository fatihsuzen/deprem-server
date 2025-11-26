package h4;

import org.json.JSONObject;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final String f23774a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f23775b;

    /* renamed from: c  reason: collision with root package name */
    private final long f23776c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23777d;

    public j(String str) {
        this(str, (JSONObject) null, 1);
    }

    public int a() {
        return this.f23777d;
    }

    public JSONObject b() {
        return this.f23775b;
    }

    public String c() {
        return this.f23774a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Packet(");
        if (this.f23775b != null) {
            sb.append("type=POST, data=");
            sb.append(this.f23775b);
        } else {
            sb.append("type=GET, data=");
            sb.append(this.f23774a);
        }
        sb.append(")");
        return sb.toString();
    }

    public j(String str, JSONObject jSONObject, int i5) {
        this.f23774a = str;
        this.f23775b = jSONObject;
        this.f23777d = i5;
        this.f23776c = System.currentTimeMillis();
    }
}
