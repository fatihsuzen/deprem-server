package androidx.window.layout;

import X2.C2250q;
import androidx.annotation.RestrictTo;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.t;

public final class WindowLayoutInfo {
    private final List<DisplayFeature> displayFeatures;

    @RestrictTo({RestrictTo.Scope.TESTS})
    public WindowLayoutInfo(List<? extends DisplayFeature> list) {
        t.e(list, "displayFeatures");
        this.displayFeatures = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.a(WindowLayoutInfo.class, obj.getClass())) {
            return false;
        }
        return t.a(this.displayFeatures, ((WindowLayoutInfo) obj).displayFeatures);
    }

    public final List<DisplayFeature> getDisplayFeatures() {
        return this.displayFeatures;
    }

    public int hashCode() {
        return this.displayFeatures.hashCode();
    }

    public String toString() {
        return C2250q.V(this.displayFeatures, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }
}
