package B2;

import H1.d;
import H1.e;
import I1.a;
import K1.i;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.t;

public final class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private i f17338a;

    /* renamed from: b  reason: collision with root package name */
    private View f17339b;

    /* renamed from: c  reason: collision with root package name */
    private View f17340c;

    /* renamed from: d  reason: collision with root package name */
    private final View f17341d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f17342e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f17343f;

    public h(View view, e eVar) {
        t.e(view, "customPlayerUi");
        t.e(eVar, "youTubePlayer");
        this.f17340c = view;
        View findViewById = view.findViewById(R.id.v_player_panel_home);
        t.d(findViewById, "findViewById(...)");
        this.f17341d = findViewById;
        View findViewById2 = this.f17340c.findViewById(R.id.iv_player_panel_feature);
        t.d(findViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById2;
        this.f17342e = imageView;
        View findViewById3 = this.f17340c.findViewById(R.id.iv_player_control);
        t.d(findViewById3, "findViewById(...)");
        this.f17343f = (ImageView) findViewById3;
        i iVar = new i();
        this.f17338a = iVar;
        this.f17339b = view;
        t.b(iVar);
        eVar.c(iVar);
        m(imageView, eVar);
        m(findViewById, eVar);
    }

    private final void m(View view, e eVar) {
        view.setOnClickListener(new g(eVar));
    }

    /* access modifiers changed from: private */
    public static final void n(e eVar, View view) {
        eVar.play();
    }

    public void e(e eVar, d dVar) {
        t.e(eVar, "youTubePlayer");
        t.e(dVar, MRAIDCommunicatorUtil.KEY_STATE);
        super.e(eVar, dVar);
        if (dVar == d.PLAYING) {
            this.f17342e.setVisibility(8);
            this.f17343f.setVisibility(8);
            return;
        }
        this.f17342e.setVisibility(0);
        UptodownApp.a aVar = UptodownApp.f13477F;
        Context context = this.f17340c.getContext();
        t.d(context, "getContext(...)");
        if (!aVar.f(context)) {
            this.f17343f.setVisibility(0);
        }
    }

    public final ImageView l() {
        return this.f17342e;
    }
}
