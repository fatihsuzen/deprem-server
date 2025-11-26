package G2;

import T3.c;
import W2.J;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import k3.l;
import kotlin.jvm.internal.u;
import r4.b;

public final class m extends u implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f18175a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(p pVar) {
        super(1);
        this.f18175a = pVar;
    }

    public final Object invoke(Object obj) {
        J j5;
        ChoiceCmpCallback choiceCmpCallback;
        ChoiceCmpCallback choiceCmpCallback2;
        USRegulationData uSRegulationData = (USRegulationData) obj;
        this.f18175a.getClass();
        c cVar = s4.c.j().f19281b;
        String str = cVar.f19230U;
        if (str != null) {
            s4.c.l().i(b.MSPA_CONFIG_THEME_UUID, str);
        }
        s4.c.l().i(b.MSPA_CONFIG_LANGUAGE, cVar.f19250o);
        s4.c.l().j(b.MSPA_CONFIG_GBC_APPLICABLE, m.l.f960a);
        if (uSRegulationData == null || (choiceCmpCallback2 = this.f18175a.f18181c) == null) {
            j5 = null;
        } else {
            choiceCmpCallback2.onReceiveUSRegulationsConsent(uSRegulationData);
            j5 = J.f19942a;
        }
        if (j5 == null && (choiceCmpCallback = this.f18175a.f18181c) != null) {
            choiceCmpCallback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
        }
        return J.f19942a;
    }
}
