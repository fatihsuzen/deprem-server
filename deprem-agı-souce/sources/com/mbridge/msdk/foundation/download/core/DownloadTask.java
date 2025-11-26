package com.mbridge.msdk.foundation.download.core;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.core.DownloaderReporter;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DownloadTask implements IDownloadTask {
    private final String METRICS_D_LOAD_TYPE = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY;
    private IDatabaseHelper _databaseHelper;
    private volatile DownloadMessage _downloadMessage;
    /* access modifiers changed from: private */
    public volatile DownloadModel _downloadModel = null;
    private DownloaderReporter.Builder _downloaderReporter;
    /* access modifiers changed from: private */
    public volatile boolean _needUpdateDownloadModel = true;
    /* access modifiers changed from: private */
    public final Object _object = new Object();
    private volatile DownloadRequest _request;
    private String downType = "";

    private DownloadTask(DownloadRequest downloadRequest, DownloadMessage downloadMessage, IDatabaseHelper iDatabaseHelper) {
        this._request = downloadRequest;
        this._downloadMessage = downloadMessage;
        this._databaseHelper = iDatabaseHelper;
    }

    static IDownloadTask create(DownloadRequest downloadRequest, DownloadMessage downloadMessage, IDatabaseHelper iDatabaseHelper) {
        return new DownloadTask(downloadRequest, downloadMessage, iDatabaseHelper);
    }

    private void sendProgress(DownloadRequest downloadRequest, DownloadMessage downloadMessage) {
        if (downloadRequest.getStatus() != DownloadStatus.CANCELLED) {
            long downloadedBytes = this._request.getDownloadedBytes();
            long totalBytes = this._request.getTotalBytes();
            downloadRequest.handlerProcessEvent(downloadMessage, new DownloadProgress(downloadedBytes, totalBytes, Utils.getDownloadRate(totalBytes, downloadedBytes)));
        }
    }

    public DownloadResponse run() {
        String str;
        DownloaderReporter.Builder builder = new DownloaderReporter.Builder(DownloadCommon.DOWNLOAD_REPORT_KEY);
        this._downloaderReporter = builder;
        builder.add(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT, String.valueOf(this._request.getRetryedCount()));
        String downloadId = this._request.getDownloadId();
        if (this._request.getStatus() == DownloadStatus.CANCELLED) {
            DownloadResponse downloadResponse = new DownloadResponse();
            downloadResponse.setCancelled(true);
            return downloadResponse;
        } else if (this._downloadMessage.getDownloadRate() == 0) {
            DownloadResponse downloadResponse2 = new DownloadResponse();
            downloadResponse2.setSuccessful(true);
            return downloadResponse2;
        } else {
            String cacheDirectoryPath = this._request.getCacheDirectoryPath();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this._databaseHelper.find(downloadId, cacheDirectoryPath, new IDatabaseHelper.IDatabaseListener() {
                public void onDatabase(DownloadModel downloadModel) {
                    synchronized (DownloadTask.this._object) {
                        try {
                            if (DownloadTask.this._needUpdateDownloadModel) {
                                DownloadModel unused = DownloadTask.this._downloadModel = downloadModel;
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(10, TimeUnit.SECONDS);
                synchronized (this._object) {
                    this._needUpdateDownloadModel = false;
                }
            } catch (InterruptedException e5) {
                try {
                    ILogger logger = GlobalComponent.getInstance().getLogger();
                    logger.log(IDownloadTask.TAG, "" + e5.getMessage());
                    countDownLatch.countDown();
                    this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_QUERY_TIMEOUT, Boolean.TRUE.toString());
                    synchronized (this._object) {
                        this._needUpdateDownloadModel = false;
                    }
                } catch (Throwable th) {
                    synchronized (this._object) {
                        this._needUpdateDownloadModel = false;
                        throw th;
                    }
                }
            }
            if (this._downloadModel == null || this._downloadModel.getDownloadedBytes() <= 0) {
                str = "2";
            } else {
                str = "1";
            }
            this._request.putExtraData("resumed_breakpoint", str);
            DownloadResponse run = FindFileFromCache.create(this._request, this._downloadModel, this._databaseHelper, downloadId, this._downloadMessage, this._downloaderReporter).run();
            if (!Objects.isNotNull(run) || !run.isSuccessful()) {
                this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_RETURN_FROM_CACHE, Boolean.FALSE.toString());
                this._request.putExtraData("cache", "2");
                if (this._downloadMessage != null) {
                    this._downloadMessage.setCache(false);
                }
                return OkHTTPFileDownloadTask.create(this._request, this._downloadModel, this._databaseHelper, this._downloadMessage, this._downloaderReporter).run();
            }
            this._request.putExtraData("cache", "1");
            if (this._downloadMessage != null) {
                this._downloadMessage.setCache(true);
            }
            sendProgress(this._request, this._downloadMessage);
            this._downloadModel = DownloadModel.create(this._downloadModel.getDownloadId(), this._downloadModel.getDownloadUrl(), this._downloadModel.getResourceUrl(), this._downloadModel.getEtag(), this._downloadModel.getSaveDirectorPath(), this._downloadModel.getSaveFileName(), this._request.getTotalBytes(), this._downloadModel.getDownloadedBytes(), this._downloadModel.getDownloadRate(), this._downloadModel.getUsageCounter() + 1, this._downloadModel.getDownloadResourceType());
            this._databaseHelper.update(this._downloadModel, cacheDirectoryPath);
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_RETURN_FROM_CACHE, Boolean.TRUE.toString());
            this._downloaderReporter.build().report();
            return run;
        }
    }
}
