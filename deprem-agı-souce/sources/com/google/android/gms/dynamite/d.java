package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class d implements DynamiteModule.b {
    d() {
    }

    public final DynamiteModule.b.C0069b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0069b bVar = new DynamiteModule.b.C0069b();
        int a5 = aVar.a(context, str, true);
        bVar.f4916b = a5;
        if (a5 != 0) {
            bVar.f4917c = 1;
            return bVar;
        }
        int b5 = aVar.b(context, str);
        bVar.f4915a = b5;
        if (b5 != 0) {
            bVar.f4917c = -1;
        }
        return bVar;
    }
}
