package com.mbridge.msdk.tracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import org.json.JSONObject;

public class t {

    /* renamed from: d  reason: collision with root package name */
    private static volatile t f11745d;

    /* renamed from: a  reason: collision with root package name */
    Handler f11746a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                try {
                    t.this.c();
                    t.this.f11746a.removeMessages(1);
                    t.this.d();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private m f11747b;

    /* renamed from: c  reason: collision with root package name */
    private w f11748c;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f11749e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f11750f = 30000;

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, String> f11751g = new HashMap<>();

    private t() {
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            this.f11746a.sendEmptyMessageDelayed(1, (long) this.f11750f);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final synchronized void b() {
        if (!this.f11749e) {
            this.f11749e = true;
            d();
        }
    }

    public final void c() {
        m[] d5 = m.d();
        if (d5.length != 0) {
            try {
                for (m mVar : d5) {
                    String c5 = mVar.c();
                    if (!"monitor".equals(c5)) {
                        String b5 = mVar.b();
                        long[] h5 = mVar.h();
                        long j5 = h5[1];
                        if (j5 != 0) {
                            long j6 = h5[0];
                            if (this.f11751g.containsKey(c5)) {
                                if ((j6 + "").equals(this.f11751g.get(c5))) {
                                }
                            }
                            this.f11751g.put(c5, j6 + "");
                            if (this.f11747b != null) {
                                try {
                                    e eVar = new e("event_lib_monitor");
                                    eVar.b(1);
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("key", "m_report_rate");
                                    jSONObject.put("task_name", c5);
                                    jSONObject.put("task_count", j5);
                                    jSONObject.put("task_session_id", b5);
                                    jSONObject.put("task_ts", j6);
                                    eVar.a(jSONObject);
                                    this.f11747b.a(eVar);
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public final void a(Context context, w wVar, int i5, JSONObject jSONObject) {
        this.f11748c = wVar;
        this.f11750f = i5;
        m a5 = m.a("monitor", context, wVar);
        this.f11747b = a5;
        if (a5 != null) {
            a5.a(jSONObject);
            this.f11747b.a();
        }
        b();
    }

    public static t a() {
        if (f11745d == null) {
            synchronized (t.class) {
                try {
                    if (f11745d == null) {
                        f11745d = new t();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11745d;
    }
}
