package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.download.e;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class d {

    /* renamed from: c  reason: collision with root package name */
    private static d f13145c;

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<String> f13146a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentMap<String, Object> f13147b;

    /* renamed from: d  reason: collision with root package name */
    private g f13148d;

    /* renamed from: e  reason: collision with root package name */
    private e f13149e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13150f = false;

    /* renamed from: g  reason: collision with root package name */
    private final String f13151g = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;

    /* renamed from: h  reason: collision with root package name */
    private final String f13152h = "down_type";

    private d() {
        try {
            this.f13148d = g.a();
            this.f13149e = e.a.f13155a;
            this.f13146a = new CopyOnWriteArrayList<>();
            this.f13147b = new ConcurrentHashMap();
            g b5 = h.a().b(c.m().k());
            if (b5 != null) {
                this.f13150f = b5.z(1);
            }
        } catch (Throwable th) {
            af.b("H5DownLoadManager", th.getMessage(), th);
        }
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            try {
                if (f13145c == null) {
                    f13145c = new d();
                }
                dVar = f13145c;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return dVar;
    }

    public final String a(String str) {
        try {
            if (!Patterns.WEB_URL.matcher(str).matches()) {
                if (!URLUtil.isValidUrl(str)) {
                    return str;
                }
            }
            Uri parse = Uri.parse(str);
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                return str;
            }
            if (!TextUtils.isEmpty(parse.getQueryParameter("urlDebug"))) {
                return str;
            }
            if (path.toLowerCase().endsWith(".zip")) {
                g gVar = this.f13148d;
                if (gVar != null) {
                    return gVar.a(str);
                }
                return null;
            }
            e eVar = this.f13149e;
            return eVar != null ? eVar.a(str) : str;
        } catch (Exception e5) {
            e5.printStackTrace();
            return str;
        }
    }
}
