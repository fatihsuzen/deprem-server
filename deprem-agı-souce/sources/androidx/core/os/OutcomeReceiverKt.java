package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import b3.C2308e;

@RequiresApi(31)
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    public static final <R, E extends Throwable> OutcomeReceiver asOutcomeReceiver(C2308e eVar) {
        return i.a(new ContinuationOutcomeReceiver(eVar));
    }
}
