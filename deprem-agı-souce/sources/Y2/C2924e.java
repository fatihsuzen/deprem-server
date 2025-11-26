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
import z2.P;

/* renamed from: y2.e  reason: case insensitive filesystem */
public final class C2924e extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private Context f26358a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f26359b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26360c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26361d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f26362e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2924e(View view, Context context) {
        super(view);
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        t.e(context, "context");
        this.f26358a = context;
        this.f26359b = (ImageView) view.findViewById(R.id.iv_logo_home_card_item);
        this.f26360c = (TextView) view.findViewById(R.id.tv_name_home_card_item);
        this.f26361d = (TextView) view.findViewById(R.id.tv_desc_home_card_item);
        this.f26362e = (TextView) view.findViewById(R.id.tv_status_home_card_item);
        TextView textView = this.f26360c;
        if (textView != null) {
            textView.setTypeface(k.f32g.w());
        }
        TextView textView2 = this.f26361d;
        if (textView2 != null) {
            textView2.setTypeface(k.f32g.x());
        }
        TextView textView3 = this.f26362e;
        if (textView3 != null) {
            textView3.setTypeface(k.f32g.x());
        }
    }

    private final boolean a(C2655d dVar) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = this.f26358a.getPackageManager();
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
            textView.setText(this.f26358a.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(this.f26358a, R.color.download_installed_status));
            textView.setBackground(ContextCompat.getDrawable(this.f26358a, R.drawable.bg_status_download_installed));
        } else {
            textView.setText(this.f26358a.getString(R.string.status_download_update));
            v.c(textView);
        }
        textView.setVisibility(0);
        if (z4) {
            textView2.setVisibility(8);
        }
    }

    private final void d(String str, TextView textView, TextView textView2, boolean z4) {
        if (new C2954m().v(str, this.f26358a)) {
            C2940B a5 = C2940B.f26458v.a(this.f26358a);
            a5.a();
            t.b(str);
            T G02 = a5.G0(str);
            C2655d Y4 = a5.Y(str);
            a5.m();
            if (Y4 == null) {
                return;
            }
            if (Y4.F() && a.f15150a.h0(this.f26358a) && a(Y4)) {
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

    static /* synthetic */ void e(C2924e eVar, String str, TextView textView, TextView textView2, boolean z4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z4 = true;
        }
        eVar.d(str, textView, textView2, z4);
    }

    private final void f(ImageView imageView, String str, String str2) {
        if (new C2954m().v(str2, this.f26358a)) {
            imageView.setImageDrawable(P.f26510a.j(this.f26358a, str2));
            return;
        }
        s.h().l(str).l(R.drawable.shape_bg_placeholder).n(new h((int) this.f26358a.getResources().getDimension(R.dimen.border_radius_s), (h.a) null, 2, (C2633k) null)).i(imageView);
    }

    private final void g(String str, String str2, TextView textView, TextView textView2) {
        textView.setText(str);
        textView2.setText(str2);
    }

    public final void b(Object obj) {
        t.e(obj, "item");
        if (obj instanceof C2657f) {
            C2657f fVar = (C2657f) obj;
            String N4 = fVar.N();
            String o02 = fVar.o0();
            TextView textView = this.f26360c;
            t.b(textView);
            TextView textView2 = this.f26361d;
            t.b(textView2);
            g(N4, o02, textView, textView2);
            String S4 = fVar.S();
            TextView textView3 = this.f26362e;
            t.b(textView3);
            TextView textView4 = this.f26361d;
            t.b(textView4);
            e(this, S4, textView3, textView4, false, 8, (Object) null);
            ImageView imageView = this.f26359b;
            t.b(imageView);
            f(imageView, fVar.G(), fVar.S());
            return;
        }
        if (obj instanceof C2746c) {
            C2660i a5 = ((C2746c) obj).a();
            t.b(a5);
            String e5 = a5.e();
            TextView textView5 = this.f26360c;
            t.b(textView5);
            TextView textView6 = this.f26361d;
            t.b(textView6);
            g(e5, (String) null, textView5, textView6);
            TextView textView7 = this.f26362e;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            int color = ContextCompat.getColor(this.f26358a, R.color.main_blue);
            Drawable drawable = ContextCompat.getDrawable(this.f26358a, R.drawable.vector_plus);
            if (drawable != null) {
                drawable.setTint(color);
            }
            ImageView imageView2 = this.f26359b;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable);
                return;
            }
            return;
        }
        throw new Exception("item unknown!");
    }

    public final void h() {
        ImageView imageView = this.f26359b;
        if (imageView != null) {
            imageView.setImageDrawable((Drawable) null);
        }
        TextView textView = this.f26360c;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        TextView textView2 = this.f26361d;
        if (textView2 != null) {
            textView2.setText((CharSequence) null);
        }
        TextView textView3 = this.f26362e;
        if (textView3 != null) {
            textView3.setText((CharSequence) null);
        }
    }
}
