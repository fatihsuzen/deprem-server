package w3;

import b3.C2305b;
import b3.C2312i;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.C2633k;

/* renamed from: w3.p0  reason: case insensitive filesystem */
public abstract class C2891p0 extends I implements Closeable, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26309a = new a((C2633k) null);

    /* renamed from: w3.p0$a */
    public static final class a extends C2305b {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final C2891p0 d(C2312i.b bVar) {
            if (bVar instanceof C2891p0) {
                return (C2891p0) bVar;
            }
            return null;
        }

        private a() {
            super(I.Key, new C2889o0());
        }
    }

    public abstract Executor F();
}
