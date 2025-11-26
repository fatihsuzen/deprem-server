package com.mbridge.msdk.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.tracker.w;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

class k {

    /* renamed from: a  reason: collision with root package name */
    private static x f11528a = null;

    /* renamed from: o  reason: collision with root package name */
    private static volatile String f11529o = "";

    /* renamed from: b  reason: collision with root package name */
    private final String f11530b;

    /* renamed from: c  reason: collision with root package name */
    private final m f11531c;

    /* renamed from: d  reason: collision with root package name */
    private Context f11532d;

    /* renamed from: e  reason: collision with root package name */
    private w f11533e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f11534f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f11535g;

    /* renamed from: h  reason: collision with root package name */
    private List<String> f11536h;

    /* renamed from: i  reason: collision with root package name */
    private volatile c f11537i;

    /* renamed from: j  reason: collision with root package name */
    private volatile l f11538j;

    /* renamed from: k  reason: collision with root package name */
    private volatile d f11539k;

    /* renamed from: l  reason: collision with root package name */
    private volatile j f11540l;

    /* renamed from: m  reason: collision with root package name */
    private volatile r f11541m;

    /* renamed from: n  reason: collision with root package name */
    private volatile boolean f11542n = true;

    /* renamed from: p  reason: collision with root package name */
    private volatile n f11543p;

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f11544q;

    k(String str, m mVar) {
        this.f11530b = str;
        this.f11531c = mVar;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        if (!y.a((Object) this.f11532d) && !y.a((Object) this.f11533e)) {
            try {
                o().a();
                this.f11542n = false;
                this.f11544q = false;
                if (TextUtils.isEmpty(f11529o)) {
                    f11529o = UUID.randomUUID().toString();
                }
                if (!y.a((Object) f11528a)) {
                    try {
                        f11528a.a(b(), this.f11530b, this.f11531c);
                        t.a().b();
                    } catch (Exception e5) {
                        if (a.f11490a) {
                            Log.e("TrackManager", "track manager start exception", e5);
                        }
                    }
                }
                return f11529o;
            } catch (Exception e6) {
                if (a.f11490a) {
                    Log.e("TrackManager", "start error", e6);
                }
                this.f11542n = true;
            }
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        if (!TextUtils.isEmpty(f11529o)) {
            return f11529o;
        }
        String uuid = UUID.randomUUID().toString();
        f11529o = uuid;
        return uuid;
    }

    /* access modifiers changed from: package-private */
    public final String c() {
        return this.f11530b;
    }

    /* access modifiers changed from: package-private */
    public final w d() {
        w wVar = this.f11533e;
        if (wVar != null) {
            return wVar;
        }
        w a5 = new w.a().a();
        this.f11533e = a5;
        return a5;
    }

    /* access modifiers changed from: package-private */
    public final Context e() {
        return this.f11532d;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject f() {
        JSONObject jSONObject = this.f11534f;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f11534f = jSONObject2;
        return jSONObject2;
    }

    /* access modifiers changed from: package-private */
    public final c g() {
        String str;
        if (y.a((Object) this.f11537i)) {
            synchronized (k.class) {
                try {
                    if (y.a((Object) this.f11537i)) {
                        Context context = this.f11532d;
                        if (TextUtils.isEmpty(this.f11530b)) {
                            str = String.format("track_manager_%s.db", new Object[]{MRAIDCommunicatorUtil.STATES_DEFAULT});
                        } else {
                            str = String.format("track_manager_%s.db", new Object[]{this.f11530b});
                        }
                        this.f11537i = new c(new b(context, str, "event_table"), "event_table");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f11537i;
    }

    /* access modifiers changed from: package-private */
    public final l h() {
        if (y.a((Object) this.f11538j)) {
            synchronized (k.class) {
                try {
                    if (y.a((Object) this.f11538j)) {
                        this.f11538j = new p(new g(g(), o(), i()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f11538j;
    }

    /* access modifiers changed from: package-private */
    public final j i() {
        if (y.a((Object) this.f11540l)) {
            synchronized (k.class) {
                try {
                    if (y.a((Object) this.f11540l)) {
                        this.f11540l = new j();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f11540l;
    }

    /* access modifiers changed from: package-private */
    public final d j() {
        if (y.a((Object) this.f11539k)) {
            this.f11539k = d().f11765h;
        }
        return this.f11539k;
    }

    /* access modifiers changed from: package-private */
    public final m k() {
        return this.f11531c;
    }

    /* access modifiers changed from: package-private */
    public final int l() {
        if (d().f11758a < 0) {
            return 50;
        }
        return d().f11758a;
    }

    /* access modifiers changed from: package-private */
    public final int m() {
        return Math.max(d().f11759b, 0);
    }

    /* access modifiers changed from: package-private */
    public final int n() {
        return Math.max(d().f11762e, 0);
    }

    /* access modifiers changed from: package-private */
    public final r o() {
        if (y.a((Object) this.f11541m)) {
            synchronized (k.class) {
                try {
                    if (y.a((Object) this.f11541m)) {
                        this.f11541m = new r(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f11541m;
    }

    /* access modifiers changed from: package-private */
    public final boolean p() throws IllegalStateException {
        if (y.a((Object) d())) {
            throw new IllegalStateException("config can not be null");
        } else if (y.a((Object) j())) {
            throw new IllegalStateException("decorate can not be null");
        } else if (y.a((Object) d().f11766i)) {
            throw new IllegalStateException("responseHandler can not be null");
        } else if (y.a((Object) d().f11764g) || y.a((Object) d().f11764g.c())) {
            throw new IllegalStateException("networkStackConfig or stack can not be null");
        } else if (!TextUtils.isEmpty(d().f11764g.b())) {
            return true;
        } else {
            throw new IllegalStateException("report url is null");
        }
    }

    /* access modifiers changed from: package-private */
    public final n q() {
        int i5;
        if (y.a((Object) this.f11543p)) {
            synchronized (k.class) {
                try {
                    if (y.a((Object) this.f11543p)) {
                        if (d().f11761d <= 0) {
                            i5 = 2;
                        } else {
                            i5 = d().f11761d;
                        }
                        this.f11543p = new n(i5, d().f11764g, d().f11766i, d().f11760c);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f11543p;
    }

    /* access modifiers changed from: package-private */
    public final boolean r() {
        return this.f11542n;
    }

    public final void s() {
        this.f11544q = true;
    }

    public final boolean t() {
        return !this.f11544q;
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context) {
        this.f11532d = context;
    }

    /* access modifiers changed from: package-private */
    public final void a(w wVar) {
        this.f11533e = wVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject) {
        this.f11534f = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(e eVar) {
        if (y.a((Object) eVar)) {
            return false;
        }
        f fVar = d().f11767j;
        if (y.b((Object) fVar)) {
            try {
                return fVar.a(eVar);
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "event filter apply exception", e5);
                }
            }
        }
        String a5 = eVar.a();
        if (TextUtils.isEmpty(a5)) {
            return false;
        }
        List<String> list = this.f11536h;
        if (list != null) {
            try {
                return !list.contains(a5);
            } catch (Exception e6) {
                if (a.f11490a) {
                    Log.e("TrackManager", "disallowTrackEventNames contains exception", e6);
                }
            }
        }
        List<String> list2 = this.f11535g;
        if (list2 != null) {
            try {
                return list2.contains(a5);
            } catch (Exception e7) {
                if (a.f11490a) {
                    Log.e("TrackManager", "allowTrackEventNames contains exception", e7);
                }
            }
        }
        return true;
    }
}
