package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.Updates;
import kotlin.jvm.internal.I;

public final /* synthetic */ class Q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f14420a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Updates f14421b;

    public /* synthetic */ Q(I i5, Updates updates) {
        this.f14420a = i5;
        this.f14421b = updates;
    }

    public final void onClick(View view) {
        Updates.b.l(this.f14420a, this.f14421b, view);
    }
}
