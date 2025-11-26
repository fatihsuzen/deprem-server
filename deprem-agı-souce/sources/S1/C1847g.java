package s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import l1.C1708c;
import l1.C1709d;
import m1.C1718a;
import n1.h;
import n1.i;
import n1.m;
import p1.C1752a;
import q1.C1757a;
import q1.C1761e;

/* renamed from: s1.g  reason: case insensitive filesystem */
public class C1847g extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16538e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16539f = C1718a.c();

    /* renamed from: s1.g$a */
    class a implements IntSupplier {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f16540a;

        a(i iVar) {
            this.f16540a = iVar;
        }

        public int getAsInt() {
            return ((Integer) this.f16540a.getValue()).intValue();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16539f.a(this.f16538e.c(str), l(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode TcfCaV1PublisherPurposesSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String g(C1757a aVar) {
        return this.f16538e.d(this.f16539f.b(aVar, l()));
    }

    public List l() {
        return C1761e.f15913z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C1757a h() {
        C1757a aVar = new C1757a();
        aVar.c(C1761e.f15904q, new i(3, 3));
        String str = C1761e.f15905r;
        Boolean bool = Boolean.FALSE;
        aVar.c(str, new h(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        aVar.c(C1761e.f15906s, new h(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        i iVar = new i(6, 0);
        aVar.c(C1761e.f15907t, iVar);
        a aVar2 = new a(iVar);
        aVar.c(C1761e.f15908u, new m(aVar2, new ArrayList()));
        aVar.c(C1761e.f15909v, new m(aVar2, new ArrayList()));
        return aVar;
    }
}
