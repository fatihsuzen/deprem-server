package s0;

import R0.b;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.concurrent.Executors;

/* renamed from: s0.e  reason: case insensitive filesystem */
public final /* synthetic */ class C1821e implements b {
    public final Object get() {
        return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.j("Firebase Scheduler", 0));
    }
}
