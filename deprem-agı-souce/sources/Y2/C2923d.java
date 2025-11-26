package y2;

import B2.v;
import D2.h;
import S1.k;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import b2.C2301u;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import l2.C2660i;
import l2.T;
import s2.C2746c;
import z2.C2940B;
import z2.C2954m;

/* renamed from: y2.d  reason: case insensitive filesystem */
public final class C2923d extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private Context f26352a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f26353b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f26354c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26355d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f26356e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f26357f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2923d(View view, Context context) {
        super(view);
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        t.e(context, "context");
        this.f26352a = context;
        View findViewById = view.findViewById(R.id.iv_home_card_featured_item);
        t.d(findViewById, "findViewById(...)");
        this.f26353b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.iv_logo_home_card_featured_item);
        t.d(findViewById2, "findViewById(...)");
        this.f26354c = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_name_home_card_featured_item);
        t.d(findViewById3, "findViewById(...)");
        this.f26355d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_desc_home_card_featured_item);
        t.d(findViewById4, "findViewById(...)");
        this.f26356e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_status_home_card_featured_item);
        t.d(findViewById5, "findViewById(...)");
        this.f26357f = (TextView) findViewById5;
        TextView textView = this.f26355d;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        this.f26356e.setTypeface(aVar.x());
        this.f26357f.setTypeface(aVar.x());
    }

    private final boolean a(C2655d dVar) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = this.f26352a.getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            String o5 = dVar.o();
            t.b(o5);
            applicationInfo = C2301u.a(packageManager, o5, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        if (dVar.e() == 0 && applicationInfo != null && applicationInfo.enabled) {
            return true;
        }
        return false;
    }

    private final void c(T t5, TextView textView, TextView textView2, boolean z4) {
        if (t5 == null || t5.m()) {
            textView.setText(this.f26352a.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(this.f26352a, R.color.download_installed_status));
            textView.setBackground(ContextCompat.getDrawable(this.f26352a, R.drawable.bg_status_download_installed));
        } else {
            textView.setText(this.f26352a.getString(R.string.status_download_update));
            v.c(textView);
        }
        textView.setVisibility(0);
        if (z4) {
            textView2.setVisibility(8);
        }
    }

    private final void d(String str, TextView textView, TextView textView2, boolean z4) {
        if (new C2954m().v(str, this.f26352a)) {
            C2940B a5 = C2940B.f26458v.a(this.f26352a);
            a5.a();
            t.b(str);
            T G02 = a5.G0(str);
            C2655d Y4 = a5.Y(str);
            a5.m();
            if (Y4 == null) {
                return;
            }
            if (Y4.F() && a.f15150a.h0(this.f26352a) && a(Y4)) {
                c(G02, textView, textView2, z4);
            } else if (!a(Y4) || Y4.F()) {
                textView.setVisibility(8);
                if (z4) {
                    textView2.setVisibility(0);
                }
            } else {
                c(G02, textView, textView2, z4);
            }
        } else {
            if (z4) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(4);
            }
            textView2.setVisibility(0);
        }
    }

    static /* synthetic */ void e(C2923d dVar, String str, TextView textView, TextView textView2, boolean z4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z4 = true;
        }
        dVar.d(str, textView, textView2, z4);
    }

    private final void f(ImageView imageView, String str) {
        if (str != null) {
            s.h().l(str).l(R.drawable.shape_bg_placeholder).n(new h((int) this.f26352a.getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2633k) null)).i(imageView);
            return;
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(this.f26352a, R.drawable.vector_app_icon_placeholder));
    }

    private final void g(String str, String str2, TextView textView, TextView textView2) {
        textView.setText(str);
        textView2.setText(str2);
    }

    public final void b(Object obj) {
        t.e(obj, "item");
        if (obj instanceof C2657f) {
            C2657f fVar = (C2657f) obj;
            String z4 = fVar.z();
            if (z4 == null || z4.length() == 0) {
                this.f26353b.setImageDrawable(ContextCompat.getDrawable(this.f26352a, R.drawable.shape_bg_placeholder));
            } else {
                s.h().l(fVar.D()).n(new h((int) this.f26352a.getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2633k) null)).a().f().l(R.drawable.shape_bg_placeholder).i(this.f26353b);
            }
            g(fVar.N(), fVar.o0(), this.f26355d, this.f26356e);
            e(this, fVar.S(), this.f26357f, this.f26356e, false, 8, (Object) null);
            f(this.f26354c, fVar.H());
            return;
        }
        if (obj instanceof C2746c) {
            C2660i a5 = ((C2746c) obj).a();
            t.b(a5);
            g(a5.e(), (String) null, this.f26355d, this.f26356e);
            this.f26357f.setVisibility(8);
            int color = ContextCompat.getColor(this.f26352a, R.color.main_blue);
            Drawable drawable = ContextCompat.getDrawable(this.f26352a, R.drawable.vector_plus);
            if (drawable != null) {
                drawable.setTint(color);
            }
            this.f26353b.setImageDrawable(drawable);
            this.f26354c.setImageDrawable((Drawable) null);
            return;
        }
        throw new Exception("item unknown!");
    }

    public final void h() {
        this.f26353b.setImageDrawable((Drawable) null);
        this.f26354c.setImageDrawable((Drawable) null);
        this.f26355d.setText((CharSequence) null);
        this.f26356e.setText((CharSequence) null);
        this.f26357f.setText((CharSequence) null);
    }
}
