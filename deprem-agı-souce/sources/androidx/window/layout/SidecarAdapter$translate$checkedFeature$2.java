package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class SidecarAdapter$translate$checkedFeature$2 extends u implements l {
    public static final SidecarAdapter$translate$checkedFeature$2 INSTANCE = new SidecarAdapter$translate$checkedFeature$2();

    SidecarAdapter$translate$checkedFeature$2() {
        super(1);
    }

    public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
        t.e(sidecarDisplayFeature, "$this$require");
        return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
    }
}
