package j$.util.stream;

import j$.util.C0469e;
import j$.util.C0481q;
import j$.util.Collection;
import j$.util.Objects;
import java.util.ArrayList;

public final class I2 extends A2 {

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f1498d;

    public final void c(long j5) {
        if (j5 < 2147483639) {
            this.f1498d = j5 >= 0 ? new ArrayList((int) j5) : new ArrayList();
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void end() {
        C0469e.u(this.f1498d, this.f1435b);
        C0546m2 m2Var = this.f1716a;
        m2Var.c((long) this.f1498d.size());
        if (!this.f1436c) {
            ArrayList arrayList = this.f1498d;
            Objects.requireNonNull(m2Var);
            Collection.EL.a(arrayList, new C0481q(8, m2Var));
        } else {
            ArrayList arrayList2 = this.f1498d;
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList2.get(i5);
                i5++;
                if (m2Var.e()) {
                    break;
                }
                m2Var.accept(obj);
            }
        }
        m2Var.end();
        this.f1498d = null;
    }

    public final void accept(Object obj) {
        this.f1498d.add(obj);
    }
}
