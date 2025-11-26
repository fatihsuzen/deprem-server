package com.mbridge.msdk.out;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

public class MBridgeIds implements NoProGuard, Serializable {
    private String bidToken = "";
    private boolean isCache = false;
    private String placementId;
    private String requestId;
    private String unitId;

    public MBridgeIds() {
    }

    public String getBidToken() {
        if (TextUtils.isEmpty(this.bidToken)) {
            this.bidToken = "";
        }
        return this.bidToken;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getRequestId() {
        if (TextUtils.isEmpty(this.requestId)) {
            return "";
        }
        return this.requestId;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public void setCache(boolean z4) {
        this.isCache = z4;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    @NonNull
    public String toString() {
        return "MBridgeIds{placementId='" + this.placementId + '\'' + ", unitId='" + this.unitId + '\'' + ", bidToken='" + this.bidToken + '\'' + '}';
    }

    public MBridgeIds(String str, String str2) {
        this.placementId = str;
        this.unitId = str2;
    }

    public MBridgeIds(String str, String str2, String str3) {
        this.placementId = str;
        this.unitId = str2;
        this.requestId = str3;
    }
}
