package com.finazzi.distquake;

import android.content.DialogInterface;
import com.finazzi.distquake.FriendshipActivity;

public final /* synthetic */ class T implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FriendshipActivity.b f13537a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f13538b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f13539c;

    public /* synthetic */ T(FriendshipActivity.b bVar, String str, String str2) {
        this.f13537a = bVar;
        this.f13538b = str;
        this.f13539c = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i8) {
        FriendshipActivity.b.b(this.f13537a, this.f13538b, this.f13539c, dialogInterface, i8);
    }
}
