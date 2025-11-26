package androidx.core.viewtree;

import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.t;

public final class ViewTree {
    public static final ViewParent getParentOrViewTreeDisjointParent(View view) {
        t.e(view, "<this>");
        ViewParent parent = view.getParent();
        if (parent != null) {
            return parent;
        }
        Object tag = view.getTag(R.id.view_tree_disjoint_parent);
        if (tag instanceof ViewParent) {
            return (ViewParent) tag;
        }
        return null;
    }

    public static final void setViewTreeDisjointParent(View view, ViewParent viewParent) {
        t.e(view, "<this>");
        view.setTag(R.id.view_tree_disjoint_parent, viewParent);
    }
}
