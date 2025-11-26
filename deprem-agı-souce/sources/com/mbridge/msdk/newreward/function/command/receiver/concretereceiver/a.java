package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.a.a;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.receiver.e;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.b.a f10786a;

    public final Object a(Object obj) {
        b bVar;
        com.mbridge.msdk.newreward.a.e eVar;
        c cVar;
        int i5;
        if (obj == null) {
            return null;
        }
        Map map = (Map) obj;
        if (map.get("reason") != null) {
            bVar = (b) map.get("reason");
        } else {
            bVar = null;
        }
        if (map.get("adapter_model") != null) {
            eVar = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
        } else {
            eVar = null;
        }
        if (map.get("command_manager") != null) {
            cVar = (c) map.get("command_manager");
        } else {
            cVar = null;
        }
        if (!(eVar == null || cVar == null)) {
            boolean z4 = false;
            if (map.get("candidate_type") != null) {
                i5 = ((Integer) map.get("candidate_type")).intValue();
            } else {
                i5 = 0;
            }
            if (this.f10786a == null) {
                String H4 = eVar.H();
                if (eVar.h() == 287) {
                    z4 = true;
                }
                this.f10786a = new com.mbridge.msdk.newreward.function.b.a(H4, z4, cVar);
            }
            com.mbridge.msdk.foundation.same.report.d.c cVar2 = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar2.c(eVar.G());
            if (i5 == 0) {
                String J4 = eVar.J();
                if (TextUtils.isEmpty(J4)) {
                    return null;
                }
                try {
                    com.mbridge.msdk.newreward.function.a.b a5 = this.f10786a.a(cVar2, bVar, eVar, 1);
                    this.f10786a.a(cVar2, J4, a5, (List<a.C0099a>) null, (JSONObject) null, eVar, 3);
                    return a5;
                } catch (Exception e5) {
                    Exception exc = e5;
                    af.b("CandidateReceiver", "load error" + exc.getMessage());
                    return null;
                }
            } else if (i5 == 1) {
                String J5 = eVar.J();
                if (TextUtils.isEmpty(J5)) {
                    return Boolean.FALSE;
                }
                try {
                    return Boolean.valueOf(this.f10786a.a(J5));
                } catch (Exception e6) {
                    Exception exc2 = e6;
                    af.b("CandidateReceiver", "loadCallBack error" + exc2.getMessage());
                    return Boolean.FALSE;
                }
            } else if (i5 == 2) {
                String J6 = eVar.J();
                if (TextUtils.isEmpty(J6)) {
                    return null;
                }
                try {
                    com.mbridge.msdk.newreward.function.a.b a6 = this.f10786a.a(cVar2, bVar, eVar, 2);
                    com.mbridge.msdk.newreward.function.b.a aVar = this.f10786a;
                    if (aVar == null) {
                        return a6;
                    }
                    aVar.a(cVar2, J6, a6, (List<a.C0099a>) null, (JSONObject) null, eVar, 1);
                    return a6;
                } catch (Exception e7) {
                    Exception exc3 = e7;
                    af.b("CandidateReceiver", "loadCallBack error" + exc3.getMessage());
                    return null;
                }
            } else if (TextUtils.isEmpty(eVar.J())) {
                return null;
            } else {
                try {
                    return this.f10786a.a(cVar2, bVar, eVar, 2);
                } catch (Exception e8) {
                    Exception exc4 = e8;
                    af.b("CandidateReceiver", "load error" + exc4.getMessage());
                }
            }
        }
        return null;
    }
}
