package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.ILogger;

public class Downloader implements Runnable {
    private static final String TAG = "DownloadTask";
    private IDatabaseHelper databaseHelper;
    private volatile DownloadMessage downloadMessage;
    public final DownloadPriority downloadPriority;
    public volatile DownloadRequest downloadRequest;
    public final int sequence;

    Downloader(DownloadRequest downloadRequest2) {
        this.downloadRequest = downloadRequest2;
        this.downloadPriority = downloadRequest2.getDownloadPriority();
        this.sequence = downloadRequest2.getSequence();
    }

    public void run() {
        GlobalComponent.getInstance().getLogger().log("DownloadTask", "开始下载任务");
        if (this.downloadRequest.getStatus() != DownloadStatus.RETRY) {
            this.downloadRequest.handlerStartEvent(this.downloadRequest.getDownloadMessage());
        }
        this.downloadRequest.setStatus(DownloadStatus.RUNNING);
        ILogger logger = GlobalComponent.getInstance().getLogger();
        logger.log("DownloadTask", "任务 " + this.downloadRequest.getDownloadId() + " 修改状态为 RUNNING");
        this.downloadMessage = this.downloadRequest.getDownloadMessage();
        this.databaseHelper = GlobalComponent.getInstance().getDatabaseHelper();
        SynchronizeAvailableDirectorPath.create(this.downloadRequest).run();
        String cacheDirectoryPath = this.downloadRequest.getCacheDirectoryPath();
        int cacheDirectorPathType = this.downloadRequest.getCacheDirectorPathType();
        DownloadMessage downloadMessage2 = this.downloadMessage;
        downloadMessage2.setSaveFilePath(cacheDirectoryPath + this.downloadMessage.getSaveFileName());
        ILogger logger2 = GlobalComponent.getInstance().getLogger();
        logger2.log("DownloadTask", "cacheDirectoryPath： " + cacheDirectoryPath + " cacheDirectorPathType： " + cacheDirectorPathType);
        DownloadResponse run = DownloadTask.create(this.downloadRequest, this.downloadMessage, this.databaseHelper).run();
        if (run.isSuccessful()) {
            if (run.getFrom() == 1) {
                this.downloadMessage.setFrom(1);
            }
            this.downloadRequest.handlerSuccessEvent(this.downloadMessage);
        } else if (run.getError() != null) {
            this.downloadRequest.handlerErrorEvent(this.downloadMessage, run.getError());
        } else if (run.isCancelled()) {
            this.downloadRequest.handlerCancelEvent(this.downloadMessage);
        }
    }
}
