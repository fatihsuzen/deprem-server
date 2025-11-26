package com.mbridge.msdk.out.reveue;

import com.mbridge.msdk.foundation.tools.ak;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import org.json.JSONObject;

public class MBridgeRevenueParamsEntity {
    public static final String ATTRIBUTION_PLATFORM_ADBRIX = "Adbrix";
    public static final String ATTRIBUTION_PLATFORM_ADJUST = "Adjust";
    public static final String ATTRIBUTION_PLATFORM_AIRVRIDGE = "Airbridge";
    public static final String ATTRIBUTION_PLATFORM_APPSFLYER = "AppsFlyer";
    public static final String ATTRIBUTION_PLATFORM_APP_METRICA = "AppMetrica";
    public static final String ATTRIBUTION_PLATFORM_APSALAR = "Apsalar";
    public static final String ATTRIBUTION_PLATFORM_BRANCH = "Branch";
    public static final String ATTRIBUTION_PLATFORM_DATA_EYE = "DataEye";
    public static final String ATTRIBUTION_PLATFORM_FOX = "Fox";
    public static final String ATTRIBUTION_PLATFORM_JUST_TRACK = "JustTrack";
    public static final String ATTRIBUTION_PLATFORM_KOCHAVA = "Kochava";
    public static final String ATTRIBUTION_PLATFORM_MY_TRACKER = "MyTracker";
    public static final String ATTRIBUTION_PLATFORM_REYUN = "Reyun";
    public static final String ATTRIBUTION_PLATFORM_SINGULAR = "Singular";
    public static final String ATTRIBUTION_PLATFORM_SOLAR_ENGINE = "SolarEngine";
    public static final String ATTRIBUTION_PLATFORM_TALKING_DATA = "TalkingData";
    public static final String ATTRIBUTION_PLATFORM_TENJIN = "Tenjin";
    public static final String ATTRIBUTION_PLATFORM_UMENG = "Umeng";
    private JSONObject eventInfoJsonObject = new JSONObject();
    private String mediationName;
    private String mmpName;
    private String mmpUserId;
    private String traceId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributionPlatform {
    }

    public MBridgeRevenueParamsEntity(String str, String str2) {
        setMmpName(str);
        setMmpUserId(str2);
        setTraceId(ak.d());
    }

    public String getMediationName() {
        return this.mediationName;
    }

    /* access modifiers changed from: protected */
    public String getMmpName() {
        return this.mmpName;
    }

    /* access modifiers changed from: protected */
    public String getMmpUserId() {
        return this.mmpUserId;
    }

    /* access modifiers changed from: protected */
    public String getReportData() {
        try {
            String jSONObject = this.eventInfoJsonObject.toString();
            return "event_info=" + URLEncoder.encode(jSONObject, "utf-8");
        } catch (Exception e5) {
            e5.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public String getTraceId() {
        return this.traceId;
    }

    /* access modifiers changed from: protected */
    public void setAdType(String str) {
        try {
            this.eventInfoJsonObject.put("mediation_ad_type", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setBidType(Boolean bool) {
        try {
            this.eventInfoJsonObject.put("bid_type", bool);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setCurrency(String str) {
        try {
            this.eventInfoJsonObject.put("currency", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setDspInfo(String str, String str2) {
        try {
            this.eventInfoJsonObject.put("dsp_name", str);
            this.eventInfoJsonObject.put("dsp_id", str2);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setEventTime(String str) {
        try {
            this.eventInfoJsonObject.put("event_time", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setExtData(JSONObject jSONObject) {
        try {
            this.eventInfoJsonObject.put("extra_data", jSONObject);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setMediationName(String str) {
        try {
            this.mediationName = str;
            this.eventInfoJsonObject.put("mediation_name", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setMediationUnitId(String str) {
        try {
            this.eventInfoJsonObject.put("mediation_unit_id", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setMmpName(String str) {
        this.mmpName = str;
        try {
            this.eventInfoJsonObject.put("mmp_name", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setMmpUserId(String str) {
        this.mmpUserId = str;
        try {
            this.eventInfoJsonObject.put("mmp_user_id", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setNetworkInfo(JSONObject jSONObject) {
        String str;
        try {
            JSONObject jSONObject2 = this.eventInfoJsonObject;
            if (jSONObject == null) {
                str = "{}";
            } else {
                str = jSONObject.toString();
            }
            jSONObject2.put("network_unit_info", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setNetworkName(String str) {
        try {
            this.eventInfoJsonObject.put("network_name", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setPrecision(String str) {
        try {
            this.eventInfoJsonObject.put("precision", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setRevenue(String str) {
        try {
            this.eventInfoJsonObject.put("revenue", str);
            long currentTimeMillis = System.currentTimeMillis();
            setEventTime((currentTimeMillis / 1000) + "");
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setSourceData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mediation_source_data", str);
            jSONObject.put("adNetwork_source_data", str2);
            this.eventInfoJsonObject.put("all_info", jSONObject);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void setTraceId(String str) {
        this.traceId = str;
        try {
            this.eventInfoJsonObject.put("trace_id", str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
