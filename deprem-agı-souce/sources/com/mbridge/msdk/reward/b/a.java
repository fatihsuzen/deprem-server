package com.mbridge.msdk.reward.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class a {

    /* renamed from: N  reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f11293N = new ConcurrentHashMap<>();

    /* renamed from: O  reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f11294O = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static String f11295b = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f11296d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f11297e = "";

    /* renamed from: f  reason: collision with root package name */
    public static ConcurrentHashMap<String, d> f11298f = new ConcurrentHashMap<>();

    /* renamed from: A  reason: collision with root package name */
    private int f11299A;

    /* renamed from: B  reason: collision with root package name */
    private int f11300B;

    /* renamed from: C  reason: collision with root package name */
    private int f11301C;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public boolean f11302D = false;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public boolean f11303E = false;

    /* renamed from: F  reason: collision with root package name */
    private boolean f11304F = false;

    /* renamed from: G  reason: collision with root package name */
    private boolean f11305G = false;

    /* renamed from: H  reason: collision with root package name */
    private boolean f11306H;
    /* access modifiers changed from: private */

    /* renamed from: I  reason: collision with root package name */
    public boolean f11307I = false;
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public ArrayList<Integer> f11308J = new ArrayList<>(7);
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public boolean f11309K = false;

    /* renamed from: L  reason: collision with root package name */
    private final Object f11310L = new Object();
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public List<CampaignEx> f11311M = new ArrayList();

    /* renamed from: P  reason: collision with root package name */
    private Queue<Integer> f11312P;

    /* renamed from: Q  reason: collision with root package name */
    private String f11313Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public g f11314R = null;

    /* renamed from: S  reason: collision with root package name */
    private volatile boolean f11315S = true;

    /* renamed from: T  reason: collision with root package name */
    private volatile boolean f11316T = false;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public volatile boolean f11317U = false;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public volatile boolean f11318V = false;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public volatile boolean f11319W = false;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public volatile boolean f11320X = false;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public volatile boolean f11321Y = false;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public CopyOnWriteArrayList<CampaignEx> f11322Z;

    /* renamed from: a  reason: collision with root package name */
    b f11323a;
    /* access modifiers changed from: private */
    public List<CampaignEx> aa;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11324c = false;

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f11325g = false;

    /* renamed from: h  reason: collision with root package name */
    volatile boolean f11326h = false;

    /* renamed from: i  reason: collision with root package name */
    volatile boolean f11327i = false;

    /* renamed from: j  reason: collision with root package name */
    volatile boolean f11328j = false;

    /* renamed from: k  reason: collision with root package name */
    volatile boolean f11329k = false;

    /* renamed from: l  reason: collision with root package name */
    private Context f11330l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public com.mbridge.msdk.reward.adapter.c f11331m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public com.mbridge.msdk.videocommon.d.c f11332n;

    /* renamed from: o  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.a f11333o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public volatile InterVideoOutListener f11334p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public volatile c f11335q;

    /* renamed from: r  reason: collision with root package name */
    private String f11336r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public String f11337s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public MBridgeIds f11338t;

    /* renamed from: u  reason: collision with root package name */
    private String f11339u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public volatile String f11340v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public String f11341w;

    /* renamed from: x  reason: collision with root package name */
    private int f11342x = 0;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public Handler f11343y = new b(this);
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public int f11344z = 2;

    /* renamed from: com.mbridge.msdk.reward.b.a$a  reason: collision with other inner class name */
    public class C0106a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final com.mbridge.msdk.reward.adapter.c f11385b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11386c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f11387d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f11388e = false;

        /* renamed from: f  reason: collision with root package name */
        private int f11389f;

        /* renamed from: g  reason: collision with root package name */
        private String f11390g;

        /* renamed from: h  reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.d.c f11391h;

        public C0106a(com.mbridge.msdk.reward.adapter.c cVar, int i5, boolean z4, String str, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            this.f11385b = cVar;
            this.f11386c = i5;
            this.f11387d = z4;
            if (cVar != null) {
                cVar.e(false);
            }
            this.f11390g = str;
            this.f11391h = cVar2;
        }

        public final void a() {
            this.f11388e = true;
        }

        public final void run() {
            if (!this.f11388e) {
                com.mbridge.msdk.reward.adapter.c cVar = this.f11385b;
                if (cVar != null) {
                    cVar.e(true);
                }
                af.b("RewardVideoController", "adSource=" + this.f11386c + " CommonCancelTimeTask mIsDevCall：" + this.f11387d);
                a.this.a(com.mbridge.msdk.foundation.c.a.b(880023, "v3 is timeout"), this.f11391h);
            }
        }

        public final void a(int i5) {
            this.f11389f = i5;
        }
    }

    public class b implements com.mbridge.msdk.reward.adapter.a {

        /* renamed from: b  reason: collision with root package name */
        private com.mbridge.msdk.reward.adapter.c f11393b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f11394c;

        /* renamed from: d  reason: collision with root package name */
        private C0106a f11395d;

        public b(com.mbridge.msdk.reward.adapter.c cVar, boolean z4) {
            this.f11393b = cVar;
            this.f11394c = z4;
        }

        public final void a(C0106a aVar) {
            this.f11395d = aVar;
        }

        public final void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            C0106a aVar = this.f11395d;
            if (aVar != null) {
                aVar.a();
                a.this.f11343y.removeCallbacks(this.f11395d);
            }
            if (a.this.f11335q != null) {
                c.b(a.this.f11335q, a.this.f11340v, a.this.f11337s, cVar);
            }
        }

        public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            C0106a aVar = this.f11395d;
            if (aVar != null) {
                aVar.a();
                a.this.f11343y.removeCallbacks(this.f11395d);
            }
            a.this.a(list);
            if (a.this.f11335q != null) {
                a.this.f11335q.a(a.this.f11340v, a.this.f11337s, cVar);
            }
        }

        public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            C0106a aVar = this.f11395d;
            if (aVar != null) {
                aVar.a();
                a.this.f11343y.removeCallbacks(this.f11395d);
            }
            com.mbridge.msdk.reward.adapter.c cVar2 = this.f11393b;
            if (cVar2 != null) {
                cVar2.a((com.mbridge.msdk.reward.adapter.a) null);
                this.f11393b = null;
            }
            a.this.a(list);
            if (a.this.f11335q != null) {
                a.this.f11335q.a(bVar, cVar);
            }
        }
    }

    public final class c {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<InterVideoOutListener> f11397b;

        /* renamed from: c  reason: collision with root package name */
        private volatile AtomicInteger f11398c;

        /* renamed from: d  reason: collision with root package name */
        private Handler f11399d;

        /* renamed from: e  reason: collision with root package name */
        private String f11400e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f11401f;

        public final void a(String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            Handler handler = this.f11399d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f11397b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f11398c.get() != 2 && this.f11399d != null) {
                this.f11398c.set(2);
                if (!a.this.f11318V) {
                    boolean unused = a.this.f11318V = true;
                    if (cVar == null) {
                        cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    cVar.b((List<CampaignEx>) a.this.f11311M);
                    a.a(a.this, "2000048", cVar, interVideoOutListener);
                    if (interVideoOutListener != null) {
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                        bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                        bundle.putString("metrics_data_lrid", cVar.f());
                        obtain.setData(bundle);
                        obtain.obj = str2;
                        obtain.what = 9;
                        this.f11399d.sendMessage(obtain);
                    }
                }
            }
        }

        private c(InterVideoOutListener interVideoOutListener, Handler handler, String str) {
            this.f11397b = new WeakReference<>(interVideoOutListener);
            this.f11398c = new AtomicInteger(0);
            this.f11399d = handler;
            this.f11400e = str;
        }

        public final void b(String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            Handler handler = this.f11399d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f11397b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f11398c.get() != 2 && this.f11399d != null) {
                if (this.f11398c.get() == 1) {
                    this.f11398c.set(3);
                }
                if (!a.this.f11318V) {
                    boolean unused = a.this.f11318V = true;
                    if (cVar == null) {
                        cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    cVar.a(true);
                    cVar.b((List<CampaignEx>) a.this.f11311M);
                    a.a(a.this, "2000048", cVar, interVideoOutListener);
                    if (interVideoOutListener != null) {
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                        bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                        bundle.putSerializable("metrics_data_lrid", cVar.f());
                        obtain.setData(bundle);
                        obtain.obj = str2;
                        obtain.what = 9;
                        this.f11399d.sendMessage(obtain);
                    }
                    if (a.this.f11319W) {
                        this.f11398c.set(2);
                    }
                }
            }
        }

        public final void a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            String str;
            com.mbridge.msdk.foundation.same.report.d.c cVar2;
            if (bVar == null || cVar == null) {
                str = "";
            } else {
                str = bVar.b();
                cVar.a(bVar);
            }
            InterVideoOutListener interVideoOutListener = null;
            if (a.this.f11331m != null) {
                a.this.f11331m.a((com.mbridge.msdk.reward.adapter.a) a.this.f11323a);
                CopyOnWriteArrayList<CampaignEx> e5 = a.this.f11331m.e();
                CampaignEx campaignEx = (a.this.f11311M == null || a.this.f11311M.size() == 0) ? null : (CampaignEx) a.this.f11311M.get(0);
                if (campaignEx == null) {
                    campaignEx = (e5 == null || e5.size() == 0) ? null : e5.get(0);
                }
                CampaignEx campaignEx2 = campaignEx;
                if (!a.this.f11303E || ((campaignEx2 != null && !TextUtils.isEmpty(campaignEx2.getNLRid())) || !(e5 == null || e5.size() == 0))) {
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                    if (a.this.f11331m.a(campaignEx2, true, bVar, 2, cVar2)) {
                        return;
                    }
                }
                a.this.f11331m.a((com.mbridge.msdk.reward.adapter.a) null);
            } else {
                cVar2 = cVar;
            }
            Handler handler = this.f11399d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f11397b;
            if (weakReference != null) {
                interVideoOutListener = weakReference.get();
            }
            if (this.f11398c.get() != 2 && this.f11399d != null) {
                boolean unused = a.this.f11319W = true;
                if (!a.this.f11321Y || str.contains("resource load timeout")) {
                    boolean unused2 = a.this.f11320X = true;
                }
                if (a.this.f11318V) {
                    this.f11398c.set(2);
                }
                if (a.this.f11319W && a.this.f11320X && !a.this.f11318V) {
                    this.f11398c.set(2);
                    a.a(a.this, "2000047", cVar2, interVideoOutListener);
                    if (interVideoOutListener != null) {
                        Message obtain = Message.obtain();
                        obtain.obj = str;
                        obtain.what = 16;
                        if (cVar2 != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("metrics_data_lrid", cVar2.f());
                            obtain.setData(bundle);
                        }
                        this.f11399d.sendMessage(obtain);
                    }
                }
            }
        }

        static /* synthetic */ void b(c cVar, String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f11397b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if ((cVar.f11398c.get() == 1 || cVar.f11398c.get() == 3) && cVar.f11399d != null && !a.this.f11317U) {
                boolean unused = a.this.f11317U = true;
                a.a(a.this, "2000127", cVar2, interVideoOutListener);
                if (interVideoOutListener != null) {
                    Message obtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, false);
                    if (cVar2 != null) {
                        bundle.putString("metrics_data_lrid", cVar2.f());
                    }
                    obtain.setData(bundle);
                    obtain.obj = str2;
                    obtain.what = 17;
                    cVar.f11399d.sendMessage(obtain);
                    if (ah.a().a("l_s_i_l_v_s", false)) {
                        cVar.a(str, str2, cVar2);
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f11397b;
            a.a(a.this, "2000047", cVar, weakReference != null ? weakReference.get() : null);
            if (this.f11399d != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                if (cVar != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("metrics_data_lrid", cVar.f());
                    obtain.setData(bundle);
                }
                this.f11399d.sendMessage(obtain);
            }
        }

        public final void a(boolean z4) {
            this.f11401f = z4;
        }

        static /* synthetic */ void a(c cVar, String str, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            cVar.f11398c.set(2);
            cVar.a(str, cVar2);
        }

        static /* synthetic */ void a(c cVar, String str, String str2, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f11397b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (cVar.f11399d != null && !a.this.f11317U) {
                boolean unused = a.this.f11317U = true;
                a.a(a.this, "2000127", cVar2, interVideoOutListener);
                if (interVideoOutListener != null) {
                    Message obtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, true);
                    if (cVar2 != null) {
                        bundle.putString("metrics_data_lrid", cVar2.f());
                    }
                    obtain.setData(bundle);
                    obtain.obj = str2;
                    obtain.what = 17;
                    cVar.f11399d.sendMessage(obtain);
                    if (ah.a().a("l_s_i_l_v_s", false)) {
                        cVar.b(str, str2, cVar2);
                    }
                }
            }
        }

        static /* synthetic */ void a(c cVar, com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar2) {
            String str;
            WeakReference<InterVideoOutListener> weakReference = cVar.f11397b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (cVar.f11398c.get() != 2 && cVar.f11399d != null) {
                boolean unused = a.this.f11320X = true;
                if (bVar != null) {
                    str = bVar.b();
                } else {
                    str = "";
                }
                if (str.contains("resource load timeout")) {
                    boolean unused2 = a.this.f11319W = true;
                }
                if (a.this.f11320X && a.this.f11319W && !a.this.f11318V) {
                    cVar.f11398c.set(2);
                    if (interVideoOutListener != null) {
                        Message obtain = Message.obtain();
                        obtain.obj = str;
                        obtain.what = 16;
                        if (cVar2 != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("metrics_data_lrid", cVar2.f());
                            obtain.setData(bundle);
                        }
                        cVar.f11399d.sendMessage(obtain);
                    }
                    if (cVar2 == null) {
                        cVar2 = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    cVar2.a(true);
                    a.a(a.this, "2000047", cVar2, interVideoOutListener);
                }
            }
        }
    }

    private final class d extends com.mbridge.msdk.video.bt.module.b.b {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public a f11403d;

        /* renamed from: e  reason: collision with root package name */
        private Handler f11404e;

        /* renamed from: f  reason: collision with root package name */
        private int f11405f;

        public final void b(String str, String str2) {
            try {
                a aVar = this.f11403d;
                if (aVar != null && aVar.f11334p != null) {
                    try {
                        this.f11403d.f11334p.onEndcardShow(a.this.f11338t);
                        com.mbridge.msdk.foundation.d.b a5 = com.mbridge.msdk.foundation.d.b.a();
                        a5.a(str2 + "_" + 2, 2);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", e5.getMessage());
                        }
                    }
                    this.f11405f = 6;
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e6.getMessage());
                }
            }
        }

        private d(a aVar, Handler handler) {
            this.f11405f = 0;
            this.f11403d = aVar;
            this.f11404e = handler;
        }

        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
            String str;
            a.this.f11324c = false;
            try {
                com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(a.this.f11337s, a.this.f11302D);
                a aVar2 = this.f11403d;
                if (aVar2 == null || aVar2.f11331m == null) {
                    str = "";
                } else {
                    str = this.f11403d.f11331m.f11211c;
                }
                aVar.a(cVar.f(), str, 3, a.f11295b);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e5.getMessage());
                }
            }
            try {
                a aVar3 = this.f11403d;
                if (aVar3 != null) {
                    boolean unused = aVar3.f11309K = true;
                    if (this.f11403d.f11331m != null) {
                        this.f11403d.f11331m.f11211c = "";
                    }
                    com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                        public final void run() {
                            try {
                                if (a.this.f11314R == null) {
                                    g unused = a.this.f11314R = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
                                }
                                h a5 = h.a((f) a.this.f11314R);
                                if (a5 != null) {
                                    a5.a(a.this.f11337s);
                                }
                            } catch (Throwable unused2) {
                                af.b("RewardVideoController", "can't find DailyPlayCapDao");
                            }
                        }
                    });
                    if (a.this.f11303E) {
                        a.this.c();
                    }
                    a aVar4 = a.this;
                    aVar4.a("2000130", cVar, aVar4.f11334p, "");
                    this.f12013b = true;
                    if (this.f11403d.f11334p != null) {
                        this.f11403d.f11334p.onAdShow(a.this.f11338t);
                        this.f11405f = 2;
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", th.getMessage());
                }
            }
        }

        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, boolean z4, com.mbridge.msdk.videocommon.b.c cVar2) {
            try {
                a aVar = this.f11403d;
                if (!(aVar == null || aVar.f11334p == null)) {
                    if (cVar2 == null) {
                        cVar2 = com.mbridge.msdk.videocommon.b.c.b(this.f11403d.f11341w);
                    }
                    if (a.this.f11303E) {
                        a.this.c();
                        a.this.b();
                        com.mbridge.msdk.foundation.same.a.b.d(a.this.f11337s, a.this.a());
                    }
                    this.f11403d.f11334p.onAdClose(a.this.f11338t, new RewardInfo(z4, cVar2.a(), String.valueOf(cVar2.b())));
                    this.f11405f = 7;
                    boolean unused = this.f11403d.f11309K = false;
                    a.this.f11308J.clear();
                    this.f11403d = null;
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000152", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e5.getMessage());
                }
            }
        }

        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
            try {
                a aVar = a.this;
                aVar.f11324c = false;
                if (this.f11403d != null) {
                    if (aVar.f11303E) {
                        a.this.c();
                    }
                    boolean unused = this.f11403d.f11309K = false;
                    a.this.a("2000131", cVar, this.f11403d.f11334p, str);
                    this.f12014c = true;
                    if (this.f11403d.f11334p != null) {
                        try {
                            this.f11403d.f11334p.onShowFail(cVar, a.this.f11338t, str);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardVideoController", e5.getMessage());
                            }
                        }
                        this.f11405f = 4;
                    }
                }
            } catch (Exception e6) {
                this.f11405f = 0;
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e6.getMessage());
                }
            }
        }

        public final void a(boolean z4, String str, String str2) {
            try {
                a aVar = this.f11403d;
                if (aVar != null && aVar.f11334p != null) {
                    if (a.this.f11303E) {
                        a.this.c();
                    }
                    boolean unused = this.f11403d.f11309K = false;
                    try {
                        this.f11403d.f11334p.onVideoAdClicked(z4, a.this.f11338t);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", e5.getMessage());
                        }
                    }
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e6.getMessage());
                }
            }
        }

        public final void a(String str, String str2) {
            try {
                a aVar = this.f11403d;
                if (aVar != null && aVar.f11334p != null) {
                    try {
                        this.f11403d.f11334p.onVideoComplete(a.this.f11338t);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", e5.getMessage());
                        }
                    }
                    this.f11405f = 5;
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e6.getMessage());
                }
            }
        }

        public final void a(boolean z4, int i5) {
            try {
                a aVar = this.f11403d;
                if (aVar != null && aVar.f11334p != null) {
                    try {
                        this.f11403d.f11334p.onAdCloseWithIVReward(a.this.f11338t, new RewardInfo(z4, i5));
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", e5.getMessage());
                        }
                    }
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e6.getMessage());
                }
            }
        }

        public final void a(int i5, String str, String str2) {
            this.f11405f = i5;
            a aVar = this.f11403d;
            if (aVar != null && !aVar.f11303E && !this.f11403d.f11302D && this.f11403d.f11332n != null && this.f11403d.f11332n.s(this.f11405f) && this.f11403d.f11335q != null && this.f11403d.f11335q.f11398c.get() != 1 && this.f11403d.f11335q.f11398c.get() != 3 && !a.this.f11308J.contains(Integer.valueOf(this.f11405f))) {
                a.this.f11308J.add(Integer.valueOf(this.f11405f));
                int A4 = this.f11403d.f11332n.A() * 1000;
                if (this.f11405f == 4) {
                    A4 = 3000;
                }
                Handler handler = this.f11404e;
                if (handler != null) {
                    handler.removeMessages(1001001);
                    this.f11404e.sendEmptyMessageDelayed(1001001, (long) A4);
                    return;
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        int i5;
                        if (d.this.f11403d != null) {
                            com.mbridge.msdk.foundation.same.report.d.d a5 = com.mbridge.msdk.foundation.same.report.d.d.a();
                            if (a.this.f11302D) {
                                i5 = 287;
                            } else {
                                i5 = 94;
                            }
                            d.this.f11403d.a(false, a5.a(0, i5, a.this.f11337s, true, 1));
                        }
                    }
                }, (long) A4);
            }
        }
    }

    public static void insertExcludeId(String str, CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(str) && campaignEx != null && com.mbridge.msdk.foundation.controller.c.m().c() != null) {
            i a5 = i.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
            fVar.a(System.currentTimeMillis());
            fVar.b(str);
            fVar.a(campaignEx.getId());
            a5.a(fVar);
        }
    }

    private void p() {
        e.a((f) g.a(this.f11330l)).a(this.f11337s);
    }

    private void q() {
        try {
            List<CampaignEx> b5 = e.a((f) g.a(this.f11330l)).b(this.f11337s);
            if (b5 != null && b5.size() > 0) {
                for (CampaignEx next : b5) {
                    if (!TextUtils.isEmpty(next.getCMPTEntryUrl())) {
                        com.mbridge.msdk.videocommon.a.b(this.f11337s + "_" + next.getRequestId() + "_" + next.getCMPTEntryUrl());
                        if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                            com.mbridge.msdk.videocommon.a.b(this.f11337s + "_" + next.getId() + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e());
                        }
                    } else {
                        com.mbridge.msdk.videocommon.a.b(next.getAdType(), next);
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", e5.getMessage());
            }
        }
    }

    private void r() {
        com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(this.f11330l, this.f11340v, this.f11337s);
        this.f11331m = cVar;
        cVar.b(this.f11302D);
        this.f11331m.c(this.f11303E);
        if (this.f11302D) {
            this.f11331m.a(this.f11299A, this.f11300B, this.f11301C);
        }
        this.f11331m.a(this.f11332n);
    }

    private boolean s() {
        try {
            if (this.f11314R == null) {
                this.f11314R = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
            }
            h a5 = h.a((f) this.f11314R);
            if (this.f11332n == null) {
                this.f11332n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f11337s, this.f11302D);
            }
            int d5 = this.f11332n.d();
            if (a5 == null || !a5.a(this.f11337s, d5)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            af.b("RewardVideoController", "cap check error");
            return false;
        }
    }

    public final List<CampaignEx> f() {
        return this.aa;
    }

    public final com.mbridge.msdk.reward.adapter.c g() {
        return this.f11331m;
    }

    public final boolean h() {
        return this.f11306H;
    }

    public final String i() {
        return this.f11337s;
    }

    public final String j() {
        return this.f11340v;
    }

    public final c k() {
        return this.f11335q;
    }

    public final InterVideoOutListener l() {
        return this.f11334p;
    }

    public final boolean m() {
        return this.f11303E;
    }

    public final MBridgeIds n() {
        return this.f11338t;
    }

    public final boolean o() {
        return this.f11302D;
    }

    private boolean e(boolean z4) {
        if (z4) {
            d("is_ready_start", "");
        }
        if (this.f11331m == null) {
            r();
        }
        List<com.mbridge.msdk.foundation.entity.c> a5 = com.mbridge.msdk.videocommon.a.a.a().a(this.f11337s);
        boolean z5 = false;
        if (a5 == null || a5.size() <= 0) {
            if (z4) {
                d("is_ready_ctir_" + false, "no effective campaign list");
            }
            return false;
        }
        String b5 = com.mbridge.msdk.foundation.same.a.b.b(this.f11337s);
        if (!TextUtils.isEmpty(b5)) {
            z5 = a(a5, b5);
        }
        if (z4) {
            d("is_ready_ctir_" + z5, "");
        }
        if (!z5) {
            for (com.mbridge.msdk.foundation.entity.c next : a5) {
                if (next != null) {
                    this.f11331m.a(next.a());
                    this.f11331m.f11212d = next.d();
                    if (this.f11331m.d(z4)) {
                        return true;
                    }
                }
            }
        }
        return z5;
    }

    public final void b(boolean z4) {
        this.f11303E = z4;
    }

    public final void c(boolean z4) {
        this.f11307I = z4;
    }

    public final boolean d(boolean z4) {
        try {
            if (!s()) {
                if (this.f11303E) {
                    return e(z4);
                }
                if (this.f11331m == null) {
                    r();
                }
                com.mbridge.msdk.reward.adapter.c cVar = this.f11331m;
                if (cVar != null) {
                    return cVar.b();
                }
                return false;
            } else if (!z4) {
                return false;
            } else {
                d("is_ready_start", "over cap check error");
                return false;
            }
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            af.b("RewardVideoController", e5.getMessage());
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            af.b("RewardVideoController", th.getMessage());
            return false;
        }
    }

    public final void b() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (this.f11309K && (concurrentHashMap = f11294O) != null && !concurrentHashMap.containsKey(a())) {
            f11294O.remove(a());
        }
    }

    public final void c() {
        String str = "";
        try {
            MBridgeIds mBridgeIds = this.f11338t;
            if (mBridgeIds == null) {
                return;
            }
            if (!this.f11309K) {
                mBridgeIds.setBidToken(str);
                return;
            }
            String a5 = a();
            if (!TextUtils.isEmpty(a5)) {
                ConcurrentHashMap<String, String> concurrentHashMap = f11294O;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(a5) && !TextUtils.isEmpty(f11294O.get(a5))) {
                    str = f11294O.get(a5);
                }
                this.f11338t.setBidToken(str);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(boolean z4) {
        this.f11302D = z4;
        if (z4) {
            this.f11344z = com.mbridge.msdk.foundation.same.a.f9181X;
        } else {
            this.f11344z = com.mbridge.msdk.foundation.same.a.f9180W;
        }
    }

    public final void b(String str, String str2) {
        try {
            this.f11330l = com.mbridge.msdk.foundation.controller.c.m().c();
            this.f11337s = str2;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.f11340v = str;
            this.f11338t = new MBridgeIds(this.f11340v, this.f11337s);
            this.f11333o = com.mbridge.msdk.videocommon.d.b.a().b();
            com.mbridge.msdk.foundation.same.f.a.b().execute(new c(this.f11330l, this.f11337s));
            if (this.f11314R == null) {
                this.f11314R = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
            }
        } catch (Throwable th) {
            af.b("RewardVideoController", th.getMessage(), th);
        }
    }

    public final void a(int i5) {
        this.f11344z = i5;
    }

    public final String a() {
        com.mbridge.msdk.reward.adapter.c cVar = this.f11331m;
        if (cVar != null) {
            return cVar.a(this.f11309K);
        }
        return "";
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            Context context = this.f11330l;
            an.b(context, "MBridge_ConfirmTitle" + this.f11337s, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            Context context2 = this.f11330l;
            an.b(context2, "MBridge_ConfirmContent" + this.f11337s, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            Context context3 = this.f11330l;
            an.b(context3, "MBridge_CancelText" + this.f11337s, str4.trim());
        }
        if (!TextUtils.isEmpty(str3)) {
            Context context4 = this.f11330l;
            an.b(context4, "MBridge_ConfirmText" + this.f11337s, str3.trim());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.foundation.same.report.d.c b(boolean r7, java.lang.String r8, com.mbridge.msdk.foundation.same.report.d.e r9) {
        /*
            r6 = this;
            java.lang.String r0 = "hb"
            java.lang.String r1 = "adtp"
            com.mbridge.msdk.foundation.same.report.d.c r2 = new com.mbridge.msdk.foundation.same.report.d.c
            r2.<init>()
            if (r7 == 0) goto L_0x0080
            android.content.Context r3 = r6.f11330l     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.foundation.db.g r3 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r3)     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.foundation.db.e r3 = com.mbridge.msdk.foundation.db.e.a((com.mbridge.msdk.foundation.db.f) r3)     // Catch:{ Exception -> 0x003d }
            if (r3 == 0) goto L_0x003f
            java.lang.String r4 = r6.f11337s     // Catch:{ Exception -> 0x003d }
            java.util.List r3 = r3.e(r4)     // Catch:{ Exception -> 0x003d }
            if (r3 == 0) goto L_0x003f
            int r4 = r3.size()     // Catch:{ Exception -> 0x003d }
            if (r4 <= 0) goto L_0x003f
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x003d }
        L_0x0029:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x003d }
            if (r4 == 0) goto L_0x003f
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x003d }
            r5.b((java.lang.String) r4)     // Catch:{ Exception -> 0x003d }
            goto L_0x0029
        L_0x003d:
            r3 = move-exception
            goto L_0x0075
        L_0x003f:
            com.mbridge.msdk.foundation.same.report.d.d r3 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x003d }
            java.util.LinkedHashMap r3 = r3.b()     // Catch:{ Exception -> 0x003d }
            if (r3 == 0) goto L_0x0080
            int r4 = r3.size()     // Catch:{ Exception -> 0x003d }
            if (r4 <= 0) goto L_0x0080
            java.util.Set r3 = r3.entrySet()     // Catch:{ Exception -> 0x003d }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x003d }
        L_0x0057:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x003d }
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x003d }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x003d }
            if (r4 == 0) goto L_0x0057
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.foundation.same.report.d.c r4 = (com.mbridge.msdk.foundation.same.report.d.c) r4     // Catch:{ Exception -> 0x003d }
            boolean r4 = r4.s()     // Catch:{ Exception -> 0x003d }
            if (r4 == 0) goto L_0x0057
            r3.remove()     // Catch:{ Exception -> 0x003d }
            goto L_0x0057
        L_0x0075:
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x007d }
            if (r4 == 0) goto L_0x0080
            r3.printStackTrace()     // Catch:{ Exception -> 0x007d }
            goto L_0x0080
        L_0x007d:
            r7 = move-exception
            goto L_0x0102
        L_0x0080:
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x007d }
            if (r3 == 0) goto L_0x008f
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.ak.d()     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r3)     // Catch:{ Exception -> 0x007d }
            goto L_0x0093
        L_0x008f:
            java.lang.String r3 = r6.a((java.lang.String) r8)     // Catch:{ Exception -> 0x007d }
        L_0x0093:
            com.mbridge.msdk.foundation.same.report.d.d r4 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = ""
            com.mbridge.msdk.foundation.same.report.d.c r2 = r4.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x007d }
            if (r2 != 0) goto L_0x00b8
            com.mbridge.msdk.foundation.same.report.d.c r4 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x007d }
            r4.<init>()     // Catch:{ Exception -> 0x007d }
            com.mbridge.msdk.foundation.same.report.d.d r2 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x00b5 }
            java.util.LinkedHashMap r2 = r2.b()     // Catch:{ Exception -> 0x00b5 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00b5 }
            r2 = 1
            r4.d((boolean) r2)     // Catch:{ Exception -> 0x00b5 }
            r2 = r4
            goto L_0x00b8
        L_0x00b5:
            r7 = move-exception
            r2 = r4
            goto L_0x0102
        L_0x00b8:
            r2.c((java.lang.String) r3)     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = r6.f11337s     // Catch:{ Exception -> 0x007d }
            r2.d((java.lang.String) r3)     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = "1"
            if (r9 == 0) goto L_0x00ef
            boolean r4 = r9.a((java.lang.String) r1)     // Catch:{ Exception -> 0x007d }
            if (r4 == 0) goto L_0x00d7
            java.lang.Object r1 = r9.b(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x007d }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x007d }
            r2.b((int) r1)     // Catch:{ Exception -> 0x007d }
        L_0x00d7:
            boolean r1 = r9.a((java.lang.String) r0)     // Catch:{ Exception -> 0x007d }
            if (r1 == 0) goto L_0x00ef
            java.lang.Object r9 = r9.b(r0)     // Catch:{ Exception -> 0x007d }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x007d }
            r2.i(r9)     // Catch:{ Exception -> 0x007d }
            boolean r9 = r9.equals(r3)     // Catch:{ Exception -> 0x007d }
            if (r9 == 0) goto L_0x00ef
            r2.e((java.lang.String) r8)     // Catch:{ Exception -> 0x007d }
        L_0x00ef:
            if (r7 == 0) goto L_0x00f3
            java.lang.String r3 = "2"
        L_0x00f3:
            r2.b((java.lang.String) r3)     // Catch:{ Exception -> 0x007d }
            if (r7 == 0) goto L_0x010f
            com.mbridge.msdk.reward.c.a.a r7 = com.mbridge.msdk.reward.c.a.a.a()     // Catch:{ Exception -> 0x007d }
            java.lang.String r8 = "2000123"
            r7.a(r8, r2)     // Catch:{ Exception -> 0x007d }
            goto L_0x010f
        L_0x0102:
            boolean r8 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r8 == 0) goto L_0x010f
            java.lang.String r8 = "RewardVideoController"
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r8, r7)
        L_0x010f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.b(boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.d.e):com.mbridge.msdk.foundation.same.report.d.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            com.mbridge.msdk.reward.adapter.c r0 = r4.f11331m     // Catch:{ Exception -> 0x000f }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x000f }
            boolean r0 = r5.equals(r0)     // Catch:{ Exception -> 0x000f }
            if (r0 != 0) goto L_0x0028
            goto L_0x0011
        L_0x000f:
            r0 = move-exception
            goto L_0x0037
        L_0x0011:
            com.mbridge.msdk.reward.adapter.c r0 = new com.mbridge.msdk.reward.adapter.c     // Catch:{ Exception -> 0x000f }
            android.content.Context r1 = r4.f11330l     // Catch:{ Exception -> 0x000f }
            java.lang.String r2 = r4.f11340v     // Catch:{ Exception -> 0x000f }
            r0.<init>(r1, r2, r5)     // Catch:{ Exception -> 0x000f }
            r4.f11331m = r0     // Catch:{ Exception -> 0x000f }
            boolean r1 = r4.f11302D     // Catch:{ Exception -> 0x000f }
            r0.b((boolean) r1)     // Catch:{ Exception -> 0x000f }
            com.mbridge.msdk.reward.adapter.c r0 = r4.f11331m     // Catch:{ Exception -> 0x000f }
            boolean r1 = r4.f11303E     // Catch:{ Exception -> 0x000f }
            r0.c((boolean) r1)     // Catch:{ Exception -> 0x000f }
        L_0x0028:
            com.mbridge.msdk.reward.adapter.c r0 = r4.f11331m     // Catch:{ Exception -> 0x000f }
            int r1 = r4.f11344z     // Catch:{ Exception -> 0x000f }
            r0.a((int) r1)     // Catch:{ Exception -> 0x000f }
            com.mbridge.msdk.reward.adapter.c r0 = r4.f11331m     // Catch:{ Exception -> 0x000f }
            com.mbridge.msdk.videocommon.d.c r1 = r4.f11332n     // Catch:{ Exception -> 0x000f }
            r0.a((com.mbridge.msdk.videocommon.d.c) r1)     // Catch:{ Exception -> 0x000f }
            goto L_0x0044
        L_0x0037:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0044
            java.lang.String r1 = "RewardVideoController"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
        L_0x0044:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            boolean r1 = r4.f11303E
            r2 = 1
            java.util.List r0 = r0.a((java.lang.String) r5, (int) r2, (boolean) r1)
            com.mbridge.msdk.videocommon.a.a r1 = com.mbridge.msdk.videocommon.a.a.a()
            boolean r3 = r4.f11303E
            java.util.List r1 = r1.b(r5, r2, r3)
            r4.aa = r1
            if (r0 == 0) goto L_0x0098
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x0098
            com.mbridge.msdk.videocommon.a.a r1 = com.mbridge.msdk.videocommon.a.a.a()
            r1.a((java.lang.String) r5, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0, (java.lang.String) r6)
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.f11322Z
            if (r5 != 0) goto L_0x0076
            java.util.concurrent.CopyOnWriteArrayList r5 = new java.util.concurrent.CopyOnWriteArrayList
            r5.<init>()
            r4.f11322Z = r5
            goto L_0x0079
        L_0x0076:
            r5.clear()
        L_0x0079:
            java.util.Iterator r5 = r0.iterator()
        L_0x007d:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0092
            java.lang.Object r0 = r5.next()
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            r0.setLocalRequestId(r6)
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r4.f11322Z
            r1.add(r0)
            goto L_0x007d
        L_0x0092:
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.f11322Z
            r4.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r5)
            return r2
        L_0x0098:
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.f11322Z
            if (r5 == 0) goto L_0x009f
            r5.clear()
        L_0x009f:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.c(java.lang.String, java.lang.String):boolean");
    }

    public final String d() {
        com.mbridge.msdk.reward.adapter.c cVar = this.f11331m;
        if (cVar != null) {
            return cVar.f();
        }
        return "";
    }

    private void d(String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar.d(this.f11337s);
            cVar.b(this.f11302D ? 287 : 94);
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("event_name", str);
            eVar.a("reason", str2);
            cVar.a("m_temp_is_ready_check", eVar);
            com.mbridge.msdk.reward.c.a.a.a().a("m_temp_is_ready_check", cVar);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> e() {
        return this.f11322Z;
    }

    public final void a(int i5, int i6, int i7) {
        this.f11299A = i5;
        this.f11300B = i6;
        if (i6 == com.mbridge.msdk.foundation.same.a.f9168K) {
            this.f11301C = i7 < 0 ? 5 : i7;
        }
        if (i6 == com.mbridge.msdk.foundation.same.a.f9167J) {
            this.f11301C = i7 < 0 ? 80 : i7;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            int i8 = 1;
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i5 == com.mbridge.msdk.foundation.same.a.f9165H ? 0 : 1);
            if (i6 == com.mbridge.msdk.foundation.same.a.f9167J) {
                i8 = 0;
            }
            jSONObject.put("ivRewardPlayValueMode", i8);
            jSONObject.put("ivRewardPlayValue", i7);
            com.mbridge.msdk.c.h.a().f(this.f11337s, jSONObject.toString());
        } catch (Exception unused) {
            af.b("RewardVideoController", "setIVRewardEnable to SP was ERROR");
        }
    }

    public static void a(String str, int i5) {
        try {
            if (f11293N != null && ap.b(str)) {
                f11293N.put(str, Integer.valueOf(i5));
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", e5.getMessage());
            }
        }
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (concurrentHashMap = f11294O) != null && !concurrentHashMap.containsKey(str)) {
            f11294O.put(str, str2);
        }
    }

    public final void a(InterVideoOutListener interVideoOutListener) {
        this.f11334p = interVideoOutListener;
        this.f11335q = new c(interVideoOutListener, this.f11343y, this.f11337s);
    }

    public final void a(boolean z4, com.mbridge.msdk.foundation.same.report.d.e eVar) {
        a(z4, "", eVar);
    }

    public final void a(boolean z4, String str, com.mbridge.msdk.foundation.same.report.d.e eVar) {
        a aVar;
        com.mbridge.msdk.foundation.same.report.d.c b5 = b(z4, str, eVar);
        if (this.f11335q == null) {
            aVar = this;
            aVar.f11335q = new c((InterVideoOutListener) null, this.f11343y, this.f11337s);
        } else {
            aVar = this;
        }
        if (aVar.f11335q == null || aVar.f11335q.f11398c.get() != 1) {
            if (aVar.f11335q == null || aVar.f11335q.f11398c.get() != 3) {
                aVar.f11315S = true;
                if (aVar.f11335q != null) {
                    aVar.f11335q.f11398c.set(1);
                }
            } else {
                aVar.f11315S = false;
            }
            aVar.f11306H = z4;
            aVar.f11343y.removeMessages(1001001);
            aVar.f11318V = false;
            aVar.f11317U = false;
            aVar.f11319W = false;
            aVar.f11320X = false;
            q();
            p();
            com.mbridge.msdk.reward.adapter.b.a();
            try {
                if (TextUtils.isEmpty(str)) {
                    if (aVar.f11302D) {
                        com.mbridge.msdk.d.b.getInstance().addInterstitialList(aVar.f11340v, aVar.f11337s);
                    } else {
                        com.mbridge.msdk.d.b.getInstance().addRewardList(aVar.f11340v, aVar.f11337s);
                    }
                }
                if (aVar.f11303E && TextUtils.isEmpty(str)) {
                    b(b5);
                } else if (com.mbridge.msdk.system.a.map == null) {
                    a(b5);
                } else {
                    com.mbridge.msdk.videocommon.d.c a5 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), aVar.f11337s);
                    aVar.f11332n = a5;
                    if (a5 == null) {
                        aVar.f11313Q = com.mbridge.msdk.foundation.controller.c.m().k();
                        com.mbridge.msdk.videocommon.d.b.a().a(aVar.f11313Q, com.mbridge.msdk.foundation.controller.c.m().b(), aVar.f11337s, new com.mbridge.msdk.videocommon.c.c() {
                            public final void a(String str) {
                            }

                            public final void b(String str) {
                            }
                        });
                        aVar.f11332n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), aVar.f11337s, aVar.f11302D);
                    }
                    if (!TextUtils.isEmpty(aVar.f11340v)) {
                        aVar.f11332n.b(aVar.f11340v);
                    }
                    int F4 = aVar.f11332n.F() * 1000;
                    if (aVar.f11343y != null) {
                        Message obtain = Message.obtain();
                        obtain.what = 1001002;
                        if (b5 != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("metrics_data_lrid", b5.f());
                            obtain.setData(bundle);
                        }
                        aVar.f11343y.sendMessageDelayed(obtain, (long) F4);
                    }
                    aVar.f11312P = aVar.f11332n.B();
                    try {
                        a(z4, str, b5);
                    } catch (Exception e5) {
                        Exception exc = e5;
                        if (aVar.f11335q != null) {
                            com.mbridge.msdk.foundation.c.b b6 = com.mbridge.msdk.foundation.c.a.b(880020, "load exception");
                            if (b5 != null) {
                                b5.a(b6);
                                b5.c(true);
                            }
                            aVar.f11335q.a(b6, b5);
                        }
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoController", exc.getMessage());
                        }
                    }
                }
            } catch (Exception e6) {
                Exception exc2 = e6;
                if (aVar.f11335q != null) {
                    com.mbridge.msdk.foundation.c.b b7 = com.mbridge.msdk.foundation.c.a.b(880001, "");
                    if (b5 != null) {
                        b5.a(b7);
                        b5.c(true);
                    }
                    aVar.f11335q.a(b7, b5);
                }
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", exc2.getMessage());
                }
            }
        } else {
            a(z4, b5);
        }
    }

    private void b(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f11335q != null) {
            com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880035, "");
            if (cVar != null) {
                cVar.a(b5);
                cVar.c(true);
            }
            c.a(this.f11335q, "bidToken is empty", cVar);
        }
    }

    private void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f11335q != null) {
            String a5 = com.mbridge.msdk.foundation.c.a.a(880001, "");
            com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880001, "");
            if (cVar != null) {
                cVar.a(b5);
                cVar.c(true);
            }
            c.a(this.f11335q, a5, cVar);
        }
    }

    private void a(boolean z4, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f11306H) {
            if (z4) {
                String a5 = com.mbridge.msdk.foundation.c.a.a(880016, "errorCode: 3501 errorMessage: current unit is loading");
                com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880016, "errorCode: 3501 errorMessage: current unit is loading");
                if (cVar != null) {
                    cVar.a(b5);
                    cVar.c(true);
                }
                this.f11335q.a(a5, cVar);
            }
        } else if (z4) {
            this.f11306H = z4;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:158:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0486  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r17, java.lang.String r18, com.mbridge.msdk.foundation.same.report.d.c r19) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r4 = r18
            r5 = r19
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            if (r0 == 0) goto L_0x04c0
            boolean r0 = r1.f11303E
            java.lang.String r10 = "RewardVideoController"
            r3 = 880019(0xd6d93, float:1.233169E-39)
            java.lang.String r6 = ""
            r11 = 0
            r12 = 1
            if (r0 != 0) goto L_0x0161
            java.lang.String r0 = r1.f11337s
            java.lang.String r7 = r5.f()
            boolean r0 = r1.c((java.lang.String) r0, (java.lang.String) r7)
            r1.f11321Y = r0
            boolean r0 = r1.f11321Y
            if (r0 == 0) goto L_0x0111
            boolean r0 = r1.s()
            if (r0 != 0) goto L_0x00b4
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.f11322Z
            if (r3 == 0) goto L_0x04c0
            int r0 = r3.size()
            if (r0 <= 0) goto L_0x04c0
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0055 }
            r0.<init>()     // Catch:{ Exception -> 0x0055 }
            java.lang.String r6 = "cache"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0055 }
            r0.a(r6, r7)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r6 = "2000127"
            r5.a(r6, r0)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r6 = "2000048"
            r5.a(r6, r0)     // Catch:{ Exception -> 0x0055 }
            r5.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0061
        L_0x0055:
            r0 = move-exception
            boolean r6 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r6 == 0) goto L_0x0061
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r10, r0)
        L_0x0061:
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            java.lang.String r6 = r1.f11340v
            java.lang.String r7 = r1.f11337s
            com.mbridge.msdk.reward.b.a.c.a(r0, r6, r7, r5)
            java.lang.Object r0 = r3.get(r11)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            com.mbridge.msdk.reward.b.a$c r6 = r1.f11335q
            boolean r7 = r1.f11303E
            r6.a((boolean) r7)
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m
            if (r6 == 0) goto L_0x009b
            java.lang.String r7 = r0.getCMPTEntryUrl()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            r7 = r7 ^ r12
            int r0 = r0.getNscpt()
            boolean r0 = r6.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3, (boolean) r7, (int) r0)
            if (r0 == 0) goto L_0x009b
            r1.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            java.lang.String r3 = r1.f11340v
            java.lang.String r6 = r1.f11337s
            r0.b((java.lang.String) r3, (java.lang.String) r6, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            goto L_0x00a0
        L_0x009b:
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r3, (com.mbridge.msdk.reward.adapter.c) r0)
        L_0x00a0:
            boolean r0 = r1.f11315S
            if (r0 == 0) goto L_0x04c0
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m
            if (r0 == 0) goto L_0x00ad
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.f11322Z
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
        L_0x00ad:
            java.util.Queue<java.lang.Integer> r0 = r1.f11312P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            goto L_0x04c0
        L_0x00b4:
            java.lang.String r0 = "非BID，本地存在可用的缓存，超过上限"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r10, (java.lang.String) r0)
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f11322Z
            if (r0 == 0) goto L_0x00df
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00df
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f11322Z
            java.util.Iterator r0 = r0.iterator()
        L_0x00c9:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x00df
            java.lang.Object r7 = r0.next()
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7
            com.mbridge.msdk.videocommon.a.a r8 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r9 = r1.f11337s
            r8.a((com.mbridge.msdk.foundation.entity.CampaignEx) r7, (java.lang.String) r9)
            goto L_0x00c9
        L_0x00df:
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m
            if (r0 == 0) goto L_0x00e8
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r7 = r1.f11322Z
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r7)
        L_0x00e8:
            if (r2 == 0) goto L_0x0102
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            if (r0 == 0) goto L_0x04c0
            java.lang.String r0 = com.mbridge.msdk.foundation.c.a.a(r3, r6)
            com.mbridge.msdk.foundation.c.b r2 = com.mbridge.msdk.foundation.c.a.b(r3, r6)
            r5.a((com.mbridge.msdk.foundation.c.b) r2)
            r5.c((boolean) r12)
            com.mbridge.msdk.reward.b.a$c r2 = r1.f11335q
            com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x0102:
            r1.f11321Y = r11
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            boolean r3 = r1.f11303E
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.f11312P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x0111:
            boolean r0 = r1.s()
            if (r0 != 0) goto L_0x012f
            r1.f11321Y = r11
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m
            if (r0 == 0) goto L_0x0122
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.f11322Z
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
        L_0x0122:
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            boolean r3 = r1.f11303E
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.f11312P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x012f:
            if (r2 == 0) goto L_0x0149
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            if (r0 == 0) goto L_0x04c0
            java.lang.String r0 = com.mbridge.msdk.foundation.c.a.a(r3, r6)
            com.mbridge.msdk.foundation.c.b r2 = com.mbridge.msdk.foundation.c.a.b(r3, r6)
            r5.a((com.mbridge.msdk.foundation.c.b) r2)
            r5.c((boolean) r12)
            com.mbridge.msdk.reward.b.a$c r2 = r1.f11335q
            com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x0149:
            r1.f11321Y = r11
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m
            if (r0 == 0) goto L_0x0154
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.f11322Z
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
        L_0x0154:
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            boolean r3 = r1.f11303E
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.f11312P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x0161:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r7 = r1.f11337s
            boolean r8 = r1.f11303E
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.a((java.lang.String) r7, (int) r12, (boolean) r8, (java.lang.String) r6)
            r7 = 880038(0xd6da6, float:1.233196E-39)
            r13 = 0
            if (r0 == 0) goto L_0x033a
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x033a
            boolean r8 = r1.s()
            if (r8 != 0) goto L_0x0315
            java.util.concurrent.CopyOnWriteArrayList r3 = new java.util.concurrent.CopyOnWriteArrayList
            r3.<init>()
            int r6 = r0.size()
            if (r6 <= 0) goto L_0x01b0
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x01b0
            java.util.Iterator r6 = r0.iterator()
        L_0x0194:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x01b0
            java.lang.Object r8 = r6.next()
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8
            if (r8 == 0) goto L_0x0194
            java.lang.String r9 = r8.getBidToken()
            boolean r9 = r4.equals(r9)
            if (r9 == 0) goto L_0x0194
            r3.add(r8)
            goto L_0x0194
        L_0x01b0:
            int r6 = r3.size()
            if (r6 <= 0) goto L_0x01ba
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r3, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x01ba:
            com.mbridge.msdk.reward.a.a r3 = new com.mbridge.msdk.reward.a.a     // Catch:{ Exception -> 0x01fb }
            java.lang.String r6 = r1.f11337s     // Catch:{ Exception -> 0x01fb }
            boolean r8 = r1.f11302D     // Catch:{ Exception -> 0x01fb }
            r3.<init>(r6, r8)     // Catch:{ Exception -> 0x01fb }
            com.mbridge.msdk.foundation.b.c r6 = new com.mbridge.msdk.foundation.b.c     // Catch:{ Exception -> 0x01fb }
            r6.<init>()     // Catch:{ Exception -> 0x01fb }
            boolean r8 = r3.a(r4)     // Catch:{ Exception -> 0x01fb }
            if (r8 == 0) goto L_0x02ac
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m     // Catch:{ Exception -> 0x0283 }
            if (r6 != 0) goto L_0x020c
            com.mbridge.msdk.reward.adapter.c r6 = new com.mbridge.msdk.reward.adapter.c     // Catch:{ Exception -> 0x01fb }
            android.content.Context r8 = r1.f11330l     // Catch:{ Exception -> 0x01fb }
            java.lang.String r9 = r1.f11340v     // Catch:{ Exception -> 0x01fb }
            java.lang.String r14 = r1.f11337s     // Catch:{ Exception -> 0x01fb }
            r6.<init>(r8, r9, r14)     // Catch:{ Exception -> 0x01fb }
            r1.f11331m = r6     // Catch:{ Exception -> 0x01fb }
            boolean r8 = r1.f11302D     // Catch:{ Exception -> 0x01fb }
            r6.b((boolean) r8)     // Catch:{ Exception -> 0x01fb }
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m     // Catch:{ Exception -> 0x01fb }
            boolean r8 = r1.f11303E     // Catch:{ Exception -> 0x01fb }
            r6.c((boolean) r8)     // Catch:{ Exception -> 0x01fb }
            boolean r6 = r1.f11302D     // Catch:{ Exception -> 0x01fb }
            if (r6 == 0) goto L_0x01fe
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m     // Catch:{ Exception -> 0x01fb }
            int r8 = r1.f11299A     // Catch:{ Exception -> 0x01fb }
            int r9 = r1.f11300B     // Catch:{ Exception -> 0x01fb }
            int r14 = r1.f11301C     // Catch:{ Exception -> 0x01fb }
            r6.a((int) r8, (int) r9, (int) r14)     // Catch:{ Exception -> 0x01fb }
            goto L_0x01fe
        L_0x01fb:
            r0 = move-exception
            goto L_0x02fa
        L_0x01fe:
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m     // Catch:{ Exception -> 0x01fb }
            int r8 = r1.f11344z     // Catch:{ Exception -> 0x01fb }
            r6.a((int) r8)     // Catch:{ Exception -> 0x01fb }
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m     // Catch:{ Exception -> 0x01fb }
            com.mbridge.msdk.videocommon.d.c r8 = r1.f11332n     // Catch:{ Exception -> 0x01fb }
            r6.a((com.mbridge.msdk.videocommon.d.c) r8)     // Catch:{ Exception -> 0x01fb }
        L_0x020c:
            com.mbridge.msdk.foundation.c.b r6 = new com.mbridge.msdk.foundation.c.b     // Catch:{ Exception -> 0x0283 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0283 }
            com.mbridge.msdk.reward.adapter.c r9 = r1.f11331m     // Catch:{ Exception -> 0x0283 }
            r7 = r6
            r6 = 0
            r8 = 1
            com.mbridge.msdk.foundation.b.c r6 = r3.a((java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.c.b) r7, (int) r8, (com.mbridge.msdk.reward.adapter.c) r9)     // Catch:{ Exception -> 0x0283 }
            if (r6 == 0) goto L_0x02cf
            int r5 = r6.g()     // Catch:{ Exception -> 0x0283 }
            int r7 = com.mbridge.msdk.foundation.b.c.f8793d     // Catch:{ Exception -> 0x0283 }
            if (r5 != r7) goto L_0x02cf
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x0283 }
            if (r5 == 0) goto L_0x02cf
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x0283 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x0283 }
            if (r5 <= 0) goto L_0x02cf
            com.mbridge.msdk.reward.adapter.c r5 = r1.f11331m     // Catch:{ Exception -> 0x0283 }
            if (r5 == 0) goto L_0x02cf
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x0283 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0283 }
            r7.<init>()     // Catch:{ Exception -> 0x0283 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0283 }
        L_0x0245:
            boolean r8 = r0.hasNext()     // Catch:{ Exception -> 0x0283 }
            if (r8 == 0) goto L_0x0294
            java.lang.Object r8 = r0.next()     // Catch:{ Exception -> 0x0283 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ Exception -> 0x0283 }
            if (r8 == 0) goto L_0x0245
            java.lang.String r9 = r8.getRequestId()     // Catch:{ Exception -> 0x0283 }
            boolean r13 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0283 }
            if (r13 == 0) goto L_0x025e
            goto L_0x0245
        L_0x025e:
            r0 = r11
        L_0x025f:
            int r13 = r5.size()     // Catch:{ Exception -> 0x0283 }
            if (r0 >= r13) goto L_0x028b
            java.lang.Object r13 = r5.get(r0)     // Catch:{ Exception -> 0x0283 }
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = (com.mbridge.msdk.foundation.entity.CampaignEx) r13     // Catch:{ Exception -> 0x0283 }
            if (r13 == 0) goto L_0x0288
            java.lang.String r13 = r13.getRequestId()     // Catch:{ Exception -> 0x0283 }
            boolean r13 = r9.equals(r13)     // Catch:{ Exception -> 0x0283 }
            if (r13 == 0) goto L_0x0278
            goto L_0x028b
        L_0x0278:
            int r13 = r5.size()     // Catch:{ Exception -> 0x0283 }
            int r13 = r13 - r12
            if (r0 != r13) goto L_0x0288
            r7.add(r8)     // Catch:{ Exception -> 0x0283 }
            goto L_0x0288
        L_0x0283:
            r0 = move-exception
            r5 = r19
            goto L_0x02fa
        L_0x0288:
            int r0 = r0 + 1
            goto L_0x025f
        L_0x028b:
            int r0 = r5.size()     // Catch:{ Exception -> 0x0283 }
            if (r0 != 0) goto L_0x0294
            r7.add(r8)     // Catch:{ Exception -> 0x0283 }
        L_0x0294:
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m     // Catch:{ Exception -> 0x0283 }
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r7)     // Catch:{ Exception -> 0x0283 }
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m     // Catch:{ Exception -> 0x0283 }
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x0283 }
            r0.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r5, (boolean) r11, (boolean) r12)     // Catch:{ Exception -> 0x0283 }
            java.util.concurrent.CopyOnWriteArrayList r13 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x0283 }
            java.util.concurrent.CopyOnWriteArrayList r0 = r6.a()     // Catch:{ Exception -> 0x0283 }
            r13.<init>(r0)     // Catch:{ Exception -> 0x0283 }
            goto L_0x02cf
        L_0x02ac:
            java.util.concurrent.CopyOnWriteArrayList r13 = r1.a((java.lang.String) r4, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)     // Catch:{ Exception -> 0x0283 }
            int r0 = r13.size()     // Catch:{ Exception -> 0x0283 }
            if (r0 <= 0) goto L_0x02c5
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0283 }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x0283 }
            com.mbridge.msdk.foundation.db.b r0 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r0)     // Catch:{ Exception -> 0x0283 }
            r0.a((java.lang.String) r4, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r13)     // Catch:{ Exception -> 0x0283 }
        L_0x02c5:
            java.lang.String r0 = "cb is closed"
            r6.d(r0)     // Catch:{ Exception -> 0x0283 }
            int r0 = com.mbridge.msdk.foundation.b.c.f8792c     // Catch:{ Exception -> 0x0283 }
            r6.a((int) r0)     // Catch:{ Exception -> 0x0283 }
        L_0x02cf:
            r8 = 0
            r9 = 1
            r7 = 0
            r5 = r4
            r4 = r19
            r3.a((com.mbridge.msdk.foundation.same.report.d.c) r4, (java.lang.String) r5, (com.mbridge.msdk.foundation.b.c) r6, (java.util.List<com.mbridge.msdk.foundation.b.a.C0084a>) r7, (org.json.JSONObject) r8, (int) r9)     // Catch:{ Exception -> 0x02f6 }
            r15 = r5
            r5 = r4
            r4 = r15
            if (r13 == 0) goto L_0x0305
            int r0 = r13.size()     // Catch:{ Exception -> 0x01fb }
            if (r0 <= 0) goto L_0x0305
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r13, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)     // Catch:{ Exception -> 0x01fb }
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m     // Catch:{ Exception -> 0x01fb }
            if (r0 == 0) goto L_0x0305
            boolean r0 = r3.a(r4)     // Catch:{ Exception -> 0x01fb }
            if (r0 != 0) goto L_0x0305
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m     // Catch:{ Exception -> 0x01fb }
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r13)     // Catch:{ Exception -> 0x01fb }
            goto L_0x0305
        L_0x02f6:
            r0 = move-exception
            r15 = r5
            r5 = r4
            r4 = r15
        L_0x02fa:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L_0x0305
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r10, r0)
        L_0x0305:
            r1.f11321Y = r11
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            boolean r3 = r1.f11303E
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.f11312P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            goto L_0x04c0
        L_0x0315:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r7 = r1.f11337s
            r0.a((java.lang.String) r7, (java.lang.String) r4)
            if (r2 == 0) goto L_0x04c0
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            if (r0 == 0) goto L_0x04c0
            java.lang.String r0 = com.mbridge.msdk.foundation.c.a.a(r3, r6)
            com.mbridge.msdk.foundation.c.b r2 = com.mbridge.msdk.foundation.c.a.b(r3, r6)
            if (r5 == 0) goto L_0x0334
            r5.a((com.mbridge.msdk.foundation.c.b) r2)
            r5.c((boolean) r12)
        L_0x0334:
            com.mbridge.msdk.reward.b.a$c r2 = r1.f11335q
            com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            return
        L_0x033a:
            boolean r8 = r1.s()
            if (r8 != 0) goto L_0x049c
            com.mbridge.msdk.reward.a.a r3 = new com.mbridge.msdk.reward.a.a     // Catch:{ Exception -> 0x0381 }
            java.lang.String r6 = r1.f11337s     // Catch:{ Exception -> 0x0381 }
            boolean r8 = r1.f11302D     // Catch:{ Exception -> 0x0381 }
            r3.<init>(r6, r8)     // Catch:{ Exception -> 0x0381 }
            com.mbridge.msdk.foundation.b.c r6 = new com.mbridge.msdk.foundation.b.c     // Catch:{ Exception -> 0x0381 }
            r6.<init>()     // Catch:{ Exception -> 0x0381 }
            boolean r8 = r3.a(r4)     // Catch:{ Exception -> 0x0381 }
            if (r8 == 0) goto L_0x0434
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m     // Catch:{ Exception -> 0x040b }
            if (r6 != 0) goto L_0x0392
            com.mbridge.msdk.reward.adapter.c r6 = new com.mbridge.msdk.reward.adapter.c     // Catch:{ Exception -> 0x0381 }
            android.content.Context r8 = r1.f11330l     // Catch:{ Exception -> 0x0381 }
            java.lang.String r9 = r1.f11340v     // Catch:{ Exception -> 0x0381 }
            java.lang.String r14 = r1.f11337s     // Catch:{ Exception -> 0x0381 }
            r6.<init>(r8, r9, r14)     // Catch:{ Exception -> 0x0381 }
            r1.f11331m = r6     // Catch:{ Exception -> 0x0381 }
            boolean r8 = r1.f11302D     // Catch:{ Exception -> 0x0381 }
            r6.b((boolean) r8)     // Catch:{ Exception -> 0x0381 }
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m     // Catch:{ Exception -> 0x0381 }
            boolean r8 = r1.f11303E     // Catch:{ Exception -> 0x0381 }
            r6.c((boolean) r8)     // Catch:{ Exception -> 0x0381 }
            boolean r6 = r1.f11302D     // Catch:{ Exception -> 0x0381 }
            if (r6 == 0) goto L_0x0384
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m     // Catch:{ Exception -> 0x0381 }
            int r8 = r1.f11299A     // Catch:{ Exception -> 0x0381 }
            int r9 = r1.f11300B     // Catch:{ Exception -> 0x0381 }
            int r14 = r1.f11301C     // Catch:{ Exception -> 0x0381 }
            r6.a((int) r8, (int) r9, (int) r14)     // Catch:{ Exception -> 0x0381 }
            goto L_0x0384
        L_0x0381:
            r0 = move-exception
            goto L_0x0482
        L_0x0384:
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m     // Catch:{ Exception -> 0x0381 }
            int r8 = r1.f11344z     // Catch:{ Exception -> 0x0381 }
            r6.a((int) r8)     // Catch:{ Exception -> 0x0381 }
            com.mbridge.msdk.reward.adapter.c r6 = r1.f11331m     // Catch:{ Exception -> 0x0381 }
            com.mbridge.msdk.videocommon.d.c r8 = r1.f11332n     // Catch:{ Exception -> 0x0381 }
            r6.a((com.mbridge.msdk.videocommon.d.c) r8)     // Catch:{ Exception -> 0x0381 }
        L_0x0392:
            com.mbridge.msdk.foundation.c.b r6 = new com.mbridge.msdk.foundation.c.b     // Catch:{ Exception -> 0x040b }
            r6.<init>(r7)     // Catch:{ Exception -> 0x040b }
            com.mbridge.msdk.reward.adapter.c r9 = r1.f11331m     // Catch:{ Exception -> 0x040b }
            r7 = r6
            r6 = 0
            r8 = 1
            com.mbridge.msdk.foundation.b.c r6 = r3.a((java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.c.b) r7, (int) r8, (com.mbridge.msdk.reward.adapter.c) r9)     // Catch:{ Exception -> 0x040b }
            if (r6 == 0) goto L_0x0457
            int r5 = r6.g()     // Catch:{ Exception -> 0x040b }
            int r7 = com.mbridge.msdk.foundation.b.c.f8793d     // Catch:{ Exception -> 0x040b }
            if (r5 != r7) goto L_0x0457
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x040b }
            if (r5 == 0) goto L_0x0457
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x040b }
            int r5 = r5.size()     // Catch:{ Exception -> 0x040b }
            if (r5 <= 0) goto L_0x0457
            com.mbridge.msdk.reward.adapter.c r5 = r1.f11331m     // Catch:{ Exception -> 0x040b }
            if (r5 == 0) goto L_0x0457
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x040b }
            if (r0 == 0) goto L_0x0421
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x040b }
            r7.<init>()     // Catch:{ Exception -> 0x040b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x040b }
        L_0x03cd:
            boolean r8 = r0.hasNext()     // Catch:{ Exception -> 0x040b }
            if (r8 == 0) goto L_0x041c
            java.lang.Object r8 = r0.next()     // Catch:{ Exception -> 0x040b }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ Exception -> 0x040b }
            if (r8 == 0) goto L_0x03cd
            java.lang.String r9 = r8.getRequestId()     // Catch:{ Exception -> 0x040b }
            boolean r13 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x040b }
            if (r13 == 0) goto L_0x03e6
            goto L_0x03cd
        L_0x03e6:
            r0 = r11
        L_0x03e7:
            int r13 = r5.size()     // Catch:{ Exception -> 0x040b }
            if (r0 >= r13) goto L_0x0413
            java.lang.Object r13 = r5.get(r0)     // Catch:{ Exception -> 0x040b }
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = (com.mbridge.msdk.foundation.entity.CampaignEx) r13     // Catch:{ Exception -> 0x040b }
            if (r13 == 0) goto L_0x0410
            java.lang.String r13 = r13.getRequestId()     // Catch:{ Exception -> 0x040b }
            boolean r13 = r9.equals(r13)     // Catch:{ Exception -> 0x040b }
            if (r13 == 0) goto L_0x0400
            goto L_0x0413
        L_0x0400:
            int r13 = r5.size()     // Catch:{ Exception -> 0x040b }
            int r13 = r13 - r12
            if (r0 != r13) goto L_0x0410
            r7.add(r8)     // Catch:{ Exception -> 0x040b }
            goto L_0x0410
        L_0x040b:
            r0 = move-exception
            r5 = r19
            goto L_0x0482
        L_0x0410:
            int r0 = r0 + 1
            goto L_0x03e7
        L_0x0413:
            int r0 = r5.size()     // Catch:{ Exception -> 0x040b }
            if (r0 != 0) goto L_0x041c
            r7.add(r8)     // Catch:{ Exception -> 0x040b }
        L_0x041c:
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m     // Catch:{ Exception -> 0x040b }
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r7)     // Catch:{ Exception -> 0x040b }
        L_0x0421:
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m     // Catch:{ Exception -> 0x040b }
            java.util.concurrent.CopyOnWriteArrayList r5 = r6.a()     // Catch:{ Exception -> 0x040b }
            r0.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r5, (boolean) r11, (boolean) r12)     // Catch:{ Exception -> 0x040b }
            java.util.concurrent.CopyOnWriteArrayList r13 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x040b }
            java.util.concurrent.CopyOnWriteArrayList r0 = r6.a()     // Catch:{ Exception -> 0x040b }
            r13.<init>(r0)     // Catch:{ Exception -> 0x040b }
            goto L_0x0457
        L_0x0434:
            java.util.concurrent.CopyOnWriteArrayList r13 = r1.a((java.lang.String) r4, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)     // Catch:{ Exception -> 0x040b }
            int r0 = r13.size()     // Catch:{ Exception -> 0x040b }
            if (r0 <= 0) goto L_0x044d
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x040b }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x040b }
            com.mbridge.msdk.foundation.db.b r0 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r0)     // Catch:{ Exception -> 0x040b }
            r0.a((java.lang.String) r4, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r13)     // Catch:{ Exception -> 0x040b }
        L_0x044d:
            java.lang.String r0 = "cb is closed 2"
            r6.d(r0)     // Catch:{ Exception -> 0x040b }
            int r0 = com.mbridge.msdk.foundation.b.c.f8792c     // Catch:{ Exception -> 0x040b }
            r6.a((int) r0)     // Catch:{ Exception -> 0x040b }
        L_0x0457:
            r8 = 0
            r9 = 1
            r7 = 0
            r5 = r4
            r4 = r19
            r3.a((com.mbridge.msdk.foundation.same.report.d.c) r4, (java.lang.String) r5, (com.mbridge.msdk.foundation.b.c) r6, (java.util.List<com.mbridge.msdk.foundation.b.a.C0084a>) r7, (org.json.JSONObject) r8, (int) r9)     // Catch:{ Exception -> 0x047e }
            r15 = r5
            r5 = r4
            r4 = r15
            if (r13 == 0) goto L_0x048d
            int r0 = r13.size()     // Catch:{ Exception -> 0x0381 }
            if (r0 <= 0) goto L_0x048d
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r13, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)     // Catch:{ Exception -> 0x0381 }
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m     // Catch:{ Exception -> 0x0381 }
            if (r0 == 0) goto L_0x048d
            boolean r0 = r3.a(r4)     // Catch:{ Exception -> 0x0381 }
            if (r0 != 0) goto L_0x048d
            com.mbridge.msdk.reward.adapter.c r0 = r1.f11331m     // Catch:{ Exception -> 0x0381 }
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r13)     // Catch:{ Exception -> 0x0381 }
            goto L_0x048d
        L_0x047e:
            r0 = move-exception
            r15 = r5
            r5 = r4
            r4 = r15
        L_0x0482:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L_0x048d
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r10, r0)
        L_0x048d:
            r1.f11321Y = r11
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            boolean r3 = r1.f11303E
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.f11312P
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r5)
            goto L_0x04c0
        L_0x049c:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r7 = r1.f11337s
            r0.a((java.lang.String) r7, (java.lang.String) r4)
            if (r2 == 0) goto L_0x04c0
            com.mbridge.msdk.reward.b.a$c r0 = r1.f11335q
            if (r0 == 0) goto L_0x04c0
            java.lang.String r0 = com.mbridge.msdk.foundation.c.a.a(r3, r6)
            com.mbridge.msdk.foundation.c.b r2 = com.mbridge.msdk.foundation.c.a.b(r3, r6)
            if (r5 == 0) goto L_0x04bb
            r5.a((com.mbridge.msdk.foundation.c.b) r2)
            r5.c((boolean) r12)
        L_0x04bb:
            com.mbridge.msdk.reward.b.a$c r2 = r1.f11335q
            com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.same.report.d.c) r5)
        L_0x04c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.d.c):void");
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("cache", 1);
                cVar.a("2000127", eVar);
                cVar.a("2000048", eVar);
                cVar.a((List<CampaignEx>) copyOnWriteArrayList);
            } catch (Exception e5) {
                af.b("RewardVideoController", e5.getMessage());
            }
            this.f11321Y = true;
            this.f11335q.a(this.f11303E);
            c.a(this.f11335q, this.f11340v, this.f11337s, cVar);
            CampaignEx campaignEx = copyOnWriteArrayList.get(0);
            a(campaignEx.getRequestId(), str);
            com.mbridge.msdk.reward.adapter.c cVar2 = this.f11331m;
            if (cVar2 == null || !cVar2.a((List<CampaignEx>) copyOnWriteArrayList, true ^ TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
                a(copyOnWriteArrayList, this.f11331m);
                return;
            }
            a((List<CampaignEx>) copyOnWriteArrayList);
            this.f11335q.b(this.f11340v, this.f11337s, cVar);
        }
    }

    private CopyOnWriteArrayList<CampaignEx> a(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int i5 = 1;
                    for (CampaignEx next : list) {
                        if (next != null) {
                            if (next.getVcn() > i5) {
                                i5 = next.getVcn();
                            }
                            if (next.getTokenRule() == 1) {
                                String requestId = next.getRequestId();
                                if (!TextUtils.isEmpty(requestId)) {
                                    if (linkedHashMap.containsKey(requestId)) {
                                        List list2 = (List) linkedHashMap.get(requestId);
                                        if (list2 != null) {
                                            list2.add(next);
                                        }
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(next);
                                        linkedHashMap.put(requestId, arrayList);
                                    }
                                }
                            } else {
                                String requestId2 = next.getRequestId();
                                if (!TextUtils.isEmpty(requestId2)) {
                                    if (linkedHashMap2.containsKey(requestId2)) {
                                        List list3 = (List) linkedHashMap2.get(requestId2);
                                        if (list3 != null) {
                                            list3.add(next);
                                        }
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(next);
                                        linkedHashMap2.put(requestId2, arrayList2);
                                    }
                                }
                            }
                        }
                    }
                    if (!(linkedHashMap2.size() + linkedHashMap.size() < i5 || linkedHashMap.size() <= 0 || linkedHashMap.entrySet() == null || linkedHashMap.entrySet().iterator() == null || linkedHashMap.entrySet().iterator().next() == null || ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue() == null)) {
                        copyOnWriteArrayList.addAll((Collection) ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue());
                        com.mbridge.msdk.foundation.same.a.b.a(this.f11337s, str, i5);
                        return copyOnWriteArrayList;
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoController", e5.getMessage());
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
        CampaignEx campaignEx = copyOnWriteArrayList2.get(0);
        boolean isEmpty = TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        boolean z4 = !isEmpty;
        int nscpt = campaignEx.getNscpt();
        this.f11325g = false;
        this.f11326h = false;
        this.f11327i = false;
        this.f11328j = false;
        this.f11329k = false;
        com.mbridge.msdk.reward.adapter.b a5 = com.mbridge.msdk.reward.adapter.b.a();
        Context context = this.f11330l;
        boolean z5 = this.f11303E;
        int i5 = this.f11302D ? 287 : 94;
        Context context2 = context;
        String str = this.f11340v;
        boolean z6 = z5;
        String str2 = this.f11337s;
        com.mbridge.msdk.reward.adapter.b bVar = a5;
        int i6 = i5;
        String requestId = campaignEx.getRequestId();
        Context context3 = context2;
        AnonymousClass2 r11 = new b.c(campaignEx, z4, cVar, nscpt) {

            /* renamed from: a  reason: collision with root package name */
            com.mbridge.msdk.foundation.same.report.d.c f11346a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CampaignEx f11347b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f11348c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ com.mbridge.msdk.reward.adapter.c f11349d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f11350e;

            {
                this.f11347b = r2;
                this.f11348c = r3;
                this.f11349d = r4;
                this.f11350e = r5;
                this.f11346a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(r2.getLocalRequestId());
            }

            public final void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
                a.this.f11325g = true;
                if (!this.f11348c) {
                    Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        final CampaignEx next = it.next();
                        if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a.this.f11343y == null) {
                            com.mbridge.msdk.reward.adapter.c cVar = this.f11349d;
                            if (cVar == null || !cVar.a((List<CampaignEx>) copyOnWriteArrayList, this.f11348c, this.f11350e)) {
                                a aVar = a.this;
                                a.a(aVar, str2, aVar.aa);
                                if (a.this.f11335q != null && !a.this.f11328j) {
                                    a.this.f11328j = true;
                                    com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3503 errorMessage: have no temp but isReady false");
                                    if (this.f11346a == null) {
                                        this.f11346a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    this.f11346a.b((List<CampaignEx>) a.this.f11322Z);
                                    this.f11346a.a(b5);
                                    c.a(a.this.f11335q, b5, this.f11346a);
                                }
                            } else if (a.this.f11335q != null && !a.this.f11329k) {
                                a.this.f11329k = true;
                                af.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                a.this.a((List<CampaignEx>) copyOnWriteArrayList);
                                com.mbridge.msdk.foundation.same.report.d.c cVar2 = this.f11346a;
                                if (cVar2 != null) {
                                    cVar2.b((List<CampaignEx>) copyOnWriteArrayList);
                                }
                                a.this.f11335q.b(str, str2, this.f11346a);
                            }
                        } else {
                            final String str4 = str;
                            final String str5 = str2;
                            final String str6 = str3;
                            final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
                            a.this.f11343y.post(new Runnable() {
                                public final void run() {
                                    com.mbridge.msdk.reward.adapter.b.a().a(a.this.f11307I, a.this.f11343y, a.this.f11302D, a.this.f11303E, (WindVaneWebView) null, next.getRewardTemplateMode().e(), a.this.f11344z, AnonymousClass2.this.f11347b, copyOnWriteArrayList2, H5DownLoadManager.getInstance().getH5ResAddress(next.getRewardTemplateMode().e()), str4, str5, str6, next.getRequestIdNotice(), a.this.f11332n, new b.j() {
                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0114a aVar) {
                                            AnonymousClass1 r22 = AnonymousClass1.this;
                                            AnonymousClass2 r5 = AnonymousClass2.this;
                                            com.mbridge.msdk.reward.adapter.c cVar = r5.f11349d;
                                            if (cVar == null || !cVar.a((List<CampaignEx>) copyOnWriteArrayList2, r5.f11348c, r5.f11350e)) {
                                                a aVar2 = a.this;
                                                a.a(aVar2, str3, aVar2.aa);
                                                if (a.this.f11335q != null && !a.this.f11328j) {
                                                    a.this.f11328j = true;
                                                    com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                                    AnonymousClass2 r32 = AnonymousClass2.this;
                                                    if (r32.f11346a == null) {
                                                        r32.f11346a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                    }
                                                    AnonymousClass1 r33 = AnonymousClass1.this;
                                                    AnonymousClass2.this.f11346a.b((List<CampaignEx>) copyOnWriteArrayList2);
                                                    AnonymousClass2.this.f11346a.a(b5);
                                                    c.a(a.this.f11335q, b5, AnonymousClass2.this.f11346a);
                                                }
                                            } else if (a.this.f11335q != null && !a.this.f11329k) {
                                                a.this.f11329k = true;
                                                AnonymousClass1 r23 = AnonymousClass1.this;
                                                a.this.a((List<CampaignEx>) copyOnWriteArrayList2);
                                                a.this.f11335q.b(str2, str3, AnonymousClass2.this.f11346a);
                                            }
                                        }

                                        public final void a(String str, String str2, String str3, a.C0114a aVar, com.mbridge.msdk.foundation.c.b bVar) {
                                            AnonymousClass1 r12 = AnonymousClass1.this;
                                            a aVar2 = a.this;
                                            a.a(aVar2, str5, aVar2.aa);
                                            if (a.this.f11335q != null && !a.this.f11328j) {
                                                a.this.f11328j = true;
                                                bVar.a("errorCode: 3301 errorMessage: temp preload failed");
                                                AnonymousClass2 r13 = AnonymousClass2.this;
                                                if (r13.f11346a == null) {
                                                    r13.f11346a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                }
                                                AnonymousClass2 r14 = AnonymousClass2.this;
                                                r14.f11346a.b((List<CampaignEx>) a.this.f11322Z);
                                                AnonymousClass2.this.f11346a.a(bVar);
                                                c.a(a.this.f11335q, bVar, AnonymousClass2.this.f11346a);
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    }
                } else if (a.this.f11326h && !a.this.f11327i && a.this.f11343y != null) {
                    a.this.f11327i = true;
                    final String str7 = str;
                    final String str8 = str2;
                    final String str9 = str3;
                    final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = copyOnWriteArrayList;
                    a.this.f11343y.post(new Runnable() {
                        public final void run() {
                            com.mbridge.msdk.reward.adapter.b a5 = com.mbridge.msdk.reward.adapter.b.a();
                            com.mbridge.msdk.reward.adapter.b bVar = a5;
                            bVar.a(a.this.f11307I, a.this.f11343y, a.this.f11302D, a.this.f11303E, str9, AnonymousClass2.this.f11347b.getRequestIdNotice(), str7, str8, AnonymousClass2.this.f11347b.getCMPTEntryUrl(), a.this.f11344z, AnonymousClass2.this.f11347b, copyOnWriteArrayList3, H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass2.this.f11347b.getCMPTEntryUrl()), str8, a.this.f11332n, new b.j() {
                                public final void a(String str, String str2, String str3, String str4, String str5, a.C0114a aVar) {
                                    AnonymousClass2 r22 = AnonymousClass2.this;
                                    AnonymousClass2 r5 = AnonymousClass2.this;
                                    com.mbridge.msdk.reward.adapter.c cVar = r5.f11349d;
                                    if (cVar == null || !cVar.a((List<CampaignEx>) copyOnWriteArrayList3, r5.f11348c, r5.f11350e)) {
                                        a aVar2 = a.this;
                                        a.a(aVar2, str3, aVar2.aa);
                                        if (a.this.f11335q != null && !a.this.f11328j) {
                                            a.this.f11328j = true;
                                            com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3504 errorMessage: tpl temp preload success but isReady false");
                                            AnonymousClass2 r32 = AnonymousClass2.this;
                                            if (r32.f11346a == null) {
                                                r32.f11346a = new com.mbridge.msdk.foundation.same.report.d.c();
                                            }
                                            AnonymousClass2.this.f11346a.a(b5);
                                            AnonymousClass2 r33 = AnonymousClass2.this;
                                            AnonymousClass2.this.f11346a.b((List<CampaignEx>) copyOnWriteArrayList3);
                                            c.a(a.this.f11335q, b5, AnonymousClass2.this.f11346a);
                                        }
                                    } else if (a.this.f11335q != null && !a.this.f11329k) {
                                        a.this.f11329k = true;
                                        af.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                        AnonymousClass2 r23 = AnonymousClass2.this;
                                        a.this.a((List<CampaignEx>) copyOnWriteArrayList3);
                                        AnonymousClass2 r24 = AnonymousClass2.this;
                                        com.mbridge.msdk.foundation.same.report.d.c cVar2 = AnonymousClass2.this.f11346a;
                                        if (cVar2 != null) {
                                            cVar2.b((List<CampaignEx>) copyOnWriteArrayList3);
                                        }
                                        a.this.f11335q.b(str2, str3, AnonymousClass2.this.f11346a);
                                    }
                                }

                                public final void a(String str, String str2, String str3, a.C0114a aVar, com.mbridge.msdk.foundation.c.b bVar) {
                                    AnonymousClass2 r12 = AnonymousClass2.this;
                                    a aVar2 = a.this;
                                    a.a(aVar2, str8, aVar2.aa);
                                    if (a.this.f11335q != null && !a.this.f11328j) {
                                        a.this.f11328j = true;
                                        if (bVar != null) {
                                            bVar.a("errorCode: 3302 errorMessage: tpl preload failed");
                                        }
                                        AnonymousClass2 r13 = AnonymousClass2.this;
                                        if (r13.f11346a == null) {
                                            r13.f11346a = new com.mbridge.msdk.foundation.same.report.d.c();
                                        }
                                        AnonymousClass2 r14 = AnonymousClass2.this;
                                        AnonymousClass2.this.f11346a.b((List<CampaignEx>) copyOnWriteArrayList3);
                                        AnonymousClass2.this.f11346a.a(bVar);
                                        c.a(a.this.f11335q, bVar, AnonymousClass2.this.f11346a);
                                    }
                                }
                            }, true);
                        }
                    });
                }
            }

            public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.c.b bVar) {
                a.this.f11325g = false;
                a aVar = a.this;
                a.a(aVar, aVar.f11337s, a.this.aa);
                if (a.this.f11335q != null && !a.this.f11328j) {
                    a.this.f11328j = true;
                    if (this.f11346a == null) {
                        this.f11346a = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    this.f11346a.b((List<CampaignEx>) copyOnWriteArrayList);
                    if (bVar != null) {
                        bVar.a("errorCode: 3201 errorMessage: campaign resource download failed");
                    }
                    this.f11346a.a(bVar);
                    c.a(a.this.f11335q, bVar, this.f11346a);
                }
            }
        };
        boolean z7 = z4;
        AnonymousClass3 r02 = new b.i(campaignEx, copyOnWriteArrayList2, z7, nscpt) {

            /* renamed from: a  reason: collision with root package name */
            com.mbridge.msdk.foundation.same.report.d.c f11365a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CampaignEx f11366b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f11367c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ boolean f11368d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f11369e;

            {
                this.f11366b = r2;
                this.f11367c = r3;
                this.f11368d = r4;
                this.f11369e = r5;
                this.f11365a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(r2.getLocalRequestId());
            }

            public final void a(String str, String str2, String str3, String str4) {
            }

            public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
                String unitId = bVar == null ? "" : bVar.d().getUnitId();
                a aVar = a.this;
                a.a(aVar, unitId, aVar.aa);
                if (bVar != null) {
                    bVar.a("errorCode: 3202 errorMessage: temp resource download failed");
                }
                if (this.f11365a == null) {
                    this.f11365a = new com.mbridge.msdk.foundation.same.report.d.c();
                }
                this.f11365a.b((List<CampaignEx>) this.f11367c);
                this.f11365a.a(bVar);
                if (this.f11368d || a.this.f11335q == null) {
                    if (this.f11369e == 1 && !a.this.f11328j && a.this.f11335q != null) {
                        a.this.f11328j = true;
                        c.a(a.this.f11335q, bVar, this.f11365a);
                    }
                } else if (!a.this.f11328j) {
                    a.this.f11328j = true;
                    c.a(a.this.f11335q, bVar, this.f11365a);
                }
            }
        };
        boolean z8 = z7;
        int i7 = nscpt;
        boolean z9 = z6;
        AnonymousClass3 r12 = r02;
        com.mbridge.msdk.reward.adapter.b bVar2 = bVar;
        CampaignEx campaignEx2 = campaignEx;
        bVar2.a(context3, z8, i7, z9, i6, str, str2, requestId, copyOnWriteArrayList2, r11, r12);
        int i8 = i7;
        if (!isEmpty) {
            com.mbridge.msdk.reward.adapter.b a6 = com.mbridge.msdk.reward.adapter.b.a();
            CampaignEx campaignEx3 = campaignEx2;
            a6.a(this.f11330l, campaignEx3, this.f11340v, this.f11337s, campaignEx2.getRequestId(), new b.i(campaignEx3, copyOnWriteArrayList, cVar, z8, i8) {

                /* renamed from: a  reason: collision with root package name */
                com.mbridge.msdk.foundation.same.report.d.c f11371a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ CampaignEx f11372b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ CopyOnWriteArrayList f11373c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ com.mbridge.msdk.reward.adapter.c f11374d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ boolean f11375e;

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ int f11376f;

                {
                    this.f11372b = r2;
                    this.f11373c = r3;
                    this.f11374d = r4;
                    this.f11375e = r5;
                    this.f11376f = r6;
                    this.f11371a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(r2.getLocalRequestId());
                }

                public final void a(final String str, final String str2, final String str3, String str4) {
                    a.this.f11326h = true;
                    if (a.this.f11325g && !a.this.f11327i && a.this.f11343y != null) {
                        a.this.f11327i = true;
                        a.this.f11343y.post(new Runnable() {
                            public final void run() {
                                com.mbridge.msdk.reward.adapter.b a5 = com.mbridge.msdk.reward.adapter.b.a();
                                boolean l5 = a.this.f11307I;
                                Handler k5 = a.this.f11343y;
                                boolean c5 = a.this.f11302D;
                                boolean e5 = a.this.f11303E;
                                String str = str3;
                                String requestIdNotice = AnonymousClass4.this.f11372b.getRequestIdNotice();
                                String str2 = str;
                                String str3 = str2;
                                String cMPTEntryUrl = AnonymousClass4.this.f11372b.getCMPTEntryUrl();
                                int m5 = a.this.f11344z;
                                AnonymousClass4 r12 = AnonymousClass4.this;
                                CampaignEx campaignEx = r12.f11372b;
                                CopyOnWriteArrayList copyOnWriteArrayList = r12.f11373c;
                                String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass4.this.f11372b.getCMPTEntryUrl());
                                String str4 = str2;
                                com.mbridge.msdk.videocommon.d.c i5 = a.this.f11332n;
                                com.mbridge.msdk.reward.adapter.b bVar = a5;
                                com.mbridge.msdk.videocommon.d.c cVar = i5;
                                CampaignEx campaignEx2 = campaignEx;
                                CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
                                bVar.a(l5, k5, c5, e5, str, requestIdNotice, str2, str3, cMPTEntryUrl, m5, campaignEx2, copyOnWriteArrayList2, h5ResAddress, str4, cVar, new b.j() {
                                    public final void a(String str, String str2, String str3, String str4, String str5, a.C0114a aVar) {
                                        AnonymousClass4 r22 = AnonymousClass4.this;
                                        com.mbridge.msdk.reward.adapter.c cVar = r22.f11374d;
                                        if (cVar == null || !cVar.a((List<CampaignEx>) r22.f11373c, r22.f11375e, r22.f11376f)) {
                                            a aVar2 = a.this;
                                            a.a(aVar2, str3, aVar2.aa);
                                            if (a.this.f11335q != null && !a.this.f11328j) {
                                                a.this.f11328j = true;
                                                com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                                AnonymousClass4 r32 = AnonymousClass4.this;
                                                if (r32.f11371a == null) {
                                                    r32.f11371a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                }
                                                AnonymousClass4 r33 = AnonymousClass4.this;
                                                r33.f11371a.b((List<CampaignEx>) r33.f11373c);
                                                AnonymousClass4.this.f11371a.a(b5);
                                                c.a(a.this.f11335q, b5, AnonymousClass4.this.f11371a);
                                            }
                                        } else if (a.this.f11335q != null && !a.this.f11329k) {
                                            a.this.f11329k = true;
                                            af.a("RewardVideoController", "Cache onVideoLoadSuccess");
                                            AnonymousClass4 r23 = AnonymousClass4.this;
                                            a.this.a((List<CampaignEx>) r23.f11373c);
                                            AnonymousClass4 r24 = AnonymousClass4.this;
                                            com.mbridge.msdk.foundation.same.report.d.c cVar2 = r24.f11371a;
                                            if (cVar2 != null) {
                                                cVar2.b((List<CampaignEx>) r24.f11373c);
                                            }
                                            a.this.f11335q.b(str2, str3, AnonymousClass4.this.f11371a);
                                        }
                                    }

                                    public final void a(String str, String str2, String str3, a.C0114a aVar, com.mbridge.msdk.foundation.c.b bVar) {
                                        AnonymousClass1 r12 = AnonymousClass1.this;
                                        a aVar2 = a.this;
                                        a.a(aVar2, str2, aVar2.aa);
                                        if (a.this.f11335q != null && !a.this.f11328j) {
                                            a.this.f11328j = true;
                                            if (bVar != null) {
                                                bVar.a("errorCode: 3303 errorMessage: tpl temp preload failed");
                                            }
                                            AnonymousClass4 r13 = AnonymousClass4.this;
                                            if (r13.f11371a == null) {
                                                r13.f11371a = new com.mbridge.msdk.foundation.same.report.d.c();
                                            }
                                            AnonymousClass4 r14 = AnonymousClass4.this;
                                            r14.f11371a.b((List<CampaignEx>) r14.f11373c);
                                            AnonymousClass4.this.f11371a.a(bVar);
                                            c.a(a.this.f11335q, bVar, AnonymousClass4.this.f11371a);
                                        }
                                    }
                                }, true);
                            }
                        });
                    }
                }

                public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
                    String str3;
                    if (bVar != null) {
                        str3 = bVar.d().getUnitId();
                        bVar.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
                    } else {
                        str3 = "";
                    }
                    a aVar = a.this;
                    a.a(aVar, str3, aVar.aa);
                    if (this.f11371a == null) {
                        this.f11371a = new com.mbridge.msdk.foundation.same.report.d.c();
                    }
                    this.f11371a.a(bVar);
                    this.f11371a.b((List<CampaignEx>) this.f11373c);
                    a.this.f11326h = false;
                    if (a.this.f11335q != null && !a.this.f11328j) {
                        a.this.f11328j = true;
                        c.a(a.this.f11335q, bVar, this.f11371a);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.Queue<java.lang.Integer> r12, boolean r13, java.lang.String r14, com.mbridge.msdk.foundation.same.report.d.c r15) {
        /*
            r11 = this;
            java.lang.String r1 = "RewardVideoController"
            r2 = 1
            java.lang.String r3 = "load mv api error:"
            r4 = 880020(0xd6d94, float:1.23317E-39)
            if (r12 == 0) goto L_0x0023
            int r0 = r12.size()     // Catch:{ Exception -> 0x001e }
            if (r0 <= 0) goto L_0x0023
            java.lang.Object r12 = r12.poll()     // Catch:{ Exception -> 0x001e }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ Exception -> 0x001e }
            if (r12 == 0) goto L_0x0023
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x001e }
        L_0x001c:
            r7 = r12
            goto L_0x0026
        L_0x001e:
            r0 = move-exception
            r12 = r0
            r5 = r11
            r10 = r15
            goto L_0x0063
        L_0x0023:
            r12 = 25
            goto L_0x001c
        L_0x0026:
            r6 = 1
            r5 = r11
            r8 = r13
            r9 = r14
            r10 = r15
            r5.a((int) r6, (int) r7, (boolean) r8, (java.lang.String) r9, (com.mbridge.msdk.foundation.same.report.d.c) r10)     // Catch:{ Exception -> 0x002f }
            goto L_0x0090
        L_0x002f:
            r0 = move-exception
            r12 = r0
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0051 }
            r13.<init>()     // Catch:{ Exception -> 0x0051 }
            r13.append(r3)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r14 = r12.getMessage()     // Catch:{ Exception -> 0x0051 }
            r13.append(r14)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0051 }
            com.mbridge.msdk.foundation.c.b r13 = com.mbridge.msdk.foundation.c.a.b(r4, r13)     // Catch:{ Exception -> 0x0051 }
            if (r10 == 0) goto L_0x0054
            r10.a((com.mbridge.msdk.foundation.c.b) r13)     // Catch:{ Exception -> 0x0051 }
            r10.c((boolean) r2)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0054
        L_0x0051:
            r0 = move-exception
            r12 = r0
            goto L_0x0063
        L_0x0054:
            r11.a((com.mbridge.msdk.foundation.c.b) r13, (com.mbridge.msdk.foundation.same.report.d.c) r10)     // Catch:{ Exception -> 0x0051 }
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0051 }
            if (r13 == 0) goto L_0x0090
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x0051 }
            com.mbridge.msdk.foundation.tools.af.b(r1, r12)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0090
        L_0x0063:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r3)
            java.lang.String r14 = r12.getMessage()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.mbridge.msdk.foundation.c.b r13 = com.mbridge.msdk.foundation.c.a.b(r4, r13)
            if (r10 == 0) goto L_0x0082
            r10.a((com.mbridge.msdk.foundation.c.b) r13)
            r10.c((boolean) r2)
        L_0x0082:
            r11.a((com.mbridge.msdk.foundation.c.b) r13, (com.mbridge.msdk.foundation.same.report.d.c) r10)
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto L_0x0090
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r12)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(java.util.Queue, boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.d.c):void");
    }

    /* access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f11335q != null) {
            this.f11320X = true;
            this.f11335q.a(bVar, cVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A[Catch:{ Exception -> 0x0011 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r9, int r10, boolean r11, java.lang.String r12, com.mbridge.msdk.foundation.same.report.d.c r13) {
        /*
            r8 = this;
            com.mbridge.msdk.reward.adapter.c r0 = r8.f11331m     // Catch:{ Exception -> 0x0011 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = r8.f11337s     // Catch:{ Exception -> 0x0011 }
            java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x0011 }
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0011 }
            if (r0 != 0) goto L_0x002d
            goto L_0x0014
        L_0x0011:
            r0 = move-exception
            goto L_0x0082
        L_0x0014:
            com.mbridge.msdk.reward.adapter.c r0 = new com.mbridge.msdk.reward.adapter.c     // Catch:{ Exception -> 0x0011 }
            android.content.Context r2 = r8.f11330l     // Catch:{ Exception -> 0x0011 }
            java.lang.String r3 = r8.f11340v     // Catch:{ Exception -> 0x0011 }
            java.lang.String r4 = r8.f11337s     // Catch:{ Exception -> 0x0011 }
            r0.<init>(r2, r3, r4)     // Catch:{ Exception -> 0x0011 }
            r8.f11331m = r0     // Catch:{ Exception -> 0x0011 }
            boolean r2 = r8.f11302D     // Catch:{ Exception -> 0x0011 }
            r0.b((boolean) r2)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r0 = r8.f11331m     // Catch:{ Exception -> 0x0011 }
            boolean r2 = r8.f11303E     // Catch:{ Exception -> 0x0011 }
            r0.c((boolean) r2)     // Catch:{ Exception -> 0x0011 }
        L_0x002d:
            boolean r0 = r8.f11302D     // Catch:{ Exception -> 0x0011 }
            if (r0 == 0) goto L_0x003c
            com.mbridge.msdk.reward.adapter.c r0 = r8.f11331m     // Catch:{ Exception -> 0x0011 }
            int r2 = r8.f11299A     // Catch:{ Exception -> 0x0011 }
            int r3 = r8.f11300B     // Catch:{ Exception -> 0x0011 }
            int r4 = r8.f11301C     // Catch:{ Exception -> 0x0011 }
            r0.a((int) r2, (int) r3, (int) r4)     // Catch:{ Exception -> 0x0011 }
        L_0x003c:
            com.mbridge.msdk.reward.adapter.c r0 = r8.f11331m     // Catch:{ Exception -> 0x0011 }
            int r2 = r8.f11344z     // Catch:{ Exception -> 0x0011 }
            r0.a((int) r2)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r0 = r8.f11331m     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.videocommon.d.c r2 = r8.f11332n     // Catch:{ Exception -> 0x0011 }
            r0.a((com.mbridge.msdk.videocommon.d.c) r2)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.b.a$a r0 = new com.mbridge.msdk.reward.b.a$a     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r2 = r8.f11331m     // Catch:{ Exception -> 0x0011 }
            r1 = r8
            r3 = r9
            r4 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0011 }
            r7 = r0
            r7.a(r10)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.b.a$b r0 = new com.mbridge.msdk.reward.b.a$b     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r1 = r8.f11331m     // Catch:{ Exception -> 0x0011 }
            r0.<init>(r1, r11)     // Catch:{ Exception -> 0x0011 }
            r8.f11323a = r0     // Catch:{ Exception -> 0x0011 }
            r0.a(r7)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r0 = r8.f11331m     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.b.a$b r1 = r8.f11323a     // Catch:{ Exception -> 0x0011 }
            r0.a((com.mbridge.msdk.reward.adapter.a) r1)     // Catch:{ Exception -> 0x0011 }
            com.mbridge.msdk.reward.adapter.c r0 = r8.f11331m     // Catch:{ Exception -> 0x0011 }
            boolean r5 = r8.f11307I     // Catch:{ Exception -> 0x0011 }
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r13
            r0.a((int) r1, (int) r2, (boolean) r3, (java.lang.String) r4, (boolean) r5, (com.mbridge.msdk.foundation.same.report.d.c) r6)     // Catch:{ Exception -> 0x0011 }
            android.os.Handler r0 = r8.f11343y     // Catch:{ Exception -> 0x0011 }
            int r1 = r10 * 1000
            long r1 = (long) r1     // Catch:{ Exception -> 0x0011 }
            r0.postDelayed(r7, r1)     // Catch:{ Exception -> 0x0011 }
            return
        L_0x0082:
            r1 = 880020(0xd6d94, float:1.23317E-39)
            java.lang.String r2 = r0.getMessage()
            com.mbridge.msdk.foundation.c.b r1 = com.mbridge.msdk.foundation.c.a.b(r1, r2)
            if (r13 == 0) goto L_0x0096
            r13.a((com.mbridge.msdk.foundation.c.b) r1)
            r2 = 1
            r13.c((boolean) r2)
        L_0x0096:
            r8.a((com.mbridge.msdk.foundation.c.b) r1, (com.mbridge.msdk.foundation.same.report.d.c) r13)
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x00a6
            java.lang.String r1 = "RewardVideoController"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(int, int, boolean, java.lang.String, com.mbridge.msdk.foundation.same.report.d.c):void");
    }

    private void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        com.mbridge.msdk.videocommon.d.c cVar2;
        com.mbridge.msdk.videocommon.d.c cVar3;
        boolean z4;
        boolean z5;
        try {
            if (this.f11331m == null) {
                r();
            }
            if (this.f11331m != null) {
                af.b("RewardVideoController", "controller 819");
                if (this.f11303E) {
                    z4 = e(false);
                } else {
                    z4 = this.f11331m.b();
                }
                if (z4) {
                    af.c("RewardVideoController", "invoke adapter show isReady");
                    d dVar = new d(this, this.f11343y);
                    f11298f.put(this.f11337s, dVar);
                    this.f11331m.a((com.mbridge.msdk.video.bt.module.b.h) dVar, str, this.f11336r, this.f11344z, this.f11339u, cVar);
                    this.f11324c = false;
                    return;
                }
                if (this.f11303E) {
                    if (this.f11331m == null) {
                        r();
                    }
                    List<com.mbridge.msdk.foundation.entity.c> a5 = com.mbridge.msdk.videocommon.a.a.a().a(this.f11337s);
                    if (a5 != null && a5.size() > 0) {
                        Iterator<com.mbridge.msdk.foundation.entity.c> it = a5.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            com.mbridge.msdk.foundation.entity.c next = it.next();
                            if (next != null) {
                                this.f11331m.a(next.a());
                                this.f11331m.f11212d = next.d();
                                if (this.f11331m.c()) {
                                    z5 = true;
                                    break;
                                }
                                com.mbridge.msdk.videocommon.a.a.a().c(this.f11337s, next.a());
                            }
                        }
                    }
                    z5 = false;
                } else {
                    z5 = this.f11331m.c();
                }
                if (z5) {
                    af.c("RewardVideoController", "invoke adapter show isSpareOfferReady");
                    d dVar2 = new d(this, this.f11343y);
                    f11298f.put(this.f11337s, dVar2);
                    this.f11331m.a((com.mbridge.msdk.video.bt.module.b.h) dVar2, str, this.f11336r, this.f11344z, this.f11339u, cVar);
                    this.f11324c = false;
                    return;
                }
            }
            this.f11324c = false;
            a("2000131", cVar, this.f11334p, "can't show because load is failed");
            if (this.f11334p != null) {
                try {
                    this.f11334p.onShowFail(cVar, this.f11338t, "can't show because load is failed");
                } catch (Exception e5) {
                    Exception exc = e5;
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", exc.getMessage());
                    }
                }
            }
            if (!this.f11302D && !this.f11303E && (cVar3 = this.f11332n) != null && cVar3.s(4) && this.f11335q != null && this.f11335q.f11398c.get() != 1 && this.f11335q.f11398c.get() != 3) {
                a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, this.f11337s, true, 1));
            }
        } catch (Exception e6) {
            Exception exc2 = e6;
            this.f11324c = false;
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoController", exc2.getLocalizedMessage());
            }
            a("2000131", cVar, this.f11334p, "show exception");
            if (this.f11334p != null) {
                try {
                    this.f11334p.onShowFail(cVar, this.f11338t, "show exception");
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoController", exc2.getMessage());
                    }
                }
            }
            if (!this.f11302D && !this.f11303E && (cVar2 = this.f11332n) != null && cVar2.s(4) && this.f11335q != null && this.f11335q.f11398c.get() != 1 && this.f11335q.f11398c.get() != 3) {
                a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, this.f11337s, true, 1));
            }
        }
    }

    private boolean a(List<com.mbridge.msdk.foundation.entity.c> list, String str) {
        if (list == null) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.c next : list) {
            if (next != null && str.equals(next.b())) {
                this.f11331m.a(next.a());
                this.f11331m.f11212d = next.d();
                if (this.f11331m.b()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x015a, code lost:
        if (r11.f11303E != false) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x015c, code lost:
        r12 = r11.f11332n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x015e, code lost:
        if (r12 == null) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0164, code lost:
        if (r12.s(4) == false) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0168, code lost:
        if (r11.f11335q == null) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0170, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f11335q) == 1) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0178, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f11335q) == 3) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x017a, code lost:
        a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, r11.f11337s, true, 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x018c, code lost:
        r11.f11324c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0196, code lost:
        if (android.text.TextUtils.isEmpty(r11.f11336r) == false) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0198, code lost:
        r11.f11336r = com.mbridge.msdk.foundation.tools.f.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r13 = new java.text.SimpleDateFormat("dd").format(new java.util.Date());
        r14 = (java.lang.String) com.mbridge.msdk.foundation.tools.an.a(r11.f11330l, "reward_date", "0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01be, code lost:
        if (android.text.TextUtils.isEmpty(r14) != false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01c4, code lost:
        if (android.text.TextUtils.isEmpty(r13) != false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01ca, code lost:
        if (r14.equals(r13) != false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01cc, code lost:
        com.mbridge.msdk.foundation.tools.an.b(r11.f11330l, "reward_date", r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01d4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01d5, code lost:
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01d8, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01da, code lost:
        com.mbridge.msdk.foundation.tools.af.b("RewardVideoController", r13.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01e3, code lost:
        a(r12, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r13 = r11.f11330l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        if (r13 != null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        a("2000131", r15, r11.f11334p, "context is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        if (r11.f11334p == null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r11.f11334p.onShowFail(r15, r11.f11338t, "context is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0061, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0064, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0066, code lost:
        com.mbridge.msdk.foundation.tools.af.b("RewardVideoController", r12.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        if (r11.f11302D != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007a, code lost:
        if (r11.f11303E != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007c, code lost:
        r12 = r11.f11332n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007e, code lost:
        if (r12 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0084, code lost:
        if (r12.s(4) == false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0088, code lost:
        if (r11.f11335q == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0090, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f11335q) == 1) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0098, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f11335q) == 3) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009a, code lost:
        a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, r11.f11337s, true, 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ac, code lost:
        r11.f11324c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b2, code lost:
        if (r11.f11302D == false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b8, code lost:
        if (com.mbridge.msdk.foundation.tools.ak.l(r13) != false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c4, code lost:
        if (com.mbridge.msdk.foundation.tools.ah.a().a("s_a_w_n_c", true) == false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c6, code lost:
        a("2000131", r15, r11.f11334p, "network exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d1, code lost:
        if (r11.f11334p == null) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r11.f11334p.onShowFail(r15, r11.f11338t, "network exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00dd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00de, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e1, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00e3, code lost:
        com.mbridge.msdk.foundation.tools.af.b("RewardVideoController", r12.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00ee, code lost:
        if (r11.f11302D != false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f2, code lost:
        if (r11.f11303E != false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f4, code lost:
        r12 = r11.f11332n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00f6, code lost:
        if (r12 == null) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00fc, code lost:
        if (r12.s(4) == false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0100, code lost:
        if (r11.f11335q == null) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0108, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f11335q) == 1) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0110, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.f11335q) == 3) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0112, code lost:
        a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 94, r11.f11337s, true, 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0124, code lost:
        r11.f11324c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x012c, code lost:
        if (s() == false) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x012e, code lost:
        a("2000131", r15, r11.f11334p, "Play more than limit");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0139, code lost:
        if (r11.f11334p == null) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r11.f11334p.onShowFail(r15, r11.f11338t, "Play more than limit");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0145, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0146, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0149, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x014b, code lost:
        com.mbridge.msdk.foundation.tools.af.b("RewardVideoController", r12.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0156, code lost:
        if (r11.f11302D != false) goto L_0x018c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r12, java.lang.String r13, java.lang.String r14, com.mbridge.msdk.foundation.same.report.d.e r15) {
        /*
            r11 = this;
            com.mbridge.msdk.foundation.same.report.d.c r15 = r11.a((com.mbridge.msdk.foundation.same.report.d.e) r15)
            r1 = 3
            r2 = 4
            r3 = 1
            r4 = 0
            r11.f11341w = r12     // Catch:{ Exception -> 0x0070 }
            r11.f11336r = r13     // Catch:{ Exception -> 0x0070 }
            r11.f11339u = r14     // Catch:{ Exception -> 0x0070 }
            java.lang.Object r13 = r11.f11310L     // Catch:{ Exception -> 0x0070 }
            monitor-enter(r13)     // Catch:{ Exception -> 0x0070 }
            boolean r14 = r11.f11324c     // Catch:{ all -> 0x002c }
            if (r14 == 0) goto L_0x0042
            java.lang.String r12 = "2000131"
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r14 = r11.f11334p     // Catch:{ all -> 0x002c }
            java.lang.String r0 = "campaing is show progressing "
            r11.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.report.d.c) r15, (com.mbridge.msdk.videocommon.listener.InterVideoOutListener) r14, (java.lang.String) r0)     // Catch:{ all -> 0x002c }
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f11334p     // Catch:{ all -> 0x002c }
            if (r12 == 0) goto L_0x003f
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f11334p     // Catch:{ Exception -> 0x0030 }
            com.mbridge.msdk.out.MBridgeIds r14 = r11.f11338t     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = "campaing is show progressing "
            r12.onShowFail(r15, r14, r0)     // Catch:{ Exception -> 0x0030 }
            goto L_0x003f
        L_0x002c:
            r0 = move-exception
            r12 = r0
            goto L_0x01e7
        L_0x0030:
            r0 = move-exception
            r12 = r0
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x002c }
            if (r14 == 0) goto L_0x003f
            java.lang.String r14 = "RewardVideoController"
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x002c }
            com.mbridge.msdk.foundation.tools.af.b(r14, r12)     // Catch:{ all -> 0x002c }
        L_0x003f:
            monitor-exit(r13)     // Catch:{ all -> 0x002c }
            goto L_0x0254
        L_0x0042:
            r11.f11324c = r3     // Catch:{ all -> 0x002c }
            monitor-exit(r13)     // Catch:{ all -> 0x002c }
            android.content.Context r13 = r11.f11330l     // Catch:{ Exception -> 0x0070 }
            if (r13 != 0) goto L_0x00b0
            java.lang.String r12 = "2000131"
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.f11334p     // Catch:{ Exception -> 0x0070 }
            java.lang.String r14 = "context is null"
            r11.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.report.d.c) r15, (com.mbridge.msdk.videocommon.listener.InterVideoOutListener) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f11334p     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x0074
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f11334p     // Catch:{ Exception -> 0x0060 }
            com.mbridge.msdk.out.MBridgeIds r13 = r11.f11338t     // Catch:{ Exception -> 0x0060 }
            java.lang.String r14 = "context is null"
            r12.onShowFail(r15, r13, r14)     // Catch:{ Exception -> 0x0060 }
            goto L_0x0074
        L_0x0060:
            r0 = move-exception
            r12 = r0
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x0074
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r0 = move-exception
            r12 = r0
            goto L_0x01e9
        L_0x0074:
            boolean r12 = r11.f11302D     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x00ac
            boolean r12 = r11.f11303E     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x00ac
            com.mbridge.msdk.videocommon.d.c r12 = r11.f11332n     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x00ac
            boolean r12 = r12.s(r2)     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x00ac
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x00ac
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f11398c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r3) goto L_0x00ac
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f11398c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r1) goto L_0x00ac
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r8 = r11.f11337s     // Catch:{ Exception -> 0x0070 }
            r9 = 1
            r10 = 1
            r6 = 0
            r7 = 94
            com.mbridge.msdk.foundation.same.report.d.e r12 = r5.a((int) r6, (int) r7, (java.lang.String) r8, (boolean) r9, (int) r10)     // Catch:{ Exception -> 0x0070 }
            r11.a((boolean) r4, (com.mbridge.msdk.foundation.same.report.d.e) r12)     // Catch:{ Exception -> 0x0070 }
        L_0x00ac:
            r11.f11324c = r4     // Catch:{ Exception -> 0x0070 }
            goto L_0x0254
        L_0x00b0:
            boolean r14 = r11.f11302D     // Catch:{ Exception -> 0x0070 }
            if (r14 == 0) goto L_0x0128
            boolean r13 = com.mbridge.msdk.foundation.tools.ak.l((android.content.Context) r13)     // Catch:{ Exception -> 0x0070 }
            if (r13 != 0) goto L_0x0128
            com.mbridge.msdk.foundation.tools.ah r13 = com.mbridge.msdk.foundation.tools.ah.a()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r14 = "s_a_w_n_c"
            boolean r13 = r13.a((java.lang.String) r14, (boolean) r3)     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x0128
            java.lang.String r12 = "2000131"
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.f11334p     // Catch:{ Exception -> 0x0070 }
            java.lang.String r14 = "network exception"
            r11.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.report.d.c) r15, (com.mbridge.msdk.videocommon.listener.InterVideoOutListener) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f11334p     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x00ec
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f11334p     // Catch:{ Exception -> 0x00dd }
            com.mbridge.msdk.out.MBridgeIds r13 = r11.f11338t     // Catch:{ Exception -> 0x00dd }
            java.lang.String r14 = "network exception"
            r12.onShowFail(r15, r13, r14)     // Catch:{ Exception -> 0x00dd }
            goto L_0x00ec
        L_0x00dd:
            r0 = move-exception
            r12 = r0
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x00ec
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)     // Catch:{ Exception -> 0x0070 }
        L_0x00ec:
            boolean r12 = r11.f11302D     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x0124
            boolean r12 = r11.f11303E     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x0124
            com.mbridge.msdk.videocommon.d.c r12 = r11.f11332n     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x0124
            boolean r12 = r12.s(r2)     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x0124
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x0124
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f11398c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r3) goto L_0x0124
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f11398c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r1) goto L_0x0124
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r8 = r11.f11337s     // Catch:{ Exception -> 0x0070 }
            r9 = 1
            r10 = 1
            r6 = 0
            r7 = 94
            com.mbridge.msdk.foundation.same.report.d.e r12 = r5.a((int) r6, (int) r7, (java.lang.String) r8, (boolean) r9, (int) r10)     // Catch:{ Exception -> 0x0070 }
            r11.a((boolean) r4, (com.mbridge.msdk.foundation.same.report.d.e) r12)     // Catch:{ Exception -> 0x0070 }
        L_0x0124:
            r11.f11324c = r4     // Catch:{ Exception -> 0x0070 }
            goto L_0x0254
        L_0x0128:
            boolean r13 = r11.s()     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x0190
            java.lang.String r12 = "2000131"
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.f11334p     // Catch:{ Exception -> 0x0070 }
            java.lang.String r14 = "Play more than limit"
            r11.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.report.d.c) r15, (com.mbridge.msdk.videocommon.listener.InterVideoOutListener) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f11334p     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x0154
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.f11334p     // Catch:{ Exception -> 0x0145 }
            com.mbridge.msdk.out.MBridgeIds r13 = r11.f11338t     // Catch:{ Exception -> 0x0145 }
            java.lang.String r14 = "Play more than limit"
            r12.onShowFail(r15, r13, r14)     // Catch:{ Exception -> 0x0145 }
            goto L_0x0154
        L_0x0145:
            r0 = move-exception
            r12 = r0
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x0154
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)     // Catch:{ Exception -> 0x0070 }
        L_0x0154:
            boolean r12 = r11.f11302D     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x018c
            boolean r12 = r11.f11303E     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x018c
            com.mbridge.msdk.videocommon.d.c r12 = r11.f11332n     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x018c
            boolean r12 = r12.s(r2)     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x018c
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q     // Catch:{ Exception -> 0x0070 }
            if (r12 == 0) goto L_0x018c
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f11398c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r3) goto L_0x018c
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q     // Catch:{ Exception -> 0x0070 }
            int r12 = r12.f11398c.get()     // Catch:{ Exception -> 0x0070 }
            if (r12 == r1) goto L_0x018c
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r8 = r11.f11337s     // Catch:{ Exception -> 0x0070 }
            r9 = 1
            r10 = 1
            r6 = 0
            r7 = 94
            com.mbridge.msdk.foundation.same.report.d.e r12 = r5.a((int) r6, (int) r7, (java.lang.String) r8, (boolean) r9, (int) r10)     // Catch:{ Exception -> 0x0070 }
            r11.a((boolean) r4, (com.mbridge.msdk.foundation.same.report.d.e) r12)     // Catch:{ Exception -> 0x0070 }
        L_0x018c:
            r11.f11324c = r4     // Catch:{ Exception -> 0x0070 }
            goto L_0x0254
        L_0x0190:
            java.lang.String r13 = r11.f11336r     // Catch:{ Exception -> 0x0070 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0070 }
            if (r13 == 0) goto L_0x019e
            java.lang.String r13 = com.mbridge.msdk.foundation.tools.f.c()     // Catch:{ Exception -> 0x0070 }
            r11.f11336r = r13     // Catch:{ Exception -> 0x0070 }
        L_0x019e:
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01d4 }
            java.lang.String r14 = "dd"
            r13.<init>(r14)     // Catch:{ Exception -> 0x01d4 }
            java.util.Date r14 = new java.util.Date     // Catch:{ Exception -> 0x01d4 }
            r14.<init>()     // Catch:{ Exception -> 0x01d4 }
            java.lang.String r13 = r13.format(r14)     // Catch:{ Exception -> 0x01d4 }
            android.content.Context r14 = r11.f11330l     // Catch:{ Exception -> 0x01d4 }
            java.lang.String r0 = "reward_date"
            java.lang.String r5 = "0"
            java.lang.Object r14 = com.mbridge.msdk.foundation.tools.an.a(r14, r0, r5)     // Catch:{ Exception -> 0x01d4 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x01d4 }
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x01d4 }
            if (r0 != 0) goto L_0x01e3
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x01d4 }
            if (r0 != 0) goto L_0x01e3
            boolean r14 = r14.equals(r13)     // Catch:{ Exception -> 0x01d4 }
            if (r14 != 0) goto L_0x01e3
            android.content.Context r14 = r11.f11330l     // Catch:{ Exception -> 0x01d4 }
            java.lang.String r0 = "reward_date"
            com.mbridge.msdk.foundation.tools.an.b(r14, r0, r13)     // Catch:{ Exception -> 0x01d4 }
            goto L_0x01e3
        L_0x01d4:
            r0 = move-exception
            r13 = r0
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0070 }
            if (r14 == 0) goto L_0x01e3
            java.lang.String r14 = "RewardVideoController"
            java.lang.String r13 = r13.getMessage()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.foundation.tools.af.b(r14, r13)     // Catch:{ Exception -> 0x0070 }
        L_0x01e3:
            r11.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.report.d.c) r15)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0254
        L_0x01e7:
            monitor-exit(r13)     // Catch:{ all -> 0x002c }
            throw r12     // Catch:{ Exception -> 0x0070 }
        L_0x01e9:
            r11.f11324c = r4
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto L_0x01f8
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r14 = r12.getLocalizedMessage()
            com.mbridge.msdk.foundation.tools.af.b(r13, r14)
        L_0x01f8:
            java.lang.String r13 = "2000131"
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r14 = r11.f11334p
            java.lang.String r0 = "show exception"
            r11.a((java.lang.String) r13, (com.mbridge.msdk.foundation.same.report.d.c) r15, (com.mbridge.msdk.videocommon.listener.InterVideoOutListener) r14, (java.lang.String) r0)
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.f11334p
            if (r13 == 0) goto L_0x021c
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.f11334p     // Catch:{ Exception -> 0x020f }
            com.mbridge.msdk.out.MBridgeIds r14 = r11.f11338t     // Catch:{ Exception -> 0x020f }
            java.lang.String r0 = "show exception"
            r13.onShowFail(r15, r14, r0)     // Catch:{ Exception -> 0x020f }
            goto L_0x021c
        L_0x020f:
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto L_0x021c
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)
        L_0x021c:
            boolean r12 = r11.f11302D
            if (r12 != 0) goto L_0x0254
            boolean r12 = r11.f11303E
            if (r12 != 0) goto L_0x0254
            com.mbridge.msdk.videocommon.d.c r12 = r11.f11332n
            if (r12 == 0) goto L_0x0254
            boolean r12 = r12.s(r2)
            if (r12 == 0) goto L_0x0254
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q
            if (r12 == 0) goto L_0x0254
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q
            int r12 = r12.f11398c.get()
            if (r12 == r3) goto L_0x0254
            com.mbridge.msdk.reward.b.a$c r12 = r11.f11335q
            int r12 = r12.f11398c.get()
            if (r12 == r1) goto L_0x0254
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()
            java.lang.String r8 = r11.f11337s
            r9 = 1
            r10 = 1
            r6 = 0
            r7 = 94
            com.mbridge.msdk.foundation.same.report.d.e r12 = r5.a((int) r6, (int) r7, (java.lang.String) r8, (boolean) r9, (int) r10)
            r11.a((boolean) r4, (com.mbridge.msdk.foundation.same.report.d.e) r12)
        L_0x0254:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.foundation.same.report.d.e):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.foundation.same.report.d.c a(com.mbridge.msdk.foundation.same.report.d.e r7) {
        /*
            r6 = this;
            r0 = 0
            com.mbridge.msdk.videocommon.download.b r1 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r2 = r6.f11337s     // Catch:{ Exception -> 0x0023 }
            java.util.concurrent.CopyOnWriteArrayList r1 = r1.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0025
            int r3 = r1.size()     // Catch:{ Exception -> 0x0023 }
            if (r3 <= 0) goto L_0x0025
            r3 = 0
            java.lang.Object r3 = r1.get(r3)     // Catch:{ Exception -> 0x0023 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x0023 }
            if (r3 == 0) goto L_0x0025
            java.lang.String r2 = r3.getCurrentLocalRid()     // Catch:{ Exception -> 0x0023 }
            goto L_0x0025
        L_0x0023:
            r7 = move-exception
            goto L_0x0096
        L_0x0025:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0023 }
            if (r3 != 0) goto L_0x003a
            com.mbridge.msdk.foundation.same.report.d.d r3 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0023 }
            java.util.LinkedHashMap r3 = r3.b()     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ Exception -> 0x0023 }
            com.mbridge.msdk.foundation.same.report.d.c r3 = (com.mbridge.msdk.foundation.same.report.d.c) r3     // Catch:{ Exception -> 0x0023 }
            r0 = r3
        L_0x003a:
            java.lang.String r3 = "2000128"
            if (r0 == 0) goto L_0x0054
            r0.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r1)     // Catch:{ Exception -> 0x0023 }
            r0.a(r3, r7)     // Catch:{ Exception -> 0x0023 }
            r0.c((java.lang.String) r2)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r7 = r6.f11337s     // Catch:{ Exception -> 0x0023 }
            r0.d((java.lang.String) r7)     // Catch:{ Exception -> 0x0023 }
            com.mbridge.msdk.reward.c.a.a r7 = com.mbridge.msdk.reward.c.a.a.a()     // Catch:{ Exception -> 0x0023 }
            r7.a(r3, r0)     // Catch:{ Exception -> 0x0023 }
            return r0
        L_0x0054:
            com.mbridge.msdk.foundation.same.report.d.c r4 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x0023 }
            r4.<init>()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = r6.f11337s     // Catch:{ Exception -> 0x007a }
            r4.d((java.lang.String) r0)     // Catch:{ Exception -> 0x007a }
            java.lang.String r0 = "metrics_data_reason"
            java.lang.String r5 = "未获取到待展示的campaign信息 本地new metricsData"
            r7.a(r0, r5)     // Catch:{ Exception -> 0x007a }
            r4.a(r3, r7)     // Catch:{ Exception -> 0x007a }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x007a }
            if (r7 == 0) goto L_0x007d
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.ak.d()     // Catch:{ Exception -> 0x007a }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r7)     // Catch:{ Exception -> 0x007a }
            r4.c((java.lang.String) r7)     // Catch:{ Exception -> 0x007a }
            goto L_0x008e
        L_0x007a:
            r7 = move-exception
            r0 = r4
            goto L_0x0096
        L_0x007d:
            r4.c((java.lang.String) r2)     // Catch:{ Exception -> 0x007a }
            r4.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r1)     // Catch:{ Exception -> 0x007a }
            com.mbridge.msdk.foundation.same.report.d.d r7 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x007a }
            java.util.LinkedHashMap r7 = r7.b()     // Catch:{ Exception -> 0x007a }
            r7.put(r2, r4)     // Catch:{ Exception -> 0x007a }
        L_0x008e:
            com.mbridge.msdk.reward.c.a.a r7 = com.mbridge.msdk.reward.c.a.a.a()     // Catch:{ Exception -> 0x007a }
            r7.a(r3, r4)     // Catch:{ Exception -> 0x007a }
            return r4
        L_0x0096:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x00a3
            java.lang.String r1 = "RewardVideoController"
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r7)
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(com.mbridge.msdk.foundation.same.report.d.e):com.mbridge.msdk.foundation.same.report.d.c");
    }

    public final void a(List<CampaignEx> list) {
        if (list != null && list.size() > 0) {
            this.f11311M = list;
        }
    }

    private String a(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = SameMD5.getMD5(ak.d());
            }
            String[] split = str.split("_");
            if (split != null && split.length >= 3) {
                str2 = split[2];
            }
            return TextUtils.isEmpty(str2) ? SameMD5.getMD5(ak.d()) : str2;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return str2;
        }
    }

    public final com.mbridge.msdk.foundation.same.report.d.c a(Message message) {
        com.mbridge.msdk.foundation.same.report.d.c cVar = null;
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    cVar = com.mbridge.msdk.foundation.same.report.d.d.a().a(data.getString("metrics_data_lrid"), "");
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
        return cVar == null ? new com.mbridge.msdk.foundation.same.report.d.c() : cVar;
    }

    /* access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar, InterVideoOutListener interVideoOutListener, String str2) {
        if (cVar == null) {
            try {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                cVar.b(this.f11311M);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                    return;
                }
                return;
            }
        }
        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
        if (!TextUtils.isEmpty(str2)) {
            eVar.a("reason", str2);
        }
        if (interVideoOutListener != null) {
            eVar.a("listener_state", 1);
        } else {
            eVar.a("listener_state", 2);
        }
        cVar.a(str, eVar);
        com.mbridge.msdk.reward.c.a.a.a().a(str, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043 A[Catch:{ Exception -> 0x0030 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044 A[Catch:{ Exception -> 0x0030 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.foundation.same.report.d.c a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r6, com.mbridge.msdk.foundation.same.report.d.c r7) {
        /*
            r5 = this;
            r0 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.mbridge.msdk.foundation.same.report.d.c r1 = new com.mbridge.msdk.foundation.same.report.d.c
            r1.<init>()
            java.lang.String r2 = ""
            if (r6 == 0) goto L_0x003c
            int r3 = r6.size()     // Catch:{ Exception -> 0x0030 }
            if (r3 <= 0) goto L_0x003c
            r3 = 0
            java.lang.Object r4 = r6.get(r3)     // Catch:{ Exception -> 0x0030 }
            if (r4 == 0) goto L_0x0032
            java.lang.Object r2 = r6.get(r3)     // Catch:{ Exception -> 0x0030 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x0030 }
            java.lang.String r2 = r2.getLocalRequestId()     // Catch:{ Exception -> 0x0030 }
            java.lang.Object r3 = r6.get(r3)     // Catch:{ Exception -> 0x0030 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x0030 }
            java.lang.String r3 = r3.getNLRid()     // Catch:{ Exception -> 0x0030 }
            goto L_0x0033
        L_0x0030:
            r6 = move-exception
            goto L_0x009d
        L_0x0032:
            r3 = r2
        L_0x0033:
            r1.c((java.lang.String) r2)     // Catch:{ Exception -> 0x0030 }
            r1.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r6)     // Catch:{ Exception -> 0x0030 }
            r6 = r2
            r2 = r3
            goto L_0x003d
        L_0x003c:
            r6 = r2
        L_0x003d:
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0030 }
            if (r2 == 0) goto L_0x0044
            return r7
        L_0x0044:
            com.mbridge.msdk.foundation.same.report.d.e r7 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0030 }
            r7.<init>()     // Catch:{ Exception -> 0x0030 }
            java.lang.String r2 = "cache"
            r7.a(r2, r0)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r2 = "hb"
            r7.a(r2, r0)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = "auto_load"
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0030 }
            r7.a(r0, r2)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = "2000127"
            r1.a(r0, r7)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = "2000048"
            r1.a(r0, r7)     // Catch:{ Exception -> 0x0030 }
            boolean r7 = r5.f11302D     // Catch:{ Exception -> 0x0030 }
            if (r7 == 0) goto L_0x006e
            r7 = 287(0x11f, float:4.02E-43)
            goto L_0x0070
        L_0x006e:
            r7 = 94
        L_0x0070:
            r1.b((int) r7)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r7 = "1"
            r1.i(r7)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r7 = "2"
            r1.b((java.lang.String) r7)     // Catch:{ Exception -> 0x0030 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0030 }
            if (r7 != 0) goto L_0x00a4
            com.mbridge.msdk.foundation.same.report.d.d r7 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0030 }
            java.util.LinkedHashMap r7 = r7.b()     // Catch:{ Exception -> 0x0030 }
            boolean r7 = r7.containsKey(r6)     // Catch:{ Exception -> 0x0030 }
            if (r7 != 0) goto L_0x00a4
            com.mbridge.msdk.foundation.same.report.d.d r7 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0030 }
            java.util.LinkedHashMap r7 = r7.b()     // Catch:{ Exception -> 0x0030 }
            r7.put(r6, r1)     // Catch:{ Exception -> 0x0030 }
            return r1
        L_0x009d:
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r7 == 0) goto L_0x00a4
            r6.printStackTrace()
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(java.util.List, com.mbridge.msdk.foundation.same.report.d.c):com.mbridge.msdk.foundation.same.report.d.c");
    }

    static /* synthetic */ void a(a aVar, String str, List list) {
        if (list != null) {
            try {
                if (list.size() > 0 && !aVar.f11318V) {
                    e.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a((List<CampaignEx>) list, str);
                }
            } catch (Throwable th) {
                af.b("RewardVideoController", th.getMessage());
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str, com.mbridge.msdk.foundation.same.report.d.c cVar, InterVideoOutListener interVideoOutListener) {
        if (aVar.f11306H) {
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                cVar.b(aVar.f11311M);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                if (interVideoOutListener != null) {
                    eVar.a("listener_state", 1);
                } else {
                    eVar.a("listener_state", 2);
                }
                cVar.a(str, eVar);
                com.mbridge.msdk.reward.c.a.a.a().a(str, cVar);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
