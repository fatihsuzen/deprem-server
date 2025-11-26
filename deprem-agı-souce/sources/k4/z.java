package k4;

import W2.J;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;
import k3.p;
import kotlin.jvm.internal.t;
import r4.b;
import s4.c;

public abstract class z {

    /* renamed from: a  reason: collision with root package name */
    public static UUID f24676a = UUID.randomUUID();

    /* renamed from: b  reason: collision with root package name */
    public static final l f24677b = c.n();

    static {
        new LinkedHashMap();
        new LinkedHashMap();
    }

    public static LiveData a(A a5) {
        Boolean bool;
        String str;
        t.e(a5, "actionTag");
        int ordinal = a5.ordinal();
        if (ordinal == 4) {
            str = String.valueOf(A.SAVE_AND_EXIT);
            bool = null;
        } else if (ordinal == 5) {
            bool = Boolean.TRUE;
            str = String.valueOf(A.ACCEPT_ALL);
        } else if (ordinal != 6) {
            bool = Boolean.FALSE;
            str = String.valueOf(A.PARTIAL_CONSENT);
        } else {
            bool = Boolean.FALSE;
            str = String.valueOf(A.REJECT_ALL);
        }
        String k5 = c.l().k(b.TC_STRING);
        String k6 = c.l().k(b.HDR_GPP_STRING);
        f24677b.i(str, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        return CoroutineLiveDataKt.liveData$default((C2312i) null, 0, (p) new t(k5, k6, bool, (C2308e) null), 3, (Object) null);
    }

    public static LiveData b(A a5, b bVar) {
        String str;
        int i5;
        t.e(a5, "actionTag");
        t.e(bVar, "acceptanceState");
        int ordinal = a5.ordinal();
        if (ordinal == 4) {
            str = String.valueOf(A.SAVE_AND_EXIT);
        } else if (ordinal == 5) {
            str = String.valueOf(A.ACCEPT_ALL);
        } else if (ordinal != 6) {
            str = String.valueOf(A.PARTIAL_CONSENT);
        } else {
            str = String.valueOf(A.REJECT_ALL);
        }
        int ordinal2 = bVar.ordinal();
        if (ordinal2 != 0) {
            i5 = 2;
            if (ordinal2 != 2) {
                i5 = 3;
            }
        } else {
            i5 = 1;
        }
        f24677b.i(str, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        return CoroutineLiveDataKt.liveData$default((C2312i) null, 0, (p) new u(c.l().k(b.SAVED_MSPA_JURISDICTION), bVar, i5, (C2308e) null), 3, (Object) null);
    }

    public static Object c(h hVar, int i5, C2308e eVar) {
        Object obj;
        l lVar = f24677b;
        lVar.i("goToPage", String.valueOf(i5));
        if (lVar.f24607h.size() < 2) {
            obj = "";
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(lVar.f24607h);
            p pVar = new p(arrayList);
            lVar.f24607h.clear();
            obj = lVar.b(g.NAVIGATION, pVar, hVar, eVar);
        }
        if (obj == C2316b.f()) {
            return obj;
        }
        return J.f19942a;
    }

    public static void d(String str, String str2) {
        t.e(str, "identifier");
        t.e(str2, "value");
        f24677b.i(str, str2);
    }

    public static LiveData e(A a5) {
        h hVar = h.GDPR;
        t.e(a5, "action");
        t.e(hVar, "regulation");
        f24677b.i(a5.f24552a, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        return CoroutineLiveDataKt.liveData$default((C2312i) null, 0, (p) new y(hVar, (C2308e) null), 3, (Object) null);
    }
}
