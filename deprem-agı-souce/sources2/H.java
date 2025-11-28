package com.finazzi.distquake;

import android.app.Activity;
import com.finazzi.distquake.FragmentChatMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class H implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentChatMenu.c f13229a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f13230b;

    public /* synthetic */ H(FragmentChatMenu.c cVar, Activity activity) {
        this.f13229a = cVar;
        this.f13230b = activity;
    }

    public final void onComplete(Task task) {
        FragmentChatMenu.c.a(this.f13229a, this.f13230b, task);
    }
}
