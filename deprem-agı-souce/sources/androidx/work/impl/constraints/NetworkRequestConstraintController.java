package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Constraints;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.WorkSpec;
import b3.C2308e;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z3.C2972e;
import z3.C2974g;

@RequiresApi(28)
public final class NetworkRequestConstraintController implements ConstraintController {
    /* access modifiers changed from: private */
    public final ConnectivityManager connManager;
    /* access modifiers changed from: private */
    public final long timeoutMs;

    public NetworkRequestConstraintController(ConnectivityManager connectivityManager, long j5) {
        t.e(connectivityManager, "connManager");
        this.connManager = connectivityManager;
        this.timeoutMs = j5;
    }

    public boolean hasConstraint(WorkSpec workSpec) {
        t.e(workSpec, "workSpec");
        if (workSpec.constraints.getRequiredNetworkRequest() != null) {
            return true;
        }
        return false;
    }

    public boolean isCurrentlyConstrained(WorkSpec workSpec) {
        t.e(workSpec, "workSpec");
        if (!hasConstraint(workSpec)) {
            return false;
        }
        throw new IllegalStateException("isCurrentlyConstrained() must never be called onNetworkRequestConstraintController. isCurrentlyConstrained() is called only on older platforms where NetworkRequest isn't supported");
    }

    public C2972e track(Constraints constraints) {
        t.e(constraints, "constraints");
        return C2974g.d(new NetworkRequestConstraintController$track$1(constraints, this, (C2308e) null));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkRequestConstraintController(ConnectivityManager connectivityManager, long j5, int i5, C2633k kVar) {
        this(connectivityManager, (i5 & 2) != 0 ? 1000 : j5);
    }
}
