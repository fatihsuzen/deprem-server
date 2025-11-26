package T1;

import S1.f;
import S1.g;
import S1.i;
import S1.j;
import S1.k;
import V1.C2205a;
import X1.C2233j;
import Y1.C2260d;
import Z1.C2263c;
import Z1.h;
import android.app.AlertDialog;
import android.app.Application;
import android.graphics.drawable.ColorDrawable;
import android.net.nsd.NsdServiceInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2290j;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;

public abstract class S0 extends C2194t {

    /* renamed from: p  reason: collision with root package name */
    private TextView f19090p;

    /* renamed from: q  reason: collision with root package name */
    private ProgressBar f19091q;

    /* renamed from: r  reason: collision with root package name */
    private AlertDialog f19092r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f19093s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f19094t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f19095u;

    /* renamed from: v  reason: collision with root package name */
    private LinearLayout f19096v;

    /* renamed from: w  reason: collision with root package name */
    private LinearLayout.LayoutParams f19097w;

    public static final class a implements C2233j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ S0 f19098a;

        a(S0 s02) {
            this.f19098a = s02;
        }

        public void a(View view, int i5) {
            this.f19098a.Z0();
            k.a aVar = k.f32g;
            h o5 = aVar.o();
            t.b(o5);
            int size = o5.g().size();
            if (size > 0 && size > i5) {
                h o6 = aVar.o();
                t.b(o6);
                Object obj = o6.g().get(i5);
                t.d(obj, "get(...)");
                h o7 = aVar.o();
                t.b(o7);
                o7.k((NsdServiceInfo) obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void Q0(S0 s02, C2260d dVar) {
        s02.k1(dVar);
    }

    private final void R0() {
        View inflate = View.inflate(this, g.dialog_sending_file, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(f.tv_percentage_dialog_sending);
        this.f19090p = textView;
        if (textView != null) {
            textView.setTypeface(k.f32g.w());
        }
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(f.progressbar_dialog_sending);
        this.f19091q = progressBar;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView2 = (TextView) inflate.findViewById(f.tv_cancel_dialog_sending);
        this.f19095u = textView2;
        t.b(textView2);
        k.a aVar = k.f32g;
        textView2.setTypeface(aVar.w());
        TextView textView3 = this.f19095u;
        if (textView3 != null) {
            textView3.setOnClickListener(new G0(this));
        }
        TextView textView4 = (TextView) inflate.findViewById(f.tv_sending_app);
        this.f19093s = textView4;
        if (textView4 != null) {
            textView4.setTypeface(aVar.x());
        }
        TextView textView5 = (TextView) inflate.findViewById(f.tv_device_to_sending);
        this.f19094t = textView5;
        if (textView5 != null) {
            textView5.setTypeface(aVar.w());
        }
        t.b(inflate);
        j1(inflate);
    }

    /* access modifiers changed from: private */
    public static final void S0(S0 s02, View view) {
        s02.Z0();
        C2263c r5 = k.f32g.r();
        t.b(r5);
        r5.r();
        s02.e1();
    }

    /* access modifiers changed from: private */
    public static final void U0(S0 s02, View view) {
        s02.Z0();
        s02.e1();
    }

    /* access modifiers changed from: private */
    public static final void W0(S0 s02, String str, String str2) {
        s02.Z0();
        if (new C2290j().o(str)) {
            s02.n1(str);
            return;
        }
        s02.I(s02.getString(i.msg_file_received) + str + ' ' + str2);
    }

    /* access modifiers changed from: private */
    public static final void Y0(S0 s02) {
        s02.Z0();
        s02.q1();
    }

    /* access modifiers changed from: private */
    public final void Z0() {
        LinearLayout linearLayout = this.f19096v;
        if (linearLayout == null) {
            AlertDialog alertDialog = this.f19092r;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.f19092r = null;
            return;
        }
        t.b(linearLayout);
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = this.f19096v;
        t.b(linearLayout2);
        linearLayout2.setVisibility(8);
    }

    private final boolean a1() {
        LinearLayout linearLayout;
        AlertDialog alertDialog = this.f19092r;
        if ((alertDialog == null || !alertDialog.isShowing()) && ((linearLayout = this.f19096v) == null || linearLayout.getVisibility() != 0)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void d1(S0 s02, String str) {
        s02.Z0();
        s02.I(str);
    }

    /* access modifiers changed from: private */
    public static final void g1(S0 s02, NsdServiceInfo nsdServiceInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(s02.getString(i.msg_connected_to_service));
        h.a aVar = h.f20257h;
        String serviceName = nsdServiceInfo.getServiceName();
        t.d(serviceName, "getServiceName(...)");
        sb.append(aVar.c(serviceName));
        s02.u0(sb.toString());
    }

    /* access modifiers changed from: private */
    public static final void i1(S0 s02, String str) {
        s02.Z0();
        s02.I(str);
        s02.e1();
    }

    private final void j1(View view) {
        Window window;
        AlertDialog alertDialog;
        LinearLayout linearLayout = this.f19096v;
        if (linearLayout == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(view);
            builder.setCancelable(false);
            AlertDialog create = builder.create();
            this.f19092r = create;
            if (create != null) {
                window = create.getWindow();
            } else {
                window = null;
            }
            t.b(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (!isFinishing() && (alertDialog = this.f19092r) != null) {
                alertDialog.show();
                return;
            }
            return;
        }
        t.b(linearLayout);
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = this.f19096v;
        t.b(linearLayout2);
        linearLayout2.addView(view, this.f19097w);
        LinearLayout linearLayout3 = this.f19096v;
        t.b(linearLayout3);
        linearLayout3.setVisibility(0);
    }

    private final void k1(C2260d dVar) {
        Z0();
        View inflate = View.inflate(this, g.dialog_confirm_receive, (ViewGroup) null);
        View findViewById = inflate.findViewById(f.tv_msg_confirm);
        t.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        Q q5 = Q.f24695a;
        String string = getString(i.msg_confirm_receive_file);
        t.d(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{dVar.f(), dVar.e()}, 2));
        t.d(format, "format(...)");
        textView.setText(format);
        View findViewById2 = inflate.findViewById(f.tv_confirm_receive);
        t.d(findViewById2, "findViewById(...)");
        TextView textView2 = (TextView) findViewById2;
        textView2.setTypeface(aVar.x());
        textView2.setOnClickListener(new E0(this, dVar));
        View findViewById3 = inflate.findViewById(f.tv_cancel);
        t.d(findViewById3, "findViewById(...)");
        TextView textView3 = (TextView) findViewById3;
        textView3.setTypeface(aVar.w());
        textView3.setOnClickListener(new F0(this));
        t.b(inflate);
        j1(inflate);
    }

    /* access modifiers changed from: private */
    public static final void l1(S0 s02, C2260d dVar, View view) {
        s02.Z0();
        s02.s1(dVar.e());
        C2263c r5 = k.f32g.r();
        t.b(r5);
        r5.o(true);
    }

    /* access modifiers changed from: private */
    public static final void m1(S0 s02, View view) {
        s02.Z0();
        C2263c r5 = k.f32g.r();
        t.b(r5);
        r5.o(false);
        s02.e1();
    }

    private final void n1(String str) {
        Z0();
        View inflate = View.inflate(this, g.dialog_receiving_finished, (ViewGroup) null);
        View findViewById = inflate.findViewById(f.tv_receiving_finished);
        t.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView.setText(str);
        View findViewById2 = inflate.findViewById(f.tv_install);
        t.d(findViewById2, "findViewById(...)");
        TextView textView2 = (TextView) findViewById2;
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new R0(this, str));
        View findViewById3 = inflate.findViewById(f.tv_cancel);
        t.d(findViewById3, "findViewById(...)");
        TextView textView3 = (TextView) findViewById3;
        textView3.setTypeface(aVar.w());
        textView3.setText(getString(17039370));
        textView3.setOnClickListener(new D0(this));
        t.b(inflate);
        j1(inflate);
    }

    /* access modifiers changed from: private */
    public static final void o1(S0 s02, String str, View view) {
        j.f(new j(s02), new File(new C2290j().f(s02), str), (String) null, false, 6, (Object) null);
        s02.Z0();
        s02.e1();
    }

    /* access modifiers changed from: private */
    public static final void p1(S0 s02, View view) {
        s02.Z0();
        s02.e1();
    }

    private final void q1() {
        Z0();
        View inflate = View.inflate(this, g.dialog_receiving_finished, (ViewGroup) null);
        View findViewById = inflate.findViewById(f.tv_receiving_finished);
        t.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView.setText(getString(i.nsd_app_sent_successfully));
        View findViewById2 = inflate.findViewById(f.tv_install);
        t.d(findViewById2, "findViewById(...)");
        ((TextView) findViewById2).setVisibility(8);
        View findViewById3 = inflate.findViewById(f.tv_cancel);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        textView2.setTypeface(aVar.w());
        textView2.setText(getString(17039370));
        textView2.setOnClickListener(new Q0(this));
        t.b(inflate);
        j1(inflate);
    }

    /* access modifiers changed from: private */
    public static final void r1(S0 s02, View view) {
        s02.Z0();
        s02.e1();
    }

    private final void s1(String str) {
        TextView textView;
        R0();
        TextView textView2 = this.f19093s;
        if (textView2 != null) {
            textView2.setText(getString(i.msg_receiving));
        }
        if (str != null && (textView = this.f19094t) != null) {
            textView.setText(str);
        }
    }

    private final void t1() {
        String str;
        TextView textView;
        NsdServiceInfo e5;
        R0();
        TextView textView2 = this.f19093s;
        if (textView2 != null) {
            textView2.setText(getString(i.sending_app_to));
        }
        h o5 = k.f32g.o();
        if (o5 == null || (e5 = o5.e()) == null) {
            str = null;
        } else {
            str = e5.getServiceName();
        }
        if (str != null && (textView = this.f19094t) != null) {
            textView.setText(h.f20257h.c(str));
        }
    }

    /* access modifiers changed from: private */
    public static final void v1(S0 s02, boolean z4) {
        TextView textView = s02.f19090p;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        ProgressBar progressBar = s02.f19091q;
        if (progressBar != null) {
            progressBar.setIndeterminate(z4);
        }
    }

    /* access modifiers changed from: private */
    public static final void x1(S0 s02) {
        s02.t1();
        ProgressBar progressBar = s02.f19091q;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
    }

    /* access modifiers changed from: private */
    public static final void z1(S0 s02, int i5) {
        ProgressBar progressBar = s02.f19091q;
        if (progressBar != null) {
            progressBar.setProgress(i5);
        }
        TextView textView = s02.f19090p;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(i5);
            sb.append('%');
            textView.setText(sb.toString());
        }
    }

    public final void P0(C2260d dVar) {
        t.e(dVar, "fileTransferInfo");
        runOnUiThread(new P0(this, dVar));
    }

    public final void T0() {
        Integer num;
        ArrayList g5;
        k.a aVar = k.f32g;
        h o5 = aVar.o();
        if (o5 == null || (g5 = o5.g()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(g5.size());
        }
        t.b(num);
        if (num.intValue() > 0) {
            a aVar2 = new a(this);
            View inflate = View.inflate(this, g.devices_available_nsd, (ViewGroup) null);
            h o6 = aVar.o();
            t.b(o6);
            C2205a aVar3 = new C2205a(o6.g(), aVar2);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(f.rv_devices);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), 1, false));
            }
            recyclerView.setAdapter(aVar3);
            View findViewById = inflate.findViewById(f.tv_cancel);
            t.d(findViewById, "findViewById(...)");
            TextView textView = (TextView) findViewById;
            textView.setTypeface(aVar.w());
            textView.setOnClickListener(new H0(this));
            t.b(inflate);
            j1(inflate);
            return;
        }
        I(getString(i.nsd_no_devices_available));
    }

    public final void V0(String str, String str2) {
        t.e(str, "filename");
        runOnUiThread(new N0(this, str, str2));
    }

    public final void X0() {
        runOnUiThread(new K0(this));
        k.f32g.b();
    }

    public final void c1(String str) {
        t.e(str, NotificationCompat.CATEGORY_MESSAGE);
        runOnUiThread(new J0(this, str));
    }

    public abstract void e1();

    public void f1(NsdServiceInfo nsdServiceInfo) {
        t.e(nsdServiceInfo, "nsdServiceInfo");
        runOnUiThread(new I0(this, nsdServiceInfo));
    }

    public final void h1(String str) {
        runOnUiThread(new M0(this, str));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        h o5;
        super.onResume();
        k.a aVar = k.f32g;
        C2263c r5 = aVar.r();
        if (r5 != null && !r5.j()) {
            Application application = getApplication();
            t.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
            if (!((k) application).Q().get() && (o5 = aVar.o()) != null) {
                o5.d();
            }
        }
        if (!a1()) {
            return;
        }
        if (aVar.s()) {
            aVar.P(false);
            X0();
        } else if (aVar.k() != null) {
            String k5 = aVar.k();
            t.b(k5);
            V0(k5, aVar.l());
            aVar.H((String) null);
            aVar.I((String) null);
        } else if (aVar.u() != null) {
            h1(aVar.u());
            aVar.R((String) null);
        } else if (aVar.t() != null) {
            String t5 = aVar.t();
            t.b(t5);
            c1(t5);
            aVar.Q((String) null);
        }
    }

    public final void u1(boolean z4) {
        runOnUiThread(new O0(this, z4));
    }

    public final void w1() {
        runOnUiThread(new C0(this));
    }

    public final void y1(int i5) {
        runOnUiThread(new L0(this, i5));
    }

    public void b1() {
    }
}
