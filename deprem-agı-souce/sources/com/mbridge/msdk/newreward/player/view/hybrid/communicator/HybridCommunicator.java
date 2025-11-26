package com.mbridge.msdk.newreward.player.view.hybrid.communicator;

import android.webkit.WebView;

public interface HybridCommunicator {
    void appendSubView(CommunicatorParameter communicatorParameter);

    void appendViewTo(CommunicatorParameter communicatorParameter);

    void bringViewToFront(CommunicatorParameter communicatorParameter);

    void broadcast(CommunicatorParameter communicatorParameter);

    void cai(CommunicatorParameter communicatorParameter);

    void callFailure(WebView webView, String str, String str2);

    void callNotSupportMethod(CommunicatorParameter communicatorParameter);

    void callSuccess(WebView webView, String str, String str2);

    void clearAllCache(CommunicatorParameter communicatorParameter);

    void click(CommunicatorParameter communicatorParameter);

    void close(CommunicatorParameter communicatorParameter);

    void closeAd(CommunicatorParameter communicatorParameter);

    void closeVideoOperte(CommunicatorParameter communicatorParameter);

    void closeWeb(CommunicatorParameter communicatorParameter);

    void createNativeEC(CommunicatorParameter communicatorParameter);

    void createPlayerView(CommunicatorParameter communicatorParameter);

    void createSubPlayTemplateView(CommunicatorParameter communicatorParameter);

    void createView(CommunicatorParameter communicatorParameter);

    void createWebview(CommunicatorParameter communicatorParameter);

    void destroyComponent(CommunicatorParameter communicatorParameter);

    void expand(CommunicatorParameter communicatorParameter);

    void feedbackLayoutOperate(CommunicatorParameter communicatorParameter);

    void feedbackOperate(CommunicatorParameter communicatorParameter);

    void feedbackPopupOperate(CommunicatorParameter communicatorParameter);

    void fireEvent(WebView webView, String str, String str2);

    void getAllCache(CommunicatorParameter communicatorParameter);

    void getAppSetting(CommunicatorParameter communicatorParameter);

    void getComponentOptions(CommunicatorParameter communicatorParameter);

    void getCurrentProgress(CommunicatorParameter communicatorParameter);

    void getCutout(CommunicatorParameter communicatorParameter);

    void getEncryptPrice(CommunicatorParameter communicatorParameter);

    void getEndScreenInfo(CommunicatorParameter communicatorParameter);

    void getFileInfo(CommunicatorParameter communicatorParameter);

    void getNetstat(CommunicatorParameter communicatorParameter);

    void getRewardSetting(CommunicatorParameter communicatorParameter);

    void getRewardUnitSetting(CommunicatorParameter communicatorParameter);

    void getSDKInfo(CommunicatorParameter communicatorParameter);

    void getUnitSetting(CommunicatorParameter communicatorParameter);

    void gial(CommunicatorParameter communicatorParameter);

    void handleNativeObject(CommunicatorParameter communicatorParameter);

    void handlerH5Exception(CommunicatorParameter communicatorParameter);

    void handlerPlayableException(CommunicatorParameter communicatorParameter);

    void hideView(CommunicatorParameter communicatorParameter);

    void increaseOfferFrequence(CommunicatorParameter communicatorParameter);

    void init(CommunicatorParameter communicatorParameter);

    void insertViewAbove(CommunicatorParameter communicatorParameter);

    void insertViewBelow(CommunicatorParameter communicatorParameter);

    void install(CommunicatorParameter communicatorParameter);

    void isSystemResume(CommunicatorParameter communicatorParameter);

    void ivRewardAdsWithoutVideo(CommunicatorParameter communicatorParameter);

    void loadads(CommunicatorParameter communicatorParameter);

    void loadingResourceStatus(CommunicatorParameter communicatorParameter);

    void notifyCloseBtn(CommunicatorParameter communicatorParameter);

    void onJSBridgeConnect(CommunicatorParameter communicatorParameter);

    void onSignalCommunicationConnected(WebView webView);

    void onlyAppendSubView(CommunicatorParameter communicatorParameter);

    void onlyAppendViewTo(CommunicatorParameter communicatorParameter);

    void onlyInsertViewAbove(CommunicatorParameter communicatorParameter);

    void onlyInsertViewBelow(CommunicatorParameter communicatorParameter);

    void open(CommunicatorParameter communicatorParameter);

    void openURL(CommunicatorParameter communicatorParameter);

    void playVideoFinishOperate(CommunicatorParameter communicatorParameter);

    void playerGetMuteState(CommunicatorParameter communicatorParameter);

    void playerMute(CommunicatorParameter communicatorParameter);

    void playerPause(CommunicatorParameter communicatorParameter);

    void playerPlay(CommunicatorParameter communicatorParameter);

    void playerResume(CommunicatorParameter communicatorParameter);

    void playerSetRenderType(CommunicatorParameter communicatorParameter);

    void playerSetSource(CommunicatorParameter communicatorParameter);

    void playerStop(CommunicatorParameter communicatorParameter);

    void playerUnmute(CommunicatorParameter communicatorParameter);

    void playerUpdateFrame(CommunicatorParameter communicatorParameter);

    void preloadSubPlayTemplateView(CommunicatorParameter communicatorParameter);

    void progressBarOperate(CommunicatorParameter communicatorParameter);

    void progressOperate(CommunicatorParameter communicatorParameter);

    void reactDeveloper(CommunicatorParameter communicatorParameter);

    void readyStatus(CommunicatorParameter communicatorParameter);

    void removeCacheItem(CommunicatorParameter communicatorParameter);

    void removeFromSuperView(CommunicatorParameter communicatorParameter);

    void reportData(CommunicatorParameter communicatorParameter);

    void reportUrls(CommunicatorParameter communicatorParameter);

    void resetCountdown(CommunicatorParameter communicatorParameter);

    void sendImpressions(CommunicatorParameter communicatorParameter);

    void sendNotchData(WebView webView, String str);

    void setCacheItem(CommunicatorParameter communicatorParameter);

    void setOrientation(CommunicatorParameter communicatorParameter);

    void setOrientationProperties(CommunicatorParameter communicatorParameter);

    void setScaleFitXY(CommunicatorParameter communicatorParameter);

    void setSubPlayTemplateInfo(CommunicatorParameter communicatorParameter);

    void setViewAlpha(CommunicatorParameter communicatorParameter);

    void setViewBgColor(CommunicatorParameter communicatorParameter);

    void setViewRect(CommunicatorParameter communicatorParameter);

    void setViewScale(CommunicatorParameter communicatorParameter);

    void showAlertView(CommunicatorParameter communicatorParameter);

    void showVideoClickView(CommunicatorParameter communicatorParameter);

    void showVideoLocation(CommunicatorParameter communicatorParameter);

    void showView(CommunicatorParameter communicatorParameter);

    void soundOperate(CommunicatorParameter communicatorParameter);

    void statistics(CommunicatorParameter communicatorParameter);

    void toggleCloseBtn(CommunicatorParameter communicatorParameter);

    void triggerCloseBtn(CommunicatorParameter communicatorParameter);

    void unload(CommunicatorParameter communicatorParameter);

    void useCustomClose(CommunicatorParameter communicatorParameter);

    void videoOperate(CommunicatorParameter communicatorParameter);

    void webViewShow(WebView webView, String str);

    void webviewFireEvent(CommunicatorParameter communicatorParameter);

    void webviewGoBack(CommunicatorParameter communicatorParameter);

    void webviewGoForward(CommunicatorParameter communicatorParameter);

    void webviewLoad(CommunicatorParameter communicatorParameter);

    void webviewReload(CommunicatorParameter communicatorParameter);
}
