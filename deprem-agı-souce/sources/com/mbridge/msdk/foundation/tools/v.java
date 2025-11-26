package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.broadcast.NetWorkChangeReceiver;
import org.json.JSONObject;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    IntentFilter f9744a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f9745b;

    /* renamed from: c  reason: collision with root package name */
    private j f9746c;

    /* renamed from: d  reason: collision with root package name */
    private long f9747d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f9748e;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final v f9749a = new v();
    }

    public static v a() {
        return a.f9749a;
    }

    public final String b() {
        long j5;
        try {
            if (this.f9745b == null) {
                this.f9745b = new JSONObject();
            }
            if (this.f9745b.length() < 2) {
                try {
                    this.f9745b.put("KEY_INFO", (String) c.a(c.m().c(), "KEY_INFO", ""));
                } catch (Exception e5) {
                    af.b("NetAddressManager", e5.getMessage());
                }
                try {
                    this.f9745b.put("KEY_TIME", ((Long) c.a(c.m().c(), "KEY_TIME", 0L)).longValue());
                } catch (Exception e6) {
                    af.b("NetAddressManager", e6.getMessage());
                }
            }
            String optString = this.f9745b.optString("KEY_INFO");
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            g a5 = h.a().a(c.m().k());
            if (a5 != null) {
                j5 = a5.c();
            } else {
                j5 = 3600;
            }
            if (System.currentTimeMillis() - this.f9745b.optLong("KEY_TIME") > j5 * 1000) {
                return "";
            }
            return optString;
        } catch (Exception e7) {
            af.b("NetAddressManager", e7.getMessage());
            return "";
        }
    }

    public final void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f9747d > 3000) {
            if (this.f9746c == null) {
                this.f9746c = new j();
            }
            this.f9746c.a(c.m().c(), c.m().k(), c.m().b());
            this.f9747d = currentTimeMillis;
        }
    }

    public final void d() {
        Context c5;
        try {
            if (h.a().a(c.m().k()).a() == 1 && (c5 = c.m().c()) != null) {
                IntentFilter intentFilter = new IntentFilter();
                this.f9744a = intentFilter;
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                c5.registerReceiver(this.f9748e, this.f9744a);
            }
        } catch (Exception e5) {
            af.b("NetAddressManager", e5.getMessage());
        }
    }

    public final void e() {
        Context c5 = c.m().c();
        if (c5 != null) {
            try {
                c5.unregisterReceiver(this.f9748e);
            } catch (Exception e5) {
                af.b("NetAddressManager", e5.getMessage());
            }
        }
    }

    private v() {
        this.f9745b = new JSONObject();
        this.f9748e = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        this.f9744a = intentFilter;
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public final void a(String str) {
        if (this.f9745b == null) {
            this.f9745b = new JSONObject();
        }
        try {
            if (!this.f9745b.optString("KEY_INFO", "").equals(str)) {
                this.f9745b.put("KEY_INFO", str);
                c.b(c.m().c(), "KEY_INFO", str);
            }
        } catch (Exception e5) {
            af.b("NetAddressManager", e5.getMessage());
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f9745b.put("KEY_TIME", currentTimeMillis);
                c.b(c.m().c(), "KEY_TIME", Long.valueOf(currentTimeMillis));
            }
        } catch (Exception e6) {
            af.b("NetAddressManager", e6.getMessage());
        }
    }
}
