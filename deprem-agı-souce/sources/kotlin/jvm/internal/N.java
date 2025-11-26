package kotlin.jvm.internal;

import r3.C2733c;
import r3.C2735e;
import r3.C2736f;
import r3.C2738h;
import r3.C2740j;
import r3.C2741k;
import r3.C2742l;

public class N {
    public C2733c b(Class cls) {
        return new C2631i(cls);
    }

    public C2735e c(Class cls, String str) {
        return new A(cls, str);
    }

    public String h(C2637o oVar) {
        String obj = oVar.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            return obj.substring(21);
        }
        return obj;
    }

    public String i(u uVar) {
        return h(uVar);
    }

    public C2736f a(C2638p pVar) {
        return pVar;
    }

    public C2738h d(x xVar) {
        return xVar;
    }

    public C2740j e(B b5) {
        return b5;
    }

    public C2741k f(D d5) {
        return d5;
    }

    public C2742l g(F f5) {
        return f5;
    }
}
