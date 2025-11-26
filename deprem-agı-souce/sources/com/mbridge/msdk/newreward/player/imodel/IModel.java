package com.mbridge.msdk.newreward.player.imodel;

import com.mbridge.msdk.newreward.player.redirect.RedirectModel;

public interface IModel {
    boolean eventClickUrl(RedirectModel redirectModel);

    void eventNoticeUrl(RedirectModel redirectModel, int i5);
}
