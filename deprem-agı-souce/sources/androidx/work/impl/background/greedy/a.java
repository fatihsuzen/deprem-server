package androidx.work.impl.background.greedy;

import androidx.work.impl.StartStopToken;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimeLimiter f536a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StartStopToken f537b;

    public /* synthetic */ a(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        this.f536a = timeLimiter;
        this.f537b = startStopToken;
    }

    public final void run() {
        TimeLimiter.track$lambda$0(this.f536a, this.f537b);
    }
}
