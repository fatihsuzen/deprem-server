package com.mbridge.msdk.video.dynview;

import android.view.View;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.dynview.h.a;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f12037b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, SoftReference<View>> f12038a = new HashMap();

    private b() {
    }

    public static b a() {
        b bVar;
        if (f12037b != null) {
            return f12037b;
        }
        synchronized (b.class) {
            try {
                if (f12037b == null) {
                    f12037b = new b();
                }
                bVar = f12037b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public final void a(c cVar, h hVar) {
        new a(cVar, hVar, new HashMap());
    }

    public final void a(c cVar, h hVar, Map<String, Object> map) {
        new a(cVar, hVar, map);
    }
}
