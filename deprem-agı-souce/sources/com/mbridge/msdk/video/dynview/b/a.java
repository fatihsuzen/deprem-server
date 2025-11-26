package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.e.e;
import java.util.ArrayList;
import java.util.Map;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f12039b;

    /* renamed from: a  reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.d.a f12040a;

    private a() {
    }

    public static a a() {
        a aVar;
        if (f12039b != null) {
            return f12039b;
        }
        synchronized (a.class) {
            try {
                if (f12039b == null) {
                    f12039b = new a();
                }
                aVar = f12039b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final void b() {
        com.mbridge.msdk.video.dynview.d.a aVar = this.f12040a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void a(View view, c cVar, Map map, e eVar) {
        int h5 = cVar.h();
        if (h5 == 1) {
            com.mbridge.msdk.video.dynview.j.a aVar = new com.mbridge.msdk.video.dynview.j.a();
            aVar.a(cVar, view, map, eVar);
            this.f12040a = aVar.f12140a;
        } else if (h5 == 2) {
            new com.mbridge.msdk.video.dynview.j.a().b(cVar, view, map, eVar);
        } else if (h5 == 4) {
            new com.mbridge.msdk.video.dynview.j.a().a(cVar, view, eVar);
        } else if (h5 != 5) {
            eVar.a(view, new ArrayList());
        } else {
            new com.mbridge.msdk.video.dynview.j.a().c(cVar, view, map, eVar);
        }
    }
}
