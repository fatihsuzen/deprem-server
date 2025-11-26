package com.mbridge.msdk.reward.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final a f11407a;

    public b(a aVar) {
        super(Looper.getMainLooper());
        this.f11407a = aVar;
    }

    public final void handleMessage(Message message) {
        boolean z4;
        String str;
        int i5;
        Message message2 = message;
        int i6 = message2.what;
        Object obj = message2.obj;
        c a5 = this.f11407a.a(message2);
        CopyOnWriteArrayList<CampaignEx> e5 = this.f11407a.e();
        List<CampaignEx> f5 = this.f11407a.f();
        com.mbridge.msdk.reward.adapter.c g5 = this.f11407a.g();
        boolean h5 = this.f11407a.h();
        String j5 = this.f11407a.j();
        String i7 = this.f11407a.i();
        a.c k5 = this.f11407a.k();
        InterVideoOutListener l5 = this.f11407a.l();
        boolean m5 = this.f11407a.m();
        MBridgeIds n5 = this.f11407a.n();
        boolean o5 = this.f11407a.o();
        boolean z5 = m5;
        switch (i6) {
            case 8:
                if (e5 != null && e5.size() > 0) {
                    if (f5 == null || f5.size() <= 0) {
                        z4 = false;
                    } else {
                        z4 = !TextUtils.isEmpty(f5.get(0).getCMPTEntryUrl());
                    }
                    int nscpt = e5.get(0).getNscpt();
                    if (g5 == null || !g5.a((List<CampaignEx>) e5, z4, nscpt)) {
                        if (k5 != null && h5) {
                            com.mbridge.msdk.videocommon.a.c(i7);
                            com.mbridge.msdk.videocommon.a.a();
                            com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880010, "load timeout");
                            if (a5 != null) {
                                a5.a(b5);
                            }
                            k5.a(b5, a5);
                            return;
                        }
                        return;
                    } else if (k5 != null && h5) {
                        k5.a(j5, i7, a5);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 9:
                if (l5 != null && h5) {
                    if (z5) {
                        this.f11407a.c();
                    }
                    l5.onVideoLoadSuccess(n5);
                    return;
                }
                return;
            case 16:
            case 18:
                if (l5 != null && h5) {
                    if (obj instanceof String) {
                        str = obj.toString();
                    } else {
                        str = "";
                    }
                    if (!(a5 == null || a5.o() == null)) {
                        str = a5.o().b();
                    }
                    com.mbridge.msdk.videocommon.a.c(i7);
                    com.mbridge.msdk.videocommon.a.a();
                    if (z5) {
                        this.f11407a.c();
                    }
                    l5.onVideoLoadFail(n5, str);
                    return;
                }
                return;
            case 17:
                if (l5 != null && h5) {
                    if (z5) {
                        this.f11407a.c();
                    }
                    l5.onLoadSuccess(n5);
                    return;
                }
                return;
            case 1001001:
                d a6 = d.a();
                if (o5) {
                    i5 = 287;
                } else {
                    i5 = 94;
                }
                this.f11407a.a(false, a6.a(0, i5, i7, true, 1));
                return;
            case 1001002:
                if (g5 == null) {
                    return;
                }
                if (g5.b()) {
                    if (k5 != null) {
                        CopyOnWriteArrayList<CampaignEx> d5 = g5.d();
                        if (d5 != null && d5.size() == 0) {
                            d5 = g5.e();
                        }
                        this.f11407a.a((List<CampaignEx>) d5);
                        c a7 = this.f11407a.a((List<CampaignEx>) d5, a5);
                        if (a7 != null) {
                            a7.b((List<CampaignEx>) d5);
                        }
                        k5.b(j5, i7, a7);
                        return;
                    }
                    return;
                } else if (g5.h(false)) {
                    if (!g5.b()) {
                        g5.g(false);
                        if (!g5.h(true)) {
                            return;
                        }
                        if (!g5.b()) {
                            g5.g(true);
                            return;
                        } else if (k5 != null) {
                            g5.f(true);
                            CopyOnWriteArrayList<CampaignEx> d6 = g5.d();
                            if (d6 != null && d6.size() == 0) {
                                d6 = g5.e();
                            }
                            this.f11407a.a((List<CampaignEx>) d6);
                            c a8 = this.f11407a.a((List<CampaignEx>) d6, a5);
                            if (a8 != null) {
                                a8.b((List<CampaignEx>) d6);
                            }
                            k5.b(j5, i7, a8);
                            return;
                        } else {
                            return;
                        }
                    } else if (k5 != null) {
                        g5.f(false);
                        CopyOnWriteArrayList<CampaignEx> d7 = g5.d();
                        if (d7 != null && d7.size() == 0) {
                            d7 = g5.e();
                        }
                        this.f11407a.a((List<CampaignEx>) d7);
                        c a9 = this.f11407a.a((List<CampaignEx>) d7, a5);
                        if (a9 != null) {
                            a9.b((List<CampaignEx>) d7);
                        }
                        k5.b(j5, i7, a9);
                        return;
                    } else {
                        return;
                    }
                } else if (!g5.h(true)) {
                    return;
                } else {
                    if (!g5.b()) {
                        g5.g(true);
                        return;
                    } else if (k5 != null) {
                        g5.f(true);
                        CopyOnWriteArrayList<CampaignEx> d8 = g5.d();
                        if (d8 != null && d8.size() == 0) {
                            d8 = g5.e();
                        }
                        this.f11407a.a((List<CampaignEx>) d8);
                        c a10 = this.f11407a.a((List<CampaignEx>) d8, a5);
                        if (a10 != null) {
                            a10.b((List<CampaignEx>) d8);
                        }
                        k5.b(j5, i7, a10);
                        return;
                    } else {
                        return;
                    }
                }
            default:
                return;
        }
    }
}
