package androidx.fragment.app;

import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f361a;

    public /* synthetic */ h(FragmentManager fragmentManager) {
        this.f361a = fragmentManager;
    }

    public final void accept(Object obj) {
        FragmentManager.c(this.f361a, (PictureInPictureModeChangedInfo) obj);
    }
}
