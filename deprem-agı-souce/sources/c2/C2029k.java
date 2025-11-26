package C2;

import B2.c;
import B2.v;
import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2291k;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import com.uptodown.workers.DownloadWorker;
import k2.C2594d;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import l2.C2668q;
import l2.T;
import z2.C2940B;
import z2.C2954m;

/* renamed from: C2.k  reason: case insensitive filesystem */
public abstract class C2029k extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private Context f17822a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2029k(View view, Context context) {
        super(view);
        t.e(view, "itemView");
        t.e(context, "context");
        this.f17822a = context;
    }

    /* access modifiers changed from: private */
    public static final void d(C2594d dVar, C2657f fVar, View view) {
        dVar.b(fVar);
    }

    private final void f(C2655d dVar, T t5, TextView textView) {
        if (t5 != null && !t5.m()) {
            textView.setText(this.f17822a.getString(R.string.status_download_update));
            v.c(textView);
        } else if (dVar.d()) {
            textView.setText(this.f17822a.getString(R.string.dark_mode_disabled));
            textView.setTextColor(ContextCompat.getColor(this.f17822a, R.color.main_light_grey));
            textView.setBackground(ContextCompat.getDrawable(this.f17822a, R.drawable.bg_status_download_installed));
        } else {
            textView.setText(this.f17822a.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(this.f17822a, R.color.main_blue));
            textView.setBackground(ContextCompat.getDrawable(this.f17822a, R.drawable.shape_stroke_blue_primary));
        }
        textView.setTypeface(k.f32g.w());
    }

    private final void j(String str, ProgressBar progressBar, ImageView imageView, TextView textView, TextView textView2, LinearLayout linearLayout) {
        c.f17333a.c(progressBar, imageView);
        linearLayout.setVisibility(8);
        if (textView2 != null) {
            g(str, textView2, textView);
        }
    }

    private final void k(int i5, long j5, ProgressBar progressBar, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout) {
        c.f17333a.e(progressBar, imageView);
        textView.setVisibility(8);
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        linearLayout.setVisibility(0);
        if (i5 == 0) {
            progressBar.setIndeterminate(true);
            textView2.setText(this.f17822a.getString(R.string.status_download_update_pending));
            return;
        }
        progressBar.setIndeterminate(false);
        progressBar.setProgress(i5);
        textView2.setText(this.f17822a.getString(R.string.percent_of_total_size, new Object[]{Integer.valueOf(i5), new C2291k().d(j5, this.f17822a)}));
    }

    public final RelativeLayout.LayoutParams b(RelativeLayout.LayoutParams layoutParams, Context context, int i5, int i6) {
        t.e(layoutParams, "<this>");
        t.e(context, "context");
        int dimension = (int) context.getResources().getDimension(R.dimen.margin_m);
        if (t.a(a.f15150a.n(context), "ar")) {
            if (i5 == i6) {
                layoutParams.setMargins(dimension, 0, 0, 0);
                return layoutParams;
            } else if (i5 == 1) {
                layoutParams.setMargins(dimension, 0, dimension, 0);
                return layoutParams;
            } else {
                layoutParams.setMargins(dimension, 0, 0, 0);
                return layoutParams;
            }
        } else if (i5 == i6) {
            layoutParams.setMargins(dimension, 0, dimension, 0);
            return layoutParams;
        } else {
            layoutParams.setMargins(dimension, 0, 0, 0);
            return layoutParams;
        }
    }

    public final void c(View view, C2594d dVar, C2657f fVar) {
        t.e(view, "<this>");
        t.e(dVar, "listener");
        t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        view.setOnClickListener(new C2026j(dVar, fVar));
    }

    public final void e(C2657f fVar, ProgressBar progressBar, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout) {
        C2668q qVar;
        boolean z4;
        t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        t.e(progressBar, "pb");
        t.e(imageView, "ivIcon");
        t.e(textView, "tvDesc");
        TextView textView4 = textView2;
        t.e(textView4, "tvProgress");
        LinearLayout linearLayout2 = linearLayout;
        t.e(linearLayout2, "llProgress");
        C2940B a5 = C2940B.f26458v.a(this.f17822a);
        a5.a();
        if (fVar.S() != null) {
            String S4 = fVar.S();
            t.b(S4);
            qVar = a5.k0(S4, fVar.A0());
        } else {
            qVar = null;
        }
        boolean z5 = false;
        if (!UptodownApp.f13477F.S("downloadApkWorker", this.f17822a) || !DownloadWorker.f21359d.j(fVar.e())) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (qVar != null && qVar.M()) {
            z5 = true;
        }
        if (qVar == null || (!z4 && !z5)) {
            j(fVar.S(), progressBar, imageView, textView, textView3, linearLayout);
            return;
        }
        k(qVar.x(), qVar.z(), progressBar, imageView, textView, textView4, textView3, linearLayout2);
    }

    public final void g(String str, TextView textView, TextView textView2) {
        t.e(textView, "tvStatus");
        t.e(textView2, "tvDesc");
        if (new C2954m().v(str, this.f17822a)) {
            C2940B a5 = C2940B.f26458v.a(this.f17822a);
            a5.a();
            t.b(str);
            T G02 = a5.G0(str);
            C2655d Y4 = a5.Y(str);
            a5.m();
            if (Y4 == null) {
                textView.setVisibility(0);
                textView2.setVisibility(8);
            } else if (Y4.e() != 0 || Y4.H()) {
                textView.setVisibility(8);
                textView2.setVisibility(0);
            } else {
                f(Y4, G02, textView);
                textView.setVisibility(0);
                textView2.setVisibility(8);
            }
        } else {
            textView.setText(this.f17822a.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(this.f17822a, R.color.main_blue));
            textView.setBackground(ContextCompat.getDrawable(this.f17822a, R.drawable.shape_stroke_blue_primary));
            textView.setTypeface(k.f32g.w());
            textView.setVisibility(8);
            textView2.setVisibility(0);
        }
    }

    public final void h(ImageView imageView, String str) {
        t.e(imageView, "iv");
        if (str != null) {
            s.h().l(str).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this.f17822a)).i(imageView);
        } else {
            imageView.setImageDrawable(ContextCompat.getDrawable(this.f17822a, R.drawable.vector_app_icon_placeholder));
        }
    }

    public final void i(C2657f fVar, TextView textView, TextView textView2) {
        t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        t.e(textView, "tvName");
        t.e(textView2, "tvDesc");
        textView.setText(fVar.N());
        String o02 = fVar.o0();
        if (o02 == null || o02.length() == 0) {
            o02 = fVar.g();
        }
        textView2.setText(o02);
    }
}
