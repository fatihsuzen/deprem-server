package L2;

import J2.u;
import P3.d;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;

public abstract class k {
    public static u a(u uVar, h hVar) {
        String str;
        Integer num;
        Map map;
        t.e(uVar, "tcModel");
        d dVar = uVar.f18314a;
        if (dVar == null) {
            throw new g(t.n("g.m", ": Unable to encode TCModel without a GVL"));
        } else if (dVar.f18876h) {
            String str2 = dVar.f18880l;
            if (str2 == null) {
                str = "en";
            } else {
                Locale locale = Locale.ROOT;
                t.d(locale, "ROOT");
                str = str2.toUpperCase(locale);
                t.d(str, "this as java.lang.String).toUpperCase(locale)");
            }
            t.e(str, "<set-?>");
            uVar.f18325l = str;
            if (hVar == null || (num = hVar.f18420b) == null) {
                return uVar;
            }
            int intValue = num.intValue();
            if (intValue < 1) {
                uVar.f18332s.unset(1);
                uVar.f18309C.forEach(new i(uVar));
                uVar.f18339z.forEach(new j(uVar));
                d dVar2 = uVar.f18314a;
                if (!(dVar2 == null || (map = dVar2.f18877i) == null)) {
                    uVar.f18311E.set((Set<String>) map.keySet());
                }
            }
            uVar.f18322i = intValue;
            return uVar;
        } else {
            throw new g(t.n("g.m", ": Unable to encode TCModel tcModel.gvl.readyPromise is not resolved"));
        }
    }
}
