package q2;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: q2.e  reason: case insensitive filesystem */
public final class C2718e {

    /* renamed from: b  reason: collision with root package name */
    public static final a f25687b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f25688a;

    /* renamed from: q2.e$a */
    public static final class a {
        public a(C2633k kVar) {
        }
    }

    public C2718e(Context context) {
        t.e(context, "context");
        this.f25688a = context;
    }

    public final long a() {
        try {
            return this.f25688a.getSharedPreferences("sp_uptodown_services", 0).getLong("versioncode_registered", -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    public final void b(long j5) {
        try {
            SharedPreferences.Editor edit = this.f25688a.getSharedPreferences("sp_uptodown_services", 0).edit();
            edit.putLong("versioncode_registered", j5);
            edit.apply();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
