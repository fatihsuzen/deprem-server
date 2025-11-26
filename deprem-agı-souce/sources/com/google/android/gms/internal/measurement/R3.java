package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.SimpleArrayMap;

public final class R3 {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap f5161a;

    R3(SimpleArrayMap simpleArrayMap) {
        this.f5161a = simpleArrayMap;
    }

    public final String a(Uri uri, String str, String str2, String str3) {
        SimpleArrayMap simpleArrayMap;
        if (uri != null) {
            simpleArrayMap = (SimpleArrayMap) this.f5161a.get(uri.toString());
        } else {
            simpleArrayMap = null;
        }
        if (simpleArrayMap == null) {
            return null;
        }
        return (String) simpleArrayMap.get("".concat(str3));
    }
}
