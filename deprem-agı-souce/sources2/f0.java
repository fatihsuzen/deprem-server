package com.finazzi.distquake;

import com.finazzi.distquake.WorkerLocation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class f0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkerLocation.c f13700a;

    public /* synthetic */ f0(WorkerLocation.c cVar) {
        this.f13700a = cVar;
    }

    public final void onComplete(Task task) {
        WorkerLocation.c.a(this.f13700a, task);
    }
}
