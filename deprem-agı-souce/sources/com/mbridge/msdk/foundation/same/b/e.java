package com.mbridge.msdk.foundation.same.b;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f9246a;

    /* renamed from: b  reason: collision with root package name */
    private final b f9247b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<a> f9248c = new ArrayList<>();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public File f9249a;

        /* renamed from: b  reason: collision with root package name */
        public c f9250b;

        public a(c cVar, File file) {
            this.f9250b = cVar;
            this.f9249a = file;
        }
    }

    private e(b bVar) {
        this.f9247b = bVar;
    }

    public static String a(c cVar) {
        File b5 = b(cVar);
        if (b5 != null) {
            return b5.getAbsolutePath();
        }
        return null;
    }

    public static File b(c cVar) {
        try {
            if (a() == null || a().f9248c == null || a().f9248c.isEmpty()) {
                return null;
            }
            ArrayList<a> arrayList = a().f9248c;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                a aVar = arrayList.get(i5);
                i5++;
                a aVar2 = aVar;
                if (aVar2.f9250b.equals(cVar)) {
                    return aVar2.f9249a;
                }
            }
            return null;
        } catch (Throwable th) {
            af.b("MBridgeDirManager", th.getMessage(), th);
            return null;
        }
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f9246a == null && c.m().c() != null) {
                    ai.a(c.m().c());
                }
                eVar = f9246a;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return eVar;
    }

    public static synchronized void a(b bVar) {
        synchronized (e.class) {
            if (f9246a == null) {
                f9246a = new e(bVar);
            }
        }
    }

    public final boolean b() {
        return a(this.f9247b.b());
    }

    private boolean a(a aVar) {
        String str;
        a c5 = aVar.c();
        if (c5 == null) {
            str = aVar.b();
        } else {
            File b5 = b(c5.d());
            if (b5 == null) {
                return false;
            }
            str = b5.getAbsolutePath() + File.separator + aVar.b();
        }
        File file = new File(str);
        if (!(!file.exists() ? file.mkdirs() : true)) {
            return false;
        }
        this.f9248c.add(new a(aVar.d(), file));
        List<a> a5 = aVar.a();
        if (a5 != null) {
            for (a a6 : a5) {
                if (!a(a6)) {
                    return false;
                }
            }
        }
        return true;
    }
}
