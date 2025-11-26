package e4;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.t;

public final class V {

    /* renamed from: a  reason: collision with root package name */
    public static final V f21520a = new V();

    /* renamed from: b  reason: collision with root package name */
    private static final int f21521b = 65536;

    /* renamed from: c  reason: collision with root package name */
    private static final U f21522c = new U(new byte[0], 0, 0, false, false);

    /* renamed from: d  reason: collision with root package name */
    private static final int f21523d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReference[] f21524e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f21523d = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i5 = 0; i5 < highestOneBit; i5++) {
            atomicReferenceArr[i5] = new AtomicReference();
        }
        f21524e = atomicReferenceArr;
    }

    private V() {
    }

    private final AtomicReference a() {
        return f21524e[(int) (Thread.currentThread().getId() & (((long) f21523d) - 1))];
    }

    public static final void b(U u5) {
        int i5;
        t.e(u5, "segment");
        if (u5.f21518f != null || u5.f21519g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        } else if (!u5.f21516d) {
            AtomicReference a5 = f21520a.a();
            U u6 = f21522c;
            U u7 = (U) a5.getAndSet(u6);
            if (u7 != u6) {
                if (u7 != null) {
                    i5 = u7.f21515c;
                } else {
                    i5 = 0;
                }
                if (i5 >= f21521b) {
                    a5.set(u7);
                    return;
                }
                u5.f21518f = u7;
                u5.f21514b = 0;
                u5.f21515c = i5 + 8192;
                a5.set(u5);
            }
        }
    }

    public static final U c() {
        AtomicReference a5 = f21520a.a();
        U u5 = f21522c;
        U u6 = (U) a5.getAndSet(u5);
        if (u6 == u5) {
            return new U();
        }
        if (u6 == null) {
            a5.set((Object) null);
            return new U();
        }
        a5.set(u6.f21518f);
        u6.f21518f = null;
        u6.f21515c = 0;
        return u6;
    }
}
