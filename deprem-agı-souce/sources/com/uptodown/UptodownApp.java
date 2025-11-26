package com.uptodown;

import B2.i;
import D2.h;
import S1.j;
import S1.k;
import U1.C2201a;
import W2.J;
import W2.u;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.UiModeManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import b2.C2290j;
import b2.C2301u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.ACData;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.NonIABData;
import com.inmobi.cmp.model.PingReturn;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.preferences.a;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.GetRemoteInstallWorker;
import com.uptodown.workers.GetUserDataWorker;
import com.uptodown.workers.PreRegisterWorker;
import com.uptodown.workers.SearchApksWorker;
import com.uptodown.workers.TrackingWorker;
import j2.C2581b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import l2.C2661j;
import l2.C2668q;
import l2.T;
import l2.V;
import l2.r;
import m2.C2681a;
import m2.C2682b;
import m2.C2683c;
import m2.C2687g;
import m2.C2688h;
import m2.C2689i;
import n2.C2693a;
import o2.C2702a;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import z2.C2940B;
import z2.C2954m;
import z2.E;
import z2.F;
import z2.G;
import z2.H;
import z2.P;
import z2.Y;

public final class UptodownApp extends k implements ChoiceCmpCallback {

    /* renamed from: F  reason: collision with root package name */
    public static final a f13477F = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public static float f13478G = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public static String f13479H;
    /* access modifiers changed from: private */

    /* renamed from: I  reason: collision with root package name */
    public static String f13480I;
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public static String f13481J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public static String f13482K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public static String f13483L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public static String f13484M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public static String f13485N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public static String f13486O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public static String f13487P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public static int f13488Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public static int f13489R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public static int f13490S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public static int f13491T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public static int f13492U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public static H1.e f13493V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public static H1.e f13494W;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public static final HashMap f13495X = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public static C2689i f13496Y = new C2689i((Handler) null);
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public static boolean f13497Z;
    /* access modifiers changed from: private */

    /* renamed from: m0  reason: collision with root package name */
    public static boolean f13498m0;
    /* access modifiers changed from: private */

    /* renamed from: n0  reason: collision with root package name */
    public static C2661j f13499n0;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public static final Object f13500o0 = new Object();
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public static ArrayList f13501p0;
    /* access modifiers changed from: private */

    /* renamed from: q0  reason: collision with root package name */
    public static C2655d f13502q0;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public static long f13503r0;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public static ArrayList f13504s0;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public static final Object f13505t0 = new Object();
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public static final Object f13506u0 = new Object();
    /* access modifiers changed from: private */

    /* renamed from: v0  reason: collision with root package name */
    public static ArrayList f13507v0 = new ArrayList();

    /* renamed from: C  reason: collision with root package name */
    private C2681a f13508C;

    /* renamed from: D  reason: collision with root package name */
    private C2683c f13509D;

    /* renamed from: E  reason: collision with root package name */
    private C2682b f13510E;

    public static final class a {

        /* renamed from: com.uptodown.UptodownApp$a$a  reason: collision with other inner class name */
        public static final class C0119a implements C2702a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f13511a;

            C0119a(Context context) {
                this.f13511a = context;
            }

            public void a(String str) {
                Bundle bundle = new Bundle();
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "failed");
                new F(this.f13511a).d("uptodown_services_init", bundle);
            }

            public void b() {
                Bundle bundle = new Bundle();
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                new F(this.f13511a).d("uptodown_services_init", bundle);
            }

            public void c() {
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            Object f13512a;

            /* renamed from: b  reason: collision with root package name */
            int f13513b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f13514c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ boolean f13515d;

            /* renamed from: com.uptodown.UptodownApp$a$b$a  reason: collision with other inner class name */
            static final class C0120a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f13516a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ L f13517b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f13518c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ boolean f13519d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0120a(L l5, String str, boolean z4, C2308e eVar) {
                    super(2, eVar);
                    this.f13517b = l5;
                    this.f13518c = str;
                    this.f13519d = z4;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new C0120a(this.f13517b, this.f13518c, this.f13519d, eVar);
                }

                /* JADX WARNING: Can't fix incorrect switch cases order */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
                    if (((com.uptodown.activities.AppDetailActivity) r5).v3(r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
                    if (((com.uptodown.activities.MainActivity) r5).e8(r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b2, code lost:
                    if (((com.uptodown.activities.MyApps) r5).k5("app_updated", r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cb, code lost:
                    if (((com.uptodown.activities.Updates) r5).D5("app_updated", r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d9, code lost:
                    if (((com.uptodown.activities.Updates) r5).D5("app_installed", r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ef, code lost:
                    if (((com.uptodown.activities.FreeUpSpaceActivity) r5).r3("app_updated", r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fe, code lost:
                    if (((com.uptodown.activities.FreeUpSpaceActivity) r5).r3("app_installed", r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:50:0x0113, code lost:
                    if (((com.uptodown.activities.AppInstalledDetailsActivity) r5).q5("app_updated", r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:54:0x0126, code lost:
                    if (((com.uptodown.tv.ui.activity.TvAppDetailActivity) r5).n(r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
                    if (((com.uptodown.activities.OldVersionsActivity) r5).W3(r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                    /*
                        r4 = this;
                        java.lang.Object r0 = c3.C2316b.f()
                        int r1 = r4.f13516a
                        switch(r1) {
                            case 0: goto L_0x001a;
                            case 1: goto L_0x0015;
                            case 2: goto L_0x0015;
                            case 3: goto L_0x0011;
                            case 4: goto L_0x0015;
                            case 5: goto L_0x0015;
                            case 6: goto L_0x0015;
                            case 7: goto L_0x0015;
                            case 8: goto L_0x0015;
                            case 9: goto L_0x0015;
                            case 10: goto L_0x0015;
                            default: goto L_0x0009;
                        }
                    L_0x0009:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r0)
                        throw r5
                    L_0x0011:
                        W2.u.b(r5)
                        goto L_0x005a
                    L_0x0015:
                        W2.u.b(r5)
                        goto L_0x014c
                    L_0x001a:
                        W2.u.b(r5)
                        kotlin.jvm.internal.L r5 = r4.f13517b
                        java.lang.Object r5 = r5.f24690a
                        boolean r1 = r5 instanceof com.uptodown.activities.OldVersionsActivity
                        if (r1 == 0) goto L_0x0034
                        com.uptodown.activities.OldVersionsActivity r5 = (com.uptodown.activities.OldVersionsActivity) r5
                        java.lang.String r1 = r4.f13518c
                        r2 = 1
                        r4.f13516a = r2
                        java.lang.Object r5 = r5.W3(r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x0034:
                        boolean r1 = r5 instanceof com.uptodown.activities.AppDetailActivity
                        if (r1 == 0) goto L_0x0047
                        com.uptodown.activities.AppDetailActivity r5 = (com.uptodown.activities.AppDetailActivity) r5
                        java.lang.String r1 = r4.f13518c
                        r2 = 2
                        r4.f13516a = r2
                        java.lang.Object r5 = r5.v3(r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x0047:
                        boolean r1 = r5 instanceof com.uptodown.activities.MainActivity
                        if (r1 == 0) goto L_0x0095
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        java.lang.String r1 = r4.f13518c
                        r2 = 3
                        r4.f13516a = r2
                        java.lang.Object r5 = r5.e8(r1, r4)
                        if (r5 != r0) goto L_0x005a
                        goto L_0x0128
                    L_0x005a:
                        boolean r5 = r4.f13519d
                        if (r5 == 0) goto L_0x0067
                        kotlin.jvm.internal.L r5 = r4.f13517b
                        java.lang.Object r5 = r5.f24690a
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        r5.l8()
                    L_0x0067:
                        kotlin.jvm.internal.L r5 = r4.f13517b
                        java.lang.Object r5 = r5.f24690a
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        java.lang.String r0 = r4.f13518c
                        r5.n8(r0)
                        kotlin.jvm.internal.L r5 = r4.f13517b
                        java.lang.Object r5 = r5.f24690a
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        java.lang.String r0 = r4.f13518c
                        r5.j8(r0)
                        kotlin.jvm.internal.L r5 = r4.f13517b
                        java.lang.Object r5 = r5.f24690a
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        java.lang.String r0 = r4.f13518c
                        r5.g8(r0)
                        kotlin.jvm.internal.L r5 = r4.f13517b
                        java.lang.Object r5 = r5.f24690a
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        java.lang.String r0 = r4.f13518c
                        r5.d8(r0)
                        goto L_0x014c
                    L_0x0095:
                        boolean r1 = r5 instanceof com.uptodown.activities.MyDownloads
                        if (r1 == 0) goto L_0x00a1
                        com.uptodown.activities.MyDownloads r5 = (com.uptodown.activities.MyDownloads) r5
                        r0 = 0
                        r5.D4(r0)
                        goto L_0x014c
                    L_0x00a1:
                        boolean r1 = r5 instanceof com.uptodown.activities.MyApps
                        java.lang.String r2 = "app_updated"
                        if (r1 == 0) goto L_0x00b6
                        com.uptodown.activities.MyApps r5 = (com.uptodown.activities.MyApps) r5
                        java.lang.String r1 = r4.f13518c
                        r3 = 4
                        r4.f13516a = r3
                        java.lang.Object r5 = r5.k5(r2, r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x00b6:
                        boolean r1 = r5 instanceof com.uptodown.activities.Updates
                        java.lang.String r3 = "app_installed"
                        if (r1 == 0) goto L_0x00dc
                        boolean r1 = r4.f13519d
                        if (r1 == 0) goto L_0x00ce
                        com.uptodown.activities.Updates r5 = (com.uptodown.activities.Updates) r5
                        java.lang.String r1 = r4.f13518c
                        r3 = 5
                        r4.f13516a = r3
                        java.lang.Object r5 = r5.D5(r2, r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x00ce:
                        com.uptodown.activities.Updates r5 = (com.uptodown.activities.Updates) r5
                        java.lang.String r1 = r4.f13518c
                        r2 = 6
                        r4.f13516a = r2
                        java.lang.Object r5 = r5.D5(r3, r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x00dc:
                        boolean r1 = r5 instanceof com.uptodown.activities.FreeUpSpaceActivity
                        if (r1 == 0) goto L_0x0101
                        boolean r1 = r4.f13519d
                        if (r1 == 0) goto L_0x00f2
                        com.uptodown.activities.FreeUpSpaceActivity r5 = (com.uptodown.activities.FreeUpSpaceActivity) r5
                        java.lang.String r1 = r4.f13518c
                        r3 = 7
                        r4.f13516a = r3
                        java.lang.Object r5 = r5.r3(r2, r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x00f2:
                        com.uptodown.activities.FreeUpSpaceActivity r5 = (com.uptodown.activities.FreeUpSpaceActivity) r5
                        java.lang.String r1 = r4.f13518c
                        r2 = 8
                        r4.f13516a = r2
                        java.lang.Object r5 = r5.r3(r3, r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x0101:
                        boolean r1 = r5 instanceof com.uptodown.activities.AppInstalledDetailsActivity
                        if (r1 == 0) goto L_0x0116
                        boolean r1 = r4.f13519d
                        if (r1 == 0) goto L_0x014c
                        com.uptodown.activities.AppInstalledDetailsActivity r5 = (com.uptodown.activities.AppInstalledDetailsActivity) r5
                        r1 = 9
                        r4.f13516a = r1
                        java.lang.Object r5 = r5.q5(r2, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x0116:
                        boolean r1 = r5 instanceof com.uptodown.tv.ui.activity.TvAppDetailActivity
                        if (r1 == 0) goto L_0x0129
                        com.uptodown.tv.ui.activity.TvAppDetailActivity r5 = (com.uptodown.tv.ui.activity.TvAppDetailActivity) r5
                        java.lang.String r1 = r4.f13518c
                        r2 = 10
                        r4.f13516a = r2
                        java.lang.Object r5 = r5.n(r1, r4)
                        if (r5 != r0) goto L_0x014c
                    L_0x0128:
                        return r0
                    L_0x0129:
                        boolean r0 = r5 instanceof com.uptodown.activities.WishlistActivity
                        if (r0 == 0) goto L_0x0135
                        com.uptodown.activities.WishlistActivity r5 = (com.uptodown.activities.WishlistActivity) r5
                        java.lang.String r0 = r4.f13518c
                        r5.D5(r0)
                        goto L_0x014c
                    L_0x0135:
                        boolean r0 = r5 instanceof com.uptodown.activities.RecommendedActivity
                        if (r0 == 0) goto L_0x0141
                        com.uptodown.activities.RecommendedActivity r5 = (com.uptodown.activities.RecommendedActivity) r5
                        java.lang.String r0 = r4.f13518c
                        r5.F5(r0)
                        goto L_0x014c
                    L_0x0141:
                        boolean r0 = r5 instanceof com.uptodown.activities.PublicListActivity
                        if (r0 == 0) goto L_0x014c
                        com.uptodown.activities.PublicListActivity r5 = (com.uptodown.activities.PublicListActivity) r5
                        java.lang.String r0 = r4.f13518c
                        r5.j5(r0)
                    L_0x014c:
                        W2.J r5 = W2.J.f19942a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.a.b.C0120a.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                public final Object invoke(M m5, C2308e eVar) {
                    return ((C0120a) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, boolean z4, C2308e eVar) {
                super(2, eVar);
                this.f13514c = str;
                this.f13515d = z4;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f13514c, this.f13515d, eVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
                if (w3.X.b(1000, r7) == r0) goto L_0x0086;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0084, code lost:
                if (w3.C2872g.g(r1, r3, r7) == r0) goto L_0x0086;
             */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = c3.C2316b.f()
                    int r1 = r7.f13513b
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L_0x002e
                    if (r1 == r4) goto L_0x0026
                    if (r1 == r3) goto L_0x001e
                    if (r1 != r2) goto L_0x0016
                    W2.u.b(r8)
                    goto L_0x0087
                L_0x0016:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L_0x001e:
                    java.lang.Object r1 = r7.f13512a
                    kotlin.jvm.internal.L r1 = (kotlin.jvm.internal.L) r1
                    W2.u.b(r8)
                    goto L_0x005f
                L_0x0026:
                    java.lang.Object r1 = r7.f13512a
                    kotlin.jvm.internal.L r1 = (kotlin.jvm.internal.L) r1
                    W2.u.b(r8)
                    goto L_0x0052
                L_0x002e:
                    W2.u.b(r8)
                    kotlin.jvm.internal.L r8 = new kotlin.jvm.internal.L
                    r8.<init>()
                    S1.k$a r1 = S1.k.f32g
                    android.app.Activity r1 = r1.g()
                    r8.f24690a = r1
                    if (r1 == 0) goto L_0x0060
                    boolean r5 = r1 instanceof com.uptodown.core.activities.InstallerActivity
                    if (r5 == 0) goto L_0x0060
                    com.uptodown.core.activities.InstallerActivity r1 = (com.uptodown.core.activities.InstallerActivity) r1
                    r7.f13512a = r8
                    r7.f13513b = r4
                    java.lang.Object r1 = r1.p2(r4, r7)
                    if (r1 != r0) goto L_0x0051
                    goto L_0x0086
                L_0x0051:
                    r1 = r8
                L_0x0052:
                    r7.f13512a = r1
                    r7.f13513b = r3
                    r3 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r8 = w3.X.b(r3, r7)
                    if (r8 != r0) goto L_0x005f
                    goto L_0x0086
                L_0x005f:
                    r8 = r1
                L_0x0060:
                    S1.k$a r1 = S1.k.f32g
                    android.app.Activity r3 = r1.g()
                    if (r3 == 0) goto L_0x0087
                    android.app.Activity r1 = r1.g()
                    r8.f24690a = r1
                    w3.I0 r1 = w3.C2865c0.c()
                    com.uptodown.UptodownApp$a$b$a r3 = new com.uptodown.UptodownApp$a$b$a
                    java.lang.String r4 = r7.f13514c
                    boolean r5 = r7.f13515d
                    r6 = 0
                    r3.<init>(r8, r4, r5, r6)
                    r7.f13512a = r6
                    r7.f13513b = r2
                    java.lang.Object r8 = w3.C2872g.g(r1, r3, r7)
                    if (r8 != r0) goto L_0x0087
                L_0x0086:
                    return r0
                L_0x0087:
                    W2.J r8 = W2.J.f19942a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private final void M0(Context context, boolean z4) {
            Data build = new Data.Builder().putBoolean("isCompressed", z4).build();
            Constraints build2 = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            WorkManager.Companion.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) TrackingWorker.class).addTag("TrackingWorkerSingle")).setBackoffCriteria(BackoffPolicy.LINEAR, 1, TimeUnit.MINUTES)).setInputData(build)).setConstraints(build2)).build());
        }

        public static /* synthetic */ boolean O0(a aVar, Context context, boolean z4, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                z4 = true;
            }
            return aVar.N0(context, z4);
        }

        public static /* synthetic */ void V(a aVar, File file, Context context, String str, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                str = null;
            }
            aVar.U(file, context, str);
        }

        public static /* synthetic */ void X(a aVar, File file, Context context, String str, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                str = null;
            }
            aVar.W(file, context, str);
        }

        private final void Y(File file, Context context) {
            C2668q qVar;
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            if (file.isFile()) {
                String name = file.getName();
                t.d(name, "getName(...)");
                qVar = a5.f0(name);
            } else {
                String absolutePath = file.getAbsolutePath();
                t.d(absolutePath, "getAbsolutePath(...)");
                qVar = a5.g0(absolutePath);
            }
            a5.m();
            Bundle bundle = new Bundle();
            if (!(qVar == null || qVar.w() == null)) {
                G g5 = G.f26487a;
                String w4 = qVar.w();
                t.b(w4);
                bundle = g5.b(context, w4, bundle);
                bundle.putString("packagename", qVar.w());
            }
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
            new F(context).d("install", bundle);
        }

        private final int d(float f5) {
            return (int) (f5 * UptodownApp.f13478G);
        }

        private final boolean e0(String str) {
            boolean z4;
            synchronized (UptodownApp.f13500o0) {
                z4 = false;
                if (UptodownApp.f13501p0 != null) {
                    ArrayList G02 = UptodownApp.f13501p0;
                    t.b(G02);
                    int size = G02.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        ArrayList G03 = UptodownApp.f13501p0;
                        t.b(G03);
                        if (s.E(str, ((C2655d) G03.get(i5)).o(), true)) {
                            ArrayList G04 = UptodownApp.f13501p0;
                            t.b(G04);
                            G04.remove(i5);
                            z4 = true;
                            break;
                        }
                        i5++;
                    }
                }
            }
            return z4;
        }

        private final void m0(Context context) {
            Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            TimeUnit timeUnit = TimeUnit.MINUTES;
            WorkManager.Companion.getInstance(context).enqueue((WorkRequest) (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) TrackingWorker.class, 30, timeUnit).addTag("TrackingWorkerPeriodic")).setBackoffCriteria(BackoffPolicy.LINEAR, 1, timeUnit)).setConstraints(build)).build());
        }

        public final String A() {
            return UptodownApp.f13484M;
        }

        public final void A0(String str) {
            UptodownApp.f13479H = str;
        }

        public final C2689i B() {
            return UptodownApp.f13496Y;
        }

        public final void B0(ArrayList arrayList) {
            UptodownApp.f13504s0 = arrayList;
        }

        public final C2655d C() {
            return UptodownApp.f13502q0;
        }

        public final void C0(boolean z4) {
            UptodownApp.f13497Z = z4;
        }

        public final ArrayList D() {
            ArrayList E02;
            synchronized (UptodownApp.f13506u0) {
                E02 = UptodownApp.f13507v0;
            }
            return E02;
        }

        public final void D0(int i5) {
            UptodownApp.f13489R = i5;
        }

        public final ArrayList E() {
            ArrayList G02;
            synchronized (UptodownApp.f13500o0) {
                G02 = UptodownApp.f13501p0;
            }
            return G02;
        }

        public final void E0(int i5) {
            UptodownApp.f13488Q = i5;
        }

        public final int F() {
            return UptodownApp.f13492U;
        }

        public final void F0(int i5) {
            UptodownApp.f13490S = i5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:3:0x001b A[LOOP:0: B:3:0x001b->B:8:0x0031, LOOP_START, PHI: r0 
          PHI: (r0v2 androidx.work.WorkInfo$State) = (r0v0 androidx.work.WorkInfo$State), (r0v3 androidx.work.WorkInfo$State) binds: [B:2:0x0004, B:8:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.work.WorkInfo.State G(java.lang.String r3, android.content.Context r4) {
            /*
                r2 = this;
                androidx.work.WorkInfo$State r0 = androidx.work.WorkInfo.State.SUCCEEDED
                if (r4 == 0) goto L_0x0033
                androidx.work.WorkManager$Companion r1 = androidx.work.WorkManager.Companion
                androidx.work.WorkManager r4 = r1.getInstance(r4)
                kotlin.jvm.internal.t.b(r3)
                n0.d r3 = r4.getWorkInfosByTag(r3)
                java.lang.Object r3 = r3.get()
                java.util.List r3 = (java.util.List) r3
                java.util.Iterator r3 = r3.iterator()
            L_0x001b:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x0033
                java.lang.Object r4 = r3.next()
                androidx.work.WorkInfo r4 = (androidx.work.WorkInfo) r4
                androidx.work.WorkInfo$State r0 = r4.getState()
                androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.RUNNING
                if (r0 == r4) goto L_0x0033
                androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.ENQUEUED
                if (r0 != r4) goto L_0x001b
            L_0x0033:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.a.G(java.lang.String, android.content.Context):androidx.work.WorkInfo$State");
        }

        public final void G0(int i5) {
            UptodownApp.f13491T = i5;
        }

        public final HashMap H() {
            return UptodownApp.f13495X;
        }

        public final void H0(String str) {
            UptodownApp.f13485N = str;
        }

        public final void I(Context context) {
            t.e(context, "context");
            if (com.uptodown.activities.preferences.a.f15150a.k0(context)) {
                new C2693a(context).c("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ2YWx1ZSI6IjRhOTRiN2I1MTk1NGVkNGMyMjZjZGM1MGMxZDE5Yjk2MTY4MzY5OTE1NCJ9.1j7HuORIuuZDp0wTf1f9A__sAHEnqaGDiuCNY5OQXYN", new C0119a(context));
            }
        }

        public final void I0(String str) {
            UptodownApp.f13484M = str;
        }

        public final boolean J() {
            return UptodownApp.f13498m0;
        }

        public final void J0(C2655d dVar) {
            UptodownApp.f13502q0 = dVar;
        }

        public final boolean K() {
            return false;
        }

        public final void K0(ArrayList arrayList) {
            synchronized (UptodownApp.f13500o0) {
                UptodownApp.f13501p0 = arrayList;
                J j5 = J.f19942a;
            }
        }

        public final boolean L(String str) {
            if (m() == null) {
                return false;
            }
            C2661j m5 = m();
            t.b(m5);
            if (s.E(m5.d(), str, true)) {
                return true;
            }
            return false;
        }

        public final void L0(int i5) {
            UptodownApp.f13492U = i5;
        }

        public final boolean M(Context context) {
            t.e(context, "context");
            return T("DownloadUpdatesWorker", context);
        }

        public final boolean N(T t5) {
            boolean z4;
            t.e(t5, "update");
            synchronized (UptodownApp.f13506u0) {
                Iterator it = UptodownApp.f13507v0.iterator();
                t.d(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        z4 = false;
                        break;
                    }
                    Object next = it.next();
                    t.d(next, "next(...)");
                    z4 = true;
                    if (s.E(((T) next).h(), t5.h(), true)) {
                        break;
                    }
                }
            }
            return z4;
        }

        public final boolean N0(Context context, boolean z4) {
            t.e(context, "context");
            if (T("TrackingWorkerSingle", context) || S("TrackingWorkerPeriodic", context) || S("GenerateQueueWorker", context) || S("DownloadUpdatesWorker", context)) {
                return false;
            }
            M0(context, z4);
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean O(java.lang.String r7) {
            /*
                r6 = this;
                java.lang.String r0 = "packagename"
                kotlin.jvm.internal.t.e(r7, r0)
                java.lang.Object r0 = com.uptodown.UptodownApp.f13500o0
                monitor-enter(r0)
                java.util.ArrayList r1 = com.uptodown.UptodownApp.f13501p0     // Catch:{ all -> 0x003c }
                r2 = 0
                if (r1 == 0) goto L_0x003e
                java.util.ArrayList r1 = com.uptodown.UptodownApp.f13501p0     // Catch:{ all -> 0x003c }
                kotlin.jvm.internal.t.b(r1)     // Catch:{ all -> 0x003c }
                int r1 = r1.size()     // Catch:{ all -> 0x003c }
                r3 = r2
            L_0x001d:
                if (r3 >= r1) goto L_0x003e
                java.util.ArrayList r4 = com.uptodown.UptodownApp.f13501p0     // Catch:{ all -> 0x003c }
                kotlin.jvm.internal.t.b(r4)     // Catch:{ all -> 0x003c }
                java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x003c }
                l2.d r4 = (l2.C2655d) r4     // Catch:{ all -> 0x003c }
                java.lang.String r4 = r4.o()     // Catch:{ all -> 0x003c }
                r5 = 1
                boolean r4 = t3.s.E(r7, r4, r5)     // Catch:{ all -> 0x003c }
                if (r4 == 0) goto L_0x0039
                monitor-exit(r0)
                return r5
            L_0x0039:
                int r3 = r3 + 1
                goto L_0x001d
            L_0x003c:
                r7 = move-exception
                goto L_0x0040
            L_0x003e:
                monitor-exit(r0)
                return r2
            L_0x0040:
                monitor-exit(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.a.O(java.lang.String):boolean");
        }

        public final boolean P() {
            return false;
        }

        public final Object P0(String str, boolean z4, C2308e eVar) {
            Object g5 = C2872g.g(C2865c0.b(), new b(str, z4, (C2308e) null), eVar);
            if (g5 == C2316b.f()) {
                return g5;
            }
            return J.f19942a;
        }

        public final boolean Q(Context context) {
            t.e(context, "context");
            try {
                PackageManager packageManager = context.getPackageManager();
                t.d(packageManager, "getPackageManager(...)");
                return new C2290j().r(C2301u.d(packageManager, "com.npg.smarttvnpg", 4096));
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }

        public final boolean R(Context context) {
            t.e(context, "context");
            Object systemService = context.getSystemService("uimode");
            t.c(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
            if (((UiModeManager) systemService).getCurrentModeType() == 4 || Q(context)) {
                return true;
            }
            return false;
        }

        public final boolean S(String str, Context context) {
            t.e(context, "context");
            WorkManager instance = WorkManager.Companion.getInstance(context);
            t.b(str);
            for (WorkInfo state : (List) instance.getWorkInfosByTag(str).get()) {
                if (state.getState() == WorkInfo.State.RUNNING) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:4:0x001f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean T(java.lang.String r2, android.content.Context r3) {
            /*
                r1 = this;
                if (r3 == 0) goto L_0x0033
                androidx.work.WorkManager$Companion r0 = androidx.work.WorkManager.Companion
                androidx.work.WorkManager r3 = r0.getInstance(r3)
                kotlin.jvm.internal.t.b(r2)
                n0.d r2 = r3.getWorkInfosByTag(r2)
                java.lang.Object r2 = r2.get()
                java.util.List r2 = (java.util.List) r2
                java.util.Iterator r2 = r2.iterator()
            L_0x0019:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x0033
                java.lang.Object r3 = r2.next()
                androidx.work.WorkInfo r3 = (androidx.work.WorkInfo) r3
                androidx.work.WorkInfo$State r3 = r3.getState()
                androidx.work.WorkInfo$State r0 = androidx.work.WorkInfo.State.RUNNING
                if (r3 == r0) goto L_0x0031
                androidx.work.WorkInfo$State r0 = androidx.work.WorkInfo.State.ENQUEUED
                if (r3 != r0) goto L_0x0019
            L_0x0031:
                r2 = 1
                return r2
            L_0x0033:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.a.T(java.lang.String, android.content.Context):boolean");
        }

        public final void U(File file, Context context, String str) {
            t.e(file, "item");
            t.e(context, "context");
            k.a aVar = k.f32g;
            if (aVar.i() == null && aVar.j() == null) {
                new j(context).a(file, str, new C2954m().A(context));
                Y(file, context);
                return;
            }
            String string = context.getString(R.string.core_installation_in_progress_msg);
            t.d(string, "getString(...)");
            ((C1598a) context).u0(string);
        }

        public final void W(File file, Context context, String str) {
            t.e(file, "item");
            t.e(context, "context");
            new j(context).c(file, str, new C2954m().A(context));
            Y(file, context);
        }

        public final boolean Z() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - UptodownApp.f13503r0 <= 600) {
                return false;
            }
            UptodownApp.f13503r0 = currentTimeMillis;
            return true;
        }

        public final Bundle a(Activity activity) {
            t.e(activity, "<this>");
            if (!com.uptodown.activities.preferences.a.f15150a.P(activity) || P()) {
                return null;
            }
            return ActivityOptions.makeCustomAnimation(activity, R.anim.left_to_right_in, R.anim.fade_out).toBundle();
        }

        public final int a0(C2657f fVar, C1598a aVar) {
            t.e(fVar, "appInfo");
            t.e(aVar, "activity");
            C2668q qVar = new C2668q();
            qVar.c(fVar);
            int S4 = qVar.S(aVar);
            if (S4 >= 0) {
                String N4 = fVar.N();
                t.b(N4);
                aVar.O2(S4, N4);
                return S4;
            }
            aVar.u0(aVar.getString(R.string.error_cant_enqueue_download) + " (108)");
            return S4;
        }

        public final ActivityOptionsCompat b(Activity activity) {
            t.e(activity, "<this>");
            if (!com.uptodown.activities.preferences.a.f15150a.P(activity) || P()) {
                return null;
            }
            return ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.left_to_right_in, R.anim.fade_out);
        }

        public final C2668q b0(C2657f fVar, Context context) {
            t.e(fVar, "appInfo");
            t.e(context, "context");
            C2668q qVar = new C2668q();
            qVar.c(fVar);
            int S4 = qVar.S(context);
            if (S4 >= 0 && H.f26488a.d()) {
                DownloadApkWorker.f21342i.b(context, S4);
            }
            return qVar;
        }

        public final ArrayList c(C2655d dVar) {
            ArrayList G02;
            t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            synchronized (UptodownApp.f13500o0) {
                try {
                    if (dVar.b() > 0) {
                        if (UptodownApp.f13501p0 != null) {
                            ArrayList G03 = UptodownApp.f13501p0;
                            t.b(G03);
                            G03.add(dVar);
                        } else {
                            UptodownApp.f13501p0 = new ArrayList();
                            ArrayList G04 = UptodownApp.f13501p0;
                            t.b(G04);
                            G04.add(dVar);
                        }
                    }
                    G02 = UptodownApp.f13501p0;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return G02;
        }

        public final void c0(T t5) {
            t.e(t5, "update");
            synchronized (UptodownApp.f13506u0) {
                try {
                    Iterator it = UptodownApp.f13507v0.iterator();
                    int i5 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i5 = -1;
                            break;
                        }
                        int i6 = i5 + 1;
                        if (s.E(((T) it.next()).h(), t5.h(), true)) {
                            break;
                        }
                        i5 = i6;
                    }
                    if (i5 >= 0 && i5 < UptodownApp.f13507v0.size()) {
                        UptodownApp.f13507v0.remove(i5);
                    }
                    J j5 = J.f19942a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void d0(String str) {
            t.e(str, "packagename");
            if (e0(str)) {
                Bundle bundle = new Bundle();
                bundle.putString("packagename", str);
                P.f26510a.f().send(106, bundle);
            }
        }

        public final void e(Context context) {
            t.e(context, "context");
            int i5 = context.getResources().getDisplayMetrics().widthPixels;
            if (!s.E(context.getString(R.string.screen_type), "phone", true)) {
                i5 = 1024;
            }
            L0((int) (((float) i5) - (((float) 4) * context.getResources().getDimension(R.dimen.margin_m))));
            E0((int) (((double) F()) / 2.048d));
            D0((int) (((double) i5) / 2.048d));
            float f5 = context.getResources().getDisplayMetrics().density;
            int i6 = context.getResources().getDisplayMetrics().heightPixels;
            float dimension = context.getResources().getDimension(R.dimen.icon_size_xl);
            float dimension2 = context.getResources().getDimension(R.dimen.icon_size_l);
            float dimension3 = context.getResources().getDimension(R.dimen.gallery_height);
            float dimension4 = context.getResources().getDimension(R.dimen.user_avatar_profile_size);
            float dimension5 = context.getResources().getDimension(R.dimen.user_avatar_review_size);
            float dimension6 = context.getResources().getDimension(R.dimen.gallery_feature_horizontal_height);
            UptodownApp.f13478G = i.f17344a.c(context) / f5;
            StringBuilder sb = new StringBuilder();
            sb.append(':');
            sb.append(d(dimension));
            z0(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(':');
            sb2.append(d(dimension2));
            A0(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(':');
            sb3.append(d(dimension4));
            p0(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(':');
            sb4.append(d(dimension5));
            q0(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(':');
            sb5.append(d(dimension3));
            I0(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(':');
            sb6.append(d((float) i6));
            H0(sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(':');
            sb7.append(d((float) v()));
            x0(sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(':');
            sb8.append(d((float) w()));
            w0(sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(':');
            sb9.append(d(dimension6));
            y0(sb9.toString());
        }

        public final boolean f(Context context) {
            t.e(context, "context");
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            if ((aVar.c(context) != 0 || !H.f26488a.f()) && aVar.c(context) != 1) {
                return false;
            }
            return true;
        }

        public final h f0(Context context) {
            t.e(context, "context");
            return new h((int) context.getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2633k) null);
        }

        public final void g() {
            synchronized (UptodownApp.f13500o0) {
                UptodownApp.f13501p0 = null;
                J j5 = J.f19942a;
            }
        }

        public final h g0(Context context) {
            t.e(context, "context");
            if (com.uptodown.activities.preferences.a.f15150a.g(context) <= 0 || !H.f26488a.c()) {
                return new h((int) context.getResources().getDimension(R.dimen.border_radius_xs), (h.a) null, 2, (C2633k) null);
            }
            return new h((int) context.getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2633k) null);
        }

        public final Object h() {
            return UptodownApp.f13505t0;
        }

        public final h h0(Context context) {
            t.e(context, "context");
            if (com.uptodown.activities.preferences.a.f15150a.g(context) <= 0 || !H.f26488a.c()) {
                return new h((int) context.getResources().getDimension(R.dimen.border_radius_xs), (h.a) null, 2, (C2633k) null);
            }
            return new h((int) context.getResources().getDimension(R.dimen.border_radius_s), (h.a) null, 2, (C2633k) null);
        }

        public final String i() {
            return UptodownApp.f13486O;
        }

        public final h i0(Context context) {
            t.e(context, "context");
            return new h((int) context.getResources().getDimension(R.dimen.border_radius_s), (h.a) null, 2, (C2633k) null);
        }

        public final String j() {
            return UptodownApp.f13487P;
        }

        public final void j0(Context context) {
            t.e(context, "context");
            String k5 = com.uptodown.activities.preferences.a.f15150a.k(context);
            if (k5 == null || k5.length() == 0) {
                if (!T("GetRemoteInstallWorker", context)) {
                    WorkManager instance = WorkManager.Companion.getInstance(context);
                    instance.enqueue((WorkRequest) (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) GetRemoteInstallWorker.class, 30, TimeUnit.MINUTES).addTag("GetRemoteInstallWorker")).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).build());
                }
            } else if (T("GetRemoteInstallWorker", context)) {
                WorkManager.Companion.getInstance(context).cancelAllWorkByTag("GetRemoteInstallWorker");
            }
        }

        public final H1.e k() {
            return UptodownApp.f13493V;
        }

        public final void k0(Context context) {
            t.e(context, "context");
            if (!T("GetUserDataWorker", context)) {
                WorkManager instance = WorkManager.Companion.getInstance(context);
                instance.enqueue((WorkRequest) (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) GetUserDataWorker.class, 24, TimeUnit.HOURS).addTag("GetUserDataWorker")).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).build());
            }
        }

        public final H1.e l() {
            return UptodownApp.f13494W;
        }

        public final void l0(Context context) {
            t.e(context, "context");
            if (!T("PreRegisterWorker", context)) {
                WorkManager instance = WorkManager.Companion.getInstance(context);
                instance.enqueue((WorkRequest) (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) PreRegisterWorker.class, 4, TimeUnit.HOURS).addTag("PreRegisterWorker")).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).build());
            }
        }

        public final C2661j m() {
            return UptodownApp.f13499n0;
        }

        public final String n() {
            return UptodownApp.f13482K;
        }

        public final void n0(Context context) {
            t.e(context, "context");
            if (!T("TrackingWorkerPeriodic", context)) {
                m0(context);
            }
        }

        public final String o() {
            return UptodownApp.f13481J;
        }

        public final void o0(FragmentTransaction fragmentTransaction, Context context) {
            t.e(fragmentTransaction, "<this>");
            t.e(context, "context");
            if (com.uptodown.activities.preferences.a.f15150a.P(context) && !P()) {
                fragmentTransaction.setCustomAnimations(R.anim.left_to_right_in, R.anim.fade_out, R.anim.left_to_right_in, R.anim.fade_out);
            }
        }

        public final String p() {
            return UptodownApp.f13483L;
        }

        public final void p0(String str) {
            UptodownApp.f13486O = str;
        }

        public final String q() {
            return UptodownApp.f13480I;
        }

        public final void q0(String str) {
            UptodownApp.f13487P = str;
        }

        public final String r() {
            return UptodownApp.f13479H;
        }

        public final void r0(H1.e eVar) {
            UptodownApp.f13493V = eVar;
        }

        public final C2655d s() {
            C2655d dVar;
            synchronized (UptodownApp.f13500o0) {
                if (UptodownApp.f13501p0 != null) {
                    ArrayList G02 = UptodownApp.f13501p0;
                    t.b(G02);
                    if (G02.size() > 0) {
                        ArrayList G03 = UptodownApp.f13501p0;
                        t.b(G03);
                        dVar = (C2655d) G03.remove(0);
                    }
                }
                dVar = null;
            }
            return dVar;
        }

        public final void s0(H1.e eVar) {
            UptodownApp.f13494W = eVar;
        }

        public final ArrayList t() {
            return UptodownApp.f13504s0;
        }

        public final void t0(boolean z4) {
            UptodownApp.f13498m0 = z4;
        }

        public final boolean u() {
            return UptodownApp.f13497Z;
        }

        public final void u0(C2661j jVar) {
            UptodownApp.f13499n0 = jVar;
        }

        public final int v() {
            return UptodownApp.f13489R;
        }

        public final void v0(T t5) {
            t.e(t5, "update");
            synchronized (UptodownApp.f13506u0) {
                try {
                    Iterator it = UptodownApp.f13507v0.iterator();
                    t.d(it, "iterator(...)");
                    while (true) {
                        if (!it.hasNext()) {
                            UptodownApp.f13507v0.add(t5);
                            break;
                        }
                        Object next = it.next();
                        t.d(next, "next(...)");
                        if (s.E(((T) next).h(), t5.h(), true)) {
                            break;
                        }
                    }
                    J j5 = J.f19942a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final int w() {
            return UptodownApp.f13488Q;
        }

        public final void w0(String str) {
            UptodownApp.f13482K = str;
        }

        public final int x() {
            return UptodownApp.f13490S;
        }

        public final void x0(String str) {
            UptodownApp.f13481J = str;
        }

        public final int y() {
            return UptodownApp.f13491T;
        }

        public final void y0(String str) {
            UptodownApp.f13483L = str;
        }

        public final String z() {
            return UptodownApp.f13485N;
        }

        public final void z0(String str) {
            UptodownApp.f13480I = str;
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13520a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UptodownApp f13521b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(UptodownApp uptodownApp, C2308e eVar) {
            super(2, eVar);
            this.f13521b = uptodownApp;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f13521b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13520a == 0) {
                u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f13521b);
                a5.a();
                Iterator it = a5.p0().iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    C2668q qVar = (C2668q) next;
                    if (qVar.w() == null || qVar.E() == 0) {
                        a5.A(qVar);
                    } else if (!qVar.o().isEmpty()) {
                        Iterator it2 = qVar.o().iterator();
                        t.d(it2, "iterator(...)");
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next2 = it2.next();
                            t.d(next2, "next(...)");
                            if (((r) next2).d() <= 0) {
                                a5.A(qVar);
                                break;
                            }
                        }
                    }
                }
                a5.m();
                new E().b(this.f13521b);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13522a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UptodownApp f13523b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f13524c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(UptodownApp uptodownApp, e eVar, C2308e eVar2) {
            super(2, eVar2);
            this.f13523b = uptodownApp;
            this.f13524c = eVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f13523b, this.f13524c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13522a;
            if (i5 == 0) {
                u.b(obj);
                GetUserDataWorker.a aVar = GetUserDataWorker.f21373b;
                Context applicationContext = this.f13523b.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                e eVar = this.f13524c;
                this.f13522a = 1;
                if (aVar.a(applicationContext, eVar, this) == f5) {
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
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13525a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UptodownApp f13526b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(UptodownApp uptodownApp, C2308e eVar) {
            super(2, eVar);
            this.f13526b = uptodownApp;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f13526b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13525a;
            if (i5 == 0) {
                u.b(obj);
                UptodownApp uptodownApp = this.f13526b;
                this.f13525a = 1;
                if (uptodownApp.j1(this) == f5) {
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
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class e implements k2.P {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UptodownApp f13527a;

        e(UptodownApp uptodownApp) {
            this.f13527a = uptodownApp;
        }

        public void a() {
            V.b bVar = V.f24870q;
            Context applicationContext = this.f13527a.getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            if (bVar.h(applicationContext) != null) {
                a aVar = UptodownApp.f13477F;
                Context applicationContext2 = this.f13527a.getApplicationContext();
                t.d(applicationContext2, "getApplicationContext(...)");
                aVar.k0(applicationContext2);
                Context applicationContext3 = this.f13527a.getApplicationContext();
                t.d(applicationContext3, "getApplicationContext(...)");
                aVar.l0(applicationContext3);
                Context applicationContext4 = this.f13527a.getApplicationContext();
                t.d(applicationContext4, "getApplicationContext(...)");
                aVar.j0(applicationContext4);
            }
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13528a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UptodownApp f13529b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(UptodownApp uptodownApp, C2308e eVar) {
            super(2, eVar);
            this.f13529b = uptodownApp;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f13529b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13528a;
            if (i5 == 0) {
                u.b(obj);
                UptodownApp uptodownApp = this.f13529b;
                this.f13528a = 1;
                if (uptodownApp.o1(uptodownApp, this) == f5) {
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
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13530a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13531b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Context context, C2308e eVar) {
            super(2, eVar);
            this.f13531b = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f13531b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13530a;
            if (i5 == 0) {
                u.b(obj);
                ArrayList D4 = new C2954m().D(this.f13531b);
                C2954m mVar = new C2954m();
                Context context = this.f13531b;
                this.f13530a = 1;
                if (mVar.f(D4, context, this) == f5) {
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
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public final Object j1(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final void k1() {
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = getSystemService("notification");
            t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            String string = getString(R.string.app_name);
            t.d(string, "getString(...)");
            String string2 = getString(R.string.notification_channel_description);
            t.d(string2, "getString(...)");
            NotificationChannel a5 = androidx.browser.trusted.g.a("CHANNEL_ID_UPTODOWN", string, 3);
            a5.setSound((Uri) null, (AudioAttributes) null);
            a5.setDescription(string2);
            a5.enableLights(true);
            ((NotificationManager) systemService).createNotificationChannel(a5);
        }
    }

    private final void l1(boolean z4, String str) {
        Bundle bundle = new Bundle();
        if (z4) {
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "accepted");
        } else {
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "rejected");
        }
        bundle.putString("consent_version", str);
        new F(this).d("user_consent_mintegral", bundle);
    }

    private final void m1() {
        if (com.uptodown.activities.preferences.a.f15150a.n0(this)) {
            V h5 = V.f24870q.h(this);
            if (h5 == null || !h5.q()) {
                String packageName = getPackageName();
                t.d(packageName, "getPackageName(...)");
                ChoiceCmp.startChoice$default(this, packageName, "p-PLc5NudJ4X36X", this, (ChoiceStyle) null, 16, (Object) null);
            }
        }
    }

    private final void n1() {
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new f(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object o1(Context context, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new g(context, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final void p1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        C2681a aVar = new C2681a();
        this.f13508C = aVar;
        registerReceiver(aVar, intentFilter);
    }

    private final void q1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        C2682b bVar = new C2682b();
        this.f13510E = bVar;
        registerReceiver(bVar, intentFilter);
    }

    private final void r1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        C2683c cVar = new C2683c();
        this.f13509D = cVar;
        registerReceiver(cVar, intentFilter);
    }

    private final void s1(Context context) {
        if (!f13477F.T("SearchApksWorker", context)) {
            WorkManager.Companion.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) SearchApksWorker.class).addTag("SearchApksWorker")).build());
        }
    }

    private final void t1() {
        try {
            C2681a aVar = this.f13508C;
            if (aVar != null) {
                unregisterReceiver(aVar);
                this.f13508C = null;
            }
            C2683c cVar = this.f13509D;
            if (cVar != null) {
                unregisterReceiver(cVar);
                this.f13509D = null;
            }
            C2682b bVar = this.f13510E;
            if (bVar != null) {
                unregisterReceiver(bVar);
                this.f13510E = null;
            }
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
        }
    }

    public void U(String str) {
        t.e(str, NotificationCompat.CATEGORY_EVENT);
    }

    public void onActionButtonClicked(F1.a aVar) {
        t.e(aVar, "actionButton");
    }

    public void onCCPAConsentGiven(String str) {
        t.e(str, "consentString");
    }

    public void onCMPUIStatusChanged(F1.b bVar) {
        t.e(bVar, NotificationCompat.CATEGORY_STATUS);
    }

    public void onCmpError(ChoiceError choiceError) {
        t.e(choiceError, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
    }

    public void onCmpLoaded(PingReturn pingReturn) {
        t.e(pingReturn, "info");
    }

    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        new F(this).b();
        a aVar = f13477F;
        aVar.I(this);
        new C2581b().b(this);
        a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
        Context applicationContext = getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        String k5 = aVar2.k(applicationContext);
        if (k5 != null) {
            Context applicationContext2 = getApplicationContext();
            t.d(applicationContext2, "getApplicationContext(...)");
            if (!aVar2.T(applicationContext2)) {
                Context applicationContext3 = getApplicationContext();
                t.d(applicationContext3, "getApplicationContext(...)");
                new g2.s(applicationContext3, k5);
            }
        }
        new z2.L(this).c();
        p1();
        r1();
        q1();
        int i5 = getResources().getConfiguration().uiMode & 48;
        String f5 = aVar2.f(this);
        if (s.E(f5, "yes", true)) {
            if (i5 != 32) {
                AppCompatDelegate.setDefaultNightMode(2);
            }
        } else if (!s.E(f5, "no", true)) {
            AppCompatDelegate.setDefaultNightMode(-1);
        } else if (i5 != 16) {
            AppCompatDelegate.setDefaultNightMode(1);
        }
        Context applicationContext4 = getApplicationContext();
        t.d(applicationContext4, "getApplicationContext(...)");
        if (aVar2.n(applicationContext4) == null) {
            String language = Locale.getDefault().getLanguage();
            Context applicationContext5 = getApplicationContext();
            t.d(applicationContext5, "getApplicationContext(...)");
            t.b(language);
            aVar2.N0(applicationContext5, language);
        }
        n1();
        Context applicationContext6 = getApplicationContext();
        t.d(applicationContext6, "getApplicationContext(...)");
        if (aVar2.j0(applicationContext6)) {
            Context applicationContext7 = getApplicationContext();
            t.d(applicationContext7, "getApplicationContext(...)");
            if (694 != aVar2.M(applicationContext7)) {
                Context applicationContext8 = getApplicationContext();
                t.d(applicationContext8, "getApplicationContext(...)");
                aVar2.m1(applicationContext8, false);
                Context applicationContext9 = getApplicationContext();
                t.d(applicationContext9, "getApplicationContext(...)");
                aVar2.r1(applicationContext9, (String) null);
            }
        }
        k1();
        aVar.n0(this);
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new c(this, new e(this), (C2308e) null), 3, (Object) null);
        C2201a aVar3 = new C2201a(this);
        aVar3.a();
        if (aVar3.m() || aVar3.t()) {
            k.f32g.T(new C2688h((Handler) null));
        }
        if (aVar3.q()) {
            s1(this);
        }
        b0(new C2687g((Handler) null));
        ResultReceiver R4 = R();
        t.c(R4, "null cannot be cast to non-null type com.uptodown.receivers.InstallerActivityReceiver");
        ((C2687g) R4).b(getApplicationContext());
        z2.M m5 = z2.M.f26506a;
        Context applicationContext10 = getApplicationContext();
        t.d(applicationContext10, "getApplicationContext(...)");
        m5.i(applicationContext10);
        k.f32g.b();
        C2908y0 unused2 = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new d(this, (C2308e) null), 3, (Object) null);
        new Y().d(this);
        m1();
    }

    public void onGoogleBasicConsentChange(GoogleBasicConsents googleBasicConsents) {
        t.e(googleBasicConsents, "consents");
    }

    public void onGoogleVendorConsentGiven(ACData aCData) {
        t.e(aCData, "acData");
    }

    public void onIABVendorConsentGiven(GDPRData gDPRData) {
        boolean z4;
        t.e(gDPRData, "gdprData");
        Boolean bool = gDPRData.getVendor().getConsents().get("867");
        if (bool != null) {
            z4 = bool.booleanValue();
        } else {
            z4 = false;
        }
        Y y4 = new Y();
        Context applicationContext = getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        y4.a(applicationContext, z4);
        l1(z4, "gdpr");
    }

    public void onNonIABVendorConsentGiven(NonIABData nonIABData) {
        t.e(nonIABData, "nonIABData");
    }

    public void onReceiveUSRegulationsConsent(USRegulationData uSRegulationData) {
        boolean z4;
        boolean z5;
        boolean z6;
        t.e(uSRegulationData, "usRegulationData");
        boolean z7 = false;
        if (uSRegulationData.getSaleOptOut() == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (uSRegulationData.getSharingOptOut() == 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (uSRegulationData.getPersonalDataConsents() == 2) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z4 && z5 && z6) {
            z7 = true;
        }
        new Y().b(!z7);
        l1(z7, "mspa");
    }

    public void onTerminate() {
        super.onTerminate();
        new z2.L(this).d();
        t1();
    }

    public void onUserMovedToOtherState() {
    }
}
