package i4;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.json.JSONObject;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f24502b = g4.b.i(b.class);

    /* renamed from: a  reason: collision with root package name */
    private final Map f24503a = new ConcurrentHashMap();

    public int a() {
        return this.f24503a.size();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject(this.f24503a);
        if (jSONObject.length() > 0) {
            return jSONObject.toString();
        }
        return null;
    }
}
