package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class i implements DynamiteModule.b {
    i() {
    }

    public final DynamiteModule.b.C0069b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0069b bVar = new DynamiteModule.b.C0069b();
        bVar.f4915a = aVar.b(context, str);
        int i5 = 1;
        int a5 = aVar.a(context, str, true);
        bVar.f4916b = a5;
        int i6 = bVar.f4915a;
        if (i6 == 0) {
            i6 = 0;
            if (a5 == 0) {
                i5 = 0;
                bVar.f4917c = i5;
                return bVar;
            }
        }
        if (a5 < i6) {
            i5 = -1;
        }
        bVar.f4917c = i5;
        return bVar;
    }
}
