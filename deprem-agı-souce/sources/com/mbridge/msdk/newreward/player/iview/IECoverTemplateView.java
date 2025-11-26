package com.mbridge.msdk.newreward.player.iview;

import android.graphics.Bitmap;

public interface IECoverTemplateView extends IPlayTempleView {
    void setCtaBtn(String str);

    void setDesc(String str);

    void setIconImageView(Bitmap bitmap);

    void setTitle(String str);
}
