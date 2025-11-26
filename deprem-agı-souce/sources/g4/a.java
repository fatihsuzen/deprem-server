package g4;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0241a f22171b = new C0241a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f22172a;

    /* renamed from: g4.a$a  reason: collision with other inner class name */
    public static final class C0241a {
        public /* synthetic */ C0241a(C2633k kVar) {
            this();
        }

        private C0241a() {
        }
    }

    public a(b bVar) {
        t.e(bVar, "matomo");
        this.f22172a = bVar.g();
    }

    public final void a(e eVar) {
        t.e(eVar, "tracker");
        SharedPreferences g5 = eVar.g();
        if (this.f22172a.getBoolean("matomo.optout", false)) {
            g5.edit().putBoolean("tracker.optout", true).apply();
            this.f22172a.edit().remove("matomo.optout").apply();
        }
        if (this.f22172a.contains("tracker.userid")) {
            g5.edit().putString("tracker.userid", this.f22172a.getString("tracker.userid", UUID.randomUUID().toString())).apply();
            this.f22172a.edit().remove("tracker.userid").apply();
        }
        if (this.f22172a.contains("tracker.firstvisit")) {
            g5.edit().putLong("tracker.firstvisit", this.f22172a.getLong("tracker.firstvisit", -1)).apply();
            this.f22172a.edit().remove("tracker.firstvisit").apply();
        }
        if (this.f22172a.contains("tracker.visitcount")) {
            g5.edit().putLong("tracker.visitcount", (long) this.f22172a.getInt("tracker.visitcount", 0)).apply();
            this.f22172a.edit().remove("tracker.visitcount").apply();
        }
        if (this.f22172a.contains("tracker.previousvisit")) {
            g5.edit().putLong("tracker.previousvisit", this.f22172a.getLong("tracker.previousvisit", -1)).apply();
            this.f22172a.edit().remove("tracker.previousvisit").apply();
        }
        Map<String, ?> all = this.f22172a.getAll();
        t.d(all, "getAll(...)");
        for (Map.Entry<String, ?> key : all.entrySet()) {
            String str = (String) key.getKey();
            t.b(str);
            if (s.P(str, "downloaded:", false, 2, (Object) null)) {
                g5.edit().putBoolean(str, true).apply();
                this.f22172a.edit().remove(str).apply();
            }
        }
    }
}
