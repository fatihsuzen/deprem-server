package c4;

import android.os.Build;
import android.util.Log;
import d4.e;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

class a extends f {

    /* renamed from: c  reason: collision with root package name */
    private final Class f20816c;

    /* renamed from: d  reason: collision with root package name */
    private final e f20817d;

    /* renamed from: e  reason: collision with root package name */
    private final e f20818e;

    /* renamed from: f  reason: collision with root package name */
    private final e f20819f;

    /* renamed from: g  reason: collision with root package name */
    private final e f20820g;

    /* renamed from: h  reason: collision with root package name */
    private final c f20821h = c.b();

    /* renamed from: c4.a$a  reason: collision with other inner class name */
    static final class C0213a extends d4.c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f20822a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f20823b;

        C0213a(Object obj, Method method) {
            this.f20822a = obj;
            this.f20823b = method;
        }

        public List a(List list, String str) {
            try {
                return (List) this.f20823b.invoke(this.f20822a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e5) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e5.getMessage());
                sSLPeerUnverifiedException.initCause(e5);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0213a;
        }

        public int hashCode() {
            return 0;
        }
    }

    static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f20824a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f20825b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f20825b = method;
            this.f20824a = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f20824a.equals(bVar.f20824a) || !this.f20825b.equals(bVar.f20825b)) {
                return false;
            }
            return true;
        }

        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f20825b.invoke(this.f20824a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e5) {
                throw V3.c.a("unable to get issues and signature", e5);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public int hashCode() {
            return this.f20824a.hashCode() + (this.f20825b.hashCode() * 31);
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Method f20826a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f20827b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f20828c;

        c(Method method, Method method2, Method method3) {
            this.f20826a = method;
            this.f20827b = method2;
            this.f20828c = method3;
        }

        static c b() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", (Class[]) null);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", (Class[]) null);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new c(method3, method, method2);
        }

        /* access modifiers changed from: package-private */
        public Object a(String str) {
            Method method = this.f20826a;
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, (Object[]) null);
                    this.f20827b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean c(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f20828c.invoke(obj, (Object[]) null);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    a(Class cls, e eVar, e eVar2, e eVar3, e eVar4) {
        this.f20816c = cls;
        this.f20817d = eVar;
        this.f20818e = eVar2;
        this.f20819f = eVar3;
        this.f20820g = eVar4;
    }

    private boolean r(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", (Class[]) null).invoke(obj, (Object[]) null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.n(str);
        }
    }

    private boolean s(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return r(str, cls, obj);
        }
    }

    public static f t() {
        Class<?> cls;
        e eVar;
        e eVar2;
        Class<byte[]> cls2 = byte[].class;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        e eVar3 = new e((Class) null, "setUseSessionTickets", Boolean.TYPE);
        e eVar4 = new e((Class) null, "setHostname", String.class);
        if (u()) {
            e eVar5 = new e(cls2, "getAlpnSelectedProtocol", new Class[0]);
            eVar = new e((Class) null, "setAlpnProtocols", cls2);
            eVar2 = eVar5;
        } else {
            eVar2 = null;
            eVar = null;
        }
        return new a(cls3, eVar3, eVar4, eVar2, eVar);
    }

    private static boolean u() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public d4.c c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            Class<String> cls2 = String.class;
            return new C0213a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, cls2, cls2}));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    public e d(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    public void f(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.f20817d.e(sSLSocket, Boolean.TRUE);
            this.f20818e.e(sSLSocket, str);
        }
        e eVar = this.f20820g;
        if (eVar != null && eVar.g(sSLSocket)) {
            this.f20820g.f(sSLSocket, f.e(list));
        }
    }

    public void g(Socket socket, InetSocketAddress inetSocketAddress, int i5) {
        try {
            socket.connect(inetSocketAddress, i5);
        } catch (AssertionError e5) {
            if (V3.c.w(e5)) {
                throw new IOException(e5);
            }
            throw e5;
        } catch (SecurityException e6) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e6);
            throw iOException;
        } catch (ClassCastException e7) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e7);
                throw iOException2;
            }
            throw e7;
        }
    }

    public String l(SSLSocket sSLSocket) {
        byte[] bArr;
        e eVar = this.f20819f;
        if (eVar == null || !eVar.g(sSLSocket) || (bArr = (byte[]) this.f20819f.f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, V3.c.f19708j);
    }

    public Object m(String str) {
        return this.f20821h.a(str);
    }

    public boolean n(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return s(str, cls, cls.getMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.n(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e5) {
            throw V3.c.a("unable to determine cleartext support", e5);
        }
    }

    public void p(int i5, String str, Throwable th) {
        int min;
        int i6 = 5;
        if (i5 != 5) {
            i6 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            int indexOf = str.indexOf(10, i7);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i7 + 4000);
                Log.println(i6, "OkHttp", str.substring(i7, min));
                if (min >= indexOf) {
                    break;
                }
                i7 = min;
            }
            i7 = min + 1;
        }
    }

    public void q(String str, Object obj) {
        if (!this.f20821h.c(obj)) {
            p(5, str, (Throwable) null);
        }
    }
}
