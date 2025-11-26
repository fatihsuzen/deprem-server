package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.Interceptor;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpCodec;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.internal.http.RealResponseBody;
import com.mbridge.msdk.thrid.okhttp.internal.http.RequestLine;
import com.mbridge.msdk.thrid.okhttp.internal.http.StatusLine;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.ForwardingSource;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Sink;
import com.mbridge.msdk.thrid.okio.Source;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class Http2Codec implements HttpCodec {
    private static final String CONNECTION = "connection";
    private static final String ENCODING = "encoding";
    private static final String HOST = "host";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList((T[]) new String[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8});
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList((T[]) new String[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE});
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String UPGRADE = "upgrade";
    private final Interceptor.Chain chain;
    private final Http2Connection connection;
    private final Protocol protocol;
    private Http2Stream stream;
    final StreamAllocation streamAllocation;

    class StreamFinishingSource extends ForwardingSource {
        long bytesRead = 0;
        boolean completed = false;

        StreamFinishingSource(Source source) {
            super(source);
        }

        private void endOfInput(IOException iOException) {
            if (!this.completed) {
                this.completed = true;
                Http2Codec http2Codec = Http2Codec.this;
                http2Codec.streamAllocation.streamFinished(false, http2Codec, this.bytesRead, iOException);
            }
        }

        public void close() throws IOException {
            super.close();
            endOfInput((IOException) null);
        }

        public long read(Buffer buffer, long j5) throws IOException {
            try {
                long read = delegate().read(buffer, j5);
                if (read <= 0) {
                    return read;
                }
                this.bytesRead += read;
                return read;
            } catch (IOException e5) {
                endOfInput(e5);
                throw e5;
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain2, StreamAllocation streamAllocation2, Http2Connection http2Connection) {
        this.chain = chain2;
        this.streamAllocation = streamAllocation2;
        this.connection = http2Connection;
        List<Protocol> protocols = okHttpClient.protocols();
        Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = !protocols.contains(protocol2) ? Protocol.HTTP_2 : protocol2;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i5 = 0; i5 < size; i5++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i5).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8.utf8())) {
                arrayList.add(new Header(encodeUtf8, headers.value(i5)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(Headers headers, Protocol protocol2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        StatusLine statusLine = null;
        for (int i5 = 0; i5 < size; i5++) {
            String name = headers.name(i5);
            String value = headers.value(i5);
            if (name.equals(Header.RESPONSE_STATUS_UTF8)) {
                statusLine = StatusLine.parse("HTTP/1.1 " + value);
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                Internal.instance.addLenient(builder, name, value);
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(protocol2).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    public Sink createRequestBody(Request request, long j5) {
        return this.stream.getSink();
    }

    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public void flushRequest() throws IOException {
        this.connection.flush();
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation2 = this.streamAllocation;
        streamAllocation2.eventListener.responseBodyStart(streamAllocation2.call);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), Okio.buffer((Source) new StreamFinishingSource(this.stream.getSource())));
    }

    public Response.Builder readResponseHeaders(boolean z4) throws IOException {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeHeaders(), this.protocol);
        if (!z4 || Internal.instance.code(readHttp2HeadersList) != 100) {
            return readHttp2HeadersList;
        }
        return null;
    }

    public void writeRequestHeaders(Request request) throws IOException {
        boolean z4;
        if (this.stream == null) {
            if (request.body() != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Http2Stream newStream = this.connection.newStream(http2HeadersList(request), z4);
            this.stream = newStream;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            newStream.readTimeout().timeout((long) this.chain.readTimeoutMillis(), timeUnit);
            this.stream.writeTimeout().timeout((long) this.chain.writeTimeoutMillis(), timeUnit);
        }
    }
}
