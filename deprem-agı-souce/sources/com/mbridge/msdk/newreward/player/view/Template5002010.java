package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter;

public class Template5002010 extends BaseTemplate {
    public Template5002010(@NonNull Context context) {
        super(context);
        PlayTemplePresenter playTemplePresenter = new PlayTemplePresenter(this);
        this.presenter = playTemplePresenter;
        playTemplePresenter.getView();
    }

    public Template5002010(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
