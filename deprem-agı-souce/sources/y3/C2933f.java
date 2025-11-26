package y3;

import B3.D;
import k3.p;
import k3.q;
import kotlin.jvm.internal.C2639q;
import r3.C2736f;
import w3.C2882l;

/* renamed from: y3.f  reason: case insensitive filesystem */
public abstract class C2933f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final m f26413a = new m(-1, (m) null, (C2932e) null, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final int f26414b = G.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final int f26415c = G.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final D f26416d = new D("BUFFERED");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final D f26417e = new D("SHOULD_BUFFER");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final D f26418f = new D("S_RESUMING_BY_RCV");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final D f26419g = new D("RESUMING_BY_EB");
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final D f26420h = new D("POISONED");
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final D f26421i = new D("DONE_RCV");
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final D f26422j = new D("INTERRUPTED_SEND");
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final D f26423k = new D("INTERRUPTED_RCV");

    /* renamed from: l  reason: collision with root package name */
    private static final D f26424l = new D("CHANNEL_CLOSED");
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final D f26425m = new D("SUSPEND");
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final D f26426n = new D("SUSPEND_NO_WAITER");
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final D f26427o = new D("FAILED");
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final D f26428p = new D("NO_RECEIVE_RESULT");
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final D f26429q = new D("CLOSE_HANDLER_CLOSED");
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static final D f26430r = new D("CLOSE_HANDLER_INVOKED");
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final D f26431s = new D("NO_CLOSE_CAUSE");

    /* renamed from: y3.f$a */
    /* synthetic */ class a extends C2639q implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f26432a = new a();

        a() {
            super(2, C2933f.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final m g(long j5, m mVar) {
            return C2933f.x(j5, mVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return g(((Number) obj).longValue(), (m) obj2);
        }
    }

    /* access modifiers changed from: private */
    public static final long A(int i5) {
        if (i5 == 0) {
            return 0;
        }
        if (i5 != Integer.MAX_VALUE) {
            return (long) i5;
        }
        return Long.MAX_VALUE;
    }

    /* access modifiers changed from: private */
    public static final boolean B(C2882l lVar, Object obj, q qVar) {
        Object q5 = lVar.q(obj, (Object) null, qVar);
        if (q5 == null) {
            return false;
        }
        lVar.E(q5);
        return true;
    }

    static /* synthetic */ boolean C(C2882l lVar, Object obj, q qVar, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            qVar = null;
        }
        return B(lVar, obj, qVar);
    }

    /* access modifiers changed from: private */
    public static final long v(long j5, boolean z4) {
        long j6;
        if (z4) {
            j6 = 4611686018427387904L;
        } else {
            j6 = 0;
        }
        return j6 + j5;
    }

    /* access modifiers changed from: private */
    public static final long w(long j5, int i5) {
        return (((long) i5) << 60) + j5;
    }

    /* access modifiers changed from: private */
    public static final m x(long j5, m mVar) {
        return new m(j5, mVar, mVar.y(), 0);
    }

    public static final C2736f y() {
        return a.f26432a;
    }

    public static final D z() {
        return f26424l;
    }
}
