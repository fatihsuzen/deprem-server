package Z1;

import S1.k;
import Y1.C2260d;
import android.content.Context;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: Z1.c  reason: case insensitive filesystem */
public final class C2263c {

    /* renamed from: g  reason: collision with root package name */
    public static final a f20239g = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final i f20240a;

    /* renamed from: b  reason: collision with root package name */
    private final d f20241b;

    /* renamed from: c  reason: collision with root package name */
    private final C2261a f20242c;

    /* renamed from: d  reason: collision with root package name */
    private Socket f20243d;

    /* renamed from: e  reason: collision with root package name */
    private Socket f20244e;

    /* renamed from: f  reason: collision with root package name */
    private C2260d f20245f;

    /* renamed from: Z1.c$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public C2263c(i iVar, Context context) {
        t.e(iVar, "nsdListener");
        t.e(context, "context");
        this.f20240a = iVar;
        this.f20241b = new d(context, iVar, this);
        this.f20242c = new C2261a(iVar, this);
    }

    private final void a() {
        try {
            Socket socket = this.f20243d;
            if (socket != null) {
                socket.close();
            }
            this.f20243d = null;
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    private final void b() {
        try {
            Socket socket = this.f20244e;
            if (socket != null) {
                socket.close();
            }
            this.f20244e = null;
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    private final void d(NsdServiceInfo nsdServiceInfo) {
        try {
            InetAddress host = nsdServiceInfo.getHost();
            if (Build.VERSION.SDK_INT >= 34) {
                Iterator it = nsdServiceInfo.getHostAddresses().iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (inetAddress != null) {
                            host = inetAddress;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            m(new Socket(host, nsdServiceInfo.getPort()));
            this.f20240a.z(nsdServiceInfo);
        } catch (ConnectException unused) {
            this.f20240a.c();
        } catch (IOException unused2) {
            this.f20240a.c();
        }
    }

    private final synchronized void n(Socket socket) {
        Socket socket2 = this.f20244e;
        if (socket2 != null && socket2.isConnected()) {
            try {
                Socket socket3 = this.f20244e;
                if (socket3 != null) {
                    socket3.close();
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        this.f20244e = socket;
    }

    public final void c() {
        NsdServiceInfo nsdServiceInfo;
        h o5 = k.f32g.o();
        if (o5 != null) {
            nsdServiceInfo = o5.e();
        } else {
            nsdServiceInfo = null;
        }
        if (nsdServiceInfo != null) {
            d(nsdServiceInfo);
        }
    }

    public final C2260d e() {
        return this.f20245f;
    }

    public final Socket f() {
        return this.f20243d;
    }

    public final Socket g() {
        return this.f20244e;
    }

    public final C2261a h() {
        return this.f20242c;
    }

    public final d i() {
        return this.f20241b;
    }

    public final boolean j() {
        Socket socket = this.f20243d;
        if (socket == null) {
            return false;
        }
        t.b(socket);
        if (!socket.isClosed()) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        Socket socket = this.f20244e;
        if (socket == null) {
            return false;
        }
        t.b(socket);
        if (!socket.isClosed()) {
            return true;
        }
        return false;
    }

    public final void l(C2260d dVar) {
        this.f20245f = dVar;
    }

    public final synchronized void m(Socket socket) {
        try {
            t.e(socket, "socket");
            Socket socket2 = this.f20243d;
            if (socket2 != null) {
                t.b(socket2);
                if (socket2.isConnected()) {
                    n(socket);
                }
            }
            this.f20243d = socket;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final void o(boolean z4) {
        Socket socket = this.f20243d;
        if (socket != null) {
            t.b(socket);
            if (!socket.isClosed()) {
                this.f20242c.g(z4);
                return;
            }
        }
        this.f20240a.p("Socket to write OK is null or closed");
    }

    public final void p() {
        Socket socket = this.f20243d;
        if (socket != null) {
            t.b(socket);
            if (!socket.isClosed()) {
                this.f20242c.h(k.f32g.p());
                return;
            }
        }
        this.f20240a.p("Socket to write ServiceName is null or closed");
    }

    public final void q(C2260d dVar) {
        t.e(dVar, "fti");
        Socket socket = this.f20243d;
        if (socket != null) {
            t.b(socket);
            if (!socket.isClosed()) {
                this.f20242c.i(dVar);
                return;
            }
        }
        this.f20240a.p("Socket to write FTI is null or closed");
    }

    public final void r() {
        this.f20241b.p();
        b();
        a();
    }
}
