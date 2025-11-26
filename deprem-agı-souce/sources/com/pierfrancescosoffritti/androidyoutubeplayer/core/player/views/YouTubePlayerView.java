package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import K1.j;
import L1.d;
import L1.e;
import L1.k;
import W2.q;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class YouTubePlayerView extends e implements LifecycleEventObserver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final List f13234a;

    /* renamed from: b  reason: collision with root package name */
    private final b f13235b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final d f13236c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13237d;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13238a;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                f13238a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView.a.<clinit>():void");
        }
    }

    public static final class b implements I1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YouTubePlayerView f13239a;

        b(YouTubePlayerView youTubePlayerView) {
            this.f13239a = youTubePlayerView;
        }

        public void a(View view, C2616a aVar) {
            t.e(view, "fullscreenView");
            t.e(aVar, "exitFullscreen");
            if (!this.f13239a.f13234a.isEmpty()) {
                for (I1.b a5 : this.f13239a.f13234a) {
                    a5.a(view, aVar);
                }
                return;
            }
            throw new IllegalStateException("To enter fullscreen you need to first register a FullscreenListener.");
        }

        public void onExitFullscreen() {
            if (!this.f13239a.f13234a.isEmpty()) {
                for (I1.b onExitFullscreen : this.f13239a.f13234a) {
                    onExitFullscreen.onExitFullscreen();
                }
                return;
            }
            throw new IllegalStateException("To enter fullscreen you need to first register a FullscreenListener.");
        }
    }

    public static final class c extends I1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f13240a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ YouTubePlayerView f13241b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f13242c;

        c(String str, YouTubePlayerView youTubePlayerView, boolean z4) {
            this.f13240a = str;
            this.f13241b = youTubePlayerView;
            this.f13242c = z4;
        }

        public void d(H1.e eVar) {
            boolean z4;
            t.e(eVar, "youTubePlayer");
            String str = this.f13240a;
            if (str != null) {
                YouTubePlayerView youTubePlayerView = this.f13241b;
                boolean z5 = this.f13242c;
                if (!youTubePlayerView.f13236c.getCanPlay$core_release() || !z5) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                j.a(eVar, z4, str, 0.0f);
            }
            eVar.a(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        t.e(context, "context");
        this.f13234a = new ArrayList();
        b bVar = new b(this);
        this.f13235b = bVar;
        Context context2 = context;
        d dVar = new d(context2, bVar, (AttributeSet) null, 0, 12, (C2633k) null);
        this.f13236c = dVar;
        addView(dVar, k.b());
        TypedArray obtainStyledAttributes = context2.getTheme().obtainStyledAttributes(attributeSet, G1.b.f2479a, 0, 0);
        t.d(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f13237d = obtainStyledAttributes.getBoolean(G1.b.f2481c, true);
        boolean z4 = obtainStyledAttributes.getBoolean(G1.b.f2480b, false);
        boolean z5 = obtainStyledAttributes.getBoolean(G1.b.f2482d, true);
        String string = obtainStyledAttributes.getString(G1.b.f2483e);
        obtainStyledAttributes.recycle();
        if (!z4 || string != null) {
            c cVar = new c(string, this, z4);
            if (this.f13237d) {
                dVar.i(cVar, z5, J1.a.f2664b.a(context2), string);
                return;
            }
            return;
        }
        throw new IllegalStateException("YouTubePlayerView: videoId is not set but autoPlay is set to true. This combination is not allowed.");
    }

    private final void f() {
        this.f13236c.o();
    }

    private final void g() {
        this.f13236c.p();
    }

    public final boolean c(I1.b bVar) {
        t.e(bVar, "fullscreenListener");
        return this.f13234a.add(bVar);
    }

    public final View d(int i5) {
        return this.f13236c.g(i5);
    }

    public final void e(I1.c cVar, J1.a aVar) {
        t.e(cVar, "youTubePlayerListener");
        t.e(aVar, "playerOptions");
        if (!this.f13237d) {
            this.f13236c.h(cVar, true, aVar);
            return;
        }
        throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false.");
    }

    public final boolean getEnableAutomaticInitialization() {
        return this.f13237d;
    }

    public final void h() {
        this.f13236c.q();
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        t.e(lifecycleOwner, "source");
        t.e(event, NotificationCompat.CATEGORY_EVENT);
        switch (a.f13238a[event.ordinal()]) {
            case 1:
                f();
                return;
            case 2:
                g();
                return;
            case 3:
                h();
                return;
            case 4:
            case 5:
            case 6:
            case 7:
                return;
            default:
                throw new q();
        }
    }

    public final void setCustomPlayerUi(View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        this.f13236c.setCustomPlayerUi(view);
    }

    public final void setEnableAutomaticInitialization(boolean z4) {
        this.f13237d = z4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context) {
        this(context, (AttributeSet) null, 0);
        t.e(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        t.e(context, "context");
    }
}
