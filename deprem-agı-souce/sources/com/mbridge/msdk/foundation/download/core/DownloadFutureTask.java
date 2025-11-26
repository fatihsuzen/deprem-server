package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadPriority;
import java.util.concurrent.FutureTask;

public class DownloadFutureTask extends FutureTask<Downloader> implements Comparable<DownloadFutureTask> {
    private final Downloader downloader;

    DownloadFutureTask(Downloader downloader2) {
        super(downloader2, (Object) null);
        this.downloader = downloader2;
    }

    public int compareTo(DownloadFutureTask downloadFutureTask) {
        Downloader downloader2 = this.downloader;
        DownloadPriority downloadPriority = downloader2.downloadPriority;
        Downloader downloader3 = downloadFutureTask.downloader;
        DownloadPriority downloadPriority2 = downloader3.downloadPriority;
        return downloadPriority == downloadPriority2 ? downloader2.sequence - downloader3.sequence : downloadPriority2.ordinal() - downloadPriority.ordinal();
    }
}
