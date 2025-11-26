package R1;

import B2.h;
import C2.C2029k;
import D2.h;
import H1.d;
import H1.e;
import J1.a;
import S1.k;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import i2.V1;
import java.util.ArrayList;
import k2.C2591a;
import k2.C2611v;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.b0;

public final class e0 extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private C2611v f4158a;

    /* renamed from: b  reason: collision with root package name */
    private final C2591a f4159b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4160c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f4161d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f4162e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private boolean f4163f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public YouTubePlayerView f4164g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public e f4165h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f4166i = "";
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f4167j;

    /* renamed from: k  reason: collision with root package name */
    private int f4168k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4169l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4170m = true;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public h f4171n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f4172o = 8;

    public final class a extends C2029k {

        /* renamed from: b  reason: collision with root package name */
        private C2611v f4173b;

        /* renamed from: c  reason: collision with root package name */
        private final C2591a f4174c;

        /* renamed from: d  reason: collision with root package name */
        private Context f4175d;

        /* renamed from: e  reason: collision with root package name */
        private String f4176e;

        /* renamed from: f  reason: collision with root package name */
        private final ImageView f4177f;

        /* renamed from: g  reason: collision with root package name */
        private final RelativeLayout f4178g;

        /* renamed from: h  reason: collision with root package name */
        private final ProgressBar f4179h;

        /* renamed from: i  reason: collision with root package name */
        private final ImageView f4180i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f4181j;

        /* renamed from: k  reason: collision with root package name */
        private final TextView f4182k;

        /* renamed from: l  reason: collision with root package name */
        private final TextView f4183l;

        /* renamed from: m  reason: collision with root package name */
        private final TextView f4184m;

        /* renamed from: n  reason: collision with root package name */
        private final TextView f4185n;

        /* renamed from: o  reason: collision with root package name */
        private final LinearLayout f4186o;

        /* renamed from: p  reason: collision with root package name */
        private final CardView f4187p;

        /* renamed from: q  reason: collision with root package name */
        private final View f4188q;

        /* renamed from: r  reason: collision with root package name */
        private final int f4189r = UptodownApp.f13477F.F();

        /* renamed from: s  reason: collision with root package name */
        final /* synthetic */ e0 f4190s;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e0 e0Var, View view, C2611v vVar, C2591a aVar, Context context, String str) {
            super(view, context);
            t.e(view, "itemView");
            t.e(vVar, "listener");
            t.e(aVar, "actionsClickListener");
            t.e(context, "context");
            t.e(str, "fragmentName");
            this.f4190s = e0Var;
            this.f4173b = vVar;
            this.f4174c = aVar;
            this.f4175d = context;
            this.f4176e = str;
            View findViewById = view.findViewById(R.id.iv_image_video_featured_item);
            t.d(findViewById, "findViewById(...)");
            this.f4177f = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.rl_video_card_info);
            t.d(findViewById2, "findViewById(...)");
            this.f4178g = (RelativeLayout) findViewById2;
            View findViewById3 = view.findViewById(R.id.pb_progress_video_featured_item);
            t.d(findViewById3, "findViewById(...)");
            this.f4179h = (ProgressBar) findViewById3;
            View findViewById4 = view.findViewById(R.id.iv_logo_video_featured_item);
            t.d(findViewById4, "findViewById(...)");
            this.f4180i = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.tv_name_video_featured_item);
            t.d(findViewById5, "findViewById(...)");
            TextView textView = (TextView) findViewById5;
            this.f4181j = textView;
            View findViewById6 = view.findViewById(R.id.tv_desc_video_featured_item);
            t.d(findViewById6, "findViewById(...)");
            TextView textView2 = (TextView) findViewById6;
            this.f4182k = textView2;
            View findViewById7 = view.findViewById(R.id.tv_status_video_featured_item);
            t.d(findViewById7, "findViewById(...)");
            this.f4183l = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.tv_progress_video_featured_item);
            t.d(findViewById8, "findViewById(...)");
            TextView textView3 = (TextView) findViewById8;
            this.f4184m = textView3;
            View findViewById9 = view.findViewById(R.id.tv_verified_video_featured_item);
            t.d(findViewById9, "findViewById(...)");
            TextView textView4 = (TextView) findViewById9;
            this.f4185n = textView4;
            View findViewById10 = view.findViewById(R.id.ll_progress_video_featured_item);
            t.d(findViewById10, "findViewById(...)");
            this.f4186o = (LinearLayout) findViewById10;
            View findViewById11 = view.findViewById(R.id.cv_youtube_player_view);
            t.d(findViewById11, "findViewById(...)");
            this.f4187p = (CardView) findViewById11;
            View findViewById12 = view.findViewById(R.id.v_player_controller);
            t.d(findViewById12, "findViewById(...)");
            this.f4188q = findViewById12;
            k.a aVar2 = k.f32g;
            textView.setTypeface(aVar2.w());
            textView2.setTypeface(aVar2.x());
            textView3.setTypeface(aVar2.x());
            textView4.setTypeface(aVar2.x());
        }

        /* access modifiers changed from: private */
        public static final boolean p(a aVar, C2657f fVar, int i5, View view) {
            aVar.f4174c.a(fVar, i5);
            return true;
        }

        /* access modifiers changed from: private */
        public static final void r(e0 e0Var, View view) {
            if (e0Var.r()) {
                e f5 = e0Var.f4165h;
                if (f5 != null) {
                    f5.pause();
                    return;
                }
                return;
            }
            e f6 = e0Var.f4165h;
            if (f6 != null) {
                f6.play();
            }
        }

        /* access modifiers changed from: private */
        public static final boolean s(a aVar, C2657f fVar, int i5, View view) {
            aVar.f4174c.a(fVar, i5);
            return true;
        }

        private final void t(C2657f fVar) {
            i(fVar, this.f4181j, this.f4182k);
            c(this.f4178g, this.f4173b, fVar);
            u(this.f4177f, fVar);
            h(this.f4180i, fVar.H());
        }

        private final void u(ImageView imageView, C2657f fVar) {
            D2.h hVar = new D2.h((int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2633k) null);
            String z4 = fVar.z();
            if (z4 == null || z4.length() == 0) {
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_bg_placeholder));
                return;
            }
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.x() > 0) {
                imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, aVar.x()));
                s.h().l(fVar.x()).m(aVar.y(), aVar.x()).n(hVar).i(imageView);
                return;
            }
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            s.h().l(fVar.x()).f().n(hVar).i(imageView);
        }

        public final void o(C2657f fVar, int i5) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            this.f4187p.setVisibility(8);
            this.f4188q.setVisibility(8);
            this.f4177f.setVisibility(0);
            t(fVar);
            C2657f fVar2 = fVar;
            e(fVar2, this.f4179h, this.f4180i, this.f4182k, this.f4184m, this.f4183l, this.f4186o);
            this.f4178g.setOnLongClickListener(new d0(this, fVar2, i5));
            this.itemView.setLayoutParams(b(new RelativeLayout.LayoutParams(this.f4189r, -1), this.f4175d, i5, this.f4190s.f4172o));
            c(this.f4177f, this.f4173b, fVar2);
        }

        public final void q(C2657f fVar, int i5) {
            ArrayList D02;
            ImageView l5;
            Float valueOf = Float.valueOf(0.0f);
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (this.f4190s.f4164g != null) {
                YouTubePlayerView g5 = this.f4190s.f4164g;
                t.b(g5);
                if (g5.getParent() != null) {
                    YouTubePlayerView g6 = this.f4190s.f4164g;
                    t.b(g6);
                    ViewParent parent = g6.getParent();
                    t.c(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(this.f4190s.f4164g);
                }
                this.f4187p.addView(this.f4190s.f4164g);
                this.f4187p.setVisibility(0);
                this.f4188q.setVisibility(0);
                this.f4177f.setVisibility(8);
                B2.h b5 = this.f4190s.f4171n;
                if (!(b5 == null || (l5 = b5.l()) == null)) {
                    l5.setImageDrawable((Drawable) null);
                }
                t(fVar);
                C2657f fVar2 = fVar;
                e(fVar2, this.f4179h, this.f4180i, this.f4182k, this.f4184m, this.f4183l, this.f4186o);
                this.f4188q.setOnClickListener(new b0(this.f4190s));
                this.f4178g.setOnLongClickListener(new c0(this, fVar2, i5));
                this.itemView.setLayoutParams(b(new RelativeLayout.LayoutParams(this.f4189r, -1), this.f4175d, i5, this.f4190s.f4172o));
                if (this.f4190s.q() && this.f4190s.f4165h != null && (D02 = fVar2.D0()) != null && !D02.isEmpty()) {
                    ArrayList D03 = fVar2.D0();
                    t.b(D03);
                    if (((b0) D03.get(0)).a() != null) {
                        ArrayList D04 = fVar2.D0();
                        t.b(D04);
                        if (!t.a(((b0) D04.get(0)).a(), this.f4190s.f4167j)) {
                            e0 e0Var = this.f4190s;
                            ArrayList D05 = fVar2.D0();
                            t.b(D05);
                            e0Var.f4167j = ((b0) D05.get(0)).a();
                            e0 e0Var2 = this.f4190s;
                            StringBuilder sb = new StringBuilder();
                            String N4 = fVar2.N();
                            t.b(N4);
                            sb.append(N4);
                            sb.append(this.f4176e);
                            e0Var2.f4166i = sb.toString();
                            if (t.a(this.f4176e, M.b(V1.class).c())) {
                                UptodownApp.f13477F.r0(this.f4190s.f4165h);
                            } else {
                                UptodownApp.f13477F.s0(this.f4190s.f4165h);
                            }
                            UptodownApp.a aVar = UptodownApp.f13477F;
                            if (!aVar.f(this.f4175d) || com.uptodown.activities.preferences.a.f15150a.g(this.f4175d) <= 0) {
                                if (aVar.H().containsKey(this.f4190s.f4166i)) {
                                    e f5 = this.f4190s.f4165h;
                                    t.b(f5);
                                    ArrayList D06 = fVar2.D0();
                                    t.b(D06);
                                    String a5 = ((b0) D06.get(0)).a();
                                    t.b(a5);
                                    Object obj = aVar.H().get(this.f4190s.f4166i);
                                    t.b(obj);
                                    f5.b(a5, ((Number) obj).floatValue());
                                } else {
                                    e f6 = this.f4190s.f4165h;
                                    t.b(f6);
                                    ArrayList D07 = fVar2.D0();
                                    t.b(D07);
                                    String a6 = ((b0) D07.get(0)).a();
                                    t.b(a6);
                                    f6.b(a6, 0.0f);
                                    aVar.H().put(this.f4190s.f4166i, valueOf);
                                }
                                String z4 = fVar2.z();
                                if (z4 != null && z4.length() != 0) {
                                    B2.h b6 = this.f4190s.f4171n;
                                    t.b(b6);
                                    b6.l().setVisibility(0);
                                    B2.h b7 = this.f4190s.f4171n;
                                    t.b(b7);
                                    u(b7.l(), fVar2);
                                    return;
                                }
                                return;
                            }
                            if (aVar.H().containsKey(this.f4190s.f4166i)) {
                                e f7 = this.f4190s.f4165h;
                                t.b(f7);
                                ArrayList D08 = fVar2.D0();
                                t.b(D08);
                                String a7 = ((b0) D08.get(0)).a();
                                t.b(a7);
                                Object obj2 = aVar.H().get(this.f4190s.f4166i);
                                t.b(obj2);
                                f7.d(a7, ((Number) obj2).floatValue());
                            } else {
                                e f8 = this.f4190s.f4165h;
                                t.b(f8);
                                ArrayList D09 = fVar2.D0();
                                t.b(D09);
                                String a8 = ((b0) D09.get(0)).a();
                                t.b(a8);
                                f8.d(a8, 0.0f);
                                aVar.H().put(this.f4190s.f4166i, valueOf);
                            }
                            if (this.f4190s.o()) {
                                e f9 = this.f4190s.f4165h;
                                t.b(f9);
                                f9.play();
                                return;
                            }
                            e f10 = this.f4190s.f4165h;
                            t.b(f10);
                            f10.pause();
                            return;
                        }
                    }
                }
                ArrayList D010 = fVar2.D0();
                if (D010 == null || D010.isEmpty()) {
                    o(fVar2, i5);
                }
                if (this.f4190s.f4165h == null) {
                    this.f4190s.p();
                    return;
                }
                return;
            }
        }
    }

    public static final class b extends I1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e0 f4191a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f4192b;

        b(e0 e0Var, View view) {
            this.f4191a = e0Var;
            this.f4192b = view;
        }

        public void c(e eVar, float f5) {
            t.e(eVar, "youTubePlayer");
            super.c(eVar, f5);
            UptodownApp.f13477F.H().put(this.f4191a.f4166i, Float.valueOf(f5));
        }

        public void d(e eVar) {
            t.e(eVar, "youTubePlayer");
            super.d(eVar);
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.x() == 0) {
                YouTubePlayerView g5 = this.f4191a.f4164g;
                t.b(g5);
                if (g5.getHeight() != 0) {
                    YouTubePlayerView g6 = this.f4191a.f4164g;
                    t.b(g6);
                    aVar.F0(g6.getHeight());
                    YouTubePlayerView g7 = this.f4191a.f4164g;
                    t.b(g7);
                    aVar.G0(g7.getWidth());
                }
            }
            this.f4191a.f4171n = new B2.h(this.f4192b, eVar);
            B2.h b5 = this.f4191a.f4171n;
            t.b(b5);
            eVar.c(b5);
            eVar.e();
            this.f4191a.f4165h = eVar;
            this.f4191a.w(true);
            this.f4191a.notifyItemChanged(0);
        }

        public void e(e eVar, d dVar) {
            t.e(eVar, "youTubePlayer");
            t.e(dVar, MRAIDCommunicatorUtil.KEY_STATE);
            super.e(eVar, dVar);
            d dVar2 = d.BUFFERING;
            if (dVar == dVar2 && this.f4191a.o()) {
                eVar.play();
            }
            if (dVar == dVar2 && t.a(this.f4191a.f4161d, M.b(V1.class).c())) {
                eVar.play();
            }
            if (dVar == d.PAUSED) {
                this.f4191a.y(false);
            }
            if (dVar == d.PLAYING) {
                this.f4191a.y(true);
            }
        }
    }

    public e0(C2611v vVar, C2591a aVar, Context context, String str) {
        t.e(vVar, "listener");
        t.e(aVar, "actionsClickListener");
        t.e(context, "context");
        t.e(str, "fragmentName");
        this.f4158a = vVar;
        this.f4159b = aVar;
        this.f4160c = context;
        this.f4161d = str;
        if (!com.uptodown.activities.preferences.a.f15150a.N(this.f4160c)) {
            try {
                YouTubePlayerView youTubePlayerView = new YouTubePlayerView(this.f4160c);
                youTubePlayerView.setEnableAutomaticInitialization(false);
                this.f4164g = youTubePlayerView;
                p();
            } catch (UnsatisfiedLinkError e5) {
                com.uptodown.activities.preferences.a.f15150a.E0(this.f4160c, true);
                this.f4164g = null;
                e5.printStackTrace();
            } catch (Exception e6) {
                com.uptodown.activities.preferences.a.f15150a.E0(this.f4160c, true);
                this.f4164g = null;
                e6.printStackTrace();
            }
        }
        if (t.a(this.f4161d, M.b(V1.class).c())) {
            this.f4172o = 8;
        } else {
            this.f4172o = 20;
        }
        this.f4170m = UptodownApp.f13477F.f(this.f4160c);
    }

    /* access modifiers changed from: private */
    public final void p() {
        YouTubePlayerView youTubePlayerView = this.f4164g;
        if (youTubePlayerView != null) {
            t.b(youTubePlayerView);
            View d5 = youTubePlayerView.d(R.layout.home_youtube_player_layout);
            J1.a c5 = new a.C0046a(this.f4160c).e(0).h(0).g(3).d(1).c();
            YouTubePlayerView youTubePlayerView2 = this.f4164g;
            t.b(youTubePlayerView2);
            youTubePlayerView2.e(new b(this, d5), c5);
        }
    }

    public int getItemCount() {
        return this.f4162e.size();
    }

    public final ArrayList m() {
        return this.f4162e;
    }

    public final int n() {
        return this.f4168k;
    }

    public final boolean o() {
        return this.f4163f;
    }

    public final boolean q() {
        return this.f4169l;
    }

    public final boolean r() {
        return this.f4170m;
    }

    /* renamed from: s */
    public void onBindViewHolder(a aVar, int i5) {
        t.e(aVar, "holder");
        int i6 = i5 + 1;
        if (com.uptodown.activities.preferences.a.f15150a.N(this.f4160c) || i5 != this.f4168k) {
            Object obj = this.f4162e.get(i5);
            t.d(obj, "get(...)");
            aVar.o((C2657f) obj, i6);
            return;
        }
        Object obj2 = this.f4162e.get(i5);
        t.d(obj2, "get(...)");
        aVar.q((C2657f) obj2, i6);
    }

    /* renamed from: t */
    public a onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_video_featured_item, viewGroup, false);
        t.b(inflate);
        return new a(this, inflate, this.f4158a, this.f4159b, this.f4160c, this.f4161d);
    }

    public final void u(int i5) {
        this.f4168k = i5;
    }

    public final void v(ArrayList arrayList) {
        t.e(arrayList, "appList");
        ArrayList arrayList2 = this.f4162e;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
    }

    public final void w(boolean z4) {
        this.f4169l = z4;
    }

    public final void x(boolean z4) {
        this.f4163f = z4;
    }

    public final void y(boolean z4) {
        this.f4170m = z4;
    }
}
