package com.mbridge.msdk.thrid.okhttp.internal.http;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.thrid.okhttp.Address;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.CertificatePinner;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.HttpUrl;
import com.mbridge.msdk.thrid.okhttp.Interceptor;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import com.mbridge.msdk.thrid.okhttp.Route;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.http2.ConnectionShutdownException;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z4) {
        this.client = okHttpClient;
        this.forWebSocket = z4;
    }

    private Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private Request followUpRequest(Response response, Route route) throws IOException {
        String header;
        HttpUrl resolve;
        if (response != null) {
            int code = response.code();
            String method = response.request().method();
            RequestBody requestBody = null;
            if (code == 307 || code == 308) {
                if (!method.equals(ShareTarget.METHOD_GET) && !method.equals("HEAD")) {
                    return null;
                }
            } else if (code == 401) {
                return this.client.authenticator().authenticate(route, response);
            } else {
                if (code != 503) {
                    if (code != 407) {
                        if (code != 408) {
                            switch (code) {
                                case MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION:
                                case 301:
                                case 302:
                                case 303:
                                    break;
                                default:
                                    return null;
                            }
                        } else if (!this.client.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                            return null;
                        } else {
                            if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
                                return response.request();
                            }
                            return null;
                        }
                    } else if (route.proxy().type() == Proxy.Type.HTTP) {
                        return this.client.proxyAuthenticator().authenticate(route, response);
                    } else {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                } else if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                } else {
                    return null;
                }
            }
            if (!this.client.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
                return null;
            }
            if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
                return null;
            }
            Request.Builder newBuilder = response.request().newBuilder();
            if (HttpMethod.permitsRequestBody(method)) {
                boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
                if (HttpMethod.redirectsToGet(method)) {
                    newBuilder.method(ShareTarget.METHOD_GET, (RequestBody) null);
                } else {
                    if (redirectsWithBody) {
                        requestBody = response.request().body();
                    }
                    newBuilder.method(method, requestBody);
                }
                if (!redirectsWithBody) {
                    newBuilder.removeHeader("Transfer-Encoding");
                    newBuilder.removeHeader("Content-Length");
                    newBuilder.removeHeader("Content-Type");
                }
            }
            if (!sameConnection(response, resolve)) {
                newBuilder.removeHeader("Authorization");
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    private boolean isRecoverable(IOException iOException, boolean z4) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z4) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean recover(IOException iOException, StreamAllocation streamAllocation2, boolean z4, Request request) {
        streamAllocation2.streamFailed(iOException);
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z4 || !requestIsUnrepeatable(iOException, request)) && isRecoverable(iOException, z4) && streamAllocation2.hasMoreRoutes()) {
            return true;
        }
        return false;
    }

    private boolean requestIsUnrepeatable(IOException iOException, Request request) {
        if ((request.body() instanceof UnrepeatableRequestBody) || (iOException instanceof FileNotFoundException)) {
            return true;
        }
        return false;
    }

    private int retryAfter(Response response, int i5) {
        String header = response.header("Retry-After");
        if (header == null) {
            return i5;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        if (!url.host().equals(httpUrl.host()) || url.port() != httpUrl.port() || !url.scheme().equals(httpUrl.scheme())) {
            return false;
        }
        return true;
    }

    public void cancel() {
        this.canceled = true;
        StreamAllocation streamAllocation2 = this.streamAllocation;
        if (streamAllocation2 != null) {
            streamAllocation2.cancel();
        }
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation2 = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation2;
        StreamAllocation streamAllocation3 = streamAllocation2;
        int i5 = 0;
        Response response = null;
        Request request2 = request;
        while (!this.canceled) {
            try {
                Response proceed = realInterceptorChain.proceed(request2, streamAllocation3, (HttpCodec) null, (RealConnection) null);
                if (response != null) {
                    proceed = proceed.newBuilder().priorResponse(response.newBuilder().body((ResponseBody) null).build()).build();
                }
                try {
                    Request followUpRequest = followUpRequest(proceed, streamAllocation3.route());
                    if (followUpRequest == null) {
                        streamAllocation3.release();
                        return proceed;
                    }
                    Util.closeQuietly((Closeable) proceed.body());
                    int i6 = i5 + 1;
                    if (i6 > 20) {
                        streamAllocation3.release();
                        throw new ProtocolException("Too many follow-up requests: " + i6);
                    } else if (!(followUpRequest.body() instanceof UnrepeatableRequestBody)) {
                        if (!sameConnection(proceed, followUpRequest.url())) {
                            streamAllocation3.release();
                            StreamAllocation streamAllocation4 = new StreamAllocation(this.client.connectionPool(), createAddress(followUpRequest.url()), call, eventListener, this.callStackTrace);
                            this.streamAllocation = streamAllocation4;
                            streamAllocation3 = streamAllocation4;
                        } else if (streamAllocation3.codec() != null) {
                            throw new IllegalStateException("Closing the body of " + proceed + " didn't close its backing stream. Bad interceptor?");
                        }
                        response = proceed;
                        request2 = followUpRequest;
                        i5 = i6;
                    } else {
                        streamAllocation3.release();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                    }
                } catch (IOException e5) {
                    IOException iOException = e5;
                    streamAllocation3.release();
                    throw iOException;
                }
            } catch (RouteException e6) {
                if (!recover(e6.getLastConnectException(), streamAllocation3, false, request2)) {
                    throw e6.getFirstConnectException();
                }
            } catch (IOException e7) {
                if (!recover(e7, streamAllocation3, !(e7 instanceof ConnectionShutdownException), request2)) {
                    throw e7;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                streamAllocation3.streamFailed((IOException) null);
                streamAllocation3.release();
                throw th2;
            }
        }
        streamAllocation3.release();
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCallStackTrace(Object obj) {
        this.callStackTrace = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }
}
