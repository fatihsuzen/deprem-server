package R3;

import W2.J;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import k3.l;
import kotlin.jvm.internal.u;

public final class i extends u implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final i f19015a = new i();

    public i() {
        super(1);
    }

    public final Object invoke(Object obj) {
        J j5;
        ChoiceCmpCallback callback;
        ChoiceCmpCallback callback2;
        USRegulationData uSRegulationData = (USRegulationData) obj;
        if (uSRegulationData == null || (callback2 = ChoiceCmp.INSTANCE.getCallback()) == null) {
            j5 = null;
        } else {
            callback2.onReceiveUSRegulationsConsent(uSRegulationData);
            j5 = J.f19942a;
        }
        if (j5 == null && (callback = ChoiceCmp.INSTANCE.getCallback()) != null) {
            callback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
        }
        return J.f19942a;
    }
}
