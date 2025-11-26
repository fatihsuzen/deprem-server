package I2;

import J2.f;
import J2.u;
import P3.k;
import T3.i;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.y;
import com.inmobi.cmp.ChoiceCmp;
import java.util.List;
import kotlin.jvm.internal.t;
import o4.m;
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
        u m5 = c.m();
        i j5 = c.j();
        f googleVendorList$app_release = ChoiceCmp.INSTANCE.getGoogleVendorList$app_release();
        k b5 = c.j().f19281b.b();
        m d5 = c.d();
        o4.k o5 = c.o();
        List list = c.j().f19285f.f25484j;
        List list2 = c.j().f19281b.f19247l;
        List list3 = c.j().f19281b.f19244i;
        List list4 = c.j().f19281b.f19261z;
        Integer num = c.j().f19281b.f19217H;
        return new k(m5, j5, googleVendorList$app_release, b5, d5, o5, list, list2, list3, list4, c.e());
    }
}
