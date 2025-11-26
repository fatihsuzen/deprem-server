package R1;

import B2.s;
import C2.C2029k;
import D2.n;
import S1.k;
import android.content.Context;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import h2.N0;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2589F;
import kotlin.jvm.internal.t;
import l2.O;
import l2.V;

public final class a0 extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4128a;

    /* renamed from: b  reason: collision with root package name */
    private C2589F f4129b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f4130c;

    public final class a extends C2029k {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final N0 f4131b;

        /* renamed from: c  reason: collision with root package name */
        private C2589F f4132c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a0 f4133d;

        /* renamed from: R1.a0$a$a  reason: collision with other inner class name */
        public static final class C0057a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f4134a;

            C0057a(a aVar) {
                this.f4134a = aVar;
            }

            public boolean onPreDraw() {
                this.f4134a.f4131b.f22541m.getViewTreeObserver().removeOnPreDrawListener(this);
                TextView textView = this.f4134a.f4131b.f22541m;
                t.d(textView, "tvBodyReview");
                if (!s.a(textView)) {
                    return true;
                }
                this.f4134a.f4131b.f22545q.setVisibility(0);
                this.f4134a.f4131b.f22545q.setTypeface(k.f32g.w());
                return true;
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(R1.a0 r3, h2.N0 r4, k2.C2589F r5) {
            /*
                r2 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.t.e(r4, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.t.e(r5, r0)
                r2.f4133d = r3
                android.widget.RelativeLayout r3 = r4.getRoot()
                java.lang.String r0 = "getRoot(...)"
                kotlin.jvm.internal.t.d(r3, r0)
                android.widget.RelativeLayout r0 = r4.getRoot()
                android.content.Context r0 = r0.getContext()
                java.lang.String r1 = "getContext(...)"
                kotlin.jvm.internal.t.d(r0, r1)
                r2.<init>(r3, r0)
                r2.f4131b = r4
                r2.f4132c = r5
                com.uptodown.util.views.UsernameTextView r3 = r4.f22540l
                S1.k$a r5 = S1.k.f32g
                android.graphics.Typeface r0 = r5.w()
                r3.setTypeface(r0)
                android.widget.TextView r3 = r4.f22542n
                android.graphics.Typeface r0 = r5.x()
                r3.setTypeface(r0)
                android.widget.TextView r3 = r4.f22541m
                android.graphics.Typeface r0 = r5.x()
                r3.setTypeface(r0)
                android.widget.TextView r3 = r4.f22544p
                android.graphics.Typeface r0 = r5.x()
                r3.setTypeface(r0)
                android.widget.TextView r3 = r4.f22543o
                android.graphics.Typeface r4 = r5.x()
                r3.setTypeface(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.a0.a.<init>(R1.a0, h2.N0, k2.F):void");
        }

        /* access modifiers changed from: private */
        public static final void s(a aVar, int i5, View view) {
            aVar.f4132c.d(i5);
        }

        /* access modifiers changed from: private */
        public static final void t(a aVar, int i5, View view) {
            aVar.f4132c.d(i5);
        }

        /* access modifiers changed from: private */
        public static final void u(a aVar, int i5, View view) {
            aVar.f4132c.e(i5);
        }

        /* access modifiers changed from: private */
        public static final void v(a aVar, View view) {
            t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            C2589F f5 = aVar.f4132c;
            Object tag = view.getTag();
            t.c(tag, "null cannot be cast to non-null type kotlin.Int");
            f5.e(((Integer) tag).intValue());
        }

        /* access modifiers changed from: private */
        public static final void w(a aVar, O o5, View view) {
            t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            Context context = aVar.itemView.getContext();
            t.d(context, "getContext(...)");
            n nVar = new n(context);
            ImageView imageView = aVar.f4131b.f22531c;
            t.d(imageView, "ivLikesCounterReview");
            nVar.n(imageView);
            if (!O.f24814p.d(o5.g())) {
                C2589F f5 = aVar.f4132c;
                Object tag = view.getTag();
                t.c(tag, "null cannot be cast to non-null type kotlin.Int");
                f5.b(((Integer) tag).intValue());
                aVar.f4131b.f22543o.setText(String.valueOf(o5.h() + 1));
            }
        }

        public final void r(O o5, int i5) {
            CharSequence charSequence;
            t.e(o5, "item");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout b5 = this.f4131b.getRoot();
            Context context = this.itemView.getContext();
            t.d(context, "getContext(...)");
            b5.setLayoutParams(b(layoutParams, context, i5, this.f4133d.f4130c));
            this.f4131b.f22532d.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_on));
            this.f4131b.f22533e.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_off));
            this.f4131b.f22534f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_off));
            this.f4131b.f22535g.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_off));
            this.f4131b.f22536h.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_off));
            if (o5.i() >= 2) {
                this.f4131b.f22533e.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_on));
            }
            if (o5.i() >= 3) {
                this.f4131b.f22534f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_on));
            }
            if (o5.i() >= 4) {
                this.f4131b.f22535g.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_on));
            }
            if (o5.i() == 5) {
                this.f4131b.f22536h.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_on));
            }
            String e5 = o5.e();
            if (e5 == null || e5.length() == 0) {
                w j5 = com.squareup.picasso.s.h().j(R.drawable.vector_user_default);
                UptodownApp.a aVar = UptodownApp.f13477F;
                Context context2 = this.itemView.getContext();
                t.d(context2, "getContext(...)");
                j5.n(aVar.i0(context2)).i(this.f4131b.f22530b);
            } else {
                w l5 = com.squareup.picasso.s.h().l(V.f24870q.d(o5.e()));
                UptodownApp.a aVar2 = UptodownApp.f13477F;
                Context context3 = this.itemView.getContext();
                t.d(context3, "getContext(...)");
                l5.n(aVar2.g0(context3)).i(this.f4131b.f22530b);
            }
            String c5 = o5.c();
            if (!(c5 == null || c5.length() == 0)) {
                this.f4131b.f22540l.setText(o5.c());
            }
            this.f4131b.f22540l.setOnClickListener(new V(this, i5));
            this.f4131b.f22530b.setOnClickListener(new W(this, i5));
            if (O.f24814p.d(o5.g())) {
                this.f4131b.f22531c.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_heart_red));
            } else {
                this.f4131b.f22531c.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_heart));
            }
            if (o5.l() != null) {
                this.f4131b.f22542n.setText(o5.l());
            }
            Spanned k5 = o5.k();
            if (k5 == null || k5.length() == 0) {
                this.f4131b.f22545q.setVisibility(8);
                this.f4131b.f22541m.setVisibility(4);
                this.f4131b.f22538j.setVisibility(4);
                this.f4131b.f22537i.setVisibility(4);
                return;
            }
            TextView textView = this.f4131b.f22541m;
            Spanned k6 = o5.k();
            if (k6 != null) {
                charSequence = t3.s.W0(k6);
            } else {
                charSequence = null;
            }
            textView.setText(charSequence);
            this.f4131b.f22541m.setVisibility(0);
            this.f4131b.f22541m.getViewTreeObserver().addOnPreDrawListener(new C0057a(this));
            this.f4131b.f22545q.setOnClickListener(new X(this, i5));
            this.f4131b.f22538j.setTag(Integer.valueOf(i5));
            this.f4131b.f22538j.setOnClickListener(new Y(this));
            if (o5.a() > 0) {
                this.f4131b.f22544p.setText(String.valueOf(o5.a()));
            } else {
                this.f4131b.f22544p.setText(this.itemView.getContext().getString(R.string.reply));
            }
            this.f4131b.f22543o.setText(String.valueOf(o5.h()));
            this.f4131b.f22537i.setTag(Integer.valueOf(i5));
            this.f4131b.f22537i.setOnClickListener(new Z(this, o5));
            this.f4131b.f22538j.setVisibility(0);
            this.f4131b.f22537i.setVisibility(0);
        }
    }

    public a0(ArrayList arrayList, C2589F f5) {
        t.e(arrayList, "reviews");
        t.e(f5, "listener");
        this.f4128a = arrayList;
        this.f4129b = f5;
        this.f4130c = arrayList.size() - 1;
    }

    /* renamed from: b */
    public void onBindViewHolder(a aVar, int i5) {
        t.e(aVar, "holder");
        Object obj = this.f4128a.get(i5);
        t.d(obj, "get(...)");
        aVar.r((O) obj, i5);
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        N0 c5 = N0.c(LayoutInflater.from(viewGroup.getContext()));
        t.d(c5, "inflate(...)");
        return new a(this, c5, this.f4129b);
    }

    public final void d(O o5) {
        t.e(o5, "review");
        Iterator it = this.f4128a.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                i5 = -1;
                break;
            }
            int i6 = i5 + 1;
            if (((O) it.next()).g() == o5.g()) {
                break;
            }
            i5 = i6;
        }
        this.f4128a.set(i5, o5);
        notifyItemChanged(i5);
    }

    public int getItemCount() {
        return this.f4128a.size();
    }
}
