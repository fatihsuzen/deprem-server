package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.Updates;

public final /* synthetic */ class V implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Updates f14772a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f14773b;

    public /* synthetic */ V(Updates updates, String str) {
        this.f14772a = updates;
        this.f14773b = str;
    }

    public final void onClick(View view) {
        Updates.c.f(this.f14772a, this.f14773b, view);
    }
}
