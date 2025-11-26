package o;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.y;
import kotlin.jvm.internal.t;
import r3.C2733c;
import s4.c;

public final class l implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return y.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(C2733c cVar, CreationExtras creationExtras) {
        return y.c(this, cVar, creationExtras);
    }

    public final ViewModel create(Class cls) {
        t.e(cls, "modelClass");
        return new k(c.m(), c.j(), c.j().f19282c, c.o(), c.j().f19281b.b(), c.j().f19281b.f19245j, c.j().f19281b.f19247l, c.j().f19281b.f19244i, c.j().f19281b.f19246k);
    }
}
