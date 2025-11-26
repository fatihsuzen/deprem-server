package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.Updates;

public final /* synthetic */ class U implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Updates f14571a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f14572b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14573c;

    public /* synthetic */ U(Updates updates, boolean z4, String str) {
        this.f14571a = updates;
        this.f14572b = z4;
        this.f14573c = str;
    }

    public final void onClick(View view) {
        Updates.c.e(this.f14571a, this.f14572b, this.f14573c, view);
    }
}
