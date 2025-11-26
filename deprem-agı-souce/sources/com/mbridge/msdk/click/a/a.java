package com.mbridge.msdk.click.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.tools.aq;
import j$.util.concurrent.ConcurrentHashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f8063a = "mtg_retry_report=1";

    /* renamed from: b  reason: collision with root package name */
    public static int f8064b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static int f8065c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f8066d = 50;

    /* renamed from: e  reason: collision with root package name */
    public static int f8067e = 600000;

    /* renamed from: f  reason: collision with root package name */
    public static int f8068f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f8069g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static int f8070h = 2;

    /* renamed from: i  reason: collision with root package name */
    public static int f8071i = 3;

    /* renamed from: j  reason: collision with root package name */
    public static int f8072j = 4;

    /* renamed from: k  reason: collision with root package name */
    public static int f8073k = 5;

    /* renamed from: l  reason: collision with root package name */
    private static String f8074l = "RetryReportControl";

    /* renamed from: o  reason: collision with root package name */
    private static int f8075o;

    /* renamed from: p  reason: collision with root package name */
    private static int f8076p;

    /* renamed from: m  reason: collision with root package name */
    private ConcurrentHashMap<String, b> f8077m;

    /* renamed from: n  reason: collision with root package name */
    private c f8078n;

    /* renamed from: q  reason: collision with root package name */
    private BroadcastReceiver f8079q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final Handler f8080r;

    /* renamed from: com.mbridge.msdk.click.a.a$a  reason: collision with other inner class name */
    private static class C0080a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static a f8082a = new a();
    }

    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(@NonNull Message message) {
            int i5 = message.what;
            if (i5 == 1) {
                Object obj = message.obj;
                if (obj instanceof String) {
                    a.a().a((String) obj, b.f8083a);
                }
            } else if (i5 == 2) {
                a.a(a.a());
            }
        }
    }

    private a() {
        this.f8077m = new ConcurrentHashMap<>();
        this.f8078n = new c(f8066d);
        this.f8080r = new b(Looper.getMainLooper());
        g a5 = h.a().a(c.m().k());
        f8065c = a5.ag();
        f8064b = a5.ai() * 1000;
        f8067e = a5.aj() * 1000;
        f8075o = a5.af();
        f8076p = a5.ah();
        try {
            if (this.f8079q == null) {
                this.f8079q = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            a.this.f8080r.sendEmptyMessage(2);
                        }
                    }
                };
                Context c5 = c.m().c();
                if (c5 != null) {
                    c5.registerReceiver(this.f8079q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public static a a() {
        return C0080a.f8082a;
    }

    private boolean b(int i5) {
        return i5 == f8069g || i5 == f8070h;
    }

    private void a(b bVar) {
        String str;
        String str2;
        try {
            CampaignEx f5 = bVar.f();
            if (f5 != null) {
                String requestId = f5.getRequestId();
                str = f5.getRequestIdNotice();
                str2 = requestId;
            } else {
                str2 = "";
                str = str2;
            }
            a(c.m().c(), bVar.i().toString(), bVar.g(), str2, str, bVar.d());
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private static void a(Context context, String str, String str2, String str3, String str4, int i5) {
        f.a().a(context, str, str2, str3, str4, i5);
    }

    private void a(String str) {
        Message obtainMessage = this.f8080r.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str;
        this.f8080r.sendMessageDelayed(obtainMessage, (long) f8064b);
    }

    /* access modifiers changed from: private */
    public void a(String str, int i5) {
        String str2;
        c cVar = this.f8078n;
        if (cVar != null) {
            b a5 = cVar.a(str);
            this.f8078n.b(str);
            if (a5 == null) {
                b bVar = this.f8077m.get(str);
                if (bVar != null && System.currentTimeMillis() <= bVar.j() + ((long) f8067e) && bVar.h() < f8065c && i5 != b.f8084b) {
                    a(str);
                }
            } else if (System.currentTimeMillis() <= a5.j() + ((long) f8067e)) {
                a5.a(i5);
                this.f8077m.put(str, a5);
                if (aq.c(str) == 0) {
                    str2 = str + "?" + f8063a;
                } else {
                    str2 = str + "&" + f8063a;
                }
                com.mbridge.msdk.click.a.a(c.m().c(), a5.f(), a5.e(), str2, a5.a(), a5.b(), a5.d());
            } else if (i5 != b.f8084b) {
                a(a5);
            }
        }
    }

    private boolean a(int i5) {
        return i5 == f8072j || i5 == f8071i;
    }

    public final void a(String str, String str2, CampaignEx campaignEx, String str3, boolean z4, boolean z5, int i5) {
        if ((a(i5) || b(i5) || i5 == f8073k) && !TextUtils.isEmpty(str)) {
            String replace = str.replace("?" + f8063a, "");
            String replace2 = replace.replace("&" + f8063a, "");
            if (this.f8077m == null) {
                this.f8077m = new ConcurrentHashMap<>();
            }
            b remove = this.f8077m.remove(replace2);
            if (remove == null) {
                remove = new b(str, str2);
                remove.b(i5);
                remove.a(z4);
                remove.b(z5);
                remove.a(campaignEx);
                remove.a(str3);
            } else if (remove.c() != b.f8084b) {
                remove.b(str2);
            }
            if ((!a(i5) || f8075o == 0) && ((!b(i5) || f8076p == 0) && i5 != f8073k)) {
                a(remove);
            } else if (System.currentTimeMillis() < remove.j() + ((long) f8067e)) {
                if (this.f8078n == null) {
                    this.f8078n = new c(f8066d);
                }
                this.f8078n.a(replace2, remove);
                if (remove.c() != b.f8083a) {
                    return;
                }
                if (remove.h() <= f8065c) {
                    a(replace2);
                } else {
                    a(remove);
                }
            } else if (remove.c() == b.f8083a) {
                a(remove);
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        c cVar = aVar.f8078n;
        if (cVar != null) {
            for (String a5 : cVar.a()) {
                aVar.a(a5, b.f8084b);
            }
        }
    }
}
