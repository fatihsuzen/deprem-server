package com.finazzi.distquake;

import android.view.MenuItem;
import androidx.appcompat.widget.W;
import com.finazzi.distquake.ChatActivity;

/* renamed from: com.finazzi.distquake.g  reason: case insensitive filesystem */
public final /* synthetic */ class C1074g implements W.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatActivity.f f13701a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13702b;

    public /* synthetic */ C1074g(ChatActivity.f fVar, int i8) {
        this.f13701a = fVar;
        this.f13702b = i8;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return ChatActivity.f.c(this.f13701a, this.f13702b, menuItem);
    }
}
