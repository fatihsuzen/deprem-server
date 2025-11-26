package z2;

import android.content.Context;
import com.uptodown.UptodownApp;
import g0.C1664a;
import kotlin.jvm.internal.t;

public final class N {
    public final void a(Context context) {
        t.e(context, "context");
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (!aVar.u()) {
            aVar.C0(true);
            try {
                C1664a.a(context);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
