package l2;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    private int f24944a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f24945b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24946c;

    /* renamed from: d  reason: collision with root package name */
    private int f24947d;

    public final void a(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObject");
        if (!jSONObject.isNull("id")) {
            this.f24944a = jSONObject.optInt("id");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f24945b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("isChecked")) {
            this.f24946c = jSONObject.optBoolean("isChecked");
        }
        if (!jSONObject.isNull("isTurbo")) {
            this.f24947d = jSONObject.optInt("isTurbo");
        }
    }

    public final int b() {
        return this.f24944a;
    }

    public final String c() {
        return this.f24945b;
    }

    public final boolean d() {
        return this.f24946c;
    }

    public final boolean e() {
        if (this.f24947d == 1) {
            return true;
        }
        return false;
    }
}
