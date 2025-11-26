package u4;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.y;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import java.util.List;
import kotlin.jvm.internal.t;
import m4.b;
import o4.k;
import r3.C2733c;
import r4.a;
import s4.c;

public final class g implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return y.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(C2733c cVar, CreationExtras creationExtras) {
        return y.c(this, cVar, creationExtras);
    }

    public final ViewModel create(Class cls) {
        String str;
        List list;
        String str2;
        String str3;
        String str4;
        t.e(cls, "modelClass");
        a l5 = c.l();
        ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
        ChoiceCmpCallback callback = choiceCmp.getCallback();
        k o5 = c.o();
        m4.t tVar = null;
        if (o5.f25598i.f25477c.length() == 0) {
            m4.t tVar2 = o5.f25595f;
            if (tVar2 == null) {
                t.w("translationsText");
                tVar2 = null;
            }
            str = tVar2.f25497b.f25477c;
        } else {
            str = o5.f25598i.f25477c;
        }
        if (o5.f25598i.f25478d.isEmpty()) {
            m4.t tVar3 = o5.f25595f;
            if (tVar3 == null) {
                t.w("translationsText");
                tVar3 = null;
            }
            list = tVar3.f25497b.f25478d;
        } else {
            list = o5.f25598i.f25478d;
        }
        List list2 = list;
        if (o5.f25598i.f25481g.length() == 0) {
            m4.t tVar4 = o5.f25595f;
            if (tVar4 == null) {
                t.w("translationsText");
                tVar4 = null;
            }
            str2 = tVar4.f25497b.f25481g;
        } else {
            str2 = o5.f25598i.f25481g;
        }
        if (o5.f25598i.f25482h.length() == 0) {
            m4.t tVar5 = o5.f25595f;
            if (tVar5 == null) {
                t.w("translationsText");
                tVar5 = null;
            }
            str3 = tVar5.f25497b.f25482h;
        } else {
            str3 = o5.f25598i.f25482h;
        }
        if (o5.f25598i.f25480f.length() == 0) {
            m4.t tVar6 = o5.f25595f;
            if (tVar6 == null) {
                t.w("translationsText");
            } else {
                tVar = tVar6;
            }
            str4 = tVar.f25497b.f25480f;
        } else {
            str4 = o5.f25598i.f25480f;
        }
        return new f(l5, callback, new b(str, str2, str3, str4, o5.b(), list2), choiceCmp.getPortalConfig$app_release(), c.n(), c.e());
    }
}
