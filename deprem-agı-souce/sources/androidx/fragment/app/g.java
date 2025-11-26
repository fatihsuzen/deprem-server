package androidx.fragment.app;

import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.util.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f360a;

    public /* synthetic */ g(FragmentManager fragmentManager) {
        this.f360a = fragmentManager;
    }

    public final void accept(Object obj) {
        FragmentManager.d(this.f360a, (MultiWindowModeChangedInfo) obj);
    }
}
