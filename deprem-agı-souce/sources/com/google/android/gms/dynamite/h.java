package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class h implements DynamiteModule.b {
    h() {
    }

    public final DynamiteModule.b.C0069b a(Context context, String str, DynamiteModule.b.a aVar) {
        int i5;
        DynamiteModule.b.C0069b bVar = new DynamiteModule.b.C0069b();
        int b5 = aVar.b(context, str);
        bVar.f4915a = b5;
        int i6 = 1;
        int i7 = 0;
        if (b5 != 0) {
            i5 = aVar.a(context, str, false);
            bVar.f4916b = i5;
        } else {
            i5 = aVar.a(context, str, true);
            bVar.f4916b = i5;
        }
        int i8 = bVar.f4915a;
        if (i8 != 0) {
            i7 = i8;
        } else if (i5 == 0) {
            i6 = 0;
            bVar.f4917c = i6;
            return bVar;
        }
        if (i7 >= i5) {
            i6 = -1;
        }
        bVar.f4917c = i6;
        return bVar;
    }
}
