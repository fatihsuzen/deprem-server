package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter;

public class Template904 extends BaseTemplate {
    public Template904(@NonNull Context context) {
        super(context);
        PlayTemplePresenter playTemplePresenter = new PlayTemplePresenter(this);
        this.presenter = playTemplePresenter;
        playTemplePresenter.getView();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public Template904(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
