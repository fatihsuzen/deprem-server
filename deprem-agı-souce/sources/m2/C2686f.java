package m2;

import S1.k;
import W2.J;
import W2.u;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

/* renamed from: m2.f  reason: case insensitive filesystem */
public final class C2686f extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25290a = new a((C2633k) null);

    /* renamed from: m2.f$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: m2.f$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25291a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f25292b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f25293c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f25294d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Activity activity, int i5, String str, C2308e eVar) {
            super(2, eVar);
            this.f25292b = activity;
            this.f25293c = i5;
            this.f25294d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f25292b, this.f25293c, this.f25294d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f25291a;
            if (i5 == 0) {
                u.b(obj);
                int i6 = this.f25293c;
                String str = this.f25294d;
                this.f25291a = 1;
                if (((AppInstalledDetailsActivity) this.f25292b).L5(i6, str, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2686f(Handler handler) {
        super(handler);
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i5, Bundle bundle) {
        String str;
        String str2;
        k.a aVar = k.f32g;
        if (aVar.g() != null) {
            Activity g5 = aVar.g();
            String str3 = null;
            if (bundle != null) {
                str = bundle.getString("packagename");
            } else {
                str = null;
            }
            if (g5 instanceof Updates) {
                ((Updates) g5).e6(i5, str, bundle);
            } else if (g5 instanceof MyApps) {
                ((MyApps) g5).E5(i5, str, bundle);
            } else if (g5 instanceof AppInstalledDetailsActivity) {
                if (i5 == 105 || i5 == 110) {
                    ((AppInstalledDetailsActivity) g5).runOnUiThread(new C1598a.b());
                    return;
                }
                if (bundle != null) {
                    str2 = bundle.getString("packagename");
                } else {
                    str2 = null;
                }
                C2908y0 unused = C2876i.d(N.a(C2865c0.c()), (C2312i) null, (O) null, new b(g5, i5, str2, (C2308e) null), 3, (Object) null);
            } else if (g5 instanceof MainActivity) {
                if (i5 == 103) {
                    ((MainActivity) g5).l8();
                }
                if (bundle != null) {
                    str3 = bundle.getString("packagename");
                }
                MainActivity mainActivity = (MainActivity) g5;
                mainActivity.runOnUiThread(new MainActivity.C1592e(i5, str3));
                mainActivity.n8(str3);
            } else if (g5 instanceof AppDetailActivity) {
                if (bundle != null) {
                    str3 = bundle.getString("packagename");
                }
                AppDetailActivity appDetailActivity = (AppDetailActivity) g5;
                appDetailActivity.runOnUiThread(new AppDetailActivity.b(i5, str3));
            } else if (g5 instanceof WishlistActivity) {
                if (bundle != null) {
                    str3 = bundle.getString("packagename");
                }
                ((WishlistActivity) g5).D5(str3);
            } else if (g5 instanceof RecommendedActivity) {
                if (bundle != null) {
                    str3 = bundle.getString("packagename");
                }
                ((RecommendedActivity) g5).F5(str3);
            } else if (g5 instanceof PublicListActivity) {
                if (bundle != null) {
                    str3 = bundle.getString("packagename");
                }
                ((PublicListActivity) g5).j5(str3);
            }
        }
    }
}
