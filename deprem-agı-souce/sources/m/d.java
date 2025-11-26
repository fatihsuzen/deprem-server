package m;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import com.inmobi.cmp.core.model.Vector;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.UUID;
import k3.p;
import k4.g;
import k4.h;
import k4.q;
import k4.z;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.I;
import r4.b;
import w3.M;

public final class d extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f944a;

    public d(C2308e eVar) {
        super(2, eVar);
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new d(eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new d((C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object f5 = C2316b.f();
        int i5 = this.f944a;
        if (i5 == 0) {
            u.b(obj);
            UUID uuid = z.f24676a;
            this.f944a = 1;
            k4.l lVar = z.f24677b;
            lVar.i("Confirm", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
            h hVar = h.NR;
            boolean z4 = l.f960a;
            ArrayList arrayList = new ArrayList();
            Vector vector = l.f961b;
            vector.forEach(new h(arrayList));
            I i6 = new I();
            i6.f24687a = true;
            vector.forEach(new j(i6));
            if (i6.f24687a) {
                str = "All";
            } else {
                I i7 = new I();
                i7.f24687a = true;
                vector.forEach(new k(i7));
                if (i7.f24687a) {
                    str = "Reject";
                } else {
                    str = "Partial";
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(lVar.f24607h);
            q qVar = new q(arrayList2, str, arrayList);
            lVar.f24607h.clear();
            lVar.f24605f.i(b.GBC_STATUS, str);
            Object b5 = lVar.b(g.DONE, qVar, hVar, this);
            if (b5 != C2316b.f()) {
                b5 = J.f19942a;
            }
            if (b5 == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }
}
