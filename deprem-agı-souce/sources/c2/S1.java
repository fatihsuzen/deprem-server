package C2;

import B2.v;
import S1.k;
import W2.q;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d3.C2345b;
import h2.n1;
import k2.X;
import kotlin.jvm.internal.t;
import l2.C2660i;
import l2.Y;

public final class S1 extends C2038n {

    /* renamed from: b  reason: collision with root package name */
    private final n1 f17595b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f17596c;

    /* renamed from: d  reason: collision with root package name */
    private final X f17597d;

    /* renamed from: e  reason: collision with root package name */
    private a f17598e = a.DOWNLOAD;

    public enum a {
        DOWNLOAD,
        OPEN,
        INSTALLING,
        DEACTIVATED;

        static {
            a[] a5;
            f17604f = C2345b.a(a5);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17605a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                C2.S1$a[] r0 = C2.S1.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                C2.S1$a r1 = C2.S1.a.DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                C2.S1$a r1 = C2.S1.a.OPEN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                C2.S1$a r1 = C2.S1.a.DEACTIVATED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                C2.S1$a r1 = C2.S1.a.INSTALLING     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f17605a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: C2.S1.b.<clinit>():void");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public S1(h2.n1 r3, android.content.Context r4, k2.X r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.t.e(r3, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r4, r0)
            android.widget.RelativeLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.t.d(r0, r1)
            r2.<init>(r0)
            r2.f17595b = r3
            r2.f17596c = r4
            r2.f17597d = r5
            C2.S1$a r4 = C2.S1.a.DOWNLOAD
            r2.f17598e = r4
            android.widget.RelativeLayout r4 = r3.f23402k
            C2.O1 r5 = new C2.O1
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            android.widget.RelativeLayout r4 = r3.f23402k
            C2.P1 r5 = new C2.P1
            r5.<init>(r2)
            r4.setOnLongClickListener(r5)
            android.widget.RelativeLayout r4 = r3.f23400i
            C2.Q1 r5 = new C2.Q1
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            android.widget.TextView r4 = r3.f23404m
            S1.k$a r5 = S1.k.f32g
            android.graphics.Typeface r0 = r5.w()
            r4.setTypeface(r0)
            android.widget.TextView r4 = r3.f23406o
            android.graphics.Typeface r0 = r5.w()
            r4.setTypeface(r0)
            android.widget.TextView r4 = r3.f23405n
            android.graphics.Typeface r0 = r5.x()
            r4.setTypeface(r0)
            android.widget.TextView r3 = r3.f23407p
            android.graphics.Typeface r4 = r5.x()
            r3.setTypeface(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C2.S1.<init>(h2.n1, android.content.Context, k2.X):void");
    }

    private final void A(ProgressBar progressBar, int i5) {
        progressBar.setIndeterminate(false);
        progressBar.setProgress(i5);
        progressBar.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void k(S1 s12, View view) {
        int bindingAdapterPosition;
        if (s12.f17597d != null && (bindingAdapterPosition = s12.getBindingAdapterPosition()) != -1) {
            s12.f17597d.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean l(S1 s12, View view) {
        int bindingAdapterPosition;
        if (s12.f17597d == null || (bindingAdapterPosition = s12.getBindingAdapterPosition()) == -1) {
            return true;
        }
        X x4 = s12.f17597d;
        t.b(view);
        x4.b(view, bindingAdapterPosition);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void m(S1 s12, View view) {
        if (UptodownApp.f13477F.Z()) {
            int i5 = b.f17605a[s12.f17598e.ordinal()];
            if (i5 == 1) {
                X x4 = s12.f17597d;
                if (x4 != null) {
                    x4.c(s12.getBindingAdapterPosition());
                }
            } else if (i5 == 2) {
                X x5 = s12.f17597d;
                if (x5 != null) {
                    x5.d(s12.getBindingAdapterPosition());
                }
            } else if (i5 == 3) {
                X x6 = s12.f17597d;
                if (x6 != null) {
                    x6.c(s12.getBindingAdapterPosition());
                }
            } else if (i5 != 4) {
                throw new q();
            }
        }
    }

    private final void o(ProgressBar progressBar) {
        progressBar.setVisibility(8);
    }

    private final void p(Y y4) {
        this.f17595b.f23398g.removeAllViews();
        if (!y4.c().isEmpty()) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginStart((int) this.f17596c.getResources().getDimension(R.dimen.margin_s));
            int i5 = 0;
            for (C2660i iVar : y4.c()) {
                int i6 = i5 + 1;
                View inflate = LayoutInflater.from(this.f17596c).inflate(R.layout.user_list_item_floating_tag, (ViewGroup) null);
                t.c(inflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) inflate;
                textView.setText(iVar.e());
                textView.setTypeface(k.f32g.x());
                if (i5 > 0) {
                    this.f17595b.f23398g.addView(inflate, layoutParams);
                } else {
                    this.f17595b.f23398g.addView(inflate);
                }
                textView.setOnClickListener(new R1(this, y4, iVar));
                i5 = i6;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void q(S1 s12, Y y4, C2660i iVar, View view) {
        X x4 = s12.f17597d;
        if (x4 != null) {
            x4.e(y4.a(), iVar);
        }
    }

    private final void r() {
        this.f17595b.f23401j.setVisibility(0);
        this.f17595b.f23394c.setVisibility(0);
        this.f17595b.f23407p.setVisibility(0);
        this.f17595b.f23404m.setVisibility(8);
    }

    private final void s() {
        this.f17598e = a.DOWNLOAD;
        TextView textView = this.f17595b.f23404m;
        t.d(textView, "tvActionUserListItem");
        v.a(textView);
        this.f17595b.f23404m.setText(this.f17596c.getString(R.string.updates_button_download_app));
        this.f17595b.f23401j.setVisibility(8);
    }

    private final void t() {
        this.f17598e = a.DEACTIVATED;
        this.f17595b.f23404m.setVisibility(0);
        this.f17595b.f23404m.setText(this.f17596c.getString(R.string.updates_button_download_app));
        this.f17595b.f23404m.setBackground(ContextCompat.getDrawable(this.f17596c, R.drawable.shape_bg_download_button_desactivated));
        this.f17595b.f23404m.setTextColor(ContextCompat.getColor(this.f17596c, R.color.white));
        this.f17595b.f23401j.setVisibility(8);
    }

    private final void u() {
        ProgressBar progressBar = this.f17595b.f23399h;
        t.d(progressBar, "pbProgressUserListItem");
        ImageView imageView = this.f17595b.f23396e;
        t.d(imageView, "ivIconUserListItem");
        e(progressBar, imageView);
        this.f17595b.f23401j.setVisibility(0);
        this.f17595b.f23394c.setVisibility(0);
        this.f17595b.f23407p.setVisibility(8);
        this.f17595b.f23404m.setVisibility(8);
    }

    private final void v() {
        this.f17595b.f23404m.setText(this.f17596c.getString(R.string.option_button_install));
        TextView textView = this.f17595b.f23404m;
        t.d(textView, "tvActionUserListItem");
        v.c(textView);
        this.f17595b.f23401j.setVisibility(8);
    }

    private final void w() {
        this.f17598e = a.INSTALLING;
        ProgressBar progressBar = this.f17595b.f23399h;
        t.d(progressBar, "pbProgressUserListItem");
        ImageView imageView = this.f17595b.f23396e;
        t.d(imageView, "ivIconUserListItem");
        e(progressBar, imageView);
        this.f17595b.f23404m.setText(this.f17596c.getString(R.string.installing));
        ProgressBar progressBar2 = this.f17595b.f23399h;
        t.d(progressBar2, "pbProgressUserListItem");
        z(progressBar2);
        this.f17595b.f23404m.setVisibility(0);
        this.f17595b.f23404m.setBackground(ContextCompat.getDrawable(this.f17596c, R.drawable.bg_status_download_installed));
        this.f17595b.f23404m.setTextColor(ContextCompat.getColor(this.f17596c, R.color.download_installed_status));
        this.f17595b.f23401j.setVisibility(8);
    }

    private final void x() {
        this.f17598e = a.OPEN;
        ProgressBar progressBar = this.f17595b.f23399h;
        t.d(progressBar, "pbProgressUserListItem");
        ImageView imageView = this.f17595b.f23396e;
        t.d(imageView, "ivIconUserListItem");
        c(progressBar, imageView);
        TextView textView = this.f17595b.f23404m;
        t.d(textView, "tvActionUserListItem");
        v.a(textView);
        ProgressBar progressBar2 = this.f17595b.f23399h;
        t.d(progressBar2, "pbProgressUserListItem");
        o(progressBar2);
        this.f17595b.f23404m.setText(this.f17596c.getString(R.string.open));
        this.f17595b.f23401j.setVisibility(8);
    }

    private final void y() {
        this.f17598e = a.INSTALLING;
        ProgressBar progressBar = this.f17595b.f23399h;
        t.d(progressBar, "pbProgressUserListItem");
        ImageView imageView = this.f17595b.f23396e;
        t.d(imageView, "ivIconUserListItem");
        e(progressBar, imageView);
        this.f17595b.f23404m.setText(this.f17596c.getString(R.string.installing));
        ProgressBar progressBar2 = this.f17595b.f23399h;
        t.d(progressBar2, "pbProgressUserListItem");
        z(progressBar2);
        this.f17595b.f23404m.setVisibility(0);
        this.f17595b.f23404m.setBackground(ContextCompat.getDrawable(this.f17596c, R.drawable.bg_status_download_installed));
        this.f17595b.f23404m.setTextColor(ContextCompat.getColor(this.f17596c, R.color.download_installed_status));
        this.f17595b.f23401j.setVisibility(8);
    }

    private final void z(ProgressBar progressBar) {
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(l2.Y r12, boolean r13) {
        /*
            r11 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.t.e(r12, r0)
            r11.p(r12)
            com.squareup.picasso.s r0 = com.squareup.picasso.s.h()
            java.lang.String r1 = r12.e()
            com.squareup.picasso.w r0 = r0.l(r1)
            r1 = 2131231328(0x7f080260, float:1.8078734E38)
            com.squareup.picasso.w r0 = r0.l(r1)
            com.uptodown.UptodownApp$a r2 = com.uptodown.UptodownApp.f13477F
            android.content.Context r3 = r11.f17596c
            D2.h r2 = r2.g0(r3)
            com.squareup.picasso.w r0 = r0.n(r2)
            h2.n1 r2 = r11.f17595b
            android.widget.ImageView r2 = r2.f23396e
            r0.i(r2)
            boolean r0 = r12.j()
            if (r0 == 0) goto L_0x0045
            h2.n1 r0 = r11.f17595b
            android.widget.ImageView r0 = r0.f23395d
            android.content.Context r1 = r11.f17596c
            r2 = 2131231526(0x7f080326, float:1.8079136E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r2)
            r0.setImageDrawable(r1)
            goto L_0x0080
        L_0x0045:
            boolean r0 = r12.k()
            if (r0 == 0) goto L_0x005c
            h2.n1 r0 = r11.f17595b
            android.widget.ImageView r0 = r0.f23395d
            android.content.Context r1 = r11.f17596c
            r2 = 2131231527(0x7f080327, float:1.8079138E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r2)
            r0.setImageDrawable(r1)
            goto L_0x0080
        L_0x005c:
            boolean r0 = r12.l()
            if (r0 == 0) goto L_0x0073
            h2.n1 r0 = r11.f17595b
            android.widget.ImageView r0 = r0.f23395d
            android.content.Context r1 = r11.f17596c
            r2 = 2131231528(0x7f080328, float:1.807914E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r2)
            r0.setImageDrawable(r1)
            goto L_0x0080
        L_0x0073:
            h2.n1 r0 = r11.f17595b
            android.widget.ImageView r0 = r0.f23395d
            android.content.Context r2 = r11.f17596c
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r2, r1)
            r0.setImageDrawable(r1)
        L_0x0080:
            h2.n1 r0 = r11.f17595b
            android.widget.TextView r0 = r0.f23406o
            java.lang.String r1 = r12.f()
            r0.setText(r1)
            h2.n1 r0 = r11.f17595b
            android.widget.TextView r0 = r0.f23404m
            r1 = 8
            r0.setVisibility(r1)
            C2.S1$a r0 = C2.S1.a.DOWNLOAD
            r11.f17598e = r0
            h2.n1 r0 = r11.f17595b
            android.widget.TextView r0 = r0.f23405n
            java.lang.String r2 = r12.i()
            r0.setText(r2)
            z2.B$a r0 = z2.C2940B.f26458v
            android.content.Context r2 = r11.f17596c
            z2.B r0 = r0.a(r2)
            r0.a()
            java.lang.String r2 = r12.g()
            r3 = 0
            if (r2 == 0) goto L_0x00c1
            java.lang.String r2 = r12.g()
            kotlin.jvm.internal.t.b(r2)
            l2.d r2 = r0.Y(r2)
            goto L_0x00c2
        L_0x00c1:
            r2 = r3
        L_0x00c2:
            java.lang.String r4 = r12.g()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0107
            int r4 = r4.length()
            if (r4 != 0) goto L_0x00d1
            goto L_0x0107
        L_0x00d1:
            java.lang.String r3 = r12.g()
            kotlin.jvm.internal.t.b(r3)
            l2.q r3 = r0.j0(r3)
            if (r3 == 0) goto L_0x0107
            S1.k$a r4 = S1.k.f32g
            Y1.c r7 = r4.j()
            if (r7 == 0) goto L_0x0107
            java.util.ArrayList r7 = r3.o()
            java.lang.Object r7 = r7.get(r6)
            l2.r r7 = (l2.r) r7
            java.lang.String r7 = r7.a()
            Y1.c r4 = r4.j()
            kotlin.jvm.internal.t.b(r4)
            java.lang.String r4 = r4.a()
            boolean r4 = t3.s.E(r7, r4, r5)
            if (r4 == 0) goto L_0x0107
            r4 = r5
            goto L_0x0108
        L_0x0107:
            r4 = r6
        L_0x0108:
            if (r2 != 0) goto L_0x01fe
            java.lang.String r2 = "pbProgressUserListItem"
            if (r3 == 0) goto L_0x01d2
            boolean r12 = r3.N()
            if (r12 != 0) goto L_0x0192
            if (r13 == 0) goto L_0x0118
            goto L_0x0192
        L_0x0118:
            if (r4 == 0) goto L_0x011f
            r11.y()
            goto L_0x0195
        L_0x011f:
            boolean r12 = r3.f()
            if (r12 == 0) goto L_0x0129
            r11.v()
            goto L_0x0195
        L_0x0129:
            com.uptodown.workers.DownloadWorker$a r12 = com.uptodown.workers.DownloadWorker.f21359d
            long r7 = r3.h()
            long r9 = r3.E()
            boolean r12 = r12.k(r7, r9)
            if (r12 == 0) goto L_0x0184
            h2.n1 r12 = r11.f17595b
            android.widget.TextView r12 = r12.f23407p
            r12.setVisibility(r1)
            h2.n1 r12 = r11.f17595b
            android.widget.TextView r12 = r12.f23405n
            android.view.View r13 = r11.itemView
            android.content.Context r13 = r13.getContext()
            int r1 = r3.x()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            b2.k r4 = new b2.k
            r4.<init>()
            long r7 = r3.z()
            android.content.Context r9 = r11.f17596c
            java.lang.String r4 = r4.d(r7, r9)
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r6] = r1
            r7[r5] = r4
            r1 = 2131952541(0x7f13039d, float:1.9541528E38)
            java.lang.String r13 = r13.getString(r1, r7)
            r12.setText(r13)
            h2.n1 r12 = r11.f17595b
            android.widget.ProgressBar r12 = r12.f23399h
            kotlin.jvm.internal.t.d(r12, r2)
            int r13 = r3.x()
            r11.A(r12, r13)
            r11.u()
            goto L_0x0195
        L_0x0184:
            h2.n1 r12 = r11.f17595b
            android.widget.ProgressBar r12 = r12.f23399h
            kotlin.jvm.internal.t.d(r12, r2)
            r11.z(r12)
            r11.r()
            goto L_0x0195
        L_0x0192:
            r11.w()
        L_0x0195:
            boolean r12 = r3.M()
            java.lang.String r13 = "ivIconUserListItem"
            if (r12 != 0) goto L_0x01c0
            com.uptodown.workers.DownloadWorker$a r12 = com.uptodown.workers.DownloadWorker.f21359d
            long r4 = r3.h()
            long r6 = r3.E()
            boolean r12 = r12.k(r4, r6)
            if (r12 == 0) goto L_0x01ae
            goto L_0x01c0
        L_0x01ae:
            h2.n1 r12 = r11.f17595b
            android.widget.ProgressBar r12 = r12.f23399h
            kotlin.jvm.internal.t.d(r12, r2)
            h2.n1 r1 = r11.f17595b
            android.widget.ImageView r1 = r1.f23396e
            kotlin.jvm.internal.t.d(r1, r13)
            r11.c(r12, r1)
            goto L_0x021b
        L_0x01c0:
            h2.n1 r12 = r11.f17595b
            android.widget.ProgressBar r12 = r12.f23399h
            kotlin.jvm.internal.t.d(r12, r2)
            h2.n1 r1 = r11.f17595b
            android.widget.ImageView r1 = r1.f23396e
            kotlin.jvm.internal.t.d(r1, r13)
            r11.e(r12, r1)
            goto L_0x021b
        L_0x01d2:
            java.lang.String r13 = r12.g()
            if (r13 == 0) goto L_0x01f0
            int r13 = r13.length()
            if (r13 != 0) goto L_0x01df
            goto L_0x01f0
        L_0x01df:
            l2.f$b r13 = l2.C2657f.f25002J0
            java.lang.String r12 = r12.b()
            boolean r12 = r13.d(r12)
            if (r12 != 0) goto L_0x01ec
            goto L_0x01f0
        L_0x01ec:
            r11.s()
            goto L_0x021b
        L_0x01f0:
            r11.t()
            h2.n1 r12 = r11.f17595b
            android.widget.ProgressBar r12 = r12.f23399h
            kotlin.jvm.internal.t.d(r12, r2)
            r11.o(r12)
            goto L_0x021b
        L_0x01fe:
            S1.k$a r12 = S1.k.f32g
            Y1.a r12 = r12.i()
            if (r12 == 0) goto L_0x0218
            java.lang.String r12 = r12.b()
            java.lang.String r13 = r2.o()
            boolean r12 = t3.s.E(r12, r13, r5)
            if (r12 == 0) goto L_0x0218
            r11.w()
            goto L_0x021b
        L_0x0218:
            r11.x()
        L_0x021b:
            r0.m()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C2.S1.n(l2.Y, boolean):void");
    }
}
