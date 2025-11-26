package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.Updates;
import kotlin.jvm.internal.I;

public final /* synthetic */ class P implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f14302a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Updates f14303b;

    public /* synthetic */ P(I i5, Updates updates) {
        this.f14302a = i5;
        this.f14303b = updates;
    }

    public final void onClick(View view) {
        Updates.b.j(this.f14302a, this.f14303b, view);
    }
}
