package J;

import android.content.Intent;
import android.os.Bundle;
import k0.C1689c;
import k0.C1698l;

/* renamed from: J.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0650f implements C1689c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0650f f2631a = new C0650f();

    private /* synthetic */ C0650f() {
    }

    public final Object a(C1698l lVar) {
        Intent intent = (Intent) ((Bundle) lVar.j()).getParcelable("notification_data");
        if (intent != null) {
            return new C0645a(intent);
        }
        return null;
    }
}
