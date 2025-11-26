package j$.time.chrono;

import j$.time.g;
import j$.time.temporal.a;
import j$.time.temporal.n;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class v extends C0455a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final v f1075c = new v();
    private static final long serialVersionUID = 459996390165777884L;

    public final String d() {
        return "Japanese";
    }

    public final String j() {
        return "japanese";
    }

    public final C0456b o(n nVar) {
        if (nVar instanceof x) {
            return (x) nVar;
        }
        return new x(g.x(nVar));
    }

    private v() {
    }

    public final m l(int i5) {
        return y.l(i5);
    }

    public final u f(a aVar) {
        switch (u.f1074a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new RuntimeException("Unsupported field: " + aVar);
            case 5:
                y[] yVarArr = y.f1082e;
                int i5 = yVarArr[yVarArr.length - 1].f1084b.f1144a;
                int i6 = 1000000000 - yVarArr[yVarArr.length - 1].f1084b.f1144a;
                int i7 = yVarArr[0].f1084b.f1144a;
                int i8 = 1;
                while (true) {
                    y[] yVarArr2 = y.f1082e;
                    if (i8 >= yVarArr2.length) {
                        return u.f((long) i6, (long) (999999999 - i5));
                    }
                    y yVar = yVarArr2[i8];
                    i6 = Math.min(i6, (yVar.f1084b.f1144a - i7) + 1);
                    i7 = yVar.f1084b.f1144a;
                    i8++;
                }
            case 6:
                y yVar2 = y.f1081d;
                long j5 = a.DAY_OF_YEAR.f1181b.f1208c;
                for (y yVar3 : y.f1082e) {
                    j5 = Math.min(j5, (long) (((yVar3.f1084b.B() ? 366 : 365) - yVar3.f1084b.A()) + 1));
                    if (yVar3.j() != null) {
                        j5 = Math.min(j5, (long) (yVar3.j().f1084b.A() - 1));
                    }
                }
                return u.f(j5, a.DAY_OF_YEAR.f1181b.f1209d);
            case 7:
                return u.e((long) x.f1077d.f1144a, 999999999);
            case 8:
                long j6 = (long) y.f1081d.f1083a;
                y[] yVarArr3 = y.f1082e;
                return u.e(j6, (long) yVarArr3[yVarArr3.length - 1].f1083a);
            default:
                return aVar.f1181b;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
