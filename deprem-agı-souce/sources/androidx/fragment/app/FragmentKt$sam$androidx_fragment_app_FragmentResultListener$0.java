package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import k3.p;
import kotlin.jvm.internal.t;

final class FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0 implements FragmentResultListener {
    private final /* synthetic */ p function;

    FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0(p pVar) {
        this.function = pVar;
    }

    public final /* synthetic */ void onFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        t.e(str, "p0");
        t.e(bundle, "p1");
        t.d(this.function.invoke(str, bundle), "invoke(...)");
    }
}
