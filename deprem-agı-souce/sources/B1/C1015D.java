package b1;

import W2.C2223l;
import W2.m;
import W2.s;
import W2.y;
import X2.M;
import android.content.Context;
import android.os.Process;
import b1.C1040z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;

/* renamed from: b1.D  reason: case insensitive filesystem */
public final class C1015D implements C1040z {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4519a;

    /* renamed from: b  reason: collision with root package name */
    private final C2223l f4520b = m.b(new C1012A(this));

    /* renamed from: c  reason: collision with root package name */
    private final int f4521c = Process.myPid();

    /* renamed from: d  reason: collision with root package name */
    private final C2223l f4522d;

    /* renamed from: e  reason: collision with root package name */
    private final C2223l f4523e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4524f;

    public C1015D(Context context, c0 c0Var) {
        t.e(context, "appContext");
        t.e(c0Var, "uuidGenerator");
        this.f4519a = context;
        this.f4522d = m.b(new C1013B(c0Var));
        this.f4523e = m.b(new C1014C(this));
    }

    private final List j() {
        return G.f4531a.a(this.f4519a);
    }

    private final F l() {
        return (F) this.f4523e.getValue();
    }

    private final boolean n(F f5, C1039y yVar) {
        if (t.a(c(), f5.c())) {
            if (f5.b() != yVar.a() || !t.a(m(), yVar.b())) {
                return true;
            }
            return false;
        } else if (f5.b() != yVar.a()) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static final F o(C1015D d5) {
        return G.f4531a.b(d5.f4519a);
    }

    /* access modifiers changed from: private */
    public static final String p(C1015D d5) {
        return d5.l().c();
    }

    /* access modifiers changed from: private */
    public static final String q(c0 c0Var) {
        String uuid = c0Var.next().toString();
        t.d(uuid, "toString(...)");
        return uuid;
    }

    public void a() {
        this.f4524f = true;
    }

    public boolean b(Map map) {
        s sVar;
        t.e(map, "processDataMap");
        if (this.f4524f) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (F f5 : j()) {
            C1039y yVar = (C1039y) map.get(f5.c());
            if (yVar != null) {
                sVar = new s(f5, yVar);
            } else {
                sVar = null;
            }
            if (sVar != null) {
                arrayList.add(sVar);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            s sVar2 = (s) obj;
            if (!n((F) sVar2.a(), (C1039y) sVar2.b())) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        return (String) this.f4520b.getValue();
    }

    public boolean d(Map map) {
        t.e(map, "processDataMap");
        C1039y yVar = (C1039y) map.get(c());
        if (yVar != null && yVar.a() == k() && t.a(yVar.b(), m())) {
            return false;
        }
        return true;
    }

    public Map e() {
        return C1040z.a.a(this);
    }

    public Map f(Map map) {
        Map v5;
        if (!(map == null || (v5 = M.v(map)) == null)) {
            v5.put(c(), new C1039y(Process.myPid(), m()));
            Map t5 = M.t(v5);
            if (t5 != null) {
                return t5;
            }
        }
        return M.f(y.a(c(), new C1039y(Process.myPid(), m())));
    }

    public int k() {
        return this.f4521c;
    }

    public String m() {
        return (String) this.f4522d.getValue();
    }
}
