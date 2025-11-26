package c4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

final class c extends f {

    /* renamed from: c  reason: collision with root package name */
    final Method f20829c;

    /* renamed from: d  reason: collision with root package name */
    final Method f20830d;

    c(Method method, Method method2) {
        this.f20829c = method;
        this.f20830d = method2;
    }

    public static c r() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", (Class[]) null));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public void f(SSLSocket sSLSocket, String str, List list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List b5 = f.b(list);
            this.f20829c.invoke(sSLParameters, new Object[]{b5.toArray(new String[b5.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw V3.c.a("unable to set ssl parameters", e5);
        }
    }

    public String l(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f20830d.invoke(sSLSocket, (Object[]) null);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw V3.c.a("unable to get selected protocols", e5);
        }
    }
}
