package com.mbridge.msdk.newreward.player.iview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public interface IECTempleView extends IBaseView {
    void addShakeView(View view);

    View getBaitClickView();

    ImageView getNoticeIV();

    IECTempleView getParentObject();

    void setBlurBackGround(Bitmap bitmap);

    void setCTAText(String str);

    void setCloseViewBtnDelayShow(int i5);

    void setHeatCount(int i5);

    void setImageBitMap(int i5, Bitmap bitmap);

    void setNLogo(int i5, String str, Drawable drawable);

    void setRatingAndUser(double d5, int i5);

    void setTextByID(int i5, String str);
}
