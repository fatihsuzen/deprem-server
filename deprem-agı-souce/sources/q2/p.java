package Q2;

import J2.f;
import J2.u;
import P3.k;
import T3.i;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.y;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import kotlin.jvm.internal.t;
import n4.a;
import n4.h;
import o4.C2708c;
import r3.C2733c;
import s4.c;

public final class p implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return y.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(C2733c cVar, CreationExtras creationExtras) {
        return y.c(this, cVar, creationExtras);
    }

    public final ViewModel create(Class cls) {
        t.e(cls, "modelClass");
        u m5 = c.m();
        i j5 = c.j();
        ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
        f googleVendorList$app_release = choiceCmp.getGoogleVendorList$app_release();
        k b5 = c.j().f19281b.b();
        C2708c cVar = null;
        if (c.f25873u == null) {
            a i5 = c.i();
            r4.a l5 = c.l();
            h k5 = c.k();
            ChoiceCmpCallback callback = choiceCmp.getCallback();
            if (c.f25868p == null) {
                c.f25868p = new q4.c();
            }
            q4.c cVar2 = c.f25868p;
            if (cVar2 == null) {
                t.w("coreUiLabelsResolver");
                cVar2 = null;
            }
            c.f25873u = new C2708c(i5, l5, k5, new q4.k(callback, cVar2), choiceCmp.getAppPackageId(), choiceCmp.getPCode());
        }
        C2708c cVar3 = c.f25873u;
        if (cVar3 == null) {
            t.w("portalConfigRepository_");
        } else {
            cVar = cVar3;
        }
        return new o(m5, j5, googleVendorList$app_release, b5, cVar, c.d(), c.j().f19281b.f19252q, c.o().d(), c.e(), c.f());
    }
}
