package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.Iterator;
import java.util.Map;

final class W5 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f5203a = -1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5204b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator f5205c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y5 f5206d;

    /* synthetic */ W5(Y5 y5, byte[] bArr) {
        Objects.requireNonNull(y5);
        this.f5206d = y5;
    }

    private final Iterator a() {
        if (this.f5205c == null) {
            this.f5205c = this.f5206d.l().entrySet().iterator();
        }
        return this.f5205c;
    }

    public final boolean hasNext() {
        int i5 = this.f5203a + 1;
        Y5 y5 = this.f5206d;
        if (i5 < y5.k()) {
            return true;
        }
        if (y5.l().isEmpty() || !a().hasNext()) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.f5204b = true;
        int i5 = this.f5203a + 1;
        this.f5203a = i5;
        Y5 y5 = this.f5206d;
        if (i5 < y5.k()) {
            return (V5) y5.j()[i5];
        }
        return (Map.Entry) a().next();
    }

    public final void remove() {
        if (this.f5204b) {
            this.f5204b = false;
            Y5 y5 = this.f5206d;
            y5.i();
            int i5 = this.f5203a;
            if (i5 < y5.k()) {
                this.f5203a = i5 - 1;
                y5.h(i5);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
