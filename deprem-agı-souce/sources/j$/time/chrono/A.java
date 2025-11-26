package j$.time.chrono;

import j$.time.g;
import j$.time.temporal.a;
import j$.time.temporal.n;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class A extends C0455a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final A f1028c = new A();
    private static final long serialVersionUID = 1039765215346859963L;

    public final String d() {
        return "Minguo";
    }

    public final m l(int i5) {
        if (i5 == 0) {
            return D.BEFORE_ROC;
        }
        if (i5 == 1) {
            return D.ROC;
        }
        throw new RuntimeException("Invalid era: " + i5);
    }

    public final String j() {
        return "roc";
    }

    public final C0456b o(n nVar) {
        if (nVar instanceof C) {
            return (C) nVar;
        }
        return new C(g.x(nVar));
    }

    public final u f(a aVar) {
        int i5 = z.f1086a[aVar.ordinal()];
        if (i5 == 1) {
            u uVar = a.PROLEPTIC_MONTH.f1181b;
            return u.e(uVar.f1206a - 22932, uVar.f1209d - 22932);
        } else if (i5 == 2) {
            u uVar2 = a.YEAR.f1181b;
            return u.f(uVar2.f1209d - 1911, (-uVar2.f1206a) + 1912);
        } else if (i5 != 3) {
            return aVar.f1181b;
        } else {
            u uVar3 = a.YEAR.f1181b;
            return u.e(uVar3.f1206a - 1911, uVar3.f1209d - 1911);
        }
    }

    private A() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
