package s0;

import R0.b;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.concurrent.Executors;

/* renamed from: s0.c  reason: case insensitive filesystem */
public final /* synthetic */ class C1819c implements b {
    public final Object get() {
        return ExecutorsRegistrar.m(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), ExecutorsRegistrar.k("Firebase Lite", 0, ExecutorsRegistrar.l())));
    }
}
