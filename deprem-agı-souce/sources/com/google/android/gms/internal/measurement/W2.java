package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class W2 {
    public static r a(Object obj) {
        if (obj == null) {
            return r.f5554c0;
        }
        if (obj instanceof String) {
            return new C1235v((String) obj);
        }
        if (obj instanceof Double) {
            return new C1128j((Double) obj);
        }
        if (obj instanceof Long) {
            return new C1128j(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new C1128j(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new C1101g((Boolean) obj);
        }
        if (obj instanceof Map) {
            C1173o oVar = new C1173o();
            Map map = (Map) obj;
            for (Object next : map.keySet()) {
                r a5 = a(map.get(next));
                if (next != null) {
                    if (!(next instanceof String)) {
                        next = next.toString();
                    }
                    oVar.g((String) next, a5);
                }
            }
            return oVar;
        } else if (obj instanceof List) {
            C1092f fVar = new C1092f();
            for (Object a6 : (List) obj) {
                fVar.r(fVar.o(), a(a6));
            }
            return fVar;
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public static r b(C3 c32) {
        if (c32 == null) {
            return r.f5553b0;
        }
        int O4 = c32.O() - 1;
        if (O4 != 1) {
            if (O4 != 2) {
                if (O4 != 3) {
                    if (O4 == 4) {
                        List<C3> F4 = c32.F();
                        ArrayList arrayList = new ArrayList();
                        for (C3 b5 : F4) {
                            arrayList.add(b(b5));
                        }
                        return new C1208s(c32.G(), arrayList);
                    }
                    throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
                } else if (c32.J()) {
                    return new C1101g(Boolean.valueOf(c32.K()));
                } else {
                    return new C1101g((Boolean) null);
                }
            } else if (c32.L()) {
                return new C1128j(Double.valueOf(c32.M()));
            } else {
                return new C1128j((Double) null);
            }
        } else if (c32.H()) {
            return new C1235v(c32.I());
        } else {
            return r.f5560i0;
        }
    }
}
