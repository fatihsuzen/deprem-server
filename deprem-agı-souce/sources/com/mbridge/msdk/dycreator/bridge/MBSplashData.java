package com.mbridge.msdk.dycreator.bridge;

import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public class MBSplashData implements a {

    /* renamed from: a  reason: collision with root package name */
    private DyOption f8629a;

    /* renamed from: b  reason: collision with root package name */
    private String f8630b;

    /* renamed from: c  reason: collision with root package name */
    private String f8631c;

    /* renamed from: d  reason: collision with root package name */
    private String f8632d;

    /* renamed from: e  reason: collision with root package name */
    private String f8633e;

    /* renamed from: f  reason: collision with root package name */
    private CampaignEx f8634f;

    /* renamed from: g  reason: collision with root package name */
    private int f8635g;

    /* renamed from: h  reason: collision with root package name */
    private int f8636h;

    /* renamed from: i  reason: collision with root package name */
    private float f8637i;

    /* renamed from: j  reason: collision with root package name */
    private float f8638j;

    /* renamed from: k  reason: collision with root package name */
    private int f8639k = 0;

    public MBSplashData(DyOption dyOption) {
        this.f8629a = dyOption;
        this.f8634f = dyOption.getCampaignEx();
    }

    public String getAdClickText() {
        return this.f8631c;
    }

    public String getAppInfo() {
        return this.f8630b;
    }

    public CampaignEx getBindData() {
        return this.f8634f;
    }

    public int getClickType() {
        return this.f8639k;
    }

    public String getCountDownText() {
        return this.f8632d;
    }

    public DyOption getDyOption() {
        return this.f8629a;
    }

    public DyOption getEffectData() {
        return this.f8629a;
    }

    public int getLogoImage() {
        return this.f8636h;
    }

    public String getLogoText() {
        return this.f8633e;
    }

    public int getNoticeImage() {
        return this.f8635g;
    }

    public float getxInScreen() {
        return this.f8637i;
    }

    public float getyInScreen() {
        return this.f8638j;
    }

    public void setAdClickText(String str) {
        this.f8631c = str;
    }

    public void setAppInfo(String str) {
        this.f8630b = str;
    }

    public void setClickType(int i5) {
        this.f8639k = i5;
    }

    public void setCountDownText(String str) {
        this.f8632d = str;
    }

    public void setLogoImage(int i5) {
        this.f8636h = i5;
    }

    public void setLogoText(String str) {
        this.f8633e = str;
    }

    public void setNoticeImage(int i5) {
        this.f8635g = i5;
    }

    public void setxInScreen(float f5) {
        this.f8637i = f5;
    }

    public void setyInScreen(float f5) {
        this.f8638j = f5;
    }
}
