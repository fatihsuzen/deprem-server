package S;

import N.C0722p;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f4338a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadFactory f4339b = Executors.defaultThreadFactory();

    public a(String str) {
        C0722p.l(str, "Name must not be null");
        this.f4338a = str;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f4339b.newThread(new b(runnable, 0));
        newThread.setName(this.f4338a);
        return newThread;
    }
}
