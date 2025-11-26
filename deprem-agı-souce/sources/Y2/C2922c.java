package y2;

import S1.k;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.activities.Gallery;
import java.util.ArrayList;
import java.util.Arrays;
import k2.C2601k;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.C2666o;
import l2.P;
import x2.C2912b;

/* renamed from: y2.c  reason: case insensitive filesystem */
public final class C2922c extends Presenter.ViewHolder {

    /* renamed from: j  reason: collision with root package name */
    public static final a f26342j = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final TextView f26343a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f26344b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f26345c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f26346d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f26347e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f26348f;

    /* renamed from: g  reason: collision with root package name */
    private final ProgressBar f26349g;

    /* renamed from: h  reason: collision with root package name */
    private final LinearLayout f26350h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f26351i;

    /* renamed from: y2.c$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2922c(View view) {
        super(view);
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        View findViewById = view.findViewById(R.id.tv_name);
        t.d(findViewById, "findViewById(...)");
        this.f26343a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_short_desc);
        t.d(findViewById2, "findViewById(...)");
        this.f26344b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_description);
        t.d(findViewById3, "findViewById(...)");
        this.f26345c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_percent);
        t.d(findViewById4, "findViewById(...)");
        this.f26346d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_version);
        t.d(findViewById5, "findViewById(...)");
        this.f26347e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tv_autor);
        t.d(findViewById6, "findViewById(...)");
        this.f26348f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.pb_download);
        t.d(findViewById7, "findViewById(...)");
        this.f26349g = (ProgressBar) findViewById7;
        this.f26350h = (LinearLayout) view.findViewById(R.id.ll_screenshots);
        View findViewById8 = view.findViewById(R.id.rl_contaier_valoration_tv_app_detail);
        t.d(findViewById8, "findViewById(...)");
        this.f26351i = (RelativeLayout) findViewById8;
    }

    /* access modifiers changed from: private */
    public static final void e(C2657f fVar, View view) {
        Object tag = view.getTag();
        t.c(tag, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) tag).intValue();
        Intent intent = new Intent(view.getContext(), Gallery.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("images", fVar.m0());
        bundle.putInt("index", intValue);
        intent.putExtra("bundle", bundle);
        view.getContext().startActivity(intent);
    }

    /* access modifiers changed from: private */
    public static final void f(int i5, View view, boolean z4) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, i5);
        if (z4) {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.main_light_grey));
            layoutParams.setMargins(12, 0, 12, 12);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.transparent));
            layoutParams.setMargins(12, 12, 12, 12);
        }
        view.setLayoutParams(layoutParams);
    }

    private final void g(Context context, C2657f fVar) {
        if (fVar.a0() == 0) {
            this.f26351i.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f26351i.findViewById(R.id.tv_valoration_value_tv_app_detail);
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        textView.setText(String.valueOf(((double) fVar.a0()) / 10.0d));
        TextView textView2 = (TextView) this.f26351i.findViewById(R.id.tv_num_ratings);
        textView2.setTypeface(aVar.x());
        textView2.setText(String.valueOf(fVar.b0()));
        View findViewById = this.f26351i.findViewById(R.id.iv_star1);
        t.d(findViewById, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = this.f26351i.findViewById(R.id.iv_star2);
        t.d(findViewById2, "findViewById(...)");
        ImageView imageView2 = (ImageView) findViewById2;
        View findViewById3 = this.f26351i.findViewById(R.id.iv_star3);
        t.d(findViewById3, "findViewById(...)");
        ImageView imageView3 = (ImageView) findViewById3;
        View findViewById4 = this.f26351i.findViewById(R.id.iv_star4);
        t.d(findViewById4, "findViewById(...)");
        ImageView imageView4 = (ImageView) findViewById4;
        View findViewById5 = this.f26351i.findViewById(R.id.iv_star5);
        t.d(findViewById5, "findViewById(...)");
        ImageView imageView5 = (ImageView) findViewById5;
        imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
        if (fVar.a0() > 5) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (fVar.a0() > 15) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (fVar.a0() > 25) {
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (fVar.a0() > 35) {
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
        if (fVar.a0() > 45) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
        }
    }

    public final void c(Context context, C2657f fVar, int i5, C2601k kVar) {
        t.e(context, "context");
        t.e(fVar, "appInfo");
        this.f26343a.setText(fVar.N());
        String o02 = fVar.o0();
        if (o02 == null || o02.length() == 0 || kVar == null) {
            this.f26344b.setText(fVar.o0());
        } else {
            TextView textView = this.f26344b;
            C2666o.a aVar = C2666o.f25106g;
            String o03 = fVar.o0();
            t.b(o03);
            textView.setText(aVar.n(o03, context, kVar));
        }
        if (fVar.k() != null) {
            if (kVar != null) {
                TextView textView2 = this.f26345c;
                C2666o.a aVar2 = C2666o.f25106g;
                String k5 = fVar.k();
                t.b(k5);
                textView2.setText(aVar2.n(k5, context, kVar));
            } else {
                TextView textView3 = this.f26345c;
                C2666o.a aVar3 = C2666o.f25106g;
                String k6 = fVar.k();
                t.b(k6);
                textView3.setText(aVar3.n(k6, context, new b()));
            }
        }
        h(i5);
        this.f26347e.setText(fVar.B0());
        this.f26348f.setText(fVar.g());
        g(context, fVar);
    }

    public final void d(Context context, C2657f fVar) {
        ArrayList arrayList;
        LinearLayout linearLayout;
        t.e(context, "context");
        if (fVar != null) {
            arrayList = fVar.m0();
        } else {
            arrayList = null;
        }
        if (arrayList != null && (linearLayout = this.f26350h) != null) {
            if (linearLayout.getChildCount() > 0) {
                this.f26350h.removeAllViews();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            layoutParams.setMargins(12, 12, 12, 12);
            ArrayList m02 = fVar.m0();
            t.b(m02);
            int size = m02.size();
            for (int i5 = 0; i5 < size; i5++) {
                C2912b bVar = new C2912b(context);
                s h5 = s.h();
                ArrayList m03 = fVar.m0();
                t.b(m03);
                h5.l(((P) m03.get(i5)).d()).i(bVar);
                bVar.setPadding(4, 4, 4, 4);
                bVar.setLayoutParams(layoutParams);
                bVar.setFocusable(true);
                bVar.setTag(Integer.valueOf(i5));
                bVar.setOnClickListener(new C2920a(fVar));
                bVar.setOnFocusChangeListener(new C2921b(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
                this.f26350h.addView(bVar);
            }
        }
    }

    public final void h(int i5) {
        if (i5 > 0) {
            this.f26349g.setVisibility(0);
            this.f26349g.setProgress(i5);
            this.f26346d.setVisibility(0);
            TextView textView = this.f26346d;
            Q q5 = Q.f24695a;
            String format = String.format("%s%%", Arrays.copyOf(new Object[]{String.valueOf(i5)}, 1));
            t.d(format, "format(...)");
            textView.setText(format);
            return;
        }
        this.f26349g.setVisibility(8);
        this.f26346d.setVisibility(8);
    }

    public final void i(boolean z4) {
        this.f26349g.setIndeterminate(z4);
    }

    /* renamed from: y2.c$b */
    public static final class b implements C2601k {
        b() {
        }

        public void b(C2660i iVar) {
            t.e(iVar, "category");
        }

        public void a(long j5) {
        }
    }
}
