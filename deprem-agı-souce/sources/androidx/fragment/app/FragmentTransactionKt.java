package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import kotlin.jvm.internal.t;

public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, @IdRes int i5, String str, Bundle bundle) {
        t.e(fragmentTransaction, "$this$add");
        t.k(4, "F");
        FragmentTransaction add = fragmentTransaction.add(i5, Fragment.class, bundle, str);
        t.d(add, "add(containerViewId, F::class.java, args, tag)");
        return add;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, int i5, String str, Bundle bundle, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str = null;
        }
        if ((i6 & 4) != 0) {
            bundle = null;
        }
        t.e(fragmentTransaction, "$this$add");
        t.k(4, "F");
        FragmentTransaction add = fragmentTransaction.add(i5, Fragment.class, bundle, str);
        t.d(add, "add(containerViewId, F::class.java, args, tag)");
        return add;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction fragmentTransaction, @IdRes int i5, String str, Bundle bundle) {
        t.e(fragmentTransaction, "$this$replace");
        t.k(4, "F");
        FragmentTransaction replace = fragmentTransaction.replace(i5, Fragment.class, bundle, str);
        t.d(replace, "replace(containerViewId, F::class.java, args, tag)");
        return replace;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction fragmentTransaction, int i5, String str, Bundle bundle, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str = null;
        }
        if ((i6 & 4) != 0) {
            bundle = null;
        }
        t.e(fragmentTransaction, "$this$replace");
        t.k(4, "F");
        FragmentTransaction replace = fragmentTransaction.replace(i5, Fragment.class, bundle, str);
        t.d(replace, "replace(containerViewId, F::class.java, args, tag)");
        return replace;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, String str, Bundle bundle) {
        t.e(fragmentTransaction, "$this$add");
        t.e(str, "tag");
        t.k(4, "F");
        FragmentTransaction add = fragmentTransaction.add((Class<? extends Fragment>) Fragment.class, bundle, str);
        t.d(add, "add(F::class.java, args, tag)");
        return add;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, String str, Bundle bundle, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            bundle = null;
        }
        t.e(fragmentTransaction, "$this$add");
        t.e(str, "tag");
        t.k(4, "F");
        FragmentTransaction add = fragmentTransaction.add((Class<? extends Fragment>) Fragment.class, bundle, str);
        t.d(add, "add(F::class.java, args, tag)");
        return add;
    }
}
