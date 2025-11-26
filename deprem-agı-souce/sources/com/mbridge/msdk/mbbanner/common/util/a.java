package com.mbridge.msdk.mbbanner.common.util;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbbanner.common.b.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10060a = "a";

    /* renamed from: b  reason: collision with root package name */
    private final Handler f10061b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f10062c;

    public final void b(final b bVar, final com.mbridge.msdk.foundation.c.b bVar2) {
        String str = f10060a;
        af.b(str, "postResourceFail unitId=" + bVar2);
        this.f10061b.post(new Runnable() {
            public final void run() {
                if (bVar != null) {
                    bVar2.a(a.this.f10062c);
                    bVar.b(bVar2);
                }
            }
        });
    }

    public final void a(boolean z4) {
        this.f10062c = z4;
    }

    public final void a(final b bVar, final CampaignUnit campaignUnit, final String str) {
        String str2 = f10060a;
        af.b(str2, "postCampaignSuccess unitId=" + str);
        this.f10061b.post(new Runnable() {
            public final void run() {
                b bVar = bVar;
                if (bVar != null) {
                    bVar.a(str, campaignUnit, a.this.f10062c);
                }
            }
        });
    }

    public final void a(final b bVar, final com.mbridge.msdk.foundation.c.b bVar2) {
        this.f10061b.post(new Runnable() {
            public final void run() {
                if (bVar != null) {
                    bVar2.a(a.this.f10062c);
                    bVar.a(bVar2);
                }
            }
        });
    }

    public final void a(final b bVar, final String str, final int i5) {
        String str2 = f10060a;
        af.b(str2, "postResourceSuccess unitId=" + str);
        this.f10061b.post(new Runnable() {
            public final void run() {
                b bVar = bVar;
                if (bVar != null) {
                    bVar.a(str, i5, a.this.f10062c);
                }
            }
        });
    }
}
