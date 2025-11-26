package com.mbridge.msdk.mbsignalcommon.mraid;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.mraid.a;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f10170a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<String> f10171b = new ArrayList<>();

    public static a a(WindVaneWebView windVaneWebView, String str) {
        Set<String> set;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains(CampaignEx.JSON_KEY_MRAID)) {
            return null;
        }
        a aVar = new a();
        aVar.f10207d = z.a("n+ztLkxpVTzBLkxgHN==");
        aVar.f10208e = parse.getHost();
        int i5 = 0;
        if (f10171b.size() == 0) {
            for (Method name : b.class.getDeclaredMethods()) {
                f10171b.add(name.getName());
            }
        }
        if (f10171b.contains(aVar.f10208e) || windVaneWebView == null) {
            String encodedQuery = parse.getEncodedQuery();
            if (encodedQuery == null) {
                set = Collections.EMPTY_SET;
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                do {
                    int indexOf = encodedQuery.indexOf(38, i5);
                    if (indexOf == -1) {
                        indexOf = encodedQuery.length();
                    }
                    int indexOf2 = encodedQuery.indexOf(61, i5);
                    if (indexOf2 > indexOf || indexOf2 == -1) {
                        indexOf2 = indexOf;
                    }
                    linkedHashSet.add(Uri.decode(encodedQuery.substring(i5, indexOf2)));
                    i5 = indexOf + 1;
                } while (i5 < encodedQuery.length());
                set = DesugarCollections.unmodifiableSet(linkedHashSet);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                for (String str2 : set) {
                    jSONObject.put(str2, parse.getQueryParameter(str2));
                }
                aVar.f10209f = jSONObject.toString();
                return aVar;
            } catch (Exception e5) {
                e5.printStackTrace();
                return aVar;
            }
        } else {
            String campaignId = windVaneWebView.getCampaignId();
            String str3 = aVar.f10208e;
            if (!TextUtils.isEmpty(campaignId)) {
                if (f10170a.containsKey(campaignId)) {
                    String str4 = f10170a.get(campaignId);
                    if (!TextUtils.isEmpty(str3) && !str4.contains(str3)) {
                        if (str4.length() > 0) {
                            str4 = str4.concat(",");
                        }
                        f10170a.put(campaignId, str4.concat(str3));
                    }
                } else {
                    f10170a.put(campaignId, str3);
                }
            }
            a.C0096a.f10169a.a((WebView) windVaneWebView, aVar.f10208e);
            a.C0096a.f10169a.a((WebView) windVaneWebView, aVar.f10208e, "Specified command is not implemented");
            return null;
        }
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f10170a.remove(str);
        }
    }

    public static String a(String str) {
        if (f10170a.containsKey(str)) {
            return f10170a.get(str);
        }
        return null;
    }
}
