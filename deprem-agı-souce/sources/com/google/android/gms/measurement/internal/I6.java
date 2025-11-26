package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.B2;
import com.google.android.gms.internal.measurement.C1087e3;
import com.google.android.gms.internal.measurement.C1096f3;
import com.google.android.gms.internal.measurement.C1105g3;
import com.google.android.gms.internal.measurement.C1114h3;
import com.google.android.gms.internal.measurement.C2;
import com.google.android.gms.internal.measurement.L2;
import com.google.android.gms.internal.measurement.M2;
import com.google.android.gms.internal.measurement.O6;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class I6 {

    /* renamed from: a  reason: collision with root package name */
    private String f5923a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5924b;

    /* renamed from: c  reason: collision with root package name */
    private C1096f3 f5925c;

    /* renamed from: d  reason: collision with root package name */
    private BitSet f5926d;

    /* renamed from: e  reason: collision with root package name */
    private BitSet f5927e;

    /* renamed from: f  reason: collision with root package name */
    private Map f5928f;

    /* renamed from: g  reason: collision with root package name */
    private Map f5929g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ C1309e f5930h;

    /* synthetic */ I6(C1309e eVar, String str, C1096f3 f3Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2, byte[] bArr) {
        Objects.requireNonNull(eVar);
        this.f5930h = eVar;
        this.f5923a = str;
        this.f5926d = bitSet;
        this.f5927e = bitSet2;
        this.f5928f = map;
        this.f5929g = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.f5929g.put(num, arrayList);
        }
        this.f5924b = false;
        this.f5925c = f3Var;
    }

    /* access modifiers changed from: package-private */
    public final void a(C1293c cVar) {
        int a5 = cVar.a();
        if (cVar.f6232c != null) {
            this.f5927e.set(a5, true);
        }
        Boolean bool = cVar.f6233d;
        if (bool != null) {
            this.f5926d.set(a5, bool.booleanValue());
        }
        if (cVar.f6234e != null) {
            Map map = this.f5928f;
            Integer valueOf = Integer.valueOf(a5);
            Long l5 = (Long) map.get(valueOf);
            long longValue = cVar.f6234e.longValue() / 1000;
            if (l5 == null || longValue > l5.longValue()) {
                this.f5928f.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (cVar.f6235f != null) {
            Map map2 = this.f5929g;
            Integer valueOf2 = Integer.valueOf(a5);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.f5929g.put(valueOf2, list);
            }
            if (cVar.b()) {
                list.clear();
            }
            O6.a();
            X2 x22 = this.f5930h.f5730a;
            C1371m w4 = x22.w();
            String str = this.f5923a;
            C1296c2 c2Var = C1304d2.f6273G0;
            if (w4.H(str, c2Var) && cVar.c()) {
                list.clear();
            }
            O6.a();
            if (x22.w().H(this.f5923a, c2Var)) {
                Long valueOf3 = Long.valueOf(cVar.f6235f.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(cVar.f6235f.longValue() / 1000));
        }
    }

    /* access modifiers changed from: package-private */
    public final C2 b(int i5) {
        ArrayList arrayList;
        List list;
        B2 M4 = C2.M();
        M4.r(i5);
        M4.w(this.f5924b);
        C1096f3 f3Var = this.f5925c;
        if (f3Var != null) {
            M4.t(f3Var);
        }
        C1087e3 N4 = C1096f3.N();
        N4.t(u6.Q(this.f5926d));
        N4.r(u6.Q(this.f5927e));
        Map map = this.f5928f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.f5928f.keySet()) {
                int intValue = num.intValue();
                Long l5 = (Long) this.f5928f.get(num);
                if (l5 != null) {
                    L2 J4 = M2.J();
                    J4.r(intValue);
                    J4.s(l5.longValue());
                    arrayList2.add((M2) J4.o());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            N4.x(arrayList);
        }
        Map map2 = this.f5929g;
        if (map2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.f5929g.keySet()) {
                C1105g3 K4 = C1114h3.K();
                K4.r(num2.intValue());
                List list2 = (List) this.f5929g.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    K4.s(list2);
                }
                arrayList3.add((C1114h3) K4.o());
            }
            list = arrayList3;
        }
        N4.z(list);
        M4.s(N4);
        return (C2) M4.o();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ BitSet c() {
        return this.f5926d;
    }

    /* synthetic */ I6(C1309e eVar, String str, byte[] bArr) {
        Objects.requireNonNull(eVar);
        this.f5930h = eVar;
        this.f5923a = str;
        this.f5924b = true;
        this.f5926d = new BitSet();
        this.f5927e = new BitSet();
        this.f5928f = new ArrayMap();
        this.f5929g = new ArrayMap();
    }
}
