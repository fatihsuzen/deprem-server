package m4;

import android.graphics.Typeface;
import kotlin.jvm.internal.t;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f25314a;

    /* renamed from: b  reason: collision with root package name */
    public final Typeface f25315b;

    public c(Typeface typeface, Typeface typeface2) {
        this.f25314a = typeface;
        this.f25315b = typeface2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (t.a(this.f25314a, cVar.f25314a) && t.a(this.f25315b, cVar.f25315b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        Typeface typeface = this.f25314a;
        int i6 = 0;
        if (typeface == null) {
            i5 = 0;
        } else {
            i5 = typeface.hashCode();
        }
        int i7 = i5 * 31;
        Typeface typeface2 = this.f25315b;
        if (typeface2 != null) {
            i6 = typeface2.hashCode();
        }
        return i7 + i6;
    }

    public final String toString() {
        return "ChoiceFonts(bold=" + this.f25314a + ", regular=" + this.f25315b + ')';
    }
}
