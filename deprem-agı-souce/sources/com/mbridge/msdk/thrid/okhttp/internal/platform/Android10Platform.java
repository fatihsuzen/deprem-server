package com.mbridge.msdk.thrid.okhttp.internal.platform;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

@SuppressLint({"NewApi"})
class Android10Platform extends AndroidPlatform {
    Android10Platform(Class<?> cls) {
        super(cls, (OptionalMethod<Socket>) null, (OptionalMethod<Socket>) null, (OptionalMethod<Socket>) null, (OptionalMethod<Socket>) null);
    }

    public static Platform buildIfSupported() {
        if (!Platform.isAndroid()) {
            return null;
        }
        try {
            if (AndroidPlatform.getSdkInt() >= 29) {
                return new Android10Platform(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ClassNotFoundException unused) {
        }
        return null;
    }

    private void enableSessionTickets(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @SuppressLint({"NewApi"})
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        try {
            enableSessionTickets(sSLSocket);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) Platform.alpnProtocolNames(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e5) {
            throw new IOException("Android internal error", e5);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String a5 = sSLSocket.getApplicationProtocol();
        if (a5 == null || a5.isEmpty()) {
            return null;
        }
        return a5;
    }
}
