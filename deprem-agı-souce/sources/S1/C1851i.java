package s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import l1.C1708c;
import l1.C1710e;
import m1.C1718a;
import n1.h;
import n1.i;
import n1.m;
import p1.C1752a;
import q1.C1757a;
import q1.C1762f;

/* renamed from: s1.i  reason: case insensitive filesystem */
public class C1851i extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16546e = C1710e.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16547f = C1718a.c();

    /* renamed from: s1.i$a */
    class a implements IntSupplier {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f16548a;

        a(i iVar) {
            this.f16548a = iVar;
        }

        public int getAsInt() {
            return ((Integer) this.f16548a.getValue()).intValue();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16547f.a(this.f16546e.c(str), l(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode TcfEuV2PublisherPurposesSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String g(C1757a aVar) {
        return this.f16546e.d(this.f16547f.b(aVar, l()));
    }

    public List l() {
        return C1762f.f15918E;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C1757a h() {
        C1757a aVar = new C1757a();
        aVar.c(C1762f.f15940t, new i(3, 3));
        String str = C1762f.f15941u;
        Boolean bool = Boolean.FALSE;
        aVar.c(str, new h(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        aVar.c(C1762f.f15942v, new h(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        i iVar = new i(6, 0);
        aVar.c(C1762f.f15943w, iVar);
        a aVar2 = new a(iVar);
        aVar.c(C1762f.f15944x, new m(aVar2, new ArrayList()));
        aVar.c(C1762f.f15945y, new m(aVar2, new ArrayList()));
        return aVar;
    }
}
