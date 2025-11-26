package androidx.fragment.app;

import android.os.Bundle;
import k3.p;
import kotlin.jvm.internal.t;

public final class FragmentKt {
    public static final void clearFragmentResult(Fragment fragment, String str) {
        t.e(fragment, "$this$clearFragmentResult");
        t.e(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String str) {
        t.e(fragment, "$this$clearFragmentResultListener");
        t.e(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }

    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        t.e(fragment, "$this$setFragmentResult");
        t.e(str, "requestKey");
        t.e(bundle, "result");
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void setFragmentResultListener(Fragment fragment, String str, p pVar) {
        t.e(fragment, "$this$setFragmentResultListener");
        t.e(str, "requestKey");
        t.e(pVar, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0(pVar));
    }
}
