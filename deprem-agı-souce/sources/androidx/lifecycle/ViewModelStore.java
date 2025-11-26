package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;

public class ViewModelStore {
    private final Map<String, ViewModel> map = new LinkedHashMap();

    public final void clear() {
        for (ViewModel clear$lifecycle_viewmodel_release : this.map.values()) {
            clear$lifecycle_viewmodel_release.clear$lifecycle_viewmodel_release();
        }
        this.map.clear();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ViewModel get(String str) {
        t.e(str, "key");
        return this.map.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> keys() {
        return new HashSet(this.map.keySet());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void put(String str, ViewModel viewModel) {
        t.e(str, "key");
        t.e(viewModel, "viewModel");
        ViewModel put = this.map.put(str, viewModel);
        if (put != null) {
            put.clear$lifecycle_viewmodel_release();
        }
    }
}
