package j$.time.chrono;

import j$.time.g;
import j$.time.temporal.a;
import j$.time.temporal.n;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

public final class G extends C0455a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final G f1035c = new G();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap.put("en", new String[]{"BB", "BE"});
        hashMap.put("th", new String[]{"BB", "BE"});
        hashMap2.put("en", new String[]{"B.B.", "B.E."});
        hashMap2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        hashMap3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        hashMap3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    public final m l(int i5) {
        if (i5 == 0) {
            return J.BEFORE_BE;
        }
        if (i5 == 1) {
            return J.BE;
        }
        throw new RuntimeException("Invalid era: " + i5);
    }

    public final String d() {
        return "ThaiBuddhist";
    }

    public final String j() {
        return "buddhist";
    }

    public final C0456b o(n nVar) {
        if (nVar instanceof I) {
            return (I) nVar;
        }
        return new I(g.x(nVar));
    }

    private G() {
    }

    public final u f(a aVar) {
        int i5 = F.f1034a[aVar.ordinal()];
        if (i5 == 1) {
            u uVar = a.PROLEPTIC_MONTH.f1181b;
            return u.e(uVar.f1206a + 6516, uVar.f1209d + 6516);
        } else if (i5 == 2) {
            u uVar2 = a.YEAR.f1181b;
            return u.f((-(uVar2.f1206a + 543)) + 1, uVar2.f1209d + 543);
        } else if (i5 != 3) {
            return aVar.f1181b;
        } else {
            u uVar3 = a.YEAR.f1181b;
            return u.e(uVar3.f1206a + 543, uVar3.f1209d + 543);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
