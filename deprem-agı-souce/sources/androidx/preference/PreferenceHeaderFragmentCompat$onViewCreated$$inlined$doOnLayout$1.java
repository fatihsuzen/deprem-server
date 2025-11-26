package androidx.preference;

import android.view.View;
import androidx.activity.OnBackPressedCallback;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;

public final class PreferenceHeaderFragmentCompat$onViewCreated$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ PreferenceHeaderFragmentCompat this$0;

    public PreferenceHeaderFragmentCompat$onViewCreated$$inlined$doOnLayout$1(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
        this.this$0 = preferenceHeaderFragmentCompat;
    }

    public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        boolean z4;
        t.f(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        view.removeOnLayoutChangeListener(this);
        OnBackPressedCallback access$getOnBackPressedCallback$p = this.this$0.onBackPressedCallback;
        t.b(access$getOnBackPressedCallback$p);
        if (!this.this$0.getSlidingPaneLayout().isSlideable() || !this.this$0.getSlidingPaneLayout().isOpen()) {
            z4 = false;
        } else {
            z4 = true;
        }
        access$getOnBackPressedCallback$p.setEnabled(z4);
    }
}
