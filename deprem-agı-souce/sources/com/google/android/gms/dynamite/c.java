package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class c implements DynamiteModule.b.a {
    c() {
    }

    public final int a(Context context, String str, boolean z4) {
        return DynamiteModule.f(context, str, z4);
    }

    public final int b(Context context, String str) {
        return DynamiteModule.a(context, str);
    }
}
