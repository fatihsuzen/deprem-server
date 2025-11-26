package com.uptodown.workers;

import E2.b;
import S1.k;
import X2.C2250q;
import android.content.Context;
import android.os.Bundle;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import b2.C2290j;
import com.uptodown.UptodownApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2668q;
import l2.T;
import t3.s;
import z2.C2940B;
import z2.C2954m;
import z2.H;
import z2.M;
import z2.P;

public final class GenerateQueueWorker extends Worker {

    /* renamed from: e  reason: collision with root package name */
    public static final a f21366e = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f21367a = k.f32g.a(this.f21367a);

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21368b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f21369c;

    /* renamed from: d  reason: collision with root package name */
    private String f21370d;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final boolean a(Context context, boolean z4, String str) {
            t.e(context, "context");
            if (UptodownApp.f13477F.T("GenerateQueueWorker", context)) {
                return false;
            }
            Data.Builder putString = new Data.Builder().putBoolean("downloadAnyway", z4).putString("packagename", str);
            WorkManager.Companion.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) GenerateQueueWorker.class).addTag("GenerateQueueWorker")).setInputData(putString.build())).build());
            return true;
        }

        public final boolean b(Context context, boolean z4, String str, boolean z5) {
            t.e(context, "context");
            if (UptodownApp.f13477F.T("GenerateQueueWorker", context)) {
                return false;
            }
            Data.Builder putBoolean = new Data.Builder().putBoolean("downloadAnyway", z4).putString("packagename", str).putBoolean("downloadUptodown", z5);
            WorkManager.Companion.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) GenerateQueueWorker.class).addTag("GenerateQueueWorker")).setInputData(putBoolean.build())).build());
            return true;
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenerateQueueWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "params");
        this.f21367a = context;
        this.f21368b = workerParameters.getInputData().getBoolean("downloadAnyway", false);
        this.f21369c = workerParameters.getInputData().getBoolean("downloadUptodown", false);
        this.f21370d = workerParameters.getInputData().getString("packagename");
    }

    private final void e() {
        if (!UptodownApp.f13477F.M(this.f21367a)) {
            Data build = new Data.Builder().putBoolean("downloadAnyway", this.f21368b).build();
            WorkManager.Companion.getInstance(this.f21367a).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) DownloadUpdatesWorker.class).addTag("DownloadUpdatesWorker")).setInputData(build)).build());
        }
    }

    private final void f(String str, boolean z4, Context context) {
        ArrayList arrayList;
        File n5;
        ArrayList arrayList2 = new ArrayList();
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        if (str != null) {
            arrayList = new ArrayList();
            T G02 = a5.G0(str);
            if (G02 != null) {
                arrayList.add(G02);
            }
        } else {
            arrayList = a5.I0();
        }
        String packageName = context.getPackageName();
        if (z4) {
            t.b(packageName);
            T G03 = a5.G0(packageName);
            if (G03 != null) {
                arrayList = new ArrayList();
                arrayList.add(G03);
            }
        }
        String j5 = com.uptodown.activities.preferences.a.f15150a.j(context);
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            T t5 = (T) next;
            C2655d C4 = new C2954m().C(context, t5.h());
            if (C4 != null && ((s.E(packageName, C4.o(), true) || str != null || (C4.b() > 0 && C4.e() == 0 && C4.C(context) && h(C4, j5))) && !t5.m() && !new C2290j().p(context, t5.h()))) {
                C2668q b5 = t5.b(context);
                if (b5 == null || !b5.f() || (n5 = b5.n()) == null || !n5.exists()) {
                    arrayList2.add(C4);
                }
            }
        }
        a5.m();
        C2250q.t(arrayList2, new b());
        int size = arrayList2.size();
        int i5 = 0;
        while (true) {
            if (i5 < size) {
                if (s.E(packageName, ((C2655d) arrayList2.get(i5)).o(), true) && ((C2655d) arrayList2.get(i5)).w() == C2655d.c.OUTDATED) {
                    Object obj = arrayList2.get(i5);
                    t.d(obj, "get(...)");
                    arrayList2.remove(i5);
                    arrayList2.add(0, (C2655d) obj);
                    break;
                }
                i5++;
            } else {
                break;
            }
        }
        UptodownApp.f13477F.K0(arrayList2);
    }

    /* access modifiers changed from: private */
    public static final int g(C2655d dVar, C2655d dVar2) {
        t.e(dVar, "app1");
        t.e(dVar2, "app2");
        if (dVar.m() == null) {
            return 1;
        }
        if (dVar2.m() == null) {
            return -1;
        }
        String m5 = dVar.m();
        t.b(m5);
        String m6 = dVar2.m();
        t.b(m6);
        return s.x(m5, m6, true);
    }

    private final boolean h(C2655d dVar, String str) {
        String str2;
        if (!s.E(str, "2", true) || new C2954m().A(this.f21367a)) {
            return false;
        }
        if (dVar.o() != null) {
            C2954m mVar = new C2954m();
            Context context = this.f21367a;
            String o5 = dVar.o();
            t.b(o5);
            str2 = mVar.h(context, o5);
        } else {
            str2 = null;
        }
        if (str2 == null || !s.E(str2, this.f21367a.getPackageName(), true)) {
            return false;
        }
        return true;
    }

    public ListenableWorker.Result doWork() {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (!aVar.M(this.f21367a)) {
            f(this.f21370d, this.f21369c, this.f21367a);
            ArrayList E4 = aVar.E();
            if (E4 == null || E4.size() <= 0) {
                InstallUpdatesWorker.f21380b.a(this.f21367a);
            } else if (!com.uptodown.activities.preferences.a.f15150a.b0(this.f21367a)) {
                e();
            } else if (H.f26488a.f() || this.f21368b) {
                e();
            } else {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("apps_parcelable", E4);
                P.f26510a.f().send(105, bundle);
                M.f26506a.G(this.f21367a);
                aVar.g();
            }
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        t.d(success, "success(...)");
        return success;
    }
}
