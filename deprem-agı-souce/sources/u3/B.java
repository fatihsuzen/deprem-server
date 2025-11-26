package U3;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class B {

    /* renamed from: a  reason: collision with root package name */
    final C2202a f19308a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f19309b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f19310c;

    public B(C2202a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f19308a = aVar;
            this.f19309b = proxy;
            this.f19310c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public C2202a a() {
        return this.f19308a;
    }

    public Proxy b() {
        return this.f19309b;
    }

    public boolean c() {
        if (this.f19308a.f19326i == null || this.f19309b.type() != Proxy.Type.HTTP) {
            return false;
        }
        return true;
    }

    public InetSocketAddress d() {
        return this.f19310c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof B)) {
            return false;
        }
        B b5 = (B) obj;
        if (!b5.f19308a.equals(this.f19308a) || !b5.f19309b.equals(this.f19309b) || !b5.f19310c.equals(this.f19310c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((527 + this.f19308a.hashCode()) * 31) + this.f19309b.hashCode()) * 31) + this.f19310c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f19310c + "}";
    }
}
