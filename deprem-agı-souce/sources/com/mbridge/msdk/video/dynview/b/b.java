package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f12041a;

    private b() {
    }

    public static b a() {
        b bVar;
        if (f12041a != null) {
            return f12041a;
        }
        synchronized (b.class) {
            try {
                if (f12041a == null) {
                    f12041a = new b();
                }
                bVar = f12041a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public final void a(View view, c cVar, Map<String, Object> map) {
        if (cVar != null) {
            int h5 = cVar.h();
            if (h5 == 1) {
                new com.mbridge.msdk.video.dynview.j.b().a(view, map);
            } else if (h5 == 2) {
                new com.mbridge.msdk.video.dynview.j.b().a(view, cVar, map);
            } else if (h5 == 3) {
                new com.mbridge.msdk.video.dynview.j.b().a(view, cVar);
            } else if (h5 == 4) {
                new com.mbridge.msdk.video.dynview.j.b().b(view, cVar, map);
            } else if (h5 == 5) {
                new com.mbridge.msdk.video.dynview.j.b();
            }
        }
    }
}
