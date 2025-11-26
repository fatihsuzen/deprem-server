package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.RemoteException;
import android.text.TextUtils;
import f0.C1650e;
import j$.util.Objects;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.f5  reason: case insensitive filesystem */
final class C1323f5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6412a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6413b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6414c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ B6 f6415d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6416e;

    C1323f5(C1446w5 w5Var, AtomicReference atomicReference, String str, String str2, String str3, B6 b6) {
        this.f6412a = atomicReference;
        this.f6413b = str2;
        this.f6414c = str3;
        this.f6415d = b6;
        Objects.requireNonNull(w5Var);
        this.f6416e = w5Var;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2 = this.f6412a;
        synchronized (atomicReference2) {
            try {
                C1446w5 w5Var = this.f6416e;
                C1650e N4 = w5Var.N();
                if (N4 == null) {
                    w5Var.f5730a.a().o().d("(legacy) Failed to get conditional properties; not connected to service", (Object) null, this.f6413b, this.f6414c);
                    atomicReference2.set(Collections.EMPTY_LIST);
                    atomicReference2.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    B6 b6 = this.f6415d;
                    C0722p.k(b6);
                    atomicReference2.set(N4.k0(this.f6413b, this.f6414c, b6));
                } else {
                    atomicReference2.set(N4.y((String) null, this.f6413b, this.f6414c));
                }
                w5Var.J();
                atomicReference = this.f6412a;
                atomicReference.notify();
            } catch (RemoteException e5) {
                try {
                    this.f6416e.f5730a.a().o().d("(legacy) Failed to get conditional properties; remote exception", (Object) null, this.f6413b, e5);
                    this.f6412a.set(Collections.EMPTY_LIST);
                    atomicReference = this.f6412a;
                } catch (Throwable th) {
                    this.f6412a.notify();
                    throw th;
                }
            }
        }
    }
}
