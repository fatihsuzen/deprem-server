package t0;

import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Locale;
import p0.C1748a;
import u0.g;
import v0.C1894b;

class e implements C1748a.b {

    /* renamed from: a  reason: collision with root package name */
    private C1894b f16592a;

    /* renamed from: b  reason: collision with root package name */
    private C1894b f16593b;

    e() {
    }

    private static void b(C1894b bVar, String str, Bundle bundle) {
        if (bVar != null) {
            bVar.onEvent(str, bundle);
        }
    }

    private void c(String str, Bundle bundle) {
        C1894b bVar;
        if ("clx".equals(bundle.getString("_o"))) {
            bVar = this.f16592a;
        } else {
            bVar = this.f16593b;
        }
        b(bVar, str, bundle);
    }

    public void a(int i5, Bundle bundle) {
        String string;
        g.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", new Object[]{Integer.valueOf(i5), bundle}));
        if (bundle != null && (string = bundle.getString(RewardPlus.NAME)) != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            c(string, bundle2);
        }
    }

    public void d(C1894b bVar) {
        this.f16593b = bVar;
    }

    public void e(C1894b bVar) {
        this.f16592a = bVar;
    }
}
