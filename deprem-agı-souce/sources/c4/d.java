package c4;

import V3.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

class d extends f {

    /* renamed from: c  reason: collision with root package name */
    private final Method f20831c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f20832d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f20833e;

    /* renamed from: f  reason: collision with root package name */
    private final Class f20834f;

    /* renamed from: g  reason: collision with root package name */
    private final Class f20835g;

    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List f20836a;

        /* renamed from: b  reason: collision with root package name */
        boolean f20837b;

        /* renamed from: c  reason: collision with root package name */
        String f20838c;

        a(List list) {
            this.f20836a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = c.f19700b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f20837b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f20836a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof List) {
                        List list = (List) obj2;
                        int size = list.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            if (this.f20836a.contains(list.get(i5))) {
                                String str = (String) list.get(i5);
                                this.f20838c = str;
                                return str;
                            }
                        }
                        String str2 = (String) this.f20836a.get(0);
                        this.f20838c = str2;
                        return str2;
                    }
                }
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f20838c = (String) objArr[0];
                return null;
            }
        }
    }

    d(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f20831c = method;
        this.f20832d = method2;
        this.f20833e = method3;
        this.f20834f = cls;
        this.f20835g = cls2;
    }

    public static f r() {
        Class<SSLSocket> cls = SSLSocket.class;
        try {
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls2.getMethod("put", new Class[]{cls, cls3});
            return new d(method, cls2.getMethod("get", new Class[]{cls}), cls2.getMethod("remove", new Class[]{cls}), cls4, cls5);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public void a(SSLSocket sSLSocket) {
        try {
            this.f20833e.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw c.a("unable to remove alpn", e5);
        }
    }

    public void f(SSLSocket sSLSocket, String str, List list) {
        List b5 = f.b(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f20834f, this.f20835g}, new a(b5));
            this.f20831c.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw c.a("unable to set alpn", e5);
        }
    }

    public String l(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f20832d.invoke((Object) null, new Object[]{sSLSocket}));
            boolean z4 = aVar.f20837b;
            if (!z4 && aVar.f20838c == null) {
                f.i().p(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z4) {
                return null;
            } else {
                return aVar.f20838c;
            }
        } catch (InvocationTargetException e5) {
            e = e5;
            throw c.a("unable to get selected protocol", e);
        } catch (IllegalAccessException e6) {
            e = e6;
            throw c.a("unable to get selected protocol", e);
        }
    }
}
