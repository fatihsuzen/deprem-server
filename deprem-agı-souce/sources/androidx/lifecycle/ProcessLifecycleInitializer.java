package androidx.lifecycle;

import X2.C2250q;
import android.content.Context;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.jvm.internal.t;

public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    public List<Class<? extends Initializer<?>>> dependencies() {
        return C2250q.g();
    }

    public LifecycleOwner create(Context context) {
        t.e(context, "context");
        AppInitializer instance = AppInitializer.getInstance(context);
        t.d(instance, "getInstance(...)");
        if (instance.isEagerlyInitialized(ProcessLifecycleInitializer.class)) {
            LifecycleDispatcher.init(context);
            ProcessLifecycleOwner.Companion companion = ProcessLifecycleOwner.Companion;
            companion.init$lifecycle_process_release(context);
            return companion.get();
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
    }
}
