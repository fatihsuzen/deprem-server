package com.finazzi.distquake;

import android.view.View;
import com.finazzi.distquake.ChatActivity;

/* renamed from: com.finazzi.distquake.a  reason: case insensitive filesystem */
public final /* synthetic */ class C1068a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatActivity.c f13685a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13686b;

    public /* synthetic */ C1068a(ChatActivity.c cVar, int i8) {
        this.f13685a = cVar;
        this.f13686b = i8;
    }

    public final void onClick(View view) {
        ChatActivity.c.b(this.f13685a, this.f13686b, view);
    }
}
