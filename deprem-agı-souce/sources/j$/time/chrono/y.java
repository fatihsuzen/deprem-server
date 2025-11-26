package j$.time.chrono;

import j$.com.android.tools.r8.a;
import j$.time.g;
import j$.time.temporal.m;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class y implements m, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final y f1081d;

    /* renamed from: e  reason: collision with root package name */
    public static final y[] f1082e;
    private static final long serialVersionUID = 1466499369062886794L;

    /* renamed from: a  reason: collision with root package name */
    public final transient int f1083a;

    /* renamed from: b  reason: collision with root package name */
    public final transient g f1084b;

    /* renamed from: c  reason: collision with root package name */
    public final transient String f1085c;

    public final /* synthetic */ boolean c(q qVar) {
        return a.o(this, qVar);
    }

    public final /* synthetic */ int e(q qVar) {
        return a.l(this, qVar);
    }

    public final /* synthetic */ Object h(j$.time.format.a aVar) {
        return a.s(this, aVar);
    }

    public final /* synthetic */ long q(q qVar) {
        return a.m(this, qVar);
    }

    static {
        y yVar = new y(-1, g.D(1868, 1, 1), "Meiji");
        f1081d = yVar;
        y yVar2 = new y(0, g.D(1912, 7, 30), "Taisho");
        y yVar3 = new y(1, g.D(1926, 12, 25), "Showa");
        y yVar4 = new y(2, g.D(1989, 1, 8), "Heisei");
        y yVar5 = new y(3, g.D(2019, 5, 1), "Reiwa");
        y[] yVarArr = new y[5];
        f1082e = yVarArr;
        yVarArr[0] = yVar;
        yVarArr[1] = yVar2;
        yVarArr[2] = yVar3;
        yVarArr[3] = yVar4;
        yVarArr[4] = yVar5;
    }

    public final y j() {
        y[] yVarArr = f1082e;
        if (this == yVarArr[yVarArr.length - 1]) {
            return null;
        }
        return l(this.f1083a + 1);
    }

    public y(int i5, g gVar, String str) {
        this.f1083a = i5;
        this.f1084b = gVar;
        this.f1085c = str;
    }

    public static y l(int i5) {
        int i6 = i5 + 1;
        if (i6 >= 0) {
            y[] yVarArr = f1082e;
            if (i6 < yVarArr.length) {
                return yVarArr[i6];
            }
        }
        throw new RuntimeException("Invalid era: " + i5);
    }

    public final m k(m mVar) {
        return mVar.a((long) getValue(), j$.time.temporal.a.ERA);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r5.v(r0) < 0) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r5.r() < r0.r()) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j$.time.chrono.y d(j$.time.g r5) {
        /*
            j$.time.g r0 = j$.time.chrono.x.f1077d
            boolean r1 = j$.time.c.b(r0)
            r2 = 1
            if (r1 == 0) goto L_0x0013
            r5.getClass()
            int r0 = r5.v(r0)
            if (r0 >= 0) goto L_0x0021
            goto L_0x001f
        L_0x0013:
            long r3 = r5.r()
            long r0 = r0.r()
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0021
        L_0x001f:
            r0 = r2
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 != 0) goto L_0x003c
            j$.time.chrono.y[] r0 = f1082e
            int r0 = r0.length
            int r0 = r0 - r2
        L_0x0028:
            if (r0 < 0) goto L_0x003a
            j$.time.chrono.y[] r1 = f1082e
            r1 = r1[r0]
            j$.time.g r2 = r1.f1084b
            int r2 = r5.compareTo(r2)
            if (r2 < 0) goto L_0x0037
            return r1
        L_0x0037:
            int r0 = r0 + -1
            goto L_0x0028
        L_0x003a:
            r5 = 0
            return r5
        L_0x003c:
            j$.time.b r5 = new j$.time.b
            java.lang.String r0 = "JapaneseDate before Meiji 6 are not supported"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.y.d(j$.time.g):j$.time.chrono.y");
    }

    public final int getValue() {
        return this.f1083a;
    }

    public final u g(q qVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        return qVar == aVar ? v.f1075c.f(aVar) : r.d(this, qVar);
    }

    public final String toString() {
        return this.f1085c;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 5, this);
    }
}
