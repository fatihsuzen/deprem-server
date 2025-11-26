package androidx.work.impl;

import X2.C2250q;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;

final class StartStopTokensImpl implements StartStopTokens {
    private final Map<WorkGenerationalId, StartStopToken> runs = new LinkedHashMap();

    public boolean contains(WorkGenerationalId workGenerationalId) {
        t.e(workGenerationalId, "id");
        return this.runs.containsKey(workGenerationalId);
    }

    public /* synthetic */ StartStopToken remove(WorkSpec workSpec) {
        return f.a(this, workSpec);
    }

    public /* synthetic */ StartStopToken tokenFor(WorkSpec workSpec) {
        return f.b(this, workSpec);
    }

    public StartStopToken remove(WorkGenerationalId workGenerationalId) {
        t.e(workGenerationalId, "id");
        return this.runs.remove(workGenerationalId);
    }

    public StartStopToken tokenFor(WorkGenerationalId workGenerationalId) {
        t.e(workGenerationalId, "id");
        Map<WorkGenerationalId, StartStopToken> map = this.runs;
        StartStopToken startStopToken = map.get(workGenerationalId);
        if (startStopToken == null) {
            startStopToken = new StartStopToken(workGenerationalId);
            map.put(workGenerationalId, startStopToken);
        }
        return startStopToken;
    }

    public List<StartStopToken> remove(String str) {
        t.e(str, "workSpecId");
        Map<WorkGenerationalId, StartStopToken> map = this.runs;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (t.a(((WorkGenerationalId) next.getKey()).getWorkSpecId(), str)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (WorkGenerationalId remove : linkedHashMap.keySet()) {
            this.runs.remove(remove);
        }
        return C2250q.n0(linkedHashMap.values());
    }
}
