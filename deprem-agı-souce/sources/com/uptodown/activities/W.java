package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.Updates;
import kotlin.jvm.internal.I;

public final /* synthetic */ class W implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f14784a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Updates f14785b;

    public /* synthetic */ W(I i5, Updates updates) {
        this.f14784a = i5;
        this.f14785b = updates;
    }

    public final void onClick(View view) {
        Updates.j.j(this.f14784a, this.f14785b, view);
    }
}
