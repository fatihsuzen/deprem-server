package com.mbridge.msdk.video.dynview.i.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.p;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.g.a;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f12123a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View f12124b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f12125c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f12126d;

    private a() {
    }

    public final void b() {
        if (this.f12124b != null) {
            this.f12124b = null;
        }
        Bitmap bitmap = this.f12125c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f12125c.recycle();
            this.f12125c = null;
        }
        Bitmap bitmap2 = this.f12126d;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f12126d.recycle();
            this.f12126d = null;
        }
    }

    public static a a() {
        a aVar;
        if (f12123a != null) {
            return f12123a;
        }
        synchronized (a.class) {
            try {
                if (f12123a == null) {
                    f12123a = new a();
                }
                aVar = f12123a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final void a(Map<String, Bitmap> map, c cVar, View view) {
        if (view != null && cVar != null && map != null && map.size() != 0 && map.size() >= 2 && cVar.g() != null && cVar.g().size() >= 2) {
            this.f12124b = view;
            int e5 = cVar.e();
            float d5 = cVar.d();
            float c5 = cVar.c();
            try {
                List<CampaignEx> g5 = cVar.g();
                String str = "";
                String md5 = g5.get(0) != null ? SameMD5.getMD5(g5.get(0).getImageUrl()) : str;
                if (g5.get(1) != null) {
                    str = SameMD5.getMD5(g5.get(1).getImageUrl());
                }
                Bitmap bitmap = null;
                Bitmap bitmap2 = (TextUtils.isEmpty(md5) || !map.containsKey(md5)) ? null : map.get(md5);
                if (!TextUtils.isEmpty(str) && map.containsKey(str)) {
                    bitmap = map.get(str);
                }
                Bitmap bitmap3 = bitmap;
                if (bitmap2 != null && !bitmap2.isRecycled() && bitmap3 != null && !bitmap3.isRecycled()) {
                    a(e5, d5, c5, bitmap2, bitmap3);
                }
            } catch (Exception e6) {
                af.b("ChoiceOneDrawBitBg", e6.getMessage());
            }
        }
    }

    private synchronized void a(int i5, float f5, float f6, Bitmap bitmap, Bitmap bitmap2) {
        try {
            final int i6 = i5;
            final float f7 = f5;
            final float f8 = f6;
            final Bitmap bitmap3 = bitmap;
            try {
                com.mbridge.msdk.foundation.same.f.a.a().execute(new Runnable() {
                    public final void run() {
                        try {
                            Bitmap a5 = p.a(bitmap3, 10);
                            Bitmap a6 = p.a(bitmap3, 10);
                            final a.C0110a a7 = com.mbridge.msdk.video.dynview.g.a.a();
                            a7.a(i6).a(a5).b(a6);
                            if (i6 == 2) {
                                float f5 = f7;
                                float f6 = f8;
                                if (f5 > f6) {
                                    a7.a(f5).b(f8);
                                } else {
                                    a7.a(f6).b(f7);
                                }
                            } else {
                                a7.a(f7).b(f8);
                            }
                            if (a.this.f12124b != null) {
                                a.this.f12124b.post(new Runnable() {
                                    public final void run() {
                                        if (a.this.f12124b != null && a7.a() != null) {
                                            a.this.f12124b.setBackground(a7.a());
                                        }
                                    }
                                });
                            }
                        } catch (Exception e5) {
                            af.b("ChoiceOneDrawBitBg", e5.getMessage());
                        }
                    }
                });
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Exception e6) {
            e = e6;
            try {
                af.a("ChoiceOneDrawBitBg", e.getMessage());
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }
}
