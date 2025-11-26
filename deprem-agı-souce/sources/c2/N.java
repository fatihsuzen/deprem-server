package C2;

import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import h2.P;
import k2.C2605o;
import kotlin.jvm.internal.t;
import l2.V;
import z2.C2962v;

public final class N extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final P f17541a;

    /* renamed from: b  reason: collision with root package name */
    private final C2605o f17542b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f17543c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public N(P p5, C2605o oVar) {
        super(p5.getRoot());
        t.e(p5, "followItemBinding");
        t.e(oVar, "listener");
        this.f17541a = p5;
        this.f17542b = oVar;
        this.f17543c = p5.getRoot().getContext();
        UsernameTextView usernameTextView = p5.f22580e;
        k.a aVar = k.f32g;
        usernameTextView.setTypeface(aVar.w());
        p5.f22579d.setTypeface(aVar.w());
    }

    /* access modifiers changed from: private */
    public static final void d(N n5, V v5, View view) {
        C2605o oVar = n5.f17542b;
        String j5 = v5.j();
        t.b(j5);
        oVar.a(j5);
    }

    /* access modifiers changed from: private */
    public static final void e(N n5, V v5, int i5, View view) {
        C2605o oVar = n5.f17542b;
        String j5 = v5.j();
        t.b(j5);
        oVar.b(j5, i5);
    }

    public final void c(V v5, int i5) {
        t.e(v5, "item");
        w l5 = s.h().l(V.f24870q.f(v5.a()));
        UptodownApp.a aVar = UptodownApp.f13477F;
        Context context = this.f17543c;
        t.d(context, "context");
        l5.n(aVar.g0(context)).i(this.f17541a.f22577b);
        this.f17541a.getRoot().setOnClickListener(new L(this, v5));
        if (v5.q()) {
            C2962v.a aVar2 = C2962v.f26557a;
            ImageView imageView = this.f17541a.f22577b;
            t.d(imageView, "ivAvatarFollowListItem");
            aVar2.b(imageView);
            this.f17541a.f22578c.setVisibility(0);
        } else {
            C2962v.a aVar3 = C2962v.f26557a;
            ImageView imageView2 = this.f17541a.f22577b;
            t.d(imageView2, "ivAvatarFollowListItem");
            aVar3.a(imageView2);
            this.f17541a.f22578c.setVisibility(8);
        }
        this.f17541a.f22580e.setText(v5.k());
        UsernameTextView.a aVar4 = UsernameTextView.f21329k;
        UsernameTextView usernameTextView = this.f17541a.f22580e;
        t.d(usernameTextView, "tvUsernameFollowListItem");
        aVar4.a(usernameTextView, v5.q(), v5.o());
        this.f17541a.f22579d.setOnClickListener(new M(this, v5, i5));
        if (v5.i() == 1) {
            this.f17541a.f22579d.setVisibility(0);
            this.f17541a.f22579d.setText(this.f17543c.getString(R.string.following));
            this.f17541a.f22579d.setBackground(ContextCompat.getDrawable(this.f17543c, R.drawable.ripple_open_button));
            this.f17541a.f22579d.setTextColor(ContextCompat.getColor(this.f17543c, R.color.blue_primary));
        } else if (v5.i() == 0) {
            this.f17541a.f22579d.setVisibility(0);
            this.f17541a.f22579d.setText(this.f17543c.getString(R.string.follow));
            this.f17541a.f22579d.setBackground(ContextCompat.getDrawable(this.f17543c, R.drawable.ripple_blue_primary_button));
            this.f17541a.f22579d.setTextColor(ContextCompat.getColor(this.f17543c, R.color.white));
        } else if (v5.i() == -1) {
            this.f17541a.f22579d.setVisibility(8);
        }
    }
}
