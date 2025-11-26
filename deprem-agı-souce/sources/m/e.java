package m;

import R2.c;
import T3.i;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import r4.a;

public final class e extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final a f945a;

    /* renamed from: b  reason: collision with root package name */
    public final ChoiceCmpCallback f946b;

    /* renamed from: c  reason: collision with root package name */
    public final c f947c;

    /* renamed from: d  reason: collision with root package name */
    public final i f948d;

    public e(a aVar, ChoiceCmpCallback choiceCmpCallback, c cVar, i iVar) {
        t.e(aVar, "sharedStorage");
        t.e(cVar, "response");
        t.e(iVar, "portalConfig");
        this.f945a = aVar;
        this.f946b = choiceCmpCallback;
        this.f947c = cVar;
        this.f948d = iVar;
    }

    public static GBCConsentValue a(List list, String str) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((c.i) obj).f894a.f18881a == l.d(str)) {
                break;
            }
        }
        c.i iVar = (c.i) obj;
        if (iVar == null) {
            return GBCConsentValue.DENIED;
        }
        if (t.a(iVar.f895b, Boolean.TRUE)) {
            return GBCConsentValue.GRANTED;
        }
        return GBCConsentValue.DENIED;
    }
}
