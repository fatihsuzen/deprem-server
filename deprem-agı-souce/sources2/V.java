package com.finazzi.distquake;

import android.content.DialogInterface;
import com.finazzi.distquake.FriendshipActivity;

public final /* synthetic */ class V implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FriendshipActivity.b f13554a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13555b;

    public /* synthetic */ V(FriendshipActivity.b bVar, int i8) {
        this.f13554a = bVar;
        this.f13555b = i8;
    }

    public final void onClick(DialogInterface dialogInterface, int i8) {
        FriendshipActivity.b.a(this.f13554a, this.f13555b, dialogInterface, i8);
    }
}
