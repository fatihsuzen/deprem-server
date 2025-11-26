package K1;

import H1.d;
import H1.e;
import I1.a;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.t;

public final class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private d f2761a = d.UNKNOWN;

    /* renamed from: b  reason: collision with root package name */
    private float f2762b;

    /* renamed from: c  reason: collision with root package name */
    private float f2763c;

    /* renamed from: d  reason: collision with root package name */
    private String f2764d;

    public void b(e eVar, String str) {
        t.e(eVar, "youTubePlayer");
        t.e(str, "videoId");
        this.f2764d = str;
    }

    public void c(e eVar, float f5) {
        t.e(eVar, "youTubePlayer");
        this.f2762b = f5;
    }

    public void e(e eVar, d dVar) {
        t.e(eVar, "youTubePlayer");
        t.e(dVar, MRAIDCommunicatorUtil.KEY_STATE);
        this.f2761a = dVar;
    }

    public void f(e eVar, float f5) {
        t.e(eVar, "youTubePlayer");
        this.f2763c = f5;
    }
}
