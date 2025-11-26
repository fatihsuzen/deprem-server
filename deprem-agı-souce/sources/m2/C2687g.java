package m2;

import S1.k;
import W2.J;
import W2.u;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.C2643C;
import l2.C2655d;
import l2.T;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import z2.C2940B;
import z2.C2954m;
import z2.F;
import z2.G;

/* renamed from: m2.g  reason: case insensitive filesystem */
public final class C2687g extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    private Context f25295a;

    /* renamed from: m2.g$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25296a;

        a(C2308e eVar) {
            super(2, eVar);
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f25296a == 0) {
                u.b(obj);
                Activity g5 = k.f32g.g();
                if (g5 != null) {
                    if (g5 instanceof Updates) {
                        ((Updates) g5).T5();
                    } else if (g5 instanceof MyDownloads) {
                        ((MyDownloads) g5).A4();
                    } else if (g5 instanceof MyApps) {
                        ((MyApps) g5).v5();
                    } else if (g5 instanceof WishlistActivity) {
                        ((WishlistActivity) g5).s5();
                    } else if (g5 instanceof RecommendedActivity) {
                        ((RecommendedActivity) g5).u5();
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: m2.g$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f25297a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f25298b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f25299c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f25300d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(L l5, L l6, String str, C2308e eVar) {
            super(2, eVar);
            this.f25298b = l5;
            this.f25299c = l6;
            this.f25300d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f25298b, this.f25299c, this.f25300d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
            if (((com.uptodown.activities.MainActivity) r5).f8((java.lang.String) r1, r4) == r0) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
            if (((com.uptodown.activities.AppDetailActivity) r5).w3((java.lang.String) r1, r4) == r0) goto L_0x0054;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r4.f25297a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L_0x0017:
                W2.u.b(r5)
                goto L_0x00b0
            L_0x001c:
                W2.u.b(r5)
                S1.k$a r5 = S1.k.f32g
                android.app.Activity r5 = r5.g()
                if (r5 == 0) goto L_0x00b0
                boolean r1 = r5 instanceof com.uptodown.activities.MainActivity
                if (r1 == 0) goto L_0x003e
                kotlin.jvm.internal.L r1 = r4.f25298b
                java.lang.Object r1 = r1.f24690a
                if (r1 == 0) goto L_0x00b0
                com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                java.lang.String r1 = (java.lang.String) r1
                r4.f25297a = r3
                java.lang.Object r5 = r5.f8(r1, r4)
                if (r5 != r0) goto L_0x00b0
                goto L_0x0054
            L_0x003e:
                boolean r1 = r5 instanceof com.uptodown.activities.AppDetailActivity
                if (r1 == 0) goto L_0x0055
                kotlin.jvm.internal.L r1 = r4.f25298b
                java.lang.Object r1 = r1.f24690a
                if (r1 == 0) goto L_0x00b0
                com.uptodown.activities.AppDetailActivity r5 = (com.uptodown.activities.AppDetailActivity) r5
                java.lang.String r1 = (java.lang.String) r1
                r4.f25297a = r2
                java.lang.Object r5 = r5.w3(r1, r4)
                if (r5 != r0) goto L_0x00b0
            L_0x0054:
                return r0
            L_0x0055:
                boolean r0 = r5 instanceof com.uptodown.activities.MyDownloads
                if (r0 == 0) goto L_0x0065
                com.uptodown.activities.MyDownloads r5 = (com.uptodown.activities.MyDownloads) r5
                kotlin.jvm.internal.L r0 = r4.f25298b
                java.lang.Object r0 = r0.f24690a
                java.lang.String r0 = (java.lang.String) r0
                r5.B4(r0)
                goto L_0x00b0
            L_0x0065:
                boolean r0 = r5 instanceof com.uptodown.activities.Updates
                if (r0 == 0) goto L_0x0075
                com.uptodown.activities.Updates r5 = (com.uptodown.activities.Updates) r5
                kotlin.jvm.internal.L r0 = r4.f25298b
                java.lang.Object r0 = r0.f24690a
                java.lang.String r0 = (java.lang.String) r0
                r5.U5(r0)
                goto L_0x00b0
            L_0x0075:
                boolean r0 = r5 instanceof com.uptodown.activities.MyApps
                if (r0 == 0) goto L_0x0085
                com.uptodown.activities.MyApps r5 = (com.uptodown.activities.MyApps) r5
                kotlin.jvm.internal.L r0 = r4.f25299c
                java.lang.Object r0 = r0.f24690a
                java.lang.String r0 = (java.lang.String) r0
                r5.w5(r0)
                goto L_0x00b0
            L_0x0085:
                boolean r0 = r5 instanceof com.uptodown.core.activities.InstallerActivity
                if (r0 == 0) goto L_0x0091
                com.uptodown.core.activities.InstallerActivity r5 = (com.uptodown.core.activities.InstallerActivity) r5
                java.lang.String r0 = r4.f25300d
                r5.e2(r0)
                goto L_0x00b0
            L_0x0091:
                boolean r0 = r5 instanceof com.uptodown.activities.WishlistActivity
                if (r0 == 0) goto L_0x00a1
                com.uptodown.activities.WishlistActivity r5 = (com.uptodown.activities.WishlistActivity) r5
                kotlin.jvm.internal.L r0 = r4.f25299c
                java.lang.Object r0 = r0.f24690a
                java.lang.String r0 = (java.lang.String) r0
                r5.t5(r0)
                goto L_0x00b0
            L_0x00a1:
                boolean r0 = r5 instanceof com.uptodown.activities.RecommendedActivity
                if (r0 == 0) goto L_0x00b0
                com.uptodown.activities.RecommendedActivity r5 = (com.uptodown.activities.RecommendedActivity) r5
                kotlin.jvm.internal.L r0 = r4.f25299c
                java.lang.Object r0 = r0.f24690a
                java.lang.String r0 = (java.lang.String) r0
                r5.v5(r0)
            L_0x00b0:
                W2.J r5 = W2.J.f19942a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: m2.C2687g.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2687g(Handler handler) {
        super(handler);
    }

    private final String a(int i5) {
        switch (i5) {
            case 1:
                return "STATUS_FAILURE";
            case 2:
                return "STATUS_FAILURE_BLOCKED";
            case 3:
                return "STATUS_FAILURE_ABORTED";
            case 4:
                return "STATUS_FAILURE_INVALID";
            case 5:
                return "STATUS_FAILURE_CONFLICT";
            case 6:
                return "STATUS_FAILURE_STORAGE";
            case 7:
                return "STATUS_FAILURE_INCOMPATIBLE";
            default:
                return String.valueOf(i5);
        }
    }

    public final void b(Context context) {
        this.f25295a = context;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i5, Bundle bundle) {
        long j5;
        int i6;
        String str;
        String str2;
        String str3;
        int i7 = i5;
        Bundle bundle2 = bundle;
        Context context = this.f25295a;
        if (context != null) {
            String str4 = null;
            if (i7 == 222) {
                if (bundle2 != null) {
                    str4 = bundle2.getString("appNameAndVersion");
                }
                if (str4 == null) {
                    str4 = "";
                }
                z2.M m5 = z2.M.f26506a;
                Context context2 = this.f25295a;
                t.b(context2);
                m5.n(context2, str4);
            } else if (i7 == 223) {
                UptodownApp.f13477F.J0((C2655d) null);
                Bundle bundle3 = new Bundle();
                bundle3.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "cancelled");
                new F(this.f25295a).d("install", bundle3);
                z2.M m6 = z2.M.f26506a;
                Context context3 = this.f25295a;
                t.b(context3);
                m6.f(context3);
                C2908y0 unused = C2876i.d(N.a(C2865c0.c()), (C2312i) null, (O) null, new a((C2308e) null), 3, (Object) null);
            } else if (i7 == 227) {
                UptodownApp.f13477F.J0((C2655d) null);
                L l5 = new L();
                L l6 = new L();
                z2.M m7 = z2.M.f26506a;
                Context context4 = this.f25295a;
                t.b(context4);
                m7.f(context4);
                if (bundle2 != null) {
                    i6 = bundle2.getInt("piStatus");
                    l5.f24690a = bundle2.getString("packagename");
                    j5 = bundle2.getLong("size");
                    str = bundle2.getString("extra_error");
                } else {
                    j5 = -1;
                    str = null;
                    i6 = 0;
                }
                String a5 = a(i6);
                Bundle bundle4 = new Bundle();
                bundle4.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, a5);
                if (str != null) {
                    bundle4.putString("extraError", str);
                }
                bundle4.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "failed");
                Object obj = l5.f24690a;
                if (obj != null) {
                    bundle4.putString("packagename", (String) obj);
                    if (this.f25295a != null) {
                        C2954m mVar = new C2954m();
                        Context context5 = this.f25295a;
                        t.b(context5);
                        C2655d C4 = mVar.C(context5, (String) l5.f24690a);
                        C2940B.a aVar = C2940B.f26458v;
                        Context context6 = this.f25295a;
                        t.b(context6);
                        C2940B a6 = aVar.a(context6);
                        a6.a();
                        T G02 = a6.G0((String) l5.f24690a);
                        if (G02 != null) {
                            if (G02.e() == 0) {
                                G02.q(2);
                                a6.C1(G02);
                            }
                            bundle4.putInt("update", 1);
                            if (C4 != null) {
                                str3 = C4.m();
                            } else {
                                str3 = null;
                            }
                            l6.f24690a = str3;
                        } else {
                            bundle4.putInt("update", 0);
                        }
                        a6.m();
                        G g5 = G.f26487a;
                        Context context7 = this.f25295a;
                        t.b(context7);
                        bundle4 = g5.b(context7, (String) l5.f24690a, bundle4);
                        C2643C.b bVar = C2643C.f24734j;
                        Context context8 = this.f25295a;
                        t.b(context8);
                        bVar.b(context8, C4, bundle4);
                    }
                }
                if (j5 > 0) {
                    bundle4.putString("size", G.f26487a.e(j5));
                }
                Context context9 = this.f25295a;
                if (context9 != null) {
                    str2 = context9.getString(R.string.dpi_device);
                } else {
                    str2 = null;
                }
                if (!(str2 == null || str2.length() == 0)) {
                    bundle4.putString("dpi", str2);
                }
                new F(this.f25295a).d("install", bundle4);
                C2908y0 unused2 = C2876i.d(N.a(C2865c0.c()), (C2312i) null, (O) null, new b(l5, l6, a5, (C2308e) null), 3, (Object) null);
            } else if (i7 == 228) {
                z2.M m8 = z2.M.f26506a;
                t.b(context);
                m8.f(context);
            }
        }
    }
}
