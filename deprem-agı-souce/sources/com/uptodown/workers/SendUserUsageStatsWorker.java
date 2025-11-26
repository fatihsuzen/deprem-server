package com.uptodown.workers;

import S1.k;
import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.uptodown.UptodownApp;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.M;
import org.json.JSONObject;
import z2.X;
import z2.Z;

public final class SendUserUsageStatsWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21410b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f21411a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(Context context) {
            t.e(context, "context");
            new X().l(context, false);
            if (UptodownApp.f13477F.T("SendUserUsageStatsWorker", context)) {
                WorkManager.Companion.getInstance(context).cancelAllWorkByTag("SendUserUsageStatsWorker");
            }
        }

        public final void b(Context context) {
            t.e(context, "context");
            if (!UptodownApp.f13477F.T("SendUserUsageStatsWorker", context)) {
                WorkManager instance = WorkManager.Companion.getInstance(context);
                instance.enqueue((WorkRequest) (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) SendUserUsageStatsWorker.class, 24, TimeUnit.HOURS).addTag("SendUserUsageStatsWorker")).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).build());
            }
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SendUserUsageStatsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "params");
        this.f21411a = context;
        this.f21411a = k.f32g.a(context);
    }

    private final void d() {
        String d5;
        X x4 = new X();
        x4.j(this.f21411a);
        x4.m(x4.e(this.f21411a));
        M j12 = new Z(this.f21411a).j1(x4);
        if (!j12.b() && (d5 = j12.d()) != null && d5.length() != 0) {
            String d6 = j12.d();
            t.b(d6);
            if (new JSONObject(d6).optInt("success") == 1) {
                x4.k(this.f21411a);
            }
        }
    }

    public ListenableWorker.Result doWork() {
        if (X.f26521e.a(this.f21411a)) {
            d();
        } else {
            f21410b.a(this.f21411a);
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        t.d(success, "success(...)");
        return success;
    }
}
