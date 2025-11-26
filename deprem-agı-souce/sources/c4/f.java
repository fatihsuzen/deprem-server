package c4;

import U3.u;
import U3.v;
import d4.a;
import d4.b;
import d4.c;
import d4.e;
import e4.C2356e;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final f f20842a = h();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f20843b = Logger.getLogger(u.class.getName());

    public static List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            v vVar = (v) list.get(i5);
            if (vVar != v.HTTP_1_0) {
                arrayList.add(vVar.toString());
            }
        }
        return arrayList;
    }

    static byte[] e(List list) {
        C2356e eVar = new C2356e();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            v vVar = (v) list.get(i5);
            if (vVar != v.HTTP_1_0) {
                eVar.writeByte(vVar.toString().length());
                eVar.writeUtf8(vVar.toString());
            }
        }
        return eVar.readByteArray();
    }

    private static f h() {
        f r5;
        f t5 = a.t();
        if (t5 != null) {
            return t5;
        }
        if (o() && (r5 = b.r()) != null) {
            return r5;
        }
        c r6 = c.r();
        if (r6 != null) {
            return r6;
        }
        f r7 = d.r();
        if (r7 != null) {
            return r7;
        }
        return new f();
    }

    public static f i() {
        return f20842a;
    }

    public static boolean o() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public c c(X509TrustManager x509TrustManager) {
        return new a(d(x509TrustManager));
    }

    public e d(X509TrustManager x509TrustManager) {
        return new b(x509TrustManager.getAcceptedIssuers());
    }

    public void g(Socket socket, InetSocketAddress inetSocketAddress, int i5) {
        socket.connect(inetSocketAddress, i5);
    }

    public String j() {
        return "OkHttp";
    }

    public SSLContext k() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e5) {
            throw new IllegalStateException("No TLS provider", e5);
        }
    }

    public String l(SSLSocket sSLSocket) {
        return null;
    }

    public Object m(String str) {
        if (f20843b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean n(String str) {
        return true;
    }

    public void p(int i5, String str, Throwable th) {
        Level level;
        if (i5 == 5) {
            level = Level.WARNING;
        } else {
            level = Level.INFO;
        }
        f20843b.log(level, str, th);
    }

    public void q(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        p(5, str, (Throwable) obj);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void f(SSLSocket sSLSocket, String str, List list) {
    }
}
