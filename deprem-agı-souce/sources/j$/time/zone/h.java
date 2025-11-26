package j$.time.zone;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public final class h implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1249a;

    public h(List list) {
        this.f1249a = list;
    }

    public final Object run() {
        Class<i> cls = i.class;
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property != null) {
            try {
                i cast = cls.cast(Class.forName(property, true, cls.getClassLoader()).newInstance());
                i.b(cast);
                ((ArrayList) this.f1249a).add(cast);
                return null;
            } catch (Exception e5) {
                throw new Error(e5);
            }
        } else {
            i.b(new i());
            return null;
        }
    }
}
