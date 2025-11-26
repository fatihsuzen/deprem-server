package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class AabEntity implements NoProGuard, Serializable {
    private static final String TAG = "AabEntity";
    public int h3c;
    public int hlp;

    public static AabEntity parser(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AabEntity aabEntity = new AabEntity();
            if (jSONObject.has("hlp")) {
                aabEntity.setHlp(jSONObject.optInt("hlp"));
            }
            if (jSONObject.has("h3c")) {
                aabEntity.setH3c(jSONObject.optInt("h3c"));
            }
            return aabEntity;
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            return null;
        }
    }

    public int getH3c() {
        return this.h3c;
    }

    public int getHlp() {
        return this.hlp;
    }

    public void setH3c(int i5) {
        this.h3c = i5;
    }

    public void setHlp(int i5) {
        this.hlp = i5;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hlp", this.hlp);
            jSONObject.put("h3c", this.h3c);
            return jSONObject;
        } catch (JSONException e5) {
            af.b(TAG, e5.getMessage());
            return jSONObject;
        }
    }
}
