package com.uptodown.activities;

import android.content.DialogInterface;
import com.uptodown.activities.Updates;
import kotlin.jvm.internal.I;

public final /* synthetic */ class Z implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f14824a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Updates f14825b;

    public /* synthetic */ Z(I i5, Updates updates) {
        this.f14824a = i5;
        this.f14825b = updates;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Updates.j.n(this.f14824a, this.f14825b, dialogInterface);
    }
}
