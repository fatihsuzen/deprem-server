package androidx.fragment.app;

import android.view.View;
import kotlin.jvm.internal.t;

public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        t.e(view, "$this$findFragment");
        F findFragment = FragmentManager.findFragment(view);
        t.d(findFragment, "FragmentManager.findFragment(this)");
        return findFragment;
    }
}
