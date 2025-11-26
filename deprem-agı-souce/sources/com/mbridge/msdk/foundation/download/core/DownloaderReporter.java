package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class DownloaderReporter {
    private static final String KEY = "key=";
    private static final String TAG = "DownloaderReporter";
    private final Map<String, String> _params;
    private final String _reportKey;

    public static class Builder {
        /* access modifiers changed from: private */
        public final Map<String, String> _params;
        /* access modifiers changed from: private */
        public final String _reportKey;

        public Builder(String str) {
            if (!TextUtils.isEmpty(str)) {
                this._reportKey = str;
                this._params = new HashMap();
                return;
            }
            throw new IllegalArgumentException("reportKey can not be empty");
        }

        public Builder add(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    this._params.put(str, str2);
                } catch (Exception unused) {
                }
            }
            return this;
        }

        public DownloaderReporter build() {
            return new DownloaderReporter(this);
        }
    }

    private void addUrlParams(Map<String, String> map, JSONObject jSONObject) {
        if (map != null && !map.isEmpty() && jSONObject != null) {
            try {
                for (String next : map.keySet()) {
                    jSONObject.put(next, encodeValue(map.get(next)));
                }
            } catch (Exception e5) {
                af.b(TAG, e5.getMessage());
            }
        }
    }

    private String encodeValue(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public final void report() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY, this._reportKey);
            addUrlParams(this._params, jSONObject);
            d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    private DownloaderReporter(Builder builder) {
        this._reportKey = builder._reportKey;
        this._params = builder._params;
    }
}
