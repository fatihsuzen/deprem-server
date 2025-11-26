package androidx.savedstate;

import W2.s;
import W2.y;
import X2.C2250q;
import X2.M;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class Recreator implements LifecycleEventObserver {
    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    public static final Companion Companion = new Companion((C2633k) null);
    private final SavedStateRegistryOwner owner;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        private final Set<String> classes = new LinkedHashSet();

        public SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            t.e(savedStateRegistry, "registry");
            savedStateRegistry.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
        }

        public final void add(String str) {
            t.e(str, "className");
            this.classes.add(str);
        }

        public Bundle saveState() {
            s[] sVarArr;
            Map h5 = M.h();
            if (h5.isEmpty()) {
                sVarArr = new s[0];
            } else {
                ArrayList arrayList = new ArrayList(h5.size());
                for (Map.Entry entry : h5.entrySet()) {
                    arrayList.add(y.a((String) entry.getKey(), entry.getValue()));
                }
                sVarArr = (s[]) arrayList.toArray(new s[0]);
            }
            Bundle bundleOf = BundleKt.bundleOf((s[]) Arrays.copyOf(sVarArr, sVarArr.length));
            SavedStateWriter.m192putStringListimpl(SavedStateWriter.m157constructorimpl(bundleOf), Recreator.CLASSES_KEY, C2250q.n0(this.classes));
            return bundleOf;
        }
    }

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        t.e(savedStateRegistryOwner, "owner");
        this.owner = savedStateRegistryOwner;
    }

    private final void reflectiveNew(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
            t.b(asSubclass);
            try {
                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor((Class[]) null);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance((Object[]) null);
                    t.b(newInstance);
                    ((SavedStateRegistry.AutoRecreated) newInstance).onRecreated(this.owner);
                } catch (Exception e5) {
                    throw new RuntimeException("Failed to instantiate " + str, e5);
                }
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e6);
            }
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException("Class " + str + " wasn't found", e7);
        }
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        t.e(lifecycleOwner, "source");
        t.e(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_CREATE) {
            lifecycleOwner.getLifecycle().removeObserver(this);
            Bundle consumeRestoredStateForKey = this.owner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
            if (consumeRestoredStateForKey != null) {
                List<String> r22 = SavedStateReader.m146getStringListOrNullimpl(SavedStateReader.m71constructorimpl(consumeRestoredStateForKey), CLASSES_KEY);
                if (r22 != null) {
                    for (String reflectiveNew : r22) {
                        reflectiveNew(reflectiveNew);
                    }
                    return;
                }
                throw new IllegalStateException("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
