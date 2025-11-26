package z2;

import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.t;
import l2.C2641A;
import l2.C2661j;
import t3.s;

public final class G {

    /* renamed from: a  reason: collision with root package name */
    public static final G f26487a = new G();

    private G() {
    }

    public final Bundle a(Bundle bundle) {
        String str;
        t.e(bundle, "params");
        H h5 = H.f26488a;
        if (h5.f()) {
            str = "wifi";
        } else {
            str = "mobile";
        }
        bundle.putString("connectionType", str);
        bundle.putLong("downBandwidthKbps", (long) h5.a());
        bundle.putLong("upBandwidthKbps", (long) h5.b());
        return bundle;
    }

    public final Bundle b(Context context, String str, Bundle bundle) {
        t.e(context, "context");
        t.e(str, "packagename");
        t.e(bundle, "bundle");
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.m() != null) {
            C2661j m5 = aVar.m();
            t.b(m5);
            String k5 = new E().k(m5.c());
            if (k5 != null && s.E(k5, str, true)) {
                bundle.putString("source", "deeplink");
                return bundle;
            }
        } else {
            C2641A b5 = C2641A.f24721f.b(context);
            if (b5 != null && s.E(b5.d(), str, true)) {
                bundle.putString("source", "notification_fcm");
            }
        }
        return bundle;
    }

    public final boolean c(String str) {
        t.e(str, "key");
        if (s.E(str, "update", true) || s.E(str, "deeplink", true) || s.E(str, "notification_fcm", true) || s.E(str, "rollback", true)) {
            return true;
        }
        return false;
    }

    public final boolean d(String str) {
        t.e(str, "key");
        if (s.E(str, "downBandwidthKbps", true) || s.E(str, "upBandwidthKbps", true) || s.E(str, "speed", true) || s.E(str, TypedValues.TransitionType.S_DURATION, true)) {
            return true;
        }
        return false;
    }

    public final String e(long j5) {
        if (j5 < 10485760) {
            return "<10MB";
        }
        if (j5 < 104857600) {
            return "<100MB";
        }
        if (j5 < 524288000) {
            return "<500MB";
        }
        if (j5 < 1073741824) {
            return "<1GB";
        }
        if (j5 < 10737418240L) {
            return "<10GB";
        }
        return "<10MB";
    }
}
