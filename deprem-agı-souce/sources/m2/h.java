package M2;

import J2.u;
import P3.d;
import X2.C2250q;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import m4.f;
import o4.k;
import o4.o;
import v4.i;

public final class h extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final u f18649a;

    /* renamed from: b  reason: collision with root package name */
    public final o f18650b;

    /* renamed from: c  reason: collision with root package name */
    public final k f18651c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f18652d = new ArrayList();

    public h(u uVar, o oVar, k kVar) {
        t.e(uVar, "tcModel");
        t.e(oVar, "disclosureRepository");
        t.e(kVar, "translationsTextRepository");
        this.f18649a = uVar;
        this.f18650b = oVar;
        this.f18651c = kVar;
    }

    public final void a(f fVar) {
        Map map;
        P3.h hVar;
        f fVar2 = fVar;
        t.e(fVar2, "cookieDisclosure");
        this.f18652d.clear();
        for (m4.h hVar2 : fVar2.f25338a) {
            ArrayList arrayList = this.f18652d;
            String str = hVar2.f25390a;
            String str2 = hVar2.f25391b;
            String valueOf = String.valueOf(hVar2.f25392c);
            String str3 = hVar2.f25393d;
            List list = hVar2.f25394e;
            String str4 = "";
            int i5 = 0;
            for (Object next : list) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    C2250q.o();
                }
                int intValue = ((Number) next).intValue();
                d dVar = this.f18649a.f18314a;
                if (dVar != null && (map = dVar.f18872d) != null && (hVar = (P3.h) map.get(String.valueOf(intValue))) != null) {
                    Q q5 = Q.f24695a;
                    String format = String.format("• %s.", Arrays.copyOf(new Object[]{hVar.f18882b}, 1));
                    t.d(format, "format(format, *args)");
                    str4 = t.n(str4, format);
                    if (i5 != list.size() - 1) {
                        str4 = t.n(str4, "\n");
                    }
                }
                i5 = i6;
            }
            arrayList.add(new i(str, str2, valueOf, str3, str4));
        }
    }
}
