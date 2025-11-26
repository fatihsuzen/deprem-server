package com.mbridge.msdk.tracker.network;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.tracker.network.ae;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.toolbox.e;
import com.mbridge.msdk.tracker.network.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class u<T> implements Comparable<u<T>> {

    /* renamed from: a  reason: collision with root package name */
    private c f11680a;

    /* renamed from: b  reason: collision with root package name */
    private String f11681b;

    /* renamed from: c  reason: collision with root package name */
    private volatile q f11682c;

    /* renamed from: d  reason: collision with root package name */
    private long f11683d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f11684e;

    /* renamed from: f  reason: collision with root package name */
    private final ae.a f11685f;

    /* renamed from: g  reason: collision with root package name */
    private int f11686g;

    /* renamed from: h  reason: collision with root package name */
    private final String f11687h;

    /* renamed from: i  reason: collision with root package name */
    private final int f11688i;

    /* renamed from: j  reason: collision with root package name */
    private final String f11689j;

    /* renamed from: k  reason: collision with root package name */
    private final int f11690k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f11691l;

    /* renamed from: m  reason: collision with root package name */
    private w.a f11692m;

    /* renamed from: n  reason: collision with root package name */
    private Integer f11693n;

    /* renamed from: o  reason: collision with root package name */
    private v f11694o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f11695p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f11696q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f11697r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f11698s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f11699t;

    /* renamed from: u  reason: collision with root package name */
    private z f11700u;

    /* renamed from: v  reason: collision with root package name */
    private b.a f11701v;

    /* renamed from: w  reason: collision with root package name */
    private a f11702w;

    /* renamed from: x  reason: collision with root package name */
    private long f11703x;

    interface a {
        void a(u<?> uVar);

        void a(u<?> uVar, w<?> wVar);
    }

    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public u(int i5, String str) {
        this(i5, str, 0);
    }

    /* access modifiers changed from: protected */
    public abstract w<T> a(r rVar);

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t5);

    /* access modifiers changed from: package-private */
    public final void b(int i5) {
        v vVar = this.f11694o;
        if (vVar != null) {
            vVar.a(this, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(String str) {
        v vVar = this.f11694o;
        if (vVar != null) {
            vVar.b(this);
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        u uVar = (u) obj;
        b e5 = e();
        b e6 = uVar.e();
        if (e5 == e6) {
            return this.f11693n.intValue() - uVar.f11693n.intValue();
        }
        return e6.ordinal() - e5.ordinal();
    }

    public boolean d() {
        return false;
    }

    public b e() {
        return b.NORMAL;
    }

    public final String f() {
        return this.f11689j;
    }

    public final long g() {
        return SystemClock.elapsedRealtime() - this.f11683d;
    }

    public final int h() {
        return this.f11688i;
    }

    public final int i() {
        return this.f11686g;
    }

    public final int j() {
        return this.f11690k;
    }

    public final String k() {
        return this.f11687h;
    }

    public final String l() {
        if (!TextUtils.isEmpty(this.f11681b)) {
            return this.f11681b;
        }
        if (this.f11680a == null) {
            this.f11680a = new e();
        }
        String a5 = this.f11680a.a(this);
        this.f11681b = a5;
        return a5;
    }

    public final b.a m() {
        return this.f11701v;
    }

    public final boolean n() {
        boolean z4;
        synchronized (this.f11691l) {
            z4 = this.f11696q;
        }
        return z4;
    }

    public final String o() {
        return "application/x-www-form-urlencoded; charset=" + C.UTF8_NAME;
    }

    public final byte[] p() {
        Map<String, String> a5 = a();
        if (a5 == null || a5.size() <= 0) {
            this.f11703x = 0;
            return null;
        }
        byte[] a6 = a(a5, C.UTF8_NAME);
        this.f11703x = (long) a6.length;
        return a6;
    }

    public final long q() {
        return this.f11703x;
    }

    public final boolean r() {
        return this.f11695p;
    }

    public final boolean s() {
        return this.f11698s;
    }

    public final boolean t() {
        return this.f11699t;
    }

    public String toString() {
        String str;
        String str2 = "0x" + Integer.toHexString(this.f11690k);
        StringBuilder sb = new StringBuilder();
        if (n()) {
            str = "[X] ";
        } else {
            str = "[ ] ";
        }
        sb.append(str);
        sb.append(this.f11687h);
        sb.append(" ");
        sb.append(str2);
        sb.append(" ");
        sb.append(e());
        sb.append(" ");
        sb.append(this.f11693n);
        return sb.toString();
    }

    public final int u() {
        z b5 = b();
        if (b5 == null) {
            return 30000;
        }
        return b5.a();
    }

    public final long v() {
        z b5 = b();
        if (b5 == null) {
            return WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        }
        long b6 = b5.b();
        if (b6 < 0) {
            return WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        }
        return b6;
    }

    public final void w() {
        synchronized (this.f11691l) {
            this.f11697r = true;
        }
    }

    public final boolean x() {
        boolean z4;
        synchronized (this.f11691l) {
            z4 = this.f11697r;
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    public final void y() {
        a aVar;
        synchronized (this.f11691l) {
            aVar = this.f11702w;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final q z() {
        return this.f11682c;
    }

    public u(int i5, String str, int i6) {
        this(i5, str, i6, "un_known");
    }

    public final void a(w.a aVar) {
        this.f11692m = aVar;
    }

    public final u<?> d(boolean z4) {
        this.f11699t = z4;
        return this;
    }

    public u(int i5, String str, int i6, String str2) {
        Uri parse;
        String host;
        this.f11685f = null;
        this.f11691l = new Object();
        int i7 = 0;
        this.f11695p = false;
        this.f11696q = false;
        this.f11697r = false;
        this.f11698s = false;
        this.f11699t = false;
        this.f11701v = null;
        this.f11703x = 0;
        this.f11686g = i5;
        this.f11687h = str;
        this.f11688i = i6;
        this.f11689j = str2;
        this.f11700u = new e();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i7 = host.hashCode();
        }
        this.f11690k = i7;
        this.f11683d = SystemClock.elapsedRealtime();
    }

    public final void a(int i5) {
        this.f11686g = i5;
    }

    public final u<?> b(boolean z4) {
        this.f11695p = z4;
        return this;
    }

    public final u<?> c(int i5) {
        this.f11693n = Integer.valueOf(i5);
        return this;
    }

    public final String d(String str) {
        if (this.f11684e != null && !TextUtils.isEmpty(str)) {
            try {
                return this.f11684e.get(str);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final u<?> a(v vVar) {
        this.f11694o = vVar;
        return this;
    }

    public z b() {
        return this.f11700u;
    }

    public Map<String, String> c() {
        return Collections.EMPTY_MAP;
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            int i5 = 0;
            for (Map.Entry next : map.entrySet()) {
                i5++;
                if (next.getKey() != null) {
                    sb.append(URLEncoder.encode((String) next.getKey(), str));
                    sb.append('=');
                    sb.append(URLEncoder.encode(next.getValue() == null ? "" : (String) next.getValue(), str));
                    if (i5 <= map.size() - 1) {
                        sb.append('&');
                    }
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException("Encoding not supported: " + str, e5);
        }
    }

    public final void b(ad adVar) {
        w.a aVar;
        synchronized (this.f11691l) {
            aVar = this.f11692m;
        }
        if (aVar != null) {
            aVar.a(adVar);
        }
    }

    public final u<?> c(boolean z4) {
        this.f11698s = z4;
        return this;
    }

    public final void c(String str, String str2) {
        if (this.f11684e == null) {
            this.f11684e = new HashMap();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.f11684e.put(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(w<?> wVar) {
        a aVar;
        synchronized (this.f11691l) {
            aVar = this.f11702w;
        }
        if (aVar != null) {
            aVar.a(this, wVar);
        }
    }

    public final void a(q qVar) {
        this.f11682c = qVar;
    }
}
