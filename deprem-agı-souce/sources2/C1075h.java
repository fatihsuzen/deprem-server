package com.finazzi.distquake;

import android.content.DialogInterface;
import com.finazzi.distquake.ChatActivity;

/* renamed from: com.finazzi.distquake.h  reason: case insensitive filesystem */
public final /* synthetic */ class C1075h implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatActivity.f f13704a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13705b;

    public /* synthetic */ C1075h(ChatActivity.f fVar, int i8) {
        this.f13704a = fVar;
        this.f13705b = i8;
    }

    public final void onClick(DialogInterface dialogInterface, int i8) {
        ChatActivity.f.b(this.f13704a, this.f13705b, dialogInterface, i8);
    }
}
