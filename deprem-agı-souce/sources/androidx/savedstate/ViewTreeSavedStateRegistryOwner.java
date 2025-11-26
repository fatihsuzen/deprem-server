package androidx.savedstate;

import android.view.View;
import android.view.ViewParent;
import androidx.core.viewtree.ViewTree;
import kotlin.jvm.internal.t;

public final class ViewTreeSavedStateRegistryOwner {
    public static final SavedStateRegistryOwner get(View view) {
        SavedStateRegistryOwner savedStateRegistryOwner;
        t.e(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_saved_state_registry_owner);
            if (tag instanceof SavedStateRegistryOwner) {
                savedStateRegistryOwner = (SavedStateRegistryOwner) tag;
            } else {
                savedStateRegistryOwner = null;
            }
            if (savedStateRegistryOwner != null) {
                return savedStateRegistryOwner;
            }
            ViewParent parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            if (parentOrViewTreeDisjointParent instanceof View) {
                view = (View) parentOrViewTreeDisjointParent;
            } else {
                view = null;
            }
        }
        return null;
    }

    public static final void set(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        t.e(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }
}
