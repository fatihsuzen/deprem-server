package com.inmobi.cmp.presentation.components;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import b3.C2308e;
import b3.C2312i;
import com.inmobi.cmp.data.model.ThemeMode;
import kotlin.jvm.internal.t;
import s4.c;
import v4.d;
import v4.f;
import w3.C2908y0;
import w3.O;

public final class CmpActivity extends AppCompatActivity {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f7847b = 0;

    /* renamed from: a  reason: collision with root package name */
    public f f7848a;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: v4.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: v4.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: v4.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: v4.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: v4.f} */
    /* JADX WARNING: type inference failed for: r1v12, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(k4.h r13, boolean r14) {
        /*
            r12 = this;
            java.lang.String r0 = "regulation"
            r1 = 0
            if (r14 != 0) goto L_0x001c
            v4.f r2 = r12.f7848a
            if (r2 == 0) goto L_0x000b
            r1 = r2
            goto L_0x0010
        L_0x000b:
            java.lang.String r2 = "viewModel"
            kotlin.jvm.internal.t.w(r2)
        L_0x0010:
            r1.getClass()
            kotlin.jvm.internal.t.e(r13, r0)
            r4.a r1 = r1.f26066a
            java.lang.String r1 = V2.a.a(r13, r1)
        L_0x001c:
            r5 = r1
            java.util.UUID r1 = k4.z.f24676a
            kotlin.jvm.internal.t.e(r13, r0)
            kotlin.jvm.internal.L r3 = new kotlin.jvm.internal.L
            r3.<init>()
            r3.f24690a = r13
            kotlin.jvm.internal.L r4 = new kotlin.jvm.internal.L
            r4.<init>()
            k4.e r0 = k4.e.TCF_CHANGE_OF_CONSENT
            r4.f24690a = r0
            int r1 = r13.ordinal()
            if (r1 == 0) goto L_0x0094
            r2 = 1
            if (r1 == r2) goto L_0x008d
            r0 = 2
            r2 = 0
            java.lang.String r6 = "preferenceKey"
            if (r1 == r0) goto L_0x006a
            r0 = 3
            if (r1 == r0) goto L_0x0045
            goto L_0x0098
        L_0x0045:
            boolean r0 = m.l.f960a
            if (r0 == 0) goto L_0x0065
            r4.a r0 = s4.c.l()
            r4.b r1 = r4.b.GBC_SHOWN
            r0.getClass()
            kotlin.jvm.internal.t.e(r1, r6)
            android.content.SharedPreferences r0 = r0.f25721a
            java.lang.String r1 = "GBCShown"
            boolean r0 = r0.getBoolean(r1, r2)
            if (r0 == 0) goto L_0x0062
            k4.e r0 = k4.e.GBC_CHANGE_OF_CONSENT
            goto L_0x0067
        L_0x0062:
            k4.e r0 = k4.e.GBC
            goto L_0x0067
        L_0x0065:
            k4.e r0 = k4.e.NR
        L_0x0067:
            r4.f24690a = r0
            goto L_0x0098
        L_0x006a:
            if (r14 == 0) goto L_0x006f
            k4.e r0 = k4.e.MSPA_MANDATORY
            goto L_0x008a
        L_0x006f:
            r4.a r0 = s4.c.l()
            r4.b r1 = r4.b.MSPA_SHOWN
            r0.getClass()
            kotlin.jvm.internal.t.e(r1, r6)
            android.content.SharedPreferences r0 = r0.f25721a
            java.lang.String r1 = "MSPAShown"
            boolean r0 = r0.getBoolean(r1, r2)
            if (r0 == 0) goto L_0x0088
            k4.e r0 = k4.e.MSPA_CHANGE_OF_CONSENT
            goto L_0x008a
        L_0x0088:
            k4.e r0 = k4.e.MSPA_OPT_OUT
        L_0x008a:
            r4.f24690a = r0
            goto L_0x0098
        L_0x008d:
            if (r14 == 0) goto L_0x0091
            k4.e r0 = k4.e.TCF_MANDATORY
        L_0x0091:
            r4.f24690a = r0
            goto L_0x0098
        L_0x0094:
            k4.e r0 = k4.e.USP
            r4.f24690a = r0
        L_0x0098:
            k4.l r0 = k4.z.f24677b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Object r2 = r3.f24690a
            r1.append(r2)
            java.lang.String r2 = "_1"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "startOnPage"
            r0.i(r2, r1)
            java.util.UUID r0 = java.util.UUID.randomUUID()
            k4.z.f24676a = r0
            k4.h r0 = k4.h.GDPR
            if (r13 != r0) goto L_0x00c3
            com.inmobi.cmp.ChoiceCmp r13 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            java.util.UUID r0 = k4.z.f24676a
            r13.setCurrentSessionId(r0)
        L_0x00c3:
            w3.s0 r13 = w3.C2896s0.f26313a
            w3.I r0 = w3.C2865c0.b()
            k4.w r2 = new k4.w
            r7 = 0
            r6 = r14
            r2.<init>(r3, r4, r5, r6, r7)
            r10 = 2
            r11 = 0
            r8 = 0
            r6 = r13
            r7 = r0
            r9 = r2
            w3.C2908y0 unused = w3.C2876i.d(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.presentation.components.CmpActivity.l(k4.h, boolean):void");
    }

    public final void onCreate(Bundle bundle) {
        int i5;
        super.onCreate(bundle);
        ThemeMode themeMode = c.f25855c.getThemeMode();
        if (themeMode == null) {
            i5 = -1;
        } else {
            i5 = v4.c.f26061a[themeMode.ordinal()];
        }
        if (i5 == 1) {
            getDelegate().setLocalNightMode(1);
        } else if (i5 == 2) {
            getDelegate().setLocalNightMode(2);
        }
        t.e(this, "context");
        f fVar = new f(c.l(), c.b(this), c.j());
        t.e(fVar, "<set-?>");
        this.f7848a = fVar;
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new d(this, (C2308e) null), 3, (Object) null);
    }
}
