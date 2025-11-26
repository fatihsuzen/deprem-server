package com.inmobi.cmp;

import H2.d;
import J2.u;
import T3.i;
import X2.C2250q;
import X2.T;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import b.j;
import b.k;
import b.n;
import b.w;
import b.x;
import b3.C2308e;
import c3.C2316b;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.NonIABData;
import com.inmobi.cmp.model.PingReturn;
import com.inmobi.cmp.model.Regulations;
import com.inmobi.cmp.presentation.components.CmpActivity;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k1.C1703a;
import k4.z;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import m.l;
import n4.h;
import o4.B;
import o4.C2708c;
import o4.C2711f;
import o4.r;
import o4.v;
import q4.e;
import q4.f;
import q4.g;
import q4.m;
import r1.C1797g;
import r4.a;
import s4.b;
import s4.c;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2896s0;
import w3.C2908y0;
import w3.J;
import w3.M;
import w3.N;
import w3.O;
import w3.T0;

public final class ChoiceCmp {
    public static final ChoiceCmp INSTANCE = new ChoiceCmp();

    /* renamed from: a  reason: collision with root package name */
    public static ChoiceCmpCallback f7832a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f7833b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f7834c = "";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f7835d;

    /* renamed from: e  reason: collision with root package name */
    public static UUID f7836e;

    /* renamed from: f  reason: collision with root package name */
    public static long f7837f;

    /* renamed from: g  reason: collision with root package name */
    public static x f7838g;

    /* renamed from: h  reason: collision with root package name */
    public static M f7839h;

    /* renamed from: i  reason: collision with root package name */
    public static final k f7840i = new k(J.f26239j0);

    /* renamed from: j  reason: collision with root package name */
    public static boolean f7841j;

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f7842k = Pattern.compile("^(p-)?([a-zA-Z0-9_-]{13})$");

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        if (r6 == r7) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        if (r6.c(r0) != r7) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
        return r7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object access$loadCmpInfo(com.inmobi.cmp.ChoiceCmp r6, b3.C2308e r7) {
        /*
            r6.getClass()
            boolean r0 = r7 instanceof b.b
            if (r0 == 0) goto L_0x0016
            r0 = r7
            b.b r0 = (b.b) r0
            int r1 = r0.f798c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0016
            int r1 = r1 - r2
            r0.f798c = r1
            goto L_0x001b
        L_0x0016:
            b.b r0 = new b.b
            r0.<init>(r6, r7)
        L_0x001b:
            java.lang.Object r6 = r0.f796a
            java.lang.Object r7 = c3.C2316b.f()
            int r1 = r0.f798c
            java.lang.String r2 = "viewModel"
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x003e
            if (r1 == r4) goto L_0x003a
            if (r1 != r3) goto L_0x0032
            W2.u.b(r6)
            goto L_0x007e
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            W2.u.b(r6)
            goto L_0x005e
        L_0x003e:
            W2.u.b(r6)
            b.x r6 = f7838g
            if (r6 != 0) goto L_0x0049
            kotlin.jvm.internal.t.w(r2)
            r6 = r5
        L_0x0049:
            r0.f798c = r4
            r6.getClass()
            w3.I r1 = w3.C2865c0.b()
            b.o r4 = new b.o
            r4.<init>(r6, r5)
            java.lang.Object r6 = w3.C2872g.g(r1, r4, r0)
            if (r6 != r7) goto L_0x005e
            goto L_0x007d
        L_0x005e:
            J2.h r6 = (J2.h) r6
            b.x r1 = f7838g
            if (r1 != 0) goto L_0x0068
            kotlin.jvm.internal.t.w(r2)
            goto L_0x0069
        L_0x0068:
            r5 = r1
        L_0x0069:
            r5.getClass()
            java.lang.String r1 = "cmpIab"
            kotlin.jvm.internal.t.e(r6, r1)
            r5.f855q = r6
            com.inmobi.cmp.ChoiceCmp r6 = INSTANCE
            r0.f798c = r3
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r7) goto L_0x007e
        L_0x007d:
            return r7
        L_0x007e:
            W2.J r6 = W2.J.f19942a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.access$loadCmpInfo(com.inmobi.cmp.ChoiceCmp, b3.e):java.lang.Object");
    }

    public static final Object access$showCMP(ChoiceCmp choiceCmp, C2308e eVar) {
        choiceCmp.getClass();
        if (!b.f25850a || c.f25853a == null) {
            return W2.J.f19942a;
        }
        Object g5 = C2872g.g(C2865c0.c().F(), new j((C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return W2.J.f19942a;
    }

    public static final void access$startLoadCmpInfo(ChoiceCmp choiceCmp) {
        choiceCmp.getClass();
        M m5 = f7839h;
        if (m5 == null) {
            m5 = N.a(T0.b((C2908y0) null, 1, (Object) null));
        }
        M m6 = m5;
        f7839h = m6;
        if (m6 != null) {
            C2908y0 unused = C2876i.d(m6, f7840i, (O) null, new n((C2308e) null), 2, (Object) null);
        }
    }

    public static final void forceDisplayUI(Activity activity) {
        t.e(activity, "activity");
        ChoiceCmp choiceCmp = INSTANCE;
        if (choiceCmp.isViewModelAvailable$app_release()) {
            x xVar = f7838g;
            if (xVar == null) {
                t.w("viewModel");
                xVar = null;
            }
            if (xVar.l()) {
                x xVar2 = f7838g;
                if (xVar2 == null) {
                    t.w("viewModel");
                    xVar2 = null;
                }
                if (!xVar2.f841c.f19281b.f19228S) {
                    ChoiceCmpCallback choiceCmpCallback = f7832a;
                    if (choiceCmpCallback != null) {
                        choiceCmpCallback.onCMPUIStatusChanged(new F1.b(DisplayStatus.HIDDEN, "GDPR is disabled for US", Regulations.NA, false, 8, (C2633k) null));
                    }
                    d.c((String) null, ChoiceError.GDPR_NA.getMessage(), (Exception) null, Boolean.TRUE, 5);
                    return;
                }
            }
            choiceCmp.a(activity, true);
            return;
        }
        ChoiceCmpCallback choiceCmpCallback2 = f7832a;
        if (choiceCmpCallback2 != null) {
            choiceCmpCallback2.onCmpError(ChoiceError.MISSING_INITIALIZATION);
        }
    }

    public static final GDPRData getGDPRData(Set<Integer> set) {
        if (INSTANCE.isViewModelAvailable$app_release()) {
            return new GDPRData(set);
        }
        return null;
    }

    public static /* synthetic */ GDPRData getGDPRData$default(Set set, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            set = null;
        }
        return getGDPRData(set);
    }

    public static final NonIABData getNonIABData(Set<Integer> set) {
        boolean z4;
        LinkedHashMap linkedHashMap;
        x xVar = null;
        if (!INSTANCE.isViewModelAvailable$app_release()) {
            return null;
        }
        x xVar2 = f7838g;
        if (xVar2 == null) {
            t.w("viewModel");
        } else {
            xVar = xVar2;
        }
        a aVar = xVar.f839a;
        r4.b bVar = r4.b.TCF_GDPR_APPLIES;
        aVar.getClass();
        t.e(bVar, "preferenceKey");
        if (aVar.f25721a.getInt("IABTCF_gdprApplies", 0) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        String k5 = xVar.f839a.k(r4.b.NON_IAB_CONSENT_ENCODED);
        Map<Integer, Boolean> map = xVar.f840b.f18307A.getMap();
        if (set == null) {
            linkedHashMap = map;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                if (set.contains(next.getKey())) {
                    linkedHashMap2.put(next.getKey(), next.getValue());
                }
            }
            linkedHashMap = linkedHashMap2;
        }
        return new NonIABData(z4, false, false, k5, linkedHashMap);
    }

    public static /* synthetic */ NonIABData getNonIABData$default(Set set, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            set = null;
        }
        return getNonIABData(set);
    }

    public static final String getSDKVersion() {
        return "2.3.3";
    }

    public static final void setUserSubscriptionStatus(boolean z4) {
        f7841j = false;
        f7835d = z4;
        ChoiceCmp choiceCmp = INSTANCE;
        if (choiceCmp.isViewModelAvailable$app_release() && V2.a.e() && choiceCmp.isViewModelAvailable$app_release()) {
            a();
            if (b.f25850a && c.f25853a != null && !f7835d) {
                choiceCmp.a((Context) c.c());
            }
        }
    }

    public static final void showCCPAScreen(Activity activity) {
        t.e(activity, "activity");
        ChoiceCmp choiceCmp = INSTANCE;
        if (choiceCmp.isViewModelAvailable$app_release()) {
            x xVar = f7838g;
            if (xVar == null) {
                t.w("viewModel");
                xVar = null;
            }
            if (xVar.l()) {
                x xVar2 = f7838g;
                if (xVar2 == null) {
                    t.w("viewModel");
                    xVar2 = null;
                }
                if (xVar2.f841c.f19281b.f19237b.contains("USP")) {
                    x xVar3 = f7838g;
                    if (xVar3 == null) {
                        t.w("viewModel");
                        xVar3 = null;
                    }
                    if (xVar3.k()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("EXTRA_ACTION", "ACTION_SHOW_CCPA_SCREEN");
                        W2.J j5 = W2.J.f19942a;
                        choiceCmp.startCMPActivity$app_release(activity, bundle);
                        return;
                    }
                }
                ChoiceCmpCallback choiceCmpCallback = f7832a;
                if (choiceCmpCallback != null) {
                    choiceCmpCallback.onCMPUIStatusChanged(new F1.b(DisplayStatus.HIDDEN, "CCPA not applicable", Regulations.NA, false, 8, (C2633k) null));
                }
                d.c((String) null, ChoiceError.US_PRIVACY_NOT_APPLICABLE.getMessage(), (Exception) null, Boolean.TRUE, 5);
                return;
            }
        }
        ChoiceCmpCallback choiceCmpCallback2 = f7832a;
        if (choiceCmpCallback2 != null) {
            choiceCmpCallback2.onCMPUIStatusChanged(new F1.b(DisplayStatus.HIDDEN, "Invalid location for CCPA regulation", Regulations.NA, false, 8, (C2633k) null));
        }
        d.c((String) null, ChoiceError.INVALID_LOCATION.getMessage(), (Exception) null, Boolean.TRUE, 5);
    }

    public static final void showGBCScreen(Activity activity) {
        t.e(activity, "activity");
        ChoiceCmp choiceCmp = INSTANCE;
        if (!choiceCmp.isViewModelAvailable$app_release()) {
            ChoiceCmpCallback choiceCmpCallback = f7832a;
            if (choiceCmpCallback != null) {
                choiceCmpCallback.onCmpError(ChoiceError.MISSING_INITIALIZATION);
            }
        } else if (l.f960a) {
            Bundle bundle = new Bundle();
            bundle.putString("EXTRA_ACTION", "ACTION_SHOW_GBC_SCREEN");
            W2.J j5 = W2.J.f19942a;
            choiceCmp.startCMPActivity$app_release(activity, bundle);
        } else {
            ChoiceCmpCallback choiceCmpCallback2 = f7832a;
            if (choiceCmpCallback2 != null) {
                choiceCmpCallback2.onCMPUIStatusChanged(new F1.b(DisplayStatus.HIDDEN, "GBC not applicable", Regulations.NA, false, 8, (C2633k) null));
            }
            d.c((String) null, ChoiceError.GBC_NOT_APPLICABLE.getMessage(), (Exception) null, Boolean.TRUE, 5);
        }
    }

    public static final void showUSRegulationScreen(Activity activity) {
        t.e(activity, "activity");
        ChoiceCmp choiceCmp = INSTANCE;
        x xVar = null;
        if (choiceCmp.isViewModelAvailable$app_release()) {
            x xVar2 = f7838g;
            if (xVar2 == null) {
                t.w("viewModel");
                xVar2 = null;
            }
            if (xVar2.l()) {
                x xVar3 = f7838g;
                if (xVar3 == null) {
                    t.w("viewModel");
                    xVar3 = null;
                }
                if (xVar3.o()) {
                    x xVar4 = f7838g;
                    if (xVar4 == null) {
                        t.w("viewModel");
                    } else {
                        xVar = xVar4;
                    }
                    if (!xVar.k()) {
                        R3.j.c(c.h());
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("EXTRA_ACTION", "ACTION_SHOW_US_REGULATION_SCREEN");
                    bundle.putBoolean("EXTRA_FORCE", true);
                    W2.J j5 = W2.J.f19942a;
                    choiceCmp.startCMPActivity$app_release(activity, bundle);
                    return;
                }
                ChoiceCmpCallback choiceCmpCallback = f7832a;
                if (choiceCmpCallback != null) {
                    choiceCmpCallback.onCMPUIStatusChanged(new F1.b(DisplayStatus.HIDDEN, "US regulations not applicable", Regulations.NA, false, 8, (C2633k) null));
                }
                d.c((String) null, ChoiceError.US_PRIVACY_NOT_APPLICABLE.getMessage(), (Exception) null, Boolean.TRUE, 5);
                return;
            }
        }
        ChoiceCmpCallback choiceCmpCallback2 = f7832a;
        if (choiceCmpCallback2 != null) {
            choiceCmpCallback2.onCMPUIStatusChanged(new F1.b(DisplayStatus.HIDDEN, "Invalid location for US regulations", Regulations.NA, false, 8, (C2633k) null));
        }
        d.c((String) null, ChoiceError.INVALID_LOCATION.getMessage(), (Exception) null, Boolean.TRUE, 5);
    }

    public static final void startChoice(Application application, String str, String str2, ChoiceCmpCallback choiceCmpCallback, ChoiceStyle choiceStyle) {
        Typeface typeface;
        Typeface typeface2;
        B b5;
        C2711f fVar;
        C2708c cVar;
        o4.t tVar;
        v vVar;
        r rVar;
        Application application2 = application;
        String str3 = str;
        String str4 = str2;
        ChoiceCmpCallback choiceCmpCallback2 = choiceCmpCallback;
        ChoiceStyle choiceStyle2 = choiceStyle;
        t.e(application2, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        t.e(str3, "packageId");
        t.e(str4, "pCode");
        t.e(choiceCmpCallback2, "callback");
        t.e(choiceStyle2, "choiceStyle");
        f7832a = choiceCmpCallback2;
        f7833b = str3;
        ChoiceCmp choiceCmp = INSTANCE;
        choiceCmp.getClass();
        Matcher matcher = f7842k.matcher(str4);
        String group = matcher.matches() ? matcher.group(2) : null;
        if (group == null) {
            ChoiceCmpCallback choiceCmpCallback3 = f7832a;
            if (choiceCmpCallback3 != null) {
                choiceCmpCallback3.onCmpError(ChoiceError.INVALID_PCODE);
            }
            group = null;
        }
        if (group == null) {
            group = null;
        }
        if (group != null) {
            f7834c = group;
            Application application3 = c.f25853a;
            t.e(application2, "<set-?>");
            c.f25853a = application2;
            t.e(choiceStyle2, "resources");
            c.f25855c = choiceStyle2;
            Integer boldFont = choiceStyle2.getBoldFont();
            if (boldFont == null) {
                typeface = null;
            } else {
                typeface = ResourcesCompat.getFont(c.c(), boldFont.intValue());
            }
            Integer regularFont = choiceStyle2.getRegularFont();
            if (regularFont == null) {
                typeface2 = null;
            } else {
                typeface2 = ResourcesCompat.getFont(c.c(), regularFont.intValue());
            }
            c.f25856d = new m4.c(typeface, typeface2);
            if (f7838g == null) {
                a l5 = c.l();
                u m5 = c.m();
                i j5 = c.j();
                if (c.f25869q == null) {
                    c.f25869q = new B(c.c(), c.i(), c.a(), c.l(), c.k(), new m(c.a()));
                }
                B b6 = c.f25869q;
                if (b6 == null) {
                    t.w("gvlRepository_");
                    b5 = null;
                } else {
                    b5 = b6;
                }
                if (c.f25870r == null) {
                    c.f25870r = new C2711f(c.i(), c.l(), c.k(), new q4.b(c.c(), c.a()));
                }
                C2711f fVar2 = c.f25870r;
                if (fVar2 == null) {
                    t.w("cmpRepository_");
                    fVar = null;
                } else {
                    fVar = fVar2;
                }
                if (c.f25873u == null) {
                    n4.a i5 = c.i();
                    a l6 = c.l();
                    h k5 = c.k();
                    ChoiceCmpCallback callback = choiceCmp.getCallback();
                    if (c.f25868p == null) {
                        c.f25868p = new q4.c();
                    }
                    q4.c cVar2 = c.f25868p;
                    if (cVar2 == null) {
                        t.w("coreUiLabelsResolver");
                        cVar2 = null;
                    }
                    c.f25873u = new C2708c(i5, l6, k5, new q4.k(callback, cVar2), choiceCmp.getAppPackageId(), choiceCmp.getPCode());
                }
                C2708c cVar3 = c.f25873u;
                if (cVar3 == null) {
                    t.w("portalConfigRepository_");
                    cVar = null;
                } else {
                    cVar = cVar3;
                }
                o4.k o5 = c.o();
                if (c.f25875w == null) {
                    c.f25875w = new o4.t(c.i(), c.k(), new f());
                }
                o4.t tVar2 = c.f25875w;
                if (tVar2 == null) {
                    t.w("geoIPRepository_");
                    tVar = null;
                } else {
                    tVar = tVar2;
                }
                if (c.f25876x == null) {
                    c.f25876x = new v(c.i(), c.l(), c.k(), new g());
                }
                v vVar2 = c.f25876x;
                if (vVar2 == null) {
                    t.w("googleVendorsRepository_");
                    vVar = null;
                } else {
                    vVar = vVar2;
                }
                if (c.f25851A == null) {
                    c.f25851A = new r(c.a(), c.i(), c.l(), c.k(), new e());
                }
                r rVar2 = c.f25851A;
                if (rVar2 == null) {
                    t.w("gbcRepository");
                    rVar = null;
                } else {
                    rVar = rVar2;
                }
                f7838g = new x(l5, m5, j5, b5, fVar, cVar, o5, tVar, vVar, rVar, c.d(), c.f());
                M m6 = f7839h;
                if (m6 == null) {
                    m6 = N.a(T0.b((C2908y0) null, 1, (Object) null));
                }
                M m7 = m6;
                f7839h = m7;
                if (m7 != null) {
                    C2908y0 unused = C2876i.d(m7, f7840i, (O) null, new n((C2308e) null), 2, (Object) null);
                }
            }
            b.m mVar = new b.m();
            t.e(application2, MimeTypes.BASE_TYPE_APPLICATION);
            t.e(mVar, "applicationLifecycleCallback");
            application2.registerActivityLifecycleCallbacks(new s4.a(mVar));
            application2.registerActivityLifecycleCallbacks(new b.a());
        }
    }

    public static /* synthetic */ void startChoice$default(Application application, String str, String str2, ChoiceCmpCallback choiceCmpCallback, ChoiceStyle choiceStyle, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            choiceStyle = new ChoiceStyle();
        }
        startChoice(application, str, str2, choiceCmpCallback, choiceStyle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0121, code lost:
        if (kotlin.jvm.internal.t.a(r7, l4.e.b(r11.toString())) == false) goto L_0x0126;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0244  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            b.x r2 = f7838g
            java.lang.String r3 = "viewModel"
            r4 = 0
            if (r2 != 0) goto L_0x000f
            kotlin.jvm.internal.t.w(r3)
            r2 = r4
        L_0x000f:
            boolean r2 = r2.l()
            r5 = 0
            if (r2 == 0) goto L_0x0328
            boolean r2 = r0.isViewModelAvailable$app_release()
            r6 = 5
            if (r2 == 0) goto L_0x02de
            b.x r2 = f7838g
            if (r2 != 0) goto L_0x0025
            kotlin.jvm.internal.t.w(r3)
            r2 = r4
        L_0x0025:
            boolean r2 = r2.o()
            if (r2 == 0) goto L_0x02de
            R3.h r2 = R3.e.b()
            r4.a r7 = R3.e.a()
            r4.b r8 = r4.b.SAVED_REGION
            java.lang.String r7 = r7.k(r8)
            R3.h r7 = R3.j.a(r7)
            boolean r8 = R3.e.c()
            if (r8 == 0) goto L_0x004a
            J2.i r8 = R3.e.f18984f
            J2.i r9 = J2.i.NATIONAL
            if (r8 != r9) goto L_0x004a
            goto L_0x00b0
        L_0x004a:
            boolean r8 = R3.e.c()
            if (r8 == 0) goto L_0x005b
            J2.i r8 = R3.e.f18984f
            J2.i r9 = J2.i.STATE_AND_NATIONAL
            if (r8 != r9) goto L_0x005b
            R3.h r8 = R3.h.f19013p
            if (r2 != r8) goto L_0x005b
            goto L_0x00b0
        L_0x005b:
            r4.a r8 = R3.e.a()
            r4.b r9 = r4.b.SAVED_MSPA_JURISDICTION
            java.lang.String r8 = r8.k(r9)
            java.lang.String r10 = "STATE_AND_NATIONAL"
            boolean r8 = kotlin.jvm.internal.t.a(r8, r10)
            if (r8 == 0) goto L_0x0078
            J2.i r8 = R3.e.f18984f
            J2.i r11 = J2.i.NATIONAL
            if (r8 != r11) goto L_0x0078
            R3.h r8 = R3.h.f19013p
            if (r7 != r8) goto L_0x0078
            goto L_0x00b0
        L_0x0078:
            r4.a r8 = R3.e.a()
            java.lang.String r8 = r8.k(r9)
            boolean r8 = kotlin.jvm.internal.t.a(r8, r10)
            if (r8 == 0) goto L_0x008f
            J2.i r8 = R3.e.f18984f
            J2.i r11 = J2.i.STATE_AND_NATIONAL
            if (r8 != r11) goto L_0x008f
            if (r7 != r2) goto L_0x008f
            goto L_0x00b0
        L_0x008f:
            r4.a r2 = R3.e.a()
            java.lang.String r2 = r2.k(r9)
            boolean r2 = kotlin.jvm.internal.t.a(r2, r10)
            if (r2 != 0) goto L_0x00a4
            boolean r2 = R3.e.c()
            if (r2 != 0) goto L_0x00a4
            goto L_0x00b0
        L_0x00a4:
            com.inmobi.cmp.ChoiceCmp r2 = INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r2 = r2.getCallback()
            if (r2 != 0) goto L_0x00ad
            goto L_0x00b0
        L_0x00ad:
            r2.onUserMovedToOtherState()
        L_0x00b0:
            b.x r2 = f7838g
            if (r2 != 0) goto L_0x00b8
            kotlin.jvm.internal.t.w(r3)
            r2 = r4
        L_0x00b8:
            T3.i r7 = r2.f841c
            T3.c r7 = r7.f19281b
            java.lang.String r8 = "coreConfig"
            kotlin.jvm.internal.t.e(r7, r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r7.f19219J
            r9.append(r10)
            java.util.List r10 = r7.f19223N
            r9.append(r10)
            java.util.List r7 = r7.f19224O
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.String r7 = l4.e.b(r7)
            r4.a r9 = r2.f839a
            r4.b r10 = r4.b.MSPA_PURPOSE_HASH
            java.lang.String r9 = r9.k(r10)
            boolean r7 = kotlin.jvm.internal.t.a(r7, r9)
            r9 = 1
            if (r7 == 0) goto L_0x0126
            boolean r7 = r2.m()
            if (r7 == 0) goto L_0x0124
            r4.a r7 = r2.f839a
            r4.b r11 = r4.b.GBC_PURPOSE_HASH
            java.lang.String r7 = r7.k(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            T3.i r12 = r2.f841c
            T3.c r12 = r12.f19281b
            T3.f r12 = r12.f19232W
            java.util.List r12 = r12.f19269c
            r11.append(r12)
            T3.i r12 = r2.f841c
            T3.c r12 = r12.f19281b
            T3.f r12 = r12.f19232W
            boolean r12 = r12.f19267a
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.String r11 = l4.e.b(r11)
            boolean r7 = kotlin.jvm.internal.t.a(r7, r11)
            if (r7 != 0) goto L_0x0124
            goto L_0x0126
        L_0x0124:
            r2 = r5
            goto L_0x018d
        L_0x0126:
            boolean r7 = r2.m()
            if (r7 == 0) goto L_0x0156
            r4.a r7 = r2.f839a
            r4.b r11 = r4.b.GBC_PURPOSE_HASH
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            T3.i r13 = r2.f841c
            T3.c r13 = r13.f19281b
            T3.f r13 = r13.f19232W
            java.util.List r13 = r13.f19269c
            r12.append(r13)
            T3.i r13 = r2.f841c
            T3.c r13 = r13.f19281b
            T3.f r13 = r13.f19232W
            boolean r13 = r13.f19267a
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.String r12 = l4.e.b(r12)
            r7.i(r11, r12)
        L_0x0156:
            r4.a r7 = r2.f839a
            T3.i r11 = r2.f841c
            T3.c r11 = r11.f19281b
            kotlin.jvm.internal.t.e(r11, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r12 = r11.f19219J
            r8.append(r12)
            java.util.List r12 = r11.f19223N
            r8.append(r12)
            java.util.List r11 = r11.f19224O
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = l4.e.b(r8)
            r7.i(r10, r8)
            r4.a r7 = r2.f839a
            r4.b r8 = r4.b.MSPA_PURPOSE_CONSENT
            r7.e(r8)
            r4.a r2 = r2.f839a
            r4.b r7 = r4.b.MSPA_SENSITIVE_PURPOSE_CONSENT
            r2.e(r7)
            r2 = r9
        L_0x018d:
            b.x r7 = f7838g
            if (r7 != 0) goto L_0x0195
            kotlin.jvm.internal.t.w(r3)
            r7 = r4
        L_0x0195:
            T3.i r7 = r7.f841c
            T3.c r7 = r7.f19281b
            boolean r7 = r7.f19227R
            b.x r8 = f7838g
            if (r8 != 0) goto L_0x01a3
            kotlin.jvm.internal.t.w(r3)
            r8 = r4
        L_0x01a3:
            T3.i r8 = r8.f841c
            T3.c r8 = r8.f19281b
            T3.d r8 = r8.f19231V
            java.lang.Boolean r8 = r8.f19262a
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            boolean r8 = kotlin.jvm.internal.t.a(r8, r10)
            if (r8 == 0) goto L_0x0236
            b.x r8 = f7838g
            if (r8 != 0) goto L_0x01bb
            kotlin.jvm.internal.t.w(r3)
            r8 = r4
        L_0x01bb:
            boolean r8 = r8.t()
            if (r8 == 0) goto L_0x0236
            b.x r8 = f7838g
            if (r8 != 0) goto L_0x01c9
            kotlin.jvm.internal.t.w(r3)
            r8 = r4
        L_0x01c9:
            boolean r8 = r8.k()
            java.lang.String r11 = "regulation"
            if (r8 == 0) goto L_0x0200
            java.util.UUID r8 = k4.z.f24676a
            k4.h r8 = k4.h.CCPA
            b.x r9 = f7838g
            if (r9 != 0) goto L_0x01dd
            kotlin.jvm.internal.t.w(r3)
            r9 = r4
        L_0x01dd:
            r9.getClass()
            kotlin.jvm.internal.t.e(r8, r11)
            r4.a r9 = r9.f839a
            java.lang.String r9 = V2.a.a(r8, r9)
            kotlin.jvm.internal.t.e(r8, r11)
            w3.s0 r12 = w3.C2896s0.f26313a
            w3.I r13 = w3.C2865c0.b()
            k4.x r15 = new k4.x
            r15.<init>(r9, r8, r5, r4)
            r16 = 2
            r17 = 0
            r14 = 0
            w3.C2908y0 unused = w3.C2876i.d(r12, r13, r14, r15, r16, r17)
            goto L_0x0236
        L_0x0200:
            if (r2 == 0) goto L_0x0205
            if (r7 == 0) goto L_0x0205
            goto L_0x0206
        L_0x0205:
            r9 = r5
        L_0x0206:
            java.util.UUID r8 = k4.z.f24676a
            k4.h r8 = k4.h.MSPA
            b.x r12 = f7838g
            if (r12 != 0) goto L_0x0212
            kotlin.jvm.internal.t.w(r3)
            r12 = r4
        L_0x0212:
            r12.getClass()
            kotlin.jvm.internal.t.e(r8, r11)
            r4.a r12 = r12.f839a
            java.lang.String r12 = V2.a.a(r8, r12)
            kotlin.jvm.internal.t.e(r8, r11)
            w3.s0 r13 = w3.C2896s0.f26313a
            w3.I r14 = w3.C2865c0.b()
            k4.x r11 = new k4.x
            r11.<init>(r12, r8, r9, r4)
            r17 = 2
            r18 = 0
            r15 = 0
            r16 = r11
            w3.C2908y0 unused = w3.C2876i.d(r13, r14, r15, r16, r17, r18)
        L_0x0236:
            b.x r8 = f7838g
            if (r8 != 0) goto L_0x023e
            kotlin.jvm.internal.t.w(r3)
            r8 = r4
        L_0x023e:
            boolean r8 = r8.k()
            if (r8 != 0) goto L_0x02a5
            R3.a r3 = s4.c.h()
            R3.j.c(r3)
            if (r7 == 0) goto L_0x0266
            if (r2 == 0) goto L_0x0266
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = "EXTRA_ACTION"
            java.lang.String r4 = "ACTION_SHOW_US_REGULATION_SCREEN"
            r2.putString(r3, r4)
            java.lang.String r3 = "EXTRA_FORCE"
            r2.putBoolean(r3, r5)
            W2.J r3 = W2.J.f19942a
            r0.startCMPActivity$app_release(r1, r2)
            return
        L_0x0266:
            if (r2 != 0) goto L_0x0283
            com.inmobi.cmp.model.ChoiceError r1 = com.inmobi.cmp.model.ChoiceError.US_REGULATION_NO_RE_TRIGGER
            com.inmobi.cmp.ChoiceCmpCallback r2 = f7832a
            if (r2 != 0) goto L_0x026f
            goto L_0x029d
        L_0x026f:
            F1.b r11 = new F1.b
            com.inmobi.cmp.core.cmpapi.status.DisplayStatus r12 = com.inmobi.cmp.core.cmpapi.status.DisplayStatus.HIDDEN
            com.inmobi.cmp.model.Regulations r14 = com.inmobi.cmp.model.Regulations.NA
            r16 = 8
            r17 = 0
            java.lang.String r13 = "MSPA is applicable but no need to re-trigger the screen"
            r15 = 0
            r11.<init>(r12, r13, r14, r15, r16, r17)
            r2.onCMPUIStatusChanged(r11)
            goto L_0x029d
        L_0x0283:
            com.inmobi.cmp.model.ChoiceError r1 = com.inmobi.cmp.model.ChoiceError.AUTO_POPUP_DISABLED
            com.inmobi.cmp.ChoiceCmpCallback r2 = f7832a
            if (r2 != 0) goto L_0x028a
            goto L_0x029d
        L_0x028a:
            F1.b r11 = new F1.b
            com.inmobi.cmp.core.cmpapi.status.DisplayStatus r12 = com.inmobi.cmp.core.cmpapi.status.DisplayStatus.HIDDEN
            com.inmobi.cmp.model.Regulations r14 = com.inmobi.cmp.model.Regulations.NA
            r16 = 8
            r17 = 0
            java.lang.String r13 = "Auto pop-up is disabled so no dialog will be shown"
            r15 = 0
            r11.<init>(r12, r13, r14, r15, r16, r17)
            r2.onCMPUIStatusChanged(r11)
        L_0x029d:
            java.lang.String r1 = r1.getMessage()
            H2.d.c(r4, r1, r4, r10, r6)
            return
        L_0x02a5:
            b.x r1 = f7838g
            if (r1 != 0) goto L_0x02ad
            kotlin.jvm.internal.t.w(r3)
            r1 = r4
        L_0x02ad:
            T3.i r1 = r1.f841c
            T3.c r1 = r1.f19281b
            boolean r1 = r1.f19227R
            if (r1 == 0) goto L_0x02bb
            com.inmobi.cmp.model.ChoiceError r1 = com.inmobi.cmp.model.ChoiceError.AUTO_POP_NOT_APPLICABLE
            java.lang.String r2 = "Auto pop-up is not applicable for this region as CCPA is enabled"
        L_0x02b9:
            r13 = r2
            goto L_0x02c0
        L_0x02bb:
            com.inmobi.cmp.model.ChoiceError r1 = com.inmobi.cmp.model.ChoiceError.AUTO_POPUP_DISABLED_AND_NOT_APPLICABLE
            java.lang.String r2 = "Auto pop-up is disabled and not applicable for this region because CCPA is enabled for this region"
            goto L_0x02b9
        L_0x02c0:
            com.inmobi.cmp.ChoiceCmpCallback r2 = f7832a
            if (r2 != 0) goto L_0x02c5
            goto L_0x02d6
        L_0x02c5:
            F1.b r11 = new F1.b
            com.inmobi.cmp.core.cmpapi.status.DisplayStatus r12 = com.inmobi.cmp.core.cmpapi.status.DisplayStatus.HIDDEN
            com.inmobi.cmp.model.Regulations r14 = com.inmobi.cmp.model.Regulations.NA
            r16 = 8
            r17 = 0
            r15 = 0
            r11.<init>(r12, r13, r14, r15, r16, r17)
            r2.onCMPUIStatusChanged(r11)
        L_0x02d6:
            java.lang.String r1 = r1.getMessage()
            H2.d.c(r4, r1, r4, r10, r6)
            return
        L_0x02de:
            b.x r1 = f7838g
            if (r1 != 0) goto L_0x02e6
            kotlin.jvm.internal.t.w(r3)
            r1 = r4
        L_0x02e6:
            T3.i r1 = r1.f841c
            T3.c r1 = r1.f19281b
            T3.d r1 = r1.f19231V
            java.lang.Boolean r1 = r1.f19262a
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.t.a(r1, r2)
            if (r1 == 0) goto L_0x0307
            b.x r1 = f7838g
            if (r1 != 0) goto L_0x02fe
            kotlin.jvm.internal.t.w(r3)
            r1 = r4
        L_0x02fe:
            boolean r1 = r1.t()
            if (r1 == 0) goto L_0x0307
            r0.sendNRVisitEvent$app_release()
        L_0x0307:
            com.inmobi.cmp.ChoiceCmpCallback r1 = f7832a
            if (r1 != 0) goto L_0x030c
            goto L_0x031e
        L_0x030c:
            F1.b r7 = new F1.b
            com.inmobi.cmp.core.cmpapi.status.DisplayStatus r8 = com.inmobi.cmp.core.cmpapi.status.DisplayStatus.HIDDEN
            com.inmobi.cmp.model.Regulations r10 = com.inmobi.cmp.model.Regulations.NA
            r12 = 8
            r13 = 0
            java.lang.String r9 = "US regulations not applicable"
            r11 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r1.onCMPUIStatusChanged(r7)
        L_0x031e:
            com.inmobi.cmp.model.ChoiceError r1 = com.inmobi.cmp.model.ChoiceError.US_PRIVACY_NOT_APPLICABLE
            java.lang.String r1 = r1.getMessage()
            H2.d.c(r4, r1, r4, r2, r6)
            return
        L_0x0328:
            r0.a(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.a(android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r8 == r1) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        if (r8.h(r0) != r1) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(b3.C2308e r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof b.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            b.c r0 = (b.c) r0
            int r1 = r0.f801c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f801c = r1
            goto L_0x0018
        L_0x0013:
            b.c r0 = new b.c
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f799a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f801c
            java.lang.String r3 = "viewModel"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003b
            if (r2 == r5) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            W2.u.b(r8)
            goto L_0x0085
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0037:
            W2.u.b(r8)
            goto L_0x005b
        L_0x003b:
            W2.u.b(r8)
            b.x r8 = f7838g
            if (r8 != 0) goto L_0x0046
            kotlin.jvm.internal.t.w(r3)
            r8 = r6
        L_0x0046:
            r0.f801c = r5
            r8.getClass()
            w3.I r2 = w3.C2865c0.b()
            b.r r5 = new b.r
            r5.<init>(r8, r6)
            java.lang.Object r8 = w3.C2872g.g(r2, r5, r0)
            if (r8 != r1) goto L_0x005b
            goto L_0x0084
        L_0x005b:
            R2.c r8 = (R2.c) r8
            android.app.Application r2 = s4.c.f25853a
            java.lang.String r2 = "gbcPurpose"
            kotlin.jvm.internal.t.e(r8, r2)
            s4.c.f25863k = r8
            b.x r8 = f7838g
            if (r8 != 0) goto L_0x006e
            kotlin.jvm.internal.t.w(r3)
            goto L_0x006f
        L_0x006e:
            r6 = r8
        L_0x006f:
            r6.getClass()
            boolean r8 = m.l.f960a
            boolean r8 = r6.m()
            m.l.f960a = r8
            com.inmobi.cmp.ChoiceCmp r8 = INSTANCE
            r0.f801c = r4
            java.lang.Object r8 = r8.h(r0)
            if (r8 != r1) goto L_0x0085
        L_0x0084:
            return r1
        L_0x0085:
            W2.J r8 = W2.J.f19942a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.b(b3.e):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (r8 == r1) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0094, code lost:
        if (r8.g(r0) != r1) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(b3.C2308e r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof b.d
            if (r0 == 0) goto L_0x0013
            r0 = r8
            b.d r0 = (b.d) r0
            int r1 = r0.f804c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f804c = r1
            goto L_0x0018
        L_0x0013:
            b.d r0 = new b.d
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f802a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f804c
            java.lang.String r3 = "viewModel"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 == r5) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            W2.u.b(r8)
            goto L_0x0097
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0038:
            W2.u.b(r8)
            goto L_0x005c
        L_0x003c:
            W2.u.b(r8)
            b.x r8 = f7838g
            if (r8 != 0) goto L_0x0047
            kotlin.jvm.internal.t.w(r3)
            r8 = r6
        L_0x0047:
            r0.f804c = r5
            r8.getClass()
            w3.I r2 = w3.C2865c0.b()
            b.s r5 = new b.s
            r5.<init>(r8, r6)
            java.lang.Object r8 = w3.C2872g.g(r2, r5, r0)
            if (r8 != r1) goto L_0x005c
            goto L_0x0096
        L_0x005c:
            U2.c r8 = (U2.c) r8
            b.x r2 = f7838g
            if (r2 != 0) goto L_0x0066
            kotlin.jvm.internal.t.w(r3)
            r2 = r6
        L_0x0066:
            r2.f853o = r8
            android.app.Application r2 = s4.c.f25853a
            if (r8 != 0) goto L_0x006e
            r2 = r6
            goto L_0x0070
        L_0x006e:
            java.lang.String r2 = r8.f19304b
        L_0x0070:
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0075
            r2 = r3
        L_0x0075:
            java.lang.String r5 = "region"
            kotlin.jvm.internal.t.e(r2, r5)
            s4.c.f25865m = r2
            if (r8 != 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            java.lang.String r6 = r8.f19303a
        L_0x0081:
            if (r6 != 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r3 = r6
        L_0x0085:
            java.lang.String r8 = "country"
            kotlin.jvm.internal.t.e(r3, r8)
            s4.c.f25866n = r3
            com.inmobi.cmp.ChoiceCmp r8 = INSTANCE
            r0.f804c = r4
            java.lang.Object r8 = r8.g(r0)
            if (r8 != r1) goto L_0x0097
        L_0x0096:
            return r1
        L_0x0097:
            W2.J r8 = W2.J.f19942a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.c(b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(b3.C2308e r19) {
        /*
            r18 = this;
            r0 = r19
            boolean r1 = r0 instanceof b.e
            if (r1 == 0) goto L_0x0017
            r1 = r0
            b.e r1 = (b.e) r1
            int r2 = r1.f807c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f807c = r2
            r2 = r18
            goto L_0x001e
        L_0x0017:
            b.e r1 = new b.e
            r2 = r18
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.f805a
            java.lang.Object r3 = c3.C2316b.f()
            int r4 = r1.f807c
            java.lang.String r5 = "viewModel"
            r6 = 0
            r7 = 1
            r8 = 2
            if (r4 == 0) goto L_0x0042
            if (r4 == r7) goto L_0x003e
            if (r4 != r8) goto L_0x0036
            W2.u.b(r0)
            goto L_0x0361
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003e:
            W2.u.b(r0)
            goto L_0x006f
        L_0x0042:
            W2.u.b(r0)
            b.x r0 = f7838g
            if (r0 != 0) goto L_0x004d
            kotlin.jvm.internal.t.w(r5)
            r0 = r6
        L_0x004d:
            r1.f807c = r7
            T3.i r4 = r0.f841c
            T3.c r4 = r4.f19281b
            boolean r4 = r4.f19248m
            if (r4 == 0) goto L_0x0065
            w3.I r4 = w3.C2865c0.b()
            b.t r9 = new b.t
            r9.<init>(r0, r6)
            java.lang.Object r0 = w3.C2872g.g(r4, r9, r1)
            goto L_0x006a
        L_0x0065:
            J2.f r0 = new J2.f
            r0.<init>()
        L_0x006a:
            if (r0 != r3) goto L_0x006f
            r1 = r3
            goto L_0x0360
        L_0x006f:
            J2.f r0 = (J2.f) r0
            b.x r4 = f7838g
            if (r4 != 0) goto L_0x0079
            kotlin.jvm.internal.t.w(r5)
            goto L_0x007a
        L_0x0079:
            r6 = r4
        L_0x007a:
            r6.getClass()
            java.lang.String r4 = "googleVendorList"
            kotlin.jvm.internal.t.e(r0, r4)
            r6.f852n = r0
            T3.i r0 = r6.f841c
            T3.j r0 = r0.f19280a
            java.util.List r0 = r0.f19290c
            boolean r4 = r0.isEmpty()
            java.lang.String r5 = "<set-?>"
            if (r4 != 0) goto L_0x00fe
            java.lang.Object r4 = X2.C2250q.M(r0)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            if (r4 != r7) goto L_0x009f
            goto L_0x00fe
        L_0x009f:
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x00ba
            java.lang.Object r4 = X2.C2250q.M(r0)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r7 = -1
            if (r4 != r7) goto L_0x00ba
            J2.f r0 = r6.f852n
            java.util.Map r0 = r0.f18273a
            r0.clear()
            goto L_0x00fe
        L_0x00ba:
            J2.f r4 = r6.f852n
            java.util.Map r7 = r4.f18273a
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x00cb:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x00f5
            java.lang.Object r10 = r7.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r11 = r10.getValue()
            J2.g r11 = (J2.g) r11
            int r11 = r11.f18274a
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r0.contains(r11)
            if (r11 == 0) goto L_0x00cb
            java.lang.Object r11 = r10.getKey()
            java.lang.Object r10 = r10.getValue()
            r9.put(r11, r10)
            goto L_0x00cb
        L_0x00f5:
            java.util.Map r0 = X2.M.v(r9)
            kotlin.jvm.internal.t.e(r0, r5)
            r4.f18273a = r0
        L_0x00fe:
            J2.f r0 = r6.f852n
            java.util.Map r0 = r0.f18273a
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x010a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x020e
            java.lang.Object r4 = r0.next()
            J2.g r4 = (J2.g) r4
            r4.a r7 = r6.f839a
            r4.b r9 = r4.b.ADDTL_CONSENT
            java.lang.String r7 = r7.k(r9)
            java.lang.String r9 = "acString"
            kotlin.jvm.internal.t.e(r7, r9)
            int r9 = r7.length()
            if (r9 > r8) goto L_0x012e
            java.util.Set r7 = X2.T.d()
            goto L_0x0170
        L_0x012e:
            java.lang.String r9 = r7.substring(r8)
            java.lang.String r7 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.t.d(r9, r7)
            java.lang.String r7 = "."
            java.lang.String[] r10 = new java.lang.String[]{r7}
            r13 = 6
            r14 = 0
            r11 = 0
            r12 = 0
            java.util.List r7 = t3.s.G0(r9, r10, r11, r12, r13, r14)
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = 10
            int r10 = X2.C2250q.p(r7, r10)
            r9.<init>(r10)
            java.util.Iterator r7 = r7.iterator()
        L_0x0154:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x016c
            java.lang.Object r10 = r7.next()
            java.lang.String r10 = (java.lang.String) r10
            int r10 = java.lang.Integer.parseInt(r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9.add(r10)
            goto L_0x0154
        L_0x016c:
            java.util.Set r7 = X2.C2250q.r0(r9)
        L_0x0170:
            int r9 = r4.f18274a
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            boolean r7 = r7.contains(r9)
            if (r7 == 0) goto L_0x0200
            java.lang.String r7 = r4.f18275b
            java.lang.String r9 = r4.f18276c
            java.util.LinkedHashSet r10 = new java.util.LinkedHashSet
            r10.<init>()
            java.util.LinkedHashSet r11 = new java.util.LinkedHashSet
            r11.<init>()
            java.util.LinkedHashSet r12 = new java.util.LinkedHashSet
            r12.<init>()
            java.util.LinkedHashSet r13 = new java.util.LinkedHashSet
            r13.<init>()
            java.util.LinkedHashSet r14 = new java.util.LinkedHashSet
            r14.<init>()
            java.util.LinkedHashSet r15 = new java.util.LinkedHashSet
            r15.<init>()
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            r16 = r0
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.lang.String r2 = "name"
            kotlin.jvm.internal.t.e(r7, r2)
            r17 = r3
            java.lang.String r3 = "purposes"
            kotlin.jvm.internal.t.e(r10, r3)
            java.lang.String r3 = "legIntPurposes"
            kotlin.jvm.internal.t.e(r11, r3)
            java.lang.String r3 = "flexiblePurposes"
            kotlin.jvm.internal.t.e(r12, r3)
            java.lang.String r3 = "specialPurposes"
            kotlin.jvm.internal.t.e(r13, r3)
            java.lang.String r3 = "features"
            kotlin.jvm.internal.t.e(r14, r3)
            java.lang.String r3 = "specialFeatures"
            kotlin.jvm.internal.t.e(r15, r3)
            java.lang.String r3 = "policyUrl"
            kotlin.jvm.internal.t.e(r9, r3)
            java.lang.String r3 = "dataDeclaration"
            kotlin.jvm.internal.t.e(r8, r3)
            java.lang.String r3 = "urls"
            kotlin.jvm.internal.t.e(r0, r3)
            java.lang.String r0 = "deviceStorageDisclosureUrl"
            java.lang.String r3 = ""
            kotlin.jvm.internal.t.e(r3, r0)
            kotlin.jvm.internal.t.e(r7, r2)
            boolean r0 = r6.d(r10)
            if (r0 == 0) goto L_0x0204
            J2.u r0 = r6.f840b
            com.inmobi.cmp.core.model.Vector r0 = r0.f18308B
            int r2 = r4.f18274a
            r0.set((int) r2)
        L_0x01f7:
            r2 = r18
            r0 = r16
            r3 = r17
            r8 = 2
            goto L_0x010a
        L_0x0200:
            r16 = r0
            r17 = r3
        L_0x0204:
            J2.u r0 = r6.f840b
            com.inmobi.cmp.core.model.Vector r0 = r0.f18308B
            int r2 = r4.f18274a
            r0.unset((int) r2)
            goto L_0x01f7
        L_0x020e:
            r17 = r3
            T3.i r0 = r6.f841c
            T3.j r0 = r0.f19280a
            java.util.List r0 = r0.f19288a
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0267
            J2.u r2 = r6.f840b
            P3.d r2 = r2.f18314a
            if (r2 != 0) goto L_0x0224
            goto L_0x02bc
        L_0x0224:
            java.util.Map r3 = r2.f18877i
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0233:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x025d
            java.lang.Object r7 = r3.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getValue()
            P3.k r8 = (P3.k) r8
            int r8 = r8.f18881a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r0.contains(r8)
            if (r8 != 0) goto L_0x0233
            java.lang.Object r8 = r7.getKey()
            java.lang.Object r7 = r7.getValue()
            r4.put(r8, r7)
            goto L_0x0233
        L_0x025d:
            java.util.Map r0 = X2.M.v(r4)
            kotlin.jvm.internal.t.e(r0, r5)
            r2.f18877i = r0
            goto L_0x02bc
        L_0x0267:
            T3.i r0 = r6.f841c
            T3.j r0 = r0.f19280a
            java.util.List r0 = r0.f19289b
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x02bc
            J2.u r2 = r6.f840b
            P3.d r2 = r2.f18314a
            if (r2 != 0) goto L_0x027a
            goto L_0x02bc
        L_0x027a:
            java.util.Map r3 = r2.f18877i
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0289:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x02b3
            java.lang.Object r7 = r3.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getValue()
            P3.k r8 = (P3.k) r8
            int r8 = r8.f18881a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r0.contains(r8)
            if (r8 == 0) goto L_0x0289
            java.lang.Object r8 = r7.getKey()
            java.lang.Object r7 = r7.getValue()
            r4.put(r8, r7)
            goto L_0x0289
        L_0x02b3:
            java.util.Map r0 = X2.M.v(r4)
            kotlin.jvm.internal.t.e(r0, r5)
            r2.f18877i = r0
        L_0x02bc:
            J2.u r0 = r6.f840b
            P3.d r0 = r0.f18314a
            if (r0 != 0) goto L_0x02c4
            goto L_0x0353
        L_0x02c4:
            java.util.Map r0 = r0.f18877i
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x02ce:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0353
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            P3.k r3 = (P3.k) r3
            java.util.Set r3 = r3.f18890f
            java.util.Iterator r3 = r3.iterator()
        L_0x02e6:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02ce
            java.lang.Object r4 = r3.next()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            T3.i r5 = r6.f841c
            T3.c r5 = r5.f19281b
            java.util.List r5 = r5.f19259x
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x0324
            java.lang.Object r5 = r2.getValue()
            P3.k r5 = (P3.k) r5
            java.util.Set r5 = r5.f18888d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r5.add(r7)
            java.lang.Object r5 = r2.getValue()
            P3.k r5 = (P3.k) r5
            java.util.Set r5 = r5.f18889e
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r5.remove(r7)
        L_0x0324:
            T3.i r5 = r6.f841c
            T3.c r5 = r5.f19281b
            java.util.List r5 = r5.f19260y
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x02e6
            java.lang.Object r5 = r2.getValue()
            P3.k r5 = (P3.k) r5
            java.util.Set r5 = r5.f18889e
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r5.add(r7)
            java.lang.Object r5 = r2.getValue()
            P3.k r5 = (P3.k) r5
            java.util.Set r5 = r5.f18888d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5.remove(r4)
            goto L_0x02e6
        L_0x0353:
            com.inmobi.cmp.ChoiceCmp r0 = INSTANCE
            r2 = 2
            r1.f807c = r2
            java.lang.Object r0 = r0.f(r1)
            r1 = r17
            if (r0 != r1) goto L_0x0361
        L_0x0360:
            return r1
        L_0x0361:
            W2.J r0 = W2.J.f19942a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.d(b3.e):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (r11 == r1) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0169, code lost:
        if (r11.d(r0) != r1) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x016b, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(b3.C2308e r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof b.f
            if (r0 == 0) goto L_0x0013
            r0 = r11
            b.f r0 = (b.f) r0
            int r1 = r0.f810c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f810c = r1
            goto L_0x0018
        L_0x0013:
            b.f r0 = new b.f
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f808a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f810c
            java.lang.String r3 = "viewModel"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 == r5) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            W2.u.b(r11)
            goto L_0x016c
        L_0x0030:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0038:
            W2.u.b(r11)
            goto L_0x005d
        L_0x003c:
            W2.u.b(r11)
            b.x r11 = f7838g
            if (r11 != 0) goto L_0x0047
            kotlin.jvm.internal.t.w(r3)
            r11 = r6
        L_0x0047:
            r0.f810c = r5
            r11.getClass()
            w3.I r2 = w3.C2865c0.b()
            b.p r5 = new b.p
            r5.<init>(r11, r6)
            java.lang.Object r11 = w3.C2872g.g(r2, r5, r0)
            if (r11 != r1) goto L_0x005d
            goto L_0x016b
        L_0x005d:
            P3.d r11 = (P3.d) r11
            b.x r2 = f7838g
            if (r2 != 0) goto L_0x0067
            kotlin.jvm.internal.t.w(r3)
            goto L_0x0068
        L_0x0067:
            r6 = r2
        L_0x0068:
            r6.getClass()
            java.lang.String r2 = "gvl"
            kotlin.jvm.internal.t.e(r11, r2)
            J2.u r2 = r6.f840b
            r2.f18314a = r11
            J2.l r2 = r2.f18313G
            r2.f18288d = r11
            if (r11 != 0) goto L_0x007c
            goto L_0x0156
        L_0x007c:
            java.util.Map r11 = r11.f18877i
            if (r11 != 0) goto L_0x0082
            goto L_0x0156
        L_0x0082:
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x008a:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x0156
            java.lang.Object r3 = r11.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r5 = r3.getValue()
            P3.k r5 = (P3.k) r5
            java.util.Set r5 = r5.f18888d
            java.util.Iterator r5 = r5.iterator()
        L_0x00a2:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00f6
            java.lang.Object r7 = r5.next()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            java.util.List r8 = r2.f18285a
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x00a2
            J2.k r8 = new J2.k
            J2.m r9 = J2.m.REQUIRE_CONSENT
            r8.<init>(r7, r9)
            java.lang.String r7 = r8.a()
            java.util.Map r8 = r2.f18287c
            java.lang.Object r8 = r8.get(r7)
            if (r8 != 0) goto L_0x00db
            java.util.Map r8 = r2.f18287c
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.put(r7, r9)
        L_0x00db:
            java.util.Map r8 = r2.f18287c
            java.lang.Object r7 = r8.get(r7)
            java.util.Set r7 = (java.util.Set) r7
            if (r7 != 0) goto L_0x00e6
            goto L_0x00a2
        L_0x00e6:
            java.lang.Object r8 = r3.getValue()
            P3.k r8 = (P3.k) r8
            int r8 = r8.f18881a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.add(r8)
            goto L_0x00a2
        L_0x00f6:
            java.lang.Object r5 = r3.getValue()
            P3.k r5 = (P3.k) r5
            java.util.Set r5 = r5.f18889e
            java.util.Iterator r5 = r5.iterator()
        L_0x0102:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x008a
            java.lang.Object r7 = r5.next()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            java.util.List r8 = r2.f18286b
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x0102
            J2.k r8 = new J2.k
            J2.m r9 = J2.m.REQUIRE_LI
            r8.<init>(r7, r9)
            java.lang.String r7 = r8.a()
            java.util.Map r8 = r2.f18287c
            java.lang.Object r8 = r8.get(r7)
            if (r8 != 0) goto L_0x013b
            java.util.Map r8 = r2.f18287c
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.put(r7, r9)
        L_0x013b:
            java.util.Map r8 = r2.f18287c
            java.lang.Object r7 = r8.get(r7)
            java.util.Set r7 = (java.util.Set) r7
            if (r7 != 0) goto L_0x0146
            goto L_0x0102
        L_0x0146:
            java.lang.Object r8 = r3.getValue()
            P3.k r8 = (P3.k) r8
            int r8 = r8.f18881a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.add(r8)
            goto L_0x0102
        L_0x0156:
            J2.u r11 = r6.f840b
            T3.i r2 = r6.f841c
            T3.c r2 = r2.f19281b
            java.lang.String r2 = r2.f19241f
            r11.b(r2)
            com.inmobi.cmp.ChoiceCmp r11 = INSTANCE
            r0.f810c = r4
            java.lang.Object r11 = r11.d(r0)
            if (r11 != r1) goto L_0x016c
        L_0x016b:
            return r1
        L_0x016c:
            W2.J r11 = W2.J.f19942a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.e(b3.e):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r7 == r1) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0085, code lost:
        if (a((b3.C2308e) r0) != r1) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof b.g
            if (r0 == 0) goto L_0x0013
            r0 = r7
            b.g r0 = (b.g) r0
            int r1 = r0.f813c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f813c = r1
            goto L_0x0018
        L_0x0013:
            b.g r0 = new b.g
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f811a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f813c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            W2.u.b(r7)
            goto L_0x0088
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0034:
            W2.u.b(r7)
            goto L_0x006f
        L_0x0038:
            W2.u.b(r7)
            T3.i r7 = s4.c.j()
            java.lang.String r2 = "<set-?>"
            kotlin.jvm.internal.t.e(r7, r2)
            R3.e.f18979a = r7
            r4.a r7 = s4.c.l()
            kotlin.jvm.internal.t.e(r7, r2)
            R3.e.f18980b = r7
            b.x r7 = f7838g
            r2 = 0
            if (r7 != 0) goto L_0x005a
            java.lang.String r7 = "viewModel"
            kotlin.jvm.internal.t.w(r7)
            r7 = r2
        L_0x005a:
            r0.f813c = r4
            r7.getClass()
            w3.I r4 = w3.C2865c0.b()
            b.u r5 = new b.u
            r5.<init>(r7, r2)
            java.lang.Object r7 = w3.C2872g.g(r4, r5, r0)
            if (r7 != r1) goto L_0x006f
            goto L_0x0087
        L_0x006f:
            R3.a r7 = (R3.a) r7
            android.app.Application r2 = s4.c.f25853a
            java.lang.String r2 = "mspaConfig"
            kotlin.jvm.internal.t.e(r7, r2)
            s4.c.f25864l = r7
            com.inmobi.cmp.ChoiceCmp r7 = INSTANCE
            r0.f813c = r3
            r7.getClass()
            java.lang.Object r7 = a((b3.C2308e) r0)
            if (r7 != r1) goto L_0x0088
        L_0x0087:
            return r1
        L_0x0088:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.f(b3.e):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (r10 == r1) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0122, code lost:
        if (r2.b(r0) == r1) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0124, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(b3.C2308e r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof b.h
            if (r0 == 0) goto L_0x0013
            r0 = r10
            b.h r0 = (b.h) r0
            int r1 = r0.f816c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f816c = r1
            goto L_0x0018
        L_0x0013:
            b.h r0 = new b.h
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f814a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f816c
            java.lang.String r3 = "viewModel"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 == r5) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            W2.u.b(r10)
            goto L_0x0125
        L_0x0030:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0038:
            W2.u.b(r10)
            goto L_0x005d
        L_0x003c:
            W2.u.b(r10)
            b.x r10 = f7838g
            if (r10 != 0) goto L_0x0047
            kotlin.jvm.internal.t.w(r3)
            r10 = r6
        L_0x0047:
            r0.f816c = r5
            r10.getClass()
            w3.I r2 = w3.C2865c0.b()
            b.q r5 = new b.q
            r5.<init>(r10, r6)
            java.lang.Object r10 = w3.C2872g.g(r2, r5, r0)
            if (r10 != r1) goto L_0x005d
            goto L_0x0124
        L_0x005d:
            T3.i r10 = (T3.i) r10
            T3.c r2 = r10.f19281b
            java.lang.String r2 = r2.f19240e
            boolean r2 = t3.s.h0(r2)
            if (r2 != 0) goto L_0x0125
            b.x r2 = f7838g
            if (r2 != 0) goto L_0x0071
            kotlin.jvm.internal.t.w(r3)
            goto L_0x0072
        L_0x0071:
            r6 = r2
        L_0x0072:
            r6.getClass()
            java.lang.String r2 = "config"
            kotlin.jvm.internal.t.e(r10, r2)
            T3.i r2 = r6.f841c
            T3.j r3 = r10.f19280a
            r2.getClass()
            java.lang.String r5 = "<set-?>"
            kotlin.jvm.internal.t.e(r3, r5)
            r2.f19280a = r3
            T3.i r2 = r6.f841c
            T3.c r3 = r10.f19281b
            r2.getClass()
            kotlin.jvm.internal.t.e(r3, r5)
            r2.f19281b = r3
            T3.i r2 = r6.f841c
            T3.h r3 = r10.f19282c
            r2.getClass()
            kotlin.jvm.internal.t.e(r3, r5)
            r2.f19282c = r3
            T3.i r2 = r6.f841c
            m4.g r3 = r10.f19283d
            r2.getClass()
            kotlin.jvm.internal.t.e(r3, r5)
            r2.f19283d = r3
            T3.i r2 = r6.f841c
            m4.p r3 = r10.f19285f
            r2.getClass()
            kotlin.jvm.internal.t.e(r3, r5)
            r2.f19285f = r3
            T3.i r2 = r6.f841c
            long r7 = r10.f19287h
            r2.f19287h = r7
            J2.u r2 = r6.f840b
            J2.l r2 = r2.f18313G
            T3.c r3 = r10.f19281b
            java.util.List r3 = r3.f19259x
            r2.getClass()
            kotlin.jvm.internal.t.e(r3, r5)
            r2.f18285a = r3
            T3.c r3 = r10.f19281b
            java.util.List r3 = r3.f19260y
            kotlin.jvm.internal.t.e(r3, r5)
            r2.f18286b = r3
            o4.k r2 = r6.f845g
            r2.getClass()
            java.lang.String r3 = "portalConfig"
            kotlin.jvm.internal.t.e(r10, r3)
            m4.g r5 = r10.f19283d
            r2.f25596g = r5
            m4.k r5 = r10.f19284e
            r2.f25597h = r5
            m4.p r5 = r10.f19285f
            r2.f25598i = r5
            r4.a r2 = r6.f839a
            r4.b r5 = r4.b.GOOGLE_ENABLED
            T3.c r7 = r10.f19281b
            boolean r7 = r7.f19248m
            r2.j(r5, r7)
            r4.a r2 = r6.f839a
            r4.b r5 = r4.b.PORTAL_CHOICE_LANG
            boolean r6 = r6.l()
            if (r6 == 0) goto L_0x0105
            java.lang.String r6 = "en"
            goto L_0x0109
        L_0x0105:
            T3.c r6 = r10.f19281b
            java.lang.String r6 = r6.f19250o
        L_0x0109:
            r2.i(r5, r6)
            com.inmobi.cmp.ChoiceCmp r2 = INSTANCE
            long r5 = java.lang.System.currentTimeMillis()
            r2.setConfigFetchTimeStampFromDevice(r5)
            android.app.Application r5 = s4.c.f25853a
            kotlin.jvm.internal.t.e(r10, r3)
            s4.c.f25859g = r10
            r0.f816c = r4
            java.lang.Object r10 = r2.b(r0)
            if (r10 != r1) goto L_0x0125
        L_0x0124:
            return r1
        L_0x0125:
            W2.J r10 = W2.J.f19942a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.g(b3.e):java.lang.Object");
    }

    public final String getAppPackageId() {
        return f7833b;
    }

    public final ChoiceCmpCallback getCallback() {
        return f7832a;
    }

    public final long getConfigFetchTimeStampFromDevice() {
        return f7837f;
    }

    public final UUID getCurrentSessionId() {
        return f7836e;
    }

    public final J2.f getGoogleVendorList$app_release() {
        x xVar = f7838g;
        if (xVar == null) {
            t.w("viewModel");
            xVar = null;
        }
        return xVar.f852n;
    }

    public final String getPCode() {
        return f7834c;
    }

    public final i getPortalConfig$app_release() {
        x xVar = null;
        if (!isViewModelAvailable$app_release()) {
            return null;
        }
        x xVar2 = f7838g;
        if (xVar2 == null) {
            t.w("viewModel");
        } else {
            xVar = xVar2;
        }
        return xVar.f841c;
    }

    public final u getTcModel$app_release() {
        x xVar = null;
        if (!isViewModelAvailable$app_release()) {
            return null;
        }
        x xVar2 = f7838g;
        if (xVar2 == null) {
            t.w("viewModel");
        } else {
            xVar = xVar2;
        }
        return xVar.f840b;
    }

    public final boolean getUserSubscribed() {
        return f7835d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r7 == r1) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r7.e(r0) != r1) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof b.i
            if (r0 == 0) goto L_0x0013
            r0 = r7
            b.i r0 = (b.i) r0
            int r1 = r0.f819c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f819c = r1
            goto L_0x0018
        L_0x0013:
            b.i r0 = new b.i
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f817a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f819c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            W2.u.b(r7)
            goto L_0x0068
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0034:
            W2.u.b(r7)
            goto L_0x005b
        L_0x0038:
            W2.u.b(r7)
            b.x r7 = f7838g
            r2 = 0
            if (r7 != 0) goto L_0x0046
            java.lang.String r7 = "viewModel"
            kotlin.jvm.internal.t.w(r7)
            r7 = r2
        L_0x0046:
            r0.f819c = r4
            r7.getClass()
            w3.I r4 = w3.C2865c0.b()
            b.v r5 = new b.v
            r5.<init>(r7, r2)
            java.lang.Object r7 = w3.C2872g.g(r4, r5, r0)
            if (r7 != r1) goto L_0x005b
            goto L_0x0067
        L_0x005b:
            m4.t r7 = (m4.t) r7
            com.inmobi.cmp.ChoiceCmp r7 = INSTANCE
            r0.f819c = r3
            java.lang.Object r7 = r7.e(r0)
            if (r7 != r1) goto L_0x0068
        L_0x0067:
            return r1
        L_0x0068:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.h(b3.e):java.lang.Object");
    }

    public final boolean isViewModelAvailable$app_release() {
        x xVar = f7838g;
        if (xVar == null || !xVar.f851m) {
            return false;
        }
        return true;
    }

    public final void onAppClosing() {
        x xVar = f7838g;
        if (xVar == null) {
            t.w("viewModel");
            xVar = null;
        }
        long j5 = f7837f;
        long j6 = xVar.f841c.f19287h;
        xVar.f839a.g(r4.b.LAST_VISIT_TIME, (System.currentTimeMillis() - j5) + j6);
    }

    public final PingReturn ping$app_release(boolean z4, CmpStatus cmpStatus, DisplayStatus displayStatus) {
        Integer num;
        Integer num2;
        Integer num3;
        int i5;
        boolean z5;
        CmpStatus cmpStatus2 = cmpStatus;
        t.e(cmpStatus2, "cmpStatus");
        DisplayStatus displayStatus2 = displayStatus;
        t.e(displayStatus2, "displayStatus");
        if (f7838g != null) {
            x xVar = f7838g;
            x xVar2 = null;
            if (xVar == null) {
                t.w("viewModel");
                xVar = null;
            }
            Boolean valueOf = Boolean.valueOf(xVar.g());
            u tcModel$app_release = getTcModel$app_release();
            if (tcModel$app_release == null) {
                num = null;
            } else {
                num = Integer.valueOf(tcModel$app_release.f18327n);
            }
            String valueOf2 = String.valueOf(num);
            u tcModel$app_release2 = getTcModel$app_release();
            if (tcModel$app_release2 == null) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(tcModel$app_release2.f18326m);
            }
            x xVar3 = f7838g;
            if (xVar3 == null) {
                t.w("viewModel");
                xVar3 = null;
            }
            Integer valueOf3 = Integer.valueOf(xVar3.j());
            x xVar4 = f7838g;
            if (xVar4 == null) {
                t.w("viewModel");
                xVar4 = null;
            }
            P3.d dVar = xVar4.f840b.f18314a;
            if (dVar == null) {
                num3 = null;
            } else {
                num3 = dVar.f18871c;
            }
            if (num3 == null) {
                i5 = xVar4.i();
            } else {
                i5 = num3.intValue();
            }
            Integer valueOf4 = Integer.valueOf(i5);
            x xVar5 = f7838g;
            if (xVar5 == null) {
                t.w("viewModel");
                xVar5 = null;
            }
            if (xVar5.o()) {
                x xVar6 = f7838g;
                if (xVar6 == null) {
                    t.w("viewModel");
                } else {
                    xVar2 = xVar6;
                }
                if (xVar2.l()) {
                    z5 = true;
                    return new PingReturn(valueOf, z4, cmpStatus2, displayStatus2, MBridgeConstans.NATIVE_VIDEO_VERSION, valueOf2, num2, valueOf3, valueOf4, Boolean.valueOf(z5));
                }
            }
            z5 = false;
            return new PingReturn(valueOf, z4, cmpStatus2, displayStatus2, MBridgeConstans.NATIVE_VIDEO_VERSION, valueOf2, num2, valueOf3, valueOf4, Boolean.valueOf(z5));
        }
        ChoiceCmpCallback choiceCmpCallback = f7832a;
        if (choiceCmpCallback != null) {
            choiceCmpCallback.onCmpError(ChoiceError.MISSING_INITIALIZATION);
        }
        return new PingReturn((Boolean) null, false, CmpStatus.ERROR, DisplayStatus.HIDDEN, MBridgeConstans.NATIVE_VIDEO_VERSION, (String) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, 512, (C2633k) null);
    }

    public final void sendNRVisitEvent$app_release() {
        if (l.f960a) {
            UUID uuid = z.f24676a;
            k4.h hVar = k4.h.NR;
            t.e(hVar, "regulation");
            C2908y0 unused = C2876i.d(C2896s0.f26313a, C2865c0.b(), (O) null, new k4.x((String) null, hVar, false, (C2308e) null), 2, (Object) null);
        }
    }

    public final void setAppPackageId(String str) {
        t.e(str, "<set-?>");
        f7833b = str;
    }

    public final void setCallback(ChoiceCmpCallback choiceCmpCallback) {
        f7832a = choiceCmpCallback;
    }

    public final void setConfigFetchTimeStampFromDevice(long j5) {
        f7837f = j5;
    }

    public final void setCurrentSessionId(UUID uuid) {
        f7836e = uuid;
    }

    public final void setLoginProcessStart() {
        f7841j = true;
    }

    public final void setPCode(String str) {
        t.e(str, "<set-?>");
        f7834c = str;
    }

    public final void setUserSubscribed(boolean z4) {
        f7835d = z4;
    }

    public final void startCMPActivity$app_release(Context context, Bundle bundle) {
        t.e(context, "context");
        t.e(bundle, "extras");
        context.startActivity(new Intent(context, CmpActivity.class).addFlags(268435456).addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL).putExtras(bundle));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r14, boolean r15) {
        /*
            r13 = this;
            b.x r0 = f7838g
            java.lang.String r1 = "viewModel"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.t.w(r1)
            r0 = r2
        L_0x000b:
            T3.i r3 = r0.f841c
            T3.c r3 = r3.f19281b
            java.util.List r3 = r3.f19237b
            java.lang.String r4 = "GDPR"
            boolean r3 = r3.contains(r4)
            java.lang.String r5 = "No regulations applicable"
            if (r3 == 0) goto L_0x00dc
            boolean r0 = r0.g()
            if (r0 == 0) goto L_0x00dc
            b.x r0 = f7838g
            if (r0 != 0) goto L_0x0029
            kotlin.jvm.internal.t.w(r1)
            r0 = r2
        L_0x0029:
            boolean r0 = r0.u()
            if (r0 == 0) goto L_0x003f
            b.x r0 = f7838g
            if (r0 != 0) goto L_0x0037
            kotlin.jvm.internal.t.w(r1)
            r0 = r2
        L_0x0037:
            boolean r0 = r0.l()
            if (r0 != 0) goto L_0x003f
            r0 = 1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r15 != 0) goto L_0x0096
            b.x r3 = f7838g
            if (r3 != 0) goto L_0x004a
            kotlin.jvm.internal.t.w(r1)
            r3 = r2
        L_0x004a:
            T3.i r3 = r3.f841c
            T3.c r3 = r3.f19281b
            T3.d r3 = r3.f19231V
            java.lang.Boolean r3 = r3.f19262a
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            boolean r3 = kotlin.jvm.internal.t.a(r3, r4)
            if (r3 == 0) goto L_0x0096
            b.x r3 = f7838g
            if (r3 != 0) goto L_0x0062
            kotlin.jvm.internal.t.w(r1)
            r3 = r2
        L_0x0062:
            boolean r3 = r3.t()
            if (r3 == 0) goto L_0x0096
            java.util.UUID r3 = k4.z.f24676a
            k4.h r3 = k4.h.GDPR
            b.x r4 = f7838g
            if (r4 != 0) goto L_0x0074
            kotlin.jvm.internal.t.w(r1)
            r4 = r2
        L_0x0074:
            r4.getClass()
            java.lang.String r6 = "regulation"
            kotlin.jvm.internal.t.e(r3, r6)
            r4.a r4 = r4.f839a
            java.lang.String r4 = V2.a.a(r3, r4)
            kotlin.jvm.internal.t.e(r3, r6)
            w3.s0 r7 = w3.C2896s0.f26313a
            w3.I r8 = w3.C2865c0.b()
            k4.x r10 = new k4.x
            r10.<init>(r4, r3, r0, r2)
            r11 = 2
            r12 = 0
            r9 = 0
            w3.C2908y0 unused = w3.C2876i.d(r7, r8, r9, r10, r11, r12)
        L_0x0096:
            if (r0 != 0) goto L_0x00c5
            if (r15 == 0) goto L_0x009b
            goto L_0x00c5
        L_0x009b:
            b.x r14 = f7838g
            if (r14 != 0) goto L_0x00a3
            kotlin.jvm.internal.t.w(r1)
            goto L_0x00a4
        L_0x00a3:
            r2 = r14
        L_0x00a4:
            boolean r14 = r2.l()
            if (r14 == 0) goto L_0x00ac
        L_0x00aa:
            r8 = r5
            goto L_0x00af
        L_0x00ac:
            java.lang.String r5 = "GDPR is applicable but no need to re-trigger the screen"
            goto L_0x00aa
        L_0x00af:
            com.inmobi.cmp.ChoiceCmpCallback r14 = f7832a
            if (r14 != 0) goto L_0x00b4
            return
        L_0x00b4:
            F1.b r6 = new F1.b
            com.inmobi.cmp.core.cmpapi.status.DisplayStatus r7 = com.inmobi.cmp.core.cmpapi.status.DisplayStatus.HIDDEN
            com.inmobi.cmp.model.Regulations r9 = com.inmobi.cmp.model.Regulations.NA
            r11 = 8
            r12 = 0
            r10 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r14.onCMPUIStatusChanged(r6)
            return
        L_0x00c5:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "EXTRA_ACTION"
            java.lang.String r2 = "ACTION_SHOW_CMP_DIALOG"
            r0.putString(r1, r2)
            java.lang.String r1 = "EXTRA_FORCE"
            r0.putBoolean(r1, r15)
            W2.J r15 = W2.J.f19942a
            r13.startCMPActivity$app_release(r14, r0)
            return
        L_0x00dc:
            b.x r14 = f7838g
            if (r14 != 0) goto L_0x00e4
            kotlin.jvm.internal.t.w(r1)
            r14 = r2
        L_0x00e4:
            T3.i r14 = r14.f841c
            T3.c r14 = r14.f19281b
            T3.d r14 = r14.f19231V
            java.lang.Boolean r14 = r14.f19262a
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r14 = kotlin.jvm.internal.t.a(r14, r0)
            if (r14 == 0) goto L_0x0105
            b.x r14 = f7838g
            if (r14 != 0) goto L_0x00fc
            kotlin.jvm.internal.t.w(r1)
            r14 = r2
        L_0x00fc:
            boolean r14 = r14.t()
            if (r14 == 0) goto L_0x0105
            r13.sendNRVisitEvent$app_release()
        L_0x0105:
            if (r15 != 0) goto L_0x0109
        L_0x0107:
            r8 = r5
            goto L_0x0124
        L_0x0109:
            b.x r14 = f7838g
            if (r14 != 0) goto L_0x0111
            kotlin.jvm.internal.t.w(r1)
            r14 = r2
        L_0x0111:
            T3.i r15 = r14.f841c
            T3.c r15 = r15.f19281b
            java.util.List r15 = r15.f19237b
            boolean r15 = r15.contains(r4)
            java.lang.String r5 = "GDPR not applicable"
            if (r15 == 0) goto L_0x0107
            boolean r14 = r14.g()
            goto L_0x0107
        L_0x0124:
            com.inmobi.cmp.ChoiceCmpCallback r14 = f7832a
            if (r14 != 0) goto L_0x0129
            goto L_0x0139
        L_0x0129:
            F1.b r6 = new F1.b
            com.inmobi.cmp.core.cmpapi.status.DisplayStatus r7 = com.inmobi.cmp.core.cmpapi.status.DisplayStatus.HIDDEN
            com.inmobi.cmp.model.Regulations r9 = com.inmobi.cmp.model.Regulations.NA
            r11 = 8
            r12 = 0
            r10 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r14.onCMPUIStatusChanged(r6)
        L_0x0139:
            com.inmobi.cmp.model.ChoiceError r14 = com.inmobi.cmp.model.ChoiceError.GDPR_NA
            java.lang.String r14 = r14.getMessage()
            r15 = 5
            H2.d.c(r2, r14, r2, r0, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.a(android.content.Context, boolean):void");
    }

    public static Object a(C2308e eVar) {
        Object obj;
        Set<Number> set;
        Map map;
        Map map2;
        Map map3;
        int i5;
        Map map4;
        Map map5;
        Map map6;
        int i6;
        Map map7;
        int i7;
        Map map8;
        Map map9;
        int i8;
        Map map10;
        int i9;
        Map map11;
        Map map12;
        Map map13;
        x xVar = f7838g;
        if (xVar == null) {
            t.w("viewModel");
            xVar = null;
        }
        String k5 = xVar.f839a.k(r4.b.HDR_GPP_STRING);
        if (k5.length() > 0) {
            Application application = c.f25853a;
            t.e(k5, "gppString");
            c.f25867o = new C1703a(k5);
        }
        x xVar2 = f7838g;
        if (xVar2 == null) {
            t.w("viewModel");
            xVar2 = null;
        }
        P3.d dVar = xVar2.f840b.f18314a;
        if (!(dVar == null || (map13 = dVar.f18877i) == null)) {
            for (Map.Entry entry : map13.entrySet()) {
                if (((P3.k) entry.getValue()).f18889e.isEmpty()) {
                    P3.k kVar = (P3.k) entry.getValue();
                    if (kVar.f18888d.isEmpty()) {
                        if (kVar.f18889e.isEmpty()) {
                            if (kVar.f18891g.isEmpty()) {
                            }
                        }
                    }
                }
                if (!xVar2.f840b.f18309C.contains(((P3.k) entry.getValue()).f18881a)) {
                    xVar2.f840b.f18309C.set(((P3.k) entry.getValue()).f18881a);
                }
            }
        }
        P3.d dVar2 = xVar2.f840b.f18314a;
        if (!(dVar2 == null || (map12 = dVar2.f18877i) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry2 : map12.entrySet()) {
                if (((P3.k) entry2.getValue()).f18895k == null) {
                    linkedHashMap.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                if (!xVar2.f840b.f18339z.contains(((P3.k) entry3.getValue()).f18881a)) {
                    xVar2.f840b.f18339z.unset(((P3.k) entry3.getValue()).f18881a);
                }
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        P3.d dVar3 = xVar2.f840b.f18314a;
        if (!(dVar3 == null || (map11 = dVar3.f18877i) == null)) {
            for (Map.Entry value : map11.entrySet()) {
                linkedHashSet.addAll(((P3.k) value.getValue()).f18888d);
            }
        }
        for (T3.g gVar : xVar2.f841c.f19282c.f19277a) {
            linkedHashSet.addAll(gVar.f19275f);
        }
        P3.d dVar4 = xVar2.f840b.f18314a;
        if (!(dVar4 == null || (map8 = dVar4.f18872d) == null)) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry4 : map8.entrySet()) {
                if (linkedHashSet.contains(Integer.valueOf(((P3.h) entry4.getValue()).f18881a))) {
                    linkedHashMap2.put(entry4.getKey(), entry4.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry5 : linkedHashMap2.entrySet()) {
                if (xVar2.f841c.f19281b.f19243h.contains(Integer.valueOf(((P3.h) entry5.getValue()).f18881a)) || xVar2.f841c.f19281b.f19254s.contains(Integer.valueOf(((P3.h) entry5.getValue()).f18881a))) {
                    linkedHashMap3.put(entry5.getKey(), entry5.getValue());
                }
            }
            for (Map.Entry entry6 : linkedHashMap3.entrySet()) {
                if (!xVar2.f840b.f18331r.contains(((P3.h) entry6.getValue()).f18881a)) {
                    int i10 = ((P3.h) entry6.getValue()).f18881a;
                    P3.d dVar5 = xVar2.f840b.f18314a;
                    if (!(dVar5 == null || (map9 = dVar5.f18872d) == null)) {
                        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                        for (Map.Entry entry7 : map9.entrySet()) {
                            if (((P3.h) entry7.getValue()).f18881a == i10) {
                                linkedHashMap4.put(entry7.getKey(), entry7.getValue());
                            }
                        }
                        int i11 = 0;
                        for (Map.Entry entry8 : linkedHashMap4.entrySet()) {
                            P3.d dVar6 = xVar2.f840b.f18314a;
                            if (!(dVar6 == null || (map10 = dVar6.f18877i) == null)) {
                                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                                for (Map.Entry entry9 : map10.entrySet()) {
                                    if (((P3.k) entry9.getValue()).f18895k == null) {
                                        linkedHashMap5.put(entry9.getKey(), entry9.getValue());
                                    }
                                }
                                for (Map.Entry value2 : linkedHashMap5.entrySet()) {
                                    Set<Number> set2 = ((P3.k) value2.getValue()).f18888d;
                                    if (!w.a(set2) || !set2.isEmpty()) {
                                        i9 = 0;
                                        for (Number intValue : set2) {
                                            if (intValue.intValue() == i10 && (i9 = i9 + 1) < 0) {
                                                C2250q.n();
                                            }
                                        }
                                    } else {
                                        i9 = 0;
                                    }
                                    i11 += i9;
                                }
                            }
                            for (T3.g gVar2 : xVar2.f841c.f19282c.f19277a) {
                                List<Number> list = gVar2.f19275f;
                                if (!(list instanceof Collection) || !list.isEmpty()) {
                                    i8 = 0;
                                    for (Number intValue2 : list) {
                                        if (intValue2.intValue() == i10 && (i8 = i8 + 1) < 0) {
                                            C2250q.n();
                                        }
                                    }
                                } else {
                                    i8 = 0;
                                }
                                i11 += i8;
                            }
                            for (Number intValue3 : xVar2.f841c.f19281b.f19254s) {
                                if (intValue3.intValue() == i10) {
                                    i11++;
                                }
                            }
                        }
                        if (i11 > 0) {
                            xVar2.f840b.f18331r.unset(((P3.h) entry6.getValue()).f18881a);
                        }
                    }
                }
            }
        }
        P3.d dVar7 = xVar2.f840b.f18314a;
        if (!(dVar7 == null || (map5 = dVar7.f18872d) == null)) {
            LinkedHashMap linkedHashMap6 = new LinkedHashMap();
            for (Map.Entry entry10 : map5.entrySet()) {
                if (xVar2.f841c.f19281b.f19245j.contains(Integer.valueOf(((P3.h) entry10.getValue()).f18881a)) || xVar2.f841c.f19281b.f19255t.contains(Integer.valueOf(((P3.h) entry10.getValue()).f18881a))) {
                    linkedHashMap6.put(entry10.getKey(), entry10.getValue());
                }
            }
            for (Map.Entry entry11 : linkedHashMap6.entrySet()) {
                if (!xVar2.f840b.f18332s.contains(((P3.h) entry11.getValue()).f18881a)) {
                    int i12 = ((P3.h) entry11.getValue()).f18881a;
                    u uVar = xVar2.f840b;
                    P3.d dVar8 = uVar.f18314a;
                    if (dVar8 == null || (map6 = dVar8.f18872d) == null) {
                        map6 = null;
                    } else if (!t.a(uVar.f18321h, "DE")) {
                        LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                        for (Map.Entry entry12 : map6.entrySet()) {
                            if (((P3.h) entry12.getValue()).f18881a != 1) {
                                linkedHashMap7.put(entry12.getKey(), entry12.getValue());
                            }
                        }
                        map6 = linkedHashMap7;
                    }
                    if (map6 != null) {
                        LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                        for (Map.Entry entry13 : map6.entrySet()) {
                            if (((P3.h) entry13.getValue()).f18881a == i12) {
                                linkedHashMap8.put(entry13.getKey(), entry13.getValue());
                            }
                        }
                        int i13 = 0;
                        for (Map.Entry entry14 : linkedHashMap8.entrySet()) {
                            P3.d dVar9 = xVar2.f840b.f18314a;
                            if (!(dVar9 == null || (map7 = dVar9.f18877i) == null)) {
                                LinkedHashMap linkedHashMap9 = new LinkedHashMap();
                                for (Map.Entry entry15 : map7.entrySet()) {
                                    if (((P3.k) entry15.getValue()).f18895k == null) {
                                        linkedHashMap9.put(entry15.getKey(), entry15.getValue());
                                    }
                                }
                                for (Map.Entry value3 : linkedHashMap9.entrySet()) {
                                    Set<Number> set3 = ((P3.k) value3.getValue()).f18889e;
                                    if (!w.a(set3) || !set3.isEmpty()) {
                                        i7 = 0;
                                        for (Number intValue4 : set3) {
                                            if (intValue4.intValue() == i12 && (i7 = i7 + 1) < 0) {
                                                C2250q.n();
                                            }
                                        }
                                    } else {
                                        i7 = 0;
                                    }
                                    i13 += i7;
                                }
                            }
                            for (T3.g gVar3 : xVar2.f841c.f19282c.f19277a) {
                                List<Number> list2 = gVar3.f19276g;
                                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                                    i6 = 0;
                                    for (Number intValue5 : list2) {
                                        if (intValue5.intValue() == i12 && (i6 = i6 + 1) < 0) {
                                            C2250q.n();
                                        }
                                    }
                                } else {
                                    i6 = 0;
                                }
                                i13 += i6;
                            }
                            for (Number intValue6 : xVar2.f841c.f19281b.f19255t) {
                                if (intValue6.intValue() == i12) {
                                    i13++;
                                }
                            }
                        }
                        if (i13 > 0) {
                            xVar2.f840b.f18332s.set(((P3.h) entry11.getValue()).f18881a);
                        }
                    }
                }
            }
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        P3.d dVar10 = xVar2.f840b.f18314a;
        if (!(dVar10 == null || (map4 = dVar10.f18877i) == null)) {
            for (Map.Entry value4 : map4.entrySet()) {
                linkedHashSet2.addAll(((P3.k) value4.getValue()).f18893i);
            }
        }
        P3.d dVar11 = xVar2.f840b.f18314a;
        if (!(dVar11 == null || (map = dVar11.f18875g) == null)) {
            LinkedHashMap linkedHashMap10 = new LinkedHashMap();
            for (Map.Entry entry16 : map.entrySet()) {
                if (linkedHashSet2.contains(Integer.valueOf(((P3.c) entry16.getValue()).f18881a))) {
                    linkedHashMap10.put(entry16.getKey(), entry16.getValue());
                }
            }
            LinkedHashMap linkedHashMap11 = new LinkedHashMap();
            for (Map.Entry entry17 : linkedHashMap10.entrySet()) {
                if (xVar2.f841c.f19281b.f19246k.contains(Integer.valueOf(((P3.c) entry17.getValue()).f18881a)) || xVar2.f841c.f19281b.f19258w.contains(Integer.valueOf(((P3.c) entry17.getValue()).f18881a))) {
                    linkedHashMap11.put(entry17.getKey(), entry17.getValue());
                }
            }
            for (Map.Entry entry18 : linkedHashMap11.entrySet()) {
                if (!xVar2.f840b.f18330q.contains(((P3.c) entry18.getValue()).f18881a)) {
                    int i14 = ((P3.c) entry18.getValue()).f18881a;
                    P3.d dVar12 = xVar2.f840b.f18314a;
                    if (!(dVar12 == null || (map2 = dVar12.f18875g) == null)) {
                        LinkedHashMap linkedHashMap12 = new LinkedHashMap();
                        for (Map.Entry entry19 : map2.entrySet()) {
                            if (((P3.c) entry19.getValue()).f18881a == i14) {
                                linkedHashMap12.put(entry19.getKey(), entry19.getValue());
                            }
                        }
                        int i15 = 0;
                        for (Map.Entry entry20 : linkedHashMap12.entrySet()) {
                            P3.d dVar13 = xVar2.f840b.f18314a;
                            if (!(dVar13 == null || (map3 = dVar13.f18877i) == null)) {
                                LinkedHashMap linkedHashMap13 = new LinkedHashMap();
                                for (Map.Entry entry21 : map3.entrySet()) {
                                    if (((P3.k) entry21.getValue()).f18895k == null) {
                                        linkedHashMap13.put(entry21.getKey(), entry21.getValue());
                                    }
                                }
                                for (Map.Entry value5 : linkedHashMap13.entrySet()) {
                                    Set<Number> set4 = ((P3.k) value5.getValue()).f18893i;
                                    if (!w.a(set4) || !set4.isEmpty()) {
                                        i5 = 0;
                                        for (Number intValue7 : set4) {
                                            if (intValue7.intValue() == i14 && (i5 = i5 + 1) < 0) {
                                                C2250q.n();
                                            }
                                        }
                                    } else {
                                        i5 = 0;
                                    }
                                    i15 += i5;
                                }
                            }
                            for (Number intValue8 : xVar2.f841c.f19281b.f19258w) {
                                if (intValue8.intValue() == i14) {
                                    i15++;
                                }
                            }
                        }
                        if (i15 > 0) {
                            xVar2.f840b.f18330q.unset(((P3.c) entry18.getValue()).f18881a);
                        }
                    }
                }
            }
        }
        for (T3.g gVar4 : xVar2.f841c.f19282c.f19277a) {
            if (xVar2.d(C2250q.r0(gVar4.f19275f))) {
                xVar2.f840b.f18307A.unset(gVar4.f19270a);
            }
            if (!gVar4.f19276g.isEmpty()) {
                xVar2.f840b.f18310D.set(gVar4.f19270a);
            }
        }
        for (Number intValue9 : xVar2.f841c.f19281b.f19254s) {
            xVar2.f840b.f18335v.unset(intValue9.intValue());
        }
        for (Number intValue10 : xVar2.f841c.f19281b.f19255t) {
            xVar2.f840b.f18336w.set(intValue10.intValue());
        }
        a aVar = xVar2.f839a;
        r4.b bVar = r4.b.GDPR_CONSENT_LAST_STORED_TIME_STAMP;
        aVar.getClass();
        t.e(bVar, "preferenceKey");
        long j5 = aVar.f25721a.getLong("GDPR_Consent_LastStoredTimeStamp", 0);
        double d5 = ((double) (xVar2.f841c.f19287h - j5)) / ((double) 86400000);
        if (j5 != 0 && d5 >= 395.0d) {
            xVar2.f();
            c.g().c(C1797g.f16398e);
            xVar2.b();
            xVar2.f839a.e(r4.b.CONFIG_THEME_UUID);
            xVar2.f839a.e(r4.b.CONFIG_LANGUAGE);
            xVar2.f839a.e(r4.b.CONFIG_COP_APPLICABLE);
            xVar2.f839a.e(r4.b.CONFIG_ADV_APPLICABLE);
            xVar2.f839a.e(r4.b.CONFIG_GBC_APPLICABLE);
            String e5 = c.g().e();
            a l5 = c.l();
            r4.b bVar2 = r4.b.HDR_GPP_STRING;
            t.d(e5, "gppString");
            l5.i(bVar2, e5);
        }
        xVar2.p();
        String k6 = xVar2.f839a.k(r4.b.ADDTL_CONSENT);
        if (k6.length() <= 0) {
            k6 = null;
        }
        if (k6 != null) {
            t.e(k6, "acString");
            if (k6.length() <= 2) {
                set = T.d();
            } else {
                String substring = k6.substring(2);
                t.d(substring, "this as java.lang.String).substring(startIndex)");
                List<String> G02 = s.G0(substring, new String[]{"."}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList(C2250q.p(G02, 10));
                for (String parseInt : G02) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
                }
                set = C2250q.r0(arrayList);
            }
            for (Number intValue11 : set) {
                xVar2.f840b.f18308B.set(intValue11.intValue());
            }
        }
        a aVar2 = xVar2.f839a;
        r4.b bVar3 = r4.b.NON_IAB_VENDOR_CONSENTS;
        if (aVar2.k(bVar3).length() > 0) {
            xVar2.f840b.f18307A.setOwnedItems(L2.d.a(xVar2.f839a.k(bVar3)));
            xVar2.f840b.f18310D.unset(L2.d.a(xVar2.f839a.k(r4.b.NON_IAB_VENDOR_LEG_INTERESTS)));
        }
        x xVar3 = f7838g;
        if (xVar3 == null) {
            t.w("viewModel");
            xVar3 = null;
        }
        if (!xVar3.n()) {
            xVar3.f839a.f(r4.b.VENDOR_LIST_VERSION, xVar3.j());
            xVar3.f839a.g(r4.b.VENDOR_LIST_LAST_UPDATED, System.currentTimeMillis());
        }
        a aVar3 = xVar3.f839a;
        r4.b bVar4 = r4.b.NON_IAB_VENDOR_CONSENT_HASH;
        String n5 = t.n(aVar3.k(bVar4), xVar3.h());
        a aVar4 = xVar3.f839a;
        r4.b bVar5 = r4.b.OPTION_HASH;
        if (!t.a(n5, aVar4.k(bVar5))) {
            if (t.a(xVar3.f839a.k(bVar4), "")) {
                xVar3.f839a.i(bVar4, l4.e.b(xVar3.f840b.f18307A.toString()));
            }
            xVar3.f839a.i(r4.b.PORTAL_CONFIG_HASH, xVar3.h());
            a aVar5 = xVar3.f839a;
            aVar5.i(bVar5, t.n(aVar5.k(bVar4), xVar3.h()));
            xVar3.f839a.i(r4.b.PORTAL_NON_HASH, xVar3.f841c.f19281b.f19257v.toString());
        }
        if (!xVar3.m()) {
            xVar3.f839a.i(r4.b.GBC_PURPOSE_HASH, "");
        }
        String str = xVar3.f841c.f19281b.f19218I;
        if (t.a(str, PrivacyEncodingMode.GPP.getValue())) {
            xVar3.r();
        } else if (t.a(str, PrivacyEncodingMode.TCF.getValue())) {
            xVar3.s();
        } else {
            xVar3.r();
            xVar3.s();
        }
        x xVar4 = f7838g;
        if (xVar4 == null) {
            t.w("viewModel");
            xVar4 = null;
        }
        xVar4.q();
        x xVar5 = f7838g;
        if (xVar5 == null) {
            t.w("viewModel");
            xVar5 = null;
        }
        for (T3.e eVar2 : xVar5.f841c.f19281b.f19232W.f19269c) {
            boolean z4 = l.f960a;
            int i16 = eVar2.f19265a;
            GBCConsentValue gBCConsentValue = eVar2.f19266b;
            t.e(gBCConsentValue, "value");
            if (gBCConsentValue == GBCConsentValue.GRANTED) {
                l.f961b.set(i16);
            } else {
                l.f961b.unset(i16);
            }
        }
        x xVar6 = f7838g;
        if (xVar6 == null) {
            t.w("viewModel");
            xVar6 = null;
        }
        a aVar6 = xVar6.f839a;
        r4.b bVar6 = r4.b.MSPA_SHOWN;
        aVar6.getClass();
        t.e(bVar6, "preferenceKey");
        boolean z5 = aVar6.f25721a.getBoolean("MSPAShown", false);
        R3.j.f19019d = z5;
        c.l().j(bVar6, z5);
        x xVar7 = f7838g;
        if (xVar7 == null) {
            t.w("viewModel");
            xVar7 = null;
        }
        xVar7.f851m = true;
        if (V2.a.e()) {
            a();
        }
        if (!b.f25850a || c.f25853a == null) {
            obj = W2.J.f19942a;
        } else {
            obj = C2872g.g(C2865c0.c().F(), new j((C2308e) null), eVar);
            if (obj != C2316b.f()) {
                obj = W2.J.f19942a;
            }
        }
        return obj == C2316b.f() ? obj : W2.J.f19942a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r0.u() != false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        r0 = f7838g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r0 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        kotlin.jvm.internal.t.w("viewModel");
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        r1 = java.lang.String.valueOf(f7836e);
        r0.getClass();
        kotlin.jvm.internal.t.e(r1, "sessionId");
        r2 = k4.z.f24676a.toString();
        kotlin.jvm.internal.t.d(r2, "sessionID.toString()");
        r1 = kotlin.jvm.internal.t.a(r1, r2);
        r0.f840b.x();
        r2 = r0.f841c.f19281b.f19218I;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
        if (r2 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        r5 = com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode.GPP;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0074, code lost:
        if (r2.equals(r5.getValue()) != true) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        ((o4.m) r0.f849k).b(r5, true, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r2 = r0.f841c.f19281b.f19218I;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0084, code lost:
        if (r2 != null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        r5 = com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode.TCF;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0091, code lost:
        if (r2.equals(r5.getValue()) != true) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        ((o4.m) r0.f849k).b(r5, true, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009b, code lost:
        ((o4.m) r0.f849k).b(com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode.TCF_AND_GPP, true, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (r0.m() == false) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00aa, code lost:
        r2 = r0.f839a;
        r5 = r4.b.f25748N;
        r6 = new java.lang.StringBuilder();
        r6.append(r0.f841c.f19281b.f19232W.f19269c);
        r6.append(r0.f841c.f19281b.f19232W.f19267a);
        r2.i(r5, l4.e.b(r6.toString()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d4, code lost:
        r2 = r0.f850l;
        r2.getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00db, code lost:
        if (m.l.f960a == false) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00dd, code lost:
        r5 = m.l.f961b;
        r5.unsetAllOwnedItems();
        r6 = r2.f25612a;
        r7 = r4.b.f25750O;
        r8 = r6.l(r7);
        kotlin.jvm.internal.t.e(r5, "newVector");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ef, code lost:
        if (r8 != null) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f2, code lost:
        r8.forEach(new m.i(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fa, code lost:
        r6.h(r7, r5);
        r2 = r2.f25613b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ff, code lost:
        if (r2 != null) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0102, code lost:
        r2.onGoogleBasicConsentChange(m.l.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0109, code lost:
        if (r1 == false) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010b, code lost:
        w3.C2908y0 unused = w3.C2876i.d(w3.C2896s0.f26313a, w3.C2865c0.b(), (w3.O) null, new k4.v(s4.c.l().k(r4.b.f25783i), s4.c.l().k(r4.b.f25810x0), s4.c.l().k(r4.b.f25738I), (b3.C2308e) null), 2, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x013a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x013b, code lost:
        r0.f839a.e(r4.b.f25751O0);
        r0.f839a.e(r4.b.f25753P0);
        r0.f839a.e(r4.b.f25755Q0);
        r0.f839a.e(r4.b.f25757R0);
        r0.f839a.e(r4.b.f25759S0);
        r0.c(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0161, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        if (kotlin.jvm.internal.t.a(r0.k(r4.b.f25741J0), "Reject") != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a() {
        /*
            boolean r0 = f7835d
            java.lang.String r1 = "Reject"
            java.lang.String r2 = "storage"
            java.lang.String r3 = "viewModel"
            r4 = 0
            if (r0 == 0) goto L_0x0024
            b.x r0 = f7838g
            if (r0 != 0) goto L_0x0013
            kotlin.jvm.internal.t.w(r3)
            r0 = r4
        L_0x0013:
            r4.a r0 = r0.f839a
            kotlin.jvm.internal.t.e(r0, r2)
            r4.b r5 = r4.b.GDPR_STATUS
            java.lang.String r0 = r0.k(r5)
            boolean r0 = kotlin.jvm.internal.t.a(r0, r1)
            if (r0 == 0) goto L_0x0036
        L_0x0024:
            boolean r0 = f7835d
            if (r0 == 0) goto L_0x0162
            b.x r0 = f7838g
            if (r0 != 0) goto L_0x0030
            kotlin.jvm.internal.t.w(r3)
            r0 = r4
        L_0x0030:
            boolean r0 = r0.u()
            if (r0 == 0) goto L_0x0162
        L_0x0036:
            b.x r0 = f7838g
            if (r0 != 0) goto L_0x003e
            kotlin.jvm.internal.t.w(r3)
            r0 = r4
        L_0x003e:
            java.util.UUID r1 = f7836e
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.getClass()
            java.lang.String r2 = "sessionId"
            kotlin.jvm.internal.t.e(r1, r2)
            java.util.UUID r2 = k4.z.f24676a
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "sessionID.toString()"
            kotlin.jvm.internal.t.d(r2, r3)
            boolean r1 = kotlin.jvm.internal.t.a(r1, r2)
            J2.u r2 = r0.f840b
            r2.x()
            T3.i r2 = r0.f841c
            T3.c r2 = r2.f19281b
            java.lang.String r2 = r2.f19218I
            r3 = 1
            if (r2 != 0) goto L_0x006a
            goto L_0x007e
        L_0x006a:
            com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode r5 = com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode.GPP
            java.lang.String r6 = r5.getValue()
            boolean r2 = r2.equals(r6)
            if (r2 != r3) goto L_0x007e
            o4.j r2 = r0.f849k
            o4.m r2 = (o4.m) r2
            r2.b(r5, r3, r1)
            goto L_0x00a4
        L_0x007e:
            T3.i r2 = r0.f841c
            T3.c r2 = r2.f19281b
            java.lang.String r2 = r2.f19218I
            if (r2 != 0) goto L_0x0087
            goto L_0x009b
        L_0x0087:
            com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode r5 = com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode.TCF
            java.lang.String r6 = r5.getValue()
            boolean r2 = r2.equals(r6)
            if (r2 != r3) goto L_0x009b
            o4.j r2 = r0.f849k
            o4.m r2 = (o4.m) r2
            r2.b(r5, r3, r1)
            goto L_0x00a4
        L_0x009b:
            o4.j r2 = r0.f849k
            com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode r5 = com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode.TCF_AND_GPP
            o4.m r2 = (o4.m) r2
            r2.b(r5, r3, r1)
        L_0x00a4:
            boolean r2 = r0.m()
            if (r2 == 0) goto L_0x00d4
            r4.a r2 = r0.f839a
            r4.b r5 = r4.b.GBC_PURPOSE_HASH
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            T3.i r7 = r0.f841c
            T3.c r7 = r7.f19281b
            T3.f r7 = r7.f19232W
            java.util.List r7 = r7.f19269c
            r6.append(r7)
            T3.i r7 = r0.f841c
            T3.c r7 = r7.f19281b
            T3.f r7 = r7.f19232W
            boolean r7 = r7.f19267a
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = l4.e.b(r6)
            r2.i(r5, r6)
        L_0x00d4:
            o4.p r2 = r0.f850l
            r2.getClass()
            boolean r5 = m.l.f960a
            if (r5 == 0) goto L_0x0109
            com.inmobi.cmp.core.model.Vector r5 = m.l.f961b
            r5.unsetAllOwnedItems()
            r4.a r6 = r2.f25612a
            r4.b r7 = r4.b.GBC_CONSENT_STRING
            com.inmobi.cmp.core.model.Vector r8 = r6.l(r7)
            java.lang.String r9 = "newVector"
            kotlin.jvm.internal.t.e(r5, r9)
            if (r8 != 0) goto L_0x00f2
            goto L_0x00fa
        L_0x00f2:
            m.i r9 = new m.i
            r9.<init>(r5)
            r8.forEach(r9)
        L_0x00fa:
            r6.h(r7, r5)
            com.inmobi.cmp.ChoiceCmpCallback r2 = r2.f25613b
            if (r2 != 0) goto L_0x0102
            goto L_0x0109
        L_0x0102:
            com.inmobi.cmp.core.model.gbc.GoogleBasicConsents r5 = m.l.a()
            r2.onGoogleBasicConsentChange(r5)
        L_0x0109:
            if (r1 == 0) goto L_0x013b
            r4.a r0 = s4.c.l()
            r4.b r1 = r4.b.TC_STRING
            java.lang.String r0 = r0.k(r1)
            r4.a r1 = s4.c.l()
            r4.b r2 = r4.b.HDR_GPP_STRING
            java.lang.String r1 = r1.k(r2)
            r4.a r2 = s4.c.l()
            r4.b r3 = r4.b.NON_IAB_CONSENT_ENCODED
            java.lang.String r2 = r2.k(r3)
            w3.s0 r5 = w3.C2896s0.f26313a
            w3.I r6 = w3.C2865c0.b()
            k4.v r8 = new k4.v
            r8.<init>(r0, r1, r2, r4)
            r9 = 2
            r10 = 0
            r7 = 0
            w3.C2908y0 unused = w3.C2876i.d(r5, r6, r7, r8, r9, r10)
            return
        L_0x013b:
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.CONFIG_THEME_UUID
            r1.e(r2)
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.CONFIG_LANGUAGE
            r1.e(r2)
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.CONFIG_COP_APPLICABLE
            r1.e(r2)
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.CONFIG_ADV_APPLICABLE
            r1.e(r2)
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.CONFIG_GBC_APPLICABLE
            r1.e(r2)
            r0.c(r3)
            return
        L_0x0162:
            boolean r0 = f7835d
            if (r0 != 0) goto L_0x01eb
            b.x r0 = f7838g
            if (r0 != 0) goto L_0x016e
            kotlin.jvm.internal.t.w(r3)
            r0 = r4
        L_0x016e:
            r4.a r0 = r0.f839a
            kotlin.jvm.internal.t.e(r0, r2)
            r4.b r2 = r4.b.GDPR_STATUS
            java.lang.String r0 = r0.k(r2)
            boolean r0 = kotlin.jvm.internal.t.a(r0, r1)
            if (r0 == 0) goto L_0x01eb
            b.x r0 = f7838g
            if (r0 != 0) goto L_0x0187
            kotlin.jvm.internal.t.w(r3)
            r0 = r4
        L_0x0187:
            r0.f()
            int r1 = r1.C1797g.f16398e
            k1.a r2 = s4.c.g()
            r2.c(r1)
            r0.b()
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.CONFIG_THEME_UUID
            r1.e(r2)
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.CONFIG_LANGUAGE
            r1.e(r2)
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.CONFIG_COP_APPLICABLE
            r1.e(r2)
            r4.a r1 = r0.f839a
            r4.b r2 = r4.b.CONFIG_ADV_APPLICABLE
            r1.e(r2)
            r4.a r0 = r0.f839a
            r4.b r1 = r4.b.CONFIG_GBC_APPLICABLE
            r0.e(r1)
            k1.a r0 = s4.c.g()
            java.lang.String r0 = r0.e()
            r4.a r1 = s4.c.l()
            r4.b r2 = r4.b.HDR_GPP_STRING
            java.lang.String r5 = "gppString"
            kotlin.jvm.internal.t.d(r0, r5)
            r1.i(r2, r0)
            b.x r0 = f7838g
            if (r0 != 0) goto L_0x01d7
            kotlin.jvm.internal.t.w(r3)
            r0 = r4
        L_0x01d7:
            r4.a r0 = r0.f839a
            r4.b r1 = r4.b.GBC_CONSENT_STRING
            r0.e(r1)
            b.x r0 = f7838g
            if (r0 != 0) goto L_0x01e6
            kotlin.jvm.internal.t.w(r3)
            goto L_0x01e7
        L_0x01e6:
            r4 = r0
        L_0x01e7:
            r0 = 0
            r4.c(r0)
        L_0x01eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.a():void");
    }
}
