package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.PublicProfileActivity;
import kotlin.jvm.internal.L;
import l2.V;

public final /* synthetic */ class D implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f13683a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ V f13684b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f13685c;

    public /* synthetic */ D(L l5, V v5, PublicProfileActivity publicProfileActivity) {
        this.f13683a = l5;
        this.f13684b = v5;
        this.f13685c = publicProfileActivity;
    }

    public final void onClick(View view) {
        PublicProfileActivity.a.C0132a.g(this.f13683a, this.f13684b, this.f13685c, view);
    }
}
