package E;

import L.C0668a;
import N.C0720n;
import android.os.Bundle;

public final class g implements C0668a.d {

    /* renamed from: d  reason: collision with root package name */
    public static final g f2386d = new g(new f());

    /* renamed from: a  reason: collision with root package name */
    private final String f2387a = null;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2388b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2389c;

    public g(f fVar) {
        this.f2388b = fVar.f2384a.booleanValue();
        this.f2389c = fVar.f2385b;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", (String) null);
        bundle.putBoolean("force_save_dialog", this.f2388b);
        bundle.putString("log_session_id", this.f2389c);
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean b() {
        return this.f2388b;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String c() {
        return this.f2389c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        String str = gVar.f2387a;
        if (!C0720n.a((Object) null, (Object) null) || this.f2388b != gVar.f2388b || !C0720n.a(this.f2389c, gVar.f2389c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return C0720n.b(null, Boolean.valueOf(this.f2388b), this.f2389c);
    }
}
