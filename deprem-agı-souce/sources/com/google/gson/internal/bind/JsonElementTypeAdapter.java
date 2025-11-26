package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.f;
import com.google.gson.h;
import com.google.gson.internal.x;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.m;
import j1.C1679a;
import j1.b;
import j1.c;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

class JsonElementTypeAdapter extends TypeAdapter {

    /* renamed from: a  reason: collision with root package name */
    static final JsonElementTypeAdapter f7625a = new JsonElementTypeAdapter();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7626a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                j1.b[] r0 = j1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7626a = r0
                j1.b r1 = j1.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7626a     // Catch:{ NoSuchFieldError -> 0x001d }
                j1.b r1 = j1.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7626a     // Catch:{ NoSuchFieldError -> 0x0028 }
                j1.b r1 = j1.b.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7626a     // Catch:{ NoSuchFieldError -> 0x0033 }
                j1.b r1 = j1.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7626a     // Catch:{ NoSuchFieldError -> 0x003e }
                j1.b r1 = j1.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7626a     // Catch:{ NoSuchFieldError -> 0x0049 }
                j1.b r1 = j1.b.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.JsonElementTypeAdapter.a.<clinit>():void");
        }
    }

    private JsonElementTypeAdapter() {
    }

    private h f(C1679a aVar, b bVar) {
        int i5 = a.f7626a[bVar.ordinal()];
        if (i5 == 3) {
            return new m(aVar.L());
        }
        if (i5 == 4) {
            return new m((Number) new x(aVar.L()));
        }
        if (i5 == 5) {
            return new m(Boolean.valueOf(aVar.B()));
        }
        if (i5 == 6) {
            aVar.J();
            return j.f7809a;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    private h g(C1679a aVar, b bVar) {
        int i5 = a.f7626a[bVar.ordinal()];
        if (i5 == 1) {
            aVar.d();
            return new f();
        } else if (i5 != 2) {
            return null;
        } else {
            aVar.l();
            return new k();
        }
    }

    /* renamed from: e */
    public h b(C1679a aVar) {
        String str;
        boolean z4;
        b N4 = aVar.N();
        h g5 = g(aVar, N4);
        if (g5 == null) {
            return f(aVar, N4);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.x()) {
                if (g5 instanceof k) {
                    str = aVar.H();
                } else {
                    str = null;
                }
                b N5 = aVar.N();
                h g6 = g(aVar, N5);
                if (g6 != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (g6 == null) {
                    g6 = f(aVar, N5);
                }
                if (g5 instanceof f) {
                    ((f) g5).l(g6);
                } else {
                    ((k) g5).l(str, g6);
                }
                if (z4) {
                    arrayDeque.addLast(g5);
                    g5 = g6;
                }
            } else {
                if (g5 instanceof f) {
                    aVar.p();
                } else {
                    aVar.q();
                }
                if (arrayDeque.isEmpty()) {
                    return g5;
                }
                g5 = (h) arrayDeque.removeLast();
            }
        }
    }

    /* renamed from: h */
    public void d(c cVar, h hVar) {
        if (hVar == null || hVar.i()) {
            cVar.z();
        } else if (hVar.k()) {
            m f5 = hVar.f();
            if (f5.u()) {
                cVar.O(f5.q());
            } else if (f5.s()) {
                cVar.Q(f5.o());
            } else {
                cVar.P(f5.r());
            }
        } else if (hVar.g()) {
            cVar.m();
            Iterator it = hVar.c().iterator();
            while (it.hasNext()) {
                d(cVar, (h) it.next());
            }
            cVar.p();
        } else if (hVar.j()) {
            cVar.n();
            for (Map.Entry entry : hVar.d().n()) {
                cVar.x((String) entry.getKey());
                d(cVar, (h) entry.getValue());
            }
            cVar.q();
        } else {
            throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
        }
    }
}
