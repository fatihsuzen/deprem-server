package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.core.viewtree.ViewTree;
import androidx.lifecycle.viewmodel.R;
import kotlin.jvm.internal.t;

public final class ViewTreeViewModelStoreOwner {
    public static final ViewModelStoreOwner get(View view) {
        ViewModelStoreOwner viewModelStoreOwner;
        t.e(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
            if (tag instanceof ViewModelStoreOwner) {
                viewModelStoreOwner = (ViewModelStoreOwner) tag;
            } else {
                viewModelStoreOwner = null;
            }
            if (viewModelStoreOwner != null) {
                return viewModelStoreOwner;
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

    public static final void set(View view, ViewModelStoreOwner viewModelStoreOwner) {
        t.e(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }
}
