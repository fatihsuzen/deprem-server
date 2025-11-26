package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StopWorkRunnable implements Runnable {
    private final Processor processor;
    private final int reason;
    private final boolean stopInForeground;
    private final StartStopToken token;

    public StopWorkRunnable(Processor processor2, StartStopToken startStopToken, boolean z4, int i5) {
        t.e(processor2, "processor");
        t.e(startStopToken, "token");
        this.processor = processor2;
        this.token = startStopToken;
        this.stopInForeground = z4;
        this.reason = i5;
    }

    public void run() {
        boolean z4;
        if (this.stopInForeground) {
            z4 = this.processor.stopForegroundWork(this.token, this.reason);
        } else {
            z4 = this.processor.stopWork(this.token, this.reason);
        }
        Logger logger = Logger.get();
        String tagWithPrefix = Logger.tagWithPrefix("StopWorkRunnable");
        logger.debug(tagWithPrefix, "StopWorkRunnable for " + this.token.getId().getWorkSpecId() + "; Processor.stopWork = " + z4);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StopWorkRunnable(Processor processor2, StartStopToken startStopToken, boolean z4) {
        this(processor2, startStopToken, z4, WorkInfo.STOP_REASON_UNKNOWN);
        t.e(processor2, "processor");
        t.e(startStopToken, "token");
    }
}
