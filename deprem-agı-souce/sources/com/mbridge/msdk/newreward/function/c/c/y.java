package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;

public final class y extends q implements OnDownloadStateListener<b>, OnProgressStateListener<b> {

    /* renamed from: a  reason: collision with root package name */
    private final b f10660a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10661b;

    /* renamed from: c  reason: collision with root package name */
    private final n f10662c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10663d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10664e;

    /* renamed from: f  reason: collision with root package name */
    private final String f10665f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10666g = false;

    /* renamed from: h  reason: collision with root package name */
    private final int f10667h;

    /* renamed from: i  reason: collision with root package name */
    private DownloadRequest f10668i;

    /* renamed from: j  reason: collision with root package name */
    private x f10669j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f10670k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10671l = false;

    public y(b bVar, a aVar, n nVar, int i5) {
        this.f10660a = bVar;
        this.f10661b = aVar;
        this.f10662c = nVar;
        this.f10667h = i5;
        String j5 = nVar.j();
        this.f10663d = j5;
        String str = e.a(c.MBRIDGE_VC) + File.separator;
        this.f10664e = str;
        String a5 = com.mbridge.msdk.newreward.function.h.c.a(j5);
        this.f10665f = a5;
        String str2 = str + a5;
        nVar.a(new File(str2));
        nVar.a(true);
        File file = new File(str2);
        if (file.exists() && file.isFile()) {
            nVar.a(1);
            nVar.b(true);
            nVar.a(false);
        }
    }

    public final void a(int i5, x xVar) {
        DownloadMessage downloadMessage;
        int i6;
        this.f10669j = xVar;
        if (TextUtils.isEmpty(this.f10663d)) {
            if (this.f10662c.d()) {
                x xVar2 = this.f10669j;
                if (xVar2 != null) {
                    xVar2.a(this.f10660a, this.f10661b, this);
                    this.f10669j.b(this.f10660a, this.f10661b, this);
                    return;
                }
                return;
            }
            x xVar3 = this.f10669j;
            if (xVar3 != null) {
                xVar3.a(this.f10660a, this.f10661b, this);
                this.f10669j.a(this.f10660a, this.f10661b, this, new MBridgeError(5, MBridgeError.ERROR_MESSAGE_DOWNLOAD_RESOURCE_URL_ERROR));
            }
        } else if (this.f10671l) {
            x xVar4 = this.f10669j;
            if (xVar4 != null) {
                xVar4.b(this.f10660a, this.f10661b, this);
            }
        } else {
            this.f10670k = false;
            int videoCtnType = this.f10661b.h().getVideoCtnType();
            if (i5 == 1 || (i6 = this.f10667h) == 100) {
                this.f10666g = false;
                downloadMessage = new DownloadMessage(this.f10660a, this.f10663d, this.f10665f, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            } else if (videoCtnType == 1) {
                this.f10666g = false;
                downloadMessage = new DownloadMessage(this.f10660a, this.f10663d, this.f10665f, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            } else {
                this.f10666g = true;
                downloadMessage = new DownloadMessage(this.f10660a, this.f10663d, this.f10665f, i6, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            }
            DownloadRequest build = MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withWriteTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withDownloadPriority(DownloadPriority.IMMEDIATE).withHttpRetryCounter(5).withDirectoryPathInternal(this.f10664e).withDownloadStateListener(this).withProgressStateListener(this).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).with("download_scene", "download_video").with("do_us_fi_re", Boolean.toString(true)).build();
            this.f10668i = build;
            build.start();
        }
    }

    public final void onCancelDownload(DownloadMessage<b> downloadMessage) {
        if (this.f10670k) {
            x xVar = this.f10669j;
            if (xVar != null) {
                xVar.b(this.f10660a, this.f10661b, this, new MBridgeError(4, MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT));
                return;
            }
            return;
        }
        x xVar2 = this.f10669j;
        if (xVar2 != null) {
            xVar2.a(this.f10660a, this.f10661b, this, new MBridgeError(2, MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR));
        }
    }

    public final void onDownloadComplete(DownloadMessage<b> downloadMessage) {
        int i5;
        String str = this.f10668i.get("cache", "2");
        n nVar = this.f10662c;
        if (TextUtils.equals(str, "2")) {
            i5 = 2;
        } else {
            i5 = 1;
        }
        nVar.a(i5);
        this.f10662c.b(true);
        this.f10662c.a(false);
        this.f10671l = true;
        x xVar = this.f10669j;
        if (xVar != null) {
            xVar.b(this.f10660a, this.f10661b, this);
        }
    }

    public final void onDownloadError(DownloadMessage<b> downloadMessage, DownloadError downloadError) {
        int i5;
        String str = this.f10668i.get("cache", "2");
        n nVar = this.f10662c;
        if (TextUtils.equals(str, "2")) {
            i5 = 2;
        } else {
            i5 = 1;
        }
        nVar.a(i5);
        this.f10662c.b(false);
        this.f10662c.a(false);
        MBridgeError mBridgeError = new MBridgeError(2, MBridgeError.ERROR_MESSAGE_DOWNLOAD_VIDEO_ERROR);
        mBridgeError.setException(downloadError.getException());
        x xVar = this.f10669j;
        if (xVar != null) {
            xVar.a(this.f10660a, this.f10661b, this, mBridgeError);
        }
    }

    public final void onDownloadStart(DownloadMessage<b> downloadMessage) {
        x xVar = this.f10669j;
        if (xVar != null) {
            xVar.a(this.f10660a, this.f10661b, this);
        }
    }

    public final void onProgress(DownloadMessage<b> downloadMessage, DownloadProgress downloadProgress) {
        int i5;
        if (downloadProgress.getCurrentDownloadRate() >= this.f10667h) {
            String str = this.f10668i.get("cache", "2");
            n nVar = this.f10662c;
            if (TextUtils.equals(str, "2")) {
                i5 = 2;
            } else {
                i5 = 1;
            }
            nVar.a(i5);
            this.f10662c.b(true);
            this.f10662c.a(false);
            if (this.f10666g) {
                this.f10668i.cancel(downloadMessage);
            }
        }
    }
}
