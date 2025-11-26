package com.mbridge.msdk.newreward.function.c.c;

import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public final class s extends r {
    protected s(b bVar, a aVar, b bVar2) {
        super(bVar, aVar, bVar2);
    }

    public final /* bridge */ /* synthetic */ void a(int i5, x xVar) {
        super.a(i5, xVar);
    }

    /* access modifiers changed from: protected */
    public final String b() {
        return "template_" + super.d().C() + "_" + super.d().D();
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
        b d5 = super.d();
        if (d5 == null) {
            return true;
        }
        return d5.K();
    }
}
