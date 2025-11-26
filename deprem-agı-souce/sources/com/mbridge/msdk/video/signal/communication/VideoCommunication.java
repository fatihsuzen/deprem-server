package com.mbridge.msdk.video.signal.communication;

import android.os.Handler;
import android.os.Looper;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;

public class VideoCommunication extends BaseVideoCommunication {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f12708g = 0;

    /* renamed from: e  reason: collision with root package name */
    private Handler f12709e = new Handler(Looper.getMainLooper());

    public void appendSubView(final Object obj, final String str) {
        if (ak.g()) {
            super.appendSubView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.appendSubView(obj, str);
                }
            });
        }
    }

    public void appendViewTo(final Object obj, final String str) {
        if (ak.g()) {
            super.appendViewTo(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.appendViewTo(obj, str);
                }
            });
        }
    }

    public void bringViewToFront(final Object obj, final String str) {
        if (ak.g()) {
            super.bringViewToFront(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.bringViewToFront(obj, str);
                }
            });
        }
    }

    public void broadcast(final Object obj, final String str) {
        if (ak.g()) {
            super.broadcast(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.broadcast(obj, str);
                }
            });
        }
    }

    public void clearAllCache(final Object obj, final String str) {
        if (ak.g()) {
            super.clearAllCache(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.clearAllCache(obj, str);
                }
            });
        }
    }

    public void click(final Object obj, final String str) {
        if (ak.g()) {
            super.click(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.click(obj, str);
                }
            });
        }
    }

    public void closeAd(final Object obj, final String str) {
        if (ak.g()) {
            super.closeAd(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.closeAd(obj, str);
                }
            });
        }
    }

    public void closeVideoOperte(final Object obj, final String str) {
        if (ak.g()) {
            super.closeVideoOperte(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.closeVideoOperte(obj, str);
                }
            });
        }
    }

    public void closeWeb(final Object obj, final String str) {
        if (ak.g()) {
            super.closeWeb(obj, str);
            return;
        }
        this.f12709e.post(new Runnable() {
            public final void run() {
                VideoCommunication.super.closeWeb(obj, str);
            }
        });
        af.b("JS-Video-Brigde", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY + str);
    }

    public void createNativeEC(final Object obj, final String str) {
        if (ak.g()) {
            super.createNativeEC(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.createNativeEC(obj, str);
                }
            });
        }
    }

    public void createPlayerView(final Object obj, final String str) {
        if (ak.g()) {
            super.createPlayerView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.createPlayerView(obj, str);
                }
            });
        }
    }

    public void createSubPlayTemplateView(final Object obj, final String str) {
        if (ak.g()) {
            super.createSubPlayTemplateView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.createSubPlayTemplateView(obj, str);
                }
            });
        }
    }

    public void createView(final Object obj, final String str) {
        if (ak.g()) {
            super.createView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.createView(obj, str);
                }
            });
        }
    }

    public void createWebview(final Object obj, final String str) {
        if (ak.g()) {
            super.createWebview(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.createWebview(obj, str);
                }
            });
        }
    }

    public void destroyComponent(final Object obj, final String str) {
        if (ak.g()) {
            super.destroyComponent(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.destroyComponent(obj, str);
                }
            });
        }
    }

    public void getAllCache(final Object obj, final String str) {
        if (ak.g()) {
            super.getAllCache(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getAllCache(obj, str);
                }
            });
        }
    }

    public void getAppSetting(final Object obj, final String str) {
        if (ak.g()) {
            super.getAppSetting(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getAppSetting(obj, str);
                }
            });
        }
    }

    public void getComponentOptions(final Object obj, final String str) {
        if (ak.g()) {
            super.getComponentOptions(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getComponentOptions(obj, str);
                }
            });
        }
    }

    public void getCurrentProgress(final Object obj, final String str) {
        if (ak.g()) {
            super.getCurrentProgress(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getCurrentProgress(obj, str);
                }
            });
        }
    }

    public void getCutout(final Object obj, final String str) {
        if (ak.g()) {
            super.getCutout(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getCutout(obj, str);
                }
            });
        }
    }

    public void getEncryptPrice(final Object obj, final String str) {
        if (ak.g()) {
            super.getEncryptPrice(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getEncryptPrice(obj, str);
                }
            });
        }
    }

    public void getFileInfo(final Object obj, final String str) {
        if (ak.g()) {
            super.getFileInfo(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getFileInfo(obj, str);
                }
            });
        }
    }

    public void getRewardSetting(final Object obj, final String str) {
        if (ak.g()) {
            super.getRewardSetting(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getRewardSetting(obj, str);
                }
            });
        }
    }

    public void getRewardUnitSetting(final Object obj, final String str) {
        if (ak.g()) {
            super.getRewardUnitSetting(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getRewardUnitSetting(obj, str);
                }
            });
        }
    }

    public void getSDKInfo(final Object obj, final String str) {
        if (ak.g()) {
            super.getSDKInfo(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getSDKInfo(obj, str);
                }
            });
        }
    }

    public void getUnitSetting(final Object obj, final String str) {
        if (ak.g()) {
            super.getUnitSetting(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getUnitSetting(obj, str);
                }
            });
        }
    }

    public void handleNativeObject(final Object obj, final String str) {
        if (ak.g()) {
            super.handleNativeObject(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.handleNativeObject(obj, str);
                }
            });
        }
    }

    public void handlerH5Exception(final Object obj, final String str) {
        if (ak.g()) {
            super.handlerH5Exception(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.handlerH5Exception(obj, str);
                }
            });
        }
    }

    public void hideView(final Object obj, final String str) {
        if (ak.g()) {
            super.hideView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.hideView(obj, str);
                }
            });
        }
    }

    public void increaseOfferFrequence(final Object obj, final String str) {
        if (ak.g()) {
            super.increaseOfferFrequence(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.increaseOfferFrequence(obj, str);
                }
            });
        }
    }

    public void init(final Object obj, final String str) {
        if (ak.g()) {
            super.init(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.init(obj, str);
                }
            });
        }
    }

    public void insertViewAbove(final Object obj, final String str) {
        if (ak.g()) {
            super.insertViewAbove(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.insertViewAbove(obj, str);
                }
            });
        }
    }

    public void insertViewBelow(final Object obj, final String str) {
        if (ak.g()) {
            super.insertViewBelow(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.insertViewBelow(obj, str);
                }
            });
        }
    }

    public void isSystemResume(final Object obj, final String str) {
        if (ak.g()) {
            super.isSystemResume(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.isSystemResume(obj, str);
                }
            });
        }
    }

    public void ivRewardAdsWithoutVideo(final Object obj, final String str) {
        if (ak.g()) {
            super.ivRewardAdsWithoutVideo(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.ivRewardAdsWithoutVideo(obj, str);
                }
            });
        }
    }

    public void loadads(final Object obj, final String str) {
        if (ak.g()) {
            super.loadads(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.loadads(obj, str);
                }
            });
        }
    }

    public void loadingResourceStatus(final Object obj, final String str) {
        if (ak.g()) {
            super.loadingResourceStatus(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.loadingResourceStatus(obj, str);
                }
            });
        }
    }

    public void notifyCloseBtn(final Object obj, final String str) {
        if (ak.g()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.notifyCloseBtn(obj, str);
                }
            });
        }
    }

    public void onlyAppendSubView(final Object obj, final String str) {
        if (ak.g()) {
            super.onlyAppendSubView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.onlyAppendSubView(obj, str);
                }
            });
        }
    }

    public void onlyAppendViewTo(final Object obj, final String str) {
        if (ak.g()) {
            super.onlyAppendViewTo(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.onlyAppendViewTo(obj, str);
                }
            });
        }
    }

    public void onlyInsertViewAbove(final Object obj, final String str) {
        if (ak.g()) {
            super.onlyInsertViewAbove(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.onlyInsertViewAbove(obj, str);
                }
            });
        }
    }

    public void onlyInsertViewBelow(final Object obj, final String str) {
        if (ak.g()) {
            super.onlyInsertViewBelow(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.onlyInsertViewBelow(obj, str);
                }
            });
        }
    }

    public void openURL(final Object obj, final String str) {
        if (ak.g()) {
            super.openURL(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.openURL(obj, str);
                }
            });
        }
    }

    public void playVideoFinishOperate(final Object obj, final String str) {
        if (ak.g()) {
            super.playVideoFinishOperate(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playVideoFinishOperate(obj, str);
                }
            });
        }
    }

    public void playerGetMuteState(final Object obj, final String str) {
        if (ak.g()) {
            super.playerGetMuteState(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerGetMuteState(obj, str);
                }
            });
        }
    }

    public void playerMute(final Object obj, final String str) {
        if (ak.g()) {
            super.playerMute(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerMute(obj, str);
                }
            });
        }
    }

    public void playerPause(final Object obj, final String str) {
        if (ak.g()) {
            super.playerPause(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerPause(obj, str);
                }
            });
        }
    }

    public void playerPlay(final Object obj, final String str) {
        if (ak.g()) {
            super.playerPlay(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerPlay(obj, str);
                }
            });
        }
    }

    public void playerResume(final Object obj, final String str) {
        if (ak.g()) {
            super.playerResume(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerResume(obj, str);
                }
            });
        }
    }

    public void playerSetRenderType(final Object obj, final String str) {
        if (ak.g()) {
            super.playerSetRenderType(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerSetRenderType(obj, str);
                }
            });
        }
    }

    public void playerSetSource(final Object obj, final String str) {
        if (ak.g()) {
            super.playerSetSource(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerSetSource(obj, str);
                }
            });
        }
    }

    public void playerStop(final Object obj, final String str) {
        if (ak.g()) {
            super.playerStop(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerStop(obj, str);
                }
            });
        }
    }

    public void playerUnmute(final Object obj, final String str) {
        if (ak.g()) {
            super.playerUnmute(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerUnmute(obj, str);
                }
            });
        }
    }

    public void playerUpdateFrame(final Object obj, final String str) {
        if (ak.g()) {
            super.playerUpdateFrame(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerUpdateFrame(obj, str);
                }
            });
        }
    }

    public void preloadSubPlayTemplateView(final Object obj, final String str) {
        if (ak.g()) {
            super.preloadSubPlayTemplateView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.preloadSubPlayTemplateView(obj, str);
                }
            });
        }
    }

    public void progressBarOperate(final Object obj, final String str) {
        if (ak.g()) {
            super.progressBarOperate(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.progressBarOperate(obj, str);
                }
            });
        }
    }

    public void progressOperate(final Object obj, final String str) {
        if (ak.g()) {
            super.progressOperate(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.progressOperate(obj, str);
                }
            });
        }
    }

    public void reactDeveloper(final Object obj, final String str) {
        if (ak.g()) {
            super.reactDeveloper(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.reactDeveloper(obj, str);
                }
            });
        }
    }

    public void readyStatus(final Object obj, final String str) {
        af.c("JS-Video-Brigde", "VIDEOBridge readyStatus");
        if (ak.g()) {
            super.readyStatus(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.readyStatus(obj, str);
                }
            });
        }
    }

    public void removeCacheItem(final Object obj, final String str) {
        if (ak.g()) {
            super.removeCacheItem(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.removeCacheItem(obj, str);
                }
            });
        }
    }

    public void removeFromSuperView(final Object obj, final String str) {
        if (ak.g()) {
            super.removeFromSuperView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.removeFromSuperView(obj, str);
                }
            });
        }
    }

    public void reportUrls(final Object obj, final String str) {
        if (ak.g()) {
            super.reportUrls(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.reportUrls(obj, str);
                }
            });
        }
    }

    public void setCacheItem(final Object obj, final String str) {
        if (ak.g()) {
            super.setCacheItem(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setCacheItem(obj, str);
                }
            });
        }
    }

    public void setScaleFitXY(final Object obj, final String str) {
        if (ak.g()) {
            super.setScaleFitXY(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setScaleFitXY(obj, str);
                }
            });
        }
    }

    public void setSubPlayTemplateInfo(final Object obj, final String str) {
        if (ak.g()) {
            super.setSubPlayTemplateInfo(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setSubPlayTemplateInfo(obj, str);
                }
            });
        }
    }

    public void setViewAlpha(final Object obj, final String str) {
        if (ak.g()) {
            super.setViewAlpha(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setViewAlpha(obj, str);
                }
            });
        }
    }

    public void setViewBgColor(final Object obj, final String str) {
        if (ak.g()) {
            super.setViewBgColor(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setViewBgColor(obj, str);
                }
            });
        }
    }

    public void setViewRect(final Object obj, final String str) {
        if (ak.g()) {
            super.setViewRect(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setViewRect(obj, str);
                }
            });
        }
    }

    public void setViewScale(final Object obj, final String str) {
        if (ak.g()) {
            super.setViewScale(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setViewScale(obj, str);
                }
            });
        }
    }

    public void showAlertView(final Object obj, final String str) {
        if (ak.g()) {
            super.showAlertView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.showAlertView(obj, str);
                }
            });
        }
    }

    public void showVideoClickView(final Object obj, final String str) {
        if (ak.g()) {
            super.showVideoClickView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.showVideoClickView(obj, str);
                }
            });
        }
    }

    public void showVideoLocation(final Object obj, final String str) {
        if (ak.g()) {
            super.showVideoLocation(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.showVideoLocation(obj, str);
                }
            });
        }
    }

    public void showView(final Object obj, final String str) {
        if (ak.g()) {
            super.showView(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.showView(obj, str);
                }
            });
        }
    }

    public void soundOperate(final Object obj, final String str) {
        if (ak.g()) {
            super.soundOperate(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.soundOperate(obj, str);
                }
            });
        }
    }

    public void statistics(final Object obj, final String str) {
        if (ak.g()) {
            super.statistics(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.statistics(obj, str);
                }
            });
        }
    }

    public void toggleCloseBtn(final Object obj, final String str) {
        if (ak.g()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.toggleCloseBtn(obj, str);
                }
            });
        }
    }

    public void triggerCloseBtn(final Object obj, final String str) {
        if (ak.g()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.triggerCloseBtn(obj, str);
                }
            });
        }
    }

    public void videoOperate(final Object obj, final String str) {
        if (ak.g()) {
            super.videoOperate(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.videoOperate(obj, str);
                }
            });
        }
    }

    public void webviewFireEvent(final Object obj, final String str) {
        if (ak.g()) {
            super.webviewFireEvent(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.webviewFireEvent(obj, str);
                }
            });
        }
    }

    public void webviewGoBack(final Object obj, final String str) {
        if (ak.g()) {
            super.webviewGoBack(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.webviewGoBack(obj, str);
                }
            });
        }
    }

    public void webviewGoForward(final Object obj, final String str) {
        if (ak.g()) {
            super.webviewGoForward(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.webviewGoForward(obj, str);
                }
            });
        }
    }

    public void webviewLoad(final Object obj, final String str) {
        if (ak.g()) {
            super.webviewLoad(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.webviewLoad(obj, str);
                }
            });
        }
    }

    public void webviewReload(final Object obj, final String str) {
        if (ak.g()) {
            super.webviewReload(obj, str);
        } else {
            this.f12709e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.webviewReload(obj, str);
                }
            });
        }
    }
}
