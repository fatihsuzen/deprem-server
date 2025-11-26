package com.uptodown.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import g2.C2380b;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.N;

public final class GetRemoteInstallWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21371b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f21372a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetRemoteInstallWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "params");
        this.f21372a = context;
    }

    public ListenableWorker.Result doWork() {
        new C2380b(this.f21372a, N.a(C2865c0.b()));
        ListenableWorker.Result success = ListenableWorker.Result.success();
        t.d(success, "success(...)");
        return success;
    }
}
