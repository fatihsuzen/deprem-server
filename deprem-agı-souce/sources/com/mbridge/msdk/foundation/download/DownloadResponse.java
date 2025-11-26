package com.mbridge.msdk.foundation.download;

import com.mbridge.msdk.foundation.download.utils.Objects;

public class DownloadResponse {
    private static final String UN_KNOWN = "unknown";
    private DownloadError _error;
    private boolean _isCancelled;
    private boolean _isSuccessful;
    private int from = 0;
    private boolean isFailed;
    private boolean isResponseStart;
    private boolean isTimeout;

    public DownloadError getError() {
        return this._error;
    }

    public String getErrorMessage() {
        if (Objects.isNull(getError()) || Objects.isNull(getError().getException())) {
            return "unknown";
        }
        return getError().getException().getMessage();
    }

    public int getFrom() {
        return this.from;
    }

    public boolean isCancelled() {
        return this._isCancelled;
    }

    public boolean isFailed() {
        return this.isFailed;
    }

    public boolean isResponseStart() {
        return this.isResponseStart;
    }

    public boolean isSuccessful() {
        return this._isSuccessful;
    }

    public boolean isTimeout() {
        return this.isTimeout;
    }

    public void setCancelled(boolean z4) {
        this._isCancelled = z4;
    }

    public void setError(DownloadError downloadError) {
        this._error = downloadError;
        setSuccessful(false);
    }

    public void setFailed(boolean z4) {
        this.isFailed = z4;
    }

    public void setFrom(int i5) {
        this.from = i5;
    }

    public void setResponseStart(boolean z4) {
        this.isResponseStart = z4;
    }

    public void setSuccessful(boolean z4) {
        this._isSuccessful = z4;
    }

    public void setTimeout(boolean z4) {
        this.isTimeout = z4;
    }

    public void setError(Exception exc) {
        setError(new DownloadError(exc));
    }
}
