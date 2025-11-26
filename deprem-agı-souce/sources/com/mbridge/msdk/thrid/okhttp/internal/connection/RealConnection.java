package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.thrid.okhttp.Address;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Connection;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Handshake;
import com.mbridge.msdk.thrid.okhttp.HttpUrl;
import com.mbridge.msdk.thrid.okhttp.Interceptor;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.Route;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.Version;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpCodec;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.internal.http1.Http1Codec;
import com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Codec;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import com.mbridge.msdk.thrid.okhttp.internal.tls.OkHostnameVerifier;
import com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Source;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class RealConnection extends Http2Connection.Listener implements Connection {
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public int allocationLimit = 1;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    private final ConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    public long idleAtNanos = Long.MAX_VALUE;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    public int successCount;

    public RealConnection(ConnectionPool connectionPool2, Route route2) {
        this.connectionPool = connectionPool2;
        this.route = route2;
    }

    private void connectSocket(int i5, int i6, Call call, EventListener eventListener) throws IOException {
        Socket socket2;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
            socket2 = address.socketFactory().createSocket();
        } else {
            socket2 = new Socket(proxy);
        }
        this.rawSocket = socket2;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(i6);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i5);
            try {
                this.source = Okio.buffer(Okio.source(this.rawSocket));
                this.sink = Okio.buffer(Okio.sink(this.rawSocket));
            } catch (NullPointerException e5) {
                if (NPE_THROW_WITH_NULL.equals(e5.getMessage())) {
                    throw new IOException(e5);
                }
            }
        } catch (ConnectException e6) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress());
            connectException.initCause(e6);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0138 A[Catch:{ all -> 0x012f }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013e A[Catch:{ all -> 0x012f }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void connectTls(com.mbridge.msdk.thrid.okhttp.internal.connection.ConnectionSpecSelector r8) throws java.io.IOException {
        /*
            r7 = this;
            com.mbridge.msdk.thrid.okhttp.Route r0 = r7.route
            com.mbridge.msdk.thrid.okhttp.Address r0 = r0.address()
            javax.net.ssl.SSLSocketFactory r1 = r0.sslSocketFactory()
            r2 = 0
            java.net.Socket r3 = r7.rawSocket     // Catch:{ AssertionError -> 0x0131 }
            com.mbridge.msdk.thrid.okhttp.HttpUrl r4 = r0.url()     // Catch:{ AssertionError -> 0x0131 }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x0131 }
            com.mbridge.msdk.thrid.okhttp.HttpUrl r5 = r0.url()     // Catch:{ AssertionError -> 0x0131 }
            int r5 = r5.port()     // Catch:{ AssertionError -> 0x0131 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0131 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x0131 }
            com.mbridge.msdk.thrid.okhttp.ConnectionSpec r8 = r8.configureSecureSocket(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r3 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r3 == 0) goto L_0x004a
            com.mbridge.msdk.thrid.okhttp.internal.platform.Platform r3 = com.mbridge.msdk.thrid.okhttp.internal.platform.Platform.get()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okhttp.HttpUrl r4 = r0.url()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r5 = r0.protocols()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.configureTlsExtensions(r1, r4, r5)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            goto L_0x004a
        L_0x0042:
            r8 = move-exception
            r2 = r1
            goto L_0x013f
        L_0x0046:
            r8 = move-exception
            r2 = r1
            goto L_0x0132
        L_0x004a:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okhttp.Handshake r4 = com.mbridge.msdk.thrid.okhttp.Handshake.get(r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.HostnameVerifier r5 = r0.hostnameVerifier()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okhttp.HttpUrl r6 = r0.url()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r6 = r6.host()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r3 != 0) goto L_0x00e1
            java.util.List r8 = r4.peerCertificates()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r2 = r8.isEmpty()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r3 = "Hostname "
            if (r2 != 0) goto L_0x00bf
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r4.<init>()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r4.append(r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okhttp.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = com.mbridge.msdk.thrid.okhttp.CertificatePinner.pin(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = "\n    DN: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r8 = com.mbridge.msdk.thrid.okhttp.internal.tls.OkHostnameVerifier.allSubjectAltNames(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r4.append(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r8 = r4.toString()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            throw r2     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x00bf:
            javax.net.ssl.SSLPeerUnverifiedException r8 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r2.<init>()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r2.append(r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okhttp.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r2.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = " not verified (no certificates)"
            r2.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r2.toString()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r8.<init>(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            throw r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x00e1:
            com.mbridge.msdk.thrid.okhttp.CertificatePinner r3 = r0.certificatePinner()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okhttp.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r5 = r4.peerCertificates()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.check((java.lang.String) r0, (java.util.List<java.security.cert.Certificate>) r5)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r8 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r8 == 0) goto L_0x0102
            com.mbridge.msdk.thrid.okhttp.internal.platform.Platform r8 = com.mbridge.msdk.thrid.okhttp.internal.platform.Platform.get()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r2 = r8.getSelectedProtocol(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x0102:
            r7.socket = r1     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okio.Source r8 = com.mbridge.msdk.thrid.okio.Okio.source((java.net.Socket) r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okio.BufferedSource r8 = com.mbridge.msdk.thrid.okio.Okio.buffer((com.mbridge.msdk.thrid.okio.Source) r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.source = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.net.Socket r8 = r7.socket     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okio.Sink r8 = com.mbridge.msdk.thrid.okio.Okio.sink((java.net.Socket) r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okio.BufferedSink r8 = com.mbridge.msdk.thrid.okio.Okio.buffer((com.mbridge.msdk.thrid.okio.Sink) r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.sink = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.handshake = r4     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r2 == 0) goto L_0x0123
            com.mbridge.msdk.thrid.okhttp.Protocol r8 = com.mbridge.msdk.thrid.okhttp.Protocol.get(r2)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            goto L_0x0125
        L_0x0123:
            com.mbridge.msdk.thrid.okhttp.Protocol r8 = com.mbridge.msdk.thrid.okhttp.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x0125:
            r7.protocol = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            com.mbridge.msdk.thrid.okhttp.internal.platform.Platform r8 = com.mbridge.msdk.thrid.okhttp.internal.platform.Platform.get()
            r8.afterHandshake(r1)
            return
        L_0x012f:
            r8 = move-exception
            goto L_0x013f
        L_0x0131:
            r8 = move-exception
        L_0x0132:
            boolean r0 = com.mbridge.msdk.thrid.okhttp.internal.Util.isAndroidGetsocknameError(r8)     // Catch:{ all -> 0x012f }
            if (r0 == 0) goto L_0x013e
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x012f }
            r0.<init>(r8)     // Catch:{ all -> 0x012f }
            throw r0     // Catch:{ all -> 0x012f }
        L_0x013e:
            throw r8     // Catch:{ all -> 0x012f }
        L_0x013f:
            if (r2 == 0) goto L_0x0148
            com.mbridge.msdk.thrid.okhttp.internal.platform.Platform r0 = com.mbridge.msdk.thrid.okhttp.internal.platform.Platform.get()
            r0.afterHandshake(r2)
        L_0x0148:
            com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.net.Socket) r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection.connectTls(com.mbridge.msdk.thrid.okhttp.internal.connection.ConnectionSpecSelector):void");
    }

    private void connectTunnel(int i5, int i6, int i7, Call call, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i8 = 0;
        while (i8 < 21) {
            connectSocket(i5, i6, call, eventListener);
            createTunnelRequest = createTunnel(i6, i7, createTunnelRequest, url);
            if (createTunnelRequest != null) {
                Util.closeQuietly(this.rawSocket);
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), (Protocol) null);
                i8++;
            } else {
                return;
            }
        }
    }

    private Request createTunnel(int i5, int i6, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec((OkHttpClient) null, (StreamAllocation) null, this.source, this.sink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.source.timeout().timeout((long) i5, timeUnit);
            this.sink.timeout().timeout((long) i6, timeUnit);
            http1Codec.writeRequest(request.headers(), str);
            http1Codec.finishRequest();
            Response build = http1Codec.readResponseHeaders(false).request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, timeUnit);
            newFixedLengthSource.close();
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if (CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(build.header("Connection"))) {
                        return authenticate;
                    } else {
                        request = authenticate;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private Request createTunnelRequest() throws IOException {
        Request build = new Request.Builder().url(this.route.address().url()).method("CONNECT", (RequestBody) null).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header(Command.HTTP_HEADER_USER_AGENT, Version.userAgent()).build();
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        if (authenticate != null) {
            return authenticate;
        }
        return build;
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i5, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() == null) {
            List<Protocol> protocols = this.route.address().protocols();
            Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (protocols.contains(protocol2)) {
                this.socket = this.rawSocket;
                this.protocol = protocol2;
                startHttp2(i5);
                return;
            }
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
            return;
        }
        eventListener.secureConnectStart(call);
        connectTls(connectionSpecSelector);
        eventListener.secureConnectEnd(call, this.handshake);
        if (this.protocol == Protocol.HTTP_2) {
            startHttp2(i5);
        }
    }

    private void startHttp2(int i5) throws IOException {
        this.socket.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i5).build();
        this.http2Connection = build;
        build.start();
    }

    public static RealConnection testConnection(ConnectionPool connectionPool2, Route route2, Socket socket2, long j5) {
        RealConnection realConnection = new RealConnection(connectionPool2, route2);
        realConnection.socket = socket2;
        realConnection.idleAtNanos = j5;
        return realConnection;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.mbridge.msdk.thrid.okhttp.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.mbridge.msdk.thrid.okhttp.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.mbridge.msdk.thrid.okhttp.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.mbridge.msdk.thrid.okhttp.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.mbridge.msdk.thrid.okhttp.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.mbridge.msdk.thrid.okhttp.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.mbridge.msdk.thrid.okhttp.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: com.mbridge.msdk.thrid.okhttp.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: com.mbridge.msdk.thrid.okhttp.EventListener} */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab A[Catch:{ IOException -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(int r13, int r14, int r15, int r16, boolean r17, com.mbridge.msdk.thrid.okhttp.Call r18, com.mbridge.msdk.thrid.okhttp.EventListener r19) {
        /*
            r12 = this;
            com.mbridge.msdk.thrid.okhttp.Protocol r0 = r12.protocol
            if (r0 != 0) goto L_0x014e
            com.mbridge.msdk.thrid.okhttp.Route r0 = r12.route
            com.mbridge.msdk.thrid.okhttp.Address r0 = r0.address()
            java.util.List r0 = r0.connectionSpecs()
            com.mbridge.msdk.thrid.okhttp.internal.connection.ConnectionSpecSelector r7 = new com.mbridge.msdk.thrid.okhttp.internal.connection.ConnectionSpecSelector
            r7.<init>(r0)
            com.mbridge.msdk.thrid.okhttp.Route r1 = r12.route
            com.mbridge.msdk.thrid.okhttp.Address r1 = r1.address()
            javax.net.ssl.SSLSocketFactory r1 = r1.sslSocketFactory()
            if (r1 != 0) goto L_0x006e
            com.mbridge.msdk.thrid.okhttp.ConnectionSpec r1 = com.mbridge.msdk.thrid.okhttp.ConnectionSpec.CLEARTEXT
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0061
            com.mbridge.msdk.thrid.okhttp.Route r0 = r12.route
            com.mbridge.msdk.thrid.okhttp.Address r0 = r0.address()
            com.mbridge.msdk.thrid.okhttp.HttpUrl r0 = r0.url()
            java.lang.String r0 = r0.host()
            com.mbridge.msdk.thrid.okhttp.internal.platform.Platform r1 = com.mbridge.msdk.thrid.okhttp.internal.platform.Platform.get()
            boolean r1 = r1.isCleartextTrafficPermitted(r0)
            if (r1 == 0) goto L_0x0040
            goto L_0x0080
        L_0x0040:
            com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException r13 = new com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException
            java.net.UnknownServiceException r14 = new java.net.UnknownServiceException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r1 = "CLEARTEXT communication to "
            r15.append(r1)
            r15.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            r13.<init>(r14)
            throw r13
        L_0x0061:
            com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException r13 = new com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException
            java.net.UnknownServiceException r14 = new java.net.UnknownServiceException
            java.lang.String r15 = "CLEARTEXT communication not enabled for client"
            r14.<init>(r15)
            r13.<init>(r14)
            throw r13
        L_0x006e:
            com.mbridge.msdk.thrid.okhttp.Route r0 = r12.route
            com.mbridge.msdk.thrid.okhttp.Address r0 = r0.address()
            java.util.List r0 = r0.protocols()
            com.mbridge.msdk.thrid.okhttp.Protocol r1 = com.mbridge.msdk.thrid.okhttp.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0141
        L_0x0080:
            r8 = 0
            r9 = r8
        L_0x0082:
            com.mbridge.msdk.thrid.okhttp.Route r0 = r12.route     // Catch:{ IOException -> 0x00fa }
            boolean r0 = r0.requiresTunnel()     // Catch:{ IOException -> 0x00fa }
            if (r0 == 0) goto L_0x00ab
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r18
            r6 = r19
            r1.connectTunnel(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00a6 }
            r10 = r3
            r2 = r5
            r1 = r6
            java.net.Socket r0 = r12.rawSocket     // Catch:{ IOException -> 0x00a0 }
            if (r0 != 0) goto L_0x009d
            goto L_0x00c8
        L_0x009d:
            r11 = r16
            goto L_0x00b4
        L_0x00a0:
            r0 = move-exception
        L_0x00a1:
            r11 = r16
        L_0x00a3:
            r6 = r0
            goto L_0x0103
        L_0x00a6:
            r0 = move-exception
            r10 = r3
            r2 = r5
            r1 = r6
            goto L_0x00a1
        L_0x00ab:
            r10 = r14
            r2 = r18
            r1 = r19
            r12.connectSocket(r13, r14, r2, r1)     // Catch:{ IOException -> 0x00a0 }
            goto L_0x009d
        L_0x00b4:
            r12.establishProtocol(r7, r11, r2, r1)     // Catch:{ IOException -> 0x00f8 }
            com.mbridge.msdk.thrid.okhttp.Route r0 = r12.route     // Catch:{ IOException -> 0x00f8 }
            java.net.InetSocketAddress r0 = r0.socketAddress()     // Catch:{ IOException -> 0x00f8 }
            com.mbridge.msdk.thrid.okhttp.Route r3 = r12.route     // Catch:{ IOException -> 0x00f8 }
            java.net.Proxy r3 = r3.proxy()     // Catch:{ IOException -> 0x00f8 }
            com.mbridge.msdk.thrid.okhttp.Protocol r4 = r12.protocol     // Catch:{ IOException -> 0x00f8 }
            r1.connectEnd(r2, r0, r3, r4)     // Catch:{ IOException -> 0x00f8 }
        L_0x00c8:
            com.mbridge.msdk.thrid.okhttp.Route r13 = r12.route
            boolean r13 = r13.requiresTunnel()
            if (r13 == 0) goto L_0x00e2
            java.net.Socket r13 = r12.rawSocket
            if (r13 == 0) goto L_0x00d5
            goto L_0x00e2
        L_0x00d5:
            java.net.ProtocolException r13 = new java.net.ProtocolException
            java.lang.String r14 = "Too many tunnel connections attempted: 21"
            r13.<init>(r14)
            com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException r14 = new com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException
            r14.<init>(r13)
            throw r14
        L_0x00e2:
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r13 = r12.http2Connection
            if (r13 == 0) goto L_0x00f7
            com.mbridge.msdk.thrid.okhttp.ConnectionPool r13 = r12.connectionPool
            monitor-enter(r13)
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r14 = r12.http2Connection     // Catch:{ all -> 0x00f3 }
            int r14 = r14.maxConcurrentStreams()     // Catch:{ all -> 0x00f3 }
            r12.allocationLimit = r14     // Catch:{ all -> 0x00f3 }
            monitor-exit(r13)     // Catch:{ all -> 0x00f3 }
            goto L_0x00f7
        L_0x00f3:
            r0 = move-exception
            r14 = r0
            monitor-exit(r13)     // Catch:{ all -> 0x00f3 }
            throw r14
        L_0x00f7:
            return
        L_0x00f8:
            r0 = move-exception
            goto L_0x00a3
        L_0x00fa:
            r0 = move-exception
            r10 = r14
            r11 = r16
            r2 = r18
            r1 = r19
            goto L_0x00a3
        L_0x0103:
            java.net.Socket r0 = r12.socket
            com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.net.Socket) r0)
            java.net.Socket r0 = r12.rawSocket
            com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.net.Socket) r0)
            r12.socket = r8
            r12.rawSocket = r8
            r12.source = r8
            r12.sink = r8
            r12.handshake = r8
            r12.protocol = r8
            r12.http2Connection = r8
            com.mbridge.msdk.thrid.okhttp.Route r0 = r12.route
            java.net.InetSocketAddress r3 = r0.socketAddress()
            com.mbridge.msdk.thrid.okhttp.Route r0 = r12.route
            java.net.Proxy r4 = r0.proxy()
            r5 = 0
            r1.connectFailed(r2, r3, r4, r5, r6)
            if (r9 != 0) goto L_0x0133
            com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException r9 = new com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException
            r9.<init>(r6)
            goto L_0x0136
        L_0x0133:
            r9.addConnectException(r6)
        L_0x0136:
            if (r17 == 0) goto L_0x0140
            boolean r0 = r7.connectionFailed(r6)
            if (r0 == 0) goto L_0x0140
            goto L_0x0082
        L_0x0140:
            throw r9
        L_0x0141:
            com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException r13 = new com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException
            java.net.UnknownServiceException r14 = new java.net.UnknownServiceException
            java.lang.String r15 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r14.<init>(r15)
            r13.<init>(r14)
            throw r13
        L_0x014e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "already connected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection.connect(int, int, int, int, boolean, com.mbridge.msdk.thrid.okhttp.Call, com.mbridge.msdk.thrid.okhttp.EventListener):void");
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isEligible(Address address, Route route2) {
        Proxy.Type type;
        if (this.allocations.size() >= this.allocationLimit || this.noNewStreams || !Internal.instance.equalsNonHost(this.route.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || route2 == null || route2.proxy().type() != (type = Proxy.Type.DIRECT) || this.route.proxy().type() != type || !this.route.socketAddress().equals(route2.socketAddress()) || route2.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean isHealthy(boolean z4) {
        int soTimeout;
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return http2Connection2.isHealthy(System.nanoTime());
        }
        if (z4) {
            try {
                soTimeout = this.socket.getSoTimeout();
                this.socket.setSoTimeout(1);
                if (this.source.exhausted()) {
                    this.socket.setSoTimeout(soTimeout);
                    return false;
                }
                this.socket.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.socket.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        if (this.http2Connection != null) {
            return true;
        }
        return false;
    }

    public HttpCodec newCodec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation) throws SocketException {
        if (this.http2Connection != null) {
            return new Http2Codec(okHttpClient, chain, streamAllocation, this.http2Connection);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.source.timeout().timeout((long) chain.readTimeoutMillis(), timeUnit);
        this.sink.timeout().timeout((long) chain.writeTimeoutMillis(), timeUnit);
        return new Http1Codec(okHttpClient, streamAllocation, this.source, this.sink);
    }

    public RealWebSocket.Streams newWebSocketStreams(StreamAllocation streamAllocation) {
        final StreamAllocation streamAllocation2 = streamAllocation;
        return new RealWebSocket.Streams(true, this.source, this.sink) {
            public void close() throws IOException {
                StreamAllocation streamAllocation = streamAllocation2;
                streamAllocation.streamFinished(true, streamAllocation.codec(), -1, (IOException) null);
            }
        };
    }

    public void onSettings(Http2Connection http2Connection2) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection2.maxConcurrentStreams();
        }
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public Route route() {
        return this.route;
    }

    public Socket socket() {
        return this.socket;
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        if (httpUrl.port() != this.route.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.route.address().url().host())) {
            return true;
        }
        if (this.handshake == null || !OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) this.handshake.peerCertificates().get(0))) {
            return false;
        }
        return true;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.route.address().url().host());
        sb.append(":");
        sb.append(this.route.address().url().port());
        sb.append(", proxy=");
        sb.append(this.route.proxy());
        sb.append(" hostAddress=");
        sb.append(this.route.socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        if (handshake2 != null) {
            obj = handshake2.cipherSuite();
        } else {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
