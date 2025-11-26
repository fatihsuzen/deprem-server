package h3;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import l3.C2677a;
import s3.C2751e;

/* renamed from: h3.h  reason: case insensitive filesystem */
final class C2459h implements C2751e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final BufferedReader f23729a;

    /* renamed from: h3.h$a */
    public static final class a implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private String f23730a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f23731b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2459h f23732c;

        a(C2459h hVar) {
            this.f23732c = hVar;
        }

        /* renamed from: a */
        public String next() {
            if (hasNext()) {
                String str = this.f23730a;
                this.f23730a = null;
                t.b(str);
                return str;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f23730a == null && !this.f23731b) {
                String readLine = this.f23732c.f23729a.readLine();
                this.f23730a = readLine;
                if (readLine == null) {
                    this.f23731b = true;
                }
            }
            if (this.f23730a != null) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C2459h(BufferedReader bufferedReader) {
        t.e(bufferedReader, "reader");
        this.f23729a = bufferedReader;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
