package com.finazzi.distquake;

import android.content.DialogInterface;
import com.finazzi.distquake.ChatPreviewActivity;

public final /* synthetic */ class E implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatPreviewActivity.b f12805a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f12806b;

    public /* synthetic */ E(ChatPreviewActivity.b bVar, int i8) {
        this.f12805a = bVar;
        this.f12806b = i8;
    }

    public final void onClick(DialogInterface dialogInterface, int i8) {
        ChatPreviewActivity.b.c(this.f12805a, this.f12806b, dialogInterface, i8);
    }
}
