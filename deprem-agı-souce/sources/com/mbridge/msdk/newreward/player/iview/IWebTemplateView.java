package com.mbridge.msdk.newreward.player.iview;

import org.json.JSONObject;

public interface IWebTemplateView extends IBaseWebView, IPlayTempleView {
    void changeVideoViewPosition(JSONObject jSONObject);

    void playOrPauseVideo(int i5);

    void seekToPlay(int i5);

    void setMuteState(int i5, int i6);
}
