package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.mbsignalcommon.base.e;
import org.json.JSONObject;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f10227a = new g();

    private g() {
    }

    public static g a() {
        return f10227a;
    }

    public final void b(Object obj, String str) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(str)) {
                String.format("javascript:window.WindVane.onFailure(%s,'');", new Object[]{aVar.f10210g});
            } else {
                str = j.c(str);
            }
            String format = String.format("javascript:window.WindVane.onFailure(%s,'%s');", new Object[]{aVar.f10210g, str});
            WindVaneWebView windVaneWebView = aVar.f10205b;
            if (windVaneWebView != null && !windVaneWebView.isDestoryed()) {
                try {
                    aVar.f10205b.loadUrl(format);
                } catch (Exception e5) {
                    e5.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void a(Object obj, String str, String str2) {
        String str3;
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(str2)) {
                str3 = String.format("javascript:window.WindVane.fireEvent('%s', '');", new Object[]{str});
            } else {
                str3 = String.format("javascript:window.WindVane.fireEvent('%s','%s');", new Object[]{str, j.c(str2)});
            }
            WindVaneWebView windVaneWebView = aVar.f10205b;
            if (windVaneWebView != null && !windVaneWebView.isDestoryed()) {
                try {
                    aVar.f10205b.loadUrl(str3);
                } catch (Exception e5) {
                    e5.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void a(WebView webView, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = String.format("javascript:window.WindVane.fireEvent('%s', '');", new Object[]{str});
        } else {
            str3 = String.format("javascript:window.WindVane.fireEvent('%s','%s');", new Object[]{str, j.c(str2)});
        }
        if (webView == null) {
            return;
        }
        if (!(webView instanceof WindVaneWebView) || !((WindVaneWebView) webView).isDestoryed()) {
            try {
                webView.loadUrl(str3);
            } catch (Exception e5) {
                e5.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Object obj, String str) {
        String str2;
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(str)) {
                str2 = String.format("javascript:window.WindVane.onSuccess(%s,'');", new Object[]{aVar.f10210g});
            } else {
                str2 = String.format("javascript:window.WindVane.onSuccess(%s,'%s');", new Object[]{aVar.f10210g, j.c(str)});
            }
            WindVaneWebView windVaneWebView = aVar.f10205b;
            if (windVaneWebView != null && !windVaneWebView.isDestoryed()) {
                try {
                    aVar.f10205b.loadUrl(str2);
                } catch (Exception e5) {
                    e5.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void a(WebView webView) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("api_version", "1.0.0");
            f10227a.a(webView, e.f10103j, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception unused) {
            f10227a.a(webView, e.f10103j, "");
        } catch (Throwable unused2) {
            f10227a.a(webView, e.f10103j, "");
        }
    }
}
