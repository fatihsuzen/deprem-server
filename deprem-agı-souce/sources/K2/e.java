package K2;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.y;
import kotlin.jvm.internal.t;
import m4.o;
import o4.k;
import r3.C2733c;
import s4.c;

public final class e implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return y.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(C2733c cVar, CreationExtras creationExtras) {
        return y.c(this, cVar, creationExtras);
    }

    public final ViewModel create(Class cls) {
        String str;
        t.e(cls, "modelClass");
        k o5 = c.o();
        o5.i();
        if (o5.f25596g.f25362X.length() == 0) {
            m4.t tVar = o5.f25595f;
            if (tVar == null) {
                t.w("translationsText");
                tVar = null;
            }
            str = tVar.f25496a.f25362X;
        } else {
            str = o5.f25596g.f25362X;
        }
        return new d(new o(str, o5.b()));
    }
}
