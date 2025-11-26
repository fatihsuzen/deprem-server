package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.RemoteException;
import android.text.TextUtils;
import f0.C1650e;
import j$.util.Objects;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.h5  reason: case insensitive filesystem */
final class C1339h5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6463a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6464b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6465c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ B6 f6466d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f6467e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6468f;

    C1339h5(C1446w5 w5Var, AtomicReference atomicReference, String str, String str2, String str3, B6 b6, boolean z4) {
        this.f6463a = atomicReference;
        this.f6464b = str2;
        this.f6465c = str3;
        this.f6466d = b6;
        this.f6467e = z4;
        Objects.requireNonNull(w5Var);
        this.f6468f = w5Var;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2 = this.f6463a;
        synchronized (atomicReference2) {
            try {
                C1446w5 w5Var = this.f6468f;
                C1650e N4 = w5Var.N();
                if (N4 == null) {
                    w5Var.f5730a.a().o().d("(legacy) Failed to get user properties; not connected to service", (Object) null, this.f6464b, this.f6465c);
                    atomicReference2.set(Collections.EMPTY_LIST);
                    atomicReference2.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    B6 b6 = this.f6466d;
                    C0722p.k(b6);
                    atomicReference2.set(N4.h0(this.f6464b, this.f6465c, this.f6467e, b6));
                } else {
                    atomicReference2.set(N4.m((String) null, this.f6464b, this.f6465c, this.f6467e));
                }
                w5Var.J();
                atomicReference = this.f6463a;
                atomicReference.notify();
            } catch (RemoteException e5) {
                try {
                    this.f6468f.f5730a.a().o().d("(legacy) Failed to get user properties; remote exception", (Object) null, this.f6464b, e5);
                    this.f6463a.set(Collections.EMPTY_LIST);
                    atomicReference = this.f6463a;
                } catch (Throwable th) {
                    this.f6463a.notify();
                    throw th;
                }
            }
        }
    }
}
