package com.uptodown.activities;

import android.content.DialogInterface;
import com.uptodown.activities.Updates;
import kotlin.jvm.internal.I;

public final /* synthetic */ class T implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f14569a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Updates f14570b;

    public /* synthetic */ T(I i5, Updates updates) {
        this.f14569a = i5;
        this.f14570b = updates;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Updates.b.n(this.f14569a, this.f14570b, dialogInterface);
    }
}
