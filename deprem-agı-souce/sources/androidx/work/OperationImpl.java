package androidx.work;

import androidx.lifecycle.LiveData;
import androidx.work.Operation;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.t;
import n0.C1722d;

final class OperationImpl implements Operation {
    private final C1722d future;
    private final LiveData<Operation.State> state;

    public OperationImpl(LiveData<Operation.State> liveData, C1722d dVar) {
        t.e(liveData, MRAIDCommunicatorUtil.KEY_STATE);
        t.e(dVar, "future");
        this.state = liveData;
        this.future = dVar;
    }

    public C1722d getResult() {
        return this.future;
    }

    public LiveData<Operation.State> getState() {
        return this.state;
    }
}
