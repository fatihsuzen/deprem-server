package com.uptodown.workers;

import A2.c;
import S1.k;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import b2.C2286f;
import b2.C2301u;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.UptodownApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2667p;
import l2.C2673w;
import l2.M;
import l2.U;
import m2.C2684d;
import org.json.JSONObject;
import t3.s;
import z2.C2940B;
import z2.D;
import z2.F;
import z2.G;
import z2.H;
import z2.Z;

public final class UploadFileWorker extends Worker {

    /* renamed from: c  reason: collision with root package name */
    public static final a f21424c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f21425a = k.f32g.a(this.f21425a);

    /* renamed from: b  reason: collision with root package name */
    private final F f21426b;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(Context context) {
            t.e(context, "context");
            if (!new D().e(context) && !UptodownApp.f13477F.T("UploadFileWorker", context)) {
                WorkManager.Companion.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) UploadFileWorker.class).addTag("UploadFileWorker")).build());
            }
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadFileWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "params");
        this.f21425a = context;
        this.f21426b = new F(context);
    }

    private final String d(String str, ArrayList arrayList) {
        ApplicationInfo applicationInfo;
        String str2 = str;
        PackageManager packageManager = this.f21425a.getPackageManager();
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2655d dVar = (C2655d) next;
            Iterator it2 = it;
            if (dVar.r() != null && s.E(dVar.r(), str2, true)) {
                try {
                    t.b(packageManager);
                    String o5 = dVar.o();
                    t.b(o5);
                    applicationInfo = C2301u.a(packageManager, o5, 128);
                } catch (PackageManager.NameNotFoundException unused) {
                    applicationInfo = null;
                }
                if (applicationInfo != null) {
                    String e5 = C2286f.f20690a.e(applicationInfo.sourceDir);
                    if (s.E(str2, e5, true)) {
                        return applicationInfo.sourceDir;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "ignored");
                    bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "hashNotMatch");
                    bundle.putString("filehash", str2);
                    bundle.putString("packagename", applicationInfo.packageName);
                    bundle.putString("filehashCalculated", e5);
                    this.f21426b.d("upload", G.f26487a.a(bundle));
                    C2940B a5 = C2940B.f26458v.a(this.f21425a);
                    a5.a();
                    dVar.Z(e5);
                    a5.y1(dVar);
                    a5.m();
                    return null;
                }
            }
            C2940B a6 = C2940B.f26458v.a(this.f21425a);
            a6.a();
            ArrayList a02 = a6.a0(dVar);
            a6.m();
            if (a02 != null) {
                Iterator it3 = a02.iterator();
                t.d(it3, "iterator(...)");
                while (it3.hasNext()) {
                    Object next2 = it3.next();
                    t.d(next2, "next(...)");
                    C2673w wVar = (C2673w) next2;
                    PackageManager packageManager2 = packageManager;
                    Iterator it4 = it3;
                    if (!s.E(str2, wVar.c(), true) || wVar.a() == null) {
                        packageManager = packageManager2;
                        it3 = it4;
                    } else {
                        C2286f fVar = C2286f.f20690a;
                        String a7 = wVar.a();
                        t.b(a7);
                        String e6 = fVar.e(a7);
                        if (s.E(str2, e6, true)) {
                            return wVar.a();
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "ignored");
                        bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "hashNotMatch");
                        bundle2.putString("filehash", str2);
                        bundle2.putString("packagename", dVar.o());
                        bundle2.putString("filehashCalculated", e6);
                        this.f21426b.d("upload", G.f26487a.a(bundle2));
                        return null;
                    }
                }
                continue;
            }
            it = it2;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "ignored");
        bundle3.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "hashNotFound");
        bundle3.putString("filehash", str2);
        this.f21426b.d("upload", G.f26487a.a(bundle3));
        return null;
    }

    private final JSONObject e() {
        C2684d.f25289a.a();
        boolean c5 = new D().c(this.f21425a);
        boolean d5 = new D().d(this.f21425a);
        if (c5 && f() && !d5) {
            C2667p pVar = new C2667p();
            pVar.j(this.f21425a);
            Z z4 = new Z(this.f21425a, (C2684d) null);
            String d6 = pVar.d();
            t.b(d6);
            M y4 = z4.y(d6);
            this.f21426b.g("getFileToUpload", (Bundle) null, y4, (String) null);
            if (!z4.i(y4) || y4.d() == null) {
                y4.f();
            } else {
                String d7 = y4.d();
                t.b(d7);
                JSONObject jSONObject = new JSONObject(d7);
                if (jSONObject.optInt("success") == 1) {
                    return jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                }
            }
        }
        return null;
    }

    private final boolean f() {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.S("DownloadUpdatesWorker", this.f21425a) || aVar.S("downloadApkWorker", this.f21425a)) {
            return false;
        }
        return true;
    }

    private final boolean g(String str, String str2) {
        boolean c5 = new D().c(this.f21425a);
        boolean d5 = new D().d(this.f21425a);
        if (!c5 || !f() || d5) {
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "ignored");
            if (!c5) {
                bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "battery");
            } else {
                bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "notIdle");
            }
            this.f21426b.d("upload", G.f26487a.a(bundle));
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            long length = file.length();
            H h5 = H.f26488a;
            if (h5.f()) {
                return c.b(new c(), this.f21425a, file, str2, false, 8, (Object) null);
            }
            if (h5.e()) {
                U a5 = U.f24867c.a(this.f21425a);
                if (length > 0 && length < a5.a(this.f21425a)) {
                    return new c().a(this.f21425a, file, str2, true);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "ignored");
                bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "size");
                G g5 = G.f26487a;
                bundle2.putString("size", g5.e(length));
                this.f21426b.d("upload", g5.a(bundle2));
                return false;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "ignored");
            bundle3.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "connection");
            G g6 = G.f26487a;
            bundle3.putString("size", g6.e(length));
            this.f21426b.d("upload", g6.a(bundle3));
            return false;
        }
        Bundle bundle4 = new Bundle();
        bundle4.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "ignored");
        bundle4.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "fileNotFound");
        this.f21426b.d("upload", G.f26487a.a(bundle4));
        return false;
    }

    public ListenableWorker.Result doWork() {
        String str;
        UptodownApp.a aVar = UptodownApp.f13477F;
        boolean S4 = aVar.S("DownloadUpdatesWorker", this.f21425a);
        boolean S5 = aVar.S("downloadApkWorker", this.f21425a);
        if (!S4 && !S5) {
            JSONObject e5 = e();
            if (e5 == null || e5.isNull("sha256")) {
                str = null;
            } else {
                str = e5.optString("sha256");
            }
            if (str != null) {
                C2940B a5 = C2940B.f26458v.a(this.f21425a);
                a5.a();
                ArrayList d02 = a5.d0();
                a5.m();
                String d5 = d(str, d02);
                if (d5 != null && g(d5, str)) {
                    UptodownApp.a.O0(aVar, this.f21425a, false, 2, (Object) null);
                }
            }
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        t.d(success, "success(...)");
        return success;
    }
}
