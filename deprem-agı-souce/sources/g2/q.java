package G2;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.y;
import com.inmobi.cmp.ChoiceCmp;
import kotlin.jvm.internal.t;
import r3.C2733c;
import s4.c;

public final class q implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return y.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(C2733c cVar, CreationExtras creationExtras) {
        return y.c(this, cVar, creationExtras);
    }

    public final ViewModel create(Class cls) {
        t.e(cls, "modelClass");
        return new p(c.h(), c.f(), ChoiceCmp.INSTANCE.getCallback());
    }
}
