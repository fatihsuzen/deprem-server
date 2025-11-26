package z2;

import W2.J;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.a;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.activities.preferences.a;
import g4.b;
import g4.e;
import g4.f;
import kotlin.jvm.internal.t;
import l2.C2670t;
import l2.M;

public final class F {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26483a;

    /* renamed from: b  reason: collision with root package name */
    private FirebaseAnalytics f26484b;

    /* renamed from: c  reason: collision with root package name */
    private e f26485c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f26486d = new Object();

    public F(Context context) {
        this.f26483a = context;
        if (context != null) {
            a b5 = a.b();
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            b5.d(aVar.Q(context));
            this.f26484b = FirebaseAnalytics.getInstance(context);
            if (aVar.O(context)) {
                FirebaseAnalytics firebaseAnalytics = this.f26484b;
                if (firebaseAnalytics != null) {
                    firebaseAnalytics.b(true);
                }
                c(context);
                return;
            }
            FirebaseAnalytics firebaseAnalytics2 = this.f26484b;
            if (firebaseAnalytics2 != null) {
                firebaseAnalytics2.b(false);
            }
            a();
        }
    }

    private final void a() {
        synchronized (this.f26486d) {
            this.f26485c = null;
            J j5 = J.f19942a;
        }
    }

    private final e c(Context context) {
        e eVar;
        synchronized (this.f26486d) {
            try {
                if (this.f26485c == null) {
                    this.f26485c = f.b("https://m.uptodown.net/matomo.php", 6).a(b.f22173e.a(context));
                }
                eVar = this.f26485c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public final void b() {
        if (this.f26485c != null && this.f26483a != null) {
            i4.f.c().a().a(this.f26485c);
        }
    }

    public final void d(String str, Bundle bundle) {
        t.e(str, NotificationCompat.CATEGORY_EVENT);
        t.e(bundle, "params");
        FirebaseAnalytics firebaseAnalytics = this.f26484b;
        if (firebaseAnalytics != null) {
            firebaseAnalytics.a(str, bundle);
        }
        C2670t.f25193d.g(str, bundle, this.f26483a);
    }

    public final void e(String str) {
        t.e(str, "packagename");
        Bundle bundle = new Bundle();
        bundle.putString("packagename", str);
        d("installer_overwritten", bundle);
    }

    public final void f(String str) {
        t.e(str, RewardPlus.NAME);
        if (this.f26485c != null) {
            i4.f.c().b(str).c(this.f26485c);
        }
    }

    public final void g(String str, Bundle bundle, M m5, String str2) {
        t.e(str, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            bundle = bundle2;
        }
        if (m5 != null) {
            if (m5.f() > 0) {
                bundle.putString("responseCode", String.valueOf(m5.f()));
            }
            if (m5.c() != null) {
                bundle.putString("exception", m5.c());
            }
        }
        if (str2 != null) {
            bundle.putString("workRequest", str2);
        }
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        d("tracking", bundle);
    }
}
