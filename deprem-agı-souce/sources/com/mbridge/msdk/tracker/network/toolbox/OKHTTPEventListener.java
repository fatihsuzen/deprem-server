package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.system.NoProGuard;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Connection;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Handshake;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.tracker.network.q;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

public class OKHTTPEventListener extends EventListener implements NoProGuard {
    private static String TAG = "OKHTTPEventListener";
    private final q monitor;

    public OKHTTPEventListener(q qVar) {
        this.monitor = qVar;
    }

    public void callEnd(Call call) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.a((IOException) null);
        }
    }

    public void callFailed(Call call, IOException iOException) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.a(iOException);
        }
    }

    public void callStart(Call call) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.a(call);
        }
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("connection_end");
            this.monitor.a(protocol, (IOException) null);
        }
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.a(protocol, iOException);
        }
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("connection_start");
            this.monitor.a(inetSocketAddress, proxy);
        }
    }

    public void connectionAcquired(Call call, Connection connection) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.a(connection);
        }
    }

    public void connectionReleased(Call call, Connection connection) {
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("dns_end");
            this.monitor.a(list);
        }
    }

    public void dnsStart(Call call, String str) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("dns_start");
            this.monitor.a();
        }
    }

    public void requestBodyEnd(Call call, long j5) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("request_body_end");
            this.monitor.e(j5);
            this.monitor.d("transmission_start");
        }
    }

    public void requestBodyStart(Call call) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("request_body_start");
            this.monitor.c();
        }
    }

    public void requestHeadersEnd(Call call, Request request) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("request_header_end");
            this.monitor.a(request);
        }
    }

    public void requestHeadersStart(Call call) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("request_header_start");
            this.monitor.b();
        }
    }

    public void responseBodyEnd(Call call, long j5) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("response_body_end");
            this.monitor.h(j5);
            this.monitor.g(j5);
        }
    }

    public void responseBodyStart(Call call) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("response_body_start");
            this.monitor.e();
        }
    }

    public void responseHeadersEnd(Call call, Response response) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("response_header_end");
            this.monitor.a(response);
        }
    }

    public void responseHeadersStart(Call call) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("response_header_start");
            this.monitor.d();
            this.monitor.d("transmission_end");
        }
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("secure_connect_end");
            this.monitor.a(handshake);
        }
    }

    public void secureConnectStart(Call call) {
        q qVar = this.monitor;
        if (qVar != null) {
            qVar.d("secure_connect_start");
        }
    }
}
