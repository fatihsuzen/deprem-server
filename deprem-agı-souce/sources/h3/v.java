package H3;

import I3.a;
import L3.A0;
import L3.B0;
import L3.C2079b0;
import L3.C2083d0;
import L3.C2086f;
import L3.O;
import L3.O0;
import L3.Q;
import O3.d;
import O3.f;
import W2.C2219h;
import W2.s;
import W2.x;
import X2.C2250q;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.C2616a;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import r3.C2733c;
import r3.C2734d;
import r3.C2743m;

abstract /* synthetic */ class v {
    private static final b b(C2733c cVar, List list, C2616a aVar) {
        if (!t.a(cVar, M.b(Collection.class))) {
            Class<List> cls = List.class;
            if (!t.a(cVar, M.b(cls)) && !t.a(cVar, M.b(cls)) && !t.a(cVar, M.b(ArrayList.class))) {
                if (t.a(cVar, M.b(HashSet.class))) {
                    return new Q((b) list.get(0));
                }
                Class<Set> cls2 = Set.class;
                if (t.a(cVar, M.b(cls2)) || t.a(cVar, M.b(cls2)) || t.a(cVar, M.b(LinkedHashSet.class))) {
                    return new C2083d0((b) list.get(0));
                }
                if (t.a(cVar, M.b(HashMap.class))) {
                    return new O((b) list.get(0), (b) list.get(1));
                }
                Class<Map> cls3 = Map.class;
                if (t.a(cVar, M.b(cls3)) || t.a(cVar, M.b(cls3)) || t.a(cVar, M.b(LinkedHashMap.class))) {
                    return new C2079b0((b) list.get(0), (b) list.get(1));
                }
                if (t.a(cVar, M.b(Map.Entry.class))) {
                    return a.j((b) list.get(0), (b) list.get(1));
                }
                if (t.a(cVar, M.b(s.class))) {
                    return a.m((b) list.get(0), (b) list.get(1));
                }
                if (t.a(cVar, M.b(x.class))) {
                    return a.o((b) list.get(0), (b) list.get(1), (b) list.get(2));
                }
                if (!A0.o(cVar)) {
                    return null;
                }
                Object invoke = aVar.invoke();
                t.c(invoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                return a.a((C2733c) invoke, (b) list.get(0));
            }
        }
        return new C2086f((b) list.get(0));
    }

    private static final b c(C2733c cVar, List list) {
        b[] bVarArr = (b[]) list.toArray(new b[0]);
        return A0.d(cVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }

    private static final b d(b bVar, boolean z4) {
        if (z4) {
            return a.t(bVar);
        }
        t.c(bVar, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return bVar;
    }

    public static final b e(C2733c cVar, List list, C2616a aVar) {
        t.e(cVar, "<this>");
        t.e(list, "serializers");
        t.e(aVar, "elementClassifierIfArray");
        b b5 = b(cVar, list, aVar);
        if (b5 == null) {
            return c(cVar, list);
        }
        return b5;
    }

    public static final b f(d dVar, C2743m mVar) {
        t.e(dVar, "<this>");
        t.e(mVar, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        b h5 = h(dVar, mVar, true);
        if (h5 != null) {
            return h5;
        }
        A0.p(B0.c(mVar));
        throw new C2219h();
    }

    public static final b g(C2743m mVar) {
        t.e(mVar, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        return t.b(f.a(), mVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b1 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final H3.b h(O3.d r6, r3.C2743m r7, boolean r8) {
        /*
            r3.c r0 = L3.B0.c(r7)
            boolean r1 = r7.b()
            java.util.List r7 = r7.d()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = X2.C2250q.p(r7, r3)
            r2.<init>(r3)
            java.util.Iterator r7 = r7.iterator()
        L_0x001d:
            boolean r3 = r7.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x0033
            java.lang.Object r3 = r7.next()
            android.support.v4.media.a.a(r3)
            r3.m r3 = L3.B0.g(r4)
            r2.add(r3)
            goto L_0x001d
        L_0x0033:
            boolean r7 = r2.isEmpty()
            r3 = 2
            if (r7 == 0) goto L_0x004d
            boolean r7 = L3.A0.l(r0)
            if (r7 == 0) goto L_0x0048
            H3.b r7 = O3.d.c(r6, r0, r4, r3, r4)
            if (r7 == 0) goto L_0x0048
        L_0x0046:
            r7 = r4
            goto L_0x0061
        L_0x0048:
            H3.b r7 = H3.s.m(r0, r1)
            goto L_0x0061
        L_0x004d:
            boolean r7 = r6.d()
            if (r7 == 0) goto L_0x0054
            goto L_0x0046
        L_0x0054:
            java.lang.Object r7 = H3.s.n(r0, r2, r1)
            boolean r5 = W2.t.g(r7)
            if (r5 == 0) goto L_0x005f
            r7 = r4
        L_0x005f:
            H3.b r7 = (H3.b) r7
        L_0x0061:
            if (r7 == 0) goto L_0x0064
            return r7
        L_0x0064:
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L_0x0085
            H3.b r7 = H3.t.e(r0)
            if (r7 != 0) goto L_0x00aa
            H3.b r7 = O3.d.c(r6, r0, r4, r3, r4)
            if (r7 != 0) goto L_0x00aa
            boolean r6 = L3.A0.l(r0)
            if (r6 == 0) goto L_0x0083
            H3.g r6 = new H3.g
            r6.<init>(r0)
        L_0x0081:
            r7 = r6
            goto L_0x00aa
        L_0x0083:
            r7 = r4
            goto L_0x00aa
        L_0x0085:
            java.util.List r7 = H3.t.f(r6, r2, r8)
            if (r7 != 0) goto L_0x008c
            return r4
        L_0x008c:
            H3.u r8 = new H3.u
            r8.<init>(r2)
            H3.b r8 = H3.t.a(r0, r7, r8)
            if (r8 != 0) goto L_0x00a9
            H3.b r7 = r6.b(r0, r7)
            if (r7 != 0) goto L_0x00aa
            boolean r6 = L3.A0.l(r0)
            if (r6 == 0) goto L_0x0083
            H3.g r6 = new H3.g
            r6.<init>(r0)
            goto L_0x0081
        L_0x00a9:
            r7 = r8
        L_0x00aa:
            if (r7 == 0) goto L_0x00b1
            H3.b r6 = d(r7, r1)
            return r6
        L_0x00b1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: H3.v.h(O3.d, r3.m, boolean):H3.b");
    }

    /* access modifiers changed from: private */
    public static final C2734d i(List list) {
        return ((C2743m) list.get(0)).e();
    }

    public static final b j(d dVar, C2743m mVar) {
        t.e(dVar, "<this>");
        t.e(mVar, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        return h(dVar, mVar, false);
    }

    public static final b k(C2733c cVar) {
        t.e(cVar, "<this>");
        b b5 = A0.b(cVar);
        if (b5 == null) {
            return O0.b(cVar);
        }
        return b5;
    }

    public static final List l(d dVar, List list, boolean z4) {
        t.e(dVar, "<this>");
        t.e(list, "typeArguments");
        if (z4) {
            Iterable<C2743m> iterable = list;
            ArrayList arrayList = new ArrayList(C2250q.p(iterable, 10));
            for (C2743m b5 : iterable) {
                arrayList.add(t.b(dVar, b5));
            }
            return arrayList;
        }
        Iterable<C2743m> iterable2 = list;
        ArrayList arrayList2 = new ArrayList(C2250q.p(iterable2, 10));
        for (C2743m d5 : iterable2) {
            b d6 = t.d(dVar, d5);
            if (d6 == null) {
                return null;
            }
            arrayList2.add(d6);
        }
        return arrayList2;
    }
}
