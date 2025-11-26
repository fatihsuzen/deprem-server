package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.Updates;
import java.util.ArrayList;
import kotlin.jvm.internal.I;

public final /* synthetic */ class Y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f14813a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f14814b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Updates f14815c;

    public /* synthetic */ Y(I i5, ArrayList arrayList, Updates updates) {
        this.f14813a = i5;
        this.f14814b = arrayList;
        this.f14815c = updates;
    }

    public final void onClick(View view) {
        Updates.j.m(this.f14813a, this.f14814b, this.f14815c, view);
    }
}
