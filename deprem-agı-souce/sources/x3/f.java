package X3;

import U3.B;
import U3.C2202a;
import U3.e;
import U3.o;
import U3.r;
import V3.c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final C2202a f20093a;

    /* renamed from: b  reason: collision with root package name */
    private final d f20094b;

    /* renamed from: c  reason: collision with root package name */
    private final e f20095c;

    /* renamed from: d  reason: collision with root package name */
    private final o f20096d;

    /* renamed from: e  reason: collision with root package name */
    private List f20097e;

    /* renamed from: f  reason: collision with root package name */
    private int f20098f;

    /* renamed from: g  reason: collision with root package name */
    private List f20099g;

    /* renamed from: h  reason: collision with root package name */
    private final List f20100h = new ArrayList();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f20101a;

        /* renamed from: b  reason: collision with root package name */
        private int f20102b = 0;

        a(List list) {
            this.f20101a = list;
        }

        public List a() {
            return new ArrayList(this.f20101a);
        }

        public boolean b() {
            if (this.f20102b < this.f20101a.size()) {
                return true;
            }
            return false;
        }

        public B c() {
            if (b()) {
                List list = this.f20101a;
                int i5 = this.f20102b;
                this.f20102b = i5 + 1;
                return (B) list.get(i5);
            }
            throw new NoSuchElementException();
        }
    }

    public f(C2202a aVar, d dVar, e eVar, o oVar) {
        List list = Collections.EMPTY_LIST;
        this.f20097e = list;
        this.f20099g = list;
        this.f20093a = aVar;
        this.f20094b = dVar;
        this.f20095c = eVar;
        this.f20096d = oVar;
        h(aVar.l(), aVar.g());
    }

    static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean d() {
        if (this.f20098f < this.f20097e.size()) {
            return true;
        }
        return false;
    }

    private Proxy f() {
        if (d()) {
            List list = this.f20097e;
            int i5 = this.f20098f;
            this.f20098f = i5 + 1;
            Proxy proxy = (Proxy) list.get(i5);
            g(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f20093a.l().k() + "; exhausted proxy configurations: " + this.f20097e);
    }

    private void g(Proxy proxy) {
        String str;
        int i5;
        this.f20099g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f20093a.l().k();
            i5 = this.f20093a.l().w();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = b(inetSocketAddress);
                i5 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i5 < 1 || i5 > 65535) {
            throw new SocketException("No route to " + str + ":" + i5 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f20099g.add(InetSocketAddress.createUnresolved(str, i5));
        } else {
            this.f20096d.j(this.f20095c, str);
            List lookup = this.f20093a.c().lookup(str);
            if (!lookup.isEmpty()) {
                this.f20096d.i(this.f20095c, str, lookup);
                int size = lookup.size();
                for (int i6 = 0; i6 < size; i6++) {
                    this.f20099g.add(new InetSocketAddress((InetAddress) lookup.get(i6), i5));
                }
                return;
            }
            throw new UnknownHostException(this.f20093a.c() + " returned no addresses for " + str);
        }
    }

    private void h(r rVar, Proxy proxy) {
        List list;
        if (proxy != null) {
            this.f20097e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f20093a.i().select(rVar.B());
            if (select == null || select.isEmpty()) {
                list = c.r(Proxy.NO_PROXY);
            } else {
                list = c.q(select);
            }
            this.f20097e = list;
        }
        this.f20098f = 0;
    }

    public void a(B b5, IOException iOException) {
        if (!(b5.b().type() == Proxy.Type.DIRECT || this.f20093a.i() == null)) {
            this.f20093a.i().connectFailed(this.f20093a.l().B(), b5.b().address(), iOException);
        }
        this.f20094b.b(b5);
    }

    public boolean c() {
        if (d() || !this.f20100h.isEmpty()) {
            return true;
        }
        return false;
    }

    public a e() {
        if (c()) {
            ArrayList arrayList = new ArrayList();
            while (d()) {
                Proxy f5 = f();
                int size = this.f20099g.size();
                for (int i5 = 0; i5 < size; i5++) {
                    B b5 = new B(this.f20093a, f5, (InetSocketAddress) this.f20099g.get(i5));
                    if (this.f20094b.c(b5)) {
                        this.f20100h.add(b5);
                    } else {
                        arrayList.add(b5);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f20100h);
                this.f20100h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
