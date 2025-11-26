package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.a;
import com.mbridge.msdk.tracker.e;
import com.mbridge.msdk.tracker.i;
import com.mbridge.msdk.tracker.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class d implements com.mbridge.msdk.tracker.d {
    public final Map<String, String> a(m mVar, List<i> list, JSONObject jSONObject) {
        HashMap hashMap;
        if (!(list == null || list.size() == 0)) {
            try {
                c.a(jSONObject);
                if (jSONObject == null) {
                    hashMap = null;
                } else {
                    hashMap = new HashMap();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, String.valueOf(jSONObject.opt(next)));
                    }
                }
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                StringBuilder a5 = a(list);
                hashMap.put("tun", String.valueOf(ab.r()));
                hashMap.put(DataSchemeDataSource.SCHEME_DATA, a5.toString());
                return hashMap;
            } catch (Exception unused) {
            } catch (OutOfMemoryError unused2) {
                if (mVar != null) {
                    mVar.i();
                }
            } catch (Throwable unused3) {
                return null;
            }
        }
        return null;
    }

    private static StringBuilder a(List<i> list) {
        e c5;
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < list.size(); i5++) {
            i iVar = list.get(i5);
            if (!(iVar == null || (c5 = iVar.c()) == null)) {
                JSONObject d5 = c5.d();
                c.a(d5);
                if (d5 == null) {
                    d5 = new JSONObject();
                }
                try {
                    d5.put(CampaignEx.JSON_KEY_ST_TS, c5.f());
                    d5.put("rts", System.currentTimeMillis());
                    int d6 = iVar.d() - 1;
                    if (d6 >= 1) {
                        d5.put("retryed", d6);
                    }
                    long g5 = c5.g();
                    if (g5 > 0) {
                        d5.put(TypedValues.TransitionType.S_DURATION, g5);
                    }
                } catch (Exception e5) {
                    if (a.f11490a) {
                        Log.e("TrackManager", "decorateRequestParams: ", e5);
                    }
                } catch (Throwable th) {
                    sb.append(a(d5));
                    throw th;
                }
                sb.append(a(d5));
                if (i5 < list.size() - 1) {
                    sb.append("\n");
                }
            }
        }
        return sb;
    }

    private static String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> keys = jSONObject.keys();
        int i5 = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            i5++;
            if (i5 <= jSONObject.length() - 1) {
                sb.append(next);
                sb.append("=");
                sb.append(a(String.valueOf(jSONObject.opt(next))));
                sb.append("&");
            } else {
                sb.append(next);
                sb.append("=");
                sb.append(a(String.valueOf(jSONObject.opt(next))));
            }
        }
        return sb.toString();
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
