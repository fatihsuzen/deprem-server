package t3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2677a;

/* renamed from: t3.i  reason: case insensitive filesystem */
final class C2785i implements Iterator, C2677a {

    /* renamed from: f  reason: collision with root package name */
    private static final a f25934f = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f25935a;

    /* renamed from: b  reason: collision with root package name */
    private int f25936b;

    /* renamed from: c  reason: collision with root package name */
    private int f25937c;

    /* renamed from: d  reason: collision with root package name */
    private int f25938d;

    /* renamed from: e  reason: collision with root package name */
    private int f25939e;

    /* renamed from: t3.i$a */
    private static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public C2785i(CharSequence charSequence) {
        t.e(charSequence, TypedValues.Custom.S_STRING);
        this.f25935a = charSequence;
    }

    /* renamed from: a */
    public String next() {
        if (hasNext()) {
            this.f25936b = 0;
            int i5 = this.f25938d;
            int i6 = this.f25937c;
            this.f25937c = this.f25939e + i5;
            return this.f25935a.subSequence(i6, i5).toString();
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        int i5;
        int i6 = this.f25936b;
        if (i6 == 0) {
            int i7 = 2;
            if (this.f25939e < 0) {
                this.f25936b = 2;
                return false;
            }
            int length = this.f25935a.length();
            int i8 = this.f25937c;
            int length2 = this.f25935a.length();
            while (true) {
                if (i8 >= length2) {
                    i7 = -1;
                    break;
                }
                char charAt = this.f25935a.charAt(i8);
                if (charAt != 10 && charAt != 13) {
                    i8++;
                } else if (!(charAt == 13 && (i5 = i8 + 1) < this.f25935a.length() && this.f25935a.charAt(i5) == 10)) {
                    i7 = 1;
                }
            }
            i7 = 1;
            length = i8;
            this.f25936b = 1;
            this.f25939e = i7;
            this.f25938d = length;
            return true;
        } else if (i6 == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
