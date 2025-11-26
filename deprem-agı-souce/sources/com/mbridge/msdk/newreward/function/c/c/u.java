package com.mbridge.msdk.newreward.function.c.c;

import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public final class u extends r {
    protected u(b bVar, a aVar, b bVar2) {
        super(bVar, aVar, bVar2);
    }

    public final /* bridge */ /* synthetic */ void a(int i5, x xVar) {
        super.a(i5, xVar);
    }

    /* access modifiers changed from: protected */
    public final String b() {
        CampaignEx h5;
        CampaignEx.c rewardTemplateMode;
        if (super.c() == null || super.c().h() == null || (h5 = super.c().h()) == null || (rewardTemplateMode = h5.getRewardTemplateMode()) == null) {
            return "";
        }
        return "template_" + rewardTemplateMode.f();
    }

    public final /* bridge */ /* synthetic */ a c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ b d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ a e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ void onCancelDownload(DownloadMessage downloadMessage) {
        super.onCancelDownload(downloadMessage);
    }

    public final /* bridge */ /* synthetic */ void onDownloadComplete(DownloadMessage downloadMessage) {
        super.onDownloadComplete(downloadMessage);
    }

    public final /* bridge */ /* synthetic */ void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
        super.onDownloadError(downloadMessage, downloadError);
    }

    public final /* bridge */ /* synthetic */ void onDownloadStart(DownloadMessage downloadMessage) {
        super.onDownloadStart(downloadMessage);
    }

    public final /* bridge */ /* synthetic */ void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
        super.onProgress(downloadMessage, downloadProgress);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        a c5 = super.c();
        if (c5 == null) {
            return true;
        }
        return c5.k();
    }
}
