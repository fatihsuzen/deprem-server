package com.mbridge.msdk.out;

import java.util.List;

public class NativeListener {

    public interface FilpListener {
        void filpEvent(int i5);
    }

    public interface NativeAdListener {
        void onAdClick(Campaign campaign);

        void onAdFramesLoaded(List<Frame> list);

        void onAdLoadError(String str);

        void onAdLoaded(List<Campaign> list, int i5);

        void onLoggingImpression(int i5);
    }

    public interface NativeTrackingListener extends BaseTrackingListener {
        void onDismissLoading(Campaign campaign);

        void onDownloadFinish(Campaign campaign);

        void onDownloadProgress(int i5);

        void onDownloadStart(Campaign campaign);

        boolean onInterceptDefaultLoadingDialog();

        void onShowLoading(Campaign campaign);
    }

    public static class Template {
        private int adNum;
        private int id;

        public Template(int i5, int i6) {
            this.id = i5;
            this.adNum = i6;
        }

        public int getAdNum() {
            return this.adNum;
        }

        public int getId() {
            return this.id;
        }

        public void setAdNum(int i5) {
            this.adNum = i5;
        }

        public void setId(int i5) {
            this.id = i5;
        }
    }

    public interface TrackingExListener extends NativeTrackingListener {
        void onLeaveApp();
    }
}
