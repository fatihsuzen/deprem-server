package R1;

import C2.C2029k;
import X2.C2250q;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import k2.C2591a;
import k2.C2594d;
import kotlin.jvm.internal.t;
import l2.C2657f;

/* renamed from: R1.k  reason: case insensitive filesystem */
public final class C0980k extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private C2594d f4231a;

    /* renamed from: b  reason: collision with root package name */
    private final C2591a f4232b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f4233c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f4234d;

    /* renamed from: R1.k$a */
    public final class a extends C2029k {

        /* renamed from: b  reason: collision with root package name */
        private C2594d f4235b;

        /* renamed from: c  reason: collision with root package name */
        private final C2591a f4236c;

        /* renamed from: d  reason: collision with root package name */
        private final ImageView f4237d;

        /* renamed from: e  reason: collision with root package name */
        private final ImageView f4238e;

        /* renamed from: f  reason: collision with root package name */
        private final ProgressBar f4239f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f4240g;

        /* renamed from: h  reason: collision with root package name */
        private final TextView f4241h;

        /* renamed from: i  reason: collision with root package name */
        private final TextView f4242i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f4243j;

        /* renamed from: k  reason: collision with root package name */
        private final TextView f4244k;

        /* renamed from: l  reason: collision with root package name */
        private final LinearLayout f4245l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ C0980k f4246m;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(R1.C0980k r4, android.view.View r5, k2.C2594d r6, k2.C2591a r7) {
            /*
                r3 = this;
                java.lang.String r0 = "itemView"
                kotlin.jvm.internal.t.e(r5, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.t.e(r6, r0)
                java.lang.String r0 = "actionsClickListener"
                kotlin.jvm.internal.t.e(r7, r0)
                r3.f4246m = r4
                android.content.Context r4 = r5.getContext()
                java.lang.String r0 = "getContext(...)"
                kotlin.jvm.internal.t.d(r4, r0)
                r3.<init>(r5, r4)
                r3.f4235b = r6
                r3.f4236c = r7
                r4 = 2131362361(0x7f0a0239, float:1.83445E38)
                android.view.View r4 = r5.findViewById(r4)
                android.widget.ImageView r4 = (android.widget.ImageView) r4
                r3.f4237d = r4
                r4 = 2131362414(0x7f0a026e, float:1.8344608E38)
                android.view.View r4 = r5.findViewById(r4)
                android.widget.ImageView r4 = (android.widget.ImageView) r4
                r3.f4238e = r4
                r4 = 2131363112(0x7f0a0528, float:1.8346024E38)
                android.view.View r4 = r5.findViewById(r4)
                java.lang.String r6 = "findViewById(...)"
                kotlin.jvm.internal.t.d(r4, r6)
                android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
                r3.f4239f = r4
                r4 = 2131364086(0x7f0a08f6, float:1.8348E38)
                android.view.View r4 = r5.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                r3.f4240g = r4
                r7 = 2131363831(0x7f0a07f7, float:1.8347482E38)
                android.view.View r7 = r5.findViewById(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                r3.f4241h = r7
                r0 = 2131364370(0x7f0a0a12, float:1.8348575E38)
                android.view.View r0 = r5.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r3.f4242i = r0
                r0 = 2131364231(0x7f0a0987, float:1.8348293E38)
                android.view.View r0 = r5.findViewById(r0)
                kotlin.jvm.internal.t.d(r0, r6)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r3.f4243j = r0
                r1 = 2131364561(0x7f0a0ad1, float:1.8348963E38)
                android.view.View r1 = r5.findViewById(r1)
                kotlin.jvm.internal.t.d(r1, r6)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r3.f4244k = r1
                r2 = 2131362691(0x7f0a0383, float:1.834517E38)
                android.view.View r5 = r5.findViewById(r2)
                kotlin.jvm.internal.t.d(r5, r6)
                android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
                r3.f4245l = r5
                S1.k$a r5 = S1.k.f32g
                android.graphics.Typeface r6 = r5.w()
                r4.setTypeface(r6)
                android.graphics.Typeface r4 = r5.x()
                r7.setTypeface(r4)
                android.graphics.Typeface r4 = r5.x()
                r0.setTypeface(r4)
                android.graphics.Typeface r4 = r5.x()
                r1.setTypeface(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.C0980k.a.<init>(R1.k, android.view.View, k2.d, k2.a):void");
        }

        /* access modifiers changed from: private */
        public static final boolean n(a aVar, C2657f fVar, int i5, View view) {
            aVar.f4236c.a(fVar, i5);
            return true;
        }

        public final void m(C2657f fVar, int i5, int i6) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            View view = this.itemView;
            Context context = view.getContext();
            t.d(context, "getContext(...)");
            view.setLayoutParams(b(layoutParams, context, i5, 20));
            String z4 = fVar.z();
            if (z4 == null || z4.length() == 0) {
                this.f4237d.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_placeholder));
            } else {
                w l5 = s.h().l(fVar.D());
                UptodownApp.a aVar = UptodownApp.f13477F;
                Context context2 = this.itemView.getContext();
                t.d(context2, "getContext(...)");
                l5.n(aVar.f0(context2)).a().f().l(R.drawable.shape_bg_placeholder).i(this.f4237d);
            }
            View view2 = this.itemView;
            t.d(view2, "itemView");
            c(view2, this.f4235b, fVar);
            this.itemView.setOnLongClickListener(new C0979j(this, fVar, i6));
            TextView textView = this.f4240g;
            t.d(textView, "tvName");
            TextView textView2 = this.f4241h;
            t.d(textView2, "tvDesc");
            i(fVar, textView, textView2);
            ImageView imageView = this.f4238e;
            t.d(imageView, "ivIcon");
            h(imageView, fVar.H());
            ProgressBar progressBar = this.f4239f;
            ImageView imageView2 = this.f4238e;
            t.d(imageView2, "ivIcon");
            TextView textView3 = this.f4241h;
            t.d(textView3, "tvDesc");
            e(fVar, progressBar, imageView2, textView3, this.f4243j, this.f4242i, this.f4245l);
        }
    }

    /* renamed from: R1.k$b */
    public final class b extends C2029k {

        /* renamed from: b  reason: collision with root package name */
        private C2594d f4247b;

        /* renamed from: c  reason: collision with root package name */
        private final C2591a f4248c;

        /* renamed from: d  reason: collision with root package name */
        private final ImageView f4249d;

        /* renamed from: e  reason: collision with root package name */
        private final ProgressBar f4250e;

        /* renamed from: f  reason: collision with root package name */
        private final ImageView f4251f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f4252g;

        /* renamed from: h  reason: collision with root package name */
        private final TextView f4253h;

        /* renamed from: i  reason: collision with root package name */
        private final TextView f4254i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f4255j;

        /* renamed from: k  reason: collision with root package name */
        private final TextView f4256k;

        /* renamed from: l  reason: collision with root package name */
        private final LinearLayout f4257l;

        /* renamed from: m  reason: collision with root package name */
        private final TextView f4258m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ C0980k f4259n;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b(R1.C0980k r5, android.view.View r6, k2.C2594d r7, k2.C2591a r8) {
            /*
                r4 = this;
                java.lang.String r0 = "itemView"
                kotlin.jvm.internal.t.e(r6, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.t.e(r7, r0)
                java.lang.String r0 = "actionsClickListener"
                kotlin.jvm.internal.t.e(r8, r0)
                r4.f4259n = r5
                android.content.Context r5 = r6.getContext()
                java.lang.String r0 = "getContext(...)"
                kotlin.jvm.internal.t.d(r5, r0)
                r4.<init>(r6, r5)
                r4.f4247b = r7
                r4.f4248c = r8
                r5 = 2131362363(0x7f0a023b, float:1.8344504E38)
                android.view.View r5 = r6.findViewById(r5)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                r4.f4249d = r5
                r5 = 2131363113(0x7f0a0529, float:1.8346026E38)
                android.view.View r5 = r6.findViewById(r5)
                java.lang.String r7 = "findViewById(...)"
                kotlin.jvm.internal.t.d(r5, r7)
                android.widget.ProgressBar r5 = (android.widget.ProgressBar) r5
                r4.f4250e = r5
                r5 = 2131362416(0x7f0a0270, float:1.8344612E38)
                android.view.View r5 = r6.findViewById(r5)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                r4.f4251f = r5
                r5 = 2131364089(0x7f0a08f9, float:1.8348005E38)
                android.view.View r5 = r6.findViewById(r5)
                android.widget.TextView r5 = (android.widget.TextView) r5
                r4.f4252g = r5
                r8 = 2131364150(0x7f0a0936, float:1.8348129E38)
                android.view.View r8 = r6.findViewById(r8)
                android.widget.TextView r8 = (android.widget.TextView) r8
                r4.f4253h = r8
                r0 = 2131363834(0x7f0a07fa, float:1.8347488E38)
                android.view.View r0 = r6.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r4.f4254i = r0
                r1 = 2131364232(0x7f0a0988, float:1.8348295E38)
                android.view.View r1 = r6.findViewById(r1)
                kotlin.jvm.internal.t.d(r1, r7)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r4.f4255j = r1
                r2 = 2131364562(0x7f0a0ad2, float:1.8348965E38)
                android.view.View r2 = r6.findViewById(r2)
                kotlin.jvm.internal.t.d(r2, r7)
                android.widget.TextView r2 = (android.widget.TextView) r2
                r4.f4256k = r2
                r3 = 2131362692(0x7f0a0384, float:1.8345172E38)
                android.view.View r3 = r6.findViewById(r3)
                kotlin.jvm.internal.t.d(r3, r7)
                android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
                r4.f4257l = r3
                r7 = 2131364372(0x7f0a0a14, float:1.834858E38)
                android.view.View r6 = r6.findViewById(r7)
                android.widget.TextView r6 = (android.widget.TextView) r6
                r4.f4258m = r6
                S1.k$a r6 = S1.k.f32g
                android.graphics.Typeface r7 = r6.w()
                r5.setTypeface(r7)
                android.graphics.Typeface r5 = r6.w()
                r8.setTypeface(r5)
                android.graphics.Typeface r5 = r6.x()
                r0.setTypeface(r5)
                android.graphics.Typeface r5 = r6.x()
                r1.setTypeface(r5)
                android.graphics.Typeface r5 = r6.x()
                r2.setTypeface(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.C0980k.b.<init>(R1.k, android.view.View, k2.d, k2.a):void");
        }

        /* access modifiers changed from: private */
        public static final boolean n(b bVar, C2657f fVar, int i5, View view) {
            bVar.f4248c.a(fVar, i5);
            return true;
        }

        public final void m(C2657f fVar, int i5, int i6, boolean z4) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            int dimension = (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (z4) {
                layoutParams.setMargins(dimension, 0, dimension, dimension);
            } else {
                layoutParams.setMargins(dimension, 0, 0, dimension);
            }
            ViewGroup.LayoutParams layoutParams2 = this.f4249d.getLayoutParams();
            t.c(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (i5 >= 10) {
                marginLayoutParams.setMarginStart((int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_xl));
            } else {
                marginLayoutParams.setMarginStart(0);
            }
            this.f4249d.setLayoutParams(marginLayoutParams);
            this.itemView.setLayoutParams(layoutParams);
            this.f4253h.setText(String.valueOf(i5));
            String z5 = fVar.z();
            if (z5 == null || z5.length() == 0) {
                this.f4249d.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_placeholder));
            } else {
                w l5 = s.h().l(fVar.D());
                UptodownApp.a aVar = UptodownApp.f13477F;
                Context context = this.itemView.getContext();
                t.d(context, "getContext(...)");
                l5.n(aVar.f0(context)).a().f().l(R.drawable.shape_bg_placeholder).i(this.f4249d);
            }
            View view = this.itemView;
            t.d(view, "itemView");
            c(view, this.f4247b, fVar);
            this.itemView.setOnLongClickListener(new C0981l(this, fVar, i6));
            TextView textView = this.f4252g;
            t.d(textView, "tvName");
            TextView textView2 = this.f4254i;
            t.d(textView2, "tvDesc");
            i(fVar, textView, textView2);
            ImageView imageView = this.f4251f;
            t.d(imageView, "ivIcon");
            h(imageView, fVar.H());
            ProgressBar progressBar = this.f4250e;
            ImageView imageView2 = this.f4251f;
            t.d(imageView2, "ivIcon");
            TextView textView3 = this.f4254i;
            t.d(textView3, "tvDesc");
            e(fVar, progressBar, imageView2, textView3, this.f4255j, this.f4258m, this.f4257l);
        }
    }

    public C0980k(C2594d dVar, C2591a aVar) {
        t.e(dVar, "listener");
        t.e(aVar, "actionsClickListener");
        this.f4231a = dVar;
        this.f4232b = aVar;
    }

    public final ArrayList a() {
        return this.f4233c;
    }

    public final void b(ArrayList arrayList, boolean z4) {
        t.e(arrayList, "appList");
        this.f4234d = z4;
        this.f4233c = arrayList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f4233c.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "holder");
        if (viewHolder instanceof a) {
            Object obj = this.f4233c.get(i5);
            t.d(obj, "get(...)");
            ((a) viewHolder).m((C2657f) obj, i5 + 1, i5);
        } else if (viewHolder instanceof b) {
            int i6 = i5 + 1;
            if (t.a(this.f4233c.get(i5), C2250q.X(this.f4233c))) {
                Object obj2 = this.f4233c.get(i5);
                t.d(obj2, "get(...)");
                ((b) viewHolder).m((C2657f) obj2, i6, i5, true);
                return;
            }
            Object obj3 = this.f4233c.get(i5);
            t.d(obj3, "get(...)");
            ((b) viewHolder).m((C2657f) obj3, i6, i5, false);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        if (this.f4234d) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_card_top_featured_item, viewGroup, false);
            t.b(inflate);
            return new b(this, inflate, this.f4231a, this.f4232b);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_card_featured_item, viewGroup, false);
        t.b(inflate2);
        return new a(this, inflate2, this.f4231a, this.f4232b);
    }
}
