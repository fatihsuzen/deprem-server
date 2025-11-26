package j2;

import android.content.Context;
import com.google.firebase.messaging.FirebaseMessaging;
import com.uptodown.activities.preferences.a;
import k0.C1698l;
import kotlin.jvm.internal.t;

/* renamed from: j2.b  reason: case insensitive filesystem */
public final class C2581b {
    /* access modifiers changed from: private */
    public static final void c(Context context, C1698l lVar) {
        t.e(lVar, "task");
        if (lVar.n()) {
            a.f15150a.F0(context, (String) lVar.j());
        }
    }

    public final void b(Context context) {
        t.e(context, "context");
        FirebaseMessaging.n().q().c(new C2580a(context));
    }
}
