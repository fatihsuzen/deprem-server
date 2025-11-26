package B2;

import android.content.Context;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.t;
import z2.H;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f17344a = new i();

    private i() {
    }

    private final float a(float f5) {
        float f6 = f5 / 2.0f;
        if (((double) f6) < 0.5d) {
            return 0.5f;
        }
        return f6;
    }

    private final float b(float f5) {
        if (f5 <= 2.0f) {
            return f5 + ((float) 2);
        }
        return f5;
    }

    public final float c(Context context) {
        t.e(context, "context");
        float f5 = context.getResources().getDisplayMetrics().density;
        float f6 = 0.5f;
        if (f5 > 3.0f) {
            f5 = 3.0f;
        } else if (f5 > 2.0f) {
            f5 -= 0.75f;
        } else if (f5 > 1.0f) {
            f5 -= 0.5f;
        }
        if (((double) f5) >= 0.5d) {
            f6 = f5;
        }
        int g5 = a.f15150a.g(context);
        if (g5 == 0) {
            return a(f6);
        }
        if (g5 != 1) {
            if (g5 == 2 && UptodownApp.f13477F.R(context)) {
                return b(f6);
            }
        } else if (!H.f26488a.c()) {
            return a(f6);
        } else {
            if (UptodownApp.f13477F.R(context)) {
                return b(f6);
            }
        }
        return f6;
    }
}
