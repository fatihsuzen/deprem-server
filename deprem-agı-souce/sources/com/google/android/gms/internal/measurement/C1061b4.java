package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* renamed from: com.google.android.gms.internal.measurement.b4  reason: case insensitive filesystem */
public abstract class C1061b4 {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayMap f5308a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f5309b = 0;

    public static synchronized Uri a(String str) {
        synchronized (C1061b4.class) {
            ArrayMap arrayMap = f5308a;
            Uri uri = (Uri) arrayMap.get("com.google.android.gms.measurement");
            if (uri != null) {
                return uri;
            }
            Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
            arrayMap.put("com.google.android.gms.measurement", parse);
            return parse;
        }
    }
}
