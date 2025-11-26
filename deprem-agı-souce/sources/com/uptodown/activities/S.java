package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.Updates;
import kotlin.jvm.internal.I;

public final /* synthetic */ class S implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f14511a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Updates f14512b;

    public /* synthetic */ S(I i5, Updates updates) {
        this.f14511a = i5;
        this.f14512b = updates;
    }

    public final void onClick(View view) {
        Updates.b.m(this.f14511a, this.f14512b, view);
    }
}
