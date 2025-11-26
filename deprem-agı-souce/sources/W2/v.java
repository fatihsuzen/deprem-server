package W2;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

final class v implements C2223l, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final a f19969d = new a((C2633k) null);

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f19970e = AtomicReferenceFieldUpdater.newUpdater(v.class, Object.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);

    /* renamed from: a  reason: collision with root package name */
    private volatile C2616a f19971a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f19972b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f19973c;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public v(C2616a aVar) {
        t.e(aVar, "initializer");
        this.f19971a = aVar;
        F f5 = F.f19936a;
        this.f19972b = f5;
        this.f19973c = f5;
    }

    public Object getValue() {
        Object obj = this.f19972b;
        F f5 = F.f19936a;
        if (obj != f5) {
            return obj;
        }
        C2616a aVar = this.f19971a;
        if (aVar != null) {
            Object invoke = aVar.invoke();
            if (androidx.concurrent.futures.a.a(f19970e, this, f5, invoke)) {
                this.f19971a = null;
                return invoke;
            }
        }
        return this.f19972b;
    }

    public boolean isInitialized() {
        if (this.f19972b != F.f19936a) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
