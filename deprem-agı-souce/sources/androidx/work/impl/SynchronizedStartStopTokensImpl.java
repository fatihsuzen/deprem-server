package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import kotlin.jvm.internal.t;

final class SynchronizedStartStopTokensImpl implements StartStopTokens {
    private final StartStopTokens delegate;
    private final Object lock = new Object();

    public SynchronizedStartStopTokensImpl(StartStopTokens startStopTokens) {
        t.e(startStopTokens, "delegate");
        this.delegate = startStopTokens;
    }

    public boolean contains(WorkGenerationalId workGenerationalId) {
        boolean contains;
        t.e(workGenerationalId, "id");
        synchronized (this.lock) {
            contains = this.delegate.contains(workGenerationalId);
        }
        return contains;
    }

    public /* synthetic */ StartStopToken remove(WorkSpec workSpec) {
        return f.a(this, workSpec);
    }

    public /* synthetic */ StartStopToken tokenFor(WorkSpec workSpec) {
        return f.b(this, workSpec);
    }

    public StartStopToken remove(WorkGenerationalId workGenerationalId) {
        StartStopToken remove;
        t.e(workGenerationalId, "id");
        synchronized (this.lock) {
            remove = this.delegate.remove(workGenerationalId);
        }
        return remove;
    }

    public StartStopToken tokenFor(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        t.e(workGenerationalId, "id");
        synchronized (this.lock) {
            startStopToken = this.delegate.tokenFor(workGenerationalId);
        }
        return startStopToken;
    }

    public List<StartStopToken> remove(String str) {
        List<StartStopToken> remove;
        t.e(str, "workSpecId");
        synchronized (this.lock) {
            remove = this.delegate.remove(str);
        }
        return remove;
    }
}
