package com.mbridge.msdk.foundation.download;

public enum DownloadResourceType {
    DOWNLOAD_RESOURCE_TYPE_VIDEO(0),
    DOWNLOAD_RESOURCE_TYPE_ZIP(1),
    DOWNLOAD_RESOURCE_TYPE_IMAGE(2),
    DOWNLOAD_RESOURCE_TYPE_HTML(3),
    DOWNLOAD_RESOURCE_TYPE_OTHER(4),
    DOWNLOAD_RESOURCE_TYPE_APK(5);
    
    public int resourceType;

    private DownloadResourceType(int i5) {
        this.resourceType = i5;
    }

    public static DownloadResourceType getDownloadResourceType(int i5) {
        if (i5 == 0) {
            return DOWNLOAD_RESOURCE_TYPE_VIDEO;
        }
        if (i5 == 1) {
            return DOWNLOAD_RESOURCE_TYPE_ZIP;
        }
        if (i5 == 2) {
            return DOWNLOAD_RESOURCE_TYPE_IMAGE;
        }
        if (i5 == 3) {
            return DOWNLOAD_RESOURCE_TYPE_HTML;
        }
        if (i5 == 4) {
            return DOWNLOAD_RESOURCE_TYPE_OTHER;
        }
        if (i5 != 5) {
            return null;
        }
        return DOWNLOAD_RESOURCE_TYPE_APK;
    }
}
