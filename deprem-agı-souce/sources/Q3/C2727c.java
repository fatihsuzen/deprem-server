package q3;

import X2.J;
import java.util.NoSuchElementException;

/* renamed from: q3.c  reason: case insensitive filesystem */
public final class C2727c extends J {

    /* renamed from: a  reason: collision with root package name */
    private final int f25694a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25695b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25696c;

    /* renamed from: d  reason: collision with root package name */
    private int f25697d;

    public C2727c(int i5, int i6, int i7) {
        this.f25694a = i7;
        this.f25695b = i6;
        boolean z4 = false;
        if (i7 <= 0 ? i5 >= i6 : i5 <= i6) {
            z4 = true;
        }
        this.f25696c = z4;
        this.f25697d = !z4 ? i6 : i5;
    }

    public boolean hasNext() {
        return this.f25696c;
    }

    public int nextInt() {
        int i5 = this.f25697d;
        if (i5 != this.f25695b) {
            this.f25697d = this.f25694a + i5;
            return i5;
        } else if (this.f25696c) {
            this.f25696c = false;
            return i5;
        } else {
            throw new NoSuchElementException();
        }
    }
}
