package com.mbridge.msdk.click;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;

public final class g extends AppletSchemeCallBack {

    /* renamed from: a  reason: collision with root package name */
    private final NativeListener.NativeTrackingListener f8133a;

    /* renamed from: b  reason: collision with root package name */
    private final CampaignEx f8134b;

    /* renamed from: c  reason: collision with root package name */
    private final AppletsModel f8135c;

    /* renamed from: d  reason: collision with root package name */
    private final a f8136d;

    public g(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        this.f8133a = nativeTrackingListener;
        this.f8134b = campaignEx;
        this.f8135c = appletsModel;
        this.f8136d = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onRequestFailed(int i5, String str, String str2) {
        CampaignEx campaignEx = this.f8134b;
        if (campaignEx != null && this.f8135c != null) {
            try {
                NativeListener.NativeTrackingListener nativeTrackingListener = this.f8133a;
                if (nativeTrackingListener != null) {
                    try {
                        nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("DefaultAppletSchemeCallBack", e5.getMessage());
                        }
                    }
                }
                this.f8135c.setUserClick(false);
                this.f8135c.setRequestingFinish();
                this.f8134b.setClickURL(str2);
                a aVar = this.f8136d;
                if (aVar != null) {
                    try {
                        aVar.a(this.f8134b);
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("DefaultAppletSchemeCallBack", e6.getMessage());
                        }
                    }
                }
            } catch (Exception e7) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DefaultAppletSchemeCallBack", e7.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onRequestStart() {
    }

    /* access modifiers changed from: protected */
    public final void onRequestSuccess(String str) {
        CampaignEx campaignEx = this.f8134b;
        if (campaignEx != null && this.f8135c != null) {
            try {
                NativeListener.NativeTrackingListener nativeTrackingListener = this.f8133a;
                if (nativeTrackingListener != null) {
                    try {
                        nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("DefaultAppletSchemeCallBack", e5.getMessage());
                        }
                    }
                }
                this.f8135c.setUserClick(false);
                this.f8135c.setRequestingFinish();
                this.f8134b.setDeepLinkUrl(str);
                a aVar = this.f8136d;
                if (aVar != null) {
                    try {
                        aVar.a(this.f8134b);
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("DefaultAppletSchemeCallBack", e6.getMessage());
                        }
                    }
                }
            } catch (Exception e7) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DefaultAppletSchemeCallBack", e7.getMessage());
                }
            }
        }
    }
}
