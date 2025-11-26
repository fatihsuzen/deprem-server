package com.google.android.gms.internal.measurement;

final class Q4 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f5150a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5151b;

    Q4(Object obj, int i5) {
        this.f5150a = obj;
        this.f5151b = i5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Q4)) {
            return false;
        }
        Q4 q42 = (Q4) obj;
        if (this.f5150a == q42.f5150a && this.f5151b == q42.f5151b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f5150a) * 65535) + this.f5151b;
    }
}
