package C2;

import S1.k;
import Y1.C2259c;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import b2.C2279K;
import b2.C2290j;
import b2.C2291k;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import java.io.File;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import k2.C2602l;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2668q;
import l2.r;

/* renamed from: C2.t  reason: case insensitive filesystem */
public final class C2055t extends C2038n {

    /* renamed from: b  reason: collision with root package name */
    private final C2602l f17876b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f17877c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f17878d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f17879e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f17880f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f17881g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f17882h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f17883i;

    /* renamed from: j  reason: collision with root package name */
    private ImageView f17884j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f17885k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f17886l;

    /* renamed from: m  reason: collision with root package name */
    private ImageView f17887m;

    /* renamed from: n  reason: collision with root package name */
    private RelativeLayout f17888n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2055t(View view, C2602l lVar) {
        super(view);
        t.e(view, "itemView");
        this.f17876b = lVar;
        View findViewById = view.findViewById(R.id.rl_download_item);
        t.d(findViewById, "findViewById(...)");
        this.f17877c = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_download_item);
        t.d(findViewById2, "findViewById(...)");
        this.f17878d = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_version_download_item);
        t.d(findViewById3, "findViewById(...)");
        this.f17879e = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_size_download_item);
        t.d(findViewById4, "findViewById(...)");
        this.f17880f = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_date_download_item);
        t.d(findViewById5, "findViewById(...)");
        this.f17881g = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.pb_progress_download_item);
        t.d(findViewById6, "findViewById(...)");
        this.f17882h = (ProgressBar) findViewById6;
        View findViewById7 = view.findViewById(R.id.iv_cancel_download_item);
        t.d(findViewById7, "findViewById(...)");
        this.f17883i = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.iv_icon_download_item);
        t.d(findViewById8, "findViewById(...)");
        this.f17884j = (ImageView) findViewById8;
        View findViewById9 = view.findViewById(R.id.tv_info_download_item);
        t.d(findViewById9, "findViewById(...)");
        this.f17885k = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.tv_deeplink_download_item);
        t.d(findViewById10, "findViewById(...)");
        this.f17886l = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.iv_resume_download_item);
        t.d(findViewById11, "findViewById(...)");
        this.f17887m = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(R.id.rl_container_options_download_item);
        t.d(findViewById12, "findViewById(...)");
        this.f17888n = (RelativeLayout) findViewById12;
        view.setOnClickListener(new C2041o(this));
        view.setOnLongClickListener(new C2044p(this));
        this.f17884j.setOnClickListener(new C2047q(this));
        TextView textView = this.f17878d;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        this.f17879e.setTypeface(aVar.x());
        this.f17880f.setTypeface(aVar.w());
        this.f17881g.setTypeface(aVar.x());
        this.f17885k.setTypeface(aVar.w());
        this.f17886l.setTypeface(aVar.w());
        this.f17883i.setOnClickListener(new r(this));
        this.f17887m.setOnClickListener(new C2052s(this));
    }

    /* access modifiers changed from: private */
    public static final void l(C2055t tVar, View view) {
        int bindingAdapterPosition;
        if (tVar.f17876b != null && (bindingAdapterPosition = tVar.getBindingAdapterPosition()) != -1) {
            tVar.f17876b.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean m(C2055t tVar, View view) {
        int bindingAdapterPosition;
        if (tVar.f17876b == null || (bindingAdapterPosition = tVar.getBindingAdapterPosition()) == -1) {
            return false;
        }
        tVar.f17876b.d(bindingAdapterPosition);
        return false;
    }

    /* access modifiers changed from: private */
    public static final void n(C2055t tVar, View view) {
        int bindingAdapterPosition;
        if (tVar.f17876b != null && (bindingAdapterPosition = tVar.getBindingAdapterPosition()) != -1) {
            tVar.f17876b.b(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void o(C2055t tVar, View view) {
        C2602l lVar;
        int bindingAdapterPosition = tVar.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1 && (lVar = tVar.f17876b) != null) {
            lVar.c(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void p(C2055t tVar, View view) {
        C2602l lVar;
        int bindingAdapterPosition = tVar.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1 && (lVar = tVar.f17876b) != null) {
            lVar.e(bindingAdapterPosition);
        }
    }

    public final void q(C2668q qVar, boolean z4, boolean z5, boolean z6) {
        C2668q qVar2 = qVar;
        t.e(qVar2, "download");
        this.f17884j.setPadding(0, 0, 0, 0);
        String D4 = qVar2.D();
        if (D4 != null && D4.length() != 0) {
            w l5 = s.h().l(qVar2.D());
            UptodownApp.a aVar = UptodownApp.f13477F;
            Context context = this.itemView.getContext();
            t.d(context, "getContext(...)");
            l5.n(aVar.g0(context)).i(this.f17884j);
        } else if (qVar2.p() != null) {
            this.f17884j.setImageDrawable(qVar2.p());
        } else if (qVar2.o().size() == 1) {
            String a5 = ((r) qVar2.o().get(0)).a();
            t.b(a5);
            if (t3.s.D(a5, ".apk", false, 2, (Object) null)) {
                C2290j jVar = new C2290j();
                Context context2 = this.itemView.getContext();
                t.d(context2, "getContext(...)");
                String a6 = ((r) qVar2.o().get(0)).a();
                t.b(a6);
                if (jVar.h(context2, a6) != null) {
                    this.f17884j.setImageDrawable(qVar2.p());
                } else {
                    this.f17884j.setImageResource(R.drawable.core_vector_apk);
                }
            } else {
                C2279K.a aVar2 = C2279K.f20490b;
                String a7 = ((r) qVar2.o().get(0)).a();
                t.b(a7);
                if (aVar2.a(a7)) {
                    this.f17884j.setImageResource(R.drawable.core_vector_xapk);
                } else {
                    this.f17884j.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_vector_file));
                }
            }
        } else {
            this.f17884j.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_vector_file));
        }
        String H4 = qVar2.H();
        if (H4 == null || H4.length() == 0) {
            this.f17878d.setText(qVar2.i());
        } else {
            TextView textView = this.f17878d;
            textView.setText(qVar2.i() + ' ' + qVar2.H());
        }
        if (qVar2.E() > 0) {
            this.f17879e.setText(String.valueOf(qVar2.E()));
            this.f17879e.setVisibility(0);
        } else {
            this.f17879e.setVisibility(8);
        }
        this.f17887m.setVisibility(8);
        if (qVar2.L() == 1) {
            this.f17886l.setVisibility(0);
        } else {
            this.f17886l.setVisibility(8);
        }
        if (!qVar2.f()) {
            TextView textView2 = this.f17880f;
            Q q5 = Q.f24695a;
            String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(qVar2.x())}, 1));
            t.d(format, "format(...)");
            textView2.setText(format);
            this.f17881g.setVisibility(8);
            this.f17882h.setProgress(qVar2.x());
            this.f17885k.setText("");
            this.f17885k.setVisibility(8);
            this.f17888n.setVisibility(0);
            this.f17883i.setVisibility(0);
            e(this.f17882h, this.f17884j);
        } else {
            String a8 = ((r) qVar2.o().get(0)).a();
            t.b(a8);
            long lastModified = new File(a8).lastModified();
            DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
            this.f17881g.setVisibility(0);
            if (qVar2.N() || z6) {
                this.f17882h.setIndeterminate(true);
                this.f17881g.setVisibility(8);
                this.f17880f.setText("");
                this.f17885k.setText(this.itemView.getContext().getString(R.string.installing));
                this.f17885k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.download_installed_status));
                this.f17885k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.bg_status_download_installed));
                this.f17888n.setVisibility(8);
                e(this.f17882h, this.f17884j);
            } else {
                k.a aVar3 = k.f32g;
                if (aVar3.j() != null) {
                    String a9 = ((r) qVar2.o().get(0)).a();
                    C2259c j5 = aVar3.j();
                    t.b(j5);
                    if (t3.s.E(a9, j5.a(), true)) {
                        this.f17881g.setText(dateTimeInstance.format(new Date(lastModified)));
                        this.f17880f.setText(new C2291k().c(qVar2.y()));
                        ProgressBar progressBar = this.f17882h;
                        C2259c j6 = aVar3.j();
                        t.b(j6);
                        progressBar.setProgress(j6.b());
                        TextView textView3 = this.f17885k;
                        Context context3 = this.itemView.getContext();
                        C2259c j7 = aVar3.j();
                        t.b(j7);
                        textView3.setText(context3.getString(R.string.unzipping_status, new Object[]{Integer.valueOf(j7.b())}));
                        this.f17885k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.download_installed_status));
                        this.f17885k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.bg_status_download_installed));
                        this.f17888n.setVisibility(8);
                        e(this.f17882h, this.f17884j);
                    }
                }
                this.f17881g.setText(dateTimeInstance.format(new Date(lastModified)));
                TextView textView4 = this.f17880f;
                C2291k kVar = new C2291k();
                long y4 = qVar2.y();
                Context context4 = this.itemView.getContext();
                t.d(context4, "getContext(...)");
                textView4.setText(kVar.d(y4, context4));
                this.f17885k.setText(this.itemView.getContext().getString(R.string.option_button_install));
                this.f17885k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.white));
                this.f17885k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_accent_green));
                this.f17885k.setVisibility(0);
                this.f17888n.setVisibility(8);
                c(this.f17882h, this.f17884j);
            }
        }
        if (qVar2.G() > -1 && qVar2.F() > -1) {
            this.f17885k.setVisibility(0);
            this.f17888n.setVisibility(8);
            this.f17883i.setVisibility(8);
            if (qVar2.G() > qVar2.F()) {
                this.f17885k.setText(this.itemView.getContext().getString(R.string.status_download_oldversion));
                this.f17885k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.white));
                this.f17885k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.bg_status_download_outdate));
            } else if (qVar2.G() < qVar2.F()) {
                this.f17885k.setText(this.itemView.getContext().getString(R.string.action_update));
                this.f17885k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.white));
                this.f17885k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_accent_green));
            } else {
                this.f17885k.setText(this.itemView.getContext().getString(R.string.status_download_installed));
                this.f17885k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.main_blue));
                this.f17885k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_stroke_blue_primary));
            }
        }
        if (!z4) {
            this.f17877c.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_ripple_bg_card));
        } else if (z5) {
            this.f17877c.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_selected_item));
        } else {
            this.f17877c.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_ripple_bg_card));
        }
    }

    public final void r(C2668q qVar, boolean z4, boolean z5) {
        boolean z6;
        t.e(qVar, "download");
        e(this.f17882h, this.f17884j);
        String D4 = qVar.D();
        if (!(D4 == null || D4.length() == 0)) {
            w l5 = s.h().l(qVar.D());
            UptodownApp.a aVar = UptodownApp.f13477F;
            Context context = this.itemView.getContext();
            t.d(context, "getContext(...)");
            l5.n(aVar.g0(context)).i(this.f17884j);
        }
        this.f17878d.setText(qVar.i());
        if (qVar.E() > 0) {
            this.f17879e.setText(String.valueOf(qVar.E()));
        } else {
            this.f17879e.setVisibility(4);
        }
        if (qVar.z() == 0) {
            this.f17880f.setVisibility(8);
        } else {
            this.f17880f.setVisibility(0);
            TextView textView = this.f17880f;
            Q q5 = Q.f24695a;
            C2291k kVar = new C2291k();
            long y4 = qVar.y();
            Context context2 = this.itemView.getContext();
            t.d(context2, "getContext(...)");
            String d5 = kVar.d(y4, context2);
            C2291k kVar2 = new C2291k();
            long z7 = qVar.z();
            Context context3 = this.itemView.getContext();
            t.d(context3, "getContext(...)");
            String format = String.format("%s/%s", Arrays.copyOf(new Object[]{d5, kVar2.d(z7, context3)}, 2));
            t.d(format, "format(...)");
            textView.setText(format);
        }
        this.f17888n.setVisibility(0);
        this.f17883i.setVisibility(0);
        this.f17887m.setVisibility(8);
        this.f17885k.setVisibility(8);
        if (qVar.L() == 1) {
            this.f17886l.setVisibility(0);
        } else {
            this.f17886l.setVisibility(8);
        }
        int x4 = qVar.x();
        if (1 > x4 || x4 >= 100) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (z6) {
            UptodownApp.a aVar2 = UptodownApp.f13477F;
            Context context4 = this.itemView.getContext();
            t.d(context4, "getContext(...)");
            if (!aVar2.S("downloadApkWorker", context4) || !DownloadWorker.f21359d.k(qVar.h(), qVar.E())) {
                z6 = false;
            } else {
                z6 = true;
            }
        }
        TextView textView2 = this.f17881g;
        Q q6 = Q.f24695a;
        String format2 = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(qVar.x())}, 1));
        t.d(format2, "format(...)");
        textView2.setText(format2);
        this.f17881g.setVisibility(0);
        if (z6) {
            this.f17882h.setIndeterminate(false);
            this.f17882h.setProgress(qVar.x());
            if (DownloadWorker.f21359d.h()) {
                this.f17883i.setVisibility(8);
                this.f17887m.setVisibility(0);
            } else {
                this.f17883i.setVisibility(0);
                this.f17887m.setVisibility(8);
            }
        } else {
            this.f17882h.setIndeterminate(true);
        }
        if (!z4) {
            return;
        }
        if (z5) {
            this.f17877c.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_selected_item));
        } else {
            this.f17877c.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_ripple_bg_card));
        }
    }
}
