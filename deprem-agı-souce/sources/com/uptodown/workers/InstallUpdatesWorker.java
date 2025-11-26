package com.uptodown.workers;

import S1.k;
import X1.C2231h;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import b2.C2279K;
import b2.C2292l;
import b2.C2301u;
import com.uptodown.UptodownApp;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2668q;
import l2.T;
import l2.r;
import t3.s;
import z2.C2940B;
import z2.C2954m;
import z2.D;
import z2.F;
import z2.M;

public final class InstallUpdatesWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21380b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f21381a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(Context context) {
            t.e(context, "context");
            if (!UptodownApp.f13477F.T("InstallUpdatesWorker", context)) {
                WorkManager.Companion.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) InstallUpdatesWorker.class).addTag("InstallUpdatesWorker")).build());
            }
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstallUpdatesWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "params");
        this.f21381a = context;
        this.f21381a = k.f32g.a(context);
    }

    private final boolean d(Context context) {
        boolean z4;
        boolean z5;
        if (Build.VERSION.SDK_INT >= 31) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean E4 = s.E(com.uptodown.activities.preferences.a.f15150a.j(context), "2", true);
        boolean A4 = new C2954m().A(context);
        if (k.f32g.i() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean e5 = new D().e(context);
        if (!z4 || !E4 || !z5 || A4 || e5) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.io.File e(java.io.File r5, java.io.File r6) {
        /*
            r4 = this;
            long r0 = r6.getUsableSpace()
            long r2 = r5.length()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 >= 0) goto L_0x000e
            return r1
        L_0x000e:
            boolean r0 = r6.isDirectory()
            if (r0 == 0) goto L_0x0036
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = r6.getAbsolutePath()
            r2.append(r6)
            r6 = 47
            r2.append(r6)
            java.lang.String r6 = r5.getName()
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r0.<init>(r6)
            r6 = r0
        L_0x0036:
            boolean r0 = r6.isFile()
            if (r0 == 0) goto L_0x0044
            boolean r0 = r6.exists()
            if (r0 != 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            return r6
        L_0x0044:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{  }
            r0.<init>(r5)     // Catch:{  }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException | SecurityException -> 0x0052 }
            r5.<init>(r6)     // Catch:{ FileNotFoundException | SecurityException -> 0x0052 }
            r4.f(r0, r5)
            return r6
        L_0x0052:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.InstallUpdatesWorker.e(java.io.File, java.io.File):java.io.File");
    }

    private final void f(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                outputStream.close();
                return;
            }
        }
    }

    private final boolean g(Context context, C2655d dVar) {
        if (s.E(context.getPackageName(), dVar.o(), true) || (dVar.e() == 0 && dVar.C(context))) {
            return true;
        }
        return false;
    }

    public ListenableWorker.Result doWork() {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        File file;
        C2655d Y4;
        if (d(this.f21381a)) {
            C2940B.a aVar = C2940B.f26458v;
            Context applicationContext = getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            C2940B a5 = aVar.a(applicationContext);
            a5.a();
            ArrayList I02 = a5.I0();
            ArrayList arrayList = new ArrayList();
            Iterator it = I02.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                T t5 = (T) next;
                if (!t5.m() && (Y4 = a5.Y(t5.h())) != null && g(this.f21381a, Y4) && t5.a() != null) {
                    C2668q a6 = t5.a();
                    t.b(a6);
                    if (a6.f()) {
                        arrayList.add(t5);
                    }
                }
            }
            a5.m();
            Iterator it2 = arrayList.iterator();
            t.d(it2, "iterator(...)");
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                t.d(next2, "next(...)");
                T t6 = (T) next2;
                try {
                    PackageManager packageManager = this.f21381a.getPackageManager();
                    t.d(packageManager, "getPackageManager(...)");
                    C2668q a7 = t6.a();
                    t.b(a7);
                    String w4 = a7.w();
                    t.b(w4);
                    packageInfo = C2301u.d(packageManager, w4, 128);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (!(packageInfo == null || packageInfo.applicationInfo == null)) {
                    C2292l lVar = new C2292l(this.f21381a, (C2231h) null);
                    ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
                    t.b(applicationInfo2);
                    if (lVar.E(applicationInfo2.targetSdkVersion)) {
                        String packageName = this.f21381a.getPackageName();
                        C2954m mVar = new C2954m();
                        Context context = this.f21381a;
                        C2668q a8 = t6.a();
                        t.b(a8);
                        String w5 = a8.w();
                        t.b(w5);
                        if (t.a(packageName, mVar.h(context, w5))) {
                            ArrayList arrayList2 = new ArrayList();
                            if (t6.n() == 1) {
                                C2668q a9 = t6.a();
                                t.b(a9);
                                File n5 = a9.n();
                                t.b(n5);
                                if (n5.isFile()) {
                                    n5 = n5.getParentFile();
                                }
                                try {
                                    PackageManager packageManager2 = this.f21381a.getPackageManager();
                                    t.d(packageManager2, "getPackageManager(...)");
                                    applicationInfo = C2301u.a(packageManager2, t6.h(), 128);
                                } catch (PackageManager.NameNotFoundException e5) {
                                    e5.printStackTrace();
                                    applicationInfo = null;
                                }
                                if (applicationInfo != null) {
                                    file = new File(applicationInfo.sourceDir);
                                } else {
                                    file = null;
                                }
                                if (!(file == null || n5 == null)) {
                                    e(file, n5);
                                }
                                t.b(file);
                                arrayList2.add(new File(n5, file.getName()));
                            }
                            C2668q a10 = t6.a();
                            t.b(a10);
                            Iterator it3 = a10.o().iterator();
                            t.d(it3, "iterator(...)");
                            while (it3.hasNext()) {
                                Object next3 = it3.next();
                                t.d(next3, "next(...)");
                                r rVar = (r) next3;
                                if (rVar.a() != null) {
                                    String a11 = rVar.a();
                                    t.b(a11);
                                    arrayList2.add(new File(a11));
                                }
                            }
                            if (arrayList2.size() == 1) {
                                C2279K.a aVar2 = C2279K.f20490b;
                                String absolutePath = ((File) arrayList2.get(0)).getAbsolutePath();
                                t.d(absolutePath, "getAbsolutePath(...)");
                                if (aVar2.a(absolutePath)) {
                                    UptodownApp.a aVar3 = UptodownApp.f13477F;
                                    Object obj = arrayList2.get(0);
                                    t.d(obj, "get(...)");
                                    UptodownApp.a.V(aVar3, (File) obj, this.f21381a, (String) null, 4, (Object) null);
                                }
                            }
                            C2292l.B(lVar, arrayList2, false, 2, (Object) null);
                            Bundle bundle = new Bundle();
                            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
                            new F(this.f21381a).d("install", bundle);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        M.f26506a.G(this.f21381a);
        UploadFileWorker.f21424c.a(this.f21381a);
        ListenableWorker.Result success = ListenableWorker.Result.success();
        t.d(success, "success(...)");
        return success;
    }
}
