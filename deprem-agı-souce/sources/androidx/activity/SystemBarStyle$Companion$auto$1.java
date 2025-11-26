package androidx.activity;

import android.content.res.Resources;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class SystemBarStyle$Companion$auto$1 extends u implements l {
    public static final SystemBarStyle$Companion$auto$1 INSTANCE = new SystemBarStyle$Companion$auto$1();

    SystemBarStyle$Companion$auto$1() {
        super(1);
    }

    public final Boolean invoke(Resources resources) {
        t.e(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
