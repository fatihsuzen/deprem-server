package com.mbridge.msdk.foundation.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONArray;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f8929a = -2;

    /* renamed from: b  reason: collision with root package name */
    public static int f8930b = -2;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f8931c = false;

    /* renamed from: d  reason: collision with root package name */
    private final RelativeLayout.LayoutParams f8932d;

    /* renamed from: e  reason: collision with root package name */
    private final ConcurrentHashMap<String, com.mbridge.msdk.foundation.d.a.a> f8933e;

    /* renamed from: f  reason: collision with root package name */
    private g f8934f;

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f8935a = new b();
    }

    public static b a() {
        return a.f8935a;
    }

    private com.mbridge.msdk.foundation.d.a.a d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c.m().k();
        }
        if (this.f8933e.containsKey(str)) {
            return this.f8933e.get(str);
        }
        return null;
    }

    public final boolean b() {
        g b5 = h.a().b(c.m().k());
        this.f8934f = b5;
        if (b5 != null) {
            return false;
        }
        h.a();
        this.f8934f = i.a();
        return false;
    }

    public final void c(String str) {
        try {
            com.mbridge.msdk.foundation.d.a.a d5 = d(str);
            if (d5 != null) {
                d5.a();
            }
            this.f8933e.remove(str);
            f8931c = false;
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private b() {
        this.f8932d = new RelativeLayout.LayoutParams(f8930b, f8929a);
        this.f8933e = new ConcurrentHashMap<>();
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3, android.content.Context r4, android.view.ViewGroup r5, android.view.ViewGroup.LayoutParams r6, com.mbridge.msdk.foundation.d.a r7) {
        /*
            r2 = this;
            boolean r0 = r2.b()
            if (r0 != 0) goto L_0x0007
            goto L_0x0057
        L_0x0007:
            com.mbridge.msdk.foundation.d.a.a r0 = r2.a((java.lang.String) r3)
            if (r7 == 0) goto L_0x0015
            com.mbridge.msdk.foundation.d.a.a$a r1 = new com.mbridge.msdk.foundation.d.a.a$a
            r1.<init>(r3, r7)
            r0.a((com.mbridge.msdk.foundation.d.a.a.C0086a) r1)
        L_0x0015:
            com.mbridge.msdk.widget.FeedBackButton r3 = r0.d()
            if (r3 == 0) goto L_0x0057
            if (r6 != 0) goto L_0x0032
            com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r6 = r6.c()
            r7 = 1092616192(0x41200000, float:10.0)
            int r6 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r6, (float) r7)
            android.widget.RelativeLayout$LayoutParams r7 = r2.f8932d
            r7.setMargins(r6, r6, r6, r6)
            android.widget.RelativeLayout$LayoutParams r6 = r2.f8932d
        L_0x0032:
            android.view.ViewParent r7 = r3.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            if (r7 == 0) goto L_0x003d
            r7.removeView(r3)
        L_0x003d:
            android.app.Activity r4 = r2.a((android.content.Context) r4)
            if (r4 == 0) goto L_0x004f
            if (r5 != 0) goto L_0x004f
            r5 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r4 = r4.findViewById(r5)
            r5 = r4
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
        L_0x004f:
            if (r5 == 0) goto L_0x0057
            r5.removeView(r3)
            r5.addView(r3, r6)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.d.b.a(java.lang.String, android.content.Context, android.view.ViewGroup, android.view.ViewGroup$LayoutParams, com.mbridge.msdk.foundation.d.a):void");
    }

    public final FeedBackButton b(String str) {
        return a(str).d();
    }

    public final void b(String str, int i5) {
        a(str).b(i5);
    }

    public final com.mbridge.msdk.foundation.d.a.a a(String str) {
        com.mbridge.msdk.foundation.d.a.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = c.m().k();
        }
        if (!this.f8933e.containsKey(str)) {
            aVar = new com.mbridge.msdk.foundation.d.a.a(str);
            this.f8933e.put(str, aVar);
        } else {
            aVar = this.f8933e.get(str);
        }
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.foundation.d.a.a aVar2 = new com.mbridge.msdk.foundation.d.a.a(str);
        this.f8933e.put(str, aVar2);
        return aVar2;
    }

    public final Activity a(Context context) {
        Activity activity;
        Context e5 = c.m().e();
        Activity activity2 = null;
        try {
            Activity activity3 = e5 instanceof Activity ? (Activity) e5 : null;
            try {
                if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
                    activity3 = (Activity) context;
                }
                WeakReference<Activity> a5 = c.m().a();
                if (a5 != null && (activity = a5.get()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    activity3 = activity;
                }
                if (activity3 == null || activity3.isFinishing() || activity3.isDestroyed()) {
                    return null;
                }
                return activity3;
            } catch (Exception e6) {
                e = e6;
                activity2 = activity3;
                e.printStackTrace();
                return activity2;
            }
        } catch (Exception e7) {
            e = e7;
            e.printStackTrace();
            return activity2;
        }
    }

    public final void a(String str, int i5, ViewGroup viewGroup) {
        com.mbridge.msdk.foundation.d.a.a a5 = a(str);
        if (a5.d() != null) {
            a5.c(i5);
            if (i5 == 0) {
                a(str, c.m().c(), viewGroup, (ViewGroup.LayoutParams) null, (a) null);
            }
        }
    }

    public final void a(String str, int i5, int i6, int i7, float f5, float f6, float f7, String str2, String str3, float f8, JSONArray jSONArray) {
        com.mbridge.msdk.foundation.d.a.a a5 = a(str);
        Context c5 = c.m().c();
        int a6 = ak.a(c5, f5);
        int a7 = ak.a(c5, f6);
        int a8 = ak.a(c5, (float) i5);
        int a9 = ak.a(c5, (float) i6);
        int a10 = ak.a(c5, (float) i7);
        int i8 = a8;
        a5.a(a6, a7, i8, a9, a10, f7, str2, str3, f8, jSONArray);
    }

    public final void a(String str, int i5, a aVar) {
        com.mbridge.msdk.foundation.d.a.a a5 = a(str);
        a5.a(new a.C0086a(str, aVar));
        if (i5 == 1) {
            a5.b();
        } else {
            a5.e();
        }
    }

    public final void a(String str, int i5, int i6, String str2, String str3) {
        String str4;
        com.mbridge.msdk.foundation.d.a.a d5 = d(str + "_" + 1);
        int i7 = 0;
        if (d5 == null) {
            d5 = d(str + "_" + 2);
            if (d5 == null) {
                d5 = d(str + "_" + 3);
                if (d5 == null) {
                    d5 = d(str + "_" + 4);
                    if (d5 == null) {
                        d5 = a(str);
                    }
                }
            }
            d5.b(0);
        }
        if (d5 != null) {
            CampaignEx c5 = d5.c();
            String campaignUnitId = c5 != null ? c5.getCampaignUnitId() : "";
            int g5 = d5.g();
            int f5 = d5.f();
            if (!TextUtils.isEmpty(str2)) {
                str4 = str2;
            } else {
                str4 = "";
            }
            if (c5 != null) {
                i7 = c5.getAdType();
            }
            com.mbridge.msdk.foundation.same.report.i.a(c5, campaignUnitId, g5, f5, str4, i5, i7, i6, str3);
        }
    }

    public final void a(String str, CampaignEx campaignEx) {
        a(str).a(campaignEx);
    }

    public final void a(String str, String str2) {
        a(str).a(str2);
    }

    public final void a(String str, FeedBackButton feedBackButton) {
        a(str).a(feedBackButton);
    }

    public final void a(String str, a aVar) {
        com.mbridge.msdk.foundation.d.a.a a5 = a(str);
        if (aVar != null) {
            a5.a(new a.C0086a(str, aVar));
        }
    }

    public final void a(String str, int i5) {
        a(str).a(i5);
    }

    public final boolean a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog != null) {
            return a(context, mBFeedBackDialog);
        }
        af.c("", "mbAlertDialog  is null");
        return false;
    }

    private boolean a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity a5 = a(context);
        if (a5 == null || mBFeedBackDialog == null || a5.isDestroyed()) {
            return false;
        }
        try {
            if (!mBFeedBackDialog.isShowing() && !a5.isFinishing()) {
                mBFeedBackDialog.show();
                return true;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return false;
    }
}
