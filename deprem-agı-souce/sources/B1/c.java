package B1;

import C1.b;
import C1.d;
import C1.e;
import C1.f;
import java.util.HashSet;
import org.json.JSONObject;

public class c implements b.C0042b {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f2319a;

    /* renamed from: b  reason: collision with root package name */
    private final C1.c f2320b;

    public c(C1.c cVar) {
        this.f2320b = cVar;
    }

    public JSONObject a() {
        return this.f2319a;
    }

    public void b(JSONObject jSONObject, HashSet hashSet, long j5) {
        this.f2320b.c(new e(this, hashSet, jSONObject, j5));
    }

    public void c() {
        this.f2320b.c(new d(this));
    }

    public void d(JSONObject jSONObject, HashSet hashSet, long j5) {
        this.f2320b.c(new f(this, hashSet, jSONObject, j5));
    }

    public void a(JSONObject jSONObject) {
        this.f2319a = jSONObject;
    }
}
