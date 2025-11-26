package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.internal.CanonicalName_jvmKt;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.l;
import kotlin.jvm.internal.t;
import r3.C2733c;

@ViewModelFactoryDsl
public final class InitializerViewModelFactoryBuilder {
    private final Map<C2733c, ViewModelInitializer<?>> initializers = new LinkedHashMap();

    public final <T extends ViewModel> void addInitializer(C2733c cVar, l lVar) {
        t.e(cVar, "clazz");
        t.e(lVar, "initializer");
        if (!this.initializers.containsKey(cVar)) {
            this.initializers.put(cVar, new ViewModelInitializer(cVar, lVar));
            return;
        }
        throw new IllegalArgumentException(("A `initializer` with the same `clazz` has already been added: " + CanonicalName_jvmKt.getCanonicalName(cVar) + '.').toString());
    }

    public final ViewModelProvider.Factory build() {
        return ViewModelProviders.INSTANCE.createInitializerFactory$lifecycle_viewmodel_release((Collection<? extends ViewModelInitializer<?>>) this.initializers.values());
    }
}
