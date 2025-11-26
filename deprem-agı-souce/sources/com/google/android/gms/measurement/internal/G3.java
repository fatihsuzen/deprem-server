package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.J0;

public final class G3 {

    /* renamed from: a  reason: collision with root package name */
    final Context f5891a;

    /* renamed from: b  reason: collision with root package name */
    Boolean f5892b;

    /* renamed from: c  reason: collision with root package name */
    long f5893c;

    /* renamed from: d  reason: collision with root package name */
    J0 f5894d;

    /* renamed from: e  reason: collision with root package name */
    boolean f5895e = true;

    /* renamed from: f  reason: collision with root package name */
    final Long f5896f;

    /* renamed from: g  reason: collision with root package name */
    String f5897g;

    public G3(Context context, J0 j02, Long l5) {
        C0722p.k(context);
        Context applicationContext = context.getApplicationContext();
        C0722p.k(applicationContext);
        this.f5891a = applicationContext;
        this.f5896f = l5;
        if (j02 != null) {
            this.f5894d = j02;
            this.f5895e = j02.f4987c;
            this.f5893c = j02.f4986b;
            this.f5897g = j02.f4989e;
            Bundle bundle = j02.f4988d;
            if (bundle != null) {
                this.f5892b = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
