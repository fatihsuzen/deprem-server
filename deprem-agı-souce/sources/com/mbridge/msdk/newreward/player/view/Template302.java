package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import androidx.annotation.NonNull;
import com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter;

public class Template302 extends BaseTemplate {
    public Template302(@NonNull Context context) {
        super(context);
        PlayTemplePresenter playTemplePresenter = new PlayTemplePresenter(this);
        this.presenter = playTemplePresenter;
        playTemplePresenter.getView();
    }
}
