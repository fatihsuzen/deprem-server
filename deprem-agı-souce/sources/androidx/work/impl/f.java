package androidx.work.impl;

import androidx.work.impl.StartStopTokens;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import kotlin.jvm.internal.t;

public abstract /* synthetic */ class f {
    static {
        StartStopTokens.Companion companion = StartStopTokens.Companion;
    }

    public static StartStopToken a(StartStopTokens startStopTokens, WorkSpec workSpec) {
        t.e(workSpec, "spec");
        return startStopTokens.remove(WorkSpecKt.generationalId(workSpec));
    }

    public static StartStopToken b(StartStopTokens startStopTokens, WorkSpec workSpec) {
        t.e(workSpec, "spec");
        return startStopTokens.tokenFor(WorkSpecKt.generationalId(workSpec));
    }

    public static StartStopTokens c() {
        return StartStopTokens.Companion.create();
    }

    public static StartStopTokens d(boolean z4) {
        return StartStopTokens.Companion.create(z4);
    }
}
