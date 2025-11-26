package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.b.a;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.d.b;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.b.c;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import java.util.List;
import java.util.Map;

public class d {

    /* renamed from: c  reason: collision with root package name */
    private static volatile d f8858c;

    /* renamed from: a  reason: collision with root package name */
    public final int f8859a = 2;

    /* renamed from: b  reason: collision with root package name */
    Handler f8860b = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            List list;
            List list2;
            try {
                int i5 = message.what;
                if (i5 == 2) {
                    Object obj = message.obj;
                    if ((obj instanceof List) && (list = (List) obj) != null && list.size() > 0) {
                        h hVar = new h(d.this.f8868k, 0);
                        for (int i6 = 0; i6 < list.size(); i6++) {
                            l lVar = (l) list.get(i6);
                            Boolean bool = Boolean.FALSE;
                            if (i6 == list.size() - 1) {
                                bool = Boolean.TRUE;
                            }
                            hVar.a(lVar, bool);
                        }
                    }
                } else if (i5 == 7) {
                    Object obj2 = message.obj;
                    if (obj2 != null && (obj2 instanceof List) && (list2 = (List) obj2) != null) {
                        list2.size();
                    }
                } else if (i5 == 9) {
                    g gVar = (g) message.obj;
                    com.mbridge.msdk.foundation.tools.h d5 = c.m().d();
                    if (d5 != null && d5.b() && gVar != null && gVar.L() == 1) {
                        com.mbridge.msdk.foundation.same.report.b.d.a(d.this.f8868k).b();
                    }
                    if (d5 != null && d5.a()) {
                        c.a();
                    }
                }
            } catch (Exception unused) {
                af.b("SDKController", "REPORT HANDLE ERROR!");
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private int f8861d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Object> f8862e;

    /* renamed from: f  reason: collision with root package name */
    private FastKV f8863f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8864g = false;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f8865h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f8866i;

    /* renamed from: j  reason: collision with root package name */
    private String f8867j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Context f8868k;

    /* renamed from: l  reason: collision with root package name */
    private String f8869l;

    /* renamed from: m  reason: collision with root package name */
    private a f8870m;

    /* renamed from: n  reason: collision with root package name */
    private String f8871n;

    private d() {
    }

    public static d a() {
        if (f8858c == null) {
            synchronized (d.class) {
                try {
                    if (f8858c == null) {
                        f8858c = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8858c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045 A[Catch:{ Exception -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r3 = this;
            android.content.Context r0 = r3.f8868k
            if (r0 == 0) goto L_0x0061
            android.os.Handler r0 = r3.f8860b
            if (r0 != 0) goto L_0x0009
            goto L_0x0061
        L_0x0009:
            com.mbridge.msdk.foundation.tools.ah r0 = com.mbridge.msdk.foundation.tools.ah.a()     // Catch:{ Exception -> 0x0056 }
            java.lang.String r1 = "e_r_r_c_t_r_l"
            r2 = 0
            boolean r0 = r0.a((java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x0056 }
            if (r0 == 0) goto L_0x0018
            r0 = 5
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            com.mbridge.msdk.foundation.same.report.c.a.a()     // Catch:{ Exception -> 0x0056 }
            android.content.Context r1 = r3.f8868k     // Catch:{ Exception -> 0x0056 }
            if (r1 != 0) goto L_0x0021
            goto L_0x003c
        L_0x0021:
            com.mbridge.msdk.foundation.db.g r2 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r1)     // Catch:{ Exception -> 0x0056 }
            com.mbridge.msdk.foundation.db.l r2 = com.mbridge.msdk.foundation.db.l.a((com.mbridge.msdk.foundation.db.f) r2)     // Catch:{ Exception -> 0x0056 }
            int r2 = r2.a()     // Catch:{ Exception -> 0x0056 }
            if (r2 <= 0) goto L_0x003c
            com.mbridge.msdk.foundation.db.g r1 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r1)     // Catch:{ Exception -> 0x0056 }
            com.mbridge.msdk.foundation.db.l r1 = com.mbridge.msdk.foundation.db.l.a((com.mbridge.msdk.foundation.db.f) r1)     // Catch:{ Exception -> 0x0056 }
            java.util.List r0 = r1.a((int) r0)     // Catch:{ Exception -> 0x0056 }
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            if (r0 == 0) goto L_0x0061
            int r1 = r0.size()     // Catch:{ Exception -> 0x0056 }
            if (r1 <= 0) goto L_0x0061
            android.os.Handler r1 = r3.f8860b     // Catch:{ Exception -> 0x0056 }
            android.os.Message r1 = r1.obtainMessage()     // Catch:{ Exception -> 0x0056 }
            r2 = 2
            r1.what = r2     // Catch:{ Exception -> 0x0056 }
            r1.obj = r0     // Catch:{ Exception -> 0x0056 }
            android.os.Handler r0 = r3.f8860b     // Catch:{ Exception -> 0x0056 }
            r0.sendMessage(r1)     // Catch:{ Exception -> 0x0056 }
            return
        L_0x0056:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x0061
            java.lang.String r0 = "SDKController"
            java.lang.String r1 = "report netstate error !"
            com.mbridge.msdk.foundation.tools.af.b(r0, r1)
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.d.b():void");
    }

    public final void c() {
        Handler handler = this.f8860b;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void a(Map map, final Context context) {
        String str;
        Object obj;
        if (context != null) {
            if (!TextUtils.isEmpty(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE)) {
                c.m().f(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE);
            } else if (map.containsKey(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME) && (obj = map.get(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME)) != null) {
                String str2 = (String) obj;
                if (!TextUtils.isEmpty(str2)) {
                    c.m().f(str2);
                }
            }
            if (map != null) {
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                    this.f8865h = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPKEY)) {
                    this.f8866i = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPKEY);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_WX_APPID)) {
                    this.f8871n = (String) map.get(MBridgeConstans.ID_MBRIDGE_WX_APPID);
                }
                if (map.containsKey(MBridgeConstans.PACKAGE_NAME_MANIFEST)) {
                    this.f8867j = (String) map.get(MBridgeConstans.PACKAGE_NAME_MANIFEST);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH)) {
                    this.f8869l = (String) map.get(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH);
                }
            }
            this.f8868k = context.getApplicationContext();
            c.m().b(this.f8868k);
            c.m().d(this.f8865h);
            c.m().e(this.f8866i);
            c.m().a(this.f8871n);
            c.m().c(this.f8867j);
            c.m().a((a.C0085a) new a.C0085a() {
            }, this.f8860b);
            try {
                com.mbridge.msdk.foundation.same.net.e.d.f().e();
            } catch (Throwable th) {
                af.b("SDKController", th.getMessage());
            }
            if (!this.f8864g) {
                ai.a(this.f8868k);
                Context applicationContext = this.f8868k.getApplicationContext();
                try {
                    if (this.f8863f == null) {
                        this.f8863f = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), z.a("H+tU+FeXHM==")).build();
                    }
                } catch (Exception unused) {
                    this.f8863f = null;
                } catch (Throwable th2) {
                    af.b("SDKController", th2.getMessage(), th2);
                }
                FastKV fastKV = this.f8863f;
                String str3 = "";
                if (fastKV != null) {
                    String string = fastKV.getString(z.a("H+tU+bfPhM=="), str3);
                    String string2 = this.f8863f.getString(z.a("H+tU+Fz8"), str3);
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9179V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9188g)) {
                        com.mbridge.msdk.foundation.same.a.f9179V = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                        com.mbridge.msdk.foundation.same.a.f9188g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
                    }
                    if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                        com.mbridge.msdk.foundation.same.a.f9179V = string;
                        com.mbridge.msdk.foundation.same.a.f9188g = string2;
                        com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.f9179V);
                        com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f9188g);
                    } else if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9179V) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9188g)) {
                        this.f8863f.putString(z.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.f9179V);
                        this.f8863f.putString(z.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f9188g);
                    }
                } else {
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(z.a("H+tU+FeXHM=="), 0);
                    if (sharedPreferences != null) {
                        String string3 = sharedPreferences.getString(z.a("H+tU+bfPhM=="), str3);
                        String string4 = sharedPreferences.getString(z.a("H+tU+Fz8"), str3);
                        str3 = string3;
                        str = string4;
                    } else {
                        str = str3;
                    }
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9179V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9188g)) {
                        com.mbridge.msdk.foundation.same.a.f9179V = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                        com.mbridge.msdk.foundation.same.a.f9188g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
                    }
                    if (!TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str)) {
                        com.mbridge.msdk.foundation.same.a.f9179V = str3;
                        com.mbridge.msdk.foundation.same.a.f9188g = str;
                        com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.f9179V);
                        com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f9188g);
                    } else if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9179V) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9188g)) {
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(z.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.f9179V);
                            edit.putString(z.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f9188g);
                            edit.apply();
                        }
                    }
                }
                try {
                    com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                        public final void run() {
                            Looper.prepare();
                            d.a(d.this);
                            d.b(d.this);
                            Looper.loop();
                        }
                    });
                    com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                        public final void run() {
                            d dVar = d.this;
                            d.a(dVar, dVar.f8865h);
                            if (!TextUtils.isEmpty(d.this.f8865h)) {
                                com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.SDK_APP_ID, d.this.f8865h);
                            }
                            new h(d.this.f8868k).a();
                            d.this.b();
                        }
                    });
                    i.c();
                } catch (Exception unused2) {
                    af.b("SDKController", "get app setting failed");
                }
                this.f8864g = true;
                ab.g(context);
                long aA = (long) com.mbridge.msdk.c.h.a().a(this.f8865h).aA();
                if (aA != 1300) {
                    this.f8860b.postDelayed(new Runnable() {
                        public final void run() {
                            ab.e(context);
                        }
                    }, aA);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        r2 = com.mbridge.msdk.out.MBRewardVideoHandler.class;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.mbridge.msdk.foundation.controller.d r11) {
        /*
            com.mbridge.msdk.c.h r0 = com.mbridge.msdk.c.h.a()     // Catch:{ all -> 0x0094 }
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r1.k()     // Catch:{ all -> 0x0094 }
            com.mbridge.msdk.c.g r0 = r0.b(r1)     // Catch:{ all -> 0x0094 }
            if (r0 == 0) goto L_0x009c
            java.util.List r0 = r0.n()     // Catch:{ all -> 0x0094 }
            if (r0 == 0) goto L_0x009c
            int r1 = r0.size()     // Catch:{ all -> 0x0094 }
            if (r1 <= 0) goto L_0x009c
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0094 }
        L_0x0022:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x009c
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0094 }
            com.mbridge.msdk.foundation.entity.a r1 = (com.mbridge.msdk.foundation.entity.a) r1     // Catch:{ all -> 0x0094 }
            int r2 = r1.a()     // Catch:{ all -> 0x0094 }
            r3 = 287(0x11f, float:4.02E-43)
            r4 = 1
            r5 = 0
            r6 = 2
            java.lang.String r7 = "loadFormSelfFilling"
            java.lang.String r8 = ""
            r9 = 0
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            if (r2 != r3) goto L_0x0068
            java.lang.Class<com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler> r2 = com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler.class
            android.content.Context r3 = r11.f8868k     // Catch:{ all -> 0x0094 }
            if (r3 == 0) goto L_0x0022
            java.lang.Class[] r3 = new java.lang.Class[r6]     // Catch:{ all -> 0x0094 }
            r3[r5] = r10     // Catch:{ all -> 0x0094 }
            r3[r4] = r10     // Catch:{ all -> 0x0094 }
            java.lang.reflect.Constructor r3 = r2.getConstructor(r3)     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0094 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0094 }
            r6[r5] = r8     // Catch:{ all -> 0x0094 }
            r6[r4] = r1     // Catch:{ all -> 0x0094 }
            java.lang.Object r1 = r3.newInstance(r6)     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x0022
            java.lang.reflect.Method r2 = r2.getMethod(r7, r9)     // Catch:{ all -> 0x0094 }
            r2.invoke(r1, r9)     // Catch:{ all -> 0x0094 }
            goto L_0x0022
        L_0x0068:
            int r2 = r1.a()     // Catch:{ all -> 0x0094 }
            r3 = 94
            if (r2 != r3) goto L_0x0022
            java.lang.Class<com.mbridge.msdk.out.MBRewardVideoHandler> r2 = com.mbridge.msdk.out.MBRewardVideoHandler.class
            java.lang.Class[] r3 = new java.lang.Class[r6]     // Catch:{ all -> 0x0094 }
            r3[r5] = r10     // Catch:{ all -> 0x0094 }
            r3[r4] = r10     // Catch:{ all -> 0x0094 }
            java.lang.reflect.Constructor r3 = r2.getConstructor(r3)     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0094 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0094 }
            r6[r5] = r8     // Catch:{ all -> 0x0094 }
            r6[r4] = r1     // Catch:{ all -> 0x0094 }
            java.lang.Object r1 = r3.newInstance(r6)     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x0022
            java.lang.reflect.Method r2 = r2.getMethod(r7, r9)     // Catch:{ all -> 0x0094 }
            r2.invoke(r1, r9)     // Catch:{ all -> 0x0094 }
            goto L_0x0022
        L_0x0094:
            r11 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x009c
            r11.printStackTrace()
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.d.b(com.mbridge.msdk.foundation.controller.d):void");
    }

    public final void a(Map<String, Object> map, int i5) {
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() != MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            af.b("SDKController", "preloaad failed,sdk do not inited");
            return;
        }
        this.f8862e = map;
        this.f8861d = i5;
        c.m().k();
        if (map != null) {
            if (this.f8870m == null) {
                this.f8870m = new com.mbridge.msdk.b.a();
            }
            try {
                Map<String, Object> map2 = this.f8862e;
                if (map2 != null && map2.size() > 0 && this.f8862e.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)) {
                    int intValue = ((Integer) this.f8862e.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue();
                    if (intValue == 0) {
                        Map<String, Object> map3 = this.f8862e;
                        int i6 = this.f8861d;
                        try {
                            Class<?> cls = Class.forName("com.mbridge.msdk.mbnative.f.a");
                            Object newInstance = cls.newInstance();
                            cls.getMethod("preload", new Class[]{Map.class, Integer.TYPE}).invoke(newInstance, new Object[]{map3, Integer.valueOf(i6)});
                        } catch (Exception unused) {
                        }
                    } else if (1 != intValue && 2 != intValue) {
                        af.b("SDKController", "unknow layout type in preload");
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(d dVar) {
        Class<b> cls = b.class;
        try {
            cls.getDeclaredMethod("start", (Class[]) null).invoke(cls.getMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null), (Object[]) null);
        } catch (Throwable th) {
            af.b("SDKController", th.getMessage(), th);
        }
    }

    static /* synthetic */ void a(d dVar, final String str) {
        if (com.mbridge.msdk.c.h.a() != null) {
            com.mbridge.msdk.c.h a5 = com.mbridge.msdk.c.h.a();
            if (a5 != null) {
                g b5 = a5.b(str);
                if (b5 != null) {
                    MBridgeConstans.OMID_JS_SERVICE_URL = b5.X();
                    MBridgeConstans.OMID_JS_H5_URL = b5.W();
                    if (!TextUtils.isEmpty(b5.B())) {
                        com.mbridge.msdk.foundation.same.net.e.d.f().f9373h = b5.B();
                        com.mbridge.msdk.foundation.same.net.e.d.f().b();
                    }
                    if (!TextUtils.isEmpty(b5.C())) {
                        com.mbridge.msdk.foundation.same.net.e.d.f().f9377l = b5.C();
                        com.mbridge.msdk.foundation.same.net.e.d.f().c();
                    }
                } else {
                    MBridgeConstans.OMID_JS_SERVICE_URL = com.mbridge.msdk.c.a.b.f7878b;
                    MBridgeConstans.OMID_JS_H5_URL = com.mbridge.msdk.c.a.b.f7877a;
                }
            }
            if (com.mbridge.msdk.c.h.a().d(str) && com.mbridge.msdk.c.h.a().a(str, 1, (String) null)) {
                if (com.mbridge.msdk.foundation.a.a.a.a().a("is_first_init", 0) == 0) {
                    try {
                        com.mbridge.msdk.foundation.a.a.a.a().b("is_first_init", 1);
                        if (TextUtils.isEmpty(f.c())) {
                            dVar.f8860b.postDelayed(new Runnable() {
                                public final void run() {
                                    new j().b(d.this.f8868k, str, d.this.f8866i);
                                }
                            }, 350);
                        } else {
                            new j().b(dVar.f8868k, str, dVar.f8866i);
                        }
                    } catch (Throwable unused) {
                        new j().b(dVar.f8868k, str, dVar.f8866i);
                    }
                } else {
                    new j().b(dVar.f8868k, str, dVar.f8866i);
                }
            }
        }
    }
}
