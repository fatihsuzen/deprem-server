package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.y;
import com.google.gson.reflect.TypeToken;
import com.google.gson.s;
import com.google.gson.t;
import com.google.gson.u;
import j1.C1679a;
import j1.b;
import j1.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ObjectTypeAdapter extends TypeAdapter {

    /* renamed from: c  reason: collision with root package name */
    private static final u f7637c = f(s.DOUBLE);

    /* renamed from: a  reason: collision with root package name */
    private final Gson f7638a;

    /* renamed from: b  reason: collision with root package name */
    private final t f7639b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7641a;

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
                f7641a = r0
                j1.b r1 = j1.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7641a     // Catch:{ NoSuchFieldError -> 0x001d }
                j1.b r1 = j1.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7641a     // Catch:{ NoSuchFieldError -> 0x0028 }
                j1.b r1 = j1.b.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7641a     // Catch:{ NoSuchFieldError -> 0x0033 }
                j1.b r1 = j1.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7641a     // Catch:{ NoSuchFieldError -> 0x003e }
                j1.b r1 = j1.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7641a     // Catch:{ NoSuchFieldError -> 0x0049 }
                j1.b r1 = j1.b.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ObjectTypeAdapter.a.<clinit>():void");
        }
    }

    public static u e(t tVar) {
        if (tVar == s.DOUBLE) {
            return f7637c;
        }
        return f(tVar);
    }

    private static u f(final t tVar) {
        return new u() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                if (typeToken.c() == Object.class) {
                    return new ObjectTypeAdapter(gson, t.this);
                }
                return null;
            }
        };
    }

    private Object g(C1679a aVar, b bVar) {
        int i5 = a.f7641a[bVar.ordinal()];
        if (i5 == 3) {
            return aVar.L();
        }
        if (i5 == 4) {
            return this.f7639b.a(aVar);
        }
        if (i5 == 5) {
            return Boolean.valueOf(aVar.B());
        }
        if (i5 == 6) {
            aVar.J();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    private Object h(C1679a aVar, b bVar) {
        int i5 = a.f7641a[bVar.ordinal()];
        if (i5 == 1) {
            aVar.d();
            return new ArrayList();
        } else if (i5 != 2) {
            return null;
        } else {
            aVar.l();
            return new y();
        }
    }

    public Object b(C1679a aVar) {
        String str;
        boolean z4;
        b N4 = aVar.N();
        Object h5 = h(aVar, N4);
        if (h5 == null) {
            return g(aVar, N4);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.x()) {
                if (h5 instanceof Map) {
                    str = aVar.H();
                } else {
                    str = null;
                }
                b N5 = aVar.N();
                Object h6 = h(aVar, N5);
                if (h6 != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (h6 == null) {
                    h6 = g(aVar, N5);
                }
                if (h5 instanceof List) {
                    ((List) h5).add(h6);
                } else {
                    ((Map) h5).put(str, h6);
                }
                if (z4) {
                    arrayDeque.addLast(h5);
                    h5 = h6;
                }
            } else {
                if (h5 instanceof List) {
                    aVar.p();
                } else {
                    aVar.q();
                }
                if (arrayDeque.isEmpty()) {
                    return h5;
                }
                h5 = arrayDeque.removeLast();
            }
        }
    }

    public void d(c cVar, Object obj) {
        if (obj == null) {
            cVar.z();
            return;
        }
        TypeAdapter l5 = this.f7638a.l(obj.getClass());
        if (l5 instanceof ObjectTypeAdapter) {
            cVar.n();
            cVar.q();
            return;
        }
        l5.d(cVar, obj);
    }

    private ObjectTypeAdapter(Gson gson, t tVar) {
        this.f7638a = gson;
        this.f7639b = tVar;
    }
}
