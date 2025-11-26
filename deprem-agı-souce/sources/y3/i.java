package Y3;

import U3.r;
import U3.x;
import java.net.Proxy;

public abstract class i {
    public static String a(x xVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(xVar.g());
        sb.append(' ');
        if (b(xVar, type)) {
            sb.append(xVar.i());
        } else {
            sb.append(c(xVar.i()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(x xVar, Proxy.Type type) {
        if (xVar.f() || type != Proxy.Type.HTTP) {
            return false;
        }
        return true;
    }

    public static String c(r rVar) {
        String g5 = rVar.g();
        String i5 = rVar.i();
        if (i5 == null) {
            return g5;
        }
        return g5 + '?' + i5;
    }
}
