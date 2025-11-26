package e1;

import android.content.Context;
import android.os.Bundle;
import b3.C2308e;
import e1.o;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import u3.C2795a;
import u3.C2797c;
import u3.C2798d;

/* renamed from: e1.b  reason: case insensitive filesystem */
public final class C1628b implements o {

    /* renamed from: b  reason: collision with root package name */
    private static final a f15229b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f15230a;

    /* renamed from: e1.b$a */
    private static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public C1628b(Context context) {
        t.e(context, "appContext");
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.f15230a = bundle == null ? Bundle.EMPTY : bundle;
    }

    public Object a(C2308e eVar) {
        return o.a.a(this, eVar);
    }

    public Boolean b() {
        if (this.f15230a.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(this.f15230a.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    public C2795a c() {
        if (this.f15230a.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return C2795a.e(C2797c.s(this.f15230a.getInt("firebase_sessions_sessions_restart_timeout"), C2798d.SECONDS));
        }
        return null;
    }

    public Double d() {
        if (this.f15230a.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(this.f15230a.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }
}
