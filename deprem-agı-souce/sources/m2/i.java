package M2;

import J2.u;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.y;
import kotlin.jvm.internal.t;
import o4.o;
import q4.d;
import r3.C2733c;
import s4.c;

public final class i implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return y.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(C2733c cVar, CreationExtras creationExtras) {
        return y.c(this, cVar, creationExtras);
    }

    public final ViewModel create(Class cls) {
        t.e(cls, "modelClass");
        u m5 = c.m();
        if (c.f25877y == null) {
            c.f25877y = new o(c.i(), c.k(), new d());
        }
        o oVar = c.f25877y;
        if (oVar == null) {
            t.w("disclosureRepository_");
            oVar = null;
        }
        return new h(m5, oVar, c.o());
    }
}
