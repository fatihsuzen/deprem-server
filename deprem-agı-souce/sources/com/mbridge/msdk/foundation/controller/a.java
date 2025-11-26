package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.h;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8821a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, String> f8822b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    protected String f8823c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f8824d;

    /* renamed from: e  reason: collision with root package name */
    protected String f8825e;

    /* renamed from: f  reason: collision with root package name */
    private final h f8826f = new h();

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<Activity> f8827g;

    /* renamed from: h  reason: collision with root package name */
    private String f8828h;

    /* renamed from: i  reason: collision with root package name */
    private int f8829i;

    /* renamed from: j  reason: collision with root package name */
    private JSONObject f8830j = new JSONObject();

    /* renamed from: k  reason: collision with root package name */
    private boolean f8831k = false;

    /* renamed from: l  reason: collision with root package name */
    private String f8832l;

    /* renamed from: m  reason: collision with root package name */
    private String f8833m;

    /* renamed from: n  reason: collision with root package name */
    private int f8834n;

    /* renamed from: o  reason: collision with root package name */
    private ConcurrentHashMap<String, String> f8835o = new ConcurrentHashMap<>();

    /* renamed from: p  reason: collision with root package name */
    private WeakReference<Context> f8836p;

    /* renamed from: q  reason: collision with root package name */
    private JSONObject f8837q;

    /* renamed from: r  reason: collision with root package name */
    private int f8838r = 0;

    /* renamed from: s  reason: collision with root package name */
    private String f8839s;

    /* renamed from: com.mbridge.msdk.foundation.controller.a$a  reason: collision with other inner class name */
    public interface C0085a {
    }

    public final WeakReference<Activity> a() {
        return this.f8827g;
    }

    /* access modifiers changed from: protected */
    public abstract void a(C0085a aVar);

    public final String b() {
        if (!TextUtils.isEmpty(this.f8832l)) {
            return this.f8832l;
        }
        Context context = this.f8824d;
        if (context != null) {
            return (String) an.a(context, "sp_appKey", "");
        }
        return null;
    }

    public final Context c() {
        return this.f8824d;
    }

    public final h d() {
        return this.f8826f;
    }

    public final Context e() {
        WeakReference<Context> weakReference = this.f8836p;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final int f() {
        return this.f8829i;
    }

    public final String g() {
        try {
            if (!TextUtils.isEmpty(this.f8825e)) {
                return this.f8825e;
            }
            Context context = this.f8824d;
            if (context == null) {
                return null;
            }
            String packageName = context.getPackageName();
            this.f8825e = packageName;
            return packageName;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String h() {
        if (!TextUtils.isEmpty(this.f8833m)) {
            return this.f8833m;
        }
        Context context = this.f8824d;
        if (context != null) {
            return (String) an.a(context, "sp_wx_appKey", "");
        }
        return null;
    }

    public final JSONObject i() {
        return this.f8837q;
    }

    public final int j() {
        return this.f8838r;
    }

    public final String k() {
        try {
            if (!TextUtils.isEmpty(this.f8823c)) {
                return this.f8823c;
            }
            Context context = this.f8824d;
            if (context != null) {
                return (String) an.a(context, "sp_appId", "");
            }
            return "";
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final String l() {
        if (!TextUtils.isEmpty(this.f8839s)) {
            return this.f8839s;
        }
        try {
            String md5 = SameMD5.getMD5(c.m().k() + c.m().b());
            this.f8839s = md5;
            return md5;
        } catch (Exception unused) {
            return "";
        }
    }

    public final void a(WeakReference<Activity> weakReference) {
        this.f8827g = weakReference;
    }

    public final void c(int i5) {
        this.f8838r = i5;
    }

    public final void d(String str) {
        Context context;
        try {
            this.f8823c = str;
            if (!TextUtils.isEmpty(str) && (context = this.f8824d) != null) {
                an.b(context, "sp_appId", str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void e(String str) {
        Context context;
        try {
            this.f8832l = str;
            if (!TextUtils.isEmpty(str) && (context = this.f8824d) != null) {
                an.b(context, "sp_appKey", str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8825e = str;
        }
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            this.f8836p = new WeakReference<>(context);
        }
    }

    public final void c(String str) {
        Context context;
        try {
            this.f8828h = str;
            if (!TextUtils.isEmpty(str) && (context = this.f8824d) != null) {
                an.b(context, "applicationIds", str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(int i5) {
        this.f8829i = i5;
    }

    public final void b(int i5) {
        this.f8834n = i5;
    }

    public final void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f8833m = str;
                Context context = this.f8824d;
                if (context != null) {
                    an.b(context, "sp_wx_appKey", str);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void b(String str) {
        try {
            if (this.f8835o != null && !TextUtils.isEmpty(str)) {
                if (this.f8835o.containsKey(str)) {
                    this.f8835o.remove(str);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void b(Context context) {
        this.f8824d = context;
    }

    public final BitmapDrawable a(String str, int i5) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        int i6;
        int i7;
        String str2;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f8835o) == null || !concurrentHashMap.containsKey(str) || !ah.a().a("w_m_r_l", true)) {
            return null;
        }
        String str3 = this.f8835o.get(str);
        BitmapDrawable n5 = ak.n(str3);
        int i8 = TextUtils.isEmpty(str3) ? 2 : 1;
        String str4 = TextUtils.isEmpty(str3) ? "get watermark failed" : n5 != null ? "" : "str to bitmap failed";
        if (n5 == null) {
            i6 = 2;
            i7 = i5;
            str2 = str;
        } else {
            i6 = 1;
            str2 = str;
            i7 = i5;
        }
        i.a(str2, i7, i8, str4, i6, str3);
        return n5;
    }

    public final void a(JSONObject jSONObject) {
        this.f8837q = jSONObject;
    }

    public final void a(final C0085a aVar, final Handler handler) {
        if (!this.f8831k) {
            try {
                if (b.a() && c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    Object a5 = an.a(this.f8824d, MBridgeConstans.SP_GA_ID, "");
                    Object a6 = an.a(this.f8824d, MBridgeConstans.SP_GA_ID_LIMIT, 0);
                    if (a5 instanceof String) {
                        String str = (String) a5;
                        if (!TextUtils.isEmpty(str)) {
                            f.a(str);
                        } else {
                            f.c();
                        }
                        if (a6 instanceof Integer) {
                            f.a(((Integer) a6).intValue());
                        }
                    }
                }
            } catch (Exception e5) {
                af.b(f8821a, e5.getMessage());
            }
            try {
                JSONObject jSONObject = new JSONObject();
                this.f8837q = jSONObject;
                jSONObject.put("webgl", 0);
            } catch (JSONException e6) {
                af.b(f8821a, e6.getMessage());
            }
            new Thread(new Runnable() {
                public final void run() {
                    int i5;
                    try {
                        ab.p(a.this.f8824d);
                        a.this.a(aVar);
                        a aVar = a.this;
                        com.mbridge.msdk.c.h.a(aVar.f8824d, aVar.f8823c);
                    } catch (Exception e5) {
                        af.b(a.f8821a, e5.getMessage());
                    }
                    if (c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                        try {
                            if (a.this.f8824d.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                                i5 = 1;
                            } else {
                                i5 = 2;
                            }
                            ab.c(i5);
                        } catch (PackageManager.NameNotFoundException unused) {
                            ab.c(0);
                        } catch (Throwable th) {
                            af.b(a.f8821a, th.getMessage());
                        }
                    }
                    try {
                        g b5 = com.mbridge.msdk.c.h.a().b(c.m().k());
                        if (b5 == null) {
                            com.mbridge.msdk.c.h.a();
                            b5 = com.mbridge.msdk.c.i.a();
                        }
                        Message obtain = Message.obtain();
                        obtain.obj = b5;
                        obtain.what = 9;
                        handler.sendMessage(obtain);
                    } catch (Exception e6) {
                        af.b(a.f8821a, e6.getMessage());
                    }
                }
            }).start();
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        if (ah.a().a("w_m_r_l", true)) {
            try {
                if (this.f8830j == null) {
                    this.f8830j = jSONObject;
                } else if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.f8830j.put(next, jSONObject.get(next));
                    }
                }
                if (this.f8830j.has(MBridgeConstans.EXTRA_KEY_WM)) {
                    if (this.f8835o == null) {
                        this.f8835o = new ConcurrentHashMap<>();
                    }
                    this.f8835o.put(str, this.f8830j.getString(MBridgeConstans.EXTRA_KEY_WM));
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
