package G2;

import W2.J;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import k3.l;
import kotlin.jvm.internal.u;

public final class n extends u implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f18176a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(p pVar) {
        super(1);
        this.f18176a = pVar;
    }

    public final Object invoke(Object obj) {
        J j5;
        ChoiceCmpCallback choiceCmpCallback;
        ChoiceCmpCallback choiceCmpCallback2;
        USRegulationData uSRegulationData = (USRegulationData) obj;
        if (uSRegulationData == null || (choiceCmpCallback2 = this.f18176a.f18181c) == null) {
            j5 = null;
        } else {
            choiceCmpCallback2.onReceiveUSRegulationsConsent(uSRegulationData);
            j5 = J.f19942a;
        }
        if (j5 == null && (choiceCmpCallback = this.f18176a.f18181c) != null) {
            choiceCmpCallback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
        }
        return J.f19942a;
    }
}
