package u1;

import A1.g;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final k f16667a;

    /* renamed from: b  reason: collision with root package name */
    private final k f16668b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16669c;

    /* renamed from: d  reason: collision with root package name */
    private final f f16670d;

    /* renamed from: e  reason: collision with root package name */
    private final i f16671e;

    private c(f fVar, i iVar, k kVar, k kVar2, boolean z4) {
        this.f16670d = fVar;
        this.f16671e = iVar;
        this.f16667a = kVar;
        if (kVar2 == null) {
            this.f16668b = k.NONE;
        } else {
            this.f16668b = kVar2;
        }
        this.f16669c = z4;
    }

    public static c a(f fVar, i iVar, k kVar, k kVar2, boolean z4) {
        g.b(fVar, "CreativeType is null");
        g.b(iVar, "ImpressionType is null");
        g.b(kVar, "Impression owner is null");
        g.e(kVar, fVar, iVar);
        return new c(fVar, iVar, kVar, kVar2, z4);
    }

    public boolean b() {
        if (k.NATIVE == this.f16667a) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (k.NATIVE == this.f16668b) {
            return true;
        }
        return false;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        A1.c.h(jSONObject, "impressionOwner", this.f16667a);
        A1.c.h(jSONObject, "mediaEventsOwner", this.f16668b);
        A1.c.h(jSONObject, "creativeType", this.f16670d);
        A1.c.h(jSONObject, "impressionType", this.f16671e);
        A1.c.h(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f16669c));
        return jSONObject;
    }
}
