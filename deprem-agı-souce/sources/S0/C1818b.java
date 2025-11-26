package s0;

import R0.b;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.concurrent.Executors;

/* renamed from: s0.b  reason: case insensitive filesystem */
public final /* synthetic */ class C1818b implements b {
    public final Object get() {
        return ExecutorsRegistrar.m(Executors.newFixedThreadPool(4, ExecutorsRegistrar.k("Firebase Background", 10, ExecutorsRegistrar.i())));
    }
}
