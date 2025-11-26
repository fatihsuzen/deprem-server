package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.Updates;
import kotlin.jvm.internal.I;

public final /* synthetic */ class X implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f14811a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Updates f14812b;

    public /* synthetic */ X(I i5, Updates updates) {
        this.f14811a = i5;
        this.f14812b = updates;
    }

    public final void onClick(View view) {
        Updates.j.l(this.f14811a, this.f14812b, view);
    }
}
