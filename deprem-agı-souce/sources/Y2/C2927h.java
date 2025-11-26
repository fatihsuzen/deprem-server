package y2;

import S1.k;
import Y1.C2257a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import b2.C2291k;
import b2.C2301u;
import com.uptodown.R;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2643C;
import l2.C2655d;
import l2.C2668q;
import t3.s;
import z2.C2940B;

/* renamed from: y2.h  reason: case insensitive filesystem */
public final class C2927h extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f26369a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f26370b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26371c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26372d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f26373e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f26374f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f26375g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2927h(View view) {
        super(view);
        t.e(view, "itemView");
        View findViewById = view.findViewById(R.id.rl_tv_old_version_item);
        t.d(findViewById, "findViewById(...)");
        this.f26369a = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.iv_icono_version);
        t.d(findViewById2, "findViewById(...)");
        this.f26370b = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_name_version);
        t.d(findViewById3, "findViewById(...)");
        this.f26371c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_size_version);
        t.d(findViewById4, "findViewById(...)");
        this.f26372d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_version);
        t.d(findViewById5, "findViewById(...)");
        this.f26373e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.progressbar_downloading_version);
        t.d(findViewById6, "findViewById(...)");
        this.f26374f = (ProgressBar) findViewById6;
        View findViewById7 = view.findViewById(R.id.tv_action_old_version_item);
        t.d(findViewById7, "findViewById(...)");
        this.f26375g = (TextView) findViewById7;
        TextView textView = this.f26371c;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        this.f26372d.setTypeface(aVar.x());
        this.f26373e.setTypeface(aVar.x());
        this.f26375g.setTypeface(aVar.x());
    }

    public final void a(C2643C c5, Context context, String str, C2655d dVar) {
        t.e(c5, "item");
        t.e(context, "context");
        String str2 = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            t.b(str);
            PackageInfo d5 = C2301u.d(packageManager, str, 0);
            ImageView imageView = this.f26370b;
            ApplicationInfo applicationInfo = d5.applicationInfo;
            imageView.setImageDrawable(applicationInfo != null ? applicationInfo.loadIcon(context.getPackageManager()) : null);
        } catch (Exception unused) {
            this.f26370b.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_uptodown_logo_disabled));
        }
        TextView textView = this.f26371c;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        this.f26372d.setTypeface(aVar.x());
        this.f26373e.setTypeface(aVar.x());
        this.f26371c.setText(dVar != null ? dVar.m() : null);
        this.f26373e.setText(c5.i());
        this.f26374f.setVisibility(4);
        this.f26375g.setVisibility(0);
        this.f26371c.setTextColor(ContextCompat.getColor(context, R.color.main_dark_grey));
        this.f26372d.setTextColor(ContextCompat.getColor(context, R.color.main_dark_grey));
        this.f26373e.setTextColor(ContextCompat.getColor(context, R.color.main_dark_grey));
        this.f26369a.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        if ((dVar != null ? Long.valueOf(dVar.A()) : null) == null || dVar.A() != c5.h()) {
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            String b5 = c5.b();
            t.b(b5);
            C2668q h02 = a5.h0(b5);
            a5.m();
            boolean z4 = h02 != null && h02.x() > 0 && h02.x() < 100;
            if (h02 == null) {
                this.f26375g.setText(R.string.updates_button_download_app);
                this.f26375g.setBackgroundColor(ContextCompat.getColor(context, R.color.accent_green));
            } else if (z4) {
                TextView textView2 = this.f26372d;
                Q q5 = Q.f24695a;
                String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(h02.x())}, 1));
                t.d(format, "format(...)");
                textView2.setText(format);
                this.f26373e.setVisibility(8);
                this.f26374f.setProgress(h02.x());
                this.f26374f.setVisibility(0);
                this.f26375g.setText(17039360);
                this.f26375g.setBackgroundColor(ContextCompat.getColor(context, R.color.main_light_grey));
            } else {
                this.f26373e.setVisibility(0);
                if (c5.g() > 0) {
                    this.f26372d.setText(new C2291k().d(c5.g(), context));
                }
                C2257a i5 = aVar.i();
                if (i5 != null) {
                    str2 = i5.b();
                }
                if (s.E(str2, h02.w(), true)) {
                    this.f26374f.setIndeterminate(true);
                    this.f26374f.setVisibility(0);
                    this.f26373e.setText(R.string.installing);
                    this.f26372d.setText("");
                    return;
                }
                this.f26375g.setText(R.string.option_button_install);
                this.f26375g.setBackgroundColor(ContextCompat.getColor(context, R.color.main_blue));
            }
        } else {
            this.f26371c.setTextColor(ContextCompat.getColor(context, R.color.white));
            this.f26372d.setTextColor(ContextCompat.getColor(context, R.color.white));
            this.f26373e.setTextColor(ContextCompat.getColor(context, R.color.white));
            this.f26369a.setBackgroundColor(ContextCompat.getColor(context, R.color.main_blue));
            this.f26375g.setVisibility(8);
        }
    }
}
