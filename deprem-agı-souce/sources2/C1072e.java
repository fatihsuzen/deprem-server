package com.finazzi.distquake;

import android.content.DialogInterface;
import com.finazzi.distquake.ChatActivity;

/* renamed from: com.finazzi.distquake.e  reason: case insensitive filesystem */
public final /* synthetic */ class C1072e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatActivity.d f13697a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13698b;

    public /* synthetic */ C1072e(ChatActivity.d dVar, int i8) {
        this.f13697a = dVar;
        this.f13698b = i8;
    }

    public final void onClick(DialogInterface dialogInterface, int i8) {
        ChatActivity.d.a(this.f13697a, this.f13698b, dialogInterface, i8);
    }
}
