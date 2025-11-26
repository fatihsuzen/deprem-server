package com.mbridge.msdk.mbsignalcommon.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10162a = "a";

    public void a(Object obj, String str) {
    }

    public void b(Object obj, String str) {
    }

    public void c(Object obj, String str) {
    }

    public void d(Object obj, String str) {
    }

    public void e(Object obj, String str) {
    }

    public void f(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                g.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b);
            }
        } catch (Throwable th) {
            af.b(f10162a, "onSignalCommunication", th);
        }
    }

    public void g(Object obj, String str) {
    }

    public void h(Object obj, String str) {
    }

    public void i(Object obj, String str) {
    }

    public void j(Object obj, String str) {
    }

    public void k(Object obj, String str) {
    }

    public final void l(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                d.a(obj, new JSONObject(str));
            } catch (Throwable unused) {
            }
        }
    }

    public final void m(Object obj, String str) {
    }

    public final void n(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
        Context c5 = c.m().c();
        if (!TextUtils.isEmpty(str)) {
            if (c5 == null) {
                try {
                    if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                        c5 = windVaneWebView.getContext();
                    }
                } catch (Exception unused) {
                }
            }
            if (c5 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("url");
                    int optInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    if (optInt == 1) {
                        com.mbridge.msdk.click.c.d(c5, optString);
                    } else if (optInt == 2) {
                        com.mbridge.msdk.click.c.f(c5, optString);
                    }
                } catch (JSONException unused2) {
                }
            }
        }
    }

    public final void o(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
        Context c5 = c.m().c();
        if (!TextUtils.isEmpty(str)) {
            if (c5 == null) {
                try {
                    if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f10205b) != null) {
                        c5 = windVaneWebView.getContext();
                    }
                } catch (Exception unused) {
                }
            }
            if (c5 == null) {
                g.a().a(obj, d.a(1));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", ab.m(c5));
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    jSONObject2 = Base64.encodeToString(jSONObject2.getBytes(), 2);
                }
                g.a().a(obj, jSONObject2);
            } catch (Throwable unused2) {
                g.a().a(obj, d.a(1));
            }
        }
    }
}
