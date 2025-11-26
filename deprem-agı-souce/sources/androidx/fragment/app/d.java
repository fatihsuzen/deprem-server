package androidx.fragment.app;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;

public final /* synthetic */ class d implements OnContextAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f357a;

    public /* synthetic */ d(FragmentActivity fragmentActivity) {
        this.f357a = fragmentActivity;
    }

    public final void onContextAvailable(Context context) {
        this.f357a.mFragments.attachHost((Fragment) null);
    }
}
