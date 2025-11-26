package L;

import M.C0695o;
import N.C0722p;
import com.google.android.gms.common.api.Status;

public abstract class h {
    public static g a(j jVar, f fVar) {
        C0722p.l(jVar, "Result must not be null");
        C0722p.b(!jVar.getStatus().i(), "Status code must not be SUCCESS");
        m mVar = new m(fVar, jVar);
        mVar.f(jVar);
        return mVar;
    }

    public static g b(Status status, f fVar) {
        C0722p.l(status, "Result must not be null");
        C0695o oVar = new C0695o(fVar);
        oVar.f(status);
        return oVar;
    }
}
