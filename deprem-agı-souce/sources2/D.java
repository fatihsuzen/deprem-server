package com.finazzi.distquake;

import android.view.View;
import com.finazzi.distquake.ChatPreviewActivity;

public final /* synthetic */ class D implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatPreviewActivity.b f12803a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f12804b;

    public /* synthetic */ D(ChatPreviewActivity.b bVar, int i8) {
        this.f12803a = bVar;
        this.f12804b = i8;
    }

    public final void onClick(View view) {
        ChatPreviewActivity.b.b(this.f12803a, this.f12804b, view);
    }
}
