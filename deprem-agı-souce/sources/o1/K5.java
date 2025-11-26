package O1;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import l2.C2646F;
import l2.C2655d;
import z2.C2954m;
import z2.O;
import z3.D;
import z3.F;
import z3.w;

public final class K5 extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final w f3325a;

    /* renamed from: b  reason: collision with root package name */
    private final D f3326b;

    public K5() {
        w a5 = F.a(O.a.f26507a);
        this.f3325a = a5;
        this.f3326b = a5;
    }

    public final void a(Context context) {
        t.e(context, "context");
        ArrayList arrayList = new ArrayList();
        ArrayList D4 = new C2954m().D(context);
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.t() != null) {
            ArrayList t5 = aVar.t();
            t.b(t5);
            Iterator it = t5.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                C2646F f5 = (C2646F) next;
                Iterator it2 = D4.iterator();
                t.d(it2, "iterator(...)");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    t.d(next2, "next(...)");
                    C2655d dVar = (C2655d) next2;
                    if (t.a(f5.c(), dVar.r())) {
                        dVar.X(f5);
                        arrayList.add(dVar);
                    }
                }
            }
        }
        C2954m.f26533a.l(arrayList, context);
        this.f3325a.setValue(new O.c(arrayList));
    }

    public final D b() {
        return this.f3326b;
    }
}
