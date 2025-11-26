package X3;

import U3.j;
import V3.a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List f20072a;

    /* renamed from: b  reason: collision with root package name */
    private int f20073b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f20074c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20075d;

    public b(List list) {
        this.f20072a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i5 = this.f20073b; i5 < this.f20072a.size(); i5++) {
            if (((j) this.f20072a.get(i5)).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public j a(SSLSocket sSLSocket) {
        j jVar;
        int i5 = this.f20073b;
        int size = this.f20072a.size();
        while (true) {
            if (i5 >= size) {
                jVar = null;
                break;
            }
            jVar = (j) this.f20072a.get(i5);
            if (jVar.c(sSLSocket)) {
                this.f20073b = i5 + 1;
                break;
            }
            i5++;
        }
        if (jVar != null) {
            this.f20074c = c(sSLSocket);
            a.f19697a.c(jVar, sSLSocket, this.f20075d);
            return jVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f20075d + ", modes=" + this.f20072a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f20075d = true;
        if (!this.f20074c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z4 = iOException instanceof SSLHandshakeException;
        if ((z4 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z4 || (iOException instanceof SSLProtocolException)) {
            return true;
        }
        return false;
    }
}
