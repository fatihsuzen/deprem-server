package G2;

import H2.d;
import R3.a;
import R3.c;
import R3.e;
import R3.f;
import R3.g;
import S3.h;
import X2.C2242i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import c.k;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import k4.A;
import k4.z;
import kotlin.jvm.internal.t;
import m.i;
import m.l;
import r4.b;

public final class p extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final a f18179a;

    /* renamed from: b  reason: collision with root package name */
    public final o4.p f18180b;

    /* renamed from: c  reason: collision with root package name */
    public final ChoiceCmpCallback f18181c;

    /* renamed from: d  reason: collision with root package name */
    public final int f18182d = 2;

    public p(a aVar, o4.p pVar, ChoiceCmpCallback choiceCmpCallback) {
        t.e(aVar, "mspaConfig");
        t.e(pVar, "gbcConsentRepository");
        this.f18179a = aVar;
        this.f18180b = pVar;
        this.f18181c = choiceCmpCallback;
    }

    public final LiveData a() {
        if (l.f960a) {
            o4.p pVar = this.f18180b;
            pVar.getClass();
            if (l.f960a) {
                Vector vector = l.f961b;
                vector.setAllOwnedItems();
                r4.a aVar = pVar.f25612a;
                b bVar = b.GBC_CONSENT_STRING;
                Vector l5 = aVar.l(bVar);
                t.e(vector, "newVector");
                if (l5 != null) {
                    l5.forEach(new i(vector));
                }
                aVar.h(bVar, vector);
                ChoiceCmpCallback choiceCmpCallback = pVar.f25613b;
                if (choiceCmpCallback != null) {
                    choiceCmpCallback.onGoogleBasicConsentChange(l.a());
                }
            }
        }
        a aVar2 = this.f18179a;
        m mVar = new m(this);
        t.e(aVar2, "mspaConfig");
        t.e(mVar, "completion");
        S3.i iVar = e.f18981c;
        if (iVar != null) {
            List<f> list = aVar2.f18959d;
            if (list != null) {
                c cVar = new c(mVar);
                t.e(list, "purposes");
                t.e(cVar, "completion");
                for (f fVar : list) {
                    fVar.f18987c = Boolean.FALSE;
                    List<g> list2 = fVar.f18990f;
                    if (list2 != null) {
                        for (g gVar : list2) {
                            gVar.f18995d = Boolean.FALSE;
                        }
                    }
                }
                iVar.f(list, true, new h(cVar));
            }
        } else {
            d.c((String) null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), (Exception) null, Boolean.TRUE, 5);
            mVar.invoke((Object) null);
        }
        UUID uuid = z.f24676a;
        return z.b(A.ACCEPT_ALL, k4.b.ACCEPT_ALL);
    }

    public final ArrayList b(int[] iArr) {
        ArrayList arrayList;
        String str;
        c.l lVar;
        String str2;
        String str3;
        ArrayList arrayList2 = new ArrayList();
        List list = this.f18179a.f18959d;
        if (list == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object next : list) {
                Integer num = ((f) next).f18985a;
                if (num != null && C2242i.J(iArr, num.intValue())) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                f fVar = (f) obj;
                Integer num2 = fVar.f18985a;
                if (num2 != null) {
                    int intValue = num2.intValue();
                    R2.a aVar = fVar.f18988d;
                    if (aVar == null) {
                        str = null;
                    } else {
                        str = aVar.f18949c;
                    }
                    if (str == null) {
                        str = "";
                    }
                    P3.e eVar = new P3.e(intValue, str);
                    String str4 = "";
                    Boolean bool = fVar.f18987c;
                    k kVar = k.MSPA_PURPOSE;
                    boolean z4 = fVar.f18991g;
                    if (z4) {
                        lVar = c.l.NON_SWITCH;
                    } else {
                        lVar = c.l.NORMAL;
                    }
                    if (z4) {
                        R2.a aVar2 = fVar.f18988d;
                        if (aVar2 == null) {
                            str3 = null;
                        } else {
                            str3 = aVar2.f18949c;
                        }
                        if (str3 != null) {
                            str2 = str3;
                            arrayList2.add(new c.i(eVar, bool, lVar, kVar, str2, (Integer) null, 80));
                        }
                    }
                    str2 = str4;
                    arrayList2.add(new c.i(eVar, bool, lVar, kVar, str2, (Integer) null, 80));
                }
            }
        }
        return arrayList2;
    }

    public final void c() {
        List list = this.f18179a.f18959d;
        if (list != null) {
            n nVar = new n(this);
            t.e(list, "mspaPurpose");
            t.e(nVar, "completion");
            S3.i iVar = e.f18981c;
            if (iVar != null) {
                iVar.f(list, true, new R3.d(nVar));
                return;
            }
            d.c((String) null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), (Exception) null, Boolean.TRUE, 5);
            nVar.invoke((Object) null);
        }
    }
}
