package com.google.android.material.sidesheet;

import android.view.View;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SheetDialog f7102a;

    public /* synthetic */ a(SheetDialog sheetDialog) {
        this.f7102a = sheetDialog;
    }

    public final void onClick(View view) {
        SheetDialog.b(this.f7102a, view);
    }
}
