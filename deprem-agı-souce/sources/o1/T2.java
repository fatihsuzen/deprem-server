package O1;

import S1.j;
import S1.k;
import U1.C2201a;
import W1.C2208a;
import W1.C2209b;
import W2.J;
import W2.u;
import X1.C2225b;
import X1.C2227d;
import Y1.C2258b;
import Z1.C2263c;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.nsd.NsdServiceInfo;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LifecycleOwnerKt;
import b2.C2290j;
import b2.C2291k;
import b2.C2301u;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.workers.DownloadWorker;
import com.uptodown.workers.GenerateQueueWorker;
import g2.C2381c;
import g2.C2388j;
import g2.C2392n;
import g2.v;
import h2.C2397A;
import h2.C2426m0;
import h2.C2429o;
import h2.s1;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import k2.C2600j;
import k2.C2610u;
import k2.I;
import k2.Z;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import l2.C2667p;
import l2.C2668q;
import l2.L;
import l2.T;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.E;
import z2.P;

public abstract class T2 extends C1598a {
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public ProgressBar f3441K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public TextView f3442L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public TextView f3443M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public boolean f3444N;

    /* renamed from: O  reason: collision with root package name */
    private boolean f3445O;

    /* renamed from: P  reason: collision with root package name */
    private C2908y0 f3446P;

    /* renamed from: Q  reason: collision with root package name */
    private ArrayList f3447Q = new ArrayList();

    /* renamed from: R  reason: collision with root package name */
    private boolean f3448R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public C2426m0 f3449S;

    /* renamed from: T  reason: collision with root package name */
    private File f3450T;

    /* renamed from: U  reason: collision with root package name */
    private boolean f3451U;

    /* renamed from: V  reason: collision with root package name */
    private h f3452V = new h(this);

    public static final class a implements C2600j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T2 f3453a;

        a(T2 t22) {
            this.f3453a = t22;
        }

        public void a(ArrayList arrayList) {
            t.e(arrayList, "positives");
            UptodownApp.f13477F.B0(arrayList);
            this.f3453a.M4();
            this.f3453a.f3444N = false;
        }

        public void b() {
            UptodownApp.f13477F.B0(new ArrayList());
            this.f3453a.M4();
            this.f3453a.f3444N = false;
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f3454a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ T2 f3455b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f3456c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f3457d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f3458e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f3459f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(T2 t22, String str, String str2, ArrayList arrayList, boolean z4, C2308e eVar) {
            super(2, eVar);
            this.f3455b = t22;
            this.f3456c = str;
            this.f3457d = str2;
            this.f3458e = arrayList;
            this.f3459f = z4;
        }

        /* access modifiers changed from: private */
        public static final void e(T2 t22, boolean z4, String str, View view) {
            t22.o2();
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.T("GenerateQueueWorker", t22) || aVar.T("downloadApkWorker", t22)) {
                String string = t22.getString(R.string.error_download_in_progress_wait);
                t.d(string, "getString(...)");
                t22.a2(string);
                return;
            }
            t22.P4(true);
            GenerateQueueWorker.f21366e.a(t22, z4, str);
        }

        /* access modifiers changed from: private */
        public static final void f(T2 t22, View view) {
            t22.o2();
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f3455b, this.f3456c, this.f3457d, this.f3458e, this.f3459f, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            C2316b.f();
            if (this.f3454a == 0) {
                u.b(obj);
                if (!this.f3455b.isFinishing()) {
                    this.f3455b.o2();
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f3455b);
                    C2397A c5 = C2397A.c(this.f3455b.getLayoutInflater());
                    t.d(c5, "inflate(...)");
                    C2940B.a aVar = C2940B.f26458v;
                    Context applicationContext = this.f3455b.getApplicationContext();
                    t.d(applicationContext, "getApplicationContext(...)");
                    C2940B a5 = aVar.a(applicationContext);
                    a5.a();
                    C2655d Y4 = a5.Y(this.f3456c);
                    a5.m();
                    String str2 = this.f3457d;
                    ArrayList arrayList = this.f3458e;
                    T2 t22 = this.f3455b;
                    boolean z4 = this.f3459f;
                    String str3 = this.f3456c;
                    TextView textView = c5.f22256f;
                    k.a aVar2 = k.f32g;
                    textView.setTypeface(aVar2.w());
                    TextView textView2 = c5.f22256f;
                    if (Y4 != null) {
                        str = Y4.m();
                    } else {
                        str = null;
                    }
                    textView2.setText(str);
                    c5.f22254d.setTypeface(aVar2.x());
                    c5.f22254d.setText(str2);
                    c5.f22253c.setTypeface(aVar2.x());
                    Iterator it = arrayList.iterator();
                    t.d(it, "iterator(...)");
                    String str4 = "";
                    while (it.hasNext()) {
                        Object next = it.next();
                        t.d(next, "next(...)");
                        str4 = str4 + "- " + ((String) next) + 10;
                    }
                    c5.f22253c.setText(str4);
                    TextView textView3 = c5.f22255e;
                    k.a aVar3 = k.f32g;
                    textView3.setTypeface(aVar3.w());
                    c5.f22255e.setOnClickListener(new U2(t22, z4, str3));
                    c5.f22252b.setTypeface(aVar3.w());
                    c5.f22252b.setOnClickListener(new V2(t22));
                    builder.setCancelable(false);
                    builder.setView(c5.getRoot());
                    this.f3455b.P2(builder.create());
                    if (!this.f3455b.isFinishing() && this.f3455b.p2() != null) {
                        this.f3455b.b3();
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class f implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T2 f3469a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2655d f3470b;

        f(T2 t22, C2655d dVar) {
            this.f3469a = t22;
            this.f3470b = dVar;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (fVar.c()) {
                Intent intent = new Intent(this.f3469a.getApplicationContext(), OldVersionsActivity.class);
                intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f3470b);
                intent.putExtra("appInfo", fVar);
                T2 t22 = this.f3469a;
                t22.startActivity(intent, UptodownApp.f13477F.a(t22));
                return;
            }
            T2 t23 = this.f3469a;
            String string = t23.getString(R.string.rollback_not_available, new Object[]{fVar.N()});
            t.d(string, "getString(...)");
            t23.u0(string);
        }

        public void d(int i5) {
            T2 t22 = this.f3469a;
            String string = t22.getString(R.string.rollback_not_available, new Object[]{this.f3470b.m()});
            t.d(string, "getString(...)");
            t22.u0(string);
        }
    }

    public static final class g implements Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T2 f3471a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2655d f3472b;

        g(T2 t22, C2655d dVar) {
            this.f3471a = t22;
            this.f3472b = dVar;
        }

        public void a(L l5) {
            t.e(l5, "reportVT");
            Intent intent = new Intent(this.f3471a, VirusTotalReport.class);
            intent.putExtra("app_selected", this.f3472b);
            intent.putExtra("appReportVT", l5);
            T2 t22 = this.f3471a;
            t22.startActivity(intent, UptodownApp.f13477F.a(t22));
        }

        public void b() {
            if (this.f3472b.t() > 650000000) {
                Intent intent = new Intent(this.f3471a, VirusTotalReport.class);
                intent.putExtra("app_selected", this.f3472b);
                intent.putExtra("isVirusTotalReportAvaialable", false);
                T2 t22 = this.f3471a;
                t22.startActivity(intent, UptodownApp.f13477F.a(t22));
                return;
            }
            this.f3471a.L2(this.f3472b.r());
        }
    }

    public static final class h implements I {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T2 f3473a;

        h(T2 t22) {
            this.f3473a = t22;
        }

        public void a(String str) {
            t.e(str, "appName");
            this.f3473a.u0(str);
        }
    }

    static final class i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f3474a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3475b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T2 f3476c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(int i5, T2 t22, C2308e eVar) {
            super(2, eVar);
            this.f3475b = i5;
            this.f3476c = t22;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new i(this.f3475b, this.f3476c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f3474a == 0) {
                u.b(obj);
                C2426m0 m0Var = null;
                switch (this.f3475b) {
                    case 106:
                        C2426m0 I32 = this.f3476c.f3449S;
                        if (I32 == null) {
                            t.w("dialogBinding");
                        } else {
                            m0Var = I32;
                        }
                        m0Var.f23362v.setText(this.f3476c.getString(R.string.action_update));
                        break;
                    case 107:
                        C2426m0 I33 = this.f3476c.f3449S;
                        if (I33 == null) {
                            t.w("dialogBinding");
                        } else {
                            m0Var = I33;
                        }
                        m0Var.f23362v.setText(this.f3476c.getString(R.string.action_cancel_download));
                        break;
                    case 108:
                        C2426m0 I34 = this.f3476c.f3449S;
                        if (I34 == null) {
                            t.w("dialogBinding");
                        } else {
                            m0Var = I34;
                        }
                        m0Var.f23362v.setText(this.f3476c.getString(R.string.notification_msg_update_uptodown));
                        break;
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((i) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    private final void L4(C2655d dVar) {
        if (!isFinishing()) {
            new C2392n(this, (String) null, dVar.r(), new g(this, dVar), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    private final void O3() {
        new C2381c(this, new a(this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void P3(String str, int i5) {
        Window window;
        if (i5 == 0) {
            AlertDialog p22 = p2();
            if (p22 != null) {
                p22.dismiss();
            }
            View inflate = getLayoutInflater().inflate(R.layout.dialog_backup_app, (ViewGroup) null, false);
            k.a aVar = k.f32g;
            ((TextView) inflate.findViewById(R.id.tv_title_dialog_backup_app)).setTypeface(aVar.w());
            TextView textView = (TextView) inflate.findViewById(R.id.tv_name_dialog_backup_app);
            this.f3442L = textView;
            if (textView != null) {
                textView.setTypeface(aVar.x());
            }
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_percentage_dialog_backup_app);
            this.f3443M = textView2;
            if (textView2 != null) {
                textView2.setTypeface(aVar.x());
            }
            this.f3441K = (ProgressBar) inflate.findViewById(R.id.progressbar_dialog_backup_app);
            View findViewById = inflate.findViewById(R.id.tv_cancel_dialog_backup_app);
            t.d(findViewById, "findViewById(...)");
            TextView textView3 = (TextView) findViewById;
            textView3.setTypeface(aVar.w());
            textView3.setOnClickListener(new K2(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(inflate);
            builder.setCancelable(false);
            P2(builder.create());
            AlertDialog p23 = p2();
            if (!(p23 == null || (window = p23.getWindow()) == null)) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            AlertDialog p24 = p2();
            if (p24 != null) {
                p24.show();
            }
        }
        TextView textView4 = this.f3442L;
        if (textView4 != null) {
            textView4.setText(str);
        }
        TextView textView5 = this.f3443M;
        if (textView5 != null) {
            Q q5 = Q.f24695a;
            String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{0}, 1));
            t.d(format, "format(...)");
            textView5.setText(format);
        }
        ProgressBar progressBar = this.f3441K;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void Q3(T2 t22, View view) {
        if (UptodownApp.f13477F.Z()) {
            C2908y0 y0Var = t22.f3446P;
            if (y0Var == null) {
                t.w("jobBackup");
                y0Var = null;
            }
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
            AlertDialog p22 = t22.p2();
            if (p22 != null) {
                p22.dismiss();
            }
            t22.P2((AlertDialog) null);
        }
    }

    /* access modifiers changed from: private */
    public final void S3(String str, String str2) {
        AlertDialog p22 = p2();
        if (p22 != null) {
            p22.dismiss();
        }
        View inflate = getLayoutInflater().inflate(R.layout.dialog_backup_result, (ViewGroup) null, false);
        k.a aVar = k.f32g;
        ((TextView) inflate.findViewById(R.id.tv_title_dialog_backup_result)).setTypeface(aVar.w());
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg_dialog_backup_result);
        textView.setTypeface(aVar.x());
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_ok_dialog_backup_result);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new H2(this));
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_browse_dialog_backup_result);
        textView3.setTypeface(aVar.w());
        textView3.setOnClickListener(new I2(this));
        if (!(str2 == null || str2.length() == 0)) {
            TextView textView4 = (TextView) inflate.findViewById(R.id.tv_share_dialog_backup_result);
            textView4.setTypeface(aVar.w());
            textView4.setOnClickListener(new J2(this, str2));
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        P2(builder.create());
        AlertDialog p23 = p2();
        t.b(p23);
        Window window = p23.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AlertDialog p24 = p2();
        t.b(p24);
        p24.show();
    }

    /* access modifiers changed from: private */
    public static final void T3(T2 t22, View view) {
        if (UptodownApp.f13477F.Z()) {
            AlertDialog p22 = t22.p2();
            if (p22 != null) {
                p22.dismiss();
            }
            t22.P2((AlertDialog) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void U3(T2 t22, View view) {
        if (UptodownApp.f13477F.Z()) {
            Intent intent = new Intent(t22, FileExplorerActivity.class);
            intent.putExtra("subdir", new C2201a(t22).d());
            intent.putExtra("subdir_sd", new C2201a(t22).o());
            t22.startActivity(intent);
            AlertDialog p22 = t22.p2();
            if (p22 != null) {
                p22.dismiss();
            }
            t22.P2((AlertDialog) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void V3(T2 t22, String str, View view) {
        if (UptodownApp.f13477F.Z()) {
            Intent intent = new Intent("android.intent.action.SEND");
            Object c5 = new C2201a(t22).c();
            if (c5 instanceof File) {
                File file = new File((File) c5, str);
                if (file.exists()) {
                    intent.setType("application/vnd.android.package-archive");
                    intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(t22, t22.getPackageName() + ".provider", file));
                    t22.startActivity(Intent.createChooser(intent, t22.getString(R.string.intent_chooser_title_share_file)));
                }
            } else if (c5 instanceof DocumentFile) {
                intent.putExtra("android.intent.extra.STREAM", ((DocumentFile) c5).getUri());
                t22.startActivity(Intent.createChooser(intent, t22.getString(R.string.intent_chooser_title_share_file)));
            }
        }
    }

    private final void W3(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        C2429o c5 = C2429o.c(getLayoutInflater(), (ViewGroup) null, false);
        t.d(c5, "inflate(...)");
        c5.getRoot().setOnClickListener(new C2(this));
        c5.f23410b.setOnClickListener(new E2());
        TextView textView = c5.f23413e;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        c5.f23412d.setTypeface(aVar.x());
        TextView textView2 = c5.f23412d;
        textView2.setText(str + str);
        c5.f23411c.setTypeface(aVar.w());
        c5.f23411c.setOnClickListener(new F2(this));
        builder.setView(c5.getRoot());
        P2(builder.create());
        if (!isFinishing()) {
            AlertDialog p22 = p2();
            t.b(p22);
            Window window = p22.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            AlertDialog p23 = p2();
            t.b(p23);
            p23.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void X3(T2 t22, View view) {
        AlertDialog p22 = t22.p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void Z3(T2 t22, View view) {
        AlertDialog p22 = t22.p2();
        t.b(p22);
        p22.dismiss();
    }

    private final void a4(C2655d dVar, T t5) {
        long j5;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        s1 c5 = s1.c(getLayoutInflater(), (ViewGroup) null, false);
        t.d(c5, "inflate(...)");
        C2940B a5 = C2940B.f26458v.a(this);
        a5.a();
        if (t5.a() != null) {
            C2668q a6 = t5.a();
            t.b(a6);
            j5 = a6.z();
        } else {
            j5 = 0;
        }
        a5.m();
        TextView textView = c5.f23544m;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        c5.f23536e.setTypeface(aVar.x());
        c5.f23533b.setTypeface(aVar.w());
        c5.f23533b.setText(dVar.m());
        c5.f23538g.setTypeface(aVar.x());
        c5.f23535d.setTypeface(aVar.w());
        TextView textView2 = c5.f23535d;
        Q q5 = Q.f24695a;
        String format = String.format("%s(%s)", Arrays.copyOf(new Object[]{dVar.B(), Long.valueOf(dVar.A())}, 2));
        t.d(format, "format(...)");
        textView2.setText(format);
        c5.f23541j.setTypeface(aVar.x());
        c5.f23545n.setTypeface(aVar.w());
        TextView textView3 = c5.f23545n;
        String format2 = String.format("%s(%s)", Arrays.copyOf(new Object[]{t5.k(), Long.valueOf(t5.j())}, 2));
        t.d(format2, "format(...)");
        textView3.setText(format2);
        c5.f23539h.setTypeface(aVar.x());
        c5.f23542k.setTypeface(aVar.w());
        c5.f23542k.setText(dVar.o());
        c5.f23540i.setTypeface(aVar.x());
        c5.f23543l.setTypeface(aVar.w());
        c5.f23543l.setText(new C2291k().d(j5, this));
        c5.f23537f.setTypeface(aVar.x());
        c5.f23534c.setTypeface(aVar.w());
        c5.f23534c.setText(getString(R.string.version_details_filename_not_found, new Object[]{dVar.m()}));
        c5.f23546o.setTypeface(aVar.w());
        c5.f23546o.setOnClickListener(new G2(this));
        builder.setView(c5.getRoot());
        P2(builder.create());
        if (!isFinishing()) {
            AlertDialog p22 = p2();
            t.b(p22);
            Window window = p22.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            AlertDialog p23 = p2();
            t.b(p23);
            p23.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void b4(T2 t22, View view) {
        if (UptodownApp.f13477F.Z()) {
            AlertDialog p22 = t22.p2();
            t.b(p22);
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void d4(C2655d dVar, T2 t22, View view) {
        if (UptodownApp.f13477F.Z()) {
            String o5 = dVar.o();
            if (!(o5 == null || o5.length() == 0)) {
                PackageManager packageManager = t22.getPackageManager();
                String o6 = dVar.o();
                t.b(o6);
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(o6);
                if (launchIntentForPackage != null) {
                    t22.startActivity(launchIntentForPackage);
                } else {
                    String string = t22.getString(R.string.error_open_app, new Object[]{dVar.m()});
                    t.d(string, "getString(...)");
                    t22.a2(string);
                }
            }
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
        }
    }

    /* access modifiers changed from: private */
    public static final void e4(C2655d dVar, T2 t22, View view) {
        if (UptodownApp.f13477F.Z()) {
            String o5 = dVar.o();
            if (!(o5 == null || o5.length() == 0)) {
                j jVar = new j(t22);
                String o6 = dVar.o();
                t.b(o6);
                jVar.h(o6);
            }
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
        }
    }

    /* access modifiers changed from: private */
    public static final void f4(T2 t22, C2655d dVar, View view) {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.Z()) {
            Intent intent = new Intent(t22.getApplicationContext(), P1.b.class);
            intent.putExtra("AppIndex", dVar.o());
            t22.startActivity(intent, aVar.a(t22));
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
        }
    }

    /* access modifiers changed from: private */
    public static final void g4(T2 t22, C2655d dVar, View view) {
        if (UptodownApp.f13477F.Z()) {
            T2 t23 = t22;
            new v(t23, (C2657f) null, dVar, t22.f3452V, LifecycleOwnerKt.getLifecycleScope(t22));
            AlertDialog p22 = t23.p2();
            t.b(p22);
            t23.w4(p22);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005a, code lost:
        if (r0.isEmpty() == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0045, code lost:
        if (r0.isEmpty() == false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void h4(O1.T2 r7, l2.C2655d r8, android.view.View r9) {
        /*
            com.uptodown.UptodownApp$a r9 = com.uptodown.UptodownApp.f13477F
            boolean r9 = r9.Z()
            if (r9 == 0) goto L_0x0079
            android.app.AlertDialog r9 = r7.p2()
            kotlin.jvm.internal.t.b(r9)
            r7.w4(r9)
            r9 = 1
            r7.f3451U = r9
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r7.f3447Q = r0
            Y1.b r0 = new Y1.b
            java.lang.String r1 = r8.o()
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r2 = r8.m()
            kotlin.jvm.internal.t.b(r2)
            r0.<init>(r1, r2)
            java.util.ArrayList r1 = r7.f3447Q
            r1.add(r0)
            java.util.ArrayList r0 = r8.v()
            if (r0 == 0) goto L_0x0049
            java.util.ArrayList r0 = r8.v()
            kotlin.jvm.internal.t.b(r0)
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0049
        L_0x0047:
            r6 = r9
            goto L_0x005f
        L_0x0049:
            java.util.ArrayList r0 = r8.n()
            if (r0 == 0) goto L_0x005d
            java.util.ArrayList r0 = r8.n()
            kotlin.jvm.internal.t.b(r0)
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x005d
            goto L_0x0047
        L_0x005d:
            r9 = 0
            goto L_0x0047
        L_0x005f:
            java.lang.String r1 = r8.m()
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r2 = r8.o()
            kotlin.jvm.internal.t.b(r2)
            long r3 = r8.A()
            java.lang.String r5 = r8.B()
            r0 = r7
            r0.A(r1, r2, r3, r5, r6)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.T2.h4(O1.T2, l2.d, android.view.View):void");
    }

    /* access modifiers changed from: private */
    public static final void i4(T2 t22, C2655d dVar, View view) {
        t22.K4(dVar);
        AlertDialog p22 = t22.p2();
        t.b(p22);
        t22.w4(p22);
    }

    /* access modifiers changed from: private */
    public static final void j4(T2 t22, C2940B b5, C2655d dVar, int i5, View view) {
        t22.z4(b5, dVar, i5);
    }

    /* access modifiers changed from: private */
    public static final void k4(T2 t22, C2940B b5, C2655d dVar, int i5, View view) {
        t22.z4(b5, dVar, i5);
    }

    /* access modifiers changed from: private */
    public static final void l4(T t5, T2 t22, View view) {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.Z()) {
            aVar.d0(t5.h());
            C2668q a5 = t5.a();
            if (a5 != null) {
                a5.U(t22);
            }
            UptodownApp.a.O0(aVar, t22, false, 2, (Object) null);
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
        }
    }

    /* access modifiers changed from: private */
    public static final void m4(T2 t22, C2655d dVar, T t5, View view) {
        if (UptodownApp.f13477F.Z()) {
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
            t22.a4(dVar, t5);
        }
    }

    /* access modifiers changed from: private */
    public static final void n4(T2 t22, T t5, View view) {
        if (UptodownApp.f13477F.Z()) {
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
            String f5 = t5.f();
            t.b(f5);
            t22.W3(f5);
        }
    }

    /* access modifiers changed from: private */
    public static final void o4(T2 t22, T t5, C2940B b5, int i5, View view) {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.Z()) {
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
            if (t5.m()) {
                t5.q(0);
            } else {
                t5.q(1);
                C2668q a5 = t5.a();
                if (a5 != null) {
                    a5.U(t22);
                }
            }
            b5.a();
            b5.C1(t5);
            b5.m();
            t22.J4(i5, t5.e());
            UptodownApp.a.O0(aVar, t22, false, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0058, code lost:
        if (r10.isEmpty() == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0043, code lost:
        if (r10.isEmpty() == false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void p4(O1.T2 r8, l2.C2655d r9, android.view.View r10) {
        /*
            com.uptodown.UptodownApp$a r10 = com.uptodown.UptodownApp.f13477F
            boolean r10 = r10.Z()
            if (r10 == 0) goto L_0x0077
            android.app.AlertDialog r10 = r8.p2()
            kotlin.jvm.internal.t.b(r10)
            r8.w4(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r8.f3447Q = r10
            Y1.b r10 = new Y1.b
            java.lang.String r0 = r9.o()
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r1 = r9.m()
            kotlin.jvm.internal.t.b(r1)
            r10.<init>(r0, r1)
            java.util.ArrayList r0 = r8.f3447Q
            r0.add(r10)
            java.util.ArrayList r10 = r9.v()
            r0 = 1
            if (r10 == 0) goto L_0x0047
            java.util.ArrayList r10 = r9.v()
            kotlin.jvm.internal.t.b(r10)
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x0047
        L_0x0045:
            r7 = r0
            goto L_0x005d
        L_0x0047:
            java.util.ArrayList r10 = r9.n()
            if (r10 == 0) goto L_0x005b
            java.util.ArrayList r10 = r9.n()
            kotlin.jvm.internal.t.b(r10)
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x005b
            goto L_0x0045
        L_0x005b:
            r0 = 0
            goto L_0x0045
        L_0x005d:
            java.lang.String r2 = r9.m()
            kotlin.jvm.internal.t.b(r2)
            java.lang.String r3 = r9.o()
            kotlin.jvm.internal.t.b(r3)
            long r4 = r9.A()
            java.lang.String r6 = r9.B()
            r1 = r8
            r1.A(r2, r3, r4, r6, r7)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.T2.p4(O1.T2, l2.d, android.view.View):void");
    }

    /* access modifiers changed from: private */
    public static final void q4(T2 t22, C2655d dVar, View view) {
        if (UptodownApp.f13477F.Z()) {
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
            t22.L4(dVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void r4(T2 t22, C2655d dVar, View view) {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.Z()) {
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
            Intent intent = new Intent(t22, AppInstalledDetailsActivity.class);
            intent.putExtra("appInstalled", dVar);
            t22.startActivity(intent, aVar.a(t22));
        }
    }

    /* access modifiers changed from: private */
    public static final void s4(T2 t22, View view) {
        AlertDialog p22 = t22.p2();
        t.b(p22);
        t22.w4(p22);
    }

    /* access modifiers changed from: private */
    public static final void t4(T2 t22, DialogInterface dialogInterface) {
        t22.f3448R = false;
    }

    /* access modifiers changed from: private */
    public static final void u4(T2 t22, C2655d dVar, View view) {
        if (UptodownApp.f13477F.Z()) {
            t22.H2(dVar.b());
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
        }
    }

    /* access modifiers changed from: private */
    public static final void v4(T2 t22, C2655d dVar, View view) {
        if (UptodownApp.f13477F.Z()) {
            t22.H4(dVar);
            AlertDialog p22 = t22.p2();
            t.b(p22);
            t22.w4(p22);
        }
    }

    private final void w4(AlertDialog alertDialog) {
        alertDialog.dismiss();
        this.f3448R = false;
    }

    private final void z4(C2940B b5, C2655d dVar, int i5) {
        if (UptodownApp.f13477F.Z()) {
            AlertDialog p22 = p2();
            t.b(p22);
            w4(p22);
            b5.a();
            if (dVar.e() == 0) {
                dVar.N(1);
                dVar.c0(C2655d.c.UPDATED);
                E e5 = new E();
                Context applicationContext = getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                e5.c(applicationContext);
            } else {
                dVar.N(0);
                dVar.c0(C2655d.c.OUTDATED);
            }
            b5.v1(dVar);
            b5.m();
            I4(i5, dVar.e());
        }
    }

    public final File A4() {
        return this.f3450T;
    }

    public final boolean B4() {
        return this.f3445O;
    }

    public final void C4(T t5, File file) {
        ApplicationInfo applicationInfo;
        t.e(t5, "updateBBDD");
        t.e(file, "fileUpdateDownloaded");
        if (!file.isDirectory()) {
            file = new File(file.getAbsolutePath()).getParentFile();
        }
        File file2 = file;
        c cVar = new c(this, file2, t5);
        try {
            PackageManager packageManager = getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            applicationInfo = C2301u.a(packageManager, t5.h(), 128);
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            File file3 = new File(applicationInfo.sourceDir);
            ArrayList arrayList = new ArrayList();
            arrayList.add(file3);
            t.b(file2);
            new C2209b(arrayList, file2, cVar, false, this);
            return;
        }
        String string = getString(R.string.installable_files_not_found);
        t.d(string, "getString(...)");
        a2(string);
        J j5 = J.f19942a;
    }

    public final boolean D4() {
        return this.f3451U;
    }

    public final boolean E4() {
        return this.f3448R;
    }

    public final void F4() {
        if (!this.f3444N) {
            this.f3444N = true;
            O3();
        }
    }

    public final void G4(C2655d dVar) {
        String str;
        if (dVar != null) {
            str = dVar.o();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            C2940B a5 = C2940B.f26458v.a(this);
            a5.a();
            t.b(dVar);
            String o5 = dVar.o();
            t.b(o5);
            T G02 = a5.G0(o5);
            if (G02 != null) {
                UptodownApp.a aVar = UptodownApp.f13477F;
                if (aVar.N(G02)) {
                    DownloadWorker.f21359d.c(G02.h());
                    aVar.c0(G02);
                } else if (aVar.O(G02.h())) {
                    aVar.d0(G02.h());
                }
            }
            a5.m();
        }
    }

    public final void H4(C2655d dVar) {
        String str;
        ApplicationInfo applicationInfo = null;
        if (dVar != null) {
            str = dVar.o();
        } else {
            str = null;
        }
        if (str != null) {
            C2940B.a aVar = C2940B.f26458v;
            Context applicationContext = getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            C2940B a5 = aVar.a(applicationContext);
            a5.a();
            String o5 = dVar.o();
            t.b(o5);
            T G02 = a5.G0(o5);
            if (G02 != null) {
                if (G02.c()) {
                    DownloadWorker.a aVar2 = DownloadWorker.f21359d;
                    if (aVar2.h()) {
                        aVar2.o();
                    } else if (UptodownApp.f13477F.M(this)) {
                        aVar2.c(G02.h());
                    } else {
                        Q4(dVar.o(), false);
                    }
                    J j5 = J.f19942a;
                } else {
                    if (G02.a() != null) {
                        C2668q a6 = G02.a();
                        t.b(a6);
                        if (a6.f()) {
                            C2668q a7 = G02.a();
                            t.b(a7);
                            if (s.E(a7.w(), getApplicationContext().getPackageName(), true)) {
                                C2668q a8 = G02.a();
                                t.b(a8);
                                File n5 = a8.n();
                                if (n5 == null || !n5.exists()) {
                                    C2668q a9 = G02.a();
                                    t.b(a9);
                                    Context applicationContext2 = getApplicationContext();
                                    t.d(applicationContext2, "getApplicationContext(...)");
                                    a9.U(applicationContext2);
                                    String string = getString(R.string.installable_files_not_found);
                                    t.d(string, "getString(...)");
                                    a2(string);
                                } else {
                                    Y1(n5);
                                }
                                J j6 = J.f19942a;
                            } else {
                                C2668q a10 = G02.a();
                                t.b(a10);
                                File n6 = a10.n();
                                if (n6 == null || !n6.exists()) {
                                    C2668q a11 = G02.a();
                                    t.b(a11);
                                    Context applicationContext3 = getApplicationContext();
                                    t.d(applicationContext3, "getApplicationContext(...)");
                                    a11.U(applicationContext3);
                                    String string2 = getString(R.string.installable_files_not_found);
                                    t.d(string2, "getString(...)");
                                    a2(string2);
                                    J j7 = J.f19942a;
                                } else if (G02.n() == 1) {
                                    if (!n6.isDirectory()) {
                                        n6 = new File(n6.getAbsolutePath()).getParentFile();
                                    }
                                    File file = n6;
                                    e eVar = new e(this, file, G02);
                                    try {
                                        PackageManager packageManager = getPackageManager();
                                        t.d(packageManager, "getPackageManager(...)");
                                        applicationInfo = C2301u.a(packageManager, G02.h(), 128);
                                    } catch (PackageManager.NameNotFoundException e5) {
                                        e5.printStackTrace();
                                    }
                                    if (applicationInfo != null) {
                                        File file2 = new File(applicationInfo.sourceDir);
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(file2);
                                        t.b(file);
                                        new C2209b(arrayList, file, eVar, false, this);
                                    } else {
                                        String string3 = getString(R.string.installable_files_not_found);
                                        t.d(string3, "getString(...)");
                                        a2(string3);
                                        J j8 = J.f19942a;
                                    }
                                } else {
                                    C2(n6, G02.f());
                                    J j9 = J.f19942a;
                                }
                            }
                        } else {
                            UptodownApp.a aVar3 = UptodownApp.f13477F;
                            if (!aVar3.M(this)) {
                                Q4(dVar.o(), false);
                                J j10 = J.f19942a;
                            } else {
                                String o6 = dVar.o();
                                t.b(o6);
                                if (aVar3.O(o6)) {
                                    String o7 = dVar.o();
                                    t.b(o7);
                                    aVar3.d0(o7);
                                    J j11 = J.f19942a;
                                } else {
                                    y4(dVar);
                                    J j12 = J.f19942a;
                                }
                            }
                        }
                    } else {
                        if (!UptodownApp.f13477F.M(this)) {
                            Q4(dVar.o(), false);
                            J j13 = J.f19942a;
                        } else {
                            y4(dVar);
                            J j14 = J.f19942a;
                        }
                    }
                    a5.m();
                    return;
                }
            }
            a5.m();
            return;
        }
    }

    public final void K4(C2655d dVar) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        new C2388j(this, dVar.b(), new f(this, dVar), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: protected */
    public abstract void M4();

    public final void N3(int i5, boolean z4, Toolbar toolbar) {
        t.e(toolbar, "toolbar");
        if (toolbar.getMenu() != null) {
            Menu menu = toolbar.getMenu();
            t.b(menu);
            menu.findItem(i5).setChecked(z4);
        }
    }

    public final void N4(File file) {
        this.f3450T = file;
    }

    public final void O4(boolean z4) {
        this.f3451U = z4;
    }

    public final void P4(boolean z4) {
        this.f3445O = z4;
    }

    public final void Q4(String str, boolean z4) {
        ArrayList i5;
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (!aVar.T("GenerateQueueWorker", this) && !aVar.T("downloadApkWorker", this) && !aVar.T("DownloadUpdatesWorker", this)) {
            ArrayList arrayList = new ArrayList();
            if (!(z4 || str == null || str.length() == 0)) {
                C2940B.a aVar2 = C2940B.f26458v;
                Context applicationContext = getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                C2940B a5 = aVar2.a(applicationContext);
                a5.a();
                T G02 = a5.G0(str);
                a5.m();
                if (!(G02 == null || (i5 = G02.i()) == null || i5.isEmpty())) {
                    C2667p pVar = new C2667p();
                    ArrayList i6 = G02.i();
                    t.b(i6);
                    arrayList = pVar.e(i6, this);
                }
            }
            if (arrayList.isEmpty()) {
                this.f3445O = true;
                GenerateQueueWorker.f21366e.a(this, z4, str);
                return;
            }
            t.b(str);
            R3(str, z4, arrayList);
        } else if (aVar.T("downloadApkWorker", this)) {
            String string = getString(R.string.error_download_in_progress_wait);
            t.d(string, "getString(...)");
            a2(string);
        }
    }

    public void R3(String str, boolean z4, ArrayList arrayList) {
        t.e(str, "packagename");
        t.e(arrayList, "missingFeatures");
        String string = getString(R.string.msg_warning_incompatible_required_features_to_install);
        t.d(string, "getString(...)");
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new b(this, str, string, arrayList, z4, (C2308e) null), 2, (Object) null);
    }

    public final void R4(int i5) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new i(i5, this, (C2308e) null), 2, (Object) null);
    }

    public void Z() {
        this.f3446P = new C2208a(this, new d(this)).u(this.f3447Q);
        this.f3447Q = new ArrayList();
    }

    public void b1() {
        File file;
        super.b1();
        Z1.h o5 = k.f32g.o();
        t.b(o5);
        if (o5.e() != null && (file = this.f3450T) != null) {
            t.b(file);
            if (!file.isDirectory()) {
                UptodownApp uptodownApp = new UptodownApp();
                File file2 = this.f3450T;
                t.b(file2);
                uptodownApp.Z(file2);
            }
        }
    }

    public final void c4(C2655d dVar, int i5) {
        long j5;
        C2426m0 m0Var;
        Window window;
        NsdServiceInfo e5;
        String k5;
        C2655d dVar2 = dVar;
        int i6 = i5;
        if (!isFinishing() && dVar2 != null) {
            C2426m0 c5 = C2426m0.c(getLayoutInflater());
            this.f3449S = c5;
            if (c5 == null) {
                t.w("dialogBinding");
                c5 = null;
            }
            TextView textView = c5.f23347g;
            k.a aVar = k.f32g;
            textView.setTypeface(aVar.w());
            C2426m0 m0Var2 = this.f3449S;
            if (m0Var2 == null) {
                t.w("dialogBinding");
                m0Var2 = null;
            }
            m0Var2.f23347g.setText(dVar2.m());
            C2426m0 m0Var3 = this.f3449S;
            if (m0Var3 == null) {
                t.w("dialogBinding");
                m0Var3 = null;
            }
            m0Var3.f23360t.setTypeface(aVar.w());
            C2426m0 m0Var4 = this.f3449S;
            if (m0Var4 == null) {
                t.w("dialogBinding");
                m0Var4 = null;
            }
            m0Var4.f23359s.setTypeface(aVar.w());
            C2426m0 m0Var5 = this.f3449S;
            if (m0Var5 == null) {
                t.w("dialogBinding");
                m0Var5 = null;
            }
            m0Var5.f23358r.setTypeface(aVar.w());
            C2426m0 m0Var6 = this.f3449S;
            if (m0Var6 == null) {
                t.w("dialogBinding");
                m0Var6 = null;
            }
            m0Var6.f23357q.setTypeface(aVar.w());
            Drawable j6 = P.f26510a.j(this, dVar2.o());
            C2426m0 m0Var7 = this.f3449S;
            if (m0Var7 == null) {
                t.w("dialogBinding");
                m0Var7 = null;
            }
            m0Var7.f23342b.setImageDrawable(j6);
            String o5 = dVar2.o();
            if (o5 == null || o5.length() == 0 || (k5 = dVar2.k()) == null || k5.length() == 0 || dVar2.b() == 0) {
                C2426m0 m0Var8 = this.f3449S;
                if (m0Var8 == null) {
                    t.w("dialogBinding");
                    m0Var8 = null;
                }
                m0Var8.f23355o.setVisibility(8);
            } else {
                C2426m0 m0Var9 = this.f3449S;
                if (m0Var9 == null) {
                    t.w("dialogBinding");
                    m0Var9 = null;
                }
                m0Var9.f23355o.setTypeface(aVar.x());
                C2426m0 m0Var10 = this.f3449S;
                if (m0Var10 == null) {
                    t.w("dialogBinding");
                    m0Var10 = null;
                }
                m0Var10.f23355o.setOnClickListener(new C0884s2(this, dVar2));
            }
            C2940B.a aVar2 = C2940B.f26458v;
            Context applicationContext = getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            C2940B a5 = aVar2.a(applicationContext);
            a5.a();
            String o6 = dVar2.o();
            t.b(o6);
            T G02 = a5.G0(o6);
            a5.m();
            C2668q a6 = G02 != null ? G02.a() : null;
            if (G02 != null) {
                C2426m0 m0Var11 = this.f3449S;
                if (m0Var11 == null) {
                    t.w("dialogBinding");
                    m0Var11 = null;
                }
                m0Var11.f23362v.setTypeface(aVar.x());
                if (G02.c()) {
                    C2426m0 m0Var12 = this.f3449S;
                    if (m0Var12 == null) {
                        t.w("dialogBinding");
                        m0Var12 = null;
                    }
                    m0Var12.f23362v.setText(getString(R.string.action_cancel_download));
                } else if (a6 != null && a6.f()) {
                    C2426m0 m0Var13 = this.f3449S;
                    if (m0Var13 == null) {
                        t.w("dialogBinding");
                        m0Var13 = null;
                    }
                    m0Var13.f23362v.setText(getString(R.string.notification_msg_update_uptodown));
                } else if (a6 == null || a6.x() <= 0) {
                    C2426m0 m0Var14 = this.f3449S;
                    if (m0Var14 == null) {
                        t.w("dialogBinding");
                        m0Var14 = null;
                    }
                    m0Var14.f23362v.setText(getString(R.string.action_update));
                } else {
                    C2426m0 m0Var15 = this.f3449S;
                    if (m0Var15 == null) {
                        t.w("dialogBinding");
                        m0Var15 = null;
                    }
                    m0Var15.f23362v.setText(getString(R.string.updates_button_resume));
                }
                C2426m0 m0Var16 = this.f3449S;
                if (m0Var16 == null) {
                    t.w("dialogBinding");
                    m0Var16 = null;
                }
                m0Var16.f23362v.setOnClickListener(new C0892t2(this, dVar2));
            } else {
                C2426m0 m0Var17 = this.f3449S;
                if (m0Var17 == null) {
                    t.w("dialogBinding");
                    m0Var17 = null;
                }
                m0Var17.f23362v.setVisibility(8);
            }
            if (!s.E(getPackageName(), dVar2.o(), true)) {
                C2426m0 m0Var18 = this.f3449S;
                if (m0Var18 == null) {
                    t.w("dialogBinding");
                    m0Var18 = null;
                }
                m0Var18.f23354n.setTypeface(aVar.x());
                C2426m0 m0Var19 = this.f3449S;
                if (m0Var19 == null) {
                    t.w("dialogBinding");
                    m0Var19 = null;
                }
                m0Var19.f23354n.setOnClickListener(new C0900u2(dVar2, this));
                C2426m0 m0Var20 = this.f3449S;
                if (m0Var20 == null) {
                    t.w("dialogBinding");
                    m0Var20 = null;
                }
                m0Var20.f23361u.setTypeface(aVar.x());
                C2426m0 m0Var21 = this.f3449S;
                if (m0Var21 == null) {
                    t.w("dialogBinding");
                    m0Var21 = null;
                }
                m0Var21.f23361u.setOnClickListener(new C0908v2(dVar2, this));
            } else {
                C2426m0 m0Var22 = this.f3449S;
                if (m0Var22 == null) {
                    t.w("dialogBinding");
                    m0Var22 = null;
                }
                m0Var22.f23354n.setVisibility(8);
                C2426m0 m0Var23 = this.f3449S;
                if (m0Var23 == null) {
                    t.w("dialogBinding");
                    m0Var23 = null;
                }
                m0Var23.f23361u.setVisibility(8);
            }
            if (UptodownApp.f13477F.K()) {
                C2426m0 m0Var24 = this.f3449S;
                if (m0Var24 == null) {
                    t.w("dialogBinding");
                    m0Var24 = null;
                }
                m0Var24.f23354n.setText(R.string.debug_title_info_app);
                C2426m0 m0Var25 = this.f3449S;
                if (m0Var25 == null) {
                    t.w("dialogBinding");
                    m0Var25 = null;
                }
                m0Var25.f23354n.setOnClickListener(new C0916w2(this, dVar2));
                C2426m0 m0Var26 = this.f3449S;
                if (m0Var26 == null) {
                    t.w("dialogBinding");
                    m0Var26 = null;
                }
                m0Var26.f23354n.setVisibility(0);
            }
            String z4 = dVar2.z();
            if (z4 == null || z4.length() == 0) {
                C2426m0 m0Var27 = this.f3449S;
                if (m0Var27 == null) {
                    t.w("dialogBinding");
                    m0Var27 = null;
                }
                m0Var27.f23356p.setVisibility(8);
            } else {
                C2426m0 m0Var28 = this.f3449S;
                if (m0Var28 == null) {
                    t.w("dialogBinding");
                    m0Var28 = null;
                }
                m0Var28.f23356p.setTypeface(aVar.x());
                C2426m0 m0Var29 = this.f3449S;
                if (m0Var29 == null) {
                    t.w("dialogBinding");
                    m0Var29 = null;
                }
                m0Var29.f23356p.setOnClickListener(new C0924x2(this, dVar2));
            }
            C2426m0 m0Var30 = this.f3449S;
            if (m0Var30 == null) {
                t.w("dialogBinding");
                m0Var30 = null;
            }
            m0Var30.f23352l.setTypeface(aVar.x());
            C2426m0 m0Var31 = this.f3449S;
            if (m0Var31 == null) {
                t.w("dialogBinding");
                m0Var31 = null;
            }
            m0Var31.f23352l.setOnClickListener(new C0932y2(this, dVar2));
            C2263c r5 = aVar.r();
            if (r5 == null || !r5.j()) {
                j5 = 0;
            } else {
                Z1.h o7 = aVar.o();
                String serviceName = (o7 == null || (e5 = o7.e()) == null) ? null : e5.getServiceName();
                if (serviceName != null) {
                    C2426m0 m0Var32 = this.f3449S;
                    if (m0Var32 == null) {
                        t.w("dialogBinding");
                        m0Var32 = null;
                    }
                    TextView textView2 = m0Var32.f23352l;
                    Q q5 = Q.f24695a;
                    j5 = 0;
                    String format = String.format("%s%s", Arrays.copyOf(new Object[]{getString(R.string.nsd_option_send_to), Z1.h.f20257h.c(serviceName)}, 2));
                    t.d(format, "format(...)");
                    textView2.setText(format);
                } else {
                    j5 = 0;
                    C2426m0 m0Var33 = this.f3449S;
                    if (m0Var33 == null) {
                        t.w("dialogBinding");
                        m0Var33 = null;
                    }
                    m0Var33.f23352l.setVisibility(8);
                }
            }
            if (dVar2.h() != 1 || dVar2.b() == j5) {
                C2426m0 m0Var34 = this.f3449S;
                if (m0Var34 == null) {
                    t.w("dialogBinding");
                    m0Var34 = null;
                }
                m0Var34.f23353m.setVisibility(8);
            } else {
                C2426m0 m0Var35 = this.f3449S;
                if (m0Var35 == null) {
                    t.w("dialogBinding");
                    m0Var35 = null;
                }
                m0Var35.f23353m.setTypeface(aVar.x());
                C2426m0 m0Var36 = this.f3449S;
                if (m0Var36 == null) {
                    t.w("dialogBinding");
                    m0Var36 = null;
                }
                m0Var36.f23353m.setOnClickListener(new C0940z2(this, dVar2));
            }
            C2426m0 m0Var37 = this.f3449S;
            if (m0Var37 == null) {
                t.w("dialogBinding");
                m0Var37 = null;
            }
            m0Var37.f23350j.setTypeface(aVar.x());
            C2426m0 m0Var38 = this.f3449S;
            if (m0Var38 == null) {
                t.w("dialogBinding");
                m0Var38 = null;
            }
            m0Var38.f23345e.setChecked(dVar2.e() == 0);
            C2426m0 m0Var39 = this.f3449S;
            if (m0Var39 == null) {
                t.w("dialogBinding");
                m0Var39 = null;
            }
            m0Var39.f23343c.setOnClickListener(new A2(this, a5, dVar2, i6));
            C2426m0 m0Var40 = this.f3449S;
            if (m0Var40 == null) {
                t.w("dialogBinding");
                m0Var40 = null;
            }
            m0Var40.f23345e.setOnClickListener(new B2(this, a5, dVar2, i6));
            if (G02 != null && dVar2.w() == C2655d.c.OUTDATED && dVar2.e() == 0) {
                C2426m0 m0Var41 = this.f3449S;
                if (m0Var41 == null) {
                    t.w("dialogBinding");
                    m0Var41 = null;
                }
                m0Var41.f23349i.setTypeface(aVar.x());
                C2426m0 m0Var42 = this.f3449S;
                if (m0Var42 == null) {
                    t.w("dialogBinding");
                    m0Var42 = null;
                }
                m0Var42.f23349i.setOnClickListener(new D2(G02, this));
                C2426m0 m0Var43 = this.f3449S;
                if (m0Var43 == null) {
                    t.w("dialogBinding");
                    m0Var43 = null;
                }
                m0Var43.f23364x.setTypeface(aVar.x());
                C2426m0 m0Var44 = this.f3449S;
                if (m0Var44 == null) {
                    t.w("dialogBinding");
                    m0Var44 = null;
                }
                m0Var44.f23364x.setOnClickListener(new L2(this, dVar2, G02));
                String f5 = G02.f();
                if (f5 == null || f5.length() == 0) {
                    C2426m0 m0Var45 = this.f3449S;
                    if (m0Var45 == null) {
                        t.w("dialogBinding");
                        m0Var45 = null;
                    }
                    m0Var45.f23363w.setVisibility(8);
                } else {
                    C2426m0 m0Var46 = this.f3449S;
                    if (m0Var46 == null) {
                        t.w("dialogBinding");
                        m0Var46 = null;
                    }
                    m0Var46.f23363w.setTypeface(aVar.x());
                    C2426m0 m0Var47 = this.f3449S;
                    if (m0Var47 == null) {
                        t.w("dialogBinding");
                        m0Var47 = null;
                    }
                    m0Var47.f23363w.setOnClickListener(new M2(this, G02));
                }
            } else {
                C2426m0 m0Var48 = this.f3449S;
                if (m0Var48 == null) {
                    t.w("dialogBinding");
                    m0Var48 = null;
                }
                m0Var48.f23349i.setVisibility(8);
                C2426m0 m0Var49 = this.f3449S;
                if (m0Var49 == null) {
                    t.w("dialogBinding");
                    m0Var49 = null;
                }
                m0Var49.f23364x.setVisibility(8);
                C2426m0 m0Var50 = this.f3449S;
                if (m0Var50 == null) {
                    t.w("dialogBinding");
                    m0Var50 = null;
                }
                m0Var50.f23363w.setVisibility(8);
            }
            if (G02 != null) {
                C2426m0 m0Var51 = this.f3449S;
                if (m0Var51 == null) {
                    t.w("dialogBinding");
                    m0Var51 = null;
                }
                m0Var51.f23351k.setVisibility(0);
                C2426m0 m0Var52 = this.f3449S;
                if (m0Var52 == null) {
                    t.w("dialogBinding");
                    m0Var52 = null;
                }
                m0Var52.f23351k.setTypeface(aVar.x());
                if (G02.m()) {
                    C2426m0 m0Var53 = this.f3449S;
                    if (m0Var53 == null) {
                        t.w("dialogBinding");
                        m0Var53 = null;
                    }
                    m0Var53.f23351k.setText(R.string.reactivate_skipped_update);
                } else {
                    C2426m0 m0Var54 = this.f3449S;
                    if (m0Var54 == null) {
                        t.w("dialogBinding");
                        m0Var54 = null;
                    }
                    m0Var54.f23351k.setText(R.string.skip_update);
                }
                C2426m0 m0Var55 = this.f3449S;
                if (m0Var55 == null) {
                    t.w("dialogBinding");
                    m0Var55 = null;
                }
                m0Var55.f23351k.setOnClickListener(new N2(this, G02, a5, i6));
            } else {
                C2426m0 m0Var56 = this.f3449S;
                if (m0Var56 == null) {
                    t.w("dialogBinding");
                    m0Var56 = null;
                }
                m0Var56.f23351k.setVisibility(8);
            }
            if (dVar2.o() != null) {
                C2426m0 m0Var57 = this.f3449S;
                if (m0Var57 == null) {
                    t.w("dialogBinding");
                    m0Var57 = null;
                }
                m0Var57.f23348h.setVisibility(0);
                C2426m0 m0Var58 = this.f3449S;
                if (m0Var58 == null) {
                    t.w("dialogBinding");
                    m0Var58 = null;
                }
                m0Var58.f23348h.setTypeface(aVar.x());
                C2426m0 m0Var59 = this.f3449S;
                if (m0Var59 == null) {
                    t.w("dialogBinding");
                    m0Var59 = null;
                }
                m0Var59.f23348h.setOnClickListener(new O2(this, dVar2));
            }
            if (dVar2.r() != null) {
                C2426m0 m0Var60 = this.f3449S;
                if (m0Var60 == null) {
                    t.w("dialogBinding");
                    m0Var60 = null;
                }
                m0Var60.f23365y.setVisibility(0);
                C2426m0 m0Var61 = this.f3449S;
                if (m0Var61 == null) {
                    t.w("dialogBinding");
                    m0Var61 = null;
                }
                m0Var61.f23365y.setTypeface(aVar.x());
                C2426m0 m0Var62 = this.f3449S;
                if (m0Var62 == null) {
                    t.w("dialogBinding");
                    m0Var62 = null;
                }
                m0Var62.f23365y.setOnClickListener(new P2(this, dVar2));
            }
            C2426m0 m0Var63 = this.f3449S;
            if (m0Var63 == null) {
                t.w("dialogBinding");
                m0Var63 = null;
            }
            m0Var63.f23346f.setTypeface(aVar.x());
            C2426m0 m0Var64 = this.f3449S;
            if (m0Var64 == null) {
                t.w("dialogBinding");
                m0Var64 = null;
            }
            m0Var64.f23346f.setOnClickListener(new Q2(this, dVar2));
            C2426m0 m0Var65 = this.f3449S;
            if (m0Var65 == null) {
                t.w("dialogBinding");
                m0Var65 = null;
            }
            m0Var65.f23366z.setOnClickListener(new R2(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C2426m0 m0Var66 = this.f3449S;
            if (m0Var66 == null) {
                t.w("dialogBinding");
                m0Var = null;
            } else {
                m0Var = m0Var66;
            }
            builder.setView(m0Var.getRoot());
            P2(builder.create());
            AlertDialog p22 = p2();
            if (p22 != null) {
                p22.setOnCancelListener(new S2(this));
                J j7 = J.f19942a;
            }
            if (!isFinishing()) {
                AlertDialog p23 = p2();
                if (!(p23 == null || (window = p23.getWindow()) == null)) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    J j8 = J.f19942a;
                }
                AlertDialog p24 = p2();
                if (p24 != null) {
                    p24.show();
                    J j9 = J.f19942a;
                }
                this.f3448R = true;
            }
        }
    }

    public final void x4(int i5, boolean z4, Toolbar toolbar) {
        t.e(toolbar, "toolbar");
        if (toolbar.getMenu() != null) {
            Menu menu = toolbar.getMenu();
            t.b(menu);
            menu.findItem(i5).setEnabled(z4);
        }
    }

    public final void y4(C2655d dVar) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        UptodownApp.a aVar = UptodownApp.f13477F;
        String o5 = dVar.o();
        t.b(o5);
        if (!aVar.O(o5)) {
            aVar.c(dVar);
        }
    }

    public static final class d implements C2225b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T2 f3463a;

        d(T2 t22) {
            this.f3463a = t22;
        }

        public void a(C2258b bVar) {
            t.e(bVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            T2 t22 = this.f3463a;
            t22.I(t22.getString(R.string.backup_no_free_space));
        }

        public void b(C2258b bVar) {
            t.e(bVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            T2 t22 = this.f3463a;
            t22.I(t22.getString(R.string.core_msg_cannot_write_path));
        }

        public void c(ArrayList arrayList) {
            t.e(arrayList, "apps");
            NsdServiceInfo nsdServiceInfo = null;
            if (arrayList.size() == 1) {
                if (this.f3463a.D4()) {
                    AlertDialog p22 = this.f3463a.p2();
                    if (p22 != null) {
                        p22.dismiss();
                    }
                    this.f3463a.O4(false);
                    Object c5 = new C2201a(this.f3463a).c();
                    if (c5 instanceof File) {
                        T2 t22 = this.f3463a;
                        String a5 = ((C2258b) arrayList.get(0)).a();
                        t.b(a5);
                        t22.N4(new File((File) c5, a5));
                        Z1.h o5 = k.f32g.o();
                        if (o5 != null) {
                            nsdServiceInfo = o5.e();
                        }
                        if (nsdServiceInfo == null) {
                            this.f3463a.T0();
                            return;
                        }
                        File A4 = this.f3463a.A4();
                        if (A4 != null && A4.exists()) {
                            File A42 = this.f3463a.A4();
                            t.b(A42);
                            if (!A42.isDirectory()) {
                                UptodownApp uptodownApp = new UptodownApp();
                                File A43 = this.f3463a.A4();
                                t.b(A43);
                                uptodownApp.Z(A43);
                                return;
                            }
                        }
                        T2 t23 = this.f3463a;
                        t23.I(t23.getString(R.string.error_generico));
                    } else if (c5 instanceof DocumentFile) {
                        String a6 = ((C2258b) arrayList.get(0)).a();
                        t.b(a6);
                        DocumentFile findFile = ((DocumentFile) c5).findFile(a6);
                        if (findFile != null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(findFile);
                            new C2209b(arrayList2, new C2290j().g(this.f3463a), new a(this.f3463a, arrayList), false, this.f3463a);
                        }
                    }
                } else {
                    this.f3463a.S3(((C2258b) arrayList.get(0)).b(), ((C2258b) arrayList.get(0)).a());
                }
            } else if (arrayList.size() > 0) {
                Q q5 = Q.f24695a;
                String string = this.f3463a.getString(R.string.msg_backup_x_apps);
                t.d(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(arrayList.size())}, 1));
                t.d(format, "format(...)");
                this.f3463a.S3(format, (String) null);
            }
        }

        public void d(String str) {
            t.e(str, "appName");
            TextView K32 = this.f3463a.f3442L;
            if (K32 != null) {
                K32.setText(str);
            }
            TextView L32 = this.f3463a.f3443M;
            if (L32 != null) {
                Q q5 = Q.f24695a;
                String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{0}, 1));
                t.d(format, "format(...)");
                L32.setText(format);
            }
            ProgressBar J32 = this.f3463a.f3441K;
            if (J32 != null) {
                J32.setProgress(0);
            }
        }

        public void e(C2258b bVar) {
            t.e(bVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            T2 t22 = this.f3463a;
            t22.I(t22.getString(R.string.core_msg_cannot_write_path));
        }

        public void f(int i5) {
            TextView L32 = this.f3463a.f3443M;
            if (L32 != null) {
                Q q5 = Q.f24695a;
                String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(i5)}, 1));
                t.d(format, "format(...)");
                L32.setText(format);
            }
            ProgressBar J32 = this.f3463a.f3441K;
            if (J32 != null) {
                J32.setProgress(i5);
            }
        }

        public void g(C2258b bVar, int i5) {
            t.e(bVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            this.f3463a.P3(bVar.b(), i5);
        }

        public static final class a implements C2227d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ T2 f3464a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ArrayList f3465b;

            a(T2 t22, ArrayList arrayList) {
                this.f3464a = t22;
                this.f3465b = arrayList;
            }

            public void a(DocumentFile documentFile) {
                t.e(documentFile, "docFile");
            }

            public void b(Object obj, int i5, int i6, long j5) {
                t.e(obj, "file");
            }

            public void c(File file) {
                t.e(file, "file");
            }

            public void d(DocumentFile documentFile) {
                t.e(documentFile, "docFile");
            }

            public void e(int i5, String str, long j5, long j6) {
                t.e(str, "currentFilename");
            }

            public void f(File file) {
                t.e(file, "file");
            }

            public void h(Object obj) {
                t.e(obj, "file");
            }

            public void i() {
                NsdServiceInfo nsdServiceInfo;
                T2 t22 = this.f3464a;
                File g5 = new C2290j().g(this.f3464a);
                String a5 = ((C2258b) this.f3465b.get(0)).a();
                t.b(a5);
                t22.N4(new File(g5, a5));
                Z1.h o5 = k.f32g.o();
                if (o5 != null) {
                    nsdServiceInfo = o5.e();
                } else {
                    nsdServiceInfo = null;
                }
                if (nsdServiceInfo == null) {
                    this.f3464a.T0();
                    return;
                }
                File A4 = this.f3464a.A4();
                if (A4 != null && A4.exists()) {
                    File A42 = this.f3464a.A4();
                    t.b(A42);
                    if (!A42.isDirectory()) {
                        UptodownApp uptodownApp = new UptodownApp();
                        File A43 = this.f3464a.A4();
                        t.b(A43);
                        uptodownApp.Z(A43);
                        return;
                    }
                }
                T2 t23 = this.f3464a;
                t23.I(t23.getString(R.string.error_generico));
            }

            public void g() {
            }
        }
    }

    public static final class c implements C2227d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T2 f3460a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f3461b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T f3462c;

        c(T2 t22, File file, T t5) {
            this.f3460a = t22;
            this.f3461b = file;
            this.f3462c = t5;
        }

        public void a(DocumentFile documentFile) {
            t.e(documentFile, "docFile");
        }

        public void b(Object obj, int i5, int i6, long j5) {
            t.e(obj, "file");
        }

        public void c(File file) {
            t.e(file, "file");
        }

        public void d(DocumentFile documentFile) {
            t.e(documentFile, "docFile");
        }

        public void e(int i5, String str, long j5, long j6) {
            t.e(str, "currentFilename");
        }

        public void f(File file) {
            t.e(file, "file");
        }

        public void h(Object obj) {
            t.e(obj, "file");
        }

        public void i() {
            T2 t22 = this.f3460a;
            File file = this.f3461b;
            t.b(file);
            t22.C2(file, this.f3462c.f());
        }

        public void g() {
        }
    }

    public static final class e implements C2227d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T2 f3466a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f3467b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T f3468c;

        e(T2 t22, File file, T t5) {
            this.f3466a = t22;
            this.f3467b = file;
            this.f3468c = t5;
        }

        public void a(DocumentFile documentFile) {
            t.e(documentFile, "docFile");
        }

        public void b(Object obj, int i5, int i6, long j5) {
            t.e(obj, "file");
        }

        public void c(File file) {
            t.e(file, "file");
        }

        public void d(DocumentFile documentFile) {
            t.e(documentFile, "docFile");
        }

        public void e(int i5, String str, long j5, long j6) {
            t.e(str, "currentFilename");
        }

        public void f(File file) {
            t.e(file, "file");
        }

        public void h(Object obj) {
            t.e(obj, "file");
        }

        public void i() {
            T2 t22 = this.f3466a;
            File file = this.f3467b;
            t.b(file);
            t22.C2(file, this.f3468c.f());
        }

        public void g() {
        }
    }

    /* access modifiers changed from: private */
    public static final void Y3(View view) {
    }

    public void I4(int i5, int i6) {
    }

    public void J4(int i5, int i6) {
    }
}
