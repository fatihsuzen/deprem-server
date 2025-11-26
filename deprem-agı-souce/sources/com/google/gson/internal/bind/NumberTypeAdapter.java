package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.o;
import com.google.gson.reflect.TypeToken;
import com.google.gson.s;
import com.google.gson.t;
import com.google.gson.u;
import j1.C1679a;
import j1.b;
import j1.c;

public final class NumberTypeAdapter extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    private static final u f7633b = f(s.LAZILY_PARSED_NUMBER);

    /* renamed from: a  reason: collision with root package name */
    private final t f7634a;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7636a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                j1.b[] r0 = j1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7636a = r0
                j1.b r1 = j1.b.NULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7636a     // Catch:{ NoSuchFieldError -> 0x001d }
                j1.b r1 = j1.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7636a     // Catch:{ NoSuchFieldError -> 0x0028 }
                j1.b r1 = j1.b.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.NumberTypeAdapter.a.<clinit>():void");
        }
    }

    private NumberTypeAdapter(t tVar) {
        this.f7634a = tVar;
    }

    public static u e(t tVar) {
        if (tVar == s.LAZILY_PARSED_NUMBER) {
            return f7633b;
        }
        return f(tVar);
    }

    private static u f(t tVar) {
        return new u() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                if (typeToken.c() == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    /* renamed from: g */
    public Number b(C1679a aVar) {
        b N4 = aVar.N();
        int i5 = a.f7636a[N4.ordinal()];
        if (i5 == 1) {
            aVar.J();
            return null;
        } else if (i5 == 2 || i5 == 3) {
            return this.f7634a.a(aVar);
        } else {
            throw new o("Expecting number, got: " + N4 + "; at path " + aVar.getPath());
        }
    }

    /* renamed from: h */
    public void d(c cVar, Number number) {
        cVar.O(number);
    }
}
