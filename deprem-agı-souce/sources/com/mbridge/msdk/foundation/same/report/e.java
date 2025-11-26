package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.a;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.same.report.e.b;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.m;
import com.mbridge.msdk.tracker.o;
import com.mbridge.msdk.tracker.v;
import com.mbridge.msdk.tracker.w;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f9506a = "e";

    /* renamed from: b  reason: collision with root package name */
    private static String f9507b = "roas";

    /* renamed from: c  reason: collision with root package name */
    private static volatile e f9508c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f9509d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public BatchReportDao f9510e;

    /* renamed from: f  reason: collision with root package name */
    private int f9511f = 1;

    /* renamed from: g  reason: collision with root package name */
    private long f9512g = 0;

    /* renamed from: h  reason: collision with root package name */
    private String f9513h = d.f().f9345F;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile int f9514i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f9515j = false;

    /* renamed from: k  reason: collision with root package name */
    private Executor f9516k = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public Handler f9517l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Stack<Long> f9518m;

    /* renamed from: n  reason: collision with root package name */
    private m f9519n;

    private e() {
        a q5;
        boolean z4;
        o oVar;
        String str;
        g b5 = h.a().b(c.m().k());
        if (!(b5 == null || (q5 = b5.q()) == null)) {
            this.f9511f = q5.a();
            this.f9512g = ((long) q5.c()) * 1000;
            this.f9513h = d.f().f9345F;
            this.f9514i = q5.b();
            if (q5.d() == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f9515j = z4;
            if (z4 && this.f9514i != 1) {
                int a5 = ah.a().a("bcp", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, ah.a().a("t_r_t", 1));
                if (!(a5 == 0 || a5 == 1)) {
                    a5 = 0;
                }
                w.a a6 = new w.a().a((com.mbridge.msdk.tracker.d) new d()).a((v) new m());
                if (a5 == 1) {
                    oVar = new o(new l((byte) 2), d.f().f9376k, d.f().f9380o);
                } else {
                    oVar = new o(new com.mbridge.msdk.tracker.network.toolbox.h(), d.f().f9345F, 0);
                }
                this.f9519n = m.a(f9507b, c.m().c(), a6.a(a5, oVar).e(ah.a().a("t_m_e_t", 604800000)).a(ah.a().a("t_m_e_s", 50)).d(ah.a().a("t_m_r_c", 50)).b(ah.a().a("t_m_t", (int) DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).c(ah.a().a("t_m_r_t_s", 1)).a());
                JSONObject a7 = c.a();
                try {
                    if (ab.w(c.m().c())) {
                        str = "pad";
                    } else {
                        str = "phone";
                    }
                    a7.put("device_type", str);
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                        a7.put(com.mbridge.msdk.foundation.same.net.f.e.f9400g, ab.n());
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                this.f9519n.a(a7);
                this.f9519n.a();
            }
        }
        af.a(f9506a, "初始化批量上报： " + this.f9513h + " " + this.f9511f + " " + this.f9512g + " " + this.f9514i);
        this.f9509d = new AtomicInteger(0);
        this.f9518m = new Stack<>();
        this.f9510e = BatchReportDao.getInstance(c.m().c());
        HandlerThread handlerThread = new HandlerThread("mb_revenue_batch_report_thread");
        handlerThread.start();
        this.f9517l = new Handler(handlerThread.getLooper()) {
            public final void handleMessage(Message message) {
                int i5 = message.what;
                int i6 = 0;
                if (i5 == 1) {
                    Bundle data = message.getData();
                    if (e.this.f9517l != null && e.this.f9510e != null && data != null) {
                        e.this.f9517l.removeMessages(2);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<BatchReportMessage> batchReportMessages = e.this.f9510e.getBatchReportMessages(currentTimeMillis, 2);
                        e.a(e.this, (ArrayList) batchReportMessages, currentTimeMillis);
                        e.this.f9509d.set(0);
                        String c5 = e.f9506a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("超时上报触发了，需要上报的数据： ");
                        if (batchReportMessages != null) {
                            i6 = batchReportMessages.size();
                        }
                        sb.append(i6);
                        af.a(c5, sb.toString());
                    }
                } else if (i5 == 2) {
                    Bundle data2 = message.getData();
                    if (e.this.f9517l != null && e.this.f9510e != null && data2 != null) {
                        e.this.f9517l.removeMessages(1);
                        long j5 = data2.getLong("last_report_time");
                        ArrayList<BatchReportMessage> batchReportMessages2 = e.this.f9510e.getBatchReportMessages(j5, 2);
                        e.a(e.this, (ArrayList) batchReportMessages2, j5);
                        String c6 = e.f9506a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("队列上报触发了，需要上报的数据： ");
                        if (batchReportMessages2 != null) {
                            i6 = batchReportMessages2.size();
                        }
                        sb2.append(i6);
                        af.a(c6, sb2.toString());
                    }
                } else if (i5 == 3) {
                    Bundle data3 = message.getData();
                    if (data3 != null) {
                        e.b(e.this, data3.getParcelableArrayList("report_message"), data3.getLong("last_report_time"));
                    }
                } else if (i5 == 4) {
                    Bundle data4 = message.getData();
                    if (e.this.f9517l != null && e.this.f9510e != null && data4 != null && e.this.f9515j) {
                        e.this.f9517l.removeMessages(4);
                        ArrayList<BatchReportMessage> batchReportMessages3 = e.this.f9510e.getBatchReportMessages(System.currentTimeMillis(), 2);
                        if (batchReportMessages3 != null && batchReportMessages3.size() > 0) {
                            for (int i7 = 0; i7 < batchReportMessages3.size(); i7++) {
                                BatchReportMessage batchReportMessage = batchReportMessages3.get(i7);
                                e.a(e.this, batchReportMessage.getReportMessage(), batchReportMessage.getTimestamp());
                            }
                        }
                        String c7 = e.f9506a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("切换上报lib，需要上报的数据： ");
                        if (batchReportMessages3 != null) {
                            i6 = batchReportMessages3.size();
                        }
                        sb3.append(i6);
                        af.a(c7, sb3.toString());
                    }
                }
            }
        };
    }

    private JSONObject b(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String split : str.split("&")) {
                    String[] split2 = split.split("=");
                    if (split2.length == 2) {
                        jSONObject.put(split2[0], split2[1]);
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                return jSONObject;
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public void a(int i5, String str) {
        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
        eVar.a(MRAIDCommunicatorUtil.KEY_STATE, Integer.valueOf(i5));
        if (i5 == 2) {
            eVar.a("reason", str);
        }
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        cVar.a("m_ad_rev_s_s", eVar);
        com.mbridge.msdk.foundation.same.report.d.d.a().a("m_ad_rev_s_s", cVar);
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f9508c == null) {
                    f9508c = new e();
                }
                eVar = f9508c;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return eVar;
    }

    public final void b() {
        Handler handler = this.f9517l;
        if (handler != null && !handler.hasMessages(1) && this.f9514i != 1 && !this.f9515j) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f9517l.sendMessageDelayed(obtain, 5000);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(final java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.f9514i     // Catch:{ all -> 0x0018 }
            r1 = 1
            if (r0 != r1) goto L_0x0008
            monitor-exit(r2)
            return
        L_0x0008:
            com.mbridge.msdk.foundation.same.report.e$3 r0 = new com.mbridge.msdk.foundation.same.report.e$3     // Catch:{ all -> 0x0018 }
            r0.<init>(r3)     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.controller.d.a()     // Catch:{ all -> 0x0018 }
            java.util.concurrent.Executor r3 = r2.f9516k     // Catch:{ all -> 0x0018 }
            if (r3 == 0) goto L_0x001a
            r3.execute(r0)     // Catch:{ all -> 0x0018 }
            goto L_0x001d
        L_0x0018:
            r3 = move-exception
            goto L_0x001f
        L_0x001a:
            r0.run()     // Catch:{ all -> 0x0018 }
        L_0x001d:
            monitor-exit(r2)
            return
        L_0x001f:
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.e.a(java.lang.String):void");
    }

    static /* synthetic */ void b(e eVar, final ArrayList arrayList, final long j5) {
        if (arrayList == null || arrayList.size() <= 0) {
            af.a(f9506a, "需要上报的数据条数： 0");
            return;
        }
        af.a(f9506a, "需要上报的数据条数： " + arrayList.size());
        Context c5 = c.m().c();
        if (c5 != null) {
            com.mbridge.msdk.foundation.same.net.f.e a5 = i.a(c5);
            a5.a(MBridgeConstans.APP_ID, c.m().k());
            a5.a("m_sdk", "msdk");
            a5.a("lqswt", String.valueOf(1));
            a5.a("device_type", ab.w(c5) ? "pad" : "phone");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                a5.a(com.mbridge.msdk.foundation.same.net.f.e.f9400g, ab.n());
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                try {
                    BatchReportMessage batchReportMessage = (BatchReportMessage) arrayList.get(i5);
                    if (batchReportMessage != null) {
                        sb.append(batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp());
                        if (i5 >= 0 && i5 < size - 1) {
                            sb.append("\n");
                        }
                    }
                    i5++;
                } catch (Throwable th) {
                    af.b(f9506a, th.getMessage());
                }
            }
            try {
                String encode = URLEncoder.encode(sb.toString(), "utf-8");
                a5.a(DataSchemeDataSource.SCHEME_DATA, encode);
                af.a(f9506a, "需要批量上报的数据： " + encode);
                com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(c.m().c());
                eVar.a(0, "");
                aVar.post(0, eVar.f9513h, a5, new b() {
                    public final void a(String str) {
                        af.a(e.f9506a, "批量上报成功");
                        e.this.a(1, "");
                        try {
                            if (e.this.f9510e != null) {
                                e.this.f9510e.deleteBatchReportMessagesByTimestamp(j5);
                            }
                        } catch (Exception e5) {
                            af.b(e.f9506a, e5.getMessage());
                        }
                        synchronized (e.this.f9518m) {
                            e.this.f9518m.clear();
                        }
                    }

                    public final void b(String str) {
                        Stack stack;
                        String c5 = e.f9506a;
                        af.a(c5, "批量上报失败： " + str);
                        e.this.a(2, str);
                        synchronized (e.this.f9518m) {
                            try {
                                e.this.f9518m.add(Long.valueOf(j5));
                                if (e.this.f9510e != null) {
                                    e.this.f9510e.updateMessagesReportState(arrayList);
                                }
                                if (e.this.f9518m.size() >= 5) {
                                    af.a(e.f9506a, "批量上报失败，上报失败的数据超过阈值");
                                    try {
                                        e.this.f9518m.pop();
                                        long longValue = ((Long) e.this.f9518m.pop()).longValue();
                                        e.this.f9518m.clear();
                                        if (e.this.f9510e != null) {
                                            e.this.f9510e.deleteBatchReportMessagesByTimestamp(longValue);
                                        }
                                        stack = e.this.f9518m;
                                    } catch (Exception e5) {
                                        af.b(e.f9506a, e5.getMessage());
                                        stack = e.this.f9518m;
                                    }
                                    stack.clear();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }, "roas", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            } catch (Exception e5) {
                af.b(f9506a, e5.getMessage());
            }
        }
    }

    static /* synthetic */ void a(e eVar, ArrayList arrayList, long j5) {
        if (arrayList != null && arrayList.size() > 0) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("report_message", arrayList);
            bundle.putLong("last_report_time", j5);
            obtain.setData(bundle);
            obtain.what = 3;
            eVar.f9517l.sendMessage(obtain);
        }
    }

    static /* synthetic */ void a(e eVar, String str, long j5) {
        if (eVar.f9519n != null) {
            com.mbridge.msdk.tracker.e eVar2 = new com.mbridge.msdk.tracker.e("roas");
            eVar2.a(true);
            if (j5 != 0) {
                eVar2.a(j5);
            }
            eVar2.b(1);
            try {
                eVar2.a(eVar.b(str));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            eVar.f9519n.a(eVar2);
        }
    }

    static /* synthetic */ void a(e eVar, String str) {
        eVar.f9510e.addReportMessage(str, 2);
        Handler handler = eVar.f9517l;
        if (handler != null && !handler.hasMessages(1)) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            eVar.f9517l.sendMessageDelayed(obtain, eVar.f9512g);
        }
        if (eVar.f9509d.incrementAndGet() >= eVar.f9511f && eVar.f9517l != null) {
            Message obtain2 = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putLong("last_report_time", System.currentTimeMillis());
            obtain2.setData(bundle);
            obtain2.what = 2;
            eVar.f9517l.sendMessage(obtain2);
            eVar.f9509d.set(0);
        }
    }
}
