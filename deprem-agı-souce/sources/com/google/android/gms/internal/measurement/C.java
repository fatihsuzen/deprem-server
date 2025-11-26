package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

final class C implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1137k f4928a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ U1 f4929b;

    C(C1137k kVar, U1 u12) {
        this.f4928a = kVar;
        this.f4929b = u12;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        r rVar = (r) obj;
        r rVar2 = (r) obj2;
        if (rVar instanceof C1244w) {
            if (!(rVar2 instanceof C1244w)) {
                return 1;
            }
            return 0;
        } else if (rVar2 instanceof C1244w) {
            return -1;
        } else {
            C1137k kVar = this.f4928a;
            if (kVar == null) {
                return rVar.b().compareTo(rVar2.b());
            }
            return (int) C1238v2.i(kVar.a(this.f4929b, Arrays.asList(new r[]{rVar, rVar2})).C().doubleValue());
        }
    }
}
