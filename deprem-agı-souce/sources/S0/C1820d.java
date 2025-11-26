package s0;

import R0.b;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.concurrent.Executors;

/* renamed from: s0.d  reason: case insensitive filesystem */
public final /* synthetic */ class C1820d implements b {
    public final Object get() {
        return ExecutorsRegistrar.m(Executors.newCachedThreadPool(ExecutorsRegistrar.j("Firebase Blocking", 11)));
    }
}
