package com.mbridge.msdk.video.module.a.a;

import androidx.appcompat.R;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

public final class n extends o {

    /* renamed from: l  reason: collision with root package name */
    private IJSFactory f12611l;

    /* renamed from: m  reason: collision with root package name */
    private int f12612m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12613n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f12614o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f12615p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12616q = false;

    /* renamed from: r  reason: collision with root package name */
    private MBridgeVideoView.a f12617r;

    public n(IJSFactory iJSFactory, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, int i5, int i6, com.mbridge.msdk.video.module.a.a aVar2, int i7, boolean z4, int i8) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i7, z4);
        boolean z5;
        this.f12611l = iJSFactory;
        this.f12612m = i5;
        if (i6 == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f12613n = z5;
        this.f12615p = i8;
        if (iJSFactory == null) {
            this.f12581a = false;
        }
    }

    public final void a(int i5, Object obj) {
        Integer num;
        int i6;
        int i7 = i5;
        Object obj2 = obj;
        if (this.f12581a) {
            String str = "";
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 != 5) {
                        int i8 = 6;
                        if (i7 != 6) {
                            if (i7 != 8) {
                                if (i7 != 20) {
                                    if (i7 != 114) {
                                        if (i7 != 116) {
                                            switch (i7) {
                                                case 10:
                                                    this.f12616q = true;
                                                    this.f12611l.getJSNotifyProxy().a(0);
                                                    break;
                                                case 11:
                                                case 12:
                                                    this.f12611l.getJSVideoModule().videoOperate(3);
                                                    if (this.f12582b.getVideo_end_type() == 3) {
                                                        this.f12611l.getJSVideoModule().setVisible(0);
                                                    } else if (this.f12582b.getAdSpaceT() != 2) {
                                                        this.f12611l.getJSVideoModule().setVisible(8);
                                                    }
                                                    if (i7 == 12) {
                                                        h();
                                                        i6 = 2;
                                                    } else {
                                                        i6 = 1;
                                                    }
                                                    this.f12611l.getJSNotifyProxy().a(i6);
                                                    if (this.f12611l.getJSCommon().g() == 2) {
                                                        this.f12611l.getJSVideoModule().setVisible(0);
                                                        j jSVideoModule = this.f12611l.getJSVideoModule();
                                                        this.f12611l.getJSContainerModule().showMiniCard(jSVideoModule.getBorderViewTop(), jSVideoModule.getBorderViewLeft(), jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                                                    } else if (i7 == 12) {
                                                        if (this.f12615p == 1) {
                                                            if (this.f12582b.getAdSpaceT() != 2) {
                                                                this.f12611l.getJSContainerModule().showEndcard(this.f12582b.getVideo_end_type());
                                                            } else {
                                                                this.f12611l.getJSContainerModule().showVideoEndCover();
                                                            }
                                                        }
                                                    } else if (this.f12582b.getAdSpaceT() != 2) {
                                                        this.f12611l.getJSContainerModule().showEndcard(this.f12582b.getVideo_end_type());
                                                    } else {
                                                        this.f12611l.getJSContainerModule().showVideoEndCover();
                                                    }
                                                    this.f12611l.getJSVideoModule().dismissAllAlert();
                                                    if (i7 == 12 && !this.f12616q && this.f12615p == 1) {
                                                        h();
                                                        g();
                                                        f();
                                                        e();
                                                        if (ah.a().a("i_l_s_t_r_i", false) && !this.f12614o) {
                                                            this.f12614o = true;
                                                            MBridgeVideoView.a aVar = this.f12617r;
                                                            if (aVar != null) {
                                                                aVar.a();
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 13:
                                                    if (!this.f12611l.getJSVideoModule().isH5Canvas()) {
                                                        this.f12611l.getJSVideoModule().closeVideoOperate(0, 2);
                                                    }
                                                    this.f12611l.getJSNotifyProxy().a(-1);
                                                    break;
                                                case 14:
                                                    if (!this.f12613n) {
                                                        this.f12611l.getJSVideoModule().closeVideoOperate(0, 1);
                                                        break;
                                                    }
                                                    break;
                                                case 15:
                                                    if (obj2 != null && (obj2 instanceof MBridgeVideoView.b)) {
                                                        this.f12613n = true;
                                                        this.f12611l.getJSNotifyProxy().a((MBridgeVideoView.b) obj2);
                                                        break;
                                                    }
                                                default:
                                                    switch (i7) {
                                                        case 123:
                                                        case R.styleable.AppCompatTheme_windowMinWidthMajor:
                                                            g jSNotifyProxy = this.f12611l.getJSNotifyProxy();
                                                            if (i7 == 123) {
                                                                i8 = 7;
                                                            }
                                                            jSNotifyProxy.a(i8, str);
                                                            break;
                                                        case R.styleable.AppCompatTheme_windowMinWidthMinor:
                                                            this.f12611l.getJSContainerModule().hideAlertWebview();
                                                            break;
                                                    }
                                            }
                                        } else {
                                            j jSVideoModule2 = this.f12611l.getJSVideoModule();
                                            this.f12611l.getJSContainerModule().configurationChanged(jSVideoModule2.getBorderViewWidth(), jSVideoModule2.getBorderViewHeight(), jSVideoModule2.getBorderViewRadius());
                                        }
                                    } else if (this.f12611l.getJSCommon().g() == 2) {
                                        j jSVideoModule3 = this.f12611l.getJSVideoModule();
                                        this.f12611l.getJSContainerModule().showMiniCard(jSVideoModule3.getBorderViewTop(), jSVideoModule3.getBorderViewLeft(), jSVideoModule3.getBorderViewWidth(), jSVideoModule3.getBorderViewHeight(), jSVideoModule3.getBorderViewRadius());
                                    }
                                } else if (ah.a().a("i_l_s_t_r_i", false) && (obj2 instanceof MBridgeVideoView.a)) {
                                    this.f12617r = (MBridgeVideoView.a) obj2;
                                }
                            } else if (!this.f12611l.getJSContainerModule().showAlertWebView()) {
                                this.f12611l.getJSVideoModule().showAlertView();
                            } else {
                                this.f12611l.getJSVideoModule().alertWebViewShowed();
                            }
                        }
                    } else if (obj2 != null && (obj2 instanceof Integer)) {
                        if (((Integer) obj2).intValue() == 1) {
                            num = 2;
                        } else {
                            num = 1;
                        }
                        this.f12611l.getJSVideoModule().soundOperate(num.intValue(), -1);
                        this.f12611l.getJSNotifyProxy().a(5, num + str);
                    }
                }
                this.f12611l.getJSVideoModule().dismissAllAlert();
                if (i7 == 2) {
                    this.f12611l.getJSNotifyProxy().a(2, str);
                }
                this.f12611l.getJSVideoModule().videoOperate(3);
                int i9 = 16;
                if (this.f12611l.getJSCommon().g() != 2) {
                    if (this.f12582b.getVideo_end_type() != 3) {
                        this.f12611l.getJSVideoModule().setVisible(8);
                    } else {
                        this.f12611l.getJSVideoModule().setVisible(0);
                    }
                    if (this.f12612m == 2 && !this.f12611l.getJSContainerModule().endCardShowing() && this.f12582b.getAdSpaceT() != 2) {
                        this.f12611l.getJSContainerModule().showEndcard(this.f12582b.getVideo_end_type());
                        i9 = i7;
                    }
                }
                this.f12611l.getJSNotifyProxy().a(1);
                i7 = i9;
            } else if (!this.f12611l.getJSContainerModule().endCardShowing()) {
                g jSNotifyProxy2 = this.f12611l.getJSNotifyProxy();
                if (obj2 != null) {
                    str = obj2.toString();
                }
                jSNotifyProxy2.a(1, str);
            }
        }
        super.a(i7, obj2);
    }
}
