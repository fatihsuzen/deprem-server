package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import java.util.Map;

public class MBButton extends Button implements InterBase {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f8313a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Boolean> f8314b;

    /* renamed from: c  reason: collision with root package name */
    private String f8315c = "";

    public MBButton(Context context) {
        super(context);
    }

    public String getActionDes() {
        Map<String, String> map = this.f8313a;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f8313a.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f8313a;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f8313a.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f8313a;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f8313a.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f8313a;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f8313a.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f8313a;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f8313a.get("mbridgeStrategy");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f8314b;
        if (map != null && map.containsKey("mbridgeAttached") && this.f8314b.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f8315c);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f8314b;
        if (map != null && map.containsKey("mbridgeDetached") && this.f8314b.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f8315c);
        }
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f8314b = c.a(str);
        if (campaignEx != null) {
            this.f8315c = campaignEx.getCampaignUnitId();
        }
    }

    public MBButton(Context context, AttributeSet attributeSet) {
        super(context);
        this.f8313a = c.a(context, attributeSet);
        a.a(this, attributeSet);
        c.a(this.f8313a, (View) this);
    }

    public MBButton(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
