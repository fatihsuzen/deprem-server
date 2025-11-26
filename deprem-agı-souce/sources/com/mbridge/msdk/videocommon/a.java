package com.mbridge.msdk.videocommon;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0114a> f12992a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0114a> f12993b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0114a> f12994c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0114a> f12995d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0114a> f12996e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0114a> f12997f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0114a> f12998g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0114a> f12999h = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0114a> f13000i = new ConcurrentHashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0114a> f13001j = new ConcurrentHashMap<>();

    /* renamed from: com.mbridge.msdk.videocommon.a$a  reason: collision with other inner class name */
    public static class C0114a {

        /* renamed from: a  reason: collision with root package name */
        private WindVaneWebView f13002a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13003b;

        public final WindVaneWebView a() {
            return this.f13002a;
        }

        public final String b() {
            WindVaneWebView windVaneWebView = this.f13002a;
            if (windVaneWebView != null) {
                return (String) windVaneWebView.getTag();
            }
            return "";
        }

        public final boolean c() {
            return this.f13003b;
        }

        public final void a(WindVaneWebView windVaneWebView) {
            this.f13002a = windVaneWebView;
        }

        public final void a(String str) {
            WindVaneWebView windVaneWebView = this.f13002a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final void a(boolean z4) {
            this.f13003b = z4;
        }
    }

    public static C0114a a(String str) {
        if (f12998g.containsKey(str)) {
            return f12998g.get(str);
        }
        if (f12999h.containsKey(str)) {
            return f12999h.get(str);
        }
        if (f13000i.containsKey(str)) {
            return f13000i.get(str);
        }
        if (f13001j.containsKey(str)) {
            return f13001j.get(str);
        }
        return null;
    }

    public static void b(String str) {
        if (f12998g.containsKey(str)) {
            f12998g.remove(str);
        }
        if (f13000i.containsKey(str)) {
            f13000i.remove(str);
        }
        if (f12999h.containsKey(str)) {
            f12999h.remove(str);
        }
        if (f13001j.containsKey(str)) {
            f13001j.remove(str);
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String next : f12998g.keySet()) {
                if (!TextUtils.isEmpty(next) && next.startsWith(str)) {
                    f12998g.remove(next);
                }
            }
        } else {
            f12998g.clear();
        }
        f12999h.clear();
    }

    public static void d(String str) {
        for (Map.Entry next : f12998g.entrySet()) {
            if (((String) next.getKey()).contains(str)) {
                f12998g.remove(next.getKey());
            }
        }
    }

    public static void e(String str) {
        for (Map.Entry next : f12999h.entrySet()) {
            if (((String) next.getKey()).contains(str)) {
                f12999h.remove(next.getKey());
            }
        }
    }

    public static void a(String str, C0114a aVar, boolean z4, boolean z5) {
        if (z4) {
            if (z5) {
                f12999h.put(str, aVar);
            } else {
                f12998g.put(str, aVar);
            }
        } else if (z5) {
            f13001j.put(str, aVar);
        } else {
            f13000i.put(str, aVar);
        }
    }

    public static void b(int i5, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                String requestIdNotice = campaignEx.getRequestIdNotice();
                if (i5 == 288) {
                    requestIdNotice = campaignEx.getKeyIaUrl();
                }
                if (i5 != 94) {
                    if (i5 != 287) {
                        if (i5 != 288) {
                            ConcurrentHashMap<String, C0114a> concurrentHashMap = f12992a;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.remove(requestIdNotice);
                                return;
                            }
                            return;
                        }
                        ConcurrentHashMap<String, C0114a> concurrentHashMap2 = f12995d;
                        if (concurrentHashMap2 != null) {
                            concurrentHashMap2.remove(requestIdNotice);
                        }
                    } else if (campaignEx.isBidCampaign()) {
                        ConcurrentHashMap<String, C0114a> concurrentHashMap3 = f12994c;
                        if (concurrentHashMap3 != null) {
                            concurrentHashMap3.remove(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0114a> concurrentHashMap4 = f12997f;
                        if (concurrentHashMap4 != null) {
                            concurrentHashMap4.remove(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0114a> concurrentHashMap5 = f12993b;
                    if (concurrentHashMap5 != null) {
                        concurrentHashMap5.remove(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0114a> concurrentHashMap6 = f12996e;
                    if (concurrentHashMap6 != null) {
                        concurrentHashMap6.remove(requestIdNotice);
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public static void a() {
        f13000i.clear();
        f13001j.clear();
    }

    public static C0114a a(int i5, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i5 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i5 != 94) {
                if (i5 != 287) {
                    if (i5 != 288) {
                        ConcurrentHashMap<String, C0114a> concurrentHashMap = f12992a;
                        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                            return f12992a.get(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0114a> concurrentHashMap2 = f12995d;
                        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                            return f12995d.get(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0114a> concurrentHashMap3 = f12994c;
                    if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                        return f12994c.get(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0114a> concurrentHashMap4 = f12997f;
                    if (concurrentHashMap4 != null && concurrentHashMap4.size() > 0) {
                        return f12997f.get(requestIdNotice);
                    }
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0114a> concurrentHashMap5 = f12993b;
                if (concurrentHashMap5 != null && concurrentHashMap5.size() > 0) {
                    return f12993b.get(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C0114a> concurrentHashMap6 = f12996e;
                if (concurrentHashMap6 != null && concurrentHashMap6.size() > 0) {
                    return f12996e.get(requestIdNotice);
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    public static void b(int i5, String str, C0114a aVar) {
        if (i5 == 94) {
            if (f12996e == null) {
                f12996e = new ConcurrentHashMap<>();
            }
            f12996e.put(str, aVar);
        } else if (i5 == 287) {
            if (f12997f == null) {
                f12997f = new ConcurrentHashMap<>();
            }
            f12997f.put(str, aVar);
        } else if (i5 != 288) {
            try {
                if (f12992a == null) {
                    f12992a = new ConcurrentHashMap<>();
                }
                f12992a.put(str, aVar);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        } else {
            if (f12995d == null) {
                f12995d = new ConcurrentHashMap<>();
            }
            f12995d.put(str, aVar);
        }
    }

    public static void a(int i5, String str, C0114a aVar) {
        if (i5 == 94) {
            if (f12993b == null) {
                f12993b = new ConcurrentHashMap<>();
            }
            f12993b.put(str, aVar);
        } else if (i5 == 287) {
            try {
                if (f12994c == null) {
                    f12994c = new ConcurrentHashMap<>();
                }
                f12994c.put(str, aVar);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
