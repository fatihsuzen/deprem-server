package K1;

import H1.c;
import H1.d;
import H1.e;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.t;

public final class h extends I1.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2755a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2756b;

    /* renamed from: c  reason: collision with root package name */
    private c f2757c;

    /* renamed from: d  reason: collision with root package name */
    private String f2758d;

    /* renamed from: e  reason: collision with root package name */
    private float f2759e;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2760a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                H1.d[] r0 = H1.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                H1.d r1 = H1.d.ENDED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                H1.d r1 = H1.d.PAUSED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                H1.d r1 = H1.d.PLAYING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f2760a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: K1.h.a.<clinit>():void");
        }
    }

    public void b(e eVar, String str) {
        t.e(eVar, "youTubePlayer");
        t.e(str, "videoId");
        this.f2758d = str;
    }

    public void c(e eVar, float f5) {
        t.e(eVar, "youTubePlayer");
        this.f2759e = f5;
    }

    public void e(e eVar, d dVar) {
        t.e(eVar, "youTubePlayer");
        t.e(dVar, MRAIDCommunicatorUtil.KEY_STATE);
        int i5 = a.f2760a[dVar.ordinal()];
        if (i5 == 1 || i5 == 2) {
            this.f2756b = false;
        } else if (i5 == 3) {
            this.f2756b = true;
        }
    }

    public void g(e eVar, c cVar) {
        t.e(eVar, "youTubePlayer");
        t.e(cVar, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
        if (cVar == c.HTML_5_PLAYER) {
            this.f2757c = cVar;
        }
    }

    public final void k() {
        this.f2755a = true;
    }

    public final void l() {
        this.f2755a = false;
    }

    public final void m(e eVar) {
        t.e(eVar, "youTubePlayer");
        String str = this.f2758d;
        if (str != null) {
            boolean z4 = this.f2756b;
            if (z4 && this.f2757c == c.HTML_5_PLAYER) {
                j.a(eVar, this.f2755a, str, this.f2759e);
            } else if (!z4 && this.f2757c == c.HTML_5_PLAYER) {
                eVar.b(str, this.f2759e);
            }
            this.f2757c = null;
        }
    }
}
