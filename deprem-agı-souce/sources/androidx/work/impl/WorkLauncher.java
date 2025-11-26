package androidx.work.impl;

import androidx.work.WorkerParameters;

public interface WorkLauncher {
    void startWork(StartStopToken startStopToken);

    void startWork(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras);

    void stopWork(StartStopToken startStopToken);

    void stopWork(StartStopToken startStopToken, int i5);

    void stopWorkWithReason(StartStopToken startStopToken, int i5);
}
