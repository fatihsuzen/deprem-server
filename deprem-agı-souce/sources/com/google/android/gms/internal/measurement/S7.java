package com.google.android.gms.internal.measurement;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.List;

public final class S7 extends C1137k {

    /* renamed from: c  reason: collision with root package name */
    private final W7 f5174c;

    public S7(W7 w7) {
        super("internal.registerCallback");
        this.f5174c = w7;
    }

    public final r a(U1 u12, List list) {
        int i5;
        C1238v2.a(this.f5405a, 3, list);
        String b5 = u12.a((r) list.get(0)).b();
        r a5 = u12.a((r) list.get(1));
        if (a5 instanceof C1191q) {
            r a6 = u12.a((r) list.get(2));
            if (a6 instanceof C1173o) {
                C1173o oVar = (C1173o) a6;
                if (oVar.i(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                    String b6 = oVar.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY).b();
                    if (oVar.i("priority")) {
                        i5 = C1238v2.g(oVar.f("priority").C().doubleValue());
                    } else {
                        i5 = 1000;
                    }
                    this.f5174c.a(b5, i5, (C1191q) a5, b6);
                    return r.f5553b0;
                }
                throw new IllegalArgumentException("Undefined rule type");
            }
            throw new IllegalArgumentException("Invalid callback params");
        }
        throw new IllegalArgumentException("Invalid callback type");
    }
}
