package C1;

import C1.b;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class a extends b {

    /* renamed from: c  reason: collision with root package name */
    protected final HashSet f2332c;

    /* renamed from: d  reason: collision with root package name */
    protected final JSONObject f2333d;

    /* renamed from: e  reason: collision with root package name */
    protected final long f2334e;

    public a(b.C0042b bVar, HashSet hashSet, JSONObject jSONObject, long j5) {
        super(bVar);
        this.f2332c = new HashSet(hashSet);
        this.f2333d = jSONObject;
        this.f2334e = j5;
    }
}
