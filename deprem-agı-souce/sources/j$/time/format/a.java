package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.l;
import j$.time.g;
import j$.time.j;
import j$.time.temporal.n;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.util.A;
import j$.util.C0469e;
import j$.util.C0616x;
import j$.util.C0617y;
import j$.util.Objects;
import j$.util.function.Function$CC;
import j$.util.stream.Collectors;
import j$.util.v0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

public final /* synthetic */ class a implements IntFunction, BinaryOperator, Supplier, BiConsumer, Function, DoubleBinaryOperator, ObjDoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1098a;

    public /* synthetic */ a(int i5) {
        this.f1098a = i5;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f1098a) {
            case 12:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
            case 17:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
            case 22:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
            case 23:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
            case 24:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
            default:
                return j$.com.android.tools.r8.a.b(this, biConsumer);
        }
    }

    public Object apply(Object obj) {
        switch (this.f1098a) {
            case 16:
                Set set = Collectors.f1457a;
                return obj;
            default:
                return ((v0) obj).toString();
        }
    }

    public double applyAsDouble(double d5, double d6) {
        return Math.min(d5, d6);
    }

    public /* synthetic */ Function compose(Function function) {
        switch (this.f1098a) {
            case 16:
                return Function$CC.$default$compose(this, function);
            default:
                return Function$CC.$default$compose(this, function);
        }
    }

    public Object apply(Object obj, Object obj2) {
        switch (this.f1098a) {
            case 9:
                Map map = (Map) obj;
                Set set = Collectors.f1457a;
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    Object key = entry.getKey();
                    Object requireNonNull = Objects.requireNonNull(entry.getValue());
                    Object t5 = C0469e.t(map, key, requireNonNull);
                    if (t5 != null) {
                        throw new IllegalStateException(String.format("Duplicate key %s (attempted merging values %s and %s)", new Object[]{key, t5, requireNonNull}));
                    }
                }
                return map;
            case 15:
                List list = (List) obj;
                Set set2 = Collectors.f1457a;
                list.addAll((List) obj2);
                return list;
            default:
                v0 v0Var = (v0) obj;
                v0 v0Var2 = (v0) obj2;
                v0Var.getClass();
                Objects.requireNonNull(v0Var2);
                if (v0Var2.f1855d != null) {
                    v0Var2.b();
                    v0Var.a(v0Var2.f1855d[0]);
                }
                return v0Var;
        }
    }

    public Object a(n nVar) {
        switch (this.f1098a) {
            case 0:
                ZoneId zoneId = (ZoneId) nVar.h(r.f1199a);
                if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                    return null;
                }
                return zoneId;
            case 1:
                return (ZoneId) nVar.h(r.f1199a);
            case 2:
                return (l) nVar.h(r.f1200b);
            case 3:
                return (s) nVar.h(r.f1201c);
            case 4:
                j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
                if (nVar.c(aVar)) {
                    return ZoneOffset.C(nVar.e(aVar));
                }
                return null;
            case 5:
                ZoneId zoneId2 = (ZoneId) nVar.h(r.f1199a);
                return zoneId2 != null ? zoneId2 : (ZoneId) nVar.h(r.f1202d);
            case 6:
                j$.time.temporal.a aVar2 = j$.time.temporal.a.EPOCH_DAY;
                if (nVar.c(aVar2)) {
                    return g.E(nVar.q(aVar2));
                }
                return null;
            default:
                j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_DAY;
                if (nVar.c(aVar3)) {
                    return j.z(nVar.q(aVar3));
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f1098a) {
            case 1:
                return "ZoneId";
            case 2:
                return "Chronology";
            case 3:
                return "Precision";
            case 4:
                return "ZoneOffset";
            case 5:
                return "Zone";
            case 6:
                return "LocalDate";
            case 7:
                return "LocalTime";
            default:
                return super.toString();
        }
    }

    public Object get() {
        switch (this.f1098a) {
            case 10:
                return new C0616x();
            case 11:
                return new ArrayList();
            case 13:
                return new C0617y();
            case 14:
                return new A();
            case 20:
                return new HashMap();
            case 21:
                return new LinkedHashSet();
            default:
                return new double[4];
        }
    }

    public void accept(Object obj, double d5) {
        switch (this.f1098a) {
            case 27:
                double[] dArr = (double[]) obj;
                dArr[2] = dArr[2] + 1.0d;
                Collectors.a(dArr, d5);
                dArr[3] = dArr[3] + d5;
                return;
            default:
                ((C0616x) obj).accept(d5);
                return;
        }
    }

    public void accept(Object obj, Object obj2) {
        switch (this.f1098a) {
            case 12:
                ((List) obj).add(obj2);
                return;
            case 17:
                ((v0) obj).a((CharSequence) obj2);
                return;
            case 22:
                ((LinkedHashSet) obj).add(obj2);
                return;
            case 23:
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                return;
            case 24:
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                Collectors.a(dArr, dArr2[0]);
                Collectors.a(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
                return;
            default:
                double[] dArr3 = (double[]) obj;
                double[] dArr4 = (double[]) obj2;
                Collectors.a(dArr3, dArr4[0]);
                Collectors.a(dArr3, dArr4[1]);
                dArr3[2] = dArr3[2] + dArr4[2];
                dArr3[3] = dArr3[3] + dArr4[3];
                return;
        }
    }

    public Object apply(int i5) {
        return new Object[i5];
    }
}
