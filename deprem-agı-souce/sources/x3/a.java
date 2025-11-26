package X3;

import U3.s;
import U3.u;
import U3.x;
import U3.z;
import Y3.g;
import androidx.browser.trusted.sharing.ShareTarget;

public final class a implements s {

    /* renamed from: a  reason: collision with root package name */
    public final u f20071a;

    public a(u uVar) {
        this.f20071a = uVar;
    }

    public z a(s.a aVar) {
        g gVar = (g) aVar;
        x request = gVar.request();
        g g5 = gVar.g();
        return gVar.f(request, g5, g5.h(this.f20071a, aVar, !request.g().equals(ShareTarget.METHOD_GET)), g5.c());
    }
}
