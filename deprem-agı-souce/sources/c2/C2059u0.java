package C2;

import S1.k;
import Y1.C2257a;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2291k;
import com.uptodown.R;
import com.uptodown.workers.DownloadWorker;
import java.util.ArrayList;
import k2.C2615z;
import kotlin.jvm.internal.t;
import l2.C2643C;
import l2.C2655d;
import l2.C2657f;
import l2.C2668q;
import t3.s;
import z2.C2940B;

/* renamed from: C2.u0  reason: case insensitive filesystem */
public final class C2059u0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2615z f17891a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f17892b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17893c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f17894d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f17895e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f17896f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f17897g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f17898h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f17899i;

    /* renamed from: j  reason: collision with root package name */
    private final float f17900j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private final float f17901k = 0.4f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2059u0(View view, C2615z zVar) {
        super(view);
        t.e(view, "itemView");
        this.f17891a = zVar;
        View findViewById = view.findViewById(R.id.tv_version_old_version_item);
        t.d(findViewById, "findViewById(...)");
        this.f17892b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_date_old_version_item);
        t.d(findViewById2, "findViewById(...)");
        this.f17893c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_type_old_version_item);
        t.d(findViewById3, "findViewById(...)");
        this.f17894d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_min_sdk_old_version_item);
        t.d(findViewById4, "findViewById(...)");
        this.f17895e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.iv_download_old_version_item);
        t.d(findViewById5, "findViewById(...)");
        this.f17896f = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.pb_progress_old_version);
        t.d(findViewById6, "findViewById(...)");
        this.f17897g = (ProgressBar) findViewById6;
        View findViewById7 = view.findViewById(R.id.rl_download_old_version_item);
        t.d(findViewById7, "findViewById(...)");
        this.f17898h = (RelativeLayout) findViewById7;
        View findViewById8 = view.findViewById(R.id.iv_virustotal_report);
        t.d(findViewById8, "findViewById(...)");
        this.f17899i = (ImageView) findViewById8;
        this.f17898h.setOnClickListener(new C2048q0(this));
        this.f17899i.setOnClickListener(new C2050r0(this));
        TextView textView = this.f17892b;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        this.f17893c.setTypeface(aVar.x());
        this.f17894d.setTypeface(aVar.w());
        this.f17895e.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void e(C2059u0 u0Var, View view) {
        int bindingAdapterPosition;
        if (u0Var.f17891a != null && (bindingAdapterPosition = u0Var.getBindingAdapterPosition()) != -1) {
            u0Var.f17891a.c(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void f(C2059u0 u0Var, View view) {
        int bindingAdapterPosition;
        if (u0Var.f17891a != null && (bindingAdapterPosition = u0Var.getBindingAdapterPosition()) != -1) {
            u0Var.f17891a.b(bindingAdapterPosition);
        }
    }

    private final void i() {
        this.f17896f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_vector_cross));
        this.f17898h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_ripple_bg_card));
        this.f17896f.setContentDescription(this.itemView.getContext().getString(R.string.option_button_cancel));
    }

    private final void j() {
        if (this.f17897g.getVisibility() == 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f17901k, this.f17900j});
            ofFloat.setStartDelay(200);
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new C2056t0(this));
            t.b(ofFloat);
            ofFloat.addListener(new a(this));
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    public static final void k(C2059u0 u0Var, ValueAnimator valueAnimator) {
        t.e(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        t.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        u0Var.f17894d.setScaleX(floatValue);
        u0Var.f17894d.setScaleY(floatValue);
        int i5 = (int) (((float) 10) * (((float) 1) - floatValue));
        u0Var.f17894d.setPadding(i5, i5, i5, i5);
    }

    private final void l() {
        if (this.f17897g.getVisibility() == 8) {
            this.f17897g.setVisibility(0);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f17900j, this.f17901k});
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new C2053s0(this));
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    public static final void m(C2059u0 u0Var, ValueAnimator valueAnimator) {
        t.e(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        t.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        u0Var.f17894d.setScaleX(floatValue);
        u0Var.f17894d.setScaleY(floatValue);
        int i5 = (int) (((float) 10) * (((float) 1) - floatValue));
        u0Var.f17894d.setPadding(i5, i5, i5, i5);
    }

    private final void n() {
        this.f17896f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_action_install));
        this.f17898h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ripple_install_button));
        this.f17896f.setContentDescription(this.itemView.getContext().getString(R.string.action_update));
    }

    public final void h(C2657f fVar, C2655d dVar, int i5) {
        boolean z4;
        boolean z5;
        int i6 = i5;
        C2657f fVar2 = fVar;
        t.e(fVar2, "appInfo");
        C2940B.a aVar = C2940B.f26458v;
        Context context = this.itemView.getContext();
        t.d(context, "getContext(...)");
        C2940B a5 = aVar.a(context);
        a5.a();
        String S4 = fVar2.S();
        t.b(S4);
        ArrayList Q4 = fVar2.Q();
        t.b(Q4);
        C2668q k02 = a5.k0(S4, ((C2643C) Q4.get(i6)).h());
        if (k02 == null || !DownloadWorker.f21359d.m(k02)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (k02 == null || !k02.M()) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (!z4 && !z5) {
            this.f17897g.setVisibility(8);
            this.f17894d.setScaleX(this.f17900j);
            this.f17894d.setScaleY(this.f17900j);
            this.f17894d.setPadding(10, 10, 10, 10);
        }
        ArrayList Q5 = fVar2.Q();
        t.b(Q5);
        String c5 = ((C2643C) Q5.get(i6)).c();
        TextView textView = this.f17894d;
        ArrayList Q6 = fVar2.Q();
        t.b(Q6);
        textView.setText(((C2643C) Q6.get(i6)).c());
        String str = null;
        if (s.F(c5, "xapk", false, 2, (Object) null)) {
            this.f17894d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_old_version_xapk_type));
        } else {
            this.f17894d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_old_version_apk_type));
        }
        TextView textView2 = this.f17892b;
        ArrayList Q7 = fVar2.Q();
        t.b(Q7);
        textView2.setText(((C2643C) Q7.get(i6)).i());
        if (dVar != null) {
            long A4 = dVar.A();
            ArrayList Q8 = fVar2.Q();
            t.b(Q8);
            if (A4 == ((C2643C) Q8.get(i6)).h()) {
                this.f17898h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ripple_install_button));
                this.f17896f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_action_install));
                this.f17896f.setContentDescription(this.itemView.getContext().getString(R.string.option_button_install));
                this.f17895e.setVisibility(0);
                TextView textView3 = this.f17895e;
                ArrayList Q9 = fVar2.Q();
                t.b(Q9);
                textView3.setText(((C2643C) Q9.get(i6)).e());
                this.f17893c.setVisibility(0);
                TextView textView4 = this.f17893c;
                ArrayList Q10 = fVar2.Q();
                t.b(Q10);
                textView4.setText(((C2643C) Q10.get(i6)).d());
                j();
                a5.m();
            }
        }
        if (z4) {
            i();
            l();
            t.b(k02);
            if (k02.x() > 0) {
                this.f17897g.setIndeterminate(false);
                this.f17897g.setProgress(k02.x());
            } else {
                this.f17897g.setIndeterminate(true);
            }
            TextView textView5 = this.f17893c;
            Context context2 = this.itemView.getContext();
            Integer valueOf = Integer.valueOf(k02.x());
            C2291k kVar = new C2291k();
            long z6 = k02.z();
            Context context3 = this.itemView.getContext();
            t.d(context3, "getContext(...)");
            textView5.setText(context2.getString(R.string.percent_of_total_size, new Object[]{valueOf, kVar.d(z6, context3)}));
            this.f17895e.setText(this.itemView.getContext().getString(R.string.verified_by_uptodown));
            this.f17895e.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_myappsupdates_dialog_vt_report), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f17895e.setCompoundDrawablePadding((int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_s));
        } else if (k02 == null || k02.x() != 0) {
            TextView textView6 = this.f17893c;
            ArrayList Q11 = fVar2.Q();
            t.b(Q11);
            textView6.setText(((C2643C) Q11.get(i6)).d());
            TextView textView7 = this.f17895e;
            ArrayList Q12 = fVar2.Q();
            t.b(Q12);
            textView7.setText(((C2643C) Q12.get(i6)).e());
            this.f17895e.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f17895e.setCompoundDrawablePadding(0);
            j();
            C2257a i7 = k.f32g.i();
            if (i7 != null) {
                str = i7.b();
            }
            if (s.E(str, fVar2.S(), true) && i7 != null) {
                long e5 = i7.e();
                ArrayList Q13 = fVar2.Q();
                t.b(Q13);
                if (e5 == ((C2643C) Q13.get(i6)).h()) {
                    l();
                    this.f17897g.setIndeterminate(true);
                    this.f17898h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_download_button_desactivated));
                    this.f17896f.setVisibility(4);
                    this.f17898h.setClickable(false);
                }
            }
            this.f17897g.setIndeterminate(false);
            this.f17897g.setVisibility(8);
            this.f17893c.setVisibility(0);
            this.f17895e.setVisibility(0);
            if (k02 == null || !k02.f()) {
                this.f17896f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_action_download));
                this.f17898h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ripple_open_button));
                this.f17896f.setContentDescription(this.itemView.getContext().getString(R.string.updates_button_download_app));
            } else if (dVar == null) {
                this.f17896f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_action_install));
                this.f17898h.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ripple_install_button));
                this.f17896f.setContentDescription(this.itemView.getContext().getString(R.string.option_button_install));
            } else {
                n();
            }
        } else {
            l();
            i();
            this.f17897g.setIndeterminate(true);
            TextView textView8 = this.f17893c;
            ArrayList Q14 = fVar2.Q();
            t.b(Q14);
            textView8.setText(((C2643C) Q14.get(i6)).d());
            TextView textView9 = this.f17895e;
            ArrayList Q15 = fVar2.Q();
            t.b(Q15);
            textView9.setText(((C2643C) Q15.get(i6)).e());
            this.f17895e.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f17895e.setCompoundDrawablePadding(0);
        }
        a5.m();
    }

    /* renamed from: C2.u0$a */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2059u0 f17902a;

        public a(C2059u0 u0Var) {
            this.f17902a = u0Var;
        }

        public void onAnimationEnd(Animator animator) {
            this.f17902a.f17897g.setVisibility(8);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }
}
