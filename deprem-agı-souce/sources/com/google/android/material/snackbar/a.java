package com.google.android.material.snackbar;

import android.view.View;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Snackbar f7116a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f7117b;

    public /* synthetic */ a(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.f7116a = snackbar;
        this.f7117b = onClickListener;
    }

    public final void onClick(View view) {
        Snackbar.a(this.f7116a, this.f7117b, view);
    }
}
