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
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvMyAppsActivity;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import z2.T;

/* renamed from: m2.i  reason: case insensitive filesystem */
public final class C2689i extends ResultReceiver {

    /* renamed from: m2.i$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25301a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f25302b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Activity activity, C2308e eVar) {
            super(2, eVar);
            this.f25302b = activity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f25302b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f25301a == 0) {
                u.b(obj);
                ((MyApps) this.f25302b).A5(false);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2689i(Handler handler) {
        super(handler);
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i5, Bundle bundle) {
        Boolean bool;
        if (i5 == 602) {
            T.f26520a.b();
            return;
        }
        k.a aVar = k.f32g;
        if (aVar.g() != null) {
            Activity g5 = aVar.g();
            Integer num = null;
            if (g5 instanceof Updates) {
                if (i5 == 600) {
                    ((Updates) g5).d6();
                } else if (i5 == 601) {
                    if (bundle != null) {
                        bool = Boolean.valueOf(bundle.getBoolean("newUpdatesAvailable"));
                    } else {
                        bool = null;
                    }
                    if (bundle != null) {
                        num = Integer.valueOf(bundle.getInt("newUpdatesAvailableCount"));
                    }
                    ((Updates) g5).c6(bool, num);
                }
            } else if (g5 instanceof MyApps) {
                if (i5 == 601) {
                    C2908y0 unused = C2876i.d(N.a(C2865c0.c()), (C2312i) null, (O) null, new a(g5, (C2308e) null), 3, (Object) null);
                }
            } else if (g5 instanceof SecurityActivity) {
                if (i5 == 601) {
                    ((SecurityActivity) g5).w5();
                }
            } else if (g5 instanceof TvMyAppsActivity) {
                if (i5 == 601) {
                    TvMyAppsActivity tvMyAppsActivity = (TvMyAppsActivity) g5;
                    tvMyAppsActivity.runOnUiThread(new TvMyAppsActivity.a());
                }
            } else if (g5 instanceof MainActivity) {
                if (i5 == 603) {
                    ((MainActivity) g5).g7();
                } else if (i5 == 604) {
                    MainActivity mainActivity = (MainActivity) g5;
                    mainActivity.runOnUiThread(new MainActivity.C1588a());
                }
            } else if (g5 instanceof AppDetailActivity) {
                if (i5 == 603) {
                    ((AppDetailActivity) g5).u3();
                }
            } else if (g5 instanceof WishlistActivity) {
                if (i5 == 601) {
                    ((WishlistActivity) g5).D5((String) null);
                }
            } else if (g5 instanceof RecommendedActivity) {
                if (i5 == 601) {
                    ((RecommendedActivity) g5).F5((String) null);
                }
            } else if (g5 instanceof PublicListActivity) {
                if (i5 == 601) {
                    ((PublicListActivity) g5).j5((String) null);
                }
            } else if (g5 instanceof RollbackActivity) {
                if (i5 == 601) {
                    RollbackActivity rollbackActivity = (RollbackActivity) g5;
                    rollbackActivity.runOnUiThread(new RollbackActivity.a());
                }
            } else if ((g5 instanceof TvAppDetailActivity) && i5 == 603) {
                TvAppDetailActivity tvAppDetailActivity = (TvAppDetailActivity) g5;
                tvAppDetailActivity.runOnUiThread(new TvAppDetailActivity.a());
            }
        }
    }
}
