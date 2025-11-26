package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MIMManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f9548a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f9549b;

    /* renamed from: c  reason: collision with root package name */
    private int f9550c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CopyOnWriteArrayList<CampaignEx> f9551d;

    /* renamed from: e  reason: collision with root package name */
    private Context f9552e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile Boolean f9553f;

    /* renamed from: g  reason: collision with root package name */
    private CampaignEx f9554g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public volatile b f9555h;

    /* renamed from: i  reason: collision with root package name */
    private volatile MiOverseaMiniCardBroadcasterReceiver f9556i;

    public static class MiOverseaMiniCardBroadcasterReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            int i5;
            if (z.a("DFKwWgtuDkKwLZPwD+z8H+N/xjK+n3eyNVx6ZVPn5jcincKZx5f5ncN=").equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("packageName");
                int intExtra = intent.getIntExtra("errorCode", 0);
                if (intExtra < 0) {
                    i5 = intent.getIntExtra("reason", 0);
                } else {
                    i5 = -1;
                }
                af.b("MIMManager", stringExtra + " " + intExtra + " " + i5);
                if (intExtra == 1 || intExtra == 2 || intExtra == 3 || intExtra == 4 || intExtra == 7) {
                    try {
                        c cVar = new c();
                        e eVar = new e();
                        eVar.a("key", URLEncoder.encode("m_mini_card", "utf-8"));
                        CampaignEx a5 = a.f9573a.a(stringExtra);
                        if (a5 != null) {
                            eVar.a("rid", a5.getRequestId());
                            eVar.a("rid_n", a5.getRequestIdNotice());
                            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, a5.getCampaignUnitId());
                            eVar.a("u_stid", com.mbridge.msdk.foundation.controller.a.f8822b.get(a5.getCampaignUnitId()));
                            cVar.a(a5);
                        }
                        eVar.a(NotificationCompat.CATEGORY_EVENT, String.valueOf(intExtra));
                        eVar.a("pkg_name", stringExtra);
                        if (i5 != -1) {
                            eVar.a("reasonCode", String.valueOf(i5));
                        }
                        cVar.a("m_mini_card", eVar);
                        d.a().a("m_mini_card", cVar);
                    } catch (Exception e5) {
                        af.b("MIMManager", e5.getMessage());
                    }
                }
            }
        }
    }

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final MIMManager f9573a = new MIMManager();
    }

    private static class b extends BroadcastReceiver {
        private b() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x0089 A[Catch:{ Exception -> 0x0078 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(android.content.Context r9, android.content.Intent r10) {
            /*
                r8 = this;
                java.lang.String r0 = r10.getAction()
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 == 0) goto L_0x000c
                goto L_0x00b5
            L_0x000c:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.z.a(r1)
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x001a
                goto L_0x00b5
            L_0x001a:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.z.a(r1)
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0028
                goto L_0x00b5
            L_0x0028:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.z.a(r1)
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x00b5
                android.os.Bundle r10 = r10.getExtras()     // Catch:{ Exception -> 0x0078 }
                if (r10 != 0) goto L_0x003c
                goto L_0x00b5
            L_0x003c:
                java.lang.String r0 = "statusCode"
                r1 = -1
                int r7 = r10.getInt(r0, r1)     // Catch:{ Exception -> 0x0078 }
                java.lang.String r0 = "packageName"
                java.lang.String r2 = ""
                java.lang.String r10 = r10.getString(r0, r2)     // Catch:{ Exception -> 0x0078 }
                if (r7 == r1) goto L_0x00b5
                boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0078 }
                if (r0 == 0) goto L_0x0054
                goto L_0x00b5
            L_0x0054:
                com.mbridge.msdk.foundation.tools.MIMManager r0 = com.mbridge.msdk.foundation.tools.MIMManager.a.f9573a     // Catch:{ Exception -> 0x0078 }
                com.mbridge.msdk.foundation.entity.CampaignEx r10 = r0.a((java.lang.String) r10)     // Catch:{ Exception -> 0x0078 }
                if (r10 != 0) goto L_0x005f
                goto L_0x00b5
            L_0x005f:
                com.mbridge.msdk.foundation.tools.MIMManager r0 = com.mbridge.msdk.foundation.tools.MIMManager.a.f9573a     // Catch:{ Exception -> 0x0078 }
                r1 = 3001(0xbb9, float:4.205E-42)
                if (r7 == r1) goto L_0x0081
                r1 = 3002(0xbba, float:4.207E-42)
                if (r7 == r1) goto L_0x007b
                r1 = 3008(0xbc0, float:4.215E-42)
                if (r7 == r1) goto L_0x0071
                r10 = 0
                goto L_0x0087
            L_0x0071:
                com.mbridge.msdk.foundation.tools.MIMManager$4 r1 = new com.mbridge.msdk.foundation.tools.MIMManager$4     // Catch:{ Exception -> 0x0078 }
                r1.<init>(r9, r10)     // Catch:{ Exception -> 0x0078 }
            L_0x0076:
                r10 = r1
                goto L_0x0087
            L_0x0078:
                r0 = move-exception
                r9 = r0
                goto L_0x00ac
            L_0x007b:
                com.mbridge.msdk.foundation.tools.MIMManager$3 r1 = new com.mbridge.msdk.foundation.tools.MIMManager$3     // Catch:{ Exception -> 0x0078 }
                r1.<init>(r9, r10)     // Catch:{ Exception -> 0x0078 }
                goto L_0x0076
            L_0x0081:
                com.mbridge.msdk.foundation.tools.MIMManager$2 r1 = new com.mbridge.msdk.foundation.tools.MIMManager$2     // Catch:{ Exception -> 0x0078 }
                r1.<init>(r9, r10)     // Catch:{ Exception -> 0x0078 }
                goto L_0x0076
            L_0x0087:
                if (r10 == 0) goto L_0x0090
                java.util.concurrent.ThreadPoolExecutor r0 = com.mbridge.msdk.foundation.same.f.a.b()     // Catch:{ Exception -> 0x0078 }
                r0.execute(r10)     // Catch:{ Exception -> 0x0078 }
            L_0x0090:
                com.mbridge.msdk.foundation.tools.MIMManager r3 = com.mbridge.msdk.foundation.tools.MIMManager.a.f9573a     // Catch:{ Exception -> 0x0078 }
                java.lang.String r5 = "dm_page_status"
                com.mbridge.msdk.foundation.tools.MIMManager r10 = com.mbridge.msdk.foundation.tools.MIMManager.a.f9573a     // Catch:{ Exception -> 0x0078 }
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = r10.b()     // Catch:{ Exception -> 0x0078 }
                java.util.concurrent.ThreadPoolExecutor r10 = com.mbridge.msdk.foundation.same.f.a.b()     // Catch:{ Exception -> 0x0078 }
                com.mbridge.msdk.foundation.tools.MIMManager$5 r2 = new com.mbridge.msdk.foundation.tools.MIMManager$5     // Catch:{ Exception -> 0x0078 }
                r4 = r9
                r2.<init>(r4, r5, r6, r7)     // Catch:{ Exception -> 0x0078 }
                r10.execute(r2)     // Catch:{ Exception -> 0x0078 }
                return
            L_0x00ac:
                java.lang.String r10 = "MIMManager"
                java.lang.String r9 = r9.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r10, r9)
            L_0x00b5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.MIMManager.b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* access modifiers changed from: private */
    public Boolean g() {
        Cursor cursor;
        Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
        Boolean bool = null;
        if (c5 != null) {
            try {
                if (c5.getContentResolver() != null) {
                    try {
                        cursor = c5.getContentResolver().query(Uri.parse(z.a("DFK/J75/JaEXWFfXYZP9LkcXYk3/YkcBLF5TWgSBYbHuH75BW3xuhr5UJj2tLkeNhrKFLkxQhl==")), (String[]) null, (String) null, (String[]) null, (String) null);
                    } catch (Exception unused) {
                        cursor = null;
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("support"));
                                if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("null")) {
                                    if (!string.equalsIgnoreCase("false")) {
                                        if (string.equalsIgnoreCase("true")) {
                                        }
                                    }
                                    bool = Boolean.valueOf(Boolean.parseBoolean(string));
                                }
                            } catch (Exception e5) {
                                af.a("MIMManager", e5.getMessage());
                            }
                            try {
                                f9548a = cursor.getString(cursor.getColumnIndex("detailStyle"));
                            } catch (Exception e6) {
                                af.a("MIMManager", e6.getMessage());
                            }
                        }
                        try {
                            cursor.close();
                        } catch (Exception e7) {
                            af.a("MIMManager", e7.getMessage());
                        }
                    }
                }
            } catch (Exception e8) {
                af.b("MIMManager", e8.getMessage());
            }
        }
        return bool;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r0.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        r4.f9551d = null;
        r4.f9555h = null;
        r4.f9552e = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        if (r0 == null) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r4 = this;
            int r0 = r4.f9550c
            int r0 = r0 + -1
            r4.f9550c = r0
            if (r0 > 0) goto L_0x0089
            android.content.Context r0 = r4.f9552e
            java.lang.String r1 = "MIMManager"
            r2 = 0
            if (r0 == 0) goto L_0x0054
            com.mbridge.msdk.foundation.tools.MIMManager$b r3 = r4.f9555h     // Catch:{ Exception -> 0x001b }
            if (r3 == 0) goto L_0x001d
            com.mbridge.msdk.foundation.tools.MIMManager$b r3 = r4.f9555h     // Catch:{ Exception -> 0x001b }
            r0.unregisterReceiver(r3)     // Catch:{ Exception -> 0x001b }
            goto L_0x001d
        L_0x0019:
            r0 = move-exception
            goto L_0x0044
        L_0x001b:
            r0 = move-exception
            goto L_0x0036
        L_0x001d:
            com.mbridge.msdk.foundation.tools.MIMManager$MiOverseaMiniCardBroadcasterReceiver r3 = r4.f9556i     // Catch:{ Exception -> 0x001b }
            if (r3 == 0) goto L_0x0026
            com.mbridge.msdk.foundation.tools.MIMManager$MiOverseaMiniCardBroadcasterReceiver r3 = r4.f9556i     // Catch:{ Exception -> 0x001b }
            r0.unregisterReceiver(r3)     // Catch:{ Exception -> 0x001b }
        L_0x0026:
            r4.f9554g = r2
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r4.f9551d
            if (r0 == 0) goto L_0x002f
        L_0x002c:
            r0.clear()
        L_0x002f:
            r4.f9551d = r2
            r4.f9555h = r2
            r4.f9552e = r2
            goto L_0x0054
        L_0x0036:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0019 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x0019 }
            r4.f9554g = r2
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r4.f9551d
            if (r0 == 0) goto L_0x002f
            goto L_0x002c
        L_0x0044:
            r4.f9554g = r2
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r4.f9551d
            if (r1 == 0) goto L_0x004d
            r1.clear()
        L_0x004d:
            r4.f9551d = r2
            r4.f9555h = r2
            r4.f9552e = r2
            throw r0
        L_0x0054:
            com.mbridge.msdk.foundation.tools.MIMManager$MiOverseaMiniCardBroadcasterReceiver r0 = r4.f9556i     // Catch:{ Exception -> 0x006a }
            if (r0 == 0) goto L_0x0089
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x006a }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x006a }
            if (r0 == 0) goto L_0x006c
            com.mbridge.msdk.foundation.tools.MIMManager$MiOverseaMiniCardBroadcasterReceiver r3 = r4.f9556i     // Catch:{ Exception -> 0x006a }
            r0.unregisterReceiver(r3)     // Catch:{ Exception -> 0x006a }
            goto L_0x006c
        L_0x0068:
            r0 = move-exception
            goto L_0x0082
        L_0x006a:
            r0 = move-exception
            goto L_0x007a
        L_0x006c:
            r4.f9554g = r2     // Catch:{ Exception -> 0x006a }
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r4.f9551d     // Catch:{ Exception -> 0x006a }
            if (r0 == 0) goto L_0x0075
            r0.clear()     // Catch:{ Exception -> 0x006a }
        L_0x0075:
            r4.f9551d = r2     // Catch:{ Exception -> 0x006a }
            r4.f9556i = r2     // Catch:{ Exception -> 0x006a }
            goto L_0x0089
        L_0x007a:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0068 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x0068 }
            goto L_0x0089
        L_0x0082:
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.MIMManager.f():void");
    }

    private MIMManager() {
        this.f9550c = 0;
        this.f9551d = new CopyOnWriteArrayList<>();
        this.f9549b = new AtomicBoolean(false);
    }

    /* access modifiers changed from: package-private */
    public final CampaignEx b() {
        return this.f9554g;
    }

    public final String c() {
        try {
            if (f9548a == null) {
                return "";
            }
            return String.format("[%s]", new Object[]{f9548a});
        } catch (Exception unused) {
            return "";
        }
    }

    public final Boolean d() {
        return this.f9553f;
    }

    public final void e() {
        this.f9550c++;
    }

    public final void b(CampaignEx campaignEx) {
        try {
            if (this.f9553f != null && campaignEx != null && this.f9553f.booleanValue()) {
                this.f9554g = null;
                try {
                    this.f9551d.remove(campaignEx);
                } catch (Exception e5) {
                    af.a("MIMManager", e5.getMessage());
                }
            }
        } catch (Exception e6) {
            af.b("MIMManager", e6.getMessage());
        }
    }

    public static MIMManager a() {
        return a.f9573a;
    }

    public final void a(CampaignEx campaignEx) {
        try {
            if (!(this.f9553f == null || campaignEx == null || !this.f9553f.booleanValue())) {
                this.f9554g = campaignEx;
                this.f9551d.add(campaignEx);
            }
            if (com.mbridge.msdk.e.b.b() && campaignEx != null && campaignEx.getDeepLinkURL().startsWith("mimarket")) {
                if (this.f9556i == null) {
                    try {
                        if (this.f9556i == null) {
                            this.f9556i = new MiOverseaMiniCardBroadcasterReceiver();
                        }
                        IntentFilter intentFilter = new IntentFilter(z.a("DFKwWgtuDkKwLZPwD+z8H+N/xjK+n3eyNVx6ZVPn5jcincKZx5f5ncN="));
                        Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                        if (c5 != null) {
                            c5.registerReceiver(this.f9556i, intentFilter);
                        }
                    } catch (Exception e5) {
                        af.a("MIMManager", e5.getMessage());
                    }
                }
                this.f9554g = campaignEx;
                this.f9551d.add(campaignEx);
            }
        } catch (Exception e6) {
            af.b("MIMManager", e6.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public CampaignEx a(String str) {
        try {
            CampaignEx campaignEx = this.f9554g;
            if (campaignEx != null && TextUtils.equals(campaignEx.getPackageName(), str)) {
                return this.f9554g;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f9551d;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return null;
            }
            Iterator<CampaignEx> it = this.f9551d.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null && TextUtils.equals(next.getPackageName(), str)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e5) {
            af.b("MIMManager", e5.getMessage());
            return null;
        }
    }

    public final void a(final Context context) {
        this.f9552e = context;
        com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
            public final void run() {
                if (MIMManager.this.f9549b.compareAndSet(false, true)) {
                    try {
                        MIMManager mIMManager = MIMManager.this;
                        Boolean unused = mIMManager.f9553f = mIMManager.g();
                    } catch (Exception e5) {
                        af.a("MIMManager", e5.getMessage());
                    }
                    if (MIMManager.this.f9553f != null && MIMManager.this.f9553f.booleanValue() && context != null) {
                        try {
                            b unused2 = MIMManager.this.f9555h = new b();
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(z.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="));
                            intentFilter.addAction(z.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="));
                            intentFilter.addAction(z.a("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"));
                            context.registerReceiver(MIMManager.this.f9555h, intentFilter);
                        } catch (Exception e6) {
                            af.a("MIMManager", e6.getMessage());
                        }
                    }
                }
            }
        });
    }
}
