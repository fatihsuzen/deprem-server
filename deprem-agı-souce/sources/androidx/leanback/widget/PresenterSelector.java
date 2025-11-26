package androidx.leanback.widget;

import android.annotation.SuppressLint;

public abstract class PresenterSelector {
    public abstract Presenter getPresenter(Object obj);

    @SuppressLint({"NullableCollection"})
    public Presenter[] getPresenters() {
        return null;
    }
}
