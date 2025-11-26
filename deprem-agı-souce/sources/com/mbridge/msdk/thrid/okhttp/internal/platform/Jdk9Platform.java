package com.mbridge.msdk.thrid.okhttp.internal.platform;

import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

final class Jdk9Platform extends Platform {
    final Method getProtocolMethod;
    final Method setProtocolMethod;

    Jdk9Platform(Method method, Method method2) {
        this.setProtocolMethod = method;
        this.getProtocolMethod = method2;
    }

    public static Jdk9Platform buildIfSupported() {
        try {
            return new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", (Class[]) null));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> alpnProtocolNames = Platform.alpnProtocolNames(list);
            this.setProtocolMethod.invoke(sSLParameters, new Object[]{alpnProtocolNames.toArray(new String[alpnProtocolNames.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw Util.assertionError("unable to set ssl parameters", e5);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            String str = (String) this.getProtocolMethod.invoke(sSLSocket, (Object[]) null);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw Util.assertionError("failed to get ALPN selected protocol", e5);
        } catch (IllegalAccessException e6) {
            throw Util.assertionError("failed to get ALPN selected protocol", e6);
        }
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
