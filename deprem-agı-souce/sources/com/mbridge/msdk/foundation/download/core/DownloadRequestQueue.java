package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadRequestQueue<T> {
    private static final String TAG = "DownloadRequestQueue";
    private final ConcurrentHashMap<String, DownloadRequest<T>> currentRequestMap;
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<DownloadRequest<T>>> delayRequestMap;
    private final AtomicInteger sequenceGenerator;

    private static final class ClassHolder {
        /* access modifiers changed from: private */
        public static final DownloadRequestQueue DOWNLOAD_REQUEST_QUEUE = new DownloadRequestQueue();

        private ClassHolder() {
        }
    }

    private void cancelAndRemoveFromMap(DownloadRequest downloadRequest, String str) {
        if (downloadRequest != null) {
            downloadRequest.cancel(downloadRequest.getDownloadMessage());
        }
    }

    public static DownloadRequestQueue getInstance() {
        return ClassHolder.DOWNLOAD_REQUEST_QUEUE;
    }

    private int getSequenceNumber() {
        return this.sequenceGenerator.incrementAndGet();
    }

    public synchronized void addRequest(DownloadRequest<T> downloadRequest) {
        try {
            String downloadId = downloadRequest.getDownloadId();
            downloadRequest.setSequence(getSequenceNumber());
            if (this.currentRequestMap.containsKey(downloadId)) {
                DownloadStatus status = downloadRequest.getStatus();
                DownloadStatus downloadStatus = DownloadStatus.RETRY;
                if (status != downloadStatus) {
                    downloadStatus = DownloadStatus.DELAY;
                }
                downloadRequest.setStatus(downloadStatus);
                if (this.delayRequestMap.containsKey(downloadId)) {
                    CopyOnWriteArrayList copyOnWriteArrayList = this.delayRequestMap.get(downloadId);
                    if (copyOnWriteArrayList != null) {
                        copyOnWriteArrayList.add(downloadRequest);
                        this.delayRequestMap.remove(downloadId);
                        this.delayRequestMap.put(downloadId, copyOnWriteArrayList);
                    }
                } else {
                    CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                    copyOnWriteArrayList2.add(downloadRequest);
                    this.delayRequestMap.put(downloadId, copyOnWriteArrayList2);
                }
            } else {
                DownloadStatus status2 = downloadRequest.getStatus();
                DownloadStatus downloadStatus2 = DownloadStatus.RETRY;
                if (status2 != downloadStatus2) {
                    downloadStatus2 = DownloadStatus.QUEUED;
                }
                downloadRequest.setStatus(downloadStatus2);
                this.currentRequestMap.put(downloadId, downloadRequest);
                downloadRequest.setFuture(ExecutorManager.getInstance().getExecutorSupplier().getDownloadTasks().submit(new Downloader(downloadRequest)));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void cancel(String str) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        try {
            if (!TextUtils.isEmpty(str) && this.delayRequestMap.containsKey(str) && (copyOnWriteArrayList = this.delayRequestMap.get(str)) != null && copyOnWriteArrayList.size() > 0) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    DownloadRequest downloadRequest = (DownloadRequest) it.next();
                    copyOnWriteArrayList.remove(downloadRequest);
                    downloadRequest.handlerCancelEvent(downloadRequest.getDownloadMessage());
                }
                if (copyOnWriteArrayList.size() > 0) {
                    this.delayRequestMap.remove(str);
                    this.delayRequestMap.put(str, copyOnWriteArrayList);
                } else {
                    this.delayRequestMap.remove(str);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                cancelAndRemoveFromMap(this.currentRequestMap.get(str), str);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void cancelAll() {
        try {
            for (Map.Entry<String, CopyOnWriteArrayList<DownloadRequest<T>>> value : this.delayRequestMap.entrySet()) {
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) value.getValue();
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        DownloadRequest downloadRequest = (DownloadRequest) it.next();
                        if (downloadRequest != null) {
                            downloadRequest.handlerCancelEvent(downloadRequest.getDownloadMessage());
                        }
                    }
                }
            }
            this.delayRequestMap.clear();
            for (Map.Entry<String, DownloadRequest<T>> value2 : this.currentRequestMap.entrySet()) {
                DownloadRequest downloadRequest2 = (DownloadRequest) value2.getValue();
                cancelAndRemoveFromMap(downloadRequest2, downloadRequest2.getDownloadId());
            }
        } finally {
            while (true) {
            }
        }
    }

    public synchronized void finish(DownloadRequest downloadRequest) {
        CopyOnWriteArrayList remove;
        String downloadId = downloadRequest.getDownloadId();
        this.currentRequestMap.remove(downloadId);
        if (this.delayRequestMap.containsKey(downloadId) && (remove = this.delayRequestMap.remove(downloadId)) != null && remove.size() > 0) {
            DownloadRequest downloadRequest2 = (DownloadRequest) remove.remove(0);
            downloadRequest2.setStatus(DownloadStatus.QUEUED);
            this.currentRequestMap.put(downloadId, downloadRequest2);
            downloadRequest2.setFuture(ExecutorManager.getInstance().getExecutorSupplier().getDownloadTasks().submit(new Downloader(downloadRequest2)));
            if (remove.size() > 0) {
                this.delayRequestMap.put(downloadId, remove);
            }
        }
    }

    public synchronized DownloadStatus getStatus(String str) {
        DownloadRequest downloadRequest = this.currentRequestMap.get(str);
        if (downloadRequest != null) {
            return downloadRequest.getStatus();
        }
        return DownloadStatus.UNKNOWN;
    }

    public void initialize() {
    }

    private DownloadRequestQueue() {
        this.currentRequestMap = new ConcurrentHashMap<>();
        this.sequenceGenerator = new AtomicInteger();
        this.delayRequestMap = new ConcurrentHashMap<>();
    }
}
