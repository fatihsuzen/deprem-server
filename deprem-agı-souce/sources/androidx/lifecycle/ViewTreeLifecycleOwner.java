package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.core.viewtree.ViewTree;
import androidx.lifecycle.runtime.R;
import kotlin.jvm.internal.t;

public final class ViewTreeLifecycleOwner {
    public static final LifecycleOwner get(View view) {
        LifecycleOwner lifecycleOwner;
        t.e(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
            if (tag instanceof LifecycleOwner) {
                lifecycleOwner = (LifecycleOwner) tag;
            } else {
                lifecycleOwner = null;
            }
            if (lifecycleOwner != null) {
                return lifecycleOwner;
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

    public static final void set(View view, LifecycleOwner lifecycleOwner) {
        t.e(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
