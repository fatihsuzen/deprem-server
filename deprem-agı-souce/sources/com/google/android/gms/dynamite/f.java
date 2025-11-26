package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class f implements DynamiteModule.b {
    f() {
    }

    public final DynamiteModule.b.C0069b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0069b bVar = new DynamiteModule.b.C0069b();
        int i5 = 0;
        int a5 = aVar.a(context, str, false);
        bVar.f4916b = a5;
        if (a5 != 0) {
            i5 = 1;
        }
        bVar.f4917c = i5;
        return bVar;
    }
}
