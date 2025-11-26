package com.uptodown.activities;

import D2.g;
import O1.A;
import O1.B;
import O1.C;
import O1.C0881s;
import O1.C0889t;
import O1.C0897u;
import O1.C0905v;
import O1.C0913w;
import O1.C0921x;
import O1.C0929y;
import O1.C0937z;
import O1.D;
import O1.G;
import R1.C0991w;
import S1.k;
import T1.S0;
import U1.C2201a;
import W1.C2210c;
import W2.J;
import W2.u;
import X1.C2231h;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b2.C2275G;
import b2.C2279K;
import b2.C2286f;
import b2.C2292l;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.core.view.WrapContentLinearLayoutManager;
import com.uptodown.workers.DownloadApkWorker;
import g2.C2388j;
import g2.C2389k;
import g2.C2392n;
import h2.C2400D;
import h2.C2436s;
import h2.C2444w;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import k2.C2586C;
import k2.C2604n;
import k2.C2610u;
import k2.Z;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2647G;
import l2.C2657f;
import l2.C2661j;
import l2.C2666o;
import l2.C2668q;
import l2.C2669s;
import l2.V;
import t3.C2788l;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.N;
import w3.O;
import z2.C2940B;
import z2.C2954m;
import z2.C2962v;
import z2.E;
import z2.F;
import z2.H;
import z2.P;

/* renamed from: com.uptodown.activities.a  reason: case insensitive filesystem */
public abstract class C1598a extends S0 {

    /* renamed from: J  reason: collision with root package name */
    public static final C0143a f14826J = new C0143a((C2633k) null);

    /* renamed from: A  reason: collision with root package name */
    private long f14827A;

    /* renamed from: B  reason: collision with root package name */
    private boolean f14828B;

    /* renamed from: C  reason: collision with root package name */
    private RecyclerView f14829C;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public C0991w f14830D;

    /* renamed from: E  reason: collision with root package name */
    private C2586C f14831E = new q(this);

    /* renamed from: F  reason: collision with root package name */
    private ArrayList f14832F = new ArrayList();

    /* renamed from: G  reason: collision with root package name */
    private ActivityResultLauncher f14833G;

    /* renamed from: H  reason: collision with root package name */
    private D2.g f14834H;

    /* renamed from: I  reason: collision with root package name */
    private RelativeLayout f14835I;

    /* renamed from: x  reason: collision with root package name */
    private F f14836x;

    /* renamed from: y  reason: collision with root package name */
    private AlertDialog f14837y;

    /* renamed from: z  reason: collision with root package name */
    private C2604n f14838z = new h(this);

    /* renamed from: com.uptodown.activities.a$a  reason: collision with other inner class name */
    public static final class C0143a {
        public /* synthetic */ C0143a(C2633k kVar) {
            this();
        }

        private C0143a() {
        }
    }

    /* renamed from: com.uptodown.activities.a$b */
    public final class b implements Runnable {
        public b() {
        }

        public void run() {
            C1598a aVar = C1598a.this;
            String string = aVar.getString(R.string.error_no_connection);
            t.d(string, "getString(...)");
            aVar.u0(string);
        }
    }

    /* renamed from: com.uptodown.activities.a$c */
    public static final class c extends ItemTouchHelper.SimpleCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f14840a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1598a aVar) {
            super(0, 8);
            this.f14840a = aVar;
        }

        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            t.e(recyclerView, "recyclerView");
            t.e(viewHolder, "viewHolder");
            t.e(viewHolder2, TypedValues.AttributesType.S_TARGET);
            return false;
        }

        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i5) {
            t.e(viewHolder, "viewHolder");
            int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
            C0991w N12 = this.f14840a.f14830D;
            if (N12 != null) {
                N12.e(absoluteAdapterPosition);
            }
        }
    }

    /* renamed from: com.uptodown.activities.a$d */
    static final class d extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14841a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1598a f14842b;

        /* renamed from: com.uptodown.activities.a$d$a  reason: collision with other inner class name */
        static final class C0144a extends kotlin.coroutines.jvm.internal.l implements k3.p {

            /* renamed from: a  reason: collision with root package name */
            int f14843a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ L f14844b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f14845c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ C1598a f14846d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0144a(L l5, File file, C1598a aVar, C2308e eVar) {
                super(2, eVar);
                this.f14844b = l5;
                this.f14845c = file;
                this.f14846d = aVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0144a(this.f14844b, this.f14845c, this.f14846d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f14843a == 0) {
                    u.b(obj);
                    if (this.f14844b.f24690a != null) {
                        C2661j jVar = new C2661j();
                        File file = this.f14845c;
                        t.b(file);
                        jVar.h(file.getAbsolutePath());
                        jVar.f(String.valueOf(this.f14845c.lastModified()));
                        this.f14846d.J2((String) this.f14844b.f24690a, jVar);
                    } else {
                        this.f14846d.G2();
                    }
                    this.f14846d.S2(true);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0144a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C1598a aVar, C2308e eVar) {
            super(2, eVar);
            this.f14842b = aVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14842b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14841a;
            if (i5 == 0) {
                u.b(obj);
                L l5 = new L();
                File j5 = new E().j(this.f14842b);
                if (j5 != null) {
                    C2940B a5 = C2940B.f26458v.a(this.f14842b);
                    a5.a();
                    ArrayList e02 = a5.e0();
                    a5.m();
                    Iterator it = e02.iterator();
                    t.d(it, "iterator(...)");
                    while (true) {
                        if (!it.hasNext()) {
                            E e5 = new E();
                            String name = j5.getName();
                            t.d(name, "getName(...)");
                            l5.f24690a = e5.k(name);
                            break;
                        }
                        Object next = it.next();
                        t.d(next, "next(...)");
                        C2661j jVar = (C2661j) next;
                        if (t3.s.E(jVar.e(), j5.getAbsolutePath(), true) && Long.parseLong(jVar.a()) == j5.lastModified()) {
                            break;
                        }
                    }
                }
                I0 c5 = C2865c0.c();
                C0144a aVar = new C0144a(l5, j5, this.f14842b, (C2308e) null);
                this.f14841a = 1;
                if (C2872g.g(c5, aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.a$e */
    static final class e extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14847a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1598a f14848b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14849c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2616a f14850d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C2616a f14851e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C1598a aVar, String str, C2616a aVar2, C2616a aVar3, C2308e eVar) {
            super(2, eVar);
            this.f14848b = aVar;
            this.f14849c = str;
            this.f14850d = aVar2;
            this.f14851e = aVar3;
        }

        /* access modifiers changed from: private */
        public static final void e(C2616a aVar, C1598a aVar2, View view) {
            aVar.invoke();
            aVar2.o2();
        }

        /* access modifiers changed from: private */
        public static final void f(C2616a aVar, C1598a aVar2, View view) {
            aVar.invoke();
            aVar2.o2();
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14848b, this.f14849c, this.f14850d, this.f14851e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14847a == 0) {
                u.b(obj);
                if (!this.f14848b.isFinishing()) {
                    this.f14848b.o2();
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f14848b);
                    C2436s c5 = C2436s.c(this.f14848b.getLayoutInflater());
                    t.d(c5, "inflate(...)");
                    String str = this.f14849c;
                    C2616a aVar = this.f14850d;
                    C1598a aVar2 = this.f14848b;
                    C2616a aVar3 = this.f14851e;
                    TextView textView = c5.f23528d;
                    k.a aVar4 = S1.k.f32g;
                    textView.setTypeface(aVar4.x());
                    c5.f23528d.setText(str);
                    c5.f23529e.setTypeface(aVar4.w());
                    c5.f23529e.setOnClickListener(new C1599b(aVar, aVar2));
                    c5.f23527c.setTypeface(aVar4.w());
                    c5.f23527c.setOnClickListener(new C1600c(aVar3, aVar2));
                    builder.setCancelable(false);
                    builder.setView(c5.getRoot());
                    this.f14848b.P2(builder.create());
                    if (!this.f14848b.isFinishing() && this.f14848b.p2() != null) {
                        this.f14848b.b3();
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.a$f */
    public static final class f implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f14852a;

        f(C1598a aVar) {
            this.f14852a = aVar;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            this.f14852a.e3(fVar);
        }

        public void d(int i5) {
            C1598a aVar = this.f14852a;
            String string = aVar.getString(R.string.app_detail_not_found);
            t.d(string, "getString(...)");
            aVar.u0(string);
        }
    }

    /* renamed from: com.uptodown.activities.a$g */
    static final class g extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14853a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1598a f14854b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l2.L f14855c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2616a f14856d;

        /* renamed from: com.uptodown.activities.a$g$a  reason: collision with other inner class name */
        public static final class C0145a extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1598a f14857a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ l2.L f14858b;

            C0145a(C1598a aVar, l2.L l5) {
                this.f14857a = aVar;
                this.f14858b = l5;
            }

            public void onClick(View view) {
                t.e(view, "widget");
                this.f14857a.L2(this.f14858b.f());
            }

            public void updateDrawState(TextPaint textPaint) {
                t.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f14857a, R.color.main_blue));
                textPaint.setTypeface(S1.k.f32g.w());
                textPaint.setUnderlineText(false);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(C1598a aVar, l2.L l5, C2616a aVar2, C2308e eVar) {
            super(2, eVar);
            this.f14854b = aVar;
            this.f14855c = l5;
            this.f14856d = aVar2;
        }

        /* access modifiers changed from: private */
        public static final CharSequence j(C2788l lVar) {
            return (CharSequence) lVar.a().get(1);
        }

        /* access modifiers changed from: private */
        public static final void l(C2616a aVar, C1598a aVar2, View view) {
            aVar.invoke();
            aVar2.o2();
        }

        /* access modifiers changed from: private */
        public static final void m(C1598a aVar, View view) {
            aVar.o2();
        }

        /* access modifiers changed from: private */
        public static final void n(C1598a aVar, l2.L l5, View view) {
            aVar.L2(l5.f());
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f14854b, this.f14855c, this.f14856d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14853a == 0) {
                u.b(obj);
                if (!this.f14854b.isFinishing()) {
                    this.f14854b.o2();
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f14854b);
                    C2444w c5 = C2444w.c(this.f14854b.getLayoutInflater());
                    t.d(c5, "inflate(...)");
                    C1598a aVar = this.f14854b;
                    l2.L l5 = this.f14855c;
                    C2616a aVar2 = this.f14856d;
                    c5.f23649f.setTypeface(S1.k.f32g.x());
                    c5.f23649f.setText(aVar.getString(R.string.positives_detected_in_downloaded_file));
                    String obj2 = c5.f23649f.getText().toString();
                    List<C2666o> e5 = C2666o.f25106g.e(obj2, "\\[xx](.*?)\\[/xx]");
                    SpannableString spannableString = new SpannableString(new t3.p("\\[xx](.*?)\\[/xx]").i(obj2, new C1601d()));
                    for (C2666o oVar : e5) {
                        int f02 = t3.s.f0(spannableString, oVar.d(), 0, false, 6, (Object) null);
                        int length = oVar.d().length() + f02;
                        if (f02 >= 0) {
                            spannableString.setSpan(new C0145a(aVar, l5), f02, length, 33);
                        }
                    }
                    c5.f23649f.setText(spannableString);
                    c5.f23649f.setMovementMethod(LinkMovementMethod.getInstance());
                    TextView textView = c5.f23651h;
                    k.a aVar3 = S1.k.f32g;
                    textView.setTypeface(aVar3.w());
                    c5.f23651h.setText(String.valueOf(l5.d()));
                    c5.f23650g.setTypeface(aVar3.x());
                    TextView textView2 = c5.f23650g;
                    P p5 = P.f26510a;
                    Q q5 = Q.f24695a;
                    String string = aVar.getString(R.string.virustotal_report_msg);
                    t.d(string, "getString(...)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(l5.e())}, 1));
                    t.d(format, "format(...)");
                    textView2.setText(p5.c(format));
                    c5.f23648e.setTypeface(aVar3.x());
                    c5.f23648e.setText(aVar.getString(R.string.virustotal_report_previous_scan, new Object[]{l5.c()}));
                    c5.f23647d.setTypeface(aVar3.w());
                    c5.f23647d.setOnClickListener(new C1602e(aVar2, aVar));
                    c5.f23646c.setTypeface(aVar3.w());
                    c5.f23646c.setOnClickListener(new C1603f(aVar));
                    c5.f23645b.setOnClickListener(new C1604g(aVar, l5));
                    builder.setCancelable(false);
                    builder.setView(c5.getRoot());
                    this.f14854b.P2(builder.create());
                    if (!this.f14854b.isFinishing() && this.f14854b.p2() != null) {
                        this.f14854b.b3();
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.a$h */
    public static final class h implements C2604n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f14859a;

        h(C1598a aVar) {
            this.f14859a = aVar;
        }
    }

    /* renamed from: com.uptodown.activities.a$i */
    public static final class i implements Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f14860a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f14861b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14862c;

        i(C1598a aVar, File file, String str) {
            this.f14860a = aVar;
            this.f14861b = file;
            this.f14862c = str;
        }

        /* access modifiers changed from: private */
        public static final J d(C1598a aVar, File file, String str) {
            aVar.y2(file, str);
            return J.f19942a;
        }

        public void a(l2.L l5) {
            t.e(l5, "reportVT");
            if (l5.d() > 0) {
                C1598a aVar = this.f14860a;
                aVar.n2(l5, new O1.F(aVar, this.f14861b, this.f14862c));
                return;
            }
            this.f14860a.y2(this.f14861b, this.f14862c);
        }

        public void b() {
            this.f14860a.y2(this.f14861b, this.f14862c);
        }
    }

    /* renamed from: com.uptodown.activities.a$j */
    public static final class j implements X1.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f14863a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f14864b;

        /* renamed from: com.uptodown.activities.a$j$a  reason: collision with other inner class name */
        public static final class C0146a implements C2231h {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1598a f14865a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ File f14866b;

            C0146a(C1598a aVar, File file) {
                this.f14865a = aVar;
                this.f14866b = file;
            }

            public void a() {
                this.f14865a.V2(this.f14866b);
            }

            public void b(String str) {
                if (str != null) {
                    this.f14865a.a2(str);
                    return;
                }
                C1598a aVar = this.f14865a;
                String string = aVar.getString(R.string.error_generico);
                t.d(string, "getString(...)");
                aVar.a2(string);
            }
        }

        j(C1598a aVar, File file) {
            this.f14863a = aVar;
            this.f14864b = file;
        }

        public void a(File file, ArrayList arrayList) {
            t.e(file, "fileZipped");
            t.e(arrayList, "files");
            this.f14863a.Z2(file);
            C0146a aVar = new C0146a(this.f14863a, file);
            C2275G g5 = new C2275G(this.f14863a);
            g5.B(arrayList);
            new C2292l(this.f14863a, aVar).A(g5.C(), false);
            C2940B a5 = C2940B.f26458v.a(this.f14863a);
            a5.a();
            String name = file.getName();
            t.d(name, "getName(...)");
            C2668q f02 = a5.f0(name);
            a5.m();
            if (f02 != null) {
                this.f14863a.E2(f02);
            }
        }

        public void b(int i5) {
            this.f14863a.W2(this.f14864b, i5);
        }

        public void c(File file) {
        }

        public void d(File file) {
        }

        public void e() {
            C1598a aVar = this.f14863a;
            String string = aVar.getString(R.string.msg_install_from_unknown_source, new Object[]{aVar.getString(R.string.app_name)});
            t.d(string, "getString(...)");
            this.f14863a.a2(string);
        }

        public void f() {
            C1598a aVar = this.f14863a;
            String string = aVar.getString(R.string.core_kill_this_app, new Object[]{aVar.getString(R.string.app_name)});
            t.d(string, "getString(...)");
            this.f14863a.a2(string);
        }

        public void g() {
            this.f14863a.W2(this.f14864b, 0);
        }

        public void h() {
            String string = this.f14863a.getString(R.string.error_unzipping);
            t.d(string, "getString(...)");
            this.f14863a.a2(string);
        }

        public void i() {
            this.f14863a.M();
        }
    }

    /* renamed from: com.uptodown.activities.a$k */
    static final class k extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14867a;

        /* renamed from: b  reason: collision with root package name */
        int f14868b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f14869c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1598a f14870d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f14871e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(long j5, C1598a aVar, int i5, C2308e eVar) {
            super(2, eVar);
            this.f14869c = j5;
            this.f14870d = aVar;
            this.f14871e = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f14869c, this.f14870d, this.f14871e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
            if (w3.X.b(r4, r7) == r0) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
            if (w3.X.b(r5, r7) == r0) goto L_0x004f;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r7.f14868b
                r2 = 2
                java.lang.String r3 = "downloadApkWorker"
                r4 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r4) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                int r1 = r7.f14867a
                W2.u.b(r8)
                goto L_0x0050
            L_0x0016:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001e:
                W2.u.b(r8)
                goto L_0x0030
            L_0x0022:
                W2.u.b(r8)
                long r5 = r7.f14869c
                r7.f14868b = r4
                java.lang.Object r8 = w3.X.b(r5, r7)
                if (r8 != r0) goto L_0x0030
                goto L_0x004f
            L_0x0030:
                com.uptodown.UptodownApp$a r8 = com.uptodown.UptodownApp.f13477F
                com.uptodown.activities.a r1 = r7.f14870d
                androidx.work.WorkInfo$State r8 = r8.G(r3, r1)
                r1 = 0
            L_0x0039:
                int r4 = r7.f14871e
                if (r1 >= r4) goto L_0x0059
                androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.ENQUEUED
                if (r8 != r4) goto L_0x0059
                int r1 = r1 + 1
                long r4 = r7.f14869c
                r7.f14867a = r1
                r7.f14868b = r2
                java.lang.Object r8 = w3.X.b(r4, r7)
                if (r8 != r0) goto L_0x0050
            L_0x004f:
                return r0
            L_0x0050:
                com.uptodown.UptodownApp$a r8 = com.uptodown.UptodownApp.f13477F
                com.uptodown.activities.a r4 = r7.f14870d
                androidx.work.WorkInfo$State r8 = r8.G(r3, r4)
                goto L_0x0039
            L_0x0059:
                com.uptodown.UptodownApp$a r8 = com.uptodown.UptodownApp.f13477F
                com.uptodown.activities.a r0 = r7.f14870d
                boolean r8 = r8.T(r3, r0)
                if (r8 != 0) goto L_0x008d
                z2.v r8 = new z2.v
                r8.<init>()
                com.uptodown.activities.a r0 = r7.f14870d
                java.util.ArrayList r8 = r8.l(r0)
                boolean r0 = r8.isEmpty()
                if (r0 != 0) goto L_0x008d
                com.uptodown.activities.a r0 = r7.f14870d
                java.lang.Object r1 = X2.C2250q.M(r8)
                l2.q r1 = (l2.C2668q) r1
                int r1 = r1.q()
                java.lang.Object r8 = X2.C2250q.M(r8)
                l2.q r8 = (l2.C2668q) r8
                java.lang.String r8 = r8.i()
                r0.O2(r1, r8)
            L_0x008d:
                W2.J r8 = W2.J.f19942a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.C1598a.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.a$l */
    public static final class l implements Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f14872a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f14873b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14874c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f14875d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C2668q f14876e;

        l(C1598a aVar, File file, String str, boolean z4, C2668q qVar) {
            this.f14872a = aVar;
            this.f14873b = file;
            this.f14874c = str;
            this.f14875d = z4;
            this.f14876e = qVar;
        }

        /* access modifiers changed from: private */
        public static final J d(C1598a aVar, File file, String str, boolean z4, C2668q qVar) {
            new S1.j(aVar).c(file, str, z4);
            if (qVar != null) {
                aVar.E2(qVar);
            }
            return J.f19942a;
        }

        public void a(l2.L l5) {
            t.e(l5, "reportVT");
            if (l5.d() > 0) {
                C1598a aVar = this.f14872a;
                aVar.n2(l5, new G(aVar, this.f14873b, this.f14874c, this.f14875d, this.f14876e));
                return;
            }
            new S1.j(this.f14872a).c(this.f14873b, this.f14874c, this.f14875d);
            C2668q qVar = this.f14876e;
            if (qVar != null) {
                this.f14872a.E2(qVar);
            }
        }

        public void b() {
            new S1.j(this.f14872a).c(this.f14873b, this.f14874c, this.f14875d);
            C2668q qVar = this.f14876e;
            if (qVar != null) {
                this.f14872a.E2(qVar);
            }
        }
    }

    /* renamed from: com.uptodown.activities.a$m */
    static final class m extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14877a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1598a f14878b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2668q f14879c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(C1598a aVar, C2668q qVar, C2308e eVar) {
            super(2, eVar);
            this.f14878b = aVar;
            this.f14879c = qVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new m(this.f14878b, this.f14879c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2669s o02;
            C2316b.f();
            if (this.f14877a == 0) {
                u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f14878b);
                a5.a();
                if (this.f14879c.h() > 0 && (o02 = a5.o0(this.f14879c.h())) != null) {
                    o02.d(this.f14878b, "installationStarted");
                }
                a5.m();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((m) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.a$n */
    public static final class n implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f14880a;

        n(C1598a aVar) {
            this.f14880a = aVar;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (!this.f14880a.isFinishing()) {
                Intent intent = new Intent(this.f14880a, AppDetailActivity.class);
                intent.putExtra("appInfo", fVar);
                C1598a aVar = this.f14880a;
                aVar.startActivity(intent, UptodownApp.f13477F.a(aVar));
            }
        }

        public void d(int i5) {
            C1598a aVar = this.f14880a;
            String string = aVar.getString(R.string.app_detail_not_found);
            t.d(string, "getString(...)");
            aVar.u0(string);
        }
    }

    /* renamed from: com.uptodown.activities.a$o */
    public static final class o implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f14881a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f14882b;

        o(C1598a aVar, String str) {
            this.f14881a = aVar;
            this.f14882b = str;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (!this.f14881a.isFinishing()) {
                Intent intent = new Intent(this.f14881a, AppDetailActivity.class);
                intent.putExtra("appInfo", fVar);
                C1598a aVar = this.f14881a;
                aVar.startActivity(intent, UptodownApp.f13477F.a(aVar));
            }
        }

        public void d(int i5) {
            String str = this.f14882b;
            if (str == null || str.length() == 0) {
                C1598a aVar = this.f14881a;
                String string = aVar.getString(R.string.app_detail_not_found);
                t.d(string, "getString(...)");
                aVar.u0(string);
                return;
            }
            new C2962v().t(this.f14881a, this.f14882b, (String) null);
        }
    }

    /* renamed from: com.uptodown.activities.a$p */
    public static final class p implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2661j f14883a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1598a f14884b;

        p(C2661j jVar, C1598a aVar) {
            this.f14883a = jVar;
            this.f14884b = aVar;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (fVar.e() > 0) {
                UptodownApp.f13477F.u0(this.f14883a);
                if (this.f14883a != null) {
                    C2940B a5 = C2940B.f26458v.a(this.f14884b);
                    a5.a();
                    a5.P0(this.f14883a);
                    a5.m();
                    File file = new File(this.f14883a.e());
                    if (file.exists()) {
                        file.delete();
                    }
                }
                this.f14884b.F2(fVar);
                return;
            }
            this.f14884b.G2();
        }

        public void d(int i5) {
            this.f14884b.G2();
        }
    }

    /* renamed from: com.uptodown.activities.a$q */
    public static final class q implements C2586C {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f14885a;

        q(C1598a aVar) {
            this.f14885a = aVar;
        }

        public void a(C2647G g5) {
            t.e(g5, "preregister");
            this.f14885a.H2(g5.b());
            C0991w N12 = this.f14885a.f14830D;
            if (N12 != null) {
                N12.d(g5);
            }
        }

        public void b() {
            if (this.f14885a.t2().size() > 0) {
                Object remove = this.f14885a.t2().remove(0);
                t.d(remove, "removeAt(...)");
                this.f14885a.M2((C2647G) remove);
            }
        }
    }

    /* renamed from: com.uptodown.activities.a$r */
    public static final class r implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f14886a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2647G f14887b;

        r(C1598a aVar, C2647G g5) {
            this.f14886a = aVar;
            this.f14887b = g5;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            C2647G g5 = new C2647G();
            g5.k(fVar.e());
            g5.n(fVar.N());
            g5.m(fVar.G());
            this.f14886a.P1(g5);
            C2940B a5 = C2940B.f26458v.a(this.f14886a);
            a5.a();
            a5.r1(g5.b());
            a5.m();
        }

        public void d(int i5) {
            if (i5 == 404) {
                C2940B a5 = C2940B.f26458v.a(this.f14886a);
                a5.a();
                a5.r1(this.f14887b.b());
                a5.m();
            }
        }
    }

    /* renamed from: com.uptodown.activities.a$s */
    public static final class s implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14888a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1598a f14889b;

        s(C2616a aVar, C1598a aVar2) {
            this.f14888a = aVar;
            this.f14889b = aVar2;
        }

        public void a(C2657f fVar) {
            t.e(fVar, "appInfo");
            this.f14889b.e3(fVar);
        }

        public void b(C2657f fVar) {
            t.e(fVar, "appInfo");
            this.f14888a.invoke();
        }
    }

    public static /* synthetic */ void B2(C1598a aVar, File file, String str, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                str = null;
            }
            aVar.A2(file, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchForegroundInstallation");
    }

    public static /* synthetic */ void D2(C1598a aVar, File file, String str, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                str = null;
            }
            aVar.C2(file, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchInstallationFromActivity");
    }

    private final void Q1() {
        new ItemTouchHelper(new c(this)).attachToRecyclerView(this.f14829C);
    }

    private final void R1() {
        View findViewById = findViewById(16908290);
        if (findViewById != null) {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById, new C0913w());
        }
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsCompat S1(View view, WindowInsetsCompat windowInsetsCompat) {
        t.e(view, "v");
        t.e(windowInsetsCompat, "windowInsets");
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        t.d(insets, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = insets.left;
            marginLayoutParams.bottomMargin = insets.bottom;
            marginLayoutParams.rightMargin = insets.right;
            marginLayoutParams.topMargin = insets.top;
            view.setLayoutParams(marginLayoutParams);
            return WindowInsetsCompat.CONSUMED;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* access modifiers changed from: private */
    public static final void W1(C2616a aVar, C1598a aVar2, View view) {
        aVar.invoke();
        aVar2.o2();
    }

    /* access modifiers changed from: private */
    public static final void X1(C1598a aVar, View view) {
        aVar.o2();
    }

    /* access modifiers changed from: private */
    public static final J Z1(C1598a aVar, File file) {
        aVar.C2(file, (String) null);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void b2(C1598a aVar, View view) {
        aVar.o2();
    }

    /* access modifiers changed from: private */
    public static final J d2(C1598a aVar, long j5) {
        Context applicationContext = aVar.getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        new C2388j(applicationContext, j5, new f(aVar), LifecycleOwnerKt.getLifecycleScope(aVar));
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J f2(C1598a aVar) {
        aVar.d3();
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void h2(C1598a aVar, View view) {
        aVar.o2();
        aVar.p0();
    }

    /* access modifiers changed from: private */
    public static final void i2(C1598a aVar, View view) {
        aVar.o2();
        aVar.finish();
    }

    /* access modifiers changed from: private */
    public static final void k2(C1598a aVar, C2616a aVar2, View view) {
        aVar.o2();
        aVar2.invoke();
    }

    /* access modifiers changed from: private */
    public static final void l2(C2616a aVar, C1598a aVar2, View view) {
        aVar.invoke();
        aVar2.o2();
    }

    /* access modifiers changed from: private */
    public static final void m2(C2616a aVar, DialogInterface dialogInterface) {
        aVar.invoke();
    }

    /* access modifiers changed from: private */
    public static final void u2(C1598a aVar, View view, View view2, int i5, int i6, int i7, int i8) {
        if (i6 > i8) {
            Object systemService = aVar.getSystemService("input_method");
            t.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private final void x2(File file, String str) {
        V h5 = V.f24870q.h(this);
        if (h5 == null || !h5.q()) {
            y2(file, str);
            J j5 = J.f19942a;
        } else if (file.isFile()) {
            new C2392n(this, (String) null, C2286f.f20690a.e(file.getAbsolutePath()), new i(this, file, str), LifecycleOwnerKt.getLifecycleScope(this));
        } else {
            y2(file, str);
            J j6 = J.f19942a;
        }
    }

    /* access modifiers changed from: private */
    public final void y2(File file, String str) {
        j jVar = new j(this, file);
        k.a aVar = S1.k.f32g;
        if (aVar.i() == null && aVar.j() == null) {
            C2279K.a aVar2 = C2279K.f20490b;
            String name = file.getName();
            t.d(name, "getName(...)");
            if (aVar2.a(name)) {
                String absolutePath = file.getAbsolutePath();
                t.d(absolutePath, "getAbsolutePath(...)");
                new C2210c(this, absolutePath, jVar, X());
                return;
            }
            UptodownApp.f13477F.U(file, this, str);
            J j5 = J.f19942a;
            return;
        }
        String string = getString(R.string.core_installation_in_progress_msg);
        t.d(string, "getString(...)");
        u0(string);
        J j6 = J.f19942a;
    }

    public final void A2(File file, String str) {
        t.e(file, "item");
        boolean A4 = new C2954m().A(this);
        V h5 = V.f24870q.h(this);
        C2940B a5 = C2940B.f26458v.a(this);
        a5.a();
        if (file.isFile()) {
            String name = file.getName();
            t.d(name, "getName(...)");
            C2668q f02 = a5.f0(name);
            if (h5 == null || !h5.q()) {
                new S1.j(this).c(file, str, A4);
                if (f02 != null) {
                    E2(f02);
                }
                J j5 = J.f19942a;
            } else {
                String e5 = C2286f.f20690a.e(file.getAbsolutePath());
                String str2 = e5;
                new C2392n(this, (String) null, str2, new l(this, file, str, A4, f02), LifecycleOwnerKt.getLifecycleScope(this));
            }
        } else {
            new S1.j(this).c(file, str, A4);
            String absolutePath = file.getAbsolutePath();
            t.d(absolutePath, "getAbsolutePath(...)");
            C2668q g02 = a5.g0(absolutePath);
            if (g02 != null) {
                E2(g02);
            }
            J j6 = J.f19942a;
        }
        a5.m();
    }

    public final void C2(File file, String str) {
        t.e(file, "item");
        if (new C2201a(this).s()) {
            A2(file, str);
        } else {
            x2(file, str);
        }
    }

    public final void E2(C2668q qVar) {
        t.e(qVar, "download");
        Bundle bundle = new Bundle();
        if (qVar.w() != null) {
            z2.G g5 = z2.G.f26487a;
            String w4 = qVar.w();
            t.b(w4);
            bundle = g5.b(this, w4, bundle);
            bundle.putString("packagename", qVar.w());
        }
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
        F f5 = this.f14836x;
        if (f5 != null) {
            f5.d("install", bundle);
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.b(), (O) null, new m(this, qVar, (C2308e) null), 2, (Object) null);
    }

    public void F2(C2657f fVar) {
        t.e(fVar, "appInfo");
        e3(fVar);
    }

    public void G2() {
    }

    public void H2(long j5) {
        if (j5 > 0) {
            new C2388j(this, j5, new n(this), LifecycleOwnerKt.getLifecycleScope(this));
            return;
        }
        K2();
        J j6 = J.f19942a;
    }

    public void I2(long j5, String str) {
        if (j5 > 0) {
            new C2388j(this, j5, new o(this, str), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void J2(String str, C2661j jVar) {
        t.e(str, "packageNameToOpen");
        new C2389k(this, str, new p(jVar, this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public final void K2() {
        if (!isFinishing() && !(S1.k.f32g.g() instanceof MyDownloads)) {
            startActivity(new Intent(this, MyDownloads.class), UptodownApp.f13477F.a(this));
        }
    }

    public final void L2(String str) {
        if (str != null && !isFinishing()) {
            String u5 = new C2954m().u(str);
            String string = getString(R.string.virustotal_safety_report_title);
            t.d(string, "getString(...)");
            new C2962v().t(this, u5, string);
        }
    }

    public final void M2(C2647G g5) {
        t.e(g5, "preregister");
        new C2388j(this, g5.b(), new r(this, g5), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public void N2() {
    }

    public final void O2(int i5, String str) {
        if (!H.f26488a.d()) {
            String string = getString(R.string.error_no_connection);
            t.d(string, "getString(...)");
            u0(string);
        } else if (!DownloadApkWorker.f21342i.b(this, i5) && str != null && str.length() != 0) {
            Q q5 = Q.f24695a;
            String string2 = getString(R.string.msg_added_to_downlads_queue);
            t.d(string2, "getString(...)");
            String format = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
            t.d(format, "format(...)");
            u0(format);
        }
    }

    public final void P1(C2647G g5) {
        t.e(g5, "preRegister");
        C0991w wVar = this.f14830D;
        if (wVar != null) {
            wVar.b(g5);
        }
    }

    public final void P2(AlertDialog alertDialog) {
        this.f14837y = alertDialog;
    }

    public final void Q2() {
        this.f14836x = new F(this);
    }

    public final void R2(RelativeLayout relativeLayout) {
        this.f14835I = relativeLayout;
    }

    public final void S2(boolean z4) {
        this.f14828B = z4;
    }

    public final void T1() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f14827A > ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            this.f14827A = currentTimeMillis;
            C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new d(this, (C2308e) null), 3, (Object) null);
        }
    }

    public final void T2(F f5) {
        this.f14836x = f5;
    }

    public final void U1(String str, C2616a aVar) {
        t.e(str, NotificationCompat.CATEGORY_MESSAGE);
        t.e(aVar, "acceptAction");
        if (!isFinishing()) {
            o2();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C2436s c5 = C2436s.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23528d;
            k.a aVar2 = S1.k.f32g;
            textView.setTypeface(aVar2.x());
            c5.f23528d.setText(str);
            c5.f23529e.setTypeface(aVar2.w());
            c5.f23529e.setOnClickListener(new C0889t(aVar, this));
            c5.f23527c.setTypeface(aVar2.w());
            c5.f23527c.setOnClickListener(new C0897u(this));
            builder.setView(c5.getRoot());
            this.f14837y = builder.create();
            if (!isFinishing() && this.f14837y != null) {
                b3();
            }
        }
    }

    public final void U2(ArrayList arrayList) {
        t.e(arrayList, "<set-?>");
        this.f14832F = arrayList;
    }

    public final void V1(String str, C2616a aVar, C2616a aVar2) {
        t.e(str, NotificationCompat.CATEGORY_MESSAGE);
        t.e(aVar, "acceptAction");
        t.e(aVar2, "cancelAction");
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new e(this, str, aVar, aVar2, (C2308e) null), 2, (Object) null);
    }

    public void V2(File file) {
        t.e(file, "xapkFile");
    }

    public void W2(File file, int i5) {
        t.e(file, "file");
    }

    public final void X2(Drawable drawable, int i5) {
        t.e(drawable, "drawable");
        DrawableCompat.setTint(drawable, i5);
    }

    public final void Y1(File file) {
        t.e(file, "updateFile");
        String string = getString(R.string.warning_auto_update);
        t.d(string, "getString(...)");
        U1(string, new A(this, file));
    }

    /* access modifiers changed from: protected */
    public final void Y2(ActivityResultLauncher activityResultLauncher) {
        this.f14833G = activityResultLauncher;
    }

    public void Z2(File file) {
        t.e(file, "xapkFile");
    }

    public final void a2(String str) {
        t.e(str, NotificationCompat.CATEGORY_MESSAGE);
        if (!isFinishing()) {
            o2();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C2436s c5 = C2436s.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23528d;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.x());
            c5.f23528d.setText(str);
            c5.f23527c.setVisibility(8);
            c5.f23529e.setTypeface(aVar.w());
            c5.f23529e.setOnClickListener(new C0937z(this));
            builder.setView(c5.getRoot());
            this.f14837y = builder.create();
            if (!isFinishing() && this.f14837y != null) {
                b3();
            }
        }
    }

    public final void a3(C2657f fVar, C2616a aVar) {
        t.e(fVar, "appInfo");
        t.e(aVar, "updateCard");
        s sVar = new s(aVar, this);
        RelativeLayout relativeLayout = this.f14835I;
        if (relativeLayout != null) {
            t.b(relativeLayout);
            D2.g gVar = new D2.g(fVar, relativeLayout, sVar);
            this.f14834H = gVar;
            gVar.B(this, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void b3() {
        AlertDialog alertDialog = this.f14837y;
        t.b(alertDialog);
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AlertDialog alertDialog2 = this.f14837y;
        t.b(alertDialog2);
        alertDialog2.show();
    }

    public void c0() {
    }

    public final void c2(String str, String str2, long j5) {
        U1(str + 10 + str2, new O1.E(this, j5));
    }

    public void c3(long j5) {
        String string = getString(R.string.core_kill_this_app, new Object[]{getString(R.string.app_name)});
        t.d(string, "getString(...)");
        a2(string);
    }

    public void d0() {
    }

    public final void d3() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        t.d(build, "build(...)");
        build.intent.setData(Uri.parse(new C2962v().c(z2.Z.f26527b.c(this))));
        ActivityResultLauncher activityResultLauncher = this.f14833G;
        if (activityResultLauncher != null) {
            t.b(activityResultLauncher);
            activityResultLauncher.launch(build.intent, UptodownApp.f13477F.b(this));
            return;
        }
        startActivity(build.intent, UptodownApp.f13477F.a(this));
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getSource() != 8194) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return true;
    }

    public void e0() {
    }

    public void e1() {
    }

    public final void e2(String str, String str2) {
        U1(str + 10 + str2, new C0905v(this));
    }

    public void e3(C2657f fVar) {
        t.e(fVar, "appInfo");
    }

    public void f0() {
    }

    public final void g2() {
        AlertDialog alertDialog;
        if (!isFinishing()) {
            o2();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C2436s c5 = C2436s.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23528d;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.x());
            c5.f23528d.setText(getString(R.string.msg_storage_permission_required));
            c5.f23529e.setTypeface(aVar.w());
            c5.f23529e.setOnClickListener(new C0921x(this));
            c5.f23527c.setTypeface(aVar.w());
            c5.f23527c.setText(getString(R.string.exit));
            c5.f23527c.setOnClickListener(new C0929y(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            this.f14837y = builder.create();
            if (!isFinishing() && (alertDialog = this.f14837y) != null) {
                t.b(alertDialog);
                Window window = alertDialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog alertDialog2 = this.f14837y;
                t.b(alertDialog2);
                alertDialog2.show();
            }
        }
    }

    public void h0() {
    }

    public final void hideKeyboardOnScroll(View view) {
        t.e(view, "scrollView");
        view.setOnScrollChangeListener(new C0881s(this, view));
    }

    public final void j2(C2657f fVar, C2616a aVar, C2616a aVar2) {
        t.e(fVar, "appInfo");
        t.e(aVar, "action");
        t.e(aVar2, "cancelAction");
        o2();
        C2400D c5 = C2400D.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        TextView textView = c5.f22319e;
        k.a aVar3 = S1.k.f32g;
        textView.setTypeface(aVar3.w());
        c5.f22318d.setTypeface(aVar3.x());
        c5.f22316b.setOnClickListener(new B(this, aVar2));
        if (fVar.K0()) {
            c5.f22318d.setText(fVar.u());
            c5.f22317c.setText(getString(R.string.leave_anyways));
        } else {
            c5.f22317c.setText(getString(R.string.download_anyways));
        }
        c5.f22317c.setTypeface(aVar3.w());
        c5.f22317c.setOnClickListener(new C(aVar, this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(c5.getRoot());
        builder.setCancelable(true);
        builder.setOnCancelListener(new D(aVar2));
        this.f14837y = builder.create();
        b3();
    }

    public final void n2(l2.L l5, C2616a aVar) {
        t.e(l5, "reportVT");
        t.e(aVar, "installAction");
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new g(this, l5, aVar, (C2308e) null), 2, (Object) null);
    }

    public final void o2() {
        AlertDialog alertDialog = this.f14837y;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        F f5 = new F(this);
        this.f14836x = f5;
        String simpleName = getClass().getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        f5.f(simpleName);
        R1();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        z2();
        N2();
    }

    public final AlertDialog p2() {
        return this.f14837y;
    }

    public final D2.g q2() {
        return this.f14834H;
    }

    public final boolean r2() {
        return this.f14828B;
    }

    public final F s2() {
        return this.f14836x;
    }

    public final void showKeyboard(View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        Object systemService = getSystemService("input_method");
        t.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(view.findFocus(), 1);
    }

    public final ArrayList t2() {
        return this.f14832F;
    }

    public final void v2() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_preregister_notifications);
        this.f14829C = recyclerView;
        if (recyclerView != null) {
            t.b(recyclerView);
            recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            RecyclerView recyclerView2 = this.f14829C;
            t.b(recyclerView2);
            recyclerView2.addItemDecoration(new B2.m((int) getResources().getDimension(R.dimen.margin_m)));
            this.f14830D = new C0991w(this, this.f14831E);
            RecyclerView recyclerView3 = this.f14829C;
            t.b(recyclerView3);
            recyclerView3.setAdapter(this.f14830D);
            Q1();
        }
    }

    public final boolean w2() {
        AlertDialog alertDialog = this.f14837y;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return false;
        }
        return true;
    }

    public final void z2() {
        C2908y0 unused = C2876i.d(N.a(C2865c0.a()), (C2312i) null, (O) null, new k(5000, this, 5, (C2308e) null), 3, (Object) null);
    }
}
