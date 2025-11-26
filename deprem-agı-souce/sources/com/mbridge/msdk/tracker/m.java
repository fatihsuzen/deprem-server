package com.mbridge.msdk.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class m {

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap<String, m> f11545b = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k f11546a;

    private m(String str, Context context, w wVar) {
        k kVar = new k(str, this);
        this.f11546a = kVar;
        kVar.a(context);
        kVar.a(wVar);
    }

    public static m[] d() {
        ConcurrentHashMap<String, m> concurrentHashMap = f11545b;
        m[] mVarArr = new m[concurrentHashMap.size()];
        try {
            int i5 = 0;
            for (Map.Entry<String, m> value : concurrentHashMap.entrySet()) {
                mVarArr[i5] = (m) value.getValue();
                i5++;
            }
        } catch (Exception e5) {
            if (a.f11490a) {
                Log.e("TrackManager", "getAllTrackManager error", e5);
            }
        }
        return mVarArr;
    }

    public final String b() {
        return this.f11546a.b();
    }

    public final String c() {
        return this.f11546a.c();
    }

    public final boolean e() {
        return !this.f11546a.r();
    }

    public final void f() {
        try {
            this.f11546a.i().a(new Runnable() {
                public final void run() {
                    try {
                        t.a().c();
                        m.this.f11546a.o().b();
                    } catch (Exception e5) {
                        if (a.f11490a) {
                            Log.e("TrackManager", "flush error", e5);
                        }
                    }
                }
            });
        } catch (Exception e5) {
            if (a.f11490a) {
                Log.e("TrackManager", "flush error", e5);
            }
        }
    }

    public final JSONObject g() {
        return this.f11546a.f();
    }

    public final long[] h() {
        return this.f11546a.h().a();
    }

    public final void i() {
        this.f11546a.s();
    }

    private boolean b(e eVar) {
        try {
            return c(eVar);
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean c(e eVar) {
        if (y.a((Object) eVar) || TextUtils.isEmpty(eVar.a())) {
            return false;
        }
        return this.f11546a.a(eVar);
    }

    public static m a(String str, Context context, w wVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, m> concurrentHashMap = f11545b;
        m mVar = concurrentHashMap.get(str);
        if (!y.a((Object) mVar)) {
            return mVar;
        }
        m mVar2 = new m(str, context, wVar);
        concurrentHashMap.put(str, mVar2);
        return mVar2;
    }

    public final String a() {
        if (!e()) {
            return this.f11546a.a();
        }
        if (a.f11490a) {
            Log.e("TrackManager", "MBridgeTrackManager is already running");
        }
        return this.f11546a.b();
    }

    public final void a(JSONObject jSONObject) {
        this.f11546a.a(jSONObject);
    }

    public final boolean a(String str) {
        return b(new e(str));
    }

    public final void a(final e eVar) {
        if (!this.f11546a.r()) {
            try {
                this.f11546a.i().a(new Runnable() {
                    public final void run() {
                        if (m.this.c(eVar)) {
                            m.this.f11546a.h().a(eVar);
                            eVar.c((long) m.this.f11546a.d().f11763f);
                            JSONObject d5 = eVar.d();
                            if (d5 != null) {
                                try {
                                    d5.put("session_id", m.this.b());
                                    long[] h5 = m.this.h();
                                    d5.put("track_time", h5[0]);
                                    d5.put("track_count", h5[1]);
                                } catch (JSONException e5) {
                                    e5.printStackTrace();
                                }
                                eVar.a(d5);
                            }
                            m.this.f11546a.h().b(eVar);
                        }
                    }
                });
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "trackEvent error", e5);
                }
            }
        } else if (a.f11490a) {
            Log.d("TrackManager", "SDK is shutdown, track event will not be processed");
        }
    }
}
