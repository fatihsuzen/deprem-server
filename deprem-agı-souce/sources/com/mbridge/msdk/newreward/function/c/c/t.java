package com.mbridge.msdk.newreward.function.c.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public final class t extends r {
    protected t(b bVar, a aVar, b bVar2) {
        super(bVar, aVar, bVar2);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final String b() {
        CampaignEx h5;
        String str;
        if (!(super.c() == null || super.c().h() == null || (h5 = super.c().h()) == null || TextUtils.isEmpty(h5.getendcard_url()))) {
            Context x4 = super.d().x();
            if (x4 == null) {
                x4 = c.m().c();
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("template_");
                if (com.mbridge.msdk.e.b.a()) {
                    str = "cn";
                } else {
                    str = "en";
                }
                sb.append(str);
                sb.append("_");
                sb.append(ab.s(x4.getApplicationContext()));
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return "";
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

    public final /* bridge */ /* synthetic */ void a(int i5, x xVar) {
        super.a(i5, xVar);
    }
}
