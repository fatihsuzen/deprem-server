package com.finazzi.distquake;

import android.content.DialogInterface;
import com.finazzi.distquake.FriendshipActivity;

public final /* synthetic */ class Q implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FriendshipActivity.b f13497a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13498b;

    public /* synthetic */ Q(FriendshipActivity.b bVar, int i8) {
        this.f13497a = bVar;
        this.f13498b = i8;
    }

    public final void onClick(DialogInterface dialogInterface, int i8) {
        FriendshipActivity.b.c(this.f13497a, this.f13498b, dialogInterface, i8);
    }
}
