package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.util.SparseArray;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.p4  reason: case insensitive filesystem */
final /* synthetic */ class C1397p4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1452x4 f6613a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ List f6614b;

    /* synthetic */ C1397p4(C1452x4 x4Var, List list) {
        this.f6613a = x4Var;
        this.f6614b = list;
    }

    public final /* synthetic */ void run() {
        C1452x4 x4Var = this.f6613a;
        x4Var.h();
        if (Build.VERSION.SDK_INT >= 30) {
            List<S5> list = this.f6614b;
            SparseArray r5 = x4Var.f5730a.x().r();
            for (S5 s5 : list) {
                int i5 = s5.f6083c;
                if (!r5.contains(i5) || ((Long) r5.get(i5)).longValue() < s5.f6082b) {
                    x4Var.w0().add(s5);
                }
            }
            x4Var.x0();
        }
    }
}
