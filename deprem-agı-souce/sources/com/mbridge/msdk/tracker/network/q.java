package com.mbridge.msdk.tracker.network;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Connection;
import com.mbridge.msdk.thrid.okhttp.Handshake;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.Route;
import com.mbridge.msdk.thrid.okhttp.TlsVersion;
import com.mbridge.msdk.tracker.e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class q {

    /* renamed from: A  reason: collision with root package name */
    private volatile long f11609A;

    /* renamed from: B  reason: collision with root package name */
    private volatile long f11610B;

    /* renamed from: C  reason: collision with root package name */
    private volatile long f11611C;

    /* renamed from: D  reason: collision with root package name */
    private volatile long f11612D;

    /* renamed from: E  reason: collision with root package name */
    private volatile long f11613E;

    /* renamed from: F  reason: collision with root package name */
    private volatile long f11614F;

    /* renamed from: G  reason: collision with root package name */
    private volatile long f11615G;

    /* renamed from: H  reason: collision with root package name */
    private volatile List<InetAddress> f11616H;

    /* renamed from: I  reason: collision with root package name */
    private volatile InetSocketAddress f11617I;

    /* renamed from: J  reason: collision with root package name */
    private volatile Proxy f11618J;

    /* renamed from: K  reason: collision with root package name */
    private volatile Handshake f11619K;

    /* renamed from: L  reason: collision with root package name */
    private volatile Protocol f11620L;

    /* renamed from: M  reason: collision with root package name */
    private volatile IOException f11621M;

    /* renamed from: N  reason: collision with root package name */
    private volatile boolean f11622N = false;

    /* renamed from: O  reason: collision with root package name */
    private volatile Exception f11623O;

    /* renamed from: P  reason: collision with root package name */
    private volatile boolean f11624P = false;

    /* renamed from: Q  reason: collision with root package name */
    private long f11625Q;

    /* renamed from: R  reason: collision with root package name */
    private long f11626R;

    /* renamed from: S  reason: collision with root package name */
    private long f11627S;

    /* renamed from: T  reason: collision with root package name */
    private long f11628T;

    /* renamed from: a  reason: collision with root package name */
    protected volatile String f11629a = "";

    /* renamed from: b  reason: collision with root package name */
    private volatile String f11630b = "";

    /* renamed from: c  reason: collision with root package name */
    private volatile String f11631c = "";

    /* renamed from: d  reason: collision with root package name */
    private volatile String f11632d = "";

    /* renamed from: e  reason: collision with root package name */
    private volatile String f11633e = "";

    /* renamed from: f  reason: collision with root package name */
    private volatile long f11634f;

    /* renamed from: g  reason: collision with root package name */
    private volatile int f11635g = -1;

    /* renamed from: h  reason: collision with root package name */
    private volatile String f11636h = "";

    /* renamed from: i  reason: collision with root package name */
    private volatile int f11637i = -1;

    /* renamed from: j  reason: collision with root package name */
    private volatile String f11638j = "un_known";

    /* renamed from: k  reason: collision with root package name */
    private volatile String f11639k = "";

    /* renamed from: l  reason: collision with root package name */
    private volatile String f11640l = "okhttp";

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f11641m = false;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicInteger f11642n = new AtomicInteger(0);

    /* renamed from: o  reason: collision with root package name */
    private volatile String f11643o = "";

    /* renamed from: p  reason: collision with root package name */
    private volatile long f11644p = 0;

    /* renamed from: q  reason: collision with root package name */
    private volatile long f11645q = 0;

    /* renamed from: r  reason: collision with root package name */
    private volatile long f11646r = 0;

    /* renamed from: s  reason: collision with root package name */
    private volatile long f11647s;

    /* renamed from: t  reason: collision with root package name */
    private volatile long f11648t;

    /* renamed from: u  reason: collision with root package name */
    private volatile IOException f11649u;

    /* renamed from: v  reason: collision with root package name */
    private volatile long f11650v;

    /* renamed from: w  reason: collision with root package name */
    private volatile long f11651w;

    /* renamed from: x  reason: collision with root package name */
    private volatile long f11652x;

    /* renamed from: y  reason: collision with root package name */
    private volatile long f11653y;

    /* renamed from: z  reason: collision with root package name */
    private volatile long f11654z;

    public q(String str, String str2) {
        this.f11638j = str;
        this.f11639k = str2;
        this.f11632d = UUID.randomUUID().toString();
    }

    private String g() {
        return TextUtils.isEmpty(this.f11631c) ? "" : this.f11631c;
    }

    private String h() {
        return TextUtils.isEmpty(this.f11630b) ? "" : this.f11630b;
    }

    private String i() {
        return TextUtils.isEmpty(this.f11632d) ? "" : this.f11632d;
    }

    private String j() {
        return TextUtils.isEmpty(this.f11633e) ? "" : this.f11633e;
    }

    private String k() {
        try {
            if (TextUtils.isEmpty(this.f11629a)) {
                return "";
            }
            return URLEncoder.encode(this.f11629a, C.UTF8_NAME);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private String l() {
        if (TextUtils.isEmpty(this.f11638j)) {
            return "un_known";
        }
        return this.f11638j;
    }

    private String m() {
        if (TextUtils.isEmpty(this.f11639k)) {
            return "";
        }
        return this.f11639k;
    }

    private int n() {
        return this.f11642n.getAndAdd(0);
    }

    private String o() {
        if (this.f11616H == null || this.f11616H.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        while (i5 < this.f11616H.size()) {
            try {
                InetAddress inetAddress = this.f11616H.get(i5);
                if (inetAddress != null) {
                    sb.append(inetAddress.getHostAddress());
                    if (i5 != this.f11616H.size() - 1) {
                        sb.append(",");
                    }
                }
                i5++;
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "getDnsResult ", e5);
                }
            }
        }
        return sb.toString();
    }

    private String p() {
        if (this.f11617I != null) {
            try {
                InetAddress address = this.f11617I.getAddress();
                if (address == null) {
                    return "";
                }
                String hostAddress = address.getHostAddress();
                if (TextUtils.isEmpty(hostAddress)) {
                    return "";
                }
                return hostAddress;
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "getAddress ", e5);
                }
            }
        }
        return "";
    }

    private String q() {
        if (this.f11619K != null) {
            try {
                TlsVersion tlsVersion = this.f11619K.tlsVersion();
                if (tlsVersion == null) {
                    return "";
                }
                return tlsVersion.javaName();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "getTlsVersion ", e5);
                }
            }
        }
        return "";
    }

    private String r() {
        try {
            if (this.f11621M != null) {
                String name = this.f11621M.getClass().getName();
                String message = this.f11621M.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    return a("connection: %s ", name, message);
                }
            }
            if (this.f11649u != null) {
                String name2 = this.f11649u.getClass().getName();
                String message2 = this.f11649u.getMessage();
                if (!TextUtils.isEmpty(message2)) {
                    return a("call: %s ", name2, message2);
                }
            }
            if (this.f11623O == null) {
                return "un_known";
            }
            String name3 = this.f11623O.getClass().getName();
            String message3 = this.f11623O.getMessage();
            if (!TextUtils.isEmpty(message3)) {
                return a("error: %s ", name3, message3);
            }
            return "un_known";
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return "un_known";
            }
            af.b("NetworkMonitor", "getError ", e5);
            return "un_known";
        }
    }

    public final void a(String str) {
        this.f11629a = str;
    }

    public final void b(long j5) {
        this.f11626R = j5;
    }

    public final void c(long j5) {
        this.f11627S = j5;
    }

    public final void d(long j5) {
        this.f11628T = j5;
    }

    public final void e(long j5) {
        this.f11611C = SystemClock.elapsedRealtime();
    }

    public final void f(long j5) {
        this.f11646r = j5;
    }

    public final void a(long j5) {
        this.f11625Q = j5;
    }

    public final void b(String str) {
        this.f11631c = str;
    }

    public final void c(String str) {
        this.f11630b = str;
    }

    public final void d(String str) {
        this.f11636h = str;
    }

    public final void e() {
        this.f11614F = SystemClock.elapsedRealtime();
    }

    public final long f() {
        return this.f11646r;
    }

    public final void g(long j5) {
        this.f11615G = SystemClock.elapsedRealtime();
    }

    public final void h(long j5) {
        this.f11645q = j5;
    }

    public final void i(long j5) {
        this.f11644p = j5;
    }

    public final void j(long j5) {
        this.f11633e = UUID.randomUUID().toString();
        this.f11634f = j5;
        this.f11642n.addAndGet(1);
        this.f11621M = null;
        this.f11649u = null;
        this.f11623O = null;
        this.f11647s = 0;
        this.f11648t = 0;
        this.f11650v = 0;
        this.f11651w = 0;
        this.f11652x = 0;
        this.f11653y = 0;
        this.f11654z = 0;
        this.f11609A = 0;
        this.f11610B = 0;
        this.f11611C = 0;
        this.f11612D = 0;
        this.f11613E = 0;
        this.f11614F = 0;
        this.f11615G = 0;
        this.f11645q = 0;
        this.f11646r = 0;
        this.f11641m = false;
        this.f11635g = -1;
        this.f11637i = -1;
        this.f11636h = "";
        this.f11643o = "";
        this.f11644p = 0;
        this.f11624P = false;
        this.f11624P = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "m_request_start");
            jSONObject.put("uuid", i());
            jSONObject.put("request_uuid", j());
            jSONObject.put("lrid", h());
            jSONObject.put("url", k());
            jSONObject.put("timeout", this.f11625Q);
            jSONObject.put("timeout_connection", this.f11626R);
            jSONObject.put("timeout_read", this.f11627S);
            jSONObject.put("timeout_write", this.f11628T);
            jSONObject.put("scene", l());
            jSONObject.put("method", m());
            jSONObject.put("adtp", g());
            jSONObject.put("http_stack", this.f11640l);
            jSONObject.put("retry_count", n() - 1);
            jSONObject.put("request_wait_duration", this.f11634f);
            e a5 = a(jSONObject, "m_request_start");
            if (MBridgeConstans.DEBUG) {
                af.a("NetworkMonitor_" + l(), "request start monitor = " + jSONObject.toString());
            }
            d.a().c().a(a5);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                af.b("NetworkMonitor", "reportRequestStart ", th);
            }
        }
    }

    public final void a(int i5) {
        this.f11637i = i5;
    }

    public final void b() {
        this.f11654z = SystemClock.elapsedRealtime();
    }

    public final void c() {
        this.f11610B = SystemClock.elapsedRealtime();
    }

    public final void d() {
        this.f11612D = SystemClock.elapsedRealtime();
    }

    public final void a(Call call) {
        this.f11647s = SystemClock.elapsedRealtime();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0104 A[Catch:{ all -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012a A[Catch:{ all -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x019d A[Catch:{ all -> 0x00dd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r9) {
        /*
            r8 = this;
            java.lang.String r0 = "m_request_end"
            r8.f11635g = r9
            boolean r9 = r8.f11624P
            if (r9 != 0) goto L_0x000a
            goto L_0x01e1
        L_0x000a:
            r9 = 0
            r8.f11624P = r9
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x00dd }
            r9.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "key"
            r9.put(r1, r0)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "uuid"
            java.lang.String r2 = r8.i()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_uuid"
            java.lang.String r2 = r8.j()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "url"
            java.lang.String r2 = r8.k()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "timeout"
            long r2 = r8.f11625Q     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "timeout_connection"
            long r2 = r8.f11626R     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "timeout_read"
            long r2 = r8.f11627S     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "timeout_write"
            long r2 = r8.f11628T     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "scene"
            java.lang.String r2 = r8.l()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "lrid"
            java.lang.String r2 = r8.h()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "method"
            java.lang.String r2 = r8.m()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "adtp"
            java.lang.String r2 = r8.g()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "http_stack"
            java.lang.String r2 = r8.f11640l     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "retry_count"
            int r2 = r8.n()     // Catch:{ all -> 0x00dd }
            r3 = 1
            int r2 = r2 - r3
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_wait_duration"
            long r4 = r8.f11634f     // Catch:{ all -> 0x00dd }
            r9.put(r1, r4)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "duration"
            long r4 = r8.f11648t     // Catch:{ all -> 0x00dd }
            long r6 = r8.f11647s     // Catch:{ all -> 0x00dd }
            long r4 = r4 - r6
            long r6 = r8.f11634f     // Catch:{ all -> 0x00dd }
            long r4 = r4 + r6
            r9.put(r1, r4)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_duration"
            long r4 = r8.f11648t     // Catch:{ all -> 0x00dd }
            long r6 = r8.f11647s     // Catch:{ all -> 0x00dd }
            long r4 = r4 - r6
            r9.put(r1, r4)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "response_code"
            int r2 = r8.f11637i     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = r8.o()     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = "dns_result"
            r9.put(r2, r1)     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = "dns_status"
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00dd }
            if (r1 == 0) goto L_0x00bc
            r1 = 2
            goto L_0x00bd
        L_0x00bc:
            r1 = r3
        L_0x00bd:
            r9.put(r2, r1)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "is_connection_acquired"
            boolean r2 = r8.f11641m     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "address"
            java.lang.String r2 = r8.p()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "port"
            java.net.InetSocketAddress r2 = r8.f11617I     // Catch:{ all -> 0x00dd }
            if (r2 == 0) goto L_0x00e0
            java.net.InetSocketAddress r2 = r8.f11617I     // Catch:{ all -> 0x00dd }
            int r2 = r2.getPort()     // Catch:{ all -> 0x00dd }
            goto L_0x00e1
        L_0x00dd:
            r9 = move-exception
            goto L_0x01d6
        L_0x00e0:
            r2 = -1
        L_0x00e1:
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "proxy"
            java.net.Proxy r2 = r8.f11618J     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x00fa
            java.net.Proxy r2 = r8.f11618J     // Catch:{ all -> 0x00dd }
            java.net.Proxy$Type r2 = r2.type()     // Catch:{ all -> 0x00dd }
            if (r2 != 0) goto L_0x00f5
            goto L_0x00fa
        L_0x00f5:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00dd }
            goto L_0x00fb
        L_0x00fa:
            r2 = r4
        L_0x00fb:
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "protocol"
            com.mbridge.msdk.thrid.okhttp.Protocol r2 = r8.f11620L     // Catch:{ all -> 0x00dd }
            if (r2 == 0) goto L_0x010a
            com.mbridge.msdk.thrid.okhttp.Protocol r2 = r8.f11620L     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x00dd }
        L_0x010a:
            r9.put(r1, r4)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "tls_version"
            java.lang.String r2 = r8.q()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "content_type"
            java.lang.String r2 = r8.f11643o     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.d.a((java.lang.String) r2)     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            int r1 = r8.f11635g     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = "result"
            r9.put(r2, r1)     // Catch:{ all -> 0x00dd }
            if (r1 == r3) goto L_0x013a
            java.lang.String r1 = "error_type"
            java.lang.String r2 = r8.f11636h     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "reason"
            java.lang.String r2 = r8.r()     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
        L_0x013a:
            java.lang.String r1 = "dns_duration"
            long r2 = r8.f11651w     // Catch:{ all -> 0x00dd }
            long r4 = r8.f11650v     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "connect_duration"
            long r2 = r8.f11653y     // Catch:{ all -> 0x00dd }
            long r4 = r8.f11652x     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_header_duration"
            long r2 = r8.f11609A     // Catch:{ all -> 0x00dd }
            long r4 = r8.f11654z     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_body_duration"
            long r2 = r8.f11611C     // Catch:{ all -> 0x00dd }
            long r4 = r8.f11610B     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "request_body_size"
            long r2 = r8.f11644p     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "response_header_duration"
            long r2 = r8.f11613E     // Catch:{ all -> 0x00dd }
            long r4 = r8.f11612D     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "response_body_duration"
            long r2 = r8.f11615G     // Catch:{ all -> 0x00dd }
            long r4 = r8.f11614F     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "response_body_size"
            long r2 = r8.f11645q     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "transmission_duration"
            long r2 = r8.f11612D     // Catch:{ all -> 0x00dd }
            long r4 = r8.f11654z     // Catch:{ all -> 0x00dd }
            long r2 = r2 - r4
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "current_response_body_size"
            long r2 = r8.f11646r     // Catch:{ all -> 0x00dd }
            r9.put(r1, r2)     // Catch:{ all -> 0x00dd }
            com.mbridge.msdk.tracker.e r0 = a((org.json.JSONObject) r9, (java.lang.String) r0)     // Catch:{ all -> 0x00dd }
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x00dd }
            if (r1 == 0) goto L_0x01ca
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r1.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = "NetworkMonitor_"
            r1.append(r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = r8.l()     // Catch:{ all -> 0x00dd }
            r1.append(r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r2.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.String r3 = "request  end  monitor = "
            r2.append(r3)     // Catch:{ all -> 0x00dd }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00dd }
            r2.append(r9)     // Catch:{ all -> 0x00dd }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x00dd }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r9)     // Catch:{ all -> 0x00dd }
        L_0x01ca:
            com.mbridge.msdk.foundation.same.report.d.d r9 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ all -> 0x00dd }
            com.mbridge.msdk.tracker.m r9 = r9.c()     // Catch:{ all -> 0x00dd }
            r9.a((com.mbridge.msdk.tracker.e) r0)     // Catch:{ all -> 0x00dd }
            return
        L_0x01d6:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x01e1
            java.lang.String r0 = "NetworkMonitor"
            java.lang.String r1 = "reportRequestEnd "
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)
        L_0x01e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.network.q.b(int):void");
    }

    public final void a() {
        this.f11650v = SystemClock.elapsedRealtime();
    }

    public final void a(List<InetAddress> list) {
        this.f11651w = SystemClock.elapsedRealtime();
        this.f11616H = list;
    }

    public final void a(InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.f11652x = SystemClock.elapsedRealtime();
        this.f11617I = inetSocketAddress;
        this.f11618J = proxy;
        this.f11622N = true;
    }

    public final void a(Handshake handshake) {
        this.f11619K = handshake;
    }

    public final void a(Protocol protocol, IOException iOException) {
        this.f11653y = SystemClock.elapsedRealtime();
        this.f11620L = protocol;
        this.f11621M = iOException;
    }

    public final void a(Connection connection) {
        this.f11641m = !this.f11622N;
        if (this.f11641m && connection != null) {
            try {
                this.f11620L = connection.protocol();
                Route route = connection.route();
                if (route != null) {
                    this.f11617I = route.socketAddress();
                    this.f11618J = route.proxy();
                }
                this.f11619K = connection.handshake();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "connectionAcquired ", e5);
                }
            }
        }
    }

    public final void a(Request request) {
        this.f11609A = SystemClock.elapsedRealtime();
    }

    public final void a(Response response) {
        this.f11613E = SystemClock.elapsedRealtime();
        if (response != null) {
            try {
                Headers headers = response.headers();
                if (headers != null) {
                    String str = headers.get("Content-Type");
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    this.f11643o = str;
                }
            } catch (Exception e5) {
                this.f11643o = EnvironmentCompat.MEDIA_UNKNOWN;
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "responseHeadersEnd ", e5);
                }
            }
        }
    }

    public final void a(IOException iOException) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f11648t = elapsedRealtime;
        this.f11649u = iOException;
        if (iOException != null) {
            if (this.f11650v == 0) {
                this.f11650v = elapsedRealtime;
            }
            if (this.f11651w == 0) {
                this.f11651w = elapsedRealtime;
            }
            if (this.f11652x == 0) {
                this.f11652x = elapsedRealtime;
            }
            if (this.f11653y == 0) {
                this.f11653y = elapsedRealtime;
            }
            if (this.f11654z == 0) {
                this.f11654z = elapsedRealtime;
            }
            if (this.f11609A == 0) {
                this.f11609A = elapsedRealtime;
            }
            if (this.f11610B == 0) {
                this.f11610B = elapsedRealtime;
            }
            if (this.f11611C == 0) {
                this.f11611C = elapsedRealtime;
            }
            if (this.f11612D == 0) {
                this.f11612D = elapsedRealtime;
            }
            if (this.f11613E == 0) {
                this.f11613E = elapsedRealtime;
            }
            if (this.f11614F == 0) {
                this.f11614F = elapsedRealtime;
            }
            if (this.f11615G == 0) {
                this.f11615G = elapsedRealtime;
            }
        }
    }

    private static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str2)) {
            str2 = "IOException";
        }
        sb.append(String.format(str, new Object[]{str2}));
        sb.append(TextUtils.isEmpty(str3) ? "" : str3.replaceAll("[\\n\\r]", " "));
        return sb.toString();
    }

    public final void a(Exception exc) {
        this.f11623O = exc;
    }

    private static e a(JSONObject jSONObject, String str) {
        e eVar = new e(str);
        eVar.b(0);
        eVar.a(0);
        eVar.a(c.c());
        eVar.a(jSONObject);
        return eVar;
    }
}
