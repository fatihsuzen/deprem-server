package com.finazzi.distquake;

import android.view.MenuItem;
import androidx.appcompat.widget.W;
import com.finazzi.distquake.ChatActivity;

/* renamed from: com.finazzi.distquake.d  reason: case insensitive filesystem */
public final /* synthetic */ class C1071d implements W.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatActivity.d f13694a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13695b;

    public /* synthetic */ C1071d(ChatActivity.d dVar, int i8) {
        this.f13694a = dVar;
        this.f13695b = i8;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return ChatActivity.d.b(this.f13694a, this.f13695b, menuItem);
    }
}
