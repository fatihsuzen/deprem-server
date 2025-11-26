package com.mbridge.msdk.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public final class b {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f11021b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final h f11022a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f11023c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11024d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11025e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11026f;

    /* renamed from: g  reason: collision with root package name */
    private volatile List<WindVaneWebView> f11027g;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f11062a;

        /* renamed from: b  reason: collision with root package name */
        boolean f11063b;

        /* renamed from: c  reason: collision with root package name */
        int f11064c;

        /* renamed from: d  reason: collision with root package name */
        int f11065d;

        /* renamed from: e  reason: collision with root package name */
        String f11066e;

        /* renamed from: f  reason: collision with root package name */
        String f11067f;

        /* renamed from: g  reason: collision with root package name */
        int f11068g;

        /* renamed from: h  reason: collision with root package name */
        CopyOnWriteArrayList<CampaignEx> f11069h;

        /* renamed from: i  reason: collision with root package name */
        CopyOnWriteArrayList<CampaignEx> f11070i;

        public a(boolean z4, boolean z5, int i5, int i6, String str, String str2, int i7, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f11062a = z4;
            this.f11063b = z5;
            this.f11064c = i5;
            this.f11065d = i6;
            this.f11066e = str;
            this.f11067f = str2;
            this.f11068g = i7;
            this.f11069h = copyOnWriteArrayList;
            this.f11070i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    public interface c {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList);

        void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.c.b bVar);
    }

    private static final class d implements H5DownLoadManager.IH5SourceDownloadListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11091a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f11092b;

        /* renamed from: c  reason: collision with root package name */
        private final String f11093c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final String f11094d;

        /* renamed from: e  reason: collision with root package name */
        private final String f11095e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CampaignEx f11096f;

        /* renamed from: g  reason: collision with root package name */
        private i f11097g;

        /* renamed from: h  reason: collision with root package name */
        private Handler f11098h;

        /* renamed from: i  reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f11099i;

        /* renamed from: j  reason: collision with root package name */
        private final long f11100j;

        public d(int i5, String str, String str2, String str3, CampaignEx campaignEx, i iVar, Handler handler, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f11092b = i5;
            this.f11093c = str;
            this.f11094d = str2;
            this.f11095e = str3;
            this.f11096f = campaignEx;
            this.f11097g = iVar;
            this.f11098h = handler;
            this.f11099i = copyOnWriteArrayList;
            this.f11100j = System.currentTimeMillis();
        }

        public final void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, false);
            int i5 = this.f11092b;
            if (i5 != 313) {
                if (i5 == 497) {
                    Message obtain = Message.obtain();
                    obtain.what = 201;
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11094d);
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f11093c);
                    bundle.putString("request_id", this.f11095e);
                    bundle.putString("url", str);
                    bundle.putString("message", str2);
                    obtain.setData(bundle);
                    this.f11098h.sendMessage(obtain);
                    if (this.f11091a) {
                        a(3, System.currentTimeMillis() - this.f11100j, str, "url download failed", "");
                        return;
                    }
                } else if (i5 == 859) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 205;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11094d);
                    bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f11093c);
                    bundle2.putString("request_id", this.f11095e);
                    bundle2.putString("message", str2);
                    obtain2.setData(bundle2);
                    this.f11098h.sendMessage(obtain2);
                    if (this.f11097g != null) {
                        try {
                            this.f11097g.a(str, this.f11095e, b.b(880006, new MBridgeIds(this.f11093c, this.f11094d, this.f11095e), str2, (Throwable) null, (CampaignEx) null));
                            return;
                        } catch (Exception e5) {
                            af.b("RewardCampaignsResourceManager", e5.getMessage());
                            return;
                        }
                    }
                }
                return;
            }
            String str3 = str;
            Message obtain3 = Message.obtain();
            obtain3.what = 201;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11094d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f11093c);
            bundle3.putString("request_id", this.f11095e);
            bundle3.putString("url", str3);
            bundle3.putString("message", str2);
            obtain3.setData(bundle3);
            this.f11098h.sendMessage(obtain3);
        }

        public final void onSuccess(String str, String str2, boolean z4) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            int i5 = this.f11092b;
            if (i5 != 313) {
                if (i5 == 497) {
                    Message obtain = Message.obtain();
                    obtain.what = 101;
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11094d);
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f11093c);
                    bundle.putString("request_id", this.f11095e);
                    bundle.putString("url", str);
                    obtain.setData(bundle);
                    this.f11098h.sendMessage(obtain);
                    if (this.f11091a) {
                        a(1, System.currentTimeMillis() - this.f11100j, str, "", str2);
                        return;
                    }
                } else if (i5 == 859) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 105;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11094d);
                    bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f11093c);
                    bundle2.putString("request_id", this.f11095e);
                    obtain2.setData(bundle2);
                    this.f11098h.sendMessage(obtain2);
                    i iVar = this.f11097g;
                    if (iVar != null) {
                        iVar.a(this.f11093c, this.f11094d, this.f11095e, str);
                        return;
                    }
                }
                return;
            }
            String str3 = str;
            Message obtain3 = Message.obtain();
            obtain3.what = 101;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11094d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f11093c);
            bundle3.putString("request_id", this.f11095e);
            bundle3.putString("url", str3);
            obtain3.setData(bundle3);
            this.f11098h.sendMessage(obtain3);
        }

        public final void a(boolean z4) {
            this.f11091a = z4;
        }

        private void a(int i5, long j5, String str, String str2, String str3) {
            final int i6 = i5;
            final long j6 = j5;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    if (d.this.f11096f != null) {
                        try {
                            int i5 = i6;
                            n nVar = new n("m_download_end", i5, j6 + "", str4, d.this.f11096f.getId(), d.this.f11094d, str5, "2");
                            nVar.f(d.this.f11096f.getRequestId());
                            nVar.s(d.this.f11096f.getCurrentLocalRid());
                            nVar.g(d.this.f11096f.getRequestIdNotice());
                            nVar.e(d.this.f11096f.getId());
                            nVar.c(d.this.f11096f.getAdSpaceT());
                            nVar.a("scenes", "1");
                            nVar.a("url", str4);
                            if (d.this.f11096f.getAdType() == 287) {
                                nVar.d(ExifInterface.GPS_MEASUREMENT_3D);
                            } else if (d.this.f11096f.getAdType() == 94) {
                                nVar.d("1");
                            }
                            if (!TextUtils.isEmpty(str6)) {
                                nVar.t(str6);
                            }
                            b.a(nVar, d.this.f11096f);
                            com.mbridge.msdk.foundation.same.report.g.a(nVar, d.this.f11094d, d.this.f11096f);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                            }
                        }
                    }
                }
            });
        }
    }

    private static final class e implements com.mbridge.msdk.foundation.same.c.c {

        /* renamed from: a  reason: collision with root package name */
        private Handler f11107a;

        /* renamed from: b  reason: collision with root package name */
        private int f11108b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f11109c;

        /* renamed from: d  reason: collision with root package name */
        private String f11110d;

        /* renamed from: e  reason: collision with root package name */
        private String f11111e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CampaignEx f11112f;

        public e(Handler handler, int i5, String str, String str2, String str3, CampaignEx campaignEx) {
            this.f11107a = handler;
            this.f11108b = i5;
            this.f11110d = str;
            this.f11109c = str2;
            this.f11111e = str3;
            this.f11112f = campaignEx;
        }

        public final void onFailedLoad(final String str, String str2) {
            int i5;
            Message obtain = Message.obtain();
            if (this.f11108b == 0) {
                i5 = 202;
            } else {
                i5 = 204;
            }
            obtain.what = i5;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11109c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f11110d);
            bundle.putString("request_id", this.f11111e);
            obtain.setData(bundle);
            this.f11107a.sendMessage(obtain);
            AnonymousClass1 r5 = new Runnable() {
                public final void run() {
                    if (e.this.f11112f != null) {
                        try {
                            o a5 = o.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                            af.a("RewardCampaignsResourceManager", "campaign is null");
                            n nVar = new n();
                            nVar.a("2000044");
                            nVar.a(ab.m(com.mbridge.msdk.foundation.controller.c.m().c()));
                            nVar.e(e.this.f11112f.getId());
                            nVar.p(e.this.f11112f.getImageUrl());
                            nVar.f(e.this.f11112f.getRequestId());
                            nVar.s(e.this.f11112f.getCurrentLocalRid());
                            nVar.g(e.this.f11112f.getRequestIdNotice());
                            nVar.c(e.this.f11109c);
                            nVar.h(str);
                            nVar.a("scenes", "1");
                            a5.a(nVar);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                            }
                        }
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            com.mbridge.msdk.foundation.same.f.a.b().execute(r5);
        }

        public final void onSuccessLoad(Bitmap bitmap, String str) {
            int i5;
            ResDownloadCheckManager.getInstance().setImageDownloadDone(str, true);
            Message obtain = Message.obtain();
            if (this.f11108b == 0) {
                i5 = 102;
            } else {
                i5 = 104;
            }
            obtain.what = i5;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11109c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f11110d);
            bundle.putString("request_id", this.f11111e);
            obtain.setData(bundle);
            this.f11107a.sendMessage(obtain);
        }
    }

    private static final class g implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11119a = false;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Context f11120b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f11121c;

        /* renamed from: d  reason: collision with root package name */
        private String f11122d;

        /* renamed from: e  reason: collision with root package name */
        private String f11123e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CampaignEx f11124f;

        /* renamed from: g  reason: collision with root package name */
        private int f11125g;

        /* renamed from: h  reason: collision with root package name */
        private Handler f11126h;

        /* renamed from: i  reason: collision with root package name */
        private i f11127i;

        /* renamed from: j  reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f11128j;

        /* renamed from: k  reason: collision with root package name */
        private long f11129k;

        public g(Context context, String str, String str2, String str3, CampaignEx campaignEx, int i5, Handler handler, i iVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f11120b = context;
            this.f11122d = str;
            this.f11121c = str2;
            this.f11123e = str3;
            this.f11124f = campaignEx;
            this.f11125g = i5;
            this.f11126h = handler;
            this.f11127i = iVar;
            this.f11128j = copyOnWriteArrayList;
            this.f11129k = System.currentTimeMillis();
        }

        public final void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
            long currentTimeMillis = System.currentTimeMillis() - this.f11129k;
            int i5 = this.f11125g;
            if (i5 != 313) {
                if (i5 == 497) {
                    Message obtain = Message.obtain();
                    obtain.what = 201;
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11121c);
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f11122d);
                    bundle.putString("request_id", this.f11123e);
                    bundle.putString("url", str2);
                    bundle.putString("message", str);
                    obtain.setData(bundle);
                    this.f11126h.sendMessage(obtain);
                    if (this.f11119a) {
                        a(3, currentTimeMillis, str2, "zip download failed", "");
                        return;
                    }
                } else if (i5 == 859) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 203;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11121c);
                    bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f11122d);
                    bundle2.putString("request_id", this.f11123e);
                    bundle2.putString("url", str2);
                    bundle2.putString("message", str);
                    obtain2.setData(bundle2);
                    this.f11126h.sendMessage(obtain2);
                    if (this.f11127i != null) {
                        try {
                            this.f11127i.a(str2, this.f11123e, b.b(880006, new MBridgeIds(this.f11122d, this.f11121c, this.f11123e), "", (Throwable) null, (CampaignEx) null));
                        } catch (Exception e5) {
                            af.b("RewardCampaignsResourceManager", e5.getMessage());
                        }
                    }
                    a(3, str2, str, "");
                    return;
                }
                return;
            }
            String str3 = str2;
            Message obtain3 = Message.obtain();
            obtain3.what = 101;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11121c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f11122d);
            bundle3.putString("request_id", this.f11123e);
            bundle3.putString("url", str3);
            bundle3.putString("message", str);
            obtain3.setData(bundle3);
            this.f11126h.sendMessage(obtain3);
        }

        public final void onSuccess(String str, String str2, boolean z4) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            long currentTimeMillis = System.currentTimeMillis() - this.f11129k;
            int i5 = this.f11125g;
            if (i5 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11121c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f11122d);
                bundle.putString("request_id", this.f11123e);
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.f11126h.sendMessage(obtain);
            } else if (i5 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11121c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f11122d);
                bundle2.putString("request_id", this.f11123e);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.f11126h.sendMessage(obtain2);
                if (this.f11119a) {
                    a(1, currentTimeMillis, str, "", str2);
                }
            } else if (i5 == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 103;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11121c);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f11122d);
                bundle3.putString("request_id", this.f11123e);
                obtain3.setData(bundle3);
                this.f11126h.sendMessage(obtain3);
                i iVar = this.f11127i;
                if (iVar != null) {
                    iVar.a(this.f11122d, this.f11121c, this.f11123e, str);
                }
                if (!z4) {
                    a(1, str, "", str2);
                }
            }
        }

        public final void a(boolean z4) {
            this.f11119a = z4;
        }

        private void a(int i5, String str, String str2, String str3) {
            final int i6 = i5;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    if (g.this.f11124f != null && g.this.f11120b != null) {
                        try {
                            n nVar = new n();
                            nVar.a("m_download_end");
                            if (g.this.f11120b != null) {
                                nVar.a(ab.m(g.this.f11120b.getApplicationContext()));
                            }
                            nVar.b(i6);
                            if (g.this.f11124f != null) {
                                nVar.e(g.this.f11124f.getId());
                                nVar.f(g.this.f11124f.getRequestId());
                                nVar.s(g.this.f11124f.getCurrentLocalRid());
                                nVar.g(g.this.f11124f.getRequestIdNotice());
                            }
                            nVar.q(str4);
                            nVar.h(str5);
                            nVar.c(g.this.f11121c);
                            if (!TextUtils.isEmpty(str6)) {
                                nVar.t(str6);
                            }
                            nVar.e(2);
                            nVar.a("scenes", "1");
                            nVar.a("url", str4);
                            b.a(nVar, g.this.f11124f);
                            com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, g.this.f11124f);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                            }
                        }
                    }
                }
            });
        }

        private void a(int i5, long j5, String str, String str2, String str3) {
            final int i6 = i5;
            final long j6 = j5;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    if (g.this.f11124f != null) {
                        try {
                            int i5 = i6;
                            n nVar = new n("m_download_end", i5, j6 + "", str4, g.this.f11124f.getId(), g.this.f11121c, str5, "1");
                            nVar.f(g.this.f11124f.getRequestId());
                            nVar.s(g.this.f11124f.getCurrentLocalRid());
                            nVar.g(g.this.f11124f.getRequestIdNotice());
                            nVar.e(g.this.f11124f.getId());
                            nVar.c(g.this.f11124f.getAdSpaceT());
                            nVar.t(str6);
                            nVar.a("scenes", "1");
                            if (g.this.f11124f.getAdType() == 287) {
                                nVar.d(ExifInterface.GPS_MEASUREMENT_3D);
                            } else if (g.this.f11124f.getAdType() == 94) {
                                nVar.d("1");
                            }
                            nVar.a("url", str4);
                            nVar.e(3);
                            b.a(nVar, g.this.f11124f);
                            com.mbridge.msdk.foundation.same.report.g.a(nVar, g.this.f11121c, g.this.f11124f);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                            }
                        }
                    }
                }
            });
        }
    }

    private static final class h extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private Context f11141a;

        /* renamed from: b  reason: collision with root package name */
        private ConcurrentHashMap<String, c> f11142b = new ConcurrentHashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> f11143c = new ConcurrentHashMap<>();

        public h(Looper looper) {
            super(looper);
        }

        public final void a(String str, String str2, String str3, c cVar) {
            ConcurrentHashMap<String, c> concurrentHashMap = this.f11142b;
            concurrentHashMap.put(str2 + "_" + str3, cVar);
        }

        public final void handleMessage(Message message) {
            boolean z4;
            Message message2 = message;
            Bundle data = message2.getData();
            String string = data.getString(MBridgeConstans.PLACEMENT_ID);
            String string2 = data.getString(MBridgeConstans.PROPERTIES_UNIT_ID);
            String string3 = data.getString("request_id");
            String str = string2 + "_" + string3;
            a aVar = (a) b.f11021b.get(str);
            c cVar = this.f11142b.get(str);
            CopyOnWriteArrayList copyOnWriteArrayList = this.f11143c.get(str);
            int i5 = message2.what;
            switch (i5) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                    break;
                default:
                    switch (i5) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            if (aVar != null && cVar != null) {
                                String string4 = data.getString("message");
                                if (string4 == null) {
                                    string4 = "";
                                }
                                int i6 = message2.what;
                                String str2 = "RewardCampaignsResourceManager";
                                Bundle bundle = data;
                                int i7 = i6 != 200 ? i6 != 201 ? i6 != 203 ? i6 != 205 ? 880024 : 880005 : 880006 : 880007 : 880004;
                                String str3 = "resource download failed " + b.b(message2.what) + " " + string4;
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = aVar.f11069h;
                                CampaignEx campaignEx = (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) ? null : aVar.f11069h.get(0);
                                try {
                                    if (!aVar.f11062a || aVar.f11070i == null) {
                                        CampaignEx campaignEx2 = campaignEx;
                                        if (com.mbridge.msdk.videocommon.download.b.getInstance().a(94, aVar.f11066e, aVar.f11063b, aVar.f11065d, aVar.f11062a, aVar.f11064c, copyOnWriteArrayList)) {
                                            cVar.a(string, string2, string3, aVar.f11069h);
                                        } else {
                                            if (!(campaignEx2 == null || campaignEx2.getRsIgnoreCheckRule() == null || campaignEx2.getRsIgnoreCheckRule().size() <= 0)) {
                                                int i8 = message2.what;
                                                if (i8 != 200) {
                                                    if (i8 != 201) {
                                                        if (i8 != 203) {
                                                            if (i8 == 205) {
                                                                if (campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                                                                    return;
                                                                }
                                                            }
                                                        } else if (campaignEx2.getRsIgnoreCheckRule().contains(1)) {
                                                            return;
                                                        }
                                                    } else if (campaignEx2.getRsIgnoreCheckRule().contains(2)) {
                                                        return;
                                                    }
                                                } else if (campaignEx2.getRsIgnoreCheckRule().contains(0)) {
                                                    return;
                                                }
                                            }
                                            cVar.a(aVar.f11069h, b.b(i7, new MBridgeIds(string, string2, string3), str3, (Throwable) null, (CampaignEx) null));
                                        }
                                        this.f11142b.remove(str);
                                        b.f11021b.remove(str);
                                        this.f11143c.remove(str);
                                        return;
                                    }
                                    CampaignEx campaignEx3 = campaignEx;
                                    if (aVar.f11064c == 1) {
                                        if (!(campaignEx3 == null || campaignEx3.getRsIgnoreCheckRule() == null || campaignEx3.getRsIgnoreCheckRule().size() <= 0)) {
                                            int i9 = message2.what;
                                            if (i9 != 200) {
                                                if (i9 != 201) {
                                                    if (i9 != 203) {
                                                        if (i9 == 205) {
                                                            if (!campaignEx3.getRsIgnoreCheckRule().contains(3)) {
                                                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = aVar.f11069h;
                                                                if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                                                                    CampaignEx campaignEx4 = aVar.f11069h.get(0);
                                                                    if (campaignEx4.getCMPTEntryUrl().equals(campaignEx4.getendcard_url()) && campaignEx3.getRsIgnoreCheckRule().contains(2)) {
                                                                        return;
                                                                    }
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (campaignEx3.getRsIgnoreCheckRule().contains(1)) {
                                                        return;
                                                    }
                                                } else if (campaignEx3.getRsIgnoreCheckRule().contains(2)) {
                                                    return;
                                                }
                                            } else if (campaignEx3.getRsIgnoreCheckRule().contains(0)) {
                                                return;
                                            }
                                        }
                                        cVar.a(aVar.f11069h, b.b(i7, new MBridgeIds(string, string2, string3), str3, (Throwable) null, (CampaignEx) null));
                                        this.f11142b.remove(str);
                                        b.f11021b.remove(str);
                                        this.f11143c.remove(str);
                                        return;
                                    }
                                    String string5 = bundle.getString("url");
                                    int i10 = message2.what;
                                    if (i10 == 200) {
                                        String str4 = str2;
                                        if (campaignEx3 == null || campaignEx3.getRsIgnoreCheckRule() == null || campaignEx3.getRsIgnoreCheckRule().size() <= 0 || !campaignEx3.getRsIgnoreCheckRule().contains(0)) {
                                            for (int i11 = 0; i11 < aVar.f11070i.size(); i11++) {
                                                if (aVar.f11070i.get(i11).getVideoUrlEncode().equals(string5)) {
                                                    aVar.f11070i.remove(i11);
                                                }
                                            }
                                            b.f11021b.remove(str);
                                            b.f11021b.put(str, aVar);
                                        } else {
                                            af.c(str4, "Is TPL but  video download fail but hit ignoreCheckRule");
                                            return;
                                        }
                                    } else if (i10 == 201) {
                                        String str5 = str2;
                                        if (campaignEx3 == null || campaignEx3.getRsIgnoreCheckRule() == null || campaignEx3.getRsIgnoreCheckRule().size() <= 0 || !campaignEx3.getRsIgnoreCheckRule().contains(2)) {
                                            for (int i12 = 0; i12 < aVar.f11070i.size(); i12++) {
                                                CampaignEx campaignEx5 = aVar.f11070i.get(i12);
                                                if (campaignEx5.getRewardTemplateMode() != null && campaignEx5.getRewardTemplateMode().c().equals(string5)) {
                                                    aVar.f11070i.remove(i12);
                                                }
                                                if (!TextUtils.isEmpty(campaignEx5.getendcard_url()) && campaignEx5.getendcard_url().equals(string5)) {
                                                    aVar.f11070i.remove(i12);
                                                }
                                            }
                                            b.f11021b.remove(str);
                                            b.f11021b.put(str, aVar);
                                        } else {
                                            af.c(str5, "Is TPL but download endcard fail but hit ignoreCheckRule");
                                            return;
                                        }
                                    } else if (i10 == 203) {
                                        String str6 = str2;
                                        if (campaignEx3 == null || campaignEx3.getRsIgnoreCheckRule() == null || campaignEx3.getRsIgnoreCheckRule().size() <= 0 || !campaignEx3.getRsIgnoreCheckRule().contains(1)) {
                                            for (int i13 = 0; i13 < aVar.f11070i.size(); i13++) {
                                                CampaignEx campaignEx6 = aVar.f11070i.get(i13);
                                                if (campaignEx6.getRewardTemplateMode() != null && campaignEx6.getRewardTemplateMode().e().equals(string5)) {
                                                    aVar.f11070i.remove(i13);
                                                }
                                            }
                                            b.f11021b.remove(str);
                                            b.f11021b.put(str, aVar);
                                        } else {
                                            af.c(str6, "Is TPL but download template fail but hit ignoreCheckRule");
                                            return;
                                        }
                                    } else if (i10 == 205) {
                                        if (campaignEx3 == null || campaignEx3.getRsIgnoreCheckRule() == null || campaignEx3.getRsIgnoreCheckRule().size() <= 0 || !campaignEx3.getRsIgnoreCheckRule().contains(3)) {
                                            aVar.f11070i.clear();
                                            b.f11021b.remove(str);
                                            b.f11021b.put(str, aVar);
                                        } else {
                                            af.c(str2, "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                            return;
                                        }
                                    }
                                    if (com.mbridge.msdk.videocommon.download.b.getInstance().a(94, aVar.f11066e, aVar.f11063b, aVar.f11065d, aVar.f11062a, aVar.f11064c, copyOnWriteArrayList)) {
                                        cVar.a(string, string2, string3, aVar.f11069h);
                                        this.f11142b.remove(str);
                                        b.f11021b.remove(str);
                                        this.f11143c.remove(str);
                                        return;
                                    } else if (aVar.f11070i.size() == 0) {
                                        cVar.a(aVar.f11069h, b.b(i7, new MBridgeIds(string, string2, string3), str3, (Throwable) null, (CampaignEx) null));
                                        this.f11142b.remove(str);
                                        b.f11021b.remove(str);
                                        this.f11143c.remove(str);
                                        return;
                                    } else {
                                        return;
                                    }
                                } catch (Exception e5) {
                                    cVar.a(aVar.f11069h, b.b(i7, new MBridgeIds(string, string2, string3), str3, e5, (CampaignEx) null));
                                    return;
                                }
                            } else {
                                return;
                            }
                        case 202:
                        case 204:
                            break;
                        default:
                            return;
                    }
            }
            String str7 = "RewardCampaignsResourceManager";
            if (aVar != null && cVar != null) {
                try {
                    z4 = com.mbridge.msdk.videocommon.download.b.getInstance().a(94, aVar.f11066e, aVar.f11063b, aVar.f11065d, aVar.f11062a, aVar.f11064c, copyOnWriteArrayList);
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        af.b(str7, e6.getLocalizedMessage());
                    }
                    z4 = false;
                }
                if (z4) {
                    cVar.a(string, string2, string3, aVar.f11069h);
                    this.f11142b.remove(str);
                    b.f11021b.remove(str);
                    this.f11143c.remove(str);
                }
            }
        }

        public final void a(Context context) {
            this.f11141a = context;
        }

        public final void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f11143c.put(str, copyOnWriteArrayList);
        }
    }

    public interface i {
        void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar);

        void a(String str, String str2, String str3, String str4);
    }

    public interface j {
        void a(String str, String str2, String str3, a.C0114a aVar, com.mbridge.msdk.foundation.c.b bVar);

        void a(String str, String str2, String str3, String str4, String str5, a.C0114a aVar);
    }

    private static final class m {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f11187a = new b();
    }

    private b() {
        this.f11024d = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
        this.f11025e = "down_type";
        this.f11026f = "h3c";
        this.f11027g = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        f11021b = new ConcurrentHashMap<>();
        handlerThread.start();
        this.f11022a = new h(handlerThread.getLooper());
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:13:0x0017
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:75)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:472)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        */
    public static synchronized java.lang.String b(int r2) {
        /*
            java.lang.Class<com.mbridge.msdk.reward.adapter.b> r0 = com.mbridge.msdk.reward.adapter.b.class
            monitor-enter(r0)
            r1 = 200(0xc8, float:2.8E-43)
            if (r2 == r1) goto L_0x0025
            r1 = 201(0xc9, float:2.82E-43)
            if (r2 == r1) goto L_0x0021
            r1 = 203(0xcb, float:2.84E-43)
            if (r2 == r1) goto L_0x001d
            r1 = 205(0xcd, float:2.87E-43)
            if (r2 == r1) goto L_0x0019
            java.lang.String r2 = "unknown"
            monitor-exit(r0)
            return r2
        L_0x0017:
            r2 = move-exception
            goto L_0x0029
        L_0x0019:
            java.lang.String r2 = "tpl"
            monitor-exit(r0)
            return r2
        L_0x001d:
            java.lang.String r2 = "temp"
            monitor-exit(r0)
            return r2
        L_0x0021:
            java.lang.String r2 = "zip/html"
            monitor-exit(r0)
            return r2
        L_0x0025:
            java.lang.String r2 = "video"
            monitor-exit(r0)
            return r2
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.b(int):java.lang.String");
    }

    public static b a() {
        return m.f11187a;
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void a(Context context, boolean z4, int i5, boolean z5, int i6, String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, c cVar, i iVar) {
        String str4 = str2;
        String str5 = str3;
        synchronized (this) {
            try {
                String str6 = str4 + "_" + str5;
                String str7 = str2;
                final String str8 = str7;
                f11021b.put(str6, new a(z4, z5, i5, copyOnWriteArrayList.size(), str7, str5, i6, copyOnWriteArrayList));
                String str9 = str;
                this.f11022a.a(str9, str8, str5, cVar);
                this.f11022a.a(context);
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
                this.f11022a.a(str6, copyOnWriteArrayList2);
                final Context context2 = context;
                final int i7 = i6;
                final String str10 = str5;
                final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = copyOnWriteArrayList2;
                final String str11 = str9;
                final i iVar2 = iVar;
                this.f11022a.post(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:104:0x025f A[SYNTHETIC, Splitter:B:104:0x025f] */
                    /* JADX WARNING: Removed duplicated region for block: B:119:0x028e  */
                    /* JADX WARNING: Removed duplicated region for block: B:59:0x014e  */
                    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a2  */
                    /* JADX WARNING: Removed duplicated region for block: B:88:0x0228 A[SYNTHETIC, Splitter:B:88:0x0228] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r22 = this;
                            r1 = r22
                            java.lang.String r2 = "RewardCampaignsResourceManager"
                            java.util.concurrent.CopyOnWriteArrayList r0 = r2
                            if (r0 == 0) goto L_0x038d
                            int r0 = r0.size()
                            if (r0 <= 0) goto L_0x038d
                            com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r0 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ Exception -> 0x0041 }
                            java.util.concurrent.CopyOnWriteArrayList r3 = r2     // Catch:{ Exception -> 0x0041 }
                            r0.setCampaignList((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x0041 }
                            com.mbridge.msdk.videocommon.download.b r4 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x0041 }
                            android.content.Context r5 = r3     // Catch:{ Exception -> 0x0041 }
                            java.lang.String r6 = r4     // Catch:{ Exception -> 0x0041 }
                            java.util.concurrent.CopyOnWriteArrayList r7 = r2     // Catch:{ Exception -> 0x0041 }
                            int r8 = r5     // Catch:{ Exception -> 0x0041 }
                            com.mbridge.msdk.reward.adapter.b$f r9 = new com.mbridge.msdk.reward.adapter.b$f     // Catch:{ Exception -> 0x0041 }
                            com.mbridge.msdk.reward.adapter.b r0 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0041 }
                            com.mbridge.msdk.reward.adapter.b$h r0 = r0.f11022a     // Catch:{ Exception -> 0x0041 }
                            java.lang.String r3 = r6     // Catch:{ Exception -> 0x0041 }
                            java.lang.String r10 = r4     // Catch:{ Exception -> 0x0041 }
                            java.lang.String r11 = r7     // Catch:{ Exception -> 0x0041 }
                            r9.<init>(r0, r3, r10, r11)     // Catch:{ Exception -> 0x0041 }
                            r4.createUnitCache((android.content.Context) r5, (java.lang.String) r6, (java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r7, (int) r8, (com.mbridge.msdk.videocommon.listener.a) r9)     // Catch:{ Exception -> 0x0041 }
                            com.mbridge.msdk.videocommon.download.b r0 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x0041 }
                            java.lang.String r3 = r4     // Catch:{ Exception -> 0x0041 }
                            r0.load(r3)     // Catch:{ Exception -> 0x0041 }
                            goto L_0x004d
                        L_0x0041:
                            r0 = move-exception
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x004d
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                        L_0x004d:
                            java.util.concurrent.CopyOnWriteArrayList r0 = r2
                            java.util.Iterator r3 = r0.iterator()
                        L_0x0053:
                            boolean r0 = r3.hasNext()
                            if (r0 == 0) goto L_0x038d
                            java.lang.Object r0 = r3.next()
                            r9 = r0
                            com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9
                            if (r9 != 0) goto L_0x0063
                            goto L_0x0053
                        L_0x0063:
                            android.os.Message r0 = android.os.Message.obtain()     // Catch:{ Exception -> 0x0091 }
                            r4 = 106(0x6a, float:1.49E-43)
                            r0.what = r4     // Catch:{ Exception -> 0x0091 }
                            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ Exception -> 0x0091 }
                            r4.<init>()     // Catch:{ Exception -> 0x0091 }
                            java.lang.String r5 = "unit_id"
                            java.lang.String r6 = r4     // Catch:{ Exception -> 0x0091 }
                            r4.putString(r5, r6)     // Catch:{ Exception -> 0x0091 }
                            java.lang.String r5 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x0091 }
                            java.lang.String r6 = r6     // Catch:{ Exception -> 0x0091 }
                            r4.putString(r5, r6)     // Catch:{ Exception -> 0x0091 }
                            java.lang.String r5 = "request_id"
                            java.lang.String r6 = r7     // Catch:{ Exception -> 0x0091 }
                            r4.putString(r5, r6)     // Catch:{ Exception -> 0x0091 }
                            r0.setData(r4)     // Catch:{ Exception -> 0x0091 }
                            com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0091 }
                            com.mbridge.msdk.reward.adapter.b$h r4 = r4.f11022a     // Catch:{ Exception -> 0x0091 }
                            r4.sendMessage(r0)     // Catch:{ Exception -> 0x0091 }
                        L_0x0091:
                            com.mbridge.msdk.foundation.entity.CampaignEx$c r14 = r9.getRewardTemplateMode()
                            java.lang.String r15 = ".zip"
                            r4 = 2
                            java.lang.String r5 = ""
                            r6 = 1
                            java.lang.String r7 = "dyview"
                            if (r14 == 0) goto L_0x00c7
                            java.lang.String r0 = r14.e()
                            int r8 = r14.f()
                            boolean r10 = r9.isDynamicView()
                            if (r10 == 0) goto L_0x00d2
                            boolean r10 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.String) r7, (java.lang.String) r0)
                            if (r10 == 0) goto L_0x00d2
                            com.mbridge.msdk.reward.adapter.b r10 = com.mbridge.msdk.reward.adapter.b.this
                            java.lang.StringBuilder r11 = new java.lang.StringBuilder
                            r11.<init>()
                            r11.append(r8)
                            r11.append(r5)
                            java.lang.String r8 = r11.toString()
                            r10.a(r6, r9, r8, r0)
                        L_0x00c7:
                            r21 = r3
                            r18 = r5
                            r16 = r14
                            r17 = r15
                            r15 = r7
                            goto L_0x0190
                        L_0x00d2:
                            boolean r8 = android.text.TextUtils.isEmpty(r0)
                            if (r8 != 0) goto L_0x00c7
                            java.lang.String r8 = "cmpt=1"
                            boolean r8 = r0.contains(r8)
                            if (r8 != 0) goto L_0x00c7
                            com.mbridge.msdk.reward.adapter.b r8 = com.mbridge.msdk.reward.adapter.b.this
                            com.mbridge.msdk.foundation.same.report.d.c r8 = r8.a((com.mbridge.msdk.foundation.entity.CampaignEx) r9, (int) r4)
                            boolean r10 = r0.contains(r15)
                            if (r10 == 0) goto L_0x0156
                            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r10 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch:{ Exception -> 0x0144 }
                            r11 = r4
                            com.mbridge.msdk.reward.adapter.b$g r4 = new com.mbridge.msdk.reward.adapter.b$g     // Catch:{ Exception -> 0x0144 }
                            r12 = r5
                            android.content.Context r5 = r3     // Catch:{ Exception -> 0x0139 }
                            r13 = r6
                            java.lang.String r6 = r6     // Catch:{ Exception -> 0x0139 }
                            r16 = r7
                            java.lang.String r7 = r4     // Catch:{ Exception -> 0x0133 }
                            r17 = r8
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x0133 }
                            com.mbridge.msdk.reward.adapter.b r11 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0133 }
                            com.mbridge.msdk.reward.adapter.b$h r11 = r11.f11022a     // Catch:{ Exception -> 0x0133 }
                            r18 = r12
                            com.mbridge.msdk.reward.adapter.b$i r12 = r8     // Catch:{ Exception -> 0x0129 }
                            r19 = r13
                            java.util.concurrent.CopyOnWriteArrayList r13 = r2     // Catch:{ Exception -> 0x0129 }
                            r20 = r10
                            r10 = 859(0x35b, float:1.204E-42)
                            r21 = r3
                            r3 = r17
                            r17 = r15
                            r15 = r16
                            r16 = r14
                            r14 = r20
                            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0127 }
                            r14.downloadH5Res(r3, r0, r4)     // Catch:{ Exception -> 0x0127 }
                            goto L_0x0190
                        L_0x0127:
                            r0 = move-exception
                            goto L_0x014a
                        L_0x0129:
                            r0 = move-exception
                            r21 = r3
                        L_0x012c:
                            r17 = r15
                            r15 = r16
                            r16 = r14
                            goto L_0x014a
                        L_0x0133:
                            r0 = move-exception
                            r21 = r3
                            r18 = r12
                            goto L_0x012c
                        L_0x0139:
                            r0 = move-exception
                            r21 = r3
                            r18 = r12
                        L_0x013e:
                            r16 = r14
                            r17 = r15
                            r15 = r7
                            goto L_0x014a
                        L_0x0144:
                            r0 = move-exception
                            r21 = r3
                            r18 = r5
                            goto L_0x013e
                        L_0x014a:
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x0190
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                            goto L_0x0190
                        L_0x0156:
                            r21 = r3
                            r18 = r5
                            r3 = r8
                            r16 = r14
                            r17 = r15
                            r15 = r7
                            java.lang.String r4 = "开始下载 html 类型的 template"
                            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r4)
                            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r13 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch:{ Exception -> 0x0184 }
                            com.mbridge.msdk.reward.adapter.b$d r4 = new com.mbridge.msdk.reward.adapter.b$d     // Catch:{ Exception -> 0x0184 }
                            java.lang.String r6 = r6     // Catch:{ Exception -> 0x0184 }
                            java.lang.String r7 = r4     // Catch:{ Exception -> 0x0184 }
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x0184 }
                            com.mbridge.msdk.reward.adapter.b$i r10 = r8     // Catch:{ Exception -> 0x0184 }
                            com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0184 }
                            com.mbridge.msdk.reward.adapter.b$h r11 = r5.f11022a     // Catch:{ Exception -> 0x0184 }
                            java.util.concurrent.CopyOnWriteArrayList r12 = r2     // Catch:{ Exception -> 0x0184 }
                            r5 = 859(0x35b, float:1.204E-42)
                            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0184 }
                            r13.downloadH5Res(r3, r0, r4)     // Catch:{ Exception -> 0x0184 }
                            goto L_0x0190
                        L_0x0184:
                            r0 = move-exception
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x0190
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                        L_0x0190:
                            java.lang.String r10 = r9.getendcard_url()
                            boolean r0 = r9.isDynamicView()
                            boolean r3 = com.mbridge.msdk.foundation.tools.ak.l((java.lang.String) r10)
                            boolean r4 = android.text.TextUtils.isEmpty(r10)
                            if (r4 != 0) goto L_0x01fc
                            if (r0 != 0) goto L_0x01b6
                            com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this
                            android.content.Context r5 = r3
                            java.lang.String r6 = r6
                            java.lang.String r7 = r4
                            java.lang.String r8 = r7
                            com.mbridge.msdk.reward.adapter.b$i r11 = r8
                            java.util.concurrent.CopyOnWriteArrayList r12 = r2
                            com.mbridge.msdk.reward.adapter.b.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                            goto L_0x01fc
                        L_0x01b6:
                            if (r3 == 0) goto L_0x01ca
                            com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this
                            android.content.Context r5 = r3
                            java.lang.String r6 = r6
                            java.lang.String r7 = r4
                            java.lang.String r8 = r7
                            com.mbridge.msdk.reward.adapter.b$i r11 = r8
                            java.util.concurrent.CopyOnWriteArrayList r12 = r2
                            com.mbridge.msdk.reward.adapter.b.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                            goto L_0x01fc
                        L_0x01ca:
                            boolean r0 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.String) r15, (java.lang.String) r10)
                            if (r0 == 0) goto L_0x01fc
                            java.lang.String r0 = "ecid"
                            java.lang.String r0 = com.mbridge.msdk.foundation.tools.aq.a(r10, r0)     // Catch:{ all -> 0x01db }
                            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x01db }
                            goto L_0x01e5
                        L_0x01db:
                            r0 = move-exception
                            java.lang.String r0 = r0.getMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                            r0 = 404(0x194, float:5.66E-43)
                        L_0x01e5:
                            com.mbridge.msdk.reward.adapter.b r3 = com.mbridge.msdk.reward.adapter.b.this
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            r4.append(r0)
                            r12 = r18
                            r4.append(r12)
                            java.lang.String r0 = r4.toString()
                            r11 = 2
                            r3.a(r11, r9, r0, r10)
                        L_0x01fc:
                            java.lang.String r0 = r9.getEndScreenUrl()
                            boolean r0 = android.text.TextUtils.isEmpty(r0)
                            if (r0 != 0) goto L_0x021e
                            boolean r0 = r9.isDynamicView()
                            if (r0 != 0) goto L_0x021e
                            com.mbridge.msdk.reward.adapter.b r0 = com.mbridge.msdk.reward.adapter.b.this
                            r3 = 6
                            com.mbridge.msdk.foundation.same.report.d.c r0 = r0.a((com.mbridge.msdk.foundation.entity.CampaignEx) r9, (int) r3)
                            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r3 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()
                            java.lang.String r4 = r9.getEndScreenUrl()
                            r3.download(r0, r4)
                        L_0x021e:
                            java.lang.String r0 = r9.getIconUrl()
                            boolean r3 = android.text.TextUtils.isEmpty(r0)
                            if (r3 != 0) goto L_0x0255
                            android.content.Context r3 = r3     // Catch:{ Exception -> 0x0246 }
                            com.mbridge.msdk.foundation.same.c.b r3 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r3)     // Catch:{ Exception -> 0x0246 }
                            com.mbridge.msdk.reward.adapter.b$e r4 = new com.mbridge.msdk.reward.adapter.b$e     // Catch:{ Exception -> 0x0246 }
                            com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0246 }
                            com.mbridge.msdk.reward.adapter.b$h r5 = r5.f11022a     // Catch:{ Exception -> 0x0246 }
                            java.lang.String r7 = r6     // Catch:{ Exception -> 0x0246 }
                            java.lang.String r8 = r4     // Catch:{ Exception -> 0x0246 }
                            r10 = r9
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x0248 }
                            r6 = 0
                            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0248 }
                            r9 = r10
                            r3.a(r0, r4)     // Catch:{ Exception -> 0x0246 }
                            goto L_0x0255
                        L_0x0246:
                            r0 = move-exception
                            goto L_0x024a
                        L_0x0248:
                            r0 = move-exception
                            r9 = r10
                        L_0x024a:
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x0255
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                        L_0x0255:
                            java.lang.String r0 = r9.getImageUrl()
                            boolean r3 = android.text.TextUtils.isEmpty(r0)
                            if (r3 != 0) goto L_0x028c
                            android.content.Context r3 = r3     // Catch:{ Exception -> 0x027d }
                            com.mbridge.msdk.foundation.same.c.b r3 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r3)     // Catch:{ Exception -> 0x027d }
                            com.mbridge.msdk.reward.adapter.b$e r4 = new com.mbridge.msdk.reward.adapter.b$e     // Catch:{ Exception -> 0x027d }
                            com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x027d }
                            com.mbridge.msdk.reward.adapter.b$h r5 = r5.f11022a     // Catch:{ Exception -> 0x027d }
                            java.lang.String r7 = r6     // Catch:{ Exception -> 0x027d }
                            java.lang.String r8 = r4     // Catch:{ Exception -> 0x027d }
                            r10 = r9
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x027f }
                            r6 = 0
                            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x027f }
                            r9 = r10
                            r3.a(r0, r4)     // Catch:{ Exception -> 0x027d }
                            goto L_0x028c
                        L_0x027d:
                            r0 = move-exception
                            goto L_0x0281
                        L_0x027f:
                            r0 = move-exception
                            r9 = r10
                        L_0x0281:
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x028c
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                        L_0x028c:
                            if (r16 == 0) goto L_0x0389
                            java.lang.String r0 = r16.c()
                            boolean r3 = android.text.TextUtils.isEmpty(r0)
                            if (r3 != 0) goto L_0x031b
                            boolean r3 = r9.isDynamicView()
                            if (r3 != 0) goto L_0x031b
                            com.mbridge.msdk.foundation.entity.AabEntity r3 = r9.getAabEntity()
                            if (r3 == 0) goto L_0x02ab
                            com.mbridge.msdk.foundation.entity.AabEntity r3 = r9.getAabEntity()
                            int r3 = r3.h3c
                            goto L_0x02ac
                        L_0x02ab:
                            r3 = 0
                        L_0x02ac:
                            com.mbridge.msdk.foundation.same.report.d.c r14 = new com.mbridge.msdk.foundation.same.report.d.c
                            r13 = 1
                            r14.<init>(r13)
                            r14.c((int) r3)
                            r3 = r17
                            boolean r3 = r0.contains(r3)
                            if (r3 == 0) goto L_0x02f0
                            java.lang.String r3 = "开始下载 zip 类型的 pause"
                            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r3)
                            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r3 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch:{ Exception -> 0x02e3 }
                            com.mbridge.msdk.reward.adapter.b$g r4 = new com.mbridge.msdk.reward.adapter.b$g     // Catch:{ Exception -> 0x02e3 }
                            android.content.Context r5 = r3     // Catch:{ Exception -> 0x02e3 }
                            java.lang.String r6 = r6     // Catch:{ Exception -> 0x02e3 }
                            java.lang.String r7 = r4     // Catch:{ Exception -> 0x02e3 }
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x02e3 }
                            com.mbridge.msdk.reward.adapter.b r10 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x02e3 }
                            com.mbridge.msdk.reward.adapter.b$h r11 = r10.f11022a     // Catch:{ Exception -> 0x02e3 }
                            com.mbridge.msdk.reward.adapter.b$i r12 = r8     // Catch:{ Exception -> 0x02e3 }
                            java.util.concurrent.CopyOnWriteArrayList r13 = r2     // Catch:{ Exception -> 0x02e3 }
                            r10 = 313(0x139, float:4.39E-43)
                            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x02e3 }
                            r3.downloadH5Res(r14, r0, r4)     // Catch:{ Exception -> 0x02e3 }
                            goto L_0x031b
                        L_0x02e3:
                            r0 = move-exception
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x031b
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                            goto L_0x031b
                        L_0x02f0:
                            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r3 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch:{ Exception -> 0x030f }
                            com.mbridge.msdk.reward.adapter.b$d r4 = new com.mbridge.msdk.reward.adapter.b$d     // Catch:{ Exception -> 0x030f }
                            java.lang.String r6 = r6     // Catch:{ Exception -> 0x030f }
                            java.lang.String r7 = r4     // Catch:{ Exception -> 0x030f }
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x030f }
                            com.mbridge.msdk.reward.adapter.b$i r10 = r8     // Catch:{ Exception -> 0x030f }
                            com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x030f }
                            com.mbridge.msdk.reward.adapter.b$h r11 = r5.f11022a     // Catch:{ Exception -> 0x030f }
                            java.util.concurrent.CopyOnWriteArrayList r12 = r2     // Catch:{ Exception -> 0x030f }
                            r5 = 313(0x139, float:4.39E-43)
                            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x030f }
                            r3.downloadH5Res(r14, r0, r4)     // Catch:{ Exception -> 0x030f }
                            goto L_0x031b
                        L_0x030f:
                            r0 = move-exception
                            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r3 == 0) goto L_0x031b
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                        L_0x031b:
                            java.util.List r0 = r16.a()
                            if (r0 == 0) goto L_0x0389
                            int r3 = r0.size()
                            if (r3 <= 0) goto L_0x0389
                            java.util.Iterator r3 = r0.iterator()
                        L_0x032b:
                            boolean r0 = r3.hasNext()
                            if (r0 == 0) goto L_0x0389
                            java.lang.Object r0 = r3.next()
                            com.mbridge.msdk.foundation.entity.CampaignEx$c$a r0 = (com.mbridge.msdk.foundation.entity.CampaignEx.c.a) r0
                            if (r0 == 0) goto L_0x032b
                            java.util.List<java.lang.String> r4 = r0.f9019a
                            if (r4 == 0) goto L_0x032b
                            int r4 = r4.size()
                            if (r4 <= 0) goto L_0x032b
                            java.util.List<java.lang.String> r0 = r0.f9019a
                            java.util.Iterator r11 = r0.iterator()
                        L_0x0349:
                            boolean r0 = r11.hasNext()
                            if (r0 == 0) goto L_0x032b
                            java.lang.Object r0 = r11.next()
                            java.lang.String r0 = (java.lang.String) r0
                            boolean r4 = android.text.TextUtils.isEmpty(r0)
                            if (r4 != 0) goto L_0x0349
                            android.content.Context r4 = r3     // Catch:{ Exception -> 0x0379 }
                            com.mbridge.msdk.foundation.same.c.b r12 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r4)     // Catch:{ Exception -> 0x0379 }
                            com.mbridge.msdk.reward.adapter.b$e r4 = new com.mbridge.msdk.reward.adapter.b$e     // Catch:{ Exception -> 0x0379 }
                            com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0379 }
                            com.mbridge.msdk.reward.adapter.b$h r5 = r5.f11022a     // Catch:{ Exception -> 0x0379 }
                            java.lang.String r7 = r6     // Catch:{ Exception -> 0x0379 }
                            java.lang.String r8 = r4     // Catch:{ Exception -> 0x0379 }
                            r10 = r9
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x037b }
                            r6 = 1
                            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x037b }
                            r9 = r10
                            r12.a(r0, r4)     // Catch:{ Exception -> 0x0379 }
                            goto L_0x0349
                        L_0x0379:
                            r0 = move-exception
                            goto L_0x037d
                        L_0x037b:
                            r0 = move-exception
                            r9 = r10
                        L_0x037d:
                            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r4 == 0) goto L_0x0349
                            java.lang.String r0 = r0.getLocalizedMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                            goto L_0x0349
                        L_0x0389:
                            r3 = r21
                            goto L_0x0053
                        L_0x038d:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.AnonymousClass1.run():void");
                    }
                });
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static com.mbridge.msdk.foundation.c.b b(int i5, MBridgeIds mBridgeIds, String str, Throwable th, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(i5);
        bVar.a(mBridgeIds);
        bVar.a(th);
        bVar.a(str);
        bVar.a(campaignEx);
        return bVar;
    }

    private static final class f implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a  reason: collision with root package name */
        private Handler f11115a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11116b;

        /* renamed from: c  reason: collision with root package name */
        private final String f11117c;

        /* renamed from: d  reason: collision with root package name */
        private final String f11118d;

        public f(Handler handler, String str, String str2, String str3) {
            this.f11115a = handler;
            this.f11117c = str;
            this.f11116b = str2;
            this.f11118d = str3;
        }

        public final void a(String str) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str, true);
            Message obtain = Message.obtain();
            obtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11116b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f11117c);
            bundle.putString("request_id", this.f11118d);
            bundle.putString("url", str);
            obtain.setData(bundle);
            this.f11115a.sendMessage(obtain);
        }

        public final void a(String str, String str2) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str2, false);
            Message obtain = Message.obtain();
            obtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f11116b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f11117c);
            bundle.putString("request_id", this.f11118d);
            bundle.putString("url", str2);
            bundle.putString("message", str);
            obtain.setData(bundle);
            this.f11115a.sendMessage(obtain);
        }
    }

    /* access modifiers changed from: private */
    public void a(final int i5, final CampaignEx campaignEx, String str, String str2) {
        com.mbridge.msdk.foundation.tools.o.a(i5, str, str2, new o.a() {
            public final void a(String str, String str2, String str3, String str4, boolean z4) {
                if (!z4) {
                    try {
                        n nVar = new n();
                        int i5 = i5;
                        if (i5 == 0) {
                            nVar.e(1);
                            nVar.b(1);
                            nVar.a("m_download_end");
                        } else if (i5 == 1) {
                            nVar.e(2);
                            nVar.b(1);
                            nVar.a("m_download_end");
                        } else if (i5 == 2) {
                            nVar.e(3);
                            nVar.b(1);
                            nVar.a("m_download_end");
                            nVar.d(campaignEx.isMraid() ? n.f9116a : n.f9117b);
                            nVar.o("1");
                        }
                        nVar.g(campaignEx.getRequestIdNotice());
                        nVar.a("url", str);
                        nVar.a("scenes", "1");
                        com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardCampaignsResourceManager", e5.getMessage());
                        }
                    }
                }
            }

            public final void a(String str, DownloadError downloadError) {
                String str2 = "";
                if (downloadError != null) {
                    try {
                        if (downloadError.getException() != null) {
                            str2 = downloadError.getException().getMessage();
                        }
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                n nVar = new n();
                int i5 = i5;
                if (i5 == 0) {
                    nVar.e(1);
                    nVar.b(3);
                    nVar.a("m_download_end");
                } else if (i5 == 1) {
                    nVar.e(2);
                    nVar.b(3);
                    nVar.a("m_download_end");
                } else if (i5 == 2) {
                    nVar.e(3);
                    nVar.b(3);
                    nVar.a("m_download_end");
                    nVar.d(campaignEx.isMraid() ? n.f9116a : n.f9117b);
                    nVar.o("1");
                }
                b.a(nVar, campaignEx);
                nVar.g(campaignEx.getRequestIdNotice());
                nVar.h(str2);
                nVar.a("scenes", "1");
                nVar.a("url", str);
                com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx);
            }
        }, campaignEx);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0073, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r12, com.mbridge.msdk.foundation.entity.CampaignEx r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, com.mbridge.msdk.reward.adapter.b.i r17) {
        /*
            r11 = this;
            r4 = r16
            r5 = r17
            monitor-enter(r11)
            com.mbridge.msdk.reward.adapter.b$h r0 = r11.f11022a     // Catch:{ all -> 0x0039 }
            r0.a(r12)     // Catch:{ all -> 0x0039 }
            r0 = 1
            if (r13 == 0) goto L_0x0074
            java.lang.String r1 = r13.getCMPTEntryUrl()     // Catch:{ all -> 0x0039 }
            boolean r2 = r13.isDynamicView()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0074
            java.lang.String r12 = "dyview"
            boolean r12 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.String) r12, (java.lang.String) r1)     // Catch:{ all -> 0x0039 }
            if (r12 == 0) goto L_0x003d
            int r12 = r13.getMof_tplid()     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r2.<init>()     // Catch:{ all -> 0x0039 }
            r2.append(r12)     // Catch:{ all -> 0x0039 }
            java.lang.String r12 = ""
            r2.append(r12)     // Catch:{ all -> 0x0039 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x0039 }
            r2 = 0
            r11.a(r2, r13, r12, r1)     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r0 = move-exception
            r12 = r0
            goto L_0x00c8
        L_0x003d:
            com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r12 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ all -> 0x0039 }
            r12.setZipDownloadDone(r1, r0)     // Catch:{ all -> 0x0039 }
            android.os.Message r12 = android.os.Message.obtain()     // Catch:{ all -> 0x0039 }
            r13 = 105(0x69, float:1.47E-43)
            r12.what = r13     // Catch:{ all -> 0x0039 }
            android.os.Bundle r13 = new android.os.Bundle     // Catch:{ all -> 0x0039 }
            r13.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = "unit_id"
            r13.putString(r0, r15)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ all -> 0x0039 }
            r13.putString(r0, r14)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = "request_id"
            r13.putString(r0, r4)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = "url"
            r13.putString(r0, r1)     // Catch:{ all -> 0x0039 }
            r12.setData(r13)     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.reward.adapter.b$h r13 = r11.f11022a     // Catch:{ all -> 0x0039 }
            r13.sendMessage(r12)     // Catch:{ all -> 0x0039 }
            if (r5 == 0) goto L_0x0072
            r5.a(r14, r15, r4, r1)     // Catch:{ all -> 0x0039 }
        L_0x0072:
            monitor-exit(r11)
            return
        L_0x0074:
            if (r13 == 0) goto L_0x00c6
            java.lang.String r1 = r13.getCMPTEntryUrl()     // Catch:{ all -> 0x0039 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0039 }
            if (r1 != 0) goto L_0x00c6
            com.mbridge.msdk.foundation.same.report.d.d r1 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r2 = r13.getCurrentLocalRid()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r3 = ""
            com.mbridge.msdk.foundation.same.report.d.c r1 = r1.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0097 }
            if (r1 != 0) goto L_0x0095
            com.mbridge.msdk.foundation.same.report.d.c r1 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x0097 }
            r1.<init>()     // Catch:{ Exception -> 0x0097 }
        L_0x0095:
            r8 = r1
            goto L_0x009a
        L_0x0097:
            r0 = move-exception
            r12 = r0
            goto L_0x00bd
        L_0x009a:
            r8.a((com.mbridge.msdk.foundation.entity.CampaignEx) r13)     // Catch:{ Exception -> 0x0097 }
            r8.a((int) r0)     // Catch:{ Exception -> 0x0097 }
            int r0 = r11.a((com.mbridge.msdk.foundation.entity.CampaignEx) r13)     // Catch:{ Exception -> 0x0097 }
            r8.c((int) r0)     // Catch:{ Exception -> 0x0097 }
            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r9 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r10 = r13.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0097 }
            com.mbridge.msdk.reward.adapter.b$3 r0 = new com.mbridge.msdk.reward.adapter.b$3     // Catch:{ Exception -> 0x0097 }
            r1 = r11
            r6 = r12
            r7 = r13
            r3 = r14
            r2 = r15
            r0.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0097 }
            r9.downloadH5Res(r8, r10, r0)     // Catch:{ Exception -> 0x0097 }
            goto L_0x00c6
        L_0x00bd:
            java.lang.String r13 = "RewardCampaignsResourceManager"
            java.lang.String r12 = r12.getLocalizedMessage()     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)     // Catch:{ all -> 0x0039 }
        L_0x00c6:
            monitor-exit(r11)
            return
        L_0x00c8:
            monitor-exit(r11)     // Catch:{ all -> 0x0039 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(android.content.Context, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.reward.adapter.b$i):void");
    }

    /* renamed from: com.mbridge.msdk.reward.adapter.b$b  reason: collision with other inner class name */
    private static class C0105b extends com.mbridge.msdk.mbsignalcommon.b.a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f11071a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f11072b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f11073c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f11074d;

        /* renamed from: e  reason: collision with root package name */
        private int f11075e;

        /* renamed from: f  reason: collision with root package name */
        private String f11076f;

        /* renamed from: g  reason: collision with root package name */
        private String f11077g;

        /* renamed from: h  reason: collision with root package name */
        private String f11078h;

        /* renamed from: i  reason: collision with root package name */
        private String f11079i;

        /* renamed from: j  reason: collision with root package name */
        private a.C0114a f11080j;

        /* renamed from: k  reason: collision with root package name */
        private CampaignEx f11081k;

        /* renamed from: l  reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f11082l;

        /* renamed from: m  reason: collision with root package name */
        private com.mbridge.msdk.videocommon.d.c f11083m;

        /* renamed from: n  reason: collision with root package name */
        private final j f11084n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f11085o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f11086p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f11087q;

        /* renamed from: r  reason: collision with root package name */
        private int f11088r = 0;

        /* renamed from: s  reason: collision with root package name */
        private boolean f11089s;

        /* renamed from: t  reason: collision with root package name */
        private long f11090t;

        public C0105b(boolean z4, Handler handler, Runnable runnable, boolean z5, boolean z6, int i5, String str, String str2, String str3, String str4, a.C0114a aVar, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.d.c cVar, j jVar, boolean z7, long j5) {
            this.f11071a = handler;
            this.f11072b = runnable;
            this.f11073c = z5;
            this.f11074d = z6;
            this.f11075e = i5;
            this.f11076f = str;
            this.f11078h = str2;
            this.f11077g = str3;
            this.f11079i = str4;
            this.f11080j = aVar;
            this.f11081k = campaignEx;
            this.f11082l = copyOnWriteArrayList;
            this.f11083m = cVar;
            this.f11084n = jVar;
            this.f11085o = z7;
            this.f11089s = z4;
            this.f11090t = j5;
        }

        public final void a(WebView webView, int i5) {
            Runnable runnable;
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                eVar.a("result", Integer.valueOf(i5));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000155", this.f11081k, eVar);
            } catch (Throwable th) {
                af.b("RVWindVaneWebView", th.getMessage());
            }
            if (!this.f11087q) {
                String str = this.f11077g + "_" + this.f11076f;
                if (i5 == 1) {
                    if (this.f11085o) {
                        com.mbridge.msdk.videocommon.a.e(this.f11077g + "_" + this.f11079i);
                    } else {
                        com.mbridge.msdk.videocommon.a.d(this.f11077g + "_" + this.f11079i);
                    }
                    com.mbridge.msdk.videocommon.a.a(this.f11077g + "_" + this.f11079i + "_" + this.f11076f, this.f11080j, true, this.f11085o);
                    Handler handler = this.f11071a;
                    if (!(handler == null || (runnable = this.f11072b) == null)) {
                        handler.removeCallbacks(runnable);
                    }
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11077g + "_" + this.f11079i + "_" + this.f11076f, true);
                    a.C0114a aVar = this.f11080j;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    j jVar = this.f11084n;
                    if (jVar != null) {
                        jVar.a(str, this.f11078h, this.f11077g, this.f11079i, this.f11076f, this.f11080j);
                    }
                } else {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11077g + "_" + this.f11079i + "_" + this.f11076f, false);
                    a.C0114a aVar2 = this.f11080j;
                    if (aVar2 != null) {
                        aVar2.a(false);
                    }
                    if (this.f11084n != null) {
                        this.f11084n.a(str, this.f11079i, this.f11076f, this.f11080j, b.b(880008, new MBridgeIds(this.f11078h, this.f11077g, this.f11079i), "readyState:" + i5, (Throwable) null, this.f11081k));
                    }
                }
                this.f11087q = true;
            }
        }

        public final void a(WebView webView, String str, String str2, int i5, int i6) {
            boolean z4 = true;
            if (i5 == 1) {
                try {
                    com.mbridge.msdk.reward.b.a aVar = new com.mbridge.msdk.reward.b.a();
                    aVar.b(false);
                    if (i6 != 2) {
                        z4 = false;
                    }
                    aVar.a(z4);
                    aVar.b(str, str2);
                    aVar.a((InterVideoOutListener) new com.mbridge.msdk.video.bt.module.b.a((com.mbridge.msdk.video.bt.module.b.g) null));
                    aVar.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, i6, str2, true, 1));
                } catch (Exception e5) {
                    Exception exc = e5;
                    if (MBridgeConstans.DEBUG) {
                        af.b("RVWindVaneWebView", exc.getMessage());
                    }
                }
            }
        }

        public final void a(Object obj, String str) {
            Object obj2 = obj;
            if (obj2 != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        String optString = new JSONObject(str).optString("id");
                        com.mbridge.msdk.video.bt.a.d.c().a(obj2, optString);
                        String c5 = com.mbridge.msdk.video.bt.a.d.c().c(optString);
                        CampaignEx a5 = com.mbridge.msdk.video.bt.a.d.c().a(optString);
                        com.mbridge.msdk.videocommon.d.c b5 = com.mbridge.msdk.video.bt.a.d.c().b(optString);
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        copyOnWriteArrayList.add(a5);
                        WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj2).f10205b;
                        if (windVaneWebView != null) {
                            b a6 = m.f11187a;
                            boolean z4 = this.f11089s;
                            int i5 = this.f11088r == 0 ? 3 : 6;
                            b bVar = a6;
                            boolean z5 = z4;
                            if (!(a5 == null || b5 == null)) {
                                if (a5.getRewardTemplateMode() != null) {
                                    if (!TextUtils.isEmpty(c5)) {
                                        if (TextUtils.isEmpty(a5.getRewardTemplateMode().e())) {
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("id", optString);
                                            JSONObject jSONObject2 = new JSONObject();
                                            jSONObject2.put("result", 1);
                                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "data is null");
                                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                                            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                                        } else if (TextUtils.isEmpty(a5.getRewardTemplateMode().e()) || !a5.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(z5, windVaneWebView, a5, copyOnWriteArrayList, c5, b5, optString) {

                                                /* renamed from: a  reason: collision with root package name */
                                                final /* synthetic */ boolean f11054a;

                                                /* renamed from: b  reason: collision with root package name */
                                                final /* synthetic */ WindVaneWebView f11055b;

                                                /* renamed from: c  reason: collision with root package name */
                                                final /* synthetic */ CampaignEx f11056c;

                                                /* renamed from: d  reason: collision with root package name */
                                                final /* synthetic */ CopyOnWriteArrayList f11057d;

                                                /* renamed from: e  reason: collision with root package name */
                                                final /* synthetic */ String f11058e;

                                                /* renamed from: f  reason: collision with root package name */
                                                final /* synthetic */ com.mbridge.msdk.videocommon.d.c f11059f;

                                                /* renamed from: g  reason: collision with root package name */
                                                final /* synthetic */ String f11060g;

                                                {
                                                    this.f11054a = r2;
                                                    this.f11055b = r3;
                                                    this.f11056c = r4;
                                                    this.f11057d = r5;
                                                    this.f11058e = r6;
                                                    this.f11059f = r7;
                                                    this.f11060g = r8;
                                                }

                                                public final void run() {
                                                    WindVaneWebView windVaneWebView;
                                                    com.mbridge.msdk.video.signal.a.k kVar;
                                                    boolean z4 = this.f11054a;
                                                    WindVaneWebView windVaneWebView2 = this.f11055b;
                                                    String e5 = this.f11056c.getRewardTemplateMode().e();
                                                    CampaignEx campaignEx = this.f11056c;
                                                    CopyOnWriteArrayList copyOnWriteArrayList = this.f11057d;
                                                    String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(this.f11056c.getRewardTemplateMode().e());
                                                    String str = this.f11058e;
                                                    com.mbridge.msdk.videocommon.d.c cVar = this.f11059f;
                                                    String str2 = this.f11060g;
                                                    boolean b5 = b.this.f11023c;
                                                    try {
                                                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                                                        eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                                                        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000154", campaignEx, eVar);
                                                        a.C0114a aVar = new a.C0114a();
                                                        WindVaneWebView windVaneWebView3 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                                                        if (campaignEx != null) {
                                                            windVaneWebView3.setLocalRequestId(campaignEx.getCurrentLocalRid());
                                                        }
                                                        windVaneWebView3.setTempTypeForMetrics(2);
                                                        aVar.a(windVaneWebView3);
                                                        String str3 = "";
                                                        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                                                            windVaneWebView = windVaneWebView2;
                                                            kVar = new com.mbridge.msdk.video.signal.a.k((Activity) null, campaignEx);
                                                            if (campaignEx != null) {
                                                                str3 = campaignEx.getRequestId();
                                                            }
                                                        } else {
                                                            CopyOnWriteArrayList<CampaignEx> a5 = com.mbridge.msdk.videocommon.download.b.getInstance().a(str);
                                                            if (a5 != null && a5.size() > 0) {
                                                                int i5 = 0;
                                                                while (i5 < copyOnWriteArrayList.size()) {
                                                                    CampaignEx campaignEx2 = (CampaignEx) copyOnWriteArrayList.get(i5);
                                                                    for (CampaignEx next : a5) {
                                                                        WindVaneWebView windVaneWebView4 = windVaneWebView2;
                                                                        if (next.getId().equals(campaignEx2.getId()) && next.getRequestId().equals(campaignEx2.getRequestId())) {
                                                                            campaignEx2.setReady(true);
                                                                            copyOnWriteArrayList.set(i5, campaignEx2);
                                                                        }
                                                                        windVaneWebView2 = windVaneWebView4;
                                                                    }
                                                                    WindVaneWebView windVaneWebView5 = windVaneWebView2;
                                                                    i5++;
                                                                }
                                                            }
                                                            windVaneWebView = windVaneWebView2;
                                                            kVar = new com.mbridge.msdk.video.signal.a.k((Activity) null, campaignEx, copyOnWriteArrayList);
                                                            str3 = ((CampaignEx) copyOnWriteArrayList.get(0)).getRequestId();
                                                        }
                                                        kVar.a(0);
                                                        kVar.a(str);
                                                        kVar.c(str2);
                                                        kVar.a(cVar);
                                                        kVar.d(z4);
                                                        windVaneWebView3.setWebViewListener(new l(str2, false, windVaneWebView, e5, str, aVar, campaignEx, b5, str3));
                                                        windVaneWebView3.setObject(kVar);
                                                        windVaneWebView3.loadUrl(h5ResAddress);
                                                        windVaneWebView3.setRid(str3);
                                                    } catch (Exception e6) {
                                                        if (MBridgeConstans.DEBUG) {
                                                            af.b("RewardCampaignsResourceManager", e6.getLocalizedMessage());
                                                        }
                                                    }
                                                }
                                            }, (long) (i5 * 1000));
                                        } else {
                                            af.a("RewardCampaignsResourceManager", "getTeamplateUrl contains cmpt=1");
                                        }
                                        this.f11088r++;
                                    }
                                }
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            try {
                                jSONObject3.put("id", optString);
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("result", 2);
                                jSONObject4.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "data is null");
                                jSONObject3.put(DataSchemeDataSource.SCHEME_DATA, jSONObject4);
                                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                            } catch (Exception e5) {
                                if (MBridgeConstans.DEBUG) {
                                    af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                                }
                            }
                            this.f11088r++;
                        }
                    }
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardCampaignsResourceManager", e6.getLocalizedMessage());
                    }
                } catch (Throwable th) {
                    af.b("RVWindVaneWebView", th.getMessage());
                }
            }
        }

        public final void a(WebView webView, String str) {
            Runnable runnable;
            super.a(webView, str);
            if (!this.f11086p) {
                String str2 = this.f11077g + "_" + this.f11076f;
                if (!str.contains("wfr=1")) {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11077g + "_" + this.f11079i + "_" + this.f11076f, true);
                    Handler handler = this.f11071a;
                    if (!(handler == null || (runnable = this.f11072b) == null)) {
                        handler.removeCallbacks(runnable);
                    }
                    a.C0114a aVar = this.f11080j;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    j jVar = this.f11084n;
                    if (jVar != null) {
                        jVar.a(str2, this.f11078h, this.f11077g, this.f11079i, this.f11076f, this.f11080j);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.f11086p = true;
            }
        }

        public final void a(WebView webView, int i5, String str, String str2) {
            super.a(webView, i5, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11077g + "_" + this.f11079i + "_" + this.f11076f, false);
            if (this.f11084n != null) {
                String str3 = this.f11077g + "_" + this.f11076f;
                a.C0114a aVar = this.f11080j;
                if (aVar != null) {
                    aVar.a(false);
                }
                this.f11084n.a(str3, this.f11079i, this.f11076f, this.f11080j, b.b(880008, new MBridgeIds(this.f11078h, this.f11077g, this.f11079i), "onReceivedError： " + i5 + "  " + str, (Throwable) null, this.f11081k));
            }
        }

        public final void a(WebView webView) {
            if (webView != null) {
                try {
                    LinkedHashMap<String, View> b5 = com.mbridge.msdk.video.bt.a.d.c().b(this.f11077g, this.f11079i);
                    if (b5 == null) {
                        return;
                    }
                    if (!b5.isEmpty()) {
                        for (View next : b5.values()) {
                            if (next instanceof MBridgeBTContainer) {
                                ((MBridgeBTContainer) next).addNativeCloseButtonWhenWebViewCrash();
                            }
                        }
                    }
                } catch (Throwable th) {
                    af.b("RVWindVaneWebView", th.getMessage());
                }
            }
        }
    }

    private static class k extends com.mbridge.msdk.mbsignalcommon.b.b {

        /* renamed from: a  reason: collision with root package name */
        private Handler f11144a;

        /* renamed from: b  reason: collision with root package name */
        private Runnable f11145b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f11146c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f11147d;

        /* renamed from: e  reason: collision with root package name */
        private String f11148e;

        /* renamed from: f  reason: collision with root package name */
        private final j f11149f;

        /* renamed from: g  reason: collision with root package name */
        private final WindVaneWebView f11150g;

        /* renamed from: h  reason: collision with root package name */
        private final String f11151h;

        /* renamed from: i  reason: collision with root package name */
        private final String f11152i;

        /* renamed from: j  reason: collision with root package name */
        private final String f11153j;

        /* renamed from: k  reason: collision with root package name */
        private final a.C0114a f11154k;

        /* renamed from: l  reason: collision with root package name */
        private final CampaignEx f11155l;

        /* renamed from: m  reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f11156m;

        /* renamed from: n  reason: collision with root package name */
        private long f11157n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f11158o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f11159p;

        /* renamed from: q  reason: collision with root package name */
        private final Runnable f11160q;

        /* renamed from: r  reason: collision with root package name */
        private final Runnable f11161r;

        public k(Handler handler, Runnable runnable, boolean z4, boolean z5, String str, j jVar, WindVaneWebView windVaneWebView, String str2, String str3, String str4, a.C0114a aVar, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, long j5) {
            this.f11144a = handler;
            this.f11145b = runnable;
            this.f11146c = z4;
            this.f11147d = z5;
            this.f11148e = str;
            this.f11149f = jVar;
            this.f11150g = windVaneWebView;
            final String str5 = str2;
            this.f11151h = str5;
            final String str6 = str4;
            this.f11152i = str6;
            final String str7 = str3;
            this.f11153j = str7;
            final a.C0114a aVar2 = aVar;
            this.f11154k = aVar2;
            this.f11155l = campaignEx;
            this.f11156m = copyOnWriteArrayList;
            this.f11157n = j5;
            final String str8 = str;
            final j jVar2 = jVar;
            AnonymousClass1 r10 = new Runnable() {
                public final void run() {
                    WindVaneWebView a5;
                    a.C0114a aVar;
                    if (!(jVar2 == null || (aVar = aVar2) == null)) {
                        aVar.a(true);
                        ResDownloadCheckManager instance = ResDownloadCheckManager.getInstance();
                        instance.setTemplatePreLoadDone(str6 + "_" + str8 + "_" + str5, true);
                        j jVar = jVar2;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str6);
                        sb.append("_");
                        sb.append(str5);
                        jVar.a(sb.toString(), str7, str6, str8, str5, aVar2);
                    }
                    a.C0114a aVar2 = aVar2;
                    if (aVar2 != null && (a5 = aVar2.a()) != null) {
                        try {
                            a5.release();
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("WindVaneWebView", e5.getMessage());
                            }
                        }
                    }
                }
            };
            this.f11161r = r10;
            this.f11160q = new Runnable() {
                public final void run() {
                    WindVaneWebView a5;
                    a.C0114a aVar;
                    if (!(jVar2 == null || (aVar = aVar2) == null)) {
                        aVar.a(true);
                        ResDownloadCheckManager instance = ResDownloadCheckManager.getInstance();
                        instance.setTemplatePreLoadDone(str6 + "_" + str8 + "_" + str5, true);
                        j jVar = jVar2;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str6);
                        sb.append("_");
                        sb.append(str5);
                        jVar.a(sb.toString(), str7, str6, str8, str5, aVar2);
                    }
                    a.C0114a aVar2 = aVar2;
                    if (aVar2 != null && (a5 = aVar2.a()) != null) {
                        try {
                            a5.release();
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("WindVaneWebView", e5.getMessage());
                            }
                        }
                    }
                }
            };
            if (handler != null) {
                handler.postDelayed(r10, 5000);
            }
        }

        public final void a(WebView webView, int i5) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.a(webView, i5);
            Handler handler2 = this.f11144a;
            if (!(handler2 == null || (runnable2 = this.f11160q) == null)) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.f11144a;
            if (!(handler3 == null || (runnable = this.f11161r) == null)) {
                handler3.removeCallbacks(runnable);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                eVar.a("result", Integer.valueOf(i5));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000155", this.f11155l, eVar);
            } catch (Throwable th) {
                af.b("WindVaneWebView", th.getMessage());
            }
            if (!this.f11159p) {
                String str = this.f11152i + "_" + this.f11151h;
                if (i5 == 1) {
                    Runnable runnable3 = this.f11145b;
                    if (!(runnable3 == null || (handler = this.f11144a) == null)) {
                        handler.removeCallbacks(runnable3);
                    }
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11152i + "_" + this.f11148e + "_" + this.f11151h, true);
                    a.C0114a aVar = this.f11154k;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.f11146c) {
                        if (this.f11147d) {
                            com.mbridge.msdk.videocommon.a.a(287, this.f11155l.getRequestIdNotice(), this.f11154k);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(287, this.f11155l.getRequestIdNotice(), this.f11154k);
                        }
                    } else if (this.f11147d) {
                        com.mbridge.msdk.videocommon.a.a(94, this.f11155l.getRequestIdNotice(), this.f11154k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(94, this.f11155l.getRequestIdNotice(), this.f11154k);
                    }
                    j jVar = this.f11149f;
                    if (jVar != null) {
                        jVar.a(str, this.f11153j, this.f11152i, this.f11148e, this.f11151h, this.f11154k);
                    }
                } else if (this.f11149f != null) {
                    this.f11149f.a(str, this.f11148e, this.f11151h, this.f11154k, b.b(880009, new MBridgeIds(this.f11153j, this.f11152i, this.f11148e), "readyState:" + i5, (Throwable) null, this.f11155l));
                }
                this.f11159p = true;
            }
        }

        public final void a(WebView webView, int i5, String str, String str2) {
            super.a(webView, i5, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11152i + "_" + this.f11148e + "_" + this.f11151h, false);
            Handler handler = this.f11144a;
            if (handler != null) {
                if (this.f11160q != null) {
                    handler.removeCallbacks(this.f11161r);
                }
                Runnable runnable = this.f11160q;
                if (runnable != null) {
                    this.f11144a.removeCallbacks(runnable);
                }
            }
            try {
                String str3 = this.f11152i + "_" + this.f11151h;
                a.C0114a aVar = this.f11154k;
                if (aVar != null) {
                    aVar.a(false);
                }
                if (this.f11149f != null) {
                    String str4 = str2;
                    this.f11149f.a(str3, this.f11148e, str4, this.f11154k, b.b(880009, new MBridgeIds(this.f11153j, this.f11152i, this.f11148e), i5 + "#" + str, (Throwable) null, this.f11155l));
                }
            } catch (Exception e5) {
                Exception exc = e5;
                if (MBridgeConstans.DEBUG) {
                    af.b("WindVaneWebView", exc.getLocalizedMessage());
                }
            }
        }

        public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11152i + "_" + this.f11148e + "_" + this.f11151h, false);
            Handler handler = this.f11144a;
            if (handler != null) {
                if (this.f11160q != null) {
                    handler.removeCallbacks(this.f11161r);
                }
                Runnable runnable = this.f11160q;
                if (runnable != null) {
                    this.f11144a.removeCallbacks(runnable);
                }
            }
            try {
                String str = this.f11152i + "_" + this.f11151h;
                a.C0114a aVar = this.f11154k;
                if (aVar != null) {
                    aVar.a(false);
                }
                if (this.f11149f != null) {
                    MBridgeIds mBridgeIds = new MBridgeIds(this.f11153j, this.f11152i, this.f11148e);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onReceivedSslError:");
                    sb.append(sslError == null ? "" : Integer.valueOf(sslError.getPrimaryError()));
                    this.f11149f.a(str, this.f11148e, this.f11151h, this.f11154k, b.b(880009, mBridgeIds, sb.toString(), (Throwable) null, this.f11155l));
                }
            } catch (Exception e5) {
                Exception exc = e5;
                if (MBridgeConstans.DEBUG) {
                    af.b("WindVaneWebView", exc.getLocalizedMessage());
                }
            }
        }

        public final void a(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.a(webView, str);
            Handler handler2 = this.f11144a;
            if (!(handler2 == null || (runnable2 = this.f11161r) == null)) {
                handler2.removeCallbacks(runnable2);
            }
            if (!this.f11158o) {
                if (!str.contains("wfr=1")) {
                    String str2 = this.f11152i + "_" + this.f11151h;
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11152i + "_" + this.f11148e + "_" + this.f11151h, true);
                    Runnable runnable3 = this.f11145b;
                    if (!(runnable3 == null || (handler = this.f11144a) == null)) {
                        handler.removeCallbacks(runnable3);
                    }
                    a.C0114a aVar = this.f11154k;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.f11146c) {
                        if (this.f11155l.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(287, this.f11155l.getRequestIdNotice(), this.f11154k);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(287, this.f11155l.getRequestIdNotice(), this.f11154k);
                        }
                    } else if (this.f11155l.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(94, this.f11155l.getRequestIdNotice(), this.f11154k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(94, this.f11155l.getRequestIdNotice(), this.f11154k);
                    }
                    j jVar = this.f11149f;
                    if (jVar != null) {
                        jVar.a(str2, this.f11153j, this.f11152i, this.f11148e, this.f11151h, this.f11154k);
                    }
                } else {
                    Handler handler3 = this.f11144a;
                    if (!(handler3 == null || (runnable = this.f11160q) == null)) {
                        handler3.postDelayed(runnable, 5000);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.f11158o = true;
            }
        }
    }

    private static class l extends com.mbridge.msdk.mbsignalcommon.b.b {

        /* renamed from: a  reason: collision with root package name */
        private String f11176a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f11177b;

        /* renamed from: c  reason: collision with root package name */
        private final WindVaneWebView f11178c;

        /* renamed from: d  reason: collision with root package name */
        private final String f11179d;

        /* renamed from: e  reason: collision with root package name */
        private final String f11180e;

        /* renamed from: f  reason: collision with root package name */
        private final a.C0114a f11181f;

        /* renamed from: g  reason: collision with root package name */
        private final CampaignEx f11182g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f11183h;

        /* renamed from: i  reason: collision with root package name */
        private String f11184i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f11185j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f11186k;

        public l(String str, boolean z4, WindVaneWebView windVaneWebView, String str2, String str3, a.C0114a aVar, CampaignEx campaignEx, boolean z5, String str4) {
            this.f11177b = z4;
            this.f11178c = windVaneWebView;
            this.f11179d = str2;
            this.f11180e = str3;
            this.f11181f = aVar;
            this.f11182g = campaignEx;
            this.f11176a = str;
            this.f11183h = z5;
            this.f11184i = str4;
        }

        public final void a(WebView webView, int i5) {
            try {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                eVar.a("result", Integer.valueOf(i5));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000155", this.f11182g, eVar);
            } catch (Throwable th) {
                af.b("WindVaneWebView", th.getMessage());
            }
            if (!this.f11186k) {
                if (this.f11178c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f11176a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", i5);
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "");
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f11178c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("WindVaneWebView", e5.getLocalizedMessage());
                        }
                    }
                }
                String str = this.f11180e + "_" + this.f11182g.getId() + "_" + this.f11182g.getRequestId() + "_" + this.f11179d;
                if (i5 == 1) {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11180e + "_" + this.f11184i + "_" + this.f11179d, true);
                    a.C0114a aVar = this.f11181f;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.f11177b) {
                        if (this.f11182g.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(str, this.f11181f, false, this.f11183h);
                        } else {
                            com.mbridge.msdk.videocommon.a.a(str, this.f11181f, false, this.f11183h);
                        }
                    } else if (this.f11182g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(str, this.f11181f, false, this.f11183h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, this.f11181f, false, this.f11183h);
                    }
                } else {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11180e + "_" + this.f11184i + "_" + this.f11179d, false);
                    a.C0114a aVar2 = this.f11181f;
                    if (aVar2 != null) {
                        aVar2.a(false);
                    }
                }
                this.f11186k = true;
            }
        }

        public final void a(WebView webView, int i5, String str, String str2) {
            ResDownloadCheckManager instance = ResDownloadCheckManager.getInstance();
            instance.setTemplatePreLoadDone(this.f11180e + "_" + this.f11184i + "_" + this.f11179d, false);
            a.C0114a aVar = this.f11181f;
            if (aVar != null) {
                aVar.a(false);
            }
            if (this.f11178c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f11176a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f11178c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("WindVaneWebView", e5.getLocalizedMessage());
                    }
                }
            }
        }

        public final void a(WebView webView, String str) {
            if (!this.f11185j) {
                if (!str.contains("wfr=1")) {
                    if (this.f11178c != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", this.f11176a);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("result", 1);
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "");
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f11178c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("WindVaneWebView", e5.getLocalizedMessage());
                            }
                        }
                    }
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f11180e + "_" + this.f11184i + "_" + this.f11179d, true);
                    a.C0114a aVar = this.f11181f;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    String str2 = this.f11180e + "_" + this.f11182g.getId() + "_" + this.f11182g.getRequestId() + "_" + this.f11179d;
                    if (this.f11177b) {
                        if (this.f11182g.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(287, this.f11182g.getRequestIdNotice(), this.f11181f);
                        } else {
                            com.mbridge.msdk.videocommon.a.a(str2, this.f11181f, false, this.f11183h);
                        }
                    } else if (this.f11182g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(94, this.f11182g.getRequestIdNotice(), this.f11181f);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str2, this.f11181f, false, this.f11183h);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.f11185j = true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(boolean r20, android.os.Handler r21, boolean r22, boolean r23, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r24, java.lang.String r25, int r26, com.mbridge.msdk.foundation.entity.CampaignEx r27, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, com.mbridge.msdk.videocommon.d.c r34, com.mbridge.msdk.reward.adapter.b.j r35) {
        /*
            r19 = this;
            r6 = r25
            r12 = r27
            r13 = r28
            r4 = r31
            monitor-enter(r19)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r0.<init>()     // Catch:{ all -> 0x0034 }
            r0.append(r4)     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ all -> 0x0034 }
            r0.append(r6)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x0034 }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0034 }
            boolean r0 = com.mbridge.msdk.foundation.tools.ak.i((java.lang.String) r6)     // Catch:{ Exception -> 0x017e }
            if (r0 == 0) goto L_0x0040
            if (r35 == 0) goto L_0x003e
            r7 = 0
            r3 = r30
            r5 = r32
            r1 = r35
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0037 }
            goto L_0x003e
        L_0x0034:
            r0 = move-exception
            goto L_0x01b4
        L_0x0037:
            r0 = move-exception
            r16 = r2
        L_0x003a:
            r5 = r32
            goto L_0x0183
        L_0x003e:
            monitor-exit(r19)
            return
        L_0x0040:
            r16 = r2
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x009b }
            r0.<init>()     // Catch:{ Exception -> 0x009b }
            java.lang.String r1 = "type"
            r2 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x009b }
            r0.a(r1, r3)     // Catch:{ Exception -> 0x009b }
            com.mbridge.msdk.foundation.same.report.d.d r1 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x009b }
            java.lang.String r3 = "2000154"
            r1.a((java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r12, (com.mbridge.msdk.foundation.same.report.d.e) r0)     // Catch:{ Exception -> 0x009b }
            com.mbridge.msdk.videocommon.a$a r7 = new com.mbridge.msdk.videocommon.a$a     // Catch:{ Exception -> 0x009b }
            r7.<init>()     // Catch:{ Exception -> 0x009b }
            r0 = 1
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = new com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView     // Catch:{ Exception -> 0x007d, all -> 0x0077 }
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x007d, all -> 0x0077 }
            android.content.Context r3 = r3.c()     // Catch:{ Exception -> 0x007d, all -> 0x0077 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x007d, all -> 0x0077 }
            if (r12 == 0) goto L_0x0083
            java.lang.String r3 = r12.getCurrentLocalRid()     // Catch:{ Exception -> 0x007d, all -> 0x0077 }
            r1.setLocalRequestId(r3)     // Catch:{ Exception -> 0x007d, all -> 0x0077 }
            goto L_0x0083
        L_0x0077:
            r6 = r25
            r5 = r32
            goto L_0x00f4
        L_0x007d:
            r6 = r25
            r5 = r32
            goto L_0x0139
        L_0x0083:
            r1.setTempTypeForMetrics(r2)     // Catch:{ Exception -> 0x007d, all -> 0x0077 }
            r7.a((com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r1)     // Catch:{ Exception -> 0x00ef }
            r0 = 0
            if (r13 == 0) goto L_0x009d
            int r2 = r13.size()     // Catch:{ Exception -> 0x009b }
            if (r2 <= 0) goto L_0x009d
            com.mbridge.msdk.video.signal.a.k r2 = new com.mbridge.msdk.video.signal.a.k     // Catch:{ Exception -> 0x009b }
            r2.<init>(r0, r12, r13)     // Catch:{ Exception -> 0x009b }
        L_0x0097:
            r0 = r2
            r2 = r26
            goto L_0x00a3
        L_0x009b:
            r0 = move-exception
            goto L_0x003a
        L_0x009d:
            com.mbridge.msdk.video.signal.a.k r2 = new com.mbridge.msdk.video.signal.a.k     // Catch:{ Exception -> 0x00ef }
            r2.<init>(r0, r12)     // Catch:{ Exception -> 0x00ef }
            goto L_0x0097
        L_0x00a3:
            r0.a((int) r2)     // Catch:{ Exception -> 0x00ef }
            r0.a((java.lang.String) r4)     // Catch:{ Exception -> 0x00ef }
            r2 = r34
            r0.a((com.mbridge.msdk.videocommon.d.c) r2)     // Catch:{ Exception -> 0x00ef }
            r2 = r20
            r0.d((boolean) r2)     // Catch:{ Exception -> 0x00ef }
            r2 = r0
            com.mbridge.msdk.reward.adapter.b$k r0 = new com.mbridge.msdk.reward.adapter.b$k     // Catch:{ Exception -> 0x00ef }
            r3 = r2
            r2 = 0
            r8 = r25
            r9 = r30
            r5 = r32
            r6 = r35
            r17 = r1
            r18 = r3
            r10 = r4
            r11 = r7
            r1 = r21
            r3 = r22
            r4 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00ea }
            r6 = r8
            r4 = r10
            r1 = r17
            r1.setWebViewListener(r0)     // Catch:{ Exception -> 0x00e7 }
            r2 = r18
            r1.setObject(r2)     // Catch:{ Exception -> 0x00e7 }
            r0 = r29
            r1.loadUrl(r0)     // Catch:{ Exception -> 0x00e7 }
            r1.setRid(r5)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x01b2
        L_0x00e7:
            r0 = move-exception
            goto L_0x0183
        L_0x00ea:
            r0 = move-exception
            r6 = r8
            r4 = r10
            goto L_0x0183
        L_0x00ef:
            r0 = move-exception
            r6 = r25
            goto L_0x003a
        L_0x00f4:
            if (r35 == 0) goto L_0x0137
            r7.a((boolean) r0)     // Catch:{ Exception -> 0x00e7 }
            com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r1 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ Exception -> 0x00e7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e7 }
            r2.<init>()     // Catch:{ Exception -> 0x00e7 }
            r2.append(r4)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ Exception -> 0x00e7 }
            r2.append(r5)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ Exception -> 0x00e7 }
            r2.append(r6)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00e7 }
            r1.setTemplatePreLoadDone(r2, r0)     // Catch:{ Exception -> 0x00e7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e7 }
            r0.<init>()     // Catch:{ Exception -> 0x00e7 }
            r0.append(r4)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ Exception -> 0x00e7 }
            r0.append(r6)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x00e7 }
            r3 = r30
            r1 = r35
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00e7 }
        L_0x0137:
            monitor-exit(r19)
            return
        L_0x0139:
            if (r35 == 0) goto L_0x017c
            r7.a((boolean) r0)     // Catch:{ Exception -> 0x00e7 }
            com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r1 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ Exception -> 0x00e7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e7 }
            r2.<init>()     // Catch:{ Exception -> 0x00e7 }
            r2.append(r4)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ Exception -> 0x00e7 }
            r2.append(r5)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ Exception -> 0x00e7 }
            r2.append(r6)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00e7 }
            r1.setTemplatePreLoadDone(r2, r0)     // Catch:{ Exception -> 0x00e7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e7 }
            r0.<init>()     // Catch:{ Exception -> 0x00e7 }
            r0.append(r4)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ Exception -> 0x00e7 }
            r0.append(r6)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x00e7 }
            r3 = r30
            r1 = r35
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00e7 }
        L_0x017c:
            monitor-exit(r19)
            return
        L_0x017e:
            r0 = move-exception
            r5 = r32
            r16 = r2
        L_0x0183:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0190
            java.lang.String r1 = "RewardCampaignsResourceManager"
            java.lang.String r2 = r0.getLocalizedMessage()     // Catch:{ all -> 0x0034 }
            com.mbridge.msdk.foundation.tools.af.b(r1, r2)     // Catch:{ all -> 0x0034 }
        L_0x0190:
            if (r35 == 0) goto L_0x01b2
            com.mbridge.msdk.out.MBridgeIds r1 = new com.mbridge.msdk.out.MBridgeIds     // Catch:{ all -> 0x0034 }
            r3 = r30
            r1.<init>(r3, r4, r5)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = ""
            r3 = 880009(0xd6d89, float:1.233155E-39)
            com.mbridge.msdk.foundation.c.b r0 = b(r3, r1, r2, r0, r12)     // Catch:{ all -> 0x0034 }
            r1 = 0
            r29 = r25
            r26 = r35
            r31 = r0
            r30 = r1
            r28 = r5
            r27 = r16
            r26.a(r27, r28, r29, r30, r31)     // Catch:{ all -> 0x0034 }
        L_0x01b2:
            monitor-exit(r19)
            return
        L_0x01b4:
            monitor-exit(r19)     // Catch:{ all -> 0x0034 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(boolean, android.os.Handler, boolean, boolean, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView, java.lang.String, int, com.mbridge.msdk.foundation.entity.CampaignEx, java.util.concurrent.CopyOnWriteArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.reward.adapter.b$j):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b7 A[SYNTHETIC, Splitter:B:52:0x01b7] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(boolean r26, android.os.Handler r27, boolean r28, boolean r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, int r35, com.mbridge.msdk.foundation.entity.CampaignEx r36, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r37, java.lang.String r38, java.lang.String r39, com.mbridge.msdk.videocommon.d.c r40, com.mbridge.msdk.reward.adapter.b.j r41, boolean r42) {
        /*
            r25 = this;
            r1 = r25
            r5 = r33
            r14 = r36
            r15 = r37
            r0 = r42
            monitor-enter(r25)
            r1.f11023c = r0     // Catch:{ all -> 0x003c }
            long r19 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r2.<init>()     // Catch:{ all -> 0x003c }
            r2.append(r5)     // Catch:{ all -> 0x003c }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ all -> 0x003c }
            r7 = r34
            r2.append(r7)     // Catch:{ all -> 0x003c }
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x003c }
            r1.f11023c = r0     // Catch:{ all -> 0x003c }
            boolean r2 = com.mbridge.msdk.foundation.tools.ak.i((java.lang.String) r7)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0041
            if (r41 == 0) goto L_0x003f
            r8 = 0
            r6 = r30
            r4 = r32
            r2 = r41
            r2.a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x003c }
            goto L_0x003f
        L_0x003c:
            r0 = move-exception
            goto L_0x01e6
        L_0x003f:
            monitor-exit(r25)
            return
        L_0x0041:
            r21 = r3
            java.lang.String r2 = "RewardCampaignsResourceManager"
            java.lang.String r3 = "开始预加载大模板资源"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.same.report.d.e r2 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x007e }
            r2.<init>()     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "type"
            r4 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x007e }
            r2.a(r3, r6)     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.same.report.d.d r3 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = "2000154"
            r3.a((java.lang.String) r6, (com.mbridge.msdk.foundation.entity.CampaignEx) r14, (com.mbridge.msdk.foundation.same.report.d.e) r2)     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.videocommon.a$a r13 = new com.mbridge.msdk.videocommon.a$a     // Catch:{ Exception -> 0x007e }
            r13.<init>()     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = new com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x007e }
            android.content.Context r3 = r3.c()     // Catch:{ Exception -> 0x007e }
            r2.<init>(r3)     // Catch:{ Exception -> 0x007e }
            if (r14 == 0) goto L_0x0083
            java.lang.String r3 = r14.getCurrentLocalRid()     // Catch:{ Exception -> 0x007e }
            r2.setLocalRequestId(r3)     // Catch:{ Exception -> 0x007e }
            goto L_0x0083
        L_0x007e:
            r0 = move-exception
            r6 = r30
            goto L_0x01b5
        L_0x0083:
            r2.setTempTypeForMetrics(r4)     // Catch:{ Exception -> 0x007e }
            r13.a((com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r2)     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.video.bt.a.d r3 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = r3.a()     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.video.bt.a.d r6 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = r6.a()     // Catch:{ Exception -> 0x007e }
            r13.a((java.lang.String) r6)     // Catch:{ Exception -> 0x007e }
            if (r15 == 0) goto L_0x0103
            int r8 = r15.size()     // Catch:{ Exception -> 0x007e }
            if (r8 <= 0) goto L_0x0103
            com.mbridge.msdk.videocommon.download.b r8 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x007e }
            java.util.concurrent.CopyOnWriteArrayList r8 = r8.a((java.lang.String) r5)     // Catch:{ Exception -> 0x007e }
            if (r8 == 0) goto L_0x00fa
            int r9 = r8.size()     // Catch:{ Exception -> 0x007e }
            if (r9 <= 0) goto L_0x00fa
            r9 = 0
        L_0x00b5:
            int r10 = r15.size()     // Catch:{ Exception -> 0x007e }
            if (r9 >= r10) goto L_0x00fa
            java.lang.Object r10 = r15.get(r9)     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ Exception -> 0x007e }
            java.util.Iterator r11 = r8.iterator()     // Catch:{ Exception -> 0x007e }
        L_0x00c5:
            boolean r12 = r11.hasNext()     // Catch:{ Exception -> 0x007e }
            if (r12 == 0) goto L_0x00f6
            java.lang.Object r12 = r11.next()     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = (com.mbridge.msdk.foundation.entity.CampaignEx) r12     // Catch:{ Exception -> 0x007e }
            java.lang.String r7 = r12.getId()     // Catch:{ Exception -> 0x007e }
            java.lang.String r4 = r10.getId()     // Catch:{ Exception -> 0x007e }
            boolean r4 = r7.equals(r4)     // Catch:{ Exception -> 0x007e }
            if (r4 == 0) goto L_0x00f4
            java.lang.String r4 = r12.getRequestId()     // Catch:{ Exception -> 0x007e }
            java.lang.String r7 = r10.getRequestId()     // Catch:{ Exception -> 0x007e }
            boolean r4 = r4.equals(r7)     // Catch:{ Exception -> 0x007e }
            if (r4 == 0) goto L_0x00f4
            r4 = 1
            r10.setReady(r4)     // Catch:{ Exception -> 0x007e }
            r15.set(r9, r10)     // Catch:{ Exception -> 0x007e }
        L_0x00f4:
            r4 = 1
            goto L_0x00c5
        L_0x00f6:
            int r9 = r9 + 1
            r4 = 1
            goto L_0x00b5
        L_0x00fa:
            com.mbridge.msdk.video.signal.a.k r4 = new com.mbridge.msdk.video.signal.a.k     // Catch:{ Exception -> 0x007e }
            r7 = 0
            r4.<init>(r7, r14, r15)     // Catch:{ Exception -> 0x007e }
        L_0x0100:
            r8 = r35
            goto L_0x010a
        L_0x0103:
            com.mbridge.msdk.video.signal.a.k r4 = new com.mbridge.msdk.video.signal.a.k     // Catch:{ Exception -> 0x007e }
            r7 = 0
            r4.<init>(r7, r14)     // Catch:{ Exception -> 0x007e }
            goto L_0x0100
        L_0x010a:
            r4.a((int) r8)     // Catch:{ Exception -> 0x007e }
            r7 = r39
            r4.a((java.lang.String) r7)     // Catch:{ Exception -> 0x007e }
            r4.c((java.lang.String) r6)     // Catch:{ Exception -> 0x007e }
            r4.d((java.lang.String) r3)     // Catch:{ Exception -> 0x007e }
            r7 = 1
            r4.c((boolean) r7)     // Catch:{ Exception -> 0x007e }
            r7 = r40
            r4.a((com.mbridge.msdk.videocommon.d.c) r7)     // Catch:{ Exception -> 0x007e }
            r9 = r26
            r4.d((boolean) r9)     // Catch:{ Exception -> 0x007e }
            r10 = r2
            com.mbridge.msdk.reward.adapter.b$b r2 = new com.mbridge.msdk.reward.adapter.b$b     // Catch:{ Exception -> 0x007e }
            r5 = 0
            r12 = r30
            r11 = r33
            r17 = r41
            r18 = r0
            r22 = r3
            r24 = r4
            r23 = r6
            r16 = r7
            r3 = r9
            r0 = r10
            r4 = r27
            r6 = r28
            r7 = r29
            r10 = r32
            r9 = r34
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x01b2 }
            r5 = r11
            r6 = r12
            r0.setWebViewListener(r2)     // Catch:{ Exception -> 0x01b0 }
            r4 = r24
            r0.setObject(r4)     // Catch:{ Exception -> 0x01b0 }
            r2 = r38
            r0.loadUrl(r2)     // Catch:{ Exception -> 0x01b0 }
            r0.setRid(r6)     // Catch:{ Exception -> 0x01b0 }
            com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout r2 = new com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout     // Catch:{ Exception -> 0x01b0 }
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x01b0 }
            android.content.Context r3 = r3.c()     // Catch:{ Exception -> 0x01b0 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x01b0 }
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01b0 }
            r4 = -1
            r3.<init>(r4, r4)     // Catch:{ Exception -> 0x01b0 }
            r2.setLayoutParams(r3)     // Catch:{ Exception -> 0x01b0 }
            r3 = r22
            r2.setInstanceId(r3)     // Catch:{ Exception -> 0x01b0 }
            r2.setUnitId(r5)     // Catch:{ Exception -> 0x01b0 }
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r7 = new com.mbridge.msdk.video.bt.module.MBridgeBTLayout     // Catch:{ Exception -> 0x01b0 }
            com.mbridge.msdk.foundation.controller.c r8 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x01b0 }
            android.content.Context r8 = r8.c()     // Catch:{ Exception -> 0x01b0 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x01b0 }
            android.widget.FrameLayout$LayoutParams r8 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01b0 }
            r8.<init>(r4, r4)     // Catch:{ Exception -> 0x01b0 }
            r7.setLayoutParams(r8)     // Catch:{ Exception -> 0x01b0 }
            r8 = r23
            r7.setInstanceId(r8)     // Catch:{ Exception -> 0x01b0 }
            r7.setUnitId(r5)     // Catch:{ Exception -> 0x01b0 }
            r7.setWebView(r0)     // Catch:{ Exception -> 0x01b0 }
            com.mbridge.msdk.video.bt.a.d r0 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ Exception -> 0x01b0 }
            java.util.LinkedHashMap r0 = r0.b((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x01b0 }
            r0.put(r8, r7)     // Catch:{ Exception -> 0x01b0 }
            r0.put(r3, r2)     // Catch:{ Exception -> 0x01b0 }
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01b0 }
            r0.<init>(r4, r4)     // Catch:{ Exception -> 0x01b0 }
            r2.addView(r7, r0)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x01e4
        L_0x01b0:
            r0 = move-exception
            goto L_0x01b5
        L_0x01b2:
            r0 = move-exception
            r5 = r11
            r6 = r12
        L_0x01b5:
            if (r41 == 0) goto L_0x01d7
            com.mbridge.msdk.out.MBridgeIds r2 = new com.mbridge.msdk.out.MBridgeIds     // Catch:{ all -> 0x003c }
            r4 = r32
            r2.<init>(r4, r5, r6)     // Catch:{ all -> 0x003c }
            java.lang.String r3 = ""
            r4 = 880008(0xd6d88, float:1.233154E-39)
            com.mbridge.msdk.foundation.c.b r2 = b(r4, r2, r3, r0, r14)     // Catch:{ all -> 0x003c }
            r3 = 0
            r38 = r34
            r35 = r41
            r40 = r2
            r39 = r3
            r37 = r6
            r36 = r21
            r35.a(r36, r37, r38, r39, r40)     // Catch:{ all -> 0x003c }
        L_0x01d7:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x01e4
            java.lang.String r2 = "RewardCampaignsResourceManager"
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x003c }
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)     // Catch:{ all -> 0x003c }
        L_0x01e4:
            monitor-exit(r25)
            return
        L_0x01e6:
            monitor-exit(r25)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(boolean, android.os.Handler, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.mbridge.msdk.foundation.entity.CampaignEx, java.util.concurrent.CopyOnWriteArrayList, java.lang.String, java.lang.String, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.reward.adapter.b$j, boolean):void");
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getAabEntity() != null) {
                    return campaignEx.getAabEntity().h3c;
                }
            } catch (Throwable th) {
                af.b("RewardCampaignsResourceManager", th.getMessage());
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.d.c a(CampaignEx campaignEx, int i5) {
        com.mbridge.msdk.foundation.same.report.d.c a5 = campaignEx != null ? com.mbridge.msdk.foundation.same.report.d.d.a().a(campaignEx.getCurrentLocalRid(), "") : null;
        if (a5 == null) {
            a5 = new com.mbridge.msdk.foundation.same.report.d.c();
        }
        a5.a(campaignEx);
        a5.c(a(campaignEx));
        a5.a(i5);
        return a5;
    }

    static /* synthetic */ void a(b bVar, Context context, String str, String str2, String str3, CampaignEx campaignEx, String str4, i iVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        String str5 = str4;
        if (!TextUtils.isEmpty(str5) && !campaignEx.isMraid()) {
            CampaignEx campaignEx2 = campaignEx;
            com.mbridge.msdk.foundation.same.report.d.c a5 = bVar.a(campaignEx2, 3);
            if (!str5.contains(".zip") || !str5.contains(ResourceManager.KEY_MD5FILENAME)) {
                boolean isEmpty = TextUtils.isEmpty(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str5));
                try {
                    d dVar = new d(497, str, str2, str3, campaignEx, iVar, bVar.f11022a, copyOnWriteArrayList);
                    dVar.a(isEmpty);
                    H5DownLoadManager.getInstance().downloadH5Res(a5, str5, dVar);
                } catch (Exception e5) {
                    Exception exc = e5;
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardCampaignsResourceManager", exc.getLocalizedMessage());
                    }
                }
            } else {
                boolean isEmpty2 = TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str5));
                try {
                    g gVar = new g(context, str, str2, str3, campaignEx2, 497, bVar.f11022a, iVar, copyOnWriteArrayList);
                    gVar.a(isEmpty2);
                    H5DownLoadManager.getInstance().downloadH5Res(a5, str5, gVar);
                } catch (Exception e6) {
                    Exception exc2 = e6;
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardCampaignsResourceManager", exc2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.d.c a5 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignEx.getCampaignUnitId());
            if (a5 != null) {
                nVar.v(a5.l());
            }
            com.mbridge.msdk.videocommon.d.a b5 = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b5 != null) {
                nVar.u(b5.c());
            }
        } catch (Exception e5) {
            af.b("RewardCampaignsResourceManager", e5.getMessage());
        }
    }

    static /* synthetic */ void a(b bVar, Context context, int i5, CampaignEx campaignEx, String str, String str2, String str3, String str4) {
        final Context context2 = context;
        final int i6 = i5;
        final CampaignEx campaignEx2 = campaignEx;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
            public final void run() {
                if (campaignEx2 != null && context2 != null) {
                    try {
                        n nVar = new n();
                        nVar.a("m_download_end");
                        Context context = context2;
                        if (context != null) {
                            nVar.a(ab.m(context.getApplicationContext()));
                        }
                        nVar.b(i6);
                        CampaignEx campaignEx = campaignEx2;
                        if (campaignEx != null) {
                            nVar.e(campaignEx.getId());
                            nVar.f(campaignEx2.getRequestId());
                            nVar.s(campaignEx2.getCurrentLocalRid());
                            nVar.g(campaignEx2.getRequestIdNotice());
                        }
                        nVar.a("url", str5);
                        nVar.q(str5);
                        nVar.h(str6);
                        nVar.c(str7);
                        if (!TextUtils.isEmpty(str8)) {
                            nVar.t(str8);
                        }
                        nVar.e(1);
                        nVar.a("scenes", "1");
                        com.mbridge.msdk.foundation.same.report.d.d.a().a(nVar, campaignEx2);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                        }
                    }
                }
            }
        });
    }
}
