package C2;

import S1.k;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import h2.K;
import h2.L;
import h2.M;
import k2.C2603m;
import kotlin.jvm.internal.t;
import l2.C2672v;
import l2.V;

public final class D extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final L f17456a;

    /* renamed from: b  reason: collision with root package name */
    private final C2603m f17457b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f17458c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public D(L l5, C2603m mVar) {
        super(l5.getRoot());
        t.e(l5, "feedItemBinding");
        t.e(mVar, "listener");
        this.f17456a = l5;
        this.f17457b = mVar;
        this.f17458c = l5.getRoot().getContext();
        UsernameTextView usernameTextView = l5.f22464j;
        k.a aVar = k.f32g;
        usernameTextView.setTypeface(aVar.w());
        l5.f22462h.setTypeface(aVar.x());
        l5.f22463i.setTypeface(aVar.x());
    }

    private final void j(C2672v vVar) {
        K c5 = K.c(LayoutInflater.from(this.f17458c));
        t.d(c5, "inflate(...)");
        w l5 = s.h().l(V.f24870q.d(vVar.b()));
        UptodownApp.a aVar = UptodownApp.f13477F;
        Context context = this.f17458c;
        t.d(context, "context");
        l5.n(aVar.g0(context)).i(c5.f22443b);
        this.f17456a.f22460f.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_feed_recommended));
        c5.getRoot().setOnClickListener(new C2067x(this, vVar));
        TextView textView = c5.f22446e;
        k.a aVar2 = k.f32g;
        textView.setTypeface(aVar2.w());
        c5.f22446e.setOnClickListener(new C2070y(this, vVar));
        c5.f22444c.setTypeface(aVar2.w());
        c5.f22444c.setText(vVar.c());
        c5.f22445d.setTypeface(aVar2.x());
        c5.f22445d.setText(vVar.d());
        this.f17456a.f22456b.addView(c5.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void k(D d5, C2672v vVar, View view) {
        d5.f17457b.f(vVar.a(), vVar.e());
    }

    /* access modifiers changed from: private */
    public static final void l(D d5, C2672v vVar, View view) {
        d5.f17457b.d(vVar.o(), vVar.p());
    }

    private final void m(C2672v vVar) {
        w l5 = s.h().l(V.f24870q.e(vVar.l()));
        UptodownApp.a aVar = UptodownApp.f13477F;
        Context context = this.f17458c;
        t.d(context, "context");
        l5.n(aVar.i0(context)).i(this.f17456a.f22457c);
        this.f17456a.f22457c.setOnClickListener(new C2073z(this, vVar));
        if (vVar.m() == 1) {
            this.f17456a.f22459e.setVisibility(0);
        } else {
            this.f17456a.f22459e.setVisibility(8);
        }
        this.f17456a.f22464j.setText(vVar.p());
        UsernameTextView.a aVar2 = UsernameTextView.f21329k;
        UsernameTextView usernameTextView = this.f17456a.f22464j;
        t.d(usernameTextView, "tvUsernameFeedItem");
        aVar2.a(usernameTextView, vVar.s(), vVar.q());
        this.f17456a.f22464j.setOnClickListener(new A(this, vVar));
        this.f17456a.f22462h.setText(vVar.k());
        this.f17456a.f22463i.setText(vVar.n());
        this.f17456a.f22456b.setVisibility(0);
        this.f17456a.f22458d.setVisibility(8);
        this.f17456a.f22456b.removeAllViews();
    }

    /* access modifiers changed from: private */
    public static final void n(D d5, C2672v vVar, View view) {
        d5.f17457b.c(vVar.o());
    }

    /* access modifiers changed from: private */
    public static final void o(D d5, C2672v vVar, View view) {
        d5.f17457b.c(vVar.o());
    }

    private final void p(C2672v vVar) {
        M c5 = M.c(LayoutInflater.from(this.f17458c));
        t.d(c5, "inflate(...)");
        w l5 = s.h().l(V.f24870q.d(vVar.b()));
        UptodownApp.a aVar = UptodownApp.f13477F;
        Context context = this.f17458c;
        t.d(context, "context");
        l5.n(aVar.g0(context)).i(c5.f22488b);
        this.f17456a.f22460f.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_feed_review));
        c5.f22488b.setOnClickListener(new C2061v(this, vVar));
        TextView textView = c5.f22495i;
        k.a aVar2 = k.f32g;
        textView.setTypeface(aVar2.w());
        c5.f22495i.setText(vVar.c());
        c5.f22496j.setTypeface(aVar2.x());
        c5.f22496j.setText(vVar.i());
        c5.getRoot().setOnClickListener(new C2064w(this, vVar));
        w(vVar, c5);
        this.f17456a.f22456b.addView(c5.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void q(D d5, C2672v vVar, View view) {
        d5.f17457b.f(vVar.a(), vVar.e());
    }

    /* access modifiers changed from: private */
    public static final void r(D d5, C2672v vVar, View view) {
        d5.f17457b.b(vVar);
    }

    private final void s(C2672v vVar) {
        this.f17456a.f22460f.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_feed_follow));
        this.f17456a.f22456b.setVisibility(8);
        this.f17456a.f22458d.setVisibility(0);
        this.f17456a.f22458d.setOnClickListener(new B(this, vVar));
    }

    /* access modifiers changed from: private */
    public static final void t(D d5, C2672v vVar, View view) {
        d5.f17457b.e(vVar.o(), vVar.p());
    }

    private final void u(C2672v vVar) {
        M c5 = M.c(LayoutInflater.from(this.f17458c));
        t.d(c5, "inflate(...)");
        w l5 = s.h().l(V.f24870q.d(vVar.b()));
        UptodownApp.a aVar = UptodownApp.f13477F;
        Context context = this.f17458c;
        t.d(context, "context");
        l5.n(aVar.g0(context)).i(c5.f22488b);
        this.f17456a.f22460f.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_feed_review));
        c5.getRoot().setOnClickListener(new C(this, vVar));
        c5.f22495i.setTypeface(k.f32g.w());
        c5.f22495i.setText(vVar.c());
        c5.f22496j.setVisibility(8);
        w(vVar, c5);
        this.f17456a.f22456b.addView(c5.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void v(D d5, C2672v vVar, View view) {
        d5.f17457b.f(vVar.a(), vVar.e());
    }

    private final void w(C2672v vVar, M m5) {
        if (vVar.s()) {
            m5.f22489c.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on_turbo));
            m5.f22490d.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_off_turbo));
            m5.f22491e.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_off_turbo));
            m5.f22492f.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_off_turbo));
            m5.f22493g.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_off_turbo));
            if (vVar.g() >= 1) {
                m5.f22489c.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on_turbo));
            }
            if (vVar.g() >= 2) {
                m5.f22490d.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on_turbo));
            }
            if (vVar.g() >= 3) {
                m5.f22491e.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on_turbo));
            }
            if (vVar.g() >= 4) {
                m5.f22492f.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on_turbo));
            }
            if (vVar.g() == 5) {
                m5.f22493g.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on_turbo));
                return;
            }
            return;
        }
        m5.f22489c.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on));
        m5.f22490d.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_off));
        m5.f22491e.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_off));
        m5.f22492f.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_off));
        m5.f22493g.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_off));
        if (vVar.g() >= 1) {
            m5.f22489c.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on));
        }
        if (vVar.g() >= 2) {
            m5.f22490d.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on));
        }
        if (vVar.g() >= 3) {
            m5.f22491e.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on));
        }
        if (vVar.g() >= 4) {
            m5.f22492f.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on));
        }
        if (vVar.g() == 5) {
            m5.f22493g.setImageDrawable(ContextCompat.getDrawable(this.f17458c, R.drawable.vector_star_on));
        }
    }

    public final void i(C2672v vVar) {
        t.e(vVar, "item");
        m(vVar);
        String r5 = vVar.r();
        if (r5 != null) {
            switch (r5.hashCode()) {
                case -1268958287:
                    if (r5.equals("follow")) {
                        s(vVar);
                        return;
                    }
                    return;
                case -938102371:
                    if (r5.equals(CampaignEx.JSON_KEY_STAR)) {
                        u(vVar);
                        return;
                    }
                    return;
                case 950398559:
                    if (r5.equals("comment")) {
                        p(vVar);
                        return;
                    }
                    return;
                case 1345968512:
                    if (r5.equals("list_add")) {
                        j(vVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
